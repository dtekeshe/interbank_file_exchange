package com.bsva.dmcs.reportv02.settlement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.bsva.commonsv02.util.SPOLogger;
import com.bsva.dao.AbstractDao;
import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dao.v02.members.CSS_CCR009_VIEW_DAO;
import com.bsva.dcms.commons.dao.CSFMembersServiceDAO;
import com.bsva.dcms.commons.dao.CsfCompanyParametersDAO;
import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.dto.CsfCompanyParametersDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dmcs.reportv02.dto.CCR009GrandTotalsDto;
import com.bsva.dmcs.reportv02.dto.CCR009SubTotals;
import com.bsva.dmcs.reportv02.dto.CCR009TrxnDetailsDto;
import com.bsva.dmcs.reportv02.dto.FileFooter009Dto;
import com.bsva.dmcs.reportv02.dto.FileFooterDto;
import com.bsva.dmcs.reportv02.dto.FileHeaderDto;
import com.bsva.dmcs.reportv02.dto.FileReportDetails;
import com.bsva.dmcs.reportv02.dto.FileReportDetailsAddress;
import com.bsva.dmcs.reportv02.dto.FileSubAddressDto;
import com.bsva.dmcs.reportv02.dto.FileTrxnDetails;
import com.bsva.entities.CsfCompanyParameters;
import com.bsva.entities.CssCcr009View;
import com.bsva.entities.Css_Stats_View;
import com.bsva.entities.CsvCcr002View;
import com.bsva.entities.v02.params.CompanyParametersEntity;

public class CCR009Reports {

	/*
	 * This class is used for only fleet reporting It Reports on the transaction codes used with the fleet card ,the
	 * count and the amount used
	 */
	private final static String FILE_SEPARATOR = System.getProperty("file.separator");

	protected final static Map<String, String> SUB_SERVICE_MNEMONICS;
	static {
		SUB_SERVICE_MNEMONICS = new HashMap<>();
		SUB_SERVICE_MNEMONICS.put("VISA CARD", "V");
		SUB_SERVICE_MNEMONICS.put("MASTERCARD", "M");
		SUB_SERVICE_MNEMONICS.put("DINERS", "D");
		SUB_SERVICE_MNEMONICS.put("AMEX", "A");
		SUB_SERVICE_MNEMONICS.put("FLEET CARD", "F");
	}

	private final static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("HHmmssSSS");

	private static String reportId = "009";

	private final static SPOLogger SPO_LOGGER;

	private final static String REPORT_FOLDER;

	private final static String SEND_FOLDER;

	private final CompanyParametersEntity params = null;

	private static BufferedWriter bw;

	private static List<Double> doubleList = new ArrayList<>();

	private static BigDecimal addDoubleGrandTotalsCount = new BigDecimal(0);

	private static BigDecimal addDoubleSubTotalsAmountt = new BigDecimal(0);

	private boolean header = true;

	private boolean footer = true;

	private boolean fileDirectory = true;

	private static String filename = null;

	private static String subMenu1 = null;

	private static String subMenu2 = null;

	private static String subMenu3 = null;

	private static String subMenu4 = null;

	private static String issuerCodeFooter = null;

	private static int subCounter = 0;

	private static int grandCounter = 0;

	private static int footerCounter = 30;

	static {

		Map<String, String> paths = new DirectoryDAO().directories();
		SPO_LOGGER = new SPOLogger(paths.get("SPOLOG"));
		REPORT_FOLDER = paths.get("REPORTS");
		SEND_FOLDER = paths.get("SEND");
	}

	public static void main(String[] args) throws DAOException {
		new CCR009Reports().writeReports("FLEET CARD");
	}

	public Map<String, String> filterListData(List<CssCcr009View> listData) {

		Map<String, String> dataset = new HashMap<String, String>();
		for (CssCcr009View css_Stats_View : listData) {
			dataset.put(css_Stats_View.getCssCcr009View_Pk().getAcqquirer(),
					css_Stats_View.getCssCcr009View_Pk().getIssuer());
		}
		Collection<String> list = dataset.values();
		for (Iterator<String> itr = list.iterator(); itr.hasNext();) {
			if (Collections.frequency(list, itr.next()) > 1) {
				itr.remove();
			}
		}
		return dataset;
	}

