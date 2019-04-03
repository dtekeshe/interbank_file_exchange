package com.bsva.entities.v02.settlement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.dto.TransactionDTO;
import com.bsva.entities.v02.loader.FileDetailEntity;

/**
 * TODO Document
 */
public class TransactionDAO extends AbstractDao<CsoTransactionsEntity, Void> {

	private final static String FILE_DETAIL_SQL =
            "SELECT  FILE_SYSTEM_SEQ_NUMBER ," +
	        "SYSTEM_SEQ_NUMBER ," +            		
			"RECORD_NUMBER ," +
			"TRANSACTION_CODE ," +
			"CARD_TYPE ," +
			"ISSUER_MEMBER ," +
			"ACQUIRER_MEMBER ," +
			"ISSUER_BIN ," +
			"ACQUIRER_BIN ," +
			"PROCESS_STATUS ," +
			"TRANSACTION_AMOUNT ," +
			"CASHBACK_PRESENT ," +
			"CASHBACK_AMOUNT ," +
			"TRANSACTION_TIME ," +
			"RECORD_START_BYTE ," +
			"RECORD_END_BYTE ," +
			"OUTPUT_FILENAME ," +
			"FILE_RECORD_CNT ," +
			"FLEET_PRODUCT ," +
			"FLEET_SUB_PRODUCT ," +
			"ACCOUNT_NUMBER ," +
			"BILLING_FEE ," +
			"BILLING_FEE_AMOUNT ," +
			"BILLING_VAT ," +
			"CB_BILL_FEE ," +
			"CB_BILL_FEE_AMNT ," +
			"CB_BILL_VAT ," +
			"DEST_REPORT ," +
			"FLEET_COUNT_TRAN ," +
			"MESSAGE_TYPE_IND ," +
			"MERCHANT_CAT_CODE ," +
			"INTCHG_RATE_DSGN ," +
			"MESSAGE_REASON_CODE ," +
			"OPFILE_NUM_SEQ ," +
			"EXTRACTIND ," +
			"ERROR_CODE ," +
			"RATE_DESC " +
            " FROM CSO_TRANSACTIONS "+
			" WHERE FILE_SYSTEM_SEQ_NUMBER = :fileref ";

    public List<CsoTransactionsEntity> getFileDetailsFor(String fileref) {
   
    	// preparing params
    	Map<String, Object> params = new HashMap<>();
    	params.put("fileref", fileref);    	
    	
    	List<CsoTransactionsEntity> entities = list(FILE_DETAIL_SQL,params,CsoTransactionsEntity.class);
    	// preparing result
    	/*List<TransactionDTO> result = new ArrayList<>();
    	 try{
    	for (CsoTransactionsEntity entity : entities) {
    		
    		TransactionDTO dto = new TransactionDTO();
    		dto.setAccountNumber(entity.getAccountNumber());
    		dto.setAcquirerBin(entity.getAcquirerBin());
    		dto.setAcquirerMember(entity.getAcquirerMember());
    		dto.setBillingFee(entity.getBillingFee().doubleValue());
    		dto.setBillingFeeAmount(entity.getBillingFeeAmount().doubleValue());
    		dto.setBillingVat(entity.getBillingVat().doubleValue());
    		dto.setCardType(entity.getCardType());
    		dto.setCashbackAmount(entity.getCashbackAmount());
    		dto.setCashbackPresent(entity.getCashbackPresent());
    		dto.setCbBillFee(entity.getCbBillFee().doubleValue());
    		dto.setCbBillFeeAmnt(entity.getCbBillFeeAmnt().doubleValue());
    		dto.setCbBillVat(entity.getCbBillVat().doubleValue());
    		dto.setDestReport(entity.getDestReport());
    		dto.setExtractInd(entity.getExtractind());
    		dto.setFileRecordCnt(entity.getFileRecordCnt());
    		dto.setFileSystemSeqNumber(Long.valueOf(entity.getFileSystemSeqNumber()));
    		dto.setFleetCountTran(entity.getFleetCountTran());
    		dto.setFleetProduct(entity.getFleetProduct());
    		dto.setFleetSubProduct(entity.getFleetSubProduct());
    		if(entity.getIntchgRateDsgn() != null){
    			dto.setIntchgRateDsgn(entity.getIntchgRateDsgn());
    		}
    		dto.setIssuerBin(entity.getIssuerBin());
    		dto.setIssuerMember(entity.getIssuerMember());
    		if(entity.getMerchantCatCode() != null){
    		dto.setMerchantCatCode(entity.getMerchantCatCode());
    		}
    		if(entity.getMessageReasonCode()!= null){
    			dto.setMessageReasonCode(entity.getMessageReasonCode());
    		}
    		if(entity.getMessageTypeInd() != null){
    		dto.setMessageTypeInd(entity.getMessageTypeInd());
    		}
    		dto.setOpfileNumSeq(entity.getOpfileNumSeq());
    		dto.setOutputFilename(entity.getOutputFilename());
    		dto.setProcessStatus(entity.getProcessStatus());
    		dto.setRecordEndByte(entity.getRecordEndByte().longValue());
    		dto.setRecordNumber(entity.getRecordNumber());
    		dto.setRecordStartByte(entity.getRecordStartByte().longValue());
    		dto.setSystemSeqNumber(entity.getSystemSeqNumber());
    		dto.setTransactionAmount(entity.getTransactionAmount());
    		dto.setTransactionCode(entity.getTransactionCode());
    		if(entity.getTransactionTime() != null){
    		dto.setTransactionTime(entity.getTransactionTime());
    		}
    		
    		result.add(dto);
    		
    		
    	}
	    }catch(Exception ex){
	    	ex.getMessage();
	    }
*/		return entities;
    }
 }
