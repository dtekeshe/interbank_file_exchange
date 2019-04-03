/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.bsva.dcms.commons.dto;

import java.io.Serializable;
import java.util.*;

public class CsfSystemSettingsDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 
	 * This attribute maps to the column SETTING_CODE in the CSF_SYSTEM_SETTINGS table.
	 */
	protected String settingCode;

	/** 
	 * This attribute maps to the column SETTING_VALUE in the CSF_SYSTEM_SETTINGS table.
	 */
	protected String settingValue;

	/** 
	 * This attribute maps to the column SETTING_DESCRIPTION in the CSF_SYSTEM_SETTINGS table.
	 */
	protected String settingDescription;

	/**
	 * Method 'CsfSystemSettings'
	 * 
	 */
	public CsfSystemSettingsDTO()
	{
	}

	/**
	 * Method 'getSettingCode'
	 * 
	 * @return String
	 */
	public String getSettingCode()
	{
		return settingCode;
	}

	/**
	 * Method 'setSettingCode'
	 * 
	 * @param settingCode
	 */
	public void setSettingCode(String settingCode)
	{
		this.settingCode = settingCode;
	}

	/**
	 * Method 'getSettingValue'
	 * 
	 * @return String
	 */
	public String getSettingValue()
	{
		return settingValue;
	}

	/**
	 * Method 'setSettingValue'
	 * 
	 * @param settingValue
	 */
	public void setSettingValue(String settingValue)
	{
		this.settingValue = settingValue;
	}

	/**
	 * Method 'getSettingDescription'
	 * 
	 * @return String
	 */
	public String getSettingDescription()
	{
		return settingDescription;
	}

	/**
	 * Method 'setSettingDescription'
	 * 
	 * @param settingDescription
	 */
	public void setSettingDescription(String settingDescription)
	{
		this.settingDescription = settingDescription;
	}

}