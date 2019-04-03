package com.bsva.dmcs.fileloadv02;

import com.bsva.dao.reprocess.InputFileControlDAO;
import com.bsva.dao.v02.*;
import com.bsva.dcms.commons.util.Utils;
import com.bsva.dmcs.controller.AbstractProcess;
import com.bsva.dmcs.fileloadv02.dto.FileFooterDto;
import com.bsva.dmcs.fileloadv02.indexer.FileIndexer;
import com.bsva.dmcs.fileloadv02.loaders.FileLoader;
import com.bsva.dmcs.fileloadv02.model.ServiceType;
import com.bsva.dmcs.fileloadv02.util.*;
import com.bsva.dto.ErrorDTO;
import com.bsva.dto.FileHeaderDTO;
import com.bsva.entities.v02.params.CompanyParametersEntity;
import com.bsva.entities.v02.commons.DeliveredFile;
import com.bsva.entities.v02.endofservice.InputFileControlEntity;
import com.bsva.entities.v02.loader.ServiceTypeEntity;
import com.bsva.entities.v02.params.SystemParametersEntity;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.*;

/**
 * Reads delivery table for incoming files
 * Validate structure of a file
 * Parse file header and validate it
 * Parse transactions and validate and index
 * Load the indexed file
 */
public class FileLoadProcess extends AbstractProcess {

    private Logger log = Logger.getLogger(FileLoadProcess.class);

    // Metadata
    private final static String PROCESS_NAME = "LOADER";
    private final static String VERSION = "20";

    private static CompanyParametersEntity companyParametersEntity;

    private static SystemParametersEntity systemParametersEntity;

    // file loader
    private static FileLoader fileLoader;

    // service types
    private static Map<String, ServiceType> serviceTypes;

    private static Map<String, String> paths;

    // delivered files reader
    private static DeliveredFilesReaderDAO deliveredFilesReader;

    // delivered files update
    private static DeliveredFilesUpdateDAO deliveredFilesUpdateDAO;
    
    //private static Map<String,Object> inputFileControlsReloadResultsDAO ;

    public FileLoadProcess() throws UnknownHostException, SQLLoaderNotImplemented {
        spolog("FILE LOADER INITIALISING");
        initFileLoader();
        spolog("FILE LOADER INITIALISED");
    }

    public static void initFileLoader() {

        try {
            // company parameters
            companyParametersEntity = new CompanyParametersDAO().companyParameters();

            // system parameters
            systemParametersEntity = new SystemParametersDAO().systemParameters();

            // directories
            paths = new DirectoryDAO().directories();

            // service type entities
            Map<String, ServiceTypeEntity> serviceTypeEntities
                    = new ServiceTypesDAO().serviceTypes();

            serviceTypes = LoaderUtils.loadServiceTypes(serviceTypeEntities);

            // delivery files reader
            deliveredFilesReader = new DeliveredFilesReaderDAO(); //DeliveredFilesReader(paths.get("RECEIVE_PATH"));
            deliveredFilesUpdateDAO = new DeliveredFilesUpdateDAO();

            // file loader
            fileLoader = LoaderUtils.fileLoaderInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("LOAD 01 FILE LOADER NOT STARTED : " + e.getMessage());
            System.out.println("LOAD 01 WILL RETRY AFTER 15 SECONDS");
            sleep(15L);
            System.out.println("LOAD 01 FILE LOADER STARTING ...");
            initFileLoader();
        }
    }

    public void process() {
        process( false );
    }

