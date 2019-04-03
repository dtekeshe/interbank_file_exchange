//package com.bsva.dmcs.fileLoad.extract;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.sql.Connection;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.apache.log4j.Logger;
//
//import com.bsva.dcms.commons.dao.CsfDeliveryServicesDAO;
//import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
//import com.bsva.dcms.commons.dto.file.FileAXSHeaderRecordDTO;
//import com.bsva.dcms.commons.dto.file.FileAXSTrailorRecordDTO;
//import com.bsva.dcms.commons.dto.file.FileDTO;
//import com.bsva.dcms.commons.dto.file.FileTransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISAFileTransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISATCR0TransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISATCR1TransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISATCR5TransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISATCR7TransactionRecordDTO;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dcms.commons.util.Constants;
//import com.bsva.dcms.commons.util.StringUtil;
//
//public class RejectedTxFileExtract {
//
//	private DataSource connection;
//	private Logger log = Logger.getLogger(RejectedTxFileExtract.class);
//
//	public RejectedTxFileExtract(DataSource conn){
//		this.connection = conn;
//	}
//
//	public void extract(FileDTO fileDto){
//
//		BufferedWriter bw = null;
//		try{
//			FileAXSHeaderRecordDTO  header = getHeader(fileDto);
//
//			String outputFileName = header.getFileName();
//
//			bw = new BufferedWriter(new FileWriter(BsvTableLookup.getInstance().getSendDir() + File.separator + outputFileName));
//
//			//write header
//			bw.write(header.toString());
//			bw.newLine();
//			bw.flush();
//
//			//write file contents
//			List<FileTransactionRecordDTO> fileTransactions = fileDto.getFileTransactionRecordDtoList();
//			Collections.sort(fileTransactions , new FileTransactionSorter());
//
//			int lineCount  = 0;
//
//			for(FileTransactionRecordDTO fileTransactionRecordDTO : fileTransactions){
//
//				VISAFileTransactionRecordDTO visaFileTransactionRecordDto = (VISAFileTransactionRecordDTO)fileTransactionRecordDTO;
//
//				if (!visaFileTransactionRecordDto.isCurrentRecordValid()){
//					VISATCR0TransactionRecordDTO tcr0 = visaFileTransactionRecordDto.getTcr0TransactionRecordDto();
//					VISATCR1TransactionRecordDTO tcr1 = visaFileTransactionRecordDto.getTcr1TransactionRecordDto();
//					VISATCR5TransactionRecordDTO tcr5 = visaFileTransactionRecordDto.getTcr5TransactionRecordDto();
//					VISATCR7TransactionRecordDTO tcr7 = visaFileTransactionRecordDto.getTcr7TransactionRecordDto();
//
//					if (tcr0 != null){
//						bw.write(tcr0.getRecord());
//						bw.newLine();
//						bw.flush();
//						lineCount++;
//					}
//
//					if (tcr1 != null){
//						bw.write(tcr1.getRecord());
//						bw.newLine();
//						bw.flush();
//						lineCount++;
//					}
//
//					if (tcr5 != null){
//						bw.write(tcr5.getRecord());
//						bw.newLine();
//						bw.flush();
//						lineCount++;
//					}
//
//					if (tcr7 != null){
//						bw.write(tcr7.getRecord());
//						bw.newLine();
//						bw.flush();
//						lineCount++;
//					}
//				}
//			}
//			//write trailor
//			lineCount += 2; // add count for header and trailor;
//			FileAXSTrailorRecordDTO trailor = getTrailor(fileDto, header, lineCount);
//			bw.write(trailor.toString());
//			bw.flush();
//		}catch(Exception e){
//			log.error("Error creating reject output file for " + fileDto.getFileName() + ". cause: " + e.getMessage() , e);
//		}finally{
//			if (bw != null){
//				try {
//					bw.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					log.error(e.getMessage());
//				}
//			}
//		}
//	}
//
//	private FileAXSHeaderRecordDTO getHeader(FileDTO fileDto) throws Exception{
//
//		FileAXSHeaderRecordDTO  header = new FileAXSHeaderRecordDTO();
//
//		header.setRecordId(Constants.AXS_HEADER_RECID);
//		header.setOutputDate(BsvTableLookup.getInstance().getNextOutputProcessDate());
//		header.setServiceType(BsvTableLookup.getInstance().getSystemService());
//
//		CsfDeliveryServicesDTO csfDeliveryServicesDTO = new CsfDeliveryServicesDTO();
//		csfDeliveryServicesDTO.setInwardOutwardInd("O");
//		csfDeliveryServicesDTO.setSubService(fileDto.getFileAXSHeaderRecordDto().getSubServiceType() + "REP");
//		csfDeliveryServicesDTO = new CsfDeliveryServicesDAO().retrieve(csfDeliveryServicesDTO);
//
//		header.setSubServiceType(StringUtil.leftJustify(csfDeliveryServicesDTO.getSubService(), StringUtil.SPACE_STRING, 10));
//
//		header.setBankMemberNumber(StringUtil.rightJustify(fileDto.getFileAXSHeaderRecordDto().getBankMemberNumber(),StringUtil.ZERO_STRING ,4));
//		header.setOriginator(Constants.ORIGINATOR);
//
//		String fileName  = csfDeliveryServicesDTO.getFilenamePrefix() + fileDto.getFileName().substring(2);
//		header.setFileName(fileName);
//		header.setFileNumber(StringUtil.rightJustify(fileName.substring(4 , 7) , StringUtil.ZERO_STRING ,3));
//		header.setDataType(Constants.FILE_DATA_TYPE);
//		header.setDataDirection(StringUtil.leftJustify(Constants.OUT_DATA_DIRECTION, StringUtil.SPACE_STRING, 3) );
//		header.setSettlementDate(BsvTableLookup.getInstance().getNextOutputProcessDate());
//		header.setTestLiveIndicator(BsvTableLookup.getInstance().getSystemStatus());
//		header.setRecordLength(Constants.RECORD_SIZE);
//		header.setFiller(StringUtil.rightJustify("", StringUtil.SPACE_STRING , 101 ));
//
//		return header;
//	}
//
//	private FileAXSTrailorRecordDTO getTrailor(FileDTO fileDto , FileAXSHeaderRecordDTO header , int numRecords){
//
//		FileAXSTrailorRecordDTO trailor = new FileAXSTrailorRecordDTO();
//		trailor.setRecordId(Constants.AXS_TRAILOR_RECID);
//		trailor.setOutputDate(header.getOutputDate());
//		trailor.setServiceType(header.getServiceType());
//		trailor.setSubServiceType(header.getSubServiceType());
//		trailor.setBankMemberNumber(header.getBankMemberNumber());
//		trailor.setNumberOfRecords(StringUtil.rightJustify(String.valueOf(numRecords) ,StringUtil.ZERO_STRING,6) );
//		trailor.setSourceIdentifier(header.getBankMemberNumber());
//		trailor.setEncryptedWorkingKey(StringUtil.rightJustify("", StringUtil.SPACE_STRING , 16 ));
//		trailor.setMacOfHashTotal(StringUtil.rightJustify("", StringUtil.SPACE_STRING , 16));
//
//		long accountNumbers = 0;
//		for(FileTransactionRecordDTO txDto : fileDto.getFileTransactionRecordDtoList()){
//			accountNumbers += Long.parseLong(txDto.getCardNumber());
//		}
//
//		String accNumHash = StringUtil.rightJustify(String.valueOf(accountNumbers), StringUtil.ZERO_STRING, 18);
//		trailor.setHashtotalOfAccountNumbers(accNumHash.substring(6 , accNumHash.length()));
//
//		trailor.setFiller(StringUtil.rightJustify("", StringUtil.SPACE_STRING , 82 ));
//
//		return trailor;
//	}
//	private class FileTransactionSorter implements Comparator<FileTransactionRecordDTO>{
//
//		@Override
//		public int compare(FileTransactionRecordDTO o1,
//				FileTransactionRecordDTO o2) {
//			// TODO Auto-generated method stub
//			return o1.getRecordOffset() - o2.getRecordOffset();
//		}
//
//	}
//}
