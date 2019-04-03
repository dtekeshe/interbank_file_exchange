package com.bsva.dcms.commons.dao;


import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsfScheduleTimesDao;
import com.bsva.dcms.commons.dto.CSFScheduleTimesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfScheduleTimes;
import com.bsva.entities.CsfScheduleTimesPK;



/**
 *
 * @author Nombuyiselo Mbangula <nombuyiselom@bankservafrica.com>
 */

public class CSFScheduleTimesDAO {

	private Map<String,Object> map = new HashMap<String, Object>();
	//private CsfScheduleTimesRepository csfScheduleTineDao = DaoFactory.csfScheduleTimesInstance();
	private CsfScheduleTimesDao csfScheduleTimesDao = new CsfScheduleTimesDao();

	public CSFScheduleTimesDAO() {

	}
	public void create(CSFScheduleTimesDTO csfScheduleTimesDTO) throws DAOException {

		try {
			CsfScheduleTimes scheduleTimes = new CsfScheduleTimes();			
			CsfScheduleTimesPK csfScheduleTimesPK = new CsfScheduleTimesPK();
			csfScheduleTimesPK.setProcess(csfScheduleTimesDTO.getProcess());
			csfScheduleTimesPK.setService(csfScheduleTimesDTO.getService());
			csfScheduleTimesPK.setSubService(csfScheduleTimesDTO.getSubService());
			
			scheduleTimes.setCsfScheduleTimesPK(csfScheduleTimesPK);
			scheduleTimes.setStartTime(csfScheduleTimesDTO.getStartTime());
			scheduleTimes.setEndTime(csfScheduleTimesDTO.getEndTime());
			scheduleTimes.setLastRunTime(csfScheduleTimesDTO.getLastRunTime());
			scheduleTimes.setActiveInd(csfScheduleTimesDTO.getActiveInd());
			scheduleTimes.setBusyInd(csfScheduleTimesDTO.getBusyInd());;
			scheduleTimes.setCheckPoint(csfScheduleTimesDTO.getCheckPoint());
			scheduleTimes.setCheckpointname(csfScheduleTimesDTO.getCheckPointName());

			csfScheduleTimesDao.create(scheduleTimes);

		} catch (Exception ex) {
			throw new DAOException("Error creating CSF_SCHEDULE_TIMES entry, cause: "+ ex.getMessage(), ex);
		}
	}

	/**
	 *  retrieving CSF_SCHEDULE_TIMES entries
	 */

	public CSFScheduleTimesDTO retrieve(CSFScheduleTimesDTO obj) throws DAOException {
		CSFScheduleTimesDTO dto = null;
		try {

			String sql = "SELECT c FROM CsfScheduleTimes "+ buildWhereClause(obj,true);
			CsfScheduleTimes scheduleTimes = csfScheduleTimesDao.executeQueryParametersSingle(sql, map);


			dto = new CSFScheduleTimesDTO();

			if(scheduleTimes.getCsfScheduleTimesPK().getProcess()!=null){
				dto.setProcess(scheduleTimes.getCsfScheduleTimesPK().getProcess());
			}
			if(scheduleTimes.getCsfScheduleTimesPK().getService()!=null){
				dto.setService(scheduleTimes.getCsfScheduleTimesPK().getService());
			}
			if(scheduleTimes.getCsfScheduleTimesPK().getSubService()!=null){
				dto.setSubService(scheduleTimes.getCsfScheduleTimesPK().getSubService());
			}
			if(scheduleTimes.getStartTime()!=null){
				dto.setStartTime(scheduleTimes.getStartTime());
			}
			if(scheduleTimes.getEndTime()!=null){
				dto.setEndTime(scheduleTimes.getEndTime());
			}
			if(scheduleTimes.getLastRunTime()!=null){
				dto.setLastRunTime(scheduleTimes.getLastRunTime());
			}
			if(scheduleTimes.getActiveInd()!=null){
				dto.setActiveInd(scheduleTimes.getActiveInd());
			}
			if(scheduleTimes.getBusyInd()!=null){
				dto.setBusyInd(scheduleTimes.getBusyInd());
			}
			if(scheduleTimes.getCheckPoint()!=null){
				dto.setCheckPoint(scheduleTimes.getCheckPoint());
			}
			if(scheduleTimes.getCheckpointname()!=null){
				dto.setCheckPointName(scheduleTimes.getCheckpointname());
			}
			map.clear();
			return dto;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CsfScheduleTimes entry, cause: "+ ex.getMessage(), ex);
		}

	}

