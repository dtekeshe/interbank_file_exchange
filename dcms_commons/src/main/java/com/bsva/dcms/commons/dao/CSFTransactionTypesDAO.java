package com.bsva.dcms.commons.dao;


import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsfTransactionTypesDao;
import com.bsva.dcms.commons.dto.CSFTransactionTypesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfTransactionTypes;



public class CSFTransactionTypesDAO {


	//private CsfTransactionTypesRepository translationDao =  DaoFactory.csfTransactionTypesInstance();
	private CsfTransactionTypesDao csfTransactionTypesDao =  new CsfTransactionTypesDao();
	private Map<String,Object> map = new HashMap<>();


	public CSFTransactionTypesDAO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates an entry in the CSF_TRANSACTION_TYPES table
	 *
	 * @param CSF_TRANSACTION_TYPES the table entry to create
	 * @throws DAOException if a database exception occurs
	 */

	public void create(CSFTransactionTypesDTO csfTransactionTypsDTO) throws DAOException {

		try {

			CsfTransactionTypes csfTransactionTypes = new CsfTransactionTypes();

			csfTransactionTypes.setTransactionCode((short) csfTransactionTypsDTO.getTransactionCode());
			csfTransactionTypes.setTransactionDescription(csfTransactionTypsDTO.getTransactionDescription());
			csfTransactionTypes.setReportSortSequence((short) csfTransactionTypsDTO.getReportSortSequence());
			csfTransactionTypes.setFinancialInd(csfTransactionTypsDTO.getFinancialInd());
			csfTransactionTypes.setCreatedBy(csfTransactionTypsDTO.getCreatedBy());
			csfTransactionTypes.setCreatedDate(csfTransactionTypsDTO.getCreatedDate());
			csfTransactionTypes.setModifiedBy(csfTransactionTypsDTO.getModifiedBy());
			csfTransactionTypes.setModifiedDate(csfTransactionTypsDTO.getModifiedDate());
			csfTransactionTypesDao.create(csfTransactionTypes);
		}
		catch(Exception ex){
			throw new DAOException("Error creating CsfTransactionTypes entry, cause: " + ex.getMessage(), ex);
		}
	}

	public CSFTransactionTypesDTO retrieve(CSFTransactionTypesDTO obj) throws DAOException {
		CSFTransactionTypesDTO dto = null;
		try {

			String sql = "SELECT c FROM CsfTransactionTypes c "+ buildWhereClause(obj,true) ;
			CsfTransactionTypes translationTypes = csfTransactionTypesDao.executeQueryParametersSingleDate(sql, map);

			dto = new CSFTransactionTypesDTO();

			if( translationTypes.getTransactionCode()!=null){
				dto.setTransactionCode(translationTypes.getTransactionCode().intValue());
			}
			if(translationTypes.getTransactionDescription()!=null){
				dto.setTransactionDescription(translationTypes.getTransactionDescription());
			}
			if(translationTypes.getReportSortSequence() != 0){
			dto.setReportSortSequence(translationTypes.getReportSortSequence());
				}
			if(translationTypes.getFinancialInd()!=null){
				dto.setFinancialInd(translationTypes.getFinancialInd());
			}
			if(translationTypes.getCreatedBy()!=null){
				dto.setCreatedBy(translationTypes.getCreatedBy());
			}
			if(translationTypes.getCreatedDate()!=null){
				dto.setCreatedDate((Date)translationTypes.getCreatedDate());
			}
			if(translationTypes.getModifiedBy()!=null){
				dto.setModifiedBy(translationTypes.getModifiedBy());
			}
			if(translationTypes.getModifiedDate()!=null){
				dto.setModifiedDate((Date)translationTypes.getModifiedDate());
			}
                        
                        if(translationTypes.getAmountDirection()!=null){
				dto.setFeeDirection(translationTypes.getAmountDirection());
			}
                        
                        if(translationTypes.getFeeDirection()!=null){
				dto.setFeeDirection(translationTypes.getFeeDirection());
			}
                        
                        if(translationTypes.getVatDirection()!=null){
				dto.setVatDirection(translationTypes.getVatDirection());
			}

			map.clear();
			return dto;
		}
		catch(Exception ex) {
			throw new DAOException("Error retrieving CsfTransactionTypes entry, cause: " + ex.getMessage(), ex);
		}

	}

