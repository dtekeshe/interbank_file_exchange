package com.bsva.dcms.commons.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.bsva.dcms.commons.dao.CSFMembersDAO;
import com.bsva.dcms.commons.dao.CSFMembersServiceDAO;
import com.bsva.dcms.commons.dao.CsoNegcardInfoDAO;
import com.bsva.dcms.commons.dao.CsoOutputControlsDAO;
import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.dto.CSFMembersDTO;
import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
import com.bsva.dcms.commons.dto.CsoNegcardInfoDTO;
import com.bsva.dcms.commons.dto.CsoOutputControlsDTO;
import com.bsva.dcms.commons.dto.file.FileAXSHeaderRecordDTO;
import com.bsva.dcms.commons.dto.file.FileAXSTrailorRecordDTO;
import com.bsva.dcms.commons.dto.file.NegativeCardRecordDTO;
import com.bsva.dcms.commons.enums.Status;
import com.bsva.dcms.commons.exceptions.DAOException;


//NOTE: this is depending on extracts having run to an end and ser cso_output_controls to C
public class NegativeCardProcessing {


	private Logger log = Logger.getLogger(NegativeCardProcessing.class);
	
	public NegativeCardProcessing(){
	}
	
	public void processIncomingNegativeCardFile(List<NegativeCardRecordDTO> negativeCardRecordDtos,int fileOrigin , String fileName){
		
		try{
			insertNegativeData(negativeCardRecordDtos, fileOrigin, fileName);
			writeNegCardTrxnsToTmpFile(negativeCardRecordDtos, fileOrigin, fileName);
		}catch(Exception e){
			log.error("Error processing incoming negative card file. cause : " +  e.getMessage() , e);
		}
	}
	
	//for all negative files
	public void processOutgoingNegativeCardFiles(){
		try{
			CsoNegcardInfoDAO csoNegcardInfodao = new CsoNegcardInfoDAO();
			List<CsoNegcardInfoDTO> csoNegcardInfoDTOs = csoNegcardInfodao.retrieveUniqueFileOriginator(BsvTableLookup.getInstance().getProcessDate());
			
			for(CsoNegcardInfoDTO csoNegcardInfoDTO : csoNegcardInfoDTOs){
				log.info("Processing outgoing negative files for Originator " + csoNegcardInfoDTO.getFileOriginator());
				processOutgoingNegativeCardFiles(csoNegcardInfoDTO.getFileOriginator());
			}
		}catch(Exception e){
			log.error("Error with processOutgoingNegativeCardFiles. cause : " + e.getMessage(), e);
		}
	}
	
	public void processOutgoingNegativeCardFiles(int fileOrigin) throws Exception{
		

			String fileOriginator = String.valueOf(fileOrigin);
			createOutputFileNamesForNegCards(fileOriginator);
			writeNegativeCardInfoOut(fileOriginator);
		
	}
	
	//1. insert data about negatives into tables
	public void insertNegativeData(List<NegativeCardRecordDTO> negativeCardRecordDtos,int fileOrigin , String fileName) throws Exception{
	
		  // the insert details about the negative file into the database
		  
		CsoNegcardInfoDTO csoNegcardInfoDTO = new CsoNegcardInfoDTO();
		csoNegcardInfoDTO.setFileOriginator(fileOrigin);
		csoNegcardInfoDTO.setNegCardCount(negativeCardRecordDtos.size());
		csoNegcardInfoDTO.setOutputDate(BsvTableLookup.getInstance().getNextOutputProcessDate());
		CsoNegcardInfoDAO CsoNegcardInfodao = new CsoNegcardInfoDAO();
		CsoNegcardInfodao.create(csoNegcardInfoDTO);
			  
		log.debug("Successfully Logged Negative File details into table for filename " + fileName); 
	}

