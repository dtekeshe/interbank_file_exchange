package com.bsva.dao.v02.fileextract;

import com.bsva.dao.AbstractDao;

import java.util.HashMap;
import java.util.Map;

/**
 * Delivered file update
 */
public class PaymentInstructionUpdateDAO extends AbstractDao<Void, Void> {

    public PaymentInstructionUpdateDAO() {
        super();
    }

    private final static String PAYMENT_iNSTRUCTION_VISA_UPDATE_SQL =
            " UPDATE CSO_PAYMENT_INSTRUCTIONS_VISA " +
            "    SET PROCESS_STATUS = :processStatus " +
            "  WHERE FILENAME_DESCRIPTION = :filename ";
    
    private final static String PAYMENT_iNSTRUCTION_MCARD_UPDATE_SQL =
            " UPDATE CSO_PAYMENT_INSTRUCTIONS_MCARD " +
            "    SET PROCESS_STATUS = :processStatus " +
            "  WHERE  FILENAME_DESCRIPTION = :filename ";

    public boolean updateDeliveryFile(String filename, String processStatus,String subService) {

    	int result = 0;
        Map<String, Object> params = new HashMap<>();
        params.put("filename", filename);
        params.put("processStatus", processStatus);

        if(subService.equals("MASTERCARD")){
        	result = executeUpdate(PAYMENT_iNSTRUCTION_MCARD_UPDATE_SQL, params);
        }else{
        	result = executeUpdate(PAYMENT_iNSTRUCTION_VISA_UPDATE_SQL, params);
        }

        return result > 0;
    }
}
