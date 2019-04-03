package com.bsva.dmcs.reportv02.settlement;

import com.bsva.commonsv02.util.SPOLogger;
import com.bsva.dao.v02.CompanyParametersDAO;
import com.bsva.dao.v02.SubServiceCardTypesDAO;
import com.bsva.dao.v02.TxnGroupCodesDAO;
import com.bsva.dao.v02.settlement.CCR002DataDAO;
import com.bsva.dmcs.reportv02.commons.AddressWriter;
import com.bsva.dmcs.reportv02.commons.FileWriter;
import com.bsva.dto.*;
import com.bsva.entities.v02.commons.CardTypeEntity;
import com.bsva.entities.v02.members.MemberAddressEntity;
import com.bsva.entities.v02.params.CompanyParametersEntity;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * TODO Document
 */
public class CCR002ReportWriter extends FileWriter {

	private final static String REPORT_ID = "001";
	private final static String LINE_SEPARATOR = System.getProperty("line.separator");

	// Metadata
	private final static String PROCESS_NAME = "SETTLE";
	private final static String VERSION = "20";
	private final Set<Integer> txnGroupCodes;
	private final CompanyParametersEntity params;
	private final List<CardTypeEntity> cardTypes;

	public CCR002ReportWriter(
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

		// get ccr002 data
		Map<IssuerCode, Map<AcquirerCode, StatementDTO>> ccr002Data
				= new CCR002DataDAO().ccr002Data();

		for (IssuerCode issuerCode : ccr002Data.keySet()) {

			// issuer data
			Map<AcquirerCode, StatementDTO> issuerData
					= ccr002Data.get(issuerCode);

			// control header

			// file header

			Integer pageNumber = 1;
			String filename = null;
			PrintWriter out = null;
			try {

				// create output file
				filename = ccr00xFilename(subServiceID, Integer.parseInt(issuerCode.getFullBankCode()));
				spolog(spoLog, LINE_SEPARATOR + "OPENING FILENAME: " + filename + ", TO " + issuerCode.getBankName());
				String filepath = ccr00xFilepath(filename);
				out = new PrintWriter( filepath );

				// control header
				FileHeaderDTO header = defaultFileHeader();
				header.setFileDate(processDate);
				header.setOriginatorID(issuerCode.getIssuerCode());
				header.setReportName("CCR001");
				writeControlHeader(header, out);
				header.incrementRecordCount(1);

				// get issuer address
				MemberAddressEntity issuerAddress = addresses.get(issuerCode.getIssuerCode());
				AddressWriter.write(out, issuerAddress, REPORT_ID);
				header.incrementRecordCount(9);

				// print issuer data
				CCR001DetailWriter.writeTxnDetails(out, issuerData);

				// print file trailer
				CCR001DetailWriter.writeTxnGroupTotals(out, issuerData);

				// file control trailer
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

	public static void spolog(SPOLogger spoLog, String message) {

		// spoLog.log(PROCESS_NAME, VERSION, message);
		System.out.println(PROCESS_NAME + " " + VERSION + " " + message);
	}
}
