package com.bsva.dcms.commons.dto;
import java.io.Serializable;


/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoCoreProcessesDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String programName;
	private int timeInterval;
	private int noOfInstanceSet;
	private int noOfInstanceActive;
	private String activeInd;
	private int sequenceNumber;
	private String programAlias;

	public String getProgramName() {
		return this.programName;
	}

	public void setProgramName(String programName) {
		this.programName=programName;
	}

	public int getTimeInterval() {
		return this.timeInterval;
	}

	public void setTimeInterval(int timeInterval) {
		this.timeInterval=timeInterval;
	}

	public int getNoOfInstanceSet() {
		return this.noOfInstanceSet;
	}

	public void setNoOfInstanceSet(int noOfInstanceSet) {
		this.noOfInstanceSet=noOfInstanceSet;
	}

	public int getNoOfInstanceActive() {
		return this.noOfInstanceActive;
	}

	public void setNoOfInstanceActive(int noOfInstanceActive) {
		this.noOfInstanceActive=noOfInstanceActive;
	}

	public String getActiveInd() {
		return this.activeInd;
	}

	public void setActiveInd(String activeInd) {
		this.activeInd=activeInd;
	}

	public int getSequenceNumber() {
		return this.sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber=sequenceNumber;
	}

	public String getProgramAlias() {
		return this.programAlias;
	}

	public void setProgramAlias(String programAlias) {
		this.programAlias=programAlias;
	}
}
