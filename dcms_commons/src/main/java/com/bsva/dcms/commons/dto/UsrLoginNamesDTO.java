package com.bsva.dcms.commons.dto;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class UsrLoginNamesDTO implements Serializable{
	private String loginName;
	private String userPassword;
	private String loginExpired;
	private String userStatus;
	private Date lastLogin;
	private String systemName;

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName=loginName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword=userPassword;
	}

	public String getLoginExpired() {
		return this.loginExpired;
	}

	public void setLoginExpired(String loginExpired) {
		this.loginExpired=loginExpired;
	}

	public String getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus=userStatus;
	}

	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin=lastLogin;
	}

	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName=systemName;
	}

}
