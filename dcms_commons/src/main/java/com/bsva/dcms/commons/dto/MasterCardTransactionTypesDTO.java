package com.bsva.dcms.commons.dto;

public class MasterCardTransactionTypesDTO {
	
	//TODO: this should possibly be moved to a table
	
	private int messageTypeIdentifier;
	private int transactionCode;
	private String functionCode;
	
	public int getMessageTypeIdentifier() {
		return messageTypeIdentifier;
	}
	public void setMessageTypeIdentifier(int messageTypeIdentifier) {
		this.messageTypeIdentifier = messageTypeIdentifier;
	}
	public int getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(int transactionCode) {
		this.transactionCode = transactionCode;
	}
	public String getFunctionCode() {
		return functionCode;
	}
	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}
	
	
	

}
