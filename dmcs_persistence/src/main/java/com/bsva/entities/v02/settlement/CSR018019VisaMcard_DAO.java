package com.bsva.entities.v02.settlement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.CSR018019ReportEntity;
import com.bsva.entities.CSR018019ReportEntityKey;

public class CSR018019VisaMcard_DAO extends AbstractDao<CSR018019ReportEntity, Void> {

	private static final String CCR018AND019_SQL_QUERY_BY_CRITERIA_ACQ_CTYPE = 
		    "  (	select a.issuer_member 		"
           +"      ,a.acquirer_member																"
           +"      ,a.card_type																		"
           +"      ,to_number(a.transaction_code) as												"
           +"                 transaction_code														"
           +"     ,SUBSTR(a.CARD_TRANSACTION,24,6) as acq_bin										"
           +"      ,count(*) as vol																	"
           +"      ,sum(visa_amount / 100) as val													"
           +"      ,sum(INTERCHANGE_FEE + INTERCHANGE_PERC +										"
           +"                CASHBACK_IC_FEE + CASHBACK_IC_PERC)									"
           +"                                            as nett_intch								"
           +"     ,sum(INTERCHANGE_VAT + CASHBACK_IC_VAT) as nett_vat								"
           +"  from cso_payment_instructions_visa a													"
           +"      ,cso_input_file_controls b														"
           +"  where a.financial_indicator = 'Y'													"
           +"    and a.FILE_REF_NUMBER = b.SYSTEM_SEQ_NUMBER										"
           +"    and b.process_status = 'C'															"
           +"    and a.process_status = 'C'															"
           +"    and a.acquirer_member =:acquirer													"
           +"    and a.card_type =:cardType															"
           +"  group by a.issuer_member																"
           +"      ,a.acquirer_member																"
           +"      ,a.card_type 																	"
           +"      ,a.transaction_code																"
           +"      ,SUBSTR(a.CARD_TRANSACTION,24,6)		)											"
           +"     union																				"
           +" (	select issuer_member																"
           +"      ,acquirer_member																	"
           +"      ,card_type																		"
           +"      ,transaction_code																"
           +"      ,SUBSTR(P31_ACQUIRER_REF_DATA,2,6) as acq_bin									"
           +"      ,count(*) as vol																	"
           +"      ,sum(mastercard_amount / 100)													"
           +"      ,sum(INTERCHANGE_FEE + INTERCHANGE_PERC +										"
           +"                CASHBACK_IC_FEE + CASHBACK_IC_PERC)									"
           +"                                            as nett_intch								"
           +"      ,sum(INTERCHANGE_VAT + CASHBACK_IC_VAT) as nett_vat								"
           +"   from cso_payment_instructions_mcard a												"
           +"       ,cso_input_file_controls b														"
           +"  where a.process_status = 'C'															"
           +"    and a.FILE_REF_NUMBER = b.SYSTEM_SEQ_NUMBER										"
           +"    and a.process_status = 'C' 														"
           +"    and b.process_status = 'C'															"
           +"    and a.acquirer_member =:acquirer													"
           +"    and a.card_type =:cardType															"
           +"  group by issuer_member 																"
           +"          ,acquirer_member																"
           +"         ,card_type																	"
           +"          ,transaction_code															"
           +"          ,SUBSTR(P31_ACQUIRER_REF_DATA,2,6)	)										"
           +" order by issuer_member																"
           +"          ,card_type																	"
           +"         ,acquirer_member																"
           +"         ,transaction_code																"
           +"         ,acq_bin 																		";



	public List<CSR018019ReportEntity> getCCR018019Data(String cardType, String acquirer) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("cardType",cardType);
		params.put("acquirer",acquirer);
		List<CSR018019ReportEntity> listData = new ArrayList<CSR018019ReportEntity>();
		
		//populateCSR3031VisaTable(cardType,acquirer);
		// execute
		List<CSR018019ReportEntity> fetchedData = list(CCR018AND019_SQL_QUERY_BY_CRITERIA_ACQ_CTYPE,params, CSR018019ReportEntity.class);

		// prepare result
		if (fetchedData.size() > 0) {
			for (CSR018019ReportEntity entity : fetchedData) {
				CSR018019ReportEntity ccr018019Entity = new CSR018019ReportEntity();
				ccr018019Entity.setAcqBin(entity.getAcqBin());
				ccr018019Entity.setAcquirerMember(entity.getAcquirerMember());
				ccr018019Entity.setCardType(entity.getCardType());
				ccr018019Entity.setIssuerMember(entity.getIssuerMember());
				ccr018019Entity.setTransCode(entity.getTransCode());
				
				CSR018019ReportEntityKey csr018019ReportEntityKey = new CSR018019ReportEntityKey();
				csr018019ReportEntityKey.setNettInterChange(entity.getId().getNettInterChange());
				csr018019ReportEntityKey.setNettVat(entity.getId().getNettVat());
				csr018019ReportEntityKey.setValue(entity.getId().getValue());
				csr018019ReportEntityKey.setVolume(entity.getId().getVolume());
				
				ccr018019Entity.setId(csr018019ReportEntityKey);
				

				listData.add(ccr018019Entity);
			}
			return listData;
		}
		else {
			return null;
		}
	}

}
