//package com.bsva.dmcs.fileLoad.extract;
//
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.apache.log4j.Logger;
//
//import com.bsva.dcms.commons.dao.CsfDeliveryServicesDAO;
//import com.bsva.dcms.commons.dao.CsfFilenameLookupDAO;
//import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
//import com.bsva.dcms.commons.dao.CsoOutputControlsDAO;
//import com.bsva.dcms.commons.dao.CsoTransactionsDAO;
//import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
//import com.bsva.dcms.commons.dto.CSOTransactionDTO;
//import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
//import com.bsva.dcms.commons.dto.CsfFilenameLookupDTO;
//import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
//import com.bsva.dcms.commons.dto.CsoOutputControlsDTO;
//import com.bsva.dcms.commons.dto.file.FileDTO;
//import com.bsva.dcms.commons.enums.Status;
//import com.bsva.dcms.commons.exceptions.DAOException;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dcms.commons.util.Utils;
//
//public class RejTxOutputFileNameGenerator {
//
//	private CsoTransactionsDAO csoTransactionDao = null;
//	private CSOTransactionDTO csoTransactionDto = null;
//	private CsoInputFileControlsDAO csoInputFileControlsDao = null;
//	private CsoInputFileControlsDTO csoInputFileControlsDto = null;
//	private CsfDeliveryServicesDAO csfDeliveryServiceDao = null;
//	private CsfDeliveryServicesDTO csfDeliveryServicesDTO = null;
//	private CsoOutputControlsDAO csoOutputControlsDao = null;
//	private CsoOutputControlsDTO csoOutputControlsDTO = null;
//	private CsfFilenameLookupDAO csfFilenameLookupDao = null;
//	private CsfFilenameLookupDTO csfFilenameLookupDTO = null;
//	private Logger log = Logger.getLogger(RejTxOutputFileNameGenerator.class);
//
//	//note these files go back to the sender i.e the originator
//	public RejTxOutputFileNameGenerator(){
//
//		csoTransactionDao = new CsoTransactionsDAO();
//		csoTransactionDto = new CSOTransactionDTO();
//		csoInputFileControlsDao = new CsoInputFileControlsDAO();
//		csoInputFileControlsDto = new CsoInputFileControlsDTO();
//		csfDeliveryServiceDao = new CsfDeliveryServicesDAO();
//		csfDeliveryServicesDTO = new CsfDeliveryServicesDTO();
//		csoOutputControlsDao = new CsoOutputControlsDAO();
//		csoOutputControlsDTO = new CsoOutputControlsDTO();
//		csfFilenameLookupDao = new CsfFilenameLookupDAO();
//		csfFilenameLookupDTO = new CsfFilenameLookupDTO();
//	}
//
//	public void execute(String fileRefNumber , String subService) throws DAOException{
//
//		csoInputFileControlsDto = new CsoInputFileControlsDTO();
//		csoInputFileControlsDto.setFileRefNumber(fileRefNumber);
//		csoInputFileControlsDto.setProcessStatus(Status.B.getSymbol()); // an accepted file
//		CsoInputFileControlsDTO csoInputFileControlsDto2 = csoInputFileControlsDao.retrieve(csoInputFileControlsDto);
//
//		if (csoInputFileControlsDto2 == null){ // i.e the file was never loaded
//			log.debug("File " + fileRefNumber + " not found.RejTxOutputFileNameGenerator stopped.");
//			return;
//		}
//		//
//		//get rejected transactions for the file, note the file could be an A status file
//		csoTransactionDto = new CSOTransactionDTO();
//		csoTransactionDto.setFileSystemSeqNumber(csoInputFileControlsDto2.getSystemSeqNumber());
//		csoTransactionDto.setProcessStatus(Status.R.getSymbol());
//		List<CSOTransactionDTO> csoTransactionList = csoTransactionDao.retrieveRelated(csoTransactionDto);
//
//		if (csoTransactionList == null){
//			log.debug("No status R transactions to generate output filenames for : " + csoInputFileControlsDto2.getFileRefNumber());
//			return;
//		}
//
//		long tran_system_seq_number = 0;
//		int max_file_size = 0; //the number of trans that each bank expects in its file
//		String filename_start = "";
//		String sub_service = ""; // sub_service of a transaction
//		int record_count = 0; // saved a non-financial record count
//
//		for(CSOTransactionDTO currentCsoTransaction : csoTransactionList){
//
//			csfDeliveryServicesDTO = new CsfDeliveryServicesDTO();
//			csfDeliveryServicesDTO.setService(csoInputFileControlsDto2.getService());
//			csfDeliveryServicesDTO.setActiveIndicator("Y");
//			csfDeliveryServicesDTO.setInwardOutwardInd("O");
//			csfDeliveryServicesDTO.setSubService(csoInputFileControlsDto2.getSubService() + "REP"); //not val .. = exception report for visa/mastercard
//			CsfDeliveryServicesDTO csfDeliveryServicesDTOs = csfDeliveryServiceDao.retrieve(csfDeliveryServicesDTO);
//
//			if (csfDeliveryServicesDTOs == null){ //i.e sub service for expeption report not set up
//				log.error("Error getting delivery service for transaction " + currentCsoTransaction.getSystemSeqNumber());
//				continue; //skip this transaction and move on to the next one
//			}
//			tran_system_seq_number = currentCsoTransaction.getSystemSeqNumber();
//			sub_service = csfDeliveryServicesDTOs.getSubService();
//			record_count = currentCsoTransaction.getFileRecordCnt();
//
//			//check that the bank code of the originating member is valid - this is where the file is going
//			boolean itemFound = false;
//			for(CSFMemberServiceDTO csfMemberServiceDto : BsvTableLookup.getInstance().getCsfMemberService()){
//				if (csfMemberServiceDto.getBankCode()== csoInputFileControlsDto2.getOriginatingMember() &&
//						csfMemberServiceDto.getService().equals(csoInputFileControlsDto2.getService())&&
//						csfMemberServiceDto.getSubService().equals(csoInputFileControlsDto2.getSubService())){
//					max_file_size = Integer.parseInt(csfMemberServiceDto.getMaxSizeTransFile());
//					filename_start = csfDeliveryServicesDTOs.getFilenamePrefix() + csfMemberServiceDto.getMemberTapeid(); // based on the originator
//					itemFound = true;
//					break;
//				}
//			}
//			if (!itemFound){
//				log.error("Error validating member for transaction " + currentCsoTransaction.getSystemSeqNumber());
//				continue; //skip this transaction and move on to the next one
//			}
//
//			//get last output filename generated for this originator
//			//List<CSOTransactionDTO> transDtoList = csoTransactionDao.retrieveByFileNameStart(filename_start);
//			int maxSequence = 0;
//			String lastOutputFilename = "";
//
//			/*if (transDtoList != null){
//				for(CSOTransactionDTO dto : transDtoList){
//					int seq = Integer.parseInt(dto.getOutputFilename().substring(4, 7));
//
//					if (seq > maxSequence){ // this will get us the very last sequence number
//						maxSequence = seq;
//						lastOutputFilename = dto.getOutputFilename();
//					}
//				}
//			}*/
//			//validate the sequence number
//			csfFilenameLookupDTO = new CsfFilenameLookupDTO();
//			csfFilenameLookupDTO.setNumIndex(maxSequence);
//			CsfFilenameLookupDTO csfFilenameLookupDTO2 = csfFilenameLookupDao.retrieve(csfFilenameLookupDTO);
//
//			//assign the current transaction to an existing file that is not full yet or create a new file for it
//
//			int fileTransactionsCount = 0;
//			int lastFileNumber = 0;
//
//			if (csfFilenameLookupDTO2 != null ){
//
//				int sum = 0;  // sum all the file_record_counts of transactions already assigned to this file
//				csoTransactionDto = new CSOTransactionDTO();
//				csoTransactionDto.setOutputFilename(lastOutputFilename);
//				List<CSOTransactionDTO> transactionsWithSameOutFileName = csoTransactionDao.retrieveRelated(csoTransactionDto);
//
//				for(CSOTransactionDTO t : transactionsWithSameOutFileName){
//					sum += t.getFileRecordCnt();
//				}
//				fileTransactionsCount =  sum + currentCsoTransaction.getFileRecordCnt();
//				lastFileNumber = csfFilenameLookupDTO.getNumIndex();
//
//			}else{ // i.e no output file generated for this originator yet
//				lastFileNumber = 0;
//				fileTransactionsCount = 0;
//			}
//
//			if (fileTransactionsCount == 0 || fileTransactionsCount > (max_file_size - 5)){  //allow some space for control records
//
//				//create a new filename based on originator -- start by first getting the sequence number
//				lastFileNumber++;
//
//				csfFilenameLookupDTO = new CsfFilenameLookupDTO();
//				csfFilenameLookupDTO.setNumIndex(lastFileNumber);
//				csfFilenameLookupDTO = csfFilenameLookupDao.retrieve(csfFilenameLookupDTO);
//
//				lastOutputFilename = filename_start + csfFilenameLookupDTO.getAlphaSeq() + "D";
//
//			}
//			csoTransactionDto = new CSOTransactionDTO();
//			csoTransactionDto.setOutputFilename(lastOutputFilename);
//			csoTransactionDto.setSystemSeqNumber(currentCsoTransaction.getSystemSeqNumber());
//			csoTransactionDao.update(csoTransactionDto);
//		}
//
//		Utils.logSpolog("Completed assigning output filenames to R txns for file " + fileRefNumber.substring(0 , 8));
//	}
//}
