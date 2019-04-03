package com.bsva.dcms.commons.dao;


import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsoScheduledProcessesDao;
import com.bsva.dcms.commons.dto.CsoScheduledProcessesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsoScheduledProcesses;

public class CsoScheduledProcessesDAO {

	//private CsoScheduledProcessesRepository csoScheduledProcessesRepositoryDao = DaoFactory.csoScheduledProcessesInstance();
	
	private CsoScheduledProcessesDao csoScheduledProcessesDao = new CsoScheduledProcessesDao();
	private Map<String,Object>map = new HashMap<String, Object>();
	public CsoScheduledProcessesDAO(){

	}

	public void creat(CsoScheduledProcessesDTO bean){

		CsoScheduledProcesses csoScheduledProcesses = new CsoScheduledProcesses();
		csoScheduledProcesses.setActiveInd(bean.getActiveIndicator());
		csoScheduledProcesses.setClassPath(bean.getClassPath());
		csoScheduledProcesses.setProcessFrequency(Long.valueOf(bean.getProcessName()));
		csoScheduledProcesses.setProcessName(String.valueOf(bean.getProcessFrequency()));
		csoScheduledProcessesDao.create(csoScheduledProcesses);
	}


	public CsoScheduledProcessesDTO retrieve(CsoScheduledProcessesDTO bean) throws DAOException{

		CsoScheduledProcessesDTO dto = null;

		try{
			String sql = "SELECT c  FROM CsoScheduledProcesses c "+ buildWhereClause(bean,true);
			CsoScheduledProcesses csoScheduledProcesses = csoScheduledProcessesDao.executeQueryParametersSingle(sql,map);
				dto = new CsoScheduledProcessesDTO();
				dto.setActiveIndicator(csoScheduledProcesses.getActiveInd());
				dto.setClassPath(csoScheduledProcesses.getClassPath());
				dto.setProcessFrequency(csoScheduledProcesses.getProcessFrequency().longValue());
				dto.setProcessName(csoScheduledProcesses.getProcessName());

		}catch(Exception ex){
			ex.getMessage();
		}
		map.clear();
		return dto;

	}

	@SuppressWarnings("unchecked")
	public List<CsoScheduledProcessesDTO> retrieveRelated(CsoScheduledProcessesDTO bean) throws DAOException{

		List<CsoScheduledProcessesDTO> dtoList = new LinkedList<CsoScheduledProcessesDTO>();
		CsoScheduledProcessesDTO csoScheduledProcessesDTO = null;
		try{
			String sql = "SELECT c  FROM CsoScheduledProcesses c "+ buildWhereClause(bean,true);
			List<CsoScheduledProcesses> csoScheduledProcessesRelated = csoScheduledProcessesDao.executeQueryParametersDate(sql,map);
			for(CsoScheduledProcesses csoScheduledProcesses : csoScheduledProcessesRelated){
				csoScheduledProcessesDTO = new CsoScheduledProcessesDTO();
				csoScheduledProcessesDTO.setActiveIndicator(csoScheduledProcesses.getActiveInd());
				csoScheduledProcessesDTO.setClassPath(csoScheduledProcesses.getClassPath());
				csoScheduledProcessesDTO.setProcessFrequency(csoScheduledProcesses.getProcessFrequency().longValue());
				csoScheduledProcessesDTO.setProcessName(csoScheduledProcesses.getProcessName());
				dtoList.add(csoScheduledProcessesDTO);
			}
		}catch(Exception ex){
			
			System.out.println("Error Occured retrieving Data from the database : "+ex.getMessage());
		}
		map.clear();
		return dtoList;
	}



	private String buildWhereClause(CsoScheduledProcessesDTO bean,boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		if (select == true) {
		if (bean.getProcessName() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.processName =:processName");
			map.put("processName",bean.getProcessName());
		}
		if (bean.getProcessFrequency() > 0L) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.processFrequency =:processFrequency");
			map.put("processFrequency",String.valueOf(bean.getProcessFrequency()));
		}
		if (bean.getClassPath() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.classPath =:classPath");
			map.put("classPath",bean.getClassPath());
		}
		if (bean.getActiveIndicator() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("c.activeInd =:activeInd");
			map.put("activeInd",bean.getActiveIndicator());
		 }
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSF_PUBLIC_HOLIDAYS");
		}
		return buff.toString();
	}

	private void setParameters(CsoScheduledProcessesDTO bean) throws DAOException {
		StringBuilder sb = new StringBuilder();
		if(bean == null) {
			return;
		}
		try {
			if (bean.getProcessName() != null) {
				sb.append(bean.getProcessName());
				sb.append(",");
			}
			if (bean.getProcessFrequency() > 0) {
				sb.append(bean.getProcessFrequency());
				sb.append(",");
			}
			if (bean.getClassPath() != null) {
				sb.append(bean.getClassPath());
				sb.append(",");
			}

			if (bean.getActiveIndicator() != null) {
				sb.append(bean.getActiveIndicator());
			}

		}catch (Exception ex) {
			ex.getMessage();
		}
	}

	public void update(CsoScheduledProcessesDTO bean) throws DAOException {

		CsoScheduledProcesses csoScheduledProcesses = new CsoScheduledProcesses();
		csoScheduledProcesses.setActiveInd(bean.getActiveIndicator());
		csoScheduledProcesses.setClassPath(bean.getClassPath());
		csoScheduledProcesses.setProcessFrequency(bean.getProcessFrequency());
		csoScheduledProcesses.setProcessName(bean.getProcessName());
		try{
			
			this.csoScheduledProcessesDao.update(csoScheduledProcesses);

		}catch (Exception ex) {
			ex.getMessage();
		}
	}
}
