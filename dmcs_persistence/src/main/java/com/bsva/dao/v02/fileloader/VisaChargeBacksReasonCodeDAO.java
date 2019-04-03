package com.bsva.dao.v02.fileloader;

import java.util.List;
import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.loader.VisaChargeBacksEntity;

public class VisaChargeBacksReasonCodeDAO extends AbstractDao<VisaChargeBacksEntity,Void> {
	
	  private final static String REASON_CODE_SQL =

	            "       SELECT REASON_CODE                  " +
	            "         FROM CSF_CHGBACK_RSN_CODES_VISA   " ;

	    public List<VisaChargeBacksEntity> getReasonCodes() {
	        // execute
	        List<VisaChargeBacksEntity> entities
	                = list(REASON_CODE_SQL,VisaChargeBacksEntity.class);
	        //Return Reason Codes
	        return entities;
	    }

}