   //2. write unique negative card details into file
   public void writeNegCardTrxnsToTmpFile(List<NegativeCardRecordDTO> negativeCardRecordDtos,int fileOrigin , String fileName) throws Exception{
		  
	     // first sort the negative card records by account number
	      List<NegativeCardRecordDTO> uniqueNegativeCardRecordDtos =  getUniqueNegativeCards(negativeCardRecordDtos);
	      Collections.sort(uniqueNegativeCardRecordDtos , new NegativeCardAccNumSorter());
	      
	     //first create the negative file
		  BufferedWriter negOutBW = null;
		  String negativeFileName = "";
		  try{
			  
			negativeFileName = "CNEGFILE." + String.format("%04d", fileOrigin);
	        FileWriter negCardFile = new FileWriter(BsvTableLookup.getInstance().getSendDir() + File.separator + negativeFileName,true);
	        negOutBW = new BufferedWriter(negCardFile);
	        
	        for(NegativeCardRecordDTO negativeCardRecordDTO : uniqueNegativeCardRecordDtos){
	   
	        	if (negativeCardRecordDTO.isCurrentRecordValid()){
			        negOutBW.write(negativeCardRecordDTO.getRecord().trim());
			        negOutBW.newLine();
	        	}
	        }
	         
	        log.info("Created Negative File " + negativeFileName + "for " + fileName);
	        
		  }finally{
			  if (negOutBW != null){
				  try {
					negOutBW.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					log.error(e.getMessage() , e); 
				}
			  }
		  }
	  }
   
     // will generate filenames for negative card records
     // fileOriginator should be null if you want it to do this for all originators
     public void createOutputFileNamesForNegCards(String fileOriginator) throws Exception{
    	 
    	 Map<String , NegativeFile> receivedNegCardFileDataByOrigin = getReceivedNegCardFileDataByOrigin(fileOriginator);
    	 
    	 if (receivedNegCardFileDataByOrigin.size() <= 0)
    		 throw new RuntimeException("No files for originator / BankCode  : " +  fileOriginator + " on cso_output_file_controls");
    	 else
    		 assignNegCardFileTrxnToFile(receivedNegCardFileDataByOrigin);
     }
   	
