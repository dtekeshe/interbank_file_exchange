package com.bsva.dmcs.reportv02.util;

import com.bsva.dcms.commons.dao.CSFTransactionTypesDAO;
import com.bsva.dcms.commons.dto.CSFTransactionTypesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dmcs.dto.SettlementSummaryData;
import com.bsva.dmcs.reports.SettlementSummaryDataProvider;
import com.bsva.dmcs.vo.TxnCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.bsva.dmcs.reports.SummaryPage.padLeft;
import static com.bsva.dmcs.reports.SummaryPage.rightPadding;

public class SettlementSummaryWriter {

    private final static List<TxnCode> txnTypes;

    static {
        txnTypes = txnTypes();
    }

    public static void write(StringBuilder summaryPageBuilder, Integer acquirerCode, Integer issuerCode) {

        Map<TxnCode, SettlementSummaryData> settlementData = null;

        try {
            settlementData = SettlementSummaryDataProvider.settlementDataFor(acquirerCode, issuerCode);

            // for each known transaction type

            for (TxnCode txnCode : txnTypes ) {

                // get the settlement data for it
                SettlementSummaryData data = settlementData.get(txnCode);

                if (data == null) {

                    // txn type not found
                    summaryPageBuilder.append(rightPadding(" ", 1));
                } else {

                    summaryPageBuilder.append(
                            rightPadding(data.getTransactionDescription(),25) +
                            // padLeft(salesDraftCount,25) +
                            padLeft("" + data.getVolume(), 25) +
                            // padLeft(salesDraftAmount,16) +
                            padLeft("" + data.getTranValue(), 16) +
                            // padLeft(salesDraftInterChange,16) +
                            padLeft("" + data.getBillingFee(), 16) +
                            // padLeft(salesDraftVat,15) +
                            padLeft("" + data.getBillingVat(), 16));
                            // padLeft(salesDraftTotalCharges,22) +
                            // TODO calculation?
                            // padLeft(salesDraftNetAmount,17));
                            // TODO calculation?
                }
            }
        } catch (NoDataFoundException e) {
            // TODO Handle exception
            e.printStackTrace();
        }
    }

    private static List<TxnCode> txnTypes() {
        try {
            List<TxnCode> txnTypes = new ArrayList<>();

            List<CSFTransactionTypesDTO> entities = new CSFTransactionTypesDAO().retrieveRelated(null);
            for (CSFTransactionTypesDTO entity : entities) {
                TxnCode txnCode = new TxnCode(entity.getTransactionCode());
                txnTypes.add(txnCode);
            }

            return txnTypes;
        } catch (DAOException e) {
            // TODO implement handler
            e.printStackTrace();
            return null;
        }
    }
}
