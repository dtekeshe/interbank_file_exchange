package com.bsva.dcms.commons.dto;

import java.util.ArrayList;
import java.util.List;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoOdsFileToLoadDTO implements java.io.Serializable, Cloneable {
	private String filename;
	private String fileRefNumber;
	private String fileformat;
	private int seqNo;
	private String status;

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename=filename;
	}

	public String getFileRefNumber() {
		return this.fileRefNumber;
	}

	public void setFileRefNumber(String fileRefNumber) {
		this.fileRefNumber=fileRefNumber;
	}

	public String getFileformat() {
		return this.fileformat;
	}

	public void setFileformat(String fileformat) {
		this.fileformat=fileformat;
	}

	public int getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo=seqNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status=status;
	}


	/* Creates and returns a copy of this object. */
	public Object clone() {
		CsoOdsFileToLoadDTO bean = new CsoOdsFileToLoadDTO();
		bean.filename = this.filename;
		bean.fileRefNumber = this.fileRefNumber;
		bean.fileformat = this.fileformat;
		bean.seqNo = this.seqNo;
		bean.status = this.status;
		return bean;
	}
	/* Returns a string representation of the object. */
	public String toString() {
		String sep = "\r\n";
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName()).append(sep);
		sb.append("[").append("this.filename").append(" = ").append(this.filename).append("]").append(sep);
		sb.append("[").append("this.fileRefNumber").append(" = ").append(this.fileRefNumber).append("]").append(sep);
		sb.append("[").append("this.fileformat").append(" = ").append(this.fileformat).append("]").append(sep);
		sb.append("[").append("this.seqNo").append(" = ").append(this.seqNo).append("]").append(sep);
		sb.append("[").append("this.status").append(" = ").append(this.status).append("]").append(sep);
		return sb.toString();
	}
}
