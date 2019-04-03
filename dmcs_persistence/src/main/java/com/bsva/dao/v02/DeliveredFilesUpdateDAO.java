package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;

import java.util.HashMap;
import java.util.Map;

/**
 * Delivered file update
 */
public class DeliveredFilesUpdateDAO extends AbstractDao<Void, Void> {

    public DeliveredFilesUpdateDAO() {
        super();
    }

    private final static String DELIVERED_FILES_UPDATE_SQL =
            " UPDATE DEL_DELIVERY_FILES_CCC " +
            "    SET XMIT_IND = :processStatus " +
            "  WHERE QUEUE_FILE_NAME = 'INQUE' " +
            "    AND FILENAME = :filename ";

    public boolean updateDeliveryFile(String filename, String processStatus) {

        Map<String, Object> params = new HashMap<>();
        params.put("filename", filename);
        params.put("processStatus", processStatus);

        // execute
        int result = executeUpdate(DELIVERED_FILES_UPDATE_SQL, params);

        return result > 0;
    }
}
