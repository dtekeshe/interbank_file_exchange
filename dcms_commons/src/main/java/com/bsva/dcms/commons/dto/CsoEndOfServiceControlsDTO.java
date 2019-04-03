package com.bsva.dcms.commons.dto;
import java.io.Serializable;
import java.util.Date;


/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoEndOfServiceControlsDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileRefNumber;
	private String recordId;
	private Date outputDate;
	private String service;
	private String subService;
	private int numberOfFiles;
	private int numberCredits;
	private int numberDebits;
	private double creditValue;
	private double debitValue;
	private long hashTotal;
	private int bankCode;
	private String eosBalance;
	private String forceClose;

	public String getFileRefNumber() {
		return this.fileRefNumber;
	}

	public void setFileRefNumber(String fileRefNumber) {
		this.fileRefNumber=fileRefNumber;
	}

	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId=recordId;
	}

	public Date getOutputDate() {
		return this.outputDate;
	}

	public void setOutputDate(Date outputDate) {
		this.outputDate=outputDate;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service=service;
	}

	public String getSubService() {
		return this.subService;
	}

	public void setSubService(String subService) {
		this.subService=subService;
	}

	public int getNumberOfFiles() {
		return this.numberOfFiles;
	}

	public void setNumberOfFiles(int numberOfFiles) {
		this.numberOfFiles=numberOfFiles;
	}

	public int getNumberCredits() {
		return this.numberCredits;
	}

	public void setNumberCredits(int numberCredits) {
		this.numberCredits=numberCredits;
	}

	public int getNumberDebits() {
		return this.numberDebits;
	}

	public void setNumberDebits(int numberDebits) {
		this.numberDebits=numberDebits;
	}

	public double getCreditValue() {
		return this.creditValue;
	}

	public void setCreditValue(double creditValue) {
		this.creditValue=creditValue;
	}

	public double getDebitValue() {
		return this.debitValue;
	}

	public void setDebitValue(double debitValue) {
		this.debitValue=debitValue;
	}

	public long getHashTotal() {
		return this.hashTotal;
	}

	public void setHashTotal(long hashTotal) {
		this.hashTotal=hashTotal;
	}

	public int getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(int bankCode) {
		this.bankCode=bankCode;
	}

	public String getEosBalance() {
		return this.eosBalance;
	}

	public void setEosBalance(String eosBalance) {
		this.eosBalance=eosBalance;
	}

	public String getForceClose() {
		return this.forceClose;
	}

	public void setForceClose(String forceClose) {
		this.forceClose=forceClose;
	}
}
