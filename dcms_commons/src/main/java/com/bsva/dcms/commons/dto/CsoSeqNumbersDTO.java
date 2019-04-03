package com.bsva.dcms.commons.dto;
import java.util.ArrayList;
import java.util.List;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoSeqNumbersDTO implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String externalFilenamePrefix;
	private String distributionCode;
	private int lastSeqNumberUsed;

	public String getExternalFilenamePrefix() {
		return this.externalFilenamePrefix;
	}

	public void setExternalFilenamePrefix(String externalFilenamePrefix) {
		this.externalFilenamePrefix=externalFilenamePrefix;
	}

	public String getDistributionCode() {
		return this.distributionCode;
	}

	public void setDistributionCode(String distributionCode) {
		this.distributionCode=distributionCode;
	}

	public int getLastSeqNumberUsed() {
		return this.lastSeqNumberUsed;
	}

	public void setLastSeqNumberUsed(int lastSeqNumberUsed) {
		this.lastSeqNumberUsed=lastSeqNumberUsed;
	}


	/* Creates and returns a copy of this object. */
	public Object clone() {
		CsoSeqNumbersDTO bean = new CsoSeqNumbersDTO();
		bean.externalFilenamePrefix = this.externalFilenamePrefix;
		bean.distributionCode = this.distributionCode;
		bean.lastSeqNumberUsed = this.lastSeqNumberUsed;
		return bean;
	}
	/* Returns a string representation of the object. */
	public String toString() {
		String sep = "\r\n";
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName()).append(sep);
		sb.append("[").append("this.externalFilenamePrefix").append(" = ").append(this.externalFilenamePrefix).append("]").append(sep);
		sb.append("[").append("this.distributionCode").append(" = ").append(this.distributionCode).append("]").append(sep);
		sb.append("[").append("this.lastSeqNumberUsed").append(" = ").append(this.lastSeqNumberUsed).append("]").append(sep);
		return sb.toString();
	}
}
