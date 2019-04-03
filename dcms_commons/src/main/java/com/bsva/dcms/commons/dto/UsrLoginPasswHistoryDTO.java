package com.bsva.dcms.commons.dto;

import java.io.Serializable;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class UsrLoginPasswHistoryDTO implements Serializable {
	private String loginName;
	private String oldPassword1;
	private String oldPassword2;
	private String oldPassword3;
	private String systemName;

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName=loginName;
	}

	public String getOldPassword1() {
		return this.oldPassword1;
	}

	public void setOldPassword1(String oldPassword1) {
		this.oldPassword1=oldPassword1;
	}

	public String getOldPassword2() {
		return this.oldPassword2;
	}

	public void setOldPassword2(String oldPassword2) {
		this.oldPassword2=oldPassword2;
	}

	public String getOldPassword3() {
		return this.oldPassword3;
	}

	public void setOldPassword3(String oldPassword3) {
		this.oldPassword3=oldPassword3;
	}

	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName=systemName;
	}

}
