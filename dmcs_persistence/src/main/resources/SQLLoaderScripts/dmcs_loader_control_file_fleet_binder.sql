-- WRITER CSO_FLEET_BIND_RESOLVED TABLE FROM SQL IDX FILE ----------------------------------------------------------

LOAD DATA
APPEND
INTO TABLE CSO_FLEET_BIND_RESOLVED
(
    SERVICE                   POSITION (  1 : 4  ),
    SUB_SERVICE               POSITION (  5 : 14 ),
    ISS                       POSITION ( 15 : 18 ),
    ACQ                       POSITION ( 19 : 22 ),        
    ACC_NO                    POSITION ( 23 : 41 ),
    TX_CDE                    POSITION ( 42 : 43 ),
    TX_DATE_TIME              POSITION ( 44 : 57 ),
    CARD_TYPE                 POSITION ( 58 : 59 ),
    FILE_SYSTEM_SEQ_NUMBER    POSITION ( 60 : 70 ),
    TRAN_SYSTEM_SEQ_NUMBER    POSITION ( 71 : 81 ),
    PROCESS_DATE              POSITION ( 82 : 97) DATE 'YYYY-MM-DD hh24:mi:ss',
    AMOUNT                    POSITION (101 : 112),   
    TX_CNT                    POSITION (113 : 115),
    ACQUIRER_BIN	      CONSTANT '0' 
)
