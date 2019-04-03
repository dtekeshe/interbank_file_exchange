package com.bsva.dcms.commons.dao;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.bsva.dao.CsoInputFileControlsDao;
import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
import com.bsva.dcms.commons.enums.Status;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.util.DateUtil;
import com.bsva.entities.CsoInputFileControls;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsoInputFileControlsDAO{
	
	private Map<String,Object> map = new HashMap<String, Object>();

	//private CsoInputFileControlsRepository inputFileControlsDao = DaoFactory.csoInputFileControlInstance();
	private CsoInputFileControlsDao inputFileControlsDao = new CsoInputFileControlsDao();
	
	public CsoInputFileControlsDAO() {
	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public void create(CsoInputFileControlsDTO bean) throws DAOException {

		try {

			CsoInputFileControls csoInputFileControls = new CsoInputFileControls();

			csoInputFileControls.setFileRefNumber(bean.getFileRefNumber());
			csoInputFileControls.setOutputDate(bean.getOutputDate() == null ? null : new Date(bean.getOutputDate().getTime()));
			csoInputFileControls.setService(bean.getService());
			csoInputFileControls.setSubService(bean.getSubService());
			csoInputFileControls.setNumberOfRecs(bean.getNumberOfRecs());
			csoInputFileControls.setNumberCredits(bean.getNumberCredits());
			csoInputFileControls.setNumberDebits(bean.getNumberDebits());
			csoInputFileControls.setCreditValue(new BigDecimal(bean.getCreditValue()));
			csoInputFileControls.setDebitValue(new BigDecimal(bean.getDebitValue()));
			csoInputFileControls.setHashTotal(bean.getHashTotal());
			csoInputFileControls.setLastFileIndicator(bean.getLastFileIndicator());
			csoInputFileControls.setProcessStatus(bean.getProcessStatus());
			csoInputFileControls.setExtractedCount(bean.getExtractedCount());
			csoInputFileControls.setExtCredits(bean.getExtCredits());
			csoInputFileControls.setExtDebits(bean.getExtDebits());
			csoInputFileControls.setExtCreditValue(new BigDecimal(bean.getExtCreditValue()));
			csoInputFileControls.setExtDebitValue(new BigDecimal(bean.getExtDebitValue()));
			csoInputFileControls.setLastProcessDate(bean.getLastProcessDate() == null ? null : new Date(bean.getLastProcessDate().getTime()));
			csoInputFileControls.setNextOutputDate(bean.getNextOutputDate() == null ? null : new Date(bean.getNextOutputDate().getTime()));
			csoInputFileControls.setSettlementCount(bean.getSettlementCount());
			csoInputFileControls.setLoadDate(bean.getLoadDate() == null ? null : new Date(bean.getLoadDate().getTime()));
			csoInputFileControls.setOriginatingMember((short) bean.getOriginatingMember());
			csoInputFileControls.setNegativeCardCount(bean.getNegativeCardCount());
			csoInputFileControls.setNegativeDuplicateCount(bean.getNegativeDuplicateCount());
			csoInputFileControls.setLastCommitedRecordPointer(bean.getLastCommitedRecordPointer());
			csoInputFileControls.setExcepRepProducedInd(bean.getExcepRepProducedInd());
			csoInputFileControls.setErrorFilename(bean.getErrorFilename());
			// csoInputFileControls.setSystemSeqNumber(bean.getSystemSeqNumber());
			csoInputFileControls.setOdsDataStatus(bean.getOdsDataStatus());
			csoInputFileControls.setIsBilled(bean.getBilled());
			csoInputFileControls.setIsPreExtracted(bean.getPreExtracted());
			csoInputFileControls.setNumberOfRejects(bean.getNumberOfRejects());
			inputFileControlsDao.create(csoInputFileControls);
            bean.setSystemSeqNumber(csoInputFileControls.getSystemSeqNumber());

		} catch (Exception ex) {
			throw new DAOException("Error creating CsoInputFileControls, cause: "+ ex.getMessage(), ex);
		} 
	}
	
	public void delete(CsoInputFileControlsDTO bean) throws DAOException {

		try {

			CsoInputFileControls csoInputFileControls = new CsoInputFileControls();

			csoInputFileControls.setFileRefNumber(bean.getFileRefNumber());
			csoInputFileControls.setOutputDate(bean.getOutputDate() == null ? null : new Date(bean.getOutputDate().getTime()));
			csoInputFileControls.setService(bean.getService());
			csoInputFileControls.setSubService(bean.getSubService());
			csoInputFileControls.setNumberOfRecs(bean.getNumberOfRecs());
			csoInputFileControls.setNumberCredits(bean.getNumberCredits());
			csoInputFileControls.setNumberDebits(bean.getNumberDebits());
			csoInputFileControls.setCreditValue(new BigDecimal(bean.getCreditValue()));
			csoInputFileControls.setDebitValue(new BigDecimal(bean.getDebitValue()));
			csoInputFileControls.setHashTotal(bean.getHashTotal());
			csoInputFileControls.setLastFileIndicator(bean.getLastFileIndicator());
			csoInputFileControls.setProcessStatus(bean.getProcessStatus());
			csoInputFileControls.setExtractedCount(bean.getExtractedCount());
			csoInputFileControls.setExtCredits(bean.getExtCredits());
			csoInputFileControls.setExtDebits(bean.getExtDebits());
			csoInputFileControls.setExtCreditValue(new BigDecimal(bean.getExtCreditValue()));
			csoInputFileControls.setExtDebitValue(new BigDecimal(bean.getExtDebitValue()));
			csoInputFileControls.setLastProcessDate(bean.getLastProcessDate() == null ? null : new Date(bean.getLastProcessDate().getTime()));
			csoInputFileControls.setNextOutputDate(bean.getNextOutputDate() == null ? null : new Date(bean.getNextOutputDate().getTime()));
			csoInputFileControls.setSettlementCount(bean.getSettlementCount());
			csoInputFileControls.setLoadDate(bean.getLoadDate() == null ? null : new Date(bean.getLoadDate().getTime()));
			csoInputFileControls.setOriginatingMember((short) bean.getOriginatingMember());
			csoInputFileControls.setNegativeCardCount(bean.getNegativeCardCount());
			csoInputFileControls.setNegativeDuplicateCount(bean.getNegativeDuplicateCount());
			csoInputFileControls.setLastCommitedRecordPointer(bean.getLastCommitedRecordPointer());
			csoInputFileControls.setExcepRepProducedInd(bean.getExcepRepProducedInd());
			csoInputFileControls.setErrorFilename(bean.getErrorFilename());
			csoInputFileControls.setSystemSeqNumber(bean.getSystemSeqNumber());
			csoInputFileControls.setOdsDataStatus(bean.getOdsDataStatus());
			csoInputFileControls.setIsBilled(bean.getBilled());
			csoInputFileControls.setIsPreExtracted(bean.getPreExtracted());
			csoInputFileControls.setNumberOfRejects(bean.getNumberOfRejects());

			inputFileControlsDao.delete(csoInputFileControls);


		} catch (Exception ex) {
			throw new DAOException("Error creating CsoInputFileControlsDao, cause: "+ ex.getMessage(), ex);
		} 
	}
	
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsoInputFileControlsDTO retrieve(CsoInputFileControlsDTO bean) throws DAOException {
		CsoInputFileControlsDTO csoInputFileControlsDTO = null;

		try {
			String sql = "SELECT c FROM CsoInputFileControls c "+ this.buildWhereClause(bean, true);
			CsoInputFileControls inputFilesControls =  inputFileControlsDao.executeQueryParametersSingleDate(sql,map);

			if(inputFilesControls != null){
				csoInputFileControlsDTO = new CsoInputFileControlsDTO();
				if(inputFilesControls.getFileRefNumber()!=null){
					csoInputFileControlsDTO.setFileRefNumber(inputFilesControls.getFileRefNumber());
				}
				if(inputFilesControls.getOutputDate()!=null){
					csoInputFileControlsDTO.setOutputDate(inputFilesControls.getOutputDate());
				}
				if(inputFilesControls.getService()!=null){
					csoInputFileControlsDTO.setService(inputFilesControls.getService());
				}
				if(inputFilesControls.getSubService()!=null){
					csoInputFileControlsDTO.setSubService(inputFilesControls.getSubService());
				}
				if(inputFilesControls.getNumberOfRecs()!=null){
					csoInputFileControlsDTO.setNumberOfRecs(inputFilesControls.getNumberOfRecs().intValue());
				}
				if(inputFilesControls.getNumberCredits()!=null){
					csoInputFileControlsDTO.setNumberCredits(inputFilesControls.getNumberCredits().intValue());
				}
				if(inputFilesControls.getNumberDebits()!=null){
					csoInputFileControlsDTO.setNumberDebits(inputFilesControls.getNumberDebits().intValue());
				}
				if(inputFilesControls.getCreditValue()!=null){
					csoInputFileControlsDTO.setCreditValue(inputFilesControls.getCreditValue().doubleValue());
				}
				if(inputFilesControls.getDebitValue()!=null){
					csoInputFileControlsDTO.setDebitValue(inputFilesControls.getDebitValue().doubleValue());
				}
				if(inputFilesControls.getHashTotal()!=null){
					csoInputFileControlsDTO.setHashTotal(inputFilesControls.getHashTotal().longValue());
				}
				if(inputFilesControls.getLastFileIndicator()!=null){
					csoInputFileControlsDTO.setLastFileIndicator(inputFilesControls.getLastFileIndicator());
				}
				if(inputFilesControls.getProcessStatus()!=null){
					csoInputFileControlsDTO.setProcessStatus(inputFilesControls.getProcessStatus());
				}
				if(inputFilesControls.getExtractedCount()!=null){
					csoInputFileControlsDTO.setExtractedCount(inputFilesControls.getExtractedCount().intValue());
				}
				if(inputFilesControls.getExtCredits()!=null){
					csoInputFileControlsDTO.setExtCredits(inputFilesControls.getExtCredits().intValue());
				}
				if(inputFilesControls.getExtDebits()!=null){
					csoInputFileControlsDTO.setExtDebits(inputFilesControls.getExtDebits().intValue());
				}
				if(inputFilesControls.getExtCreditValue()!=null){
					csoInputFileControlsDTO.setExtCreditValue(inputFilesControls.getExtCreditValue().doubleValue());
				}
				if(inputFilesControls.getExtDebitValue()!=null){
					csoInputFileControlsDTO.setExtDebitValue(inputFilesControls.getExtDebitValue().doubleValue());
				}
				if(inputFilesControls.getLastProcessDate()!=null){
					csoInputFileControlsDTO.setLastProcessDate(inputFilesControls.getLastProcessDate());
				}
				if(inputFilesControls.getNextOutputDate()!=null){
					csoInputFileControlsDTO.setNextOutputDate(inputFilesControls.getNextOutputDate());
				}
				if(inputFilesControls.getSettlementCount()!=null){
					csoInputFileControlsDTO.setSettlementCount(inputFilesControls.getSettlementCount().intValue());
				}
				if(inputFilesControls.getLoadDate()!=null){
					csoInputFileControlsDTO.setLoadDate(inputFilesControls.getLoadDate());
				}
				if(inputFilesControls.getOriginatingMember()!=null){
					csoInputFileControlsDTO.setOriginatingMember(inputFilesControls.getOriginatingMember().intValue());
				}
				if(inputFilesControls.getNegativeCardCount()!=null){
					csoInputFileControlsDTO.setNegativeCardCount(inputFilesControls.getNegativeCardCount().intValue());
				}
				if(inputFilesControls.getNegativeDuplicateCount()!=null){
					csoInputFileControlsDTO.setNegativeDuplicateCount(inputFilesControls.getNegativeDuplicateCount().intValue());
				}
				if(inputFilesControls.getLastCommitedRecordPointer()!=null){
					csoInputFileControlsDTO.setLastCommitedRecordPointer(inputFilesControls.getLastCommitedRecordPointer().intValue());
				}
				if(inputFilesControls.getExcepRepProducedInd()!=null){
					csoInputFileControlsDTO.setExcepRepProducedInd(inputFilesControls.getExcepRepProducedInd());
				}
				if(inputFilesControls.getErrorFilename()!=null){
					csoInputFileControlsDTO.setErrorFilename(inputFilesControls.getErrorFilename());
				}
				if(inputFilesControls.getSystemSeqNumber()!=null){
					csoInputFileControlsDTO.setSystemSeqNumber(inputFilesControls.getSystemSeqNumber());
				}
				if(inputFilesControls.getOdsDataStatus()!=null){
					csoInputFileControlsDTO.setOdsDataStatus(inputFilesControls.getOdsDataStatus());		
				}
				if(inputFilesControls.getIsBilled()!=null){
					csoInputFileControlsDTO.setBilled(inputFilesControls.getIsBilled());		
				}
				if(inputFilesControls.getIsPreExtracted()!=null){
					csoInputFileControlsDTO.setPreExtracted(inputFilesControls.getIsPreExtracted());		
				}
				if(inputFilesControls.getNumberOfRejects()!=null){
					csoInputFileControlsDTO.setNumberOfRejects(inputFilesControls.getNumberOfRejects());		
				}
				
				
				
			}
			map.clear();
			return csoInputFileControlsDTO;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving .CsoInputFileControls, cause: "+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	@SuppressWarnings("unchecked")
	public List<CsoInputFileControlsDTO> retrieveRelated(CsoInputFileControlsDTO bean) throws DAOException {
		List<CsoInputFileControlsDTO> dtoList = new ArrayList<CsoInputFileControlsDTO>();
		CsoInputFileControlsDTO csoInputFileControlsDTO = null;

		try {
			String sql = "SELECT c FROM CsoInputFileControls c "+ this.buildWhereClause(bean, true);
			
			List<CsoInputFileControls> csoInputFileControls = inputFileControlsDao.executeQueryParametersDate(sql, map);
			for (CsoInputFileControls inputFilesControls : csoInputFileControls) {

				csoInputFileControlsDTO = new CsoInputFileControlsDTO();
				if(inputFilesControls.getFileRefNumber()!=null){
					csoInputFileControlsDTO.setFileRefNumber(inputFilesControls.getFileRefNumber());
				}
				if(inputFilesControls.getOutputDate()!=null){
					csoInputFileControlsDTO.setOutputDate(inputFilesControls.getOutputDate());
				}
				if(inputFilesControls.getService()!=null){
					csoInputFileControlsDTO.setService(inputFilesControls.getService());
				}
				if(inputFilesControls.getSubService()!=null){
					csoInputFileControlsDTO.setSubService(inputFilesControls.getSubService());
				}
				if(inputFilesControls.getNumberOfRecs()!=null){
					csoInputFileControlsDTO.setNumberOfRecs(inputFilesControls.getNumberOfRecs().intValue());
				}
				if(inputFilesControls.getNumberCredits()!=null){
					csoInputFileControlsDTO.setNumberCredits(inputFilesControls.getNumberCredits().intValue());
				}
				if(inputFilesControls.getNumberDebits()!=null){
					csoInputFileControlsDTO.setNumberDebits(inputFilesControls.getNumberDebits().intValue());
				}
				if(inputFilesControls.getCreditValue()!=null){
					csoInputFileControlsDTO.setCreditValue(inputFilesControls.getCreditValue().doubleValue());
				}
				if(inputFilesControls.getDebitValue()!=null){
					csoInputFileControlsDTO.setDebitValue(inputFilesControls.getDebitValue().doubleValue());
				}
				if(inputFilesControls.getHashTotal()!=null){
					csoInputFileControlsDTO.setHashTotal(inputFilesControls.getHashTotal().longValue());
				}
				if(inputFilesControls.getLastFileIndicator()!=null){
					csoInputFileControlsDTO.setLastFileIndicator(inputFilesControls.getLastFileIndicator());
				}
				if(inputFilesControls.getProcessStatus()!=null){
					csoInputFileControlsDTO.setProcessStatus(inputFilesControls.getProcessStatus());
				}
				if(inputFilesControls.getExtractedCount()!=null){
					csoInputFileControlsDTO.setExtractedCount(inputFilesControls.getExtractedCount().intValue());
				}
				if(inputFilesControls.getExtCredits()!=null){
					csoInputFileControlsDTO.setExtCredits(inputFilesControls.getExtCredits().intValue());
				}
				if(inputFilesControls.getExtDebits()!=null){
					csoInputFileControlsDTO.setExtDebits(inputFilesControls.getExtDebits().intValue());
				}
				if(inputFilesControls.getExtCreditValue()!=null){
					csoInputFileControlsDTO.setExtCreditValue(inputFilesControls.getExtCreditValue().doubleValue());
				}
				if(inputFilesControls.getExtDebitValue()!=null){
					csoInputFileControlsDTO.setExtDebitValue(inputFilesControls.getExtDebitValue().doubleValue());
				}
				if(inputFilesControls.getLastProcessDate()!=null){
					csoInputFileControlsDTO.setLastProcessDate(inputFilesControls.getLastProcessDate());
				}
				if(inputFilesControls.getNextOutputDate()!=null){
					csoInputFileControlsDTO.setNextOutputDate(inputFilesControls.getNextOutputDate());
				}
				if(inputFilesControls.getSettlementCount()!=null){
					csoInputFileControlsDTO.setSettlementCount(inputFilesControls.getSettlementCount().intValue());
				}
				if(inputFilesControls.getLoadDate()!=null){
					csoInputFileControlsDTO.setLoadDate(inputFilesControls.getLoadDate());
				}
				if(inputFilesControls.getOriginatingMember()!=null){
					csoInputFileControlsDTO.setOriginatingMember(inputFilesControls.getOriginatingMember().intValue());
				}
				if(inputFilesControls.getNegativeCardCount()!=null){
					csoInputFileControlsDTO.setNegativeCardCount(inputFilesControls.getNegativeCardCount().intValue());
				}
				if(inputFilesControls.getNegativeDuplicateCount()!=null){
					csoInputFileControlsDTO.setNegativeDuplicateCount(inputFilesControls.getNegativeDuplicateCount().intValue());
				}
				if(inputFilesControls.getLastCommitedRecordPointer()!=null){
					csoInputFileControlsDTO.setLastCommitedRecordPointer(inputFilesControls.getLastCommitedRecordPointer().intValue());
				}
				if(inputFilesControls.getExcepRepProducedInd()!=null){
					csoInputFileControlsDTO.setExcepRepProducedInd(inputFilesControls.getExcepRepProducedInd());
				}
				if(inputFilesControls.getErrorFilename()!=null){
					csoInputFileControlsDTO.setErrorFilename(inputFilesControls.getErrorFilename());
				}
				if(inputFilesControls.getSystemSeqNumber()!=null){
					csoInputFileControlsDTO.setSystemSeqNumber(inputFilesControls.getSystemSeqNumber());
				}
				if(inputFilesControls.getOdsDataStatus()!=null){
					csoInputFileControlsDTO.setOdsDataStatus(inputFilesControls.getOdsDataStatus());		
				}
				if(inputFilesControls.getIsBilled()!=null){
					csoInputFileControlsDTO.setBilled(inputFilesControls.getIsBilled());		
				}
				if(inputFilesControls.getIsPreExtracted()!=null){
					csoInputFileControlsDTO.setPreExtracted(inputFilesControls.getIsPreExtracted());		
				}
				if(inputFilesControls.getNumberOfRejects()!=null){
					csoInputFileControlsDTO.setNumberOfRejects(inputFilesControls.getNumberOfRejects());		
				}
				
				dtoList.add(csoInputFileControlsDTO);

			}
			map.clear();
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CsoInputFileControls, cause: "+ ex.getMessage());
		} 
	}
	
	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 *//*

	@SuppressWarnings("unchecked")
	public List<CsoInputFileControlsDTO> retrieveRelatedSQLQuery() throws DAOException {
		List<CsoInputFileControlsDTO> dtoList = new ArrayList<CsoInputFileControlsDTO>();
		CsoInputFileControlsDTO csoInputFileControlsDTO = null;
		
		List<String> listString = new ArrayList<String>();
		listString.add("A");
		listString.add("H");
        Set<String> params = new HashSet<String>();
        params.addAll(listString);      
		
		try {
			String sql = " select c from CsoInputFileControls c  where c.processStatus in(:"+params+")";
			
			List<CsoInputFileControls> csoInputFileControls = (List<CsoInputFileControls>) inputFileControlsDao.executeQueryParametersSingleDate(sql,map);
			for (CsoInputFileControls inputFilesControls : csoInputFileControls) {

				csoInputFileControlsDTO = new CsoInputFileControlsDTO();
				if(inputFilesControls.getFileRefNumber()!=null){
					csoInputFileControlsDTO.setFileRefNumber(inputFilesControls.getFileRefNumber());
				}
				if(inputFilesControls.getOutputDate()!=null){
					csoInputFileControlsDTO.setOutputDate(inputFilesControls.getOutputDate());
				}
				if(inputFilesControls.getService()!=null){
					csoInputFileControlsDTO.setService(inputFilesControls.getService());
				}
				if(inputFilesControls.getSubService()!=null){
					csoInputFileControlsDTO.setSubService(inputFilesControls.getSubService());
				}
				if(inputFilesControls.getNumberOfRecs()!=null){
					csoInputFileControlsDTO.setNumberOfRecs(inputFilesControls.getNumberOfRecs().intValue());
				}
				if(inputFilesControls.getNumberCredits()!=null){
					csoInputFileControlsDTO.setNumberCredits(inputFilesControls.getNumberCredits().intValue());
				}
				if(inputFilesControls.getNumberDebits()!=null){
					csoInputFileControlsDTO.setNumberDebits(inputFilesControls.getNumberDebits().intValue());
				}
				if(inputFilesControls.getCreditValue()!=null){
					csoInputFileControlsDTO.setCreditValue(inputFilesControls.getCreditValue().doubleValue());
				}
				if(inputFilesControls.getDebitValue()!=null){
					csoInputFileControlsDTO.setDebitValue(inputFilesControls.getDebitValue().doubleValue());
				}
				if(inputFilesControls.getHashTotal()!=null){
					csoInputFileControlsDTO.setHashTotal(inputFilesControls.getHashTotal().longValue());
				}
				if(inputFilesControls.getLastFileIndicator()!=null){
					csoInputFileControlsDTO.setLastFileIndicator(inputFilesControls.getLastFileIndicator());
				}
				if(inputFilesControls.getProcessStatus()!=null){
					csoInputFileControlsDTO.setProcessStatus(inputFilesControls.getProcessStatus());
				}
				if(inputFilesControls.getExtractedCount()!=null){
					csoInputFileControlsDTO.setExtractedCount(inputFilesControls.getExtractedCount().intValue());
				}
				if(inputFilesControls.getExtCredits()!=null){
					csoInputFileControlsDTO.setExtCredits(inputFilesControls.getExtCredits().intValue());
				}
				if(inputFilesControls.getExtDebits()!=null){
					csoInputFileControlsDTO.setExtDebits(inputFilesControls.getExtDebits().intValue());
				}
				if(inputFilesControls.getExtCreditValue()!=null){
					csoInputFileControlsDTO.setExtCreditValue(inputFilesControls.getExtCreditValue().doubleValue());
				}
				if(inputFilesControls.getExtDebitValue()!=null){
					csoInputFileControlsDTO.setExtDebitValue(inputFilesControls.getExtDebitValue().doubleValue());
				}
				if(inputFilesControls.getLastProcessDate()!=null){
					csoInputFileControlsDTO.setLastProcessDate(inputFilesControls.getLastProcessDate());
				}
				if(inputFilesControls.getNextOutputDate()!=null){
					csoInputFileControlsDTO.setNextOutputDate(inputFilesControls.getNextOutputDate());
				}
				if(inputFilesControls.getSettlementCount()!=null){
					csoInputFileControlsDTO.setSettlementCount(inputFilesControls.getSettlementCount().intValue());
				}
				if(inputFilesControls.getLoadDate()!=null){
					csoInputFileControlsDTO.setLoadDate(inputFilesControls.getLoadDate());
				}
				if(inputFilesControls.getOriginatingMember()!=null){
					csoInputFileControlsDTO.setOriginatingMember(inputFilesControls.getOriginatingMember().intValue());
				}
				if(inputFilesControls.getNegativeCardCount()!=null){
					csoInputFileControlsDTO.setNegativeCardCount(inputFilesControls.getNegativeCardCount().intValue());
				}
				if(inputFilesControls.getNegativeDuplicateCount()!=null){
					csoInputFileControlsDTO.setNegativeDuplicateCount(inputFilesControls.getNegativeDuplicateCount().intValue());
				}
				if(inputFilesControls.getLastCommitedRecordPointer()!=null){
					csoInputFileControlsDTO.setLastCommitedRecordPointer(inputFilesControls.getLastCommitedRecordPointer().intValue());
				}
				if(inputFilesControls.getExcepRepProducedInd()!=null){
					csoInputFileControlsDTO.setExcepRepProducedInd(inputFilesControls.getExcepRepProducedInd());
				}
				if(inputFilesControls.getErrorFilename()!=null){
					csoInputFileControlsDTO.setErrorFilename(inputFilesControls.getErrorFilename());
				}
				if(inputFilesControls.getSystemSeqNumber()!=null){
					csoInputFileControlsDTO.setSystemSeqNumber(inputFilesControls.getSystemSeqNumber());
				}
				if(inputFilesControls.getOdsDataStatus()!=null){
					csoInputFileControlsDTO.setOdsDataStatus(inputFilesControls.getOdsDataStatus());		
				}
				if(inputFilesControls.getIsBilled()!=null){
					csoInputFileControlsDTO.setBilled(inputFilesControls.getIsBilled());		
				}
				if(inputFilesControls.getIsPreExtracted()!=null){
					csoInputFileControlsDTO.setPreExtracted(inputFilesControls.getIsPreExtracted());		
				}
				
				dtoList.add(csoInputFileControlsDTO);

			}
			map.clear();
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CsoInputFileControls, cause: "+ ex.getMessage());
		} 
	}
*/
	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */
	public void updateFileExtract(CsoInputFileControlsDTO bean) throws DAOException {
		try{
			CsoInputFileControls csoInputFileControls = new CsoInputFileControls();
			csoInputFileControls.setSystemSeqNumber(bean.getSystemSeqNumber());
			csoInputFileControls.setOdsDataStatus(bean.getOdsDataStatus());
			csoInputFileControls.setFileRefNumber(bean.getFileRefNumber());
			csoInputFileControls.setOdsDataStatus(bean.getOdsDataStatus());
			csoInputFileControls.setFileRefNumber(bean.getFileRefNumber());
			csoInputFileControls.setProcessStatus(bean.getProcessStatus());
			inputFileControlsDao.update(csoInputFileControls);

		} catch (Exception ex) {
			throw new DAOException("Error updating CsoInputFileControls, cause: "
					+ ex.getMessage(), ex);
		}
	}

	public void update(CsoInputFileControlsDTO bean) throws DAOException {
		try {
			
		CsoInputFileControls csoInputFileControls = new CsoInputFileControls();
		if(bean.getFileRefNumber()!=null){
		csoInputFileControls.setFileRefNumber(bean.getFileRefNumber());
		}
		if(bean.getOutputDate()!=null){
		csoInputFileControls.setOutputDate(bean.getOutputDate() == null ? null : new Date(bean.getOutputDate().getTime()));
		}
		if(bean.getSubService()!=null){
		csoInputFileControls.setService(bean.getService());
		}
		if(bean.getSubService()!=null){
		csoInputFileControls.setSubService(bean.getSubService());
		}
		if(bean.getNumberOfRecs() != 0){
		csoInputFileControls.setNumberOfRecs(bean.getNumberOfRecs());
		}
		if(bean.getNumberCredits()!= 0){
		csoInputFileControls.setNumberCredits(bean.getNumberCredits());
		}
		if(bean.getNumberDebits()!= 0){
		csoInputFileControls.setNumberDebits(bean.getNumberDebits());
		}
		if(bean.getCreditValue()!= 0){
		csoInputFileControls.setCreditValue(new BigDecimal(bean.getCreditValue()));
		}
		if(bean.getDebitValue() != 0){
		csoInputFileControls.setDebitValue(new BigDecimal(bean.getDebitValue()));
		}
		if(bean.getHashTotal()!= 0){
		csoInputFileControls.setHashTotal(bean.getHashTotal());
		}
		if(bean.getLastFileIndicator()!=null){
		csoInputFileControls.setLastFileIndicator(bean.getLastFileIndicator());
		}
		if(bean.getProcessStatus()!=null){
		csoInputFileControls.setProcessStatus(bean.getProcessStatus());
		}
		if(bean.getExtractedCount() != 0){
		csoInputFileControls.setExtractedCount(bean.getExtractedCount());
		}
		if(bean.getExtCredits() != 0){
		csoInputFileControls.setExtCredits(bean.getExtCredits());
		}
		if(bean.getExtDebits() != 0){
		csoInputFileControls.setExtDebits(bean.getExtDebits());
		}
		if(bean.getExtCreditValue() != 0){
		csoInputFileControls.setExtCreditValue(new BigDecimal(bean.getExtCreditValue()));
		}
		if(bean.getExtDebitValue() != 0){
		csoInputFileControls.setExtDebitValue(new BigDecimal(bean.getExtDebitValue()));
		}
		if(bean.getLastProcessDate()!=null){
		csoInputFileControls.setLastProcessDate(bean.getLastProcessDate() == null ? null : new Date(bean.getLastProcessDate().getTime()));
		}
		if(bean.getNextOutputDate()!=null){
		csoInputFileControls.setNextOutputDate(bean.getNextOutputDate() == null ? null : new Date(bean.getNextOutputDate().getTime()));
		}
		if(bean.getSettlementCount() != 0){
		csoInputFileControls.setSettlementCount(bean.getSettlementCount());
		}
		if(bean.getLoadDate()!=null){
		csoInputFileControls.setLoadDate(bean.getLoadDate() == null ? null : new Date(bean.getLoadDate().getTime()));
		}
		if(bean.getOriginatingMember() != 0){
		csoInputFileControls.setOriginatingMember((short) bean.getOriginatingMember());
		}
		if(bean.getNegativeCardCount() != 0){
		csoInputFileControls.setNegativeCardCount(bean.getNegativeCardCount());
		}
		if(bean.getNegativeDuplicateCount() != 0){
		csoInputFileControls.setNegativeDuplicateCount(bean.getNegativeDuplicateCount());
		}
		if(bean.getLastCommitedRecordPointer() != 0){
		csoInputFileControls.setLastCommitedRecordPointer(bean.getLastCommitedRecordPointer());
		}
		if(bean.getExcepRepProducedInd()!=null){
		csoInputFileControls.setExcepRepProducedInd(bean.getExcepRepProducedInd());
		}
		if(bean.getErrorFilename()!=null){
		csoInputFileControls.setErrorFilename(bean.getErrorFilename());
		}
		if(bean.getSystemSeqNumber()!= 0){
		csoInputFileControls.setSystemSeqNumber(bean.getSystemSeqNumber());
		}
		if(bean.getOdsDataStatus()!=null){
		csoInputFileControls.setOdsDataStatus(bean.getOdsDataStatus());
		}
		if(bean.getPreExtracted()!=null){
		csoInputFileControls.setIsPreExtracted(bean.getPreExtracted());
		}
		if(bean.getBilled()!=null){
		csoInputFileControls.setIsBilled(bean.getBilled());
		}

		inputFileControlsDao.update(csoInputFileControls);

		} catch (Exception ex) {
			throw new DAOException("Error updating CsoInputFileControls, cause: "
					+ ex.getMessage(), ex);
		}
	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	public void deleteByProcessStatus(CsoInputFileControlsDTO bean) throws DAOException {

		CsoInputFileControls csoInputFileControls = new CsoInputFileControls();

		csoInputFileControls.setFileRefNumber(bean.getFileRefNumber());
		csoInputFileControls.setOutputDate(bean.getOutputDate() == null ? null : new Date(bean.getOutputDate().getTime()));
		csoInputFileControls.setService(bean.getService());
		csoInputFileControls.setSubService(bean.getSubService());
		csoInputFileControls.setNumberOfRecs(bean.getNumberOfRecs());
		csoInputFileControls.setNumberDebits(bean.getNumberCredits());
		csoInputFileControls.setNumberDebits(bean.getNumberDebits());
		csoInputFileControls.setCreditValue(new BigDecimal(bean.getCreditValue()));
		csoInputFileControls.setDebitValue(new BigDecimal(bean.getDebitValue()));
		csoInputFileControls.setHashTotal(bean.getHashTotal());
		csoInputFileControls.setLastFileIndicator(bean.getLastFileIndicator());
		csoInputFileControls.setProcessStatus(bean.getProcessStatus());
		csoInputFileControls.setExtractedCount(bean.getExtractedCount());
		csoInputFileControls.setExtCredits(bean.getExtCredits());
		csoInputFileControls.setExtDebits(bean.getExtDebits());
		csoInputFileControls.setExtCreditValue(new BigDecimal(bean.getExtCreditValue()));
		csoInputFileControls.setExtDebitValue(new BigDecimal(bean.getExtDebitValue()));
		csoInputFileControls.setLastProcessDate(bean.getLastProcessDate() == null ? null : new Date(bean.getLastProcessDate().getTime()));
		csoInputFileControls.setNextOutputDate(bean.getNextOutputDate() == null ? null : new Date(bean.getNextOutputDate().getTime()));
		csoInputFileControls.setSettlementCount(bean.getSettlementCount());
		csoInputFileControls.setLoadDate(bean.getLoadDate() == null ? null : new Date(bean.getLoadDate().getTime()));
		csoInputFileControls.setOriginatingMember((short) bean.getOriginatingMember());
		csoInputFileControls.setNegativeCardCount(bean.getNegativeCardCount());
		csoInputFileControls.setNegativeDuplicateCount(bean.getNegativeDuplicateCount());
		csoInputFileControls.setLastCommitedRecordPointer(bean.getLastCommitedRecordPointer());
		csoInputFileControls.setExcepRepProducedInd(bean.getExcepRepProducedInd());
		csoInputFileControls.setErrorFilename(bean.getErrorFilename());
		csoInputFileControls.setSystemSeqNumber(bean.getSystemSeqNumber());
		csoInputFileControls.setOdsDataStatus(bean.getOdsDataStatus());
		csoInputFileControls.setIsBilled(bean.getBilled());
		csoInputFileControls.setIsPreExtracted(bean.getPreExtracted());
		csoInputFileControls.setNumberOfRejects(bean.getNumberOfRejects());
		inputFileControlsDao.delete(csoInputFileControls);

	}

	public void delete(String deletequery) throws DAOException {
		
		try {
			inputFileControlsDao.deleteBulk(deletequery);
		} catch (Exception ex) {
			throw new DAOException("Error deleting bulk CsoInputFileControls, cause: "
					+ ex.getMessage(), ex);
		} 

	}

	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @throws ParseException 
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsoInputFileControlsDTO bean, boolean select ) throws DAOException, ParseException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		
		if (select == true) {

		if (bean.getFileRefNumber() != null && !bean.getFileRefNumber().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.fileRefNumber = :fileRefNumber"); 
			map.put("fileRefNumber",bean.getFileRefNumber());
		}
		if (bean.getService() != null && !bean.getService().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.service = :service");
			map.put("service",bean.getService());
		}
		if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.subService =:subService");
			map.put("subService",bean.getSubService());
		}
		if (bean.getSystemSeqNumber() > 0L) {
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
		
			if (bean.getOutputDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				buff.append("c.outputDate = :outputDate");
				map.put("outputDate",bean.getOutputDate());
			}
			if (bean.getNumberOfRecs() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.numberOfRecs = :numberOfRecs");
				map.put("numberOfRecs",String.valueOf(bean.getNumberOfRecs()));
			}
			if (bean.getNumberCredits() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.numberCredits = :numberCredits");
				map.put("numberCredits",String.valueOf(bean.getNumberCredits()));
			}
			if (bean.getNumberDebits() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.numberDebits = :numberDebits");
				map.put("numberDebits",String.valueOf(bean.getNumberDebits()));
			}
			if (bean.getCreditValue() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.creditValue = :creditValue");
				map.put("creditValue",String.valueOf(bean.getCreditValue()));
			}
			if (bean.getDebitValue() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.debitValue = :debitValue");
				map.put("debitValue",String.valueOf(bean.getDebitValue()));
			}
			if (bean.getHashTotal() > 0L) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.hashTotal = :hashTotal");
				map.put("hashTotal",String.valueOf(bean.getHashTotal()));
			}
			if (bean.getLastFileIndicator() != null && !bean.getLastFileIndicator().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.lastFileIndicator = :lastFileIndicator");
				map.put("lastFileIndicator",bean.getLastFileIndicator());
			}
			if (bean.getProcessStatus() != null && !bean.getProcessStatus().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.processStatus = :processStatus");
				map.put("processStatus",bean.getProcessStatus());
			}
			if (bean.getExtractedCount() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.extractedCount = :extractedCount");
				map.put("extractedCount",String.valueOf(bean.getExtractedCount()));
			}
			if (bean.getExtCredits() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.extCredits = :extCredits");
				map.put("extCredits",String.valueOf(bean.getExtCredits()));
			}
			if (bean.getExtDebits() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.extDebits = :extDebits");
				map.put("extDebits",String.valueOf(bean.getExtDebits()));
			}
			if (bean.getExtCreditValue() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.extCreditValue = :extCreditValue");
				map.put("extCreditValue",String.valueOf(bean.getExtCreditValue()));
			}
			if (bean.getExtDebitValue() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.extDebitValue = :extDebitValue");
				map.put("extDebitValue",String.valueOf(bean.getExtDebitValue()));
			}
			if (bean.getLastProcessDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.lastProcessDate = :lastProcessDate");
				map.put("lastProcessDate",String.valueOf(bean.getLastProcessDate()));
			}
			if (bean.getNextOutputDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.nextOutputDate = :nextOutputDate");
				map.put("nextOutputDate",String.valueOf(bean.getNextOutputDate()));
			}
			if (bean.getSettlementCount() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.settlementCount = :settlementCount");
				map.put("settlementCount",String.valueOf(bean.getSettlementCount()));
			}
			if (bean.getLoadDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.loadDate = :loadDate");
				map.put("loadDate",String.valueOf(bean.getLoadDate()));
			}
			if (bean.getOriginatingMember() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.originatingMember = :originatingMember");
				map.put("originatingMember",String.valueOf(bean.getOriginatingMember()));
			}
			if (bean.getNegativeCardCount() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.negativeCardCount = :negativeCardCount");
				map.put("negativeCardCount",String.valueOf(bean.getNegativeCardCount()));
			}
			if (bean.getNegativeDuplicateCount() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.negativeDuplicateCount = :negativeDuplicateCount");
				map.put("negativeDuplicateCount",String.valueOf(bean.getNegativeDuplicateCount()));
			}
			if (bean.getLastCommitedRecordPointer() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.lastCommitedRecordPointer = :lastCommitedRecordPointer");
				map.put("lastCommitedRecordPointer",String.valueOf(bean.getLastCommitedRecordPointer()));
			}
			if (bean.getExcepRepProducedInd() != null && !bean.getExcepRepProducedInd().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.excepRepProducedInd = :excepRepProducedInd");
				map.put("excepRepProducedInd",bean.getExcepRepProducedInd());
			}
			if (bean.getErrorFilename() != null && !bean.getErrorFilename().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.errorFilename = :errorFilename");
				map.put("errorFilename",bean.getErrorFilename());
			}
			if (bean.getOdsDataStatus() != null && !bean.getOdsDataStatus().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.odsDataStatus = :odsDataStatus");
				map.put("odsDataStatus",bean.getOdsDataStatus());
			}
			/*private boolean isPreExtracted;
				private boolean isBilled;
			 * */
			if (bean.getBilled() != null && !bean.getBilled().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.isBilled = :isBilled");
				map.put("isBilled",bean.getBilled());
			}
			if (bean.getPreExtracted() != null && !bean.getPreExtracted().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.isPreExtracted = :isPreExtracted");
				map.put("isPreExtracted",bean.getPreExtracted());
			}
			if (bean.getNumberOfRejects() != null && !bean.getNumberOfRejects().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.numberOfRejects = :numberOfRejects");
				map.put("numberOfRejects",bean.getNumberOfRejects());
			}
		}
		buff.append(" ORDER BY  OUTPUT_DATE ASC ,FILE_REF_NUMBER ASC  ");
		if(!whereClause && select == false) {
			throw new DAOException("Cannot Build all rows in CCCOWNER.CSO_INPUT_FILE_CONTROLS");
		}
		return buff.toString();
	}


	public List<CsoInputFileControlsDTO> retrieveFilesWithRejTxns(CsoInputFileControlsDTO bean , String transactionStatus) throws DAOException {

		try {
			String sql  = "SELECT * FROM CsoInputFileControls a WHERE a.PROCESS_STATUS = ? AND  "
					+ "a.SUB_SERVICE = ? AND a.SYSTEM_SEQ_NUMBER NOT IN"
					+ "(SELECT DISTINCT(b.FILE_SYSTEM_SEQ_NUMBER) FROM CsoTransactions b WHERE b.PROCESS_STATUS = ?)";
			//:TODO
			/*ps = conn.prepareStatement(SQL_SELECT);
			ps.setString(pos++, bean.getProcessStatus());
			ps.setString(pos++, bean.getSubService());
			ps.setString(pos++, transactionStatus);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<CsoInputFileControlsDTO>) results;
			} else {
				return null;
			}*/
			return (List<CsoInputFileControlsDTO>) bean;

		} catch (Exception ex) {
			throw new DAOException("Error retrieveByTransactionStatus CsoInputFileControls, cause: "
					+ ex.getMessage(), ex);
		} 
	}

	public List<CsoInputFileControlsDTO> retrieveRelatedFiles(String filenameStart) throws DAOException {
		List<CsoInputFileControlsDTO> dtoList = new ArrayList<CsoInputFileControlsDTO>();
		CsoInputFileControlsDTO csoInputFileControlsDTO = null;

		try {
			String sql = "SELECT c FROM CsoInputFileControls c ";//+ this.buildWhereClause(bean, true);
			
			//List<CsoInputFileControls> csoInputFileControls = inputFileControlsDao.executeNamedQuery("findByfileRefNumber", CsoInputFileControls.class);
			List<CsoInputFileControls> csoInputFileControls = inputFileControlsDao.executeQueryParameters(sql, map);
			for (CsoInputFileControls inputFilesControls : csoInputFileControls) {

				csoInputFileControlsDTO = new CsoInputFileControlsDTO();
				if(inputFilesControls.getFileRefNumber()!=null){
					csoInputFileControlsDTO.setFileRefNumber(inputFilesControls.getFileRefNumber());
				}
				if(inputFilesControls.getOutputDate()!=null){
					csoInputFileControlsDTO.setOutputDate(new Date(inputFilesControls.getOutputDate().toString()));
				}
				if(inputFilesControls.getService()!=null){
					csoInputFileControlsDTO.setService(inputFilesControls.getService());
				}
				if(inputFilesControls.getSubService()!=null){
					csoInputFileControlsDTO.setSubService(inputFilesControls.getSubService());
				}
				if(inputFilesControls.getNumberOfRecs()!=null){
					csoInputFileControlsDTO.setNumberOfRecs(inputFilesControls.getNumberOfRecs().intValue());
				}
				if(inputFilesControls.getNumberCredits()!=null){
					csoInputFileControlsDTO.setNumberCredits(inputFilesControls.getNumberCredits().intValue());
				}
				if(inputFilesControls.getNumberDebits()!=null){
					csoInputFileControlsDTO.setNumberDebits(inputFilesControls.getNumberDebits().intValue());
				}
				if(inputFilesControls.getCreditValue()!=null){
					csoInputFileControlsDTO.setCreditValue(inputFilesControls.getCreditValue().doubleValue());
				}
				if(inputFilesControls.getDebitValue()!=null){
					csoInputFileControlsDTO.setDebitValue(inputFilesControls.getDebitValue().doubleValue());
				}
				if(inputFilesControls.getHashTotal()!=null){
					csoInputFileControlsDTO.setHashTotal(inputFilesControls.getHashTotal().longValue());
				}
				if(inputFilesControls.getLastFileIndicator()!=null){
					csoInputFileControlsDTO.setLastFileIndicator(inputFilesControls.getLastFileIndicator());
				}
				if(inputFilesControls.getProcessStatus()!=null){
					csoInputFileControlsDTO.setProcessStatus(inputFilesControls.getProcessStatus());
				}
				if(inputFilesControls.getExtractedCount()!=null){
					csoInputFileControlsDTO.setExtractedCount(inputFilesControls.getExtractedCount().intValue());
				}
				if(inputFilesControls.getExtCredits()!=null){
					csoInputFileControlsDTO.setExtCredits(inputFilesControls.getExtCredits().intValue());
				}
				if(inputFilesControls.getExtDebits()!=null){
					csoInputFileControlsDTO.setExtDebits(inputFilesControls.getExtDebits().intValue());
				}
				if(inputFilesControls.getExtCreditValue()!=null){
					csoInputFileControlsDTO.setExtCreditValue(inputFilesControls.getExtCreditValue().doubleValue());
				}
				if(inputFilesControls.getExtDebitValue()!=null){
					csoInputFileControlsDTO.setExtDebitValue(inputFilesControls.getExtDebitValue().doubleValue());
				}
				if(inputFilesControls.getLastProcessDate()!=null){
					csoInputFileControlsDTO.setLastProcessDate(inputFilesControls.getLastProcessDate());
				}
				if(inputFilesControls.getNextOutputDate()!=null){
					csoInputFileControlsDTO.setNextOutputDate(inputFilesControls.getNextOutputDate());
				}
				if(inputFilesControls.getSettlementCount()!=null){
					csoInputFileControlsDTO.setSettlementCount(inputFilesControls.getSettlementCount().intValue());
				}
				if(inputFilesControls.getLoadDate()!=null){
					csoInputFileControlsDTO.setLoadDate(inputFilesControls.getLoadDate());
				}
				if(inputFilesControls.getOriginatingMember()!=null){
					csoInputFileControlsDTO.setOriginatingMember(inputFilesControls.getOriginatingMember().intValue());
				}
				if(inputFilesControls.getNegativeCardCount()!=null){
					csoInputFileControlsDTO.setNegativeCardCount(inputFilesControls.getNegativeCardCount().intValue());
				}
				if(inputFilesControls.getNegativeDuplicateCount()!=null){
					csoInputFileControlsDTO.setNegativeDuplicateCount(inputFilesControls.getNegativeDuplicateCount().intValue());
				}
				if(inputFilesControls.getLastCommitedRecordPointer()!=null){
					csoInputFileControlsDTO.setLastCommitedRecordPointer(inputFilesControls.getLastCommitedRecordPointer().intValue());
				}
				if(inputFilesControls.getExcepRepProducedInd()!=null){
					csoInputFileControlsDTO.setExcepRepProducedInd(inputFilesControls.getExcepRepProducedInd());
				}
				if(inputFilesControls.getErrorFilename()!=null){
					csoInputFileControlsDTO.setErrorFilename(inputFilesControls.getErrorFilename());
				}
				if(inputFilesControls.getSystemSeqNumber()!=null){
					csoInputFileControlsDTO.setSystemSeqNumber(inputFilesControls.getSystemSeqNumber());
				}
				if(inputFilesControls.getOdsDataStatus()!=null){
					csoInputFileControlsDTO.setOdsDataStatus(inputFilesControls.getOdsDataStatus());		
				}
				if(inputFilesControls.getIsBilled()!=null){
					csoInputFileControlsDTO.setBilled(inputFilesControls.getIsBilled());		
				}
				if(inputFilesControls.getIsPreExtracted()!=null){
					csoInputFileControlsDTO.setPreExtracted(inputFilesControls.getIsPreExtracted());		
				}
				dtoList.add(csoInputFileControlsDTO);

			}

			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CsoInputFileControls, cause: "+ ex.getMessage());
		} 

	}
	public void delete() throws DAOException {
		inputFileControlsDao.deleteBulk("Delete from CsoInputFileControls where PROCESS_STATUS in ('A','C','H')");
	}
}