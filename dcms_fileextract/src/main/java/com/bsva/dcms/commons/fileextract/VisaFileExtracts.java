/*
package com.bsva.dcms.commons.fileextract;

import com.bsva.dcms.commons.dao.CSOPaymentInstructionsVisaDAO;
import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
import com.bsva.dcms.commons.dao.CsoOutputControlsDAO;
import com.bsva.dcms.commons.dao.CsoPaymentInstructionsMcardDAO;
import com.bsva.dcms.commons.dao.CsoScheduleTimesDAO;
import com.bsva.dcms.commons.dao.CsoScheduledProcessesDAO;
import com.bsva.dcms.commons.dao.CsoTransactionsDAO;
import com.bsva.dcms.commons.dto.CSOPaymentInstructionsVisaDTO;
import com.bsva.dcms.commons.dto.CSOTransactionDTO;
import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
import com.bsva.dcms.commons.dto.CsoOutputControlsDTO;
import com.bsva.dcms.commons.dto.CsoPaymentInstructionsMcardDTO;
import com.bsva.dcms.commons.dto.CsoScheduleTimesDTO;
import com.bsva.dcms.commons.dto.CsoScheduledProcessesDTO;
import com.bsva.dcms.commons.dto.file.FileAXSHeaderRecordDTO;
import com.bsva.dcms.commons.dto.file.FileAXSTrailorRecordDTO;
import com.bsva.dcms.commons.dto.file.FileDTO;
import com.bsva.dcms.commons.dto.file.FileEOS98RecordDTO;
import com.bsva.dcms.commons.dto.file.FileTransactionRecordDTO;
import com.bsva.dcms.commons.dto.file.MastercardFileDTO;
import com.bsva.dcms.commons.dto.file.VISATCR0TransactionRecordDTO;
import com.bsva.dcms.commons.dto.file.VISATCR1TransactionRecordDTO;
import com.bsva.dcms.commons.dto.file.VISATCR3TransactionRecordDTO;
import com.bsva.dcms.commons.dto.file.VISATCR5TransactionRecordDTO;
import com.bsva.dcms.commons.dto.file.VISATCR7TransactionRecordDTO;
import com.bsva.dcms.commons.enums.Status;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.util.Constants;
import com.bsva.dcms.commons.util.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;


*//**
 * @author AugustineA
 *
 *//*
public class VisaFileExtracts extends FileExtracter {

    private static String logPGM = "VISAFILEEXTRACT";
    private static Logger log = Logger.getLogger(FileExtracts.class);
    private CsoInputFileControlsDTO csoInputFileControlsDTO;
    private CSOTransactionDTO csoTransaction;
    private MastercardFileDTO mastercardFileDTO;
    private FileDTO fileDto;
    private CSOPaymentInstructionsVisaDTO csoPaymentInstructioVisa;
    private CsoPaymentInstructionsMcardDTO csoPaymentInstructionMcardDTO;
    public List<FileTransactionRecordDTO> fileTransactionRecordDtoList2;
    private List<FileTransactionRecordDTO> fileTransactionRecordDtoList;
    private CsoOutputControlsDTO csoOutputControlsDTO;
    private CsoScheduledProcessesDTO csoScheduledProcessesDTO;
    private List<FileTransactionRecordDTO> tcr00 = new ArrayList<>();
    private List<FileTransactionRecordDTO> tcr01 = new ArrayList<>();
    private List<FileTransactionRecordDTO> tcr03 = new ArrayList<>();
    private List<FileTransactionRecordDTO> tcr05 = new ArrayList<>();
    private List<FileTransactionRecordDTO> tcr07 = new ArrayList<>();
    // private FileTransactionRecordDTO fileTransactionRecordDTO = null;
    private VISATCR0TransactionRecordDTO tcr0 = null;
    private VISATCR1TransactionRecordDTO tcr1 = null;
    private VISATCR3TransactionRecordDTO tcr3 = null;
    private VISATCR5TransactionRecordDTO tcr5 = null;
    private VISATCR7TransactionRecordDTO tcr7 = null;
    private int maxLines = 0;
    private String rec0ID = String.valueOf(Constants.TCR0_RECID);
    private String rec1ID = String.valueOf(Constants.TCR1_RECID);
    private String rec5ID = String.valueOf(Constants.TCR5_RECID);
    private String rec7ID = String.valueOf(Constants.TCR7_RECID);
    private CsoInputFileControlsDTO csoInputFileDTO = new CsoInputFileControlsDTO();
    private CsoInputFileControlsDTO csoInputFileControls = null;
    private String fileRef = null;
    private BufferedWriter bw;
    private FileWriter fwr;
    private static final String EOD_PROCESS_NAME	= "EOD";
    private int trc0Count = 0;

    VisaFileExtracts() {
        this.csoTransaction = new CSOTransactionDTO();
        this.mastercardFileDTO = new MastercardFileDTO();
        this.fileDto = new FileDTO();
        this.csoPaymentInstructioVisa = new CSOPaymentInstructionsVisaDTO();
        this.csoPaymentInstructionMcardDTO = new CsoPaymentInstructionsMcardDTO();
        this.fileTransactionRecordDtoList2 = new ArrayList<>();
        this.fileTransactionRecordDtoList = new ArrayList<>();
        this.csoOutputControlsDTO = new CsoOutputControlsDTO();
        this.csoScheduledProcessesDTO = new CsoScheduledProcessesDTO();
    }

    public static VisaFileExtracts getInstance() {
        return VisaFileExtractsHolder.INSTANCE;
    }

    private static class VisaFileExtractsHolder {

        private static final VisaFileExtracts INSTANCE = new VisaFileExtracts();
    }
    
    private boolean isEndOfDay() throws DAOException {
    	
    	CsoScheduledProcessesDAO csoScheduledProcessesDAO = new CsoScheduledProcessesDAO();
    	CsoScheduledProcessesDTO csoScheduledProcessesDto = new CsoScheduledProcessesDTO();
    	csoScheduledProcessesDto.setProcessName(EOD_PROCESS_NAME);
        List<CsoScheduledProcessesDTO> csoScheduledProcessesDTOList = csoScheduledProcessesDAO.retrieveRelated(csoScheduledProcessesDto);

        for (CsoScheduledProcessesDTO csoScheduledProcessesDTO : csoScheduledProcessesDTOList) {
            String processName = csoScheduledProcessesDTO.getProcessName();
            String activeIndicator = csoScheduledProcessesDTO.getActiveIndicator();

            if (processName.equals(EOD_PROCESS_NAME) && activeIndicator.equals("Y")) {
            	return true;
            }else{
            	return false;
            }
            
         }
		
		return false;
    }

    public FileDTO buildVisa() throws DAOException, SQLException, NumberFormatException, ParseException {
    	
    	Map<String, List<FileTransactionRecordDTO>>  fileMap = new HashMap<>();
    	
    	CsoOutputControlsDTO dto = new CsoOutputControlsDTO();
    	dto.setFullFileInd(isEndOfDay() ? "N" : "F");
    	List<CsoOutputControlsDTO> data = new CsoOutputControlsDAO().retrieveRelated(dto);
    	for (CsoOutputControlsDTO csoOutputControlsDTO : data) {
      		
    		List<FileTransactionRecordDTO> txnList = fileMap.get(csoOutputControlsDTO.getFilenameDescription());
    		if (txnList == null) {
    			txnList = new ArrayList<FileTransactionRecordDTO>();
    			fileMap.put(csoOutputControlsDTO.getFilenameDescription(), txnList);                        
    		}
    		
	        String fileName = "";
	        CsoTransactionsDAO csoTransactionsDAO = new CsoTransactionsDAO();
	        csoTransaction.setOutputFilename(csoOutputControlsDTO.getFilenameDescription());
	        List<CSOTransactionDTO> transactionList = csoTransactionsDAO.retrieveRelated(csoTransaction);
	        if(transactionList.size() > 0){
	        //long processedfileSeqNumber = -1;
	        fileName = csoOutputControlsDTO.getFilenameDescription();
	        fileDto.setBankCode(String.valueOf(csoOutputControlsDTO.getBankCode()));
	        fileDto.setRecordCount(csoOutputControlsDTO.getRecordCount());
	        fileDto.setHashTotal((long)csoOutputControlsDTO.getHashTotal99());
	        fileDto.setFileNumber(String.valueOf(csoOutputControlsDTO.getRecordCount()));
            fileDto.setFileName(fileName);
            fileDto.setLastFileIndicator(csoOutputControlsDTO.getLastFileIndicator());
            csoInputFileDTO.setSystemSeqNumber(transactionList.get(0).getFileSystemSeqNumber());
	        CsoInputFileControlsDAO csoInputFileControlsDAO = new CsoInputFileControlsDAO();
	        csoInputFileControls = csoInputFileControlsDAO.retrieve(csoInputFileDTO);
	        if(csoInputFileControls != null){
            //header01
            FileAXSHeaderRecordDTO header = createAXSHeaderRecord(csoInputFileControls,fileDto);
            fileDto.setFileAXSHeaderRecordDto(header);
	        }else{
	        	continue;
	        }
	        for (CSOTransactionDTO transDto : transactionList) {
	            
	            if (transDto.getOutputFilename() != null && !transDto.getOutputFilename().isEmpty()) {//Assuming list is Ordered && fileSeqNumber != processedfileSeqNumber 
	                //	processedfileSeqNumber = fileSeqNumber;
	                //csoPaymentInstructioVisa.setFileRefNumber(String.valueOf(transDto.getFileSystemSeqNumber()));
	                CSOPaymentInstructionsVisaDAO cSOPaymentInstructionsVisaDAO = new CSOPaymentInstructionsVisaDAO();
	                int seqNum = (int)transDto.getSystemSeqNumber();
	                csoPaymentInstructioVisa.setSystemGenSeqNumber(seqNum);
	                csoPaymentInstructioVisa.setFilenameDescription(transDto.getOutputFilename());
	                List<CSOPaymentInstructionsVisaDTO> csoPaymentVisaList = cSOPaymentInstructionsVisaDAO.retrieveRelated(csoPaymentInstructioVisa);
	
	                if (csoPaymentVisaList != null && csoPaymentVisaList.size() > 0) {
	
	                    for (CSOPaymentInstructionsVisaDTO csoPaymentInstructioVisa : csoPaymentVisaList) {
	
	                        if (csoPaymentInstructioVisa.getFilenameDescription().equals(transDto.getOutputFilename())) {
	
	                            FileTransactionRecordDTO fileTransactionRecordDTO = new FileTransactionRecordDTO();
	                            //if (fileSeqNumber == fileRefNumber){
	
	                            int transactionCodeNumber = csoPaymentInstructioVisa.getTransactionCodeNumber();
	
	                            int rec0ID = Constants.TCR0_RECID;
	                            int rec1ID = Constants.TCR1_RECID;
	                            int rec3ID = Constants.TCR3_RECID;
	                            int rec5ID = Constants.TCR5_RECID;
	                            int rec7ID = Constants.TCR7_RECID;
	
	                            if (transactionCodeNumber == rec0ID) {
	                                tcr0 = new VISATCR0TransactionRecordDTO();
	                                tcr0.setRecord(csoPaymentInstructioVisa.getCardTransaction());
	                                tcr0.setTcrNumber(String.valueOf(transactionCodeNumber));
	                                fileTransactionRecordDTO.setTcr0TransactionRecordDto(tcr0);
	                                fileTransactionRecordDTO.getTcr0TransactionRecordDto().setFileName(transDto.getOutputFilename());
	                                fileTransactionRecordDTO.setFileName(transDto.getOutputFilename());
	                            }
	
	                            if (transactionCodeNumber == rec1ID) {
	                                tcr1 = new VISATCR1TransactionRecordDTO();
	                                tcr1.setRecord(csoPaymentInstructioVisa.getCardTransaction());
	                                tcr1.setTcrNumber(String.valueOf(transactionCodeNumber));
	                                fileTransactionRecordDTO.setTcr1TransactionRecordDto(tcr1);
	                                fileTransactionRecordDTO.getTcr1TransactionRecordDto().setFileName(transDto.getOutputFilename());
	                                fileTransactionRecordDTO.setFileName(transDto.getOutputFilename());
	
	                            }
	                            if (transactionCodeNumber == rec3ID) {
	                                tcr3 = new VISATCR3TransactionRecordDTO();
	                                tcr3.setRecord(csoPaymentInstructioVisa.getCardTransaction());
	                                tcr3.setTcrNumber(String.valueOf(transactionCodeNumber));
	                                fileTransactionRecordDTO.setTcr3TransactionRecordDto(tcr3);
	                                fileTransactionRecordDTO.getTcr3TransactionRecordDto().setFileName(transDto.getOutputFilename());
	                                fileTransactionRecordDTO.setFileName(transDto.getOutputFilename());
	
	                            }
	
	                            if (transactionCodeNumber == rec5ID) {
	                                tcr5 = new VISATCR5TransactionRecordDTO();
	                                tcr5.setRecord(csoPaymentInstructioVisa.getCardTransaction());// + billingFee + billingFeeAmount + billingVat);
	                                tcr5.setTcrNumber(String.valueOf(transactionCodeNumber));
	                                fileTransactionRecordDTO.setTcr5TransactionRecordDto(tcr5);
	                                fileTransactionRecordDTO.getTcr5TransactionRecordDto().setFileName(transDto.getOutputFilename());
	                                fileTransactionRecordDTO.setFileName(transDto.getOutputFilename());
	                            }
	
	                            if (transactionCodeNumber == rec7ID) {
	                                tcr7 = new VISATCR7TransactionRecordDTO();
	                                tcr7.setRecord(csoPaymentInstructioVisa.getCardTransaction());
	                                tcr7.setTcrNumber(String.valueOf(transactionCodeNumber));
	                                fileTransactionRecordDTO.setTcr7TransactionRecordDto(tcr7);
	                                fileTransactionRecordDTO.getTcr7TransactionRecordDto().setFileName(transDto.getOutputFilename());;
	                                fileTransactionRecordDTO.setFileName(transDto.getOutputFilename());
	                            }
	                            // fileTransactionRecordDtoList.add(fileTransactionRecordDTO);
	                            txnList.add(fileTransactionRecordDTO);
	                        }
	                        
	                        csoPaymentInstructioVisa.setProcessStatus(Status.C.getSymbol());
	                        cSOPaymentInstructionsVisaDAO.update(csoPaymentInstructioVisa);
	                    }
	
	                }
	
	            }
	            
	        	}
	
	        }
	        if(fileMap.values() != null){
	            writeToFile(csoInputFileControls, fileMap);
	       	}
		}
    	
        return fileDto;

    }


	private void writeToFile(CsoInputFileControlsDTO csoInputFC, Map<String, List<FileTransactionRecordDTO>> fileMap)throws DAOException {
    	for (String filename : fileMap.keySet()) {
    		
    		List<FileTransactionRecordDTO> file = fileMap.get( filename );
                
    		
             CsoOutputControlsDAO csoOutputControlsdao = new CsoOutputControlsDAO();
             CsoOutputControlsDTO csoOutputControlsdto = new CsoOutputControlsDTO();
             csoOutputControlsdto.setFilenameDescription(filename);
             csoOutputControlsdto.setFullFileInd(isEndOfDay() ? "N" : "F");
             CsoOutputControlsDTO csoOutputControlsDto = csoOutputControlsdao.retrieve(csoOutputControlsdto);
                
             FileAXSHeaderRecordDTO header = createAXSHeaderRecord(csoInputFC,fileDto);
             header.setSubServiceType(csoOutputControlsDto.getSubService());
             fileDto.setFileAXSHeaderRecordDto(header);
    		
             FileEOS98RecordDTO eos98 = createEOS98Record(csoInputFC);
             fileDto.setFileEOS98RecordDto(eos98);
             fileDto.setInternalCounter(file.size()+2);
             //End Of File 99
             FileAXSTrailorRecordDTO eof99 = createEOF99Record(csoInputFC);
             //eof99.setNumberOfRecords(String.valueOf(file.size()));
             fileDto.setFileAxsTrailorRecordDto(eof99);
             //fileDto.getFileAxsTrailorRecordDto().setNumberOfRecords(String.valueOf(csoOutputControlsDto.getRecordCount()));
             //fileDto.getFileAxsTrailorRecordDto().setHashtotalOfAccountNumbers(String.valueOf(csoOutputControlsDto.getHashTotal99()));
             
             fileDto.setFileName(filename);
             fileRef = csoInputFC.getFileRefNumber();
             Utils.logSpolog("Writing "+csoOutputControlsDto.getFilenameDescription()+" File");
             writeVisaFile(file,filename);

             CsoInputFileControlsDTO inputControl = new CsoInputFileControlsDTO();
             CsoInputFileControlsDAO inputFiledao = new CsoInputFileControlsDAO();
             inputControl.setFileRefNumber(csoInputFC.getFileRefNumber());
             CsoInputFileControlsDTO controlData = inputFiledao.retrieve(inputControl);
             if(controlData != null){
            	 controlData.setProcessStatus(Status.C.getSymbol());
            	 inputFiledao.update(controlData);
             }
             Utils.logSpolog("Log extracted file to Del_Delivery");
             Utils.logDelDelivery(filename, "O",file.get(0).getAcquirer(), Status.Y.getSymbol());

             log.info("**Change FullFileIND status to C***");

             if (csoOutputControlsDto != null) {
                 csoOutputControlsDto.setFullFileInd(Status.C.getSymbol());
                 csoOutputControlsDto.setStatusCode(Status.C.getSymbol());
                 new CsoOutputControlsDAO().update(csoOutputControlsDto);
             }
             
             CSOPaymentInstructionsVisaDTO visaDto = new CSOPaymentInstructionsVisaDTO();
             visaDto.setFilenameDescription(filename);
             List<CSOPaymentInstructionsVisaDTO> visaPull = new CSOPaymentInstructionsVisaDAO().retrieveRelated(visaDto);
             for (CSOPaymentInstructionsVisaDTO visaRecordDTO : visaPull) {
            	 visaRecordDTO.setProcessStatus(Status.C.getSymbol());
            	 new CSOPaymentInstructionsVisaDAO().update(visaRecordDTO);
			}
             Utils.logSpolog("Successfully logged extracted Visa with FileName: " + filename + "to DelDelivery");
             long now = System.currentTimeMillis();
             log.debug("After file  Extract Process took : " + ((System.currentTimeMillis() - now) / 1000) + "seconds 0000000000000000000000000000000000000000000000000000");
    		
    	}
	}
    

    public void writeVisaFile(List<FileTransactionRecordDTO> fileTxns,String fileName) {
        try {

            String pathName = BsvTableLookup.getInstance().getSendDir();
            fwr = new FileWriter(pathName + File.separator + fileName);
            bw = new BufferedWriter(fwr);

            bw.write(fileDto.getFileAXSHeaderRecordDto().toString());
            bw.newLine();

            for (FileTransactionRecordDTO fileTransactionRecordDTO : fileTxns) {

                if (fileTransactionRecordDTO.getTcr0TransactionRecordDto() != null) {
                    if (fileTransactionRecordDTO.getTcr0TransactionRecordDto().getFileName().equals(fileName)) {
                        bw.write(fileTransactionRecordDTO.getTcr0TransactionRecordDto().getRecord());
                        bw.newLine();
                    }
                }
                if (fileTransactionRecordDTO.getTcr1TransactionRecordDto() != null) {
                    if (fileTransactionRecordDTO.getTcr1TransactionRecordDto().getFileName().equals(fileName)) {
                        bw.write(fileTransactionRecordDTO.getTcr1TransactionRecordDto().getRecord());
                        bw.newLine();
                    }
                }
                if (fileTransactionRecordDTO.getTcr3TransactionRecordDto() != null) {
                    if (fileTransactionRecordDTO.getTcr3TransactionRecordDto().getFileName().equals(fileName)) {
                        bw.write(fileTransactionRecordDTO.getTcr3TransactionRecordDto().getRecord());
                        bw.newLine();
                    }
                }
                if (fileTransactionRecordDTO.getTcr5TransactionRecordDto() != null) {
                    if (fileTransactionRecordDTO.getTcr5TransactionRecordDto().getFileName().equals(fileName)) {
                        bw.write(fileTransactionRecordDTO.getTcr5TransactionRecordDto().getRecord());
                        bw.newLine();
                    }
                }
                if (fileTransactionRecordDTO.getTcr7TransactionRecordDto() != null) {
                    if (fileTransactionRecordDTO.getTcr7TransactionRecordDto().getFileName().equals(fileName)) {
                        bw.write(fileTransactionRecordDTO.getTcr7TransactionRecordDto().getRecord());
                        bw.newLine();
                    }
                }
            }

            //String eos98 = fileDto.getFileEOS98RecordDto().toString();
            if(fileDto.getLastFileIndicator().equals("Y")){
            bw.write(fileDto.getFileEOS98RecordDto().toString());
            bw.newLine();
            }

            //String eof99 = fileDto.getFileAxsTrailorRecordDto().toString();
            bw.write(fileDto.getFileAxsTrailorRecordDto().toString());
            bw.close();
            Utils.logSpolog("Done Extracting "+fileName+" Files to Send Folder");

            Utils.logSpolog("Logging extracted file "+fileName+"to Delivery");

            Utils.logSpolog("Successfully extracted  FileName: " + csoOutputControlsDTO.getFilenameDescription());

            CsoOutputControlsDTO csoOutputControlsdtos = new CsoOutputControlsDTO();
            csoOutputControlsdtos.setFilenameDescription(fileDto.getFileName());
            CsoOutputControlsDTO csoOutputControl = new CsoOutputControlsDAO().retrieve(csoOutputControlsdtos);

            if (csoOutputControl != null) {
                csoOutputControl.setFullFileInd(Status.C.getSymbol());
                csoOutputControl.setStatusCode(Status.C.getSymbol());
                new CsoOutputControlsDAO().update(csoOutputControl);
            }
            CsoInputFileControlsDTO inputControl = new CsoInputFileControlsDTO();
            CsoInputFileControlsDAO inputFiledao = new CsoInputFileControlsDAO();
            inputControl.setFileRefNumber(fileRef);
            CsoInputFileControlsDTO controlData = inputFiledao.retrieve(inputControl);
            if(controlData != null){
           	 controlData.setProcessStatus(Status.C.getSymbol());
           	 inputFiledao.update(controlData);
            }
            CSOTransactionDTO transDto = new CSOTransactionDTO();
            transDto.setOutputFilename(fileDto.getFileName());
            List<CSOTransactionDTO> transDTO = new CsoTransactionsDAO().retrieveRelated(transDto);
            if(transDTO.size() > 0){
            	for (CSOTransactionDTO csoTransactionDTO : transDTO) {
            		csoTransactionDTO.setProcessStatus("C");
            	 	new CsoTransactionsDAO().update(csoTransactionDTO);
            	}
            }
            
            Utils.logSpolog("Successfully Updated input file controls to Status C ");


        } catch (Exception e) {
            log.error("Error in write File : " + e);
            log.debug("TESTING VISA ERROR LOG ... " + e.getMessage());
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
        
    }
    
}


*/