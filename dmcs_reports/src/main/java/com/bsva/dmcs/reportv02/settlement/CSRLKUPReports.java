package com.bsva.dmcs.reportv02.settlement;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dao.v02.settlement.CsrlkUpEntity_DAO;
import com.bsva.entities.v02.settlement.CsrlkUpEntity;

//fetch the data from CSF_CARD_RATE_LOOKUP
/**
 * @author AugustineA
 *
 */
public class CSRLKUPReports {

	private static Logger log = Logger.getLogger(CSRLKUPReports.class);

	private static String reportId = "CSRLKUP";

	private static final String NEW_LINE_SEPARATOR = "\n";

	private final static String REPORT_FOLDER;

	private String filename = null;

	static {

		Map<String, String> paths = new DirectoryDAO().directories();
		REPORT_FOLDER = paths.get("REPORTS");
	}

	// Used to pull data from the databse table
	public static void writeReportFile() throws IOException {
		// Used to fetch data from the persistence layer
		List<CsrlkUpEntity> allCsrData = new CsrlkUpEntity_DAO().cardTypes();
		if (allCsrData.isEmpty()) {
			
		}else{
			// Used to create fileName
			String filepath = ccr00xFilename(reportId);
			// creating a file with filepath
			FileWriter writer = new FileWriter(REPORT_FOLDER + "/" + filepath);
			String header = "\"Sub Service" + "\"," + "\"Rate Descriptor" + "\"," + "\"Pos Entry Mode" + "\","
					+ "\"Chip Card" + "\"," + "\"Terminal Capability" + "\"," + "\"Ecommerce Ind" + "\","
					+ "\"Card Present" + "\"";
			// Writing Header Data
			writer.write(header);
			writer.write(System.lineSeparator());
			// Loop all data and write to file
			for (CsrlkUpEntity csrlkUpEntity : allCsrData) {
				writer.write("\"" + rightPadding(csrlkUpEntity.getSubService(), 10) + "\"" + ",");
				writer.write("\"" + rightPadding(csrlkUpEntity.getId().getRateDescriptor(), 10) + "\"" + ",");
				writer.write("\"" + padLeft(csrlkUpEntity.getId().getPostEntryMode(), 2) + "\"" + ",");
				writer.write("\"" + padLeft(csrlkUpEntity.getId().getChipCard(), 1) + "\"" + ",");
				writer.write("\"" + padLeft(csrlkUpEntity.getId().getTerminalcapability(), 1) + "\"" + ",");
				writer.write("\"" + padLeft(csrlkUpEntity.getId().getEcommIndicator(), 1) + "\"" + ",");
				writer.write("\"" + padLeft(csrlkUpEntity.getId().getCardPresent(), 1) + "\"");
				writer.flush();
				writer.write(System.lineSeparator());
			}
			// Used to close open file
			writer.close();
		}

	}

	public static void main(String[] args) throws IOException {
		writeReportFile();
	}

	public static String ccr00xFilename(String fileName) {
		Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();
		String procDateHeader = processDate.toString().substring(0, 10).replace("-", "").replace(" ", "");
		return fileName + "." + procDateHeader + ".csv" + ".4149";
	}

	// System.out.println(String.format("%10s", "01702"));//.replace(' ', '0'));
	public static String padLeftString(String s, int n) {
		return String.format("%0$" + n + "s", s);// .replace(" ", "0");
	}

	public static String rightPadding(String str, int num) {
		return String.format("%1$-" + num + "s", str);
	}

	public static String padLeft(String s, int n) {
		return String.format("%1$" + n + "s", s);
	}

}
