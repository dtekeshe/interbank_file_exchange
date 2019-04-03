
-- NEGATIVE RECORDS LOADER -------------------------------------------------------------------------------------------------

LOAD DATA
APPEND
INTO TABLE CSO_NEGATIVE_CARDS 
   (
      FILE_REF_NUMBER      POSITION ( 01  : 16  ), 
      SYSTEM_SEQ_NUMBER    POSITION ( 17  : 26  ),
      TRANSACTION_CODE     POSITION ( 27  : 28  ), 
      DEST_BIN_NUMBER      POSITION ( 29  : 34  ),
      SOURCE_BIN_NUMBER    POSITION ( 35  : 40  ),
      TRANS_SEQ_NUMBER     POSITION ( 41  : 46  ),
      TRANSACTION_TYPE     POSITION ( 47  : 47  ),
      AUTH_CENTRE          POSITION ( 48  : 51  ),
      NEGATIVE_ACC_NUMBER  POSITION ( 52  : 67  ),
      RESPONSE_CODE        POSITION ( 68  : 69  ),
      PURGE_DATE           POSITION ( 70  : 73  ),
      REGION_CODE          POSITION ( 73  : 74  ),
      CARDHOLDER_NAME      POSITION ( 75  : 146 ),
      ACQUIRER             POSITION ( 147 : 150 )
   )
-- NEGATIVE RECORDS LOADER --------------------------------------------------------------------------------------------------
