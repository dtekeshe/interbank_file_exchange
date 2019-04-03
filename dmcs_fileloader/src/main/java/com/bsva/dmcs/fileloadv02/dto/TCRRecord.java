package com.bsva.dmcs.fileloadv02.dto;

/**
 * TCR5 Record Specification ------------------------------------------------------------------------------------------
 *
 String line = "";
 TCR5Record tcr5 = new TCR5Record();
 tcr5.setTxnCode(         substring(line, 0,   2));
 tcr5.setTxnQualifier(    substring(line, 2,   3));
 tcr5.setTxnNumber(       substring(line, 3,   4));
 tcr5.setTxnID(           substring(line, 4,  19));
 tcr5.setAuthAmount(      substring(line, 19, 31));
 tcr5.setAuthCurrency(    substring(line, 31, 34));
 tcr5.setResponseCode(    substring(line, 34, 36));
 tcr5.setValidationCode(  substring(line, 36, 40));
 tcr5.setExclusionReason( substring(line, 40, 41));
 tcr5.setProcessingCode(  substring(line, 41, 42));
 tcr5.setChargeBackInd(   substring(line, 42, 44));
 tcr5.setClearSeqNumber(  substring(line, 44, 46));
 tcr5.setClearSeqCount(   substring(line, 46, 48));
 tcr5.setMarketAuthInd(   substring(line, 48, 49));
 tcr5.setTotalAuthAmount( substring(line, 49, 61));
 tcr5.setInfoIndicator(   substring(line, 61, 62));
 tcr5.setMerTelephone(    substring(line, 62, 76));
 tcr5.setAdditionDataInd( substring(line, 76, 77));
 tcr5.setMerVolumeInd(    substring(line, 77, 79));
 tcr5.setEcommInd(        substring(line, 79, 81));
 tcr5.setMerVerifyValue(  substring(line, 81, 91));
 tcr5.setInterchangeFee(  substring(line, 91, 106));
 tcr5.setInterchangeSign( substring(line, 106, 107));
 tcr5.setExchangeRate(    substring(line, 107, 115));
 tcr5.setRevExchangeRate( substring(line, 115, 123));
 tcr5.setIssuerISAAmount( substring(line, 123, 135));
 tcr5.setReserved(        substring(line, 135, 167));
 tcr5.setCVV2ResultCode(  substring(line, 167, 168));

 * TCR5 Record Specification Ends -------------------------------------------------------------------------------------
 */
public class TCRRecord {
    private String txnCode;
    private String txnNumber;
    private String input;

    public void setTxnCode(String txnCode) {
        this.txnCode = txnCode;
    }

    public String getTxnCode() {
        return txnCode;
    }

    public void setTxnNumber(String txnNumber) {
        this.txnNumber = txnNumber;
    }

    public String getTxnNumber() {
        return txnNumber;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
