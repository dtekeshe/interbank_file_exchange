package com.bsva.entities.v02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;

public class ChargeBacksVISA_DAO extends AbstractDao<ChargeBacksVISA, Void>{
	
    
	
	private final static String CHARGEBACKS_REPORTS = 
			        "  SELECT ACQUIRER_MEMBER                     " +
                    " ,ISSUER_MEMBER                              " +
                    " ,TRANSACTION_CODE                           " +
                    " ,nvl(ACCOUNT_NUMBER,0)AS ACCOUNT_NUMBER     " +
                    " ,nvl(SUBSTR(CARD_TRANSACTION,23,1),0) AS MF_FORMAT      " +   //MF_FORMAT                       
                    " ,nvl(SUBSTR(CARD_TRANSACTION,24,6),0) AS MF_ACQUIRER     "  + //MF_ACQUIRER                  
                    " ,nvl(SUBSTR(CARD_TRANSACTION,30,4),0) AS MF_DATE      " +     //                
                    " ,nvl(SUBSTR(CARD_TRANSACTION,34,11),0) AS MF_BATCHNO     " +                
                    " ,nvl(SUBSTR(CARD_TRANSACTION,45,1),0) AS CHECK_DIGIT      " +            
                    " ,nvl(SUBSTR(CARD_TRANSACTION,54,4),0) AS PURCHASE_DATE      " +          
                    " ,nvl(SUBSTR(CARD_TRANSACTION,78,7),0) AS AMOUNT      " +                    
                    " ,nvl(SUBSTR(CARD_TRANSACTION,148,4),0) AS AUTH_1     " +                  
                    " ,nvl(SUBSTR(CARD_TRANSACTION,152,1),0) AS AUTH_2     " +                    
                    " ,nvl(SUBSTR(CARD_TRANSACTION,88,25),0) AS MERCHANT_NAME     " +             
                    " ,nvl(SUBSTR(CARD_TRANSACTION,113,13),0) AS MERCHANT_CITY    " +           
                    " ,nvl(SUBSTR(CARD_TRANSACTION,126,2),0) AS MERCHANT_COUNTRY     " +        
                    " ,nvl(SUBSTR(CARD_TRANSACTION,129,4),0) AS MERCHANT_TYPE     " +              
                    " ,LPAD(nvl(SUBSTR(CARD_TRANSACTION,144,2),0),4,'0') AS REASON " +   
                    " ,nvl(SUBSTR(CARD_TRANSACTION,61,9),0)  AS REASON_CODE           " +              
                    " ,nvl(SYSTEM_GEN_SEQ_NUMBER,0) AS SYSTEM_GEN_SEQ_NUMBER       " +                   
                    " ,CASE TRANSACTION_CODE                    " +                        
                    " WHEN '14' THEN                            " + 
                    "     CASE SUBSTR(CARD_TRANSACTION,143,1)   " + 
                    "          WHEN '1'                         " + 
                    "               THEN 'CBFC'                 " + 
                    "           WHEN '2'                        " + 
                    "               THEN 'CBSC'                 " + 
                    "           ELSE ' '                        " + 
                    "      END                                  " + 
                    " WHEN '15' THEN                            " + 
                    "      CASE SUBSTR(CARD_TRANSACTION,143,1)  " + 
                    "           WHEN '1'                        " + 
                    "               THEN 'CBFC'                 " + 
                    "           WHEN '2'                        " + 
                    "               THEN 'CBSC'                 " + 
                    "           ELSE ' '                        " + 
                    "      END                                  " + 
                    " WHEN '16' THEN                            " + 
                    "      CASE SUBSTR(CARD_TRANSACTION,143,1)  " + 
                    "          WHEN '1'                         " + 
                    "               THEN 'CVFC'                 " + 
                    "           WHEN '2'                        " + 
                    "                THEN 'CVSC'                " + 
                    "           ELSE ' '                        " + 
                    "      END                                  " + 
                    "  WHEN '17' THEN                           " + 
                    "     CASE SUBSTR(CARD_TRANSACTION,143,1)   " + 
                    "           WHEN '1'                   " + 
                    "               THEN 'CDFC'            " + 
                    "           WHEN '2'                   " + 
                    "                THEN 'CDSC'           " + 
                    "           ELSE ' '                   " + 
                    "      END                             " + 
                    "  ELSE '    '                         " + 
                   "   END AS USAGE_CODE                   " +                             
                  "    FROM CSO_PAYMENT_INSTRUCTIONS_VISA  " + 
                  "    WHERE PROCESS_STATUS = 'C'          " + 
                  "    and (FINANCIAL_INDICATOR = 'Y'      " + 
                  "    AND TRANSACTION_CODE IN             " + 
                  "    (14,15,16,17,4,5,6,25))                      " + //i added tranx code 4,5,25 to be able to extract data for testing purpose
                  "    ORDER BY SYSTEM_GEN_SEQ_NUMBER      ";
	
