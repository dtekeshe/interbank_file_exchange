package com.bsva.dmcs.fileloadv02.model;

import com.bsva.dmcs.fileloadv02.dto.MastercardPDSDTO;
import com.bsva.dmcs.fileloadv02.dto.MemberRole;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Represents TCR0, TCR1, TCR5, TCR7 payload
 *
 * TODO Rename according to TCR acrynom
 */
public class FileDetailDTO implements Comparable<FileDetailDTO> {

    // raw input
    private String input;
    private Integer inputLength;
    private final Long lineID;
    private final AtomicLong fileSeqNumber;
    private final AtomicLong txnSeqNumber;

    // transaction info
    private final Integer txnCode;
    private final TCRCode tcrCode;

    private Integer billingTxnCode;

    // read from file
    private Integer acquirerBin;
    private Integer issuerBin;

    // lookup against MemberDAO
    private Integer acquirerCode;
    private Integer issuerCode;
    private String distributionCode;
    private MemberRole memberRole;
    private Integer cardType;

    // BIN details
    private Long daysBeforefirstDeletionDate;
    private Long daysBeforefinalDeletionDate;

    // required for billing
    private Long amount;
    private Long cashbackAmount;
    private boolean cashBackPresent;
    private TerminalInfo terminalInfo;

    // required for validation
    private String accountNumber;
    private String usageCode;

    private BillingData billingData;

    // validation result
    private String status;
    private String timeString;
    private String monthDay;
    private Date dateTime;

    private List<MastercardPDSDTO> pdsList;
    private String outputFilename;

    private String messageTypeIndicator;
    private String primaryBitmap;
    private String secondaryBitmap;
    private String processingCode;
    private long outputLineId;
    private long transCount;
    private String product;
    private String subProduct;
    
    private String serviceCode;
    private String p5ReconciliationAmount;
    private String acquirerMember;
    private String issuermeMber;
    private String messageReasonCode;
    private String cardAcceptorbusCode;
    private String retrievalRefNumber;
    private String approvalCode;
    private String icclength;
    private String iccSystemRelatedData;
    private String p2PanLength;
    private String p2Pan;
    private String p12localDate;
    private String p13localTime;
    private String pointOfSaleData;
    private String cardAcceptorTerminalId;
    private String cardAcceptorId;
    private String functionCode;
    private String acquirerRefLength;
    private String p31AcquirerRefData;
    private String code;
    private String cardAcceptorLength;
    private String p26cardAcceptorName;
    private String additionalDataLength;
    private String additionalData;
    private String p20currencyCode;
    private String reconcilliationCode;
    private String messageNumber;
    private String s70NetworkmanCountryCode;
    private String s72Datalen;
    private String s72DataRecord;
    private String s73Actiondate;
    private String s74NoofCredits;
    private String s75ReversalNoofCredits;
    private String s76NoofDebits;
    private String s77ReversalNoofDebits;
    private String s78NumberTransfers;
    private String s79ReversalNumberTransfers;
    private String s80NumberEnquiries;
    private String s81NumberAuthorisations;
    private String s82ProcessingFeeCredits;
    private String s83TransactionfeeCredits;
    private String s84ProcessingFeeDebits;
    private String s85TransctionfeeAmounts;
    private String s86AmountCredits;
    private String s87ReversalAmountCredits;
    private String s88AmountDebits;
    private String s89ReversalAmountDebits;
    private String s90OriginatingDataElements;
    private String s91FileUpdateCode;
    private String s92FilesSecurityCode;
    private String s93Length;
    private String forwardingInstLength;
    private String forwardingInstCode;
    private String s93TransactionDestInstId;
    private String s94Length;
    private String s94TransactionorigInstId;
    private String s95CardIssrefDataLength;
    private String s95CardIssuerRefData;
    private String s96MessageSecuritycode;
    private String s97NetSettlementAmount;
    private String s98Payee;
    private String s99SettlementInstidCode;
    private String s100Riilen;
    private String s100RcvingInstidCode;
    private String s101Filename;
    private String s102AccountIdentification1;
    private String s103AccountIdentification2;
    private String s104TransactionDescription;
    private String s111Len;
    private String s111AmtcurrencyConversion;
    private String s123Addlen;
    private String s123AdditionalData;
    private String s124Addlen;
    private String s124AdditionalData;
    private String s125Addlen;
    private String s125AdditionalData;
    private String s127Addlen;
    private String s127NetworkData;
    private String fileid;
    
    
    
