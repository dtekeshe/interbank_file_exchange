package com.bsva.entities.v02.endofday;

import com.bsva.dao.AbstractDao;

public class EndOfDayBillingSummary_DAO extends AbstractDao<Void, Void> {
	
	  private final static String MONTH_TOTAL_SQL_INSERT = 
	        "  INSERT INTO CSO_BILLING_SUMMARY                                                  "+
            "       (PROCESS_DATE																"+
            "       ,SERVICE																	"+
            "       ,SUB_SERVICE																"+
            "       ,ISSUING_MEMBER																"+
            "       ,CARD_TYPE																	"+
            "       ,VOLUME																		"+
            "       ,VALUE																		"+
            "       ,VOLUME_BELOW																"+
            "       ,VALUE_BELOW																"+
            "       ,VOLUME_ABOVE																"+
            "       ,VALUE_ABOVE)																"+
            "  SELECT																			"+
            "       C.PROCESS_DATE																"+
            "       ,A.SERVICE_CODE AS SERVICE													"+
            "       ,A.SUB_SERVICE_NAME AS SUB_SERVICE											"+
            "       ,A.ISSUER_MEMBER															"+
            "       ,LPAD(TRIM(A.CARD_TYPE),2,'0')												"+
            "       ,COUNT(*) AS VOLUME															"+
            "       ,NVL(SUM(MASTERCARD_AMOUNT),0) AS VALUE										"+
            "       ,NVL(SUM(CASE																"+
            "                  WHEN MASTERCARD_AMOUNT <= D.TIERED_CUT_OFF						"+
            "                     THEN 1														"+
            "                  ELSE 0															"+
            "                END),0) AS VOL_BELOW												"+
            "       ,NVL(SUM(CASE																"+
            "                  WHEN MASTERCARD_AMOUNT <= D.TIERED_CUT_OFF						"+
            "                     THEN MASTERCARD_AMOUNT										"+
            "                  ELSE 0															"+
            "                END),0) AS VAL_BELOW												"+
            "       ,NVL(SUM(CASE																"+
            "                  WHEN MASTERCARD_AMOUNT <= D.TIERED_CUT_OFF						"+
            "                     THEN 0														"+
            "                  ELSE 1															"+
            "                END),0) AS VOL_ABOVE												"+
            "       ,NVL(SUM(CASE																"+
            "                  WHEN MASTERCARD_AMOUNT <= D.TIERED_CUT_OFF						"+
            "                     THEN 0														"+
            "                  ELSE MASTERCARD_AMOUNT											"+
            "                END),0) AS VAL_ABOVE												"+
            "   FROM																			"+
            "       CSO_PAYMENT_INSTRUCTIONS_MCARD A											"+
            "      ,CSO_INPUT_FILE_CONTROLS B													"+
            "      ,CSO_SYSTEM_PARAMETERS C														"+
            "      ,CSF_COMPANY_PARAMETERS D													"+
            "   WHERE																			"+
            "       A.PROCESS_STATUS = 'C'														"+
            "       AND FINANCIAL_INDICATOR = 'Y'												"+
            "       AND A.FILE_REF_NUMBER1 = B.SYSTEM_SEQ_NUMBER								"+
            "       AND B.PROCESS_STATUS = 'C'													"+
            "       AND C.PROCESS_ACTIVE_IND = 'Y'												"+
            "   GROUP BY																		"+	
            "        C.PROCESS_DATE																"+
            "       ,A.SERVICE_CODE																"+
            "       ,A.SUB_SERVICE_NAME															"+
            "       ,A.ISSUER_MEMBER															"+
            "       ,A.CARD_TYPE																"+
            "   UNION																			"+
            "   SELECT																			"+
            "        C.PROCESS_DATE																"+
            "       ,A.SERVICE																	"+
            "       ,A.SUB_SERVICE																"+
            "       ,A.ISSUER_MEMBER															"+
            "       ,A.CARD_TYPE																"+
            "       ,NVL(COUNT(*),0)															"+
            "       ,NVL(SUM(VISA_AMOUNT),0)													"+
            "       ,NVL(SUM(CASE																"+
            "                  WHEN VISA_AMOUNT <= D.TIERED_CUT_OFF								"+
            "                       THEN 1														"+
            "                  ELSE 0															"+
            "                END),0) AS VOL_BELOW												"+
            "       ,NVL(SUM(CASE																"+
            "                  WHEN VISA_AMOUNT <= D.TIERED_CUT_OFF								"+
            "                       THEN VISA_AMOUNT											"+
            "                  ELSE 0															"+
            "                END),0) AS VAL_BELOW												"+
            "       ,NVL(SUM(CASE																"+
            "                  WHEN VISA_AMOUNT <= D.TIERED_CUT_OFF								"+
            "                       THEN 0														"+
            "                  ELSE 1															"+
            "                END),0) AS VOL_ABOVE												"+
            "       ,NVL(SUM(CASE																"+
            "                  WHEN VISA_AMOUNT <= D.TIERED_CUT_OFF								"+	
            "                       THEN 0														"+
            "                  ELSE VISA_AMOUNT													"+
            "                END),0) AS VAL_ABOVE												"+
            "   FROM																			"+
            "       CSO_PAYMENT_INSTRUCTIONS_VISA A												"+
            "      ,CSO_INPUT_FILE_CONTROLS B													"+
            "      ,CSO_SYSTEM_PARAMETERS C														"+
            "      ,CSF_COMPANY_PARAMETERS D													"+
            "   WHERE																			"+
            "       A.PROCESS_STATUS  = 'C'														"+
            "       AND FINANCIAL_INDICATOR = 'Y'												"+
            "       AND A.FILE_REF_NUMBER = B.SYSTEM_SEQ_NUMBER									"+
            "       AND B.PROCESS_STATUS = 'C'													"+
            "       AND C.PROCESS_ACTIVE_IND = 'Y'												"+
            "   GROUP BY																		"+
            "        C.PROCESS_DATE																"+
            "       ,A.SERVICE																	"+
            "       ,A.SUB_SERVICE																"+
            "       ,A.ISSUER_MEMBER															"+
            "       ,A.CARD_TYPE ";						
	  
	  private final static String CHECK_DATA_EXIST = "select * from CSO_BILLING_SUMMARY";
	  
	  public int countRows(){
		  
		  Integer counter = (Integer) executeCountQuery(CHECK_DATA_EXIST);
		  if(counter.intValue() > 0){
			  System.out.println("There is Data in the table ");
		  }else{
			  getMonthEndTable();
		  }
		  return 1;
	  }
		  
	  

	  public void getMonthEndTable() {
		  try{
	        // executeUpdate with no return results
	       int rowCount =  executeSelectQuery(MONTH_TOTAL_SQL_INSERT);
	       System.out.println("Number of Rows affected : "+rowCount);
		  }catch(Exception ex){
			  ex.printStackTrace();
		  }

	    }


}
