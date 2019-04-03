package com.bsva.dcms.commons.dto;

public class TransactionsViewDTO {
	
	private int AcquirerMember;
	private String AcquirerName;
	private int AcquirerBin;
	private int issuerMember;
	private String issuerName;
	private int issuerBin;
    private String service;
    private String subService;
    private int  cardType;
    private String cardDescription;
    private int transactioCode;
    private double transAmount;
    private int transSeqNumber;
    private String cashBackPresent ;
    private int cashBackAmount;
    private String transStatus;
    private String fileStatus;
    private int messageTypeind;
    private int merchantCatCode;
    private int inchgRateDsgn;
    private int messageReasonCode;
    private double billingFee;
    private double billingFeeAmount;
    private double billingVat;
    private double cbBillFee;
    private double cbBillAmnt;
    private double cdBillVat;
    private double interChangeFee;
    private double interChangeFeeAmount;
    private double inputVat;
    private double destReport;
    private double amountDirection;
    private double reportSortSequence;
    private double cbInterchangeFee;
    private double cbInterchangeFeeAmount;
    private double cashbackInputVat;
    private int cashbackAmountDirection;
    private String fleetCountTran;
    
    
	public TransactionsViewDTO() {
		super();
	}


	public int getAcquirerMember() {
		return AcquirerMember;
	}


	public String getAcquirerName() {
		return AcquirerName;
	}


	public int getAcquirerBin() {
		return AcquirerBin;
	}


	public int getIssuerMember() {
		return issuerMember;
	}


	public String getIssuerName() {
		return issuerName;
	}


	public int getIssuerBin() {
		return issuerBin;
	}


	public String getService() {
		return service;
	}


	public String getSubService() {
		return subService;
	}


	public int getCardType() {
		return cardType;
	}


	public String getCardDescription() {
		return cardDescription;
	}


	public int getTransactioCode() {
		return transactioCode;
	}


	public double getTransAmount() {
		return transAmount;
	}


	public int getTransSeqNumber() {
		return transSeqNumber;
	}


	public String getCashBackPresent() {
		return cashBackPresent;
	}


	public int getCashBackAmount() {
		return cashBackAmount;
	}


	public String getTransStatus() {
		return transStatus;
	}


	public String getFileStatus() {
		return fileStatus;
	}


	public int getMessageTypeind() {
		return messageTypeind;
	}


	public int getMerchantCatCode() {
		return merchantCatCode;
	}


	public int getInchgRateDsgn() {
		return inchgRateDsgn;
	}


	public int getMessageReasonCode() {
		return messageReasonCode;
	}


	public double getBillingFee() {
		return billingFee;
	}


	public double getBillingFeeAmount() {
		return billingFeeAmount;
	}


	public double getBillingVat() {
		return billingVat;
	}


	public double getCbBillFee() {
		return cbBillFee;
	}


	public double getCbBillAmnt() {
		return cbBillAmnt;
	}


	public double getCdBillVat() {
		return cdBillVat;
	}


	public double getInterChangeFee() {
		return interChangeFee;
	}


	public double getInterChangeFeeAmount() {
		return interChangeFeeAmount;
	}


	public double getInputVat() {
		return inputVat;
	}


	public double getDestReport() {
		return destReport;
	}


	public double getAmountDirection() {
		return amountDirection;
	}


	public double getReportSortSequence() {
		return reportSortSequence;
	}


	public double getCbInterchangeFee() {
		return cbInterchangeFee;
	}


	public double getCbInterchangeFeeAmount() {
		return cbInterchangeFeeAmount;
	}


	public double getCashbackInputVat() {
		return cashbackInputVat;
	}


	public int getCashbackAmountDirection() {
		return cashbackAmountDirection;
	}


	public String getFleetCountTran() {
		return fleetCountTran;
	}


	public void setAcquirerMember(int acquirerMember) {
		AcquirerMember = acquirerMember;
	}


	public void setAcquirerName(String acquirerName) {
		AcquirerName = acquirerName;
	}


	public void setAcquirerBin(int acquirerBin) {
		AcquirerBin = acquirerBin;
	}


	public void setIssuerMember(int issuerMember) {
		this.issuerMember = issuerMember;
	}


	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}


	public void setIssuerBin(int issuerBin) {
		this.issuerBin = issuerBin;
	}


	public void setService(String service) {
		this.service = service;
	}


	public void setSubService(String subService) {
		this.subService = subService;
	}


	public void setCardType(int cardType) {
		this.cardType = cardType;
	}


	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}


	public void setTransactioCode(int transactioCode) {
		this.transactioCode = transactioCode;
	}


	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}


	public void setTransSeqNumber(int transSeqNumber) {
		this.transSeqNumber = transSeqNumber;
	}


	public void setCashBackPresent(String cashBackPresent) {
		this.cashBackPresent = cashBackPresent;
	}


	public void setCashBackAmount(int cashBackAmount) {
		this.cashBackAmount = cashBackAmount;
	}


	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}


	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}


	public void setMessageTypeind(int messageTypeind) {
		this.messageTypeind = messageTypeind;
	}


	public void setMerchantCatCode(int merchantCatCode) {
		this.merchantCatCode = merchantCatCode;
	}


	public void setInchgRateDsgn(int inchgRateDsgn) {
		this.inchgRateDsgn = inchgRateDsgn;
	}


	public void setMessageReasonCode(int messageReasonCode) {
		this.messageReasonCode = messageReasonCode;
	}


	public void setBillingFee(double billingFee) {
		this.billingFee = billingFee;
	}


	public void setBillingFeeAmount(double billingFeeAmount) {
		this.billingFeeAmount = billingFeeAmount;
	}


	public void setBillingVat(double billingVat) {
		this.billingVat = billingVat;
	}


	public void setCbBillFee(double cbBillFee) {
		this.cbBillFee = cbBillFee;
	}


	public void setCbBillAmnt(double cbBillAmnt) {
		this.cbBillAmnt = cbBillAmnt;
	}


	public void setCdBillVat(double cdBillVat) {
		this.cdBillVat = cdBillVat;
	}


	public void setInterChangeFee(double interChangeFee) {
		this.interChangeFee = interChangeFee;
	}


	public void setInterChangeFeeAmount(double interChangeFeeAmount) {
		this.interChangeFeeAmount = interChangeFeeAmount;
	}


	public void setInputVat(double inputVat) {
		this.inputVat = inputVat;
	}


	public void setDestReport(double destReport) {
		this.destReport = destReport;
	}


	public void setAmountDirection(double amountDirection) {
		this.amountDirection = amountDirection;
	}


	public void setReportSortSequence(double reportSortSequence) {
		this.reportSortSequence = reportSortSequence;
	}


	public void setCbInterchangeFee(double cbInterchangeFee) {
		this.cbInterchangeFee = cbInterchangeFee;
	}


	public void setCbInterchangeFeeAmount(double cbInterchangeFeeAmount) {
		this.cbInterchangeFeeAmount = cbInterchangeFeeAmount;
	}


	public void setCashbackInputVat(double cashbackInputVat) {
		this.cashbackInputVat = cashbackInputVat;
	}


	public void setCashbackAmountDirection(int cashbackAmountDirection) {
		this.cashbackAmountDirection = cashbackAmountDirection;
	}


	public void setFleetCountTran(String fleetCountTran) {
		this.fleetCountTran = fleetCountTran;
	}
    
    
    
    

}
