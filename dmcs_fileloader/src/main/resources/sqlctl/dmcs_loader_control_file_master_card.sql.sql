
-- Write Headers -------------------------------------------------------------------------------------------------------

-- Check duplicate CSO_INPUT_FILE_CONTROLS using file_reference_number, if PROCESS_STATUS = F, delete and proceed

--  Write CSO_INPUT_FILE_CONTROLS record

-- Header record type 01, AXSHeader, filter : POSITION (0, 2) = '01'

LOAD DATA
APPEND
INTO TABLE CSO_INPUT_FILE_CONTROLS
WHEN (01:02) = '01'
   (
      FILE_REF_NUMBER POSITION (03:32), -- VARCHAR2(60 BYTE) NOT NULL
      OUTPUT_DATE     POSITION (11:19) DATE 'YYYYMMDD', -- CONSTANT '17-NOV-16', -- POSITION (03:10) DATE 'YYYYMMDD', -- CONSTANT '17-NOV-16', --POSITION (03:10) DATE,
      SERVICE         POSITION (33:36),
      SUB_SERVICE     POSITION (37:40),
      NUMBER_OF_RECS  POSITION (61:71),
      NUMBER_DEBITS   POSITION (72:82),
      NUMBER_CREDITS  POSITION (83:93),
      CREDIT_VALUE    POSITION (94:104),
      DEBIT_VALUE     POSITION (105:115),
      -- HASH_TOTAL      -- NUMBER(12, 0)
      -- LAST_FILE_INDICATOR  -- VARCHAR2(1 BYTE)
      PROCESS_STATUS  POSITION (116 : 116),     -- VARCHAR2(1 BYTE)
      -- EXTRACTED_COUNT      -- NUMBER(6, 0)
      -- EXT_CREDITS          NUMBER(6, 0)
      -- EXT_DEBITS NUMBER(6, 0)
      -- EXT_CREDIT_VALUE NUMBER(16, 2)
      -- EXT_DEBIT_VALUE NUMBER(16, 2)
      -- LAST_PROCESS_DATE DATE
      -- NEXT_OUTPUT_DATE DATE
      -- SETTLEMENT_COUNT NUMBER(6, 0)
      -- LOAD_DATE DATE
      ORIGINATING_MEMBER POSITION (47:50), -- NUMBER(4, 0)
      -- validation_code POSITION (28, 32),
      -- NEGATIVE_CARD_COUNT NUMBER(6, 0)
      -- NEGATIVE_DUPLICATE_COUNT NUMBER(6, 0)
      -- LAST_COMMITED_RECORD_POINTER NUMBER(8, 0)
      -- EXCEP_REP_PRODUCED_IND VARCHAR2(1 BYTE)
      -- ERROR_FILENAME VARCHAR2(6 BYTE)
      SYSTEM_SEQ_NUMBER POSITION  (51 : 60), --NUMBER(10, 0) NOT NULL
      ODS_DATA_STATUS   CONSTANT '1',
      IS_BILLED         CONSTANT 'N',
      IS_PRE_EXTRACTED  CONSTANT 'Y'
   )
