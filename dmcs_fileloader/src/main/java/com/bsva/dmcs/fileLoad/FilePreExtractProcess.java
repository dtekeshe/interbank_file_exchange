//package com.bsva.dmcs.fileLoad;
//
//import java.text.ParseException;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import com.bsva.dcms.commons.dao.CsfPublicHolidaysDAO;
//import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
//import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
//import com.bsva.dcms.commons.dto.CsfPublicHolidaysDTO;
//import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
//import com.bsva.dcms.commons.dto.DelDeliveryFilesCCCDTO;
//import com.bsva.dcms.commons.exceptions.DAOException;
//import com.bsva.dcms.commons.exceptions.DuplicateProcessException;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dcms.commons.util.DateUtil;
//import com.bsva.dmcs.controller.AbstractProcess;
//import com.bsva.dmcs.fileLoad.extract.OutputFileNameGeneratorException;
//import com.bsva.dmcs.fileLoad.subfunctions.Billing;
//import com.bsva.dmcs.fileLoad.subfunctions.PreExtract;
//
//public class FilePreExtractProcess extends AbstractProcess {
//
//	private Logger log = Logger.getLogger(FileLoadProcess.class);
//
//
//	@Override
//	public void init() {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void process() {
//
//		try {
//			//log.debug("0000000000  In file Pre-Extract Process Started  0000000000");
//		   try {
//				CsoInputFileControlsDTO inputFilesDto = new CsoInputFileControlsDTO();
//                CsoInputFileControlsDAO daoInput = new CsoInputFileControlsDAO() ;
//                inputFilesDto.setProcessStatus("A");
//                List<CsoInputFileControlsDTO> inputFiles = daoInput.retrieveRelated(inputFilesDto);
//                for (CsoInputFileControlsDTO preExtractedFile : inputFiles) {
//				String filename = preExtractedFile.getFileRefNumber().substring(0,8);
//				String fileReferenceNumber = preExtractedFile.getFileRefNumber();
//				CsoInputFileControlsDTO inputFileControl  = new CsoInputFileControlsDTO();
//				inputFileControl.setPreExtracted("N");
//				inputFileControl.setBilled("Y");
//				inputFileControl.setProcessStatus("A");
//				inputFileControl.setFileRefNumber(fileReferenceNumber);
//				CsoInputFileControlsDAO dao = new CsoInputFileControlsDAO();
//				CsoInputFileControlsDTO csoInputFileControlsDto = dao.retrieve(inputFileControl);
//
//				if(csoInputFileControlsDto != null){
//						String service = preExtractedFile.getService();
//						String subService = preExtractedFile.getSubService();
//						PreExtract preExtract = new PreExtract(filename,service, subService, fileReferenceNumber);
//						log.debug("In file PreExtract process0000000000000000000000000000000000000000000000000000");
//						long now = System.currentTimeMillis();
//							try {
//								preExtract.execute();
//
//							} catch (OutputFileNameGeneratorException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//
//							CsfPublicHolidaysDTO csfPublicHolidaysDto = new CsfPublicHolidaysDTO();
//							CsfPublicHolidaysDTO csfPublicHolidaysDto2 = new CsfPublicHolidaysDTO();
//							String procDate = BsvTableLookup.getInstance().getProcessDate();
//					        Date processDate;
//							try {
//								processDate = DateUtil.formatStringToDate(procDate, "yyyyMMdd");
//								Calendar cal = Calendar.getInstance();
//								cal.setTime(processDate);
//								Date date = cal.getTime();
//								csfPublicHolidaysDto.setProcessDate(date);
//								//Minus one day from the Calender
//								/*cal.add(Calendar.DAY_OF_MONTH, -1);
//								Date date2 = cal.getTime();
//								csfPublicHolidaysDto2.setProcessDate(date2);*/
//							} catch (ParseException e) {
//								e.printStackTrace();
//							}
//							CsfPublicHolidaysDAO pubDao = new CsfPublicHolidaysDAO();
//							CsoInputFileControlsDAO csoInputFileControlsDao = new CsoInputFileControlsDAO();
//							CsoInputFileControlsDTO csoInputFileControlsDtos = new CsoInputFileControlsDTO();
//								CsfPublicHolidaysDTO retrieveResults = pubDao.retrieve(csfPublicHolidaysDto);
//								//CsfPublicHolidaysDTO retrieveResults2 = pubDao.retrieve(csfPublicHolidaysDto2);
//								if(retrieveResults == null){
//									//Is not a public Holiday
//									 csoInputFileControlsDtos.setFileRefNumber(fileReferenceNumber);
//									 CsoInputFileControlsDTO csoInputFileControlsdto = csoInputFileControlsDao.retrieve(csoInputFileControlsDtos);
//									 csoInputFileControlsdto.setProcessStatus("A");
//							         csoInputFileControlsDao.update(csoInputFileControlsdto);
//							         //if(retrieveResults2 == null){
//								         //Updating the previous Records that was on H Status to A if is not a holiday
//								         CsoInputFileControlsDTO csoInputFileControlsDt = new CsoInputFileControlsDTO();
//								         csoInputFileControlsDt.setProcessStatus("H");
//								         List<CsoInputFileControlsDTO> csoInputFileControlsdt = csoInputFileControlsDao.retrieveRelated(csoInputFileControlsDt);
//								         for (CsoInputFileControlsDTO csoInputFileControlsDTO2 : csoInputFileControlsdt) {
//								        	 csoInputFileControlsDTO2.setProcessStatus("A");
//								        	 csoInputFileControlsDao.update(csoInputFileControlsDTO2);
//										 }
//							         //}
//							         log.debug("After file process took : " + ((System.currentTimeMillis() - now ) / 1000) + "seconds 0000000000000000000000000000000000000000000000000000");
//								}else{
//									// It is a public Holiday and update inputfileControl Status to H
//									 csoInputFileControlsDtos.setFileRefNumber(fileReferenceNumber);
//									 CsoInputFileControlsDTO csoInputFileControlsdto = csoInputFileControlsDao.retrieve(csoInputFileControlsDtos);
//									 csoInputFileControlsdto.setProcessStatus("H");
//									 csoInputFileControlsdto.setPreExtracted("Y");
//							         csoInputFileControlsDao.update(csoInputFileControlsdto);
//							         log.debug("After file process took : " + ((System.currentTimeMillis() - now ) / 1000) + "seconds 0000000000000000000000000000000000000000000000000000");
//								}
//						/*} catch (OutputFileNameGeneratorException e) {
//							e.printStackTrace();
//						}*/
//						//log.debug("After file PreExtract process took : " + ((System.currentTimeMillis() - now ) / 1000) + "seconds 0000000000000000000000000000000000000000000000000000");
//					}
//				}
//
//			 // log.debug("0000000000  In file Pre_Extract Process Finished , There is no file to be Pre-Extracted0000000000 ");
//			} catch (DAOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		catch (Exception e) {
//			log.error(e.getMessage());
//		}
//
//	}
//
//}
