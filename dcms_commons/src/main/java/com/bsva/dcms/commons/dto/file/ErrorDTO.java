package com.bsva.dcms.commons.dto.file;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

public class ErrorDTO {
	
	private Logger log = Logger.getLogger(ErrorDTO.class);
	
	List<ErrorDetailsDTO> errorsList = new ArrayList<>();

	public void addError(int errNo, long recNo, int recID, int fieldNo, String fieldContent, String correctVal) {
		
		ErrorDetailsDTO error = new ErrorDetailsDTO();
        error.setErrorNumber(errNo);
        error.setRecordNo(recNo);
        error.setRecordID(recID);
        error.setFieldNo(fieldNo);
        error.setFieldContent(fieldContent);
        error.setCorrectValue(correctVal);
        
        errorsList.add(error);
        
        log.info("** Added error msg : " + error);
    }
	
	public List<ErrorDetailsDTO> getErrorsList() {
		return errorsList;
	}

	public void setErrorsList(List<ErrorDetailsDTO> errorsList) {
		this.errorsList = errorsList;
	}
	
	 public HashMap<String,String> getNextValidationError(int index) {
	        if (index >= errorsList.size()) {
	            return null;
	        }
	        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
	        DecimalFormat recNoFormat = new DecimalFormat("#####", symbols);
	        ErrorDetailsDTO tempErr = errorsList.get(index);
	        
	        HashMap<String,String> returnHm = new HashMap<String,String>();
	        returnHm.put("errorNo", String.valueOf(tempErr.getErrorNumber()));
	        returnHm.put("recordNo", String.format("%5s",recNoFormat.format(tempErr.getRecordNo())));
	        returnHm.put("recordID", String.format("%02d", tempErr.getRecordID()));
	        returnHm.put("fieldNo", String.valueOf(tempErr.getFieldNo()));
	        returnHm.put("fieldContent", tempErr.getFieldContent());
	        returnHm.put("correctValue", tempErr.getCorrectValue());
	        return returnHm;
	    }
}
