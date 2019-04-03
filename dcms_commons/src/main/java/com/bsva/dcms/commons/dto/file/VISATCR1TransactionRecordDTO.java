package com.bsva.dcms.commons.dto.file;

public class VISATCR1TransactionRecordDTO extends VisaTCRTransactionsDTO{

//	private String issuerWorkstationBIN; 
//	private String acquirerWorkstationBIN;
	private String chargebackReferenceNumber;
	private String documentationIndicator;
	private String memberMessageText;
	private String specialConditionIndicators;
	private String feeProgramIndicator;
	private String issuerCharge;
	private String reserved;
	private String cardAcceptorID;
	private String terminalID;
	private String nationalReimbursementFee;
	private String mail_TelephoneElectronicCommerceIndicator;
	private String specialChargebackIndicator;
	private String interfaceTraceNumber;
	private String unattendedAcceptanceTerminalIndicator;
	private String prepaidCardIndicator;
	private String serviceDevelopmentField;
	private String avsResponseCode;
	private String authorizationSourceCode;
	private String purchaseIdentifierFormat;
	private String atmAccountSelection;
	private String installmentPaymentCount;
	private String purchaseIdentifier;
	private String cashback;
	private String chipConditionCode;
	private String posEnvironment;
	private String posEntryMode;
	private String chipCard;
	private String terminalCapability;
	private String cardHolderId;
	private String eCommInd;
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
	public String geteCommInd() {
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
	//	public String getIssuerWorkstationBIN() {
//		return issuerWorkstationBIN;
//	}
//	public void setIssuerWorkstationBIN(String issuerWorkstationBIN) {
//		this.issuerWorkstationBIN = issuerWorkstationBIN;
//	}
//	public String getAcquirerWorkstationBIN() {
//		return acquirerWorkstationBIN;
//	}
//	public void setAcquirerWorkstationBIN(String acquirerWorkstationBIN) {
//		this.acquirerWorkstationBIN = acquirerWorkstationBIN;
//	}
	public String getChargebackReferenceNumber() {
		return chargebackReferenceNumber;
	}
	public void setChargebackReferenceNumber(String chargebackReferenceNumber) {
		this.chargebackReferenceNumber = chargebackReferenceNumber;
	}
	public String getDocumentationIndicator() {
		return documentationIndicator;
	}
	public void setDocumentationIndicator(String documentationIndicator) {
		this.documentationIndicator = documentationIndicator;
	}
	public String getMemberMessageText() {
		return memberMessageText;
	}
	public void setMemberMessageText(String memberMessageText) {
		this.memberMessageText = memberMessageText;
	}
	public String getSpecialConditionIndicators() {
		return specialConditionIndicators;
	}
	public void setSpecialConditionIndicators(String specialConditionIndicators) {
		this.specialConditionIndicators = specialConditionIndicators;
	}
	public String getFeeProgramIndicator() {
		return feeProgramIndicator;
	}
	public void setFeeProgramIndicator(String feeProgramIndicator) {
		this.feeProgramIndicator = feeProgramIndicator;
	}
	public String getIssuerCharge() {
		return issuerCharge;
	}
	public void setIssuerCharge(String issuerCharge) {
		this.issuerCharge = issuerCharge;
	}
	public String getReserved() {
		return reserved;
	}
	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
	public String getCardAcceptorID() {
		return cardAcceptorID;
	}
	public void setCardAcceptorID(String cardAcceptorID) {
		this.cardAcceptorID = cardAcceptorID;
	}
	public String getTerminalID() {
		return terminalID;
	}
	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}
	public String getNationalReimbursementFee() {
		return nationalReimbursementFee;
	}
	public void setNationalReimbursementFee(String nationalReimbursementFee) {
		this.nationalReimbursementFee = nationalReimbursementFee;
	}

	public String getMail_TelephoneElectronicCommerceIndicator() {
		return mail_TelephoneElectronicCommerceIndicator;
	}
	public void setMail_TelephoneElectronicCommerceIndicator(
			String mail_TelephoneElectronicCommerceIndicator) {
		this.mail_TelephoneElectronicCommerceIndicator = mail_TelephoneElectronicCommerceIndicator;
	}
	public String getSpecialChargebackIndicator() {
		return specialChargebackIndicator;
	}
	public void setSpecialChargebackIndicator(String specialChargebackIndicator) {
		this.specialChargebackIndicator = specialChargebackIndicator;
	}
	public String getInterfaceTraceNumber() {
		return interfaceTraceNumber;
	}
	public void setInterfaceTraceNumber(String interfaceTraceNumber) {
		this.interfaceTraceNumber = interfaceTraceNumber;
	}
	public String getUnattendedAcceptanceTerminalIndicator() {
		return unattendedAcceptanceTerminalIndicator;
	}
	public void setUnattendedAcceptanceTerminalIndicator(String unattendedAcceptanceTerminalIndicator) {
		this.unattendedAcceptanceTerminalIndicator = unattendedAcceptanceTerminalIndicator;
	}
	public String getPrepaidCardIndicator() {
		return prepaidCardIndicator;
	}
	public void setPrepaidCardIndicator(String prepaidCardIndicator) {
		this.prepaidCardIndicator = prepaidCardIndicator;
	}
	public String getServiceDevelopmentField() {
		return serviceDevelopmentField;
	}
	public void setServiceDevelopmentField(String serviceDevelopmentField) {
		this.serviceDevelopmentField = serviceDevelopmentField;
	}
	public String getAvsResponseCode() {
		return avsResponseCode;
	}
	public void setAvsResponseCode(String avsResponseCode) {
		this.avsResponseCode = avsResponseCode;
	}
	public String getAuthorizationSourceCode() {
		return authorizationSourceCode;
	}
	public void setAuthorizationSourceCode(String authorizationSourceCode) {
		this.authorizationSourceCode = authorizationSourceCode;
	}
	public String getPurchaseIdentifierFormat() {
		return purchaseIdentifierFormat;
	}
	public void setPurchaseIdentifierFormat(String purchaseIdentifierFormat) {
		this.purchaseIdentifierFormat = purchaseIdentifierFormat;
	}
	public String getAtmAccountSelection() {
		return atmAccountSelection;
	}
	public void setAtmAccountSelection(String atmAccountSelection) {
		this.atmAccountSelection = atmAccountSelection;
	}
	
	public String getInstallmentPaymentCount() {
		return installmentPaymentCount;
	}
	public void setInstallmentPaymentCount(String installmentPaymentCount) {
		this.installmentPaymentCount = installmentPaymentCount;
	}
	public String getPurchaseIdentifier() {
		return purchaseIdentifier;
	}
	public void setPurchaseIdentifier(String purchaseIdentifier) {
		this.purchaseIdentifier = purchaseIdentifier;
	}
	public String getCashback() {
		return cashback;
	}
	public void setCashback(String cashback) {
		this.cashback = cashback;
	}
	public String getChipConditionCode() {
		return chipConditionCode;
	}
	public void setChipConditionCode(String chipConditionCode) {
		this.chipConditionCode = chipConditionCode;
	}
	public String getPosEnvironment() {
		return posEnvironment;
	}
	public void setPosEnvironment(String posEnvironment) {
		this.posEnvironment = posEnvironment;
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
