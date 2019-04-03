package com.bsva.dcms.commons.dto;
import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoOutputControlsDTO implements java.io.Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bankCode;
	private String service;
	private String subService;
	private String filenamePrefix;
	private String distributionCode;
	private String seqNumber;
	private String statusCode;
	private String filenameDescription;
	private Date transmissionDate;
	private String lastFileIndicator;
	private long crVolume;
	private double crValue;
	private long drVolume;
	private double drValue;
	private int recordCount;
	private long hashTotal98;
	private long hashTotal99;
	private String originatingBankId;
	private int originatingMember;
	private long negCardCount;
	private Timestamp startTime;
	private Timestamp endTime;
	private String fullFileInd;
    private Long recordCountForDay;
    private double drValueForDay;

	public int getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(int bankCode) {
		this.bankCode=bankCode;
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

	public String getFilenamePrefix() {
		return this.filenamePrefix;
	}

	public void setFilenamePrefix(String filenamePrefix) {
		this.filenamePrefix=filenamePrefix;
	}

	public String getDistributionCode() {
		return this.distributionCode;
	}

	public void setDistributionCode(String distributionCode) {
		this.distributionCode=distributionCode;
	}

	public String getSeqNumber() {
		return this.seqNumber;
	}

	public void setSeqNumber(String seqNumber) {
		this.seqNumber=seqNumber;
	}

	public String getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode=statusCode;
	}

	public String getFilenameDescription() {
		return this.filenameDescription;
	}

	public void setFilenameDescription(String filenameDescription) {
		this.filenameDescription=filenameDescription;
	}

	public Date getTransmissionDate() {
		return this.transmissionDate;
	}

	public void setTransmissionDate(Date transmissionDate) {
		this.transmissionDate=transmissionDate;
	}

	public String getLastFileIndicator() {
		return this.lastFileIndicator;
	}

	public void setLastFileIndicator(String lastFileIndicator) {
		this.lastFileIndicator=lastFileIndicator;
	}

	public long getCrVolume() {
		return this.crVolume;
	}

	public void setCrVolume(long crVolume) {
		this.crVolume=crVolume;
	}

	public double getCrValue() {
		return this.crValue;
	}

	public void setCrValue(double crValue) {
		this.crValue=crValue;
	}

	public long getDrVolume() {
		return this.drVolume;
	}

	public void setDrVolume(long drVolume) {
		this.drVolume=drVolume;
	}

	public double getDrValue() {
		return this.drValue;
	}

	public Long getRecordCountForDay() {
		return recordCountForDay;
	}

	public double getDrValueForDay() {
		return drValueForDay;
	}

	public void setRecordCountForDay(Long recordCountForDay) {
		this.recordCountForDay = recordCountForDay;
	}

	public void setDrValueForDay(double drValueForDay) {
		this.drValueForDay = drValueForDay;
	}

	public void setDrValue(double drValue) {
		this.drValue=drValue;
	}

	public int getRecordCount() {
		return this.recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount=recordCount;
	}

	public long getHashTotal98() {
		return this.hashTotal98;
	}

	public void setHashTotal98(long hashTotal98) {
		this.hashTotal98=hashTotal98;
	}

	public long getHashTotal99() {
		return this.hashTotal99;
	}

	public void setHashTotal99(long hashTotal99) {
		this.hashTotal99=hashTotal99;
	}

	public String getOriginatingBankId() {
		return this.originatingBankId;
	}

	public void setOriginatingBankId(String originatingBankId) {
		this.originatingBankId=originatingBankId;
	}

	public int getOriginatingMember() {
		return this.originatingMember;
	}

	public void setOriginatingMember(int originatingMember) {
		this.originatingMember=originatingMember;
	}

	public long getNegCardCount() {
		return this.negCardCount;
	}

	public void setNegCardCount(long negCardCount) {
		this.negCardCount=negCardCount;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime=startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime=endTime;
	}


	public String getFullFileInd() {
		return fullFileInd;
	}

	public void setFullFileInd(String fullFileInd) {
		this.fullFileInd = fullFileInd;
	}

	/* Creates and returns a copy of this object. */
	public Object clone() {
		CsoOutputControlsDTO bean = new CsoOutputControlsDTO();
		bean.bankCode = this.bankCode;
		bean.service = this.service;
		bean.subService = this.subService;
		bean.filenamePrefix = this.filenamePrefix;
		bean.distributionCode = this.distributionCode;
		bean.seqNumber = this.seqNumber;
		bean.statusCode = this.statusCode;
		bean.filenameDescription = this.filenameDescription;
		bean.transmissionDate = this.transmissionDate;
		bean.lastFileIndicator = this.lastFileIndicator;
		bean.crVolume = this.crVolume;
		bean.crValue = this.crValue;
		bean.drVolume = this.drVolume;
		bean.drValue = this.drValue;
		bean.recordCount = this.recordCount;
		bean.hashTotal98 = this.hashTotal98;
		bean.hashTotal99 = this.hashTotal99;
		bean.originatingBankId = this.originatingBankId;
		bean.originatingMember = this.originatingMember;
		bean.negCardCount = this.negCardCount;
		bean.startTime = this.startTime;
		bean.endTime = this.endTime;
		bean.fullFileInd = this.fullFileInd;
		return bean;
	}
	/* Returns a string representation of the object. */
	public String toString() {
		String sep = "\r\n";
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName()).append(sep);
		sb.append("[").append("this.bankCode").append(" = ").append(this.bankCode).append("]").append(sep);
		sb.append("[").append("this.service").append(" = ").append(this.service).append("]").append(sep);
		sb.append("[").append("this.subService").append(" = ").append(this.subService).append("]").append(sep);
		sb.append("[").append("this.filenamePrefix").append(" = ").append(this.filenamePrefix).append("]").append(sep);
		sb.append("[").append("this.distributionCode").append(" = ").append(this.distributionCode).append("]").append(sep);
		sb.append("[").append("this.seqNumber").append(" = ").append(this.seqNumber).append("]").append(sep);
		sb.append("[").append("this.statusCode").append(" = ").append(this.statusCode).append("]").append(sep);
		sb.append("[").append("this.filenameDescription").append(" = ").append(this.filenameDescription).append("]").append(sep);
		sb.append("[").append("this.transmissionDate").append(" = ").append(this.transmissionDate).append("]").append(sep);
		sb.append("[").append("this.lastFileIndicator").append(" = ").append(this.lastFileIndicator).append("]").append(sep);
		sb.append("[").append("this.crVolume").append(" = ").append(this.crVolume).append("]").append(sep);
		sb.append("[").append("this.crValue").append(" = ").append(this.crValue).append("]").append(sep);
		sb.append("[").append("this.drVolume").append(" = ").append(this.drVolume).append("]").append(sep);
		sb.append("[").append("this.drValue").append(" = ").append(this.drValue).append("]").append(sep);
		sb.append("[").append("this.recordCount").append(" = ").append(this.recordCount).append("]").append(sep);
		sb.append("[").append("this.hashTotal98").append(" = ").append(this.hashTotal98).append("]").append(sep);
		sb.append("[").append("this.hashTotal99").append(" = ").append(this.hashTotal99).append("]").append(sep);
		sb.append("[").append("this.originatingBankId").append(" = ").append(this.originatingBankId).append("]").append(sep);
		sb.append("[").append("this.originatingMember").append(" = ").append(this.originatingMember).append("]").append(sep);
		sb.append("[").append("this.negCardCount").append(" = ").append(this.negCardCount).append("]").append(sep);
		sb.append("[").append("this.startTime").append(" = ").append(this.startTime).append("]").append(sep);
		sb.append("[").append("this.endTime").append(" = ").append(this.endTime).append("]").append(sep);
		sb.append("[").append("this.fullFileInd").append(" = ").append(this.fullFileInd).append("]").append(sep);
		return sb.toString();
	}
}