     //get last filename generated for this originator
     @SuppressWarnings("null")
	public Map<String , NegativeFile> getReceivedNegCardFileDataByOrigin(String fileOriginator) throws Exception{
    	 
    	 //this will return the last filename that has been assigned to this bankcode + total of neg records for this bankcode
    	Map<String , NegativeFile> negativeRecordGroup = new HashMap<>();
    	
    	 try {
    		 
    		 List<CsoNegcardInfoDTO> csoNegcardInfoDTOs =  null;
    		 
    		 CsoNegcardInfoDTO csoNegCrdInfoSearchDTO = new CsoNegcardInfoDTO();
    		 csoNegCrdInfoSearchDTO.setFileOriginator(Integer.parseInt(fileOriginator));
    		 csoNegCrdInfoSearchDTO.setOutputDate(BsvTableLookup.getInstance().getProcessDate());
    		 csoNegcardInfoDTOs = new CsoNegcardInfoDAO().retrieveRelated(csoNegCrdInfoSearchDTO);
    		
    		 for(CsoNegcardInfoDTO csoNegcardInfoDTO : csoNegcardInfoDTOs){
				
				CSFMembersDTO csfMembersDto = new CSFMembersDTO();
				csfMembersDto.setBankCode(csoNegcardInfoDTO.getFileOriginator());
				CSFMembersDAO csfMembersDao = new CSFMembersDAO();
				CSFMembersDTO csFMembersDto = csfMembersDao.retrieve(csfMembersDto);
				
				if (csFMembersDto == null){  // i.e originator does not exist
					log.error("Error loading member " + csoNegcardInfoDTO.getFileOriginator());
					continue;
				}
				if (csFMembersDto.getNegCardDataRequired().equals("N")){ // if originator does not require negative card files
					log.debug("Member " + csoNegcardInfoDTO.getFileOriginator() + "skipped. reason : Does not req neg card data");
					continue;
				}
				
				CSFMemberServiceDTO csfMemberServiceDTO = new CSFMemberServiceDTO();
				csfMemberServiceDTO.setSubService("VISA CARD");
				csfMemberServiceDTO.setBankCode(csoNegcardInfoDTO.getFileOriginator());
				CSFMembersServiceDAO csfMembersServiceDao = new CSFMembersServiceDAO();
				CSFMemberServiceDTO csFMemberServiceDdto = csfMembersServiceDao.retrieve(csfMemberServiceDTO);
				
				if (csFMemberServiceDdto == null){ // i.e originator not active for this service
					log.error("Error loading member service" + csoNegcardInfoDTO.getFileOriginator());
					continue;
				}
				
				CsoOutputControlsDTO csoOutputControlsDTO = new CsoOutputControlsDTO();
				csoOutputControlsDTO.setBankCode(csoNegcardInfoDTO.getFileOriginator());
				csoOutputControlsDTO.setSubService("VISA CARD");
				csoOutputControlsDTO.setLastFileIndicator("Y");
				CsoOutputControlsDAO csoOutputControlsDao = new CsoOutputControlsDAO();
				CsoOutputControlsDTO  csoOutputControlsDto = csoOutputControlsDao.retrieve(csoOutputControlsDTO);
				log.debug("The value of the object is :"+csoOutputControlsDto);
				if(csoOutputControlsDto != null){
				log.debug("The value of the object is :"+csoOutputControlsDto);
				NegativeFile negRec = new NegativeFile();
				negRec.setFileNameDescription(csoOutputControlsDto.getFilenameDescription());
				negRec.setFileNamePrefix(csoOutputControlsDto.getFilenamePrefix());
				negRec.setDistributionCode(csoOutputControlsDto.getDistributionCode());
					
				int totNegRecs = (int)(csoOutputControlsDto.getNegCardCount() + (csoOutputControlsDto.getNegCardCount()/1000));
				negRec.setTotalNegativeRecord(totNegRecs);
					
				negRec.setMaxTransationSizeInFile(Integer.parseInt(csFMemberServiceDdto.getMaxSizeTransFile()));
//				negRec.setMaxTransationSizeInFile(7);   // for testing purposes
					
				String groupingKey =  csoOutputControlsDto.getFilenameDescription() + csoOutputControlsDto.getFilenamePrefix() + 
						csoOutputControlsDto.getDistributionCode() + csFMemberServiceDdto.getMaxSizeTransFile();
					
				if (negativeRecordGroup.containsKey(groupingKey)){
					NegativeFile  savedRec = negativeRecordGroup.get(groupingKey);
						
					int tot = negRec.getTotalNegativeRecord() + savedRec.getTotalNegativeRecord();
					savedRec.setTotalNegativeRecord(tot);
				}else{
					negativeRecordGroup.put(groupingKey, negRec);
				}
			  }
				
			}
			
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				throw new Exception("Error in getMaxNegCardFileName. cause " + e.getMessage() ,e);
			}
    	 
    	 return negativeRecordGroup;
     }
    	 //this creates a new file for negative card transactions
     
