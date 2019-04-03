//package com.bsva.dmcs.fileLoad;
//
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Properties;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//
//import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
//import com.bsva.dcms.commons.dto.DelDeliveryFilesCCCDTO;
//import com.bsva.dcms.commons.enums.Status;
//import com.bsva.dcms.commons.exceptions.DuplicateProcessException;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dcms.commons.util.Utils;
//import com.bsva.dmcs.fileLoad.subfunctions.Billing;
//import com.bsva.dmcs.fileLoad.subfunctions.FileProcess;
//import com.bsva.dmcs.fileLoad.subfunctions.PreExtract;
//import com.bsva.entities.CsoInputFileControls;
//
//
//public class Main implements Runnable{
//
//    private long delay;
//   // @Resource(lookup = "java:jboss/datasources/DMCSDb")
//    //private static DataSource connection;
//    private boolean run = true;
//    private static String logPGM = "";
//    private Logger log = Logger.getLogger(Main.class);
//
//    /*
//     * TODO: MONDAY
//     * TEST VISA FROM BEGINNING TO END
//     * RENAME BASIC2.XML TO SOMETHING ELSE
//     * MOVE BASIC2.XML TO THE RESOURCE DIRECTORY (LOOK TO REPORTS FOR WAYS TO ACCESS THE FILE THATS NOT IN THE BUILD PATH)
//     * TEST OPTIONAL SECONDARY BIT MAP
//     *
//     */
//
//	public Main() {
//      //  this.connection = conn;
//      // this.delay = delay;
//    }
//
//	public static void mainnnn(String[] args){
//
////
////		INSERT INTO DEL_DELIVERY_FILES_CCC(POSITION , QUEUE_FILE_NAME , PRD_DATE, MEMBER , FILENAME , XMIT_IND) VALUES(1 , 'INQUE' , '20160209' , 0001, 'CCN0002D', 'Y');
////		INSERT INTO DEL_DELIVERY_FILES_CCC(POSITION , QUEUE_FILE_NAME , PRD_DATE, MEMBER , FILENAME , XMIT_IND) VALUES(2 , 'INQUE' , '20160209' , 0001, 'CVB0002D', 'Y');
////		INSERT INTO DEL_DELIVERY_FILES_CCC(POSITION , QUEUE_FILE_NAME , PRD_DATE, MEMBER , FILENAME , XMIT_IND) VALUES(3 , 'INQUE' , '20160209' , 0001, 'CVB0005D', 'Y');
////
////
////			SELECT * FROM CSO_SYSTEM_PARAMETERS WHERE PROCESS_ACTIVE_IND = 'Y'
//
//
//		  String VERSION = "@@version";
//
//	        System.out.println("Version: " + VERSION);
//	        try {
//	           /* System.out.println("STARTED: File loader component");
//
//	            String configFile = "";
//	            if(args.length > 0) {
//	                configFile = args[0];
//	            } */
//	            Main m = new Main();
//	            Thread thread = new Thread();
//	            thread.start();
//	        }
//	        catch(Exception ex)  {
//	            ex.printStackTrace();
//	        }
//	}
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		load();
//	}
//
//
////	private void initializeLogger(){
////	    Properties logProperties = new Properties();
////	 
////	    try
////	    {
////	      // load our log4j properties / configuration file
////	      logProperties.load(new FileInputStream(LOG_PROPERTIES_FILE));
////	      PropertyConfigurator.configure(logProperties);
////	      log.info("Logging initialized.");
////	    }
////	    catch(IOException e)
////	    {
////	      throw new RuntimeException("Unable to load logging property " + LOG_PROPERTIES_FILE);
////	    }
////	  }
//
//	public void load(){
//
//		//todo: test duplicate entries on the program control table
//		try{
//
//			Properties logProperties = new Properties();
//
//			InputStream is = this.getClass().getClassLoader().getResourceAsStream("log4j.properties");
//			logProperties.load(is);
//			PropertyConfigurator.configure(logProperties);
//
//			log.info("Info");
//			log.debug("Debug");
//			log.error("Error");
//
//			FileLoadDAO fileLoadDAO = new FileLoadDAO();
//
//			List<DelDeliveryFilesCCCDTO>  delDeliveryFileList = fileLoadDAO.getReceivedFilesFromDelivery();
//			for(DelDeliveryFilesCCCDTO delDeliveryFile : delDeliveryFileList){
//
//				String filename =  delDeliveryFile.getFileName();
//				String filenamePrefix = filename.substring(0,2);
//			    String fileReferenceNumber = filename + BsvTableLookup.getInstance().getNextOutputProcessDate();
//
//				CsfDeliveryServicesDTO fileDeliveryService = fileLoadDAO.getFileDeliveryService(filenamePrefix);
//				String service = fileDeliveryService.getService();
//				String subService = fileDeliveryService.getSubService();
//
//
//				try{
//					//check that the sub service is active before loading the file
//					logPGM = "LOADER";
//					if (Utils.isSubServiceActive(logPGM, service, subService , "I")){
//
//						//1. first process the file
//						try{
//							FileProcess fileProcess = new FileProcess(filename, service, subService);
//							fileProcess.execute();
//						}catch(DuplicateProcessException e){
//							log.error(e.getMessage());
//						}
//
//
//						//TODO. find out if this is necessary
////						RejectedTxFileExtract rejTxFileExtract = new RejectedTxFileExtract(conn);
////						rejTxFileExtract.extract(fileDto);
//
//
//	//					//5. launch ODS process
//	//					//TODO: we cannot spawn a thread for every file
//	//					//TODO: maybe this should run in parallel with the file loader??
//	////					FileLoadODSProcess fileLoadOds = new FileLoadODSProcess(ds.getConnection());
//	////					fileLoadOds.setFileName(filename);
//	////					Thread odsThread = new Thread(fileLoadOds);
//	////					odsThread.start();
//	//
//	//					fileLoadDAO.setProcessFileStage(logPGM ,filename, service , subService, Status.C);
//	//
//						//2. calculate the billing figures for loaded transactions
//						try{
//							Billing billing = new Billing(filename, service, subService, fileReferenceNumber);
//							//billing.execute(CsoInputFileControls inputFileControl);
//						}catch(Exception e){
//							log.error(e.getMessage());
//						}
//
//						//3. the run the preextract before extract is triggeres
//						try{
//							PreExtract preExtract = new PreExtract(filename, service, subService, fileReferenceNumber);
//							//preExtract.execute();
//						}catch(Exception e){
//							log.error(e.getMessage());
//						}
//
//
//
//
////						CsvCcr00XDataViewDto dto = new CsvCcr00XDataViewDto();
////						dto.setSubService("VISA CARD");
////						CsvCCR00XDataViewDAO dao = new CsvCCR00XDataViewDAO(conn);
////						dao.retrieveRelated(null);
////						String name = "mboni";
//
////						CsvCcr002View csvCcr002View = new CsvCcr002View(conn);
////						List<CsvCcr002ViewDto> csvCcr002ViewDtos = csvCcr002View.execute();
//
//
////						CsvSettlementView csvSettlementView = new CsvSettlementView(conn);
////						List<CsvSettlementViewDto> csvSettlementViewDtos = csvSettlementView.execute();
////
//
//						//last step is to update del_delivery to completed
////						Utils.updateDelDeliveryStatus(delDeliveryFile.getFileName(), Status.C.getSymbol());
//
//					}else{
//						log.debug("Subservice " + subService + " is inactive. Cannot process file " + filename);
//					}
//
//				}catch(Exception e){
//					Utils.updateProcess(logPGM, delDeliveryFile.getFileName(), service, subService, Status.F.getSymbol());
////					Utils.updateDelDeliveryStatus(delDeliveryFile.getFileName(), Status.F.getSymbol());
//					log.error("Error processing file " +  delDeliveryFile.getFileName(), e);
//				}
//			}
//
//		}catch(Exception e){
//			log.error("Error with LOADER" , e);
//		}
//	}
//
//}
