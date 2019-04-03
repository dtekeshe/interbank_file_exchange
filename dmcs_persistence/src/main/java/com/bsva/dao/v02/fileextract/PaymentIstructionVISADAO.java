package com.bsva.dao.v02.fileextract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.dto.FileDetailEntityDTO;
import com.bsva.entities.v02.loader.FileDetailEntity;

/**
 * TODO Document
 */
public class PaymentIstructionVISADAO extends AbstractDao<FileDetailEntity, Void> {

	private final static String FILE_DETAIL_SQL =
            " SELECT CARD_TRANSACTION ," +
	        "FILE_REF_NUMBER , INPUT_SEQ_NUMBER" +
            "  FROM CSO_PAYMENT_INSTRUCTIONS_VISA " +
            " WHERE FILENAME_DESCRIPTION = :filename " +
            " ORDER BY SYSTEM_GEN_SEQ_NUMBER,INPUT_SEQ_NUMBER";
	
	private final static String FILE_DETAIL_SQL_MCARD =
            " SELECT CARD_TRANSACTION ," +
	        "FILE_REF_NUMBER" +
            "  FROM CSO_PAYMENT_INSTRUCTIONS_MCARD " +
            " WHERE FILENAME_DESCRIPTION = :filename " +
            " ORDER BY SYSTEM_SEQ_NUMBER";

    public List<FileDetailEntityDTO> getFileDetailsFor(String filename,String subService) {

    	String switchSubService = null;
    	// preparing params
    	Map<String, Object> params = new HashMap<>();
    	params.put("filename", filename);
    	if(subService.equals("MASTERCARD")){
    		switchSubService = FILE_DETAIL_SQL_MCARD;
    	}else{
    		switchSubService = FILE_DETAIL_SQL;
    	}
    	
        // execute
    	List<FileDetailEntity> entities
                = list(switchSubService, params, FileDetailEntity.class);
    	
    	// preparing result
    	List<FileDetailEntityDTO> result = new ArrayList<>();
    	for (FileDetailEntity entity : entities) {
			FileDetailEntityDTO dto = new FileDetailEntityDTO();
    		dto.setCardRefNumber(entity.getCardRefNumber());
    		dto.setCardTransaction(entity.getCardTransaction());
    		result.add(dto);
    	}
    	
        return result;
    }
}
