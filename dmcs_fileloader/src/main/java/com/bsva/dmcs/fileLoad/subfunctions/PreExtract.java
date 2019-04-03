//package com.bsva.dmcs.fileLoad.subfunctions;
//
//
//import javax.sql.DataSource;
//
//import org.apache.log4j.Logger;
//
//import com.bsva.dao.CsoInputFileControlsDao;
//import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
//import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
//import com.bsva.dcms.commons.enums.Status;
//import com.bsva.dcms.commons.exceptions.DAOException;
//import com.bsva.dcms.commons.exceptions.DuplicateProcessException;
//import com.bsva.dcms.commons.util.Utils;
//import com.bsva.dmcs.fileLoad.FileLoadDAO;
//import com.bsva.dmcs.fileLoad.extract.OutputFileNameGenerator;
//import com.bsva.dmcs.fileLoad.extract.OutputFileNameGeneratorException;
//import com.bsva.dto.FileStatusDTO;
//import com.bsva.dto.FileStatusDTO.FileProcessStatus;
//
//public class PreExtract {
//
//	private static String logPGM = "PREEXTRACT";
//	private static Logger log = Logger.getLogger(PreExtract.class);
//	private DataSource conn;
//	private String filename;
//	private String service;
//	private String subService;
//	private String fileReferenceNumber;
//
//	private CsoInputFileControlsDao csoInputFileControlsDao;
//
//	public PreExtract(String filename, String service, String subService, String fileReferenceNumber) {
//		super();
//		this.filename = filename;
//		this.service = service;
//		this.subService = subService;
//		this.fileReferenceNumber = fileReferenceNumber;
//
//		csoInputFileControlsDao = new CsoInputFileControlsDao();
//	}
//
//	public void execute() throws OutputFileNameGeneratorException, DuplicateProcessException{
//
//		// Is file available for billing
//		//    i.e. is CSO_INPUT_FILE_CONTROLS.PROCESS_STATUS = 'A' AND IS_PRE_EXTRACTED = 'N'
//		FileStatusDTO fileStatus = csoInputFileControlsDao.getFileStatus(fileReferenceNumber);
//		if ((fileStatus.getBilled().equals("Y") && fileStatus.getPreExtracted().equals("N"))){
//			 CsoInputFileControlsDAO csoInputFileControlsDao = new CsoInputFileControlsDAO();
//			 try {
//				 CsoInputFileControlsDTO csoInputFileControlsDto = new CsoInputFileControlsDTO();
//				 csoInputFileControlsDto.setFileRefNumber(fileReferenceNumber);
//				 csoInputFileControlsDto.setProcessStatus("A");
//				 csoInputFileControlsDto.setPreExtracted("N");
//				 csoInputFileControlsDto.setBilled("Y");
//				 CsoInputFileControlsDTO csoInputFileControlsdto = csoInputFileControlsDao.retrieve(csoInputFileControlsDto);
//				 if(csoInputFileControlsdto != null){
//					 csoInputFileControlsdto.setProcessStatus("B");
//					 csoInputFileControlsDao.update(csoInputFileControlsdto);
//				 }
//			} catch (DAOException ex) {
//				ex.getMessage();
//			}
//			OutputFileNameGenerator preExtractProcess = new OutputFileNameGenerator();
//			boolean preExtractSuccessful = preExtractProcess.execute(fileReferenceNumber , subService);
//			if(preExtractSuccessful){
//				try {
//					 CsoInputFileControlsDTO csoInputFileControlsDtos = new CsoInputFileControlsDTO();
//					 csoInputFileControlsDtos.setFileRefNumber(fileReferenceNumber);
//					 CsoInputFileControlsDTO csoInputFileControlsdto = csoInputFileControlsDao.retrieve(csoInputFileControlsDtos);
//					 csoInputFileControlsdto.setPreExtracted("Y");
//					 csoInputFileControlsdto.setProcessStatus("A");
//			         csoInputFileControlsDao.update(csoInputFileControlsdto);
//				} catch (DAOException ex) {
//					ex.getMessage();
//				}
//
//			}
//		}
//
//	}
//
//}
