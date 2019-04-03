package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;

import java.util.HashMap;
import java.util.Map;

/**
 * Delivered file update
 */
public class CsoTransactionUpdateDAO extends AbstractDao<Void, Void> {

    public CsoTransactionUpdateDAO() {
        super();
    }

    private final static String CSO_TRANSACTION_UPDATE_SQL =
            " UPDATE CSO_TRANSACTIONS " +
            "    SET PROCESS_STATUS = :processStatus " +
            "  WHERE OUTPUT_FILENAME = :filename ";
    

    public boolean updateDeliveryFile(String filename, String processStatus) {

    	int result = 0;
        Map<String, Object> params = new HashMap<>();
        params.put("filename", filename);
        params.put("processStatus", processStatus);

        result = executeUpdate(CSO_TRANSACTION_UPDATE_SQL, params);
       

        return result > 0;
    }
}
