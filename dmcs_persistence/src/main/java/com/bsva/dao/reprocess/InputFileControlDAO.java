package com.bsva.dao.reprocess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.jboss.logging.Logger;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.endofservice.InputFileControlEntity;

public class InputFileControlDAO extends AbstractDao<InputFileControlEntity, Void>{
	
	//private Logger logger = Logger.getLogger(InputFileControlDAO.class);
	
	private final static String DELETE_PAYMENT_VISA = "DELETE FROM CSO_PAYMENT_INSTRUCTIONS_VISA WHERE FILE_REF_NUMBER = ";
	private final static String DELETE_PAYMENT_MCARD = "DELETE FROM CSO_PAYMENT_INSTRUCTIONS_MCARD WHERE FILE_REF_NUMBER = ";
	private final static String DELETE_CSO_TRANX = "DELETE FROM CSO_TRANSACTIONS WHERE FILE_SYSTEM_SEQ_NUMBER = ";
	private final static String DELETE_CSO_INPUT_FILE_CONTROL = "DELETE FROM CSO_INPUT_FILE_CONTROLS WHERE SYSTEM_SEQ_NUMBER = ";
	private final static String DELETE_CSO_PROGRAM_CONTROLS = "DELETE FROM CSO_PROGRAM_CONTROLS WHERE ARB_DATA = ";


	
	public Map<String,Object> getData(){
		try{
		Map<String, Object> params = new HashMap<String, Object>();
		//params.put("fileName", fileName);
		List<InputFileControlEntity> inoputResult = findAll(InputFileControlEntity.class);
		 if(inoputResult.size() > 0){
		  for (InputFileControlEntity inputFileControlEntity : inoputResult) {
			  if(inputFileControlEntity.getProcessStatus().equalsIgnoreCase("F")){
				   // logger.info("About to start reprocessing of filename : "+ inputFileControlEntity.getFilename().substring(0, 8));
				    params.put(inputFileControlEntity.getFilename().substring(0, 8), inputFileControlEntity);
				   // logger.info("ABOUT DELETING OF SYSTEM SEQ NUMBER ");
					  deleteData(inputFileControlEntity.getSystemSeqNumber());
					  deleteProgramControl(inputFileControlEntity.getFilename().substring(0, 8));
			  }
		  	}
		  return params ;
		 }
		}catch(Exception ex){
			ex.getMessage();
		}
		return null;
		
	}
	// Do all the deletes here.
	public void deleteData(String systemSeqNumber){
		
		   //logger.info("ABOUT DELETING OF SYSTEM SEQ NUMBER : "+ systemSeqNumber +" FOR REPROCESSING" );
		 deleteTruncate(DELETE_PAYMENT_VISA + "'"+systemSeqNumber+ "'");
		   //logger.info("ABOUT DELETING OF SYSTEM SEQ NUMBER : "+ systemSeqNumber +" FOR REPROCESSING" );
		 deleteTruncate(DELETE_PAYMENT_MCARD + "'"+systemSeqNumber+ "'");
		   //logger.info("ABOUT DELETING OF SYSTEM SEQ NUMBER : "+ systemSeqNumber +" FOR REPROCESSING" );
		 deleteTruncate(DELETE_CSO_TRANX + "'"+systemSeqNumber+ "'");
		   //logger.info("ABOUT DELETING OF SYSTEM SEQ NUMBER : "+ systemSeqNumber +" FOR REPROCESSING" );
		 deleteTruncate(DELETE_CSO_INPUT_FILE_CONTROL + "'"+systemSeqNumber+ "'");
		 
		
	}
	
	public void deleteProgramControl(String fileName){
		 //logger.info("ABOUT DELETING OF SYSTEM SEQ NUMBER : "+ fileName +" FOR REPROCESSING" );
		 deleteTruncate(DELETE_CSO_PROGRAM_CONTROLS + "'"+fileName+ "'");
	}
	

}
