package com.bsva.dcms.commons.dto;

import java.io.Serializable;



/**
*
* @author Nombuyiselo Mbangula <nombuyiselom@bankservafrica.com>
*/

public class CSFMemberServiceDTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String memberNo;
	private int bankCode;
	private String service;
	private String subService;
	private String outputInd;
	private String maxSizeTransFile;
	private String memberTapeid;
	private String acquirerInd;
	private String issuerInd;
	private String contactName;
	private String title;
	private String branchCode;
	private String accountNumber;
	private String memberAddress1;
	private String memberAddress2;
	private String memberAddress3;
	private String memberAddress4;
	private String country;
	private String vatRegNumber;
	private String exceptionReportInd;
	private String currencyCodeValidationReq;
	private String inputCharset;
	private String outputCharset;
	private int header01RecordLength;
	private int trailer98RecordLength;
	private int trailer99RecordLength;
	private int invoiceNoCCR001;
	

	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public int getBankCode() {
		return bankCode;
	}
	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getSubService() {
		return subService;
	}
	public void setSubService(String subService) {
		this.subService = subService;
	}
	public String getOutputInd() {
		return outputInd;
	}
	public void setOutputInd(String outputInd) {
		this.outputInd = outputInd;
	}
	public String getMaxSizeTransFile() {
		return maxSizeTransFile;
	}
	public void setMaxSizeTransFile(String maxSizeTransFile) {
		this.maxSizeTransFile = maxSizeTransFile;
	}
	public String getMemberTapeid() {
		return memberTapeid;
	}
	public void setMemberTapeid(String memberTapeid) {
		this.memberTapeid = memberTapeid;
	}
	public String getAcquirerInd() {
		return acquirerInd;
	}
	public void setAcquirerInd(String acquirerInd) {
		this.acquirerInd = acquirerInd;
	}
	public String getIssuerInd() {
		return issuerInd;
	}
	public void setIssuerInd(String issuerInd) {
		this.issuerInd = issuerInd;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getMemberAddress1() {
		return memberAddress1;
	}
	public void setMemberAddress1(String memberAddress1) {
		this.memberAddress1 = memberAddress1;
	}
	public String getMemberAddress2() {
		return memberAddress2;
	}
	public void setMemberAddress2(String memberAddress2) {
		this.memberAddress2 = memberAddress2;
	}
	public String getMemberAddress3() {
		return memberAddress3;
	}
	public void setMemberAddress3(String memberAddress3) {
		this.memberAddress3 = memberAddress3;
	}
	public String getMemberAddress4() {
		return memberAddress4;
	}
	public void setMemberAddress4(String memberAddress4) {
		this.memberAddress4 = memberAddress4;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getVatRegNumber() {
		return vatRegNumber;
	}
	public void setVatRegNumber(String vatRegNumber) {
		this.vatRegNumber = vatRegNumber;
	}
	public String getExceptionReportInd() {
		return exceptionReportInd;
	}
	public void setExceptionReportInd(String exceptionReportInd) {
		this.exceptionReportInd = exceptionReportInd;
	}
	public String getCurrencyCodeValidationReq() {
		return currencyCodeValidationReq;
	}
	public void setCurrencyCodeValidationReq(String currencyCodeValidationReq) {
		this.currencyCodeValidationReq = currencyCodeValidationReq;
	}
	public String getInputCharset() {
		return inputCharset;
	}
	public void setInputCharset(String inputCharset) {
		this.inputCharset = inputCharset;
	}
	public String getOutputCharset() {
		return outputCharset;
	}
	public void setOutputCharset(String outputCharset) {
		this.outputCharset = outputCharset;
	}
	public int getHeader01RecordLength() {
		return header01RecordLength;
	}
	public void setHeader01RecordLength(int header01RecordLength) {
		this.header01RecordLength = header01RecordLength;
	}
	public int getTrailer98RecordLength() {
		return trailer98RecordLength;
	}
	public void setTrailer98RecordLength(int trailer98RecordLength) {
		this.trailer98RecordLength = trailer98RecordLength;
	}
	public int getTrailer99RecordLength() {
		return trailer99RecordLength;
	}
	public void setTrailer99RecordLength(int trailer99RecordLength) {
		this.trailer99RecordLength = trailer99RecordLength;
	}
	public int getInvoiceNoCCR001() {
		return invoiceNoCCR001;
	}
	public void setInvoiceNoCCR001(int invoiceNoCCR001) {
		this.invoiceNoCCR001 = invoiceNoCCR001;
	}
	
}
