package com.bsva.dcms.commons.dto;

import java.io.Serializable;

public class DelDeliveryFilesCCCDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int position;
	private String queueFileName;
	private int prddate;
	private int member;
	private int userDest;
	private String application;
	private String subApplication;
	private String fileName;
	private String lastFile;
	private String xmitInd;
	private String programFrom;
	private int timeCreated;
	private String outputFormat;
	private String backupFormat;
	private String createTrailer;
	private int noOfRecords;
	private int noOfDebits;
	private int noOfCredits;
	private int valueDebits;
	private int valueCredits;
	private int hashTotals;
	private int recLength;
	private int blockFactor;
	private String deliveryStatus;
	private int deliveryTime;
	private String writtenToAxd;
	private String rejectReason;
	private String reportName;
	
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getQueueFileName() {
		return queueFileName;
	}
	public void setQueueFileName(String queueFileName) {
		this.queueFileName = queueFileName;
	}
	public int getPrddate() {
		return prddate;
	}
	public void setPrddate(int prddate) {
		this.prddate = prddate;
	}
	public int getMember() {
		return member;
	}
	public void setMember(int member) {
		this.member = member;
	}
	public int getUserDest() {
		return userDest;
	}
	public void setUserDest(int userDest) {
		this.userDest = userDest;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	public String getSubApplication() {
		return subApplication;
	}
	public void setSubApplication(String subApplication) {
		this.subApplication = subApplication;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getLastFile() {
		return lastFile;
	}
	public void setLastFile(String lastFile) {
		this.lastFile = lastFile;
	}
	public String getXmitInd() {
		return xmitInd;
	}
	public void setXmitInd(String xmitInd) {
		this.xmitInd = xmitInd;
	}
	public String getProgramFrom() {
		return programFrom;
	}
	public void setProgramFrom(String programFrom) {
		this.programFrom = programFrom;
	}
	public int getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(int timeCreated) {
		this.timeCreated = timeCreated;
	}
	public String getOutputFormat() {
		return outputFormat;
	}
	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}
	public String getBackupFormat() {
		return backupFormat;
	}
	public void setBackupFormat(String backupFormat) {
		this.backupFormat = backupFormat;
	}
	public String getCreateTrailer() {
		return createTrailer;
	}
	public void setCreateTrailer(String createTrailer) {
		this.createTrailer = createTrailer;
	}
	public int getNoOfRecords() {
		return noOfRecords;
	}
	public void setNoOfRecords(int noOfRecords) {
		this.noOfRecords = noOfRecords;
	}
	public int getNoOfDebits() {
		return noOfDebits;
	}
	public void setNoOfDebits(int noOfDebits) {
		this.noOfDebits = noOfDebits;
	}
	public int getNoOfCredits() {
		return noOfCredits;
	}
	public void setNoOfCredits(int noOfCredits) {
		this.noOfCredits = noOfCredits;
	}
	public int getValueDebits() {
		return valueDebits;
	}
	public void setValueDebits(int valueDebits) {
		this.valueDebits = valueDebits;
	}
	public int getValueCredits() {
		return valueCredits;
	}
	public void setValueCredits(int valueCredits) {
		this.valueCredits = valueCredits;
	}
	public int getHashTotals() {
		return hashTotals;
	}
	public void setHashTotals(int hashTotals) {
		this.hashTotals = hashTotals;
	}
	public int getRecLength() {
		return recLength;
	}
	public void setRecLength(int recLength) {
		this.recLength = recLength;
	}
	public int getBlockFactor() {
		return blockFactor;
	}
	public void setBlockFactor(int blockFactor) {
		this.blockFactor = blockFactor;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getWrittenToAxd() {
		return writtenToAxd;
	}
	public void setWrittenToAxd(String writtenToAxd) {
		this.writtenToAxd = writtenToAxd;
	}
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	

}
