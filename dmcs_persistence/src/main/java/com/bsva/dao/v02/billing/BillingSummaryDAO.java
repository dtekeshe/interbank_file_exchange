package com.bsva.dao.v02.billing;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.CsrMisEntity;
import com.bsva.entities.v02.CsoBillingSummary;
import com.bsva.entities.v02.CsoBillingSummaryPK;

public class BillingSummaryDAO extends AbstractDao<CsrMisEntity, Void> {

	//this is used to delete daya older than 90 Dyas Or The currect Day Data before insert of the current day Data.
	private static String DELETE_BILLING_SUMMARY_SQL = "DELETE  FROM CSO_BILLING_SUMMARY "
			+ " WHERE PROCESS_DATE = TO_DATE( :processDate,'YYYY-MM-DD') " + " OR "
			+ " PROCESS_DATE <= TRUNC(SYSDATE) - 90";

	//Building a query from different table to be save to the Cso_Billing_summary table.
	private static String SELECT_INTO_BILLING_SUMMARY = 
			//These two lines was commented out because you cannot use the same query to select and insert using java and Hibernate
	// " INSERT INTO CSO_BILLING_SUMMARY "+
	// " ( PROCESS_DATE ,SERVICE,SUB_SERVICE,ISSUING_MEMBER,CARD_TYPE,VOLUME,VALUE,VOLUME_BELOW ,VALUE_BELOW,VOLUME_ABOVE,VALUE_ABOVE ) "+

	" SELECT C.PROCESS_DATE AS PROCESS_DATE,"
			+ " A.SERVICE_CODE AS SERVICE ,"
			+ " A.SUB_SERVICE_NAME AS SUB_SERVICE, "
			+ " A.ISSUER_MEMBER AS ISSUER_MEMBER "
			+ " ,LPAD(TRIM(A.CARD_TYPE),2,'0')AS CARD_TYPE ,"
			+ " COUNT(*) AS VOLUME,"
			+ " NVL(SUM(MASTERCARD_AMOUNT),0) AS VALUE ,"
			+ " NVL(SUM(CASE "
			+ " WHEN MASTERCARD_AMOUNT <= D.TIERED_CUT_OFF THEN 1 ELSE 0 END),0) AS VOLUME_BELOW "
			+ " ,NVL(SUM(CASE WHEN MASTERCARD_AMOUNT <= D.TIERED_CUT_OFF THEN MASTERCARD_AMOUNT ELSE 0 END),0) AS VALUE_BELOW "
			+ " ,NVL(SUM(CASE  WHEN MASTERCARD_AMOUNT <= D.TIERED_CUT_OFF THEN 0 ELSE 1 END),0) AS VOLUME_ABOVE "
			+ "  ,NVL(SUM(CASE WHEN MASTERCARD_AMOUNT <= D.TIERED_CUT_OFF THEN 0 ELSE MASTERCARD_AMOUNT END),0) AS VALUE_ABOVE "
			+ " FROM CSO_PAYMENT_INSTRUCTIONS_MCARD A ,CSO_INPUT_FILE_CONTROLS B ,CSO_SYSTEM_PARAMETERS C ,CSF_COMPANY_PARAMETERS D "
			+ "  WHERE  A.PROCESS_STATUS = 'C' AND FINANCIAL_INDICATOR = 'Y' AND A.FILE_REF_NUMBER1 = B.SYSTEM_SEQ_NUMBER "
			+ " AND B.PROCESS_STATUS = 'C' AND C.PROCESS_ACTIVE_IND = 'Y' "
			+ " GROUP BY  C.PROCESS_DATE ,A.SERVICE_CODE ,A.SUB_SERVICE_NAME ,A.ISSUER_MEMBER ,A.CARD_TYPE "
			+ " UNION"
			+ " SELECT C.PROCESS_DATE AS PROCESS_DATE ,"
			+ " A.SERVICE AS SERVICE,"
			+ " A.SUB_SERVICE AS SUB_SERVICE,"
			+ " A.ISSUER_MEMBER AS ISSUER_MEMBER,"
			+ " A.CARD_TYPE AS CARD_TYPE,"
			+ " NVL(COUNT(*),0) AS VOLUME"
			+ " ,NVL(SUM(VISA_AMOUNT),0) AS VALUE,"
			+ " NVL(SUM(CASE WHEN VISA_AMOUNT <= D.TIERED_CUT_OFF THEN 1 ELSE 0 END),0) AS VOLUME_BELOW "
			+ "  ,NVL(SUM(CASE WHEN VISA_AMOUNT <= D.TIERED_CUT_OFF THEN VISA_AMOUNT ELSE 0 END),0) AS VALUE_BELOW "
			+ " ,NVL(SUM(CASE WHEN VISA_AMOUNT <= D.TIERED_CUT_OFF THEN 0  ELSE 1 END),0) AS VOLUME_ABOVE "
			+ " ,NVL(SUM(CASE  WHEN VISA_AMOUNT <= D.TIERED_CUT_OFF THEN 0 ELSE VISA_AMOUNT END),0) AS VALUE_ABOVE      "
			+ "  FROM CSO_PAYMENT_INSTRUCTIONS_VISA A  ,CSO_INPUT_FILE_CONTROLS B ,CSO_SYSTEM_PARAMETERS C ,CSF_COMPANY_PARAMETERS D "
			+ "  WHERE A.PROCESS_STATUS  = 'C' AND FINANCIAL_INDICATOR = 'Y' AND A.FILE_REF_NUMBER = B.SYSTEM_SEQ_NUMBER "
			+ "  AND B.PROCESS_STATUS = 'C' AND C.PROCESS_ACTIVE_IND = 'Y' "
			+ " GROUP BY C.PROCESS_DATE ,A.SERVICE ,A.SUB_SERVICE ,A.ISSUER_MEMBER ,A.CARD_TYPE ";

