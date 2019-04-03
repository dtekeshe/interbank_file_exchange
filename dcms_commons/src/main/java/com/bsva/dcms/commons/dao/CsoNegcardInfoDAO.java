package com.bsva.dcms.commons.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsoNegcardInfoDao;
import com.bsva.dcms.commons.dto.CsoNegcardInfoDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsoNegcardInfo;
import com.bsva.entities.CsoNegcardInfoPK;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsoNegcardInfoDAO {
	
	private Map<String,Object> map = new HashMap<String, Object>();
	//private CsoNegcardInfoRepository csoNegcardInfoDao = DaoFactory.csoNegcardInfoInstance();
	private CsoNegcardInfoDao csoNegcardInfoDao = new CsoNegcardInfoDao();

	public CsoNegcardInfoDAO() {
	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public CsoNegcardInfoDTO create(CsoNegcardInfoDTO bean) throws DAOException {

		try {

			CsoNegcardInfo csoNegcardInfo = new CsoNegcardInfo();
			csoNegcardInfo.setNegCardCount(bean.getNegCardCount());
			CsoNegcardInfoPK csoNegcardInfoPK = new CsoNegcardInfoPK();
			csoNegcardInfoPK.setFileOriginator(String.valueOf(bean.getFileOriginator()));
			csoNegcardInfoPK.setOutputDate(bean.getOutputDate());
			csoNegcardInfo.setCsoNegcardInfoPK(csoNegcardInfoPK);
			csoNegcardInfoDao.create(csoNegcardInfo);

			return bean;

		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSO_NEGCARD_INFO, cause: "+ ex.getMessage(), ex);
		}
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsoNegcardInfoDTO retrieve(CsoNegcardInfoDTO bean) throws DAOException {
		CsoNegcardInfoDTO csoNegcardInfoDTO = new CsoNegcardInfoDTO();
		try {
			String sql = "SELECT c FROM CsoNegcardInfo c "+ this.buildWhereClause(bean, true);

			CsoNegcardInfo csoNegcardInfo = csoNegcardInfoDao.executeQueryParametersSingleDate(sql, map);
			csoNegcardInfoDTO.setFileOriginator(Integer.valueOf(csoNegcardInfo.getCsoNegcardInfoPK().getFileOriginator()));
			csoNegcardInfoDTO.setNegCardCount(csoNegcardInfo.getNegCardCount());
			csoNegcardInfoDTO.setOutputDate(csoNegcardInfo.getCsoNegcardInfoPK().getOutputDate());
			map.clear();
			return csoNegcardInfoDTO;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_NEGCARD_INFO, cause: "+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	@SuppressWarnings("unchecked")
	public List<CsoNegcardInfoDTO> retrieveRelated(CsoNegcardInfoDTO bean) throws DAOException {
		List<CsoNegcardInfoDTO> dtoList = new LinkedList<>();
		CsoNegcardInfoDTO csoNegcardInfoDTO = null;
		try {
			String sql = "SELECT c FROM CsoNegcardInfo c "+ this.buildWhereClause(bean, true);
			List<CsoNegcardInfo> csoNegcardInfo = csoNegcardInfoDao.executeQueryParametersDate(sql, map);
			for (CsoNegcardInfo csoNegcardInfo2 : csoNegcardInfo) {
				
				csoNegcardInfoDTO = new CsoNegcardInfoDTO();
				
				csoNegcardInfoDTO.setFileOriginator(Integer.valueOf(csoNegcardInfo2.getCsoNegcardInfoPK().getFileOriginator()));
				csoNegcardInfoDTO.setNegCardCount(csoNegcardInfo2.getNegCardCount());
				csoNegcardInfoDTO.setOutputDate(csoNegcardInfo2.getCsoNegcardInfoPK().getOutputDate());
				dtoList.add(csoNegcardInfoDTO);
			}
			map.clear();
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_NEGCARD_INFO, cause: "+ ex.getMessage(), ex);
		}
	}
	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CsoNegcardInfoDTO bean) throws DAOException {

		CsoNegcardInfo csoNegcardInfo = new CsoNegcardInfo();
		csoNegcardInfo.setNegCardCount(bean.getNegCardCount());	
		CsoNegcardInfoPK csoNegcardInfoPK = new CsoNegcardInfoPK();
		csoNegcardInfoPK.setFileOriginator(String.valueOf(bean.getFileOriginator()));
		csoNegcardInfoPK.setOutputDate(bean.getOutputDate());
		csoNegcardInfo.setCsoNegcardInfoPK(csoNegcardInfoPK);

		try {

			csoNegcardInfoDao.update(csoNegcardInfo);

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSO_NEGCARD_INFO, cause: "+ ex.getMessage(), ex);
		}
	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */
	
	
	public void delete(CsoNegcardInfoDTO bean) throws DAOException {
	
		try{

			CsoNegcardInfo csoNegcardInfo = new CsoNegcardInfo();
			csoNegcardInfo.setNegCardCount(bean.getNegCardCount());
			csoNegcardInfo.getCsoNegcardInfoPK().setFileOriginator(String.valueOf(bean.getFileOriginator()));
			csoNegcardInfo.getCsoNegcardInfoPK().setOutputDate(bean.getOutputDate());	
			csoNegcardInfoDao.delete(csoNegcardInfo);

		} catch (Exception ex) {
			throw new DAOException("Error Deleting CCCOWNER.CSO_NEGCARD_INFO, cause: "+ ex.getMessage(), ex);
		} 

	}

	/**
	 * Retrieve a record count from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */
	public int retrieveRowCount(CsoNegcardInfoDTO bean) throws DAOException {

		try {
			String sql = "SELECT COUNT(*) AS count FROM CsoNegcardInfo "+ this.buildWhereClause(bean,true);
			int count = (int) csoNegcardInfoDao.executeCountQuery(sql);
			return count;
			
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_NEGCARD_INFO, cause: "+ ex.getMessage(), ex);
		} 		
	}

	public List<CsoNegcardInfoDTO> retrieveUniqueFileOriginator(String processDate) throws DAOException {
		List<CsoNegcardInfoDTO> results = new ArrayList<>();
		CsoNegcardInfoDTO csoNegcardInfoDTO = new CsoNegcardInfoDTO();

		try {
			String sql = "SELECT DISTINCT(fileOriginator) FROM CsoNegcardInfo WHERE outputDate ="+processDate;
			List<CsoNegcardInfo> csoNegcardInfo =  csoNegcardInfoDao.executeTypeQuery(sql);
			for (CsoNegcardInfo csoNegcardInfo2 : csoNegcardInfo) {
				csoNegcardInfoDTO.setFileOriginator(Integer.valueOf(csoNegcardInfo2.getCsoNegcardInfoPK().getFileOriginator()));
				csoNegcardInfoDTO.setNegCardCount(csoNegcardInfo2.getNegCardCount());
				csoNegcardInfoDTO.setOutputDate(csoNegcardInfo2.getCsoNegcardInfoPK().getOutputDate());
				results.add(csoNegcardInfoDTO);
			}
			return results;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CsoNegcardInfo, cause: "+ ex.getMessage(), ex);
		} 
	}
	
	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsoNegcardInfoDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (select == true) {
			if (bean.getFileOriginator() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("c.csoNegcardInfoPK.fileOriginator =:fileOriginator");
				map.put("fileOriginator",String.valueOf(bean.getFileOriginator()));		
			}
			if (bean.getOutputDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("c.csoNegcardInfoPK.outputDate =:outputDate");
				map.put("outputDate",bean.getOutputDate());
			}
			if (bean.getNegCardCount() > 0L) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("c.negCardCount =:negCardCount");
				map.put("negCardCount",String.valueOf(bean.getNegCardCount()));
			}

			
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot Build all rows in CCCOWNER.CSO_NEGCARD_INFO");
		}
		return buff.toString();
	}
	
	public void delete() throws DAOException {
		//csoNegcardInfoDao.deleteBulk("Delete from CsoNegcardInfo");
		csoNegcardInfoDao.deleteTruncate("TRUNCATE TABLE CSO_NEGATIVE_CARDS");
	}

	
}
