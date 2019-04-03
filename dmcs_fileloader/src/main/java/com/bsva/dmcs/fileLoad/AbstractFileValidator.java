//package com.bsva.dmcs.fileLoad;
//
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
//import com.bsva.dcms.commons.dao.CsoTransactionsDAO;
//import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
//import com.bsva.dcms.commons.dto.CSOTransactionDTO;
//import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
//import com.bsva.dcms.commons.dto.file.ErrorDTO;
//import com.bsva.dcms.commons.dto.file.FileAXSHeaderRecordDTO;
//import com.bsva.dcms.commons.dto.file.FileAXSTrailorRecordDTO;
//import com.bsva.dcms.commons.dto.file.FileDTO;
//import com.bsva.dcms.commons.dto.file.FileEOS98RecordDTO;
//import com.bsva.dcms.commons.dto.file.FileTransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.NegativeCardRecordDTO;
//import com.bsva.dcms.commons.enums.Status;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dcms.commons.util.Constants;
//import com.bsva.dcms.commons.util.DateUtil;
//import com.bsva.dcms.commons.util.StringUtil;
//import com.bsva.dcms.commons.util.Utils;
//import com.bsva.dmcs.fileLoad.exceptions.FileLoadException;
//
//public abstract class AbstractFileValidator implements Validator {
//
//    protected BsvTableLookup bsvTableLookup = BsvTableLookup.getInstance();
//
//    private FileDTO fileDto;
//
//    protected abstract void validateByFileType(FileDTO fileDto) throws FileLoadException;
//
//    public void validate(FileDTO fileDto) throws FileLoadException {
//
//        this.fileDto = fileDto;
//        validateByFileType(fileDto);
//
//        Utils.logSpolog("File " + fileDto.getFileName() + " finished Validating");
//    }
//
//    protected boolean validateFileHeader() {
//        boolean status = true;
//        FileAXSHeaderRecordDTO header = fileDto.getFileAXSHeaderRecordDto();
//        ErrorDTO errorDto = this.fileDto.getErrorDto();
//
//        try{
//			//check the header processDate
//			Date processDate = DateUtil.formatStringToDate(bsvTableLookup.getProcessDate(), "yyyyMMdd");
//			String formattedDate = DateUtil.formatDate(processDate, "yyyyMMdd");
//			if (!header.getOutputDate().equals(formattedDate)){
//				errorDto.addError(11, header.getLineNumber(), Integer.parseInt(Constants.AXS_HEADER_RECID), 3, header.getOutputDate(), formattedDate);
//				fileDto.setFileStatus(Status.R.getSymbol());
//				 status = false;
//			}
//		}catch(Exception e){
//			errorDto.addError(11, header.getLineNumber(), Integer.parseInt(Constants.AXS_HEADER_RECID), 3, header.getOutputDate(), null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//			 status = false;
//		}
//        // here we validate the 01 record
//        if (!header.getRecordId().equals(Constants.AXS_HEADER_RECID)) {
//            errorDto.addError(3, header.getLineNumber(), 1, 1, header.getServiceType(), bsvTableLookup.getSystemService());
//            fileDto.setFileStatus(Status.R.getSymbol());
//            status = false;
//        }
//
//        //check service
//        if (!header.getServiceType().equals(bsvTableLookup.getSystemService())) {
//            errorDto.addError(65, header.getLineNumber(), 1, 3, header.getServiceType(), bsvTableLookup.getSystemService());
//            fileDto.setFileStatus(Status.R.getSymbol());
//            status = false;
//        }
//
//        //check file input date / process date
//        if (!Utils.IsNumeric(header.getOutputDate())) {
//            errorDto.addError(66, header.getLineNumber(), 1, 2, header.getOutputDate(), null);
//            fileDto.setFileStatus(Status.R.getSymbol());
//            status = false;
//        }
//
//        //check file process date
//        if (!header.getOutputDate().equals(bsvTableLookup.getProcessDate())) {
//            errorDto.addError(11, header.getLineNumber(), 1, 2, header.getOutputDate(), bsvTableLookup.getProcessDate());
//            fileDto.setFileStatus(Status.R.getSymbol());
//            status = false;
//        }
//
//        //check filename prefix for sub service
//        String fileNamePrefix = header.getFileName().substring(0, 2);
//        if (!bsvTableLookup.getCsfDeliveryServices().get(fileNamePrefix).getSubService().equals(header.getSubServiceType())) {
//            errorDto.addError(10, header.getLineNumber(), 1, 7, header.getSubServiceType(), bsvTableLookup.getCsfDeliveryServices().get(fileNamePrefix).getSubService());
//            fileDto.setFileStatus(Status.R.getSymbol());
//            status = false;
//        }
//
//        //check subservice
//        if (bsvTableLookup.getCsfServices().get(header.getSubServiceType()) == null || bsvTableLookup.getCsfServices().get(header.getSubServiceType()).equals("")) {
//            errorDto.addError(76, header.getLineNumber(), 1, 4, header.getSubServiceType(), null);
//            fileDto.setFileStatus(Status.R.getSymbol());
//            status = false;
//        }
//
//        //check validation code
//        if (!header.getOriginator().equals(bsvTableLookup.getValidationCode())) {
//            errorDto.addError(16, header.getLineNumber(), 1, 6, header.getOriginator(), bsvTableLookup.getValidationCode());
//            fileDto.setFileStatus(Status.R.getSymbol());
//            status = false;
//        }
//
//        if (!(header.getFileNumber().equals(StringUtil.rightJustify(fileDto.getFileName().substring(4, 7), StringUtil.ZERO_STRING, 4)))) {
//            errorDto.addError(67, header.getLineNumber(), 1, 7, header.getFileName().substring(4, 7), header.getFileNumber());
//            fileDto.setFileStatus(Status.R.getSymbol());
//            status = false;
//        }
//
//        //DATA
//        if (!header.getDataType().equals(Constants.FILE_DATA_TYPE)) {
//            errorDto.addError(23, header.getLineNumber(), 1, 9, header.getDataType(), Constants.FILE_DATA_TYPE);
//            fileDto.setFileStatus(Status.R.getSymbol());
//            status = false;
//        }
//
//        //IN
//        if (!header.getDataDirection().equals(Constants.IN_DATA_DIRECTION)) {
//            errorDto.addError(24, header.getLineNumber(), 1, 10, header.getDataDirection(), Constants.IN_DATA_DIRECTION);
//            fileDto.setFileStatus(Status.R.getSymbol());
//            status = false;
//        }
//
//        //check settlement date
//        if (!Utils.IsNumeric(header.getSettlementDate())) {
//            errorDto.addError(68, header.getLineNumber(), 1, 11, header.getSettlementDate(), null);
//            fileDto.setFileStatus(Status.R.getSymbol());
//            status = false;
//        } else {
//            if (Integer.parseInt(header.getSettlementDate()) < 20070000) {
//                errorDto.addError(69, header.getLineNumber(), 1, 11, header.getSettlementDate(), null);
//                fileDto.setFileStatus(Status.R.getSymbol());
//                status = false;
//            }
//        }
//
//        //check test live indicator
//        if (!header.getTestLiveIndicator().equals(bsvTableLookup.getSystemStatus())) {
//            errorDto.addError(15, header.getLineNumber(), 1, 6, header.getTestLiveIndicator(), bsvTableLookup.getSystemStatus());
//            fileDto.setFileStatus(Status.R.getSymbol());
//            status = false;
//        }
//
//        //check del-delivery filename against the header filename
//        if (!fileDto.getFileName().equals(header.getFileName())) {
//            errorDto.addError(18, header.getLineNumber(), 1, 7, header.getFileName(), fileDto.getFileName());
//            fileDto.setFileStatus(Status.R.getSymbol());
//            status = false;
//        }
//
//        //check record length
//        if (!Utils.IsNumeric(header.getRecordLength())) {
//            errorDto.addError(25, header.getLineNumber(), 1, 13, header.getRecordLength(), null);
//            fileDto.setFileStatus(Status.R.getSymbol());
//            status = false;
//        }
//
//	   //NEW ONES
//        //validate the member code of the originator of the file
//        boolean found = false;
//        for (CSFMemberServiceDTO memberServiceDTO : bsvTableLookup.getCsfMemberService()) {
//            if (fileDto.getFileOriginator() == memberServiceDTO.getBankCode() && fileDto.getFileSubService().equals(memberServiceDTO.getSubService())) {
//                found = true;
//                break;
//            }
//        }
//
//        if (!found) {
//            errorDto.addError(16, header.getLineNumber(), 1, 5, header.getRecordLength(), null);
//            fileDto.setFileStatus(Status.R.getSymbol());
//            status = false;
//        }
//        return status;
//    }
//
//    protected void validateFileTrailor() {
//
//        FileAXSTrailorRecordDTO axsTrailorRecDto = fileDto.getFileAxsTrailorRecordDto();
//        ErrorDTO errorDto = this.fileDto.getErrorDto();
//
//        // here we validate the 01 record
//        if (!axsTrailorRecDto.getRecordId().equals(Constants.AXS_TRAILOR_RECID)) {
//            errorDto.addError(9, axsTrailorRecDto.getLineNumber(), Integer.parseInt(Constants.AXS_TRAILOR_RECID), 1, axsTrailorRecDto.getServiceType(), bsvTableLookup.getSystemService());
//            fileDto.setFileStatus(Status.R.getSymbol());
//        }
//
//        //check service
//        if (!axsTrailorRecDto.getServiceType().equals(bsvTableLookup.getSystemService())) {
//            errorDto.addError(65, axsTrailorRecDto.getLineNumber(), Integer.parseInt(Constants.AXS_TRAILOR_RECID), 3, axsTrailorRecDto.getServiceType(), bsvTableLookup.getSystemService());
//            fileDto.setFileStatus(Status.R.getSymbol());
//        }
//
//        //check file input date / process date
//        if (!Utils.IsNumeric(axsTrailorRecDto.getOutputDate())) {
//            errorDto.addError(66, axsTrailorRecDto.getLineNumber(), Integer.parseInt(Constants.AXS_TRAILOR_RECID), 2, axsTrailorRecDto.getOutputDate(), null);
//            fileDto.setFileStatus(Status.R.getSymbol());
//        }
//
//        //check file process date
//        if (!axsTrailorRecDto.getOutputDate().equals(bsvTableLookup.getProcessDate())) {
//            errorDto.addError(11, axsTrailorRecDto.getLineNumber(), Integer.parseInt(Constants.AXS_TRAILOR_RECID), 2, axsTrailorRecDto.getOutputDate(), bsvTableLookup.getProcessDate());
//            fileDto.setFileStatus(Status.R.getSymbol());
//        }
//
//        //check subservice
//        if (bsvTableLookup.getCsfSubServices().get(axsTrailorRecDto.getSubServiceType()) == null || bsvTableLookup.getCsfSubServices().get(axsTrailorRecDto.getSubServiceType()).equals("")) {
//            errorDto.addError(76, axsTrailorRecDto.getLineNumber(), Integer.parseInt(Constants.AXS_TRAILOR_RECID), 4, axsTrailorRecDto.getSubServiceType(), null);
//            fileDto.setFileStatus(Status.R.getSymbol());
//        }
//    }
//
//    protected void validateFileEOS() {
//
//        FileEOS98RecordDTO eosRecDto = fileDto.getFileEOS98RecordDto();
//        ErrorDTO errorDto = this.fileDto.getErrorDto();
//
//        if (eosRecDto == null) {
//            return;
//        }
//
//        // here we validate the 01 record
//        if (!eosRecDto.getRecordId().equals(Constants.EOS_98_RECID)) {
//            errorDto.addError(21, eosRecDto.getLineNumber(), 98, 1, eosRecDto.getServiceType(), bsvTableLookup.getSystemService());
//            fileDto.setFileStatus(Status.R.getSymbol());
//        }
//
//        //check service
//        if (!eosRecDto.getServiceType().equals(bsvTableLookup.getSystemService())) {
//            errorDto.addError(65, eosRecDto.getLineNumber(), 98, 3, eosRecDto.getServiceType(), bsvTableLookup.getSystemService());
//            fileDto.setFileStatus(Status.R.getSymbol());
//        }
//
//        //check file input date / process date
//        if (!Utils.IsNumeric(eosRecDto.getOutputDate())) {
//            errorDto.addError(66, eosRecDto.getLineNumber(), 98, 2, eosRecDto.getOutputDate(), null);
//            fileDto.setFileStatus(Status.R.getSymbol());
//        }
//
//        //check file process date
//        if (!eosRecDto.getOutputDate().equals(bsvTableLookup.getProcessDate())) {
//            errorDto.addError(11, eosRecDto.getLineNumber(), 98, 2, eosRecDto.getOutputDate(), bsvTableLookup.getProcessDate());
//            fileDto.setFileStatus(Status.R.getSymbol());
//        }
//
//        //check subservice
//        if (bsvTableLookup.getCsfSubServices().get(eosRecDto.getSubServiceType()) == null || bsvTableLookup.getCsfSubServices().get(eosRecDto.getSubServiceType()).equals("")) {
//            errorDto.addError(76, eosRecDto.getLineNumber(), 98, 4, eosRecDto.getSubServiceType(), null);
//            fileDto.setFileStatus(Status.R.getSymbol());
//        }
//
//        //check number of transmission files - total number of visa files delivered
//        List<CsoInputFileControlsDTO> csoInputFileControlsFromSameOriginator = new ArrayList<>();
//        int numberOfTransmissionFiles = 1;
//
//        try {
//            //get the files from the same originator on this processing date
//            CsoInputFileControlsDTO inputFileControlDto = new CsoInputFileControlsDTO();
//            inputFileControlDto.setService(eosRecDto.getServiceType());
//            inputFileControlDto.setSubService(eosRecDto.getSubServiceType());
//            inputFileControlDto.setOutputDate(DateUtil.formatStringToDate(eosRecDto.getOutputDate(), "yyyyMMdd"));
//            CsoInputFileControlsDAO csoInputFileControlsdao = new CsoInputFileControlsDAO();
//            List<CsoInputFileControlsDTO> csoInputFileControlsList = csoInputFileControlsdao.retrieveRelated(inputFileControlDto);
//
//            String fileNamePrefix = fileDto.getFileName().substring(0, 4);
//
//            if (csoInputFileControlsList != null) {
//                for (CsoInputFileControlsDTO inputFileDto : csoInputFileControlsList) {
//                    if (inputFileDto.getFileRefNumber().startsWith(fileNamePrefix)) {
//                        numberOfTransmissionFiles += 1;
//                        csoInputFileControlsFromSameOriginator.add(inputFileDto);
//                    }
//                }
//            }
//            if (Integer.parseInt(eosRecDto.getTransamissionFileCount()) != numberOfTransmissionFiles) {
//                errorDto.addError(51, eosRecDto.getLineNumber(), 98, 6, eosRecDto.getTransamissionFileCount(), String.valueOf(numberOfTransmissionFiles));
//                fileDto.setFileStatus(Status.R.getSymbol());
//            }
//
//        } catch (Exception e) {
//            errorDto.addError(51, eosRecDto.getLineNumber(), 98, 6, eosRecDto.getTransamissionFileCount(), String.valueOf(numberOfTransmissionFiles));
//            fileDto.setFileStatus(Status.R.getSymbol());
//        }
//
//        //TODO include negatives for visa files : we dont store the negative ones
//        int debitRecordNumber = 0;
//        long debitRecordValue = 0;
//        long accountNumbers = 0;
//
//        try {
//
//            CSOTransactionDTO transactionDto;
//            for (CsoInputFileControlsDTO inputFileDto : csoInputFileControlsFromSameOriginator) {
//                // get all the transactions of the  files we received
//                transactionDto = new CSOTransactionDTO();
//                transactionDto.setFileSystemSeqNumber(inputFileDto.getSystemSeqNumber());
//                CsoTransactionsDAO csoTransactionsdao = new CsoTransactionsDAO();
//                List<CSOTransactionDTO> tranList = csoTransactionsdao.retrieveRelated(transactionDto);
//                debitRecordNumber += tranList.size();
//
//                for (CSOTransactionDTO tranDto : tranList) {
//                    debitRecordValue += tranDto.getTransactionAmount();
//                    accountNumbers += Long.parseLong(tranDto.getAccountNumber());
//                }
//            }
//
//            //check total number of debit records
//            if (Integer.parseInt(eosRecDto.getDebitRecordCount()) != debitRecordNumber) {
//                errorDto.addError(8, eosRecDto.getLineNumber(), 98, 8, eosRecDto.getDebitRecordCount(), String.valueOf(debitRecordNumber));
//                fileDto.setFileStatus(Status.R.getSymbol());
//            }
//
//            //check value of debit records
//            if (Integer.parseInt(eosRecDto.getValueOfDebitRecords()) != debitRecordValue) {
//                errorDto.addError(52, eosRecDto.getLineNumber(), 98, 10, eosRecDto.getValueOfDebitRecords(), String.valueOf(debitRecordValue));
//                fileDto.setFileStatus(Status.R.getSymbol());
//            }
//
//            //hashtotal of account numbers
//            if (!((new Long(eosRecDto.getHashTotalOfAccountNumber()).longValue()) == accountNumbers)) {
//                errorDto.addError(6, eosRecDto.getLineNumber(), 99, 11, eosRecDto.getHashTotalOfAccountNumber(), String.valueOf(accountNumbers));
//                fileDto.setFileStatus(Status.R.getSymbol());
//            }
//
//        } catch (Exception e) {
//            errorDto.addError(8, eosRecDto.getLineNumber(), 98, 8, eosRecDto.getDebitRecordCount(), String.valueOf(debitRecordNumber));
//            errorDto.addError(8, eosRecDto.getLineNumber(), 98, 10, eosRecDto.getValueOfDebitRecords(), String.valueOf(debitRecordValue));
//            errorDto.addError(6, eosRecDto.getLineNumber(), 99, 11, eosRecDto.getHashTotalOfAccountNumber(), String.valueOf(accountNumbers));
//            fileDto.setFileStatus(Status.R.getSymbol());
//        }
//
//    }
//
//}
