package com.bsva.dcms.commons.dto;


public class CsoSpologDTO {
	
	private long processNameSeq;
	private String processName;
	private String version;
	private long messageSeq;
	private String message;
	
	
	public CsoSpologDTO() {
	}
	
	public long getProcessNameSeq() {
		return processNameSeq;
	}
	public String getProcessName() {
		return processName;
	}
	public String getVersion() {
		return version;
	}
	public long getMessageSeq() {
		return messageSeq;
	}
	public String getMessage() {
		return message;
	}
	public void setProcessNameSeq(long processNameSeq) {
		this.processNameSeq = processNameSeq;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setMessageSeq(long messageSeq) {
		this.messageSeq = messageSeq;
	}
	public void setMessage(String message) {
		this.message = message;
	}


}
