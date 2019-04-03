package com.bsva.entities.v02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;

public class ChargeBacksDAO  extends AbstractDao<ChargeBacksMcard, Void>{

		private final static String CHARGEBACKS_REPORTS = " SELECT ACQUIRER_MEMBER "+//ACQUIRER
                    " ,ISSUER_MEMBER,"  //ISSUER
                    + " TRANSACTION_CODE, " //TRANSACTION-CODE
                    + " nvl(SUBSTR(P2_PAN,1,16),0) AS ACCOUNT_NUMBER ," //ACCOUNT-NUMBER
                    + " nvl(SUBSTR(P31_ACQUIRER_REF_DATA,1,1),0) AS MF_FORMAT ," +//MF-FORMAT
                    "   nvl(SUBSTR(P31_ACQUIRER_REF_DATA,2,6),0) AS MF_ACQUIRER ," //MF-ACQUIRER
                    + " nvl(SUBSTR(P31_ACQUIRER_REF_DATA,8,4),0) AS MF_DATE ," //MF-DATE
                    + " nvl(SUBSTR(P31_ACQUIRER_REF_DATA,12,11),0) AS MF_BATCHNO ," + //MF-BATCHNO
                    "   nvl(SUBSTR(P31_ACQUIRER_REF_DATA,23,1),0) AS CHECK_DIGIT ," + //CHECK-DIGIT
                      " nvl(SUBSTR(P12_LOCAL_DATE,3,4),0) AS PURCHASE_DATE ," //PURCHASE-DATE
                    + " nvl(P4_TRANSACTION_AMOUNT,0) AS AMOUNT " + //AMOUNT
                    "  ,nvl(SUBSTR(LPAD(P38_APPROVAL_CODE,6,'0'),1,5),'0') AS MCARD_AUTH ," //MCARD-AUTH
                    + " nvl(P43_CARD_ACCEPTOR_NAME,' ') AS CARD_ACCEPTOR_NAME," //CARD-ACCEPTOR-NAME
                    + " nvl(P26_CARD_ACCEPTOR_BUS_CODE,0) AS MERCHANT_TYPE " +  //MERCHANT-TYPE
                    "  ,nvl(TO_CHAR(P25_MESSAGE_REASON_CODE),'00') AS REASON " + //REASON
                    " ,CASE " +
                    "    WHEN TRANSACTION_CODE < 50         " +
                    "     THEN TO_NUMBER(                   " +
                    "        SUBSTR(P30_ORIGINAL_AMOUNT,13,12) )  " +// AMOUNT-2
                    " ELSE                                  " +
                    "    TO_NUMBER(                         " +
                    "    SUBSTR(P30_ORIGINAL_AMOUNT,1,12))  " +
                    " END " +
                    " ,nvl(SYSTEM_SEQ_NUMBER2,0) AS SYSTEM_SEQ_NUMBER2 " + // SYSTEM-SEQ-NUMBER
                    " ,CASE MESSAGE_TYPE_INDICATOR " +
                    "  WHEN 1240 THEN " +
                    "    CASE P24_FUNCTION_CODE   " +
                    "        WHEN 200 THEN '    ' " +
                    "        WHEN 205 THEN 'SDSP' " +
                    "        WHEN 282 THEN 'SDSP' " +
                    "       ELSE '    '           " +
                    "     END                     " +
                    "  WHEN 1442 THEN             " +
                    "     CASE P24_FUNCTION_CODE  " +
                    "        WHEN 450 THEN 'CBFC' " +
                    "        WHEN 451 THEN 'CBSC' " +
                    "        WHEN 453 THEN 'CBFC' " +
                    "        WHEN 454 THEN 'CBSC' " +
                    "        ELSE '    '                " +
                    "     END                           " +
                    "  WHEN 1644 THEN                   " +
                    "     CASE P24_FUNCTION_CODE        " +
                    "        WHEN 603 THEN 'RREQ'       " +
                    "        ELSE '    '                " +
                    "     END                           " +
                    "  ELSE '    '                      " +
                 " END AS USAGE_CODE                    " + // USAGE-CODE
              " FROM CSO_PAYMENT_INSTRUCTIONS_MCARD     " +
          " WHERE ((( RECORD_ID IN (14,15,16,17)        " +
          "    OR ( TRANSACTION_CODE IN (14,15,16,17))) " +
          "     AND FINANCIAL_INDICATOR = 'Y')          " +
          "    OR ( TRANSACTION_CODE IN (51, 52, 53)))  " +
          "     AND PROCESS_STATUS = 'C'                " +
          "     AND ISSUER_MEMBER = :issuerMember AND ACQUIRER_MEMBER = :acquirerMember" +
          "     ORDER BY SYSTEM_SEQ_NUMBER2             " ;
               
	 public List<ChargeBacksMcard> getMasterCard(String issuerMember,String acquirerMember) {
		 
		 Map<String,Object> params = new HashMap<String, Object>();
		 params.put("issuerMember", issuerMember);
		 params.put("acquirerMember", acquirerMember);

	        // execute
	        List<ChargeBacksMcard> entities
	                = list(CHARGEBACKS_REPORTS ,params, ChargeBacksMcard.class);

	        return entities;
	}
	 
}
