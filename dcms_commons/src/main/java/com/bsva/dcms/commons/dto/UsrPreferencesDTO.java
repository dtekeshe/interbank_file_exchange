package com.bsva.dcms.commons.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class UsrPreferencesDTO implements Serializable{
	private String loginName;
	private String preferenceCode;
	private String preferenceValue;
	private String systemName;

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName=loginName;
	}

	public String getPreferenceCode() {
		return this.preferenceCode;
	}

	public void setPreferenceCode(String preferenceCode) {
		this.preferenceCode=preferenceCode;
	}

	public String getPreferenceValue() {
		return this.preferenceValue;
	}

	public void setPreferenceValue(String preferenceValue) {
		this.preferenceValue=preferenceValue;
	}

	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName=systemName;
	}

}