	@SuppressWarnings("unchecked")
	public List<CSFScheduleTimesDTO> retrieveRelated(CSFScheduleTimesDTO obj)throws DAOException {

		List<CSFScheduleTimesDTO> dtoList = new LinkedList<CSFScheduleTimesDTO>();

		CSFScheduleTimesDTO dto = null;

		try {

			String sql = "SELECT c FROM CsfScheduleTimes c " + buildWhereClause(obj,true);
			List<CsfScheduleTimes> csfScheduleTimes =  csfScheduleTimesDao.executeQueryParametersDate(sql, map);

			for (CsfScheduleTimes scheduleTimes : csfScheduleTimes) {			
				
				dto = new CSFScheduleTimesDTO();

				if(scheduleTimes.getCsfScheduleTimesPK().getProcess()!=null){
					dto.setProcess(scheduleTimes.getCsfScheduleTimesPK().getProcess());
				}
				if(scheduleTimes.getCsfScheduleTimesPK().getService()!=null){
					dto.setService(scheduleTimes.getCsfScheduleTimesPK().getService());
				}
				if(scheduleTimes.getCsfScheduleTimesPK().getSubService()!=null){
					dto.setSubService(scheduleTimes.getCsfScheduleTimesPK().getSubService());
				}
				if(scheduleTimes.getStartTime()!=null){
					dto.setStartTime(scheduleTimes.getStartTime());
				}
				if(scheduleTimes.getEndTime()!=null){
					dto.setEndTime(scheduleTimes.getEndTime());
				}
				if(scheduleTimes.getLastRunTime()!=null){
					dto.setLastRunTime(scheduleTimes.getLastRunTime());
				}
				if(scheduleTimes.getActiveInd()!=null){
					dto.setActiveInd(scheduleTimes.getActiveInd());
				}
				if(scheduleTimes.getBusyInd()!=null){
					dto.setBusyInd(scheduleTimes.getBusyInd());
				}
				if(scheduleTimes.getCheckPoint()!=null){
					dto.setCheckPoint(scheduleTimes.getCheckPoint());
				}
				if(scheduleTimes.getCheckpointname()!=null){
					dto.setCheckPointName(scheduleTimes.getCheckpointname());
				}

				dtoList.add(dto);
			}
			map.clear();
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CSF_SCHEDULE_TIMES entries, cause: "+ ex.getMessage(), ex);
		}

	}

	/**
	 * Updating CSF_SCHEDULE_TIMES table
	 */

	public void update(CSFScheduleTimesDTO obj) throws DAOException {

		CsfScheduleTimes scheduleTimes = new CsfScheduleTimes();			
		CsfScheduleTimesPK csfScheduleTimesPK = new CsfScheduleTimesPK();
		csfScheduleTimesPK.setProcess(obj.getProcess());
		csfScheduleTimesPK.setService(obj.getService());
		csfScheduleTimesPK.setSubService(obj.getSubService());
		scheduleTimes.setCsfScheduleTimesPK(csfScheduleTimesPK);
		scheduleTimes.setStartTime(obj.getStartTime());
		scheduleTimes.setEndTime(obj.getEndTime());
		scheduleTimes.setLastRunTime(obj.getLastRunTime());
		scheduleTimes.setActiveInd(obj.getActiveInd());
		scheduleTimes.setBusyInd(obj.getBusyInd());
		scheduleTimes.setCheckPoint(obj.getCheckPoint());
		scheduleTimes.setCheckpointname(obj.getCheckPointName());
		try {

			csfScheduleTimesDao.update(scheduleTimes);

		} catch (Exception ex) {
			throw new DAOException("Error updating CSF_SCHEDULE_TIMES entry, cause: "
					+ ex.getMessage(), ex);
		}
	}

	private String buildWhereClause(CSFScheduleTimesDTO obj, boolean select)throws DAOException  {

		if (obj == null) {
			return "";
		}
		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		
		if (select == true) {
		

		if (obj.getProcess() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.process =:process");
			map.put("process",obj.getProcess());
		}

		if (obj.getService() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.service =:service");
			map.put("service",obj.getService());
		}

		if (obj.getSubService() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.subService =:subService");
			map.put("subService",obj.getSubService());
		}

		if (obj.getStartTime() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.startTime =:startTime");
			map.put("startTime",obj.getStartTime());
		}

		if (obj.getEndTime() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.endTime =:endTime");
			map.put("endTime",obj.getEndTime());
		}

		if (obj.getLastRunTime() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.lastRunTime =:lastRunTime");
			map.put("lastRunTime",String.valueOf(obj.getLastRunTime()));
		}

		if (obj.getActiveInd() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.activeInd =:activeInd");
			map.put("activeInd",obj.getActiveInd());
		}

		if (obj.getBusyInd() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.busyInd =:busyInd");
			map.put("busyInd",obj.getBusyInd());
		}

		if (obj.getCheckPoint() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.checkPoint =:checkPoint");
			map.put("checkPoint",obj.getCheckPoint());
		}

		if (obj.getCheckPointName() != null) {
			if (!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			} else {
				buff.append(" AND ");
			}

			buff.append("c.checkPointName =:checkPointName");
			map.put("checkPointName",obj.getCheckPointName());
		}
		
		}
		if(!whereClause && select == false) {
			throw new DAOException( "Cannot update delete all rows in CsfScheduleTimes");
		}

		return buff.toString();
	}


}
