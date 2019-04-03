USE CCCOWNER;
CREATE OR REPLACE VIEW CCCOWNER.CSF_TRANSACTION_TYPES_NORMALISED_VIEW
(
  TRANSACTION_CODE
)
AS
  SELECT DISTINCT
		 CASE
			WHEN TRANSACTION_CODE = 9 THEN 5
			WHEN TRANSACTION_CODE = 19 THEN 15
			WHEN TRANSACTION_CODE = 29 THEN 25
			ELSE TRANSACTION_CODE
		 END
			AS TRANSACTION_CODE
	FROM CCCOWNER.CSF_TRANSACTION_TYPES
   WHERE FINANCIAL_IND = 'Y'