package com.bsva.dmcs.operations.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;






import static java.nio.file.StandardCopyOption.*;

import com.bsva.dcms.commons.dao.CSFMembersDAO;
import com.bsva.dcms.commons.dao.CsfDeliveryServicesDAO;
import com.bsva.dcms.commons.dao.CsoSystemParametersDAO;
import com.bsva.dcms.commons.dao.DelDeliveryFilesCCCDAO;
import com.bsva.dcms.commons.dto.CSFMembersDTO;
import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
import com.bsva.dcms.commons.dto.CsoSystemParametersDTO;
import com.bsva.dcms.commons.dto.DelDeliveryFilesCCCDTO;
import com.bsva.dcms.commons.enums.Status;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.util.DateUtil;
import com.bsva.dcms.commons.util.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.NoSuchFileException;

/**
 * @author Mphikeleli
 *
 */
public class DmcsDirAndFileProcessing {

    private final Logger log = Logger.getLogger(DmcsDirAndFileProcessing.class.getName());

    public static final String INPUT_DIR = BsvTableLookup.getInstance().getInputDir();
    public static final String RECIEVE_DIR = BsvTableLookup.getInstance().getReceiveDir();
    public static final String SEND_DIR = BsvTableLookup.getInstance().getSendDir();
    public static final String PREVIOUS_DIR = BsvTableLookup.getInstance().getPrevDir();
    public static final String ARCHIVE_DIR = BsvTableLookup.getInstance().getArchiveDir();
    public static final String REPORT_DIR = BsvTableLookup.getInstance().getReportsDir();
    public static final String EXPORT_DIR = BsvTableLookup.getInstance().getExportDir();
    private static final String PROCESSNAME = "DmcsDirAndFileProcessing";
    private int position = 1;

    public DmcsDirAndFileProcessing() {
        super();
    }

