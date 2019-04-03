package com.bsva.dao.v02.settlement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.Css_Stats_View;
import com.bsva.entities.CsvSarbTotals;

public class CSVSarbTotalsViewDAO extends AbstractDao<CsvSarbTotals, Void>{
	
	private static char charac = '"';
	private static String comma = " , ";
	private static final String CCR020_SQL_QUERY = "    select ACQUIRER_MEMBER ,"+
                  " trim(' "+charac+" ' || to_char(PROCESS_DATE,'YYYY-MON-DD')"+
                  "        || '"+comma+"' || "+
                  " ACQUIRER_MEMBER || '"+comma+"' || "+
                  " ISSUER_MEMBER || '"+comma+"' || "+
                  " to_number(CARD_TYPE) || ',"+comma+"' || "+
                  " CARD_DESCRIPTION || '"+comma+"' ||"+
                  " RATE_DESC || '"+comma+"' || "+
                  " TRANSACTION_CODE || '"+comma+"' || " +
                  " TRANSACTION_DESCRIPTION || '"+comma+"' || "+
                  " VALUE || ',' || "+
                  " VOLUME || ',' || "+
                  " INTERCHANGE_FEE || ',' ||"+
                  " INTERCHANGE_PERCENT || ',' ||"+
                  " INTERCHANGE_VAT ) as csvstr "+
                  " from CSV_SARB_TOTALS_VIEW ";
	
	public List<CsvSarbTotals> getcsvSarbTotals(){
		
		List<CsvSarbTotals> listData = new ArrayList<CsvSarbTotals>();
        // Prepare params
        //Map<String, Object> params = new HashMap<>();
        //params.put("processDate", processDate);
       // params.put("cardDescription", cardDescription);

        // execute
        List<CsvSarbTotals> fetchedData
                = list(CCR020_SQL_QUERY,CsvSarbTotals.class);
        // prepare result
        List<CsvSarbTotals> sarbTotals = new ArrayList<>();

        for (CsvSarbTotals entity : fetchedData ) {
        	sarbTotals.add(entity);
        }
		
		return sarbTotals;
	}
	
}