	public void getData() {
		//fetches the whole data to be save for the current Day
		List<CsrMisEntity> entities = list(SELECT_INTO_BILLING_SUMMARY, CsrMisEntity.class);
		for (CsrMisEntity csrMisEntity : entities) {

			CsoBillingSummary csoBillingSummary = new CsoBillingSummary();
			csoBillingSummary.getCsoBillingSummaryPK().setIssuingMember(Short.valueOf(csrMisEntity.getCsrMisEntity_PK().getIssuingMember()));
			csoBillingSummary.setValue(new BigDecimal(csrMisEntity.getValue()));
			csoBillingSummary.setValueAbove(new BigDecimal(csrMisEntity.getValueAbove()));
			csoBillingSummary.setValueBelow(new BigDecimal(csrMisEntity.getValueBelow()));
			csoBillingSummary.setVolume(Integer.valueOf(csrMisEntity.getVolume()));
			csoBillingSummary.setVolumeAbove(Integer.valueOf(csrMisEntity.getVolumeAbove()));
			csoBillingSummary.setVolumeBelow(Integer.valueOf(csrMisEntity.getVolumeBelow()));

			CsoBillingSummaryPK csoBillingSummaryPK = new CsoBillingSummaryPK();
			csoBillingSummaryPK.setIssuingMember(Short.valueOf(csrMisEntity.getCsrMisEntity_PK().getIssuingMember()));
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			Date date;
			try {
				date = df.parse(csrMisEntity.getCsrMisEntity_PK().getProcessDate());
				csoBillingSummaryPK.setProcessDate(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			csoBillingSummaryPK.setService(csrMisEntity.getService());
			csoBillingSummaryPK.setSubService(csrMisEntity.getCsrMisEntity_PK().getServiceCode());
			csoBillingSummaryPK.setCardType(csrMisEntity.getCsrMisEntity_PK().getCardType());
			csoBillingSummary.setCsoBillingSummaryPK(csoBillingSummaryPK);

			//this is used to save the data to the table.
			saveOrUpdate(csoBillingSummary);

		}

	}
    // This deletes the current day data if there is any already in the table
	public int updateData(String processDate) {

		Map<String, Object> params = new HashMap<>();
		params.put("processDate", processDate);

		int result = executeUpdate(DELETE_BILLING_SUMMARY_SQL, params);

		return result;

	}

}
