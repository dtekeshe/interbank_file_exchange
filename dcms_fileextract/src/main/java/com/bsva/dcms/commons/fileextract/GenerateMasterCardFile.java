package com.bsva.dcms.commons.fileextract;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.bsva.dao.v02.CsoTransactionUpdateDAO;
import com.bsva.dao.v02.OutputControlExtractUpdateDAO;
import com.bsva.dao.v02.OutputFileReaderDAO;
import com.bsva.dao.v02.fileextract.PaymenMCARDPDSDAO;
import com.bsva.dao.v02.fileextract.PaymentInstructionUpdateDAO;
import com.bsva.dao.v02.fileextract.PaymentIstructionVISADAO;
import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
import com.bsva.dcms.commons.dto.file.FileAXSHeaderRecordDTO;
import com.bsva.dcms.commons.dto.file.FileAXSTrailorRecordDTO;
import com.bsva.dcms.commons.dto.file.FileEOS98RecordDTO;
import com.bsva.dcms.commons.enums.Status;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.util.Constants;
import com.bsva.dcms.commons.util.StringUtil;
import com.bsva.dcms.commons.util.Utils;
import com.bsva.dto.FileDetailEntityDTO;
import com.bsva.dto.FileEntityPDSDTO;
import com.bsva.dto.OutputFileEntityDTO;

public class GenerateMasterCardFile {

	
	 private BufferedWriter bw;
	 private FileWriter fwr;
	 private String fileRef = null;
	 private static Logger log = Logger.getLogger(GenerateExtractedOutputFiles.class);
	 private FileAXSHeaderRecordDTO header;
	 private FileEOS98RecordDTO footer98Record;
	 private FileAXSTrailorRecordDTO footer99Record;
	 private static String logPGM = "EXTRACT";
	 private static final String PROCESSNAME = "EXTRACT"
;	 private long numberOfFiles = 0l;
	 
