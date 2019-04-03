package com.bsva.dmcs.fileloadv02.validators;

import com.bsva.dcms.commons.dao.CsfSystemSettingsDAO;
import com.bsva.dcms.commons.dto.CsfSystemSettingsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dmcs.fileloadv02.dto.FileFooterDto;
import com.bsva.dmcs.fileloadv02.dto.SubService;
import com.bsva.dmcs.fileloadv02.model.MemberInfoBean;
import com.bsva.dmcs.fileloadv02.parsers.TxnRecordParser;
import com.bsva.dmcs.fileloadv02.util.FileRejectedException;
import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.dto.ErrorDTO;
import com.bsva.dto.FileStats;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.bsva.dto.ErrorCode.*;

/**
 * TODO Document
 */
public class TxnCodeSequenceValidator extends TxnRecordParser {
	
	private int counter = 0;
	private final static String TCR_RECORDS = "00";

    public void validate(List<FileDetailDTO> payLines, List<ErrorDTO> errors, Long lineNumber,SubService subService) {
        
        //FileStats fileStats = null ;
        // if any record of is invalid, invalidate the whole group
        for (FileDetailDTO payment : payLines) {
        	if(subService.getDescription().equals("VISA CARD")){
	        	if(payLines.size() < 4){
	        		//String firstInputSeq = payLines.get(0).getInput().substring(2, 4).trim();
	        		//System.out.println(firstInputSeq);
	        		/*if(!TCR_RECORDS.equals(firstInputSeq)){
	        			CsfSystemSettingsDTO csfSystemSettingsDTO = new CsfSystemSettingsDTO();
	        			csfSystemSettingsDTO.setSettingCode("INV_TCRREC");
	        			try{
	        			CsfSystemSettingsDTO settingsname = new CsfSystemSettingsDAO().retrieve(csfSystemSettingsDTO);
	        			String serviceCode = settingsname.getSettingValue();
	        			counter ++;
	        			if(counter >= Integer.valueOf(serviceCode)){
	        				throw new FileRejectedException("####......FILE HAS SO MANY INCOMPLETE TRC RECS ....####");
	        			}
						} catch (DAOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        		}else{
	        		 String tcrtxnCode = payment.getInput().substring(2, 4);
	        		 error(errors,tcrtxnCode,lineNumber,FILE_FORMAT_ERROR_ON_FILE,4,tcrtxnCode);
	        		 rejectTxns(payLines);
	                 return;
	        		}*/
	        	}
        	}
        	
            if (! "C".equals(payment.getStatus())) {
                rejectTxns(payLines);
                return;
            }
        }

        int initialErrorCount = errors.size();

        // transaction code for TCR0 and TCR1 must be the same
        String tcr0TxnCode = txnCodeFor("00", payLines);
        String tcr1TxnCode = txnCodeFor("01", payLines);
        if (tcr0TxnCode != null && tcr1TxnCode != null && ! tcr0TxnCode.equals(tcr1TxnCode) ) {
            error(errors, null, lineNumber, TRC1_TRAN_CODE_NOT_EQUAL_TRC0, 4, tcr0TxnCode);
        }

        // transaction sequence must be in order i.e. 0500, 0501, 0505, 0507
        if ( ! isValidTxnRecordSequence(payLines)) {
            error(errors, null, lineNumber, TCR_SEQ_NO_OUT_OF_SEQ, 3, tcr0TxnCode);
            rejectTxns(payLines);
            return;
        }
    }

    private static void rejectTxns(List<FileDetailDTO> payLines) {
        for (FileDetailDTO fileDetailDTO : payLines) {
            fileDetailDTO.setStatus("R");
        }
    }

    private static boolean hasMoreErrors(Integer errorCount, Integer originalErrorCount) {
        return errorCount - originalErrorCount > 0;
    }

    private static String txnCodeFor(String tcrNumber,  List<FileDetailDTO> payLines) {
        for (FileDetailDTO payLine : payLines) {
            String thisTcrNumber = payLine.getInput().substring(2, 4);
            if (tcrNumber.equals(thisTcrNumber)) {
                String thisTxnCode = payLine.getInput().substring(0, 2);
                return thisTxnCode;
            }
        }

        return null;
    }

    private static boolean isValidTxnRecordSequence(List<FileDetailDTO> payLines) {
        String previousTcrNumber = null;
        for (FileDetailDTO paymentLine : payLines) {

            String thisTcrNumber = paymentLine.getInput().substring(2, 4);
            if (previousTcrNumber == null) {
                previousTcrNumber = thisTcrNumber;
                continue;
            }

            Integer previousTcrNumberInt;
            try {
                previousTcrNumberInt = Integer.parseInt(previousTcrNumber);
            } catch (Exception e) {
                return false;
            }

            Integer thisTcrNumberInt;
            try {
                thisTcrNumberInt = Integer.parseInt(thisTcrNumber);
            } catch (Exception e) {
                return false;
            }

            if (previousTcrNumberInt > thisTcrNumberInt) {
                return false;
            }
        }

        return true;
    }
    
    private static boolean isValidTxnRecordSequenceNonFinancials(List<FileDetailDTO> payLines) {
    	
        if(payLines.size() > 0) {

           return true;
        }

        return false;
    }

    @Override
    public FileDetailDTO parse( AtomicLong fileSeqNumber,
                                AtomicLong txnSeqNumber,
                                String line,
                                Long lineID,
                                MemberInfoBean memberInfoBean,
                                SubService subService,
                                List<ErrorDTO> errors) {
        return null;
    }
    
 public Boolean validateNonFinancialRecord(List<FileDetailDTO> payLines, List<ErrorDTO> errors, Long lineNumber,SubService subService) {

        int initialErrorCount = errors.size();
        // transaction code for TCR0 and TCR1 must be the same
        String tcr0TxnCode = txnCodeFor("00", payLines);
        String tcr1TxnCode = txnCodeFor("01", payLines);
        if (tcr0TxnCode != null && tcr1TxnCode != null && ! tcr0TxnCode.equals(tcr1TxnCode) ) {
            error(errors, null, lineNumber, TRC1_TRAN_CODE_NOT_EQUAL_TRC0, 4, tcr0TxnCode);
        }

        // transaction sequence must be in order i.e. 0500, 0501, 0505, 0507
        if ( ! isValidTxnRecordSequenceNonFinancials(payLines)) {
            error(errors, null, lineNumber, TCR_SEQ_NO_OUT_OF_SEQ, 3, tcr0TxnCode);
            rejectTxns(payLines);
            return false;
        }
        return true;
    }
}
