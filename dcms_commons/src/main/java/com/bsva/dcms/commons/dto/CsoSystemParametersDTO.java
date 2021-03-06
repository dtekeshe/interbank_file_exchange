/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.bsva.dcms.commons.dto;

import java.io.Serializable;
import java.util.Date;

public class CsoSystemParametersDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 
	 * This attribute maps to the column PROCESS_DATE in the CSO_SYSTEM_PARAMETERS table.
	 */
	protected Date processDate;

	/** 
	 * This attribute maps to the column PROCESS_ACTIVE_IND in the CSO_SYSTEM_PARAMETERS table.
	 */
	protected String processActiveInd;

	/** 
	 * This attribute maps to the column LIVE_TEST_CODE in the CSO_SYSTEM_PARAMETERS table.
	 */
	protected String liveTestCode;

	/** 
	 * This attribute maps to the column CIS_DOWNLOAD_IND in the CSO_SYSTEM_PARAMETERS table.
	 */
	protected String cisDownloadInd;

	/** 
	 * This attribute maps to the column EOD_DONE in the CSO_SYSTEM_PARAMETERS table.
	 */
	protected String eodDone;

	/** 
	 * This attribute maps to the column RUN_BATCH in the CSO_SYSTEM_PARAMETERS table.
	 */
	protected String runBatch;

	/** 
	 * This attribute maps to the column UNIX_SOD_DONE in the CSO_SYSTEM_PARAMETERS table.
	 */
	protected String unixSodDone;

	/** 
	 * This attribute maps to the column CCCORE_INTERVAL in the CSO_SYSTEM_PARAMETERS table.
	 */
	protected int cccoreInterval;

	/** 
	 * This attribute maps to the column NEXT_OUTPUT_DATE in the CSO_SYSTEM_PARAMETERS table.
	 */
	protected Date nextOutputDate;

	/**
	 * Method 'CsoSystemParameters'
	 * 
	 */
	public CsoSystemParametersDTO()
	{
	}

	/**
	 * Method 'getProcessDate'
	 * 
	 * @return Date
	 */
	public Date getProcessDate()
	{
		return processDate;
	}

	/**
	 * Method 'setProcessDate'
	 * 
	 * @param processDate
	 */
	public void setProcessDate(Date processDate)
	{
		this.processDate = processDate;
	}

	/**
	 * Method 'getProcessActiveInd'
	 * 
	 * @return String
	 */
	public String getProcessActiveInd()
	{
		return processActiveInd;
	}

	/**
	 * Method 'setProcessActiveInd'
	 * 
	 * @param processActiveInd
	 */
	public void setProcessActiveInd(String processActiveInd)
	{
		this.processActiveInd = processActiveInd;
	}

	/**
	 * Method 'getLiveTestCode'
	 * 
	 * @return String
	 */
	public String getLiveTestCode()
	{
		return liveTestCode;
	}

	/**
	 * Method 'setLiveTestCode'
	 * 
	 * @param liveTestCode
	 */
	public void setLiveTestCode(String liveTestCode)
	{
		this.liveTestCode = liveTestCode;
	}

	/**
	 * Method 'getCisDownloadInd'
	 * 
	 * @return String
	 */
	public String getCisDownloadInd()
	{
		return cisDownloadInd;
	}

	/**
	 * Method 'setCisDownloadInd'
	 * 
	 * @param cisDownloadInd
	 */
	public void setCisDownloadInd(String cisDownloadInd)
	{
		this.cisDownloadInd = cisDownloadInd;
	}

	/**
	 * Method 'getEodDone'
	 * 
	 * @return String
	 */
	public String getEodDone()
	{
		return eodDone;
	}

	/**
	 * Method 'setEodDone'
	 * 
	 * @param eodDone
	 */
	public void setEodDone(String eodDone)
	{
		this.eodDone = eodDone;
	}

	/**
	 * Method 'getRunBatch'
	 * 
	 * @return String
	 */
	public String getRunBatch()
	{
		return runBatch;
	}

	/**
	 * Method 'setRunBatch'
	 * 
	 * @param runBatch
	 */
	public void setRunBatch(String runBatch)
	{
		this.runBatch = runBatch;
	}

	/**
	 * Method 'getUnixSodDone'
	 * 
	 * @return String
	 */
	public String getUnixSodDone()
	{
		return unixSodDone;
	}

	/**
	 * Method 'setUnixSodDone'
	 * 
	 * @param unixSodDone
	 */
	public void setUnixSodDone(String unixSodDone)
	{
		this.unixSodDone = unixSodDone;
	}

	/**
	 * Method 'getCccoreInterval'
	 * 
	 * @return int
	 */
	public int getCccoreInterval()
	{
		return cccoreInterval;
	}

	/**
	 * Method 'setCccoreInterval'
	 * 
	 * @param cccoreInterval
	 */
	public void setCccoreInterval(int cccoreInterval)
	{
		this.cccoreInterval = cccoreInterval;
	}

	/**
	 * Method 'getNextOutputDate'
	 * 
	 * @return Date
	 */
	public Date getNextOutputDate()
	{
		return nextOutputDate;
	}

	/**
	 * Method 'setNextOutputDate'
	 * 
	 * @param nextOutputDate
	 */
	public void setNextOutputDate(Date nextOutputDate)
	{
		this.nextOutputDate = nextOutputDate;
	}
}