	@SuppressWarnings("unused")
	public void writeReports(String subServices) throws DAOException {
		if (subServices.equals("FLEET CARD")) {
			FileFooter009Dto fileFooterDto = new FileFooter009Dto();
			FileSubAddressDto fileSubAddressDto = new FileSubAddressDto();
			CCR009SubTotals ccr009SubTotals = new CCR009SubTotals();
			CCR009GrandTotalsDto ccr009GrandTotalsDto = new CCR009GrandTotalsDto();
			FileReportDetailsAddress fileReportDetails = new FileReportDetailsAddress();
			try {
				Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();
				CsfCompanyParametersDTO csfCompany = new CsfCompanyParametersDAO().retrieve(null);
				String procDate = processDate.toString();

				String trimString = procDate.trim();
				// fetching Data from the view reports
				List<CssCcr009View> listData = new CSS_CCR009_VIEW_DAO().getCSS009Reports();
				Map<String, String> datasetList = filterListData(listData);

				// for (CssCcr009View cssCcr009View : listData) {
				for (Entry<String, String> cssCcr009View2 : datasetList.entrySet()) {

					Integer issuerCode = Integer.valueOf(cssCcr009View2.getValue());
					Integer acqCode = Integer.valueOf(cssCcr009View2.getKey());

					List<CssCcr009View> listData2 = new CSS_CCR009_VIEW_DAO().getCSS009Reports(issuerCode, acqCode);
					for (CssCcr009View cssCcr009View : listData2) {
						try {
							// Getting the memberServices using the IssuerCode
							CSFMemberServiceDTO codeDetailsIssuer = getMemberNo(
									Integer.valueOf(cssCcr009View.getCssCcr009View_Pk().getIssuer()), subServices);
							CSFMemberServiceDTO codeDetailsAcquirer = getMemberNo(
									Integer.valueOf(cssCcr009View.getCssCcr009View_Pk().getAcqquirer()), subServices);

							if (fileDirectory) {
								// create output file
								filename = ccr00xFilename(subServices,
										Integer.valueOf(codeDetailsIssuer.getMemberNo()));
								String filepath = ccr00xFilepath(filename);
								bw = new BufferedWriter(new FileWriter(filepath));

								// control header
								subMenu1 = "BANKSERV         CCR009"
										// + SUB_SERVICE_MNEMONICS.get(subServices)
										+ "  :                    SOUTH AFRICAN BANKERS SERVICES COMPANY LIMITED             "
										+ processDate.toString().substring(0, 8).replace("-", "") + "    PAGE:-     1";
								subMenu2 = "                                                      REG.NO.  "
										+ csfCompany.getRegistrationNumber() + "";
								subMenu3 = "                                            F L E E T  C A R D  B Y  P R O D U C T  T Y P E   R E P O R T   ";
								subMenu4 = "                                         ---------------------------------------------------------------------";
								fileDirectory = false;
							}

							if (header) {
								// assigning value to the header
								FileHeaderDto headerFile = new FileHeaderDto();
								headerFile.setRecordId("01");
								headerFile.setOutputDate(processDate.toString().replace("-", ""));
								headerFile.setService("CARD");
								headerFile.setSubService("REPORTS");
								// headerFile.setBankMemberNumber("");
								headerFile.setBankMemberNumber(padLeftString(String.valueOf(issuerCode), 4));
								issuerCodeFooter = padLeftString(String.valueOf(issuerCode), 4);
								headerFile.setOriginator("ACBJ");
								headerFile.setFileName(filename.substring(0, 7));
								headerFile.setDataType("DATA");
								headerFile.setDataDirection("OUT");
								headerFile.setSettlementDate(processDate.toString().replace("-", ""));
								headerFile.setTestLiveInd("LIVE");
								headerFile.setNumber("01320");
								headerFile.setBankCode(padLeftString(String.valueOf(issuerCode), 3));
								headerFile.setReportName("CCR009");
								headerFile.setMmnemonic(SUB_SERVICE_MNEMONICS.get(subServices));
								// writing file header to the file
								bw.write(headerFile.toString());
								bw.flush();

								// Report Details Address start
								// Assigning Values to the report Details

								fileReportDetails.setToAddressLine0("TO :-  " + codeDetailsIssuer.getContactName());
								fileReportDetails.setToAddressLine1(codeDetailsIssuer.getMemberAddress1());
								fileReportDetails.setToAddressLine2(codeDetailsIssuer.getMemberAddress2());
								fileReportDetails.setToAddressLine3(codeDetailsIssuer.getMemberAddress3());
								fileReportDetails.setToAddressLine4(codeDetailsIssuer.getMemberAddress4());
								fileReportDetails.setToAddressVat("VAT REG NO." + codeDetailsIssuer.getVatRegNumber());

								fileReportDetails
										.setFromAddressLine0("From :-  " + codeDetailsAcquirer.getContactName());
								fileReportDetails.setFromAddressLine1(codeDetailsAcquirer.getMemberAddress1());
								fileReportDetails.setFromAddressLine2(codeDetailsAcquirer.getMemberAddress2());
								fileReportDetails.setFromAddressLine3(codeDetailsAcquirer.getMemberAddress3());
								fileReportDetails.setFromAddressLine4(codeDetailsAcquirer.getMemberAddress4());
								fileReportDetails
										.setFromAddressVat("VAT REG NO." + codeDetailsAcquirer.getVatRegNumber());
								// end of Report Details Address

								fileSubAddressDto.setTrxnCodeHeader("TRANS CODE");
								fileSubAddressDto.setTrxnCountHeader("COUNT");
								fileSubAddressDto.setTrxnAmountHeader("AMOUNT");

								bw.newLine();
								bw.newLine();
								bw.write(subMenu1);
								bw.newLine();
								bw.newLine();
								bw.write(subMenu2);
								bw.newLine();
								bw.newLine();
								bw.write(subMenu3);
								bw.newLine();
								bw.newLine();
								bw.write(subMenu4);
								bw.newLine();
								bw.newLine();
								bw.write(fileReportDetails.toString());
								bw.newLine();
								bw.write(fileSubAddressDto.toString());

								header = false;
							}

							// Start of Trxn Details
							CCR009TrxnDetailsDto ccr009TrxnDetailsDto = new CCR009TrxnDetailsDto();
							// ccr009TrxnDetailsDto.setTrxnDescriptionHeader("");
							// ccr009TrxnDetailsDto.setTrxnCodeHeader("TRANS CODE");
							// ccr009TrxnDetailsDto.setTrxnCountHeader("COUNT");
							// ccr009TrxnDetailsDto.setTrxnAmountHeader("AMOUNT");

							ccr009TrxnDetailsDto.setTrxnDescription(cssCcr009View.getCssCcr009View_Pk().getTxDesc());
							ccr009TrxnDetailsDto.setTrxnCode(cssCcr009View.getCssCcr009View_Pk().getTransactionCode());
							ccr009TrxnDetailsDto.setTrxnCount(cssCcr009View.getVolume());
							ccr009TrxnDetailsDto.setTrxnAmount(cssCcr009View.getValue());
							subCounter += Integer.valueOf(cssCcr009View.getVolume());
							grandCounter += Integer.valueOf(cssCcr009View.getVolume());
							footerCounter = 1 + footerCounter;
							BigDecimal bdAmount = new BigDecimal(new Double(cssCcr009View.getValue()));
							addDoubleSubTotalsAmountt = addDoubleSubTotalsAmountt.add(bdAmount).setScale(2,
									RoundingMode.HALF_UP);
							addDoubleGrandTotalsCount = addDoubleGrandTotalsCount.add(bdAmount).setScale(2,
									RoundingMode.HALF_UP);

							// ccr009TrxnDetailsDto.setUnderLine("-----------------------");
							// ccr009TrxnDetailsDto.setSubTotals("SUB TOTALS");
							// ccr009TrxnDetailsDto.setSubTotalsCount("");//subTotal Count
							// ccr009TrxnDetailsDto.setSubTotalsAmount("");// subTotalsAmount
							// ccr009TrxnDetailsDto.setGrandTotals("GRAND TOTALS");
							// ccr009TrxnDetailsDto.setGrandTotalsCount("");//
							// ccr009TrxnDetailsDto.setGrandTotalsAmount(grandTotalsAmount);//
							// end of Trxn Details

							// wrapping fileWriter to bufferededWriter

							// bw.newLine();
							bw.write(ccr009TrxnDetailsDto.toString());

						}
						catch (Exception ex) {
							ex.getMessage();
						}
					}
					ccr009SubTotals.setSubTotalsText("SUB TOTALS ");
					ccr009SubTotals.setTopUnderLine("===================");
					ccr009SubTotals.setSubTotalsCount(String.valueOf(subCounter));
					ccr009SubTotals.setSubTotals(String.valueOf(addDoubleSubTotalsAmountt));
					ccr009SubTotals.setDounUnderLine("===================");
					bw.write(ccr009SubTotals.toString());
				}
				// Grand Totals will be hereccr009SubTotals.setSubTotalsText("SUB TOTALS ");
				ccr009GrandTotalsDto.setGrandTotalsText("GRAND TOTALS ");
				ccr009GrandTotalsDto.setTopUnderLine("===================");
				ccr009GrandTotalsDto.setGrandTotalsCount(String.valueOf(grandCounter));
				ccr009GrandTotalsDto.setGrandTotals(String.valueOf(addDoubleGrandTotalsCount));
				ccr009GrandTotalsDto.setDounUnderLine("===================");

				bw.write(ccr009GrandTotalsDto.toString());
				addDoubleSubTotalsAmountt = BigDecimal.ZERO;
				addDoubleGrandTotalsCount = BigDecimal.ZERO;

				if (footer) {
					// Assigning Values to the footer

					fileFooterDto.setRecordId("99");
					fileFooterDto.setOutputDate(processDate.toString().replace("-", ""));
					fileFooterDto.setService("CARD");
					fileFooterDto.setSubService("REPORTS");
					fileFooterDto.setServiceCode(padLeftString(String.valueOf(issuerCodeFooter), 4));
					fileFooterDto.setCounterNumber(String.valueOf(footerCounter));
					fileFooterDto.setPadzeroOne("0");
					fileFooterDto.setPaddAllEmpty("");
					fileFooterDto.setPadAllZero("0");
					// end of the footer writer

					footer = false;

				}

			}
			catch (Exception ex) {
				ex.getMessage();
			}
			finally {
				try {
					bw.write(fileFooterDto.toString() + "\n");
					bw.flush();
					issuerCodeFooter = null;
					footerCounter = 0;
					if (bw != null) {

						bw.close();
					}
				}
				catch (Exception ex) {
					ex.getMessage();
				}

			}

		}

	}

