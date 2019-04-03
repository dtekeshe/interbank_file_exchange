package com.bsva.dcms.commons.dto.file;

public class VISATCR0TransactionRecordDTO extends VisaTCRTransactionsDTO {

	
	private String issuerWorkstationBIN; 
	private String acquirerWorkstationBIN;
	private String accountNumber;
	private String accNoExtension;
	private String floorLimitIndicator;
	private String exceptionfileInd;
	private String pcasIndicator;
	private String acqReferenceNo;
	private String acqBusinessID;
	private String purchaseDate;
	private String destinationAmount;
	private String destCurrencyCode;
	private String sourceAmount;
	private String sourceCurrencyCode;
	private String merchantName;
	private String merchantCity;
	private String merchantCountry;
	private String merchantCatCode;
	private String merchantZIPCode;
	private String merchantStateCode;
	private String requestPaymentInd;
	private String filler;
	private String usageCode;
	private String reasonCode;
	private String settlementFlag;
	private String authorisationIndicator;
	private String authorisationCode;
	private String posTermCapability;
	private String internationalFeeInd;
	private String cardholderIDMethod;
	private String collectionOnlyFlag;
	private String posEntryMode;
	private String chipCard;
	private String terminalCapability;
	private String cardHolderId;
	private String eCommInd;
	private String centralProcDate;
	private String reimbursementAttrbte;
	private String fileName;
	private String record;
	private int lineNumber;
	private String subServices;
	
	public String getSubServices() {
		return subServices;
	}

