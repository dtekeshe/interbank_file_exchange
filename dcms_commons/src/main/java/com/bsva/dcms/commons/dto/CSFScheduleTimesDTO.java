package com.bsva.dcms.commons.dto;

import java.io.Serializable;
import java.util.Date;

public class CSFScheduleTimesDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String process;
	private String service;
	private String subService;
	private String startTime;
	private String endTime;
	private String lastRunTime;
	private String activeInd;
	private String busyInd;
	private String checkPoint;
	private String checkPointName;
	private String processDate;
	

	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getSubService() {
		return subService;
	}
	public void setSubService(String subService) {
		this.subService = subService;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getLastRunTime() {
		return lastRunTime;
	}
	public void setLastRunTime(String lastRunTime) {
		this.lastRunTime = lastRunTime;
	}
	public String getActiveInd() {
		return activeInd;
	}
	public void setActiveInd(String activeInd) {
		this.activeInd = activeInd;
	}
	public String getBusyInd() {
		return busyInd;
	}
	public void setBusyInd(String busyInd) {
		this.busyInd = busyInd;
	}
	public String getCheckPoint() {
		return checkPoint;
	}
	public void setCheckPoint(String checkPoint) {
		this.checkPoint = checkPoint;
	}
	public String getCheckPointName() {
		return checkPointName;
	}
	public void setCheckPointName(String checkPointName) {
		this.checkPointName = checkPointName;
	}
	public String getProcessDate() {
		return processDate;
	}
	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}

}
