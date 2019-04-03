package com.bsva.dmcs.fileextractv02;

import com.bsva.dmcs.reportv02.util.Justification;
import com.bsva.entities.v02.extract.OutputControlsEntity;
import com.bsva.entities.v02.outputcontrols.OutputControlDayTotalEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.bsva.dmcs.reportv02.util.StringUtils.format;

/**
 * TODO Document
 */
public class FileWriter {

    public final static String FILE_HEADER_RECORD_ID = "01";
    public final static String FILE_98_RECORD_ID = "98";
    public final static String FILE_91_RECORD_ID = "91";
    public final static String FILE_92_RECORD_ID = "92";
    public final static String FILE_TRAILER_RECORD_ID = "99";
    public final static String CONTENT_TYPE = "DATA";
    public final static String DIRECTION = "OUT";
    private final static String FILLER_ZERO_16 = "0000000000000000";
    private final static String FILLER_ZERO_12  = "000000000000";
    private final static String FILLER_ZERO_8  = "00000000";
    private final static String FILLER_SPACE_8  = "        ";
    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
    protected final static String FILE_SEPARATOR = System.getProperty("file.separator");
    protected final static String LINE_SEPARATOR = System.getProperty("line.separator");

    private final String environmentID;
    private final String validationCode;
    private final String formattedProcessDate;
    protected final String exportFolder;
    protected final String sendFolder;

    public FileWriter( String environmentID,
                       String validationCode,
                       Date processDate,
                       String exportFolder,
                       String sendFolder) {

        this.environmentID = environmentID;
        this.validationCode = validationCode;
        this.formattedProcessDate = DATE_FORMAT.format(processDate);
        this.exportFolder = exportFolder;
        this.sendFolder = sendFolder;
    }

    /**
     * TODO Document
     *
     * @param file
     * @return
     */
    protected String buildFileHeaderRecord(OutputControlsEntity file) {
    	Integer bankCode    = file.getId().getDestBankCode();
        Integer acquiringBankCode = file.getId().getOriginBankCode();

        String filename     = file.getFilename();
        String sequenceNum  = file.getFilename();
        String serviceID    = file.getId().getServiceID();
        String subServiceID = file.getId().getSubServiceID();

        StringBuilder builder = new StringBuilder();
        String lineFileName = format("00000000", 8, ' ', Justification.LEFT);
        String lineSubservice = format(subServiceID, 10, ' ', Justification.LEFT);
        String subHeaderLine = "02000001CARD"+lineSubservice+"10000000000000000000000100000000000000000000000100000000000000000000001000000000000000000000000000000000000000000000000000000000164400                   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000            000697000000000000000000000000000000000000000000000000000                       000000000000000000000000000000000000000000000000000000                                                                                             000000  000                       00                                                                                                                                                                                                                                                  00000000000000000000000000000000000000000000000000000000000000000000000000000000000                                                                                                                                                                          000000000                0000000000000000000                    000                                                                                                                                                                                                                                                               000                                           000                                 0000000000000000001000                                                                                                    0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   00000000000000000000000000000000000000                0000000000000000                         000000000000000000000000                                                                                          000            000                                           000                                           000                                           000                                           "+lineFileName+"";
         builder.append(FILE_HEADER_RECORD_ID);
        builder.append(formattedProcessDate);
        builder.append(format(serviceID, 4, ' ', Justification.LEFT));
        builder.append(format(subServiceID, 10, ' ', Justification.LEFT));
        builder.append(format(bankCode,       4, '0', Justification.RIGHT));
        builder.append(format(validationCode, 4, ' ', Justification.LEFT));
        builder.append(format(filename, 8, ' ', Justification.LEFT));
        builder.append(format(sequenceNum, 4, '0', Justification.RIGHT));
        builder.append(CONTENT_TYPE);
        builder.append(DIRECTION);
        builder.append(formattedProcessDate);
        builder.append(format(environmentID, 4, ' ', Justification.LEFT));
        builder.append("MASTERCARD".equals(subServiceID) ? "0700" : "0168");
        builder.append(format(acquiringBankCode, 4, '0', Justification.RIGHT));
        builder.append(LINE_SEPARATOR);
        if("MASTERCARD".equals(subServiceID)){
        	builder.append(subHeaderLine);
        	//builder.append(LINE_SEPARATOR);
        }
        return builder.toString();
    }

