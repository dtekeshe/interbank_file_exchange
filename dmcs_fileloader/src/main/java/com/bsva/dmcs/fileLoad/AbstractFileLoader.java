//package com.bsva.dmcs.fileLoad;
//
//import java.util.ArrayList;
//
//import org.apache.log4j.Logger;
//
//import com.bsva.dcms.commons.dto.file.FileAXSHeaderRecordDTO;
//import com.bsva.dcms.commons.dto.file.FileAXSTrailorRecordDTO;
//import com.bsva.dcms.commons.dto.file.FileDTO;
//import com.bsva.dcms.commons.dto.file.FileEOS98RecordDTO;
//import com.bsva.dcms.commons.dto.file.FileHeader90RecordDTO;
//import com.bsva.dcms.commons.dto.file.FileTransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.NegativeCardRecordDTO;
//import com.bsva.dcms.commons.enums.Status;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dcms.commons.util.Utils;
//import com.bsva.dmcs.fileLoad.exceptions.FileLoadException;
//
//public abstract class AbstractFileLoader implements Loader {
//
//    private FileDTO fileDto;
//
//    public AbstractFileLoader() {
//
//    }
//
//    //recordOffset = recodCount in mastercard files unlike in visa files
//    protected int recordOffset = 0; // note recordOffSet != lineCount . lineCount is all lines , and recordOffset is for transactions only(note 4 lines can count as 1 transaction
//    protected int recordCount = 0; // all the transaction lines. this excludes headers and footers
//    protected FileAXSHeaderRecordDTO fileAXSHeaderRecordDto = null;
//    protected FileAXSTrailorRecordDTO fileAXSTrailorRecordDto = null;
//    protected FileEOS98RecordDTO fileEOSTrailorRecordDto = null;
//    protected FileHeader90RecordDTO fileHeader90Dto = null;
//    protected NegativeCardRecordDTO negCardRecordDto = null;
//
//    protected int lineCount = 0;   // all the lines including headers and footers
//    private Logger log = Logger.getLogger(AbstractFileLoader.class);
//
//    protected abstract void loadFileByType(String fileName) throws FileLoadException;
//
//    protected abstract FileDTO getFileByType();
//
//    public FileDTO load(String fileName) throws FileLoadException {
//
//        fileDto = new FileDTO();
//        fileDto = getFileByType();
//        fileDto.setFileName(fileName);
//        fileDto.setFileRefNumber(fileName + BsvTableLookup.getInstance().getNextOutputProcessDate());
//        fileDto.setFileTransactionRecordDtoList(new ArrayList<FileTransactionRecordDTO>());
//        loadFileByType(fileName);
//
//        Utils.logSpolog("File " + fileName + " finished Reading");
//        return fileDto;
//    }
//
//    protected void createAXSHeaderRecord(String line) {
//
//        // first line must be a 01 record
//        if (lineCount != 1 || line == null || line.trim().equals("")) {
//            fileDto.getErrorDto().addError(3, 1, 01, 1, "01", null);
//            fileDto.setFileStatus(Status.R.getSymbol());
//            return;
//        }
//
//        fileAXSHeaderRecordDto = new FileAXSHeaderRecordDTO();
//
//        String recordId = line.substring(0, 2).trim();
//        fileAXSHeaderRecordDto.setRecordId(recordId);
//
//        String fileInputDate = line.substring(2, 10).trim();
//        fileAXSHeaderRecordDto.setOutputDate(fileInputDate);
//
//        //set service to file
//        String serviceType = line.substring(10, 14).trim();
//        fileAXSHeaderRecordDto.setServiceType(serviceType);
//
//        //set subservice to file
//        String subServiceType = line.substring(14, 24).trim();
//        fileAXSHeaderRecordDto.setSubServiceType(subServiceType);
//
//        //set originator to file
//        String bankMemberNumber = line.substring(24, 28).trim();
//        fileAXSHeaderRecordDto.setBankMemberNumber(bankMemberNumber);
//
//        String originator = line.substring(28, 32).trim();
//        fileAXSHeaderRecordDto.setOriginator(originator);
//
//        String fileName = line.substring(32, 40).trim();
//        fileAXSHeaderRecordDto.setFileName(fileName);
//
//        String fileNumber = line.substring(40, 44).trim();
//        fileAXSHeaderRecordDto.setFileNumber(fileNumber);
//
//        String dataType = line.substring(44, 48).trim();
//        fileAXSHeaderRecordDto.setDataType(dataType);
//
//        String dataDirection = line.substring(48, 51).trim();
//        fileAXSHeaderRecordDto.setDataDirection(dataDirection);
//
//        String settlementDate = line.substring(51, 59).trim();
//        fileAXSHeaderRecordDto.setSettlementDate(settlementDate);
//
//        String testLiveIndicator = line.substring(59, 63).trim();
//        fileAXSHeaderRecordDto.setTestLiveIndicator(testLiveIndicator);
//
//        String recordLength = line.substring(63, 67).trim();
//        fileAXSHeaderRecordDto.setRecordLength(recordLength);
//
//        fileAXSHeaderRecordDto.setRecord(line);
//
//        fileAXSHeaderRecordDto.setLineNumber(lineCount);
//
//        fileDto.setFileService(fileAXSHeaderRecordDto.getServiceType());
//        fileDto.setFileSubService(fileAXSHeaderRecordDto.getSubServiceType());
//        try {
//            fileDto.setFileOriginator(Integer.parseInt(fileAXSHeaderRecordDto.getBankMemberNumber()));
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//    }
//
//    protected void createAXSTrailorRecord(String line) {
//
//        // you cant have a 99 record before the header
//        if (this.fileDto.getFileAXSHeaderRecordDto() == null) {
//            fileDto.getErrorDto().addError(4, lineCount, 99, 1, "99", "01");
//            fileDto.setFileStatus(Status.R.getSymbol());
//        }
//
//        if (line == null || line.trim().equals("")) {
//            fileDto.getErrorDto().addError(9, lineCount, 99, 1, "99", "01");
//            fileDto.setFileStatus(Status.R.getSymbol());
//            return;
//        }
//
//        fileAXSTrailorRecordDto = new FileAXSTrailorRecordDTO();
//
//        //else construct ur 99 record
//        String recordId = line.substring(0, 2).trim();
//        fileAXSTrailorRecordDto.setRecordId(recordId);
//
//        String outputDate = line.substring(2, 10).trim();
//        fileAXSTrailorRecordDto.setOutputDate(outputDate);
//
//        String serviceType = line.substring(10, 14).trim();
//        fileAXSTrailorRecordDto.setServiceType(serviceType);
//
//        if ("MASTERCARD".equals(fileDto.getFileSubService())) {
//            fileAXSTrailorRecordDto.setSubServiceType("MASTERCARD");
//        } else {
//            String subServiceType = line.substring(14, 24).trim();
//            fileAXSTrailorRecordDto.setSubServiceType(subServiceType);
//        }
//
//        String bankMemberNumber = line.substring(24, 28).trim();
//        fileAXSTrailorRecordDto.setBankMemberNumber(bankMemberNumber);
//
//        String numberOfRecords = line.substring(28, 34).trim();
//        fileAXSTrailorRecordDto.setNumberOfRecords(numberOfRecords);
//
//        String sourceIdentifier = line.substring(34, 42).trim();
//        fileAXSTrailorRecordDto.setSourceIdentifier(sourceIdentifier);
//
//        String encryptedWorkingKey = line.substring(42, 58).trim();
//        fileAXSTrailorRecordDto.setEncryptedWorkingKey(encryptedWorkingKey);
//
//        String macOfHashTotal = line.substring(58, 74).trim();
//        fileAXSTrailorRecordDto.setMacOfHashTotal(macOfHashTotal);
//
//        String hashtotalOfAccountNumbers = line.substring(74, 86).trim();
//        fileAXSTrailorRecordDto.setHashtotalOfAccountNumbers(hashtotalOfAccountNumbers);
//
//
//        fileAXSTrailorRecordDto.setRecord(line);
//        fileAXSTrailorRecordDto.setLineNumber(lineCount);
//    }
//
//    protected void createEOSRecord(String line) {
//
//        // you cant have a 98 record without receiving the header first
//        if (this.fileDto.getFileAXSHeaderRecordDto() == null) {
//            fileDto.getErrorDto().addError(3, lineCount, 98, 1, "98", "01");
//            fileDto.setFileStatus(Status.R.getSymbol());
//            return;
//        }
//
//        if (this.fileDto.getFileAxsTrailorRecordDto() != null) {
//            fileDto.getErrorDto().addError(5, lineCount, 90, 1, "98", "01");
//            fileDto.setFileStatus(Status.R.getSymbol());
//            return;
//        }
//
//        fileEOSTrailorRecordDto = new FileEOS98RecordDTO();
//
//        //else construct your 98 record
//        String recordId = line.substring(0, 2).trim();
//        fileEOSTrailorRecordDto.setRecordId(recordId);
//
//        String outputDate = line.substring(2, 10).trim();
//        fileEOSTrailorRecordDto.setOutputDate(outputDate);
//
//        String serviceType = line.substring(10, 14).trim();
//        fileEOSTrailorRecordDto.setServiceType(serviceType);
//
//        if ("MASTERCARD".equals(fileDto.getFileSubService())) {
//            fileEOSTrailorRecordDto.setSubServiceType("MASTERCARD");
//        } else {
//            String subServiceType = line.substring(14, 24).trim();
//            fileEOSTrailorRecordDto.setSubServiceType(subServiceType);
//        }
//
//        String bankMemberNumber = line.substring(24, 28).trim();
//        fileEOSTrailorRecordDto.setBankMemberNumber(bankMemberNumber);
//
//        String noOfTransamissionFiles = line.substring(28, 32).trim();
//        fileEOSTrailorRecordDto.setTransamissionFileCount(noOfTransamissionFiles);
//
//        String noOfCreditRecord = line.substring(32, 40).trim();
//        fileEOSTrailorRecordDto.setCreditRecordCount(noOfCreditRecord);
//
//        String noOfDebitRecods = line.substring(40, 48).trim();
//        fileEOSTrailorRecordDto.setDebitRecordCount(noOfDebitRecods);
//
//        String valueOfCreditRecords = line.substring(48, 64).trim();
//        fileEOSTrailorRecordDto.setValueOfCreditRecords(valueOfCreditRecords);
//
//        String valueOfDebitRecords = line.substring(64, 80).trim();
//        fileEOSTrailorRecordDto.setValueOfDebitRecords(valueOfDebitRecords);
//
//        String hashTotalOfAccountNumber = line.substring(80, 92).trim();
//        fileEOSTrailorRecordDto.setHashTotalOfAccountNumber(hashTotalOfAccountNumber);
//
//        fileEOSTrailorRecordDto.setRecord(line);
//        fileEOSTrailorRecordDto.setLineNumber(lineCount);
//
//    }
//
//    protected void createHeader90Record(String line) {
//
//        // you cant have a 90 record before a 01 record
//        if (this.fileDto.getFileAXSHeaderRecordDto() == null) {
//            fileDto.getErrorDto().addError(3, lineCount, 90, 1, "90", "01");
//            fileDto.setFileStatus(Status.R.getSymbol());
//            return;
//        }
//        if (this.fileDto.getFileAxsTrailorRecordDto() != null) {
//            fileDto.getErrorDto().addError(5, lineCount, 90, 1, "90", "01");
//            fileDto.setFileStatus(Status.R.getSymbol());
//            return;
//        }
//
//        fileHeader90Dto = new FileHeader90RecordDTO();
//        //else read the 90 record
//        String transactionCode = line.substring(0, 2).trim();
//        fileHeader90Dto.setTransactionCode(transactionCode);
//
//        String processingBin = line.substring(2, 8).trim();
//        fileHeader90Dto.setProcessingBin(processingBin);
//
//        String processingDate = line.substring(8, 13).trim();
//        fileHeader90Dto.setProcessingDate(processingDate);
//
//        line.substring(13, 29);
//
//        String testOption = line.substring(29, 33).trim();
//        fileHeader90Dto.setTestOption(testOption);
//
//        line.substring(33, 62);
//
//        String securityCode = line.substring(62, 70).trim();
//        fileHeader90Dto.setSecurityCode(securityCode);
//
//        line.substring(70, 76);
//
//        String outgointFileId = line.substring(76, 79).trim();
//        fileHeader90Dto.setOutgointFileId(outgointFileId);
//
//        fileHeader90Dto.setRecord(line);
//        fileHeader90Dto.setLineNumber(lineCount);
//    }
//
//    protected void createNegativeRecord(String line) {
//
//        //you cant have 41 records before reading the header first
//        if (this.fileDto.getFileAXSHeaderRecordDto() == null) {
//            fileDto.getErrorDto().addError(3, lineCount, 41, 1, "41", "01");
//            fileDto.setFileStatus(Status.R.getSymbol());
//            return;
//        }
//        if (this.fileDto.getFileAxsTrailorRecordDto() != null) {
//            fileDto.getErrorDto().addError(9, lineCount, 41, 1, "41", "01");
//            fileDto.setFileStatus(Status.R.getSymbol());
//            return;
//        }
//
//        negCardRecordDto = new NegativeCardRecordDTO();
//        //you cant have 41 records before reading the header first
//        String transactionCode = line.substring(0, 2).trim();
//        negCardRecordDto.setTransactionCode(transactionCode);
//        String destinationCode = line.substring(2, 8).trim();
//        negCardRecordDto.setDestinationCode(destinationCode);
//        String sourceBin = line.substring(8, 14).trim();
//        negCardRecordDto.setSourceBin(sourceBin);
//        String transactionType = line.substring(14, 15).trim();
//        negCardRecordDto.setTransactionType(transactionType);
//        String authCentreId = line.substring(15, 19).trim();
//        negCardRecordDto.setAuthCentreId(authCentreId);
//        String accountNumber = line.substring(19, 35).trim();
//        negCardRecordDto.setAccountNumber(accountNumber);
//        String responseCode = line.substring(35, 37).trim();
//        negCardRecordDto.setResponseCode(responseCode);
//        String purgeDate = line.substring(37, 41).trim();
//        negCardRecordDto.setPurgeDate(purgeDate);
//        String regionCode = line.substring(41, 50).trim();
//        negCardRecordDto.setRegionCode(regionCode);
//        String cardHolderName = line.substring(50, 121).trim();
//        negCardRecordDto.setCardHolderName(cardHolderName);
//        String lineAdvance = line.substring(121, 122).trim();
//        negCardRecordDto.setLineAdvance(lineAdvance);
//
//        negCardRecordDto.setRecord(line);
//        negCardRecordDto.setLineNumber(lineCount);
//        negCardRecordDto.setRecordOffset(recordOffset++);
//    }
//
//}
