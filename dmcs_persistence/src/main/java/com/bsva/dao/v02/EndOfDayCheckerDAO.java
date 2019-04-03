package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.commons.EndOfDayFlagEntity;

public class EndOfDayCheckerDAO extends AbstractDao<EndOfDayFlagEntity, Void> {

	private final static String END_OF_DAY_CHECK_SQL =
			" SELECT COUNT(*) AS END_OF_DAY_FLAG " +
			"   FROM CSO_SCHEDULED_PROCESSES " +
			"  WHERE PROCESS_NAME = 'EOD' " +
			"    AND ACTIVE_IND = 'Y' ";
	
	public Boolean isEndOfDay() {
	    
		EndOfDayFlagEntity entity 
				= uniqueResult(END_OF_DAY_CHECK_SQL,  EndOfDayFlagEntity.class);
		
	    boolean isEndOfDay = entity.getEndOfDayFlag() > 0;
	    
	    return isEndOfDay;
	}
}
