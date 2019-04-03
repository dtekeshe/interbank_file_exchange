package com.bsva.dcms.commons.dto;

public class CsvFleetBillViewDTO {

	 private String acquirer;
	    private String issuer; 
	    private Double value;
	    private Double volume;
	    private Double percCost;
	    private String cost;
	    private Double vat;
	    private Double totalCharge;
	    private Double nettAmount;
	    private String acquirerMember;
	    private String issuerMember;
	    private Integer cardType;
	    private String cardDescription;
	    private Integer transactionCode;
	    private String transactionDescription;
	    private String reportSortSequence;
	    private String service;
	    private String subService;
	    
	    public CsvFleetBillViewDTO(){
	    	
	    }

		public String getAcquirer() {
			return acquirer;
		}

		public String getIssuer() {
			return issuer;
		}

		public Double getValue() {
			return value;
		}

		public Double getVolume() {
			return volume;
		}

		public Double getPercCost() {
			return percCost;
		}

		public String getCost() {
			return cost;
		}

		public Double getVat() {
			return vat;
		}

		public Double getTotalCharge() {
			return totalCharge;
		}

		public Double getNettAmount() {
			return nettAmount;
		}

		public String getAcquirerMember() {
			return acquirerMember;
		}

		public String getIssuerMember() {
			return issuerMember;
		}

		public Integer getCardType() {
			return cardType;
		}

		public String getCardDescription() {
			return cardDescription;
		}

		public Integer getTransactionCode() {
			return transactionCode;
		}

		public String getTransactionDescription() {
			return transactionDescription;
		}

		public String getReportSortSequence() {
			return reportSortSequence;
		}

		public String getService() {
			return service;
		}

		public String getSubService() {
			return subService;
		}

		public void setAcquirer(String acquirer) {
			this.acquirer = acquirer;
		}

		public void setIssuer(String issuer) {
			this.issuer = issuer;
		}

		public void setValue(Double value) {
			this.value = value;
		}

		public void setVolume(Double volume) {
			this.volume = volume;
		}

		public void setPercCost(Double percCost) {
			this.percCost = percCost;
		}

		public void setCost(String cost) {
			this.cost = cost;
		}

		public void setVat(Double vat) {
			this.vat = vat;
		}

		public void setTotalCharge(Double totalCharge) {
			this.totalCharge = totalCharge;
		}

		public void setNettAmount(Double nettAmount) {
			this.nettAmount = nettAmount;
		}

		public void setAcquirerMember(String acquirerMember) {
			this.acquirerMember = acquirerMember;
		}

		public void setIssuerMember(String issuerMember) {
			this.issuerMember = issuerMember;
		}

		public void setCardType(Integer cardType) {
			this.cardType = cardType;
		}

		public void setCardDescription(String cardDescription) {
			this.cardDescription = cardDescription;
		}

		public void setTransactionCode(Integer transactionCode) {
			this.transactionCode = transactionCode;
		}

		public void setTransactionDescription(String transactionDescription) {
			this.transactionDescription = transactionDescription;
		}

		public void setReportSortSequence(String reportSortSequence) {
			this.reportSortSequence = reportSortSequence;
		}

		public void setService(String service) {
			this.service = service;
		}

		public void setSubService(String subService) {
			this.subService = subService;
		}

	}

