//package com.bsva.dmcs.reportv02.settlement;
//
//import com.bsva.commonsv02.util.SPOLogger;
//import com.bsva.dao.v02.*;
//import com.bsva.dao.v02.members.MemberServiceDAO;
//import com.bsva.dmcs.reportv02.commons.AddressWriter;
//import com.bsva.dmcs.reportv02.commons.FileWriter;
//import com.bsva.dmcs.reportv02.dto.TxnGroupTotalsDTO;
//import com.bsva.dto.FileHeaderDTO;
//import com.bsva.dto.TxnGroup;
//import com.bsva.entities.v02.commons.CardTypeEntity;
//import com.bsva.entities.v02.members.MemberAddressEntity;
//import com.bsva.entities.v02.members.MemberEntity;
//import com.bsva.entities.v02.params.CompanyParametersEntity;
//import com.bsva.entities.v02.settlement.CCR00XDataEntity;
//
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.util.*;
//
///**
// * TODO Document
// */
//public class CCR005ReportWriterOLD extends FileWriter {
//
//	private final static String REPORT_ID = "005";
//	private final static String LINE_SEPARATOR = System.getProperty("line.separator");
//
//	// summary page writer
//	private final CCR001SummaryPageWriter ccr001SummaryPageWriter;
//	private final CCR001FinalTotalsPageWriter ccr001FinalTotalsPageWriter;
//
//	private final SPOLogger spoLog;
//	// Metadata
//	private final static String PROCESS_NAME = "SETTLE";
//	private final static String VERSION = "20";
//	private final Set<Integer> txnGroupCodes;
//	private final CompanyParametersEntity params;
//	private final List<CardTypeEntity> cardTypes;
//
//	public CCR005ReportWriterOLD(
//			String subServiceID,
//			String reportFolder) {
//
//		super( subServiceID, reportFolder, REPORT_ID);
//
//		ccr001SummaryPageWriter = new CCR001SummaryPageWriter(subServiceID, reportFolder);
//		ccr001FinalTotalsPageWriter = new CCR001FinalTotalsPageWriter(subServiceID, reportFolder);
//
//		spoLog = new SPOLogger("");
//		txnGroupCodes = new TxnGroupCodesDAO().txnGroupCodes();
//		params = new CompanyParametersDAO().companyParameters();
//		cardTypes = new SubServiceCardTypesDAO().cardTypes(subServiceID);
//	}
//
//	public void write(String subServiceID,
//					  Map<Integer, MemberAddressEntity> addresses,
//					  Date processDate, SPOLogger spoLog) {
//
//		// get acquirers
//		List<MemberEntity> acquirers
//				= new MemberServiceDAO().acquiringMemberService(subServiceID);
//
//		// for each acquirer
//		for (MemberEntity acquirer : acquirers) {
//
//			Integer pageNumber = 1;
//			String filename = null;
//			PrintWriter out = null;
//			try {
//
//				// create output file
//				filename = ccr00xFilename(subServiceID, acquirer.getFullBankCode());
//				spolog(spoLog, LINE_SEPARATOR + "OPENING FILENAME: " + filename + ", TO " + acquirer.getMemberName());
//				String filepath = ccr00xFilepath(filename);
//				out = new PrintWriter( filepath );
//
//				// control header
//				FileHeaderDTO header = defaultFileHeader();
//				header.setFileDate(processDate);
//				header.setOriginatorID(acquirer.getBankCode());
//				header.setReportName("CCR005");
//				writeControlHeader(header, out);
//				header.incrementRecordCount(1);
//
//				// get issuer address
//				MemberAddressEntity acquirerAddress = addresses.get(acquirer.getBankCode());
//
//				// get issuers
//				List<MemberEntity> issuers
//						= new MemberServiceDAO().issuingMemberService(subServiceID);
//
//				for (MemberEntity issuer : issuers) {
//
//					if (acquirer.getBankCode() == issuer.getBankCode()) {
//						//spolog(spoLog, "SKIPPING. ISSUER NOT DIFFERENT FROM ACQUIRER : " + issuer.getMemberName());
//						continue;
//					}
//
//					spolog(spoLog, "EXTRACTING DATA FROM : " + issuer.getMemberName());
//
//					// for each card type
//					for (CardTypeEntity cardType : cardTypes ) {
//
//						// file header
//						writeFileHeader(params, header, cardType.getCardDescription(), pageNumber++, out);
//
//						// get acquirer address
//						MemberAddressEntity issuerAddress = addresses.get(issuer.getBankCode());
//						AddressWriter.write(out, issuerAddress, acquirerAddress);
//						header.incrementRecordCount(9);
//
//						// write detail column header
//						CCR001DetailWriter.writeColumnHeader(out);
//						header.incrementRecordCount(4);
//
//						// ccr00x data for issuer / acquirer pair
//						Map<TxnGroup, List<CCR00XDataEntity>> ccr00xData
//								= new CCR00XDataDAO()
//								.ccr00XData(
//										"CARD",
//										subServiceID,
//										issuer.getBankCode(),
//										acquirer.getBankCode(),
//										cardType.getCardType());
//
//						// for each txn group code
//						for (Integer txnGroupCode : txnGroupCodes) {
//
//							TxnGroup txnGroup
//									= new TxnGroup("CARD",
//									subServiceID,
//									issuer.getBankCode(),
//									acquirer.getBankCode(),
//									txnGroupCode);
//
//							List<CCR00XDataEntity> txns = ccr00xData.get(txnGroup);
//
//							// write each txn
//							if (txns == null) {
////								spolog(spoLog, "NO DATA FOR : " + acquirer.getMemberName() +
////										" FROM : " + issuer.getMemberName() +
////										" TXN GROUP : " + txnGroupCode);
//								continue;
//							}
//
//							CCR001DetailWriter.writeTxnDetails(out, txns);
//
//							// write txn group totals
//							CCR001DetailWriter.writeTxnGroupUnderline(out);
//							TxnGroupTotalsDTO txnGroupTotals = txnGroupTotals(txns);
//							CCR001DetailWriter.writeTxnGroupTotals(out, "SUB TOTALS", txnGroupTotals);
//						}
//
//						// write grand totals
//						out.println();
//						CCR001DetailWriter.writeTxnGroupUnderline(out);
//						TxnGroupTotalsDTO grandTotals = grandTotals(ccr00xData.values());
//						CCR001DetailWriter.writeTxnGroupTotals(out, "GRAND TOTALS", grandTotals);
//					}
//
//					// totals for this issuer, acquirer pair
//					ccr001SummaryPageWriter.write(out, header, subServiceID, issuer.getBankCode(),
//							issuer.getBankCode(), addresses.get(issuer.getBankCode()),
//							addresses.get(acquirer.getBankCode()), processDate, spoLog,
//							pageNumber++ );
//				}
//
//				// final totals for this acquirer
//				ccr001FinalTotalsPageWriter.write(out, header, subServiceID, acquirer.getBankCode(),
//						addresses.get(acquirer.getBankCode()), ccr00xData, spoLog, pageNumber++, REPORT_ID);
//
//				// file trailer
//				writeControlTrailer(header, out);
//
//			} catch (FileNotFoundException e) {
//				// TODO implement handler
//				e.printStackTrace();
//			} finally {
//				spolog(spoLog, "CLOSING FILENAME: " + filename);
//				try {out.flush();} catch (Exception e){}
//				try {out.close();} catch (Exception e){}
//			}
//		}
//	}
//
//	private TxnGroupTotalsDTO txnGroupTotals(List<CCR00XDataEntity> txns) {
//		TxnGroupTotalsDTO totals = new TxnGroupTotalsDTO();
//		for (CCR00XDataEntity txn : txns) {
//			totals.addVolume(txn.getVolume());
//			totals.addTranValue(txn.getTranValue());
//			totals.addBillingFee(txn.getBillingFee());
//			totals.addBillingFeeAmount(txn.getBillingFeeAmount());
//			totals.addBillingVAT(txn.getBillingVAT());
//		}
//
//		return totals;
//	}
//
//	private TxnGroupTotalsDTO grandTotals(Collection<List<CCR00XDataEntity>> ccr00xData) {
//
//		TxnGroupTotalsDTO totals = new TxnGroupTotalsDTO();
//		for (List<CCR00XDataEntity> txns : ccr00xData) {
//			for (CCR00XDataEntity txn : txns) {
//				totals.addVolume(txn.getVolume());
//				totals.addTranValue(txn.getTranValue());
//				totals.addBillingFee(txn.getBillingFee());
//				totals.addBillingFeeAmount(txn.getBillingFeeAmount());
//				totals.addBillingVAT(txn.getBillingVAT());
//			}
//		}
//
//		return totals;
//	}
//
//	public static void spolog(SPOLogger spoLog, String message) {
//
//		// spoLog.log(PROCESS_NAME, VERSION, message);
//		System.out.println(PROCESS_NAME + " " + VERSION + " " + message);
//	}
//}
