package com.bsva.dmcs.operations.processes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.bsva.dmcs.fileloadv02.FileLoadProcess;
import org.apache.log4j.Logger;

import com.bsva.dcms.commons.dao.CsfDeliveryServicesDAO;
import com.bsva.dcms.commons.dao.CsoScheduleTimesDAO;
import com.bsva.dcms.commons.dao.CsoScheduledProcessesDAO;
import com.bsva.dcms.commons.dao.CsoServiceParametersDAO;
import com.bsva.dcms.commons.dao.CsoSystemParametersDAO;
import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
import com.bsva.dcms.commons.dto.CsoScheduleTimesDTO;
import com.bsva.dcms.commons.dto.CsoScheduledProcessesDTO;
import com.bsva.dcms.commons.dto.CsoServiceParametersDTO;
import com.bsva.dcms.commons.dto.CsoSystemParametersDTO;
import com.bsva.dcms.commons.enums.Status;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.util.Utils;
import com.bsva.dmcs.controller.AbstractProcess;
import com.bsva.dmcs.operations.businesslogic.CleanProcess;
import com.bsva.dmcs.operations.exceptions.SODServiceException;
import com.bsva.dmcs.operations.interfaces.SODService;
import com.bsva.dmcs.operations.utils.SODServiceImpl;
//import com.bsva.dmcs.reports.CSRBINS;

public class SODProcess extends AbstractProcess {

	private Logger logger = Logger.getLogger(SODProcess.class);

	private SODService sodService = null;

	private static final String SOD_PROCESS_NAME = "SOD";
	private static final String SETTLE_PROCESS_NAME = "SETTLE";
	private static final String EOD_PROCESS_NAME = "EOD";
	private static final String SERVICE = "CARD";
	private static final String SUB_SERVICE_NAME = "ALL";
	private static final String PROCESSNAME = "SODProcess";
	
	@Resource(lookup = "java:jboss/datasources/DMCSDb")
	private DataSource datasource;

	@Override
	public void init() {

	}
	
	@Override
	public void process() {
	
	}

