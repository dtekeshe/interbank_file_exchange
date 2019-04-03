package com.bsva.dao.v02.billing;

import com.bsva.dao.AbstractDao;
import com.bsva.dto.FleetBillingTxnDTO;
import com.bsva.entities.v02.billing.FleetBillingTxnEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Document
 */
public class FleetBillingDAO extends AbstractDao<FleetBillingTxnEntity, Void> {

	private final static String FLEET_BILLING_SQL =

			"SELECT SERVICE AS SERVICE_ID, 'FLEET CARD' AS SUB_SERVICE_ID, ISS AS ISSUER_CODE, ACQ AS ACQUIRER_CODE, ACC_NO AS ACCOUNT_NUMBER,TX_CDE, "
					+ "TX_DATE_TIME, CARD_TYPE, AMOUNT, TRAN_SYSTEM_SEQ_NUMBER ,ACQ_REF_NO  FROM CSO_FLEET_BILLING ORDER BY ISS ,ACQ ,ACC_NO ,TX_DATE_TIME ,TX_CDE";

	public List<FleetBillingTxnDTO> fleetBillingTxns() {
		List<FleetBillingTxnDTO> trxndata = new ArrayList<>();
		List<FleetBillingTxnEntity> txns = list(FLEET_BILLING_SQL, FleetBillingTxnEntity.class);
		for (FleetBillingTxnEntity fleetBillingTxnEntity : txns) {

			FleetBillingTxnDTO dtoData = new FleetBillingTxnDTO();
			dtoData.setAccountNumber(fleetBillingTxnEntity.getAccountNumber());
			dtoData.setAcquirerBin(fleetBillingTxnEntity.getAcquirerBin());
			dtoData.setAcquirerCode(fleetBillingTxnEntity.getAcquirerCode());
			dtoData.setAmount(fleetBillingTxnEntity.getAmount());
			dtoData.setCardType(fleetBillingTxnEntity.getCardType());
			dtoData.setIssuerCode(fleetBillingTxnEntity.getIssuerCode());
			dtoData.setServiceID(fleetBillingTxnEntity.getServiceID());
			dtoData.setSubServiceID(fleetBillingTxnEntity.getSubServiceID());
			dtoData.setSystemSequenceNumber(fleetBillingTxnEntity.getSystemSeqNumber());
			dtoData.setTxnCode(fleetBillingTxnEntity.getTxnCode());
			if (fleetBillingTxnEntity.getTxnCount() != null) {
				dtoData.setTxnCount(fleetBillingTxnEntity.getTxnCount());
			}
			dtoData.setTxnDateTime(fleetBillingTxnEntity.getTxnDateTime());

			trxndata.add(dtoData);

		}

		return trxndata;
	}
}