     public void assignNegCardFileTrxnToFile(Map<String , NegativeFile> maxNegCardFileNamesGroup) throws Exception{
    	 try{
	    	 for(NegativeFile negRecord : maxNegCardFileNamesGroup.values()){
	    		 
	    		 int negRecsLeft = negRecord.getTotalNegativeRecord();
	    		 String fileName = negRecord.getFileNameDescription();
	    				 
	    		 while (negRecsLeft != 0){  // exit when negRecsLeft = 0
	    			 CsoOutputControlsDAO csoOutputControlsDao = new CsoOutputControlsDAO();
		    		 CsoOutputControlsDTO csoOutputControlsDTO = new CsoOutputControlsDTO();		    		
		    		 csoOutputControlsDTO.setFilenameDescription(fileName);
		    		 CsoOutputControlsDTO csoOutputControlsdto = csoOutputControlsDao.retrieve(csoOutputControlsDTO);
		    		 if(csoOutputControlsdto != null){
		    			 csoOutputControlsdto.setLastFileIndicator("N");
		    			 csoOutputControlsDao.update(csoOutputControlsdto);
		    		 }
		    		 
		    		 String newFile = new FileNameGenerator().generateFile(negRecord.getFileNamePrefix(), negRecord.getDistributionCode());
		    		 
		    		 int fileNegRecs = 0;
		    		 
		    		 if (negRecsLeft <= (negRecord.getMaxTransationSizeInFile() -  (int)(negRecord.getMaxTransationSizeInFile()/1000))){ // -10
		    			 fileNegRecs = negRecsLeft;
		    			 negRecsLeft = 0;
		    		 }else{
		    			 fileNegRecs = negRecord.getMaxTransationSizeInFile() -(int)(negRecord.getMaxTransationSizeInFile()/1000); // -10
		    			 negRecsLeft = negRecsLeft - negRecord.getMaxTransationSizeInFile();
		    		 }
		    			
		    		 //Add 4 for 01,90,92 and 99 records...
		    		 int totalRecs = fileNegRecs + (int)(fileNegRecs/1000) + 4;
		    		 
		    		 csoOutputControlsDTO = new CsoOutputControlsDTO();
		    		 csoOutputControlsDTO.setFilenameDescription(negRecord.getFileNameDescription());
		    		 CsoOutputControlsDAO csoOutputControlsDaoRetrieve = new CsoOutputControlsDAO();
		    		 CsoOutputControlsDTO  csoOutputControlsDto= csoOutputControlsDaoRetrieve.retrieve(csoOutputControlsDTO);
		    		 
		    		 CsoOutputControlsDTO newCsoOutputControlEntry =  new CsoOutputControlsDTO();
		    		 newCsoOutputControlEntry.setBankCode(csoOutputControlsDto.getBankCode());
		    		 newCsoOutputControlEntry.setService(csoOutputControlsDto.getService());
		    		 newCsoOutputControlEntry.setSubService(csoOutputControlsDto.getSubService());
		    		 newCsoOutputControlEntry.setFilenamePrefix(csoOutputControlsDto.getFilenamePrefix());
		    		 newCsoOutputControlEntry.setDistributionCode(csoOutputControlsDto.getDistributionCode());
		    		 newCsoOutputControlEntry.setSeqNumber(newFile.substring(4 , 7));
		    		 newCsoOutputControlEntry.setStatusCode("O");
		    		 newCsoOutputControlEntry.setFilenameDescription(newFile);
		    		 newCsoOutputControlEntry.setTransmissionDate(csoOutputControlsDto.getTransmissionDate());
		    		 newCsoOutputControlEntry.setLastFileIndicator("Y");
		    		 newCsoOutputControlEntry.setNegCardCount(fileNegRecs);
		    		 newCsoOutputControlEntry.setRecordCount(totalRecs);
//		    		 newCsoOutputControlEntry.setOriginatingMember(csoOutputControlsDTO.getOriginatingMember());
//		    		 newCsoOutputControlEntry.setOriginatingBankId(csoOutputControlsDTO.getOriginatingBankId());
		    		 newCsoOutputControlEntry.setFullFileInd(Status.D.getSymbol());
		    		 CsoOutputControlsDAO csoOutputControlsDaoCreate = new CsoOutputControlsDAO();
		    		 csoOutputControlsDaoCreate.create(newCsoOutputControlEntry);
		    		 
		    		 fileName = newFile;
		    	 }
	    	 }
	    	
    	 }catch(Exception e){
    		 throw new Exception("Error in createNewMaxNegCardFileName. cause " + e.getMessage() ,e);
    	 }
     }
 
