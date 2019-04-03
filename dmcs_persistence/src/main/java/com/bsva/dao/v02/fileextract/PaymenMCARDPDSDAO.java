package com.bsva.dao.v02.fileextract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.dto.FileDetailEntityDTO;
import com.bsva.dto.FileEntityPDSDTO;
import com.bsva.entities.v02.loader.FileDetailEntity;
import com.bsva.entities.v02.loader.FilePDSEntity;

/**
 * TODO Document
 */
public class PaymenMCARDPDSDAO extends AbstractDao<FilePDSEntity, Void> {

	private final static String FILE_DETAIL_SQL_MCARD =
            " SELECT SYSTEM_SEQ_NUMBER ,"+
	        " PDS_NUMBER ,"+
	        " PDS_LENGTH ,"+
	        " PDS_DATA "+
            "  FROM CSO_PAYMENT_MCARD_PDS " +
            " WHERE SYSTEM_SEQ_NUMBER = :sysseqNumber " +
            " ORDER BY SYSTEM_SEQ_NUMBER";

    public FileEntityPDSDTO getFileDetailsFor(String filename,String sysseqNumber) {

    	String switchSubService = FILE_DETAIL_SQL_MCARD;
    	// preparing params
    	Map<String, Object> params = new HashMap<>();
    	params.put("sysseqNumber", sysseqNumber);
    	
    	
        // execute
       FilePDSEntity entities = uniqueResult(switchSubService, params, FilePDSEntity.class);
    	 if(entities == null){
    		 return null;
    	 }else{
    		FileEntityPDSDTO dto = new FileEntityPDSDTO();
    		dto.setSystemSeqNumber(entities.getSystemSeqNumber());
    		dto.setPdsLength(entities.getPdslength());
    		dto.setPdsNumber(entities.getPdsNumber());
    		dto.setPdsData(entities.getPdsData());
    	
            return dto;
    	 }
    }
}
