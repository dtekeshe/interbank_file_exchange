package com.bsva.dcms.commons.dto;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoInputFileControlsDTO implements java.io.Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileRefNumber;
	private Date outputDate;
	private String service;
	private String subService;
	private int numberOfRecs;
	private int numberCredits;
	private int numberDebits;
	private double creditValue;
	private double debitValue;
	private long hashTotal;
	private String lastFileIndicator;
	private String processStatus;
	private int extractedCount;
	private int extCredits;
	private int extDebits;
	private double extCreditValue;
	private double extDebitValue;
	private Date lastProcessDate;
	private Date nextOutputDate;
	private int settlementCount;
	private Date loadDate;
	private int originatingMember;
	private int negativeCardCount;
	private int negativeDuplicateCount;
	private int lastCommitedRecordPointer;
	private String excepRepProducedInd;
	private String errorFilename;
	private long systemSeqNumber;
	private String odsDataStatus;
	private String preExtracted;
	private String billed;
	private String numberOfRejects;


	public String getPreExtracted() {
		return preExtracted;
	}

	public String getBilled() {
		return billed;
	}

	public void setPreExtracted(String preExtracted) {
		this.preExtracted = preExtracted;
	}

	public void setBilled(String billed) {
		this.billed = billed;
	}

	public String getFileRefNumber() {
		return this.fileRefNumber;
	}

	public void setFileRefNumber(String fileRefNumber) {
		this.fileRefNumber=fileRefNumber;
	}

	public Date getOutputDate() {
		return this.outputDate;
	}

	public void setOutputDate(Date outputDate) {
		this.outputDate=outputDate;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service=service;
	}

	public String getSubService() {
		return this.subService;
	}

	public void setSubService(String subService) {
		this.subService=subService;
	}

	public int getNumberOfRecs() {
		return this.numberOfRecs;
	}

	public void setNumberOfRecs(int numberOfRecs) {
		this.numberOfRecs=numberOfRecs;
	}

	public int getNumberCredits() {
		return this.numberCredits;
	}

	public void setNumberCredits(int numberCredits) {
		this.numberCredits=numberCredits;
	}

	public int getNumberDebits() {
		return this.numberDebits;
	}

	public void setNumberDebits(int numberDebits) {
		this.numberDebits=numberDebits;
	}

	public double getCreditValue() {
		return this.creditValue;
	}

	public void setCreditValue(double creditValue) {
		this.creditValue=creditValue;
	}

	public double getDebitValue() {
		return this.debitValue;
	}

	public void setDebitValue(double debitValue) {
		this.debitValue=debitValue;
	}

	public long getHashTotal() {
		return this.hashTotal;
	}

	public void setHashTotal(long hashTotal) {
		this.hashTotal=hashTotal;
	}

	public String getLastFileIndicator() {
		return this.lastFileIndicator;
	}

	public void setLastFileIndicator(String lastFileIndicator) {
		this.lastFileIndicator=lastFileIndicator;
	}

	public String getProcessStatus() {
		return this.processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus=processStatus;
	}

	public int getExtractedCount() {
		return this.extractedCount;
	}

	public void setExtractedCount(int extractedCount) {
		this.extractedCount=extractedCount;
	}

	public int getExtCredits() {
		return this.extCredits;
	}

	public void setExtCredits(int extCredits) {
		this.extCredits=extCredits;
	}

	public int getExtDebits() {
		return this.extDebits;
	}

	public void setExtDebits(int extDebits) {
		this.extDebits=extDebits;
	}

	public double getExtCreditValue() {
		return this.extCreditValue;
	}

	public void setExtCreditValue(double extCreditValue) {
		this.extCreditValue=extCreditValue;
	}

	public double getExtDebitValue() {
		return this.extDebitValue;
	}

	public void setExtDebitValue(double extDebitValue) {
		this.extDebitValue=extDebitValue;
	}

	public Date getLastProcessDate() {
		return this.lastProcessDate;
	}

	public void setLastProcessDate(Date lastProcessDate) {
		this.lastProcessDate=lastProcessDate;
	}

	public Date getNextOutputDate() {
		return this.nextOutputDate;
	}

	public void setNextOutputDate(Date nextOutputDate) {
		this.nextOutputDate=nextOutputDate;
	}

	public int getSettlementCount() {
		return this.settlementCount;
	}

	public void setSettlementCount(int settlementCount) {
		this.settlementCount=settlementCount;
	}

	public Date getLoadDate() {
		return this.loadDate;
	}

	public void setLoadDate(Date loadDate) {
		this.loadDate=loadDate;
	}

	public int getOriginatingMember() {
		return this.originatingMember;
	}

	public void setOriginatingMember(int originatingMember) {
		this.originatingMember=originatingMember;
	}

	public int getNegativeCardCount() {
		return this.negativeCardCount;
	}

	public void setNegativeCardCount(int negativeCardCount) {
		this.negativeCardCount=negativeCardCount;
	}

	public int getNegativeDuplicateCount() {
		return this.negativeDuplicateCount;
	}

	public void setNegativeDuplicateCount(int negativeDuplicateCount) {
		this.negativeDuplicateCount=negativeDuplicateCount;
	}

	public int getLastCommitedRecordPointer() {
		return this.lastCommitedRecordPointer;
	}

	public void setLastCommitedRecordPointer(int lastCommitedRecordPointer) {
		this.lastCommitedRecordPointer=lastCommitedRecordPointer;
	}

	public String getExcepRepProducedInd() {
		return this.excepRepProducedInd;
	}

	public void setExcepRepProducedInd(String excepRepProducedInd) {
		this.excepRepProducedInd=excepRepProducedInd;
	}

	public String getErrorFilename() {
		return this.errorFilename;
	}

	public void setErrorFilename(String errorFilename) {
		this.errorFilename=errorFilename;
	}

	public long getSystemSeqNumber() {
		return this.systemSeqNumber;
	}

	public void setSystemSeqNumber(long systemSeqNumber) {
		this.systemSeqNumber=systemSeqNumber;
	}

	public String getOdsDataStatus() {
		return this.odsDataStatus;
	}

	public void setOdsDataStatus(String odsDataStatus) {
		this.odsDataStatus=odsDataStatus;
	}
	public void setNumberOfRejects(String numberOfRejects) {
		this.numberOfRejects = numberOfRejects;
	}
	public String getNumberOfRejects() {
		return numberOfRejects;
	}


	/* Creates and returns a copy of this object. */
	public Object clone() {
		CsoInputFileControlsDTO bean = new CsoInputFileControlsDTO();
		bean.fileRefNumber = this.fileRefNumber;
		bean.outputDate = this.outputDate;
		bean.service = this.service;
		bean.subService = this.subService;
		bean.numberOfRecs = this.numberOfRecs;
		bean.numberCredits = this.numberCredits;
		bean.numberDebits = this.numberDebits;
		bean.creditValue = this.creditValue;
		bean.debitValue = this.debitValue;
		bean.hashTotal = this.hashTotal;
		bean.lastFileIndicator = this.lastFileIndicator;
		bean.processStatus = this.processStatus;
		bean.extractedCount = this.extractedCount;
		bean.extCredits = this.extCredits;
		bean.extDebits = this.extDebits;
		bean.extCreditValue = this.extCreditValue;
		bean.extDebitValue = this.extDebitValue;
		bean.lastProcessDate = this.lastProcessDate;
		bean.nextOutputDate = this.nextOutputDate;
		bean.settlementCount = this.settlementCount;
		bean.loadDate = this.loadDate;
		bean.originatingMember = this.originatingMember;
		bean.negativeCardCount = this.negativeCardCount;
		bean.negativeDuplicateCount = this.negativeDuplicateCount;
		bean.lastCommitedRecordPointer = this.lastCommitedRecordPointer;
		bean.excepRepProducedInd = this.excepRepProducedInd;
		bean.errorFilename = this.errorFilename;
		bean.systemSeqNumber = this.systemSeqNumber;
		bean.odsDataStatus = this.odsDataStatus;
		bean.billed = this.billed;
		bean.preExtracted = this.preExtracted;
		bean.numberOfRejects = this.numberOfRejects;
		return bean;
	}
	/* Returns a string representation of the object. */
	public String toString() {
		String sep = "\r\n";
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName()).append(sep);
		sb.append("[").append("this.fileRefNumber").append(" = ").append(this.fileRefNumber).append("]").append(sep);
		sb.append("[").append("this.outputDate").append(" = ").append(this.outputDate).append("]").append(sep);
		sb.append("[").append("this.service").append(" = ").append(this.service).append("]").append(sep);
		sb.append("[").append("this.subService").append(" = ").append(this.subService).append("]").append(sep);
		sb.append("[").append("this.numberOfRecs").append(" = ").append(this.numberOfRecs).append("]").append(sep);
		sb.append("[").append("this.numberCredits").append(" = ").append(this.numberCredits).append("]").append(sep);
		sb.append("[").append("this.numberDebits").append(" = ").append(this.numberDebits).append("]").append(sep);
		sb.append("[").append("this.creditValue").append(" = ").append(this.creditValue).append("]").append(sep);
		sb.append("[").append("this.debitValue").append(" = ").append(this.debitValue).append("]").append(sep);
		sb.append("[").append("this.hashTotal").append(" = ").append(this.hashTotal).append("]").append(sep);
		sb.append("[").append("this.lastFileIndicator").append(" = ").append(this.lastFileIndicator).append("]").append(sep);
		sb.append("[").append("this.processStatus").append(" = ").append(this.processStatus).append("]").append(sep);
		sb.append("[").append("this.extractedCount").append(" = ").append(this.extractedCount).append("]").append(sep);
		sb.append("[").append("this.extCredits").append(" = ").append(this.extCredits).append("]").append(sep);
		sb.append("[").append("this.extDebits").append(" = ").append(this.extDebits).append("]").append(sep);
		sb.append("[").append("this.extCreditValue").append(" = ").append(this.extCreditValue).append("]").append(sep);
		sb.append("[").append("this.extDebitValue").append(" = ").append(this.extDebitValue).append("]").append(sep);
		sb.append("[").append("this.lastProcessDate").append(" = ").append(this.lastProcessDate).append("]").append(sep);
		sb.append("[").append("this.nextOutputDate").append(" = ").append(this.nextOutputDate).append("]").append(sep);
		sb.append("[").append("this.settlementCount").append(" = ").append(this.settlementCount).append("]").append(sep);
		sb.append("[").append("this.loadDate").append(" = ").append(this.loadDate).append("]").append(sep);
		sb.append("[").append("this.originatingMember").append(" = ").append(this.originatingMember).append("]").append(sep);
		sb.append("[").append("this.negativeCardCount").append(" = ").append(this.negativeCardCount).append("]").append(sep);
		sb.append("[").append("this.negativeDuplicateCount").append(" = ").append(this.negativeDuplicateCount).append("]").append(sep);
		sb.append("[").append("this.lastCommitedRecordPointer").append(" = ").append(this.lastCommitedRecordPointer).append("]").append(sep);
		sb.append("[").append("this.excepRepProducedInd").append(" = ").append(this.excepRepProducedInd).append("]").append(sep);
		sb.append("[").append("this.errorFilename").append(" = ").append(this.errorFilename).append("]").append(sep);
		sb.append("[").append("this.systemSeqNumber").append(" = ").append(this.systemSeqNumber).append("]").append(sep);
		sb.append("[").append("this.odsDataStatus").append(" = ").append(this.odsDataStatus).append("]").append(sep);
		sb.append("[").append("this.billed").append(" = ").append(this.billed).append("]").append(sep);
		sb.append("[").append("this.preExtracted").append(" = ").append(this.preExtracted).append("]").append(sep);
		sb.append("[").append("this.numberOfRejects").append(" = ").append(this.numberOfRejects).append("]").append(sep);
		return sb.toString();
	}
}
