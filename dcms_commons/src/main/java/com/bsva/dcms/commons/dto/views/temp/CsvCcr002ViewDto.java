package com.bsva.dcms.commons.dto.views.temp;

public class CsvCcr002ViewDto {

	private String issuerMember;
	private int issuerBankCode;
	private String acquirerMember;
	private int acquirerBankCode;
	private String service;
	private String subService;
	private double acquirerFees;
	private double issuerFees;
	private double nettFees;
	private int invoiceNumber;
	public String getIssuerMember() {
		return issuerMember;
	}
	public void setIssuerMember(String issuerMember) {
		this.issuerMember = issuerMember;
	}
	public int getIssuerBankCode() {
		return issuerBankCode;
	}
	public void setIssuerBankCode(int issuerBankCode) {
		this.issuerBankCode = issuerBankCode;
	}
	public String getAcquirerMember() {
		return acquirerMember;
	}
	public void setAcquirerMember(String acquirerMember) {
		this.acquirerMember = acquirerMember;
	}
	public int getAcquirerBankCode() {
		return acquirerBankCode;
	}
	public void setAcquirerBankCode(int acquirerBankCode) {
		this.acquirerBankCode = acquirerBankCode;
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
	public double getAcquirerFees() {
		return acquirerFees;
	}
	public void setAcquirerFees(double acquirerFees) {
		this.acquirerFees = acquirerFees;
	}
	public double getIssuerFees() {
		return issuerFees;
	}
	public void setIssuerFees(double issuerFees) {
		this.issuerFees = issuerFees;
	}
	public double getNettFees() {
		return nettFees;
	}
	public void setNettFees(double nettFees) {
		this.nettFees = nettFees;
	}
	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
}
