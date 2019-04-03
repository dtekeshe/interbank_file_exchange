package com.bsva.dmcs.operations.processes;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.bsva.dcms.commons.dao.DelDeliveryFilesCCCDAO;
import com.bsva.dcms.commons.dto.DelDeliveryFilesCCCDTO;
import com.bsva.dcms.commons.enums.Status;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.util.Utils;
import com.bsva.dmcs.controller.AbstractProcess;

/**
 * @author Mphikeleli
 *
 */
public class OutDelProcess extends AbstractProcess{
	
	private final Logger log = Logger.getLogger(OutDelProcess.class.getName());

	@Resource(lookup = "java:jboss/datasources/DMCSDb")
    private DataSource datasource;
	private static final String PROCESSNAME = "OUTDEL";

	public OutDelProcess() {
	}

	
	public static void main(String[] args){
		 
		//  String VERSION = "@@version";
	       // Utils.logSpologDel("Version: " + VERSION);
	        try {
	            //System.out.println("STARTED: Settlement component");

	           // String driverClassName = "oracle.jdbc.OracleDriver";
	           // String dbURL = "jdbc:oracle:thin:@172.16.163.172:1521:cccd";
	            //String dbURL = "jdbc:oracle:thin:@172.16.161.128:1521:ICMST";
	        
	           // Class.forName(driverClassName);
	           // Connection conn = //DriverManager.getConnection(dbURL, "CCCOWNER", "cccowner");
	            
	            
	            OutDelProcess inDel = new OutDelProcess();
	            
	            inDel.executeOutDel();
	        }
	        catch(Exception ex)  {
	            ex.printStackTrace();
	        }
	}
	
	public void executeOutDel(){ 
		//getLog().info("### OutDel Process Is Starting ###");
		//Utils.logSpologDel("### OutDel Process Is Starting ###");
		setCon(getCon());
		
		List<DelDeliveryFilesCCCDTO> outputFiles = new ArrayList<DelDeliveryFilesCCCDTO>();

		DelDeliveryFilesCCCDTO delDto = new DelDeliveryFilesCCCDTO();
		delDto.setQueueFileName("OUTQUE"); 
		delDto.setPrddate(Integer.parseInt(BsvTableLookup.getInstance().getProcessDate()));
		delDto.setDeliveryStatus(Status.Y.getSymbol());

		try {
			DelDeliveryFilesCCCDAO delDeliveryFilesCCCdao = new DelDeliveryFilesCCCDAO();
			outputFiles = delDeliveryFilesCCCdao.retrieveRelated(delDto);

			if(outputFiles.size() > 0){

				for(DelDeliveryFilesCCCDTO file : outputFiles){

					File receiveDirectory = new File(BsvTableLookup.getInstance().getReceiveDir());

					File[] sendFiles = receiveDirectory.listFiles();

					for(File entry : sendFiles){

						if(entry.isFile()){

							if(file.getFileName().equals(entry.getName())){
                                 
									Utils.logSpologDel("Filename: " + file.getFileName() + "Copying to output",PROCESSNAME);
								
								if(copyFile(BsvTableLookup.getInstance().getReceiveDir() + File.separator + entry.getName(), BsvTableLookup.getInstance().getSendDir() + File.separator + "output" + File.separator + entry.getName())){

									updateDelDilevery(file.getFileName());

									Utils.logSpologDel("Filename: " + file.getFileName() + "Successfully copied to output",PROCESSNAME);
								}
							}
						}	
					}
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		//getLog().info("### OutDel Process Is Complete ###");
	}
	
	
	private boolean copyFile(String source, String dest){
		
		Path sourcePath = Paths.get(source);
		Path destinationPath = Paths.get(dest);
		
		try {
			
			Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
			
			return true;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
		
	private boolean updateDelDilevery(String fileName){
		
		//update del delivery
		Utils.logSpologDel("About to update File : "+fileName+" to DelDelivery .",PROCESSNAME);
		DelDeliveryFilesCCCDTO delDto = new DelDeliveryFilesCCCDTO();
	    delDto.setFileName(fileName);
	    delDto.setPrddate(Integer.parseInt(BsvTableLookup.getInstance().getProcessDate()));
		delDto.setDeliveryStatus(Status.C.getSymbol());
		try {
			
			DelDeliveryFilesCCCDAO delDeliveryFilesCCCDao = new DelDeliveryFilesCCCDAO();
			delDeliveryFilesCCCDao.update(delDto);
			
			return true;
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void init() {
		
	}

	@Override
	public void process() {
		executeOutDel();
	}

	public DataSource getCon() {
		return datasource;
	}


	public void setCon(DataSource con) {
		this.datasource = con;
	}


	public Logger getLog() {
		return log;
	}
}
