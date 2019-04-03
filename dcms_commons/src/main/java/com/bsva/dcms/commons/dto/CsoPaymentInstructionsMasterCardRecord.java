package com.bsva.dcms.commons.dto;

import java.math.BigDecimal;

/**
 *
 * @author SimphiweT
 */
public class CsoPaymentInstructionsMasterCardRecord {

    private boolean currentRecordValid = true;
    private boolean transactionACashBack;
    
    private int acquirermember;
    private int issuermember;
    private long seqno;
    private String servicecode;
    private String subservicename;
    private String primarybitmap;
    private String secondarybitmap;
    private int messagetypeindicator;
    private String filerefnumber1;
    private long transactionamount;
    private int messagereasoncode;
    private String retrievalrefnumber;
    private String approvalcode;
    private int recordid;
    private short transactioncode;
    private int cardtype;
    private int cardacceptorbuscode;
    private int icclength;
    private String iccsystemrelateddata;
    private int panlength;
    private String pan;
    private long cashbackpurchase;
    private long cashbackpurchaseamnt;
    private String localdate;
    private String localtime;
    private String pointofsaledata;
    private String cardacceptorterminalid;
    private String cardacceptorid;
    private String forwardinginstcode;
    private String forwardinginstlength;
    private String functioncode;
    private String acquirerreflength;    
    private String acquirerrefdata;
    private String code;
    private String cardacceptorlength;  
    private String cardacceptorname;
    private String additionaldatalength;
    private String additionaldata;
    private String currencycode;  
    private String reconcilliationcode;
    private String messagenumber;
    
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
    private long s94transactionoriginstid;             
    private int s95cardissrefdatalength;
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
    private long reconciliationAmount;

    public int getAcquirermember() {
        return acquirermember;
    }

    public void setAcquirermember(int acquirermember) {
        this.acquirermember = acquirermember;
    }

    public int getIssuermember() {
        return issuermember;
    }

    public void setIssuermember(int issuermember) {
        this.issuermember = issuermember;
    }

    public long getSeqno() {
        return seqno;
    }

    public void setSeqno(long seqno) {
        this.seqno = seqno;
    }

    public String getServicecode() {
        return servicecode;
    }

    public void setServicecode(String servicecode) {
        this.servicecode = servicecode;
    }

    public String getSubservicename() {
        return subservicename;
    }

    public void setSubservicename(String subservicename) {
        this.subservicename = subservicename;
    }

    public String getPrimarybitmap() {
        return primarybitmap;
    }

    public void setPrimarybitmap(String primarybitmap) {
        this.primarybitmap = primarybitmap;
    }

    public String getSecondarybitmap() {
        return secondarybitmap;
    }

    public void setSecondarybitmap(String secondarybitmap) {
        this.secondarybitmap = secondarybitmap;
    }

    public int getMessagetypeindicator() {
        return messagetypeindicator;
    }

    public void setMessagetypeindicator(int messagetypeindicator) {
        this.messagetypeindicator = messagetypeindicator;
    }

    public String getFilerefnumber1() {
        return filerefnumber1;
    }

    public void setFilerefnumber1(String filerefnumber1) {
        this.filerefnumber1 = filerefnumber1;
    }

    public long getTransactionamount() {
        return transactionamount;
    }

    public void setTransactionamount(long transactionamount) {
        this.transactionamount = transactionamount;
    }

    public int getMessagereasoncode() {
        return messagereasoncode;
    }

    public void setMessagereasoncode(int messagereasoncode) {
        this.messagereasoncode = messagereasoncode;
    }

    public String getRetrievalrefnumber() {
        return retrievalrefnumber;
    }

    public void setRetrievalrefnumber(String retrievalrefnumber) {
        this.retrievalrefnumber = retrievalrefnumber;
    }

    public String getApprovalcode() {
        return approvalcode;
    }

    public void setApprovalcode(String approvalcode) {
        this.approvalcode = approvalcode;
    }

    public int getRecordid() {
        return recordid;
    }

    public void setRecordid(int recordid) {
        this.recordid = recordid;
    }

    public short getTransactioncode() {
        return transactioncode;
    }

    public void setTransactioncode(short transactioncode) {
        this.transactioncode = transactioncode;
    }

    public int getCardtype() {
        return cardtype;
    }

    public void setCardtype(int cardtype) {
        this.cardtype = cardtype;
    }

    public int getCardacceptorbuscode() {
        return cardacceptorbuscode;
    }

    public void setCardacceptorbuscode(int cardacceptorbuscode) {
        this.cardacceptorbuscode = cardacceptorbuscode;
    }

