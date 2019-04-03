package com.bsva.dmcs.operations.processes;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.text.ParseException;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.bsva.dcms.commons.dao.CsfDeliveryServicesDAO;
import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.util.DateUtil;
import com.bsva.dcms.commons.util.Utils;
import com.bsva.dmcs.controller.AbstractProcess;
import com.bsva.dmcs.operations.utils.DmcsDirAndFileProcessing;

/**
 * @author Mphikeleli
 *
 */
public class InDelProcess extends AbstractProcess {

	private final Logger log = Logger.getLogger(InDelProcess.class.getName());

	@Resource(lookup = "java:jboss/datasources/DMCSDb")
    private DataSource datasource;
	private static final String PROCESSNAME = "INDEL" ;

	public InDelProcess() {	
		//datasource = connect;
	}
	
	public static void main(String[] args) throws ParseException{
		 
		 // String VERSION = "@@version";

	       // System.out.println("Version: " + VERSION);
	        try {
	           // System.out.println("STARTED: Settlement component");

//	            String driverClassName = "oracle.jdbc.OracleDriver";
//	            String dbURL = "jdbc:oracle:thin:@172.16.163.172:1521:cccd";
//	            //String dbURL = "jdbc:oracle:thin:@172.16.161.128:1521:ICMST";
//	        
//	            Class.forName(driverClassName);
	           // Connection conn = DriverManager.getConnection(dbURL, "CCCOWNER", "cccowner");
	            
	            InDelProcess inDel = new InDelProcess();
	            
	            inDel.process();
	        }
	        catch(Exception ex)  {
	            ex.printStackTrace();
		
	     try {
					int time = Integer.valueOf(DateUtil.formatDate(new Date(116,2,17), "YYYYMMdd"));
					//System.out.println(time);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	        }
				
	  }


	@Override
	public void init() {
	}

	@Override
	public void process() {
		
		//Utils.logSpologDel("### Indel Process Has Started - ####");
		//This needs to be a directory
		
		//setCon(getCon());
		//log.info("### getting Indel Process- ####");
		String dirName = BsvTableLookup.getInstance().getInputDir();//+ File.separator + "input";
		File delInput = new File(BsvTableLookup.getInstance().getInputDir());//+ "input");
		if(delInput != null && delInput.length() > 0){
			for(String file : delInput.list()){
				log.info("Listing Files in Dir: " + file);
			}
		}
	
		File[] inputFiles = delInput.listFiles(new FilenameFilter() {
			
			public boolean accept(File dir, String filename){
				CsfDeliveryServicesDTO retrivedCsfDeliveryServicesDTO = null;
				CsfDeliveryServicesDAO csfDeliveryServicesDAO = new CsfDeliveryServicesDAO();
				CsfDeliveryServicesDTO csfDeliveryServicesDTO = new CsfDeliveryServicesDTO();
				String fname = filename.substring(0, 2);
				csfDeliveryServicesDTO.setFilenamePrefix(fname);
				csfDeliveryServicesDTO.setInwardOutwardInd("I");
				try {
					 retrivedCsfDeliveryServicesDTO = csfDeliveryServicesDAO.retrieve(csfDeliveryServicesDTO);
					 Utils.logSpologDel("Getting processes active Indicator"+ retrivedCsfDeliveryServicesDTO.getActiveIndicator(),PROCESSNAME);
					 
				} catch (DAOException e) {
					e.printStackTrace();
				}
				if (retrivedCsfDeliveryServicesDTO != null){
					return true;
				}else{
					return false;
				}
			}
		} );

		//logg to process logger
		File receivedFile;
		if (inputFiles != null && inputFiles.length > 0){
			for (File inputFile : inputFiles) {
				if (inputFile.isFile()) {
					if (!inputFile.getName().startsWith("C")) {
						continue;
					}
					receivedFile = new File(BsvTableLookup.getInstance().getReceiveDir() + File.separator + inputFile.getName());
					log.info("ReceivedFile ............................ "+ receivedFile);
					if (receivedFile.exists()) {
						continue;
					}
					log.info("After ReceivedFile ............................ ");
					Utils.logSpologDel("Moving input File: "+ inputFile.getName() + " to Dollar Recieve...",PROCESSNAME);
					
					
					inputFile.renameTo(new File(BsvTableLookup.getInstance().getReceiveDir() + File.separator + inputFile.getName()));
					
					Utils.logSpologDel("input File: "+ inputFile.getName() + " successfully moved to Dollar Recieve",PROCESSNAME);
					DmcsDirAndFileProcessing dFprocessing = new DmcsDirAndFileProcessing();
					
					Utils.logSpologDel("logging input File: "+ inputFile.getName() + " into DelDelivery...",PROCESSNAME);
					
					try {
						if(dFprocessing.logFileDelivery(inputFile.getName())){
							
							continue;	
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					Utils.logSpologDel("input File: "+ inputFile.getName() + " Successfully logged into DelDelivery",PROCESSNAME);
				}
			}
		//log to process Logger
	   }
		//log.info("### Indel Process Has Completed - #####");
	}

	public DataSource getCon() {
		return datasource;
	}

	public void setCon(DataSource con) {
		this.datasource = con;
	}
}
