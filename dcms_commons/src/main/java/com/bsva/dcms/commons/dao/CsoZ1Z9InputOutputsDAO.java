package com.bsva.dcms.commons.dao;


import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsoZ1Z9InputOutputsDao;
import com.bsva.dcms.commons.dto.CsoZ1Z9InputOutputsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsoZ1Z9InputOutputs;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsoZ1Z9InputOutputsDAO {

	//private CsoZ1Z9InputOutputsRepository csoZ1Z9InputOutputsRepositoryDao = DaoFactory.csoZ1Z9InputOutputsInstance();
	
	private CsoZ1Z9InputOutputsDao csoZ1Z9InputOutputsDao = new CsoZ1Z9InputOutputsDao();
	
    private Map<String,Object> map = new HashMap<>();
	public CsoZ1Z9InputOutputsDAO() {

	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */
	public void create(CsoZ1Z9InputOutputsDTO bean) throws DAOException {

		CsoZ1Z9InputOutputs csoZ1Z9InputOutputs = new CsoZ1Z9InputOutputs();
		csoZ1Z9InputOutputs.setFilenameDescription(bean.getFilenameDescription());
		csoZ1Z9InputOutputs.setOraSeqNumber(bean.getOraSeqNumber());
		csoZ1Z9InputOutputs.setService(bean.getService());
		csoZ1Z9InputOutputs.setSubService(bean.getSubService());
		csoZ1Z9InputOutputs.setInternalIndicator(bean.getInputOutputIndicator());
		csoZ1Z9InputOutputs.setLastFileIndicator(bean.getLastFileIndicator());
		csoZ1Z9InputOutputs.setTransmitIndicator(bean.getTransmitIndicator());
		csoZ1Z9InputOutputs.setDestination(bean.getDestination());
		csoZ1Z9InputOutputs.setNumberOfRecords(bean.getNumberOfRecords());
		csoZ1Z9InputOutputs.setOpsDate((Date) bean.getOpsDate());
		csoZ1Z9InputOutputs.setCrValue(BigDecimal.valueOf(bean.getCrValue()));
		csoZ1Z9InputOutputs.setDrValue(BigDecimal.valueOf(bean.getDrValue()));
		csoZ1Z9InputOutputs.setFileRefNumber(bean.getFileRefNumber());
		csoZ1Z9InputOutputs.setBankCode((short) bean.getBankCode());
		csoZ1Z9InputOutputs.setReportName(bean.getReportName());
		csoZ1Z9InputOutputs.setMedia(bean.getMedia());
		csoZ1Z9InputOutputs.setCentre((short) bean.getCentre());
		csoZ1Z9InputOutputs.setInternalIndicator(bean.getInternalIndicator());
		csoZ1Z9InputOutputs.setPrintCode(bean.getPrintCode());
		csoZ1Z9InputOutputs.setRecipientCode(bean.getRecipientCode());
		csoZ1Z9InputOutputs.setDistributedIndicator(bean.getDistributedIndicator());
		csoZ1Z9InputOutputs.setNoOfCredits(bean.getNoOfCredits());
		csoZ1Z9InputOutputs.setNoOfDebits(bean.getNoOfDebits());
		csoZ1Z9InputOutputs.setHashTotal(bean.getHashTotal());
		csoZ1Z9InputOutputs.setAxdCreatedIndicator(bean.getAxdCreatedIndicator());
		csoZ1Z9InputOutputs.setNegativeCardCount(bean.getNegativeCardCount());
		csoZ1Z9InputOutputs.setAcquirer((short) bean.getAcquirer());
		csoZ1Z9InputOutputs.setIssuer((short) bean.getIssuer());
		csoZ1Z9InputOutputs.setControlRecordCount(bean.getControlRecordCount());

		csoZ1Z9InputOutputsDao.create(csoZ1Z9InputOutputs);

	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */
	@SuppressWarnings("unchecked")
	public CsoZ1Z9InputOutputsDTO retrieve(CsoZ1Z9InputOutputsDTO bean) throws DAOException {

		CsoZ1Z9InputOutputsDTO csoZ1Z9InputOutputsDTO = null;

		try {
			String sql = "SELECT c FROM CsoZ1Z9InputOutputs c " + buildWhereClause(bean,true);

			CsoZ1Z9InputOutputs csoZ1Z9InputOutputs = csoZ1Z9InputOutputsDao.executeQueryParametersSingle(sql, map);
				csoZ1Z9InputOutputsDTO = new CsoZ1Z9InputOutputsDTO();
				if(csoZ1Z9InputOutputsDTO!=null){
				
				if(csoZ1Z9InputOutputs.getFilenameDescription()!=null){
				csoZ1Z9InputOutputsDTO.setFilenameDescription(csoZ1Z9InputOutputs.getFilenameDescription());
				}
				csoZ1Z9InputOutputsDTO.setOraSeqNumber(csoZ1Z9InputOutputs.getOraSeqNumber());
				
				if(csoZ1Z9InputOutputs.getService()!=null){
				csoZ1Z9InputOutputsDTO.setService(csoZ1Z9InputOutputs.getService());
				}
				if(csoZ1Z9InputOutputs.getSubService()!=null){
				csoZ1Z9InputOutputsDTO.setSubService(csoZ1Z9InputOutputs.getSubService());
				}
				if(csoZ1Z9InputOutputs.getInputOutputIndicator()!=null){
				csoZ1Z9InputOutputsDTO.setInternalIndicator(csoZ1Z9InputOutputs.getInputOutputIndicator());
				}
				if(csoZ1Z9InputOutputs.getLastFileIndicator()!=null){
				csoZ1Z9InputOutputsDTO.setLastFileIndicator(csoZ1Z9InputOutputs.getLastFileIndicator());
				}
				if(csoZ1Z9InputOutputs.getTransmitIndicator()!=null){
				csoZ1Z9InputOutputsDTO.setTransmitIndicator(csoZ1Z9InputOutputs.getTransmitIndicator());
				}
				if(csoZ1Z9InputOutputs.getDestination()!=null){
				csoZ1Z9InputOutputsDTO.setDestination(csoZ1Z9InputOutputs.getDestination().intValue());
				}
			
				csoZ1Z9InputOutputsDTO.setNumberOfRecords(csoZ1Z9InputOutputs.getNumberOfRecords());
				if( csoZ1Z9InputOutputs.getOpsDate()!=null){
				csoZ1Z9InputOutputsDTO.setOpsDate((Date) csoZ1Z9InputOutputs.getOpsDate());
				}
				if(csoZ1Z9InputOutputs.getCrValue()!=null){
				csoZ1Z9InputOutputsDTO.setCrValue(csoZ1Z9InputOutputs.getCrValue().doubleValue());
				}
				if(csoZ1Z9InputOutputs.getDrValue()!=null){
	    		csoZ1Z9InputOutputsDTO.setDrValue(csoZ1Z9InputOutputs.getDrValue().doubleValue());
				}
				if(csoZ1Z9InputOutputs.getFileRefNumber()!=null){
				csoZ1Z9InputOutputsDTO.setFileRefNumber(csoZ1Z9InputOutputs.getFileRefNumber());
				}
				if(csoZ1Z9InputOutputs.getBankCode()!=null){
				csoZ1Z9InputOutputsDTO.setBankCode(csoZ1Z9InputOutputs.getBankCode().shortValue());
				}
				if(csoZ1Z9InputOutputs.getReportName()!=null){
				csoZ1Z9InputOutputsDTO.setReportName(csoZ1Z9InputOutputs.getReportName());
				}
				if(csoZ1Z9InputOutputs.getMedia()!=null){
				csoZ1Z9InputOutputsDTO.setMedia(csoZ1Z9InputOutputs.getMedia());
				}
				csoZ1Z9InputOutputsDTO.setCentre(csoZ1Z9InputOutputs.getCentre());
				if(csoZ1Z9InputOutputs.getInternalIndicator()!=null){
				csoZ1Z9InputOutputsDTO.setInternalIndicator(csoZ1Z9InputOutputs.getInternalIndicator());
				}
				if(csoZ1Z9InputOutputs.getPrintCode()!=null){
				csoZ1Z9InputOutputsDTO.setPrintCode(csoZ1Z9InputOutputs.getPrintCode());
				}
				if(csoZ1Z9InputOutputs.getRecipientCode()!=null){
				csoZ1Z9InputOutputsDTO.setRecipientCode(csoZ1Z9InputOutputs.getRecipientCode());
				}
				if(csoZ1Z9InputOutputs.getDistributedIndicator()!=null){
				csoZ1Z9InputOutputsDTO.setDistributedIndicator(csoZ1Z9InputOutputs.getDistributedIndicator());
				}
				if(csoZ1Z9InputOutputs.getNoOfCredits()!=null){
				csoZ1Z9InputOutputsDTO.setNoOfCredits(csoZ1Z9InputOutputs.getNoOfCredits().intValue());
				}
				if(csoZ1Z9InputOutputs.getNoOfDebits()!=null){
				csoZ1Z9InputOutputsDTO.setNoOfDebits(csoZ1Z9InputOutputs.getNoOfDebits().intValue());
				}
				if(csoZ1Z9InputOutputs.getHashTotal()!=null){
				csoZ1Z9InputOutputsDTO.setHashTotal(csoZ1Z9InputOutputs.getHashTotal().longValue());
				}
				if(csoZ1Z9InputOutputs.getAxdCreatedIndicator()!=null){
				csoZ1Z9InputOutputsDTO.setAxdCreatedIndicator(csoZ1Z9InputOutputs.getAxdCreatedIndicator());
				}
				if(csoZ1Z9InputOutputs.getNegativeCardCount()!=null){
				csoZ1Z9InputOutputsDTO.setNegativeCardCount(csoZ1Z9InputOutputs.getNegativeCardCount().intValue());
				}
				if(csoZ1Z9InputOutputs.getAcquirer()!=null){
				csoZ1Z9InputOutputsDTO.setAcquirer(csoZ1Z9InputOutputs.getAcquirer().shortValue());
				}
				if(csoZ1Z9InputOutputs.getIssuer()!=null){
				csoZ1Z9InputOutputsDTO.setIssuer(csoZ1Z9InputOutputs.getIssuer().shortValue());
				}
				if(csoZ1Z9InputOutputs.getControlRecordCount()!=null){
				csoZ1Z9InputOutputsDTO.setControlRecordCount(csoZ1Z9InputOutputs.getControlRecordCount().intValue());
				}
				
			}

		}
		catch(Exception ex) {
			ex.getMessage();
		}
		map.clear();
		return csoZ1Z9InputOutputsDTO;


	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */
	public List<CsoZ1Z9InputOutputsDTO> retrieveRelated(CsoZ1Z9InputOutputsDTO bean) throws DAOException {
		List<CsoZ1Z9InputOutputsDTO> dtoList = new LinkedList<CsoZ1Z9InputOutputsDTO>();
		CsoZ1Z9InputOutputsDTO csoZ1Z9InputOutputsDTO;
		try {
			String sql = "SELECT c  FROM CsoZ1Z9InputOutputs c "  + buildWhereClause(bean,true);
			List<CsoZ1Z9InputOutputs> csoZ1Z9InputOutputsretrieveRelated = csoZ1Z9InputOutputsDao.executeQueryParameters(sql, map);

			for (CsoZ1Z9InputOutputs csoZ1Z9InputOutputsRelated : csoZ1Z9InputOutputsretrieveRelated) {

				csoZ1Z9InputOutputsDTO = new CsoZ1Z9InputOutputsDTO();
				if(csoZ1Z9InputOutputsDTO!=null){
					
					if(csoZ1Z9InputOutputsRelated.getFilenameDescription()!=null){
					csoZ1Z9InputOutputsDTO.setFilenameDescription(csoZ1Z9InputOutputsRelated.getFilenameDescription());
					}
					csoZ1Z9InputOutputsDTO.setOraSeqNumber(csoZ1Z9InputOutputsRelated.getOraSeqNumber());
					
					if(csoZ1Z9InputOutputsRelated.getService()!=null){
					csoZ1Z9InputOutputsDTO.setService(csoZ1Z9InputOutputsRelated.getService());
					}
					if(csoZ1Z9InputOutputsRelated.getSubService()!=null){
					csoZ1Z9InputOutputsDTO.setSubService(csoZ1Z9InputOutputsRelated.getSubService());
					}
					if(csoZ1Z9InputOutputsRelated.getInputOutputIndicator()!=null){
					csoZ1Z9InputOutputsDTO.setInternalIndicator(csoZ1Z9InputOutputsRelated.getInputOutputIndicator());
					}
					if(csoZ1Z9InputOutputsRelated.getLastFileIndicator()!=null){
					csoZ1Z9InputOutputsDTO.setLastFileIndicator(csoZ1Z9InputOutputsRelated.getLastFileIndicator());
					}
					if(csoZ1Z9InputOutputsRelated.getTransmitIndicator()!=null){
					csoZ1Z9InputOutputsDTO.setTransmitIndicator(csoZ1Z9InputOutputsRelated.getTransmitIndicator());
					}
					if(csoZ1Z9InputOutputsRelated.getDestination()!=null){
					csoZ1Z9InputOutputsDTO.setDestination(csoZ1Z9InputOutputsRelated.getDestination().intValue());
					}
				
					csoZ1Z9InputOutputsDTO.setNumberOfRecords(csoZ1Z9InputOutputsRelated.getNumberOfRecords());
					if( csoZ1Z9InputOutputsRelated.getOpsDate()!=null){
					csoZ1Z9InputOutputsDTO.setOpsDate((Date) csoZ1Z9InputOutputsRelated.getOpsDate());
					}
					if(csoZ1Z9InputOutputsRelated.getCrValue()!=null){
					csoZ1Z9InputOutputsDTO.setCrValue(csoZ1Z9InputOutputsRelated.getCrValue().doubleValue());
					}
					if(csoZ1Z9InputOutputsRelated.getDrValue()!=null){
		    		csoZ1Z9InputOutputsDTO.setDrValue(csoZ1Z9InputOutputsRelated.getDrValue().doubleValue());
					}
					if(csoZ1Z9InputOutputsRelated.getFileRefNumber()!=null){
					csoZ1Z9InputOutputsDTO.setFileRefNumber(csoZ1Z9InputOutputsRelated.getFileRefNumber());
					}
					if(csoZ1Z9InputOutputsRelated.getBankCode()!=null){
					csoZ1Z9InputOutputsDTO.setBankCode(csoZ1Z9InputOutputsRelated.getBankCode().shortValue());
					}
					if(csoZ1Z9InputOutputsRelated.getReportName()!=null){
					csoZ1Z9InputOutputsDTO.setReportName(csoZ1Z9InputOutputsRelated.getReportName());
					}
					if(csoZ1Z9InputOutputsRelated.getMedia()!=null){
					csoZ1Z9InputOutputsDTO.setMedia(csoZ1Z9InputOutputsRelated.getMedia());
					}
					csoZ1Z9InputOutputsDTO.setCentre(csoZ1Z9InputOutputsRelated.getCentre());
					if(csoZ1Z9InputOutputsRelated.getInternalIndicator()!=null){
					csoZ1Z9InputOutputsDTO.setInternalIndicator(csoZ1Z9InputOutputsRelated.getInternalIndicator());
					}
					if(csoZ1Z9InputOutputsRelated.getPrintCode()!=null){
					csoZ1Z9InputOutputsDTO.setPrintCode(csoZ1Z9InputOutputsRelated.getPrintCode());
					}
					if(csoZ1Z9InputOutputsRelated.getRecipientCode()!=null){
					csoZ1Z9InputOutputsDTO.setRecipientCode(csoZ1Z9InputOutputsRelated.getRecipientCode());
					}
					if(csoZ1Z9InputOutputsRelated.getDistributedIndicator()!=null){
					csoZ1Z9InputOutputsDTO.setDistributedIndicator(csoZ1Z9InputOutputsRelated.getDistributedIndicator());
					}
					if(csoZ1Z9InputOutputsRelated.getNoOfCredits()!=null){
					csoZ1Z9InputOutputsDTO.setNoOfCredits(csoZ1Z9InputOutputsRelated.getNoOfCredits().intValue());
					}
					if(csoZ1Z9InputOutputsRelated.getNoOfDebits()!=null){
					csoZ1Z9InputOutputsDTO.setNoOfDebits(csoZ1Z9InputOutputsRelated.getNoOfDebits().intValue());
					}
					if(csoZ1Z9InputOutputsRelated.getHashTotal()!=null){
					csoZ1Z9InputOutputsDTO.setHashTotal(csoZ1Z9InputOutputsRelated.getHashTotal().longValue());
					}
					if(csoZ1Z9InputOutputsRelated.getAxdCreatedIndicator()!=null){
					csoZ1Z9InputOutputsDTO.setAxdCreatedIndicator(csoZ1Z9InputOutputsRelated.getAxdCreatedIndicator());
					}
					if(csoZ1Z9InputOutputsRelated.getNegativeCardCount()!=null){
					csoZ1Z9InputOutputsDTO.setNegativeCardCount(csoZ1Z9InputOutputsRelated.getNegativeCardCount().intValue());
					}
					if(csoZ1Z9InputOutputsRelated.getAcquirer()!=null){
					csoZ1Z9InputOutputsDTO.setAcquirer(csoZ1Z9InputOutputsRelated.getAcquirer().shortValue());
					}
					if(csoZ1Z9InputOutputsRelated.getIssuer()!=null){
					csoZ1Z9InputOutputsDTO.setIssuer(csoZ1Z9InputOutputsRelated.getIssuer().shortValue());
					}
					if(csoZ1Z9InputOutputsRelated.getControlRecordCount()!=null){
					csoZ1Z9InputOutputsDTO.setControlRecordCount(csoZ1Z9InputOutputsRelated.getControlRecordCount().intValue());
					}
					}

				dtoList.add(csoZ1Z9InputOutputsDTO);

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
	/*public List<CsoZ1Z9InputOutputsDTO> retrieveRelated(CsoZ1Z9InputOutputsDTO bean, int startRow, int endRow) throws DAOException {
		List<CsoZ1Z9InputOutputsDTO> dtoList = new LinkedList<CsoZ1Z9InputOutputsDTO>();
		try {

			
				return dtoList;
			
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_Z1_Z9_INPUT_OUTPUTS, cause: "+ ex.getMessage(), ex);
		} 
	}*

	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsoZ1Z9InputOutputsDTO bean, boolean select)throws DAOException  {

		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		
		if (select == true) {

		if (bean.getService() != null && !bean.getService().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.service  =:service");
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
			
			buff.append("c.subService  =:subService");
			map.put("subService",bean.getSubService());
		}
		if (bean.getFileRefNumber() != null && !bean.getFileRefNumber().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.fileRefNumber =:fileRefNumber");
			map.put("fileRefNumber",bean.getFileRefNumber());

		}
		if (bean.getBankCode() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.bankCode =:bankCode");
			map.put("bankCode",String.valueOf(bean.getBankCode()));
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
		if (bean.getOraSeqNumber() > 0L) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.oraSeqNumber =:oraSeqNumber");
			map.put("oraSeqNumber",String.valueOf(bean.getOraSeqNumber()));

		}
		if (bean.getInputOutputIndicator() != null && !bean.getInputOutputIndicator().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.inputOutputIndicator =:inputOutputIndicator");
			map.put("inputOutputIndicator",bean.getInputOutputIndicator());
		}
		if (bean.getLastFileIndicator() != null && !bean.getLastFileIndicator().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.lastFileIndicator =:lastFileIndicator");
			map.put("lastFileIndicator",bean.getLastFileIndicator());
		}
		if (bean.getTransmitIndicator() != null && !bean.getTransmitIndicator().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.transmitIndicator =:transmitIndicator");
			map.put("transmitIndicator",bean.getTransmitIndicator());
		}
		if (bean.getDestination() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.destination =:destination");
			map.put("destination",String.valueOf(bean.getDestination()));
			
		}
		if (bean.getNumberOfRecords() > 0L) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.numberOfRecords =:numberOfRecords");
			map.put("numberOfRecords",String.valueOf(bean.getNumberOfRecords()));
		}
		if (bean.getOpsDate() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.opsDate =:opsDate");
			map.put("opsDate",String.valueOf(bean.getOpsDate()));
		}
		if (bean.getCrValue() > 0.0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.crValue =:crValue");
			map.put("crValue",String.valueOf(bean.getCrValue()));
		}
		if (bean.getDrValue() > 0.0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.drValue =:drValue");
			map.put("drValue",String.valueOf(bean.getDrValue()));
		}
		if (bean.getReportName() != null && !bean.getReportName().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.reportName =:reportName");
			map.put("reportName",bean.getReportName());
		}
		if (bean.getMedia() != null && !bean.getMedia().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.media =:media");
			map.put("media",bean.getMedia());
		}
		if (bean.getCentre() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.centre =:centre");
			map.put("centre",String.valueOf(bean.getCentre()));
		}
		if (bean.getInternalIndicator() != null && !bean.getInternalIndicator().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.internalIndicator =:internalIndicator");
			map.put("internalIndicator",bean.getInternalIndicator());
		}
		if (bean.getPrintCode() != null && !bean.getPrintCode().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.printCode =:printCode");
			map.put("printCode",bean.getPrintCode());
		}
		if (bean.getRecipientCode() != null && !bean.getRecipientCode().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.recipientCode =:");
			map.put("",bean.getRecipientCode());
		}
		if (bean.getDistributedIndicator() != null && !bean.getDistributedIndicator().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.distributedIndicator =:distributedIndicator");
			map.put("distributedIndicator",bean.getDistributedIndicator());
		}
		if (bean.getNoOfCredits() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.noOfCredits =:noOfCredits");
			map.put("noOfCredits",String.valueOf(bean.getNoOfCredits()));
		}
		if (bean.getNoOfDebits() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.noOfDebits =:noOfDebits");
			map.put("noOfDebits",String.valueOf(bean.getNoOfDebits()));
		}
		if (bean.getHashTotal() > 0L) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.hashTotal =:hashTotal");
			map.put("hashTotal",String.valueOf(bean.getHashTotal()));
		}
		if (bean.getAxdCreatedIndicator() != null && !bean.getAxdCreatedIndicator().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.axdCreatedIndicator =:axdCreatedIndicator");
			map.put("axdCreatedIndicator",bean.getAxdCreatedIndicator());
		}
		if (bean.getNegativeCardCount() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.negativeCardCount =:negativeCardCount");
			map.put("negativeCardCount",String.valueOf(bean.getNegativeCardCount()));
		}
		if (bean.getAcquirer() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.acquirer =:acquirer");
			map.put("acquirer",String.valueOf(bean.getAcquirer()));
		}
		if (bean.getIssuer() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.issuer =:");
			map.put("",String.valueOf(bean.getIssuer()));
		}
		if (bean.getControlRecordCount() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.controlRecordCount =:controlRecordCount");
			map.put("controlRecordCount",String.valueOf(bean.getControlRecordCount()));
		}
		}
		if(!whereClause && select == false) {
			throw new DAOException( "Cannot Build where clause in CsoZ1Z9InputOutputs");
		}

		return buff.toString();
	}

	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */
	public void update(CsoZ1Z9InputOutputsDTO bean) throws DAOException {
		try{
		CsoZ1Z9InputOutputs csoZ1Z9InputOutputs = new CsoZ1Z9InputOutputs();
		csoZ1Z9InputOutputs.setFilenameDescription(bean.getFilenameDescription());
		csoZ1Z9InputOutputs.setOraSeqNumber(bean.getOraSeqNumber());
		csoZ1Z9InputOutputs.setService(bean.getService());
		csoZ1Z9InputOutputs.setSubService(bean.getSubService());
		csoZ1Z9InputOutputs.setInternalIndicator(bean.getInputOutputIndicator());
		csoZ1Z9InputOutputs.setLastFileIndicator(bean.getLastFileIndicator());
		csoZ1Z9InputOutputs.setTransmitIndicator(bean.getTransmitIndicator());
		csoZ1Z9InputOutputs.setDestination(bean.getDestination());
		csoZ1Z9InputOutputs.setNumberOfRecords(bean.getNumberOfRecords());
		csoZ1Z9InputOutputs.setOpsDate((Date) bean.getOpsDate());
		csoZ1Z9InputOutputs.setCrValue(BigDecimal.valueOf(bean.getCrValue()));
		csoZ1Z9InputOutputs.setDrValue(BigDecimal.valueOf(bean.getDrValue()));
		csoZ1Z9InputOutputs.setFileRefNumber(bean.getFileRefNumber());
		csoZ1Z9InputOutputs.setBankCode((short) bean.getBankCode());
		csoZ1Z9InputOutputs.setReportName(bean.getReportName());
		csoZ1Z9InputOutputs.setMedia(bean.getMedia());
		csoZ1Z9InputOutputs.setCentre((short) bean.getCentre());
		csoZ1Z9InputOutputs.setInternalIndicator(bean.getInternalIndicator());
		csoZ1Z9InputOutputs.setPrintCode(bean.getPrintCode());
		csoZ1Z9InputOutputs.setRecipientCode(bean.getRecipientCode());
		csoZ1Z9InputOutputs.setDistributedIndicator(bean.getDistributedIndicator());
		csoZ1Z9InputOutputs.setNoOfCredits(bean.getNoOfCredits());
		csoZ1Z9InputOutputs.setNoOfDebits(bean.getNoOfDebits());
		csoZ1Z9InputOutputs.setHashTotal(bean.getHashTotal());
		csoZ1Z9InputOutputs.setAxdCreatedIndicator(bean.getAxdCreatedIndicator());
		csoZ1Z9InputOutputs.setNegativeCardCount(bean.getNegativeCardCount());
		csoZ1Z9InputOutputs.setAcquirer((short) bean.getAcquirer());
		csoZ1Z9InputOutputs.setIssuer((short) bean.getIssuer());
		csoZ1Z9InputOutputs.setControlRecordCount(bean.getControlRecordCount());
		csoZ1Z9InputOutputsDao.update(csoZ1Z9InputOutputs);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	public void delete(){
		try{
		//csoZ1Z9InputOutputsDao.deleteBulk("Delete from CsoZ1Z9InputOutputs");
		csoZ1Z9InputOutputsDao.deleteTruncate("TRUNCATE TABLE CSO_Z1_Z9_INPUT_OUTPUTS");	
		}catch(Exception ex){
			ex.getMessage();
		}
		
	}
}