    public int getIcclength() {
        return icclength;
    }

    public void setIcclength(int icclength) {
        this.icclength = icclength;
    }

    public String getIccsystemrelateddata() {
        return iccsystemrelateddata;
    }

    public void setIccsystemrelateddata(String iccsystemrelateddata) {
        this.iccsystemrelateddata = iccsystemrelateddata;
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

    public long getCashbackpurchase() {
        return cashbackpurchase;
    }

    public void setCashbackpurchase(long cashbackpurchase) {
        this.cashbackpurchase = cashbackpurchase;
    }

    public long getCashbackpurchaseamnt() {
        return cashbackpurchaseamnt;
    }

    public void setCashbackpurchaseamnt(long cashbackpurchaseamnt) {
        this.cashbackpurchaseamnt = cashbackpurchaseamnt;
    }

    public String getLocaldate() {
        return localdate;
    }

    public void setLocaldate(String localdate) {
        this.localdate = localdate;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public String getPointofsaledata() {
        return pointofsaledata;
    }

    public void setPointofsaledata(String pointofsaledata) {
        this.pointofsaledata = pointofsaledata;
    }

    public String getCardacceptorterminalid() {
        return cardacceptorterminalid;
    }

    public void setCardacceptorterminalid(String cardacceptorterminalid) {
        this.cardacceptorterminalid = cardacceptorterminalid;
    }

    public String getCardacceptorid() {
        return cardacceptorid;
    }

    public void setCardacceptorid(String cardacceptorid) {
        this.cardacceptorid = cardacceptorid;
    }

    public String getForwardinginstcode() {
        return forwardinginstcode;
    }

    public void setForwardinginstcode(String forwardinginstcode) {
        this.forwardinginstcode = forwardinginstcode;
    }

    public String getForwardinginstlength() {
        return forwardinginstlength;
    }

    public void setForwardinginstlength(String forwardinginstlength) {
        this.forwardinginstlength = forwardinginstlength;
    }

    public String getFunctioncode() {
        return functioncode;
    }

    public void setFunctioncode(String functioncode) {
        this.functioncode = functioncode;
    }

    public String getAcquirerreflength() {
        return acquirerreflength;
    }

    public void setAcquirerreflength(String acquirerreflength) {
        this.acquirerreflength = acquirerreflength;
    }

    public String getAcquirerrefdata() {
        return acquirerrefdata;
    }

    public void setAcquirerrefdata(String acquirerrefdata) {
        this.acquirerrefdata = acquirerrefdata;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCardacceptorlength() {
        return cardacceptorlength;
    }

    public void setCardacceptorlength(String cardacceptorlength) {
        this.cardacceptorlength = cardacceptorlength;
    }

    public String getCardacceptorname() {
        return cardacceptorname;
    }

    public void setCardacceptorname(String cardacceptorname) {
        this.cardacceptorname = cardacceptorname;
    }

    public String getAdditionaldatalength() {
        return additionaldatalength;
    }

    public void setAdditionaldatalength(String additionaldatalength) {
        this.additionaldatalength = additionaldatalength;
    }

    public String getAdditionaldata() {
        return additionaldata;
    }

    public void setAdditionaldata(String additionaldata) {
        this.additionaldata = additionaldata;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public String getReconcilliationcode() {
        return reconcilliationcode;
    }

    public void setReconcilliationcode(String reconcilliationcode) {
        this.reconcilliationcode = reconcilliationcode;
    }

    public String getMessagenumber() {
        return messagenumber;
    }

    public void setMessagenumber(String messagenumber) {
        this.messagenumber = messagenumber;
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

    public long getS94transactionoriginstid() {
        return s94transactionoriginstid;
    }

    public void setS94transactionoriginstid(long s94transactionoriginstid) {
        this.s94transactionoriginstid = s94transactionoriginstid;
    }

    public int getS95cardissrefdatalength() {
        return s95cardissrefdatalength;
    }

    public void setS95cardissrefdatalength(int s95cardissrefdatalength) {
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

    public boolean isCurrentRecordValid() {
        return currentRecordValid;
    }

    public void setCurrentRecordValid(boolean currentRecordValid) {
        this.currentRecordValid = currentRecordValid;
    }

    public boolean isTransactionACashBack() {
        return transactionACashBack;
    }

    public void setTransactionACashBack(boolean transactionACashBack) {
        this.transactionACashBack = transactionACashBack;
    }

    public long getReconciliationAmount() {
        return reconciliationAmount;
    }

    public void setReconciliationAmount(long reconciliationAmount) {
        this.reconciliationAmount = reconciliationAmount;
    }

    

}
