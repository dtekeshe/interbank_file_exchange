package com.bsva.dmcs.reports;

import com.bsva.dcms.commons.dto.views.temp.CsvCcr00XDataViewDto;
import com.bsva.dmcs.dto.AcquirerIssuerPair;
import com.bsva.dmcs.dto.SettlementSummaryData;
import com.bsva.dmcs.reportv02.util.NoDataFoundException;
import com.bsva.dmcs.vo.TxnCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for CCR001.java
 * Provides settlement data for each acquirer / issuer paid
 * Construct the provider by providing List<CsvCcr00XDataViewDto>
 * e.g. instantiate at line 180 of {@link CCR001#CCR001()}
 */
public class SettlementSummaryDataProvider {

    private static Map<AcquirerIssuerPair, Map<TxnCode, SettlementSummaryData>> settlementData;

    public static void init(List<CsvCcr00XDataViewDto> txns) {

        settlementData = new HashMap<>();

        // build settlement data map

        for (CsvCcr00XDataViewDto txn : txns) {

            try {
                AcquirerIssuerPair pair =
                        new AcquirerIssuerPair(
                                txn.getAcquirerBankCode(),
                                txn.getIssuerBankCode());

                // do we have acquirer / issuer paid already
                Map<TxnCode, SettlementSummaryData> map = settlementData.get(pair);
                if (map == null) {
                    map = new HashMap<>();
                    settlementData.put(pair, map);
                }

                // do we have a txn code entry
                TxnCode txnCode = new TxnCode(txn.getTransactionCode());
                SettlementSummaryData data = map.get(txnCode);
                if (data == null) {
                    data = new SettlementSummaryData(pair);
                    txn.getTransactionDescription();
                    txn.getCardDescription();
                    txn.getIssuerMember();
                    txn.getAcquirerMember();
                    map.put(txnCode, data);
                }

                data.addVolume(txn.getTransactionValue());
                data.addBillingFee(txn.getBillingFee());
                data.addBillingFeeAmount(txn.getBillingFeeAmount());
                data.addBillingVat(txn.getBillingVat());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static Map<TxnCode, SettlementSummaryData> settlementDataFor(
                Integer acquirerCode, Integer issuerCode) throws NoDataFoundException {

        AcquirerIssuerPair pair = new AcquirerIssuerPair(acquirerCode, issuerCode);

        Map<TxnCode, SettlementSummaryData> data = settlementData.get(pair);
        if ( data == null) {
            throw new NoDataFoundException("DATA NOT FOUND FOR PAIR : " + pair);
        }

        return data;
    }
}
