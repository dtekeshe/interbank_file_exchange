package com.bsva.dmcs.fileloadv02.indexer;

import com.bsva.dao.CsfCardTypesDao;
import com.bsva.dao.CsfTransactionTypesDao;
import com.bsva.dao.v02.ProgramControlsDAO;
import com.bsva.dcms.commons.util.Utils;
import com.bsva.dmcs.fileloadv02.billing.BillingCalculator;
import com.bsva.dmcs.fileloadv02.billing.MastercardPDSConstructor;
import com.bsva.dmcs.fileloadv02.billing.VISATCR5Constructor;
import com.bsva.dmcs.fileloadv02.dto.*;
import com.bsva.dmcs.fileloadv02.indexer.util.NegativeRecordsWriter;
import com.bsva.dmcs.fileloadv02.io.VISAFileHeaderParser;
import com.bsva.dmcs.fileloadv02.model.BillingData;
import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.dmcs.fileloadv02.model.MemberInfoBean;
import com.bsva.dmcs.fileloadv02.model.VISAFileHeader;
import com.bsva.dmcs.fileloadv02.parsers.TxnRecordParser;
import com.bsva.dmcs.fileloadv02.parsers.FileHeaderParser;
import com.bsva.dmcs.fileloadv02.util.*;
import com.bsva.dmcs.fileloadv02.util.Timer;
import com.bsva.dmcs.fileloadv02.validators.TxnCodeSequenceValidator;
import com.bsva.dmcs.reportv02.loader.CR003VetFileWriter;
import com.bsva.dmcs.reportv02.loader.CR023VetFileWriter;
import com.bsva.dmcs.reportv02.loader.CRVetFileWriter;
import com.bsva.dmcs.reportv02.loader.VetFileWriter;
import com.bsva.dto.Environment;
import com.bsva.dto.ErrorDTO;
import com.bsva.dto.FileHeaderDTO;
import com.bsva.dto.FileStats;
import com.bsva.entities.CsfCardTypes;
import com.bsva.entities.CsfTransactionTypes;
import com.bsva.entities.v02.params.CompanyParametersEntity;

import org.apache.log4j.Logger;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import static com.bsva.dmcs.fileloadv02.util.FileIndexerUtils.*;

/**
 * Knows the structure of a VISA file
 * Reads each line and calls appropriate line parser
 * Validate, billing, assign output filename & index a set of transactions
 */

/**
 * @author AugustineA
 *
 */
@SuppressWarnings("unused")
public class GenericFileIndexer extends AbstractFileIndexer implements FileIndexer {

    // Metadata
    private final String processName;
    private final static String VERSION = "20";
    private final static String TCR_RECORD_3 = "0503";

    private Logger log = Logger.getLogger(GenericFileIndexer.class);

    private final static String FILE_PATH_SEPARATOR = System.getProperty("file.separator");
    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

    private final FileHeaderParser fileHeaderParser;
    private final TxnRecordParser txnRecordParser;

    private final String companyName;
    private final String registrationNumber;
    private final Service service;
    private final SubService subService;

    private final BillingCalculator billingCalculator;
    private final VetFileWriter csr003VetFileWriter;
    private final VetFileWriter csr023VetFileWriter;
    
    private final CRVetFileWriter cr003VetFileWriter;
    private final CRVetFileWriter cr0023VetFileWriter;
    
    private final VetFileWriter csr021VetFileWriter;
    private final TxnCodeSequenceValidator txnCodeSequenceValidator;
    private final ProgramControlsDAO programControlsDAO;

    private final MemberInfoBean memberInfoBean;
//    private final TxnCodeSequenceValidator txnCodeSequenceValidator;
//    private final VISATCRStringParser tcrStringParser;
    private TxnRecordWriter txnRecordWriter;
    private NegativeRecordsWriter negativeRecordsWriter;
    private final String receiveFolder;
    private final String indexFolder;
    private final String reportFolder;
    private final String exportFolder;
    private final String sendFolder;
    private final Map<Integer, Integer> memberCodes;
    private final Map<String, Integer> memberTapeIds;
    private Map<String,Integer> fileSeqnumberCount  = new HashMap<>();
//    private final CSR021VetFileWriter csr021VetReportWriter;
    private final String inboundFilenamePrefix;
    private final NegativeRecordParser negativeRecordParser;

