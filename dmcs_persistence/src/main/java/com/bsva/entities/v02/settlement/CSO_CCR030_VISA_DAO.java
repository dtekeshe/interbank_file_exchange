package com.bsva.entities.v02.settlement;

import java.util.HashMap;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.Ccr03031VisaEntity;

public class CSO_CCR030_VISA_DAO extends AbstractDao<Ccr03031VisaEntity, Void> {

	private final static String  INSERT_DATA_TO_VISA_TABLE=  " INSERT INTO CSO_CCR030_VISA_PRD			 						"
			+"(  																											"
			+"  ACQUIRER_MEMBER,																							"
			+"  ISSUER_MEMBER,																								"
			+"  CARD_TYPE,																									"
			+"  CARD_NO,																									"
			+"  TRANSACTION_CODE,																							"
			+"  TRANSACTION_DATE,																							"
			+"  BSVA_SEQ_NO,																								"
			+"  TRANSACTION_ACQUIRER_REF_DATA,																				"
			+"  POS_ENTRY_MODE,																								"
			+"  TERMINAL_CAPABILITY,																						"
			+"  FPI,																										"
			+"  ECOMM_INDICATOR,																							"
			+"  VISA_AMOUNT,																								"
			+"  CASHBACK_PURCHASE_AMOUNT,																					"
			+"  MCC,																										"
			+"  RATE_DESCRIPTOR,																							"
			+"  INTERCHANGE_FEE,																							"
			+"  INTERCHANGE_PERC,																							"
			+"  INTERCHANGE_VAT,																							"
			+"  CASHBACK_INTERCHANGE_FEE,																					"
			+"  CASHBACK_INTERCHANGE_VAT,																					"
			+"  TRANSACTION_CARD_ID_METHOD  )																				"
			+"  VALUES 		(																								"
			+"	:acquirerMember,:issuerMember,:cardType,:cardNo,:trxnCode,:trxnDate,:seqNumber,:trxnAcqRefDate,:posEntryMode,:terminalCapability,"
			+"	:fpi,:eCommInd,:visaAmount,:cashBackPAmount,:mcc,:rateDescriptor,:interChangeFee,:interChangePerc,:interChangeVat,"
			+"	:cashBackInterChangeFee,:cashBackInterChangeVat,:trxnTerminalType)";

	

	
	public void saveFileVisa(Ccr03031VisaEntity ccr03031VisaEntity ) {

		// prepare params
		Map<String, Object> params = new HashMap<>();
		/*params.put("acquirerMember", ccr03031VisaEntity.getAcquirer());
		params.put("issuerMember", ccr03031VisaEntity.getIssuer());
		params.put("cardType", ccr03031VisaEntity.getCardType());
		params.put("cardNo", ccr03031VisaEntity.getCardNo());
		params.put("trxnCode", ccr03031VisaEntity.getTrxnCode());
		params.put("trxnDate", ccr03031VisaEntity.getTrxnDate());
		params.put("seqNumber", ccr03031VisaEntity.getBsvaSeqNumber());
		params.put("trxnAcqRefDate", ccr03031VisaEntity.getTrxnAcqRefData());
		params.put("posEntryMode", ccr03031VisaEntity.getPosEntryMode());
		params.put("terminalCapability", ccr03031VisaEntity.getTerminalCapability());
		params.put("fpi", ccr03031VisaEntity.getFpi());
		params.put("eCommInd", ccr03031VisaEntity.geteCommIndicator());
		params.put("visaAmount", ccr03031VisaEntity.getVisaAmount());
		params.put("cashBackPAmount", ccr03031VisaEntity.getCashBackPurchase());
		params.put("mcc", ccr03031VisaEntity.getMcc());
		params.put("rateDescriptor", ccr03031VisaEntity.getRateDescriptor());
		params.put("interChangeFee", ccr03031VisaEntity.getInterChangeFee());
		params.put("interChangePerc", ccr03031VisaEntity.getInterChangePerc());	
		params.put("interChangeVat", ccr03031VisaEntity.getInterChangeVat());
		params.put("cashBackInterChangeFee", ccr03031VisaEntity.getCashBackInterChangeFee());
		params.put("cashBackInterChangeVat", ccr03031VisaEntity.getCashBackInterChangeVat());
		params.put("trxnTerminalType", ccr03031VisaEntity.getTrxnCardIdMethod());*/

		 executeUpdate(INSERT_DATA_TO_VISA_TABLE, params);
	}

}
