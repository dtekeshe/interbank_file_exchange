//package com.bsva.dmcs.fileLoad.masterCard;
//
//
//import javax.sql.DataSource;
//
//import org.apache.log4j.Logger;
//
//import com.bsva.dcms.commons.dto.CSFBinsDTO;
//import com.bsva.dcms.commons.dto.CSFCardTypesDTO;
//import com.bsva.dcms.commons.dto.file.ErrorDTO;
//import com.bsva.dcms.commons.dto.file.FileAXSTrailorRecordDTO;
//import com.bsva.dcms.commons.dto.file.FileDTO;
//import com.bsva.dcms.commons.dto.file.FileTransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.MastercardFileDTO;
//import com.bsva.dcms.commons.dto.file.MastercardFileTransactionRecordDTO;
//import com.bsva.dcms.commons.enums.Status;
//import com.bsva.dcms.commons.util.StringUtil;
//import com.bsva.dmcs.fileLoad.AbstractFileValidator;
//import com.bsva.dmcs.fileLoad.exceptions.FileLoadException;
//
//public class MasterCardFileValidator extends AbstractFileValidator {
//
//    private ErrorDTO errorDto = new ErrorDTO();
//    private MastercardFileDTO fileDto = new MastercardFileDTO();
//    private Logger log = Logger.getLogger(MasterCardFileValidator.class);
//
//    public void validateByFileType(FileDTO fileDto) throws FileLoadException {
//        // TODO Auto-generated method stub
//        log.info("Validating file " + fileDto.getFileName());
//
//        this.fileDto = (MastercardFileDTO) fileDto;
//        this.errorDto = this.fileDto.getErrorDto();
//
//        //if file was rejected during load, then dont continue
//        if (this.fileDto.getFileStatus().equals(Status.R.getSymbol())) {
//            return;
//        }
//
//        //if header was invalid, dont bother validating the rest of the file
//        try {
//            if (!validateMasterCardHeader()) {
//                return;
//            }
//        } catch (Exception ex) {
//            log.debug("Master Card Header Not validated!!!!" + ex.getMessage());
//        }
//
//        if (!validateMasterCardTrailor()) {
//            return;
//        }
//
//        try {
//            if (!validateIPMHeader()) {
//                return;
//            }
//        } catch (Exception ex) {
//            log.debug("IPM Header Not validated!!!!");
//        }
//        if (!validateMasterCardRecord()) {
//            return;
//        }
//
//        /*if (!validateMasterCardEOS()) {
//            return;
//        }*/
//
//        if (!validateIPMTrailor()) {
//            return;
//        }
//
//    }
//
//    //TODO if header is invalid , dont validate the rest of the file
//    private boolean validateMasterCardHeader() {
//
//        super.validateFileHeader();
//
//        //FNSEQNOSTR
//        if (bsvTableLookup.getCsfSystemSettings().get("FNSEQNOSTR") != null) {
//
//        }
//
//        return this.fileDto.getFileStatus().equals(Status.A.getSymbol());
//    }
//
//    private boolean validateMasterCardRecord() {
//
//        for (FileTransactionRecordDTO fileTransactionRecordDTO : fileDto.getFileTransactionRecordDtoList()) {
//
//            MastercardFileTransactionRecordDTO mcTransactionRecord = (MastercardFileTransactionRecordDTO) fileTransactionRecordDTO;
//            validateDataElements(mcTransactionRecord);
//        }
//        return this.fileDto.getFileStatus().equals(Status.A.getSymbol());
//    }
//
//    private void validateDataElements(MastercardFileTransactionRecordDTO mcTransactionRecord) {
//
//        int mti = mcTransactionRecord.getMessageTypeInd();
//
//        String pan = mcTransactionRecord.getCardNumber();
//        if (pan != null) {
//
//            validateMCbin(mcTransactionRecord.getIssuerBin(), 2, mcTransactionRecord, 'I');
//
//            if (pan.length() < 16) {
//                errorDto.addError(55, Long.valueOf(mcTransactionRecord.getRecordId()), Integer.valueOf(mcTransactionRecord.getRecordId()), 0, pan, "Pan Length is 16");
//                mcTransactionRecord.setCurrentRecordValid(false);
//            }
//        }
//
//        long amountTransactionDE = mcTransactionRecord.getTransactionAmount();
//
//        CSFCardTypesDTO csfCardTypesDTO = bsvTableLookup.getCsfCardTypes().get(String.valueOf(mcTransactionRecord.getCardType()));
//        double pasaLimit = csfCardTypesDTO == null ? 0 : csfCardTypesDTO.getPasaPaymentLimit();
//        double amountTransaction = amountTransactionDE / 100;
//
//        if (amountTransaction > pasaLimit) {
//            errorDto.addError(43, Long.valueOf(mcTransactionRecord.getRecordId()), Integer.valueOf(mcTransactionRecord.getRecordId()), 0, "pasaLimit", "Transaction Amount greater than pasaLimit");
//            mcTransactionRecord.setCurrentRecordValid(false);
//        }
//    }
//
//    private void validateMCbin(int binNo, int elementNo, MastercardFileTransactionRecordDTO mcTransactionRecord, char issAcqBin) {
//
//        CSFBinsDTO binDto = bsvTableLookup.getBINDetailForBin(binNo);
//        int mti = mcTransactionRecord.getMessageTypeInd();
//
//        if (binDto == null) {
//            errorDto.addError(27, Long.valueOf(mcTransactionRecord.getRecordId()), mti, 0, String.valueOf(binNo), null);
//            mcTransactionRecord.setCurrentRecordValid(false);
//        } else {
//
//            if (issAcqBin == 'I') {
//                if (!binDto.getAcqIssBoth().equals("B") && !binDto.getAcqIssBoth().equals("I")) {
//                    errorDto.addError(63, Long.valueOf(mcTransactionRecord.getRecordId()), mti, 0, String.valueOf(binNo), null);
//                    mcTransactionRecord.setCurrentRecordValid(false);
//                }
//            } else {
//                if (!binDto.getAcqIssBoth().equals("B") && !binDto.getAcqIssBoth().equals("A")) {
//                    errorDto.addError(64, Long.valueOf(mcTransactionRecord.getRecordId()), mti, 0, String.valueOf(binNo), null);
//                    mcTransactionRecord.setCurrentRecordValid(false);
//                }
//            }
//
//            //validate bin dates
//            if (!binDatingValidation(mcTransactionRecord, issAcqBin, binDto, issAcqBin)) {
//                mcTransactionRecord.setCurrentRecordValid(false);
//            }
//        }
//
//    }
//
//    private boolean binDatingValidation(MastercardFileTransactionRecordDTO mcTransactionRecord, char issAcqBin, CSFBinsDTO csfbinsDto, int elementNo) {
//
//        boolean binValid = true;
//        int mti = mcTransactionRecord.getMessageTypeInd();
//        int binNo = (issAcqBin == 'I') ? mcTransactionRecord.getIssuerBin() : mcTransactionRecord.getAcquirerBin();
//        String functionCode = String.valueOf(mcTransactionRecord.getFunctionCode());
//
//        if (mti == 1240) {
//
//            if (csfbinsDto.getActiveInd().equals("A")) {
//
//                if (csfbinsDto.getDaysBeforeFirstDeletionDate() < 0 && csfbinsDto.getDaysBeforeFinalDeletionDate() > 0) {
//
//                    if (!functionCode.equals("205") && !functionCode.equals(282)) {
//
//                        errorDto.addError(issAcqBin == 'I' ? 61 : 62, Long.valueOf(mcTransactionRecord.getRecordId()), mti, 0, String.valueOf(binNo), null);
//                    }
//                }
//
//                if (csfbinsDto.getDaysBeforeFirstDeletionDate() < 0 && csfbinsDto.getDaysBeforeFinalDeletionDate() < 0) {
//                    errorDto.addError(issAcqBin == 'I' ? 61 : 62, Long.valueOf(mcTransactionRecord.getRecordId()), mti, 0, String.valueOf(binNo), null);
//                }
//            }
//        }
//
//        if (mti == 1442) {
//            if (csfbinsDto.getDaysBeforeFinalDeletionDate() < 0) {
//                errorDto.addError(issAcqBin == 'I' ? 61 : 62, Long.valueOf(mcTransactionRecord.getRecordId()), mti, 0, String.valueOf(binNo), null);
//            }
//        }
//
//        return binValid;
//    }
//
//    private boolean validateMasterCardEOS() {
//
//        super.validateFileEOS();
//        return this.fileDto.getFileStatus().equals(Status.A.getSymbol());
//    }
//
//    private boolean validateMasterCardTrailor() {
//
//        super.validateFileTrailor();
//
//        FileAXSTrailorRecordDTO axsTrailorRecDto = fileDto.getFileAxsTrailorRecordDto();
//        //check total number of records for mc incl control + eof records
//        int numOfRecords = 0;
//        numOfRecords += fileDto.getFileTransactionRecordDtoList().size();
//        numOfRecords += fileDto.getFileAXSHeaderRecordDto() != null ? 1 : 0;
//        numOfRecords += fileDto.getFileAxsTrailorRecordDto() != null ? 1 : 0;
//        numOfRecords += fileDto.getIpmFileHeaderDto() != null ? 1 : 0;
//        numOfRecords += fileDto.getIpmFileTrailorDto() != null ? 1 : 0;
//        numOfRecords += fileDto.getFileEOS98RecordDto() != null ? 1 : 0;
//        if (Integer.parseInt(axsTrailorRecDto.getNumberOfRecords()) != numOfRecords) {
//            errorDto.addError(8, axsTrailorRecDto.getLineNumber(), 99, 6, axsTrailorRecDto.getNumberOfRecords(), String.valueOf(numOfRecords));
//            fileDto.setFileStatus(Status.R.getSymbol());
//        }
//
//        //hashtotal of account numbers
//        long accNumTotal = 0;
//        for (FileTransactionRecordDTO fileTransactionRecDto : fileDto.getFileTransactionRecordDtoList()) {
//            accNumTotal += Long.valueOf(fileTransactionRecDto.getCardNumber());
//        }
//        String accNumHash = StringUtil.rightJustify(String.valueOf(accNumTotal), StringUtil.ZERO_STRING, 12);
//        if (!axsTrailorRecDto.getHashtotalOfAccountNumbers().equals(accNumHash)) {
//            errorDto.addError(6, axsTrailorRecDto.getLineNumber(), 99, 10, axsTrailorRecDto.getHashtotalOfAccountNumbers(), accNumHash);
//            fileDto.setFileStatus(Status.R.getSymbol());
//        }
//        return this.fileDto.getFileStatus().equals(Status.A.getSymbol());
//    }
//
//    private boolean validateIPMHeader() {
//
//        if (fileDto.getIpmFileHeaderDto().getP24_FunctionCode().isEmpty()) {
//            fileDto.getErrorDto().addError(81, fileDto.getIpmFileHeaderDto().getLineNumber(), fileDto.getIpmFileHeaderDto().getTransactionCode(), 1, null, null);
//            fileDto.setFileStatus(Status.R.getSymbol());
//        }
//
//        return this.fileDto.getFileStatus().equals(Status.A.getSymbol());
//    }
//
//    private boolean validateIPMTrailor() {
//
//        if (fileDto.getIpmFileTrailorDto().getP24_FunctionCode().isEmpty()) {
//            fileDto.getErrorDto().addError(82, fileDto.getIpmFileHeaderDto().getLineNumber(), fileDto.getIpmFileHeaderDto().getTransactionCode(), 1, null, null);
//            fileDto.setFileStatus(Status.R.getSymbol());
//        }
//        return this.fileDto.getFileStatus().equals(Status.A.getSymbol());
//
//    }
//
//    @Override
//    public void setConnection(DataSource conn) {
//        // TODO Auto-generated method stub
//
//    }
//}
