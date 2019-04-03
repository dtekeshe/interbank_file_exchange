package com.bsva.dcms.commons.dto;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class HsoInputFileControlsDTO implements Serializable{
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
}
