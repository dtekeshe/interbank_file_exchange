package com.bsva.dmcs.operations.businesslogic;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static java.nio.file.StandardCopyOption.*;

import java.nio.file.NoSuchFileException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.bsva.dao.v02.startofday.CsfBinsDAO;

//import org.apache.commons.io.FileUtils;

import com.bsva.dcms.commons.dao.CSFBinDAO;
import com.bsva.dcms.commons.dao.CSFScheduleTimesDAO;
import com.bsva.dcms.commons.dao.CSFServicesDAO;
import com.bsva.dcms.commons.dao.CsfDeliveryServicesDAO;
import com.bsva.dcms.commons.dao.CsfPublicHolidaysDAO;
import com.bsva.dcms.commons.dao.CsfSystemSettingsDAO;
import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
import com.bsva.dcms.commons.dao.CsoScheduleTimesDAO;
import com.bsva.dcms.commons.dao.CsoScheduledProcessesDAO;
import com.bsva.dcms.commons.dao.CsoServiceParametersDAO;
import com.bsva.dcms.commons.dao.CsoSystemParametersDAO;
import com.bsva.dcms.commons.dao.DelDeliveryFilesCCCDAO;
import com.bsva.dcms.commons.dao.SiteControlsDAO;
import com.bsva.dcms.commons.dto.CSFBinsDTO;
import com.bsva.dcms.commons.dto.CSFScheduleTimesDTO;
import com.bsva.dcms.commons.dto.CSFServicesDTO;
import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
import com.bsva.dcms.commons.dto.CsfPublicHolidaysDTO;
import com.bsva.dcms.commons.dto.CsfSystemSettingsDTO;
import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
import com.bsva.dcms.commons.dto.CsoScheduleTimesDTO;
import com.bsva.dcms.commons.dto.CsoScheduledProcessesDTO;
import com.bsva.dcms.commons.dto.CsoServiceParametersDTO;
import com.bsva.dcms.commons.dto.CsoSystemParametersDTO;
import com.bsva.dcms.commons.dto.DelDeliveryFilesCCCDTO;
import com.bsva.dcms.commons.dto.SiteControlsDTO;
import com.bsva.dcms.commons.enums.Status;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.exceptions.DuplicateProcessException;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.util.DateUtil;
import com.bsva.dcms.commons.util.Utils;
import com.bsva.entities.v02.startofday.CsfBinsEntity;


/**
 * @author AugustineA
 *
 */
public class DmcsSOD {

	private static final Logger log = Logger.getLogger(DmcsSOD.class.getName());
	private static final String EOD_PROCESS_NAME = "EOD";
	private static final String SOD_PROCESS_NAME = "SOD";
	private static final String SETTLE_PROCESS_NAME	= "SETTLE";
	private static final String PROCESSNAME = "DMCSSOD";

	@Resource(lookup = "java:jboss/datasources/DMCSDb")
    private DataSource datasource;

	public DmcsSOD() {
	}