    /**
     * TODO Document
     *
     * @param file
     * @param has98Record
     * @return
     */
    protected String buildFileTrailerRecord(OutputControlsEntity file, boolean has98Record,String filename) {

        String serviceID    = file.getId().getServiceID();
        String subServiceID = file.getId().getSubServiceID();
        Long recordCount    = file.getRecordCount()  ;
        String lastFile = file.getLastFileIndicator();
        if(recordCount == 0 && lastFile.equals("Y")){
        	long num = 2L;
        	recordCount =+ num;
        }else if(recordCount == 0 ){
        	++recordCount;
        }

        Integer bankCode    = file.getId().getDestBankCode();
        String subServiceLine = format(subServiceID, 10, ' ', Justification.LEFT);
    	String fileNameLine = format("00000000", 8, ' ', Justification.LEFT);
    	String lineBeforeFooter = "92000000CARD"+subServiceLine+"10000000000000000000000100000000000000000000000100000000000000000000001000000000000000000000000000000000000000000000000000000000164400                   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000            000695000000000000000000000000000000000000000000000000000                       00000000000000000000000000                                                                                                                         000000  000                       00                                                                                                                                                                                                                                                  000000000000000000000000000000000000000000000000000000000000000000000000000000000                                                                                                                                                                            000000000                0000000000000000000                    000                                                                                                                                                                                                                                                               000                                           000                                 0000000000000032764000                                                                                                    0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   00000000000000000000000000000000000000                0000000000000000                         000000000000000000000000                                                                                          000            000                                           000                                           000                                           000                                           "+fileNameLine+"";
    	
        StringBuilder builder = new StringBuilder();
        if("MASTERCARD".equals(subServiceID)){
        	builder.append(lineBeforeFooter);
        	builder.append(LINE_SEPARATOR);
        }
        builder.append(FILE_TRAILER_RECORD_ID);
        builder.append(formattedProcessDate);
        builder.append(format(serviceID,    4,  ' ', Justification.LEFT));
        builder.append(format(subServiceID, 10, ' ', Justification.LEFT));
        builder.append(format(bankCode,       4, '0', Justification.RIGHT));
        builder.append(format(recordCount+1,       6, '0', Justification.RIGHT));

        builder.append(FILLER_ZERO_16);

        return builder.toString();
    }

    /**
     * TODO Document
     *
     * @param file
     * @param dayTotal
     * @return
     */
    protected String build98Record(OutputControlsEntity file,
                                   OutputControlDayTotalEntity dayTotal) {

        String serviceID     = file.getId().getServiceID();
        String subServiceID  = file.getId().getSubServiceID();
        Integer destBankCode = file.getId().getDestBankCode();

        Integer fileCount = dayTotal.getFileCount();
        Long crVolume     = dayTotal.getCrVolume();
        Long drVolume     = dayTotal.getDrVolume();
        Long crValue    = dayTotal.getCrValue().longValue();
        Long drValue    = dayTotal.getDrValue().longValue();

        StringBuilder builder = new StringBuilder();

        builder.append(FILE_98_RECORD_ID);
        builder.append(formattedProcessDate);
        builder.append(format(serviceID,    4,  ' ', Justification.LEFT));
        builder.append(format(subServiceID, 10, ' ', Justification.LEFT));
        builder.append(format(destBankCode, 4,  '0', Justification.RIGHT));
        builder.append(format(fileCount,    8,  '0', Justification.RIGHT));
        builder.append(format(crVolume,     8,  '0', Justification.RIGHT));
        builder.append(format(drVolume,     8,  '0', Justification.RIGHT));
        builder.append(format(crValue,      16, '0', Justification.RIGHT));
        builder.append(format(drValue,      16, '0', Justification.RIGHT));

        return builder.toString();
    }
    /**
     * TODO Document
     *
     * @param file
     * @return
     */
    //This is for future use. but is parked for now.
    protected String build91_92Record(OutputControlsEntity file ) {

    	String transactionCode = " ";
    	String tranCCodeQualifier = " ";
    	String tranSeqNo  = " ";
    	String bin = " ";
    	String processingDate = " ";
    	String destAmount = " ";
    	String moneyTransfer = " ";
    	String batchNumber = " ";
    	String numberOTCRS = " ";
    	String reserved1 = " ";
    	String centerBatchInd = " ";
    	String noOfTransactions = " ";
    	String reserved2 = " ";
    	String sourceAmount = " ";
    	String filler = " ";
    	//Creating StringBuilder to use and append to the line
    	StringBuilder builder = new StringBuilder();
        
        builder.append(format(transactionCode,2,' ',Justification.LEFT));
        builder.append(format(tranCCodeQualifier,1,' ',Justification.LEFT));
        builder.append(format(tranSeqNo,1,' ',Justification.LEFT));
        builder.append(format(bin,6,' ',Justification.LEFT));
        builder.append(format(processingDate,5,' ',Justification.LEFT));
        builder.append(format(destAmount,15,' ',Justification.LEFT));
        builder.append(format(moneyTransfer,12,' ',Justification.LEFT));
        builder.append(format(batchNumber,6,' ',Justification.LEFT));
        builder.append(format(numberOTCRS,12,' ',Justification.LEFT));
        builder.append(format(reserved1,6,' ',Justification.LEFT));
        builder.append(format(centerBatchInd,8,' ',Justification.LEFT));
        builder.append(format(noOfTransactions,9,' ',Justification.LEFT));
        builder.append(format(reserved2,18,' ',Justification.LEFT));
        builder.append(format(sourceAmount,13,' ',Justification.LEFT));
        builder.append(format(filler,52,' ',Justification.LEFT));
    	
    	return builder.toString() + LINE_SEPARATOR;
    }
 }
