package com.bsva.dcms.commons.fileextract;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bsva.dcms.commons.dao.CsoOutputControlsDAO;
import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
import com.bsva.dcms.commons.dto.CsoOutputControlsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;

public class FileExtracts {

    private static Logger log = Logger.getLogger(FileExtracts.class);
    private List<CsoInputFileControlsDTO> masterCardCsoInputFileControlsDTOList = new ArrayList<>();

    public FileExtracts(){
    	
    }
    // this will process files awaiting extracts
    public void processFiles() throws Exception {
         execute();	
	     executeMasterCard();
		

    }

    public void execute() {

        try {
              // VisaFileExtracts visaFileExtracts = new VisaFileExtracts();
              // visaFileExtracts.buildVisa();
               
               //New version of FileExtract
        	  GenerateExtractedOutputFiles output = new GenerateExtractedOutputFiles();
        	  output.writeVisaFile();
                
        } catch (Exception e) {
            log.error("Error in execute() " + e.getMessage());
        }
    }

    public void executeMasterCard() throws Exception {
        //MasterCardFileExtracts masterCardFileExtracts = new MasterCardFileExtracts();
       // masterCardFileExtracts.buildMasterCard(masterCardCsoInputFileControlsDTOList);
    }
    
  
}
