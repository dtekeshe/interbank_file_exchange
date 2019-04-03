package com.bsva.dao.v02;

import java.util.HashMap;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.endofservice.InputFileControlEntity;

public class InputFileControlDAO extends AbstractDao<InputFileControlEntity,Void> {

    private final static String INPUT_FILES_UPDATE_SQL =
            "  UPDATE CSO_INPUT_FILE_CONTROLS " +
            "  SET PROCESS_STATUS =:processStatus " +
            "  WHERE IS_PRE_EXTRACTED =:preExtracted " ;

    public boolean updateDeliveryFile() {

    	 Map<String, Object> params = new HashMap<>();
    	 
         params.put("processStatus", "C");
         params.put("preExtracted", "Y");
        // execute
        int result = executeUpdate(INPUT_FILES_UPDATE_SQL,params);

        return result > 0;
    }
}