    @SuppressWarnings("unused")
    public GenericFileIndexer(
            Map<Integer, Integer> memberCodes,
            Map<String, Integer> memberTapeIds,
            BillingCalculator billingCalculator,
            TxnRecordParser txnRecordParser,
            VetFileWriter csr003VetFileWriter,
            VetFileWriter csr023VetFileWriter,
            VetFileWriter csr021VetFileWriter,
            CRVetFileWriter cr003VetFileWriter,
            CRVetFileWriter cr0023VetFileWriter,
            Environment environment,
            Date processDate,
            Boolean isPublicHoliday,
            String receiveFolder,
            String indexFolder,
            String reportFolder,
            String exportFolder,
            String sendFolder,
            Service service,
            SubService subService,
            CompanyParametersEntity companyParameters,
            ProgramControlsDAO programControlsDAO,
            String filenamePrefix,
            String inboundFilenamePrefix)
        throws SystemConfigurationException {

        super();

        this.companyName = companyParameters.getCompanyName();
        this.registrationNumber = companyParameters.getRegistrationNumber();
        this.service = service;
        this.subService = subService;
        this.billingCalculator = billingCalculator;
        this.txnRecordParser = txnRecordParser;
        this.csr003VetFileWriter = csr003VetFileWriter;
        this.csr023VetFileWriter = csr023VetFileWriter;
        this.csr021VetFileWriter = csr021VetFileWriter;
        this.cr003VetFileWriter = cr003VetFileWriter;
        this.cr0023VetFileWriter = cr0023VetFileWriter;
        this.memberCodes = memberCodes;
        this.memberTapeIds = memberTapeIds;
        this.programControlsDAO = programControlsDAO;

        List<CsfCardTypes> cardTypes = new CsfCardTypesDao().findAll();
        List<CsfTransactionTypes> txnTypes = new CsfTransactionTypesDao().findAll();
        memberInfoBean = new MemberInfoBean();

        fileHeaderParser = new VISAFileHeaderParser(
                            processDate,
                            isPublicHoliday,
                            service.name(),
                            subService.getDescription(),
                            memberCodes.keySet(),
                            companyParameters.getValidationCode(),
                            environment);

        txnCodeSequenceValidator = new TxnCodeSequenceValidator();

        txnRecordWriter = new TxnRecordWriter(service, subService, filenamePrefix);
        negativeRecordsWriter = new NegativeRecordsWriter();

        this.receiveFolder = receiveFolder;
        this.indexFolder = indexFolder;
        this.reportFolder = reportFolder;
        this.exportFolder = exportFolder;
        this.sendFolder = sendFolder;
        this.inboundFilenamePrefix = inboundFilenamePrefix;

        processName = inboundFilenamePrefix + "LOADER";
        negativeRecordParser = new NegativeRecordParser(memberInfoBean);
    }