     public void writeNegativeCardInfoOut(String fileOriginator) throws Exception{
    	 
    	 BufferedReader br = null;
    	 BufferedWriter bw = null;
    	 
    	 try{
    		 
    		 //get the all the files for this originator that have been marked to receive negative card details
	    	 CsoOutputControlsDTO csoOutputControlsDTO = new CsoOutputControlsDTO();
	    	 csoOutputControlsDTO.setBankCode(Integer.parseInt(fileOriginator));
	    	 csoOutputControlsDTO.setStatusCode("O");
	    	 List<CsoOutputControlsDTO>  negativeCardOutCsoOutputControls = new CsoOutputControlsDAO().retrieveNegativeCardFiles(csoOutputControlsDTO);
    	     Collections.sort(negativeCardOutCsoOutputControls , new CsoOutputControlsBankCodeSorter());
    	    
	    	 //get negative card info for the one originator provided
	    	 CsoNegcardInfoDTO csoNegcardInfoDTO = new CsoNegcardInfoDTO();
	    	 csoNegcardInfoDTO.setFileOriginator(Integer.parseInt(fileOriginator));
	    	 csoNegcardInfoDTO.setOutputDate(BsvTableLookup.getInstance().getProcessDate());
	    	 CsoNegcardInfoDAO csoNegcardInfoDAORetrieve = new CsoNegcardInfoDAO();
	    	 List<CsoNegcardInfoDTO> csoNegcardInfoDTOs = csoNegcardInfoDAORetrieve.retrieveRelated(csoNegcardInfoDTO);
	    	 
	    	 if (csoNegcardInfoDTOs == null){
	    		 log.warn("No negative card info found for originator " + fileOriginator);
	    		 return;
	    	 }
	    		 
	    	 //streams for input file
	    	 File inputFile =  null;
	    	 
	    	 //streams for output file
			 File outputFile = null;
			 
			 String fileName = "";
			 int outputFileLineCount = 0;
			 int inputFileLineCount = 0;
			 CsoNegcardInfoDTO inputFileNegCardInfoDto = null;
			 int lastBankCode = 0;
			 
	    	 for(CsoOutputControlsDTO outFileCsoOutputControl : negativeCardOutCsoOutputControls){
	    		
	    		 String outputFileName = outFileCsoOutputControl.getFilenameDescription();
    			 lastBankCode = outFileCsoOutputControl.getBankCode();
    			 
	    		// if the file is not already opened for reading, then it must be opened
	    		if (br == null){
	    				
	    			inputFileNegCardInfoDto = getNextNegativeCardInfoData(csoNegcardInfoDTOs, outFileCsoOutputControl.getBankCode());
	    			
	    			if (inputFileNegCardInfoDto == null){
	    				log.error("No NegCardFileInfo loaded for originator " + outFileCsoOutputControl.getBankCode());
	    				continue;
	    			}
			    	fileName = "CNEGFILE." + StringUtil.rightJustify(String.valueOf(inputFileNegCardInfoDto.getFileOriginator()), StringUtil.ZERO_STRING, 4);
		    		inputFile = new File(BsvTableLookup.getInstance().getSendDir() + File.separator + fileName);
			        br = new BufferedReader(new FileReader(inputFile));
			
	    		}
	    		
	    		// if no output file has been opened for writing to it, then open it and write a header
	    		if (bw == null){
		    		 outputFile = new File(BsvTableLookup.getInstance().getSendDir() + File.separator + outputFileName);
	    			 bw = new BufferedWriter(new FileWriter(outputFile));
	    			 
	    			 //write header of output file
				     FileAXSHeaderRecordDTO fileHeader = getFileHeader(outputFileName);
				     bw.write(fileHeader.toString());
				     bw.flush();  
	    		}
	    		
	    		//read from input and write into output
	        	while (outputFileLineCount < outFileCsoOutputControl.getNegCardCount()){ // while less than the output file limit
	        			
	        		 String inline  = br.readLine();
	        		 bw.write(inline);
	        		 bw.newLine();
	        		 bw.flush();
	        		 outputFileLineCount ++;
	        		 inputFileLineCount ++ ;
	        		    
	        	     if (inputFileLineCount >= inputFileNegCardInfoDto.getNegCardCount()){ // if we have read all records of input file
	        	    	 inputFileLineCount = 0;  // reset for the next input file to be read
	        	    	 inputFileNegCardInfoDto = getNextNegativeCardInfoData(csoNegcardInfoDTOs, outFileCsoOutputControl.getBankCode());
	        	    	 
	        	    	 if (inputFileNegCardInfoDto == null)
	        	    		 break;
	        	     }
	        	}
	    	   
	    		 //mark the output file as extracted
	    		 outFileCsoOutputControl.setStatusCode("E");
	    		 outFileCsoOutputControl.setFilenameDescription(outFileCsoOutputControl.getFilenameDescription());
	    		 new CsoOutputControlsDAO().update(outFileCsoOutputControl);
	    		 
	    		 outputFileLineCount = 0; //reset it for next output file
	    		 
	    		 //write trailor for this ouput file before closing it
	    		 FileAXSTrailorRecordDTO fileTrailor = getFileTrailor(outputFileName);
			     bw.write(fileTrailor.toString());
			     bw.flush();
	    		 
			     //close the file as we are done writing into it
	    		 if (bw != null){
	    			 bw.close();
	    			 bw = null;
	    		 }
	    	 }
    
    	 }catch(Exception e){
    		 throw new Exception("Error in writeNegativeCardInfoOut. cause " + e.getMessage() ,e);
    	 }finally{
    		 if (br != null)
    			 br.close();
    		 if (bw != null)
    			 bw.close();
    	 } 
     }
     //remove duplicates from file lines
 	 private List<NegativeCardRecordDTO> getUniqueNegativeCards(List<NegativeCardRecordDTO> negativeCardRecordDtos){
 		
 		List<String> binAccKey = new ArrayList<>();
 		List<NegativeCardRecordDTO> uniqueNegativeCardRecordDtos = new ArrayList<>();
 		
 		for(NegativeCardRecordDTO negativeCardRecordDTO : negativeCardRecordDtos){
 			
 			if (binAccKey.contains(negativeCardRecordDTO.getSourceBin() + negativeCardRecordDTO.getAccountNumber())){
 				//skip
 			}else{
 				uniqueNegativeCardRecordDtos.add(negativeCardRecordDTO);
 				binAccKey.add(negativeCardRecordDTO.getSourceBin() + negativeCardRecordDTO.getAccountNumber());
 			}
 		}
 		
 		return uniqueNegativeCardRecordDtos;
 	}
 	
  
     private class NegativeCardAccNumSorter implements Comparator<NegativeCardRecordDTO>{