	 public void writemastercardFile(OutputFileEntityDTO outputFileEntity){
	
    try {
    	Utils.logSpolog("##### Extract Started  #####",PROCESSNAME);
        String pathName = BsvTableLookup.getInstance().getSendDir();
     
        long now = System.currentTimeMillis();
       
 			  numberOfFiles++;
 			 log.debug("In file Extract  process took : " + ((System.currentTimeMillis() - now) / 1000) + "seconds 0000000000000000000000000000000000000000000000000000");
			  try {
				// check that the sub service is active before loading the file
				// 1. first process the file								
 			   fwr = new FileWriter(pathName + File.separator + outputFileEntity.getFileNameDescription());
 			  FileEntityPDSDTO entityPDSDTO1 = new PaymenMCARDPDSDAO().getFileDetailsFor(outputFileEntity.getFileNameDescription(),"42000");
 			  if(entityPDSDTO1 != null){
	 			  System.out.println(""+entityPDSDTO1.getSystemSeqNumber());
	 			  System.out.println(""+ entityPDSDTO1.getPdsLength());
	 			  System.out.println(""+entityPDSDTO1.getPdsNumber());
	 			  System.out.println(""+entityPDSDTO1.getSystemSeqNumber());
 			  }
 			  List<FileDetailEntityDTO> paymentList =  new PaymentIstructionVISADAO().getFileDetailsFor(outputFileEntity.getFileNameDescription(),outputFileEntity.getSubService());
 			  if(!paymentList.isEmpty() && paymentList.size() >0 ){
 				
 			  CsoInputFileControlsDTO inputDto = new CsoInputFileControlsDTO();
 			  inputDto.setSystemSeqNumber(Long.valueOf(paymentList.get(0).getCardRefNumber()));
 			  CsoInputFileControlsDAO inputDao = new CsoInputFileControlsDAO();
	 			 CsoInputFileControlsDTO inputDtoResult = inputDao.retrieve(inputDto);
	 			 if(inputDtoResult != null){
	 				//header01
	 	             header = createAXSHeaderRecord(outputFileEntity);
	 	             footer98Record = createEOS98Record(outputFileEntity,numberOfFiles);
	 	             footer99Record = createEOF99Record(outputFileEntity);
	 	            inputDtoResult.setProcessStatus("C");
	 	            new CsoInputFileControlsDAO().update(inputDtoResult);
	 	           Utils.logSpolog("Updated Filename : "+outputFileEntity.getFileNameDescription()+" On InputFilesContols to C status",PROCESSNAME);
	 			 }
 				 bw = new BufferedWriter(fwr);
 				 bw.write(header.toString());
 				 bw.newLine();
	 			   for (FileDetailEntityDTO string : paymentList) {
	 				    // FileEntityPDSDTO entityPDSDTO = (FileEntityPDSDTO) new PaymenMCARDPDSDAO().getFileDetailsFor(outputFileEntity.getFileNameDescription(), string.getCardRefNumber());
	 				     //bw.write(entityPDSDTO.getSystemSeqNumber());
		 				 bw.write(string.getCardTransaction());
		 				 bw.newLine();
	 			   }
	 			   	 bw.flush();
	 	             if(outputFileEntity.getLasteFileIndicator().equals("Y")){
	 	            	bw.write(footer98Record.toString());
	 	            	bw.newLine();
	 	            	Utils.logSpolog("Last File of the day sent Out to Send Folder",PROCESSNAME);
	 	             }
	 	             bw.write(footer99Record.toString());
	 	             bw.flush();
	 	             log.debug("Before  Extract Update");
	 	             new OutputControlExtractUpdateDAO().updateDeliveryFile(outputFileEntity.getFileNameDescription(), "C", "C");
	 	            
	 	             Utils.logSpolog("Updated Filename : "+outputFileEntity.getFileNameDescription() +" On CsoOutputControl to C Status",PROCESSNAME);
	 	             boolean result =  new PaymentInstructionUpdateDAO().updateDeliveryFile(outputFileEntity.getFileNameDescription(), "C", outputFileEntity.getSubService());
	 	             
	 	             log.debug("After Extract  process took : " + ((System.currentTimeMillis() - now) / 1000) + "seconds 0000000000000000000000000000000000000000000000000000");
	 	            if(result){
	 	            	Utils.logSpolog("Updated Filename : "+outputFileEntity.getFileNameDescription() +" On PaymentInstruction to C Status",PROCESSNAME);
	 	            }
	 	             boolean tranResult =  new CsoTransactionUpdateDAO().updateDeliveryFile(outputFileEntity.getFileNameDescription(), "C");
	 	             if(tranResult){
	 	            	Utils.logSpolog("Updated Filename : "+outputFileEntity.getFileNameDescription() +" On CsoTransaction to C Status",PROCESSNAME);
	 	             }
	 	             int origin = Integer.valueOf(outputFileEntity.getOriginatingBank());
	 	             	Utils.logDelDelivery(outputFileEntity.getFileNameDescription(), "O",origin, Status.Y.getSymbol());
	 	             	Utils.logSpolog("Logged Filename : "+outputFileEntity.getFileNameDescription() +" to Del_Delivery table",PROCESSNAME);
	 	     
 			  }
 			    if(outputFileEntity.getRecordCount().equals("2")){
 			    	 header = createAXSHeaderRecord(outputFileEntity);
	 	             footer98Record = createEOS98Record(outputFileEntity,numberOfFiles);
	 	             footer99Record = createEOF99Record(outputFileEntity);
	 				  bw = new BufferedWriter(fwr);
	 				  bw.write(header.toString());
	 				  bw.newLine();
	 				  bw.write(footer98Record.toString());
	 				  bw.newLine();
	 				  bw.write(footer99Record.toString());
	 				  bw.flush();
	 				 new OutputControlExtractUpdateDAO().updateDeliveryFile(outputFileEntity.getFileNameDescription(), "C", "C");
	 	             Utils.logSpolog("Updated Filename : "+outputFileEntity.getFileNameDescription() +" On CsoOutputControl to C Status",PROCESSNAME);
	 				 Utils.logSpolog(" Extract Done for FileName : "+outputFileEntity.getFileNameDescription(),PROCESSNAME);
	 				 int origin = Integer.valueOf(outputFileEntity.getOriginatingBank());
	 	             Utils.logDelDelivery(outputFileEntity.getFileNameDescription(), "O",origin, Status.Y.getSymbol());
	 	             Utils.logSpolog("Logged Filename : "+outputFileEntity.getFileNameDescription() +" to Del_Delivery table",PROCESSNAME);
	 	            long donelog = System.currentTimeMillis();
	 	            Utils.logSpolog("Extracted "+outputFileEntity.getFileNameDescription() +" took : "+ (now - donelog)/1000+"seconds",PROCESSNAME);
				}
 			   
 			   Utils.logSpolog("### Extract Done for Filename : "+outputFileEntity.getFileNameDescription() +" ####",PROCESSNAME);
 			   
 		    
 		    
 		   
        long done = System.currentTimeMillis();
         log.debug("Extracted "+outputFileEntity.getFileNameDescription() +" took : "+ (now - done)/1000+"seconds");
        
        
			  
    } catch (Exception e) {
        log.error("Error in write File : " + e);
        log.debug("VISA ERROR LOG ... " + e.getMessage());
    }
    finally {

		try {

			if (bw != null)
				bw.close();

			if (fwr != null)
				fwr.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
      
    }
    }catch (Exception e) {
        log.error("Error in write File : " + e);
        log.debug("VISA ERROR LOG ... " + e.getMessage());
    }
  }
	 
	// createAXSHeaderRecord
	    public FileAXSHeaderRecordDTO createAXSHeaderRecord(OutputFileEntityDTO outputFileEntity) {

	        FileAXSHeaderRecordDTO visaAXSHeaderRecordDto = new FileAXSHeaderRecordDTO();

	        try {

	            String recordID = Constants.AXS_HEADER_RECID;
	            visaAXSHeaderRecordDto.setRecordId(StringUtil.leftJustify(recordID, StringUtil.SPACE_STRING, 2));
	            String outputDate = BsvTableLookup.getInstance().getProcessDate();
	            visaAXSHeaderRecordDto.setOutputDate(StringUtil.leftJustify(outputDate, StringUtil.SPACE_STRING, 8));

	            String serviceType = BsvTableLookup.getInstance().getSystemService();
	            visaAXSHeaderRecordDto.setServiceType(StringUtil.leftJustify(serviceType, StringUtil.SPACE_STRING, 4));

	            String memberSubService = outputFileEntity.getSubService();
	            visaAXSHeaderRecordDto.setSubServiceType(StringUtil.leftJustify(memberSubService, StringUtil.SPACE_STRING, 10));

	            visaAXSHeaderRecordDto.setBankMemberNumber(padLeftString(String.valueOf(outputFileEntity.getBankCode()), 4));
	          
	            String originator = Constants.ORIGINATOR;
	            visaAXSHeaderRecordDto.setOriginator(StringUtil.leftJustify(originator, StringUtil.SPACE_STRING, 4));

	            if (outputFileEntity.getSubService().equals("MASTERCARD")) {
	                String fileName = outputFileEntity.getFileNameDescription();
	                visaAXSHeaderRecordDto.setFileName(StringUtil.leftJustify(fileName, StringUtil.SPACE_STRING, 8));
	            }
	            if ("VISA CARD".equals(outputFileEntity.getSubService()) || "DINERS".equals(outputFileEntity.getSubService())|| "AMEX".equals(outputFileEntity.getSubService()) || "FLEET".equals(outputFileEntity.getSubService())) {
	            	//fileDto = filedto;
	            	String fileName = outputFileEntity.getFileNameDescription();
	                visaAXSHeaderRecordDto.setFileName(StringUtil.leftJustify(fileName, StringUtil.SPACE_STRING, 8));
	            }

	            //getting the number of files for the day
	             String fileNumber = outputFileEntity.getFileNameDescription();
	             visaAXSHeaderRecordDto.setFileNumber(StringUtil.leftJustify(fileNumber.substring(3, 7),StringUtil.SPACE_STRING, 4));
	             
	            String dataType = Constants.FILE_DATA_TYPE;
	            visaAXSHeaderRecordDto.setDataType(StringUtil.leftJustify(dataType, StringUtil.SPACE_STRING, 4));

	            String dataDirection = Constants.OUT_DATA_DIRECTION;
	            visaAXSHeaderRecordDto.setDataDirection(StringUtil.leftJustify(dataDirection, StringUtil.SPACE_STRING, 3));

	            String settlementDate = BsvTableLookup.getInstance().getProcessDate();
	            visaAXSHeaderRecordDto.setSettlementDate(StringUtil.leftJustify(settlementDate, StringUtil.SPACE_STRING, 8));
	          
	            String liveIndicator = BsvTableLookup.getInstance().getSystemStatus();
	            visaAXSHeaderRecordDto.setTestLiveIndicator(StringUtil.leftJustify(liveIndicator, StringUtil.SPACE_STRING, 4));

	            String recordSize = Constants.RECORD_SIZE;
	            visaAXSHeaderRecordDto.setRecordLength(StringUtil.leftJustify(recordSize, StringUtil.SPACE_STRING, 4));

	            String filler = "";
	            visaAXSHeaderRecordDto.setFiller(StringUtil.leftJustify(filler, StringUtil.SPACE_STRING, 101));

	            //csoInputFC.setProcessStatus(Status.C.getSymbol());
	            //new CsoInputFileControlsDAO().update(csoInputFC);

	        } catch (Exception e) {
	            log.error("Error in createAXSHeaderRecord() " + e);
	        }
	        //fileNumberCount ++;
	        return visaAXSHeaderRecordDto;
	    }
	    /*public List<FileTrailer91_92RecordDTO> createTrailor92Record() {

	        FileTrailer91_92RecordDTO fileTrailorDto = new FileTrailer91_92RecordDTO();

	        try {

	            VisaTCRTransactionsDTO dto = new VisaTCRTransactionsDTO();

	            String transactionCode = dto.getTransactionCode();

	            if (transactionCode == Constants.END_OF_BATCH_91 || transactionCode == Constants.END_OF_BATCH_92);
	            fileTrailorDto.setTransactionCode(StringUtil.leftJustify(transactionCode, StringUtil.SPACE_STRING, 2));

	            String tranCCodeQualifier = dto.getTranCodeQualifier();
	            fileTrailorDto.setTranCodeQualifier(StringUtil.leftJustify(tranCCodeQualifier, StringUtil.ZERO_STRING, 1));

	            String tranSeqNo = dto.getTcrNumber();
	            fileTrailorDto.setTcrNumber(StringUtil.leftJustify(tranSeqNo, StringUtil.ZERO_STRING, 1));

	            String bin = "";
	            fileTrailorDto.setBin(StringUtil.leftJustify(bin, StringUtil.ZERO_STRING, 6));

	            String processingDate = BsvTableLookup.getInstance().getProcessDate();
	            fileTrailorDto.setProcessingDate(StringUtil.leftJustify(processingDate, StringUtil.ZERO_STRING, 5));

	            String destAmount = "";
	            fileTrailorDto.setDestinationAmount(StringUtil.leftJustify(destAmount, StringUtil.ZERO_STRING, 15));

	            String moneyTransfer = "";
	            fileTrailorDto.setNoOfMoneyTransfers(StringUtil.leftJustify(moneyTransfer, StringUtil.ZERO_STRING, 12));

	            String batchNumber = "";
	            fileTrailorDto.setBatchNumber(StringUtil.leftJustify(batchNumber, StringUtil.ZERO_STRING, 6));

	            String numberOTCRs = "";
	            fileTrailorDto.setNoOfTCRs(StringUtil.leftJustify(numberOTCRs, StringUtil.ZERO_STRING, 12));

	            String reserved1 = "";
	            fileTrailorDto.setReserved1(StringUtil.leftJustify(reserved1, StringUtil.SPACE_STRING, 6));

	            String centreBatchInd = "";
	            fileTrailorDto.setCentreBatchIndicator(StringUtil.leftJustify(centreBatchInd, StringUtil.SPACE_STRING, 8));

	            String noOfTransactions = "";
	            fileTrailorDto.setNoOfTransactions(StringUtil.leftJustify(noOfTransactions, StringUtil.SPACE_STRING, 9));

	            String reserved2 = "";
	            fileTrailorDto.setReserved2(StringUtil.leftJustify(reserved2, StringUtil.SPACE_STRING, 18));

	            String sourceAmount = "";
	            fileTrailorDto.setSourceAmount(StringUtil.leftJustify(sourceAmount, StringUtil.ZERO_STRING, 13));

	            String filler = "";
	            fileTrailorDto.setFiller(StringUtil.leftJustify(filler, StringUtil.SPACE_STRING, 52));

	            // this.visaFileDto.setFileCtrlTrailorDtoList(fileTrailorDto);
	           // fileTrailer91_92RecordList.add(fileTrailorDto);

	        } catch (Exception e) {
	            log.error("Error in createTrailor92Record() " + e.getMessage());
	        }
	       // return fileTrailer91_92RecordList;

	    }*/

	    // createEOS98Record
	    public FileEOS98RecordDTO createEOS98Record(OutputFileEntityDTO outputFileEntity,long numberOfFiles) {
	        FileEOS98RecordDTO fileEOS98RecordDto = new FileEOS98RecordDTO();

	        try {

	            String recordID = Constants.EOS_98_RECID;
	            fileEOS98RecordDto.setRecordId(recordID);
	            String outputDate = BsvTableLookup.getInstance().getProcessDate();
	            fileEOS98RecordDto.setOutputDate(outputDate);

	            //String serviceType = BsvTableLookup.getInstance().getSystemService();
	            fileEOS98RecordDto.setServiceType(outputFileEntity.getService());

	            String memberSubService = outputFileEntity.getSubService();
	            fileEOS98RecordDto.setSubServiceType(memberSubService);

	            //int originBankMember = csoInputFC.getOriginatingMember();
	            String sTest = "00";
	            fileEOS98RecordDto.setBankMemberNumber(padLeftString(sTest, 4));

	            String noOfTransFiles =  String.valueOf(numberOfFiles);
	            fileEOS98RecordDto.setTransamissionFileCount(padLeftString(noOfTransFiles,4));

	            String noOfCredits = "";
	            fileEOS98RecordDto.setCreditRecordCount(noOfCredits);

	            String noOfDebitRecords = "";
	            fileEOS98RecordDto.setDebitRecordCount(noOfDebitRecords);

	            String valueCreditRecs = "";
	            fileEOS98RecordDto.setValueOfCreditRecords(valueCreditRecs);

	            long  valueDebitRecs = Long.valueOf(outputFileEntity.getDrValue());
	            valueDebitRecs += valueDebitRecs;
	            fileEOS98RecordDto.setValueOfDebitRecords(padLeftString(String.valueOf(valueDebitRecs),16));

	           // long hashTotalAccNo = fileDto.getHashTotal();
	            fileEOS98RecordDto.setHashTotalOfAccountNumber("");

	            String filler = "";
	            fileEOS98RecordDto.setFiller(filler);

	            //this.fileDto.setFileEOS98RecordDto(fileEOS98RecordDto);

	        } catch (Exception e) {
	            log.error("Error in createEOS98Record() " + e.getMessage());
	        }
	        return fileEOS98RecordDto;

	    }

	    // createEOF99Record
	    public FileAXSTrailorRecordDTO createEOF99Record(OutputFileEntityDTO outputFileEntity) {

	        FileAXSTrailorRecordDTO fileEOS99RecordDto = new FileAXSTrailorRecordDTO();

	        try {

	            String recordID = Constants.AXS_TRAILOR_RECID;
	            fileEOS99RecordDto.setRecordId(recordID);
	            String outputDate = BsvTableLookup.getInstance().getProcessDate();
	            fileEOS99RecordDto.setOutputDate(outputDate);

	            String serviceType = BsvTableLookup.getInstance().getSystemService();
	            fileEOS99RecordDto.setServiceType(serviceType);

	            String memberSubService = outputFileEntity.getSubService();
	            fileEOS99RecordDto.setSubServiceType(memberSubService);

	            fileEOS99RecordDto.setBankMemberNumber(padLeftString(String.valueOf(outputFileEntity.getBankCode()), 4));

	            String noOfRecords = String.valueOf(outputFileEntity.getRecordCount());
	            String pad = padLeftString(noOfRecords,6);
	            fileEOS99RecordDto.setNumberOfRecords(pad);

	            String sourceID = "";
	            fileEOS99RecordDto.setSourceIdentifier(sourceID);

	            String encryptedWorkingKey = "";
	            fileEOS99RecordDto.setEncryptedWorkingKey(encryptedWorkingKey);

	            String macHashTotal = " ";
	            fileEOS99RecordDto.setMacOfHashTotal(macHashTotal);

	            long hashTotalAccNo = Long.valueOf(outputFileEntity.getHashTotal());
	            fileEOS99RecordDto.setHashtotalOfAccountNumbers(padLeftString(String.valueOf(hashTotalAccNo),16));

	            String filler = "";
	            fileEOS99RecordDto.setFiller(filler);

	            String masterCardRecord = "";

	            /*if (memberSubService.equals("MASTERCARD")) {
	             int bankCode = csoInputFC.getOriginatingMember();
	             int recordWriteStartByte = BsvTableLookup.getInstance().getCsfMasterCardOptions().get(String.valueOf(bankCode)).getRecordWriteStartByte();
	             for (int x = 0; x < recordWriteStartByte; x++) {
	             masterCardRecord += '\0';
	             }
	             }*/
	            //this.fileDto.setFileAxsTrailorRecordDto(fileEOS99RecordDto);

	        } catch (Exception e) {
	            log.error("Error in createEOF99Record() " + e.getMessage());
	        }
	        return fileEOS99RecordDto;
	    }
	    
	    /**
		 * @param s
		 * @param n
		 * @return
		 */
	    public static String padLeftString(String s, int n) {
	 	   return String.format("%0$"+ n +"s", s).replace(' ', '0');
	     }
	    
}
