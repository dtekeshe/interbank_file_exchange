package com.bsva.dcms.commons.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsfErrorCodesDao;
import com.bsva.dcms.commons.dto.CsfErrorCodesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfErrorCodes;

/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsfErrorCodesDAO {
	
	private Map<String,Object> map = new HashMap<>();
	//private CsfErrorCodesRepository errorCodesDao = DaoFactory.csfErrorCodesInstance();
	private CsfErrorCodesDao errorCodesDao = new CsfErrorCodesDao();
	public CsfErrorCodesDAO() {
	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public CsfErrorCodesDTO create(CsfErrorCodesDTO bean) throws DAOException {


		try {
			CsfErrorCodes csfErrorCodes = new CsfErrorCodes();
			csfErrorCodes.setErrorCode(bean.getErrorCode());
			csfErrorCodes.setErrorMessage(bean.getErrorMessage());
			csfErrorCodes.setErrorRejectLevel(bean.getErrorRejectLevel());
			errorCodesDao.create(csfErrorCodes);

			return bean;

		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSF_ERROR_CODES, cause: "
					+ ex.getMessage(), ex);
		}
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsfErrorCodesDTO retrieve(CsfErrorCodesDTO bean) throws DAOException {
		CsfErrorCodesDTO csfErrorCodesDTO = new CsfErrorCodesDTO();
		try {

			String sql =	"SELECT c FROM CsfErrorCodes c "+ buildWhereClause(bean, true);
			CsfErrorCodes csfErrorCodes = errorCodesDao.executeQueryParametersSingle(sql, map);

			if(csfErrorCodes.getErrorCode()!=null){
				csfErrorCodesDTO.setErrorCode(csfErrorCodes.getErrorCode());
			}
			if(csfErrorCodes.getErrorMessage()!=null){
				csfErrorCodesDTO.setErrorMessage(csfErrorCodes.getErrorMessage());
			}
			if(csfErrorCodes.getErrorRejectLevel()!=null){
				csfErrorCodesDTO.setErrorRejectLevel(csfErrorCodes.getErrorRejectLevel());
			}

			map.clear();
			return csfErrorCodesDTO;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSF_ERROR_CODES, cause: "
					+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public List<CsfErrorCodesDTO> retrieveRelated(CsfErrorCodesDTO bean) throws DAOException {
		List<CsfErrorCodesDTO> dtoList = new ArrayList<CsfErrorCodesDTO>();
		CsfErrorCodesDTO csfErrorCodesDTO;
		try {

			String sql = "SELECT c FROM CsfErrorCodes c "+ buildWhereClause(bean, true);

			List<CsfErrorCodes> csfErrorCodesList = errorCodesDao.executeQueryParameters(sql, map);

			for (CsfErrorCodes csfErrorCodes : csfErrorCodesList) {		
				
				csfErrorCodesDTO = new CsfErrorCodesDTO();
				
				if(csfErrorCodes.getErrorCode() !=null){
					csfErrorCodesDTO.setErrorCode(csfErrorCodes.getErrorCode());
				}
				if(csfErrorCodes.getErrorMessage() !=null){
					csfErrorCodesDTO.setErrorMessage(csfErrorCodes.getErrorMessage());
				}
				if(csfErrorCodes.getErrorRejectLevel() !=null){
					csfErrorCodesDTO.setErrorRejectLevel(csfErrorCodes.getErrorRejectLevel());
				}
				dtoList.add(csfErrorCodesDTO);
			}
			map.clear();
			return dtoList;


		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSF_ERROR_CODES, cause: "
					+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CsfErrorCodesDTO bean) throws DAOException {
		try{
			CsfErrorCodes csfErrorCodes = new CsfErrorCodes();
			csfErrorCodes.setErrorCode(bean.getErrorCode());
			csfErrorCodes.setErrorMessage(bean.getErrorMessage());
			csfErrorCodes.setErrorRejectLevel(bean.getErrorRejectLevel());
			errorCodesDao.update(csfErrorCodes);

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSF_ERROR_CODES, cause: "+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	public void delete(CsfErrorCodesDTO bean) throws DAOException {
		try{

			CsfErrorCodes csfErrorCodes = new CsfErrorCodes();
			csfErrorCodes.setErrorCode(bean.getErrorCode());
			csfErrorCodes.setErrorMessage(bean.getErrorMessage());
			csfErrorCodes.setErrorRejectLevel(bean.getErrorRejectLevel());
			errorCodesDao.delete(csfErrorCodes);

		} catch (Exception ex) {
			throw new DAOException("Error Deleting CCCOWNER.CSF_ERROR_CODES, cause: "+ ex.getMessage(), ex);
		} 

	}

	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsfErrorCodesDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (select == true) {			
		
		if (bean.getErrorCode() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.errorCode =:errorCode");        
			map.put("errorCode",String.valueOf(bean.getErrorCode()));	
		   }
			if (bean.getErrorMessage() != null && !bean.getErrorMessage().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.errorMessage =:errorMessage");
				map.put("errorMessage",bean.getErrorMessage());
			}
			if (bean.getErrorRejectLevel() != null && !bean.getErrorRejectLevel().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.errorRejectLevel =:errorRejectLevel");
				map.put("errorRejectLevel",bean.getErrorRejectLevel());
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSF_ERROR_CODES");
		}
		return buff.toString();
	}

}
