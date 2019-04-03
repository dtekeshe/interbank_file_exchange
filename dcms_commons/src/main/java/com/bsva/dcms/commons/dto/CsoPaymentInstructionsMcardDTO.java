package com.bsva.dcms.commons.dto;

import java.io.Serializable;

/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 * 
* Created By BSVATools
 */
public class CsoPaymentInstructionsMcardDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String fileRefNumber1;
    private long systemSeqNumber2;
    private String serviceCode;
    private String subServiceName;
    private int acquirerMember;
    private int issuerMember;
    private long mastercardAmount;
    private String financialIndicator;
    private String primaryBitmap;
    private String secondaryBitmap;
    private int messageTypeIndicator;
    private int p2PanLength;
    private String p2Pan;
    private int p3ProcessCode;
    private long p4TransactionAmount;
    private long p5ReconclliationAmount;
    private long p6CardholderBilling;
    private long p7TransctionDateAndTime;
    private int p8IccrAmount;
    private int p9ReconConversionRate;
    private int p10CardholderConvRate;
    private int p11SystemTraceAuditNumber;
    private long p12LocalDate;
    private long p13LocalTime;
    private int p14ExpirationDate;
    private int p15SettlementDate;
    private int p16ConversionDate;
    private int p17CaptureDate;
    private int p18MerchantType;
    private int p19AcqBankInstitutionCode;
    private int p20CountryCodePriAccNo;
    private int p21FwdingInstCountryCode;
    private String p22PointOfSaleData;
    private int p23CardSequenceNumber;
    private int p24FunctionCode;
    private int p25MessageReasonCode;
    private int p26CardAcceptorBusCode;
    private int p27AuthIdResponseLength;
    private int p28TransactionFeeAmount;
    private int p29SettlementFeeAmount;
    private String p30OriginalAmount;
    private int p31AcquirerRefLength;
    private String p31AcquirerRefData;
    private int p32AcquiringInstLength;
    private long p32AcquiringInstCode;
    private int p33ForwardingInstLength;
    private long p33ForwardingInstCode;
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
    private String p46AdditionalDataIso;
    private String p47AdditionalDataNational;
    private String p48AdditionalDataLength;
    private String p48AdditionalData;
    private int p49CurrencyCode;
    private int p50ReconcilliationCode;
    private int p51CardholderBillCurCode;
    private String p52PersonalIdNumber;
    private long p53SecurityRelControlInfo;
    private int p54AdditionalAmntLength;
    private String p54AdditionalAmounts;
    private int p55IccLength;
    private String p55IccSystemRelatedData;
    private int p62AddLen;
    private String p62AdditionalData;
    private int p63TxLifeCycleIdLength;
    private String p63TransactionLifeCycleId;
    private String p64PrimaryMac;
    private String s66SettlemntCode;
    private int s67ExtendedPaymentCode;
    private int s68RecInstCountryCode;
    private int s69SettleInstCountryCode;
    private int s70NetworkManCountryCode;
    private int s71MessageNumber;
    private int s72DataLen;
    private String s72DataRecord;
    private int s73ActionDate;
    private long s74NoOfCredits;
    private long s75ReversalNoOfCredits;
    private long s76NoOfDebits;
    private long s77ReversalNoOfDebits;
    private long s78NumberTransfers;
    private long s79ReversalNumberTransfers;
    private long s80NumberEnquiries;
    private long s81NumberAuthorisations;
    private long s82ProcessingFeeCredits;
    private long s83TransactionFeeCredits;
    private long s84ProcessingFeeDebits;
    private long s85TransctionFeeAmounts;
    private long s86AmountCredits;
    private long s87ReversalAmountCredits;
    private long s88AmountDebits;
    private long s89ReversalAmountDebits;
    private long s90OriginatingDataElements;
    private String s91FileUpdateCode;
    private String s92FilesSecurityCode;
    private int s93Length;
    private long s93TransactionDestInstId;
    private int s94Length;
    private String s94TransactionOrigInstId;
    private int s95CardIssRefDataLength;
    private String s95CardIssuerRefData;
    private String s96MessageSecurityCode;
    private long s97NetSettlementAmount;
    private String s98Payee;
    private long s99SettlementInstIdCode;
    private int s100RiiLen;
    private long s100RcvingInstIdCode;
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
    private long seqNo;
    private String processStatus;
    private int recordId;
    private short transactionCode;
    private String cardType;
    private String filenameDescription;
    private byte[] p55IccSysDataRaw;
    private int ird;
    private String cashbackPurchase;
    private double cashbackPurchaseAmnt;

    // SARB Billing Values
    private String posEntryMode;
    private String chipCard;
    private String terminalCapability;
    private String ecommInd;
    private String cardPresent;
    private String rateDesc;
    private Double interchangeFee;
    private Double interchangePerc;
    private Double interchangeVat;
    private Double cashbackIcFee;
    private Double cashbackIcPerc;
    private Double cashbackIcVat;
    private String feeDataPresent;
    private String sarbBilling;

    public String getFileRefNumber1() {
        return this.fileRefNumber1;
    }

    public void setFileRefNumber1(String fileRefNumber1) {
        this.fileRefNumber1 = fileRefNumber1;
    }

    public long getSystemSeqNumber2() {
        return this.systemSeqNumber2;
    }

    public void setSystemSeqNumber2(long systemSeqNumber2) {
        this.systemSeqNumber2 = systemSeqNumber2;
    }

    public String getServiceCode() {
        return this.serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getSubServiceName() {
        return this.subServiceName;
    }

    public void setSubServiceName(String subServiceName) {
        this.subServiceName = subServiceName;
    }

    public int getAcquirerMember() {
        return this.acquirerMember;
    }

    public void setAcquirerMember(int acquirerMember) {
        this.acquirerMember = acquirerMember;
    }

    public int getIssuerMember() {
        return this.issuerMember;
    }

    public void setIssuerMember(int issuerMember) {
        this.issuerMember = issuerMember;
    }

    public long getMastercardAmount() {
        return this.mastercardAmount;
    }

    public void setMastercardAmount(long mastercardAmount) {
        this.mastercardAmount = mastercardAmount;
    }

    public String getFinancialIndicator() {
        return this.financialIndicator;
    }

    public void setFinancialIndicator(String financialIndicator) {
        this.financialIndicator = financialIndicator;
    }

    public String getPrimaryBitmap() {
        return this.primaryBitmap;
    }

    public void setPrimaryBitmap(String primaryBitmap) {
        this.primaryBitmap = primaryBitmap;
    }

    public String getSecondaryBitmap() {
        return this.secondaryBitmap;
    }

    public void setSecondaryBitmap(String secondaryBitmap) {
        this.secondaryBitmap = secondaryBitmap;
    }

    public int getMessageTypeIndicator() {
        return this.messageTypeIndicator;
    }

    public void setMessageTypeIndicator(int messageTypeIndicator) {
        this.messageTypeIndicator = messageTypeIndicator;
    }

    public int getP2PanLength() {
        return this.p2PanLength;
    }

    public void setP2PanLength(int p2PanLength) {
        this.p2PanLength = p2PanLength;
    }

    public String getP2Pan() {
        return this.p2Pan;
    }

    public void setP2Pan(String p2Pan) {
        this.p2Pan = p2Pan;
    }

    public int getP3ProcessCode() {
        return this.p3ProcessCode;
    }

    public void setP3ProcessCode(int p3ProcessCode) {
        this.p3ProcessCode = p3ProcessCode;
    }

    public long getP4TransactionAmount() {
        return this.p4TransactionAmount;
    }

    public void setP4TransactionAmount(long p4TransactionAmount) {
        this.p4TransactionAmount = p4TransactionAmount;
    }

    public long getP5ReconclliationAmount() {
        return this.p5ReconclliationAmount;
    }

    public void setP5ReconclliationAmount(long p5ReconclliationAmount) {
        this.p5ReconclliationAmount = p5ReconclliationAmount;
    }

    public long getP6CardholderBilling() {
        return this.p6CardholderBilling;
    }

    public void setP6CardholderBilling(long p6CardholderBilling) {
        this.p6CardholderBilling = p6CardholderBilling;
    }

    public long getP7TransctionDateAndTime() {
        return this.p7TransctionDateAndTime;
    }

    public void setP7TransctionDateAndTime(long p7TransctionDateAndTime) {
        this.p7TransctionDateAndTime = p7TransctionDateAndTime;
    }

    public int getP8IccrAmount() {
        return this.p8IccrAmount;
    }

    public void setP8IccrAmount(int p8IccrAmount) {
        this.p8IccrAmount = p8IccrAmount;
    }

    public int getP9ReconConversionRate() {
        return this.p9ReconConversionRate;
    }

    public void setP9ReconConversionRate(int p9ReconConversionRate) {
        this.p9ReconConversionRate = p9ReconConversionRate;
    }

    public int getP10CardholderConvRate() {
        return this.p10CardholderConvRate;
    }

    public void setP10CardholderConvRate(int p10CardholderConvRate) {
        this.p10CardholderConvRate = p10CardholderConvRate;
    }

    public int getP11SystemTraceAuditNumber() {
        return this.p11SystemTraceAuditNumber;
    }

    public void setP11SystemTraceAuditNumber(int p11SystemTraceAuditNumber) {
        this.p11SystemTraceAuditNumber = p11SystemTraceAuditNumber;
    }

    public long getP12LocalDate() {
        return this.p12LocalDate;
    }

    public void setP12LocalDate(long p12LocalDate) {
        this.p12LocalDate = p12LocalDate;
    }

    public long getP13LocalTime() {
        return this.p13LocalTime;
    }

    public void setP13LocalTime(long p13LocalTime) {
        this.p13LocalTime = p13LocalTime;
    }

    public int getP14ExpirationDate() {
        return this.p14ExpirationDate;
    }

    public void setP14ExpirationDate(int p14ExpirationDate) {
        this.p14ExpirationDate = p14ExpirationDate;
    }

    public int getP15SettlementDate() {
        return this.p15SettlementDate;
    }

    public void setP15SettlementDate(int p15SettlementDate) {
        this.p15SettlementDate = p15SettlementDate;
    }

    public int getP16ConversionDate() {
        return this.p16ConversionDate;
    }

    public void setP16ConversionDate(int p16ConversionDate) {
        this.p16ConversionDate = p16ConversionDate;
    }

    public int getP17CaptureDate() {
        return this.p17CaptureDate;
    }

    public void setP17CaptureDate(int p17CaptureDate) {
        this.p17CaptureDate = p17CaptureDate;
    }

    public int getP18MerchantType() {
        return this.p18MerchantType;
    }

    public void setP18MerchantType(int p18MerchantType) {
        this.p18MerchantType = p18MerchantType;
    }

    public int getP19AcqBankInstitutionCode() {
        return this.p19AcqBankInstitutionCode;
    }

    public void setP19AcqBankInstitutionCode(int p19AcqBankInstitutionCode) {
        this.p19AcqBankInstitutionCode = p19AcqBankInstitutionCode;
    }

    public int getP20CountryCodePriAccNo() {
        return this.p20CountryCodePriAccNo;
    }

    public void setP20CountryCodePriAccNo(int p20CountryCodePriAccNo) {
        this.p20CountryCodePriAccNo = p20CountryCodePriAccNo;
    }

    public int getP21FwdingInstCountryCode() {
        return this.p21FwdingInstCountryCode;
    }

    public void setP21FwdingInstCountryCode(int p21FwdingInstCountryCode) {
        this.p21FwdingInstCountryCode = p21FwdingInstCountryCode;
    }

    public String getP22PointOfSaleData() {
        return this.p22PointOfSaleData;
    }

    public void setP22PointOfSaleData(String p22PointOfSaleData) {
        this.p22PointOfSaleData = p22PointOfSaleData;
    }

    public int getP23CardSequenceNumber() {
        return this.p23CardSequenceNumber;
    }

    public void setP23CardSequenceNumber(int p23CardSequenceNumber) {
        this.p23CardSequenceNumber = p23CardSequenceNumber;
    }

    public int getP24FunctionCode() {
        return this.p24FunctionCode;
    }

    public void setP24FunctionCode(int p24FunctionCode) {
        this.p24FunctionCode = p24FunctionCode;
    }

    public int getP25MessageReasonCode() {
        return this.p25MessageReasonCode;
    }

    public void setP25MessageReasonCode(int p25MessageReasonCode) {
        this.p25MessageReasonCode = p25MessageReasonCode;
    }

    public int getP26CardAcceptorBusCode() {
        return this.p26CardAcceptorBusCode;
    }

    public void setP26CardAcceptorBusCode(int p26CardAcceptorBusCode) {
        this.p26CardAcceptorBusCode = p26CardAcceptorBusCode;
    }

    public int getP27AuthIdResponseLength() {
        return this.p27AuthIdResponseLength;
    }

    public void setP27AuthIdResponseLength(int p27AuthIdResponseLength) {
        this.p27AuthIdResponseLength = p27AuthIdResponseLength;
    }

    public int getP28TransactionFeeAmount() {
        return this.p28TransactionFeeAmount;
    }

    public void setP28TransactionFeeAmount(int p28TransactionFeeAmount) {
        this.p28TransactionFeeAmount = p28TransactionFeeAmount;
    }

    public int getP29SettlementFeeAmount() {
        return this.p29SettlementFeeAmount;
    }

    public void setP29SettlementFeeAmount(int p29SettlementFeeAmount) {
        this.p29SettlementFeeAmount = p29SettlementFeeAmount;
    }

    public String getP30OriginalAmount() {
        return this.p30OriginalAmount;
    }

    public void setP30OriginalAmount(String p30OriginalAmount) {
        this.p30OriginalAmount = p30OriginalAmount;
    }

    public int getP31AcquirerRefLength() {
        return this.p31AcquirerRefLength;
    }

    public void setP31AcquirerRefLength(int p31AcquirerRefLength) {
        this.p31AcquirerRefLength = p31AcquirerRefLength;
    }

    public String getP31AcquirerRefData() {
        return this.p31AcquirerRefData;
    }

    public void setP31AcquirerRefData(String p31AcquirerRefData) {
        this.p31AcquirerRefData = p31AcquirerRefData;
    }

    public int getP32AcquiringInstLength() {
        return this.p32AcquiringInstLength;
    }

    public void setP32AcquiringInstLength(int p32AcquiringInstLength) {
        this.p32AcquiringInstLength = p32AcquiringInstLength;
    }

    public long getP32AcquiringInstCode() {
        return this.p32AcquiringInstCode;
    }

    public void setP32AcquiringInstCode(long p32AcquiringInstCode) {
        this.p32AcquiringInstCode = p32AcquiringInstCode;
    }

    public int getP33ForwardingInstLength() {
        return this.p33ForwardingInstLength;
    }

    public void setP33ForwardingInstLength(int p33ForwardingInstLength) {
        this.p33ForwardingInstLength = p33ForwardingInstLength;
    }

    public long getP33ForwardingInstCode() {
        return this.p33ForwardingInstCode;
    }

    public void setP33ForwardingInstCode(long p33ForwardingInstCode) {
        this.p33ForwardingInstCode = p33ForwardingInstCode;
    }

    public String getP34ExtendedAccountNumber() {
        return this.p34ExtendedAccountNumber;
    }

    public void setP34ExtendedAccountNumber(String p34ExtendedAccountNumber) {
        this.p34ExtendedAccountNumber = p34ExtendedAccountNumber;
    }

    public String getP35Track2Data() {
        return this.p35Track2Data;
    }

    public void setP35Track2Data(String p35Track2Data) {
        this.p35Track2Data = p35Track2Data;
    }

    public String getP36Track3Data() {
        return this.p36Track3Data;
    }

    public void setP36Track3Data(String p36Track3Data) {
        this.p36Track3Data = p36Track3Data;
    }

    public String getP37RetrievalRefNumber() {
        return this.p37RetrievalRefNumber;
    }

    public void setP37RetrievalRefNumber(String p37RetrievalRefNumber) {
        this.p37RetrievalRefNumber = p37RetrievalRefNumber;
    }

    public String getP38ApprovalCode() {
        return this.p38ApprovalCode;
    }

    public void setP38ApprovalCode(String p38ApprovalCode) {
        this.p38ApprovalCode = p38ApprovalCode;
    }

    public String getP39ResponseCode() {
        return this.p39ResponseCode;
    }

    public void setP39ResponseCode(String p39ResponseCode) {
        this.p39ResponseCode = p39ResponseCode;
    }

    public int getP40ServiceCode() {
        return this.p40ServiceCode;
    }

    public void setP40ServiceCode(int p40ServiceCode) {
        this.p40ServiceCode = p40ServiceCode;
    }

    public String getP41CardAcceptorTerminalId() {
        return this.p41CardAcceptorTerminalId;
    }

    public void setP41CardAcceptorTerminalId(String p41CardAcceptorTerminalId) {
        this.p41CardAcceptorTerminalId = p41CardAcceptorTerminalId;
    }

    public String getP42CardAcceptorId() {
        return this.p42CardAcceptorId;
    }

    public void setP42CardAcceptorId(String p42CardAcceptorId) {
        this.p42CardAcceptorId = p42CardAcceptorId;
    }

    public int getP43CardAcceptorLength() {
        return this.p43CardAcceptorLength;
    }

    public void setP43CardAcceptorLength(int p43CardAcceptorLength) {
        this.p43CardAcceptorLength = p43CardAcceptorLength;
    }

    public String getP43CardAcceptorName() {
        return this.p43CardAcceptorName;
    }

    public void setP43CardAcceptorName(String p43CardAcceptorName) {
        this.p43CardAcceptorName = p43CardAcceptorName;
    }

    public String getP44AdditionalResponseData() {
        return this.p44AdditionalResponseData;
    }

    public void setP44AdditionalResponseData(String p44AdditionalResponseData) {
        this.p44AdditionalResponseData = p44AdditionalResponseData;
    }

    public String getP45Track1Data() {
        return this.p45Track1Data;
    }

    public void setP45Track1Data(String p45Track1Data) {
        this.p45Track1Data = p45Track1Data;
    }

    public String getP46AdditionalDataIso() {
        return this.p46AdditionalDataIso;
    }

    public void setP46AdditionalDataIso(String p46AdditionalDataIso) {
        this.p46AdditionalDataIso = p46AdditionalDataIso;
    }

    public String getP47AdditionalDataNational() {
        return this.p47AdditionalDataNational;
    }

    public void setP47AdditionalDataNational(String p47AdditionalDataNational) {
        this.p47AdditionalDataNational = p47AdditionalDataNational;
    }

    public String getP48AdditionalDataLength() {
        return this.p48AdditionalDataLength;
    }

    public void setP48AdditionalDataLength(String p48AdditionalDataLength) {
        this.p48AdditionalDataLength = p48AdditionalDataLength;
    }

    public String getP48AdditionalData() {
        return this.p48AdditionalData;
    }

    public void setP48AdditionalData(String p48AdditionalData) {
        this.p48AdditionalData = p48AdditionalData;
    }

    public int getP49CurrencyCode() {
        return this.p49CurrencyCode;
    }

    public void setP49CurrencyCode(int p49CurrencyCode) {
        this.p49CurrencyCode = p49CurrencyCode;
    }

    public int getP50ReconcilliationCode() {
        return this.p50ReconcilliationCode;
    }

    public void setP50ReconcilliationCode(int p50ReconcilliationCode) {
        this.p50ReconcilliationCode = p50ReconcilliationCode;
    }

    public int getP51CardholderBillCurCode() {
        return this.p51CardholderBillCurCode;
    }

    public void setP51CardholderBillCurCode(int p51CardholderBillCurCode) {
        this.p51CardholderBillCurCode = p51CardholderBillCurCode;
    }

    public String getP52PersonalIdNumber() {
        return this.p52PersonalIdNumber;
    }

    public void setP52PersonalIdNumber(String p52PersonalIdNumber) {
        this.p52PersonalIdNumber = p52PersonalIdNumber;
    }

    public long getP53SecurityRelControlInfo() {
        return this.p53SecurityRelControlInfo;
    }

    public void setP53SecurityRelControlInfo(long p53SecurityRelControlInfo) {
        this.p53SecurityRelControlInfo = p53SecurityRelControlInfo;
    }

    public int getP54AdditionalAmntLength() {
        return this.p54AdditionalAmntLength;
    }

    public void setP54AdditionalAmntLength(int p54AdditionalAmntLength) {
        this.p54AdditionalAmntLength = p54AdditionalAmntLength;
    }

    public String getP54AdditionalAmounts() {
        return this.p54AdditionalAmounts;
    }

    public void setP54AdditionalAmounts(String p54AdditionalAmounts) {
        this.p54AdditionalAmounts = p54AdditionalAmounts;
    }

    public int getP55IccLength() {
        return this.p55IccLength;
    }

    public void setP55IccLength(int p55IccLength) {
        this.p55IccLength = p55IccLength;
    }

    public String getP55IccSystemRelatedData() {
        return this.p55IccSystemRelatedData;
    }

    public void setP55IccSystemRelatedData(String p55IccSystemRelatedData) {
        this.p55IccSystemRelatedData = p55IccSystemRelatedData;
    }

    public int getP62AddLen() {
        return this.p62AddLen;
    }

    public void setP62AddLen(int p62AddLen) {
        this.p62AddLen = p62AddLen;
    }

    public String getP62AdditionalData() {
        return this.p62AdditionalData;
    }

    public void setP62AdditionalData(String p62AdditionalData) {
        this.p62AdditionalData = p62AdditionalData;
    }

    public int getP63TxLifeCycleIdLength() {
        return this.p63TxLifeCycleIdLength;
    }

    public void setP63TxLifeCycleIdLength(int p63TxLifeCycleIdLength) {
        this.p63TxLifeCycleIdLength = p63TxLifeCycleIdLength;
    }

    public String getP63TransactionLifeCycleId() {
        return this.p63TransactionLifeCycleId;
    }

    public void setP63TransactionLifeCycleId(String p63TransactionLifeCycleId) {
        this.p63TransactionLifeCycleId = p63TransactionLifeCycleId;
    }

    public String getP64PrimaryMac() {
        return this.p64PrimaryMac;
    }

    public void setP64PrimaryMac(String p64PrimaryMac) {
        this.p64PrimaryMac = p64PrimaryMac;
    }

    public String getS66SettlemntCode() {
        return this.s66SettlemntCode;
    }

    public void setS66SettlemntCode(String s66SettlemntCode) {
        this.s66SettlemntCode = s66SettlemntCode;
    }

    public int getS67ExtendedPaymentCode() {
        return this.s67ExtendedPaymentCode;
    }

    public void setS67ExtendedPaymentCode(int s67ExtendedPaymentCode) {
        this.s67ExtendedPaymentCode = s67ExtendedPaymentCode;
    }

    public int getS68RecInstCountryCode() {
        return this.s68RecInstCountryCode;
    }

    public void setS68RecInstCountryCode(int s68RecInstCountryCode) {
        this.s68RecInstCountryCode = s68RecInstCountryCode;
    }

    public int getS69SettleInstCountryCode() {
        return this.s69SettleInstCountryCode;
    }

    public void setS69SettleInstCountryCode(int s69SettleInstCountryCode) {
        this.s69SettleInstCountryCode = s69SettleInstCountryCode;
    }

    public int getS70NetworkManCountryCode() {
        return this.s70NetworkManCountryCode;
    }

    public void setS70NetworkManCountryCode(int s70NetworkManCountryCode) {
        this.s70NetworkManCountryCode = s70NetworkManCountryCode;
    }

    public int getS71MessageNumber() {
        return this.s71MessageNumber;
    }

    public void setS71MessageNumber(int s71MessageNumber) {
        this.s71MessageNumber = s71MessageNumber;
    }

    public int getS72DataLen() {
        return this.s72DataLen;
    }

    public void setS72DataLen(int s72DataLen) {
        this.s72DataLen = s72DataLen;
    }

    public String getS72DataRecord() {
        return this.s72DataRecord;
    }

    public void setS72DataRecord(String s72DataRecord) {
        this.s72DataRecord = s72DataRecord;
    }

    public int getS73ActionDate() {
        return this.s73ActionDate;
    }

    public void setS73ActionDate(int s73ActionDate) {
        this.s73ActionDate = s73ActionDate;
    }

    public long getS74NoOfCredits() {
        return this.s74NoOfCredits;
    }

    public void setS74NoOfCredits(long s74NoOfCredits) {
        this.s74NoOfCredits = s74NoOfCredits;
    }

    public long getS75ReversalNoOfCredits() {
        return this.s75ReversalNoOfCredits;
    }

    public void setS75ReversalNoOfCredits(long s75ReversalNoOfCredits) {
        this.s75ReversalNoOfCredits = s75ReversalNoOfCredits;
    }

    public long getS76NoOfDebits() {
        return this.s76NoOfDebits;
    }

    public void setS76NoOfDebits(long s76NoOfDebits) {
        this.s76NoOfDebits = s76NoOfDebits;
    }

    public long getS77ReversalNoOfDebits() {
        return this.s77ReversalNoOfDebits;
    }

    public void setS77ReversalNoOfDebits(long s77ReversalNoOfDebits) {
        this.s77ReversalNoOfDebits = s77ReversalNoOfDebits;
    }

    public long getS78NumberTransfers() {
        return this.s78NumberTransfers;
    }

    public void setS78NumberTransfers(long s78NumberTransfers) {
        this.s78NumberTransfers = s78NumberTransfers;
    }

    public long getS79ReversalNumberTransfers() {
        return this.s79ReversalNumberTransfers;
    }

    public void setS79ReversalNumberTransfers(long s79ReversalNumberTransfers) {
        this.s79ReversalNumberTransfers = s79ReversalNumberTransfers;
    }

    public long getS80NumberEnquiries() {
        return this.s80NumberEnquiries;
    }

    public void setS80NumberEnquiries(long s80NumberEnquiries) {
        this.s80NumberEnquiries = s80NumberEnquiries;
    }

    public long getS81NumberAuthorisations() {
        return this.s81NumberAuthorisations;
    }

    public void setS81NumberAuthorisations(long s81NumberAuthorisations) {
        this.s81NumberAuthorisations = s81NumberAuthorisations;
    }

    public long getS82ProcessingFeeCredits() {
        return this.s82ProcessingFeeCredits;
    }

    public void setS82ProcessingFeeCredits(long s82ProcessingFeeCredits) {
        this.s82ProcessingFeeCredits = s82ProcessingFeeCredits;
    }

    public long getS83TransactionFeeCredits() {
        return this.s83TransactionFeeCredits;
    }

    public void setS83TransactionFeeCredits(long s83TransactionFeeCredits) {
        this.s83TransactionFeeCredits = s83TransactionFeeCredits;
    }

    public long getS84ProcessingFeeDebits() {
        return this.s84ProcessingFeeDebits;
    }

    public void setS84ProcessingFeeDebits(long s84ProcessingFeeDebits) {
        this.s84ProcessingFeeDebits = s84ProcessingFeeDebits;
    }

    public long getS85TransctionFeeAmounts() {
        return this.s85TransctionFeeAmounts;
    }

    public void setS85TransctionFeeAmounts(long s85TransctionFeeAmounts) {
        this.s85TransctionFeeAmounts = s85TransctionFeeAmounts;
    }

    public long getS86AmountCredits() {
        return this.s86AmountCredits;
    }

    public void setS86AmountCredits(long s86AmountCredits) {
        this.s86AmountCredits = s86AmountCredits;
    }

    public long getS87ReversalAmountCredits() {
        return this.s87ReversalAmountCredits;
    }

    public void setS87ReversalAmountCredits(long s87ReversalAmountCredits) {
        this.s87ReversalAmountCredits = s87ReversalAmountCredits;
    }

    public long getS88AmountDebits() {
        return this.s88AmountDebits;
    }

    public void setS88AmountDebits(long s88AmountDebits) {
        this.s88AmountDebits = s88AmountDebits;
    }

    public long getS89ReversalAmountDebits() {
        return this.s89ReversalAmountDebits;
    }

    public void setS89ReversalAmountDebits(long s89ReversalAmountDebits) {
        this.s89ReversalAmountDebits = s89ReversalAmountDebits;
    }

    public long getS90OriginatingDataElements() {
        return this.s90OriginatingDataElements;
    }

    public void setS90OriginatingDataElements(long s90OriginatingDataElements) {
        this.s90OriginatingDataElements = s90OriginatingDataElements;
    }

    public String getS91FileUpdateCode() {
        return this.s91FileUpdateCode;
    }

    public void setS91FileUpdateCode(String s91FileUpdateCode) {
        this.s91FileUpdateCode = s91FileUpdateCode;
    }

    public String getS92FilesSecurityCode() {
        return this.s92FilesSecurityCode;
    }

    public void setS92FilesSecurityCode(String s92FilesSecurityCode) {
        this.s92FilesSecurityCode = s92FilesSecurityCode;
    }

    public int getS93Length() {
        return this.s93Length;
    }

    public void setS93Length(int s93Length) {
        this.s93Length = s93Length;
    }

    public long getS93TransactionDestInstId() {
        return this.s93TransactionDestInstId;
    }

    public void setS93TransactionDestInstId(long s93TransactionDestInstId) {
        this.s93TransactionDestInstId = s93TransactionDestInstId;
    }

    public int getS94Length() {
        return this.s94Length;
    }

    public void setS94Length(int s94Length) {
        this.s94Length = s94Length;
    }

    public String getS94TransactionOrigInstId() {
        return this.s94TransactionOrigInstId;
    }

    public void setS94TransactionOrigInstId(String s94TransactionOrigInstId) {
        this.s94TransactionOrigInstId = s94TransactionOrigInstId;
    }

    public int getS95CardIssRefDataLength() {
        return this.s95CardIssRefDataLength;
    }

    public void setS95CardIssRefDataLength(int s95CardIssRefDataLength) {
        this.s95CardIssRefDataLength = s95CardIssRefDataLength;
    }

    public String getS95CardIssuerRefData() {
        return this.s95CardIssuerRefData;
    }

    public void setS95CardIssuerRefData(String s95CardIssuerRefData) {
        this.s95CardIssuerRefData = s95CardIssuerRefData;
    }

    public String getS96MessageSecurityCode() {
        return this.s96MessageSecurityCode;
    }

    public void setS96MessageSecurityCode(String s96MessageSecurityCode) {
        this.s96MessageSecurityCode = s96MessageSecurityCode;
    }

    public long getS97NetSettlementAmount() {
        return this.s97NetSettlementAmount;
    }

    public void setS97NetSettlementAmount(long s97NetSettlementAmount) {
        this.s97NetSettlementAmount = s97NetSettlementAmount;
    }

    public String getS98Payee() {
        return this.s98Payee;
    }

    public void setS98Payee(String s98Payee) {
        this.s98Payee = s98Payee;
    }

    public long getS99SettlementInstIdCode() {
        return this.s99SettlementInstIdCode;
    }

    public void setS99SettlementInstIdCode(long s99SettlementInstIdCode) {
        this.s99SettlementInstIdCode = s99SettlementInstIdCode;
    }

    public int getS100RiiLen() {
        return this.s100RiiLen;
    }

    public void setS100RiiLen(int s100RiiLen) {
        this.s100RiiLen = s100RiiLen;
    }

    public long getS100RcvingInstIdCode() {
        return this.s100RcvingInstIdCode;
    }

    public void setS100RcvingInstIdCode(long s100RcvingInstIdCode) {
        this.s100RcvingInstIdCode = s100RcvingInstIdCode;
    }

    public String getS101FileName() {
        return this.s101FileName;
    }

    public void setS101FileName(String s101FileName) {
        this.s101FileName = s101FileName;
    }

    public String getS102AccountIdentification1() {
        return this.s102AccountIdentification1;
    }

    public void setS102AccountIdentification1(String s102AccountIdentification1) {
        this.s102AccountIdentification1 = s102AccountIdentification1;
    }

    public String getS103AccountIdentification2() {
        return this.s103AccountIdentification2;
    }

    public void setS103AccountIdentification2(String s103AccountIdentification2) {
        this.s103AccountIdentification2 = s103AccountIdentification2;
    }

    public String getS104TransactionDescription() {
        return this.s104TransactionDescription;
    }

    public void setS104TransactionDescription(String s104TransactionDescription) {
        this.s104TransactionDescription = s104TransactionDescription;
    }

    public int getS111Length() {
        return this.s111Length;
    }

    public void setS111Length(int s111Length) {
        this.s111Length = s111Length;
    }

    public String getS111AmtCurrencyConversion() {
        return this.s111AmtCurrencyConversion;
    }

    public void setS111AmtCurrencyConversion(String s111AmtCurrencyConversion) {
        this.s111AmtCurrencyConversion = s111AmtCurrencyConversion;
    }

    public int getS123AddLen() {
        return this.s123AddLen;
    }

    public void setS123AddLen(int s123AddLen) {
        this.s123AddLen = s123AddLen;
    }

    public String getS123AdditionalData() {
        return this.s123AdditionalData;
    }

    public void setS123AdditionalData(String s123AdditionalData) {
        this.s123AdditionalData = s123AdditionalData;
    }

    public int getS124AddLen() {
        return this.s124AddLen;
    }

    public void setS124AddLen(int s124AddLen) {
        this.s124AddLen = s124AddLen;
    }

    public String getS124AdditionalData() {
        return this.s124AdditionalData;
    }

    public void setS124AdditionalData(String s124AdditionalData) {
        this.s124AdditionalData = s124AdditionalData;
    }

    public int getS125AddLen() {
        return this.s125AddLen;
    }

    public void setS125AddLen(int s125AddLen) {
        this.s125AddLen = s125AddLen;
    }

    public String getS125AdditionalData() {
        return this.s125AdditionalData;
    }

    public void setS125AdditionalData(String s125AdditionalData) {
        this.s125AdditionalData = s125AdditionalData;
    }

    public String getS127NetworkData() {
        return this.s127NetworkData;
    }

    public void setS127NetworkData(String s127NetworkData) {
        this.s127NetworkData = s127NetworkData;
    }

    public String getInputFileIdentifier() {
        return this.inputFileIdentifier;
    }

    public void setInputFileIdentifier(String inputFileIdentifier) {
        this.inputFileIdentifier = inputFileIdentifier;
    }

    public long getSeqNo() {
        return this.seqNo;
    }

    public void setSeqNo(long seqNo) {
        this.seqNo = seqNo;
    }

    public String getProcessStatus() {
        return this.processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public int getRecordId() {
        return this.recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public short getTransactionCode() {
        return this.transactionCode;
    }

    public void setTransactionCode(short transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getFilenameDescription() {
        return this.filenameDescription;
    }

    public void setFilenameDescription(String filenameDescription) {
        this.filenameDescription = filenameDescription;
    }

    public byte[] getP55IccSysDataRaw() {
        return p55IccSysDataRaw;
    }

    public void setP55IccSysDataRaw(byte[] p55IccSysDataRaw) {
        this.p55IccSysDataRaw = p55IccSysDataRaw;
    }

    public int getIrd() {
        return this.ird;
    }

    public void setIrd(int ird) {
        this.ird = ird;
    }

    public String getCashbackPurchase() {
        return this.cashbackPurchase;
    }

    public void setCashbackPurchase(String cashbackPurchase) {
        this.cashbackPurchase = cashbackPurchase;
    }

    public double getCashbackPurchaseAmnt() {
        return this.cashbackPurchaseAmnt;
    }

    public void setCashbackPurchaseAmnt(double cashbackPurchaseAmnt) {
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

    public Double getInterchangeVat() {
        return interchangeVat;
    }

    public void setInterchangeVat(Double interchangeVat) {
        this.interchangeVat = interchangeVat;
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
