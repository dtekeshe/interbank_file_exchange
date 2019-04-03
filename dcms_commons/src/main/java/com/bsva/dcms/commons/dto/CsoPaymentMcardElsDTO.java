package com.bsva.dcms.commons.dto;
import java.util.ArrayList;
import java.util.List;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoPaymentMcardElsDTO implements java.io.Serializable, Cloneable {
	private long systemSeqNumber;
	private String dataElNo;
	private int dataElType;
	private int dataElLength;
	private byte[] dataElData;

	public long getSystemSeqNumber() {
		return this.systemSeqNumber;
	}

	public void setSystemSeqNumber(long systemSeqNumber) {
		this.systemSeqNumber=systemSeqNumber;
	}

	public String getDataElNo() {
		return this.dataElNo;
	}

	public void setDataElNo(String dataElNo) {
		this.dataElNo=dataElNo;
	}

	public int getDataElType() {
		return this.dataElType;
	}

	public void setDataElType(int dataElType) {
		this.dataElType=dataElType;
	}

	public int getDataElLength() {
		return this.dataElLength;
	}

	public void setDataElLength(int dataElLength) {
		this.dataElLength=dataElLength;
	}

	public byte[] getDataElData() {
		return dataElData;
	}

	public void setDataElData(byte[] dataElData) {
		this.dataElData = dataElData;
	}

	/* Creates and returns a copy of this object. */
	public Object clone() {
		CsoPaymentMcardElsDTO bean = new CsoPaymentMcardElsDTO();
		bean.systemSeqNumber = this.systemSeqNumber;
		bean.dataElNo = this.dataElNo;
		bean.dataElType = this.dataElType;
		bean.dataElLength = this.dataElLength;
		bean.dataElData = this.dataElData;
		return bean;
	}
	/* Returns a string representation of the object. */
	public String toString() {
		String sep = "\r\n";
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName()).append(sep);
		sb.append("[").append("this.systemSeqNumber").append(" = ").append(this.systemSeqNumber).append("]").append(sep);
		sb.append("[").append("this.dataElNo").append(" = ").append(this.dataElNo).append("]").append(sep);
		sb.append("[").append("this.dataElType").append(" = ").append(this.dataElType).append("]").append(sep);
		sb.append("[").append("this.dataElLength").append(" = ").append(this.dataElLength).append("]").append(sep);
		sb.append("[").append("this.dataElData").append(" = ").append(this.dataElData).append("]").append(sep);
		return sb.toString();
	}
}
