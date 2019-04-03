package com.bsva.dmcs.fileloadv02.indexer.util;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import com.bsva.dmcs.fileloadv02.indexer.FleetTxnRecordWriter;
import com.bsva.entities.v02.billing.FleetBillingTxnEntity;
import com.bsva.entities.v02.settlement.FleetBindKey;


/**
 * @author AugustineA
 *
 */
public class FleetBillingTxnsBinderAndWriter {

	private final static Long FIVE_MINS_IN_MILLS = (long) (5 * 60 * 1000); // 5 mins x 60 sec x 1000 mills
	// = new HashMap<String, List<FleetBillingTxnEntity>>();

	public static List<FleetBillingTxnEntity> write(PrintWriter out, Long fileSystemSeqNumber,
			List<FleetBillingTxnEntity> txns) {

		List<FleetBillingTxnEntity> boundTxns = new ArrayList<>();

		// bind txns for same account together
		Map<FleetBindKey, List<FleetBillingTxnEntity>> mappedTxns = map(txns);
		// record counter
		AtomicLong lineID = new AtomicLong(0L);

		for (List<FleetBillingTxnEntity> txnsForAcc : mappedTxns.values()) {

			List<FleetBillingTxnEntity> boundTxnsForAcc = bind(txnsForAcc);
			// write
			FleetTxnRecordWriter.write(out, fileSystemSeqNumber, lineID, boundTxnsForAcc);
		}

		return boundTxns;
	}

	// bind txns for same account together
	private static Map<FleetBindKey, List<FleetBillingTxnEntity>> map(List<FleetBillingTxnEntity> txns) {

		Map<FleetBindKey, List<FleetBillingTxnEntity>> mappedTxns = new HashMap<>();
		for (FleetBillingTxnEntity txn : txns) {
			// Get the keys to search from
			FleetBindKey keys = new FleetBindKey();
			keys.setAccountNumber(txn.getAccountNumber());
			keys.setIss(String.valueOf(txn.getIssuerCode().intValue()));
			keys.setAcq(String.valueOf(txn.getAcquirerCode().intValue()));
			keys.setAcqBin(String.valueOf(txn.getAcquirerBin()));
			
			// Declare an array to put values
			List<FleetBillingTxnEntity> txnsForAccount = mappedTxns.get(keys);

			if (txnsForAccount == null) {
				 //create a new list for this key
				txnsForAccount = new ArrayList<>();
				mappedTxns.put(keys, txnsForAccount);
			}
			// add this txn
			txnsForAccount.add(txn);
		}

		return mappedTxns;
	}

	// bind txns within 5 minutes together
	private static List<FleetBillingTxnEntity> bind(List<FleetBillingTxnEntity> txns) {

		// don't bind it one txn
		if (txns.size() == 1) {
			txns.get(0).incrementTxnCount();
			return txns;
		}

		// sort txns by txnDateTime
		Collections.sort(txns, new Comparator<FleetBillingTxnEntity>() {
			@Override
			public int compare(FleetBillingTxnEntity thisTxn, FleetBillingTxnEntity prevTxn) {
				return prevTxn.getTxnDateTime().compareTo(thisTxn.getTxnDateTime());
			}
		});

		// bind txns
		List<FleetBillingTxnEntity> boundTxns = new ArrayList<>();

		// add the first one
		boundTxns.add(txns.get(0));

		// increment count
		txns.get(0).incrementTxnCount();

		for (int idx = 1; idx < txns.size(); ++idx) {
			FleetBillingTxnEntity thisTxn = txns.get(idx);
			// last bound txn time
			FleetBillingTxnEntity prevTxn = boundTxns.get(boundTxns.size() - 1);
			Long prevTxnTime = prevTxn.getTxnDateTime();
			String prevTxnTxCode = String.valueOf(prevTxn.getTxnCode().intValue());
			// This txn happened within 5 minutes from prev txn
			Long thisTxnTime = thisTxn.getTxnDateTime();
			String thisTxnTxCode = String.valueOf(thisTxn.getTxnCode().intValue());
			if ((Math.abs((thisTxnTime - prevTxnTime)) <= FIVE_MINS_IN_MILLS) && (prevTxnTxCode.equals(thisTxnTxCode))) {
				// add this txn amount to last txn
				prevTxn.addAmount(thisTxn.getAmount());
				prevTxn.incrementTxnCount();
			}
			else {
				// add this txn
				thisTxn.incrementTxnCount();
				boundTxns.add(thisTxn);
			}
		}

		return boundTxns;
	}
}