    public void process(boolean isReload) {

        try {

            // get delivered files
            List<DeliveredFile> deliveredFilenames = deliveredFilesReader.deliveredFiles();
            if (deliveredFilenames.size() > 0) {
                spolog("FILE LOAD PROCESS STARTED : RELOAD = " + (isReload ? "Y" : "N") );
                log.info("FILE LOAD PROCESS STARTED");
            }

            for (DeliveredFile deliveredFile : deliveredFilenames) {
            	 spolog("FILE LOAD PROCESS STARTED");
                 checkReload(isReload, deliveredFile);
                 log.info("FILE LOAD PROCESS DONE");
            }
            
            Map<String,Object> inputFileControlsReloadResults = new InputFileControlDAO().getData();
            List<DeliveredFile> deliveredFileNameData = new ArrayList<>();
            if(inputFileControlsReloadResults != null){
            for (Map.Entry<String, Object> entry :inputFileControlsReloadResults.entrySet()) {
            	InputFileControlEntity inputFile = (InputFileControlEntity)entry.getValue();
            	DeliveredFile deliveryFile = new DeliveredFile();
            	deliveryFile.setFilename(entry.getKey());
            	deliveredFileNameData.add(deliveryFile);
            	spolog("SUCCESSFULLY DELETED SYSTEM SEQ NUMBER : " +inputFile.getSystemSeqNumber()+" FROM CSO_TRANSACTIONS , CSO_PAYMENT_INSTRUCTIONS_VISA , CSO_PAYMENT_INSTRUCTIONS_MCARD AND CSO_PROGRAM_CONTROLS ");
              }
            }
            if(deliveredFileNameData.size() > 0){
            	 spolog("FILE LOAD RE-PROCESS STARTED");
	            for (DeliveredFile deliveredFile : deliveredFileNameData) {
	            	spolog(deliveredFile.getFilename() + " : IS ABOUT TO BE REPROCESSED");
	                checkReload(isReload, deliveredFile);
	                spolog("SUCCESSFULLY RE-PROCESSED FILENAME : "+deliveredFile.getFilename());
	            }
	            log.info("FILE LOAD RE-PROCESS DONE");
            }
            
        } catch(Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

	private void checkReload(boolean isReload, DeliveredFile deliveredFile) {
		List<ErrorDTO> errors = new ArrayList<>();

		try {
		    spolog("PROCESSING: " + deliveredFile.getFilename());

		    // detect service type
		    ServiceType serviceType = serviceType(deliveredFile.getFilename());

		    // validate and Index
		    spolog("VALIDATING " + deliveredFile.getFilename());
		    FileIndexer fileIndex = serviceType.getFileIndexer();
		    FileHeaderDTO header = new FileHeaderDTO();
		    FileFooterDto footer = new FileFooterDto();
		    fileIndex.index(deliveredFile.getFilename(), header,footer, errors, isReload);

		    if (isReload) {
		        spolog("DELETING DATABASE RECORDS FOR FILE REF " + header.getFileRefNumber() + ".");
		    }

		    // load
		    spolog("LOADING " + deliveredFile.getFilename() + " INTO DATABASE.");
		    String fileLoaderScript = serviceType.getFileLoaderScript();
		    String subServiceID = serviceType.getSubService().getDescription();
		    fileLoader.load(deliveredFile.getFilename(), fileLoaderScript, subServiceID);

		    // update
		    spolog("UPDATING CSO OUTPUT CONTROLS");		   
		    fileIndex.getTxnRecordWriter().getFilenameServer().flashFilenamesToOutputControls();
		    spolog("UPDATING OF CSO OUTPUT CONTROLS DONE");

		    // update delivery
		    deliveredFilesUpdateDAO.updateDeliveryFile(deliveredFile.getFilename(), "X");

		    // completed
		    spolog(deliveredFile.getFilename() + " LOADED SUCCESSFULLY.");

		    // move file to processed
		    //deliveredFilesReader.moveFile(filename, "processed");

		} catch (FileRejectedException | IOException | SystemConfigurationException e) {
		    spolog( e.getMessage() );
		    // e.printStackTrace();
		    deliveredFilesUpdateDAO.updateDeliveryFile(deliveredFile.getFilename(), "F");
		}
	}

    /**
     * Gets service type associated with this filename
     *
     * @param filename
     * @return serviceType
     */
    private ServiceType serviceType(String filename) {

        String filenamePrefix = filename.substring(0, 2);
        ServiceType serviceType = serviceTypes.get(filenamePrefix);
        return serviceType;
    }

    public void spolog(String message) {
        System.out.println(PROCESS_NAME + " " + VERSION + " " + message);
        Utils.logSpolog(message, PROCESS_NAME);
    }

    private static void sleep(Long timeout) {
        try {Thread.sleep(timeout * 1000);} catch (Exception e){}
    }

   /* public static void main(String[] args) {

        boolean isReload = false;

        if (args.length > 0 && "reload".equals(args[0])) {
            isReload = true;
        }

        try {
            new FileLoadProcess().process(isReload);
            System.out.println("\nFILE LOADER ENDED\n");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SQLLoaderNotImplemented sqlLoaderNotImplemented) {
            sqlLoaderNotImplemented.printStackTrace();
        }
        //System.exit(0);
    }*/

    @Override
    public void init() {
    }
}