    //get Data for mastercard
    private String transactionCode;
    private String AcquirerRefData;
    private String p12LocalDate;
    private String p4transAmount;
    private String p38approvalCode;
    private String p43cardAcceptorName;
    private String p26CardAcceptorBusCode;
    private String p25MessageReasonCode;
    private String p30OriginalAmount;
    private String systemSeqNumber2;
    private String p24FunctionCode;
    private String recordId;
    private String financialIndicator;
    private String processStatus;
    private String systemSeqNumber;
    
    //get data for Visa Card
    private String mfFormat;
    private String mfAcquirer;
    private String mfDate;
    private String mfBatchNo;
    private String checkDigit;
    private String purchaseDate;
    private String auth_1;
    private String auth_2;
    private String merchantName;
    private String merchantCity;
    private String merchantCountry;
    private String merchantType;
    private String reason;
    private String reasonCode;
    
    
    

    public FileDetailDTO(
            AtomicLong fileSeqNumber,
            AtomicLong txnSeqNumber,
            String input,
            Long lineID,
            Integer txnCode,
            TCRCode tcrCode) {

        this.fileSeqNumber = fileSeqNumber;
        this.txnSeqNumber = txnSeqNumber;
        this.input = input;
        this.lineID = lineID;
        this.txnCode = txnCode;
        this.tcrCode = tcrCode;
    }

    public long getTransCount() {
		return transCount;
	}

	public void setTransCount(long transCount) {
		this.transCount = transCount;
	}

	public Long getLineID() {
        return lineID;
    }

    public Integer getInputLength() {
        return inputLength;
    }

    public void setInputLength(Integer inputLength) {
        this.inputLength = inputLength;
    }

    public AtomicLong getFileSeqNumber() {
        return fileSeqNumber;
    }

    public AtomicLong getTxnSeqNumber() {
        return txnSeqNumber;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Integer getTxnCode() {
        return txnCode;
    }

    public TCRCode getTcrCode() {
        return tcrCode;
    }

    public Integer getBillingTxnCode() {
        return billingTxnCode;
    }

    public void setBillingTxnCode(Integer billingTxnCode) {
        this.billingTxnCode = billingTxnCode;
    }

    public Integer getAcquirerBin() {
        return acquirerBin;
    }

    public void setAcquirerBin(Integer acquirerBin) {
        this.acquirerBin = acquirerBin;
    }

    public Integer getIssuerBin() {
        return issuerBin;
    }

    public void setIssuerBin(Integer issuerBin) {
        this.issuerBin = issuerBin;
    }

    public Integer getAcquirerCode() {
        return acquirerCode != null ? acquirerCode : 0;
    }

    public void setAcquirerCode(Integer acquirerCode) {
        this.acquirerCode = acquirerCode;
    }

    public Integer getIssuerCode() {
        return issuerCode != null ? issuerCode : 0;
    }

    public void setIssuerCode(Integer issuerCode) {
        this.issuerCode = issuerCode;
    }

    public String getDistributionCode() {
        return distributionCode;
    }

    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }

    public MemberRole getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(MemberRole memberRole) {
        this.memberRole = memberRole;
    }

