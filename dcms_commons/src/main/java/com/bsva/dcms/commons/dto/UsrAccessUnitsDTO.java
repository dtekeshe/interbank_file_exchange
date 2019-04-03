package com.bsva.dcms.commons.dto;
import java.io.Serializable;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class UsrAccessUnitsDTO implements Serializable {
	private String accessUnitName;
	private String accessUnitDesc;
	private int accessUnitIdx;
	private String systemName;

	public String getAccessUnitName() {
		return this.accessUnitName;
	}

	public void setAccessUnitName(String accessUnitName) {
		this.accessUnitName=accessUnitName;
	}

	public String getAccessUnitDesc() {
		return this.accessUnitDesc;
	}

	public void setAccessUnitDesc(String accessUnitDesc) {
		this.accessUnitDesc=accessUnitDesc;
	}

	public int getAccessUnitIdx() {
		return this.accessUnitIdx;
	}

	public void setAccessUnitIdx(int accessUnitIdx) {
		this.accessUnitIdx=accessUnitIdx;
	}

	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName=systemName;
	}
}
