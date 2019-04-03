package com.bsva.dcms.commons.dto;

import java.io.Serializable;

public class CSOPaymentInstructionMcardDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String fileRefNumber1;
    private int systemSequenceNumber2;
    private String serviceCode;
    private String subServiceName;
    private int acquierMember;
    private int issuerMember;
    private int masterCardAmount;
    private String financialIndicator;
    private String primaryBitmap;
    private String secondaryBitmap;
    private int messageTypeIndicator;
    private int p2PanLength;
    private String p2Pan;
    private int p3ProcessCode;
    private int p4TransactionAmount;
    private int p5ReconciliationAmount;
    private int p6cardholderBilling;
    private int p7TransactionDateAndTime;
    private int p8ICCRAmount;
    private int p9ReconConversationRate;
    private int p10CardHolderConvRate;
    private int p11SystemTraceAuditNumber;
    private int p12LocalDate;
    private int p13LocalTime;
    private int p14ExpirationDate;
    private int p15SettlementDate;
    private int p16ConversionDate;
    private int p17CaptureDate;
    private int p18MerchanType;
    private int p19AcqInstitutionCode;
    private int p20CountryCodePriAccNo;
    private int p21FwidingInstCountryCode;
    private String p22PointOfSaleData;
    private int p23CardSequenceNumber;
    private int p24FunctionCode;
    private int p25MessageReasonCode;
    private int p26CardAcceptorBusCode;
    private int p27AuthIdResponseLength;
    private int p28TransactionFeeAmount;
    private int p29SettlementFeeAmount;
    private String p3OriginalAmount;
    private int p31AcquireRefLentgh;
    private int p31AcquireRefData;
    private int p32AcquiringInstLength;
    private int p32AcquiringInstCode;
    private int p33ForwardingInstLength;
    private int p33ForwardingInstCode;
    private String p34ExtendedAccountNumber;
    private String p35Track2Data;
    private String p36Track3Data;
    private String p37RetrievalRefNumber;
    private String p38ApprovalCode;
    private String p39ResponseCode;
    private int p40ServiceCode;
    private String p41CardAcceptorTerminalId;
    private String p42CardAcceptorId;
    private int p43CardAcceptorLength;
    private String p43CardAcceptorName;
    private String p44AdditionalResponseData;
    private String p45Track1Data;
    private String p46AdditionalDataISO;
    private String p47AdditionalDataNational;
    private String p48AdditionalDataLength;
    private String p48AdditionalData;
    private int p49CurrencyCode;
    private int p50ReconciliationCode;
    private int p51CardHolderBillCurCode;
    private String p52PersonalIdNumber;
    private int p53SecurityRelControlInfo;
    private int p54AdditionalAmntLength;
    private String p54AdditionalAmounts;
    private int p5ICCLength;
    private String p55ICCSystemRelatedData;
    private int p6AddLen;
    private String p62AdditionalData;
    private int p63TxLifeCycleIdLength;
    private String p63TransactioLifeCyclId;
    private String p64PrimaryMac;
    private String s66SettlementCode;
    private int s67ExtendedPaymentCode;
    private int s68ReInstCountryCode;
    private int s69SettleInstCountryCode;
    private int s70NetworkManCountryCode;
    private int s71MessageNumber;
    private int s72DataLen;
    private String s72DataRecord;
    private int s7ActionDate;
    private int s74NoOfCredits;
    private int s75ReversalNoOfCredits;
    private int s76NoOfDebits;
    private int s77ReversalNoOfDebits;
    private int s78NumberTransfers;
    private int s79ReversalNumberTransfers;
    private int s80NumberEnquiries;
    private int s81NumberAuthorisations;
    private int s82ProcessingFeeCredits;
    private int s83TransactionFeeCredits;
    private int s84ProcessingFeeDebits;
    private int s85TransactioFeeAmounts;
    private int s86AmountCredits;
    private int s87ReversalAmountCredits;
    private int s88AmountDebits;
    private int s89ReversalAmountDebits;
    private int s90OriginatingDataElements;
    private String s91FileUpdateCode;
    private String s92FilesSecurityCode;
    private int s93Length;
    private int s93TransactionDestInstId;
    private int s94Length;
    private String s94TransactionOrigInstId;
    private int s95CardIssRefDataLength;
    private String s95CardIssuerRefData;
    private String s96MessageSecurityCode;
    private int s97NetSettlemenAmount;
    private String s98Payee;
    private int s99SettlementInstIdCode;
    private int s100RIILen;
    private int s100RcvingInstIdCode;
    private String s101FileName;
    private String s102AccountIdentification1;
    private String s103AccountIdentification2;
    private String s104TransactionDescription;
    private int s111Length;
    private String s111AmtCurrencyConversion;
    private int s123AddLen;
    private String s123AdditionalData;
    private int s124AddLen;
    private String s124AdditionalData;
    private int s125AddLen;
    private String s125AdditionalData;
    private String s127NetworkData;
    private String inputFileIdentifier;
    private int seqNo;
    private String processStatus;
    private int recordId;
    private int transactionCode;
    private String cardType;
    private String filenameDesription;
    private int p55ICCSysDataRaw;
    private int iRD;
    private String cashbackPurchase;
    private int cashbackPurchaseAmnt;
    // SARB Billing Values        
    private String posEntryMode;
    private String chipCard;
    private String terminalCapability;
    private String ecommInd;
    private String cardPresent;
    private String rateDesc;
    private Double interchangeFee;
    private Double interchangePerc;
    private Double interchasngeVat;
    private Double cashbackIcFee;
    private Double cashbackIcPerc;
    private Double cashbackIcVat;
    private String feeDataPresent;
    private String sarbBilling;

    public String getFileRefNumber1() {
        return fileRefNumber1;
    }

    public void setFileRefNumber1(String fileRefNumber1) {
        this.fileRefNumber1 = fileRefNumber1;
    }

    public int getSystemSequenceNumber2() {
        return systemSequenceNumber2;
    }

    public void setSystemSequenceNumber2(int systemSequenceNumber2) {
        this.systemSequenceNumber2 = systemSequenceNumber2;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getSubServiceName() {
        return subServiceName;
    }

    public void setSubServiceName(String subServiceName) {
        this.subServiceName = subServiceName;
    }

    public int getAcquierMember() {
        return acquierMember;
    }

    public void setAcquierMember(int acquierMember) {
        this.acquierMember = acquierMember;
    }

    public int getIssuerMember() {
        return issuerMember;
    }

    public void setIssuerMember(int issuerMember) {
        this.issuerMember = issuerMember;
    }

    public int getMasterCardAmount() {
        return masterCardAmount;
    }

    public void setMasterCardAmount(int masterCardAmount) {
        this.masterCardAmount = masterCardAmount;
    }

    public String getFinancialIndicator() {
        return financialIndicator;
    }

    public void setFinancialIndicator(String financialIndicator) {
        this.financialIndicator = financialIndicator;
    }

    public String getPrimaryBitmap() {
        return primaryBitmap;
    }

    public void setPrimaryBitmap(String primaryBitmap) {
        this.primaryBitmap = primaryBitmap;
    }

    public String getSecondaryBitmap() {
        return secondaryBitmap;
    }

    public void setSecondaryBitmap(String secondaryBitmap) {
        this.secondaryBitmap = secondaryBitmap;
    }

    public int getMessageTypeIndicator() {
        return messageTypeIndicator;
    }

    public void setMessageTypeIndicator(int messageTypeIndicator) {
        this.messageTypeIndicator = messageTypeIndicator;
    }

    public int getP2PanLength() {
        return p2PanLength;
    }

    public void setP2PanLength(int p2PanLength) {
        this.p2PanLength = p2PanLength;
    }

    public String getP2Pan() {
        return p2Pan;
    }

    public void setP2Pan(String p2Pan) {
        this.p2Pan = p2Pan;
    }

    public int getP3ProcessCode() {
        return p3ProcessCode;
    }

    public void setP3ProcessCode(int p3ProcessCode) {
        this.p3ProcessCode = p3ProcessCode;
    }

    public int getP4TransactionAmount() {
        return p4TransactionAmount;
    }

    public void setP4TransactionAmount(int p4TransactionAmount) {
        this.p4TransactionAmount = p4TransactionAmount;
    }

    public int getP5ReconciliationAmount() {
        return p5ReconciliationAmount;
    }

    public void setP5ReconciliationAmount(int p5ReconciliationAmount) {
        this.p5ReconciliationAmount = p5ReconciliationAmount;
    }

    public int getP6cardholderBilling() {
        return p6cardholderBilling;
    }

    public void setP6cardholderBilling(int p6cardholderBilling) {
        this.p6cardholderBilling = p6cardholderBilling;
    }

    public int getP7TransactionDateAndTime() {
        return p7TransactionDateAndTime;
    }

    public void setP7TransactionDateAndTime(int p7TransactionDateAndTime) {
        this.p7TransactionDateAndTime = p7TransactionDateAndTime;
    }

    public int getP8ICCRAmount() {
        return p8ICCRAmount;
    }

    public void setP8ICCRAmount(int p8iccrAmount) {
        p8ICCRAmount = p8iccrAmount;
    }

    public int getP9ReconConversationRate() {
        return p9ReconConversationRate;
    }

    public void setP9ReconConversationRate(int p9ReconConversationRate) {
        this.p9ReconConversationRate = p9ReconConversationRate;
    }

    public int getP10CardHolderConvRate() {
        return p10CardHolderConvRate;
    }

    public void setP10CardHolderConvRate(int p10CardHolderConvRate) {
        this.p10CardHolderConvRate = p10CardHolderConvRate;
    }

    public int getP11SystemTraceAuditNumber() {
        return p11SystemTraceAuditNumber;
    }

    public void setP11SystemTraceAuditNumber(int p11SystemTraceAuditNumber) {
        this.p11SystemTraceAuditNumber = p11SystemTraceAuditNumber;
    }

    public int getP12LocalDate() {
        return p12LocalDate;
    }

    public void setP12LocalDate(int p12LocalDate) {
        this.p12LocalDate = p12LocalDate;
    }

    public int getP13LocalTime() {
        return p13LocalTime;
    }

    public void setP13LocalTime(int p13LocalTime) {
        this.p13LocalTime = p13LocalTime;
    }

    public int getP14ExpirationDate() {
        return p14ExpirationDate;
    }

    public void setP14ExpirationDate(int p14ExpirationDate) {
        this.p14ExpirationDate = p14ExpirationDate;
    }

    public int getP15SettlementDate() {
        return p15SettlementDate;
    }

    public void setP15SettlementDate(int p15SettlementDate) {
        this.p15SettlementDate = p15SettlementDate;
    }

    public int getP16ConversionDate() {
        return p16ConversionDate;
    }

    public void setP16ConversionDate(int p16ConversionDate) {
        this.p16ConversionDate = p16ConversionDate;
    }

    public int getP17CaptureDate() {
        return p17CaptureDate;
    }

    public void setP17CaptureDate(int p17CaptureDate) {
        this.p17CaptureDate = p17CaptureDate;
    }

    public int getP18MerchanType() {
        return p18MerchanType;
    }

    public void setP18MerchanType(int p18MerchanType) {
        this.p18MerchanType = p18MerchanType;
    }

    public int getP19AcqInstitutionCode() {
        return p19AcqInstitutionCode;
    }

    public void setP19AcqInstitutionCode(int p19AcqInstitutionCode) {
        this.p19AcqInstitutionCode = p19AcqInstitutionCode;
    }

    public int getP20CountryCodePriAccNo() {
        return p20CountryCodePriAccNo;
    }

    public void setP20CountryCodePriAccNo(int p20CountryCodePriAccNo) {
        this.p20CountryCodePriAccNo = p20CountryCodePriAccNo;
    }

    public int getP21FwidingInstCountryCode() {
        return p21FwidingInstCountryCode;
    }

    public void setP21FwidingInstCountryCode(int p21FwidingInstCountryCode) {
        this.p21FwidingInstCountryCode = p21FwidingInstCountryCode;
    }

    public String getP22PointOfSaleData() {
        return p22PointOfSaleData;
    }

    public void setP22PointOfSaleData(String p22PointOfSaleData) {
        this.p22PointOfSaleData = p22PointOfSaleData;
    }

    public int getP23CardSequenceNumber() {
        return p23CardSequenceNumber;
    }

    public void setP23CardSequenceNumber(int p23CardSequenceNumber) {
        this.p23CardSequenceNumber = p23CardSequenceNumber;
    }

    public int getP24FunctionCode() {
        return p24FunctionCode;
    }

    public void setP24FunctionCode(int p24FunctionCode) {
        this.p24FunctionCode = p24FunctionCode;
    }

    public int getP25MessageReasonCode() {
        return p25MessageReasonCode;
    }

    public void setP25MessageReasonCode(int p25MessageReasonCode) {
        this.p25MessageReasonCode = p25MessageReasonCode;
    }

    public int getP26CardAcceptorBusCode() {
        return p26CardAcceptorBusCode;
    }

    public void setP26CardAcceptorBusCode(int p26CardAcceptorBusCode) {
        this.p26CardAcceptorBusCode = p26CardAcceptorBusCode;
    }

    public int getP27AuthIdResponseLength() {
        return p27AuthIdResponseLength;
    }

    public void setP27AuthIdResponseLength(int p27AuthIdResponseLength) {
        this.p27AuthIdResponseLength = p27AuthIdResponseLength;
    }

    public int getP28TransactionFeeAmount() {
        return p28TransactionFeeAmount;
    }

    public void setP28TransactionFeeAmount(int p28TransactionFeeAmount) {
        this.p28TransactionFeeAmount = p28TransactionFeeAmount;
    }

    public int getP29SettlementFeeAmount() {
        return p29SettlementFeeAmount;
    }

    public void setP29SettlementFeeAmount(int p29SettlementFeeAmount) {
        this.p29SettlementFeeAmount = p29SettlementFeeAmount;
    }

    public String getP3OriginalAmount() {
        return p3OriginalAmount;
    }

    public void setP3OriginalAmount(String p3OriginalAmount) {
        this.p3OriginalAmount = p3OriginalAmount;
    }

    public int getP31AcquireRefLentgh() {
        return p31AcquireRefLentgh;
    }

    public void setP31AcquireRefLentgh(int p31AcquireRefLentgh) {
        this.p31AcquireRefLentgh = p31AcquireRefLentgh;
    }

    public int getP31AcquireRefData() {
        return p31AcquireRefData;
    }

    public void setP31AcquireRefData(int p31AcquireRefData) {
        this.p31AcquireRefData = p31AcquireRefData;
    }

    public int getP32AcquiringInstLength() {
        return p32AcquiringInstLength;
    }

    public void setP32AcquiringInstLength(int p32AcquiringInstLength) {
        this.p32AcquiringInstLength = p32AcquiringInstLength;
    }

    public int getP32AcquiringInstCode() {
        return p32AcquiringInstCode;
    }

    public void setP32AcquiringInstCode(int p32AcquiringInstCode) {
        this.p32AcquiringInstCode = p32AcquiringInstCode;
    }

    public int getP33ForwardingInstLength() {
        return p33ForwardingInstLength;
    }

    public void setP33ForwardingInstLength(int p33ForwardingInstLength) {
        this.p33ForwardingInstLength = p33ForwardingInstLength;
    }

    public int getP33ForwardingInstCode() {
        return p33ForwardingInstCode;
    }

    public void setP33ForwardingInstCode(int p33ForwardingInstCode) {
        this.p33ForwardingInstCode = p33ForwardingInstCode;
    }

    public String getP34ExtendedAccountNumber() {
        return p34ExtendedAccountNumber;
    }

    public void setP34ExtendedAccountNumber(String p34ExtendedAccountNumber) {
        this.p34ExtendedAccountNumber = p34ExtendedAccountNumber;
    }

    public String getP35Track2Data() {
        return p35Track2Data;
    }

    public void setP35Track2Data(String p35Track2Data) {
        this.p35Track2Data = p35Track2Data;
    }

    public String getP36Track3Data() {
        return p36Track3Data;
    }

    public void setP36Track3Data(String p36Track3Data) {
        this.p36Track3Data = p36Track3Data;
    }

    public String getP37RetrievalRefNumber() {
        return p37RetrievalRefNumber;
    }

    public void setP37RetrievalRefNumber(String p37RetrievalRefNumber) {
        this.p37RetrievalRefNumber = p37RetrievalRefNumber;
    }

    public String getP38ApprovalCode() {
        return p38ApprovalCode;
    }

    public void setP38ApprovalCode(String p38ApprovalCode) {
        this.p38ApprovalCode = p38ApprovalCode;
    }

    public String getP39ResponseCode() {
        return p39ResponseCode;
    }

    public void setP39ResponseCode(String p39ResponseCode) {
        this.p39ResponseCode = p39ResponseCode;
    }

    public int getP40ServiceCode() {
        return p40ServiceCode;
    }

    public void setP40ServiceCode(int p40ServiceCode) {
        this.p40ServiceCode = p40ServiceCode;
    }

    public String getP41CardAcceptorTerminalId() {
        return p41CardAcceptorTerminalId;
    }

    public void setP41CardAcceptorTerminalId(String p41CardAcceptorTerminalId) {
        this.p41CardAcceptorTerminalId = p41CardAcceptorTerminalId;
    }

    public String getP42CardAcceptorId() {
        return p42CardAcceptorId;
    }

    public void setP42CardAcceptorId(String p42CardAcceptorId) {
        this.p42CardAcceptorId = p42CardAcceptorId;
    }

    public int getP43CardAcceptorLength() {
        return p43CardAcceptorLength;
    }

    public void setP43CardAcceptorLength(int p43CardAcceptorLength) {
        this.p43CardAcceptorLength = p43CardAcceptorLength;
    }

    public String getP43CardAcceptorName() {
        return p43CardAcceptorName;
    }

    public void setP43CardAcceptorName(String p43CardAcceptorName) {
        this.p43CardAcceptorName = p43CardAcceptorName;
    }

    public String getP44AdditionalResponseData() {
        return p44AdditionalResponseData;
    }

    public void setP44AdditionalResponseData(String p44AdditionalResponseData) {
        this.p44AdditionalResponseData = p44AdditionalResponseData;
    }

    public String getP45Track1Data() {
        return p45Track1Data;
    }

    public void setP45Track1Data(String p45Track1Data) {
        this.p45Track1Data = p45Track1Data;
    }

    public String getP46AdditionalDataISO() {
        return p46AdditionalDataISO;
    }

    public void setP46AdditionalDataISO(String p46AdditionalDataISO) {
        this.p46AdditionalDataISO = p46AdditionalDataISO;
    }

    public String getP47AdditionalDataNational() {
        return p47AdditionalDataNational;
    }

    public void setP47AdditionalDataNational(String p47AdditionalDataNational) {
        this.p47AdditionalDataNational = p47AdditionalDataNational;
    }

    public String getP48AdditionalDataLength() {
        return p48AdditionalDataLength;
    }

    public void setP48AdditionalDataLength(String p48AdditionalDataLength) {
        this.p48AdditionalDataLength = p48AdditionalDataLength;
    }

    public String getP48AdditionalData() {
        return p48AdditionalData;
    }

    public void setP48AdditionalData(String p48AdditionalData) {
        this.p48AdditionalData = p48AdditionalData;
    }

    public int getP49CurrencyCode() {
        return p49CurrencyCode;
    }

    public void setP49CurrencyCode(int p49CurrencyCode) {
        this.p49CurrencyCode = p49CurrencyCode;
    }

    public int getP50ReconciliationCode() {
        return p50ReconciliationCode;
    }

    public void setP50ReconciliationCode(int p50ReconciliationCode) {
        this.p50ReconciliationCode = p50ReconciliationCode;
    }

    public int getP51CardHolderBillCurCode() {
        return p51CardHolderBillCurCode;
    }

    public void setP51CardHolderBillCurCode(int p51CardHolderBillCurCode) {
        this.p51CardHolderBillCurCode = p51CardHolderBillCurCode;
    }

    public String getP52PersonalIdNumber() {
        return p52PersonalIdNumber;
    }

    public void setP52PersonalIdNumber(String p52PersonalIdNumber) {
        this.p52PersonalIdNumber = p52PersonalIdNumber;
    }

    public int getP53SecurityRelControlInfo() {
        return p53SecurityRelControlInfo;
    }

    public void setP53SecurityRelControlInfo(int p53SecurityRelControlInfo) {
        this.p53SecurityRelControlInfo = p53SecurityRelControlInfo;
    }

    public int getP54AdditionalAmntLength() {
        return p54AdditionalAmntLength;
    }

    public void setP54AdditionalAmntLength(int p54AdditionalAmntLength) {
        this.p54AdditionalAmntLength = p54AdditionalAmntLength;
    }

    public String getP54AdditionalAmounts() {
        return p54AdditionalAmounts;
    }

    public void setP54AdditionalAmounts(String p54AdditionalAmounts) {
        this.p54AdditionalAmounts = p54AdditionalAmounts;
    }

    public int getP5ICCLength() {
        return p5ICCLength;
    }

    public void setP5ICCLength(int p5iccLength) {
        p5ICCLength = p5iccLength;
    }

    public String getP55ICCSystemRelatedData() {
        return p55ICCSystemRelatedData;
    }

    public void setP55ICCSystemRelatedData(String p55iccSystemRelatedData) {
        p55ICCSystemRelatedData = p55iccSystemRelatedData;
    }

    public int getP6AddLen() {
        return p6AddLen;
    }

    public void setP6AddLen(int p6AddLen) {
        this.p6AddLen = p6AddLen;
    }

    public String getP62AdditionalData() {
        return p62AdditionalData;
    }

    public void setP62AdditionalData(String p62AdditionalData) {
        this.p62AdditionalData = p62AdditionalData;
    }

    public int getP63TxLifeCycleIdLength() {
        return p63TxLifeCycleIdLength;
    }

    public void setP63TxLifeCycleIdLength(int p63TxLifeCycleIdLength) {
        this.p63TxLifeCycleIdLength = p63TxLifeCycleIdLength;
    }

    public String getP63TransactioLifeCyclId() {
        return p63TransactioLifeCyclId;
    }

    public void setP63TransactioLifeCyclId(String p63TransactioLifeCyclId) {
        this.p63TransactioLifeCyclId = p63TransactioLifeCyclId;
    }

    public String getP64PrimaryMac() {
        return p64PrimaryMac;
    }

    public void setP64PrimaryMac(String p64PrimaryMac) {
        this.p64PrimaryMac = p64PrimaryMac;
    }

    public String getS66SettlementCode() {
        return s66SettlementCode;
    }

    public void setS66SettlementCode(String s66SettlementCode) {
        this.s66SettlementCode = s66SettlementCode;
    }

    public int getS67ExtendedPaymentCode() {
        return s67ExtendedPaymentCode;
    }

    public void setS67ExtendedPaymentCode(int s67ExtendedPaymentCode) {
        this.s67ExtendedPaymentCode = s67ExtendedPaymentCode;
    }

    public int getS68ReInstCountryCode() {
        return s68ReInstCountryCode;
    }

    public void setS68ReInstCountryCode(int s68ReInstCountryCode) {
        this.s68ReInstCountryCode = s68ReInstCountryCode;
    }

    public int getS69SettleInstCountryCode() {
        return s69SettleInstCountryCode;
    }

    public void setS69SettleInstCountryCode(int s69SettleInstCountryCode) {
        this.s69SettleInstCountryCode = s69SettleInstCountryCode;
    }

    public int getS70NetworkManCountryCode() {
        return s70NetworkManCountryCode;
    }

    public void setS70NetworkManCountryCode(int s70NetworkManCountryCode) {
        this.s70NetworkManCountryCode = s70NetworkManCountryCode;
    }

    public int getS71MessageNumber() {
        return s71MessageNumber;
    }

    public void setS71MessageNumber(int s71MessageNumber) {
        this.s71MessageNumber = s71MessageNumber;
    }

    public int getS72DataLen() {
        return s72DataLen;
    }

    public void setS72DataLen(int s72DataLen) {
        this.s72DataLen = s72DataLen;
    }

    public String getS72DataRecord() {
        return s72DataRecord;
    }

    public void setS72DataRecord(String s72DataRecord) {
        this.s72DataRecord = s72DataRecord;
    }

    public int getS7ActionDate() {
        return s7ActionDate;
    }

    public void setS7ActionDate(int s7ActionDate) {
        this.s7ActionDate = s7ActionDate;
    }

    public int getS74NoOfCredits() {
        return s74NoOfCredits;
    }

    public void setS74NoOfCredits(int s74NoOfCredits) {
        this.s74NoOfCredits = s74NoOfCredits;
    }

    public int getS75ReversalNoOfCredits() {
        return s75ReversalNoOfCredits;
    }

    public void setS75ReversalNoOfCredits(int s75ReversalNoOfCredits) {
        this.s75ReversalNoOfCredits = s75ReversalNoOfCredits;
    }

    public int getS76NoOfDebits() {
        return s76NoOfDebits;
    }

    public void setS76NoOfDebits(int s76NoOfDebits) {
        this.s76NoOfDebits = s76NoOfDebits;
    }

    public int getS77ReversalNoOfDebits() {
        return s77ReversalNoOfDebits;
    }

    public void setS77ReversalNoOfDebits(int s77ReversalNoOfDebits) {
        this.s77ReversalNoOfDebits = s77ReversalNoOfDebits;
    }

    public int getS78NumberTransfers() {
        return s78NumberTransfers;
    }

    public void setS78NumberTransfers(int s78NumberTransfers) {
        this.s78NumberTransfers = s78NumberTransfers;
    }

    public int getS79ReversalNumberTransfers() {
        return s79ReversalNumberTransfers;
    }

    public void setS79ReversalNumberTransfers(int s79ReversalNumberTransfers) {
        this.s79ReversalNumberTransfers = s79ReversalNumberTransfers;
    }

    public int getS80NumberEnquiries() {
        return s80NumberEnquiries;
    }

    public void setS80NumberEnquiries(int s80NumberEnquiries) {
        this.s80NumberEnquiries = s80NumberEnquiries;
    }

    public int getS81NumberAuthorisations() {
        return s81NumberAuthorisations;
    }

    public void setS81NumberAuthorisations(int s81NumberAuthorisations) {
        this.s81NumberAuthorisations = s81NumberAuthorisations;
    }

    public int getS82ProcessingFeeCredits() {
        return s82ProcessingFeeCredits;
    }

    public void setS82ProcessingFeeCredits(int s82ProcessingFeeCredits) {
        this.s82ProcessingFeeCredits = s82ProcessingFeeCredits;
    }

    public int getS83TransactionFeeCredits() {
        return s83TransactionFeeCredits;
    }

    public void setS83TransactionFeeCredits(int s83TransactionFeeCredits) {
        this.s83TransactionFeeCredits = s83TransactionFeeCredits;
    }

    public int getS84ProcessingFeeDebits() {
        return s84ProcessingFeeDebits;
    }

    public void setS84ProcessingFeeDebits(int s84ProcessingFeeDebits) {
        this.s84ProcessingFeeDebits = s84ProcessingFeeDebits;
    }

    public int getS85TransactioFeeAmounts() {
        return s85TransactioFeeAmounts;
    }

    public void setS85TransactioFeeAmounts(int s85TransactioFeeAmounts) {
        this.s85TransactioFeeAmounts = s85TransactioFeeAmounts;
    }

    public int getS86AmountCredits() {
        return s86AmountCredits;
    }

    public void setS86AmountCredits(int s86AmountCredits) {
        this.s86AmountCredits = s86AmountCredits;
    }

    public int getS87ReversalAmountCredits() {
        return s87ReversalAmountCredits;
    }

    public void setS87ReversalAmountCredits(int s87ReversalAmountCredits) {
        this.s87ReversalAmountCredits = s87ReversalAmountCredits;
    }

    public int getS88AmountDebits() {
        return s88AmountDebits;
    }

    public void setS88AmountDebits(int s88AmountDebits) {
        this.s88AmountDebits = s88AmountDebits;
    }

    public int getS89ReversalAmountDebits() {
        return s89ReversalAmountDebits;
    }

    public void setS89ReversalAmountDebits(int s89ReversalAmountDebits) {
        this.s89ReversalAmountDebits = s89ReversalAmountDebits;
    }

    public int getS90OriginatingDataElements() {
        return s90OriginatingDataElements;
    }

    public void setS90OriginatingDataElements(int s90OriginatingDataElements) {
        this.s90OriginatingDataElements = s90OriginatingDataElements;
    }

    public String getS91FileUpdateCode() {
        return s91FileUpdateCode;
    }

    public void setS91FileUpdateCode(String s91FileUpdateCode) {
        this.s91FileUpdateCode = s91FileUpdateCode;
    }

    public String getS92FilesSecurityCode() {
        return s92FilesSecurityCode;
    }

    public void setS92FilesSecurityCode(String s92FilesSecurityCode) {
        this.s92FilesSecurityCode = s92FilesSecurityCode;
    }

    public int getS93Length() {
        return s93Length;
    }

    public void setS93Length(int s93Length) {
        this.s93Length = s93Length;
    }

    public int getS93TransactionDestInstId() {
        return s93TransactionDestInstId;
    }

    public void setS93TransactionDestInstId(int s93TransactionDestInstId) {
        this.s93TransactionDestInstId = s93TransactionDestInstId;
    }

    public int getS94Length() {
        return s94Length;
    }

    public void setS94Length(int s94Length) {
        this.s94Length = s94Length;
    }

    public String getS94TransactionOrigInstId() {
        return s94TransactionOrigInstId;
    }

    public void setS94TransactionOrigInstId(String s94TransactionOrigInstId) {
        this.s94TransactionOrigInstId = s94TransactionOrigInstId;
    }

    public int getS95CardIssRefDataLength() {
        return s95CardIssRefDataLength;
    }

    public void setS95CardIssRefDataLength(int s95CardIssRefDataLength) {
        this.s95CardIssRefDataLength = s95CardIssRefDataLength;
    }

    public String getS95CardIssuerRefData() {
        return s95CardIssuerRefData;
    }

    public void setS95CardIssuerRefData(String s95CardIssuerRefData) {
        this.s95CardIssuerRefData = s95CardIssuerRefData;
    }

    public String getS96MessageSecurityCode() {
        return s96MessageSecurityCode;
    }

    public void setS96MessageSecurityCode(String s96MessageSecurityCode) {
        this.s96MessageSecurityCode = s96MessageSecurityCode;
    }

    public int getS97NetSettlemenAmount() {
        return s97NetSettlemenAmount;
    }

    public void setS97NetSettlemenAmount(int s97NetSettlemenAmount) {
        this.s97NetSettlemenAmount = s97NetSettlemenAmount;
    }

    public String getS98Payee() {
        return s98Payee;
    }

    public void setS98Payee(String s98Payee) {
        this.s98Payee = s98Payee;
    }

    public int getS99SettlementInstIdCode() {
        return s99SettlementInstIdCode;
    }

    public void setS99SettlementInstIdCode(int s99SettlementInstIdCode) {
        this.s99SettlementInstIdCode = s99SettlementInstIdCode;
    }

    public int getS100RIILen() {
        return s100RIILen;
    }

    public void setS100RIILen(int s100riiLen) {
        s100RIILen = s100riiLen;
    }

    public int getS100RcvingInstIdCode() {
        return s100RcvingInstIdCode;
    }

    public void setS100RcvingInstIdCode(int s100RcvingInstIdCode) {
        this.s100RcvingInstIdCode = s100RcvingInstIdCode;
    }

    public String getS101FileName() {
        return s101FileName;
    }

    public void setS101FileName(String s101FileName) {
        this.s101FileName = s101FileName;
    }

    public String getS102AccountIdentification1() {
        return s102AccountIdentification1;
    }

    public void setS102AccountIdentification1(String s102AccountIdentification1) {
        this.s102AccountIdentification1 = s102AccountIdentification1;
    }

    public String getS103AccountIdentification2() {
        return s103AccountIdentification2;
    }

    public void setS103AccountIdentification2(String s103AccountIdentification2) {
        this.s103AccountIdentification2 = s103AccountIdentification2;
    }

    public String getS104TransactionDescription() {
        return s104TransactionDescription;
    }

    public void setS104TransactionDescription(String s104TransactionDescription) {
        this.s104TransactionDescription = s104TransactionDescription;
    }

    public int getS111Length() {
        return s111Length;
    }

    public void setS111Length(int s111Length) {
        this.s111Length = s111Length;
    }

    public String getS111AmtCurrencyConversion() {
        return s111AmtCurrencyConversion;
    }

    public void setS111AmtCurrencyConversion(String s111AmtCurrencyConversion) {
        this.s111AmtCurrencyConversion = s111AmtCurrencyConversion;
    }

    public int getS123AddLen() {
        return s123AddLen;
    }

    public void setS123AddLen(int s123AddLen) {
        this.s123AddLen = s123AddLen;
    }

    public String getS123AdditionalData() {
        return s123AdditionalData;
    }

    public void setS123AdditionalData(String s123AdditionalData) {
        this.s123AdditionalData = s123AdditionalData;
    }

    public int getS124AddLen() {
        return s124AddLen;
    }

    public void setS124AddLen(int s124AddLen) {
        this.s124AddLen = s124AddLen;
    }

    public String getS124AdditionalData() {
        return s124AdditionalData;
    }

    public void setS124AdditionalData(String s124AdditionalData) {
        this.s124AdditionalData = s124AdditionalData;
    }

    public int getS125AddLen() {
        return s125AddLen;
    }

    public void setS125AddLen(int s125AddLen) {
        this.s125AddLen = s125AddLen;
    }

    public String getS125AdditionalData() {
        return s125AdditionalData;
    }

    public void setS125AdditionalData(String s125AdditionalData) {
        this.s125AdditionalData = s125AdditionalData;
    }

    public String getS127NetworkData() {
        return s127NetworkData;
    }

    public void setS127NetworkData(String s127NetworkData) {
        this.s127NetworkData = s127NetworkData;
    }

    public String getInputFileIdentifier() {
        return inputFileIdentifier;
    }

    public void setInputFileIdentifier(String inputFileIdentifier) {
        this.inputFileIdentifier = inputFileIdentifier;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(int transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getFilenameDesription() {
        return filenameDesription;
    }

    public void setFilenameDesription(String filenameDesription) {
        this.filenameDesription = filenameDesription;
    }

    public int getP55ICCSysDataRaw() {
        return p55ICCSysDataRaw;
    }

    public void setP55ICCSysDataRaw(int p55iccSysDataRaw) {
        p55ICCSysDataRaw = p55iccSysDataRaw;
    }

    public int getiRD() {
        return iRD;
    }

    public void setiRD(int iRD) {
        this.iRD = iRD;
    }

    public String getCashbackPurchase() {
        return cashbackPurchase;
    }

    public void setCashbackPurchase(String cashbackPurchase) {
        this.cashbackPurchase = cashbackPurchase;
    }

    public int getCashbackPurchaseAmnt() {
        return cashbackPurchaseAmnt;
    }

    public void setCashbackPurchaseAmnt(int cashbackPurchaseAmnt) {
        this.cashbackPurchaseAmnt = cashbackPurchaseAmnt;
    }

    public String getPosEntryMode() {
        return posEntryMode;
    }

    public void setPosEntryMode(String posEntryMode) {
        this.posEntryMode = posEntryMode;
    }

    public String getChipCard() {
        return chipCard;
    }

    public void setChipCard(String chipCard) {
        this.chipCard = chipCard;
    }

    public String getTerminalCapability() {
        return terminalCapability;
    }

    public void setTerminalCapability(String terminalCapability) {
        this.terminalCapability = terminalCapability;
    }

    public String getEcommInd() {
        return ecommInd;
    }

    public void setEcommInd(String ecommInd) {
        this.ecommInd = ecommInd;
    }

    public String getCardPresent() {
        return cardPresent;
    }

    public void setCardPresent(String cardPresent) {
        this.cardPresent = cardPresent;
    }

    public String getRateDesc() {
        return rateDesc;
    }

    public void setRateDesc(String rateDesc) {
        this.rateDesc = rateDesc;
    }

    public Double getInterchangeFee() {
        return interchangeFee;
    }

    public void setInterchangeFee(Double interchangeFee) {
        this.interchangeFee = interchangeFee;
    }

    public Double getInterchangePerc() {
        return interchangePerc;
    }

    public void setInterchangePerc(Double interchangePerc) {
        this.interchangePerc = interchangePerc;
    }

    public Double getInterchasngeVat() {
        return interchasngeVat;
    }

    public void setInterchasngeVat(Double interchasngeVat) {
        this.interchasngeVat = interchasngeVat;
    }

    public Double getCashbackIcFee() {
        return cashbackIcFee;
    }

    public void setCashbackIcFee(Double cashbackIcFee) {
        this.cashbackIcFee = cashbackIcFee;
    }

    public Double getCashbackIcPerc() {
        return cashbackIcPerc;
    }

    public void setCashbackIcPerc(Double cashbackIcPerc) {
        this.cashbackIcPerc = cashbackIcPerc;
    }

    public Double getCashbackIcVat() {
        return cashbackIcVat;
    }

    public void setCashbackIcVat(Double cashbackIcVat) {
        this.cashbackIcVat = cashbackIcVat;
    }

    public String getFeeDataPresent() {
        return feeDataPresent;
    }

    public void setFeeDataPresent(String feeDataPresent) {
        this.feeDataPresent = feeDataPresent;
    }

    public String getSarbBilling() {
        return sarbBilling;
    }

    public void setSarbBilling(String sarbBilling) {
        this.sarbBilling = sarbBilling;
    }
    
    

}
