package com.bsva.dcms.commons.dto.file;

public class ErrorDetailsDTO {
	
	private int errorNumber;
	private long recordNo;
	private int recordID;
	private int fieldNo;
	private String fieldContent;
	private String correctValue;
	
	public int getErrorNumber() {
		return errorNumber;
	}
	public void setErrorNumber(int errorNumber) {
		this.errorNumber = errorNumber;
	}
	public long getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(long recordNo) {
		this.recordNo = recordNo;
	}
	public int getRecordID() {
		return recordID;
	}
	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}
	public int getFieldNo() {
		return fieldNo;
	}
	public void setFieldNo(int fieldNo) {
		this.fieldNo = fieldNo;
	}
	public String getFieldContent() {
		return fieldContent;
	}
	public void setFieldContent(String fieldContent) {
		this.fieldContent = fieldContent;
	}
	public String getCorrectValue() {
		return correctValue;
	}
	public void setCorrectValue(String correctValue) {
		this.correctValue = correctValue;
	}
	
	@Override
	public String toString(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("errorNo - " +  errorNumber + ",");
		buffer.append("recordNo - " + recordNo + ",");
		buffer.append("recordID - " +  recordID + ",");
		buffer.append("fieldNo - " +  fieldNo + ",");
		buffer.append("fieldContent - " +  correctValue);
		return buffer.toString();
	}

	
}
