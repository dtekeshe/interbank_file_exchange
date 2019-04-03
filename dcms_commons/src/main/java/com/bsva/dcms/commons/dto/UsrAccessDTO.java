package com.bsva.dcms.commons.dto;

import java.io.Serializable;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class UsrAccessDTO implements Serializable{
	private String loginName;
	private String accessUnit;
	private String systemName;

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName=loginName;
	}

	public String getAccessUnit() {
		return this.accessUnit;
	}

	public void setAccessUnit(String accessUnit) {
		this.accessUnit=accessUnit;
	}

	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName=systemName;
	}

}
