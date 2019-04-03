package com.bsva.dcms.commons.fileextract;

import org.apache.log4j.Logger;

import com.bsva.dmcs.controller.AbstractProcess;

public class FileExtractProcess extends AbstractProcess {

    private Logger log = Logger.getLogger(FileExtractProcess.class);

    @Override
    public void init() {
        
    }

    public void process() {
        // TODO Auto-generated method stub

        try {
           // log.info("#### EXTRACT STARTED #### ");

        	  FileExtracts fileExtracts = new FileExtracts();
        	  fileExtracts.processFiles();
        		
            //log.info(" #### EXTRACT DONE #### ");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
