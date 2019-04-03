package com.bsva.dmcs.operations.processes;

import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.bsva.dcms.commons.dao.CsoOutputControlsDAO;
import com.bsva.dcms.commons.dao.CsoScheduledProcessesDAO;
import com.bsva.dcms.commons.dao.CsoServiceParametersDAO;
import com.bsva.dcms.commons.dao.CsoSystemParametersDAO;
import com.bsva.dcms.commons.dto.CsoOutputControlsDTO;
import com.bsva.dcms.commons.dto.CsoScheduledProcessesDTO;
import com.bsva.dcms.commons.dto.CsoServiceParametersDTO;
import com.bsva.dcms.commons.dto.CsoSystemParametersDTO;
import com.bsva.dcms.commons.enums.Status;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.util.Utils;
import com.bsva.dmcs.controller.AbstractProcess;

/**
 * @author Mphikeleli
 *
 */
public class EODProcess extends AbstractProcess {
	
	private final Logger log = Logger.getLogger(EODProcess.class.getName());
	
	private static String logPGM = "REQCLOSE";

	@Resource(lookup = "java:jboss/datasources/DMCSDb")
    private DataSource datasource;
	
    private static final String EOD_PROCESS_NAME	= "EOD";
    private static final String SERVICE				= "CARD";
    private static final String SUB_SERVICE_NAME	= "ALL";
    private static Date processDate = null;
	
	public boolean updateServiceParameters(String service, String subService, String serviceStatus){
		
		boolean result = false;
		
		
		CsoServiceParametersDTO parmObject = new CsoServiceParametersDTO();
		
		parmObject.setInwardStatus(Status.A.getSymbol());
		parmObject.setOutwardStatus(Status.N.getSymbol());
		parmObject.setInputRequestClose(Status.N.getSymbol());
		parmObject.setProcessActiveInd(serviceStatus); 
		parmObject.setService(service);
		parmObject.setSubService(subService); 
	
		try {
			
			CsoSystemParametersDAO csoSystemParametersDAO = new CsoSystemParametersDAO();
			
			CsoSystemParametersDTO csoSystemParametersDTO = new CsoSystemParametersDTO();
			csoSystemParametersDTO.setProcessActiveInd(Status.Y.getSymbol());
			
			CsoSystemParametersDTO csoSystemParametersDTO2 = csoSystemParametersDAO.retrieve(csoSystemParametersDTO);
			
			processDate = csoSystemParametersDTO2.getProcessDate();
			parmObject.setProcessDate(processDate);
			
			CsoServiceParametersDAO csoServiceParametersDao = new CsoServiceParametersDAO();
			csoServiceParametersDao.update(parmObject);
			
			csoSystemParametersDTO2.setProcessActiveInd(Status.Y.getSymbol());
			csoSystemParametersDAO.update(csoSystemParametersDTO2); 
			
		} catch (DAOException e) {
			e.printStackTrace(); 
		}
		return result;
	}
	
	public List<CsoServiceParametersDTO>  getServices(){
		
		List<CsoServiceParametersDTO> services = new ArrayList<CsoServiceParametersDTO>();
		
		try {
			  CsoServiceParametersDAO CsoServiceParametersDao = new CsoServiceParametersDAO();
			  services = CsoServiceParametersDao.retrieveRelated(null);
			   
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return services; 
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public void process() {
		//getLog().info("### EOD Process Is Starting ###");
		//setCon(getCon());
		
		if(Utils.isProcessActivated(EOD_PROCESS_NAME, SERVICE, SUB_SERVICE_NAME)){
		//if(true){
			/*getLog().info("### EOD Process Is Running ###");
			CsoOutputControlsDAO csoOutputControlsDAO = new CsoOutputControlsDAO();
			CsoOutputControlsDTO csoOutputControlsDTO = new CsoOutputControlsDTO();
			
			String[][] productInfo  = {{"VISA CARD","MASTERCARD"},{"N"}};//Over-complicated things, but at least it's future proof.
			int numSubProcesses		= 2;
			int numStatuses			= 1;
			boolean allComplete 	= true;
			
			for(int i = 0; i < numSubProcesses; i++){
				csoOutputControlsDTO.setSubService(productInfo[0][i]);
				csoOutputControlsDTO.setService("CARD");
				for(int j = 0; j < numStatuses; j++ ){
					csoOutputControlsDTO.setFullFileInd(productInfo[1][j]);
					List<CsoOutputControlsDTO> csoOutputControlsDTOs = new ArrayList<CsoOutputControlsDTO>();
					try {
						csoOutputControlsDTOs = csoOutputControlsDAO.retrieveRelated(csoOutputControlsDTO);
						
						if(csoOutputControlsDTOs != null && csoOutputControlsDTOs.size() > 0){
							allComplete = false;	
							getLog().info("Not All Files Have been Extracted for " + productInfo[0][i]);
							break;
						}
						
					if(allComplete){
							
							try {
							CsoScheduledProcessesDAO csoScheduledProcessesDAO = new CsoScheduledProcessesDAO();
							
							List<CsoScheduledProcessesDTO> csoScheduledProcessesDTOs = new ArrayList<CsoScheduledProcessesDTO>();
						     csoScheduledProcessesDTOs = csoScheduledProcessesDAO.retrieveRelated(null);// Retrieve ALL
							
							if(csoScheduledProcessesDTOs != null && csoScheduledProcessesDTOs.size() > 0){
								for (CsoScheduledProcessesDTO csoScheduledProcessesDTO :csoScheduledProcessesDTOs){
									if(("SOD".equals(csoScheduledProcessesDTO.getProcessName()))){
										csoScheduledProcessesDTO.setActiveIndicator(Status.Y.getSymbol());
										
									}else if (("OUTDEL".equals(csoScheduledProcessesDTO.getProcessName()))){
										continue; 
									}else{
										csoScheduledProcessesDTO.setActiveIndicator(Status.N.getSymbol());
									}
									CsoScheduledProcessesDAO csoScheduledProcessesDao = new CsoScheduledProcessesDAO();
									csoScheduledProcessesDao.update(csoScheduledProcessesDTO);
								}
							}
						}catch(DAOException e){
					    	 e.printStackTrace();
					     }	
					  }
					} catch (DAOException e) {
						e.printStackTrace();
					}	
				}
			}*/
			//getLog().info(SUB_SERVICE_NAME + " Indicator Set to : N");
			//updateServiceParameters(SERVICE,"VISA CARD",Status.A.getSymbol());
			//getLog().info("EOD Indicator Set to : N");
			//Utils.updateProcessActiveInd(EOD_PROCESS_NAME, SERVICE, SUB_SERVICE_NAME, Status.Y.getSymbol(), processDate);
			
			
	 }else{
		 // getLog().info("EOD Indicator Set Not Set N");
	 }		
		//getLog().info("### EOD Process Has Finished ###");
	}

	public Logger getLog() {
		return log;
	}

	public DataSource getCon() {
		return datasource;
	}

	public void setCon(DataSource con) {
		this.datasource = con;
	}

}
