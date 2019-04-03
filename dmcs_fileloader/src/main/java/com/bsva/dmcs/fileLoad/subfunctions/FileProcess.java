//package com.bsva.dmcs.fileLoad.subfunctions;
//
//import javax.xml.transform.TransformerFactoryConfigurationError;
//
//import com.bsva.dao.CsoInputFileControlsDao;
//import com.bsva.dcms.commons.dao.DelDeliveryFilesCCCDAO;
//import com.bsva.dcms.commons.dto.DelDeliveryFilesCCCDTO;
//import com.bsva.dcms.commons.dto.file.FileDTO;
//import com.bsva.dcms.commons.dto.file.MastercardFileDTO;
//import com.bsva.dcms.commons.dto.file.VISAFileDTO;
//import com.bsva.dcms.commons.enums.Status;
//import com.bsva.dcms.commons.exceptions.DAOException;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dcms.commons.util.Csr023TotalCalculations;
//import com.bsva.dcms.commons.util.NegativeCardProcessing;
//import com.bsva.dcms.commons.util.Utils;
//import com.bsva.dmcs.fileLoad.FileLoadDAO;
//import com.bsva.dmcs.fileLoad.Loader;
//import com.bsva.dmcs.fileLoad.LoaderFactory;
//import com.bsva.dmcs.fileLoad.SaveFactory;
//import com.bsva.dmcs.fileLoad.Saver;
//import com.bsva.dmcs.fileLoad.Validator;
//import com.bsva.dmcs.fileLoad.ValidatorFactory;
//import com.bsva.dmcs.reports.CSR003;
//import com.bsva.dmcs.reports.CSR021;
//import com.bsva.dmcs.reports.CSR023;
//
//public class FileProcess {
//
//	private static String logPGM = "LOADER";
//	private String filename;
//	private String service;
//	private String subService;
//
//	private CsoInputFileControlsDao csoInputFileControlsDao;
//
//	public FileProcess(String filename, String service,
//			String subService) {
//		super();
//		this.filename = filename;
//		this.service = service;
//		this.subService = subService;
//
//		csoInputFileControlsDao = new CsoInputFileControlsDao();
//	}
//
//	public void execute() throws TransformerFactoryConfigurationError, Exception{
//
//		FileLoadDAO fileLoadDAO = new FileLoadDAO();
//
//		Utils.logProcess(logPGM, filename, service, subService, Status.A.getSymbol());
//
//		if (fileLoadDAO.isFileReadyForLoad(filename, service, subService)){
//
//			Utils.updateProcess(logPGM, filename, service, subService, Status.B.getSymbol());
//
//			//1. load the file into memory
//			Loader loader = LoaderFactory.getLoader(subService);
//			FileDTO fileDto = loader.load(filename);
//			Utils.logSpolog("Finished validating File :"+ filename);
//			//2. validate the file from memory
//			Validator validator = ValidatorFactory.getValidator(subService);
//			//validator.setConnection(conn);
//			validator.validate(fileDto);
//			Utils.updateProcess(logPGM, filename, service, subService, Status.C.getSymbol());
//			//3. vet the file
//			if (fileDto.getFileStatus().equals(Status.R.getSymbol())){
//				//CSR021V
//				logPGM = "CSR021";
//				Utils.logProcess(logPGM, filename, service, subService, Status.A.getSymbol());
//				CSR021 sr021Report = new CSR021(fileDto);
//				sr021Report.build();
//				Utils.updateProcess(logPGM, filename, service, subService, Status.B.getSymbol());
//				sr021Report.printTextFile();
//				Utils.logSpolog("CSR021 Reports created for :"+ filename);
//				Utils.updateProcess(logPGM, filename, service, subService, Status.C.getSymbol());
//
//			}else{
//				//CSR023V
//				logPGM = "CSR023";
//				Utils.logProcess(logPGM, filename, service, subService, Status.A.getSymbol());
//
//				Csr023TotalCalculations totalCalc = new Csr023TotalCalculations(filename,BsvTableLookup.getInstance().getProcessDate());
//				totalCalc.buildCsr023Totals(fileDto);
//				Utils.updateProcess(logPGM, filename, service, subService, Status.B.getSymbol());
//				CSR023 csr023Report = new CSR023(totalCalc);
//				csr023Report.build();
//				csr023Report.printTextFile();
//				Utils.logSpolog("CSR023 Reports created for :"+ filename);
//				Utils.updateProcess(logPGM, filename, service, subService, Status.C.getSymbol());
//			}
//
//                if ((fileDto instanceof VISAFileDTO) && (fileDto.getErrorDto().getErrorsList().size() > 20)) {
//					//CSR003 - VISA ERROR REPORT
//					CSR003 csr003Report = new CSR003(fileDto);
//					csr003Report.build();
//					csr003Report.printTextFile();
//					Utils.logSpolog("CSR003 Reports created for :"+ filename);
//                  }
//
//                 if ((fileDto instanceof MastercardFileDTO) && (fileDto.getErrorDto().getErrorsList().size() > 20)) {
//					//CSR003 - MCI ERROR REPORT
//					logPGM = "CSR003";
//					CSR003 csr003Report = new CSR003(fileDto);
//					csr003Report.build();
//					csr003Report.printTextFile();
//					Utils.logSpolog("CSR003 Reports created for :"+ filename);
//                 }
//
//			//4. create negative files if any(non existent for mastercard files
//			if (fileDto instanceof VISAFileDTO){
//
//				if (((VISAFileDTO) fileDto).getNegativeCardRecordDToList().size() > 0){
//					NegativeCardProcessing negativeCardProcessor = new NegativeCardProcessing();
//					negativeCardProcessor.processIncomingNegativeCardFile(((VISAFileDTO) fileDto).getNegativeCardRecordDToList(), fileDto.getFileOriginator() , filename);
//					negativeCardProcessor.processOutgoingNegativeCardFiles(fileDto.getFileOriginator());
//					//negativeCardProcessor.processOutgoingNegativeCardFiles();
//					//negativeCardProcessor.fixLastFileIndInOutControls();
//				}
//			}
//
//			//5. save the file into the database
//			Saver fileSaver = SaveFactory.getFileSaver(subService);
//			//fileSaver.setConnection(conn);
//			fileSaver.save(fileDto);
//
//			//5. If file was rejected , update del delivery status to rejected else proceed with the next subprocess
//	        try {
//	        	DelDeliveryFilesCCCDAO dao = new DelDeliveryFilesCCCDAO();
//		        DelDeliveryFilesCCCDTO dto = new DelDeliveryFilesCCCDTO();
//		        dto.setFileName(filename);
//		        DelDeliveryFilesCCCDTO dtoValue;
//
//		        dtoValue = dao.retrieve(dto);
//		        Utils.logSpolog("Logged File :"+ filename +"to DelDelivery");
//		       /*if (fileDto.getFileStatus().equals(Status.R.getSymbol())){
//					Utils.updateDelDeliveryStatus(filename,dtoValue.getPosition(),dtoValue.getQueueFileName(), Status.R.getSymbol());
//				}else*/
//					Utils.updateDelDeliveryStatus(filename,dtoValue.getPosition(),dtoValue.getQueueFileName(), Status.X.getSymbol());
//
//			} catch (DAOException e) {
//				e.printStackTrace();
//			}
//		}
//		logPGM = "LOADER";
//		Utils.updateProcess(logPGM, filename, service, subService, Status.A.getSymbol());
//	}
//
//}