		@Override
		public int compare(NegativeCardRecordDTO o1, NegativeCardRecordDTO o2) {
			// TODO Auto-generated method stub
			return o1.getAccountNumber().compareTo(o2.getAccountNumber());
		}
    	 
     }
     
     private class CsoOutputControlsBankCodeSorter implements Comparator<CsoOutputControlsDTO>{

		@Override
		public int compare(CsoOutputControlsDTO o1, CsoOutputControlsDTO o2) {
			// TODO Auto-generated method stub
			return o1.getBankCode() - o1.getBankCode();
		}
    	 
     }
     
     private List<CsoNegcardInfoDTO> getNegativeCardInfoForOriginator(List<CsoNegcardInfoDTO> csoNegcardInfoDTOs , int originator){
    	 
    	 
    	 List<CsoNegcardInfoDTO> csoNegativeCardInfoDtosForOrigin = new ArrayList<>();
    	 
    	 for(CsoNegcardInfoDTO negCardInfo : csoNegcardInfoDTOs){
    		 if (negCardInfo.getFileOriginator() == originator){
    			 csoNegativeCardInfoDtosForOrigin.add(negCardInfo);
    		 }
    	 }
    	 
    	 return csoNegativeCardInfoDtosForOrigin;
     }
     
     private CsoNegcardInfoDTO getNextNegativeCardInfoData(List<CsoNegcardInfoDTO> csoNegcardInfoDTOs , int originator){
    	 
    	 if (csoNegcardInfoDTOs == null || csoNegcardInfoDTOs.size() == 0)
    		 return null;
    	 
    	 CsoNegcardInfoDTO fileRead = csoNegcardInfoDTOs.remove(0);
    	 return fileRead;
     }
     
     private FileAXSHeaderRecordDTO getFileHeader(String fileName){
    	 
    	 FileAXSHeaderRecordDTO header = new FileAXSHeaderRecordDTO();
    	 header.setRecordId(Constants.AXS_HEADER_RECID);
    	 header.setOutputDate(BsvTableLookup.getInstance().getNextOutputProcessDate());
    	 header.setServiceType(BsvTableLookup.getInstance().getSystemService());
    	 
    	 CsfDeliveryServicesDTO delServ = BsvTableLookup.getInstance().getCsfDeliveryServices().get(fileName.substring(0 , 2));
    	 header.setSubServiceType(delServ.getSubService());
    	 
    	 String memberTapeId = fileName.substring(2, 4);
    	 header.setBankMemberNumber( BsvTableLookup.getInstance().getCsfMembersByTapeId().get(memberTapeId).getMemberNo());
    	 
    	 header.setOriginator(Constants.ORIGINATOR);
    	 header.setFileName(fileName);
    	 header.setFileNumber(fileName.substring(4 , 7));
    	 
    	 header.setDataType(Constants.FILE_DATA_TYPE);
    	 header.setDataDirection(StringUtil.leftJustify(Constants.OUT_DATA_DIRECTION, StringUtil.SPACE_STRING, 3));
    	 header.setSettlementDate(BsvTableLookup.getInstance().getNextOutputProcessDate());
    	 header.setTestLiveIndicator(BsvTableLookup.getInstance().getSystemStatus());
    	 header.setRecordLength(Constants.RECORD_SIZE);
    	 header.setFiller(StringUtil.rightJustify("", StringUtil.SPACE_STRING , 101 ));

    	 return header;
     }
     
