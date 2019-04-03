package com.bsva.dao.v02.settlement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.Ccr03031VisaEntity;

public class CCR030VisaReportDAO extends AbstractDao<Ccr03031VisaEntity, Void> {

	private static final String CCR031_SQL_QUERY_BY_CRITERIA_ACQUIRER = " SELECT SYSTEM_SEQ_NO , ACQUIRER ,"
			+ " ISSUER ,CARD_TYPE,REPORT_STRING  FROM CSV_CCR03_VIEW_VISA WHERE ACQUIRER = :code "
			+ " ORDER BY ACQUIRER , CARD_TYPE , ISSUER  ";

	private static final String CCR031_SQL_QUERY_BY_CRITERIA_ISSUER = " SELECT SYSTEM_SEQ_NO , ACQUIRER ,"
			+ " ISSUER ,CARD_TYPE,REPORT_STRING  FROM CSV_CCR03_VIEW_VISA WHERE ISSUER = :code "
			+ " ORDER BY ACQUIRER , CARD_TYPE , ISSUER  ";

	public List<Ccr03031VisaEntity> getCCR03031Data(String code, String issuer) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", code);
		List<Ccr03031VisaEntity> listData = new ArrayList<Ccr03031VisaEntity>();
		// execute
		List<Ccr03031VisaEntity> fetchedData2 = null;
		
		if ("ACQUIRER".equals(issuer)) {
			fetchedData2 = list(CCR031_SQL_QUERY_BY_CRITERIA_ACQUIRER, params, Ccr03031VisaEntity.class);
		}
		else {
			fetchedData2 = list(CCR031_SQL_QUERY_BY_CRITERIA_ISSUER, params, Ccr03031VisaEntity.class);
		}

		// prepare result
		if (fetchedData2.size() > 0) {
			for (Ccr03031VisaEntity entity : fetchedData2) {
				Ccr03031VisaEntity ccr03031VisaEntity = new Ccr03031VisaEntity();
				ccr03031VisaEntity.setAcquirer(entity.getAcquirer());
				ccr03031VisaEntity.setSystemSeqNumber(entity.getSystemSeqNumber());
				ccr03031VisaEntity.setCardType(entity.getCardType());
				ccr03031VisaEntity.setIssuer(entity.getIssuer());
				ccr03031VisaEntity.setReportString(entity.getReportString());

				listData.add(entity);
			}
		}
		return listData;

	}

}
