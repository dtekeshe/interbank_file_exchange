package com.bsva.dmcs.fileextractv02;

import com.bsva.dao.v02.CompanyParametersDAO;
import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dao.v02.extract.OutputFileReaderDAO;
import com.bsva.dmcs.controller.AbstractProcess;
import com.bsva.entities.v02.extract.OutputControlsEntity;
import com.bsva.entities.v02.outputcontrols.LastFileOutputControlKey;
import com.bsva.entities.v02.outputcontrols.OutputControlDayTotalEntity;
import com.bsva.entities.v02.params.CompanyParametersEntity;
import com.bsva.entities.v02.params.SystemParametersEntity;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
@SuppressWarnings("unused")
public class FileExtractProcess extends AbstractProcess {

    private final static String PROCESS_NAME = "OUTPUT";

    private static FileExtractor fileExtractor;
    private static OutputFileReaderDAO outputFileReaderDAO;

    private Logger log = Logger.getLogger(FileExtractProcess.class);

    public FileExtractProcess() {
        initFileExtract();
    }

    @Override
    /**
     * Scheduled process
     * Runs during the day.
     * Extracts full files only.
     */
    public void process() {

        // System.out.println("READING PENDING FULL FILES");
        // get pending full files
        List<OutputControlsEntity> files
                = outputFileReaderDAO.pendingFullFiles();

        // System.out.println(files.size() + " FULL FILES FOUND");
        fileExtractor.extract(files, Boolean.FALSE, null);
    }

    /**
     * Called by EndOfService process
     * Will extract partial files
     *  @param serviceID
     * @param subServiceID
     * @param dayTotals
     */
    public void endOfService(String serviceID,
                             String subServiceID,
                             Map<LastFileOutputControlKey, OutputControlDayTotalEntity> dayTotals) {

        // System.out.println("READING PENDING PARTIAL FILES");
        // get pending partial files
        List<OutputControlsEntity> files
                = outputFileReaderDAO.pendingPartialFiles( serviceID,
                                                           subServiceID );
        // System.out.println(files.size() + " PARTIAL FILES FOUND");
        fileExtractor.extract(files, Boolean.TRUE, dayTotals);
    }

    public static void initFileExtract() {

        try {
            System.out.println("INITIALING FILE OUTPUT PROGRAM");

            // company parameters
            CompanyParametersEntity companyParametersEntity = new CompanyParametersDAO().companyParameters();
            String validationCode = companyParametersEntity.getValidationCode();

            // system parameters
            SystemParametersEntity systemParametersEntity
                    = new SystemParametersDAO()
                            .systemParameters();
            String environmentID
                    =  systemParametersEntity.getEnvironmentDescription();
            Date processDate = systemParametersEntity.getProcessDate();

            // directories
            Map<String, String> paths = new DirectoryDAO().directories();
            String sendFolder   = paths.get("SEND_FOLDER");
            String exportFolder = paths.get("EXPORT_FOLDER");

            outputFileReaderDAO = new OutputFileReaderDAO();

            fileExtractor
                    = new FileExtractor( environmentID,
                                         validationCode,
                                         processDate,
                                         exportFolder,
                                         sendFolder,
                                         outputFileReaderDAO );

            System.out.println("FILE OUTPUT INITIALISED. OUTPUT FOLDER: " + sendFolder);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("OUTPUT 01 FILE OUTPUT NOT STARTED : " + e.getMessage());
            System.out.println("OUTPUT 01 FILE OUTPUT WILL RETRY AFTER 15 SECONDS");
            sleep(15L);
            System.out.println("OUTPUT 01 FILE OUTPUT STARTING ...");
            initFileExtract();
        }
    }

    private static void sleep(Long timeout) {
        try {Thread.sleep(timeout * 1000);} catch (Exception e){}
    }

    @Override
    public void init() {
    }
}