     private  FileAXSTrailorRecordDTO getFileTrailor(String fileName){
    	 
    	 FileAXSTrailorRecordDTO fileTrailor = new FileAXSTrailorRecordDTO();
    	 
    	 fileTrailor.setRecordId(Constants.AXS_TRAILOR_RECID);
    	 fileTrailor.setOutputDate(BsvTableLookup.getInstance().getNextOutputProcessDate());
    	 fileTrailor.setServiceType(BsvTableLookup.getInstance().getSystemService());
    	 
    	 
    	 CsfDeliveryServicesDTO delServ = BsvTableLookup.getInstance().getCsfDeliveryServices().get(fileName.substring(0 , 2));
    	 fileTrailor.setSubServiceType(delServ.getSubService());
    	 
    	 String memberTapeId = fileName.substring(2, 4);
    	 fileTrailor.setBankMemberNumber(BsvTableLookup.getInstance().getCsfMembersByTapeId().get(memberTapeId).getMemberNo());
    	 
    	 fileTrailor.setNumberOfRecords(StringUtil.rightJustify(String.valueOf("0") ,StringUtil.ZERO_STRING,6));
    	 fileTrailor.setSourceIdentifier(fileTrailor.getBankMemberNumber());
    	 fileTrailor.setEncryptedWorkingKey(StringUtil.rightJustify("", StringUtil.SPACE_STRING , 16 ));
    	 fileTrailor.setMacOfHashTotal(StringUtil.rightJustify("", StringUtil.SPACE_STRING , 16));
    	 
    	 fileTrailor.setHashtotalOfAccountNumbers(StringUtil.rightJustify(String.valueOf("0") ,StringUtil.ZERO_STRING,12));
    	 
    	 fileTrailor.setFiller(StringUtil.rightJustify("", StringUtil.SPACE_STRING , 82 ));
    	 
    	 return fileTrailor;
     }
     
     public void fixLastFileIndInOutControls(){
    	 
    	 try{
	    	 CsoOutputControlsDAO csoOutputControlsDAO = new CsoOutputControlsDAO();
	    	 //csoOutputControlsDAO.fixCsoOutputControls();///TODO  //TODO    //TODO
	    	 
    	 }catch(Exception e){
    		 log.error("Error with fixLastFileIndInOutControls. cause " + e.getMessage() , e);
    	 }
    	 
     }
    class NegativeFile{
    	 
    	 private String fileNameDescription;
    	 private String fileNamePrefix;
    	 private String distributionCode;
    	 private int maxTransationSizeInFile;
    	 private int totalNegativeRecord;
		public String getFileNameDescription() {
			return fileNameDescription;
		}
		public void setFileNameDescription(String fileNameDescription) {
			this.fileNameDescription = fileNameDescription;
		}
		public String getFileNamePrefix() {
			return fileNamePrefix;
		}
		public void setFileNamePrefix(String fileNamePrefix) {
			this.fileNamePrefix = fileNamePrefix;
		}
		public String getDistributionCode() {
			return distributionCode;
		}
		public void setDistributionCode(String distributionCode) {
			this.distributionCode = distributionCode;
		}
		public int getMaxTransationSizeInFile() {
			return maxTransationSizeInFile;
		}
		public void setMaxTransationSizeInFile(int maxTransationSizeInFile) {
			this.maxTransationSizeInFile = maxTransationSizeInFile;
		}
		public int getTotalNegativeRecord() {
			return totalNegativeRecord;
		}
		public void setTotalNegativeRecord(int totalNegativeRecord) {
			this.totalNegativeRecord = totalNegativeRecord;
		}
    	 
     }
 
}
