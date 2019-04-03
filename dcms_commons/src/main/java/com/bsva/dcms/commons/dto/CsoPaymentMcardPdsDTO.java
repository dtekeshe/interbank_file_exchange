package com.bsva.dcms.commons.dto;
import java.util.ArrayList;
import java.util.List;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoPaymentMcardPdsDTO implements java.io.Serializable, Cloneable {
	private long systemSeqNumber;
	private int pdsNumber;
	private int pdsLength;
	private String pdsData;

	public long getSystemSeqNumber() {
		return this.systemSeqNumber;
	}

	public void setSystemSeqNumber(long systemSeqNumber) {
		this.systemSeqNumber=systemSeqNumber;
	}

	public int getPdsNumber() {
		return this.pdsNumber;
	}

	public void setPdsNumber(int pdsNumber) {
		this.pdsNumber=pdsNumber;
	}

	public int getPdsLength() {
		return this.pdsLength;
	}

	public void setPdsLength(int pdsLength) {
		this.pdsLength=pdsLength;
	}

	public String getPdsData() {
		return this.pdsData;
	}

	public void setPdsData(String pdsData) {
		this.pdsData=pdsData;
	}


	/* Creates and returns a copy of this object. */
	public Object clone() {
		CsoPaymentMcardPdsDTO bean = new CsoPaymentMcardPdsDTO();
		bean.systemSeqNumber = this.systemSeqNumber;
		bean.pdsNumber = this.pdsNumber;
		bean.pdsLength = this.pdsLength;
		bean.pdsData = this.pdsData;
		return bean;
	}
	/* Returns a string representation of the object. */
	public String toString() {
		String sep = "\r\n";
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName()).append(sep);
		sb.append("[").append("this.systemSeqNumber").append(" = ").append(this.systemSeqNumber).append("]").append(sep);
		sb.append("[").append("this.pdsNumber").append(" = ").append(this.pdsNumber).append("]").append(sep);
		sb.append("[").append("this.pdsLength").append(" = ").append(this.pdsLength).append("]").append(sep);
		sb.append("[").append("this.pdsData").append(" = ").append(this.pdsData).append("]").append(sep);
		return sb.toString();
	}
}
