package com.bsva.dao.v02.settlement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.bsva.dao.AbstractDao;
import com.bsva.entities.Ccr03031McardEntity;

public class CCR030McardReportDAO extends AbstractDao<Ccr03031McardEntity, Void> {



	private static final String CCR030_SQL_QUERY_BY_CRITERIA = " SELECT SYSTEM_SEQ_NUMBER , ACQUIRER,   ISSUER,   CARD_TYPE,   REPORT_STRING "
			+ "  FROM CSV_CCR03_VIEW_MCARD  WHERE ISSUER = :issuerCode ORDER BY ISSUER ,CARD_TYPE ,ACQUIRER ";

	public List<Ccr03031McardEntity> getCCR030Data(String issuerCode) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("issuerCode", issuerCode);

		List<Ccr03031McardEntity> listData = new ArrayList<Ccr03031McardEntity>();
		// execute
		List<Ccr03031McardEntity> fetchedData = list(CCR030_SQL_QUERY_BY_CRITERIA, params, Ccr03031McardEntity.class);
		// prepare result
		if (fetchedData.size() > 0) {
			for (Ccr03031McardEntity entity : fetchedData) {

				Ccr03031McardEntity ccr03031McardEntity = new Ccr03031McardEntity();
				ccr03031McardEntity.setAcquirer(entity.getAcquirer());
				ccr03031McardEntity.setIssuer(entity.getIssuer());
				ccr03031McardEntity.setCardType(entity.getCardType());
				ccr03031McardEntity.setSeqNumber(entity.getSeqNumber());
				ccr03031McardEntity.setReportString(entity.getReportString());

				listData.add(ccr03031McardEntity);
			}
			return listData;
		}
		else {
			return null;
		}
	}

}