	@SuppressWarnings("unchecked")
	public List<CSFTransactionTypesDTO> retrieveRelated(CSFTransactionTypesDTO obj) throws DAOException {
		List<CSFTransactionTypesDTO> dtoList = new LinkedList<CSFTransactionTypesDTO>();
		CSFTransactionTypesDTO dto = null;
		try {
			String sql = "SELECT c FROM CsfTransactionTypes c " + buildWhereClause(obj,true);
			List<CsfTransactionTypes> translationType =  csfTransactionTypesDao.executeQueryParameters(sql, map);
			for (CsfTransactionTypes translationTypes : translationType) {                    	 

				dto = new CSFTransactionTypesDTO();
				
				if( translationTypes.getTransactionCode()!=null){
					dto.setTransactionCode(translationTypes.getTransactionCode().shortValue());
				}
				if(translationTypes.getTransactionDescription()!=null){
					dto.setTransactionDescription(translationTypes.getTransactionDescription());
				}
			    if(translationTypes.getReportSortSequence() != 0){
				dto.setReportSortSequence(translationTypes.getReportSortSequence());
				}
				if(translationTypes.getFinancialInd()!=null){
					dto.setFinancialInd(translationTypes.getFinancialInd());
				}
				if(translationTypes.getCreatedBy()!=null){
					dto.setCreatedBy(translationTypes.getCreatedBy());
				}
				if(translationTypes.getCreatedDate()!=null){
					dto.setCreatedDate((Date)translationTypes.getCreatedDate());
				}
				if(translationTypes.getModifiedBy()!=null){
					dto.setModifiedBy(translationTypes.getModifiedBy());
				}
				if(translationTypes.getModifiedDate()!=null){
					dto.setModifiedDate((Date)translationTypes.getModifiedDate());
				}


				map.clear();
				dtoList.add(dto);
			}
			return dtoList;
		}
		catch(Exception ex) {
			throw new DAOException("Error retrieving CsfTransactionTypes entries, cause: " + ex.getMessage(), ex);
		}

	}

	public void update(CSFTransactionTypesDTO obj) throws DAOException {

		CsfTransactionTypes csfTransactionTypes = new CsfTransactionTypes();

		csfTransactionTypes.setTransactionCode((short) obj.getTransactionCode());
		csfTransactionTypes.setTransactionDescription(obj.getTransactionDescription());
		csfTransactionTypes.setReportSortSequence((short) obj.getReportSortSequence());
		csfTransactionTypes.setFinancialInd(obj.getFinancialInd());
		csfTransactionTypes.setCreatedBy(obj.getCreatedBy());
		csfTransactionTypes.setCreatedDate(obj.getCreatedDate());
		csfTransactionTypes.setModifiedBy(obj.getModifiedBy());
		csfTransactionTypes.setModifiedDate(obj.getModifiedDate());
		try {

			csfTransactionTypesDao.update(csfTransactionTypes);

		}
		catch(Exception ex) {
			throw new DAOException("Error updating CSF_TRANSACTION_TYPES entry, cause: " + ex.getMessage(),  ex);
		}
	}

	public void delete(CSFTransactionTypesDTO csfTransactionTypsDTO){

		CsfTransactionTypes csfTransactionTypes = new CsfTransactionTypes();

		csfTransactionTypes.setTransactionCode((short) csfTransactionTypsDTO.getTransactionCode());
		csfTransactionTypes.setTransactionDescription(csfTransactionTypsDTO.getTransactionDescription());
		csfTransactionTypes.setReportSortSequence((short) csfTransactionTypsDTO.getReportSortSequence());
		csfTransactionTypes.setFinancialInd(csfTransactionTypsDTO.getFinancialInd());
		csfTransactionTypes.setCreatedBy(csfTransactionTypsDTO.getCreatedBy());
		csfTransactionTypes.setCreatedDate(csfTransactionTypsDTO.getCreatedDate());
		csfTransactionTypes.setModifiedBy(csfTransactionTypsDTO.getModifiedBy());
		csfTransactionTypes.setModifiedDate(csfTransactionTypsDTO.getModifiedDate());
		csfTransactionTypesDao.delete(csfTransactionTypes);

	}

	private String buildWhereClause(CSFTransactionTypesDTO obj, boolean select)throws DAOException  {

		if(obj == null) {
			return "";
		}
		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (select == true) {
		if(obj.getTransactionCode() != 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.transactionCode =:transactionCode");
			map.put("transactionCode",(short)obj.getTransactionCode());	
		}

		if(obj.getTransactionDescription() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.transactionDescription =:transactionDescription");
			map.put("transactionDescription",obj.getTransactionDescription());	
		}

		if(obj.getReportSortSequence() != 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.reportSortSequence =:reportSortSequence");
			map.put("reportSortSequence",String.valueOf(obj.getReportSortSequence()));	
		}

		if(obj.getFinancialInd() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.financialInd =:financialInd");
			map.put("financialInd",obj.getFinancialInd());
		}

		if(obj.getCreatedBy() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.createdBy =:createdBy");
			map.put("createdBy",obj.getCreatedBy());
		}
		if(obj.getCreatedDate() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.createdDate =:createdDate");
			map.put("createdDate",String.valueOf(obj.getCreatedDate()));
		}
		if(obj.getModifiedBy() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.modifiedBy =:modifiedBy");
			map.put("modifiedBy",obj.getModifiedBy());
		}
		if(obj.getModifiedDate() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.modifiedDate =:modifiedDate");
			map.put("modifiedDate",String.valueOf(obj.getModifiedDate()));
		}
		}
		if(!whereClause && select == false) {
			throw new DAOException( "Cannot Build  all rows in CsfTransactionTypes");
		}

		return buff.toString();
	}


}


