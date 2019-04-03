package com.bsva.dao.v02.settlement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.Ccr03031McardEntity;

public class CCR031McardReportDAO extends AbstractDao<Ccr03031McardEntity, Void> {

	// This is the first query for the CCR030 Reports
	private static final String CCR030_SQL_QUERY_BY_CRITERIA_ISSUER = " SELECT  SYSTEM_SEQ_NUMBER, ACQUIRER, ISSUER, CARD_TYPE, REPORT_STRING  "
			+ "	FROM CSV_CCR03_VIEW_MCARD WHERE ISSUER =:code  ORDER BY ISSUER ,CARD_TYPE, ACQUIRER  ";

	private static final String CCR030_SQL_QUERY_BY_CRITERIA_ACQUIRER = " SELECT  SYSTEM_SEQ_NUMBER, ACQUIRER, ISSUER, CARD_TYPE, REPORT_STRING  "
			+ "	FROM CSV_CCR03_VIEW_MCARD WHERE ACQUIRER =:code  ORDER BY ISSUER ,CARD_TYPE, ACQUIRER  ";

	public List<Ccr03031McardEntity> getCCR03031Data(String code, String acquiring) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();

			params.put("code", code);

			List<Ccr03031McardEntity> listData = new ArrayList<Ccr03031McardEntity>();
			// execute
			List<Ccr03031McardEntity> fetchedData2 = null;
			if ("ACQUIRER".equals(acquiring)) {
				fetchedData2 = list(CCR030_SQL_QUERY_BY_CRITERIA_ACQUIRER, params, Ccr03031McardEntity.class);
			}
			else {
				fetchedData2 = list(CCR030_SQL_QUERY_BY_CRITERIA_ISSUER, params, Ccr03031McardEntity.class);
			}
			// prepare result
			if (fetchedData2.size() > 0) {

				for (Ccr03031McardEntity entity : fetchedData2) {

					Ccr03031McardEntity ccr03031McardEntity = new Ccr03031McardEntity();
					if (entity.getAcquirer() != null) {
						ccr03031McardEntity.setAcquirer(entity.getAcquirer());
					}

					if (entity.getCardType() != null) {
						ccr03031McardEntity.setCardType(entity.getCardType());
					}

					if (entity.getIssuer() != null) {
						ccr03031McardEntity.setIssuer(entity.getIssuer());
					}

					if (entity.getReportString() != null) {
						ccr03031McardEntity.setReportString(entity.getReportString());
					}
					if (entity.getSeqNumber() != null) {
						ccr03031McardEntity.setSeqNumber(entity.getSeqNumber());
					}

					listData.add(ccr03031McardEntity);
				}

				return listData;

			}
			else {
				return null;
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
