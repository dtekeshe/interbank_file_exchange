package com.bsva.dcms.commons.dto;
import java.io.Serializable;


/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoNegcardInfoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int fileOriginator;
	private long negCardCount;
	private String outputDate;

	public int getFileOriginator() {
		return this.fileOriginator;
	}

	public void setFileOriginator(int fileOriginator) {
		this.fileOriginator=fileOriginator;
	}

	public long getNegCardCount() {
		return this.negCardCount;
	}

	public void setNegCardCount(long negCardCount) {
		this.negCardCount=negCardCount;
	}

	public String getOutputDate() {
		return outputDate;
	}

	public void setOutputDate(String outputDate) {
		this.outputDate = outputDate;
	}
	
}
