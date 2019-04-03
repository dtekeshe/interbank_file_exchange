package com.bsva.dao.v02.members;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.members.OutputControllerEntity;

public class OutputControlDAO extends AbstractDao<OutputControllerEntity, Void>{
	
	private final static String FETCH_OUTPUT_CONTROL_SQL = "SELECT BANK_CODE,FILENAME_DESCRIPTION,SERVICE,SUB_SERVICE,"
			+ " DISTRIBUTION_CODE,FILENAME_PREFIX,FULLFILEIND ,CR_VOLUME,CR_VALUE,DR_VOLUME, DR_VALUE ,RECORD_COUNT"
			+ " , SEQ_NUMBER, ORIGINATING_MEMBER ,ORIGINATING_MEMBER FROM CSO_OUTPUT_CONTROLS "
			+ " WHERE SERVICE = :service and SUB_SERVICE = :subService "+
	" AND DISTRIBUTION_CODE = :distributionCode AND FILENAME_PREFIX = :fileNamePrefix "+
	 "  AND LAST_FILE_INDICATOR = 'Y' ";
	
	
	public List<OutputControllerEntity>  getData(String service,String subService,String distributionCode,String fileNamePrefix){
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("service", service);
		params.put("subService", subService);
		params.put("distributionCode", distributionCode);
		params.put("fileNamePrefix", fileNamePrefix);
		//params.put("", value);
		List<OutputControllerEntity> entities 
		= list(FETCH_OUTPUT_CONTROL_SQL,params, OutputControllerEntity.class);
		
		return entities;
	}

	

}
