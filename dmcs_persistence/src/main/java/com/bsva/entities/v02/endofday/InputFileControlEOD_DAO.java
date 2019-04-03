package com.bsva.entities.v02.endofday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.endofservice.InputFileControlEntity;

public class InputFileControlEOD_DAO extends AbstractDao<InputFileControlEntity, Void> {
	
	  private final static String INPUT_FILE_CONTROL_SQL = 
	            "  SELECT FILE_REF_NUMBER ,SYSTEM_SEQ_NUMBER ,PROCESS_STATUS"
	           + " FROM CSO_INPUT_FILE_CONTROLS WHERE SUB_SERVICE =:subServices AND PROCESS_STATUS =:processStatus";

	    public List<InputFileControlEntity> getProcessStatus(String subServices,String processStatus) {
	        Map<String,Object> params = new HashMap<String, Object>();
	        params.put("subServices", subServices);
	        params.put("processStatus", processStatus);
	        // prepare params
	        // execute
	        List<InputFileControlEntity> entities
	                = list(INPUT_FILE_CONTROL_SQL,params,InputFileControlEntity.class);

	        // prepare result
	        //Map<String, CsoInputFileControls> addresses = new HashMap<>();
	        List<InputFileControlEntity> listData = new ArrayList<InputFileControlEntity>();
	        
	        for (InputFileControlEntity entity : entities ) {
	        	
	        	listData.add(entity);
	        }

	        return listData;
	    }

}