    public void index(String filename, FileHeaderDTO header,FileFooterDto footer, List<ErrorDTO> errors, boolean isReload)
                    throws IOException, FileRejectedException, SystemConfigurationException {

        Timer.start();

        // reset counters
        resetCounters();

        // read sequences
        readSequences();

        BufferedReader in = null;
        PrintWriter out = null;
        PrintWriter pdsOut = null;
        ExportRecordWriter exportRecordWriter = null;

        VISAFileHeader fileHeader = null;

        String indexpath = null;
        String negRecsIndexPath = null;
        String pdsIndexPath = null;
        String csr021XmlPath = null;
        String csr023XmlPath = null;

        FileStats fileStats = new FileStats();

        try {
            String filepath = receiveFolder + FILE_PATH_SEPARATOR + filename;
            String sendFolderFilePath = sendFolder + FILE_PATH_SEPARATOR;
            indexpath = indexFolder + FILE_PATH_SEPARATOR + filename + ".idx";
            negRecsIndexPath = indexFolder + FILE_PATH_SEPARATOR + filename + ".negative" + ".idx";
            if ("MASTERCARD".equals(subService.getDescription())) {
                pdsIndexPath = indexFolder + FILE_PATH_SEPARATOR + filename + ".pds" + ".idx";
                pdsOut = new PrintWriter(new File(pdsIndexPath));
            }

            in = new BufferedReader(new FileReader(filepath));
            out = new PrintWriter(new File(indexpath));

            String lastRec = null ;
            String line  = null;
            Long counter = 0L;
            Long count99Rec = 0L;
            boolean isHeaderValid = false;

            exportRecordWriter = new ExportRecordWriter(exportFolder);

            List<FileDetailDTO> payLines = new ArrayList<>();
            Set<NegativeRecordDTO> negativeRecords = new TreeSet<>();
            spolog("INDEXING FILE: " + filename);
            Counter.negativeDuplicateCount = 0L;
            Counter.negativeCardCount = 0L;
            
            while ((line = in.readLine()) != null) {
            	lastRec = line.substring(0, 2);
                // replace non printable characters with a space.
                line = line.replaceAll("\\p{C}\\p{C}", " ");
                //line = line.replaceAll("\\xef|\\xbb|\\xbf", "");
                line = line.replace("\uFEFF", "");
                if (line.startsWith("41")) {

                    NegativeRecordDTO negativeRecord
                            = negativeRecordParser.parse(fileSeqNumber.intValue(), line);

                    if (negativeRecords.contains(negativeRecord)) {
                        ++Counter.negativeDuplicateCount;
                    } else {
                        ++Counter.negativeCardCount;
                        negativeRecords.add(negativeRecord);
                        fileStats.addAcceptedNegativeCardRecCount(1L);
                    }
                    continue;
                }

                ++counter;

                TCRType tcrType = tcrType(subService.getDescription(), line);

                switch (tcrType) {

                    case HEADER:
                        // parse line
                        fileHeaderParser.parse(header,filename, line, errors, programControlsDAO, isReload);
                        header.setFileSeqNumber(fileSeqNumber.incrementAndGet());

                        // check header status
                        if ("R".equals(header.getStatus()) ) {
                            fileStats.addRejectedControlRecCount(1L);
                            throw new FileRejectedException("INVALID FILE HEADER");
                        }

                        // log start of program
                        programControlsDAO.logStartOfProgram("LOADER", subService.getDescription(), filename);

                        // update file stats
                        fileStats.addAcceptedControlRecCount(1L);

                        break;
                    case SECONDARY_HEADER:
                        // update file stats
                        fileStats.addAcceptedControlRecCount(1L);
                        break;
                    case FINANCIAL:

                        if (hasPrevious(payLines)) {
                            // validate TCR sequence
                            txnCodeSequenceValidator.validate(payLines, errors, (counter - 1),subService);
                            // apply billing
                            billingCalculator.bill(payLines);

                            if ("MASTERCARD".equals(subService.getDescription())) {
                                // if Mastercard, add PDS 146 to input string

                                FileDetailDTO tcr0 = payLines.get(0);
                                if ("C".equals(tcr0.getStatus())) {

                                    BillingData billingData = tcr0.getBillingData();
                                    Long amount = tcr0.getAmount();
                                    
                                    // pds list
                                    List<MastercardPDSDTO> pdsList
                                            = tcr0.getPdsList();

                                    // construct PDS 146
                                    MastercardPDSDTO pds146
                                            = MastercardPDSConstructor
                                                .pds146(tcr0.getTxnSeqNumber().longValue(),
                                                        Boolean.TRUE,
                                                        billingData.getTransactionFee());
                                    pdsList.add(pds146);

                                    // reconstruct PDS payload in order to insert PDS 146
                                    MastercardPDSConstructor.combine(tcr0, pdsList);

                                    // write PDS to file
                                    txnRecordWriter.writePDS(pdsOut, pdsList);
                                }
                            }  else if ("VISA CARD".equals(subService.getDescription())) {
                                if (payLines.get(0) != null && "C".equals(payLines.get(0).getStatus())) {
                                    VISATCR5Constructor.addTCR5Record(payLines);
                                }
                            } else if ("FLEET CARD".equals(subService.getDescription())) {
                                // if fleet, build date and time stamp
                                // for Fleet Card, get timestamp
                            	List<FileDetailDTO> listData = payLines;
                            	for(FileDetailDTO tcrLines : payLines){
                            	if(listData.size() >= 3 && payLines.get(0).getMonthDay()!= null){
                                //FileDetailDTO tcr0 = payLines.get(0);
                                FileDetailDTO tcr0 = tcrLines;
                                if ("C".equals(tcr0.getStatus())) {
                                    Date dateTime = getDateTime(payLines);
                                    if (dateTime == null) {
                                        // TODO flag all payment lines as errror
                                        //throw new FileRejectedException("NULL VALUE FOR DATETIME ON FLEET TRANSACTION");
                                    } else {
                                        tcr0.setDateTime(dateTime);
                                    }
                                 }                                
                                if(tcrLines.getInput().substring(0,4).equals(TCR_RECORD_3)){
                                	String product = tcrLines.getInput().substring(26, 27);
                                		if(product == null){
                                		
	                                	}else{
	                                		tcr0.setProduct(product);
	                                	}
                                	String subProduct =  tcrLines.getInput().substring(27, 29);
	                            		if(product == null){
	                            		
	                            		}else{
	                            			tcr0.setSubProduct(subProduct);
	                            		}
                                	}
                            	}
                              }
                            }	

                            // write to index file
                            txnRecordWriter.write(out, header, payLines);
                            // write to export file
                            exportRecordWriter.write(payLines);
                            
                            // update counters
                            updateCounters(payLines, fileStats);
                            // reset
                            payLines = new ArrayList<>();
                        }

                        // parse financial record and validate
                        FileDetailDTO payment
                                = txnRecordParser.parse(fileSeqNumber, new AtomicLong(txnSeqNumber.incrementAndGet()),
                                                        line, counter, memberInfoBean, subService, errors );
                        payLines.add(payment);

                        break;

                    case NON_FINANCIAL:
                    	Boolean result = false;
                        // add to transaction set
                    	if(!subService.equals("MASTERCARD")){
                    	 result = 	txnCodeSequenceValidator.validateNonFinancialRecord(payLines, errors, (counter - 1),subService);
                    		
                    	}
                    	if(result == true){
                    		payment = txnRecordParser.parse(fileSeqNumber, txnSeqNumber,
                                                            line, counter, memberInfoBean, subService, errors );
                    		payLines.add(payment);
                    	}

                        break;

                    case TRAILER:

                    	if(line.startsWith("99")){
                    		++count99Rec;
                    		//Validate Trailer records
                        	fileHeaderParser.parseFooter(footer,filename, line, errors, programControlsDAO, isReload,counter,count99Rec);
                    	}
                        if (hasPrevious(payLines)) {
                            // validate TCR sequence
                            txnCodeSequenceValidator.validate(payLines, errors, (counter - 1),subService);
                            // apply billing
                            billingCalculator.bill(payLines);

                             if ("MASTERCARD".equals(subService.getDescription())) {

                                // if Mastercard, add PDS 146 to input string

                                FileDetailDTO tcr0 = payLines.get(0);
                                if ("C".equals(tcr0.getStatus())) {

                                    BillingData billingData = tcr0.getBillingData();
                                    Long amount = tcr0.getAmount();

                                    // pds list
                                    List<MastercardPDSDTO> pdsList
                                            = tcr0.getPdsList();

                                    // construct PDS 146
                                    MastercardPDSDTO pds146
                                            = MastercardPDSConstructor
                                            .pds146(tcr0.getTxnSeqNumber().longValue(),
                                                    Boolean.TRUE,
                                                    billingData.getTransactionFee());

                                    // reconstruct PDS payload in order to insert PDS 146
                                    MastercardPDSConstructor.combine(tcr0, pdsList);

                                    // write PDS to file
                                    txnRecordWriter.writePDS(pdsOut, pdsList);
                                }
                            }  else if ("VISA CARD".equals(subService.getDescription())) {
                                if (payLines.get(0) != null && "C".equals(payLines.get(0).getStatus())) {
                                    VISATCR5Constructor.addTCR5Record(payLines);
                                }
                            } else if ("FLEET CARD".equals(subService.getDescription())) {

                                // if fleet, build date time stamp
                                // for Fleet Card, get timestamp
                                FileDetailDTO tcr0 = payLines.get(0);
                                if ("C".equals(tcr0.getStatus())) {
                                    Date dateTime = getDateTime(payLines);
                                    if (dateTime == null) {
                                        // TODO flag all payment lines as errror
                                    	throw new FileRejectedException("NULL VALUE FOR DATETIME ON FLEET TRANSACTION");
                                    } else {
                                        tcr0.setDateTime(dateTime);
                                    }
                                }
                            }
                            // write to index file
                            txnRecordWriter.write(out, header, payLines);
                            // write to export file
                            /*boolean isFilename = fileSeqnumberCount.containsKey(payLines.get(0).getOutputFilename());
                            if(isFilename){
                            	Integer fileDetails = fileSeqnumberCount.get(payLines.get(0).getOutputFilename());
                            	String values = payLines.get(0).getOutputFilename();
                            	String inputLine = payLines.get(0).getInput().replace("-", "0").replace(".", "0");
                            	String changedLine = String.format("%5s", fileDetails+1).replace(' ', '0');
                            	String lineChanged = StringUtils.replace(inputLine, changedLine,2,8);
                            	payLines.get(0).setInput(lineChanged);
                            	exportRecordWriter.write(payLines);
                            	fileSeqnumberCount.put(payLines.get(0).getOutputFilename(),fileDetails+1);
                            }else{
                            	if(payLines.get(0).getOutputFilename() != null){
                            		fileSeqnumberCount.put(payLines.get(0).getOutputFilename(), 1);
                            	}
                            }*/
                            // update counters
                            updateCounters(payLines, fileStats);
                            // reset
                            payLines = new ArrayList<>();
                        }
                        fileStats.addAcceptedControlRecCount(1L);
                        break;

                    case INVALID_REC:
                        fileStats.addRejectedControlRecCount(1L);
                        break;
                    default:
                        break;
                }

                if ((counter % 50000) == 0) {
                    spolog("INDEXED " + counter + " RECS.");
                }
                //spolog("REMAINING REC AFTER INDEX IS :" + counter + " .");
                //System.out.println("REMAINING REC AFTER INDEX IS :" + counter + " .");
            }
            if(!lastRec.equals("99")){
            	footer.setStatus("R");
            }
            // check header status
            if ("R".equals(footer.getStatus()) ) {
                fileHeaderParser.parseFooter(footer,filename, line, errors, programControlsDAO, isReload,counter,count99Rec);
                fileStats.addRejectedControlRecCount(1L);
                throw new FileRejectedException("INVALID FILE FOOTER");
            }
            String headerString = VISAParserUtils.toString(header, filename);
            out.println(headerString);

            // Generating VET Reports
            Integer memberCode = memberCode(filename, memberTapeIds);
            csr003VetFileWriter.write(memberCode, filename, header, errors, fileStats);
            cr003VetFileWriter.writeData(memberCode, filename, header, errors, fileStats);
            
            header.setSubServiceID(subService.getDescription());
            csr023VetFileWriter.write(memberCode, filename, header, errors, fileStats);
            cr0023VetFileWriter.writeData(memberCode, filename, header, errors, fileStats);

            if ( negativeRecords.size() > 0 ) {
                spolog("WRITING NEGATIVE RECORDS");
                PrintWriter negRecsOut = null;
                
                try {
                    negRecsOut = new PrintWriter(new File(negRecsIndexPath));
                    negativeRecordsWriter.write(negRecsOut, fileSeqNumber.longValue(), negativeRecords);
                } finally {
                    try {negRecsOut.flush();}catch (Exception e){}
                    try {negRecsOut.close();}catch (Exception e){}
                }
            }

            // closing exported files
            exportRecordWriter.flushAndClose();

            spolog("INDEXING OF FILE: " + filename + " COMPLETED.");
        }  catch ( FileRejectedException e) {

            // print a CSR021 report
            Integer memberCode = memberCode(filename, memberTapeIds);
            csr021VetFileWriter.write(memberCode, filename, header, errors, fileStats);

            throw new FileRejectedException(e.getMessage());
        }  catch (SystemConfigurationException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        } finally {

            try {in.close();} catch (Exception e) {}
            try {out.flush();} catch (Exception e) {}
            try {out.close();} catch (Exception e) {}
            if ("MASTERCARD".equals(subService.getDescription())) {
                try {pdsOut.flush();} catch (Exception e) {}
                try {pdsOut.close();} catch (Exception e) {}
            }
            updateSequences();

            spolog("INDEXED in " + Timer.end());
        }
    }

    @Override
    public TxnRecordWriter getTxnRecordWriter() {
        return txnRecordWriter;
    }

    private void spolog(String message) {
        System.out.println(processName + " " + VERSION + " " + message);
        // spoLog.log(PROCESS_NAME, VERSION, message);
        Utils.logSpolog(message, processName);
    }

    private boolean hasPrevious(List<FileDetailDTO> payLines) {
        return payLines.size() > 0;
    }
}
