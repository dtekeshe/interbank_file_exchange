//package com.bsva.dmcs.fileLoad;
//
//
//import com.bsva.dcms.commons.dao.CsoBillingSummaryDAO;
//
//import org.apache.log4j.Logger;
//
//import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
//import com.bsva.dcms.commons.dto.CsoBillingSummaryDTO;
//import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
//import com.bsva.dcms.commons.dto.file.FileDTO;
//import com.bsva.dcms.commons.enums.Status;
//import com.bsva.dcms.commons.exceptions.DAOException;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dcms.commons.util.Csr023TotalCalculations;
//import com.bsva.dcms.commons.util.DateUtil;
//import com.bsva.dcms.commons.util.Utils;
//import com.bsva.dmcs.fileLoad.exceptions.FileLoadException;
//
//import java.math.BigDecimal;
//import java.math.BigInteger;
//
//public abstract class AbstractFileSaver implements Saver{
//
//	private Logger log = Logger.getLogger(AbstractFileSaver.class);
//
//	public long loadInputFileControls(FileDTO fileDto) throws FileLoadException{
//
//		long fileSequence = 0L;
//
//		try{
//			CsoInputFileControlsDTO inputFileControlDto = new CsoInputFileControlsDTO();
//			CsoInputFileControlsDAO inputFileControlsDao = new CsoInputFileControlsDAO();
//
//			//check to see if this file is already loaded.we must not load duplicate files
//			inputFileControlDto.setFileRefNumber(fileDto.getFileRefNumber());
//			CsoInputFileControlsDTO inputFileControldto = inputFileControlsDao.retrieve(inputFileControlDto);
//
//			if (inputFileControldto != null){
//
//				if (inputFileControldto.getProcessStatus().equals(Status.F.getSymbol())){
//					inputFileControlsDao.delete(inputFileControldto);
//				}else{
//					throw new FileLoadException("Duplicate file for " + fileDto.getFileName());
//			     }
//		    }
//
//
//                        Csr023TotalCalculations csr023TotalCalculations = new Csr023TotalCalculations(fileDto.getFileRefNumber(), null);
//                        csr023TotalCalculations.buildCsr023Totals(fileDto);
//
//							//insert new file record into table
//						CsoInputFileControlsDTO inputFileControlto = new CsoInputFileControlsDTO();
//						inputFileControlto.setFileRefNumber(fileDto.getFileRefNumber());
//						inputFileControlto.setService(fileDto.getFileService());
//						inputFileControlto.setSubService(fileDto.getFileSubService());
//
//                        // input file stats for csr024 report
//                        inputFileControlto.setCreditValue(csr023TotalCalculations.getTotAccCrVal() / 100);
//                        inputFileControlto.setNumberCredits((int)csr023TotalCalculations.getTotAccCrVol());
//                        inputFileControlto.setDebitValue(csr023TotalCalculations.getTotAccDrVal() / 100);
//                        inputFileControlto.setNumberDebits((int) csr023TotalCalculations.getTotAccDrVol());
//                        // using field to store the rejected error count for now
//                        inputFileControlto.setErrorFilename(String.valueOf(fileDto.getErrorDto().getErrorsList().size()));
//                        inputFileControlto.setBilled("N");
//                        inputFileControlto.setPreExtracted("N");
//
//                        // just populating for report testing purposes
//			/*inputFileControlto.setExtCreditValue(csr023TotalCalculations.getTotRejCrVal());
//                        inputFileControlto.setExtCredits((int) csr023TotalCalculations.getTotRejCrVol());
//                        inputFileControlto.setExtDebitValue(csr023TotalCalculations.getTotRejDrVal());
//                        inputFileControlto.setExtDebits((int) csr023TotalCalculations.getTotRejDrVal());*/
//				   //record count ??
//				String recCntStr = String.valueOf(fileDto.getRecordCount());
//		        if (recCntStr.length() > 6)
//		            recCntStr = recCntStr.substring(recCntStr.length() - 5);
//		        inputFileControlto.setNumberOfRecs(Integer.parseInt(recCntStr));
//
//		        inputFileControlto.setProcessStatus(fileDto.getFileStatus().equals(Status.A.getSymbol()) ? Status.B.getSymbol() : Status.A.getSymbol());
//		        inputFileControlto.setOriginatingMember(fileDto.getFileOriginator());
//		        inputFileControlto.setNegativeCardCount(0);
//		        inputFileControlto.setOutputDate(DateUtil.formatStringToDate(BsvTableLookup.getInstance().getNextOutputProcessDate() , "yyyyMMdd"));
//
//		        inputFileControlto.setOdsDataStatus("1"); //TODO: find the correct default
//
//				// on insert , a system sequence number will be generated, probably through a trigger??
//
//				 inputFileControlsDao.create(inputFileControlto);
//
//				//retrieve the generated system sequence number
//				//CsoInputFileControlsDTO inputFileControlDto2 = inputFileControlsDao.retrieve(inputFileControlDto);
//
//				fileSequence = inputFileControlto.getSystemSeqNumber();
//				fileDto.setFileSystemSeqNumber(fileSequence);
//
//                                // save summary billing information
//                                //saveBillingSummaryData(fileDto);
//
//
//
//
//
//			}catch(Exception e){
//				//throw new FileLoadException(e.getMessage());
//				Utils.logSpolog("Error Occured Validating File"+ e.getMessage());
//			}
//
//			return fileSequence;
//	}
//
//
//        public void saveBillingSummaryData(FileDTO fileDTO) throws DAOException {
//
//            CsoBillingSummaryDAO billingSummaryDAO = new CsoBillingSummaryDAO();
//            CsoBillingSummaryDTO billingSummaryDTO = new CsoBillingSummaryDTO();
//
//            billingSummaryDTO.setIssuingMember((short) fileDTO.getFileOriginator());
//            billingSummaryDTO.setService(fileDTO.getFileSubService());
//            billingSummaryDTO.setVolume(0);
//            billingSummaryDTO.setVolumeAbove(0);
//            billingSummaryDTO.setVolumeBelow(0);
//
//            billingSummaryDAO.create(billingSummaryDTO);
//
//        }
//
//
//}
