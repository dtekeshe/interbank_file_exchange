package com.bsva.dmcs.reportv02.dto;

public class CCR002ReportsDTO {
	
	private String issuerMember;
	private String issuerCode;
	private String acquirerMember;
	private String acquirerCode;
	private String service;
	private String sub_service;
	private String acqFees;
	private String issFees;
	private String nettFees;
	private String invoiceNoCcr001;
	
	public CCR002ReportsDTO() {
	}

	public CCR002ReportsDTO(String issuerMember, String issuerCode, String acquirerMember, String acquirerCode,
			String service, String sub_service, String acqFees, String issFees, String nettFees, String invoiceNoCcr001) {
		super();
		this.issuerMember = issuerMember;
		this.issuerCode = issuerCode;
		this.acquirerMember = acquirerMember;
		this.acquirerCode = acquirerCode;
		this.service = service;
		this.sub_service = sub_service;
		this.acqFees = acqFees;
		this.issFees = issFees;
		this.nettFees = nettFees;
		this.invoiceNoCcr001 = invoiceNoCcr001;
	}

	public String getIssuerMember() {
		return issuerMember;
	}

	public String getIssuerCode() {
		return issuerCode;
	}

	public String getAcquirerMember() {
		return acquirerMember;
	}

	public String getAcquirerCode() {
		return acquirerCode;
	}

	public String getService() {
		return service;
	}

	public String getSub_service() {
		return sub_service;
	}

	public String getAcqFees() {
		return acqFees;
	}

	public String getIssFees() {
		return issFees;
	}

	public String getNettFees() {
		return nettFees;
	}

	public String getInvoiceNoCcr001() {
		return invoiceNoCcr001;
	}

	public void setIssuerMember(String issuerMember) {
		this.issuerMember = issuerMember;
	}

	public void setIssuerCode(String issuerCode) {
		this.issuerCode = issuerCode;
	}

	public void setAcquirerMember(String acquirerMember) {
		this.acquirerMember = acquirerMember;
	}

	public void setAcquirerCode(String acquirerCode) {
		this.acquirerCode = acquirerCode;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setSub_service(String sub_service) {
		this.sub_service = sub_service;
	}

	public void setAcqFees(String acqFees) {
		this.acqFees = acqFees;
	}

	public void setIssFees(String issFees) {
		this.issFees = issFees;
	}

	public void setNettFees(String nettFees) {
		this.nettFees = nettFees;
	}

	public void setInvoiceNoCcr001(String invoiceNoCcr001) {
		this.invoiceNoCcr001 = invoiceNoCcr001;
	}

}
