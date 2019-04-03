package com.bsva.entities.v02.settlement;

import java.util.HashMap;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.Ccr03031McardEntity;

public class CSO_CCR030_MCARD_DAO extends AbstractDao<Ccr03031McardEntity, Void> {

	private final static String INSERT_DATA_TO_MCARD_TABLE = " INSERT INTO CSO_CCR030_MCARD_PRD		 					"
			+ "(  																											"
			+ "  ACQUIRER_MEMBER,																							"
			+ "  ISSUER_MEMBER,																								"
			+ "  CARD_TYPE,																									"
			+ "  CARD_NO,																									"
			+ "  TRANSACTION_CODE,																							"
			+ "  TRANSACTION_PROCESS_CODE,																					"
			+ "  TRANSACTION_DATE,																							"
			+ "  TRANSACTION_TIME,																							"
			+ "  SEQUENCE_NUMBER,																							"
			+ "  TRANSACTION_ACQUIRER_REF_DATA,																				"
			+ "  TRANSACTION_POINT_OF_SALE,																					"
			+ "  TERMINAL_CAPABILITY,																						"
			+ "  CARD_PRESENT,																								"
			+ "  TRANSACTION_SERVICE_CODE,																					"
			+ "  TRANSACTION_IRD,																							"
			+ "  ECOMM_INDICATOR,																							"
			+ "  MASTERCARD_AMOUNT,																							"
			+ "  CASHBACK_PURCHASE_AMOUNT,																					"
			+ "  MCC,																										"
			+ "  RATE_DESCRIPTOR,																							"
			+ "  INTERCHANGE_FEE,																							"
			+ "  INTERCHANGE_PERC,																							"
			+ "  INTERCHANGE_VAT,																							"
			+ "  CASHBACK_INTERCHANGE_FEE,																					"
			+ "  CASHBACK_INTERCHANGE_VAT,																					"
			+ "  TRANSACTION_TERMINAL_TYPE  )																				"
			+ "  VALUES 		(																								"
			+ "	:acquirer_member,:issuer_member,:card_type,:card_no,:transaction_code,:tx_process_code,:tx_date,:tx_time,:bsva_seqno , "
			+ "	:tx_acq_ref_data,:tx_point_of_sale,:terminal_capability,:card_present,:tx_service_code,:tx_ird,:ecomm_ind,:mastercard_amount,:cashback_purchase_amnt , "
			+ "	:mcc,:rate_desc,:interchange_fee,:interchange_perc,:interchange_vat,:cashback_ic_fee,:cashback_ic_vat,:tx_terminal_type )";

	public void saveFileMcard(Ccr03031McardEntity ccr03031McardEntity) {

		// prepare params
		Map<String, Object> params = new HashMap<>();
		/*params.put("acquirer_member", ccr03031McardEntity.getAcquirer());
		params.put("issuer_member", ccr03031McardEntity.getIssuer());
		params.put("card_type", ccr03031McardEntity.getCardType());
		params.put("card_no", ccr03031McardEntity.getCardNo());
		params.put("transaction_code", ccr03031McardEntity.getTrxnCode());
		params.put("tx_process_code", ccr03031McardEntity.getTrxnProcessCode());
		params.put("tx_date", ccr03031McardEntity.getTrxnDate());
		params.put("tx_time", ccr03031McardEntity.getTrxnTime());
		params.put("bsva_seqno", ccr03031McardEntity.getSeqNumber());
		params.put("tx_acq_ref_data", ccr03031McardEntity.getTrxnRefData());
		params.put("tx_point_of_sale", ccr03031McardEntity.getTrxnPointOfSale());
		params.put("terminal_capability", ccr03031McardEntity.getTerminalCapability());
		params.put("card_present", ccr03031McardEntity.getCardPresent());
		params.put("tx_service_code", ccr03031McardEntity.getTrxnServiceCode());
		params.put("tx_ird", ccr03031McardEntity.getTrxnIrd());
		params.put("ecomm_ind", ccr03031McardEntity.geteCommInd());
		params.put("mastercard_amount", ccr03031McardEntity.getmCardAmount());
		params.put("cashback_purchase_amnt", ccr03031McardEntity.getCashBackPurchaseAmount());
		params.put("mcc", ccr03031McardEntity.getMcc());
		params.put("rate_desc", ccr03031McardEntity.getRateDescriptor());
		params.put("interchange_fee", ccr03031McardEntity.getInterChangeFee());
		params.put("interchange_perc", ccr03031McardEntity.getInterChangePerc());
		params.put("interchange_vat", ccr03031McardEntity.getInterChangeVat());
		params.put("cashback_ic_fee", ccr03031McardEntity.getCashBackInterchangeFee());
		params.put("cashback_ic_vat", ccr03031McardEntity.getCashBackInterchangeVat());
		params.put("tx_terminal_type", ccr03031McardEntity.getTrxnTerminalType());*/

		executeUpdate(INSERT_DATA_TO_MCARD_TABLE, params);
	}

}