	public void process(Date rocessDate) {
		
		boolean result = false;

		setSodService(new SODServiceImpl());

		try {
			Utils.logSpolog("### SOD Process Started ###",PROCESSNAME);
			CsoScheduleTimesDTO csoScheduleTimesDTO = new CsoScheduleTimesDTO();

			csoScheduleTimesDTO.setProcess(SOD_PROCESS_NAME);
			csoScheduleTimesDTO.setService(SERVICE);
			csoScheduleTimesDTO.setSubService(SUB_SERVICE_NAME);
			csoScheduleTimesDTO.setActiveInd(Status.Y.getSymbol());

			CsoScheduleTimesDAO csoScheduleTimesDAO = new CsoScheduleTimesDAO();
			CsoScheduleTimesDTO csoScheduleTimesDTO2 = csoScheduleTimesDAO.retrieve(csoScheduleTimesDTO);

			String date = BsvTableLookup.getInstance().getProcessDate();
			Utils.logSpolog("Process Date is : " + date,PROCESSNAME);
			// CsoSystemParametersDAO sysDao = new CsoSystemParametersDAO();
			// CsoSystemParametersDTO dtoData = new CsoSystemParametersDTO();
			// CsoSystemParametersDTO sysParameters = sysDao.retrieve(dtoData);

			try {
				//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				//Date startDate = df.parse(csoScheduleTimesDTO2.getProcessDate());
				result = getSodService().sodProcess(rocessDate);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (result) {
				
				CsfDeliveryServicesDTO delDto = new CsfDeliveryServicesDTO();
				delDto.setInwardOutwardInd("O");
				//delDto.setActiveIndicator("N");
				CsfDeliveryServicesDAO delDao = new CsfDeliveryServicesDAO();
				try {
					List<CsfDeliveryServicesDTO> delServices = delDao.retrieveRelated(delDto);
					if(delServices.size() > 0){
						for (CsfDeliveryServicesDTO csfDeliveryServicesDTO : delServices) {
							if(csfDeliveryServicesDTO.getSubService().contains("REP")){
							}else{
								csfDeliveryServicesDTO.setActiveIndicator("Y");
								delDao.update(csfDeliveryServicesDTO);
							}
						}
					}
					
				} catch (DAOException e) {
					e.printStackTrace();
				}
				getSodService().moveToArchive();
				Utils.logSpolog("### SOD Process Starting...... ###",PROCESSNAME);
				Utils.logSpolog("### Deleted all tables that needs to be deleted ###",PROCESSNAME);
				Utils.logSpolog("### Populated all  default tables",PROCESSNAME);
				Utils.logSpolog("### Moving old files to prev folder ###",PROCESSNAME);
				Utils.logSpolog("Moving spolog to Archive folder",PROCESSNAME);
				Utils.logSpolog("Generating Default Output Files",PROCESSNAME);
				
				System.out.println("Generating Default Output Files :"+ PROCESSNAME);
				getSodService().generateDefaultOutputFiles();//check why it does not complete succesfully
				System.out.println("After Default Output Files  Generation :"+ PROCESSNAME);
				
				Utils.logSpolog("Moving Files to prev Receive folder",PROCESSNAME);
				getSodService().moveToPrevReceive();
				Utils.logSpolog("Moving files to prev send folder",PROCESSNAME);
				getSodService().moveToPrevSend();
				Utils.logSpolog("Moving spolog to Archive folder",PROCESSNAME);
				
				Utils.logSpolog("Moving files to Prev Report folder",PROCESSNAME);
				getSodService().moveToPrevReport();
				Utils.logSpolog("Deleting negative files folder", PROCESSNAME);
				getSodService().deleteNegFiles();
				getSodService().deleteExportFile();
				Utils.logSpolog("Deleting export folder files", PROCESSNAME);
				CleanProcess cleanCisBin = new CleanProcess();
				cleanCisBin.generateCisBinsReports();
				System.out.println("#########----Start Of Day Done----------###########...");
				System.out.println("######### SOD Process Has Completed ##########");
				//getLogger().info("Settting SOD Indicator to : N");
				CsoSystemParametersDTO csoSystemParametersDTO = new CsoSystemParametersDTO();
				CsoSystemParametersDAO csoSystemParametersDAO = new CsoSystemParametersDAO();
				csoSystemParametersDTO.setProcessActiveInd(Status.Y.getSymbol());

				CsoSystemParametersDTO csoSystemParametersDTO2 = csoSystemParametersDAO
						.retrieve(csoSystemParametersDTO);
				if (csoSystemParametersDTO2 != null) {
					Utils.updateProcessActiveInd(SOD_PROCESS_NAME, SERVICE, SUB_SERVICE_NAME, Status.N.getSymbol(),
							csoSystemParametersDTO2.getProcessDate());
				}

				if (updateServiceParameters(SERVICE, SUB_SERVICE_NAME, SOD_PROCESS_NAME, Status.A.getSymbol())) {
					getLogger().info("Settting SOD Indicator to : N");
				}
				Utils.logSpolog("### SOD Process Has Completed ###",PROCESSNAME);
//				try {
//					CSRBINS cisbins = new CSRBINS();
//					cisbins.build();
//					cisbins.printTextFile();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			} else {
				getLogger().info("The Current Process date is : "+rocessDate+" You cannot run  on the same Process date Or On Sunday");
				Utils.logSpolog("The Current Process date is : "+rocessDate+" You cannot run Start Of Day twice on the same day Or On Sunday",PROCESSNAME);
			}

			// Initialize file loader ---------------------------------------------------------------------------------
			FileLoadProcess.initFileLoader();
			// Initialize file loader ends ----------------------------------------------------------------------------

		} catch (SODServiceException e) {
			e.printStackTrace();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		/*
		 * }else{ //getLogger().info("SOD Indicator Set to : N"); }
		 */
		// getLogger().info("### SOD Process Has Completed ###");
		// Utils.logSpolog("### SOD Process Has Completed ###");
	}

	public boolean updateServiceParameters(String service, String subService, String processName, String serviceStatus) {

		boolean result = false;

		CsoScheduleTimesDTO csoScheduleTimesDTO = new CsoScheduleTimesDTO();
		CsoScheduleTimesDAO csoScheduleTimesDAO = new CsoScheduleTimesDAO();

		csoScheduleTimesDTO.setService(service);
		csoScheduleTimesDTO.setSubService(subService);
		csoScheduleTimesDTO.setProcess(processName);
		// csoScheduleTimesDTO.setActiveInd(Status.Y.getSymbol());

		CsoServiceParametersDTO parmObject = new CsoServiceParametersDTO();

		parmObject.setInwardStatus(Status.A.getSymbol());
		parmObject.setOutwardStatus(Status.N.getSymbol());
		parmObject.setInputRequestClose(Status.N.getSymbol());
		parmObject.setProcessActiveInd(serviceStatus);
		parmObject.setService(service);
		parmObject.setSubService(subService);

		try {
			CsoScheduleTimesDTO csoScheduleTimesDTO2 = csoScheduleTimesDAO.retrieve(csoScheduleTimesDTO);
			if (csoScheduleTimesDTO2 != null) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date startDate;
				try {
					startDate = df.parse(csoScheduleTimesDTO2.getProcessDate());
					parmObject.setProcessDate(startDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			CsoServiceParametersDAO csoServiceParametersDao = new CsoServiceParametersDAO();
			csoServiceParametersDao.update(parmObject);

			result = true;

		} catch (DAOException e) {
		}
		return result;
	}

	public SODService getSodService() {
		return sodService;
	}

	public void setSodService(SODService sodService) {
		this.sodService = sodService;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public DataSource getConn() {
		return datasource;
	}

	public void setConn(DataSource conn) {
		this.datasource = conn;
	}
}
