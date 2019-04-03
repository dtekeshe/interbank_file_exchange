//package com.bsva.dmcs.fileLoad;
//
//import java.text.ParseException;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import com.bsva.dcms.commons.dao.CSFSubServicesDAO;
//import com.bsva.dcms.commons.dao.CsfDeliveryServicesDAO;
//import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
//import com.bsva.dcms.commons.dao.CsoOdsFileToLoadDAO;
//import com.bsva.dcms.commons.dao.CsoProgramControlsDAO;
//import com.bsva.dcms.commons.dao.CsoScheduleTimesDAO;
//import com.bsva.dcms.commons.dao.DelDeliveryFilesCCCDAO;
//import com.bsva.dcms.commons.dto.CSFSubServicesDTO;
//import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
//import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
//import com.bsva.dcms.commons.dto.CsoOdsFileToLoadDTO;
//import com.bsva.dcms.commons.dto.CsoProgramControlsDTO;
//import com.bsva.dcms.commons.dto.CsoScheduleTimesDTO;
//import com.bsva.dcms.commons.dto.DelDeliveryFilesCCCDTO;
//import com.bsva.dcms.commons.dto.file.FileDTO;
//import com.bsva.dcms.commons.enums.Status;
//import com.bsva.dcms.commons.exceptions.DAOException;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dcms.commons.util.DateUtil;
//
//public class FileLoadDAO {
//
//
//	private Logger log = Logger.getLogger(FileLoadDAO.class);
//
//
//	//get delivery service for a file
//	public CsfDeliveryServicesDTO getFileDeliveryService(String prefix) throws DAOException{
//
//		CsfDeliveryServicesDTO dto = new CsfDeliveryServicesDTO();
//		dto.setFilenamePrefix(prefix);
//		CsfDeliveryServicesDAO dao = new CsfDeliveryServicesDAO();
//		CsfDeliveryServicesDTO csfDeliveryServicesDto  = dao.retrieve(dto);
//
//		return csfDeliveryServicesDto;
//	}
//
//	//get all the files that have been logged on delivery
//	public List<DelDeliveryFilesCCCDTO> getReceivedFilesFromDelivery() throws DAOException{
//
//	   DelDeliveryFilesCCCDTO dto = new DelDeliveryFilesCCCDTO();
//	   dto.setQueueFileName("INQUE");
//	   String xmitindicator = Status.Y.getSymbol();
//	   dto.setXmitInd(xmitindicator);
//	   String str = BsvTableLookup.getInstance().getProcessDate();
//	   log.debug("FileLoad Process Date is :"+ str);
//	   dto.setPrddate(Integer.valueOf(BsvTableLookup.getInstance().getProcessDate()));
//	   DelDeliveryFilesCCCDAO dao = new DelDeliveryFilesCCCDAO();
//	   List<DelDeliveryFilesCCCDTO> list = dao.retrieveRelated(dto);
//
//	   return list;
//	}
//	//get all the files that have been logged on delivery
//	public List<DelDeliveryFilesCCCDTO> getLoadedFilesFromDelivery() throws DAOException{
//
//	   DelDeliveryFilesCCCDTO dto = new DelDeliveryFilesCCCDTO();
//	   dto.setQueueFileName("INQUE");
//	   String xmitindicator = Status.X.getSymbol();
//	   dto.setXmitInd(xmitindicator);
//	   String str = BsvTableLookup.getInstance().getProcessDate();
//	   //log.debug("FileLoad Process Date is :"+ str);
//	   dto.setPrddate(Integer.valueOf(BsvTableLookup.getInstance().getProcessDate()));
//	   DelDeliveryFilesCCCDAO dao = new DelDeliveryFilesCCCDAO();
//	   List<DelDeliveryFilesCCCDTO> list = dao.retrieveRelated(dto);
//
//	   return list;
//	}
//	//check if the sub service has been activated
//	public boolean isSubServiceActive(String processName,String service,String subService, String inOutIndicator) throws DAOException, ParseException{
//
//		//first check to see if the subservice is active
//		CSFSubServicesDTO csfSubServicesDTO = new CSFSubServicesDTO();
//		csfSubServicesDTO.setService(service);
//		csfSubServicesDTO.setSubservice(subService);
//		CSFSubServicesDAO csfSubServicesDAOdao = new CSFSubServicesDAO();
//		CSFSubServicesDTO csfSubServicesDTOdto = csfSubServicesDAOdao.retrieve(csfSubServicesDTO);
//
//		if (csfSubServicesDTOdto == null)
//			return false;
//
//		//then check to see if this subservice is active for the outward
//		CsfDeliveryServicesDTO csfDeliveryServicesDTO = new CsfDeliveryServicesDTO();
//		csfDeliveryServicesDTO.setService(service);
//		csfDeliveryServicesDTO.setSubService(subService);
//		csfDeliveryServicesDTO.setInwardOutwardInd(inOutIndicator.toUpperCase());
//		csfDeliveryServicesDTO.setActiveIndicator("Y");
//		CsfDeliveryServicesDAO ssfDeliveryServicesDao = new CsfDeliveryServicesDAO();
//		CsfDeliveryServicesDTO csfDeliveryServicesDto =  ssfDeliveryServicesDao.retrieve(csfDeliveryServicesDTO);
//
//		if (csfDeliveryServicesDto == null)
//			return false;
//
//		// then check the time when the subservice is supposed to be running
//		CsoScheduleTimesDTO dto = new CsoScheduleTimesDTO();
//		dto.setProcess(processName);
//		dto.setService(service);
//		dto.setSubService(subService);
//
//		CsoScheduleTimesDAO dao = new CsoScheduleTimesDAO();
//		CsoScheduleTimesDTO csoScheduleTimesdto = dao.retrieve(dto);
//
//		//start time
//		String startTime = csoScheduleTimesdto.getStartTime() == null ? "00:00:00" :  csoScheduleTimesdto.getStartTime();
//		Date startTimeDate = DateUtil.formatStringToDate(startTime, "HH:mm:ss");
//		Calendar startTimeCal = new GregorianCalendar();
//		startTimeCal.setTime(startTimeDate);
//
//		//end time
//		String endTime = csoScheduleTimesdto.getEndTime() == null ? "23:59:59" :  csoScheduleTimesdto.getEndTime();
//		Date endTimeDate = DateUtil.formatStringToDate(endTime, "HH:mm:ss");
//		Calendar endTimeCal = new GregorianCalendar();
//		endTimeCal.setTime(endTimeDate);
//
//		//current time
//		String currentTime = DateUtil.formatDate(new Date(), "HH:mm:ss"); // this is so we can strip only the time off from the date object
//		Date currentTimeDate = DateUtil.formatStringToDate(currentTime, "HH:mm:ss");
//		Calendar currentTimeCal = new GregorianCalendar();
//		currentTimeCal.setTime(currentTimeDate);
//
//		// sub service has be active and has a start and end time for activity
//		if (csoScheduleTimesdto.getActiveInd().equalsIgnoreCase(Status.Y.getSymbol()) && (currentTimeCal.after(startTimeCal) && currentTimeCal.before(endTimeCal))){
//			return true;
//		}else
//			return false;
//	}
//
//	public CsoOdsFileToLoadDTO getODSFile(String fileName){
//
//		try{
//			CsoOdsFileToLoadDTO odsFileDto = new CsoOdsFileToLoadDTO();
//			odsFileDto.setFilename(fileName);
//			CsoOdsFileToLoadDAO csoOdsFileToLoadDao = new CsoOdsFileToLoadDAO();
//			CsoOdsFileToLoadDTO csoOdsFileToLoadDto	= csoOdsFileToLoadDao.retrieve(odsFileDto);
//			return csoOdsFileToLoadDto;
//		}catch(Exception e){
//			log.error(e.getMessage() , e);
//		}
//		return null;
//	}
//
//	public void updateOdsFile(CsoOdsFileToLoadDTO odsFileDto){
//		try{
//			CsoOdsFileToLoadDAO csoOdsFileToLoadDao = new CsoOdsFileToLoadDAO();
//			csoOdsFileToLoadDao.update(odsFileDto);
//		}catch(Exception e){
//			log.error(e.getMessage() , e);
//		}
//	}
//
//	public void saveFileToODS(CsoOdsFileToLoadDTO odsFileDto){
//
//		try{
//			CsoOdsFileToLoadDAO csoOdsFileToLoadDao = new CsoOdsFileToLoadDAO();
//			csoOdsFileToLoadDao.create(odsFileDto);
//		}catch(Exception e){
//			log.error(e.getMessage() , e);
//		}
//	}
//
//	public void updateFileODSloadStatus(CsoInputFileControlsDTO csoInputFileControlsDTO){
//		try{
//			CsoInputFileControlsDAO csoInputFileControlsDao = new CsoInputFileControlsDAO();
//			csoInputFileControlsDao.update(csoInputFileControlsDTO);
//		}catch(Exception e){
//			log.error(e.getMessage() , e);
//		}
//	}
//
//	public boolean isFileReadyForLoad(String fileName , String service, String subService){
//	    return isProgramControlDataExisting("LOADER", fileName, service, subService, "A");
//	}
//
//	public boolean isFileReadyForBilling(String fileName , String service, String subService){
//		return isProgramControlDataExisting("BILLING", fileName, service, subService, "A");
//	}
//
//	public boolean isFileReadyForPreExtract(String fileName , String service, String subService){
//		return isProgramControlDataExisting("PREEXTRACT", fileName, service, subService, "A");
//	}
//
//	private boolean isProgramControlDataExisting(String programName,String fileName, String service, String subService , String status){
//
//		try{
//			CsoProgramControlsDTO progCtrlDto = new CsoProgramControlsDTO();
//			progCtrlDto.setProgramName(programName);
//			progCtrlDto.setServiceCode(service);
//			progCtrlDto.setSubServiceCode(subService);
//			progCtrlDto.setStatus(status);
//			progCtrlDto.setArbData(fileName);
//
//			CsoProgramControlsDAO prgCtrlDao = new CsoProgramControlsDAO();
//			CsoProgramControlsDTO csoProgramControlsDto = prgCtrlDao.retrieve(progCtrlDto);
//
//			if (csoProgramControlsDto == null)
//				return false;
//			else
//				return true;
//		}catch(Exception e){
//			return false;
//		}
//
//	}
//
//
//}
