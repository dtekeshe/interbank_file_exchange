package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.dao.v02.endofservice.SubServiceStatusDAO;
import com.bsva.dto.OutputFileEntityDTO;
import com.bsva.entities.v02.outputcontrols.OutputFileEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputFileReaderDAO extends AbstractDao<OutputFileEntity, Void> {

	// output files SQL
	private final static String OUTPUT_FILES_SQL =
			" SELECT SERVICE, SUB_SERVICE,FILENAME_PREFIX,DISTRIBUTION_CODE, FILENAME_DESCRIPTION, BANK_CODE,ORIGINATING_MEMBER,                      " +
			"		 FULLFILEIND, RECORD_COUNT, SEQ_NUMBER, HASH_TOTAL_99,                                          " +
			"        STATUS_CODE,LAST_FILE_INDICATOR,DR_VALUE ,RECORD_COUNT_FOR_DAY,DR_VALUE_FOR_DAY                " +
			"   FROM CSO_OUTPUT_CONTROLS                                                                            " +
			"  WHERE STATUS_CODE = 'O'                                                                              " +
			"    AND FULLFILEIND NOT IN ('C', 'D')     															    ";
	           // ( ! isEndOfDay ?
	           //       " AND FULLFILEIND = 'F' " :
	           //       " AND FULLFILEIND IN ('N','F') " );
	private final static String OUTPUT_CONTROL_FILES_SQL =
			" SELECT SERVICE, SUB_SERVICE,FILENAME_PREFIX,DISTRIBUTION_CODE, FILENAME_DESCRIPTION, BANK_CODE,ORIGINATING_MEMBER,                      " +
					"		 FULLFILEIND, RECORD_COUNT, SEQ_NUMBER, HASH_TOTAL_99,                                          " +
					"        STATUS_CODE,LAST_FILE_INDICATOR,DR_VALUE ,RECORD_COUNT_FOR_DAY,DR_VALUE_FOR_DAY                " +
					"   FROM CSO_OUTPUT_CONTROLS                                                                            " +
					"  WHERE SUB_SERVICE = 'VISA CARD' AND LAST_FILE_INDICATOR = 'Y' AND  BANK_CODE =:bankcode						    ";
	
    public List<OutputFileEntityDTO> getOutputFiles() {

    	// is it end of day?
    	// boolean isEndOfDay = new EndOfDayCheckerDAO().isEndOfDay();

        // execute
        List<OutputFileEntity> entities = list(OUTPUT_FILES_SQL, OutputFileEntity.class);

        List<OutputFileEntityDTO> outputList = new ArrayList<>();
		
      if(entities.size() > 0){
		for ( OutputFileEntity outputFileEntity : entities ) {

            // get status for this sub service
            String subServiceID = outputFileEntity.getId().getSubService();
            String subServiceStatus
                    = new SubServiceStatusDAO().status(subServiceID, "O");
            String fullFileInd = outputFileEntity.getFullFileIndicator();

            switch (subServiceStatus) {
                // during the day
                case "Y":
                    // extract full files only
                    if (! "F".equals(fullFileInd) ) {
                        continue;
                    }
                	
                    break;
                // during the day
                case "C":
                    // sub service is closing. don't do anything
                    // TODO SPOLOG Warning
                    continue;
                // end of service routing has requested extract of partial files
                case "P":
                    // REQUEST CLOSE
                    // extract full and partial files
                    if ( ! ( "F".equals(fullFileInd) || "N".equals(fullFileInd) ) ) {
                        continue;
                    }
                    break;
                case "N":
                    // sub service is closed. don't do anything
                    // TODO SPOLOG Warning
                    continue;
                default:
                    // unknown status. ignore record
                    // TODO SPOLOG Warning
                    continue;
            }
            OutputFileEntityDTO outputFileEntityDTO = new OutputFileEntityDTO();
			outputFileEntityDTO.setBankCode(outputFileEntity.getBankCode());
			outputFileEntityDTO.setFileNameDescription(outputFileEntity.getId().getFileNameDescription());
			outputFileEntityDTO.setFullFileIndicator(outputFileEntity.getFullFileIndicator());
			outputFileEntityDTO.setDistributionCode(outputFileEntity.getDistributionCode());
			outputFileEntityDTO.setFileNamePrefix(outputFileEntity.getFilenamePrefix());
			outputFileEntityDTO.setHashTotal(outputFileEntity.getHashTotal());
			outputFileEntityDTO.setOriginatingBank(outputFileEntity.getOriginatingMember());
			outputFileEntityDTO.setRecordCount(outputFileEntity.getRecordCount());
			outputFileEntityDTO.setService(outputFileEntity.getId().getService());
			outputFileEntityDTO.setStatusCode(outputFileEntity.getStatusCode());
			outputFileEntityDTO.setSubService(outputFileEntity.getId().getSubService());
			outputFileEntityDTO.setLasteFileIndicator(outputFileEntity.getLasteFileIndicator());
			outputFileEntityDTO.setSeqNumber(outputFileEntity.getSeqNumber());
			outputFileEntityDTO.setDrValue(outputFileEntity.getDrvalue());
			if(outputFileEntity.getRecordCountForDay()!= null){
			outputFileEntityDTO.setRecordCountForDay(outputFileEntity.getRecordCountForDay());
			}
			if(outputFileEntity.getDrValueForDay()!= null){
			outputFileEntityDTO.setDrValueForDay(outputFileEntity.getDrValueForDay());
			}
			outputList.add(outputFileEntityDTO);
		 }
       }

        return outputList;
      }
    
    public List<OutputFileEntityDTO> getOutputFilesNeg(String bankcode) {

    	// preparing params
    	Map<String, Object> params = new HashMap<>();
    	params.put("bankcode", bankcode);  
        // execute
        List<OutputFileEntity> entities = list(OUTPUT_CONTROL_FILES_SQL,params, OutputFileEntity.class);

        List<OutputFileEntityDTO> outputList = new ArrayList<>();
		
      if(entities.size() > 0){
		for ( OutputFileEntity outputFileEntity : entities ) {

           
			OutputFileEntityDTO outputFileEntityDTO = new OutputFileEntityDTO();
			outputFileEntityDTO.setBankCode(outputFileEntity.getBankCode());
			outputFileEntityDTO.setFileNamePrefix(outputFileEntity.getFilenamePrefix());
			outputFileEntityDTO.setDistributionCode(outputFileEntity.getDistributionCode());
			outputFileEntityDTO.setFileNameDescription(outputFileEntity.getId().getFileNameDescription());
			outputFileEntityDTO.setFullFileIndicator(outputFileEntity.getFullFileIndicator());
			outputFileEntityDTO.setHashTotal(outputFileEntity.getHashTotal());
			outputFileEntityDTO.setOriginatingBank(outputFileEntity.getOriginatingMember());
			outputFileEntityDTO.setRecordCount(outputFileEntity.getRecordCount());
			outputFileEntityDTO.setService(outputFileEntity.getId().getService());
			outputFileEntityDTO.setStatusCode(outputFileEntity.getStatusCode());
			outputFileEntityDTO.setSubService(outputFileEntity.getId().getSubService());
			outputFileEntityDTO.setLasteFileIndicator(outputFileEntity.getLasteFileIndicator());
			outputFileEntityDTO.setSeqNumber(outputFileEntity.getSeqNumber());
			outputFileEntityDTO.setDrValue(outputFileEntity.getDrvalue());;
			outputList.add(outputFileEntityDTO);
		 }
       }

        return outputList;
      }
    
}