	public boolean sodProcess(Date processDate) {
     try{
		boolean result = false;
		SiteControlsDTO siteControlsDTO = retrieveSiteControl();

		if (siteControlsDTO != null) {
			CsoSystemParametersDTO systemParametersDTO = new CsoSystemParametersDTO();
			systemParametersDTO.setProcessDate(processDate);
			systemParametersDTO.setProcessActiveInd("Y");   
			CsoSystemParametersDTO systemParametersdto = retrieveCsoParameters(systemParametersDTO);
			// check if current processing date(s) exist(s) in
			// cso_system_parameters.
			if (systemParametersdto != null) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				log.info("Start of Day Has Already Run on this Date: " + df.format(processDate));
				Utils.logSpolog("Start of Day Has Already Run on this Date: " + df.format(processDate),PROCESSNAME);
				return result ;
			}

		}else{
			Utils.logSpolog("SOD cannot continue as it has been scheduled to run on the same day",PROCESSNAME);
			return result ;
		}
		  boolean check = Utils.isValidBusinessDate(processDate);
		 if(check == true){
			Utils.logSpolog(" Starting Cleanup process ",PROCESSNAME);
			// deleting all transactional tables 
		 	CleanProcess cleanProcess = new CleanProcess(datasource);
		 	boolean cleanupresult = cleanProcess.runCleanProcess(processDate);
	        if(cleanupresult){
	        	Utils.logSpolog("Cleanup Process was Successful, Completed Deleting all files :",PROCESSNAME);
	        	System.out.println("Cleanup Process was Successful, Completed Deleting all files :");
	        }else{
	        	System.out.println(" Error occured Cleanup Process :");
	        }
			String previous_core_int = "";
	
			CsfSystemSettingsDTO csfSystemSettingsDTO = new CsfSystemSettingsDTO();
	
			csfSystemSettingsDTO.setSettingCode("COREINTVAL");
	
			csfSystemSettingsDTO = retrieveSystemSettings(csfSystemSettingsDTO);
	
			if (csfSystemSettingsDTO != null) {
	
				previous_core_int = csfSystemSettingsDTO.getSettingValue();
	
			} else {
				previous_core_int = "300";
			}
			Utils.logSpolog("About to create CsoServiceParameters,PROCESSNAME",PROCESSNAME);
			CsoSystemParametersDTO csoSystemParameter = new CsoSystemParametersDTO();
	
			csoSystemParameter.setProcessDate(processDate);
			csoSystemParameter.setProcessActiveInd("Y");
			csoSystemParameter.setLiveTestCode(siteControlsDTO.getSystemStatus().substring(0, 1));
			csoSystemParameter.setCccoreInterval(Integer.valueOf(previous_core_int));
			csoSystemParameter.setNextOutputDate(Utils.getNextOutputDate(processDate )); 
			csoSystemParameter.setCisDownloadInd("N"); 
	
			createSystemParameters(csoSystemParameter);
	
			List<CSFServicesDTO> cSFServicesListDTO = retrieveRelatedServices();
	
			if (cSFServicesListDTO != null) { 
				for (CSFServicesDTO service : cSFServicesListDTO) {
	
					CsoServiceParametersDTO csoServiceParametersDTO = new CsoServiceParametersDTO();
					csoServiceParametersDTO.setProcessDate(processDate);
					csoServiceParametersDTO.setService(service.getServiceCode());
					csoServiceParametersDTO.setSubService(service.getServiceName());
					csoServiceParametersDTO.setProcessActiveInd("A");
					csoServiceParametersDTO.setInwardStatus("A");
					csoServiceParametersDTO.setOutwardStatus("N");
					csoServiceParametersDTO.setInputRequestClose("N");
					
		            createServiceParameters(csoServiceParametersDTO);
	
				}
			}
			else{
				return result ;
			}
			deleteCSFBin();
			Utils.logSpolog("ABout to creat Csf_Bins",PROCESSNAME);
			
			retrieveCSFBins();//Delete and re-create csfBins table
			Utils.logSpolog("Done to creating Csf_Bins",PROCESSNAME);
			deleteCsoScheduleTimes();
			Utils.logSpolog("ABout to cretae CsoScheduletimes",PROCESSNAME);
			List<CSFScheduleTimesDTO> csfScheduleTimes = retrieveScheduleTimes();
			Utils.logSpolog("Done creating CsoScheduletimes",PROCESSNAME);
			for(CSFScheduleTimesDTO scheduleTime : csfScheduleTimes){
	
				createCSOScheduleTimes(scheduleTime);
			}
	        result = true;
	        return result;
			}
		
		}catch(Exception ex){
			ex.getMessage();		 
		}
	return false;

	}	
	private void deleteServiceParameters() throws DAOException{
		CsoServiceParametersDTO csoServiceParametersDTO = new CsoServiceParametersDTO();
		CsoServiceParametersDAO csoServiceParametersDAO = new CsoServiceParametersDAO();
		try {

			csoServiceParametersDAO.delete();
			
			Utils.logSpolog("Successfully Deleted CSO_SERVICE_PARAMETERS",PROCESSNAME);

		} catch (DAOException e) {

		}
	}
	
	private void deleteSystemParameters() throws DAOException{
		CsoSystemParametersDTO csoSystemParametersDTO = new CsoSystemParametersDTO();
		CsoSystemParametersDAO csoSystemParametersDAO = new CsoSystemParametersDAO();
		try {

			csoSystemParametersDAO.delete();
			
			Utils.logSpolog("Successfully Deleted CSO_SYSTEM_PARAMETERS",PROCESSNAME);

		} catch (DAOException e) {

		}
	}
	private void updateSystems(Date processDate,SiteControlsDTO siteControlsDTO ){
		
		try {
			deleteServiceParameters();
			deleteSystemParameters();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		String previous_core_int = "";

		CsfSystemSettingsDTO csfSystemSettingsDTO = new CsfSystemSettingsDTO();

		csfSystemSettingsDTO.setSettingCode("COREINTVAL");

		csfSystemSettingsDTO = retrieveSystemSettings(csfSystemSettingsDTO);

		if (csfSystemSettingsDTO != null) {

			previous_core_int = csfSystemSettingsDTO.getSettingValue();

		} else {
			previous_core_int = "300";
		}
		CsoSystemParametersDTO csoSystemParameter = new CsoSystemParametersDTO();

		csoSystemParameter.setProcessDate(processDate);
		csoSystemParameter.setProcessActiveInd("Y");
		csoSystemParameter.setLiveTestCode(siteControlsDTO.getSystemStatus().substring(0, 1));
		csoSystemParameter.setCccoreInterval(Integer.valueOf(previous_core_int));
		csoSystemParameter.setNextOutputDate(Utils.getNextOutputDate(processDate )); 
		csoSystemParameter.setCisDownloadInd("N"); 

		createSystemParameters(csoSystemParameter);

		List<CSFServicesDTO> cSFServicesListDTO = retrieveRelatedServices();


		if (cSFServicesListDTO != null) { 
			for (CSFServicesDTO service : cSFServicesListDTO) {

				CsoServiceParametersDTO csoServiceParametersDTO = new CsoServiceParametersDTO();
				csoServiceParametersDTO.setProcessDate(processDate);
				csoServiceParametersDTO.setService(service.getServiceCode());
				csoServiceParametersDTO.setSubService(service.getServiceName());
				csoServiceParametersDTO.setProcessActiveInd("A");
				csoServiceParametersDTO.setInwardStatus("A");
				csoServiceParametersDTO.setOutwardStatus("N");
				csoServiceParametersDTO.setInputRequestClose("N");
				
	            createServiceParameters(csoServiceParametersDTO);
	              

			}
		}
		
		CsfDeliveryServicesDTO delDto = new CsfDeliveryServicesDTO();
		delDto.setInwardOutwardInd("O");
		delDto.setActiveIndicator("N");
		CsfDeliveryServicesDAO delDao = new CsfDeliveryServicesDAO();
		try {
			List<CsfDeliveryServicesDTO> delServices = delDao.retrieveRelated(delDto);
			for (CsfDeliveryServicesDTO csfDeliveryServicesDTO : delServices) {
				csfDeliveryServicesDTO.setActiveIndicator("Y");
				delDao.update(csfDeliveryServicesDTO);
			}
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private SiteControlsDTO retrieveSiteControl(){
		SiteControlsDTO siteControlsDTO = new SiteControlsDTO();
		SiteControlsDAO siteControlsDAO = new SiteControlsDAO();
		SiteControlsDTO siteControlsdto  = new SiteControlsDTO();
		siteControlsDTO.setSiteCode("CCCD");
		try {
            siteControlsdto = siteControlsDAO.retrieve(siteControlsDTO);
		} catch (DAOException e) {

		}
		return siteControlsdto; 
	}

	private CsoSystemParametersDTO retrieveCsoParameters(CsoSystemParametersDTO csoSystemParametersDTO){
		CsoSystemParametersDTO csoSystemParametersDto = null;
		CsoSystemParametersDAO csoSystemParametersDAO = new CsoSystemParametersDAO();
		try {
			 csoSystemParametersDto = csoSystemParametersDAO.retrieve(csoSystemParametersDTO);
		} catch (DAOException e) {

		}
		return csoSystemParametersDto;
	}

	private List<CsfPublicHolidaysDTO> retrievePublicHolidaysByCondition(Date processDate){
		CsfPublicHolidaysDTO csfPublicHolidaysDTO = new CsfPublicHolidaysDTO();
		List<CsfPublicHolidaysDTO> csfPublicHolidaysListDTO = new ArrayList<CsfPublicHolidaysDTO>();
		CsfPublicHolidaysDAO csfPublicHolidaysDAO = new CsfPublicHolidaysDAO();
		csfPublicHolidaysDTO.setProcessDate(processDate);
		csfPublicHolidaysDTO.setPublicHolidayIndicator("Y");
		try {
			csfPublicHolidaysListDTO = csfPublicHolidaysDAO.retrieveByCondition(csfPublicHolidaysDTO);
		} catch (DAOException e) {

		}
		return csfPublicHolidaysListDTO; 
	}

	
	private CsfSystemSettingsDTO retrieveSystemSettings(CsfSystemSettingsDTO csfSystemSettingsDTO){
		CsfSystemSettingsDTO csfSystemSettingsDto = null;
		CsfSystemSettingsDAO csfSystemSettingsDAO = new CsfSystemSettingsDAO();
		try {
			csfSystemSettingsDto = csfSystemSettingsDAO.retrieve(csfSystemSettingsDTO);
		} catch (DAOException e) {

		}
		return csfSystemSettingsDto; 
	}

	private void createSystemParameters(CsoSystemParametersDTO csoSystemParametersDTO){
		CsoSystemParametersDAO csoSystemParametersDAO = new CsoSystemParametersDAO();
		try {
			csoSystemParametersDAO.create(csoSystemParametersDTO);
		} catch (DAOException e) {

		}
	}

	private List<CSFServicesDTO> retrieveRelatedServices(){
		CSFServicesDTO cSFServicesDTO = new CSFServicesDTO();
		List<CSFServicesDTO> cSFServicesListDTO = new ArrayList<CSFServicesDTO>();
		CSFServicesDAO cSFServicesDAO = new CSFServicesDAO();
		try {
			cSFServicesListDTO = cSFServicesDAO.retrieveRelated(cSFServicesDTO);
		} catch (DAOException e) {

		}
		return cSFServicesListDTO; 
	}

	private void createServiceParameters(CsoServiceParametersDTO csoServiceParametersDTO){
		CsoServiceParametersDAO csoServiceParametersDAO = new CsoServiceParametersDAO();
		try {		
			csoServiceParametersDAO.create(csoServiceParametersDTO);
		} catch (DAOException e) {
		}
	}

	@SuppressWarnings("unused")
	private void deleteCSFBin() throws DAOException{

		CSFBinDAO cSFBinDAO = new CSFBinDAO();
		try {
			cSFBinDAO.delete();
			log.info("Successfully Deleted CSF_BINS");
			Utils.logSpolog("Successfully Deleted CSF_BINS",PROCESSNAME);
		} catch (DAOException e) {

		}
	}

	private void retrieveCSFBins(){
		List<CSFBinsDTO> cSFBinDTO = new ArrayList<CSFBinsDTO>();
		CSFBinDAO cSFBinDAO = new CSFBinDAO();
		CsfBinsDAO cSFBins = new CsfBinsDAO();
		List<CsfBinsEntity> CsfBinsdata = cSFBins.getCsfBinsData();
		try {
			 cSFBinDAO.createCSFBins(CsfBinsdata);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	private void createCSFBin(CSFBinsDTO cSFBinDTO){
		CSFBinDAO cSFBinDAO = new CSFBinDAO();
		try {
			cSFBinDAO.create(cSFBinDTO);
			Utils.logSpolog("Successfully Created CSF_BINS",PROCESSNAME);
		} catch (DAOException e) {

		}
	}

	private void deleteCsoScheduleTimes(){

		CsoScheduleTimesDTO scheduleTime = new CsoScheduleTimesDTO();
		CsoScheduleTimesDAO scheduleTimeDAO = new CsoScheduleTimesDAO();
			try {
				scheduleTimeDAO.delete();
			} catch (DAOException e) {
				
			}
			
			log.info("Successfully Deleted CSO_SCHEDULE_TIMES");
			Utils.logSpolog("Successfully Deleted CsoScheduleTimes",PROCESSNAME);
			
	 
	}

	private List<CSFScheduleTimesDTO> retrieveScheduleTimes(){

		List<CSFScheduleTimesDTO> csfScheduleTimes = new ArrayList<CSFScheduleTimesDTO>();
		CSFScheduleTimesDTO csfScheduleTimesDTO = new CSFScheduleTimesDTO();
		CSFScheduleTimesDAO scheduleDao = new CSFScheduleTimesDAO();
		try {
			csfScheduleTimes = scheduleDao.retrieveRelated(csfScheduleTimesDTO);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return csfScheduleTimes;
	}

	private void createCSOScheduleTimes(CSFScheduleTimesDTO cSFScheduleTimesDTO){

		CsoScheduleTimesDTO csoSheduleTime = new CsoScheduleTimesDTO();
		CsoScheduleTimesDAO csoSheduleTimeDao = new CsoScheduleTimesDAO();
		csoSheduleTime.setProcess(cSFScheduleTimesDTO.getProcess()); 
		csoSheduleTime.setService(cSFScheduleTimesDTO.getService()); 
		csoSheduleTime.setSubService(cSFScheduleTimesDTO.getSubService()); 
		csoSheduleTime.setStartTime(cSFScheduleTimesDTO.getStartTime());
		csoSheduleTime.setEndTime(cSFScheduleTimesDTO.getEndTime());
		csoSheduleTime.setActiveInd("Y"); 
		csoSheduleTime.setBusyInd(cSFScheduleTimesDTO.getBusyInd());
		csoSheduleTime.setCheckPoint(cSFScheduleTimesDTO.getCheckPoint()); 
		csoSheduleTime.setCheckPointName(cSFScheduleTimesDTO.getCheckPointName());  
		csoSheduleTime.setProcessDate(cSFScheduleTimesDTO.getProcessDate());

		try {
			System.out.println("createCSOScheduleTimes " + csoSheduleTime);
			csoSheduleTimeDao.create(csoSheduleTime);
			Utils.logSpolog("Successfully Created CsoScheduleTimes",PROCESSNAME);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	private void registerProcessFile(String processName, String fileName, String service, String subService, Status status){
		try {
			Utils.logProcess(processName, fileName, service, subService, status.getSymbol());
		} catch (DuplicateProcessException e) {
			e.printStackTrace();
		}

	}

	private void updateProcessFile(String processName, String fileName, Status status) {
        DelDeliveryFilesCCCDAO dao = new DelDeliveryFilesCCCDAO();
        DelDeliveryFilesCCCDTO dto = new DelDeliveryFilesCCCDTO();
        dto.setFileName(fileName);
        DelDeliveryFilesCCCDTO dtoValue;
      try {
             dtoValue = dao.retrieve(dto);
             Utils.updateDelDeliveryStatus(fileName,dtoValue.getPosition(),dtoValue.getQueueFileName(), status.getSymbol());
      } catch (Exception e) {
             // TODO Auto-generated catch block
             e.getMessage();
      }
      //     serviceUtilDao.setProcessFileStage(processName, fileName, status);
	}


	public DataSource getCon() {
		return datasource;
	}

	public void setCon(DataSource con) {
		this.datasource = con;
	}
	
}
