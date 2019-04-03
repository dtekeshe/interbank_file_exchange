//package com.bsva.dmcs.fileLoad.extract;
//
//import java.sql.Connection;
//import java.util.List;
//
//import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
//import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
//import com.bsva.dcms.commons.exceptions.DAOException;
//
//public class CompleteInputFiles {
//
//
//	private CsoInputFileControlsDAO csoInputFileControlsDao = null;
//	private CsoInputFileControlsDTO csoInputFileControlsDto = null;
//
//	public CompleteInputFiles(Connection connection){
//
//		csoInputFileControlsDao = new CsoInputFileControlsDAO();
//		csoInputFileControlsDto = new CsoInputFileControlsDTO();
//	}
//
//	// i dont think this should be happening because extract picks status A files
//	public void execute(String subService) throws DAOException{
//
//		csoInputFileControlsDto = new CsoInputFileControlsDTO();
//		csoInputFileControlsDto.setProcessStatus("A"); // an accepted file
//		csoInputFileControlsDto.setSubService(subService);
//		String transactionStatus = "A";
//		List<CsoInputFileControlsDTO> csoInputFileControlsDtoList = csoInputFileControlsDao.retrieveFilesWithRejTxns(csoInputFileControlsDto , transactionStatus);
//
//		for(CsoInputFileControlsDTO inputfileCtrlDto : csoInputFileControlsDtoList){
//
//			CsoInputFileControlsDTO csoInputFileControlsDto = new CsoInputFileControlsDTO();
//			  csoInputFileControlsDto.setFileRefNumber(inputfileCtrlDto.getFileRefNumber());
//			  csoInputFileControlsDto.setOutputDate(inputfileCtrlDto.getOutputDate());
//				csoInputFileControlsDto.setService(inputfileCtrlDto.getService());
//				csoInputFileControlsDto.setSubService(inputfileCtrlDto.getSubService());
//				csoInputFileControlsDto.setNumberOfRecs(inputfileCtrlDto.getNumberOfRecs());
//				csoInputFileControlsDto.setNumberDebits(inputfileCtrlDto.getNumberCredits());
//				csoInputFileControlsDto.setNumberDebits(inputfileCtrlDto.getNumberDebits());
//				csoInputFileControlsDto.setCreditValue(inputfileCtrlDto.getCreditValue());
//				csoInputFileControlsDto.setDebitValue(inputfileCtrlDto.getDebitValue());
//				csoInputFileControlsDto.setHashTotal(inputfileCtrlDto.getHashTotal());
//				csoInputFileControlsDto.setLastFileIndicator(inputfileCtrlDto.getLastFileIndicator());
//				csoInputFileControlsDto.setProcessStatus("C");
//				csoInputFileControlsDto.setExtractedCount(inputfileCtrlDto.getExtractedCount());
//				csoInputFileControlsDto.setExtCredits(inputfileCtrlDto.getExtCredits());
//				csoInputFileControlsDto.setExtDebits(inputfileCtrlDto.getExtDebits());
//				csoInputFileControlsDto.setExtCreditValue(inputfileCtrlDto.getExtCreditValue());
//				csoInputFileControlsDto.setExtDebitValue(inputfileCtrlDto.getExtDebitValue());
//				csoInputFileControlsDto.setLastProcessDate(inputfileCtrlDto.getLastProcessDate());
//				csoInputFileControlsDto.setNextOutputDate(inputfileCtrlDto.getNextOutputDate());
//				csoInputFileControlsDto.setSettlementCount(inputfileCtrlDto.getSettlementCount());
//				csoInputFileControlsDto.setLoadDate(inputfileCtrlDto.getLoadDate() );
//				csoInputFileControlsDto.setOriginatingMember(inputfileCtrlDto.getOriginatingMember());
//				csoInputFileControlsDto.setNegativeCardCount(inputfileCtrlDto.getNegativeCardCount());
//				csoInputFileControlsDto.setNegativeDuplicateCount(inputfileCtrlDto.getNegativeDuplicateCount());
//				csoInputFileControlsDto.setLastCommitedRecordPointer(inputfileCtrlDto.getLastCommitedRecordPointer());
//				csoInputFileControlsDto.setExcepRepProducedInd(inputfileCtrlDto.getExcepRepProducedInd());
//				csoInputFileControlsDto.setErrorFilename(inputfileCtrlDto.getErrorFilename());
//				csoInputFileControlsDto.setSystemSeqNumber(inputfileCtrlDto.getSystemSeqNumber());
//				csoInputFileControlsDto.setOdsDataStatus(inputfileCtrlDto.getOdsDataStatus());
//				csoInputFileControlsDto.setBilled(inputfileCtrlDto.getBilled());
//				csoInputFileControlsDto.setPreExtracted(inputfileCtrlDto.getPreExtracted());
//
//			csoInputFileControlsDao.update(inputfileCtrlDto);
//		}
//
//	}
//
////	public void execute() throws DAOException{
////
////		csoInputFileControlsDto = new CsoInputFileControlsDTO();
////		csoInputFileControlsDto.setFileRefNumber(this.fileRefNumber);
////		csoInputFileControlsDto.setProcessStatus("A"); // an accepted file
////		csoInputFileControlsDto.setSubService(this.subService);
////		csoInputFileControlsDto = csoInputFileControlsDao.retrieve(csoInputFileControlsDto);
////
////		if (csoInputFileControlsDto == null)
////			return;
////
////		csoTransactionDto = new CSOTransactionDTO();
////		csoTransactionDto.setFileSystemSeqNumber(Long.parseLong(csoInputFileControlsDto.getFileRefNumber()));
////		List<CSOTransactionDTO> csoTransactionList = csoTransactionDao.retrieveRelated(csoTransactionDto);
////
////		Set<Long> fileSystemSeqNumbers = new HashSet<>();
////
////		for(CSOTransactionDTO transDto : csoTransactionList){
////			if (!transDto.getProcessStatus().equals("A")){
////				fileSystemSeqNumbers.add(new Long(transDto.getSystemSeqNumber()));
////			}
////		}
////
////		for(Long systemSeqNumber : fileSystemSeqNumbers){
////			csoInputFileControlsDto = new CsoInputFileControlsDTO();
////			csoInputFileControlsDto.setProcessStatus("C");
////			csoInputFileControlsDto.setSystemSeqNumber(systemSeqNumber.longValue());
////			csoInputFileControlsDao.update(csoInputFileControlsDto);
////		}
////	}
//}
