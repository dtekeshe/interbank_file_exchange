package com.bsva.dcms.commons.dto.file;

public class VISATCR5TransactionRecordDTO extends VisaTCRTransactionsDTO {

	private String transactionIdentifier;
	private String authorizedAmount;
	private String authorizationCurrencyCode;
	private String authorizationResponseCode;
	private String validationCode;
	private String excludedTransactionIdentifierReason;
	private String crsProcessingCode;
	private String chargebackRightsIndicator;
	private String multipleClearingSequenceNumber;
	private String multipleClearingSequenceCount;
	private String marketSpecificAuthorizationDataIndicator;
	private String totalAuthorizedAmount;
	private String informationIndicator;
	private String merchantTelephoneNumber;
	private String additionalDataIndicator;
	private String merchantVolumeIndicator; 
	private String electronicCommerceGoodsIndicator;
	private String merchantVerificationValue;
	private String interchangeFeeAmount;
	private String interchangeFeeSign;
	private String sourceCurrencyToBaseCurrencyExchangeRate;
	private String baseCurrencyToDestinationCurrencyExchangeRate;
	private String optionalIssuerISAAmount;
	private String reserved1;
	private String cvv2ResultCode;
	private String fileName;
	

	private String record;
	private int lineNumber;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getTransactionIdentifier() {
		return transactionIdentifier;
	}
	public void setTransactionIdentifier(String transactionIdentifier) {
		this.transactionIdentifier = transactionIdentifier;
	}
	public String getAuthorizedAmount() {
		return authorizedAmount;
	}
	public void setAuthorizedAmount(String authorizedAmount) {
		this.authorizedAmount = authorizedAmount;
	}
	public String getAuthorizationCurrencyCode() {
		return authorizationCurrencyCode;
	}
	public void setAuthorizationCurrencyCode(String authorizationCurrencyCode) {
		this.authorizationCurrencyCode = authorizationCurrencyCode;
	}
	public String getAuthorizationResponseCode() {
		return authorizationResponseCode;
	}
	public void setAuthorizationResponseCode(String authorizationResponseCode) {
		this.authorizationResponseCode = authorizationResponseCode;
	}
	public String getValidationCode() {
		return validationCode;
	}
	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}
	public String getExcludedTransactionIdentifierReason() {
		return excludedTransactionIdentifierReason;
	}
	public void setExcludedTransactionIdentifierReason(
			String excludedTransactionIdentifierReason) {
		this.excludedTransactionIdentifierReason = excludedTransactionIdentifierReason;
	}
	public String getCrsProcessingCode() {
		return crsProcessingCode;
	}
	public void setCrsProcessingCode(String crsProcessingCode) {
		this.crsProcessingCode = crsProcessingCode;
	}
	public String getChargebackRightsIndicator() {
		return chargebackRightsIndicator;
	}
	public void setChargebackRightsIndicator(String chargebackRightsIndicator) {
		this.chargebackRightsIndicator = chargebackRightsIndicator;
	}
	public String getMultipleClearingSequenceNumber() {
		return multipleClearingSequenceNumber;
	}
	public void setMultipleClearingSequenceNumber(String multipleClearingSequenceNumber) {
		this.multipleClearingSequenceNumber = multipleClearingSequenceNumber;
	}
	public String getMultipleClearingSequenceCount() {
		return multipleClearingSequenceCount;
	}
	public void setMultipleClearingSequenceCount(
			String multipleClearingSequenceCount) {
		this.multipleClearingSequenceCount = multipleClearingSequenceCount;
	}
	public String getMarketSpecificAuthorizationDataIndicator() {
		return marketSpecificAuthorizationDataIndicator;
	}
	public void setMarketSpecificAuthorizationDataIndicator(
			String marketSpecificAuthorizationDataIndicator) {
		this.marketSpecificAuthorizationDataIndicator = marketSpecificAuthorizationDataIndicator;
	}
	public String getTotalAuthorizedAmount() {
		return totalAuthorizedAmount;
	}
	public void setTotalAuthorizedAmount(String totalAuthorizedAmount) {
		this.totalAuthorizedAmount = totalAuthorizedAmount;
	}
	public String getInformationIndicator() {
		return informationIndicator;
	}
	public void setInformationIndicator(String informationIndicator) {
		this.informationIndicator = informationIndicator;
	}
	public String getMerchantTelephoneNumber() {
		return merchantTelephoneNumber;
	}
	public void setMerchantTelephoneNumber(String merchantTelephoneNumber) {
		this.merchantTelephoneNumber = merchantTelephoneNumber;
	}
	public String getAdditionalDataIndicator() {
		return additionalDataIndicator;
	}
	public void setAdditionalDataIndicator(String additionalDataIndicator) {
		this.additionalDataIndicator = additionalDataIndicator;
	}
	public String getMerchantVolumeIndicator() {
		return merchantVolumeIndicator;
	}
	public void setMerchantVolumeIndicator(String merchantVolumeIndicator) {
		this.merchantVolumeIndicator = merchantVolumeIndicator;
	}
	public String getElectronicCommerceGoodsIndicator() {
		return electronicCommerceGoodsIndicator;
	}
	public void setElectronicCommerceGoodsIndicator(
			String electronicCommerceGoodsIndicator) {
		this.electronicCommerceGoodsIndicator = electronicCommerceGoodsIndicator;
	}
	public String getMerchantVerificationValue() {
		return merchantVerificationValue;
	}
	public void setMerchantVerificationValue(String merchantVerificationValue) {
		this.merchantVerificationValue = merchantVerificationValue;
	}
	public String getInterchangeFeeAmount() {
		return interchangeFeeAmount;
	}
	public void setInterchangeFeeAmount(String interchangeFeeAmount) {
		this.interchangeFeeAmount = interchangeFeeAmount;
	}
	public String getInterchangeFeeSign() {
		return interchangeFeeSign;
	}
	public void setInterchangeFeeSign(String interchangeFeeSign) {
		this.interchangeFeeSign = interchangeFeeSign;
	}
	public String getSourceCurrencyToBaseCurrencyExchangeRate() {
		return sourceCurrencyToBaseCurrencyExchangeRate;
	}
	public void setSourceCurrencyToBaseCurrencyExchangeRate(
			String sourceCurrencyToBaseCurrencyExchangeRate) {
		this.sourceCurrencyToBaseCurrencyExchangeRate = sourceCurrencyToBaseCurrencyExchangeRate;
	}
	public String getBaseCurrencyToDestinationCurrencyExchangeRate() {
		return baseCurrencyToDestinationCurrencyExchangeRate;
	}
	public void setBaseCurrencyToDestinationCurrencyExchangeRate(
			String baseCurrencyToDestinationCurrencyExchangeRate) {
		this.baseCurrencyToDestinationCurrencyExchangeRate = baseCurrencyToDestinationCurrencyExchangeRate;
	}
	public String getOptionalIssuerISAAmount() {
		return optionalIssuerISAAmount;
	}
	public void setOptionalIssuerISAAmount(String optionalIssuerISAAmount) {
		this.optionalIssuerISAAmount = optionalIssuerISAAmount;
	}
	public String getReserved1() {
		return reserved1;
	}
	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}
	public String getCvv2ResultCode() {
		return cvv2ResultCode;
	}
	public void setCvv2ResultCode(String cvv2ResultCode) {
		this.cvv2ResultCode = cvv2ResultCode;
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
