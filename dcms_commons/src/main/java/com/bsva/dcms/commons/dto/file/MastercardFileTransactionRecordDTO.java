package com.bsva.dcms.commons.dto.file;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class MastercardFileTransactionRecordDTO extends FileTransactionRecordDTO {

    private boolean financialStatus = true;
    private int transactionOriginator;
    private int recordStartByte;
    private int recordEndByte;
    private int transactionTarget;
    private int IRD = 0;
    private String primaryBitMap;
    private String secondaryBitMap;
    private String fileRefNumber;
    private String fileNameDescription;
    private boolean isSecondaryBitMapPresent;
    private Map<Integer, DataElementDTO> dataElementsMap;
    private String recordId = "00";
    private int acquirerBin;
    private int acquirer;
    private boolean isCurrentRecordValid = true;
    private int merchantCatCode;
    private boolean isTransactionACashBack = false;
    private long cashbackAmount;
    private int issuerBin;
    private int issuer;
    private String cardNumber;
    private String messageTypeIndicator;
    private int fileSystemSeqNumber;
    private String ProcessStatus;
    private String AccountNumber;
    private String OutputFilename;
    private String fleetCountTran;
    private String extractInd;
    private String cardAcceptorBusCode;
    private String retrievalRefNumber;
    private String approvalCode;
    private String cardType;
    private String iccLength;
    private String iccSystemRelatedData;
    private int panlength;
    private String pan;
    private String localDate;
    private String localTime;
    private String pointOfSaleData;
    private String cardAcceptorTerminalId;
    private String cardAcceptorId;
    private String fowardingInstCode;
    private int functionCode;
    private int acquirerRefLength;
    private String acquirerRefData;
    private int code;
    private int cardAcceptorLength;
    private String cardAcceptorName;
    private int additionalDataLength;
    private String additionalData;
    private String currencyCode;
    private String reconciliationCode;
    private int messageNumber;
    private int p33ForwardingInstLength;
    private int fileRecordCnt;//FILE_RECORD_CNT
    private int s70networkmancountrycode;
    private int s72datalen;
    private String s72datarecord;
    private String s73actiondate;
    private String s74noofcredits;
                         
    private String s75reversalnoofcredits;
    private String s76noofdebits;
    private String s77reversalnoofdebits;
    private String s78numbertransfers;
    private String s79reversalnumbertransfers;
    private String s80numberenquiries;
    private String s81numberauthorisations;
            
    private String s82processingfeecredits;
    private String s83transactionfeecredits;
    private String s84processingfeedebits;
    private String s85transctionfeeamounts;
    private String s86amountcredits;
    private long s87reversalamountcredits;
                        
    private long s88amountdebits;
    private long s89reversalamountdebits;
    private long s90originatingdataelements;
    private String s91fileupdatecode;
    private String s92filessecuritycode;
    private int s93length;
    private long s93transactiondestinstid;
    private int s94length;        
    private String s94transactionoriginstid;             
    private String s95cardissrefdatalength;
    private int s95cardissuerrefdata;
    
    private String s96messagesecuritycode;
    private long s97netsettlementamount;
    private String s98payee;
    private long s99settlementinstidcode;
    private int s100riilen;
    private long s100rcvinginstidcode;
    private String s101filename;
    private String s102accountidentification1;
    private String s103accountidentification2;

    private String s104transactiondescription;
    private int s111len;
    private String s111amtcurrencyconversion;
    private int s123addlen;
    private String s123additionaldata;
    private int s124addlen;
    private String s124additionaldata;
    private int s125addlen;
    private String s125additionaldata;
    private int s127addlen;
    private String s127networkdata;
    private String fileid;
    private long reconciliationAmout;
    


    public MastercardFileTransactionRecordDTO() {

        dataElementsMap = new HashMap<Integer, DataElementDTO>();
//    	
//    	for(int i = 0 ; i <= 128; i++){
//    		dataElementsMap.put(i, null);
//    	}
    }

    public boolean isFinancialStatus() {
        return financialStatus;
    }

    public void setFinancialStatus(boolean financialStatus) {
        this.financialStatus = financialStatus;
    }

    public int getTransactionOriginator() {
        return transactionOriginator;
    }

    public void setTransactionOriginator(int transactionOriginator) {
        this.transactionOriginator = transactionOriginator;
    }

    public String getPrimaryBitMap() {
        return primaryBitMap;
    }

    public void setPrimaryBitMap(String primaryBitMap) {
        this.primaryBitMap = primaryBitMap;
    }

    public String getSecondaryBitMap() {
        return secondaryBitMap;
    }

    public void setSecondaryBitMap(String secondaryBitMap) {
        this.secondaryBitMap = secondaryBitMap;
    }

    public int getRecordStartByte() {
        return recordStartByte;
    }

    public void setRecordStartByte(int recordStartByte) {
        this.recordStartByte = recordStartByte;
    }

    public int getRecordEndByte() {
        return recordEndByte;
    }

    public void setRecordEndByte(int recordEndByte) {
        this.recordEndByte = recordEndByte;
    }

    public int getAcquirerBin() {
        return acquirerBin;
    }

    public void setAcquirerBin(int acquirerBin) {
        this.acquirerBin = acquirerBin;
    }

    public int getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(int acquirer) {
        this.acquirer = acquirer;
    }

    @Override
    public boolean isCurrentRecordValid() {
        return isCurrentRecordValid;
    }

    @Override
    public void setCurrentRecordValid(boolean isCurrentRecordValid) {
        this.isCurrentRecordValid = isCurrentRecordValid;
    }

    public int getMerchantCatCode() {
        return merchantCatCode;
    }

    public void setMerchantCatCode(int merchantCatCode) {
        this.merchantCatCode = merchantCatCode;
    }

    public boolean isTransactionACashBack() {
        return isTransactionACashBack;
    }

    public void setTransactionACashBack(boolean isTransactionACashBack) {
        this.isTransactionACashBack = isTransactionACashBack;
    }

    public long getCashbackAmount() {
        return cashbackAmount;
    }

    public void setCashbackAmount(long cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }

    public int getIssuerBin() {
        return issuerBin;
    }

    public void setIssuerBin(int issuerBin) {
        this.issuerBin = issuerBin;
    }

    public int getIssuer() {
        return issuer;
    }

    public void setIssuer(int issuer) {
        this.issuer = issuer;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getTransactionTarget() {
        return transactionTarget;
    }

    public void setTransactionTarget(int transactionTarget) {
        this.transactionTarget = transactionTarget;
    }

    public int getIRD() {
        return IRD;
    }

    public void setIRD(int iRD) {
        IRD = iRD;
    }

//	public int getMessageReasonCode() {
//		return messageReasonCode;
//	}
//
//	public void setMessageReasonCode(int messageReasonCode) {
//		this.messageReasonCode = messageReasonCode;
//	}
    public Map<Integer, DataElementDTO> getDataElementsMap() {
        return dataElementsMap;
    }

    public void setDataElementsMap(Map<Integer, DataElementDTO> dataElementsMap) {
        this.dataElementsMap = dataElementsMap;
    }

    public String getFileRefNumber() {
        return fileRefNumber;
    }

    public void setFileRefNumber(String fileRefNumber) {
        this.fileRefNumber = fileRefNumber;
    }

    public boolean isSecondaryBitMapPresent() {
        return isSecondaryBitMapPresent;
    }

    public void setSecondaryBitMapPresent(boolean isSecondaryBitMapPresent) {
        this.isSecondaryBitMapPresent = isSecondaryBitMapPresent;
    }

    public String getMessageTypeIndicator() {
        return messageTypeIndicator;
    }

    public void setMessageTypeIndicator(String messageTypeIndicator) {
        this.messageTypeIndicator = messageTypeIndicator;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public int getFileSystemSeqNumber() {
        return fileSystemSeqNumber;
    }

    public void setFileSystemSeqNumber(int fileSystemSeqNumber) {
        this.fileSystemSeqNumber = fileSystemSeqNumber;
    }

    public String getProcessStatus() {
        return ProcessStatus;
    }

    public void setProcessStatus(String ProcessStatus) {
        this.ProcessStatus = ProcessStatus;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public String getOutputFilename() {
        return OutputFilename;
    }

    public void setOutputFilename(String OutputFilename) {
        this.OutputFilename = OutputFilename;
    }

    public String getFleetCountTran() {
        return fleetCountTran;
    }

    public void setFleetCountTran(String fleetCountTran) {
        this.fleetCountTran = fleetCountTran;
    }

    public String getExtractInd() {
        return extractInd;
    }

    public void setExtractInd(String extractInd) {
        this.extractInd = extractInd;
    }

    public String getFileNameDescription() {
        return fileNameDescription;
    }

    public void setFileNameDescription(String fileNameDescription) {
        this.fileNameDescription = fileNameDescription;
    }

    public boolean isIsSecondaryBitMapPresent() {
        return isSecondaryBitMapPresent;
    }

    public void setIsSecondaryBitMapPresent(boolean isSecondaryBitMapPresent) {
        this.isSecondaryBitMapPresent = isSecondaryBitMapPresent;
    }

    public boolean isIsCurrentRecordValid() {
        return isCurrentRecordValid;
    }

    public void setIsCurrentRecordValid(boolean isCurrentRecordValid) {
        this.isCurrentRecordValid = isCurrentRecordValid;
    }

    public boolean isIsTransactionACashBack() {
        return isTransactionACashBack;
    }

    public void setIsTransactionACashBack(boolean isTransactionACashBack) {
        this.isTransactionACashBack = isTransactionACashBack;
    }

    public String getCardAcceptorBusCode() {
        return cardAcceptorBusCode;
    }

    public void setCardAcceptorBusCode(String cardAcceptorBusCode) {
        this.cardAcceptorBusCode = cardAcceptorBusCode;
    }

    public String getRetrievalRefNumber() {
        return retrievalRefNumber;
    }

    public void setRetrievalRefNumber(String retrievalRefNumber) {
        this.retrievalRefNumber = retrievalRefNumber;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getIccLength() {
        return iccLength;
    }

    public void setIccLength(String iccLength) {
        this.iccLength = iccLength;
    }

    public String getIccSystemRelatedData() {
        return iccSystemRelatedData;
    }

    public void setIccSystemRelatedData(String iccSystemRelatedData) {
        this.iccSystemRelatedData = iccSystemRelatedData;
    }

    public int getPanlength() {
        return panlength;
    }

    public void setPanlength(int panlength) {
        this.panlength = panlength;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getPointOfSaleData() {
        return pointOfSaleData;
    }

    public void setPointOfSaleData(String pointOfSaleData) {
        this.pointOfSaleData = pointOfSaleData;
    }

    public String getCardAcceptorTerminalId() {
        return cardAcceptorTerminalId;
    }

    public void setCardAcceptorTerminalId(String cardAcceptorTerminalId) {
        this.cardAcceptorTerminalId = cardAcceptorTerminalId;
    }

    public String getCardAcceptorId() {
        return cardAcceptorId;
    }

    public void setCardAcceptorId(String cardAcceptorId) {
        this.cardAcceptorId = cardAcceptorId;
    }

    public String getFowardingInstCode() {
        return fowardingInstCode;
    }

    public void setFowardingInstCode(String fowardingInstCode) {
        this.fowardingInstCode = fowardingInstCode;
    }

    public int getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(int functionCode) {
        this.functionCode = functionCode;
    }

    public int getAcquirerRefLength() {
        return acquirerRefLength;
    }

    public void setAcquirerRefLength(int acquirerRefLength) {
        this.acquirerRefLength = acquirerRefLength;
    }

    public String getAcquirerRefData() {
        return acquirerRefData;
    }

    public void setAcquirerRefData(String acquirerRefData) {
        this.acquirerRefData = acquirerRefData;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCardAcceptorLength() {
        return cardAcceptorLength;
    }

    public void setCardAcceptorLength(int cardAcceptorLength) {
        this.cardAcceptorLength = cardAcceptorLength;
    }

    public String getCardAcceptorName() {
        return cardAcceptorName;
    }

    public void setCardAcceptorName(String cardAcceptorName) {
        this.cardAcceptorName = cardAcceptorName;
    }

    public int getAdditionalDataLength() {
        return additionalDataLength;
    }

    public void setAdditionalDataLength(int additionalDataLength) {
        this.additionalDataLength = additionalDataLength;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getReconciliationCode() {
        return reconciliationCode;
    }

    public void setReconciliationCode(String reconciliationCode) {
        this.reconciliationCode = reconciliationCode;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(int messageNumber) {
        this.messageNumber = messageNumber;
    }

    public int getP33ForwardingInstLength() {
        return p33ForwardingInstLength;
    }

    public void setP33ForwardingInstLength(int p33ForwardingInstLength) {
        this.p33ForwardingInstLength = p33ForwardingInstLength;
    }

    public int getS70networkmancountrycode() {
        return s70networkmancountrycode;
    }

    public void setS70networkmancountrycode(int s70networkmancountrycode) {
        this.s70networkmancountrycode = s70networkmancountrycode;
    }

    public int getS72datalen() {
        return s72datalen;
    }

    public void setS72datalen(int s72datalen) {
        this.s72datalen = s72datalen;
    }

    public String getS72datarecord() {
        return s72datarecord;
    }

    public void setS72datarecord(String s72datarecord) {
        this.s72datarecord = s72datarecord;
    }

    public String getS73actiondate() {
        return s73actiondate;
    }

    public void setS73actiondate(String s73actiondate) {
        this.s73actiondate = s73actiondate;
    }

    public String getS74noofcredits() {
        return s74noofcredits;
    }

    public void setS74noofcredits(String s74noofcredits) {
        this.s74noofcredits = s74noofcredits;
    }

    public String getS75reversalnoofcredits() {
        return s75reversalnoofcredits;
    }

    public void setS75reversalnoofcredits(String s75reversalnoofcredits) {
        this.s75reversalnoofcredits = s75reversalnoofcredits;
    }

    public String getS76noofdebits() {
        return s76noofdebits;
    }

    public void setS76noofdebits(String s76noofdebits) {
        this.s76noofdebits = s76noofdebits;
    }

    public String getS77reversalnoofdebits() {
        return s77reversalnoofdebits;
    }

    public void setS77reversalnoofdebits(String s77reversalnoofdebits) {
        this.s77reversalnoofdebits = s77reversalnoofdebits;
    }

    public String getS78numbertransfers() {
        return s78numbertransfers;
    }

    public void setS78numbertransfers(String s78numbertransfers) {
        this.s78numbertransfers = s78numbertransfers;
    }

    public String getS79reversalnumbertransfers() {
        return s79reversalnumbertransfers;
    }

    public void setS79reversalnumbertransfers(String s79reversalnumbertransfers) {
        this.s79reversalnumbertransfers = s79reversalnumbertransfers;
    }

    public String getS80numberenquiries() {
        return s80numberenquiries;
    }

    public void setS80numberenquiries(String s80numberenquiries) {
        this.s80numberenquiries = s80numberenquiries;
    }

    public String getS81numberauthorisations() {
        return s81numberauthorisations;
    }

    public void setS81numberauthorisations(String s81numberauthorisations) {
        this.s81numberauthorisations = s81numberauthorisations;
    }

    public String getS82processingfeecredits() {
        return s82processingfeecredits;
    }

    public void setS82processingfeecredits(String s82processingfeecredits) {
        this.s82processingfeecredits = s82processingfeecredits;
    }

    public String getS83transactionfeecredits() {
        return s83transactionfeecredits;
    }

    public void setS83transactionfeecredits(String s83transactionfeecredits) {
        this.s83transactionfeecredits = s83transactionfeecredits;
    }

    public String getS84processingfeedebits() {
        return s84processingfeedebits;
    }

    public void setS84processingfeedebits(String s84processingfeedebits) {
        this.s84processingfeedebits = s84processingfeedebits;
    }

    public String getS85transctionfeeamounts() {
        return s85transctionfeeamounts;
    }

    public void setS85transctionfeeamounts(String s85transctionfeeamounts) {
        this.s85transctionfeeamounts = s85transctionfeeamounts;
    }

    public String getS86amountcredits() {
        return s86amountcredits;
    }

    public void setS86amountcredits(String s86amountcredits) {
        this.s86amountcredits = s86amountcredits;
    }

    public long getS87reversalamountcredits() {
        return s87reversalamountcredits;
    }

    public void setS87reversalamountcredits(long s87reversalamountcredits) {
        this.s87reversalamountcredits = s87reversalamountcredits;
    }

    public long getS88amountdebits() {
        return s88amountdebits;
    }

    public void setS88amountdebits(long s88amountdebits) {
        this.s88amountdebits = s88amountdebits;
    }

    public long getS89reversalamountdebits() {
        return s89reversalamountdebits;
    }

    public void setS89reversalamountdebits(long s89reversalamountdebits) {
        this.s89reversalamountdebits = s89reversalamountdebits;
    }

    public long getS90originatingdataelements() {
        return s90originatingdataelements;
    }

    public void setS90originatingdataelements(long s90originatingdataelements) {
        this.s90originatingdataelements = s90originatingdataelements;
    }

    public String getS91fileupdatecode() {
        return s91fileupdatecode;
    }

    public void setS91fileupdatecode(String s91fileupdatecode) {
        this.s91fileupdatecode = s91fileupdatecode;
    }

    public String getS92filessecuritycode() {
        return s92filessecuritycode;
    }

    public void setS92filessecuritycode(String s92filessecuritycode) {
        this.s92filessecuritycode = s92filessecuritycode;
    }

    public int getS93length() {
        return s93length;
    }

    public void setS93length(int s93length) {
        this.s93length = s93length;
    }

    public long getS93transactiondestinstid() {
        return s93transactiondestinstid;
    }

    public void setS93transactiondestinstid(long s93transactiondestinstid) {
        this.s93transactiondestinstid = s93transactiondestinstid;
    }

    public int getS94length() {
        return s94length;
    }

    public void setS94length(int s94length) {
        this.s94length = s94length;
    }

    public String getS94transactionoriginstid() {
        return s94transactionoriginstid;
    }

    public void setS94transactionoriginstid(String s94transactionoriginstid) {
        this.s94transactionoriginstid = s94transactionoriginstid;
    }

    public String getS95cardissrefdatalength() {
        return s95cardissrefdatalength;
    }

    public void setS95cardissrefdatalength(String s95cardissrefdatalength) {
        this.s95cardissrefdatalength = s95cardissrefdatalength;
    }

    public int getS95cardissuerrefdata() {
        return s95cardissuerrefdata;
    }

    public void setS95cardissuerrefdata(int s95cardissuerrefdata) {
        this.s95cardissuerrefdata = s95cardissuerrefdata;
    }

    public String getS96messagesecuritycode() {
        return s96messagesecuritycode;
    }

    public void setS96messagesecuritycode(String s96messagesecuritycode) {
        this.s96messagesecuritycode = s96messagesecuritycode;
    }

    public long getS97netsettlementamount() {
        return s97netsettlementamount;
    }

    public void setS97netsettlementamount(long s97netsettlementamount) {
        this.s97netsettlementamount = s97netsettlementamount;
    }

    public String getS98payee() {
        return s98payee;
    }

    public void setS98payee(String s98payee) {
        this.s98payee = s98payee;
    }

    public long getS99settlementinstidcode() {
        return s99settlementinstidcode;
    }

    public void setS99settlementinstidcode(long s99settlementinstidcode) {
        this.s99settlementinstidcode = s99settlementinstidcode;
    }

    public int getS100riilen() {
        return s100riilen;
    }

    public void setS100riilen(int s100riilen) {
        this.s100riilen = s100riilen;
    }

    public long getS100rcvinginstidcode() {
        return s100rcvinginstidcode;
    }

    public void setS100rcvinginstidcode(long s100rcvinginstidcode) {
        this.s100rcvinginstidcode = s100rcvinginstidcode;
    }

    public String getS101filename() {
        return s101filename;
    }

    public void setS101filename(String s101filename) {
        this.s101filename = s101filename;
    }

    public String getS102accountidentification1() {
        return s102accountidentification1;
    }

    public void setS102accountidentification1(String s102accountidentification1) {
        this.s102accountidentification1 = s102accountidentification1;
    }

    public String getS103accountidentification2() {
        return s103accountidentification2;
    }

    public void setS103accountidentification2(String s103accountidentification2) {
        this.s103accountidentification2 = s103accountidentification2;
    }

    public String getS104transactiondescription() {
        return s104transactiondescription;
    }

    public void setS104transactiondescription(String s104transactiondescription) {
        this.s104transactiondescription = s104transactiondescription;
    }

    public int getS111len() {
        return s111len;
    }

    public void setS111len(int s111len) {
        this.s111len = s111len;
    }

    public String getS111amtcurrencyconversion() {
        return s111amtcurrencyconversion;
    }

    public void setS111amtcurrencyconversion(String s111amtcurrencyconversion) {
        this.s111amtcurrencyconversion = s111amtcurrencyconversion;
    }

    public int getS123addlen() {
        return s123addlen;
    }

    public void setS123addlen(int s123addlen) {
        this.s123addlen = s123addlen;
    }

    public String getS123additionaldata() {
        return s123additionaldata;
    }

    public void setS123additionaldata(String s123additionaldata) {
        this.s123additionaldata = s123additionaldata;
    }

    public int getS124addlen() {
        return s124addlen;
    }

    public void setS124addlen(int s124addlen) {
        this.s124addlen = s124addlen;
    }

    public String getS124additionaldata() {
        return s124additionaldata;
    }

    public void setS124additionaldata(String s124additionaldata) {
        this.s124additionaldata = s124additionaldata;
    }

    public int getS125addlen() {
        return s125addlen;
    }

    public void setS125addlen(int s125addlen) {
        this.s125addlen = s125addlen;
    }

    public String getS125additionaldata() {
        return s125additionaldata;
    }

    public void setS125additionaldata(String s125additionaldata) {
        this.s125additionaldata = s125additionaldata;
    }

    public int getS127addlen() {
        return s127addlen;
    }

    public void setS127addlen(int s127addlen) {
        this.s127addlen = s127addlen;
    }

    public String getS127networkdata() {
        return s127networkdata;
    }

    public void setS127networkdata(String s127networkdata) {
        this.s127networkdata = s127networkdata;
    }

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

    public long getReconciliationAmout() {
        return reconciliationAmout;
    }

    public void setReconciliationAmout(long reconciliationAmout) {
        this.reconciliationAmout = reconciliationAmout;
    }
}
