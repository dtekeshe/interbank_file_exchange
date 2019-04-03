package com.bsva.dmcs.reportv02.settlement;

import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dao.v02.startofday.MonthEndDTO;
import com.bsva.dmcs.reportv02.dto.MontEndTotHeaderDTO;
import com.bsva.dmcs.reportv02.dto.MonthEndReportDTO;
import com.bsva.entities.v02.endofday.MisMoTot_DAO;

public class MonthEndReports {

	private static SimpleDateFormat dft = new SimpleDateFormat("YYYY-MM-dd");

	private final static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("HHmmssSSS");

	private static Logger log = Logger.getLogger(CCR15Reports.class);

	private final static String FILE_SEPARATOR = System.getProperty("file.separator");

	private static final String NEW_LINE_SEPARATOR = "\n";

	protected final static Map<String, String> SUB_SERVICE_MNEMONICS;

	private final static String REPORT_FOLDER;

	private String filename = null;

	private FileWriter fileWriter = null;
	// private static private BigInteger countNum = BigInteger.ONE;
	static {
		SUB_SERVICE_MNEMONICS = new HashMap<>();
		SUB_SERVICE_MNEMONICS.put("VISA CARD", "V");
		SUB_SERVICE_MNEMONICS.put("MASTERCARD", "M");
		SUB_SERVICE_MNEMONICS.put("DINERS", "D");
		SUB_SERVICE_MNEMONICS.put("AMEX", "A");
		SUB_SERVICE_MNEMONICS.put("FLEET CARD", "F");
	}
	static {

		Map<String, String> paths = new DirectoryDAO().directories();
		REPORT_FOLDER = paths.get("REPORTS");
	}

	public static void main(String[] args) {

		// writeReports();
		Format formatter = new SimpleDateFormat("MMMMM");
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 04, 04);
		cal.add(Calendar.APRIL, -1);
		String s = formatter.format(cal.getTime());
		System.out.println(s.toUpperCase());
	}

	@SuppressWarnings("resource")
	public void writeReports() throws IOException {
		Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();
		String formatDate = dft.format(processDate);
		String checkMonthEnd = formatDate.substring(0, 7).replace("-", "");
		String lastday = padLeftString(String.valueOf(checkMonthEnd.substring(4)),2);
		Calendar calendar = Calendar.getInstance();
		int intLastDay = Integer.valueOf(lastday).intValue();
		int lastDate = calendar.getActualMaximum(Calendar.DATE);
		//if (lastDate == intLastDay) {
			try {

				Format formatter = new SimpleDateFormat("MMMMMM");
				Calendar cal = Calendar.getInstance();
				cal.set(2018, 04, 04);
				cal.add(Calendar.APRIL, -1);
				String sdATE = formatter.format(cal.getTime());
				// create output file
				filename = ccr00xFilename();
				String filepath = ccr00xFilepath(filename);
				fileWriter = new FileWriter(filepath);
				// String sDate = formatter.format(new Date());
				String monthEnd = formatDate.substring(0, 7).replace("-", "");

				MontEndTotHeaderDTO montEndTotHeaderDTO = new MontEndTotHeaderDTO();
				montEndTotHeaderDTO.setMonth("Month");
				montEndTotHeaderDTO.setProduct("Product");
				montEndTotHeaderDTO.setMnemonicMemberName("Member name");
				montEndTotHeaderDTO.setSubService("Sub Service");
				montEndTotHeaderDTO.setCardDescription("Card Type");
				montEndTotHeaderDTO.setVolumeBelow("Volume Below");
				montEndTotHeaderDTO.setValueBelow("Value Below");
				montEndTotHeaderDTO.setVolumeAbove("Volume Above");
				montEndTotHeaderDTO.setValueAbove("Value Above");
				montEndTotHeaderDTO.setTieredItemChargeBelow("Bankserv Revenue Below");
				montEndTotHeaderDTO.setTieredItemChargeAbove("Bankserv Revenue Above");
				montEndTotHeaderDTO.setTotalCharge("Bankserv Revenue Total");
				montEndTotHeaderDTO.setPriceBelow("Tier price Below");
				montEndTotHeaderDTO.setPriceAbove("Tier price Above");
				fileWriter.write(montEndTotHeaderDTO.toString());

				List<MonthEndDTO> misMoTot_DAO = new MisMoTot_DAO().getMonthEndTotal(monthEnd);

				for (MonthEndDTO monthEndDTO : misMoTot_DAO) {
					MonthEndReportDTO monthEndDTOdata = new MonthEndReportDTO();
					monthEndDTOdata.setCardDescription(monthEndDTO.getCardDescription());
					monthEndDTOdata.setChargeAbove(monthEndDTO.getChargeAbove());
					monthEndDTOdata.setChargeBelow(monthEndDTO.getChargeBelow());
					monthEndDTOdata.setMnemonicMemberName(monthEndDTO.getMnemonicMemberName());
					monthEndDTOdata.setMonth(monthEndDTO.getMonth());
					monthEndDTOdata.setProduct(monthEndDTO.getProduct());
					monthEndDTOdata.setSubService(monthEndDTO.getSubService());
					monthEndDTOdata.setTieredItemChargeAbove(monthEndDTO.getTieredItemChargeAbove());
					monthEndDTOdata.setTieredItemChargeBelow(monthEndDTO.getTieredItemChargeBelow());
					monthEndDTOdata.setTotalCharge(monthEndDTO.getTotalCharge());
					monthEndDTOdata.setValueAbove(monthEndDTO.getValueAbove());
					monthEndDTOdata.setValueBelow(monthEndDTO.getValueBelow());
					monthEndDTOdata.setVolumeAbove(monthEndDTO.getVolumeAbove());
					monthEndDTOdata.setVolumeBelow(monthEndDTO.getVolumeBelow());
					fileWriter.write(monthEndDTOdata.toString());
				}
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
			finally {

				if (fileWriter != null) {
					fileWriter.close();
				}
			}
		//}

	}

	public static String ccr00xFilename() {
		return "MISMOTOT" + "." + TIMESTAMP_FORMAT.format(new Date()).substring(0, 6) + ".csv" + "." + "4149";
	}

	public static String ccr00xFilepath(String filename) {
		return REPORT_FOLDER + FILE_SEPARATOR + filename;
	}

	/**
	 * @param s
	 * @param n
	 * @return
	 */
	public static String padRight(String s, int n) {
		return String.format("%1$" + n + "s", s);
	}

	/**
	 * @param str
	 * @param num
	 * @return
	 */
	public static String rightPadding(String str, int num) {
		return String.format("%1$-" + num + "s", str);
	}

	/**
	 * @param str
	 * @param num
	 * @return
	 */
	public static String leftPadZeros(String str, int num) {
		return String.format("%1$" + num + "s", str).replace(' ', '0');
	}

	/**
	 * @param str
	 * @param num
	 * @return
	 */
	public static String rightPadZeros(String str, int num) {
		return String.format("%1$-" + num + "s", str).replace(' ', '0');
	}

	/**
	 * @param s
	 * @param n
	 * @return
	 */
	// used to format String for FileWriter
	public static String padLeftString(String s, int n) {
		return String.format("%0$" + n + "s", s).replace(' ', '0');
	}

}
