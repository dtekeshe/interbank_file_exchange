-- CSF_TRANSACTION_TYPES_COLLATED_VIEW
--
--    EXAMPLE:
--      CSF_TRANSACTION_TYPES  CSF_TRANSACTION_TYPES_NORMALISED
--      ---------------------  --------------------------------
--      CODE                   CODE
--      ----                   ----
--      9       |-------------- 5
--      19      |              15
--      29      |              25
--      5 -------
--      15
--      25
USE CCCOWNER;
CREATE OR REPLACE VIEW CCCOWNER.CSF_TRANSACTION_TYPES_COLLATED_VIEW
(
  TRANSACTION_CODE,
  TRANSACTION_DESCRIPTION,
  REPORT_SORT_SEQUENCE
)
 AS
    SELECT A.TRANSACTION_CODE,
           B.TRANSACTION_DESCRIPTION,
           B.REPORT_SORT_SEQUENCE
      FROM CSF_TRANSACTION_TYPES_NORMALISED_VIEW A,
           CSF_TRANSACTION_TYPES B
     WHERE A.TRANSACTION_CODE = B.TRANSACTION_CODE