//package com.bsva.dmcs.fileLoad.ods;
//
//import java.sql.Connection;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
//import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
//import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
//import com.bsva.dcms.commons.dto.CsoOdsFileToLoadDTO;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dmcs.fileLoad.FileLoadDAO;
//
//public class FileLoadODSProcess implements Runnable{
//
//	private String fileName;
//	private String service;
//	private String subService;
//
//	private static String logPGM = "LOADER_ODS";
////	private DataSource ds;
//	@Resource(lookup = "java:jboss/datasources/DMCSDb")
//    private DataSource datasource;
//
//	public FileLoadODSProcess(Connection conn){
//		conn = (Connection) datasource;
//	}
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		try{
//
//			FileLoadDAO fileLoadDAO = new FileLoadDAO();
//			CsoOdsFileToLoadDTO odfFileToLoadDto = fileLoadDAO.getODSFile(fileName);
//
//			//save/file with a status of A
//			if (odfFileToLoadDto != null){
//
//				String status = odfFileToLoadDto.getStatus();
//
//				if (status.equals("A")){}
//				if (status.equals("B")){
//					odfFileToLoadDto.setStatus("D");
//					odfFileToLoadDto.setFileRefNumber(fileName + BsvTableLookup.getInstance().getProcessDate());
//					fileLoadDAO.updateOdsFile(odfFileToLoadDto);
//				}
//				if (status.equals("C") || status.equals("D")){
//					odfFileToLoadDto.setStatus("A");
//					odfFileToLoadDto.setFileRefNumber(fileName + BsvTableLookup.getInstance().getProcessDate());
//					fileLoadDAO.updateOdsFile(odfFileToLoadDto);
//				}
//
//			}else{
//				odfFileToLoadDto =  new CsoOdsFileToLoadDTO();
//				odfFileToLoadDto.setStatus("A");
//				odfFileToLoadDto.setFilename(fileName);
//				odfFileToLoadDto.setFileRefNumber(fileName + BsvTableLookup.getInstance().getProcessDate());
//				odfFileToLoadDto.setFileformat(subService);
//
//				fileLoadDAO.saveFileToODS(odfFileToLoadDto);
//			}
//
//			//fileLoadDAO.registerProcessFile(logPGM, fileName , service , subService, Status.A);
//
//			//TODO:
//			//1 . set ods_data_status to 3 on cso_input_file_controls
//			CsoInputFileControlsDTO inputFileControlsDTO = new CsoInputFileControlsDTO();
//			inputFileControlsDTO.setFileRefNumber(fileName + BsvTableLookup.getInstance().getProcessDate());
//			CsoInputFileControlsDAO csoInputFileControlsDAO = new CsoInputFileControlsDAO();
//			inputFileControlsDTO.setOdsDataStatus("3");
//			CsoInputFileControlsDTO inputFileControls = csoInputFileControlsDAO.retrieve(inputFileControlsDTO);
//				if(inputFileControls.getSystemSeqNumber() != 0)	{
//					//inputFileControlsDTO.setSystemSeqNumber(inputFileControls.getSystemSeqNumber());
//					CsoInputFileControlsDTO csoInputFileControlsDto = new CsoInputFileControlsDTO();
//					  csoInputFileControlsDto.setFileRefNumber(inputFileControls.getFileRefNumber());
//					  csoInputFileControlsDto.setOutputDate(inputFileControls.getOutputDate());
//						csoInputFileControlsDto.setService(inputFileControls.getService());
//						csoInputFileControlsDto.setSubService(inputFileControls.getSubService());
//						csoInputFileControlsDto.setNumberOfRecs(inputFileControls.getNumberOfRecs());
//						csoInputFileControlsDto.setNumberDebits(inputFileControls.getNumberCredits());
//						csoInputFileControlsDto.setNumberDebits(inputFileControls.getNumberDebits());
//						csoInputFileControlsDto.setCreditValue(inputFileControls.getCreditValue());
//						csoInputFileControlsDto.setDebitValue(inputFileControls.getDebitValue());
//						csoInputFileControlsDto.setHashTotal(inputFileControls.getHashTotal());
//						csoInputFileControlsDto.setLastFileIndicator(inputFileControls.getLastFileIndicator());
//						csoInputFileControlsDto.setProcessStatus("C");
//						csoInputFileControlsDto.setExtractedCount(inputFileControls.getExtractedCount());
//						csoInputFileControlsDto.setExtCredits(inputFileControls.getExtCredits());
//						csoInputFileControlsDto.setExtDebits(inputFileControls.getExtDebits());
//						csoInputFileControlsDto.setExtCreditValue(inputFileControls.getExtCreditValue());
//						csoInputFileControlsDto.setExtDebitValue(inputFileControls.getExtDebitValue());
//						csoInputFileControlsDto.setLastProcessDate(inputFileControls.getLastProcessDate());
//						csoInputFileControlsDto.setNextOutputDate(inputFileControls.getNextOutputDate());
//						csoInputFileControlsDto.setSettlementCount(inputFileControls.getSettlementCount());
//						csoInputFileControlsDto.setLoadDate(inputFileControls.getLoadDate() );
//						csoInputFileControlsDto.setOriginatingMember(inputFileControls.getOriginatingMember());
//						csoInputFileControlsDto.setNegativeCardCount(inputFileControls.getNegativeCardCount());
//						csoInputFileControlsDto.setNegativeDuplicateCount(inputFileControls.getNegativeDuplicateCount());
//						csoInputFileControlsDto.setLastCommitedRecordPointer(inputFileControls.getLastCommitedRecordPointer());
//						csoInputFileControlsDto.setExcepRepProducedInd(inputFileControls.getExcepRepProducedInd());
//						csoInputFileControlsDto.setErrorFilename(inputFileControls.getErrorFilename());
//						csoInputFileControlsDto.setSystemSeqNumber(inputFileControls.getSystemSeqNumber());
//						csoInputFileControlsDto.setOdsDataStatus("3");
//
//						csoInputFileControlsDAO.update(csoInputFileControlsDto);
//				}
//
//
//			//2. do some stuff
//			//.......
//
//
//			//3. set ods_data_status to 4 on cso_input_file_controls
//			inputFileControlsDTO.setOdsDataStatus("4");
//			csoInputFileControlsDAO.update(inputFileControlsDTO);
//
//			//fileLoadDAO.setProcessFileStage(logPGM, fileName,service , subService, Status.C);
//
//			//mark ods file as completed
//
//
//			odfFileToLoadDto.setStatus("C");
//			fileLoadDAO.updateOdsFile(odfFileToLoadDto);
//
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//
//	}
//	public String getFileName() {
//		return fileName;
//	}
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}
//	public String getService() {
//		return service;
//	}
//	public void setService(String service) {
//		this.service = service;
//	}
//	public String getSubService() {
//		return subService;
//	}
//	public void setSubService(String subService) {
//		this.subService = subService;
//	}
//
//}
