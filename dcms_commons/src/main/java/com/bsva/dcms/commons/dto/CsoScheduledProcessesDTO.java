package com.bsva.dcms.commons.dto;

import java.util.Date;

public class CsoScheduledProcessesDTO {

	private String processName;
	private long processFrequency;
	private String classPath;
	private String activeIndicator;
	
	
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public long getProcessFrequency() {
		return processFrequency;
	}
	public void setProcessFrequency(long processFrequency) {
		this.processFrequency = processFrequency;
	}
	public String getClassPath() {
		return classPath;
	}
	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}
	public String getActiveIndicator() {
		return activeIndicator;
	}
	public void setActiveIndicator(String activeIndicator) {
		this.activeIndicator = activeIndicator;
	}
	
	
}
