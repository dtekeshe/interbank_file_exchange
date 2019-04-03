package com.bsva.dmcs.controller;

import java.sql.Connection;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.bsva.dcms.commons.dao.CsoScheduledProcessesDAO;
import com.bsva.dcms.commons.dto.CsoScheduledProcessesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;

public class ProcessControllerDAO {
	
	@Resource(lookup = "java:jboss/datasources/DMCSDb")
    private DataSource datasource;
	private Logger log = Logger.getLogger(ProcessControllerDAO.class);
	
	public ProcessControllerDAO(Connection conn){
		this.datasource = (DataSource) conn;
	}
	public ProcessControllerDAO(){
	}

	public List<CsoScheduledProcessesDTO> getSchedulesProccesses(){
		
		try {
			
			CsoScheduledProcessesDAO csoScheduledProcessesDao = new CsoScheduledProcessesDAO();
			List<CsoScheduledProcessesDTO> csoScheduledProcesses = csoScheduledProcessesDao.retrieveRelated(null);
			
			return csoScheduledProcesses;
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			log.error(e);
			return null;
		}
		
	}
	
}