	public void setSubServices(String subServices) {
		this.subServices = subServices;
	}
	
	
	public String getPosEntryMode() {
		return posEntryMode;
	}
	public String getChipCard() {
		return chipCard;
	}
	public String getTerminalCapability() {
		return terminalCapability;
	}
	public String getCardHolderId() {
		return cardHolderId;
	}
	public String getECommInd() {
		return eCommInd;
	}
	public void setPosEntryMode(String posEntryMode) {
		this.posEntryMode = posEntryMode;
	}
	public void setChipCard(String chipCard) {
		this.chipCard = chipCard;
	}
	public void setTerminalCapability(String terminalCapability) {
		this.terminalCapability = terminalCapability;
	}
	public void setCardHolderId(String cardHolderId) {
		this.cardHolderId = cardHolderId;
	}
	public void setECommInd(String eCommInd) {
		this.eCommInd = eCommInd;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getIssuerWorkstationBIN() {
		return issuerWorkstationBIN;
	}
	public void setIssuerWorkstationBIN(String issuerWorkstationBIN) {
		this.issuerWorkstationBIN = issuerWorkstationBIN;
	}
	public String getAcquirerWorkstationBIN() {
		return acquirerWorkstationBIN;
	}
	public void setAcquirerWorkstationBIN(String acquirerWorkstationBIN) {
		this.acquirerWorkstationBIN = acquirerWorkstationBIN;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccNoExtension() {
		return accNoExtension;
	}
	public void setAccNoExtension(String accNoExtension) {
		this.accNoExtension = accNoExtension;
	}
	public String getFloorLimitIndicator() {
		return floorLimitIndicator;
	}
	public void setFloorLimitIndicator(String floorLimitIndicator) {
		this.floorLimitIndicator = floorLimitIndicator;
	}
	public String getExceptionfileInd() {
		return exceptionfileInd;
	}
	public void setExceptionfileInd(String exceptionfileInd) {
		this.exceptionfileInd = exceptionfileInd;
	}
	public String getPcasIndicator() {
		return pcasIndicator;
	}
	public void setPcasIndicator(String pcasIndicator) {
		this.pcasIndicator = pcasIndicator;
	}
	public String getAcqReferenceNo() {
		return acqReferenceNo;
	}
	public void setAcqReferenceNo(String acqReferenceNo) {
		this.acqReferenceNo = acqReferenceNo;
	}
	public String getAcqBusinessID() {
		return acqBusinessID;
	}
	public void setAcqBusinessID(String acqBusinessID) {
		this.acqBusinessID = acqBusinessID;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getDestinationAmount() {
		return destinationAmount;
	}
	public void setDestinationAmount(String destinationAmount) {
		this.destinationAmount = destinationAmount;
	}
	public String getDestCurrencyCode() {
		return destCurrencyCode;
	}
	public void setDestCurrencyCode(String destCurrencyCode) {
		this.destCurrencyCode = destCurrencyCode;
	}
	public String getSourceAmount() {
		return sourceAmount;
	}
	public void setSourceAmount(String sourceAmount) {
		this.sourceAmount = sourceAmount;
	}
	public String getSourceCurrencyCode() {
		return sourceCurrencyCode;
	}
	public void setSourceCurrencyCode(String sourceCurrencyCode) {
		this.sourceCurrencyCode = sourceCurrencyCode;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getMerchantCity() {
		return merchantCity;
	}
	public void setMerchantCity(String merchantCity) {
		this.merchantCity = merchantCity;
	}
	public String getMerchantCountry() {
		return merchantCountry;
	}
	public void setMerchantCountry(String merchantCountry) {
		this.merchantCountry = merchantCountry;
	}
	public String getMerchantCatCode() {
		return merchantCatCode;
	}
	public void setMerchantCatCode(String merchantCatCode) {
		this.merchantCatCode = merchantCatCode;
	}
	public String getMerchantZIPCode() {
		return merchantZIPCode;
	}
	public void setMerchantZIPCode(String merchantZIPCode) {
		this.merchantZIPCode = merchantZIPCode;
	}
	public String getMerchantStateCode() {
		return merchantStateCode;
	}
	public void setMerchantStateCode(String merchantStateCode) {
		this.merchantStateCode = merchantStateCode;
	}
	public String getRequestPaymentInd() {
		return requestPaymentInd;
	}
	public void setRequestPaymentInd(String requestPaymentInd) {
		this.requestPaymentInd = requestPaymentInd;
	}
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	public String getUsageCode() {
		return usageCode;
	}
	public void setUsageCode(String usageCode) {
		this.usageCode = usageCode;
	}
	public String getReasonCode() {
		return reasonCode;
	}
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	public String getSettlementFlag() {
		return settlementFlag;
	}
	public void setSettlementFlag(String settlementFlag) {
		this.settlementFlag = settlementFlag;
	}
	public String getAuthorisationIndicator() {
		return authorisationIndicator;
	}
	public void setAuthorisationIndicator(String authorisationIndicator) {
		this.authorisationIndicator = authorisationIndicator;
	}
	public String getAuthorisationCode() {
		return authorisationCode;
	}
	public void setAuthorisationCode(String authorisationCode) {
		this.authorisationCode = authorisationCode;
	}
	public String getPosTermCapability() {
		return posTermCapability;
	}
	public void setPosTermCapability(String posTermCapability) {
		this.posTermCapability = posTermCapability;
	}
	public String getInternationalFeeInd() {
		return internationalFeeInd;
	}
	public void setInternationalFeeInd(String internationalFeeInd) {
		this.internationalFeeInd = internationalFeeInd;
	}
	public String getCardholderIDMethod() {
		return cardholderIDMethod;
	}
	public void setCardholderIDMethod(String cardholderIDMethod) {
		this.cardholderIDMethod = cardholderIDMethod;
	}
	public String getCollectionOnlyFlag() {
		return collectionOnlyFlag;
	}
	public void setCollectionOnlyFlag(String collectionOnlyFlag) {
		this.collectionOnlyFlag = collectionOnlyFlag;
	}
	public String getCentralProcDate() {
		return centralProcDate;
	}
	public void setCentralProcDate(String centralProcDate) {
		this.centralProcDate = centralProcDate;
	}
	public String getReimbursementAttrbte() {
		return reimbursementAttrbte;
	}
	public void setReimbursementAttrbte(String reimbursementAttrbte) {
		this.reimbursementAttrbte = reimbursementAttrbte;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
}
