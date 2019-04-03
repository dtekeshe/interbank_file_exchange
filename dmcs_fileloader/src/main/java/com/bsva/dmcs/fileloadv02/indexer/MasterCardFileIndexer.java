/*package com.bsva.dmcs.fileloadv02.indexer;

import com.bsva.dao.CsfCardTypesDao;
import com.bsva.dao.CsfTransactionTypesDao;
import com.bsva.dmcs.fileloadv02.billing.BillingCalculator;
import com.bsva.dmcs.fileloadv02.dto.*;
import com.bsva.dmcs.fileloadv02.model.MemberInfoBean;
import com.bsva.dmcs.fileloadv02.model.TCR;
import com.bsva.dmcs.fileloadv02.model.VISAFileHeader;
import com.bsva.dmcs.fileloadv02.parsers.VISAFileHeaderParser;
import com.bsva.dmcs.fileloadv02.parsers.VISATCRStringParser;
import com.bsva.dmcs.fileloadv02.reports.CSR021ReportWriter;
import com.bsva.dmcs.fileloadv02.util.FileRejectedException;
import com.bsva.dmcs.fileloadv02.util.SPOLOGGER;
import com.bsva.dmcs.fileloadv02.util.Timer;
import com.bsva.dmcs.fileloadv02.validators.TxnCodeSequenceValidator;
import com.bsva.dmcs.fileloadv02.validators.VISAFileHeaderValidator;
import com.bsva.entities.CsfCardTypes;
import com.bsva.entities.CsfTransactionTypes;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.bsva.dmcs.fileloadv02.util.FileIndexerUtils.tcrType;

*//**
 * Knows the structure of a VISA file
 * Reads each line and calls appropriate line parser
 * Validate, billing, assign output filename & index a set of transactions
 *//*
public class MasterCardFileIndexer extends AbstractFileIndexer implements FileIndexer {

    private final static String PATH_SEPARATOR = System.getProperty("path.separator");
    private final String companyName;
    private final String registrationNumber;
    private final SubService subService;
    private final BillingCalculator billingCalculator;
    private final MemberInfoBean memberInfoBean;
//    private final TxnCodeSequenceValidator txnCodeSequenceValidator;
    private final VISAFileHeaderValidator fileHeaderValidator;
    private final VISATCRStringParser tcrStringParser;
    private VISALineWriter visaLineWriter;

    private final String receiveFolder;
    private final String indexFolder;

    private CSR021ReportWriter csr021ReportWriter;

    @SuppressWarnings("unused")
    public MasterCardFileIndexer(
            BillingCalculator billingCalculator,
            Environment environment,
            String receiveFolder,
            String indexFolder,
            String reportFolder,
            Service service,
            SubService subService,
            BigDecimal vatPercentage,
            String companyName,
            String registrationNumber,
            String validationCode) {
        super();
        this.subService = subService;
        this.billingCalculator = billingCalculator;
        List<CsfCardTypes> cardTypes = new CsfCardTypesDao().findAll();
        List<CsfTransactionTypes> txnTypes = new CsfTransactionTypesDao().findAll();
        memberInfoBean = new MemberInfoBean();
        tcrStringParser = new VISATCRStringParser();
        fileHeaderValidator = new VISAFileHeaderValidator(service, subService, validationCode);
//        visaFileRecordValidator = new VISAFileRecordValidator(txnTypes, cardTypes);
        visaLineWriter = new VISALineWriter(service, subService);

        this.receiveFolder = receiveFolder;
        this.indexFolder = indexFolder;
        this.companyName = companyName;
        this.registrationNumber = registrationNumber;

        csr021ReportWriter = new CSR021ReportWriter(reportFolder);
    }

    public String index(String filename, List<ErrorDTO> errors) throws IOException, FileRejectedException {

        Timer.start();

        BufferedReader in = null;
        PrintWriter out = null;

        try {
            String filepath = receiveFolder + PATH_SEPARATOR + filename;
            String indexpath = indexFolder + PATH_SEPARATOR + filename + ".idx";

            in = new BufferedReader(new FileReader(filepath));
            out = new PrintWriter(new File(indexpath));

            String line = null;
            Long counter = 0L;
            VISAFileHeader fileHeader = null;
            List<TCR> payLines = new ArrayList<>();

            spolog("INDEXING FILE: " + filename);

            while ((line = in.readLine()) != null) {

                ++counter;

                TCRType tcrType = tcrType(line);

                switch (tcrType) {

                    case HEADER:
                        // System.out.println("HEADER");
                        // parse
                        fileHeader = VISAFileHeaderParser.parse(fileSeqNumber, line);
                        // validate
                        fileHeaderValidator.validate(filename, fileHeader, errors);
                        // write to output. will index on end of file and summing up lines
    //                fileHeader.setFileSystemSeqNumber(++fileSeqNumber);
                        // write to output
                        out.println(fileHeader);
                        break;

                    case FINANCIAL:

                        if (hasPrevious(payLines)){
                            // validate TCR sequence
                            TxnCodeSequenceValidator.validate(payLines, errors, (counter - 1));
                            // apply billing
                            billingCalculator.bill(payLines);
                            // write to index file
                            visaLineWriter.write(out, fileHeader, payLines);
                            // reset
                            payLines = new ArrayList<>();
                        }

                        TCR payment
                                = tcrStringParser.parse(fileSeqNumber, ++txnSeqNumber, ++paySeqNumber,
                                line, counter, memberInfoBean, subService, csr021Out, null );

                        payLines.add(payment);

                     and we get a financial,
                     * means new transaction set beginning.
                     * hence process previous transaction set. 
                        // flag previous transaction set as accepted or rejected
                        // index
                        // write to index file

                     create new transaction set
                     * add this transaction
                     * the next line should be non-financial 
                        break;

                    case NON_FINANCIAL:
                        // System.out.println("NON_FINANCIAL");
                        // add to transaction set
                        payment = tcrStringParser.parse(
                                                    fileSeqNumber, txnSeqNumber, ++paySeqNumber,
                                                    line, counter, null, null, csr021Out, null );
                        payLines.add(payment);
                        break;

                    case UNKNOWN:
                        // System.out.println("UNKNOWN");
                        // flag previous transaction set as accepted or rejected
                        // index
                        // write to index file
                        break;

                    default:
                        // System.out.println("default");
                        // add to vet report
                        // ignore and move to next line
                        break;
                }

                if ( ( counter % 50000 ) == 0) {
                    spolog("INDEXED " + counter + " RECS.");
                }
            }

        } finally {

            try {in.close();} catch (Exception e){}
            try {out.flush();} catch (Exception e){}
            try {out.close();} catch (Exception e){}

            spolog("INDEXED in " + Timer.end() );
        }
        // flag previous transaction set as accepted or rejected
        // write to index file

        return null;
    }

    private boolean hasPrevious(List<TCR> payLines) {
        return payLines.size() > 0;
    }

    public void spolog(String message) {

        SPOLOGGER.spolog(PROCESS_NAME, VERSION, message);
    }

    // Metadata
    private final static String PROCESS_NAME = "CVINDEXER";
    private final static String VERSION = "20";
}
*/