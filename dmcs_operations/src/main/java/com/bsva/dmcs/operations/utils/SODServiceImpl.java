package com.bsva.dmcs.operations.utils;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.bsva.dcms.commons.dto.CsoServiceParametersDTO;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dmcs.operations.businesslogic.DmcsDefaultOutputFiles;
import com.bsva.dmcs.operations.businesslogic.DmcsSOD;
import com.bsva.dmcs.operations.exceptions.SODServiceException;
import com.bsva.dmcs.operations.interfaces.SODService;
import com.bsva.dmcs.operations.processes.InDelProcess;

public class SODServiceImpl implements SODService {
	
	
	
	public SODServiceImpl(){
	}

	@Override
	public boolean sodProcess(Date processDate) throws SODServiceException {
		boolean result;
    	try {
    		DmcsSOD dmcsSOD = new DmcsSOD();
    		result = dmcsSOD.sodProcess(processDate);
    	
    	} catch (Exception  e) {
			e.printStackTrace();
			throw new SODServiceException("Error Occured During sodProcess():" + e);
		}
    		
		return result;
	}

	@Override
	public void executeInputDelivery() throws SODServiceException {
    	try {
		InDelProcess inDel = new InDelProcess();
		inDel.process();
			
	} catch (Exception  e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new SODServiceException("Error Occured InDel inputFiles :" + e);
	 }		
	}

	@Override
	public void executeOutdel() throws SODServiceException {
//		try {
//
//			OutDel outDel = new OutDel(con);
//			
//			outDel.executeOutDel();
//					
//		} catch (SQLException  e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new facadeException("Error Occured OutDel :" + e);
//		}			
	}

	@Override
	public String[] updateServiceParameters(String subService,String serviceStatus) throws SODServiceException {
		String[] results = new String[2];
    	
//    	try {
//			DmcsEOD dmcsEOD = new DmcsEOD(con);
//			
//			results = dmcsEOD.updateServiceParameters(subService,subServiceStatus);
//			
//		} catch (SQLException  e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new facadeException("Error Occured :" + e);
//		}
		return results;
	}

	@Override
	public void moveToPrevReceive() throws SODServiceException {
    	try {
    		DmcsDirAndFileProcessing fileProcessing = new DmcsDirAndFileProcessing();
    		fileProcessing.moveToPrevReceive(); 
    	}catch (Exception  e) {
			e.printStackTrace();
			throw new SODServiceException("Error Occured While Moving Files To Dollar prev recieve: " + e);
		}
	}

	@Override
	public void moveToPrevSend() throws SODServiceException {
		try {
    		DmcsDirAndFileProcessing fileProcessing = new DmcsDirAndFileProcessing();
    		fileProcessing.moveToPrevSend(); 
    	}catch (Exception  e) {
			e.printStackTrace();
			throw new SODServiceException("Error Occured While Moving Files To Dollar prev send: " + e);
		}
	}

	@Override
	public void moveToPrevReport() throws SODServiceException {
		try {
    		DmcsDirAndFileProcessing fileProcessing = new DmcsDirAndFileProcessing();
    		fileProcessing.moveToPrevReport(); 
    	}catch (Exception  e) {
			e.printStackTrace();
			throw new SODServiceException("Error Occured While Moving Files To Dollar prev report: " + e);
		}
	}

	@Override
	public void generateDefaultOutputFiles() throws SODServiceException {
		
		try {
			DmcsDefaultOutputFiles dmcsDefaultOutputFiles = new DmcsDefaultOutputFiles();
			
			dmcsDefaultOutputFiles.generateDefaultOutputFiles();
		}catch (Exception  e) {
			e.printStackTrace();
			throw new SODServiceException("Error Occured While Generating Output File Controls:" + e);
		}
	}

	@Override
	public List<CsoServiceParametersDTO> getServices() throws SODServiceException {
	  	List<CsoServiceParametersDTO> services = new ArrayList<CsoServiceParametersDTO>();
//    	
//		try {
//	    		
//				con = dataSource.getConnection();
//				
//				DmcsEOD dmcsEOD = new DmcsEOD(con);
//				
//				services = dmcsEOD.getServices();
//				
//			} catch (SQLException  e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				throw new facadeException("Error Occured :" + e);
//			}
//		
		return services;
	}

	@Override
	public void deleteNegFiles() throws SODServiceException {
		try {
    		DmcsDirAndFileProcessing fileProcessing = new DmcsDirAndFileProcessing();
    		fileProcessing.deleteNegFiles(); 
    	}catch (Exception  e) {
			e.printStackTrace();
			throw new SODServiceException("Error Occured While Moving Files To Dollar prev report: " + e);
		}
		
	}

	@Override
	public void moveToArchive() throws SODServiceException {
		try {
    		DmcsDirAndFileProcessing fileProcessing = new DmcsDirAndFileProcessing();
    		fileProcessing.moveToArchive(); 
    	}catch (Exception  e) {
			e.printStackTrace();
			throw new SODServiceException("Error Occured While Moving Files To Dollar Archive recieve: " + e);
		}
		
	}

	@Override
	public void deleteExportFile() throws SODServiceException {
		try{
			DmcsDirAndFileProcessing deleteExportFolder = new DmcsDirAndFileProcessing();
			deleteExportFolder.deleteExportFolder();
		}catch(Exception ex){
			ex.printStackTrace();
			throw new SODServiceException("Error occured deleting export folder :"+ ex);
		}
		
	}


}
