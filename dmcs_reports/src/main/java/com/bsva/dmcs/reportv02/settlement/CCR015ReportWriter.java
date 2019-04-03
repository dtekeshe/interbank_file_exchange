package com.bsva.dmcs.reportv02.settlement;

// import static com.bsva.dmcs.reportv02.util.ReportsUtils.ccr00xFilename;
// import static com.bsva.dmcs.reportv02.util.ReportsUtils.ccr00xFilepath;

import com.bsva.commonsv02.util.SPOLogger;
import com.bsva.dao.v02.CCR00XDataDAO;
import com.bsva.dao.v02.CompanyParametersDAO;
import com.bsva.dao.v02.SubServiceCardTypesDAO;
import com.bsva.dao.v02.TxnGroupCodesDAO;
import com.bsva.dao.v02.members.MemberServiceDAO;
import com.bsva.dmcs.reportv02.commons.AddressWriter;
import com.bsva.dmcs.reportv02.commons.FileWriter;
import com.bsva.dmcs.reportv02.dto.TxnGroupTotalsDTO;
import com.bsva.dto.FileHeaderDTO;
import com.bsva.dto.TxnGroup;
import com.bsva.entities.v02.commons.CardTypeEntity;
import com.bsva.entities.v02.members.MemberAddressEntity;
import com.bsva.entities.v02.members.MemberEntity;
import com.bsva.entities.v02.params.CompanyParametersEntity;
import com.bsva.entities.v02.settlement.CCR00XDataEntity;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * TODO Document
 */
public class CCR015ReportWriter extends FileWriter {

	private final static String REPORT_ID = "001";
	private final static String LINE_SEPARATOR = System.getProperty("line.separator");

	// Metadata
	private final static String PROCESS_NAME = "SETTLE";
	private final static String VERSION = "20";
	private final Set<Integer> txnGroupCodes;
	private final CompanyParametersEntity params;
	private final List<CardTypeEntity> cardTypes;

	public CCR015ReportWriter(
			String subServiceID,
			String reportFolder) {

		super( subServiceID, reportFolder, REPORT_ID);

		txnGroupCodes = new TxnGroupCodesDAO().txnGroupCodes();
		params = new CompanyParametersDAO().companyParameters();
		cardTypes = new SubServiceCardTypesDAO().cardTypes(subServiceID);
	}

