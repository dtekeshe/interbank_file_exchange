LOAD DATA
APPEND
INTO TABLE CSO_INPUT_FILE_CONTROLS
WHEN (01:02) = '01' AND (01:02) <> "99"
   (
      FILE_REF_NUMBER     POSITION (03:32), 
      OUTPUT_DATE         POSITION (11:19) DATE 'YYYYMMDD',
      SERVICE             POSITION ( 33  : 36  ),
      SUB_SERVICE         POSITION (37:46),
      NUMBER_OF_RECS      POSITION (61:71),
      NUMBER_DEBITS       POSITION (72:82),
      NUMBER_CREDITS      POSITION (83:93),
      CREDIT_VALUE        POSITION (94:104),
      DEBIT_VALUE         POSITION (105:115),
      PROCESS_STATUS      POSITION (160 : 160), 
      ORIGINATING_MEMBER  POSITION (47:50), 
      SYSTEM_SEQ_NUMBER   POSITION  (51 : 60),
      ODS_DATA_STATUS     CONSTANT '1',
      IS_BILLED           CONSTANT 'N',
      IS_PRE_EXTRACTED    CONSTANT 'Y'
   )
INTO TABLE CSO_TRANSACTIONS
WHEN (01:02) <> '01' AND (01:02) <> "99"  
  (
    FILE_SYSTEM_SEQ_NUMBER POSITION (1   : 10),
    SYSTEM_SEQ_NUMBER      POSITION (11  : 21),
    RECORD_NUMBER          POSITION (36  : 45),
    ACQUIRER_MEMBER        POSITION (46  : 51),
    ISSUER_MEMBER          POSITION (52  : 57),
    CARD_TYPE              POSITION (58  : 59),
    OUTPUT_FILENAME        POSITION (70  : 77),

    BILLING_FEE            POSITION (78  : 88 ),
    BILLING_FEE_AMOUNT     POSITION (89  : 99 ),
    BILLING_VAT            POSITION (100 : 110),
    CB_BILL_FEE            POSITION (111 : 121),
    CB_BILL_FEE_AMNT       POSITION (122 : 132),
    CB_BILL_VAT            POSITION (133 : 143),
    RATE_DESC		   POSITION (150 : 160),

    CASHBACK_AMOUNT        POSITION (161 : 171),
    CASHBACK_PRESENT       POSITION (172 : 172),
    PROCESS_STATUS         POSITION (173 : 173),
    TRANSACTION_CODE       POSITION (174 : 175),

    TRANSACTION_AMOUNT     POSITION (328 : 338), 
    ACCOUNT_NUMBER         POSITION (345 : 364),
    ISSUER_BIN             POSITION (365 : 370),
    ACQUIRER_BIN           POSITION (371 : 376),
    EXTRACTIND             CONSTANT 'N',
    RECORD_START_BYTE      CONSTANT '0',
    RECORD_END_BYTE        CONSTANT '0',
    FILE_RECORD_CNT        CONSTANT '0',
    FLEET_COUNT_TRAN       CONSTANT '0',
    OPFILE_NUM_SEQ         CONSTANT '0'
 )
 INTO TABLE CSO_PAYMENT_INSTRUCTIONS_MCARD
 WHEN (01:02) <> '01' AND (01:02) <> "99"
    (
      FILE_REF_NUMBER         POSITION (1   : 10),
      FILE_REF_NUMBER1        POSITION (1   : 10),
      SYSTEM_SEQ_NUMBER       POSITION (11  : 21),
      SYSTEM_SEQ_NUMBER2      POSITION (11  : 21),
      SERVICE_CODE            POSITION (22  : 25),
      SUB_SERVICE_NAME        POSITION (26  : 35),
      SEQ_NO                  POSITION (36  : 45),
      ACQUIRER_MEMBER         POSITION (46  : 51),
      ISSUER_MEMBER           POSITION (52  : 57),
      CARD_TYPE               POSITION (58  : 59),
      FILENAME_DESCRIPTION    POSITION (70  : 77),

      POS_ENTRY_MODE          POSITION (145 : 145),
      TERMINAL_CAPABILITY     POSITION (146 : 146),
      CHIP_CARD               POSITION (147 : 147),
      ECOMM_IND               POSITION (148 : 148),
      CARD_PRESENT            POSITION (149 : 149),
      RATE_DESC               POSITION (150 : 160),
      CASHBACK_PURCHASE_AMNT  POSITION (161 : 171),
      CASHBACK_PURCHASE       POSITION (172 : 172),
      PROCESS_STATUS          POSITION (173 : 173),
      TRANSACTION_CODE        POSITION (174 : 175),
      
      MESSAGE_TYPE_INDICATOR  POSITION (196 : 199),
      PRIMARY_BITMAP          POSITION (200 : 263),
      SECONDARY_BITMAP        POSITION (264 : 327),
      MASTERCARD_AMOUNT       POSITION (328 : 338),
      P3_PROCESS_CODE         POSITION (339 : 344),
      P2_PAN                  POSITION (345 : 364),
      FINANCIAL_INDICATOR     CONSTANT 'Y',
      CARD_TRANSACTION        POSITION (1 : 2228),
      INTERCHANGE_FEE         POSITION (84 : 89),
      INTERCHANGE_VAT         POSITION (104 : 111),
      CASHBACK_IC_FEE         POSITION (129 : 133),
      CASHBACK_IC_VAT         POSITION (138 : 144),
      P4_TRANSACTION_AMOUNT   POSITION (328 : 338),
      P31_ACQUIRER_REF_DATA   POSITION (381 : 403),
      P12_LOCAL_DATE          POSITION (530 : 535),
      P7_TRANSCTION_DATE_AND_TIME   POSITION (174 : 183),
      P38_APPROVAL_CODE       POSITION (439 : 444),
      P43_CARD_ACCEPTOR_NAME  POSITION (778 : 825),
      P26_CARD_ACCEPTOR_BUS_CODE  POSITION (557 : 560),
      P25_MESSAGE_REASON_CODE POSITION (355 : 358),
      P30_ORIGINAL_AMOUNT     POSITION (458 : 470),
      P24_FUNCTION_CODE       POSITION (1815 : 1817),
      RECORD_ID               POSITION (1818 : 1818)
)


