package com.bsva.dcms.commons.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsoTransactionsDao;
import com.bsva.dcms.commons.dto.CSOTransactionDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsoTransactions;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsoTransactionsDAO{

	private CsoTransactionsDao csoTransactionsDao = new CsoTransactionsDao();
	
	//private CsoTransactionsRepository csoTransactionsRepositoryDao = DaoFactory.csoTransactionsInstance();

	//List<String> map = new ArrayList<String>();
	private Map<String,Object>map = new HashMap<String, Object>();
	
	public CsoTransactionsDAO() {

	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public void create(CSOTransactionDTO bean) throws DAOException {
     try{
		CsoTransactions csoTransactions = new CsoTransactions();
		csoTransactions.setFileSystemSeqNumber(String.valueOf(bean.getFileSystemSeqNumber()));
		csoTransactions.setSystemSeqNumber(bean.getSystemSeqNumber());
		csoTransactions.setRecordEndByte(BigInteger.valueOf(bean.getRecordEndByte()));
		csoTransactions.setTransactionCode((short) bean.getTransactionCode());
		csoTransactions.setCardType((short) bean.getCardType());
		csoTransactions.setIssuerMember((short) bean.getIssuerMember());
		csoTransactions.setAcquirerMember((short) bean.getAcquirerMember());
		csoTransactions.setIssuerBin(bean.getIssuerBin());
		csoTransactions.setAcquirerBin(bean.getAcquirerBin());
		csoTransactions.setProcessStatus(bean.getProcessStatus());
		csoTransactions.setTransactionAmount(bean.getTransactionAmount());
		csoTransactions.setCashbackPresent(bean.getCashbackPresent() == null ? "N": bean.getCashbackPresent());
		csoTransactions.setCashbackAmount(bean.getCashbackAmount());
		csoTransactions.setTransactionTime(bean.getTransactionTime());
		csoTransactions.setRecordStartByte(BigInteger.valueOf(bean.getRecordStartByte()));
		csoTransactions.setRecordEndByte(BigInteger.valueOf(bean.getRecordEndByte()));
		csoTransactions.setOutputFilename(bean.getOutputFilename());
		csoTransactions.setFileRecordCnt( (short) bean.getFileRecordCnt());
		csoTransactions.setFleetProduct(bean.getFleetProduct());
		csoTransactions.setFleetSubProduct(bean.getFleetSubProduct());
		csoTransactions.setAccountNumber(bean.getAccountNumber());
		csoTransactions.setBillingFee(BigDecimal.valueOf(bean.getBillingFee()));
		csoTransactions.setBillingFeeAmount(BigDecimal.valueOf(bean.getBillingFeeAmount()));
		csoTransactions.setBillingVat(BigDecimal.valueOf(bean.getBillingVat()));
		csoTransactions.setCbBillFee(BigDecimal.valueOf(bean.getCbBillFee()));
		csoTransactions.setCbBillFeeAmnt(BigDecimal.valueOf(bean.getCbBillFeeAmnt()));
		csoTransactions.setCbBillVat(BigDecimal.valueOf(bean.getCbBillVat()));
		csoTransactions.setDestReport(bean.getDestReport());
		csoTransactions.setFleetCountTran(bean.getFleetCountTran());
		csoTransactions.setMessageTypeInd((short) bean.getMessageTypeInd());
		csoTransactions.setMerchantCatCode((short) bean.getMerchantCatCode());
		csoTransactions.setIntchgRateDsgn((short) bean.getIntchgRateDsgn());
		csoTransactions.setMessageReasonCode( (short) bean.getMessageReasonCode());
		csoTransactions.setOpfileNumSeq(bean.getOpfileNumSeq());
		csoTransactions.setExtractind(bean.getExtractInd());
		csoTransactions.setRecordNumber(bean.getRecordNumber());

		csoTransactionsDao.create(csoTransactions);
		bean.setSystemSeqNumber(csoTransactions.getSystemSeqNumber());
		
		
     }catch(Exception ex){
    	 ex.getMessage();
     }
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	@SuppressWarnings("unchecked")
	public CSOTransactionDTO retrieve(CSOTransactionDTO bean) throws DAOException {

		CSOTransactionDTO dto = null;

		try{
            
			String sql = "SELECT c FROM CsoTransactions c "+buildWhereClause(bean,true);

			CsoTransactions csoTransactions = csoTransactionsDao.executeQueryParametersSingleDate(sql,map);

			dto = new CSOTransactionDTO();
			if(csoTransactions!=null){

				dto.setFileSystemSeqNumber(Long.valueOf(csoTransactions.getFileSystemSeqNumber()));
				dto.setSystemSeqNumber(csoTransactions.getSystemSeqNumber());
				dto.setRecordStartByte(csoTransactions.getRecordEndByte().longValue());
				dto.setTransactionCode(csoTransactions.getTransactionCode());
				dto.setCardType(csoTransactions.getCardType());
				if(csoTransactions.getIssuerMember()!=null){
					dto.setIssuerMember(csoTransactions.getIssuerMember().intValue());
				}
				if(csoTransactions.getAcquirerMember()!=null){
					dto.setAcquirerMember(csoTransactions.getAcquirerMember().intValue());
				}
				if(csoTransactions.getIssuerBin()!=null){
					dto.setIssuerBin(csoTransactions.getIssuerBin().intValue());
				}
				if(csoTransactions.getAcquirerBin()!=null){
					dto.setAcquirerBin(csoTransactions.getAcquirerBin().intValue());
				}
				if(csoTransactions.getProcessStatus()!=null){
					dto.setProcessStatus(csoTransactions.getProcessStatus());
				}
				if(csoTransactions.getTransactionAmount()!=null){
					dto.setTransactionAmount(csoTransactions.getTransactionAmount());
				}
				if(csoTransactions.getCashbackPresent()!=null){
					dto.setCashbackPresent(csoTransactions.getCashbackPresent());
				}
				if(csoTransactions.getCashbackAmount()!=null){
					dto.setCashbackAmount(csoTransactions.getCashbackAmount());
				}
				if(csoTransactions.getTransactionTime()!=null){
					dto.setTransactionTime(csoTransactions.getTransactionTime().longValue());
				}
				if(csoTransactions.getRecordStartByte()!=null){
					dto.setRecordStartByte(csoTransactions.getRecordStartByte().longValue());
				}
				if(csoTransactions.getRecordEndByte()!=null){
					dto.setRecordEndByte(csoTransactions.getRecordEndByte().longValue());
				}
				if(csoTransactions.getOutputFilename()!=null){
					dto.setOutputFilename(csoTransactions.getOutputFilename());
				}
				dto.setFileRecordCnt(csoTransactions.getFileRecordCnt());
				if(csoTransactions.getFleetProduct()!=null){
					dto.setFleetProduct(csoTransactions.getFleetProduct());
				}
				if(csoTransactions.getFleetSubProduct()!=null){
					dto.setFleetSubProduct(csoTransactions.getFleetSubProduct());
				}
				if(csoTransactions.getAccountNumber()!=null){
					dto.setAccountNumber(csoTransactions.getAccountNumber());
				}
				if(csoTransactions.getBillingFee()!=null){
					dto.setBillingFee(csoTransactions.getBillingFee().longValue());
				}
				if(csoTransactions.getBillingFeeAmount()!=null){
					dto.setBillingFeeAmount(csoTransactions.getBillingFeeAmount().doubleValue());
				}
				if(csoTransactions.getBillingVat()!=null){
					dto.setBillingVat(csoTransactions.getBillingVat().doubleValue());
				}
				if(csoTransactions.getCbBillFee()!=null){
					dto.setCbBillFee(csoTransactions.getCbBillFee().doubleValue());
				}
				if(csoTransactions.getCbBillFeeAmnt()!=null){
					dto.setCbBillFeeAmnt(csoTransactions.getCbBillFeeAmnt().doubleValue());
				}
				if(csoTransactions.getCbBillVat()!=null){
					dto.setCbBillVat(csoTransactions.getCbBillVat().doubleValue());
				}
				if(csoTransactions.getDestReport()!=null){
					dto.setDestReport(csoTransactions.getDestReport());
				}
				if(csoTransactions.getFleetCountTran()!=null){
					dto.setFleetCountTran(csoTransactions.getFleetCountTran());
				}
				if(csoTransactions.getMessageTypeInd()!=null){
					dto.setMessageTypeInd(csoTransactions.getMessageTypeInd().shortValue());
				}
				if(csoTransactions.getMerchantCatCode()!=null){
					dto.setMerchantCatCode(csoTransactions.getMerchantCatCode().shortValue());
				}
				if(csoTransactions.getIntchgRateDsgn()!=null){
					dto.setIntchgRateDsgn(csoTransactions.getIntchgRateDsgn().shortValue());
				}
				if(csoTransactions.getMessageReasonCode()!=null){
					dto.setMessageReasonCode(csoTransactions.getMessageReasonCode().shortValue());
				}
				dto.setOpfileNumSeq(csoTransactions.getOpfileNumSeq());
				if(csoTransactions.getExtractind()!=null){
					dto.setExtractInd(csoTransactions.getExtractind());
				}
				if(csoTransactions.getRateDesc()!=null){
					dto.setRateDesc(csoTransactions.getRateDesc());
				}
			}


		}catch(Exception ex){
			ex.getMessage();
		}
		map.clear();
		return dto;

	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	@SuppressWarnings("unchecked")
	public List<CSOTransactionDTO> retrieveRelated(CSOTransactionDTO bean) throws DAOException {

		List<CSOTransactionDTO> dtoList = new LinkedList<CSOTransactionDTO>();
		CSOTransactionDTO dto;

		try {
			String sql = "SELECT c  FROM CsoTransactions c "+ buildWhereClause(bean,true);

			List<CsoTransactions> csoTransactionsRetrieveRelated = csoTransactionsDao.executeQueryParametersDate(sql,map);

			for (CsoTransactions csoTransactions : csoTransactionsRetrieveRelated) {

				dto = new CSOTransactionDTO();
				dto.setFileSystemSeqNumber(Long.valueOf(csoTransactions.getFileSystemSeqNumber()));
				dto.setSystemSeqNumber(csoTransactions.getSystemSeqNumber());
				dto.setRecordStartByte(csoTransactions.getRecordEndByte().longValue());
				dto.setTransactionCode(csoTransactions.getTransactionCode());
				dto.setCardType(csoTransactions.getCardType());
				if(csoTransactions.getIssuerMember()!=null){
					dto.setIssuerMember(csoTransactions.getIssuerMember().intValue());
				}
				if(csoTransactions.getAcquirerMember()!=null){
					dto.setAcquirerMember(csoTransactions.getAcquirerMember().intValue());
				}
				if(csoTransactions.getIssuerBin()!=null){
					dto.setIssuerBin(csoTransactions.getIssuerBin().intValue());
				}
				if(csoTransactions.getAcquirerBin()!=null){
					dto.setAcquirerBin(csoTransactions.getAcquirerBin().intValue());
				}
				if(csoTransactions.getProcessStatus()!=null){
					dto.setProcessStatus(csoTransactions.getProcessStatus());
				}
				if(csoTransactions.getTransactionAmount()!=null){
					dto.setTransactionAmount(csoTransactions.getTransactionAmount());
				}
				if(csoTransactions.getCashbackPresent()!=null){
					dto.setCashbackPresent(csoTransactions.getCashbackPresent());
				}
				if(csoTransactions.getCashbackAmount()!=null){
					dto.setCashbackAmount(csoTransactions.getCashbackAmount());
				}
				if(csoTransactions.getTransactionTime()!=null){
					dto.setTransactionTime(csoTransactions.getTransactionTime().longValue());
				}
				if(csoTransactions.getRecordStartByte()!=null){
					dto.setRecordStartByte(csoTransactions.getRecordStartByte().longValue());
				}
				if(csoTransactions.getRecordEndByte()!=null){
					dto.setRecordEndByte(csoTransactions.getRecordEndByte().longValue());
				}
				if(csoTransactions.getOutputFilename()!=null){
					dto.setOutputFilename(csoTransactions.getOutputFilename());
				}
				dto.setFileRecordCnt(csoTransactions.getFileRecordCnt());
				if(csoTransactions.getFleetProduct()!=null){
					dto.setFleetProduct(csoTransactions.getFleetProduct());
				}
				if(csoTransactions.getFleetSubProduct()!=null){
					dto.setFleetSubProduct(csoTransactions.getFleetSubProduct());
				}
				if(csoTransactions.getAccountNumber()!=null){
					dto.setAccountNumber(csoTransactions.getAccountNumber());
				}
				if(csoTransactions.getBillingFee()!=null){
					dto.setBillingFee(csoTransactions.getBillingFee().longValue());
				}
				if(csoTransactions.getBillingFeeAmount()!=null){
					dto.setBillingFeeAmount(csoTransactions.getBillingFeeAmount().doubleValue());
				}
				if(csoTransactions.getBillingVat()!=null){
					dto.setBillingVat(csoTransactions.getBillingVat().doubleValue());
				}
				if(csoTransactions.getCbBillFee()!=null){
					dto.setCbBillFee(csoTransactions.getCbBillFee().doubleValue());
				}
				if(csoTransactions.getCbBillFeeAmnt()!=null){
					dto.setCbBillFeeAmnt(csoTransactions.getCbBillFeeAmnt().doubleValue());
				}
				if(csoTransactions.getCbBillVat()!=null){
					dto.setCbBillVat(csoTransactions.getCbBillVat().doubleValue());
				}
				if(csoTransactions.getDestReport()!=null){
					dto.setDestReport(csoTransactions.getDestReport());
				}
				if(csoTransactions.getFleetCountTran()!=null){
					dto.setFleetCountTran(csoTransactions.getFleetCountTran());
				}
				if(csoTransactions.getMessageTypeInd()!=null){
					dto.setMessageTypeInd(csoTransactions.getMessageTypeInd().shortValue());
				}
				if(csoTransactions.getMerchantCatCode()!=null){
					dto.setMerchantCatCode(csoTransactions.getMerchantCatCode().shortValue());
				}
				if(csoTransactions.getIntchgRateDsgn()!=null){
					dto.setIntchgRateDsgn(csoTransactions.getIntchgRateDsgn().shortValue());
				}
				if(csoTransactions.getMessageReasonCode()!=null){
					dto.setMessageReasonCode(csoTransactions.getMessageReasonCode().shortValue());
				}
				dto.setOpfileNumSeq(csoTransactions.getOpfileNumSeq());
				if(csoTransactions.getExtractind()!=null){
					dto.setExtractInd(csoTransactions.getExtractind());
				}
				if(csoTransactions.getRateDesc()!=null){
					dto.setRateDesc(csoTransactions.getRateDesc());
				}
				
				dtoList.add(dto);
			}
		}
		catch(Exception ex) {
			ex.getMessage();
		}

		 map.clear();
		return dtoList;
	}

	/**
	 * Retrieve a list of records based on rowcountfrom Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */
	//public List<CSOTransactionDTO> retrieveRelatedCount(CSOTransactionDTO bean, int startRow, int endRow) throws DAOException {
	public int retrieveRelatedCount(CSOTransactionDTO bean) throws DAOException {	
		try {
			String sql = "SELECT COUNT(*) AS count FROM CsoTransactions ";
			int count = (int) csoTransactionsDao.executeCountQuery(sql);

			return count;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CSOTransaction, cause: "+ ex.getMessage(), ex);
		}
	}

	private String buildWhereClause(CSOTransactionDTO bean, boolean select)throws DAOException  {

		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		
		if (select == true) {

		if (bean.getFileSystemSeqNumber() > 0L) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.fileSystemSeqNumber =:fileSystemSeqNumber");
			map.put("fileSystemSeqNumber",String.valueOf(bean.getFileSystemSeqNumber()));

		}
		if (bean.getSystemSeqNumber() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.systemSeqNumber =:systemSeqNumber");
			map.put("systemSeqNumber",bean.getSystemSeqNumber());
		}
		if (bean.getRecordNumber() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.recordNumber =:recordNumber");
			map.put("recordNumber",String.valueOf(bean.getRecordNumber()));
		}
		if (bean.getTransactionCode() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.transactionCode =:transactionCode");
			map.put("transactionCode",String.valueOf(bean.getTransactionCode()));
		}
		if (bean.getCardType() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.cardType =:cardType");
			map.put("cardType",String.valueOf(bean.getCardType()));
		}
		if (bean.getIssuerMember() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.issuerMember =:issuerMember");
			map.put("issuerMember",String.valueOf(bean.getIssuerMember()));
		}
		if (bean.getAcquirerMember() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.acquirerMember =:acquirerMember");
			map.put("acquirerMember",String.valueOf(bean.getAcquirerMember()));
		}
		if (bean.getIssuerBin() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.issuerBin =:issuerBin");
			map.put("issuerBin",String.valueOf(bean.getIssuerBin()));
		}
		if (bean.getAcquirerBin() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.acquirerBin =:acquirerBin");
			map.put("acquirerBin",String.valueOf(bean.getAcquirerBin()));
		}
		if (bean.getProcessStatus() != null && !bean.getProcessStatus().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.processStatus =:processStatus");
			map.put("processStatus",bean.getProcessStatus());
		}
		if (bean.getTransactionAmount() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.transactionAmount =:transactionAmount");
			map.put("transactionAmount",String.valueOf(bean.getTransactionAmount()));
		}
		if (bean.getCashbackPresent() != null && !bean.getCashbackPresent().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.cashbackPresent =:cashbackPresent");
			map.put("cashbackPresent",bean.getCashbackPresent());
		}
		if (bean.getCashbackAmount() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.cashbackAmount =:cashbackAmount");
			map.put("cashbackAmount",String.valueOf(bean.getCashbackAmount().longValue()));
		}
		if (bean.getTransactionTime() > 0L) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.transactionTime =:transactionTime");
			map.put("transactionTime",String.valueOf(bean.getTransactionTime()));
		}
		if (bean.getRecordStartByte() > 0L) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.recordStartByte =:recordStartByte");
			map.put("recordStartByte",String.valueOf(bean.getRecordStartByte()));
		}
		if (bean.getRecordEndByte() > 0L) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.recordEndByte =:recordEndByte");
			map.put("recordEndByte",String.valueOf(bean.getRecordEndByte()));
		}
		if (bean.getOutputFilename() != null && !bean.getOutputFilename().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.outputFilename =:outputFilename");
			map.put("outputFilename",bean.getOutputFilename());
		}
		if (bean.getFileRecordCnt() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.fileRecordCnt =:fileRecordCnt");
			map.put("fileRecordCnt",String.valueOf(bean.getFileRecordCnt()));
		}
		if (bean.getFleetProduct() != null && !bean.getFleetProduct().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.fleetProduct =:fleetProduct");
			map.put("fleetProduct",bean.getFleetProduct());
		}
		if (bean.getFleetSubProduct() != null && !bean.getFleetSubProduct().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.fleetSubProduct =:fleetSubProduct");
			map.put("fleetSubProduct",bean.getFleetSubProduct());

		}
		if (bean.getAccountNumber() != null && !bean.getAccountNumber().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.accountNumber =:accountNumber");
			map.put("accountNumber",bean.getAccountNumber());
		}
		if (bean.getBillingFee() > 0.0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.billingFee =:billingFee");
			map.put("billingFee",String.valueOf(bean.getBillingFee()));
		}
		if (bean.getBillingFeeAmount() > 0.0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.billingFeeAmount =:billingFeeAmount");
			map.put("billingFeeAmount",String.valueOf(bean.getBillingFeeAmount()));
		}
		if (bean.getBillingVat() > 0.0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.billingVat =:billingVat");
			map.put("billingVat",String.valueOf(bean.getBillingVat()));
		}
		if (bean.getCbBillFee() > 0.0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.cbBillFee =:cbBillFee");
			map.put("cbBillFee",String.valueOf(bean.getCbBillFee()));
		}
		if (bean.getCbBillFeeAmnt() > 0.0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.cbBillFeeAmnt =:cbBillFeeAmnt");
			map.put("cbBillFeeAmnt",String.valueOf(bean.getCbBillFeeAmnt()));
		}
		if (bean.getCbBillVat() > 0.0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.cbBillVat =:cbBillVat");
			map.put("cbBillVat",String.valueOf(bean.getCbBillVat()));
		}
		if (bean.getDestReport() != null && !bean.getDestReport().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.destReport =:destReport");
			map.put("destReport",bean.getDestReport());
		}
		if (bean.getFleetCountTran() != null && !bean.getFleetCountTran().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.fleetCountTran =:fleetCountTran");
			map.put("fleetCountTran",bean.getFleetCountTran());

		}
		if (bean.getMessageTypeInd() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.messageTypeInd =:messageTypeInd");
			map.put("messageTypeInd",String.valueOf(bean.getMessageTypeInd()));
		}
		if (bean.getMerchantCatCode() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.merchantCatCode =:merchantCatCode");
			map.put("merchantCatCode",String.valueOf(bean.getMerchantCatCode()));
		}
		if (bean.getIntchgRateDsgn() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.intchgRateDsgn =:intchgRateDsgn");
			map.put("intchgRateDsgn",String.valueOf(bean.getIntchgRateDsgn()));
		}
		if (bean.getMessageReasonCode() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.messageReasonCode =:messageReasonCode");
			map.put("messageReasonCode",String.valueOf(bean.getMessageReasonCode()));
		}
		if (bean.getOpfileNumSeq() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.opfileSeq =:opfileSeq");
			map.put("opfileSeq",String.valueOf(bean.getOpfileNumSeq()));
		}
		if (bean.getExtractInd() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.extractind =:extractind");
			map.put("extractind",bean.getExtractInd());
		}
		}
		if(!whereClause && select == false) {
			throw new DAOException( "Cannot Build where clause in CsoTransactions");
		}

		return buff.toString();
	}

	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CSOTransactionDTO bean) throws DAOException {
		try {

			CsoTransactions csoTransactions = new CsoTransactions();

			csoTransactions.setFileSystemSeqNumber(String.valueOf(bean.getFileSystemSeqNumber()));
			csoTransactions.setSystemSeqNumber(bean.getSystemSeqNumber());
			csoTransactions.setRecordStartByte((BigInteger.valueOf(bean.getRecordEndByte())));
			csoTransactions.setTransactionCode((short) bean.getTransactionCode());
			csoTransactions.setCardType((short) bean.getCardType());
			csoTransactions.setIssuerMember((short) bean.getIssuerMember());
			csoTransactions.setAcquirerMember((short) bean.getAcquirerMember());
			csoTransactions.setIssuerBin(bean.getIssuerBin());
			csoTransactions.setAcquirerBin(bean.getAcquirerBin());
			csoTransactions.setProcessStatus(bean.getProcessStatus());
			csoTransactions.setTransactionAmount(bean.getTransactionAmount()== 0 ? 0:bean.getTransactionAmount());
			csoTransactions.setCashbackPresent(bean.getCashbackPresent()== null ? "N": bean.getCashbackPresent());
			if(bean.getCashbackAmount() == null){
				csoTransactions.setCashbackAmount(BigDecimal.ZERO);
			}else{
				csoTransactions.setCashbackAmount(bean.getCashbackAmount());
			}
			csoTransactions.setTransactionTime(bean.getTransactionTime());
			csoTransactions.setRecordStartByte(BigInteger.valueOf(bean.getRecordStartByte()));
			csoTransactions.setRecordEndByte(BigInteger.valueOf(bean.getRecordEndByte()));
			csoTransactions.setOutputFilename(bean.getOutputFilename());
			csoTransactions.setFileRecordCnt( (short) bean.getFileRecordCnt());
			csoTransactions.setFleetProduct(bean.getFleetProduct());
			csoTransactions.setFleetSubProduct(bean.getFleetSubProduct());
			csoTransactions.setAccountNumber(bean.getAccountNumber());
			csoTransactions.setBillingFee(BigDecimal.valueOf(bean.getBillingFee()));
			csoTransactions.setBillingFeeAmount(BigDecimal.valueOf(bean.getBillingFeeAmount()));
			csoTransactions.setBillingVat(BigDecimal.valueOf(bean.getBillingVat()));
			csoTransactions.setCbBillFee(BigDecimal.valueOf(bean.getCbBillFee()));
			csoTransactions.setCbBillFeeAmnt(BigDecimal.valueOf(bean.getCbBillFeeAmnt()));
			csoTransactions.setCbBillVat(BigDecimal.valueOf(bean.getCbBillVat()));
			csoTransactions.setDestReport(bean.getDestReport());
			csoTransactions.setFleetCountTran(bean.getFleetCountTran() == null ? "N": bean.getFleetCountTran());
			csoTransactions.setMessageTypeInd((short) bean.getMessageTypeInd());
			csoTransactions.setMerchantCatCode((short) bean.getMerchantCatCode());
			csoTransactions.setIntchgRateDsgn((short) bean.getIntchgRateDsgn());
			csoTransactions.setMessageReasonCode( (short) bean.getMessageReasonCode());
			csoTransactions.setOpfileNumSeq(bean.getOpfileNumSeq());
			csoTransactions.setExtractind(bean.getExtractInd());
			csoTransactions.setRecordNumber(bean.getRecordNumber());
			csoTransactions.setRateDesc(bean.getRateDesc());

			csoTransactionsDao.update(csoTransactions);

		} catch (Exception ex) {
			ex.getMessage();
		} 
	}
	
	public void updateBilling(CSOTransactionDTO bean) throws DAOException {
		try {
			CsoTransactions csoTransactions = new CsoTransactions();
			
			csoTransactions.setFleetCountTran(bean.getFleetCountTran());
			csoTransactions.setProcessStatus(bean.getProcessStatus());
			csoTransactions.setTransactionAmount(bean.getTransactionAmount());
			csoTransactions.setCardType((short) bean.getCardType());
			csoTransactions.setCashbackPresent(bean.getCashbackPresent());
			csoTransactions.setCashbackAmount(bean.getCashbackAmount());
			csoTransactions.setFileRecordCnt( (short) bean.getFileRecordCnt());
			csoTransactions.setRecordNumber(bean.getRecordNumber());
			csoTransactions.setTransactionCode((short) bean.getTransactionCode());
			csoTransactions.setRecordStartByte(BigInteger.valueOf(bean.getRecordStartByte()));
			csoTransactions.setRecordEndByte(BigInteger.valueOf(bean.getRecordEndByte()));
			csoTransactions.setFileSystemSeqNumber(String.valueOf(bean.getFileSystemSeqNumber()));
			csoTransactions.setOpfileNumSeq(bean.getOpfileNumSeq());
			csoTransactions.setBillingFee(BigDecimal.valueOf(bean.getBillingFee()));
			csoTransactions.setBillingFeeAmount(BigDecimal.valueOf(bean.getBillingFeeAmount()));
			csoTransactions.setBillingVat(BigDecimal.valueOf(bean.getBillingVat()));
			csoTransactions.setCbBillFee(BigDecimal.valueOf(bean.getCbBillFee()));
			csoTransactions.setCbBillFeeAmnt(BigDecimal.valueOf(bean.getCbBillFeeAmnt()));
			csoTransactions.setCbBillVat(BigDecimal.valueOf(bean.getCbBillVat()));
			csoTransactions.setAcquirerBin(bean.getAcquirerBin());
			csoTransactions.setAcquirerMember((short)bean.getAcquirerMember());
			csoTransactions.setIssuerBin(bean.getIssuerBin());
			csoTransactions.setIssuerMember((short)bean.getIssuerMember());
			csoTransactions.setAccountNumber(bean.getAccountNumber());
			csoTransactions.setExtractind(bean.getExtractInd());
			csoTransactions.setRateDesc(bean.getRateDesc());
			
			csoTransactions.setSystemSeqNumber(bean.getSystemSeqNumber());
			
			csoTransactionsDao.update(csoTransactions);

		} catch (Exception ex) {
			ex.getMessage();
		} 
	}
	
	public void updateTransactions(CSOTransactionDTO bean) throws DAOException {
		try {

			//
			CsoTransactions csoTransactions = new CsoTransactions();
			//Optional parameter that must be set before update
			csoTransactions.setRecordStartByte((BigInteger.valueOf(bean.getRecordEndByte())));
			csoTransactions.setRecordEndByte(BigInteger.valueOf(bean.getRecordEndByte()));
			csoTransactions.setTransactionCode((short) bean.getTransactionCode());
			csoTransactions.setRecordNumber(bean.getRecordNumber());
			csoTransactions.setFileSystemSeqNumber(String.valueOf(bean.getFileSystemSeqNumber()));
			csoTransactions.setFileRecordCnt( (short) bean.getFileRecordCnt());
			csoTransactions.setCardType((short) bean.getCardType());
			
			csoTransactions.setFleetCountTran(bean.getFleetCountTran());
			csoTransactions.setTransactionAmount(bean.getTransactionAmount());
			csoTransactions.setCashbackPresent(bean.getCashbackPresent());
			csoTransactions.setCashbackAmount(bean.getCashbackAmount());
			csoTransactions.setProcessStatus(bean.getProcessStatus());
			csoTransactions.setOutputFilename(bean.getOutputFilename());
			csoTransactions.setSystemSeqNumber(bean.getSystemSeqNumber());
			csoTransactions.setRateDesc(bean.getRateDesc());

			csoTransactionsDao.update(csoTransactions);

		} catch (Exception ex) {
			ex.getMessage();
		} 
	}
	
	public void updateRejTxOutPut(CSOTransactionDTO bean) throws DAOException {
		try {
			
			//Optional that must be set 
			

			CsoTransactions csoTransactions = new CsoTransactions();			
			csoTransactions.setOutputFilename(bean.getOutputFilename());
			csoTransactions.setSystemSeqNumber(bean.getSystemSeqNumber());
			csoTransactionsDao.update(csoTransactions);

		} catch (Exception ex) {
			ex.getMessage();
		} 
	}
	public void delete() throws DAOException {
		//csoTransactionsDao.deleteBulk("Delete from CsoTransactions");
		csoTransactionsDao.deleteTruncate("TRUNCATE TABLE CSO_TRANSACTIONS");
	}
}
