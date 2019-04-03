package com.bsva.dao.v02.members;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.CsoInputFileControls;
import com.bsva.entities.v02.billing.InputFileControlSummaryEntity;

public class InputFileControlDAO extends AbstractDao<InputFileControlSummaryEntity, Void> {
    
    private final static String INPUT_FILE_CONTROL_SQL = 
            "  SELECT SUM(CREDIT_VALUE + DEBIT_VALUE)AS AMOUNT ,SUM(NUMBER_OF_RECS) AS COUNT "
           + " FROM CSO_INPUT_FILE_CONTROLS"
           + " WHERE SUB_SERVICE =:subServices AND PROCESS_STATUS NOT IN ('R')";

    public List<InputFileControlSummaryEntity> getSubServices(String subServices) {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("subServices", subServices);
        // prepare params
        // execute
        List<InputFileControlSummaryEntity> entities
                = list(INPUT_FILE_CONTROL_SQL,params,InputFileControlSummaryEntity.class);

        // prepare result
        //Map<String, CsoInputFileControls> addresses = new HashMap<>();
        List<InputFileControlSummaryEntity> listData = new ArrayList<InputFileControlSummaryEntity>();
        
        for (InputFileControlSummaryEntity entity : entities ) {
        	
        	listData.add(entity);
        }

        return listData;
    }
}
