package com.bsva.dcms.commons.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsoOutputControlsDao;
import com.bsva.dcms.commons.dto.CSFBinsDTO;
import com.bsva.dcms.commons.dto.CsoOutputControlsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfBins;
import com.bsva.entities.CsoOutputControls;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsoOutputControlsDAO{

	//private CsoOutputControlsRepository csoOutputControlsDao = DaoFactory.csoOutputControlsInstance();
	private CsoOutputControlsDao csoOutputControlsDao = new CsoOutputControlsDao();
	private Map<String,Object>map = new HashMap<String, Object>();

	public CsoOutputControlsDAO() {

	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public void create(CsoOutputControlsDTO bean) throws DAOException {

		try {

			CsoOutputControls csoOutputControls = new CsoOutputControls();

			csoOutputControls.setBankCode(String.valueOf(bean.getBankCode()));
			csoOutputControls.setService(bean.getService());
			csoOutputControls.setSubService(bean.getSubService());
			csoOutputControls.setFilenamePrefix(bean.getFilenamePrefix());
			csoOutputControls.setDistributionCode(bean.getDistributionCode());
			csoOutputControls.setSeqNumber(bean.getSeqNumber());
			csoOutputControls.setStatusCode(bean.getStatusCode());
			csoOutputControls.setFilenameDescription(bean.getFilenameDescription());
			//csoOutputControls.setTransmissionDate(new Date(bean.getTransmissionDate().getTime()));
			csoOutputControls.setLastFileIndicator(bean.getLastFileIndicator());
			csoOutputControls.setCrVolume(bean.getCrVolume());
			csoOutputControls.setCrValue(new BigDecimal(bean.getCrValue()));
			csoOutputControls.setDrVolume(bean.getDrVolume());
			csoOutputControls.setDrValue(new BigDecimal(bean.getDrValue()));
			csoOutputControls.setRecordCount(bean.getRecordCount());
			csoOutputControls.setHashTotal98(bean.getHashTotal98());
			csoOutputControls.setHashTotal99(bean.getHashTotal99());
			csoOutputControls.setOriginatingBankId(bean.getOriginatingBankId());
			csoOutputControls.setOriginatingMember(String.valueOf(bean.getOriginatingMember()));
			csoOutputControls.setNegCardCount(bean.getNegCardCount());
			csoOutputControls.setStartTime(bean.getStartTime());
			csoOutputControls.setEndTime(bean.getEndTime());
			csoOutputControls.setFullfileind(bean.getFullFileInd());
			csoOutputControls.setRecordCountForDay(bean.getRecordCountForDay());
			csoOutputControls.setDrValueForDay(bean.getDrValueForDay());

			csoOutputControlsDao.create(csoOutputControls);



		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSO_OUTPUT_CONTROLS, cause: "+ ex.getMessage(), ex);
		}
	}
	
	/*public List<CsoOutputControlsDTO> retrieveAllByQuery() throws DAOException {
		List<CsoOutputControlsDTO> dtoList = new LinkedList<CsoOutputControlsDTO>();
		String sql = "SELECT SERVICE, SUB_SERVICE, FILENAME_DESCRIPTION FROM CSO_OUTPUT_CONTROLS WHERE STATUS_CODE = 'C' AND FULLFILEIND = 'C' "
				    + " OR  ( FULLFILEIND = 'N' AND ( SELECT COUNT(*)  FROM CSO_SCHEDULED_PROCESSES WHERE PROCESS_NAME = 'EOD' AND ACTIVE_IND = 'Y' ) > 0 )" ;
		try {
			List<Object[]> binsTotal = csoOutputControlsDao.executeQueryCrunch(sql);        
			for(Object[] t : binsTotal){		            	
				CsoOutputControlsDTO csfBinsDTO = new CsoOutputControlsDTO();		            	
				csfBinsDTO.setService((String) t[0]);
				csfBinsDTO.setSubService((String) t[1]);
				csfBinsDTO.setFilenameDescription((String)t[2]);	               
				dtoList.add(csfBinsDTO);
			}
		}
		catch(Exception ex) {
			throw new DAOException("Error retrieving CSF_BINS_By_Query entries, cause: " + ex.getMessage(), ex);
		}
		return dtoList;
	}*/

	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsoOutputControlsDTO retrieve(CsoOutputControlsDTO bean) throws DAOException {
		CsoOutputControlsDTO dto = new CsoOutputControlsDTO();
		try {
			String sql = "SELECT c FROM CsoOutputControls c " + this.buildWhereClause(bean, true);

			CsoOutputControls csoOutputControls = csoOutputControlsDao.executeQueryParametersSingleDate(sql, map);
           if(csoOutputControls == null){
        	   return null;
           }else{
			dto.setBankCode(Integer.valueOf(csoOutputControls.getBankCode()));
			if(csoOutputControls.getService()!=null){
				dto.setService(csoOutputControls.getService());
			}
			if(csoOutputControls.getSubService()!=null){
				dto.setSubService(csoOutputControls.getSubService());
			}
			if(csoOutputControls.getFilenamePrefix()!=null){		
				dto.setFilenamePrefix(csoOutputControls.getFilenamePrefix());
			}
			if(csoOutputControls.getDistributionCode()!=null){
				dto.setDistributionCode(csoOutputControls.getDistributionCode());
			}
			if(csoOutputControls.getSeqNumber()!=null){
				dto.setSeqNumber(csoOutputControls.getSeqNumber());
			}
			if(csoOutputControls.getStatusCode()!=null){
				dto.setStatusCode(csoOutputControls.getStatusCode());
			}
			if(csoOutputControls.getFilenameDescription()!=null){
				dto.setFilenameDescription(csoOutputControls.getFilenameDescription());
			}
			if(csoOutputControls.getTransmissionDate()!=null){
				dto.setTransmissionDate(csoOutputControls.getTransmissionDate());
			}
			if(csoOutputControls.getLastFileIndicator()!=null){
				dto.setLastFileIndicator(csoOutputControls.getLastFileIndicator());
			}
			if(csoOutputControls.getCrVolume()!=null){
				dto.setCrVolume(csoOutputControls.getCrVolume().longValue());
			}
			if(csoOutputControls.getCrValue()!=null){
				dto.setCrValue(csoOutputControls.getCrValue().doubleValue());
			}
			if(csoOutputControls.getDrVolume()!=null){
				dto.setDrVolume(csoOutputControls.getDrVolume().longValue());
			}
			if(csoOutputControls.getDrValue()!=null){
				dto.setDrValue(csoOutputControls.getDrValue().doubleValue());
			}
			if(csoOutputControls.getRecordCount()!=null){
				dto.setRecordCount(csoOutputControls.getRecordCount().intValue());
			}
			if(csoOutputControls.getHashTotal98()!=null){
				dto.setHashTotal98(csoOutputControls.getHashTotal98().longValue());
			}
			if(csoOutputControls.getHashTotal99()!=null){
				dto.setHashTotal99(csoOutputControls.getHashTotal99().longValue());
			}
			if(csoOutputControls.getOriginatingBankId()!=null){
				dto.setOriginatingBankId(csoOutputControls.getOriginatingBankId());
			}
			if(csoOutputControls.getOriginatingMember()!=null){
				dto.setOriginatingMember(Integer.valueOf(csoOutputControls.getOriginatingMember()));
			}
			dto.setNegCardCount(csoOutputControls.getNegCardCount());
			if(csoOutputControls.getStartTime()!=null){
				dto.setStartTime((Timestamp) csoOutputControls.getStartTime());
			}
			if(csoOutputControls.getEndTime()!=null){
				dto.setEndTime((Timestamp) csoOutputControls.getEndTime());
			}
			if(csoOutputControls.getFullfileind()!=null){
				dto.setFullFileInd(csoOutputControls.getFullfileind());
			}
			if(csoOutputControls.getRecordCountForDay()!=null){
				dto.setRecordCountForDay(csoOutputControls.getRecordCountForDay());
			}
			if(csoOutputControls.getDrValueForDay()!=null){
				dto.setDrValueForDay(csoOutputControls.getDrValueForDay());
			}

            map.clear();
			return dto;
           }

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_OUTPUT_CONTROLS, cause: "+ ex.getMessage(), ex);
		}
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	@SuppressWarnings("unchecked")
	public List<CsoOutputControlsDTO> retrieveRelated(CsoOutputControlsDTO bean) throws DAOException {
		List<CsoOutputControlsDTO> dtoList = new LinkedList<>();
		CsoOutputControlsDTO dto =null;

		try {
			String sql = "SELECT c FROM CsoOutputControls c "+ this.buildWhereClause(bean, true);
			List<CsoOutputControls> csoOutputControl = (List<CsoOutputControls>) csoOutputControlsDao.executeQueryParameters(sql,map);
			if(csoOutputControl == null){
	        	   return null;
	        }else{
			for (CsoOutputControls csoOutputControls : csoOutputControl) {				

				dto = new CsoOutputControlsDTO();
				dto.setBankCode(Integer.valueOf(csoOutputControls.getBankCode()));

				if(csoOutputControls.getService()!=null){
					dto.setService(csoOutputControls.getService());
				}
				if(csoOutputControls.getSubService()!=null){
					dto.setSubService(csoOutputControls.getSubService());
				}
				if(csoOutputControls.getFilenamePrefix()!=null){		
					dto.setFilenamePrefix(csoOutputControls.getFilenamePrefix());
				}
				if(csoOutputControls.getDistributionCode()!=null){
					dto.setDistributionCode(csoOutputControls.getDistributionCode());
				}
				if(csoOutputControls.getSeqNumber()!=null){
					dto.setSeqNumber(csoOutputControls.getSeqNumber());
				}
				if(csoOutputControls.getStatusCode()!=null){
					dto.setStatusCode(csoOutputControls.getStatusCode());
				}
				if(csoOutputControls.getFilenameDescription()!=null){
					dto.setFilenameDescription(csoOutputControls.getFilenameDescription());
				}
				if(csoOutputControls.getTransmissionDate()!=null){
					dto.setTransmissionDate(csoOutputControls.getTransmissionDate());
				}
				if(csoOutputControls.getLastFileIndicator()!=null){
					dto.setLastFileIndicator(csoOutputControls.getLastFileIndicator());
				}
				if(csoOutputControls.getCrVolume()!=null){
					dto.setCrVolume(csoOutputControls.getCrVolume().longValue());
				}
				if(csoOutputControls.getCrValue()!=null){
					dto.setCrValue(csoOutputControls.getCrValue().doubleValue());
				}
				if(csoOutputControls.getDrVolume()!=null){
					dto.setDrVolume(csoOutputControls.getDrVolume().longValue());
				}
				if(csoOutputControls.getDrValue()!=null){
					dto.setDrValue(csoOutputControls.getDrValue().doubleValue());
				}
				if(csoOutputControls.getRecordCount()!=null){
					dto.setRecordCount(csoOutputControls.getRecordCount().intValue());
				}
				if(csoOutputControls.getHashTotal98()!=null){
					dto.setHashTotal98(csoOutputControls.getHashTotal98().longValue());
				}
				if(csoOutputControls.getHashTotal99()!=null){
					dto.setHashTotal99(csoOutputControls.getHashTotal99().longValue());
				}
				if(csoOutputControls.getOriginatingBankId()!=null){
					dto.setOriginatingBankId(csoOutputControls.getOriginatingBankId());
				}
				if(csoOutputControls.getOriginatingMember()!=null){
					dto.setOriginatingMember(Integer.valueOf(csoOutputControls.getOriginatingMember()));
				}
				dto.setNegCardCount(csoOutputControls.getNegCardCount());
				if(csoOutputControls.getStartTime()!=null){
					dto.setStartTime((Timestamp) csoOutputControls.getStartTime());
				}
				if(csoOutputControls.getEndTime()!=null){
					dto.setEndTime((Timestamp) csoOutputControls.getEndTime());
				}
				if(csoOutputControls.getFullfileind()!=null){
					dto.setFullFileInd(csoOutputControls.getFullfileind());
				}
				if(csoOutputControls.getRecordCountForDay() !=null){
				dto.setRecordCountForDay(csoOutputControls.getRecordCountForDay());
				}
				if(csoOutputControls.getDrValueForDay()!= null){
					dto.setDrValueForDay(csoOutputControls.getDrValueForDay());
				}

                map.clear();
				dtoList.add(dto);

			}			

			return dtoList;
	      }

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_OUTPUT_CONTROLS, cause: "+ ex.getMessage(), ex);
		}
	}

	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CsoOutputControlsDTO bean) throws DAOException {
		try {
		CsoOutputControls csoOutputControls = new CsoOutputControls();

		csoOutputControls.setBankCode(String.valueOf(bean.getBankCode()));
		csoOutputControls.setService(bean.getService());
		csoOutputControls.setSubService(bean.getSubService());
		csoOutputControls.setFilenamePrefix(bean.getFilenamePrefix());
		csoOutputControls.setDistributionCode(bean.getDistributionCode());
		csoOutputControls.setSeqNumber(bean.getSeqNumber());
		csoOutputControls.setStatusCode(bean.getStatusCode());
		csoOutputControls.setFilenameDescription(bean.getFilenameDescription());
		csoOutputControls.setTransmissionDate(bean.getTransmissionDate());
		csoOutputControls.setLastFileIndicator(bean.getLastFileIndicator());
		csoOutputControls.setCrVolume(bean.getCrVolume());
		csoOutputControls.setCrValue(new BigDecimal(bean.getCrValue()));
		csoOutputControls.setDrVolume(bean.getDrVolume());
		csoOutputControls.setDrValue(new BigDecimal(bean.getDrValue()));
		csoOutputControls.setRecordCount(bean.getRecordCount());
		csoOutputControls.setHashTotal98(bean.getHashTotal98());
		csoOutputControls.setHashTotal99(bean.getHashTotal99());
		csoOutputControls.setOriginatingBankId(bean.getOriginatingBankId());
		csoOutputControls.setOriginatingMember(String.valueOf(bean.getOriginatingMember()));
		csoOutputControls.setNegCardCount(bean.getNegCardCount());
		csoOutputControls.setStartTime(bean.getStartTime());
		csoOutputControls.setEndTime(bean.getEndTime());
		csoOutputControls.setFullfileind(bean.getFullFileInd());
		csoOutputControls.setRecordCountForDay(bean.getRecordCountForDay());
		csoOutputControls.setDrValueForDay(bean.getDrValueForDay());
		

			csoOutputControlsDao.update(csoOutputControls);

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSO_OUTPUT_CONTROLS, cause: "+ ex.getMessage(), ex);
		}
	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	public void delete(CsoOutputControlsDTO bean) throws DAOException {
		try{
			CsoOutputControls csoOutputControls = new CsoOutputControls();

			csoOutputControls.setBankCode(String.valueOf(bean.getBankCode()));
			csoOutputControls.setService(bean.getService());
			csoOutputControls.setSubService(bean.getSubService());
			csoOutputControls.setFilenamePrefix(bean.getFilenamePrefix());
			csoOutputControls.setDistributionCode(bean.getDistributionCode());
			csoOutputControls.setSeqNumber(bean.getSeqNumber());
			csoOutputControls.setStatusCode(bean.getStatusCode());
			csoOutputControls.setFilenameDescription(bean.getFilenameDescription());
			csoOutputControls.setTransmissionDate(new Date(bean.getTransmissionDate().getTime()));
			csoOutputControls.setLastFileIndicator(bean.getLastFileIndicator());
			csoOutputControls.setCrVolume(bean.getCrVolume());
			csoOutputControls.setCrValue(new BigDecimal(bean.getCrValue()));
			csoOutputControls.setDrVolume(bean.getDrVolume());
			csoOutputControls.setDrValue(new BigDecimal(bean.getDrValue()));
			csoOutputControls.setRecordCount(bean.getRecordCount());
			csoOutputControls.setHashTotal98(bean.getHashTotal98());
			csoOutputControls.setHashTotal99(bean.getHashTotal99());
			csoOutputControls.setOriginatingBankId(bean.getOriginatingBankId());
			csoOutputControls.setOriginatingMember(String.valueOf(bean.getOriginatingMember()));
			csoOutputControls.setNegCardCount(bean.getNegCardCount());
			csoOutputControls.setStartTime(bean.getStartTime());
			csoOutputControls.setEndTime(bean.getEndTime());
			csoOutputControls.setFullfileind(bean.getFullFileInd());
			csoOutputControls.setRecordCountForDay(bean.getRecordCountForDay());
			csoOutputControls.setDrValueForDay(bean.getDrValueForDay());
			
			csoOutputControlsDao.delete(csoOutputControls);

		} catch (Exception ex) {
			throw new DAOException("Error Deleting CCCOWNER.CSO_OUTPUT_CONTROLS, cause: "+ ex.getMessage(), ex);
		} 

	}

	/**
	 * Retrieve a record count from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */
	public int retrieveRowCount(CsoOutputControlsDTO bean) throws DAOException {

		try {
			String sql = "SELECT COUNT(*) AS count FROM CsoOutputControls ";//+ this.buildWhereClause(bean, true);

			int count = (int) csoOutputControlsDao.executeCountQuery(sql);
			
			return count;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_OUTPUT_CONTROLS, cause: "
					+ ex.getMessage(), ex);
		}
		
	}
	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsoOutputControlsDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		
		if (select == true) {

		if (bean.getBankCode() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.bankCode = :bankCode");
			map.put("bankCode",String.valueOf(bean.getBankCode()));	
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

			buff.append("c.subService = :subService");
			map.put("subService",bean.getSubService());	
		}
		if (bean.getFilenamePrefix() != null && !bean.getFilenamePrefix().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.filenamePrefix = :filenamePrefix");
			map.put("filenamePrefix",bean.getFilenamePrefix());	
		}
		if (bean.getSeqNumber() != null && !bean.getSeqNumber().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.seqNumber = :seqNumber");
			map.put("seqNumber",bean.getSeqNumber());	
		}
	
			if (bean.getDistributionCode() != null && !bean.getDistributionCode().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.distributionCode = :distributionCode");
				map.put("distributionCode",bean.getDistributionCode());
			}
			if (bean.getStatusCode() != null && !bean.getStatusCode().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.statusCode=:statusCode");
				map.put("statusCode",bean.getStatusCode());
			}
			if (bean.getFilenameDescription() != null && !bean.getFilenameDescription().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.filenameDescription =:filenameDescription");
				map.put("filenameDescription",bean.getFilenameDescription());
			}
			if (bean.getTransmissionDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.transmissionDate =:transmissionDate");
				map.put("transmissionDate",String.valueOf(bean.getTransmissionDate()));
			}
			if (bean.getLastFileIndicator() != null && !bean.getLastFileIndicator().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.lastFileIndicator=:lastFileIndicator");
				map.put("lastFileIndicator",bean.getLastFileIndicator());
			}
			if (bean.getCrVolume() > 0L) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.crVolume=:crVolume");
				map.put("crVolume",String.valueOf(bean.getCrVolume()));
			}
			if (bean.getCrValue() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.crValue=:crValue");
				map.put("crValue",String.valueOf(bean.getCrValue()));
			}
			if (bean.getDrVolume() > 0L) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.drVolume=:drVolume");
				map.put("drVolume",String.valueOf(bean.getDrVolume()));
			}
			if (bean.getDrValue() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.drValue=:drValue");
				map.put("drValue",String.valueOf(bean.getDrValue()));
			}
			if (bean.getRecordCount() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.recordCount=:recordCount");
				map.put("recordCount",String.valueOf(bean.getRecordCount()));
			}
			if (bean.getHashTotal98() > 0L) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.hashTotal98=:hashTotal98");
				map.put("hashTotal98",String.valueOf(bean.getHashTotal98()));
			}
			if (bean.getHashTotal99() > 0L) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.hashTotal99=:hashTotal99");
				map.put("hashTotal99",String.valueOf(bean.getHashTotal99()));
			}
			if (bean.getOriginatingBankId() != null && !bean.getOriginatingBankId().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.originatingBankId=:originatingBankId");
				map.put("originatingBankId",bean.getOriginatingBankId());
			}
			if (bean.getOriginatingMember() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.originatingMember=:originatingMember");
				map.put("originatingMember",String.valueOf(bean.getOriginatingMember()));
			}
			if (bean.getNegCardCount() > 0L) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.negCardCount=:negCardCount");
				map.put("negCardCount",String.valueOf(bean.getNegCardCount()));
			}
			if (bean.getStartTime() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.startTime=:startTime");
				map.put("startTime",String.valueOf(bean.getStartTime()));
			}
			if (bean.getEndTime() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.endTime=:endTime");
				map.put("endTime",String.valueOf(bean.getEndTime()));
			}

			if (bean.getFullFileInd() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.fullfileind =:fullfileind");
				map.put("fullfileind",bean.getFullFileInd());
			}
			if (bean.getRecordCountForDay() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.recordCountForDay =:recordCountForDay");
				map.put("recordCountForDay",bean.getRecordCountForDay());
			}
			if (bean.getDrValueForDay() != 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.drValueForDay=:drValueForDay");
				map.put("drValueForDay",bean.getDrValueForDay());
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot build all rows in CsoOutputControls");
		}
		return buff.toString();
	}


	@SuppressWarnings("unchecked")
	public List<CsoOutputControlsDTO> retrieveNegativeCardFiles(CsoOutputControlsDTO bean) throws DAOException {
		List<CsoOutputControlsDTO> dtoList = new LinkedList<>();
		CsoOutputControlsDTO dto = new CsoOutputControlsDTO();

		try {
			String sql = 
					"SELECT c FROM CsoOutputControls c ";
			sql += this.buildWhereClause(bean, true);
			sql += " AND negCardCount > 0 ORDER BY filenameDescription ASC";
			List<CsoOutputControls> csoOutputControl = (List<CsoOutputControls>) csoOutputControlsDao.executeQueryParameters(sql,map);
			for (CsoOutputControls csoOutputControls : csoOutputControl) {				

				dto.setBankCode(Integer.valueOf(csoOutputControls.getBankCode()));

				if(csoOutputControls.getService()!=null){
					dto.setService(csoOutputControls.getService());
				}
				if(csoOutputControls.getSubService()!=null){
					dto.setSubService(csoOutputControls.getSubService());
				}
				if(csoOutputControls.getFilenamePrefix()!=null){		
					dto.setFilenamePrefix(csoOutputControls.getFilenamePrefix());
				}
				if(csoOutputControls.getDistributionCode()!=null){
					dto.setDistributionCode(csoOutputControls.getDistributionCode());
				}
				if(csoOutputControls.getSeqNumber()!=null){
					dto.setSeqNumber(csoOutputControls.getSeqNumber());
				}
				if(csoOutputControls.getStatusCode()!=null){
					dto.setStatusCode(csoOutputControls.getStatusCode());
				}
				if(csoOutputControls.getFilenameDescription()!=null){
					dto.setFilenameDescription(csoOutputControls.getFilenameDescription());
				}
				if(csoOutputControls.getTransmissionDate()!=null){
					dto.setTransmissionDate(csoOutputControls.getTransmissionDate());
				}
				if(csoOutputControls.getLastFileIndicator()!=null){
					dto.setLastFileIndicator(csoOutputControls.getLastFileIndicator());
				}
				if(csoOutputControls.getCrVolume()!=null){
					dto.setCrVolume(csoOutputControls.getCrVolume().longValue());
				}
				if(csoOutputControls.getCrValue()!=null){
					dto.setCrValue(csoOutputControls.getCrValue().doubleValue());
				}
				if(csoOutputControls.getDrVolume()!=null){
					dto.setDrVolume(csoOutputControls.getDrVolume().longValue());
				}
				if(csoOutputControls.getDrValue()!=null){
					dto.setDrValue(csoOutputControls.getDrValue().doubleValue());
				}
				if(csoOutputControls.getRecordCount()!=null){
					dto.setRecordCount(csoOutputControls.getRecordCount().intValue());
				}
				if(csoOutputControls.getHashTotal98()!=null){
					dto.setHashTotal98(csoOutputControls.getHashTotal98().longValue());
				}
				if(csoOutputControls.getHashTotal99()!=null){
					dto.setHashTotal99(csoOutputControls.getHashTotal99().longValue());
				}
				if(csoOutputControls.getOriginatingBankId()!=null){
					dto.setOriginatingBankId(csoOutputControls.getOriginatingBankId());
				}
				if(csoOutputControls.getOriginatingMember()!=null){
					dto.setOriginatingMember(Integer.valueOf(csoOutputControls.getOriginatingMember()));
				}
				dto.setNegCardCount(csoOutputControls.getNegCardCount());
				if(csoOutputControls.getStartTime()!=null){
					dto.setStartTime((Timestamp) csoOutputControls.getStartTime());
				}
				if(csoOutputControls.getEndTime()!=null){
					dto.setEndTime((Timestamp) csoOutputControls.getEndTime());
				}
				if(csoOutputControls.getFullfileind()!=null){
					dto.setFullFileInd(csoOutputControls.getFullfileind());
				}
				if(csoOutputControls.getRecordCountForDay() != 0){
					dto.setRecordCountForDay(csoOutputControls.getRecordCountForDay());
				}
				if(csoOutputControls.getDrValueForDay()!= 0){
					dto.setDrValueForDay(csoOutputControls.getDrValueForDay());
				}
				dtoList.add(bean);

			}			

			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_OUTPUT_CONTROLS, cause: "
					+ ex.getMessage(), ex);
		} 
	}

	public void fixCsoOutputControls()throws DAOException{

		PreparedStatement ps = null;

		try{
			String sql = "UPDATE CsoOutputControls SET lastFileIndicator = 'N'";
			//ps = conn.prepareStatement(sql);
			int result = ps.executeUpdate();

			if (result <= 0){
				throw new DAOException("Error with sql : " + sql);
			}


			sql = "update cso_output_controls set last_file_indicator = 'Y' where filename_description in (" +
					" select aa.file_strt || bb.alpha_seq || 'D' as last_filename" +
					" from " +
					" (select file_strt " +
					"      ,max(num_index) as max_fileno " +
					" from  " +
					" (select substr(a.filename_description,1,4) as file_strt" +
					"      ,substr(a.filename_description,5,3) as file_seq_no" +
					"      ,b.num_index" +
					"  from cso_output_controls a" +
					"    ,csf_filename_lookup b" +
					"  where substr(a.filename_description,5,3) = b.alpha_seq)" +
					"  group by file_strt) aa" +
					"        ,csf_filename_lookup bb " +
					" where aa.max_fileno = bb.num_index)";

			//ps = conn.prepareStatement(sql);
			//result = ps.executeUpdate();

			if (result <= 0){
				throw new DAOException("Error with sql : " + sql);
			}

		}catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_OUTPUT_CONTROLS, cause: "
					+ ex.getMessage(), ex);
		}

	}

	public void updateLastFileIndicator(CsoOutputControlsDTO bean)throws DAOException{
		try {

			CsoOutputControls csoOutputControls = new CsoOutputControls();

			csoOutputControls.setBankCode(String.valueOf(bean.getBankCode()));
			csoOutputControls.setService(bean.getService());
			csoOutputControls.setSubService(bean.getSubService());
			csoOutputControls.setFilenamePrefix(bean.getFilenamePrefix());
			csoOutputControls.setDistributionCode(bean.getDistributionCode());
			csoOutputControls.setSeqNumber(bean.getSeqNumber());
			csoOutputControls.setStatusCode(bean.getStatusCode());
			csoOutputControls.setFilenameDescription(bean.getFilenameDescription());
			csoOutputControls.setTransmissionDate(new Date(bean.getTransmissionDate().getTime()));
			csoOutputControls.setLastFileIndicator(bean.getLastFileIndicator());
			csoOutputControls.setCrVolume(bean.getCrVolume());
			csoOutputControls.setCrValue(new BigDecimal(bean.getCrValue()));
			csoOutputControls.setDrVolume(bean.getDrVolume());
			csoOutputControls.setDrValue(new BigDecimal(bean.getDrValue()));
			csoOutputControls.setRecordCount(bean.getRecordCount());
			csoOutputControls.setHashTotal98(bean.getHashTotal98());
			csoOutputControls.setHashTotal99(bean.getHashTotal99());
			csoOutputControls.setOriginatingBankId(bean.getOriginatingBankId());
			csoOutputControls.setOriginatingMember(String.valueOf(bean.getOriginatingMember()));
			csoOutputControls.setNegCardCount(bean.getNegCardCount());
			csoOutputControls.setStartTime(bean.getStartTime());
			csoOutputControls.setEndTime(bean.getEndTime());
			csoOutputControls.setFullfileind(bean.getFullFileInd());
			csoOutputControls.setRecordCountForDay(bean.getRecordCountForDay());
			csoOutputControls.setDrValueForDay(bean.getDrValueForDay());

			csoOutputControlsDao.update(csoOutputControls);



		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSO_OUTPUT_CONTROLS, cause: "+ ex.getMessage(), ex);
		}

	}
	
	public void delete() throws DAOException{
		
		csoOutputControlsDao.deleteBulk("Delete from CsoOutputControls");
	}
	
}
