package com.bsva.dmcs.fileloadv02.billing;

import com.bsva.dao.v02.CsoCardTypeDirectionDAO;
import com.bsva.dao.v02.TransactionTypesDAO;
import com.bsva.dao.v02.billing.CardFeeBilateralDAO;
import com.bsva.dao.v02.billing.CardFeeSARBBillingDAO;
import com.bsva.dao.v02.billing.SARBBillingRateDescriptorsDAO;
import com.bsva.dao.v02.billing.SARBBillingRatesDAO;
import com.bsva.dmcs.fileloadv02.dto.Service;
import com.bsva.dmcs.fileloadv02.dto.SubService;
import com.bsva.dmcs.fileloadv02.model.BillingData;
import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.dmcs.fileloadv02.model.TerminalInfo;
import com.bsva.dmcs.fileloadv02.util.BinarySearch;
import com.bsva.entities.v02.billing.BilateralBillingKey;
import com.bsva.entities.v02.billing.BillingKey;
import com.bsva.entities.v02.billing.BillingRate;
import com.bsva.entities.v02.billing.BillingRateID;
import com.bsva.entities.v02.billing.CardFeeBilateralRateEntity;
import com.bsva.entities.v02.billing.CardFeeSARBBillingEntity;
import com.bsva.entities.v02.commons.TxnTypeEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * TODO Document
 */
@SuppressWarnings("unused")
public class SARBBillingCalculator extends BillingCalculator {

	private final Map<BillingKey, String> billingRateDescriptors;

	// private final Map<BillingRateID, BillingRate> billingRates;
	private final BigDecimal vatRate;

	private final String subServiceID;

	private final BilateralBillingCalculator bilateralBillingCalculator;

	private final VisaBillateralBilling visaBillateralBilling;

	private final Map<Integer, TxnTypeEntity> txnTypes;

	private final Map<String, CardFeeSARBBillingEntity> billingRates;

	private final Map<BilateralBillingKey, CardFeeBilateralRateEntity> billateralBillingRate;

	private final Map<Short, String> csfCardTypesDirection;

	private final static List<Integer> BILATERAL_TXN_CODES;
	static {
		BILATERAL_TXN_CODES = Arrays.asList(new Integer[] { 4, 7, 14, 17, 24, 27, 34, 37 });
		// BILATERAL_TXN_CODES = Arrays.asList(new Integer[] {4,5,6,15,16,25,26,14,24,34,7,17,27,37});
	}

	private static Integer[] debitTransactionCodes;
	static {
		debitTransactionCodes = new Integer[] { 4, 5, 7, 14, 15, 17, 26 };
	}

	public SARBBillingCalculator(Service service, SubService subService, BigDecimal vatRate) {

		subServiceID = subService.getDescription();

		billingRateDescriptors = new SARBBillingRateDescriptorsDAO().billingRateDescriptors(service.name(),
				subServiceID);
		billateralBillingRate = new CardFeeBilateralDAO().applicableBilateralRatesMap(BILATERAL_TXN_CODES);
		// billingRates
		// = new SARBBillingRatesDAO()
		// .billingRates();
		billingRates = new CardFeeSARBBillingDAO().cardFeeSARBBillingRates();
		csfCardTypesDirection = new CsoCardTypeDirectionDAO().getCardTypes();

		this.vatRate = vatRate;

		this.bilateralBillingCalculator = new BilateralBillingCalculator(service, subService, vatRate);
		this.visaBillateralBilling = new VisaBillateralBilling(service, subService, vatRate);
		txnTypes = new TransactionTypesDAO().txnTypeEntities();
	}

