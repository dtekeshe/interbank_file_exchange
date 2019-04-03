package com.bsva.dcms.commons.dao;



import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsoOdsFileToLoadDao;
import com.bsva.dcms.commons.dto.CsoOdsFileToLoadDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsoOdsFileToLoad;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsoOdsFileToLoadDAO{


	//private CsoOdsFileToLoadRepository csoOdsFileToLoadDao = DaoFactory.csoOdsFileToLoadInstance();
	private CsoOdsFileToLoadDao csoOdsFileToLoadDao = new CsoOdsFileToLoadDao();
	private Map<String,Object> map = new HashMap<String, Object>();

	public CsoOdsFileToLoadDAO() {

	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public CsoOdsFileToLoadDTO create(CsoOdsFileToLoadDTO bean) throws DAOException {	
		try {
			CsoOdsFileToLoad csoOdsFileToLoad = new CsoOdsFileToLoad();
			csoOdsFileToLoad.setFilename(bean.getFilename());
			csoOdsFileToLoad.setFileRefNumber(bean.getFileRefNumber());
			csoOdsFileToLoad.setFileformat(bean.getFileformat());
			csoOdsFileToLoad.setSeqNo(bean.getSeqNo());
			csoOdsFileToLoad.setStatus(bean.getStatus());
			csoOdsFileToLoadDao.create(csoOdsFileToLoad);
			return bean;
		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSO_ODS_FILE_TO_LOAD, cause: "
					+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsoOdsFileToLoadDTO retrieve(CsoOdsFileToLoadDTO bean) throws DAOException {
		CsoOdsFileToLoadDTO csoOdsFileToLoadDTO = new CsoOdsFileToLoadDTO();
		try {
			String sql = "SELECT c FROM CsoOdsFileToLoad c "+ this.buildWhereClause(bean, true);
			CsoOdsFileToLoad csoOdsFileToLoad = csoOdsFileToLoadDao.executeQueryParametersSingle(sql,map);		

			if(csoOdsFileToLoad.getFileformat()!=null){
				csoOdsFileToLoadDTO.setFileformat(csoOdsFileToLoad.getFileformat());
			}
			if(csoOdsFileToLoad.getFilename()!=null){
				csoOdsFileToLoadDTO.setFilename(csoOdsFileToLoad.getFilename());
			}
			if(csoOdsFileToLoad.getFileRefNumber()!=null){
				csoOdsFileToLoadDTO.setFileRefNumber(csoOdsFileToLoad.getFileRefNumber());
			}
			//if(csoOdsFileToLoad.getSeqNo()!=null){
			csoOdsFileToLoadDTO.setSeqNo(csoOdsFileToLoad.getSeqNo());
			//}
			if(csoOdsFileToLoad.getStatus()!=null){
				csoOdsFileToLoadDTO.setStatus(csoOdsFileToLoad.getStatus());	
			}
			map.clear();
			return csoOdsFileToLoadDTO;			
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_ODS_FILE_TO_LOAD, cause: "
					+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	@SuppressWarnings("unchecked")
	public List<CsoOdsFileToLoadDTO> retrieveRelated(CsoOdsFileToLoadDTO bean) throws DAOException {
		List<CsoOdsFileToLoadDTO> dtoList = new LinkedList<>();
		CsoOdsFileToLoadDTO csoOdsFileToLoadDTO = null;
		try {
			String sql = "SELECT c FROM CsoOdsFileToLoad c "+ this.buildWhereClause(bean, true);
			List<CsoOdsFileToLoad> csoOdsFileToLoad2 = csoOdsFileToLoadDao.executeQueryParameters(sql, map);
			for (CsoOdsFileToLoad csoOdsFileToLoad : csoOdsFileToLoad2) {			

				csoOdsFileToLoadDTO = new CsoOdsFileToLoadDTO();
				if(csoOdsFileToLoad.getFileformat()!=null){
					csoOdsFileToLoadDTO.setFileformat(csoOdsFileToLoad.getFileformat());
				}
				if(csoOdsFileToLoad.getFilename()!=null){
					csoOdsFileToLoadDTO.setFilename(csoOdsFileToLoad.getFilename());
				}
				if(csoOdsFileToLoad.getFileRefNumber()!=null){
					csoOdsFileToLoadDTO.setFileRefNumber(csoOdsFileToLoad.getFileRefNumber());
				}
				//if(csoOdsFileToLoad.getSeqNo()!=null){
				csoOdsFileToLoadDTO.setSeqNo(csoOdsFileToLoad.getSeqNo());
				//}
				if(csoOdsFileToLoad.getStatus()!=null){
					csoOdsFileToLoadDTO.setStatus(csoOdsFileToLoad.getStatus());	
				}
				dtoList.add(csoOdsFileToLoadDTO);			 
			}		
			map.clear();
			return dtoList;		
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_ODS_FILE_TO_LOAD, cause: "+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CsoOdsFileToLoadDTO bean) throws DAOException {

		CsoOdsFileToLoad csoOdsFileToLoad = new CsoOdsFileToLoad();
		csoOdsFileToLoad.setFilename(bean.getFilename());
		csoOdsFileToLoad.setFileRefNumber(bean.getFileRefNumber());
		csoOdsFileToLoad.setFileformat(bean.getFileformat());
		csoOdsFileToLoad.setSeqNo(bean.getSeqNo());
		csoOdsFileToLoad.setStatus(bean.getStatus());

		try {

			csoOdsFileToLoadDao.update(csoOdsFileToLoad);

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSO_ODS_FILE_TO_LOAD, cause: "
					+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	public void delete(CsoOdsFileToLoadDTO bean) throws DAOException {
		try {
			CsoOdsFileToLoad csoOdsFileToLoad = new CsoOdsFileToLoad();
			csoOdsFileToLoad.setFilename(bean.getFilename());
			csoOdsFileToLoad.setFileRefNumber(bean.getFileRefNumber());
			csoOdsFileToLoad.setFileformat(bean.getFileformat());
			csoOdsFileToLoad.setSeqNo(bean.getSeqNo());
			csoOdsFileToLoad.setStatus(bean.getStatus());			
			csoOdsFileToLoadDao.delete(csoOdsFileToLoad);

		} catch (Exception ex) {
			throw new DAOException("Error deleting CCCOWNER.CSO_ODS_FILE_TO_LOAD, cause: "
					+ ex.getMessage(), ex);
		}
	}
	
	public void delete(String deletequery) throws DAOException {
		
		csoOdsFileToLoadDao.deleteBulk(deletequery);
	}


	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsoOdsFileToLoadDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		if (select == true) {
			
		if (bean.getFilename() != null && !bean.getFilename().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.filename =:filename");
			map.put("filename",bean.getFilename());	
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
		if (bean.getSeqNo() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.seqNo =:seqNo");
			map.put("seqNo",String.valueOf(bean.getSeqNo()));
		}
		
			if (bean.getFileformat() != null && !bean.getFileformat().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.fileformat =:fileformat");
				map.put("fileformat",bean.getFileformat());
			}
			if (bean.getStatus() != null && !bean.getStatus().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.status =:status");
				map.put("status",bean.getStatus());
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot build all rows in CCCOWNER.CSO_ODS_FILE_TO_LOAD");
		}
		return buff.toString();
	}
	public void delete() throws DAOException {
	 csoOdsFileToLoadDao.deleteBulk("Delete from CsoOdsFileToLoad");
	}
}
