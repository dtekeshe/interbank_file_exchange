USE CCCOWNER;
CREATE OR REPLACE VIEW CCCOWNER.CSV_CCR015_VIEW
(
   PROCESS_MONTH,
   ISSUER_BIN,
   ISSUER_MEMBER_NAME,
   ISSUER_MEMBER,
   CARD_DESCRIPTION,
   CARD_TYPE,
   ACQUIRING_MEMBER_NAME,
   ACQUIRING_MEMBER,
   MERCHANT_CAT_CODE,
   INTERCHANGE_RATE_DESIGNATOR,
   ITEM_CHARGE,
   ITEM_CHARGE_AMOUNT,
   TRANSACTION_DESCRIPTION,
   VOLUME,
   VALUE,
   TOTAL_COST
)
AS
     SELECT PROCESS_MONTH,
            ISSUER_BIN,
            IFNULL(ISSUING_MEMBER_NAME, ' '),
            IFNULL(ISSUING_MEMBER, 0),
            IFNULL(CARD_DESCRIPTION, ' '),
            IFNULL(CAST(CARD_TYPE AS SIGNED INTEGER), 0),
            IFNULL(ACQUIRING_MEMBER_NAME, ' '),
            IFNULL(ACQUIRING_MEMBER, 0),
            IFNULL(MERCHANT_CAT_CODE, ' '),
            IFNULL(INTERCHANGE_RATE_DESIGNATOR, 0),
            IFNULL(ITEM_CHARGE, 0),
            IFNULL(ITEM_CHARGE_AMOUNT, 0),
            IFNULL(TRANSACTION_DESCRIPTION, ' '),
            IFNULL(SUM(TOTAL_COUNT), 0),
            IFNULL(SUM(ABS(TOTAL_AMOUNT)), 0),
            IFNULL(ROUND(SUM(ABS(TOTAL_COST)), 2), 0)
       FROM CSS_STATS_VIEW
      WHERE PROCESS_STATUS = 'C'
   GROUP BY PROCESS_MONTH,
            ISSUER_BIN,
            IFNULL(ISSUING_MEMBER_NAME, ' '),
            IFNULL(ISSUING_MEMBER, 0),
            IFNULL(CARD_DESCRIPTION, ' '),
            IFNULL(CAST(CARD_TYPE AS UNSIGNED INTEGER ), 0),
            IFNULL(ACQUIRING_MEMBER_NAME, ' '),
            IFNULL(ACQUIRING_MEMBER, 0),
            IFNULL(ITEM_CHARGE, 0),
            IFNULL(ITEM_CHARGE_AMOUNT, 0),
            IFNULL(MERCHANT_CAT_CODE, ' '),
            IFNULL(INTERCHANGE_RATE_DESIGNATOR, 0),
            IFNULL(TRANSACTION_DESCRIPTION, ' ')
   ORDER BY PROCESS_MONTH,
            IFNULL(ISSUING_MEMBER, 0),
            IFNULL(CAST(CARD_TYPE AS UNSIGNED INTEGER), 0),
            IFNULL(ACQUIRING_MEMBER, 0),
            ISSUER_BIN,
            IFNULL(MERCHANT_CAT_CODE, ' ');