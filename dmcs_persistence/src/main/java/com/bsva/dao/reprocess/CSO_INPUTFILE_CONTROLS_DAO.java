package com.bsva.dao.reprocess;

import java.util.ArrayList;
import java.util.List;

import com.bsva.dao.AbstractDao;

public class CSO_INPUTFILE_CONTROLS_DAO 
extends AbstractDao<CsoInputFileEntity, Void> {
	
	  private final static String INPUT_FILE_CONTROL_SQL = 
	            "  SELECT FILE_REF_NUMBER ,OUTPUT_DATE,NUMBER_OF_RECS,NUMBER_CREDITS,NUMBER_DEBITS,CREDIT_VALUE, "
	           + "	DEBIT_VALUE,PROCESS_STATUS,ORIGINATING_MEMBER, SYSTEM_SEQ_NUMBER ,ODS_DATA_STATUS,NUMBER_OF_REJECTS,NEGATIVE_DUPLICATE_COUNT,NEGATIVE_CARD_COUNT "
	           + " FROM CSO_INPUT_FILE_CONTROLS ";

	    public List<CsoInputFileEntity> getData() {
	       // Map<String,Object> params = new HashMap<String, Object>();
	        //params.put("subServices", subServices);
	        //params.put("processStatus", processStatus);
	        // prepare params
	        // execute
	        List<CsoInputFileEntity> entities
	                = list(INPUT_FILE_CONTROL_SQL,CsoInputFileEntity.class);

	        // prepare result
	        //Map<String, CsoInputFileControls> addresses = new HashMap<>();
	        List<CsoInputFileEntity> listData = new ArrayList<CsoInputFileEntity>();
	        
	        for (CsoInputFileEntity entity : entities ) {
	        	
	        	listData.add(entity);
	        }

	        return listData;
	    }



}
