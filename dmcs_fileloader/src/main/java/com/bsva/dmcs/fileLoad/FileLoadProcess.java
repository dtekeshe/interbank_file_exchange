//package com.bsva.dmcs.fileLoad;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import bsh.util.Util;
//
//import com.bsva.dcms.commons.dao.CsfPublicHolidaysDAO;
//import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
//import com.bsva.dcms.commons.dao.DelDeliveryFilesCCCDAO;
//import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
//import com.bsva.dcms.commons.dto.CsfPublicHolidaysDTO;
//import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
//import com.bsva.dcms.commons.dto.DelDeliveryFilesCCCDTO;
//import com.bsva.dcms.commons.enums.Status;
//import com.bsva.dcms.commons.exceptions.DAOException;
//import com.bsva.dcms.commons.exceptions.DuplicateProcessException;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dcms.commons.util.DateUtil;
//import com.bsva.dcms.commons.util.Utils;
//import com.bsva.dmcs.controller.AbstractProcess;
//import com.bsva.dmcs.fileLoad.subfunctions.Billing;
//import com.bsva.dmcs.fileLoad.subfunctions.FileProcess;
//import com.bsva.dmcs.fileLoad.subfunctions.PreExtract;
//
//public class FileLoadProcess extends AbstractProcess {
//
//	private static String logPGM = "LOADER";
//	private Logger log = Logger.getLogger(FileLoadProcess.class);
//
//
//	// load file into dto
//	public void process() {
//
//		//log.info("** LOADER STARTED ** ");
//		try {
//			FileLoadDAO fileLoadDAO = new FileLoadDAO();
//			// TODO : make this loop e.g while true, or run every 2 seconds
//			List<DelDeliveryFilesCCCDTO> delDeliveryFileList = fileLoadDAO.getReceivedFilesFromDelivery();
//
//			log.debug("Found " + delDeliveryFileList.size()+ " files on del_delivery_ccc");
//			for (DelDeliveryFilesCCCDTO delDeliveryFile : delDeliveryFileList) {
//				String filename = delDeliveryFile.getFileName();
//				String filenamePrefix = filename.substring(0, 2);
//				String fileReferenceNumber = filename + BsvTableLookup.getInstance().getNextOutputProcessDate();
//
//				//if("CVAG001D".equals(filename)){
//				CsfDeliveryServicesDTO fileDeliveryService = fileLoadDAO.getFileDeliveryService(filenamePrefix);
//				String service = fileDeliveryService.getService();
//				String subService = fileDeliveryService.getSubService();
//				try {
//					// check that the sub service is active before loading the file
//					logPGM = "LOADER";
//					if (Utils.isSubServiceActive(logPGM, service, subService,"I")) {
//						// 1. first process the file
//						try {
//							FileProcess fileProcess = new FileProcess(filename,service, subService);
//							log.debug("In file process0000000000000000000000000000000000000000000000000000");
//							Utils.logSpolog("Processing filename : "+ filename);
//							long now = System.currentTimeMillis();
//							fileProcess.execute();
//							CsoInputFileControlsDAO csoInputFileControlsDao = new CsoInputFileControlsDAO();
//							CsoInputFileControlsDTO csoInputFileControlsDtos = new CsoInputFileControlsDTO();
//							csoInputFileControlsDtos.setFileRefNumber(fileReferenceNumber);
//							CsoInputFileControlsDTO csoInputFileControlsdto =  csoInputFileControlsDao.retrieve(csoInputFileControlsDtos);
//							 if(csoInputFileControlsdto != null){
//								 csoInputFileControlsdto.setProcessStatus("A");
//								 csoInputFileControlsDao.update(csoInputFileControlsdto);
//							 }
//						}
//						catch (DuplicateProcessException e) {
//							log.error(e.getMessage());
//						}
//					} else {
//						log.debug("Subservice " + subService+ " is inactive. Cannot process file "+ filename);
//					}
//				} catch (Exception e) {
//					Utils.updateProcess(logPGM, delDeliveryFile.getFileName(),service, subService, Status.F.getSymbol());
//					DelDeliveryFilesCCCDAO dao = new DelDeliveryFilesCCCDAO();
//					DelDeliveryFilesCCCDTO dto = new DelDeliveryFilesCCCDTO();
//					dto.setFileName(filename);
//					DelDeliveryFilesCCCDTO dtoValue;
//					try {
//						dtoValue = dao.retrieve(dto);
//						Utils.updateDelDeliveryStatus(delDeliveryFile.getFileName(),delDeliveryFile.getPosition(),dtoValue.getQueueFileName(),Status.F.getSymbol());
//					} catch (DAOException ex) {
//						// TODO Auto-generated catch block
//						ex.getMessage();
//					}
//					log.error("Error processing file "+ delDeliveryFile.getFileName(), e);
//				}
//			}
//			//log.info("** LOADER DONE ** ");
//		} catch (Exception e) {
//			log.error("Error with file load. cause : " + e.getMessage(), e);
//		}
//	}
//
//	@Override
//	public void init() {
//		// TODO Auto-generated method stub
//	}
//}
