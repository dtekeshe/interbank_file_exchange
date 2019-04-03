package com.bsva.dcms.commons.dao;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsfPublicHolidaysDao;
import com.bsva.dcms.commons.dto.CsfPublicHolidaysDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfPublicHolidays;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsfPublicHolidaysDAO{

	//private CsfPublicHolidaysRepository  csfPublicHolidaysDao = DaoFactory.csfPublicHolidaysInstance();
	private CsfPublicHolidaysDao  csfPublicHolidaysDao = new CsfPublicHolidaysDao();
	
	private Map<String,Object> map = new HashMap<String, Object>();

	public CsfPublicHolidaysDAO() {

	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public void create(CsfPublicHolidaysDTO bean) throws DAOException {
		try {
			CsfPublicHolidays publicHolidays = new CsfPublicHolidays();
			publicHolidays.setProcessDate(bean.getProcessDate());
			publicHolidays.setPublicHolidayIndicator(bean.getPublicHolidayIndicator());
			csfPublicHolidaysDao.create(publicHolidays);
		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSF_PUBLIC_HOLIDAYS, cause: "+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsfPublicHolidaysDTO retrieve(CsfPublicHolidaysDTO bean) throws DAOException {

		CsfPublicHolidaysDTO csfPublicHolidaysDTO = new CsfPublicHolidaysDTO();

		try {

			String sql ="SELECT c FROM CsfPublicHolidays c"+ this.buildWhereClause(bean, true);
			CsfPublicHolidays publicHolidays = csfPublicHolidaysDao.executeQueryParametersSingleDate(sql, map);
            if(publicHolidays != null){
			if(publicHolidays.getProcessDate()!=null){
				csfPublicHolidaysDTO.setProcessDate(publicHolidays.getProcessDate());
			}
			if(publicHolidays.getPublicHolidayIndicator()!=null){
				csfPublicHolidaysDTO.setPublicHolidayIndicator(publicHolidays.getPublicHolidayIndicator());
			}
			map.clear();
			return csfPublicHolidaysDTO;
            }else{
			  return null;
            }
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSF_PUBLIC_HOLIDAYS, cause: "+ ex.getMessage(), ex);
		}
	}

	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public List<CsfPublicHolidaysDTO> retrieveByCondition(CsfPublicHolidaysDTO bean) throws DAOException {

		List<CsfPublicHolidaysDTO> dtoList = new LinkedList<>();	

		CsfPublicHolidaysDTO csfPublicHolidaysDTO = null;

		try {
			String sql = "SELECT c FROM CsfPublicHolidays c "+ this.buildWhereClause(bean, true);
			List<CsfPublicHolidays> publicHolidays =  csfPublicHolidaysDao.executeQueryParametersDate(sql, map);

			for (CsfPublicHolidays csfPublicHolidays : publicHolidays) {
				
				csfPublicHolidaysDTO = new CsfPublicHolidaysDTO();

				if(csfPublicHolidays.getProcessDate()!=null){
					csfPublicHolidaysDTO.setProcessDate(csfPublicHolidays.getProcessDate());
				}
				if(csfPublicHolidays.getPublicHolidayIndicator()!=null){
					csfPublicHolidaysDTO.setPublicHolidayIndicator(csfPublicHolidays.getPublicHolidayIndicator());
				}
				dtoList.add(csfPublicHolidaysDTO);
			}
			map.clear();
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSF_PUBLIC_HOLIDAYS, cause: "+ ex.getMessage(), ex);
		}
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */


	public List<CsfPublicHolidaysDTO> retrieveRelated(CsfPublicHolidaysDTO bean) throws DAOException {

		List<CsfPublicHolidaysDTO> dtoList = new LinkedList<>();

		CsfPublicHolidaysDTO csfPublicHolidaysDTO = new CsfPublicHolidaysDTO();

		try {
			String sql = "SELECT c FROM CsfPublicHolidays c ";
			sql += this.buildWhereClause(bean, true);
			List<CsfPublicHolidays> publicHolidays =  csfPublicHolidaysDao.executeQueryParameters(sql, map);

			for (CsfPublicHolidays csfPublicHolidays : publicHolidays) {

				if(csfPublicHolidays.getProcessDate()!=null){
					csfPublicHolidaysDTO.setProcessDate(csfPublicHolidays.getProcessDate());
				}
				if(csfPublicHolidays.getPublicHolidayIndicator()!=null){
					csfPublicHolidaysDTO.setPublicHolidayIndicator(csfPublicHolidays.getPublicHolidayIndicator());
				}
				dtoList.add(csfPublicHolidaysDTO);
			}
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSF_PUBLIC_HOLIDAYS, cause: "+ ex.getMessage(), ex);
		}
	}
	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CsfPublicHolidaysDTO bean) throws DAOException {

		CsfPublicHolidays publicHolidays = new CsfPublicHolidays();
		publicHolidays.setProcessDate(bean.getProcessDate());
		publicHolidays.setPublicHolidayIndicator(bean.getPublicHolidayIndicator());
		try {

			csfPublicHolidaysDao.update(publicHolidays);

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSF_PUBLIC_HOLIDAYS, cause: "+ ex.getMessage(), ex);
		}
	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	
	public void delete(CsfPublicHolidaysDTO bean) throws DAOException {
			try {
				CsfPublicHolidays publicHolidays = new CsfPublicHolidays();
				publicHolidays.setProcessDate(bean.getProcessDate());
				publicHolidays.setPublicHolidayIndicator(bean.getPublicHolidayIndicator());
				csfPublicHolidaysDao.delete(publicHolidays);
			} catch (Exception ex) {
				throw new DAOException("Error creating CCCOWNER.CSF_PUBLIC_HOLIDAYS, cause: "+ ex.getMessage(), ex);
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
				CsfPublicHolidaysDTO bean = new CsfPublicHolidaysDTO();
				bean.setProcessDate(rs.getDate("PROCESS_DATE"));
				bean.setPublicHolidayIndicator(rs.getString("PUBLIC_HOLIDAY_INDICATOR"));
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSF_PUBLIC_HOLIDAYS, cause: "
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
	private String buildWhereClause(CsfPublicHolidaysDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		
		if (select == true) {
		if (bean.getProcessDate() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
            Date date = bean.getProcessDate();
           // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 00:00:00.0");
    	   // String processingDate = formatter.format(date);
            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
			buff.append("c.processDate =:processDate");
			map.put("processDate",sqlStartDate);
		}
		
			if (bean.getPublicHolidayIndicator() != null && !bean.getPublicHolidayIndicator().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.publicHolidayIndicator =:publicHolidayIndicator");
				map.put("publicHolidayIndicator",bean.getPublicHolidayIndicator());
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSF_PUBLIC_HOLIDAYS");
		}
		return buff.toString();
	}

}