	@Override
	public void bill(List<FileDetailDTO> payLines) {

		if (!"C".equals(payLines.get(0).getStatus())) {
			return;
		}

		// is pure cash back ?
		FileDetailDTO payment = payLines.get(0);
		FileDetailDTO tcr01 = null;
		if ("VISA CARD".equals(subServiceID)) {
			tcr01 = payLines.get(1);
		}

		// billing data
		Integer txnCode = payment.getBillingTxnCode() != null ? payment.getBillingTxnCode() : payment.getTxnCode();
		TxnTypeEntity txnType = txnTypes.get(txnCode);
		
		Integer percentageFeeDirection = txnType.getFeeDirection();
		Integer flatFeeDirection = txnType.getAmountDirection();
		Integer vatDirection = txnType.getVatDirection();

		boolean isBilateral = BILATERAL_TXN_CODES.contains(txnCode.intValue());
		if (isBilateral && "VISA CARD".equals(subServiceID)) {
			visaBillateralBilling.bill(payLines);
			return;
		}
		else if (isBilateral && ("DINERS".equals(subServiceID) || "AMEX".equals(subServiceID))
				|| "FLEET CARD".equals(subServiceID)) {
			bilateralBillingCalculator.bill(payLines);
			return;
		}

		@SuppressWarnings("null")
		boolean hasCashBack = "MASTERCARD".equals(subServiceID) ? payment.isCashBackPresent() : tcr01.hasCashBack();
		Long cashBackAmount = "MASTERCARD".equals(subServiceID) ? payment.getCashbackAmount() : tcr01.getCashbackAmount();

		TerminalInfo terminalInfo = payment.getTerminalInfo();

		// prime TCR0
		if ("VISA CARD".equals(subServiceID) && payLines.size() > 1) {
			try {
				TerminalInfo additional = payLines.get(1).getTerminalInfo();
				terminalInfo.setChipCard(additional.getChipCard());
				terminalInfo.setEcommIndicator(additional.getEcommIndicator());
				payment.setCashbackAmount(payLines.get(1).getCashbackAmount());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		BillingKey billingKey = new BillingKey();
		try {
			billingKey.setPosEntryMode(terminalInfo.getPosEntryMode());
			billingKey.setChipCard(terminalInfo.getChipCard());
			billingKey.setTerminalCapability(terminalInfo.getTerminalCapability());
			billingKey.seteCommIndicator(terminalInfo.getEcommIndicator());
			billingKey.setCardPresent(terminalInfo.getCardPresent());
		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}
		boolean pureCashBack = isPureCashBack(payment.getAmount(), cashBackAmount);

		// calculate purchase portion
		Long purchasePortion = pureCashBack ? 0L : purchasePortion(payment.getAmount(), cashBackAmount);

		// billing rate
		// BillingRate billingRate = null;
		// BillingRate cashBackBillingRate = null;
		CardFeeSARBBillingEntity cashBackFee = null;
		String rateDescriptor = null;

		if (hasCashBack) {
			rateDescriptor = "CASHBACK";
			BillingRateID billingRateID = new BillingRateID(rateDescriptor, payment.getCardType());
			// cashBackFee = billingRates.get(billingRateID);
			Iterator entries = billingRates.entrySet().iterator();
			while (entries.hasNext()) {
				Map.Entry entry = (Map.Entry) entries.next();
				if (entry.getKey().equals(rateDescriptor)) {
					cashBackFee = (CardFeeSARBBillingEntity) entry.getValue();
				}
			}
		}
		CardFeeSARBBillingEntity cardFee = null;
		if (!pureCashBack) {
			// Card Not present Basic rate
			rateDescriptor = billingRateDescriptors.get(billingKey);
			if (rateDescriptor == null) {
				rateDescriptor = "CNP BR";
			}
			// BillingRateID billingRateID = new BillingRateID(rateDescriptor, payment.getCardType());
			// billingRate = billingRates.get(billingRateID);
			// cardFee = billingRates.get(rateDescriptor);
			Iterator entries = billingRates.entrySet().iterator();
			while (entries.hasNext()) {
				Map.Entry entry = (Map.Entry) entries.next();
				if (entry.getKey().equals(rateDescriptor)) {
					cardFee = (CardFeeSARBBillingEntity) entry.getValue();
				}
			}
		}
		else {
			rateDescriptor = "CASHBACK";
			// cashBackFee = billingRates.get(rateDescriptor);
			Iterator entries = billingRates.entrySet().iterator();
			while (entries.hasNext()) {
				Map.Entry entry = (Map.Entry) entries.next();
				if (entry.getKey().equals(rateDescriptor)) {
					cashBackFee = (CardFeeSARBBillingEntity) entry.getValue();
				}
			}
		}

		

		// Card fee

		boolean isDebit = "DEBIT"
				.equalsIgnoreCase(csfCardTypesDirection.get(Short.valueOf(payment.getCardType().shortValue())));
		Double percent = 0.00;
		Double flat = 0.00;
		if (cardFee != null) {
			percent = isDebit ? cardFee.getDebitPercent() : cardFee.getCreditPercent();// Line to check for balancing
			flat = isDebit ? cardFee.getDebitRate() : cardFee.getCreditRate();
		}
		Double cashbackPercent = 0.00;
		Double cashbackFlat = 0.00;
		if (hasCashBack) {
			if (cashBackFee != null) {
				cashbackPercent = isDebit ? cashBackFee.getDebitPercent() : cashBackFee.getCreditPercent();
				cashbackFlat = isDebit ? cashBackFee.getDebitRate() : cashBackFee.getCreditRate();
			}
		}
		// if charge back and process date is before rate change over date
		if (txnCode > 10 && cardFee != null) {
			Date txnDate = payment.getDateTime();
			if (txnDate != null && cardFee.getChangeOverDate().after(txnDate)) {
				// use old rates
				percent = isDebit ? cardFee.getOldDebitPercent() : cardFee.getOldCreditPercent();
				flat = isDebit ? cardFee.getOldDebitRate() : cardFee.getOldCreditRate();
				if (cashBackFee != null) {
					cashbackPercent = isDebit ? cashBackFee.getDebitPercent() : cashBackFee.getCreditPercent();
					cashbackFlat = isDebit ? cashBackFee.getDebitRate() : cashBackFee.getCreditRate();
				}
			}
		}
		
		long percentageFee =  (pureCashBack ? 0L
				: percentageFee(purchasePortion, new BigDecimal(percent).setScale(2, RoundingMode.HALF_UP),
						percentageFeeDirection));
		long flatFee = (pureCashBack ? 0L
				: flatFee(purchasePortion, new BigDecimal(flat).setScale(2, RoundingMode.HALF_UP), flatFeeDirection));
		long cashBackPercentFee = (!hasCashBack ? 0L
				: percentageFee(cashBackAmount, new BigDecimal(cashbackPercent).setScale(2, RoundingMode.HALF_UP),
						percentageFeeDirection));
		long cashBackFlatFee = (!hasCashBack ? 0L
				: flatFee(cashBackAmount, new BigDecimal(cashbackFlat).setScale(2, RoundingMode.HALF_UP),
						flatFeeDirection));

		Double vatFee = cashBackVat(percentageFee + flatFee, vatRate, vatDirection);
		Double cashbackVAT = cashBackVat(cashBackPercentFee + cashBackFlatFee, vatRate, 1);

		BillingData billingData = new BillingData(rateDescriptor,
				// purchase portion
				percentageFee, flatFee, (pureCashBack ? 0L : vatFee),

				// cash back portion
				cashBackPercentFee, cashBackFlatFee, cashbackVAT);

		payment.setBillingData(billingData);
		/*if(("MASTERCARD".equals(subServiceID) && ((txnCode == 25) || (txnCode == 6)))){
			payment.setAmount(payment.getAmount()*flatFeeDirection);
		}*/
	}

	private boolean isDebitFee(Short cardType, TxnTypeEntity txnType) {

		boolean isDebit = "DEBIT".equalsIgnoreCase(csfCardTypesDirection.get(cardType));

		int txnCodeDirection = txnTypes.get(txnType.getTxnCode()).getAmountDirection();

		return txnCodeDirection == 1 ? isDebit : !isDebit;
	}

}