    public Integer getCardType() {
        return cardType != null ? cardType : 0;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Long getDaysBeforefirstDeletionDate() {
        return daysBeforefirstDeletionDate;
    }

    public void setDaysBeforefirstDeletionDate(Long daysBeforefirstDeletionDate) {
        this.daysBeforefirstDeletionDate = daysBeforefirstDeletionDate;
    }

    public Long getDaysBeforefinalDeletionDate() {
        return daysBeforefinalDeletionDate;
    }

    public void setDaysBeforefinalDeletionDate(Long daysBeforefinalDeletionDate) {
        this.daysBeforefinalDeletionDate = daysBeforefinalDeletionDate;
    }

    public Long getAmount() {
        return amount != null ? amount : 0L;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getCashbackAmount() {
        return cashbackAmount != null ? cashbackAmount : 0L;
    }

    public void setCashbackAmount(Long cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }

    public boolean isCashBackPresent() {
        return cashBackPresent;
    }

    public void setCashBackPresent(boolean cashBackPresent) {
        this.cashBackPresent = cashBackPresent;
    }

    public TerminalInfo getTerminalInfo() {
        return terminalInfo;
    }

    public void setTerminalInfo(TerminalInfo terminalInfo) {
        this.terminalInfo = terminalInfo;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUsageCode() {
        return usageCode;
    }

    public void setUsageCode(String usageCode) {
        this.usageCode = usageCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BillingData getBillingData() {
        return billingData;
    }

    public void setBillingData(BillingData billingData) {
        this.billingData = billingData;
    }

    public Boolean hasCashBack() {
        return getCashbackAmount() != null && getCashbackAmount() > 0;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setMonthDay(String monthDay) {
        this.monthDay = monthDay;
    }

    public String getMonthDay() {
        return monthDay;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getOutputFilename() {
        return outputFilename;
    }

    public void setOutputFilename(String outputFilename) {
        this.outputFilename = outputFilename;
    }

    public String getMessageTypeIndicator() {
        return messageTypeIndicator;
    }

    public void setMessageTypeIndicator(String messageTypeIndicator) {
        this.messageTypeIndicator = messageTypeIndicator;
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

    public String getProcessingCode() {
        return processingCode;
    }

    public void setProcessingCode(String processingCode) {
        this.processingCode = processingCode;
    }

    public List<MastercardPDSDTO> getPdsList() {
        if (pdsList == null) {
            pdsList = new ArrayList<>();
        }
        return pdsList;
    }

    public void setPdsList(List<MastercardPDSDTO> pdsList) {
        this.pdsList = pdsList;
    }

    @Override
    public int compareTo(FileDetailDTO o) {
        int thisTcrNumber = this.getTcrCode().getId();
        int thatTcrNumber = o.getTcrCode().getId();
        return thisTcrNumber > thatTcrNumber ? 1 : -1;
    }

	public long getOutputLineId() {
		return outputLineId;
	}

	public void setOutputLineId(long outputLineId) {
		this.outputLineId = outputLineId;
	}

	public String getProduct() {
		return product;
	}

	public String getSubProduct() {
		return subProduct;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void setSubProduct(String subProduct) {
		this.subProduct = subProduct;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public String getP2Pan() {
		return p2Pan;
	}

	public String getP31AcquirerRefData() {
		return p31AcquirerRefData;
	}

	public String getP12LocalDate() {
		return p12LocalDate;
	}

	public String getP4transAmount() {
		return p4transAmount;
	}

	public String getP38approvalCode() {
		return p38approvalCode;
	}

	public String getP43cardAcceptorName() {
		return p43cardAcceptorName;
	}

	public String getP26CardAcceptorBusCode() {
		return p26CardAcceptorBusCode;
	}

	public String getP25MessageReasonCode() {
		return p25MessageReasonCode;
	}

	public String getP30OriginalAmount() {
		return p30OriginalAmount;
	}

	public String getSystemSeqNumber2() {
		return systemSeqNumber2;
	}

	public String getP24FunctionCode() {
		return p24FunctionCode;
	}

	public String getRecordId() {
		return recordId;
	}

	public String getFinancialIndicator() {
		return financialIndicator;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public String getSystemSeqNumber() {
		return systemSeqNumber;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public void setP2Pan(String p2Pan) {
		this.p2Pan = p2Pan;
	}

	public void setP31AcquirerRefData(String p31AcquirerRefData) {
		this.p31AcquirerRefData = p31AcquirerRefData;
	}

	public void setP12LocalDate(String p12LocalDate) {
		this.p12LocalDate = p12LocalDate;
	}

	public void setP4transAmount(String p4transAmount) {
		this.p4transAmount = p4transAmount;
	}

	public void setP38approvalCode(String p38approvalCode) {
		this.p38approvalCode = p38approvalCode;
	}

	public void setP43cardAcceptorName(String p43cardAcceptorName) {
		this.p43cardAcceptorName = p43cardAcceptorName;
	}

	public void setP26CardAcceptorBusCode(String p26CardAcceptorBusCode) {
		this.p26CardAcceptorBusCode = p26CardAcceptorBusCode;
	}

	public void setP25MessageReasonCode(String p25MessageReasonCode) {
		this.p25MessageReasonCode = p25MessageReasonCode;
	}

	public void setP30OriginalAmount(String p30OriginalAmount) {
		this.p30OriginalAmount = p30OriginalAmount;
	}

	public void setSystemSeqNumber2(String systemSeqNumber2) {
		this.systemSeqNumber2 = systemSeqNumber2;
	}

	public void setP24FunctionCode(String p24FunctionCode) {
		this.p24FunctionCode = p24FunctionCode;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public void setFinancialIndicator(String financialIndicator) {
		this.financialIndicator = financialIndicator;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public void setSystemSeqNumber(String systemSeqNumber) {
		this.systemSeqNumber = systemSeqNumber;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public String getP5ReconciliationAmount() {
		return p5ReconciliationAmount;
	}

	public String getAcquirerMember() {
		return acquirerMember;
	}

	public String getIssuermeMber() {
		return issuermeMber;
	}

	public String getMessageReasonCode() {
		return messageReasonCode;
	}

	public String getCardAcceptorbusCode() {
		return cardAcceptorbusCode;
	}

	public String getRetrievalRefNumber() {
		return retrievalRefNumber;
	}

	public String getApprovalCode() {
		return approvalCode;
	}

	public String getIcclength() {
		return icclength;
	}

	public String getIccSystemRelatedData() {
		return iccSystemRelatedData;
	}

	public String getP2PanLength() {
		return p2PanLength;
	}

	public String getP12localDate() {
		return p12localDate;
	}

	public String getP13localTime() {
		return p13localTime;
	}

	public String getPointOfSaleData() {
		return pointOfSaleData;
	}

	public String getCardAcceptorTerminalId() {
		return cardAcceptorTerminalId;
	}

	public String getCardAcceptorId() {
		return cardAcceptorId;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public String getAcquirerRefLength() {
		return acquirerRefLength;
	}

	public String getCode() {
		return code;
	}

	public String getCardAcceptorLength() {
		return cardAcceptorLength;
	}

	public String getP26cardAcceptorName() {
		return p26cardAcceptorName;
	}

	public String getAdditionalDataLength() {
		return additionalDataLength;
	}

	public String getAdditionalData() {
		return additionalData;
	}

	public String getP20currencyCode() {
		return p20currencyCode;
	}

	public String getReconcilliationCode() {
		return reconcilliationCode;
	}

	public String getMessageNumber() {
		return messageNumber;
	}

	public String getS70NetworkmanCountryCode() {
		return s70NetworkmanCountryCode;
	}

	public String getS72Datalen() {
		return s72Datalen;
	}

	public String getS72DataRecord() {
		return s72DataRecord;
	}

	public String getS73Actiondate() {
		return s73Actiondate;
	}

	public String getS74NoofCredits() {
		return s74NoofCredits;
	}

	public String getS75ReversalNoofCredits() {
		return s75ReversalNoofCredits;
	}

	public String getS76NoofDebits() {
		return s76NoofDebits;
	}

	public String getS77ReversalNoofDebits() {
		return s77ReversalNoofDebits;
	}

	public String getS78NumberTransfers() {
		return s78NumberTransfers;
	}

	public String getS79ReversalNumberTransfers() {
		return s79ReversalNumberTransfers;
	}

	public String getS80NumberEnquiries() {
		return s80NumberEnquiries;
	}

	public String getS81NumberAuthorisations() {
		return s81NumberAuthorisations;
	}

	public String getS82ProcessingFeeCredits() {
		return s82ProcessingFeeCredits;
	}

	public String getS83TransactionfeeCredits() {
		return s83TransactionfeeCredits;
	}

	public String getS84ProcessingFeeDebits() {
		return s84ProcessingFeeDebits;
	}

	public String getS85TransctionfeeAmounts() {
		return s85TransctionfeeAmounts;
	}

	public String getS86AmountCredits() {
		return s86AmountCredits;
	}

	public String getS87ReversalAmountCredits() {
		return s87ReversalAmountCredits;
	}

	public String getS88AmountDebits() {
		return s88AmountDebits;
	}

	public String getS89ReversalAmountDebits() {
		return s89ReversalAmountDebits;
	}

	public String getS90OriginatingDataElements() {
		return s90OriginatingDataElements;
	}

	public String getS91FileUpdateCode() {
		return s91FileUpdateCode;
	}

	public String getS92FilesSecurityCode() {
		return s92FilesSecurityCode;
	}

	public String getS93Length() {
		return s93Length;
	}

	public String getForwardingInstLength() {
		return forwardingInstLength;
	}

	public String getForwardingInstCode() {
		return forwardingInstCode;
	}

	public String getS93TransactionDestInstId() {
		return s93TransactionDestInstId;
	}

	public String getS94Length() {
		return s94Length;
	}

	public String getS94TransactionorigInstId() {
		return s94TransactionorigInstId;
	}

	public String getS95CardIssrefDataLength() {
		return s95CardIssrefDataLength;
	}

	public String getS95CardIssuerRefData() {
		return s95CardIssuerRefData;
	}

	public String getS96MessageSecuritycode() {
		return s96MessageSecuritycode;
	}

	public String getS97NetSettlementAmount() {
		return s97NetSettlementAmount;
	}

	public String getS98Payee() {
		return s98Payee;
	}

	public String getS99SettlementInstidCode() {
		return s99SettlementInstidCode;
	}

	public String getS100Riilen() {
		return s100Riilen;
	}

	public String getS100RcvingInstidCode() {
		return s100RcvingInstidCode;
	}

	public String getS101Filename() {
		return s101Filename;
	}

	public String getS102AccountIdentification1() {
		return s102AccountIdentification1;
	}

	public String getS103AccountIdentification2() {
		return s103AccountIdentification2;
	}

	public String getS104TransactionDescription() {
		return s104TransactionDescription;
	}

	public String getS111Len() {
		return s111Len;
	}

	public String getS111AmtcurrencyConversion() {
		return s111AmtcurrencyConversion;
	}

	public String getS123Addlen() {
		return s123Addlen;
	}

	public String getS123AdditionalData() {
		return s123AdditionalData;
	}

	public String getS124Addlen() {
		return s124Addlen;
	}

	public String getS124AdditionalData() {
		return s124AdditionalData;
	}

	public String getS125Addlen() {
		return s125Addlen;
	}

	public String getS125AdditionalData() {
		return s125AdditionalData;
	}

	public String getS127Addlen() {
		return s127Addlen;
	}

	public String getS127NetworkData() {
		return s127NetworkData;
	}

	public String getFileid() {
		return fileid;
	}

	public String getAcquirerRefData() {
		return AcquirerRefData;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public void setP5ReconciliationAmount(String p5ReconciliationAmount) {
		this.p5ReconciliationAmount = p5ReconciliationAmount;
	}

	public void setAcquirerMember(String acquirerMember) {
		this.acquirerMember = acquirerMember;
	}

	public void setIssuermeMber(String issuermeMber) {
		this.issuermeMber = issuermeMber;
	}

	public void setMessageReasonCode(String messageReasonCode) {
		this.messageReasonCode = messageReasonCode;
	}

	public void setCardAcceptorbusCode(String cardAcceptorbusCode) {
		this.cardAcceptorbusCode = cardAcceptorbusCode;
	}

	public void setRetrievalRefNumber(String retrievalRefNumber) {
		this.retrievalRefNumber = retrievalRefNumber;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	public void setIcclength(String icclength) {
		this.icclength = icclength;
	}

	public void setIccSystemRelatedData(String iccSystemRelatedData) {
		this.iccSystemRelatedData = iccSystemRelatedData;
	}

	public void setP2PanLength(String p2PanLength) {
		this.p2PanLength = p2PanLength;
	}

	public void setP12localDate(String p12localDate) {
		this.p12localDate = p12localDate;
	}

	public void setP13localTime(String p13localTime) {
		this.p13localTime = p13localTime;
	}

	public void setPointOfSaleData(String pointOfSaleData) {
		this.pointOfSaleData = pointOfSaleData;
	}

	public void setCardAcceptorTerminalId(String cardAcceptorTerminalId) {
		this.cardAcceptorTerminalId = cardAcceptorTerminalId;
	}

	public void setCardAcceptorId(String cardAcceptorId) {
		this.cardAcceptorId = cardAcceptorId;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public void setAcquirerRefLength(String acquirerRefLength) {
		this.acquirerRefLength = acquirerRefLength;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCardAcceptorLength(String cardAcceptorLength) {
		this.cardAcceptorLength = cardAcceptorLength;
	}

	public void setP26cardAcceptorName(String p26cardAcceptorName) {
		this.p26cardAcceptorName = p26cardAcceptorName;
	}

	public void setAdditionalDataLength(String additionalDataLength) {
		this.additionalDataLength = additionalDataLength;
	}

	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;
	}

	public void setP20currencyCode(String p20currencyCode) {
		this.p20currencyCode = p20currencyCode;
	}

	public void setReconcilliationCode(String reconcilliationCode) {
		this.reconcilliationCode = reconcilliationCode;
	}

	public void setMessageNumber(String messageNumber) {
		this.messageNumber = messageNumber;
	}

	public void setS70NetworkmanCountryCode(String s70NetworkmanCountryCode) {
		this.s70NetworkmanCountryCode = s70NetworkmanCountryCode;
	}

	public void setS72Datalen(String s72Datalen) {
		this.s72Datalen = s72Datalen;
	}

	public void setS72DataRecord(String s72DataRecord) {
		this.s72DataRecord = s72DataRecord;
	}

	public void setS73Actiondate(String s73Actiondate) {
		this.s73Actiondate = s73Actiondate;
	}

	public void setS74NoofCredits(String s74NoofCredits) {
		this.s74NoofCredits = s74NoofCredits;
	}

	public void setS75ReversalNoofCredits(String s75ReversalNoofCredits) {
		this.s75ReversalNoofCredits = s75ReversalNoofCredits;
	}

	public void setS76NoofDebits(String s76NoofDebits) {
		this.s76NoofDebits = s76NoofDebits;
	}

	public void setS77ReversalNoofDebits(String s77ReversalNoofDebits) {
		this.s77ReversalNoofDebits = s77ReversalNoofDebits;
	}

	public void setS78NumberTransfers(String s78NumberTransfers) {
		this.s78NumberTransfers = s78NumberTransfers;
	}

	public void setS79ReversalNumberTransfers(String s79ReversalNumberTransfers) {
		this.s79ReversalNumberTransfers = s79ReversalNumberTransfers;
	}

	public void setS80NumberEnquiries(String s80NumberEnquiries) {
		this.s80NumberEnquiries = s80NumberEnquiries;
	}

	public void setS81NumberAuthorisations(String s81NumberAuthorisations) {
		this.s81NumberAuthorisations = s81NumberAuthorisations;
	}

	public void setS82ProcessingFeeCredits(String s82ProcessingFeeCredits) {
		this.s82ProcessingFeeCredits = s82ProcessingFeeCredits;
	}

	public void setS83TransactionfeeCredits(String s83TransactionfeeCredits) {
		this.s83TransactionfeeCredits = s83TransactionfeeCredits;
	}

	public void setS84ProcessingFeeDebits(String s84ProcessingFeeDebits) {
		this.s84ProcessingFeeDebits = s84ProcessingFeeDebits;
	}

	public void setS85TransctionfeeAmounts(String s85TransctionfeeAmounts) {
		this.s85TransctionfeeAmounts = s85TransctionfeeAmounts;
	}

	public void setS86AmountCredits(String s86AmountCredits) {
		this.s86AmountCredits = s86AmountCredits;
	}

	public void setS87ReversalAmountCredits(String s87ReversalAmountCredits) {
		this.s87ReversalAmountCredits = s87ReversalAmountCredits;
	}

	public void setS88AmountDebits(String s88AmountDebits) {
		this.s88AmountDebits = s88AmountDebits;
	}

	public void setS89ReversalAmountDebits(String s89ReversalAmountDebits) {
		this.s89ReversalAmountDebits = s89ReversalAmountDebits;
	}

	public void setS90OriginatingDataElements(String s90OriginatingDataElements) {
		this.s90OriginatingDataElements = s90OriginatingDataElements;
	}

	public void setS91FileUpdateCode(String s91FileUpdateCode) {
		this.s91FileUpdateCode = s91FileUpdateCode;
	}

	public void setS92FilesSecurityCode(String s92FilesSecurityCode) {
		this.s92FilesSecurityCode = s92FilesSecurityCode;
	}

	public void setS93Length(String s93Length) {
		this.s93Length = s93Length;
	}

	public void setForwardingInstLength(String forwardingInstLength) {
		this.forwardingInstLength = forwardingInstLength;
	}

	public void setForwardingInstCode(String forwardingInstCode) {
		this.forwardingInstCode = forwardingInstCode;
	}

	public void setS93TransactionDestInstId(String s93TransactionDestInstId) {
		this.s93TransactionDestInstId = s93TransactionDestInstId;
	}

	public void setS94Length(String s94Length) {
		this.s94Length = s94Length;
	}

	public void setS94TransactionorigInstId(String s94TransactionorigInstId) {
		this.s94TransactionorigInstId = s94TransactionorigInstId;
	}

	public void setS95CardIssrefDataLength(String s95CardIssrefDataLength) {
		this.s95CardIssrefDataLength = s95CardIssrefDataLength;
	}

	public void setS95CardIssuerRefData(String s95CardIssuerRefData) {
		this.s95CardIssuerRefData = s95CardIssuerRefData;
	}

	public void setS96MessageSecuritycode(String s96MessageSecuritycode) {
		this.s96MessageSecuritycode = s96MessageSecuritycode;
	}

	public void setS97NetSettlementAmount(String s97NetSettlementAmount) {
		this.s97NetSettlementAmount = s97NetSettlementAmount;
	}

	public void setS98Payee(String s98Payee) {
		this.s98Payee = s98Payee;
	}

	public void setS99SettlementInstidCode(String s99SettlementInstidCode) {
		this.s99SettlementInstidCode = s99SettlementInstidCode;
	}

	public void setS100Riilen(String s100Riilen) {
		this.s100Riilen = s100Riilen;
	}

	public void setS100RcvingInstidCode(String s100RcvingInstidCode) {
		this.s100RcvingInstidCode = s100RcvingInstidCode;
	}

	public void setS101Filename(String s101Filename) {
		this.s101Filename = s101Filename;
	}

	public void setS102AccountIdentification1(String s102AccountIdentification1) {
		this.s102AccountIdentification1 = s102AccountIdentification1;
	}

	public void setS103AccountIdentification2(String s103AccountIdentification2) {
		this.s103AccountIdentification2 = s103AccountIdentification2;
	}

	public void setS104TransactionDescription(String s104TransactionDescription) {
		this.s104TransactionDescription = s104TransactionDescription;
	}

	public void setS111Len(String s111Len) {
		this.s111Len = s111Len;
	}

	public void setS111AmtcurrencyConversion(String s111AmtcurrencyConversion) {
		this.s111AmtcurrencyConversion = s111AmtcurrencyConversion;
	}

	public void setS123Addlen(String s123Addlen) {
		this.s123Addlen = s123Addlen;
	}

	public void setS123AdditionalData(String s123AdditionalData) {
		this.s123AdditionalData = s123AdditionalData;
	}

	public void setS124Addlen(String s124Addlen) {
		this.s124Addlen = s124Addlen;
	}

	public void setS124AdditionalData(String s124AdditionalData) {
		this.s124AdditionalData = s124AdditionalData;
	}

	public void setS125Addlen(String s125Addlen) {
		this.s125Addlen = s125Addlen;
	}

	public void setS125AdditionalData(String s125AdditionalData) {
		this.s125AdditionalData = s125AdditionalData;
	}

	public void setS127Addlen(String s127Addlen) {
		this.s127Addlen = s127Addlen;
	}

	public void setS127NetworkData(String s127NetworkData) {
		this.s127NetworkData = s127NetworkData;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	public void setAcquirerRefData(String acquirerRefData) {
		AcquirerRefData = acquirerRefData;
	}

	public String getMfFormat() {
		return mfFormat;
	}

	public String getMfAcquirer() {
		return mfAcquirer;
	}

	public String getMfDate() {
		return mfDate;
	}

	public String getMfBatchNo() {
		return mfBatchNo;
	}

	public String getCheckDigit() {
		return checkDigit;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public String getAuth_1() {
		return auth_1;
	}

	public String getAuth_2() {
		return auth_2;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public String getMerchantCity() {
		return merchantCity;
	}

	public String getMerchantCountry() {
		return merchantCountry;
	}

	public String getMerchantType() {
		return merchantType;
	}

	public String getReason() {
		return reason;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setMfFormat(String mfFormat) {
		this.mfFormat = mfFormat;
	}

	public void setMfAcquirer(String mfAcquirer) {
		this.mfAcquirer = mfAcquirer;
	}

	public void setMfDate(String mfDate) {
		this.mfDate = mfDate;
	}

	public void setMfBatchNo(String mfBatchNo) {
		this.mfBatchNo = mfBatchNo;
	}

	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public void setAuth_1(String auth_1) {
		this.auth_1 = auth_1;
	}

	public void setAuth_2(String auth_2) {
		this.auth_2 = auth_2;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public void setMerchantCity(String merchantCity) {
		this.merchantCity = merchantCity;
	}

	public void setMerchantCountry(String merchantCountry) {
		this.merchantCountry = merchantCountry;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
}

