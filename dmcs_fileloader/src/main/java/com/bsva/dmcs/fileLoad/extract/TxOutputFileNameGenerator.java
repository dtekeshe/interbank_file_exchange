//package com.bsva.dmcs.fileLoad.extract;
//
//
//import java.sql.Connection;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import com.bsva.dcms.commons.dao.CSOPaymentInstructionsVisaDAO;
//import com.bsva.dcms.commons.dao.CsfCardFeeBilateralDAO;
//import com.bsva.dcms.commons.dao.CsfDeliveryServicesDAO;
//import com.bsva.dcms.commons.dao.CsfFilenameLookupDAO;
//import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
//import com.bsva.dcms.commons.dao.CsoOutputControlsDAO;
//import com.bsva.dcms.commons.dao.CsoPaymentInstructionsMcardDAO;
//import com.bsva.dcms.commons.dao.CsoTransactionsDAO;
//import com.bsva.dcms.commons.dto.CSFBinsDTO;
//import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
//import com.bsva.dcms.commons.dto.CSOPaymentInstructionsVisaDTO;
//import com.bsva.dcms.commons.dto.CSOTransactionDTO;
//import com.bsva.dcms.commons.dto.CsfCardFeeBilateralDTO;
//import com.bsva.dcms.commons.dto.CsfFilenameLookupDTO;
//import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
//import com.bsva.dcms.commons.dto.CsoOutputControlsDTO;
//import com.bsva.dcms.commons.dto.CsoPaymentInstructionsMcardDTO;
//import com.bsva.dcms.commons.enums.Status;
//import com.bsva.dcms.commons.exceptions.DAOException;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dcms.commons.util.FileNameGenerator;
//import com.bsva.dcms.commons.util.StringUtil;
//import com.bsva.dcms.commons.util.Utils;
//
//public class TxOutputFileNameGenerator {
//
//	private CsoTransactionsDAO csoTransactionDao = null;
//
//	private CsoInputFileControlsDAO csoInputFileControlsDao = null;
//	private CsfCardFeeBilateralDAO csfCardFeeBilateralDao = null;
//	private CsfCardFeeBilateralDTO csfCardfeeBilateralDTO = null;
//	private CsoOutputControlsDAO csoOutputControlsDao = null;
//	private CsfFilenameLookupDAO csfFilenameLookupDao = null;
//	private CsfFilenameLookupDTO csfFilenameLookupDTO = null;
//	private Logger log = Logger.getLogger(TxOutputFileNameGenerator.class);
//    private long systemSeqNumber = 0l;
//    private int recordCount = 0;
//    private long accNumberTotal = 0L;
//    private int filenam = 001;
//    private String lastOutputFileName = null;
//
//	//note : these files go to the destination bank
//	public TxOutputFileNameGenerator(){
//
//		csoTransactionDao = new CsoTransactionsDAO();
//
//		csoInputFileControlsDao = new CsoInputFileControlsDAO();
//		csfCardFeeBilateralDao = new CsfCardFeeBilateralDAO();
//		csfCardfeeBilateralDTO = new CsfCardFeeBilateralDTO();
//		csoOutputControlsDao = new CsoOutputControlsDAO();
//		csfFilenameLookupDao = new CsfFilenameLookupDAO();
//		csfFilenameLookupDTO = new CsfFilenameLookupDTO();
//	}
//
//	//this will be called per file instead of for all files at once , subService will be provided by the file object
//	public void execute(String fileRefNumber , String subService) throws DAOException{
//
//		CsoInputFileControlsDTO csoInputFileControlsDto = new CsoInputFileControlsDTO();
//		csoInputFileControlsDto.setSubService(subService);
//		csoInputFileControlsDto.setFileRefNumber(fileRefNumber);
//		csoInputFileControlsDto.setProcessStatus("B");
//		CsoInputFileControlsDTO csoInputFileControls = csoInputFileControlsDao.retrieve(csoInputFileControlsDto);
//
//		if (csoInputFileControls != null){ // i.e file was actually loaded
//			extract_subservice(csoInputFileControls);
//		}else
//			log.debug("File " + fileRefNumber + " not found.TxOutputFileNameGenerator stopped");
//	}
//
//	public void extract_subservice(CsoInputFileControlsDTO inputFileControlsDto)  throws DAOException{
//
//		long tran_system_seq_number = 0; // trigger generated number for a transaction
//		String max_file_size="0"; //the number of trans that each bank expects in its file
//		String filename_start;
//		int record_count = 0;   // saved a non-financial record count
//		String  fileNameDescription;
//		int fileContentCount = 2;
//		String dest_report;
//		int fileTransactionCount = 0;
//
//		//get all the transactions of the file retrieved through cso_input_file_controls
//		CSOTransactionDTO csoTransactionDto = new CSOTransactionDTO();
//		csoTransactionDto.setProcessStatus("A");
//		csoTransactionDto.setFileSystemSeqNumber(inputFileControlsDto.getSystemSeqNumber());
//
//		List<CSOTransactionDTO> csoTransactionList = csoTransactionDao.retrieveRelated(csoTransactionDto);
//
//		if (csoTransactionList.size() <= 0){
//			log.debug("No status A transactions to generate output filenames for : " + inputFileControlsDto.getFileRefNumber());
//			return;
//		}
//
//		for(CSOTransactionDTO csoTransaction : csoTransactionList){
//			tran_system_seq_number = csoTransaction.getSystemSeqNumber();
//
//			CsoInputFileControlsDTO csoInputFileControlsDto = new CsoInputFileControlsDTO();
//			csoInputFileControlsDto.setSystemSeqNumber(csoTransaction.getFileSystemSeqNumber());
//			CsoInputFileControlsDTO csoInputFileControls = csoInputFileControlsDao.retrieve(csoInputFileControlsDto);
//
//			//csf_card_fee_bilateral lookup
//			csfCardfeeBilateralDTO = new CsfCardFeeBilateralDTO();
//			csfCardfeeBilateralDTO.setIssuingMember(csoTransaction.getIssuerMember());
//			csfCardfeeBilateralDTO.setAcquiringMember(csoTransaction.getAcquirerMember());
//			csfCardfeeBilateralDTO.setTransactionCode(csoTransaction.getTransactionCode());
//			csfCardfeeBilateralDTO = csfCardFeeBilateralDao.retrieve(csfCardfeeBilateralDTO);
//			if (csfCardfeeBilateralDTO != null){
//				dest_report = csfCardfeeBilateralDTO.getDestReport(); //not used
//			}
//
//			//cso_output_control lookup
//			CsoOutputControlsDTO csoOutputControlsDTO = new CsoOutputControlsDTO();
//			csoOutputControlsDTO.setStatusCode("O");
//			csoOutputControlsDTO.setOriginatingMember(csoInputFileControls.getOriginatingMember());
//
//			accNumberTotal += Long.valueOf(csoTransaction.getAccountNumber());
//
//			CSFBinsDTO binDto_Acquirer = null;
//			binDto_Acquirer = BsvTableLookup.getInstance().getBINDetailForBin(Integer.valueOf(csoTransaction.getAcquirerBin()));
//			int acq = binDto_Acquirer.getBankCode();
//
//			CSFBinsDTO binDto_Issuer = null;
//			binDto_Issuer = BsvTableLookup.getInstance().getBINDetailForBin(Integer.valueOf(csoTransaction.getIssuerBin()));
//			int iss = binDto_Issuer.getBankCode();
//
//			//get the destination of the file
//			int destinationMember = 0;
//			if (acq == csoInputFileControls.getOriginatingMember()){
//				destinationMember = iss;
//			}else{  //i.e originator is the same as the issuer
//				destinationMember = acq;
//			}
//
//			if (acq == 0){
//				destinationMember = iss;
//			}else if (iss == 0){
//				destinationMember = acq;
//			}
//
//			// i.e get output control details for file coming from originator A to destination B
//			csoOutputControlsDTO.setBankCode(destinationMember);  // destination bank code
//
//			if(csoInputFileControls.getSubService().equals("FLEET")){
//			csoOutputControlsDTO.setSubService(csoInputFileControls.getSubService()+" CARD");
//			}else{
//				csoOutputControlsDTO.setSubService(csoInputFileControls.getSubService());
//			}
//			csoOutputControlsDTO.setService(csoInputFileControls.getService());
//
//			CsoOutputControlsDTO csoOutputControls =  csoOutputControlsDao.retrieve(csoOutputControlsDTO);
//
//			if (csoOutputControls == null){  //i.e files from A to B are not possible
//				log.error("Error getting cso output controls for transaction " + csoTransaction.getSystemSeqNumber() + ", destination " + destinationMember);
//				continue; //skip this transaction and move on to the next one
//			}
//			fileNameDescription = csoOutputControls.getFilenameDescription();
//			//fileContentCount += csoTransaction.getFileRecordCnt();  // records currently assigned to this output filename
//			filename_start = csoOutputControls.getFilenamePrefix() + csoOutputControls.getDistributionCode(); //distribution code of the destination
//
//			//csf_filename_lookup
//			csfFilenameLookupDTO = new CsfFilenameLookupDTO();
//			csfFilenameLookupDTO.setAlphaSeq(csoOutputControls.getSeqNumber());
//			csfFilenameLookupDTO.setNumIndex(-1);
//			csfFilenameLookupDTO = csfFilenameLookupDao.retrieve(csfFilenameLookupDTO);
//
//			if (csfFilenameLookupDTO == null){ //  if seq number is not valid
//				log.error("Error validating sequence number for transaction " + csoTransaction.getSystemSeqNumber() + ",filename " + csoOutputControls.getFilenameDescription());
//				continue; //skip this transaction and move on to the next one
//			}
//
//			//check csf_member_service if destination bank code is valid
//			boolean itemFound = false;
//			for(CSFMemberServiceDTO csfMemberServiceDto : BsvTableLookup.getInstance().getCsfMemberService()){
//				if (csfMemberServiceDto.getBankCode()== csoOutputControls.getBankCode() &&
//						csfMemberServiceDto.getService().equals(csoOutputControls.getService())&&
//						csfMemberServiceDto.getSubService().equals(csoOutputControls.getSubService())){
//					max_file_size = csfMemberServiceDto.getMaxSizeTransFile();
//					itemFound = true;
//					break;
//				}
//			}
//			if (!itemFound){
//				log.error("Error retrieving member for transaction " +  csoTransaction.getSystemSeqNumber());
//				continue; //skip this transaction and move on to the next one
//			}
//			//update output filename per transaction
//			 lastOutputFileName = fileNameDescription;
//
//
//
//			if (fileTransactionCount >= Integer.parseInt(max_file_size)){
////			if (fileTransactionCount >= Integer.parseInt(max_file_size)){
//
//				//mark that filename as completed
//				CsoOutputControlsDTO csoOutputControlsDTO1 = new CsoOutputControlsDTO();//fileNameDescription
//				csoOutputControlsDTO1.setFilenameDescription(fileNameDescription);
//				CsoOutputControlsDTO csoOutputControlsDTO6 = new CsoOutputControlsDAO().retrieve(csoOutputControlsDTO1);
//				if(csoOutputControlsDTO6 != null){
//					csoOutputControlsDTO6.setStatusCode("C");  //i.e this output filename should no longer be used because it is full
//					csoOutputControlsDTO6.setLastFileIndicator(Status._N.getSymbol());
//					csoOutputControlsDTO6.setFullFileInd(Status._F.getSymbol());
//					csoOutputControlsDTO6.setRecordCount(fileTransactionCount);
//					//csoOutputControlsDTO6.setFilenameDescription(lastOutputFileName); // update this filename
//					//csoOutputControlsDao.update(csoOutputControlsDTO2);
//
//					//get latest record - to be used whrn adding a new file name on output controls
//					//csoOutputControlsDTO = new CsoOutputControlsDTO();
//					//csoOutputControlsDTO.setFilenameDescription(lastOutputFileName);
//					//csoOutputControlsDTO = csoOutputControlsDao.retrieve(csoOutputControlsDTO);
//
//					//mark  last_file_indicator = 'N' for all the files with this distribution code and filename prefix
//					//csoOutputControlsDTO2.setLastFileIndicator("N");
//					//csoOutputControlsDTO6.setDistributionCode(csoOutputControlsDTO.getDistributionCode());
//					//csoOutputControlsDTO6.setFilenamePrefix(csoOutputControlsDTO.getFilenamePrefix());
//					csoOutputControlsDao.update(csoOutputControlsDTO6);
//				}
//
//				CsoOutputControlsDAO csoOutputControlsdao1 = new CsoOutputControlsDAO();
//	             CsoOutputControlsDTO csoOutputControlsdto1 = new CsoOutputControlsDTO();
//	             csoOutputControlsdto1.setFilenamePrefix(fileNameDescription.substring(0, 2));
//	             List<CsoOutputControlsDTO> csoOutputControlsDto2 = csoOutputControlsdao1.retrieveRelated(csoOutputControlsdto1);
//	             if(csoOutputControlsDto2.size() > 0){
//	               for (CsoOutputControlsDTO csoOutputControlsDTO3 : csoOutputControlsDto2) {
//	            	   csoOutputControlsDTO3.setLastFileIndicator(Status.N.getSymbol());
//	            	 csoOutputControlsdao1.update(csoOutputControlsDTO3);
//	               }
//	             }
//
//				//add new file name
//				String newFileName =  new FileNameGenerator().generateFile(filename_start.substring(0 , 2), filename_start.substring(2, 4));
//
//				if (newFileName == null || newFileName.equals("")){
//					log.error("Error genetating filename for transaction " +  csoTransaction.getSystemSeqNumber());
//					continue;
//				}
//				CsoOutputControlsDTO newCsoOutputControlsDTO = new CsoOutputControlsDTO();
//				newCsoOutputControlsDTO.setBankCode(csoOutputControlsDTO6.getBankCode());
//				newCsoOutputControlsDTO.setService(csoOutputControlsDTO6.getService());
//				newCsoOutputControlsDTO.setSubService(csoOutputControlsDTO6.getSubService());
//				newCsoOutputControlsDTO.setFilenamePrefix(csoOutputControlsDTO6.getFilenamePrefix());
//				newCsoOutputControlsDTO.setDistributionCode(csoOutputControlsDTO6.getDistributionCode());
//				newCsoOutputControlsDTO.setSeqNumber(newFileName.substring(4 , 7));
//				newCsoOutputControlsDTO.setStatusCode("O");  // output filename ready for use
//				newCsoOutputControlsDTO.setFilenameDescription(newFileName);
//				newCsoOutputControlsDTO.setTransmissionDate(csoOutputControlsDTO6.getTransmissionDate());
//				newCsoOutputControlsDTO.setLastFileIndicator("Y");
//				newCsoOutputControlsDTO.setOriginatingMember(csoOutputControlsDTO6.getOriginatingMember());
//				newCsoOutputControlsDTO.setOriginatingBankId(csoOutputControlsDTO6.getOriginatingBankId());
//				newCsoOutputControlsDTO.setFullFileInd(Status.D.getSymbol());
//				csoOutputControlsDao.create(newCsoOutputControlsDTO);
//				//update with the new filename
//				lastOutputFileName = newFileName;
//
//				//reset the number of transaction there
//				fileTransactionCount = 0;
//				fileContentCount = 0;
//			}
//
//			//assign the filename to the transaction and mark that transaction as completed
//			CSOTransactionDTO csoTransactionDto1 = new CSOTransactionDTO();
//			csoTransactionDto1.setSystemSeqNumber(tran_system_seq_number);
//			CSOTransactionDTO csoTransactionDto2 = new CsoTransactionsDAO().retrieve(csoTransactionDto1);
//			if(csoTransactionDto2 != null){
//				csoTransactionDto2.setOutputFilename(lastOutputFileName);
//				csoTransactionDto2.setProcessStatus("C");
//				csoTransactionDao.update(csoTransactionDto2);
//			}
//
//			if(csoOutputControls.getSubService().equals("MASTERCARD")){
//				//assign output filename to PaymentInstructions
//				CsoPaymentInstructionsMcardDTO paymentInstructionMCI = new CsoPaymentInstructionsMcardDTO();
//				paymentInstructionMCI.setFileRefNumber1(String.valueOf(csoTransaction.getFileSystemSeqNumber()));
//				CsoPaymentInstructionsMcardDTO paymentInstructionsMCIDTO = new CsoPaymentInstructionsMcardDAO().retrieve(paymentInstructionMCI);
//				if(paymentInstructionsMCIDTO != null){
//						fileContentCount++;
//						paymentInstructionsMCIDTO.setFilenameDescription(lastOutputFileName);
//						new CsoPaymentInstructionsMcardDAO().update(paymentInstructionsMCIDTO);
//
//				}
//			}else{
//				//assign output filename to PaymentInstructions
//				CSOPaymentInstructionsVisaDTO paymentInstruction = new CSOPaymentInstructionsVisaDTO();
//				paymentInstruction.setSystemGenSeqNumber((int)tran_system_seq_number);
//				List<CSOPaymentInstructionsVisaDTO> paymentInstructionsVisaDTO = new CSOPaymentInstructionsVisaDAO().retrieveRelated(paymentInstruction);
//				if(paymentInstructionsVisaDTO.size() > 0){
//					for (CSOPaymentInstructionsVisaDTO csoPaymentInstructionsVisaDTO : paymentInstructionsVisaDTO) {
//						csoPaymentInstructionsVisaDTO.setFilenameDescription(lastOutputFileName);
//						fileContentCount++;
//						new CSOPaymentInstructionsVisaDAO().update(csoPaymentInstructionsVisaDTO);
//
//					}
//				}
//			}
//			 fileTransactionCount = fileContentCount;
//			//incremanet  the number of transactions now assigned to an output file name
//			//fileTransactionCount++;
//			CsoOutputControlsDTO csoOutputControlsDTO5 = new CsoOutputControlsDTO();
//			csoOutputControlsDTO5.setFilenameDescription(lastOutputFileName);
//			CsoOutputControlsDTO CsoOutputControlsDTO4 = csoOutputControlsDao.retrieve(csoOutputControlsDTO5);
//			if(CsoOutputControlsDTO4 != null){
//
//				CsoOutputControlsDTO4.setFullFileInd(fileContentCount > Integer.parseInt(max_file_size)? Status._F.getSymbol() :Status._N.getSymbol() );
//				if(CsoOutputControlsDTO4.getFullFileInd().equals("N")){
//				  CsoOutputControlsDTO4.setRecordCount(fileContentCount+3);
//				}else{
//				  CsoOutputControlsDTO4.setRecordCount(fileContentCount);
//				}
//				CsoOutputControlsDTO4.setFilenameDescription(lastOutputFileName);
//				String accountNumberHash = StringUtil.rightJustify(String.valueOf(accNumberTotal), StringUtil.ZERO_STRING, 12);
//				CsoOutputControlsDTO4.setHashTotal99(Long.valueOf(accountNumberHash));
//				csoOutputControlsDao.update(CsoOutputControlsDTO4);
//			}
//
//		}
//
//		Utils.logSpolog("Completed assigning output filenames to A txns for file " + inputFileControlsDto.getFileRefNumber().substring(0 , 8));
//	}
//}
