package com.bsva.dmcs.reportv02.settlement;

import com.bsva.dao.v02.CompanyParametersDAO;
import com.bsva.dao.v02.SubServiceCardTypesDAO;
import com.bsva.dao.v02.TxnGroupCodesDAO;
import com.bsva.dmcs.reportv02.commons.AddressWriter;
import com.bsva.dmcs.reportv02.commons.FileWriter;
import com.bsva.dmcs.reportv02.dto.TxnGroupTotalsDTO;
import com.bsva.dto.FileHeaderDTO;
import com.bsva.dto.FinalTotalsTxnGroup;
import com.bsva.entities.v02.commons.CardTypeEntity;
import com.bsva.entities.v02.members.MemberAddressEntity;
import com.bsva.entities.v02.params.CompanyParametersEntity;
import com.bsva.entities.v02.settlement.CCR00XFinalTotalsDataEntity;

import java.io.PrintWriter;
import java.util.*;

/**
 * TODO Document
 */
public class CCR001FinalTotalsPageWriter extends FileWriter {

	private final static String REPORT_ID = "001";

	private final static String LINE_SEPARATOR = System.getProperty("line.separator");

	// Metadata
	private final static String PROCESS_NAME = "SETTLE";

	private final static String VERSION = "20";

	private final Set<Integer> txnGroupCodes;

	private final CompanyParametersEntity params;

	private final List<CardTypeEntity> cardTypes;

	private String subServices = null;

	public CCR001FinalTotalsPageWriter(String subServiceID, String reportFolder) {

		super(subServiceID, reportFolder, REPORT_ID);

		txnGroupCodes = new TxnGroupCodesDAO().txnGroupCodes();
		params = new CompanyParametersDAO().companyParameters();
		cardTypes = new SubServiceCardTypesDAO().cardTypes(subServiceID);
		subServices = subServiceID;
	}

	public void write(PrintWriter out, FileHeaderDTO header, String subServiceID, Integer isserBankCode,
			MemberAddressEntity issuerAddress, Map<FinalTotalsTxnGroup, List<CCR00XFinalTotalsDataEntity>> ccr00xData,
			Integer pageNumber, String reportID) {

		// file header
		writeFileHeader(params, header, "F I N A L  T O T A L S", pageNumber, out);

		AddressWriter.write(out, issuerAddress, reportID);
		header.incrementRecordCount(9);

		// write detail column header
		CCR001DetailWriter.writeColumnHeader(out);
		header.incrementRecordCount(4);

		// for each txn group code
		for (Integer txnGroupCode : txnGroupCodes) {

			FinalTotalsTxnGroup txnGroup = new FinalTotalsTxnGroup("CARD", subServiceID, isserBankCode, txnGroupCode);

			List<CCR00XFinalTotalsDataEntity> txns = ccr00xData.get(txnGroup);

			// write each txn
			if (txns == null) {
				continue;
			}
			if (subServices.equals("VISA CARD") || subServices.equals("MASTERCARD")) {
				CCR001DetailWriter.writeFinalTotalsTxnSARBVMDetails(out, txns);
				
				// write txn group totals
				CCR001DetailWriter.writeTxnGroupUnderline(out);
				TxnGroupTotalsDTO txnGroupTotals = txnGroupTotals(txns);
				CCR001DetailWriter.writeTxnFinalSARBVMSubTotals(out, "SUB TOTALS", txnGroupTotals);

			}
			else {
				CCR001DetailWriter.writeFinalTotalsTxnDetails(out, txns);
				
				// write txn group totals
				CCR001DetailWriter.writeTxnGroupUnderline(out);
				TxnGroupTotalsDTO txnGroupTotals = txnGroupTotals(txns);
				if("FLEET CARD".equals(subServiceID)){
					CCR001DetailWriter.writeTxnFinalSubTotalsFleetCard(out, "SUB TOTALS", txnGroupTotals);
				}else{
					CCR001DetailWriter.writeTxnFinalSubTotals(out, "SUB TOTALS", txnGroupTotals);
				}

			}
		}
		if (subServices.equals("VISA CARD") || subServices.equals("MASTERCARD")) {
			// write grand totals for Sarb Billing
			out.println();
			CCR001DetailWriter.writeTxnGroupUnderline(out);
			TxnGroupTotalsDTO grandTotals = finalTotals(ccr00xData.values());
			CCR001DetailWriter.writeTxnFinalSARBVMGrandTotals(out, "GRAND TOTALS", grandTotals);
		}
		else {
			// write grand totals for Bilateral Billing
			out.println();
			CCR001DetailWriter.writeTxnGroupUnderline(out);
			TxnGroupTotalsDTO grandTotals = finalTotals(ccr00xData.values());
			if("FLEET CARD".equals(subServiceID)){
				CCR001DetailWriter.writeTxnFinalGrandTotalsFleetCard(out, "GRAND TOTALS", grandTotals);
			}else{
				CCR001DetailWriter.writeTxnFinalGrandTotals(out, "GRAND TOTALS", grandTotals);
			}

		}
	}

	private TxnGroupTotalsDTO txnGroupTotals(List<CCR00XFinalTotalsDataEntity> txns) {
		TxnGroupTotalsDTO totals = new TxnGroupTotalsDTO();
		for (CCR00XFinalTotalsDataEntity txn : txns) {
			totals.addVolume(txn.getVolume());
			totals.addTranValue(txn.getTranValue());
			totals.addBillingFee(txn.getBillingFee());
			totals.addBillingFeeAmount(txn.getBillingFeeAmount());
			totals.addBillingVAT(txn.getBillingVAT());
		}

		return totals;
	}

	private TxnGroupTotalsDTO grandTotals(Collection<List<CCR00XFinalTotalsDataEntity>> ccr00xData) {

		TxnGroupTotalsDTO totals = new TxnGroupTotalsDTO();
		for (List<CCR00XFinalTotalsDataEntity> txns : ccr00xData) {
			for (CCR00XFinalTotalsDataEntity txn : txns) {
				totals.addVolume(
						CCR001ReportWriter.SPLIT_TXNS.contains(txn.getId().getTxnCode()) ? 0 : txn.getVolume());
				totals.addTranValue(txn.getTranValue());
				totals.addBillingFee(txn.getBillingFee());
				totals.addBillingFeeAmount(txn.getBillingFeeAmount());
				totals.addBillingVAT(txn.getBillingVAT());
			}
		}

		return totals;
	}

	private TxnGroupTotalsDTO finalTotals(Collection<List<CCR00XFinalTotalsDataEntity>> ccr00xData) {

		TxnGroupTotalsDTO totals = new TxnGroupTotalsDTO();
		for (List<CCR00XFinalTotalsDataEntity> txns : ccr00xData) {
			for (CCR00XFinalTotalsDataEntity txn : txns) {
				totals.addVolume(
						CCR001ReportWriter.SPLIT_TXNS.contains(txn.getId().getTxnCode()) ? 0 : txn.getVolume());
				totals.addTranValue(txn.getTranValue());
				totals.addBillingFee(abs(txn.getBillingFee()));
				totals.addBillingFeeAmount(abs(txn.getBillingFeeAmount()));
				totals.addBillingVAT(abs(txn.getBillingVAT()));
			}
		}

		return totals;
	}

	private static Double abs(Double value) {
		return Math.abs(value);
	}
}
