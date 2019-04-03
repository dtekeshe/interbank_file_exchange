package com.bsva.dao.v02.fileextract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.loader.FileDetailEntity;


/**
 * @author AugustineA
 *
 */
public class PaymentIstructionMCARDDAO extends AbstractDao<FileDetailEntity, Void> {

	private final static String FILE_DETAIL_SQL =
            " SELECT CARD_TRANSACTION " +
            "  FROM CSO_PAYMENT_INSTRUCTIONS_MCARD " +
            " WHERE FILENAME_DESCRIPTION = :filename " +
            " ORDER BY SYSTEM_SEQ_NUMBER2";

    public List<String> getFileDetailsFor(String filename) {

    	// preparing params
    	Map<String, Object> params = new HashMap<>();
    	params.put("filename", filename);
    	
        // execute
    	List<FileDetailEntity> entities
                = list(FILE_DETAIL_SQL, params, FileDetailEntity.class);
    	
    	// preparing result
    	List<String> result = new ArrayList<>();
    	for (FileDetailEntity entity : entities) {
    		result.add(entity.getCardTransaction());
    	}
    	
        return result;
    }
}