    public void moveToPrevReceive() {

        String prevRecievePath = PREVIOUS_DIR + File.separator + "receive" + File.separator;
        log.info("Moving Files To Previous Recieve Dir: " + prevRecievePath);
        Utils.logSpolog("Moving Files To Previous Recieve Dir: " + prevRecievePath,PROCESSNAME);
        deleteFiles(new File(prevRecievePath));

        File receive = new File(RECIEVE_DIR);
        File prevRecieve = new File(prevRecievePath);

        try {

            moveFiles(receive, prevRecieve);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
  //Moving files from default spolog folder to Archive folder on SOD
    public void moveToArchive() {
    	 String archiveDir = BsvTableLookup.getInstance().getArchiveDir(); 
    	 String receiveDir = BsvTableLookup.getInstance().getSpologDir()+ File.separator ;
        String prevRecievePath = archiveDir + File.separator;
        
        Utils.logSpolog("Moving spolog Files To Archive  Dir: " + prevRecievePath,PROCESSNAME);
        
        deleteFiles(new File(prevRecievePath));
        
        File receive = new File(receiveDir);
        File prevRecieve = new File(prevRecievePath);

        try {

        	moveFilesToAchive(receive, prevRecieve);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // delete working files stored at the database server by SQL Loader
        // e.g. cccops@172.16.163.172:
        //      /ccc01/home/cccops/tana54/ccc/sqlidx
        //      /ccc01/home/cccops/tana54/ccc/sqllog
        //      /ccc01/home/cccops/tana54/ccc/sqlbad
        try {
            Runtime.getRuntime().exec("sqlldr_folders_clean");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moveToPrevSend() {

        String prevSendPath = PREVIOUS_DIR + File.separator + "send" + File.separator;

        log.info("Moving Files To Previous Send Dir: " + prevSendPath);
        Utils.logSpolog("Moving Files To Previous Send Dir: " + prevSendPath,PROCESSNAME);
        deleteFiles(new File(prevSendPath));

        File send = new File(SEND_DIR);
        File prevSend = new File(prevSendPath);

        try {

            try {
            moveFiles(send, prevSend);
            } catch (NumberFormatException nex) {
                log.info(nex.getMessage());
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void deleteExportFolder(){
    	
    	try{
            String exportPath = EXPORT_DIR + File.separator;
            log.info("DELETING EXPORT DIR : " + exportPath);
            Utils.logSpolog("DELETING EXPORT DIR : " + exportPath,PROCESSNAME);
            deleteFiles(new File(exportPath));

    	}catch(Exception ex){
    		ex.getMessage();
    	}
    }

    public void moveToPrevReport() {

        String prevReportPath = PREVIOUS_DIR + File.separator + "reports" + File.separator;
        log.info("Moving Reports To Previous Reports Send Dir: " + prevReportPath);
        Utils.logSpolog("Moving Reports To Previous Reports Send Dir: " + prevReportPath,PROCESSNAME);
        deleteFiles(new File(prevReportPath));

        File report = new File(REPORT_DIR);
        File prevReport = new File(prevReportPath);

        try {

            moveFiles(report, prevReport);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void deleteNegFiles() {
    	Utils.logSpolog("Deleting NegFiles",PROCESSNAME);
        String files;
        File negCardFile;
        File recFolder = new File(RECIEVE_DIR);
        File[] listOfFiles = recFolder.listFiles();
        if (listOfFiles != null && listOfFiles.length > 0) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    files = listOfFiles[i].getName();

//						log.info("Deleted Negative Filename :" + listOfFiles[i].getName());
                    log.info("Deleting Files :" + listOfFiles[i].getName());

//						if (files.startsWith("CNEGFILE")) {
                    negCardFile = new File(RECIEVE_DIR + File.separator + files);
                    negCardFile.delete();
//						}
                }
            }
        }
    }

    private void deleteFiles(File dir) {

        File[] Files = dir.listFiles();
        if (Files != null && Files.length > 0) {
            for (File file : Files) {

                if (!file.isDirectory()) {

                    log.info("Deleted Filename :" + file.getName());
                    Utils.logSpolog("Deleted Filename :" + file.getName(),PROCESSNAME);
                    file.delete();
                }
            }
        }
    }

    private void moveFiles(File source, File dest) throws IOException {

        File[] files = source.listFiles();

        File destination;
        File original;
        if (files != null && files.length > 0) {
            for (File file : files) {

                if (file.isFile()) {

//					log.info("Moved File Name :" + file.getName());
                    destination = new File(dest + File.separator + file.getName());
                    original = new File(source + File.separator + file.getName());

//					if (destination.exists()) {
//	
//						continue;
//					}
//					file.renameTo(new File(dest + File.separator + file.getName()));
                    log.info("Moving File Name :" + file.getName() + " From : " + source.getAbsolutePath() + " To; " + dest.getAbsolutePath());
                    Utils.logSpolog("Moving File Name :" + file.getName() + " From : " + source.getAbsolutePath() + " To; " + dest.getAbsolutePath(),PROCESSNAME);
                    try {
                    Files.move(FileSystems.getDefault().getPath(original.getAbsolutePath()), FileSystems.getDefault().getPath(destination.getAbsolutePath()), REPLACE_EXISTING);
                    } catch (NoSuchFileException nex) {
                        log.info(nex.getMessage());
                    }
                }
            }
        }
    }
    
    private void moveFilesToAchive(File source, File dest) throws IOException {

        File[] files = source.listFiles();
        PrintWriter writer = null;
        File destination;
        File original;
        if (files != null && files.length > 0) {
            for (File file : files) {

                if (file.isFile()) {

//					log.info("Moved File Name :" + file.getName());
            		CsoSystemParametersDTO csoSystemParametersDTO = new CsoSystemParametersDTO();
            		
            		csoSystemParametersDTO.setProcessActiveInd("Y");
            		CsoSystemParametersDAO csoSystemParametersDao = new CsoSystemParametersDAO();
            		CsoSystemParametersDTO csoSystemParameter;
            		String dateString = null;
					try {
						csoSystemParameter = csoSystemParametersDao.retrieve(csoSystemParametersDTO);
						 dateString = DateUtil.formatDate(csoSystemParameter.getProcessDate(), "yyyyMMdd");
					} catch (DAOException e) {
						e.printStackTrace();
					}catch(Exception ex){
						ex.getMessage();
					}
            		
            		
                     destination = new File(dest + File.separator + file.getName().substring(0, file.getName().lastIndexOf(".")));
            		
            		 original = new File(source + File.separator + file.getName().substring(0, file.getName().lastIndexOf(".")));    
            		 
                    Utils.logSpolog("Moving File Name :" + file.getName() + " From : " + original + " To; " + destination,PROCESSNAME);
                    try {
                    String fileSource = original.toString()+".spo";
                    String fileDest = destination.toString()+dateString+".spo";
                    
                    Path pathSource = Paths.get(fileSource);
              		Path pathTarget = Paths.get(fileDest);
              		//commented out to stop moving rather copy the file as it stops the tailing of the files
              		Files.move(pathSource, pathTarget, REPLACE_EXISTING);
              		
              		 // Added to creat an empty record in the file
              		 //Files.copy(pathSource, pathTarget, REPLACE_EXISTING);
              		 //writer = new PrintWriter(original);
              		 //writer.write("");
              		 //writer.close();
              		
                    }catch (IOException  nex) {
                        log.info(nex.getMessage());
                    }
                    catch (Exception  nex) {
                        log.info(nex.getMessage());
                    }
                    
                }
            }
        }
    }


    public boolean logFileDelivery(String fileName) throws IOException {

        String queue = "";
        try {
            String fname = fileName.substring(0, 2);
            CsfDeliveryServicesDTO dto = getFileDeliveryService(fname);
            if (dto == null) {
                return false;
            }
            if ("I".equals(dto.getInwardOutwardInd())) {

                queue = "INQUE";

            } else if ("O".equals(dto.getInwardOutwardInd())) {

                queue = "OUTQUE";
            }

            CsoSystemParametersDTO parmObject = new CsoSystemParametersDTO();
            parmObject.setProcessActiveInd(Status.Y.getSymbol());
            CsoSystemParametersDAO csoSystemParametersdao = new CsoSystemParametersDAO();
            CsoSystemParametersDTO csoSystemParametersDTO = csoSystemParametersdao.retrieve(parmObject);

            CSFMembersDTO cmfMemberParm = new CSFMembersDTO();
           
            String fileNames = fileName.substring(2, 4).trim().toString();
            log.info("The filename is : " + fileNames);
            Utils.logSpolog("The filename is : " + fileNames,PROCESSNAME);
            
            
            if (fileNames.equals("CS")) {
            	Integer originator = getFileOriginator(fileName);
                cmfMemberParm.setBankCode(originator); 
            } else {
                cmfMemberParm.setMemberTapeId(fileNames);
            }
            
            CSFMembersDAO csfMembersdao = new CSFMembersDAO();
          
            CSFMembersDTO cSFMembersDTO = csfMembersdao.retrieve(cmfMemberParm);

            DelDeliveryFilesCCCDTO deliveryFileParm = new DelDeliveryFilesCCCDTO();
            String fileparam = fileName.substring(0, 2).trim().toString();
            deliveryFileParm.setFileName(fileparam);
            deliveryFileParm.setQueueFileName(queue);

            DelDeliveryFilesCCCDAO delDeliveryFilesCCCDao = new DelDeliveryFilesCCCDAO();
            List<DelDeliveryFilesCCCDTO> deliveryList = delDeliveryFilesCCCDao.retrieveRelated(deliveryFileParm);
            if (deliveryList != null && deliveryList.size() > 0) {

                position = deliveryList.size() + 1;
            } else {
            	 DelDeliveryFilesCCCDTO deliveryFileParms = new DelDeliveryFilesCCCDTO();
            	List<DelDeliveryFilesCCCDTO> deliveryLists = delDeliveryFilesCCCDao.retrieveRelated(deliveryFileParms);
            	if (deliveryLists != null && deliveryLists.size() > 0) {
            		position = deliveryLists.size()+1;
            	}
            }

            DelDeliveryFilesCCCDTO delDeliveryFile = new DelDeliveryFilesCCCDTO();

            delDeliveryFile.setPosition(position);
            delDeliveryFile.setPrddate(Integer.valueOf(DateUtil.formatDate(csoSystemParametersDTO.getProcessDate(), "YYYYMMdd")));
            delDeliveryFile.setFileName(fileName);
            delDeliveryFile.setXmitInd(Status.Y.getSymbol());
//				delDeliveryFile.setDeliveryStatus(Status.Y.getSymbol()); 
            delDeliveryFile.setQueueFileName(queue);
            delDeliveryFile.setMember(cSFMembersDTO.getBankCode());
            delDeliveryFile.setDeliveryTime(Integer.valueOf(Utils.getTime()));

            //check if file is already logged in delDelivery before inserting
            DelDeliveryFilesCCCDTO paramObj = new DelDeliveryFilesCCCDTO();
            paramObj.setFileName(fileName);
            DelDeliveryFilesCCCDAO delDeliveryFileDao = new DelDeliveryFilesCCCDAO();
            List<DelDeliveryFilesCCCDTO> fileNameCheck = delDeliveryFileDao.retrieveRelated(paramObj);
            if (fileNameCheck != null) {
                try {
                    DelDeliveryFilesCCCDAO delDeliveryFilesCCCDa = new DelDeliveryFilesCCCDAO();
                    delDeliveryFilesCCCDa.create(delDeliveryFile);

                } catch (Exception ex) {
                    log.info("Error Occured Creating Del Delivery");
                    Utils.logSpolog("Error Occured Creating Del Delivery",PROCESSNAME);
                }
                return true;
            }

        } catch (DAOException e) {
            // TODO Auto-generated catch block
            log.info("Error Occured in Del Delivery " + e);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            log.info("Error Occured in Del Delivery " + e);

        }
        return false;

    }

    //get delivery service for a file
    public CsfDeliveryServicesDTO getFileDeliveryService(String prefix) throws DAOException {

        CsfDeliveryServicesDTO dto = new CsfDeliveryServicesDTO();
        dto.setFilenamePrefix(prefix);

        CsfDeliveryServicesDAO dao = new CsfDeliveryServicesDAO();
        CsfDeliveryServicesDTO csfDeliveryServicesdto = dao.retrieve(dto);

        return csfDeliveryServicesdto;
    }

    public void archiveFolder(String srcFolder, String destZipFile) throws Exception {
        ZipOutputStream zip = null;
        FileOutputStream fileWriter = null;
        fileWriter = new FileOutputStream(destZipFile);
        zip = new ZipOutputStream(fileWriter);
        addFolderToZip("", srcFolder, zip);
        zip.flush();
        zip.close();
    }

    private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
            throws Exception {
        File folder = new File(srcFile);
        if (folder.isDirectory()) {
            addFolderToZip(path, srcFile, zip);
        } else {
            byte[] buf = new byte[1024];
            int len;
            FileInputStream in = new FileInputStream(srcFile);
            zip.putNextEntry(new ZipEntry(path + File.separator + folder.getName()));
            while ((len = in.read(buf)) > 0) {
                zip.write(buf, 0, len);
            }
        }
    }

    private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
            throws Exception {
        File folder = new File(srcFolder);

        for (String fileName : folder.list()) {
            if (path.equals("")) {
                addFileToZip(folder.getName(), srcFolder + File.separator + fileName, zip);
            } else {
                addFileToZip(path + File.separator + folder.getName(), srcFolder + File.separator + fileName, zip);
            }
        }
    }

    private Integer getFileOriginator(String fileName) throws FileNotFoundException, IOException {
        
        String file = RECIEVE_DIR  + File.separator + fileName;
        log.info("Moving File : " + file);
        Utils.logSpolog("Moving File : " + file,PROCESSNAME);
        
        File input = new File(file);

        FileReader namedReader = new FileReader(input);
        BufferedReader in = new BufferedReader(namedReader);
        
        String header = in.readLine();
        String originator = header.substring(24,28);
        namedReader.close();
        
        return Integer.valueOf(originator);
    }

}
