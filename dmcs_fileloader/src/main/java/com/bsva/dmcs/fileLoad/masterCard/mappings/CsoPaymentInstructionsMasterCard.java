//package com.bsva.dmcs.fileLoad.masterCard.mappings;
//
//
///**
// *
// * @author SimphiweT
// */
//public class CsoPaymentInstructionsMasterCard {
//
//    private boolean currentRecordValid = true;
//    private boolean transactionACashBack;
//
//    private int ACQUIRER_MEMBER;
//    private int ISSUER_MEMBER;
//    private long SEQ_NO;
//    private String SERVICE_CODE;
//    private String SUB_SERVICE_NAME;
//    private String PRIMARY_BITMAP;
//    private String SECONDARY_BITMAP;
//    private int MESSAGE_TYPE_INDICATOR;
//    private String FILE_REF_NUMBER1;
//    private long TRANSACTION_AMOUNT;
//    private int MESSAGE_REASON_CODE;
//    private String RETRIEVAL_REF_NUMBER;
//    private String APPROVAL_CODE;
//    private int RECORD_ID;
//    private int TRANSACTION_CODE;
//    private int CARD_TYPE;
//    private int CARD_ACCEPTOR_BUS_CODE;
//    private int ICC_LENGTH;
//    private String ICC_SYSTEM_RELATED_DATA;
//    private int PAN_LENGTH;
//    private String PAN;
//    private long CASHBACK_PURCHASE;
//    private long CASHBACK_PURCHASE_AMNT;
//    private String LOCAL_DATE;
//    private String LOCAL_TIME;
//    private String POINT_OF_SALE_DATA;
//    private String CARD_ACCEPTOR_TERMINAL_ID;
//    private String CARD_ACCEPTOR_ID;
//    private String FORWARDING_INST_CODE;
//    private String FORWARDING_INST_LENGTH;
//    private String FUNCTION_CODE;
//    private String ACQUIRER_REF_LENGTH;
//    private String ACQUIRER_REF_DATA;
//    private String CODE;
//    private String CARD_ACCEPTOR_LENGTH;
//    private String CARD_ACCEPTOR_NAME;
//    private String ADDITIONAL_DATA_LENGTH;
//    private String ADDITIONAL_DATA;
//    private String CURRENCY_CODE;
//    private String RECONCILLIATION_CODE;
//    private String MESSAGE_NUMBER;
//
//    private int s70_NETWORK_MAN_COUNTRY_CODE;
//    private int s72_DATA_LEN;
//    private String s72_DATA_RECORD;
//    private String s73_ACTION_DATE;
//    private String s74_NO_OF_CREDITS;
//
//    private String s75_REVERSAL_NO_OF_CREDITS;
//    private String s76_NO_OF_DEBITS;
//    private String s77_REVERSAL_NO_OF_DEBITS;
//    private String s78_NUMBER_TRANSFERS;
//    private String s79_REVERSAL_NUMBER_TRANSFERS;
//    private String s80_NUMBER_ENQUIRIES;
//    private String s81_NUMBER_AUTHORISATIONS;
//
//    private String s82_PROCESSING_FEE_CREDITS;
//    private String s83_TRANSACTION_FEE_CREDITS;
//    private String s84_PROCESSING_FEE_DEBITS;
//    private String s85_TRANSCTION_FEE_AMOUNTS;
//    private String s86_AMOUNT_CREDITS;
//    private long s87_REVERSAL_AMOUNT_CREDITS;
//
//    private long s88_AMOUNT_DEBITS;
//    private long s89_REVERSAL_AMOUNT_DEBITS;
//    private long s90_ORIGINATING_DATA_ELEMENTS;
//    private String s91_FILE_UPDATE_CODE;
//    private String s92_FILES_SECURITY_CODE;
//    private int s93_LENGTH;
//    private long s93_TRANSACTION_DEST_INST_ID;
//    private int s94_LENGTH;
//    private long s94_TRANSACTION_ORIG_INST_ID;
//    private int s95_CARD_ISS_REF_DATA_LENGTH;
//    private int s95_CARD_ISSUER_REF_DATA;
//
//    private String s96_MESSAGE_SECURITY_CODE;
//    private long s97_NET_SETTLEMENT_AMOUNT;
//    private String s98_PAYEE;
//    private long s99_SETTLEMENT_INST_ID_CODE;
//    private int s100_RII_LEN;
//    private long s100_RCVING_INST_ID_CODE;
//    private String s101_FILE_NAME;
//    private String s102_ACCOUNT_IDENTIFICATION_1;
//    private String s103_ACCOUNT_IDENTIFICATION_2;
//
//    private String s104_TRANSACTION_DESCRIPTION;
//    private int s111_LEN;
//    private String s111_AMT_CURRENCY_CONVERSION;
//    private int s123_ADD_LEN;
//    private String s123_ADDITIONAL_DATA;
//    private int s124_ADD_LEN;
//    private String s124_ADDITIONAL_DATA;
//    private int s125_ADD_LEN;
//    private String s125_ADDITIONAL_DATA;
//    private int s127_ADD_LEN;
//    private String s127_NETWORK_DATA;
//    private String fILE_ID;
//
//    public boolean isCurrentRecordValid() {
//        return currentRecordValid;
//    }
//
//    public void setCurrentRecordValid(boolean currentRecordValid) {
//        this.currentRecordValid = currentRecordValid;
//    }
//
//    public boolean isTransactionACashBack() {
//        return transactionACashBack;
//    }
//
//    public void setTransactionACashBack(boolean transactionACashBack) {
//        this.transactionACashBack = transactionACashBack;
//    }
//
//    public int getACQUIRER_MEMBER() {
//        return ACQUIRER_MEMBER;
//    }
//
//    public void setACQUIRER_MEMBER(int ACQUIRER_MEMBER) {
//        this.ACQUIRER_MEMBER = ACQUIRER_MEMBER;
//    }
//
//    public int getISSUER_MEMBER() {
//        return ISSUER_MEMBER;
//    }
//
//    public void setISSUER_MEMBER(int ISSUER_MEMBER) {
//        this.ISSUER_MEMBER = ISSUER_MEMBER;
//    }
//
//    public long getSEQ_NO() {
//        return SEQ_NO;
//    }
//
//    public void setSEQ_NO(long SEQ_NO) {
//        this.SEQ_NO = SEQ_NO;
//    }
//
//    public String getSERVICE_CODE() {
//        return SERVICE_CODE;
//    }
//
//    public void setSERVICE_CODE(String SERVICE_CODE) {
//        this.SERVICE_CODE = SERVICE_CODE;
//    }
//
//    public String getSUB_SERVICE_NAME() {
//        return SUB_SERVICE_NAME;
//    }
//
//    public void setSUB_SERVICE_NAME(String SUB_SERVICE_NAME) {
//        this.SUB_SERVICE_NAME = SUB_SERVICE_NAME;
//    }
//
//    public String getPRIMARY_BITMAP() {
//        return PRIMARY_BITMAP;
//    }
//
//    public void setPRIMARY_BITMAP(String PRIMARY_BITMAP) {
//        this.PRIMARY_BITMAP = PRIMARY_BITMAP;
//    }
//
//    public String getSECONDARY_BITMAP() {
//        return SECONDARY_BITMAP;
//    }
//
//    public void setSECONDARY_BITMAP(String SECONDARY_BITMAP) {
//        this.SECONDARY_BITMAP = SECONDARY_BITMAP;
//    }
//
//    public int getMESSAGE_TYPE_INDICATOR() {
//        return MESSAGE_TYPE_INDICATOR;
//    }
//
//    public void setMESSAGE_TYPE_INDICATOR(int MESSAGE_TYPE_INDICATOR) {
//        this.MESSAGE_TYPE_INDICATOR = MESSAGE_TYPE_INDICATOR;
//    }
//
//    public String getFILE_REF_NUMBER1() {
//        return FILE_REF_NUMBER1;
//    }
//
//    public void setFILE_REF_NUMBER1(String FILE_REF_NUMBER1) {
//        this.FILE_REF_NUMBER1 = FILE_REF_NUMBER1;
//    }
//
//    public long getTRANSACTION_AMOUNT() {
//        return TRANSACTION_AMOUNT;
//    }
//
//    public void setTRANSACTION_AMOUNT(long TRANSACTION_AMOUNT) {
//        this.TRANSACTION_AMOUNT = TRANSACTION_AMOUNT;
//    }
//
//    public int getMESSAGE_REASON_CODE() {
//        return MESSAGE_REASON_CODE;
//    }
//
//    public void setMESSAGE_REASON_CODE(int MESSAGE_REASON_CODE) {
//        this.MESSAGE_REASON_CODE = MESSAGE_REASON_CODE;
//    }
//
//    public String getRETRIEVAL_REF_NUMBER() {
//        return RETRIEVAL_REF_NUMBER;
//    }
//
//    public void setRETRIEVAL_REF_NUMBER(String RETRIEVAL_REF_NUMBER) {
//        this.RETRIEVAL_REF_NUMBER = RETRIEVAL_REF_NUMBER;
//    }
//
//    public String getAPPROVAL_CODE() {
//        return APPROVAL_CODE;
//    }
//
//    public void setAPPROVAL_CODE(String APPROVAL_CODE) {
//        this.APPROVAL_CODE = APPROVAL_CODE;
//    }
//
//    public int getRECORD_ID() {
//        return RECORD_ID;
//    }
//
//    public void setRECORD_ID(int RECORD_ID) {
//        this.RECORD_ID = RECORD_ID;
//    }
//
//    public int getTRANSACTION_CODE() {
//        return TRANSACTION_CODE;
//    }
//
//    public void setTRANSACTION_CODE(int TRANSACTION_CODE) {
//        this.TRANSACTION_CODE = TRANSACTION_CODE;
//    }
//
//    public int getCARD_TYPE() {
//        return CARD_TYPE;
//    }
//
//    public void setCARD_TYPE(int CARD_TYPE) {
//        this.CARD_TYPE = CARD_TYPE;
//    }
//
//    public int getCARD_ACCEPTOR_BUS_CODE() {
//        return CARD_ACCEPTOR_BUS_CODE;
//    }
//
//    public void setCARD_ACCEPTOR_BUS_CODE(int CARD_ACCEPTOR_BUS_CODE) {
//        this.CARD_ACCEPTOR_BUS_CODE = CARD_ACCEPTOR_BUS_CODE;
//    }
//
//    public int getICC_LENGTH() {
//        return ICC_LENGTH;
//    }
//
//    public void setICC_LENGTH(int ICC_LENGTH) {
//        this.ICC_LENGTH = ICC_LENGTH;
//    }
//
//    public String getICC_SYSTEM_RELATED_DATA() {
//        return ICC_SYSTEM_RELATED_DATA;
//    }
//
//    public void setICC_SYSTEM_RELATED_DATA(String ICC_SYSTEM_RELATED_DATA) {
//        this.ICC_SYSTEM_RELATED_DATA = ICC_SYSTEM_RELATED_DATA;
//    }
//
//    public int getPAN_LENGTH() {
//        return PAN_LENGTH;
//    }
//
//    public void setPAN_LENGTH(int PAN_LENGTH) {
//        this.PAN_LENGTH = PAN_LENGTH;
//    }
//
//    public String getPAN() {
//        return PAN;
//    }
//
//    public void setPAN(String PAN) {
//        this.PAN = PAN;
//    }
//
//    public long getCASHBACK_PURCHASE() {
//        return CASHBACK_PURCHASE;
//    }
//
//    public void setCASHBACK_PURCHASE(long CASHBACK_PURCHASE) {
//        this.CASHBACK_PURCHASE = CASHBACK_PURCHASE;
//    }
//
//    public long getCASHBACK_PURCHASE_AMNT() {
//        return CASHBACK_PURCHASE_AMNT;
//    }
//
//    public void setCASHBACK_PURCHASE_AMNT(long CASHBACK_PURCHASE_AMNT) {
//        this.CASHBACK_PURCHASE_AMNT = CASHBACK_PURCHASE_AMNT;
//    }
//
//    public String getLOCAL_DATE() {
//        return LOCAL_DATE;
//    }
//
//    public void setLOCAL_DATE(String LOCAL_DATE) {
//        this.LOCAL_DATE = LOCAL_DATE;
//    }
//
//    public String getLOCAL_TIME() {
//        return LOCAL_TIME;
//    }
//
//    public void setLOCAL_TIME(String LOCAL_TIME) {
//        this.LOCAL_TIME = LOCAL_TIME;
//    }
//
//    public String getPOINT_OF_SALE_DATA() {
//        return POINT_OF_SALE_DATA;
//    }
//
//    public void setPOINT_OF_SALE_DATA(String POINT_OF_SALE_DATA) {
//        this.POINT_OF_SALE_DATA = POINT_OF_SALE_DATA;
//    }
//
//    public String getCARD_ACCEPTOR_TERMINAL_ID() {
//        return CARD_ACCEPTOR_TERMINAL_ID;
//    }
//
//    public void setCARD_ACCEPTOR_TERMINAL_ID(String CARD_ACCEPTOR_TERMINAL_ID) {
//        this.CARD_ACCEPTOR_TERMINAL_ID = CARD_ACCEPTOR_TERMINAL_ID;
//    }
//
//    public String getCARD_ACCEPTOR_ID() {
//        return CARD_ACCEPTOR_ID;
//    }
//
//    public void setCARD_ACCEPTOR_ID(String CARD_ACCEPTOR_ID) {
//        this.CARD_ACCEPTOR_ID = CARD_ACCEPTOR_ID;
//    }
//
//    public String getFORWARDING_INST_CODE() {
//        return FORWARDING_INST_CODE;
//    }
//
//    public void setFORWARDING_INST_CODE(String FORWARDING_INST_CODE) {
//        this.FORWARDING_INST_CODE = FORWARDING_INST_CODE;
//    }
//
//    public String getFORWARDING_INST_LENGTH() {
//        return FORWARDING_INST_LENGTH;
//    }
//
//    public void setFORWARDING_INST_LENGTH(String FORWARDING_INST_LENGTH) {
//        this.FORWARDING_INST_LENGTH = FORWARDING_INST_LENGTH;
//    }
//
//    public String getFUNCTION_CODE() {
//        return FUNCTION_CODE;
//    }
//
//    public void setFUNCTION_CODE(String FUNCTION_CODE) {
//        this.FUNCTION_CODE = FUNCTION_CODE;
//    }
//
//    public String getACQUIRER_REF_LENGTH() {
//        return ACQUIRER_REF_LENGTH;
//    }
//
//    public void setACQUIRER_REF_LENGTH(String ACQUIRER_REF_LENGTH) {
//        this.ACQUIRER_REF_LENGTH = ACQUIRER_REF_LENGTH;
//    }
//
//    public String getACQUIRER_REF_DATA() {
//        return ACQUIRER_REF_DATA;
//    }
//
//    public void setACQUIRER_REF_DATA(String ACQUIRER_REF_DATA) {
//        this.ACQUIRER_REF_DATA = ACQUIRER_REF_DATA;
//    }
//
//    public String getCODE() {
//        return CODE;
//    }
//
//    public void setCODE(String CODE) {
//        this.CODE = CODE;
//    }
//
//    public String getCARD_ACCEPTOR_LENGTH() {
//        return CARD_ACCEPTOR_LENGTH;
//    }
//
//    public void setCARD_ACCEPTOR_LENGTH(String CARD_ACCEPTOR_LENGTH) {
//        this.CARD_ACCEPTOR_LENGTH = CARD_ACCEPTOR_LENGTH;
//    }
//
//    public String getCARD_ACCEPTOR_NAME() {
//        return CARD_ACCEPTOR_NAME;
//    }
//
//    public void setCARD_ACCEPTOR_NAME(String CARD_ACCEPTOR_NAME) {
//        this.CARD_ACCEPTOR_NAME = CARD_ACCEPTOR_NAME;
//    }
//
//    public String getADDITIONAL_DATA_LENGTH() {
//        return ADDITIONAL_DATA_LENGTH;
//    }
//
//    public void setADDITIONAL_DATA_LENGTH(String ADDITIONAL_DATA_LENGTH) {
//        this.ADDITIONAL_DATA_LENGTH = ADDITIONAL_DATA_LENGTH;
//    }
//
//    public String getADDITIONAL_DATA() {
//        return ADDITIONAL_DATA;
//    }
//
//    public void setADDITIONAL_DATA(String ADDITIONAL_DATA) {
//        this.ADDITIONAL_DATA = ADDITIONAL_DATA;
//    }
//
//    public String getCURRENCY_CODE() {
//        return CURRENCY_CODE;
//    }
//
//    public void setCURRENCY_CODE(String CURRENCY_CODE) {
//        this.CURRENCY_CODE = CURRENCY_CODE;
//    }
//
//    public String getRECONCILLIATION_CODE() {
//        return RECONCILLIATION_CODE;
//    }
//
//    public void setRECONCILLIATION_CODE(String RECONCILLIATION_CODE) {
//        this.RECONCILLIATION_CODE = RECONCILLIATION_CODE;
//    }
//
//    public String getMESSAGE_NUMBER() {
//        return MESSAGE_NUMBER;
//    }
//
//    public void setMESSAGE_NUMBER(String MESSAGE_NUMBER) {
//        this.MESSAGE_NUMBER = MESSAGE_NUMBER;
//    }
//
//    public int getS72_DATA_LEN() {
//        return s72_DATA_LEN;
//    }
//
//    public void setS72_DATA_LEN(int s72_DATA_LEN) {
//        this.s72_DATA_LEN = s72_DATA_LEN;
//    }
//
//    public String getS72_DATA_RECORD() {
//        return s72_DATA_RECORD;
//    }
//
//    public void setS72_DATA_RECORD(String s72_DATA_RECORD) {
//        this.s72_DATA_RECORD = s72_DATA_RECORD;
//    }
//
//    public String getS73_ACTION_DATE() {
//        return s73_ACTION_DATE;
//    }
//
//    public void setS73_ACTION_DATE(String s73_ACTION_DATE) {
//        this.s73_ACTION_DATE = s73_ACTION_DATE;
//    }
//
//    public String getS74_NO_OF_CREDITS() {
//        return s74_NO_OF_CREDITS;
//    }
//
//    public void setS74_NO_OF_CREDITS(String s74_NO_OF_CREDITS) {
//        this.s74_NO_OF_CREDITS = s74_NO_OF_CREDITS;
//    }
//
//    public String getS75_REVERSAL_NO_OF_CREDITS() {
//        return s75_REVERSAL_NO_OF_CREDITS;
//    }
//
//    public void setS75_REVERSAL_NO_OF_CREDITS(String s75_REVERSAL_NO_OF_CREDITS) {
//        this.s75_REVERSAL_NO_OF_CREDITS = s75_REVERSAL_NO_OF_CREDITS;
//    }
//
//    public String getS76_NO_OF_DEBITS() {
//        return s76_NO_OF_DEBITS;
//    }
//
//    public void setS76_NO_OF_DEBITS(String s76_NO_OF_DEBITS) {
//        this.s76_NO_OF_DEBITS = s76_NO_OF_DEBITS;
//    }
//
//    public String getS77_REVERSAL_NO_OF_DEBITS() {
//        return s77_REVERSAL_NO_OF_DEBITS;
//    }
//
//    public void setS77_REVERSAL_NO_OF_DEBITS(String s77_REVERSAL_NO_OF_DEBITS) {
//        this.s77_REVERSAL_NO_OF_DEBITS = s77_REVERSAL_NO_OF_DEBITS;
//    }
//
//    public String getS78_NUMBER_TRANSFERS() {
//        return s78_NUMBER_TRANSFERS;
//    }
//
//    public void setS78_NUMBER_TRANSFERS(String s78_NUMBER_TRANSFERS) {
//        this.s78_NUMBER_TRANSFERS = s78_NUMBER_TRANSFERS;
//    }
//
//    public String getS79_REVERSAL_NUMBER_TRANSFERS() {
//        return s79_REVERSAL_NUMBER_TRANSFERS;
//    }
//
//    public void setS79_REVERSAL_NUMBER_TRANSFERS(String s79_REVERSAL_NUMBER_TRANSFERS) {
//        this.s79_REVERSAL_NUMBER_TRANSFERS = s79_REVERSAL_NUMBER_TRANSFERS;
//    }
//
//    public String getS80_NUMBER_ENQUIRIES() {
//        return s80_NUMBER_ENQUIRIES;
//    }
//
//    public void setS80_NUMBER_ENQUIRIES(String s80_NUMBER_ENQUIRIES) {
//        this.s80_NUMBER_ENQUIRIES = s80_NUMBER_ENQUIRIES;
//    }
//
//    public String getS81_NUMBER_AUTHORISATIONS() {
//        return s81_NUMBER_AUTHORISATIONS;
//    }
//
//    public void setS81_NUMBER_AUTHORISATIONS(String s81_NUMBER_AUTHORISATIONS) {
//        this.s81_NUMBER_AUTHORISATIONS = s81_NUMBER_AUTHORISATIONS;
//    }
//
//    public String getS82_PROCESSING_FEE_CREDITS() {
//        return s82_PROCESSING_FEE_CREDITS;
//    }
//
//    public void setS82_PROCESSING_FEE_CREDITS(String s82_PROCESSING_FEE_CREDITS) {
//        this.s82_PROCESSING_FEE_CREDITS = s82_PROCESSING_FEE_CREDITS;
//    }
//
//    public String getS83_TRANSACTION_FEE_CREDITS() {
//        return s83_TRANSACTION_FEE_CREDITS;
//    }
//
//    public void setS83_TRANSACTION_FEE_CREDITS(String s83_TRANSACTION_FEE_CREDITS) {
//        this.s83_TRANSACTION_FEE_CREDITS = s83_TRANSACTION_FEE_CREDITS;
//    }
//
//    public String getS84_PROCESSING_FEE_DEBITS() {
//        return s84_PROCESSING_FEE_DEBITS;
//    }
//
//    public void setS84_PROCESSING_FEE_DEBITS(String s84_PROCESSING_FEE_DEBITS) {
//        this.s84_PROCESSING_FEE_DEBITS = s84_PROCESSING_FEE_DEBITS;
//    }
//
//    public String getS85_TRANSCTION_FEE_AMOUNTS() {
//        return s85_TRANSCTION_FEE_AMOUNTS;
//    }
//
//    public void setS85_TRANSCTION_FEE_AMOUNTS(String s85_TRANSCTION_FEE_AMOUNTS) {
//        this.s85_TRANSCTION_FEE_AMOUNTS = s85_TRANSCTION_FEE_AMOUNTS;
//    }
//
//    public String getS86_AMOUNT_CREDITS() {
//        return s86_AMOUNT_CREDITS;
//    }
//
//    public void setS86_AMOUNT_CREDITS(String s86_AMOUNT_CREDITS) {
//        this.s86_AMOUNT_CREDITS = s86_AMOUNT_CREDITS;
//    }
//
//    public long getS87_REVERSAL_AMOUNT_CREDITS() {
//        return s87_REVERSAL_AMOUNT_CREDITS;
//    }
//
//    public void setS87_REVERSAL_AMOUNT_CREDITS(long s87_REVERSAL_AMOUNT_CREDITS) {
//        this.s87_REVERSAL_AMOUNT_CREDITS = s87_REVERSAL_AMOUNT_CREDITS;
//    }
//
//    public long getS88_AMOUNT_DEBITS() {
//        return s88_AMOUNT_DEBITS;
//    }
//
//    public void setS88_AMOUNT_DEBITS(long s88_AMOUNT_DEBITS) {
//        this.s88_AMOUNT_DEBITS = s88_AMOUNT_DEBITS;
//    }
//
//    public long getS89_REVERSAL_AMOUNT_DEBITS() {
//        return s89_REVERSAL_AMOUNT_DEBITS;
//    }
//
//    public void setS89_REVERSAL_AMOUNT_DEBITS(long s89_REVERSAL_AMOUNT_DEBITS) {
//        this.s89_REVERSAL_AMOUNT_DEBITS = s89_REVERSAL_AMOUNT_DEBITS;
//    }
//
//    public long getS90_ORIGINATING_DATA_ELEMENTS() {
//        return s90_ORIGINATING_DATA_ELEMENTS;
//    }
//
//    public void setS90_ORIGINATING_DATA_ELEMENTS(long s90_ORIGINATING_DATA_ELEMENTS) {
//        this.s90_ORIGINATING_DATA_ELEMENTS = s90_ORIGINATING_DATA_ELEMENTS;
//    }
//
//    public String getS91_FILE_UPDATE_CODE() {
//        return s91_FILE_UPDATE_CODE;
//    }
//
//    public void setS91_FILE_UPDATE_CODE(String s91_FILE_UPDATE_CODE) {
//        this.s91_FILE_UPDATE_CODE = s91_FILE_UPDATE_CODE;
//    }
//
//    public String getS92_FILES_SECURITY_CODE() {
//        return s92_FILES_SECURITY_CODE;
//    }
//
//    public void setS92_FILES_SECURITY_CODE(String s92_FILES_SECURITY_CODE) {
//        this.s92_FILES_SECURITY_CODE = s92_FILES_SECURITY_CODE;
//    }
//
//    public int getS93_LENGTH() {
//        return s93_LENGTH;
//    }
//
//    public void setS93_LENGTH(int s93_LENGTH) {
//        this.s93_LENGTH = s93_LENGTH;
//    }
//
//    public long getS93_TRANSACTION_DEST_INST_ID() {
//        return s93_TRANSACTION_DEST_INST_ID;
//    }
//
//    public void setS93_TRANSACTION_DEST_INST_ID(long s93_TRANSACTION_DEST_INST_ID) {
//        this.s93_TRANSACTION_DEST_INST_ID = s93_TRANSACTION_DEST_INST_ID;
//    }
//
//    public int getS94_LENGTH() {
//        return s94_LENGTH;
//    }
//
//    public void setS94_LENGTH(int s94_LENGTH) {
//        this.s94_LENGTH = s94_LENGTH;
//    }
//
//    public int getS95_CARD_ISSUER_REF_DATA() {
//        return s95_CARD_ISSUER_REF_DATA;
//    }
//
//    public void setS95_CARD_ISSUER_REF_DATA(int s95_CARD_ISSUER_REF_DATA) {
//        this.s95_CARD_ISSUER_REF_DATA = s95_CARD_ISSUER_REF_DATA;
//    }
//
//    public String getS96_MESSAGE_SECURITY_CODE() {
//        return s96_MESSAGE_SECURITY_CODE;
//    }
//
//    public void setS96_MESSAGE_SECURITY_CODE(String s96_MESSAGE_SECURITY_CODE) {
//        this.s96_MESSAGE_SECURITY_CODE = s96_MESSAGE_SECURITY_CODE;
//    }
//
//    public long getS97_NET_SETTLEMENT_AMOUNT() {
//        return s97_NET_SETTLEMENT_AMOUNT;
//    }
//
//    public void setS97_NET_SETTLEMENT_AMOUNT(long s97_NET_SETTLEMENT_AMOUNT) {
//        this.s97_NET_SETTLEMENT_AMOUNT = s97_NET_SETTLEMENT_AMOUNT;
//    }
//
//    public String getS98_PAYEE() {
//        return s98_PAYEE;
//    }
//
//    public void setS98_PAYEE(String s98_PAYEE) {
//        this.s98_PAYEE = s98_PAYEE;
//    }
//
//    public long getS99_SETTLEMENT_INST_ID_CODE() {
//        return s99_SETTLEMENT_INST_ID_CODE;
//    }
//
//    public void setS99_SETTLEMENT_INST_ID_CODE(long s99_SETTLEMENT_INST_ID_CODE) {
//        this.s99_SETTLEMENT_INST_ID_CODE = s99_SETTLEMENT_INST_ID_CODE;
//    }
//
//    public int getS100_RII_LEN() {
//        return s100_RII_LEN;
//    }
//
//    public void setS100_RII_LEN(int s100_RII_LEN) {
//        this.s100_RII_LEN = s100_RII_LEN;
//    }
//
//    public long getS100_RCVING_INST_ID_CODE() {
//        return s100_RCVING_INST_ID_CODE;
//    }
//
//    public void setS100_RCVING_INST_ID_CODE(long s100_RCVING_INST_ID_CODE) {
//        this.s100_RCVING_INST_ID_CODE = s100_RCVING_INST_ID_CODE;
//    }
//
//    public String getS101_FILE_NAME() {
//        return s101_FILE_NAME;
//    }
//
//    public void setS101_FILE_NAME(String s101_FILE_NAME) {
//        this.s101_FILE_NAME = s101_FILE_NAME;
//    }
//
//    public String getS102_ACCOUNT_IDENTIFICATION_1() {
//        return s102_ACCOUNT_IDENTIFICATION_1;
//    }
//
//    public void setS102_ACCOUNT_IDENTIFICATION_1(String s102_ACCOUNT_IDENTIFICATION_1) {
//        this.s102_ACCOUNT_IDENTIFICATION_1 = s102_ACCOUNT_IDENTIFICATION_1;
//    }
//
//    public String getS103_ACCOUNT_IDENTIFICATION_2() {
//        return s103_ACCOUNT_IDENTIFICATION_2;
//    }
//
//    public void setS103_ACCOUNT_IDENTIFICATION_2(String s103_ACCOUNT_IDENTIFICATION_2) {
//        this.s103_ACCOUNT_IDENTIFICATION_2 = s103_ACCOUNT_IDENTIFICATION_2;
//    }
//
//    public String getS104_TRANSACTION_DESCRIPTION() {
//        return s104_TRANSACTION_DESCRIPTION;
//    }
//
//    public void setS104_TRANSACTION_DESCRIPTION(String s104_TRANSACTION_DESCRIPTION) {
//        this.s104_TRANSACTION_DESCRIPTION = s104_TRANSACTION_DESCRIPTION;
//    }
//
//    public int getS111_LEN() {
//        return s111_LEN;
//    }
//
//    public void setS111_LEN(int s111_LEN) {
//        this.s111_LEN = s111_LEN;
//    }
//
//    public String getS111_AMT_CURRENCY_CONVERSION() {
//        return s111_AMT_CURRENCY_CONVERSION;
//    }
//
//    public void setS111_AMT_CURRENCY_CONVERSION(String s111_AMT_CURRENCY_CONVERSION) {
//        this.s111_AMT_CURRENCY_CONVERSION = s111_AMT_CURRENCY_CONVERSION;
//    }
//
//    public int getS123_ADD_LEN() {
//        return s123_ADD_LEN;
//    }
//
//    public void setS123_ADD_LEN(int s123_ADD_LEN) {
//        this.s123_ADD_LEN = s123_ADD_LEN;
//    }
//
//    public String getS123_ADDITIONAL_DATA() {
//        return s123_ADDITIONAL_DATA;
//    }
//
//    public void setS123_ADDITIONAL_DATA(String s123_ADDITIONAL_DATA) {
//        this.s123_ADDITIONAL_DATA = s123_ADDITIONAL_DATA;
//    }
//
//    public int getS124_ADD_LEN() {
//        return s124_ADD_LEN;
//    }
//
//    public void setS124_ADD_LEN(int s124_ADD_LEN) {
//        this.s124_ADD_LEN = s124_ADD_LEN;
//    }
//
//    public String getS124_ADDITIONAL_DATA() {
//        return s124_ADDITIONAL_DATA;
//    }
//
//    public void setS124_ADDITIONAL_DATA(String s124_ADDITIONAL_DATA) {
//        this.s124_ADDITIONAL_DATA = s124_ADDITIONAL_DATA;
//    }
//
//    public int getS125_ADD_LEN() {
//        return s125_ADD_LEN;
//    }
//
//    public void setS125_ADD_LEN(int s125_ADD_LEN) {
//        this.s125_ADD_LEN = s125_ADD_LEN;
//    }
//
//    public String getS125_ADDITIONAL_DATA() {
//        return s125_ADDITIONAL_DATA;
//    }
//
//    public void setS125_ADDITIONAL_DATA(String s125_ADDITIONAL_DATA) {
//        this.s125_ADDITIONAL_DATA = s125_ADDITIONAL_DATA;
//    }
//
//    public int getS127_ADD_LEN() {
//        return s127_ADD_LEN;
//    }
//
//    public void setS127_ADD_LEN(int s127_ADD_LEN) {
//        this.s127_ADD_LEN = s127_ADD_LEN;
//    }
//
//    public String getS127_NETWORK_DATA() {
//        return s127_NETWORK_DATA;
//    }
//
//    public void setS127_NETWORK_DATA(String s127_NETWORK_DATA) {
//        this.s127_NETWORK_DATA = s127_NETWORK_DATA;
//    }
//
//    public String getfILE_ID() {
//        return fILE_ID;
//    }
//
//    public void setfILE_ID(String fILE_ID) {
//        this.fILE_ID = fILE_ID;
//    }
//
//    public long getS94_TRANSACTION_ORIG_INST_ID() {
//        return s94_TRANSACTION_ORIG_INST_ID;
//    }
//
//    public void setS94_TRANSACTION_ORIG_INST_ID(long s94_TRANSACTION_ORIG_INST_ID) {
//        this.s94_TRANSACTION_ORIG_INST_ID = s94_TRANSACTION_ORIG_INST_ID;
//    }
//
//    public int getS95_CARD_ISS_REF_DATA_LENGTH() {
//        return s95_CARD_ISS_REF_DATA_LENGTH;
//    }
//
//    public void setS95_CARD_ISS_REF_DATA_LENGTH(int s95_CARD_ISS_REF_DATA_LENGTH) {
//        this.s95_CARD_ISS_REF_DATA_LENGTH = s95_CARD_ISS_REF_DATA_LENGTH;
//    }
//
//    public int getS70_NETWORK_MAN_COUNTRY_CODE() {
//        return s70_NETWORK_MAN_COUNTRY_CODE;
//    }
//
//    public void setS70_NETWORK_MAN_COUNTRY_CODE(int s70_NETWORK_MAN_COUNTRY_CODE) {
//        this.s70_NETWORK_MAN_COUNTRY_CODE = s70_NETWORK_MAN_COUNTRY_CODE;
//    }
//
//    @Override
//    public String toString() {
//        return " SEQ_NO=" + SEQ_NO + " , " + " SERVICE_CODE=" + SERVICE_CODE + " , " + " SUB_SERVICE_NAME= " + SUB_SERVICE_NAME + " , " + " PRIMARY_BITMAP= " + PRIMARY_BITMAP + " , " + " MESSAGE_TYPE_INDICATOR= " + MESSAGE_TYPE_INDICATOR + " , " + " ACQUIRER_MEMBER= " + ACQUIRER_MEMBER + " , " + " ISSUER_MEMBER= " + ISSUER_MEMBER + " , " + "TRANSACTION_AMOUNT=" + TRANSACTION_AMOUNT;
//    }
//
//}
