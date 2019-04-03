package com.bsva.dao.v02.members;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.Css_Stats_View;
import com.bsva.entities.Css_Stats_View_PK;

public class Css_Stats_View_DAO extends AbstractDao<Css_Stats_View, Css_Stats_View_PK>{

	
	private static final String CSS_CCR0014_VIEW_REPORTS_SQL = //"SELECT * FROM CSS_STATS_VIEW";
     " SELECT ISSUER_BIN ,"
     + "ACQUIRING_MEMBER_NAME ,"
     + "ACQUIRING_MEMBER ,"
     + "NVL(CARD_DESCRIPTION,' ')AS CARD_DESCRIPTION,"
     + "NVL(TO_NUMBER(CARD_TYPE),0)AS CARD_TYPE "+
     " ,NVL(ISSUING_MEMBER_NAME,' ')AS ISSUING_MEMBER_NAME ,"
     + "NVL(ISSUING_MEMBER,0)AS ISSUING_MEMBER ,"
     + "NVL(MERCHANT_CAT_CODE,' ')AS MERCHANT_CAT_CODE,"
     + "NVL(INTERCHANGE_RATE_DESIGNATOR,0)AS INTERCHANGE_RATE_DESIGNATOR, "+
     " NVL(ITEM_CHARGE,0)AS ITEM_CHARGE ,"
     + "NVL(ITEM_CHARGE_AMOUNT,0)AS ITEM_CHARGE_AMOUNT,"
     + "NVL(TRANSACTION_DESCRIPTION,' ')AS TRANSACTION_DESCRIPTION,"
     + "NVL(SUM(TOTAL_COUNT),0)AS TOTAL_COUNT, "+
     " NVL(SUM(ABS(TOTAL_AMOUNT)),0)AS TOTAL_AMOUNT,"
     + "NVL(ROUND(SUM(ABS(TOTAL_COST)),2),0)AS TOTAL_COST "+
     " FROM CSS_STATS_VIEW WHERE PROCESS_STATUS = 'C' AND CARD_DESCRIPTION =:cardDescription "+
     //"AND PROCESS_MONTH = '201403' "+
     " GROUP BY  ISSUER_BIN ,"
     + "ACQUIRING_MEMBER_NAME ,"
     + "ACQUIRING_MEMBER "+
     " ,CARD_DESCRIPTION ,"
     + "NVL(TO_NUMBER(CARD_TYPE),0) ,"
     + "NVL(ISSUING_MEMBER_NAME,' '),"
     + "NVL(ISSUING_MEMBER,0) ,"
     + "MERCHANT_CAT_CODE,"
     + "NVL(INTERCHANGE_RATE_DESIGNATOR,0) "+
     " ,ITEM_CHARGE ,ITEM_CHARGE_AMOUNT ,"
     + "NVL(TRANSACTION_DESCRIPTION,' ')"
     + " ORDER BY ACQUIRING_MEMBER ,"
     + "NVL(TO_NUMBER(CARD_TYPE),0) "+
     " , ACQUIRING_MEMBER_NAME ,"
     + "NVL(ISSUING_MEMBER,0),"
     + "ISSUER_BIN ,"
     + "MERCHANT_CAT_CODE ";
	
	private static final String CSS_CCR0015_VIEW_REPORTS_SQL = 
	" SELECT ISSUER_BIN"+
                     " ,NVL(ISSUING_MEMBER_NAME,' ') AS ISSUING_MEMBER_NAME "+
                     " ,NVL(ISSUING_MEMBER,0) AS ISSUING_MEMBER "+
                     " ,NVL(CARD_DESCRIPTION,' ') AS CARD_DESCRIPTION "+
                     " ,NVL(TO_NUMBER(CARD_TYPE),0) AS CARD_TYPE"+
                     " ,NVL(ACQUIRING_MEMBER_NAME,' ') AS ACQUIRING_MEMBER_NAME"+
                     " ,NVL(ACQUIRING_MEMBER,0) AS ACQUIRING_MEMBER "+
                     " ,NVL(MERCHANT_CAT_CODE,' ') AS MERCHANT_CAT_CODE"+
                 " ,NVL(INTERCHANGE_RATE_DESIGNATOR,0) AS INTERCHANGE_RATE_DESIGNATOR "+
                     " ,NVL(ITEM_CHARGE,0) AS ITEM_CHARGE"+
                     " ,NVL(ITEM_CHARGE_AMOUNT,0) AS ITEM_CHARGE_AMOUNT "+
                  " ,NVL(TRANSACTION_DESCRIPTION,' ') AS TRANSACTION_DESCRIPTION"+
                     " ,NVL(SUM(TOTAL_COUNT),0) AS TOTAL_COUNT"+
                     " ,NVL(SUM(ABS(TOTAL_AMOUNT)),0) AS TOTAL_AMOUNT"+
                     " ,NVL(ROUND(SUM(ABS(TOTAL_COST)),2),0) AS TOTAL_COST "+
          " FROM CSS_STATS_VIEW   WHERE PROCESS_STATUS = 'C' AND CARD_DESCRIPTION =:cardDescription "+
          // AND PROCESS_MONTH = '201403'
               " GROUP BY ISSUER_BIN "+
                       " ,NVL(ISSUING_MEMBER_NAME,' ')"+
                       " ,NVL(ISSUING_MEMBER,0)"+
                       " ,NVL(CARD_DESCRIPTION,' ')"+
                       " ,NVL(TO_NUMBER(CARD_TYPE),0)"+
                       " ,NVL(ACQUIRING_MEMBER_NAME,' ')"+
                       " ,NVL(ACQUIRING_MEMBER,0)"+
                       " ,NVL(ITEM_CHARGE,0)"+
                       " ,NVL(ITEM_CHARGE_AMOUNT,0)"+
                       " ,NVL(MERCHANT_CAT_CODE,' ')"+
                  " ,NVL(INTERCHANGE_RATE_DESIGNATOR,0)"+
                    " ,NVL(TRANSACTION_DESCRIPTION,' ')"+
           " ORDER BY NVL(ISSUING_MEMBER,0)"+
                   " ,NVL(TO_NUMBER(CARD_TYPE),0)"+
                   " ,NVL(ACQUIRING_MEMBER,0)"+
                   " ,ISSUER_BIN"+
                   " ,NVL(CARD_DESCRIPTION,' ')"+
                   " ,NVL(MERCHANT_CAT_CODE,' ')";




		    
	    public List<Css_Stats_View> getCSS0014Reports(String cardDescription) {
	        // prepare params
	        Map<String, Object> params = new HashMap<>();
	        //params.put("processDate", processDate);
	        params.put("cardDescription", cardDescription);


	        // execute
	        List<Css_Stats_View> entities
	                = list(CSS_CCR0014_VIEW_REPORTS_SQL,params , Css_Stats_View.class);

	        // prepare result
	        List<Css_Stats_View> addresses = new ArrayList<>();

	        for (Css_Stats_View entity : entities ) {
	            addresses.add(entity);
	        }

	        return addresses;
	    }
	    
	    public List<Css_Stats_View> getCSS0015Reports(String cardDescription) {
	        // prepare params
	        Map<String, Object> params = new HashMap<>();
	        //params.put("processDate", processDate);
	        params.put("cardDescription", cardDescription);

	        // execute
	        List<Css_Stats_View> entities
	                = list(CSS_CCR0015_VIEW_REPORTS_SQL,params, Css_Stats_View.class);

	        // prepare result
	        List<Css_Stats_View> addresses = new ArrayList<>();

	        for (Css_Stats_View entity : entities ) {
	            addresses.add(entity);
	        }

	        return addresses;
	    }
}
