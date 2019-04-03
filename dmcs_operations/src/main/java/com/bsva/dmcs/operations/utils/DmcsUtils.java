package com.bsva.dmcs.operations.utils;

import java.sql.Connection;

import javax.sql.DataSource;

import com.bsva.dcms.commons.dao.CsfProcessScheduleDAO;
import com.bsva.dcms.commons.dao.CsoSystemParametersDAO;
import com.bsva.dcms.commons.dto.CsfProcessScheduleDTO;
import com.bsva.dcms.commons.dto.CsoSystemParametersDTO;
import com.bsva.dcms.commons.exceptions.DAOException;

public class DmcsUtils {

	public static CsoSystemParametersDTO retrieve(Connection connect, CsoSystemParametersDTO csoSystemParameters){
		CsoSystemParametersDTO csoSystemParameter = null;
		CsoSystemParametersDAO csoSystemParametersDAO = new CsoSystemParametersDAO();
		try {

			 csoSystemParameter = csoSystemParametersDAO.retrieve(csoSystemParameters); 

		} catch (DAOException e) {
		}
		return csoSystemParameter; 

	}
	
	public static void deleteCsoSystemParameters(DataSource connect){

		CsoSystemParametersDTO csoSystemParametersDTO = new CsoSystemParametersDTO();
		CsoSystemParametersDAO csoSystemParametersDAO = new CsoSystemParametersDAO();

		
			//csoSystemParametersDAO.delete(csoSystemParametersDTO);
		

	}
	
	public static CsfProcessScheduleDTO retrieveProcessSchedule(DataSource connect, CsfProcessScheduleDTO csfProcessScheduleDTO){
		CsfProcessScheduleDTO csfProcessScheduleDto = null;
		CsfProcessScheduleDAO csfProcessScheduleDAO = new CsfProcessScheduleDAO();

		try {
			csfProcessScheduleDto = csfProcessScheduleDAO.retrieve(csfProcessScheduleDTO);
		} catch (DAOException e) {


		}
		return csfProcessScheduleDto; 
	}
}
