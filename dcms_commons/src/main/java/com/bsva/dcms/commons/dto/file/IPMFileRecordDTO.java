package com.bsva.dcms.commons.dto.file;

import java.util.Map;

public class IPMFileRecordDTO {

    private String primaryBitMap;
    private String secondaryBitMap;
    private String messageTypeIndicator;
    private int transactionCode = 0;
    private Map<Integer , DataElementDTO> dataElementsMap;
    
    private int lineNumber;
	private int recordOffset = 0; 
	private boolean isCurrentRecordValid = true;
    
	public String getMessageTypeIndicator() {
		return messageTypeIndicator;
	}
	public void setMessageTypeIndicator(String messageTypeIndicator) {
		this.messageTypeIndicator = messageTypeIndicator;
	}
	public String getPrimaryBitMap() {
		return primaryBitMap;
	}
	public void setPrimaryBitMap(String primaryBitMap) {
		this.primaryBitMap = primaryBitMap;
	}
	public String getSecondaryBitMap() {
		return secondaryBitMap;
	}
	public void setSecondaryBitMap(String secondaryBitMap) {
		this.secondaryBitMap = secondaryBitMap;
	}
	public Map<Integer, DataElementDTO> getDataElementsMap() {
		return dataElementsMap;
	}
	public void setDataElementsMap(Map<Integer, DataElementDTO> dataElementsMap) {
		this.dataElementsMap = dataElementsMap;
	}
	public int getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(int transactionCode) {
		this.transactionCode = transactionCode;
	}

	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public int getRecordOffset() {
		return recordOffset;
	}
	public void setRecordOffset(int recordOffset) {
		this.recordOffset = recordOffset;
	}
	public boolean isCurrentRecordValid() {
		return isCurrentRecordValid;
	}
	public void setCurrentRecordValid(boolean isCurrentRecordValid) {
		this.isCurrentRecordValid = isCurrentRecordValid;
	}
	public String toString() {

		 StringBuffer buff = new StringBuffer();
	        buff.append(getMessageTypeIndicator());
	        buff.append(getPrimaryBitMap());
	        buff.append(getSecondaryBitMap());
	        buff.append(getDataElementsMap()); //TODO: this object needs to be broken down further...iterate thru its elements
	        buff.append(getTransactionCode());
	       		
		return buff.toString();
		
		
	}
	
	
}
