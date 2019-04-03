package com.bsva.dmcs.reportv02.settlement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dao.v02.settlement.CSRRATE_DAO;
import com.bsva.entities.v02.settlement.CsrRateEntity;

/**
 * @author AugustineA
 *
 */
public class CSRRATEReport {

	private static Logger log = Logger.getLogger(CSRRATEReport.class);

	private final static String reportId = "CSRRATE";

	private final static String REPORT_FOLDER;

	private String filename = null;
	// used to get the report folder path
	static {

		Map<String, String> paths = new DirectoryDAO().directories();
		REPORT_FOLDER = paths.get("REPORTS");
	}

	// used to pull data from the database table
	public static void writeReportFile() {

		// Pull data as it is from the Database table
		List<CsrRateEntity> allCsrData = new CSRRATE_DAO().cardRateView();
		if (allCsrData.isEmpty()) {

		}
		else {
			try {
				// Creating the file name and path.
				String filepath = ccr00xFilename(reportId);
				FileWriter writer = new FileWriter(REPORT_FOLDER + "/" + filepath);

				String header = "\"Sub Service" + "\"," + "\"Transaction Code" + "\"," + "\"Rate Descriptor" + "\","
						+ "\"," + "\"Pos Entry Mode" + "\"," + "\"Chip Card" + "\"," + "\"Terminal Capability" + "\","
						+ "\"Ecommerce Ind" + "\"," + "\"Card Present" + "\"," + "\"Volume" + "\"";
				// writing the file header
				writer.write(header);
				// start a newline
				writer.write(System.lineSeparator());
				// Loop and write all data to the file
				for (CsrRateEntity csrRateEntity : allCsrData) {
					if (csrRateEntity != null) {
						if (csrRateEntity.getSubServices() != null) {
							writer.write("\"" + rightPadding(csrRateEntity.getSubServices(), 10) + "\"" + ",");
						}
						if (csrRateEntity.getId().getTransactionCode() != null) {
							writer.write(
									"\"" + padLeftString(csrRateEntity.getId().getTransactionCode(), 2) + "\"" + ",");
						}
						if (csrRateEntity.getId().getRateDescriptor() != null) {
							writer.write(
									"\"" + rightPadding(csrRateEntity.getId().getRateDescriptor(), 10) + "\"" + ",");
						}
						if (csrRateEntity.getId().getPosEntryMode() != null) {
							writer.write("\"" + rightPadding(csrRateEntity.getId().getPosEntryMode(), 2) + "\"" + ",");
						}
						if (csrRateEntity.getId().getChipCard() != null) {
							writer.write("\"" + padLeft(csrRateEntity.getId().getChipCard(), 1) + "\"" + ",");
						}
						if (csrRateEntity.getId().getTerminalCapability() != null) {
							writer.write("\"" + padLeft(csrRateEntity.getId().getTerminalCapability(), 1) + "\"" + ",");
						}
						if (csrRateEntity.getId().getEcommerceInd() != null) {
							writer.write("\"" + padLeft(csrRateEntity.getId().getEcommerceInd(), 1) + "\"");
						}
						if (csrRateEntity.getId().getCardPresent() != null) {
							writer.write("\"" + padLeft(csrRateEntity.getId().getCardPresent(), 1) + "\"");
						}
						if (csrRateEntity.getId().getVolume() != null) {
							writer.write("\"" + padLeftString(csrRateEntity.getId().getVolume(), 9) + "\"");
						}
						writer.flush();

						writer.write(System.lineSeparator());
					}
				}
				// Close opened file
				writer.close();
			}
			catch (Exception ex) {
				System.out.println("Error Occured with : " + ex.getMessage());
				ex.printStackTrace();
			}
		}

	}

	// Created and used for testing Manually
	public static void main(String[] args) throws IOException {
		writeReportFile();
	}

	// generating fileName
	public static String ccr00xFilename(String fileName) {
		Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();
		String procDateHeader = processDate.toString().substring(0, 10).replace("-", "").replace(" ", "");
		return fileName + "." + procDateHeader + ".csv" + ".4149";
	}

	// System.out.println(String.format("%10s", "01702"));//.replace(' ', '0'));
	public static String padLeftString(String s, int n) {
		return String.format("%0$" + n + "s", s).replace(" ", "0");
	}

	public static String rightPadding(String str, int num) {
		return String.format("%1$-" + num + "s", str);
	}

	public static String padLeft(String s, int n) {
		return String.format("%1$" + n + "s", s);
	}
}
