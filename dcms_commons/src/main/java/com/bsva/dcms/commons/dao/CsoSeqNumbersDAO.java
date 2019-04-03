package com.bsva.dcms.commons.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsoSeqNumbersDao;
import com.bsva.dcms.commons.dto.CsoSeqNumbersDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsoSeqNumbers;
import com.bsva.entities.CsoSeqNumbersPK;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsoSeqNumbersDAO{
	private String SQL_SELECT = 			"";
	private String SQL_SELECT_COUNT = 			"";
	
	//private CsoSeqNumbersRepository csoSeqNumbersDao =  DaoFactory.csoSeqNumbersInstance();
	
	private CsoSeqNumbersDao csoSeqNumbersDao =  new CsoSeqNumbersDao();
	//private List<String> map = new ArrayList<String>();
	private Map<String,Object>map = new HashMap<String, Object>();

	public CsoSeqNumbersDAO() {
	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public void create(CsoSeqNumbersDTO bean) throws DAOException {
		
		try {
			CsoSeqNumbers csoSeqNumbers = new CsoSeqNumbers();
			CsoSeqNumbersPK csoSeqNumbersPK = new CsoSeqNumbersPK();
			csoSeqNumbersPK.setExternalFilenamePrefix(bean.getExternalFilenamePrefix());
			csoSeqNumbersPK.setDistributionCode(bean.getDistributionCode());
			csoSeqNumbers.setLastSeqNumberUsed((short) bean.getLastSeqNumberUsed());
			csoSeqNumbers.setCsoSeqNumbersPK(csoSeqNumbersPK);			
			csoSeqNumbersDao.create(csoSeqNumbers);
			
		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSO_SEQ_NUMBERS, cause: "
					+ ex.getMessage(), ex);
		}
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsoSeqNumbersDTO retrieve(CsoSeqNumbersDTO bean) throws DAOException {
	
		CsoSeqNumbersDTO dto = new CsoSeqNumbersDTO();
		try {
			
			SQL_SELECT = "SELECT c FROM CsoSeqNumbers c " +this.buildWhereClause(bean, true);
			
			CsoSeqNumbers csoSeqNumbers = csoSeqNumbersDao.executeQueryParametersSingleDate(SQL_SELECT,map);
			
			if(csoSeqNumbers.getCsoSeqNumbersPK().getDistributionCode()!=null){
			dto.setDistributionCode(csoSeqNumbers.getCsoSeqNumbersPK().getDistributionCode());
			}
			if(csoSeqNumbers.getCsoSeqNumbersPK().getExternalFilenamePrefix()!=null){
			dto.setExternalFilenamePrefix(csoSeqNumbers.getCsoSeqNumbersPK().getExternalFilenamePrefix());
			}
			//if(csoSeqNumbers.getLastSeqNumberUsed()!=null){
			dto.setLastSeqNumberUsed(csoSeqNumbers.getLastSeqNumberUsed());		
			//}
			map.clear();
			return dto;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_SEQ_NUMBERS, cause: "
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
	public List<CsoSeqNumbersDTO> retrieveRelated(CsoSeqNumbersDTO bean) throws DAOException {
		List<CsoSeqNumbersDTO> dtoList = new LinkedList<CsoSeqNumbersDTO>();
		CsoSeqNumbersDTO csoSeqNumbersDTO = null;
		try {
			SQL_SELECT = "SELECT c FROM CsoSeqNumbersDTO c "+buildWhereClause(bean, true);
			List<CsoSeqNumbers> csoSeqNumber = csoSeqNumbersDao.executeQueryParametersDate(SQL_SELECT, map);
			for (CsoSeqNumbers csoSeqNumbers : csoSeqNumber) {
				
				csoSeqNumbersDTO = new CsoSeqNumbersDTO();
				if(csoSeqNumbers.getCsoSeqNumbersPK().getDistributionCode()!=null){
					csoSeqNumbersDTO.setDistributionCode(csoSeqNumbers.getCsoSeqNumbersPK().getDistributionCode());
				}
				if(csoSeqNumbers.getCsoSeqNumbersPK().getExternalFilenamePrefix()!=null){
					csoSeqNumbersDTO.setExternalFilenamePrefix(csoSeqNumbers.getCsoSeqNumbersPK().getExternalFilenamePrefix());
				}
				//if(csoSeqNumbers.getLastSeqNumberUsed()!=null){
				csoSeqNumbersDTO.setLastSeqNumberUsed(csoSeqNumbers.getLastSeqNumberUsed());		
				//}
				dtoList.add(csoSeqNumbersDTO);
			}
			map.clear();
			return dtoList;			
		} catch (Exception ex) {
			throw new DAOException("Error retrieving  CCCOWNER.CSO_SEQ_NUMBERS, cause: "+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CsoSeqNumbersDTO bean) throws DAOException {
		try{
			CsoSeqNumbers csoSeqNumbers = new CsoSeqNumbers();
			CsoSeqNumbersPK csoSeqNumbersPK = new CsoSeqNumbersPK();
			csoSeqNumbersPK.setExternalFilenamePrefix(bean.getExternalFilenamePrefix());
			csoSeqNumbersPK.setDistributionCode(bean.getDistributionCode());
			csoSeqNumbers.setLastSeqNumberUsed((short) bean.getLastSeqNumberUsed());
			csoSeqNumbers.setCsoSeqNumbersPK(csoSeqNumbersPK);
			csoSeqNumbersDao.update(csoSeqNumbers);

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSO_SEQ_NUMBERS, cause: "
					+ ex.getMessage(), ex);
		} 

	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	public void delete(CsoSeqNumbersDTO bean) throws DAOException {
		try {
			CsoSeqNumbers csoSeqNumbers = new CsoSeqNumbers();
			CsoSeqNumbersPK csoSeqNumbersPK = new CsoSeqNumbersPK();
			csoSeqNumbersPK.setDistributionCode(bean.getDistributionCode());
			csoSeqNumbersPK.setExternalFilenamePrefix(bean.getExternalFilenamePrefix());
			csoSeqNumbers.setCsoSeqNumbersPK(csoSeqNumbersPK);			
			csoSeqNumbers.setLastSeqNumberUsed((short) bean.getLastSeqNumberUsed());
			csoSeqNumbersDao.delete(csoSeqNumbers);

		} catch (Exception ex) {
			throw new DAOException("Error deleting CCCOWNER.CSO_SEQ_NUMBERS, cause: "
					+ ex.getMessage(), ex);
		} 

	}
	/**
	 * Retrieve a record count from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */
	public Long retrieveRowCount(CsoSeqNumbersDTO bean) throws DAOException {
		try {
			SQL_SELECT_COUNT = "SELECT COUNT(*) AS count FROM CsoSeqNumbers ";
			//SQL_SELECT_COUNT += this.buildWhereClause(bean, true);

			Long count = (Long) csoSeqNumbersDao.executeCountQuery(SQL_SELECT_COUNT);

			return count;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_SEQ_NUMBERS, cause: "+ ex.getMessage(), ex);
		}
	}

	/**
	 * Populate the query ResultSet.
	 *
	 * @param rs The ResultSet.
	 * @exception SQLException if something is wrong.
	 */
	private List getResults(ResultSet rs) throws DAOException {
		try {
			List results = new ArrayList();
			while (rs.next()) {
				CsoSeqNumbersDTO bean = new CsoSeqNumbersDTO();
				bean.setExternalFilenamePrefix(rs.getString("EXTERNAL_FILENAME_PREFIX"));
				bean.setDistributionCode(rs.getString("DISTRIBUTION_CODE"));
				bean.setLastSeqNumberUsed(rs.getInt("LAST_SEQ_NUMBER_USED"));
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSO_SEQ_NUMBERS, cause: "
					+ ex.getMessage(), ex);
		} finally {
		}
	}
	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsoSeqNumbersDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (select == true) {
			if (bean.getExternalFilenamePrefix() != null && !bean.getExternalFilenamePrefix().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
			
				buff.append("c.csoSeqNumbersPK.externalFilenamePrefix = :externalFilenamePrefix");
				map.put("externalFilenamePrefix",bean.getExternalFilenamePrefix());
			}
			if (bean.getDistributionCode() != null && !bean.getDistributionCode().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
			
				buff.append("c.csoSeqNumbersPK.distributionCode = :distributionCode");
				map.put("distributionCode",bean.getDistributionCode());
			}
			if (bean.getLastSeqNumberUsed() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
			
				buff.append("c.lastSeqNumberUsed = :lastSeqNumberUsed");
				map.put("lastSeqNumberUsed",String.valueOf(bean.getLastSeqNumberUsed()));
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot Build where clause in CCCOWNER.CSO_SEQ_NUMBERS");
		}
		return buff.toString();
	}
	
	public void delete()throws DAOException{
		try{
		//csoSeqNumbersDao.deleteBulk("Delete from CsoSeqNumbers");
		csoSeqNumbersDao.deleteTruncate("TRUNCATE TABLE CSO_SEQ_NUMBERS");
		}
		catch(Exception e){
			throw new DAOException("Cannot Delete all rows in CCCOWNER.CSO_SEQ_NUMBERS");			
		}
		
	}

}