	private final static String CHARGEBACKS_REPORTS_ISSUER = 
	        "  SELECT ACQUIRER_MEMBER                     " +
            " ,ISSUER_MEMBER                              " +
            " ,TRANSACTION_CODE                           " +
            " ,nvl(ACCOUNT_NUMBER,0)AS ACCOUNT_NUMBER     " +
            " ,nvl(SUBSTR(CARD_TRANSACTION,23,1),0) AS MF_FORMAT      " +   //MF_FORMAT                       
            " ,nvl(SUBSTR(CARD_TRANSACTION,24,6),0) AS MF_ACQUIRER     "  + //MF_ACQUIRER                  
            " ,nvl(SUBSTR(CARD_TRANSACTION,30,4),0) AS MF_DATE      " +     //                
            " ,nvl(SUBSTR(CARD_TRANSACTION,34,11),0) AS MF_BATCHNO     " +                
            " ,nvl(SUBSTR(CARD_TRANSACTION,45,1),0) AS CHECK_DIGIT      " +            
            " ,nvl(SUBSTR(CARD_TRANSACTION,54,4),0) AS PURCHASE_DATE      " +          
            " ,nvl(SUBSTR(CARD_TRANSACTION,78,7),0) AS AMOUNT      " +                    
            " ,nvl(SUBSTR(CARD_TRANSACTION,148,4),0) AS AUTH_1     " +                  
            " ,nvl(SUBSTR(CARD_TRANSACTION,152,1),0) AS AUTH_2     " +                    
            " ,nvl(SUBSTR(CARD_TRANSACTION,88,25),0) AS MERCHANT_NAME     " +             
            " ,nvl(SUBSTR(CARD_TRANSACTION,113,13),0) AS MERCHANT_CITY    " +           
            " ,nvl(SUBSTR(CARD_TRANSACTION,126,2),0) AS MERCHANT_COUNTRY     " +        
            " ,nvl(SUBSTR(CARD_TRANSACTION,129,4),0) AS MERCHANT_TYPE     " +              
            " ,LPAD(nvl(SUBSTR(CARD_TRANSACTION,144,2),0),4,'0') AS REASON " +   
            " ,nvl(SUBSTR(CARD_TRANSACTION,61,9),0)  AS REASON_CODE           " +              
            " ,nvl(SYSTEM_GEN_SEQ_NUMBER,0) AS SYSTEM_GEN_SEQ_NUMBER       " +                   
            " ,CASE TRANSACTION_CODE                    " +                        
            " WHEN '14' THEN                            " + 
            "     CASE SUBSTR(CARD_TRANSACTION,143,1)   " + 
            "          WHEN '1'                         " + 
            "               THEN 'CBFC'                 " + 
            "           WHEN '2'                        " + 
            "               THEN 'CBSC'                 " + 
            "           ELSE ' '                        " + 
            "      END                                  " + 
            " WHEN '15' THEN                            " + 
            "      CASE SUBSTR(CARD_TRANSACTION,143,1)  " + 
            "           WHEN '1'                        " + 
            "               THEN 'CBFC'                 " + 
            "           WHEN '2'                        " + 
            "               THEN 'CBSC'                 " + 
            "           ELSE ' '                        " + 
            "      END                                  " + 
            " WHEN '16' THEN                            " + 
            "      CASE SUBSTR(CARD_TRANSACTION,143,1)  " + 
            "          WHEN '1'                         " + 
            "               THEN 'CVFC'                 " + 
            "           WHEN '2'                        " + 
            "                THEN 'CVSC'                " + 
            "           ELSE ' '                        " + 
            "      END                                  " + 
            "  WHEN '17' THEN                           " + 
            "     CASE SUBSTR(CARD_TRANSACTION,143,1)   " + 
            "           WHEN '1'                   " + 
            "               THEN 'CDFC'            " + 
            "           WHEN '2'                   " + 
            "                THEN 'CDSC'           " + 
            "           ELSE ' '                   " + 
            "      END                             " + 
            "  ELSE '    '                         " + 
           "   END AS USAGE_CODE                   " +                             
          "    FROM CSO_PAYMENT_INSTRUCTIONS_VISA  " + 
          "    WHERE ISSUER_MEMBER = :issuer_Member AND ACQUIRER_MEMBER = :acquirerMember AND PROCESS_STATUS = 'C'          " + 
          "    and (FINANCIAL_INDICATOR = 'Y'      " + 
          "    AND TRANSACTION_CODE IN             " + 
          "    (14,15,16,17))                      " + //i added tranx code 4,5,25 to be able to extract data for testing purpose
          "    ORDER BY SYSTEM_GEN_SEQ_NUMBER      ";

	       
 public List<ChargeBacksVISA> getVisaChargeBack() {

        // execute
        List<ChargeBacksVISA> entities
                = list(CHARGEBACKS_REPORTS , ChargeBacksVISA.class);

        return entities;
}
 
 public List<ChargeBacksVISA> getVisaChargeBacksReport(String issuer_Member,String acquirerMember) {
	 Map<String,Object> params = new HashMap<>();
	 params.put("issuer_Member", issuer_Member);
	 params.put("acquirerMember", acquirerMember);
     // execute
     List<ChargeBacksVISA> entities
             = list(CHARGEBACKS_REPORTS_ISSUER ,params ,ChargeBacksVISA.class);

     return entities;
}
 
 
 
     
 



}
