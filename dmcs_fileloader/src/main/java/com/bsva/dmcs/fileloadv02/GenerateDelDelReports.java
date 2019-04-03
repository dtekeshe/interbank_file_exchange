package com.bsva.dmcs.fileloadv02;

import static com.bsva.dao.v02.util.StringUtils.format;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.v02.LastSeqNumbersDAO;
import com.bsva.dao.v02.startofday.DefaultOutputFilesDAO;
import com.bsva.dao.v02.startofday.SeqNumbersDAO;
import com.bsva.dao.v02.util.DatabaseException;
import com.bsva.dto.Justification;
import com.bsva.entities.v02.loader.LastSeqNumberKey;
import com.bsva.entities.v02.startofday.DefaultOutputFileEntity;
import com.bsva.entities.v02.startofday.DefaultOutputFileKey;
import com.bsva.entities.v02.startofday.SeqNumberEntity;
import com.bsva.entities.v02.startofday.SeqNumberKey;

public class GenerateDelDelReports {
	
	private static Map<LastSeqNumberKey,Long> lastSeqNumberUsed;
	
	static {

		lastSeqNumberUsed = new LastSeqNumbersDAO().lastSeqNumbers();
	}

	  public void setSeqNumbers(DefaultOutputFileEntity genObject,int counter) {
		  
		// Map<SeqNumberKey, SeqNumberEntity> getlastSeqNumber = lastSeqNumberUsed;
	        // group files by destination bank
	    	List<DefaultOutputFileEntity> defaultList = new ArrayList<>();
	        Map<SeqNumberKey, SeqNumberEntity> destBanks = new HashMap<>();
	            // create key
	            SeqNumberKey key
	                    = new SeqNumberKey("CR", genObject.getDestBankID());

	            SeqNumberEntity seqNumberForThisBank = destBanks.get(key);
	            if (seqNumberForThisBank == null) {
	                seqNumberForThisBank = new SeqNumberEntity(key, 0);
	            }

	            // increment seq number
	             seqNumberForThisBank.setSeqNumber(counter);//.incrementSeqNumber();
	            //set seqNumber
	            genObject.getId().setSeqNumber(seqNumberForThisBank.getSeqNumber());
	            destBanks.put(key, seqNumberForThisBank);

	            // construct filename
	            String filename
	                    = "CR" +
	                    		genObject.getDestBankID() +
	                    format("" + seqNumberForThisBank.getSeqNumber(), 3, '0', Justification.RIGHT) +
	                    "D";
	            // setFileNameDescription
	            genObject.getId().setFilenameDescription(filename);
	            
	            DefaultOutputFileEntity defaultEntity = new DefaultOutputFileEntity();
	            
	            defaultEntity.setDestBankID(genObject.getDestBankID());
	            defaultEntity.setOriginBankID(genObject.getOriginBankID());
	            
	            DefaultOutputFileKey defaultFileKey = new DefaultOutputFileKey();
	            defaultFileKey.setDestBankCode(genObject.getId().getDestBankCode());
	            defaultFileKey.setFilenameDescription(genObject.getId().getFilenameDescription());
	            defaultFileKey.setOriginBankCode(genObject.getId().getOriginBankCode());
	            defaultFileKey.setSeqNumber(genObject.getId().getSeqNumber());
	            defaultFileKey.setServiceID(genObject.getId().getServiceID());
	            defaultFileKey.setSubServiceID(genObject.getId().getSubServiceID());
	            defaultEntity.setId(defaultFileKey);
	            
	            defaultList.add(defaultEntity);
	            
	        

	        // save last seq numbers
	        Collection<SeqNumberEntity> seqNumbers
	                        = destBanks.values();
	        if(counter == 1){
	        	new SeqNumbersDAO().insert(seqNumbers);
	        }else{
	        	new SeqNumbersDAO().updateLastSeqNumbers(counter, seqNumberForThisBank.getId().getFilenamePrefix(), seqNumberForThisBank.getId().getDestDistCode());
	        }
	        
	        insertIntoOutputControls(defaultEntity);
	        
	    }
	  
	  public void setSeqNumbersCCR009(DefaultOutputFileEntity genObject,int counter) {
		  
			// Map<SeqNumberKey, SeqNumberEntity> getlastSeqNumber = lastSeqNumberUsed;
		        // group files by destination bank
		    	List<DefaultOutputFileEntity> defaultList = new ArrayList<>();
		        Map<SeqNumberKey, SeqNumberEntity> destBanks = new HashMap<>();
		            // create key
		            SeqNumberKey key
		                    = new SeqNumberKey("CR", genObject.getDestBankID());

		            SeqNumberEntity seqNumberForThisBank = destBanks.get(key);
		            if (seqNumberForThisBank == null) {
		                seqNumberForThisBank = new SeqNumberEntity(key, 0);
		            }

		            // increment seq number
		             seqNumberForThisBank.setSeqNumber(counter);//.incrementSeqNumber();
		            //set seqNumber
		            genObject.getId().setSeqNumber(seqNumberForThisBank.getSeqNumber());
		            destBanks.put(key, seqNumberForThisBank);

		            // construct filename
		            String filename
		                    = "CR" +
		                    		genObject.getDestBankID() +
		                    format("" + seqNumberForThisBank.getSeqNumber(), 3, '0', Justification.RIGHT) +
		                    "D";
		            // setFileNameDescription
		            genObject.getId().setFilenameDescription(filename);
		            
		            DefaultOutputFileEntity defaultEntity = new DefaultOutputFileEntity();
		            
		            defaultEntity.setDestBankID(genObject.getDestBankID());
		            defaultEntity.setOriginBankID(genObject.getOriginBankID());
		            
		            DefaultOutputFileKey defaultFileKey = new DefaultOutputFileKey();
		            defaultFileKey.setDestBankCode(genObject.getId().getDestBankCode());
		            defaultFileKey.setFilenameDescription(genObject.getId().getFilenameDescription());
		            defaultFileKey.setOriginBankCode(genObject.getId().getOriginBankCode());
		            defaultFileKey.setSeqNumber(genObject.getId().getSeqNumber());
		            defaultFileKey.setServiceID(genObject.getId().getServiceID());
		            defaultFileKey.setSubServiceID(genObject.getId().getSubServiceID());
		            defaultEntity.setId(defaultFileKey);
		            
		            defaultList.add(defaultEntity);
		            
		        

		        // save last seq numbers
		        Collection<SeqNumberEntity> seqNumbers
		                        = destBanks.values();
		        if(counter == 1){
		        	new SeqNumbersDAO().insert(seqNumbers);
		        }else{
		        	new SeqNumbersDAO().updateLastSeqNumbers(counter, seqNumberForThisBank.getId().getFilenamePrefix(), seqNumberForThisBank.getId().getDestDistCode());
		        }
		        
		        insertIntoOutputControlsCCR009(defaultEntity);
		        
		    }
	  
	  public void insertIntoOutputControls(DefaultOutputFileEntity outputObject){
		  DefaultOutputFilesDAO defaultOutputFilesDAO = new DefaultOutputFilesDAO();
		  try {
			defaultOutputFilesDAO.createSingleDefaultOutputFiles(outputObject);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
		}
	  }
	  
	  public void insertIntoOutputControlsCCR009(DefaultOutputFileEntity outputObject){
		  DefaultOutputFilesDAO defaultOutputFilesDAO = new DefaultOutputFilesDAO();
		  try {
			defaultOutputFilesDAO.createSingleDefaultOutputFilesCCR009(outputObject);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
		}
	  }
}