	private static Double abs(Double value) {
		return Math.abs(value);
	}

	private static String sign(Double value) {
		return value < 0.0 ? "-" : " ";
	}

	public static BigDecimal initializeToZero(BigDecimal bigDec) {

		BigDecimal bigDecimal = BigDecimal.ZERO;
		if (bigDec.compareTo(bigDecimal) > 0) {
			bigDec = bigDecimal;
		}
		return bigDecimal;
	}

	public static int sumCounter(List<FileTrxnDetails> listString) {

		return listString.size() + 30;

	}

	// Used to test Locally
	/*
	 * public static void main(String[] args) { CCR002reports.write("FLEET CARD"); }
	 */

	public static String ccr00xFilepath(String filename) {
		return REPORT_FOLDER + FILE_SEPARATOR + filename;
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

	/**
	 * @param s
	 * @param n
	 * @return
	 */
	// used to format String for FileWriter
	public static String padRightString(String s, int n) {
		return String.format("%0$" + n + "s", s).replace(' ', '0');
	}

	/**
	 * @param bankCode
	 * @return full member Number
	 */
	// fetching the bank information based on the bankCode
	private static CSFMemberServiceDTO getMemberNo(int bankCode, String subservices) {

		CSFMemberServiceDTO parmObject = new CSFMemberServiceDTO();
		parmObject.setBankCode(bankCode);
		parmObject.setSubService(subservices);
		CSFMemberServiceDTO returnedObject = null;

		try {
			returnedObject = new CSFMembersServiceDAO().retrieve(parmObject);

		}
		catch (DAOException e) {
			e.printStackTrace();
		}

		if (returnedObject != null) {

			return returnedObject;

		}
		return null;
	}

	public static String ccr00xFilename(String subServiceID, Integer issuerMemberCode) {
		return "CCR" + reportId + SUB_SERVICE_MNEMONICS.get(subServiceID) + "." + TIMESTAMP_FORMAT.format(new Date())
				+ "." + issuerMemberCode;
	}
}