	public void write(String subServiceID,
					  Map<Integer, MemberAddressEntity> addresses,
					  Date processDate, SPOLogger spoLog) {

		// get issuers
		List<MemberEntity> issuers
				= new MemberServiceDAO().issuingMemberService(subServiceID);

		// for each issuer
		for (MemberEntity issuer : issuers) {

			Integer pageNumber = 1;
			String filename = null;
			PrintWriter out = null;
			try {

				// create output file
				filename = ccr00xFilename(subServiceID, issuer.getFullBankCode());
				spolog(spoLog, LINE_SEPARATOR + "OPENING FILENAME: " + filename + ", TO " + issuer.getMemberName());
				String filepath = ccr00xFilepath(filename);
				out = new PrintWriter( filepath );

				// control header
				FileHeaderDTO header = defaultFileHeader();
				header.setFileDate(processDate);
				header.setOriginatorID(issuer.getBankCode());
				header.setReportName("CCR001");
				writeControlHeader(header, out);
				header.incrementRecordCount(1);

				// get issuer address
				MemberAddressEntity issuerAddress = addresses.get(issuer.getBankCode());

				// for each card type
				for (CardTypeEntity cardType : cardTypes ) {

					// get acquirers
					List<MemberEntity> acquirers
							= new MemberServiceDAO().acquiringMemberService(subServiceID);

					for (MemberEntity acquirer : acquirers) {

						if (acquirer.getBankCode() == issuer.getBankCode()) {
							spolog(spoLog, "SKIPPING. ISSUER NOT DIFFERENT FROM ACQUIRER : " + issuer.getMemberName());
							continue;
						}

						spolog(spoLog, "EXTRACTING DATA FROM : " + acquirer.getMemberName());

						// file header
						writeFileHeader(params, header, cardType.getCardDescription(), pageNumber++, out);

						// get acquirer address
						MemberAddressEntity acquirerAddress = addresses.get(acquirer.getBankCode());
						AddressWriter.write1(out, issuerAddress, acquirerAddress);
						header.incrementRecordCount(9);

						// write detail column header
						CCR001DetailWriter.writeColumnHeader(out);
						header.incrementRecordCount(4);

						// ccr00x data for issuer / acquirer pair
						Map<TxnGroup, List<CCR00XDataEntity>> ccr00xData
								= new CCR00XDataDAO()
								.ccr00XData(
										"CARD",
										subServiceID,
										issuer.getBankCode(),
										acquirer.getBankCode(),
										cardType.getCardType());

						// for each txn group code
						for (Integer txnGroupCode : txnGroupCodes) {

							TxnGroup txnGroup
									= new TxnGroup("CARD",
									subServiceID,
									issuer.getBankCode(),
									acquirer.getBankCode(),
									txnGroupCode);

							List<CCR00XDataEntity> txns = ccr00xData.get(txnGroup);

							// write each txn
							if (txns == null) {
								spolog(spoLog, "NO DATA FOR : " + issuer.getMemberName() +
										" FROM : " + acquirer.getMemberName() +
										" TXN GROUP : " + txnGroupCode);
								continue;
							}

							CCR001DetailWriter.writeTxnDetails(out, txns);

							// write txn group totals
							CCR001DetailWriter.writeTxnGroupUnderline(out);
							TxnGroupTotalsDTO txnGroupTotals = txnGroupTotals(txns);
							CCR001DetailWriter.writeTxnSubTotals(out, "SUB TOTALS", txnGroupTotals);
						}

						// write grand totals
						out.println();
						CCR001DetailWriter.writeTxnGroupUnderline(out);
						TxnGroupTotalsDTO grandTotals = grandTotals(ccr00xData.values());
						CCR001DetailWriter.writeTxnGrandTotals(out, "GRAND TOTALS", grandTotals);
					}
				}
				// file trailer
				writeControlTrailer(header, out);

			} catch (FileNotFoundException e) {
				// TODO implement handler
				e.printStackTrace();
			} finally {
				spolog(spoLog, "CLOSING FILENAME: " + filename);
				try {out.flush();} catch (Exception e){}
				try {out.close();} catch (Exception e){}
			}
		}
	}

	private TxnGroupTotalsDTO txnGroupTotals(List<CCR00XDataEntity> txns) {
		TxnGroupTotalsDTO totals = new TxnGroupTotalsDTO();
		for (CCR00XDataEntity txn : txns) {
			totals.addVolume(txn.getVolume());
			totals.addTranValue(txn.getTranValue());
			totals.addBillingFee(txn.getBillingFee());
			totals.addBillingFeeAmount(txn.getBillingFeeAmount());
			totals.addBillingVAT(txn.getBillingVAT());
		}

		return totals;
	}

	private TxnGroupTotalsDTO grandTotals(Collection<List<CCR00XDataEntity>> ccr00xData) {

		TxnGroupTotalsDTO totals = new TxnGroupTotalsDTO();
		for (List<CCR00XDataEntity> txns : ccr00xData) {
			for (CCR00XDataEntity txn : txns) {
				totals.addVolume(txn.getVolume());
				totals.addTranValue(txn.getTranValue());
				totals.addBillingFee(txn.getBillingFee());
				totals.addBillingFeeAmount(txn.getBillingFeeAmount());
				totals.addBillingVAT(txn.getBillingVAT());
			}
		}

		return totals;
	}

	public static void spolog(SPOLogger spoLog, String message) {

		// spoLog.log(PROCESS_NAME, VERSION, message);
		System.out.println(PROCESS_NAME + " " + VERSION + " " + message);
	}
}
