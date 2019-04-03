package com.bsva.dcms.commons.dto;
import java.io.Serializable;
import java.util.Date;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoZ1Z9InputOutputsDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String filenameDescription;
	private long oraSeqNumber;
	private String service;
	private String subService;
	private String inputOutputIndicator;
	private String lastFileIndicator;
	private String transmitIndicator;
	private int destination;
	private long numberOfRecords;
	private Date opsDate;
	private double crValue;
	private double drValue;
	private String fileRefNumber;
	private int bankCode;
	private String reportName;
	private String media;
	private int centre;
	private String internalIndicator;
	private String printCode;
	private String recipientCode;
	private String distributedIndicator;
	private int noOfCredits;
	private int noOfDebits;
	private long hashTotal;
	private String axdCreatedIndicator;
	private int negativeCardCount;
	private int acquirer;
	private int issuer;
	private int controlRecordCount;

	public String getFilenameDescription() {
		return this.filenameDescription;
	}

	public void setFilenameDescription(String filenameDescription) {
		this.filenameDescription=filenameDescription;
	}

	public long getOraSeqNumber() {
		return this.oraSeqNumber;
	}

	public void setOraSeqNumber(long oraSeqNumber) {
		this.oraSeqNumber=oraSeqNumber;
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

	public String getInputOutputIndicator() {
		return this.inputOutputIndicator;
	}

	public void setInputOutputIndicator(String inputOutputIndicator) {
		this.inputOutputIndicator=inputOutputIndicator;
	}

	public String getLastFileIndicator() {
		return this.lastFileIndicator;
	}

	public void setLastFileIndicator(String lastFileIndicator) {
		this.lastFileIndicator=lastFileIndicator;
	}

	public String getTransmitIndicator() {
		return this.transmitIndicator;
	}

	public void setTransmitIndicator(String transmitIndicator) {
		this.transmitIndicator=transmitIndicator;
	}

	public int getDestination() {
		return this.destination;
	}

	public void setDestination(int destination) {
		this.destination=destination;
	}

	public long getNumberOfRecords() {
		return this.numberOfRecords;
	}

	public void setNumberOfRecords(long numberOfRecords) {
		this.numberOfRecords=numberOfRecords;
	}

	public Date getOpsDate() {
		return this.opsDate;
	}

	public void setOpsDate(Date opsDate) {
		this.opsDate=opsDate;
	}

	public double getCrValue() {
		return this.crValue;
	}

	public void setCrValue(double crValue) {
		this.crValue=crValue;
	}

	public double getDrValue() {
		return this.drValue;
	}

	public void setDrValue(double drValue) {
		this.drValue=drValue;
	}

	public String getFileRefNumber() {
		return this.fileRefNumber;
	}

	public void setFileRefNumber(String fileRefNumber) {
		this.fileRefNumber=fileRefNumber;
	}

	public int getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(int bankCode) {
		this.bankCode=bankCode;
	}

	public String getReportName() {
		return this.reportName;
	}

	public void setReportName(String reportName) {
		this.reportName=reportName;
	}

	public String getMedia() {
		return this.media;
	}

	public void setMedia(String media) {
		this.media=media;
	}

	public int getCentre() {
		return this.centre;
	}

	public void setCentre(int centre) {
		this.centre=centre;
	}

	public String getInternalIndicator() {
		return this.internalIndicator;
	}

	public void setInternalIndicator(String internalIndicator) {
		this.internalIndicator=internalIndicator;
	}

	public String getPrintCode() {
		return this.printCode;
	}

	public void setPrintCode(String printCode) {
		this.printCode=printCode;
	}

	public String getRecipientCode() {
		return this.recipientCode;
	}

	public void setRecipientCode(String recipientCode) {
		this.recipientCode=recipientCode;
	}

	public String getDistributedIndicator() {
		return this.distributedIndicator;
	}

	public void setDistributedIndicator(String distributedIndicator) {
		this.distributedIndicator=distributedIndicator;
	}

	public int getNoOfCredits() {
		return this.noOfCredits;
	}

	public void setNoOfCredits(int noOfCredits) {
		this.noOfCredits=noOfCredits;
	}

	public int getNoOfDebits() {
		return this.noOfDebits;
	}

	public void setNoOfDebits(int noOfDebits) {
		this.noOfDebits=noOfDebits;
	}

	public long getHashTotal() {
		return this.hashTotal;
	}

	public void setHashTotal(long hashTotal) {
		this.hashTotal=hashTotal;
	}

	public String getAxdCreatedIndicator() {
		return this.axdCreatedIndicator;
	}

	public void setAxdCreatedIndicator(String axdCreatedIndicator) {
		this.axdCreatedIndicator=axdCreatedIndicator;
	}

	public int getNegativeCardCount() {
		return this.negativeCardCount;
	}

	public void setNegativeCardCount(int negativeCardCount) {
		this.negativeCardCount=negativeCardCount;
	}

	public int getAcquirer() {
		return this.acquirer;
	}

	public void setAcquirer(int acquirer) {
		this.acquirer=acquirer;
	}

	public int getIssuer() {
		return this.issuer;
	}

	public void setIssuer(int issuer) {
		this.issuer=issuer;
	}

	public int getControlRecordCount() {
		return this.controlRecordCount;
	}

	public void setControlRecordCount(int controlRecordCount) {
		this.controlRecordCount=controlRecordCount;
	}
}