INTO TABLE CSO_TRANSACTIONS
WHEN (01:02) <> '-1' AND (01:02) <> '01' AND (01:02) <> '92' AND (01:02) <> '98' AND (01:02) <> '99' AND (03:04) = '00'
  (

    -- SEQUENCE

    FILE_SYSTEM_SEQ_NUMBER POSITION (169 : 178),
    SYSTEM_SEQ_NUMBER      POSITION (179 : 189),

    -- FILE INPUT

    TRANSACTION_CODE       POSITION ( 01 :  02),
    ISSUER_BIN             POSITION (5   : 10),
    ACCOUNT_NUMBER         POSITION (5   : 20),
    ACQUIRER_BIN           POSITION (28  : 33),
    TRANSACTION_AMOUNT     POSITION (77  : 88), 
    RECORD_NUMBER          POSITION (222 : 231),

    -- CONSTANTS

    EXTRACTIND             CONSTANT 'N',
    RECORD_START_BYTE      CONSTANT '0',
    RECORD_END_BYTE        CONSTANT '0',
    FILE_RECORD_CNT        CONSTANT '0',
    FLEET_COUNT_TRAN       CONSTANT '0',
    OPFILE_NUM_SEQ         CONSTANT '0'

    -- PRIMED DATA

    ACQUIRER_MEMBER        POSITION (214 : 219),
    ISSUER_MEMBER          POSITION (220 : 225),
    CARD_TYPE              POSITION (220 : 221),

    OUTPUT_FILENAME        POSITION (232 : 239),
    BILLING_FEE            POSITION (240 : 250),
    BILLING_FEE_AMOUNT     POSITION (251 : 261),
    BILLING_VAT            POSITION (262 : 273),
    CB_BILL_FEE            POSITION (274 : 284),
    CB_BILL_FEE_AMNT       POSITION (285 : 295),
    CB_BILL_VAT            POSITION (296 : 306),
    CASHBACK_PRESENT       POSITION (296 : 306),
    CASHBACK_AMOUNT        POSITION (296 : 306),

    PROCESS_STATUS         POSITION (240 : 240),

 )

 INTO TABLE CSO_PAYMENT_INSTRUCTIONS_MCARD
 WHEN (01:02) <> '-1' AND (01:02) <> '01' AND (01:02) <> '92' AND (01:02) <> '98' AND (01:02) <> '99' AND (03:04) = '00'
    (
      FILE_REF_NUMBER1                POSITION ( 1 :   2),
      SYSTEM_SEQ_NUMBER2              POSITION ( 3 : 8),
      SERVICE_CODE                    POSITION ( 9 : 12),
      SUB_SERVICE_NAME                POSITION ( 13 : 22),
      PRIMARY_BITMAP                  POSITION ( 24 : 67),
      SECONDARY_BITMAP                POSITION ( 68 : 131),
      MESSAGE_TYPE_INDICATOR          POSITION ( 151 : 153),
      ACQUIRER_MEMBER                 POSITION ( 369 : 374),
      ISSUER_MEMBER                   POSITION ( 156 : 161),
      MASTERCARD_AMOUNT               POSITION ( 01 :  02),
      FINANCIAL_INDICATOR             POSITION ( 03 :  04), -- not found
      P2_PAN_LENGTH                   POSITION ( 5 : 20),
      P2_PAN                          POSITION ( 5 : 20),

      P3_PROCESS_CODE                 POSITION ( 5 : 20), --
      P4_TRANSACTION_AMOUNT           POSITION ( 189 : 184),     --
      P5_RECONCLLIATION_AMOUNT        POSITION ( 5 : 20), -- 
      P6_CARDHOLDER_BILLING           POSITION ( 5 : 20), --
      P7_TRANSCTION_DATE_AND_TIME     POSITION ( 5 : 20), --
      P8_ICCR_AMOUNT                  POSITION ( 5 : 20),
      P9_RECON_CONVERSION_RATE        POSITION ( 5 : 20),
      P10_CARDHOLDER_CONV_RATE        POSITION ( 5 : 20),
      P11_SYSTEM_TRACE_AUDIT_NUMBER   POSITION ( 5 : 20),

      P12_LOCAL_DATE                  POSITION ( 5 : 20),
      P13_LOCAL_TIME                  POSITION ( 5 : 20),

      P14_EXPIRATION_DATE             POSITION ( 5 : 20),
      P15_SETTLEMENT_DATE             POSITION ( 5 : 20),
      P16_CONVERSION_DATE             POSITION ( 5 : 20),
      P17_CAPTURE_DATE                POSITION ( 5 : 20),
      P18_MERCHANT_TYPE               POSITION ( 5 : 20),
      P19_ACQ_BANK_INSTITUTION_CODE   POSITION ( 5 : 20),
      P20_COUNTRY_CODE_PRI_ACC_NO     POSITION ( 5 : 20),
      P21_FWDING_INST_COUNTRY_CODE    POSITION ( 5 : 20),

      P22_POINT_OF_SALE_DATA          POSITION ( 5 : 20),
      P23_CARD_SEQUENCE_NUMBER        POSITION ( 5 : 20),

      P24_FUNCTION_CODE               POSITION ( 5 : 20),
      P25_MESSAGE_REASON_CODE         POSITION ( 318 : 321),
      P26_CARD_ACCEPTOR_BUS_CODE      POSITION ( 322 : 325),

      P27_AUTH_ID_RESPONSE_LENGTH     POSITION ( 5 : 20),

      P28_TRANSACTION_FEE_AMOUNT      POSITION ( 5 : 20),
      P29_SETTLEMENT_FEE_AMOUNT       POSITION ( 5 : 20),
      P30_ORIGINAL_AMOUNT             POSITION ( 5 : 20),

      P31_ACQUIRER_REF_LENGTH         POSITION ( 5 : 20),
      P31_ACQUIRER_REF_DATA           POSITION ( 5 : 20),

      P32_ACQUIRING_INST_LENGTH       POSITION ( 5 : 20),
      P32_ACQUIRING_INST_CODE         POSITION ( 5 : 20),
      P33_FORWARDING_INST_LENGTH      POSITION ( 5 : 20),
      P33_FORWARDING_INST_CODE        POSITION ( 5 : 20),
      P34_EXTENDED_ACCOUNT_NUMBER     POSITION ( 5 : 20),

      P35_TRACK_2_DATA                POSITION ( 5 : 20), --
      P36_TRACK_3_DATA                POSITION ( 5 : 20), --

      P37_RETRIEVAL_REF_NUMBER        POSITION ( 5 : 20),
      P38_APPROVAL_CODE               POSITION ( 5 : 20),

      P39_RESPONSE_CODE               POSITION ( 5 : 20), --

      P40_SERVICE_CODE                POSITION ( 5 : 20),
      P41_CARD_ACCEPTOR_TERMINAL_ID   POSITION ( 5 : 20),
      P42_CARD_ACCEPTOR_ID            POSITION ( 5 : 20),          
      P43_CARD_ACCEPTOR_LENGTH        POSITION ( 5 : 20),
      P43_CARD_ACCEPTOR_NAME          POSITION ( 5 : 20),

      P44_ADDITIONAL_RESPONSE_DATA    POSITION ( 5 : 20), --
      P45_TRACK_1_DATA                POSITION ( 5 : 20),             --
      P46_ADDITIONAL_DATA_ISO         POSITION ( 5 : 20),      --

      P47_ADDITIONAL_DATA_NATIONAL    POSITION ( 5 : 20),
      P48_ADDITIONAL_DATA_LENGTH      POSITION ( 5 : 20),
      P48_ADDITIONAL_DATA             POSITION ( 5 : 20),
      P49_CURRENCY_CODE               POSITION ( 5 : 20),
      P50_RECONCILLIATION_CODE        POSITION ( 5 : 20),

      P51_CARDHOLDER_BILL_CUR_CODE    POSITION ( 5 : 20),
      P52_PERSONAL_ID_NUMBER          POSITION ( 5 : 20),
      P53_SECURITY_REL_CONTROL_INFO   POSITION ( 5 : 20),
      P54_ADDITIONAL_AMNT_LENGTH      POSITION ( 5 : 20),
      P54_ADDITIONAL_AMOUNTS          POSITION ( 5 : 20),

      P55_ICC_LENGTH                  POSITION ( 5 : 20),
      P55_ICC_SYSTEM_RELATED_DATA     POSITION ( 5 : 20),

      P62_ADD_LEN                     POSITION ( 5 : 20),
      P62_ADDITIONAL_DATA             POSITION ( 5 : 20),
      P63_TX_LIFE_CYCLE_ID_LENGTH     POSITION ( 5 : 20),
      P63_TRANSACTION_LIFE_CYCLE_ID   POSITION ( 5 : 20),
      P64_PRIMARY_MAC                 POSITION ( 5 : 20),
      S66_SETTLEMNT_CODE              POSITION ( 5 : 20),
      S67_EXTENDED_PAYMENT_CODE       POSITION ( 5 : 20),
      S68_REC_INST_COUNTRY_CODE       POSITION ( 5 : 20),
      S69_SETTLE_INST_COUNTRY_CODE    POSITION ( 5 : 20),

      S70_NETWORK_MAN_COUNTRY_CODE    POSITION ( 5 : 20),
      S71_MESSAGE_NUMBER              POSITION ( 5 : 20),
      S72_DATA_LEN                    POSITION ( 5 : 20),
      S72_DATA_RECORD                 POSITION ( 5 : 20),
      S73_ACTION_DATE                 POSITION ( 5 : 20),
      S74_NO_OF_CREDITS               POSITION ( 5 : 20),
      S75_REVERSAL_NO_OF_CREDITS      POSITION ( 5 : 20),
      S76_NO_OF_DEBITS                POSITION ( 5 : 20),
      S77_REVERSAL_NO_OF_DEBITS       POSITION ( 5 : 20),
      S78_NUMBER_TRANSFERS            POSITION ( 5 : 20),
      S79_REVERSAL_NUMBER_TRANSFERS   POSITION ( 5 : 20),
      S80_NUMBER_ENQUIRIES            POSITION ( 5 : 20),
      S81_NUMBER_AUTHORISATIONS       POSITION ( 5 : 20),
      S82_PROCESSING_FEE_CREDITS      POSITION ( 5 : 20),
      S83_TRANSACTION_FEE_CREDITS     POSITION ( 5 : 20),
      S84_PROCESSING_FEE_DEBITS       POSITION ( 5 : 20),
      S85_TRANSCTION_FEE_AMOUNTS      POSITION ( 5 : 20),
      S86_AMOUNT_CREDITS              POSITION ( 5 : 20),
      S87_REVERSAL_AMOUNT_CREDITS     POSITION ( 5 : 20),
      S88_AMOUNT_DEBITS               POSITION ( 5 : 20),
      S89_REVERSAL_AMOUNT_DEBITS      POSITION ( 5 : 20),
      S90_ORIGINATING_DATA_ELEMENTS   POSITION ( 5 : 20),
      S91_FILE_UPDATE_CODE            POSITION ( 5 : 20),
      S92_FILES_SECURITY_CODE         POSITION ( 5 : 20),
      S93_LENGTH                      POSITION ( 5 : 20),

      S93_TRANSACTION_DEST_INST_ID    POSITION ( 5 : 20), --
      S94_LENGTH                      POSITION ( 5 : 20),                   --
      S94_TRANSACTION_ORIG_INST_ID    POSITION ( 5 : 20), --
      S95_CARD_ISS_REF_DATA_LENGTH    POSITION ( 5 : 20), --
      S95_CARD_ISSUER_REF_DATA        POSITION ( 5 : 20),     --


      S96_MESSAGE_SECURITY_CODE       POSITION ( 5 : 20),
      S97_NET_SETTLEMENT_AMOUNT       POSITION ( 5 : 20),
      S98_PAYEE                       POSITION ( 5 : 20),
      S99_SETTLEMENT_INST_ID_CODE     POSITION ( 5 : 20),
      S100_RII_LEN                    POSITION ( 5 : 20),
      S100_RCVING_INST_ID_CODE        POSITION ( 5 : 20),
      S101_FILE_NAME                  POSITION ( 5 : 20),
      S102_ACCOUNT_IDENTIFICATION_1   POSITION ( 5 : 20),
      S103_ACCOUNT_IDENTIFICATION_2   POSITION ( 5 : 20),
      S104_TRANSACTION_DESCRIPTION    POSITION ( 5 : 20),
      S111_LENGTH                     POSITION ( 5 : 20),
      S111_AMT_CURRENCY_CONVERSION    POSITION ( 5 : 20),
      S123_ADD_LEN                    POSITION ( 5 : 20),
      S123_ADDITIONAL_DATA            POSITION ( 5 : 20),
      S124_ADD_LEN                    POSITION ( 5 : 20),
      S124_ADDITIONAL_DATA            POSITION ( 5 : 20),
      S125_ADD_LEN                    POSITION ( 5 : 20),
      S125_ADDITIONAL_DATA            POSITION ( 5 : 20),
      S127_NETWORK_DATA               POSITION ( 5 : 20),
      INPUT_FILE_IDENTIFIER           POSITION ( 5 : 20),

      -- END OF INPUT DATA -----------------------------------------------------------

      SEQ_NO                          POSITION ( 5 : 20),
      PROCESS_STATUS                  POSITION ( 5 : 20),
      RECORD_ID                       POSITION ( 5 : 20),
      TRANSACTION_CODE                POSITION ( 5 : 20),
      CARD_TYPE                       POSITION ( 5 : 20),
      FILENAME_DESCRIPTION            POSITION ( 5 : 20),
      P55_ICC_SYS_DATA_RAW            POSITION ( 5 : 20),
      IRD                             POSITION ( 5 : 20),
      CASHBACK_PURCHASE               POSITION ( 5 : 20),
      CASHBACK_PURCHASE_AMNT          POSITION ( 5 : 20)
 )