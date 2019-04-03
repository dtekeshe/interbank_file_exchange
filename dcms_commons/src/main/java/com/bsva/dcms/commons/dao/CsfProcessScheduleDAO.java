package com.bsva.dcms.commons.dao;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsfProcessScheduleDao;
import com.bsva.dcms.commons.dto.CsfProcessScheduleDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfProcessSchedule;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsfProcessScheduleDAO{

	//private CsfProcessScheduleRepository csfProcessSchedulerDao = DaoFactory.csfProcessScheduleInstance();
	
	private CsfProcessScheduleDao csfProcessSchedulerDao = new  CsfProcessScheduleDao();
	private Map<String,Object> map = new HashMap<>();
	public CsfProcessScheduleDAO() {

	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public void create(CsfProcessScheduleDTO bean) throws DAOException{	
		try {
			CsfProcessSchedule csfProcessSchedule = new CsfProcessSchedule();
			csfProcessSchedule.setDayNumber((short) bean.getDayNumber());
			csfProcessSchedule.setProcessIndicator(bean.getProcessIndicator());
			csfProcessSchedulerDao.create(csfProcessSchedule);
		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSF_PROCESS_SCHEDULE, cause: "+ ex.getMessage(), ex);
		}
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsfProcessScheduleDTO retrieve(CsfProcessScheduleDTO bean) throws DAOException {	
		CsfProcessScheduleDTO csfProcessScheduleDTO = new CsfProcessScheduleDTO();
		try {
			String sql = "SELECT c FROM CsfProcessSchedule c" +this.buildWhereClause(bean, true);
			CsfProcessSchedule  processSchedule = (CsfProcessSchedule) csfProcessSchedulerDao.executeQueryParametersSingle(sql, map);

			if(processSchedule.getDayNumber()!=null){
				csfProcessScheduleDTO.setDayNumber((int) processSchedule.getDayNumber());
			}
			if(processSchedule.getProcessIndicator()!=null){
				csfProcessScheduleDTO.setProcessIndicator(processSchedule.getProcessIndicator());
			}
			
			map.clear();
			return csfProcessScheduleDTO;			
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSF_PROCESS_SCHEDULE, cause: "+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	@SuppressWarnings("unchecked")
	public List<CsfProcessScheduleDTO> retrieveRelated(CsfProcessScheduleDTO bean) throws DAOException {
		List<CsfProcessScheduleDTO> dtoList = new LinkedList<>();
		CsfProcessScheduleDTO csfProcessScheduleDTO = null;
		try {
			String sql = "SELECT c FROM CsfProcessSchedule c "+ this.buildWhereClause(bean, true);
			List<CsfProcessSchedule> processScheduleList = (List<CsfProcessSchedule>) csfProcessSchedulerDao.executeQueryParameters(sql, map);
			for (CsfProcessSchedule csfProcessSchedule : processScheduleList) {
				
				csfProcessScheduleDTO = new CsfProcessScheduleDTO();

				if(csfProcessSchedule.getDayNumber()!=null){
					csfProcessScheduleDTO.setDayNumber((int) csfProcessSchedule.getDayNumber());
				}
				if(csfProcessSchedule.getProcessIndicator()!=null){
					csfProcessScheduleDTO.setProcessIndicator(csfProcessSchedule.getProcessIndicator());
				}
				dtoList.add(csfProcessScheduleDTO);
			}
			map.clear();
			return dtoList;			
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSF_PROCESS_SCHEDULE, cause: "+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CsfProcessScheduleDTO bean) throws DAOException {

		CsfProcessSchedule csfProcessSchedule = new CsfProcessSchedule();
		csfProcessSchedule.setDayNumber((short) bean.getDayNumber());
		csfProcessSchedule.setProcessIndicator(bean.getProcessIndicator());
		try {


			csfProcessSchedulerDao.update(csfProcessSchedule);

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSF_PROCESS_SCHEDULE, cause: "+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	public void delete(CsfProcessScheduleDTO bean) throws DAOException {
		try {
			CsfProcessSchedule processScgeduleDelete = new CsfProcessSchedule();
			processScgeduleDelete.setDayNumber((short) bean.getDayNumber());
			processScgeduleDelete.setProcessIndicator(bean.getProcessIndicator());
			csfProcessSchedulerDao.delete(processScgeduleDelete);

		} catch (Exception ex) {
			throw new DAOException("Error deleting CCCOWNER.CSF_PROCESS_SCHEDULE, cause: "+ ex.getMessage(), ex);
		} 

	}

	/**
	 * Populate the query ResultSet.
	 *
	 * @param rs The ResultSet.
	 * @exception SQLException if something is wrong.
	 */
	/*private List getResults(ResultSet rs) throws DAOException {
		try {
			List results = new ArrayList();
			while (rs.next()) {
				CsfProcessScheduleDTO bean = new CsfProcessScheduleDTO();
				bean.setDayNumber(rs.getInt("DAY_NUMBER"));
				bean.setProcessIndicator(rs.getString("PROCESS_INDICATOR"));
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSF_PROCESS_SCHEDULE, cause: "
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
	private String buildWhereClause(CsfProcessScheduleDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (select == true) {
			
		if (bean.getDayNumber() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.dayNumber =:dayNumber");
			map.put("dayNumber",String.valueOf(bean.getDayNumber()));
		}
		
			if (bean.getProcessIndicator() != null && !bean.getProcessIndicator().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.processIndicator =:processIndicator");
				map.put("processIndicator",bean.getProcessIndicator());
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSF_PROCESS_SCHEDULE");
		}
		return buff.toString();
	}

}
