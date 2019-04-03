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

public class CsoBatchProcessesDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 
	 * This attribute maps to the column RUN_ORDER in the CSO_BATCH_PROCESSES table.
	 */
	protected int runOrder;

	/** 
	 * This attribute maps to the column PROGRAM_NAME in the CSO_BATCH_PROCESSES table.
	 */
	protected String programName;

	/** 
	 * This attribute maps to the column COMPLETED in the CSO_BATCH_PROCESSES table.
	 */
	protected String completed;

	/** 
	 * This attribute maps to the column MONTH_END_ONLY in the CSO_BATCH_PROCESSES table.
	 */
	protected String monthEndOnly;

	/** 
	 * This attribute maps to the column PROGRAM_ALIAS in the CSO_BATCH_PROCESSES table.
	 */
	protected String programAlias;

	/** 
	 * This attribute maps to the column INTERFACE in the CSO_BATCH_PROCESSES table.
	 */
	protected String aInterface;

	/** 
	 * This attribute maps to the column ACTIVE in the CSO_BATCH_PROCESSES table.
	 */
	protected String active;

	/**
	 * Method 'CsoBatchProcesses'
	 * 
	 */
	public CsoBatchProcessesDTO()
	{
	}

	/**
	 * Method 'getRunOrder'
	 * 
	 * @return int
	 */
	public int getRunOrder()
	{
		return runOrder;
	}

	/**
	 * Method 'setRunOrder'
	 * 
	 * @param runOrder
	 */
	public void setRunOrder(int runOrder)
	{
		this.runOrder = runOrder;
	}

	/**
	 * Method 'getProgramName'
	 * 
	 * @return String
	 */
	public String getProgramName()
	{
		return programName;
	}

	/**
	 * Method 'setProgramName'
	 * 
	 * @param programName
	 */
	public void setProgramName(String programName)
	{
		this.programName = programName;
	}

	/**
	 * Method 'getCompleted'
	 * 
	 * @return String
	 */
	public String getCompleted()
	{
		return completed;
	}

	/**
	 * Method 'setCompleted'
	 * 
	 * @param completed
	 */
	public void setCompleted(String completed)
	{
		this.completed = completed;
	}

	/**
	 * Method 'getMonthEndOnly'
	 * 
	 * @return String
	 */
	public String getMonthEndOnly()
	{
		return monthEndOnly;
	}

	/**
	 * Method 'setMonthEndOnly'
	 * 
	 * @param monthEndOnly
	 */
	public void setMonthEndOnly(String monthEndOnly)
	{
		this.monthEndOnly = monthEndOnly;
	}

	/**
	 * Method 'getProgramAlias'
	 * 
	 * @return String
	 */
	public String getProgramAlias()
	{
		return programAlias;
	}

	/**
	 * Method 'setProgramAlias'
	 * 
	 * @param programAlias
	 */
	public void setProgramAlias(String programAlias)
	{
		this.programAlias = programAlias;
	}

	/**
	 * Method 'getAInterface'
	 * 
	 * @return String
	 */
	public String getAInterface()
	{
		return aInterface;
	}

	/**
	 * Method 'setAInterface'
	 * 
	 * @param aInterface
	 */
	public void setAInterface(String aInterface)
	{
		this.aInterface = aInterface;
	}

	/**
	 * Method 'getActive'
	 * 
	 * @return String
	 */
	public String getActive()
	{
		return active;
	}

	/**
	 * Method 'setActive'
	 * 
	 * @param active
	 */
	public void setActive(String active)
	{
		this.active = active;
	}
}