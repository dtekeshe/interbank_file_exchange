package com.bsva.dcms.commons.dao;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsfSystemServiceDao;
import com.bsva.dcms.commons.dto.CsfSystemServiceDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfSystemService;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsfSystemServiceDAO{
	
	//private CsfSystemServiceRepository systemServiceDao = DaoFactory.csfSystemServiceInstance();
	private CsfSystemServiceDao systemServiceDao = new CsfSystemServiceDao();
	private Map<String,Object> map = new HashMap<String, Object>();

	public CsfSystemServiceDAO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public CsfSystemServiceDTO create(CsfSystemServiceDTO bean) throws DAOException {
		try {
			CsfSystemService service = new CsfSystemService();
			service.setServiceCode(bean.getServiceCode());
			systemServiceDao.create(service);

			return bean;

		} catch (Exception ex) {
			throw new DAOException( "Error creating CCCOWNER.CSF_SYSTEM_SERVICE, cause: "+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsfSystemServiceDTO retrieve(CsfSystemServiceDTO bean) throws DAOException {
		CsfSystemServiceDTO csfSystemServiceDTO = new CsfSystemServiceDTO();
		try {
			String sql = "SELECT c FROM CsfSystemService c "+buildWhereClause(bean,true);

			CsfSystemService csfSystemService = systemServiceDao.executeQueryParametersSingle(sql, map);

			csfSystemServiceDTO.setServiceCode(csfSystemService.getServiceCode());
			map.clear();
			return csfSystemServiceDTO;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CsfSystemService, cause: "+ ex.getMessage(), ex);
		}
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public List<CsfSystemServiceDTO> retrieveRelated(CsfSystemServiceDTO bean) throws DAOException {
		List<CsfSystemServiceDTO> dtoList = new LinkedList<>();
		CsfSystemServiceDTO csfSystemServiceDTO;
		try {
			String sql = "SELECT c FROM CsfSystemService c "+ buildWhereClause(bean, true);
			List<CsfSystemService> systemService = systemServiceDao.executeQueryParameters(sql,map);
			for (CsfSystemService csfSystemService : systemService) {	
				csfSystemServiceDTO = new CsfSystemServiceDTO();
				csfSystemServiceDTO.setServiceCode(csfSystemService.getServiceCode());	
				dtoList.add(csfSystemServiceDTO);
			}
			map.clear();
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CsfSystemService, cause: "+ ex.getMessage(), ex);
		}
	}

	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CsfSystemServiceDTO bean) throws DAOException {

		CsfSystemService service = new CsfSystemService();
		service.setServiceCode(bean.getServiceCode());
		
		try {

			systemServiceDao.update(service);

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSF_SYSTEM_SERVICE, cause: "+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	public void delete(CsfSystemServiceDTO bean) throws DAOException {
		try {
			CsfSystemService service = new CsfSystemService();
			service.setServiceCode(bean.getServiceCode());
			systemServiceDao.delete(service);

		} catch (Exception ex) {
			throw new DAOException( "Error creating CCCOWNER.CSF_SYSTEM_SERVICE, cause: "+ ex.getMessage(), ex);
		}

	}
	/**
	 * Retrieve a record count from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */
	public int retrieveRowCount(CsfSystemServiceDTO bean) throws DAOException {	
		try {
			String sql = "SELECT COUNT(*) AS count FROM CsfSystemService ";
			int count = (int) systemServiceDao.executeCountQuery(sql);

			return count;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CsfSystemService, cause: "+ ex.getMessage(), ex);
		}
	}

	/**
	 * Populate the query ResultSet.
	 *
	 * @param rs The ResultSet.
	 * @exception SQLException if something is wrong.
	 */
/*	private List getResults(ResultSet rs) throws DAOException {
		try {
			List results = new ArrayList();
			while (rs.next()) {
				CsfSystemServiceDTO bean = new CsfSystemServiceDTO();
				bean.setServiceCode(rs.getString("SERVICE_CODE"));
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSF_SYSTEM_SERVICE, cause: "
					+ ex.getMessage(), ex);
		} finally {
		}
	}*/
	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsfSystemServiceDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		
		if (select == true) {

		if (bean.getServiceCode() != null && !bean.getServiceCode().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			buff.append("c.serviceCode =:serviceCode");
			map.put("serviceCode",bean.getServiceCode());
		 }
		
		}
		if(!whereClause && select == false) {
			throw new DAOException( "Cannot update delete all rows in CsfSystemService");
		}
		return buff.toString();
	}

	/**
	 * Build a Dynamic Parameter Class.
	 *
	 * @param bean The Object to be inserted.
	 * @param ps The Prepared Statement.
	 * @param pos offset for parameters.
	 * @param select Is parameters for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private void setParameters(CsfSystemServiceDTO bean, int pos, boolean select) throws DAOException {
		StringBuilder sb = new StringBuilder();
		if(bean == null) {
			return;
		}
		try {
			if (bean.getServiceCode() != null && !bean.getServiceCode().isEmpty()) {
				sb.append(bean.getServiceCode());
				sb.append(",");
			}
			if (select == true) {
			}

		} catch (Exception ex) {
			throw new DAOException("Error getting results CsfSystemService, cause: "+ ex.getMessage(), ex);
		}
	}

}
