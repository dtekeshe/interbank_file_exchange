package com.bsva.dao.v02.settlement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.settlement.CsvSettlementView;
import com.bsva.entities.v02.settlement.CsvSettlementView_PK;

public class CsvSettlementViewDAO extends AbstractDao<CsvSettlementView, CsvSettlementView_PK> {

	private static final String CSS_CCR0015_VIEW_REPORTS_SQL = " SELECT ORIGINATING_BANK, HOMING_BANK, PROCESS_DATE,"
			+ " SERVICE, SUB_SERVICE ,SETTLEMENT_NAME, PAYMENT_STREAM, CURRENCY_CODE, STATUS_CODE, "
			+ " SETTLEMENT_IND, CR_VOLUME, CR_VALUE, DR_VOLUME ,DR_VALUE FROM "
			+ " CSV_SETTLEMENT_VIEW WHERE SERVICE = :service AND SUB_SERVICE = :subService ";

	public List<CsvSettlementView> getCsvSettlementViewReports(String service,String subService) {

		// prepare params
		Map<String, Object> params = new HashMap<>();
		params.put("subService", subService);
		params.put("service", service);
		

		// execute
		List<CsvSettlementView> entities = list(CSS_CCR0015_VIEW_REPORTS_SQL, params, CsvSettlementView.class);

		// prepare result
		List<CsvSettlementView> addresses = new ArrayList<CsvSettlementView>();

		for (CsvSettlementView entity : entities) {
			addresses.add(entity);
		}

		return addresses;
	}

}
