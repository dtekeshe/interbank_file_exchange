package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;

import java.util.HashMap;
import java.util.Map;

/**
 * Delivered file update
 */
public class OutputControlExtractUpdateDAO extends AbstractDao<Void, Void> {

    public OutputControlExtractUpdateDAO() {
        super();
    }

    private final static String CSO_OUTPUT_CONTROLS =
            " UPDATE CSO_OUTPUT_CONTROLS " +
            "  SET STATUS_CODE = :statuscode ," +
            "  FULLFILEIND = :fullfileind " +
            "  WHERE FILENAME_DESCRIPTION = :filename ";

    public boolean updateDeliveryFile(String filename, String statuscode,String fullfileind) {

    	int result = 0;
        Map<String, Object> params = new HashMap<>();
        params.put("filename", filename);
        params.put("statuscode", statuscode);
        params.put("fullfileind", fullfileind);

        result = executeUpdate(CSO_OUTPUT_CONTROLS, params);

        return result > 0;
    }
}
