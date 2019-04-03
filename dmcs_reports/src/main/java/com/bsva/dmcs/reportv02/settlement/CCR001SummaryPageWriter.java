package com.bsva.dmcs.reportv02.settlement;

import com.bsva.dao.v02.CompanyParametersDAO;
import com.bsva.dao.v02.SubServiceCardTypesDAO;
import com.bsva.dao.v02.TxnGroupCodesDAO;
import com.bsva.dao.v02.settlement.CCR00XSummaryDataDAO;
import com.bsva.dmcs.reportv02.commons.AddressWriter;
import com.bsva.dmcs.reportv02.commons.FileWriter;
import com.bsva.dmcs.reportv02.dto.TxnGroupTotalsDTO;
import com.bsva.dto.FileHeaderDTO;
import com.bsva.dto.TxnGroup;
import com.bsva.entities.v02.commons.CardTypeEntity;
import com.bsva.entities.v02.members.MemberAddressEntity;
import com.bsva.entities.v02.params.CompanyParametersEntity;
import com.bsva.entities.v02.settlement.CCR00XSummaryDataEntity;

import java.io.PrintWriter;
import java.util.*;

/**
 * TODO Document
 */
public class CCR001SummaryPageWriter extends FileWriter {

	private final static String REPORT_ID = "001";
	private final static String LINE_SEPARATOR = System.getProperty("line.separator");

	// Metadata
	private final static String PROCESS_NAME = "SETTLE";
	private final static String VERSION = "20";
	private final Set<Integer> txnGroupCodes;
	private final CompanyParametersEntity params;
	private final List<CardTypeEntity> cardTypes;

	public CCR001SummaryPageWriter(
			String subServiceID,
			String reportFolder) {

		super( subServiceID, reportFolder, REPORT_ID);

		txnGroupCodes = new TxnGroupCodesDAO().txnGroupCodes();
		params = new CompanyParametersDAO().companyParameters();
		cardTypes = new SubServiceCardTypesDAO().cardTypes(subServiceID);
	}

	public void write(PrintWriter out, FileHeaderDTO header, String subServiceID,
					  Integer isserBankCode,
					  Integer acquirerBankCode,
					  MemberAddressEntity issuerAddress,
					  MemberAddressEntity acquirerAddress,
					  Integer pageNumber) {
		if(isserBankCode != acquirerBankCode){
		// file header
		writeFileHeader(params, header, "S U M M A R Y", pageNumber, out);

		AddressWriter.writeSummarypage(out, issuerAddress, acquirerAddress);
		header.incrementRecordCount(9);

		// write detail column header
		CCR001DetailWriter.writeColumnHeader(out);
		header.incrementRecordCount(4);

		// ccr00x data for issuer / acquirer pair
		Map<TxnGroup, List<CCR00XSummaryDataEntity>> ccr00xData
				= new CCR00XSummaryDataDAO().ccr00XData( "CARD", subServiceID, isserBankCode, acquirerBankCode);

		// for each txn group code
		for (Integer txnGroupCode : txnGroupCodes) {

			TxnGroup txnGroup
					= new TxnGroup("CARD", subServiceID, isserBankCode, acquirerBankCode, txnGroupCode);

			List<CCR00XSummaryDataEntity> txns = ccr00xData.get(txnGroup);

			// write each txn
			if (txns == null) {
				continue;
			}

			CCR001DetailWriter.writeSummaryTxnDetails(out, txns);

			// write txn group totals
			CCR001DetailWriter.writeTxnGroupUnderline(out);
			TxnGroupTotalsDTO txnGroupTotals = txnGroupTotals(txns);
			if("FLEET CARD".equals(txns.get(0).getId().getSubService())){
				CCR001DetailWriter.writeTxnSubTotalsFleetCard(out, "SUB TOTALS", txnGroupTotals);
			}else{
				CCR001DetailWriter.writeTxnSubTotals(out, "SUB TOTALS", txnGroupTotals);
			}
		}

		// write grand totals
		out.println();
		CCR001DetailWriter.writeTxnGroupUnderline(out);
		TxnGroupTotalsDTO grandTotals = grandTotals(ccr00xData.values());
		if("FLEET CARD".equals(subServiceID)){
			CCR001DetailWriter.writeTxnGrandTotalsFleetCard(out, "GRAND TOTALS", grandTotals);
		}else{
			CCR001DetailWriter.writeTxnGrandTotals(out, "GRAND TOTALS", grandTotals);
		}
		
	  }
		
	}

	private TxnGroupTotalsDTO txnGroupTotals(List<CCR00XSummaryDataEntity> txns) {
		TxnGroupTotalsDTO totals = new TxnGroupTotalsDTO();
		for (CCR00XSummaryDataEntity txn : txns) {
			totals.addVolume(CCR001ReportWriter.SPLIT_TXNS.contains(txn.getId().getTxnCode()) ? 0:txn.getVolume());
			totals.addTranValue(txn.getTranValue());
			totals.addBillingFee(txn.getBillingFee());
			totals.addBillingFeeAmount(txn.getBillingFeeAmount());
			totals.addBillingVAT(txn.getBillingVAT());
		}

		return totals;
	}

	private TxnGroupTotalsDTO grandTotals(Collection<List<CCR00XSummaryDataEntity>> ccr00xData) {

		TxnGroupTotalsDTO totals = new TxnGroupTotalsDTO();
		for (List<CCR00XSummaryDataEntity> txns : ccr00xData) {
			for (CCR00XSummaryDataEntity txn : txns) {
				totals.addVolume(CCR001ReportWriter.SPLIT_TXNS.contains(txn.getId().getTxnCode()) ? 0:txn.getVolume());
				totals.addTranValue(txn.getTranValue());
				totals.addBillingFee(txn.getBillingFee());
				totals.addBillingFeeAmount(txn.getBillingFeeAmount());
				totals.addBillingVAT(txn.getBillingVAT());
			}
		}

		return totals;
	}
}
