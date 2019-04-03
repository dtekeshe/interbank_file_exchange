package com.bsva.entities.v02.settlement;

import com.bsva.dao.AbstractDao;

public class CSO_CSR03031VisaReport_DAO extends AbstractDao<Void, Void> {

	private final static String CSO_CCR030_VISA_SQL_INSERT = "  INSERT INTO CSO_CCR030_VISA ( 					"
			+ " ACQUIRER_MEMBER, 																				"
			+ " ISSUER_MEMBER,																					"
			+ " CARD_TYPE,																						"
			+ " CARD_NO,																						"
			+ " TRANSACTION_CODE,																				"
			+ " TRANSACTION_DATE,																			"
			+ " BSVA_SEQ_NO,																					"
			+ " TRANSACTION_ACQUIRER_REF_DATA,																	"
			+ " POS_ENTRY_MODE,																					"
			+ " TERMINAL_CAPABILITY,																			"
			+ " FPI,																							"
			+ " ECOMM_INDICATOR,																				"
			+ " VISA_AMOUNT,																					"
			+ " CASHBACK_PURCHASE_AMOUNT,																		"
			+ " MCC,																							"
			+ " RATE_DESCRIPTOR,																				"
			+ " INTERCHANGE_FEE,																				"
			+ " INTERCHANGE_PERC,																				"
			+ " INTERCHANGE_VAT,																				"
			+ " CASHBACK_INTERCHANGE_FEE,																		"
			+ " CASHBACK_INTERCHANGE_VAT,																		"
			+ " TRANSACTION_CARD_ID_METHOD																		"

			+ " )																								"
			+ " SELECT  																						"
			+ "   LPAD (acquirer_member, 4, '0')AS ACQUIRER_MEMBER,												"
			+ "      LPAD (issuer_member, 4, '0') AS ISSUER_MEMBER,												"
			+ "      LPAD (card_type, 2, '0') AS CARD_TYPE, 													"
			+ "      RPAD (card_no, 16, ' ') AS CARD_NO, 														"
			+ "      LPAD (tran_code, 2, '0')AS TRANSACTION_CODE, 												"
			+ "      LPAD (tx_date, 4, '0') AS TRANSACTION_DATE, 												"
			+ "      LPAD (bsva_seqno, 12, '0')AS BSVA_SEQ_NO, 													"
			+ "      RPAD (tx_acq_ref, 23, ' ')AS TRANSACTION_ACQUIRER_REF_DATA, 								"
			+ "      RPAD (pos_entry_mode, 2, ' ')AS POS_ENTRY_MODE, 											"
			+ "      RPAD (terminal_capability, 1, ' ')AS TERMINAL_CAPABILITY, 									"
			+ "      RPAD (tx_fpi, 3, ' ') AS FPI, 																"
			+ "      RPAD (ecomm_ind, 1, ' ')AS ECOMM_INDICATOR, 												"
			+ "      TO_CHAR (ABS (visa_amount), 'fm09999999999.90')AS VISA_AMOUNT, 							"
			+ "      TO_CHAR (ABS (cashback_purchase_amnt), 'fm09999999999.90')AS CASHBACK_PURCHASE_AMOUNT, 	"
			+ "      RPAD (mcc, 4, ' ')AS MCC, 																	"
			+ "      RPAD (rate_desc, 10, ' ')AS RATE_DESCRIPTOR, 												"
			+ "      TO_CHAR (ABS (interchange_fee), 'fm099999.90')AS INTERCHANGE_FEE, 							"
			+ "      TO_CHAR (ABS (interchange_perc), 'fm099999.90')AS INTERCHANGE_PERC, 						"
			+ "      TO_CHAR (ABS (interchange_vat), 'fm0999.90')AS INTERCHANGE_VAT, 							"
			+ "      TO_CHAR (ABS (cashback_ic_fee), 'fm099999.90')AS CASHBACK_INTERCHANGE_FEE,					"
			+ "      TO_CHAR (ABS (cashback_ic_vat), 'fm0999.90') AS CASHBACK_INTERCHANGE_VAT, 					"
			+ "      tx_card_id_method AS TRANSACTION_CARD_ID_METHOD 											"

			+ " FROM (SELECT  																					"
			+ "              a.acquirer_member,																	"
			+ "              a.issuer_member, 																	"
			+ "              TRIM (a.card_type) AS tx_card_type, 												"
			+ "              a.account_number AS card_no, 														"
			+ "              SUBSTR (a.card_transaction, 54, 4) AS tx_date,										"
			+ "              SUBSTR (a.card_transaction, 28, 23) AS tx_acq_ref, 								"
			+ "              SUBSTR (b.card_transaction, 72, 3) AS tx_fpi, 										"
			+ "              SUBSTR (a.card_transaction, 156, 1) AS tx_card_id_method, 							"
			+ "              '000000' AS tx_time, 																"
			+ "              a.system_gen_seq_number AS bsva_seqno, 											"
			+ "              a.pos_entry_mode, 																	"
			+ "              a.terminal_capability, 															"
			+ "              a.card_present, 																	"
			+ "              a.ecomm_ind, 																		"
			+ "              a.visa_amount, 																	"
			+ "              a.cashback_purchase_amnt, 															"
			+ "              TO_NUMBER (a.transaction_code) AS tran_code, 										"
			+ "             SUBSTR (a.card_transaction, 129, 4) AS mcc, 										"
			+ "              a.rate_desc, 																		"
			+ "              a.interchange_fee, 																"
			+ "              a.interchange_perc, 																"
			+ "              a.interchange_vat, 																"
			+ "              a.cashback_ic_fee, 																"
			+ "              a.cashback_ic_vat 																	"
			+ "         FROM cso_payment_instructions_visa a 													"
			+ "              LEFT OUTER JOIN cso_payment_instructions_visa b 									"
			+" 				ON     a.system_gen_seq_number = b.system_gen_seq_number							"
            +"				AND a.TRANSACTION_CODE_NUMBER = 0													"
            +"				AND b.TRANSACTION_CODE_NUMBER = 1													"
			+ "        WHERE     a.financial_indicator = 'Y' 													"
			+ "              AND SUBSTR (a.SUB_SERVICE, 1, 9) = 'VISA CARD' 									"
			+ "              AND a.process_status = 'C') a, 													"
			+ "      csf_members b, 																			"
			+ "      csf_members c, 																			"
			+ "      csf_card_types d, 																			"
			+ "      csf_transaction_types e 																	"
			+ "	WHERE     a.issuer_member = b.bank_code 														"
			+ "      AND a.acquirer_member = c.bank_code 														"
			+ "      AND TO_NUMBER (a.tx_card_type) = TO_NUMBER (d.card_type) 									"
			+ "      AND TO_NUMBER (a.tran_code) = TO_NUMBER (e.transaction_code)							    ";

	public void populateCSR3031VisaTable() {
		try {
			// executeUpdate with no return results
			executeSelectQuery(CSO_CCR030_VISA_SQL_INSERT);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
