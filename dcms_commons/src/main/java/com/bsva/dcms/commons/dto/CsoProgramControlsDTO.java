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

public class CsoProgramControlsDTO implements java.io.Serializable, Cloneable {
	private String programName;
	private String serviceCode;
	private String subServiceCode;
	private String paymentStream;
	private Date startTime;
	private Date endTime;
	private String status;
	private double executionAverage;
	private double executionLast;
	private int seqNo;
	private String arbData;

	public String getProgramName() {
		return this.programName;
	}

	public void setProgramName(String programName) {
		this.programName=programName;
	}

	public String getServiceCode() {
		return this.serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode=serviceCode;
	}

	public String getSubServiceCode() {
		return this.subServiceCode;
	}

	public void setSubServiceCode(String subServiceCode) {
		this.subServiceCode=subServiceCode;
	}

	public String getPaymentStream() {
		return this.paymentStream;
	}

	public void setPaymentStream(String paymentStream) {
		this.paymentStream=paymentStream;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime=startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime=endTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status=status;
	}

	public double getExecutionAverage() {
		return this.executionAverage;
	}

	public void setExecutionAverage(double executionAverage) {
		this.executionAverage=executionAverage;
	}

	public double getExecutionLast() {
		return this.executionLast;
	}

	public void setExecutionLast(double executionLast) {
		this.executionLast=executionLast;
	}

	public int getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo=seqNo;
	}

	public String getArbData() {
		return this.arbData;
	}

	public void setArbData(String arbData) {
		this.arbData=arbData;
	}


	/* Creates and returns a copy of this object. */
	public Object clone() {
		CsoProgramControlsDTO bean = new CsoProgramControlsDTO();
		bean.programName = this.programName;
		bean.serviceCode = this.serviceCode;
		bean.subServiceCode = this.subServiceCode;
		bean.paymentStream = this.paymentStream;
		bean.startTime = this.startTime;
		bean.endTime = this.endTime;
		bean.status = this.status;
		bean.executionAverage = this.executionAverage;
		bean.executionLast = this.executionLast;
		bean.seqNo = this.seqNo;
		bean.arbData = this.arbData;
		return bean;
	}
	/* Returns a string representation of the object. */
	public String toString() {
		String sep = "\r\n";
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName()).append(sep);
		sb.append("[").append("this.programName").append(" = ").append(this.programName).append("]").append(sep);
		sb.append("[").append("this.serviceCode").append(" = ").append(this.serviceCode).append("]").append(sep);
		sb.append("[").append("this.subServiceCode").append(" = ").append(this.subServiceCode).append("]").append(sep);
		sb.append("[").append("this.paymentStream").append(" = ").append(this.paymentStream).append("]").append(sep);
		sb.append("[").append("this.startTime").append(" = ").append(this.startTime).append("]").append(sep);
		sb.append("[").append("this.endTime").append(" = ").append(this.endTime).append("]").append(sep);
		sb.append("[").append("this.status").append(" = ").append(this.status).append("]").append(sep);
		sb.append("[").append("this.executionAverage").append(" = ").append(this.executionAverage).append("]").append(sep);
		sb.append("[").append("this.executionLast").append(" = ").append(this.executionLast).append("]").append(sep);
		sb.append("[").append("this.seqNo").append(" = ").append(this.seqNo).append("]").append(sep);
		sb.append("[").append("this.arbData").append(" = ").append(this.arbData).append("]").append(sep);
		return sb.toString();
	}
}
