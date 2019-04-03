package com.bsva.dmcs.reportv02.settlement;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dao.v02.members.CssStatsViewDAO;
import com.bsva.dao.v02.members.Css_Stats_View_DAO;
import com.bsva.dcms.commons.dao.CSFMembersServiceDAO;
import com.bsva.dcms.commons.dao.CsfDeliveryServicesDAO;
import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dmcs.reportv02.dto.CCR014ReportsDto;
import com.bsva.dmcs.reportv02.dto.CsvSubHeaderDto;
import com.bsva.dmcs.reportv02.dto.FileFooterDto;
import com.bsva.dmcs.reportv02.dto.FileHeaderDto;
import com.bsva.entities.Css_Stats_View;

public class CCR017Reports {
	
	private static Logger log = Logger.getLogger(CCR15Reports.class);
	private final static String FILE_SEPARATOR = System.getProperty("file.separator");
	private final static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("HHmmssSSS");
	private static String reportId = "017";
	private static final String NEW_LINE_SEPARATOR = "\n";
	protected final static Map<String, String> SUB_SERVICE_MNEMONICS;
	private final static String REPORT_FOLDER;
	private String filename = null;
	private static int numberCount = 1;
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

	public Set<Integer> filterListData(List<Css_Stats_View> listData) {

		Set<Integer> dataset = new HashSet<>();
		for (Css_Stats_View css_Stats_View : listData) {
			dataset.add(Integer.valueOf(css_Stats_View.getCss_Stats_View_PK().getIssuingMember()));
		}
		return dataset;
	}

	public void writeCsvFile(String subService) {
		Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();
		String procdate = processDate.toString().substring(0, 8).replace("-", "");
		String procDateHeader = processDate.toString().substring(0, 10).replace("-", "");
		FileWriter fileWriter = null;
		// Map<Integer,Css_Stats_View> dtoList = new
		// Css_Stats_View_DAO().getCSS0014Reports(subService);
		List<Css_Stats_View> listData = new CssStatsViewDAO().getCSS0017Reports(subService);
		Set<Integer> datasetList = filterListData(listData);
		for (Integer issuingMember : datasetList) {
			try {

				CSFMemberServiceDTO codeDetails = getMemberNo(Integer.valueOf(issuingMember), subService);
				if (codeDetails == null) {
					continue;
				}
				CsfDeliveryServicesDTO csfDeliveryServicesDTO = new CsfDeliveryServicesDTO();
				csfDeliveryServicesDTO.setFilenamePrefix("C9");
				CsfDeliveryServicesDTO deliveryServices = new CsfDeliveryServicesDAO().retrieve(csfDeliveryServicesDTO);

				// create output file
				filename = ccr00xFilename(subService, Integer.valueOf(codeDetails.getMemberNo()));
				String filepath = ccr00xFilepath(filename);
				fileWriter = new FileWriter(filepath);
				// writing File Header
				FileHeaderDto header = new FileHeaderDto();
				header.setRecordId("01");
				header.setOutputDate(procDateHeader);
				header.setService("CARD");
				String filename = deliveryServices.getFilenamePrefix() + codeDetails.getMemberTapeid()
						+ padLeftString("" + numberCount, 3) + "D";
				if (deliveryServices != null) {
					header.setSubService(deliveryServices.getSubService());
				}
				header.setBankMemberNumber(padLeftString(String.valueOf(issuingMember), 4));
				header.setOriginator("ACBJ");
				header.setFileName(filename);
				header.setDataType("DATA");
				header.setDataDirection("OUT");
				header.setSettlementDate(procDateHeader);
				header.setTestLiveInd("LIVE");
				header.setNumber("01320");
				header.setBankCode(padLeftString(String.valueOf(issuingMember), 3));
				header.setReportName("CCR014");
				header.setMmnemonic(SUB_SERVICE_MNEMONICS.get(subService));

				fileWriter.write(header.toString());

				// Writing File SubHeader
				CsvSubHeaderDto subHeader = new CsvSubHeaderDto();
				subHeader.setAcquiringMember("Acquiring Member");
				subHeader.setCardDescription("Card Description");
				subHeader.setInterchangeAmount("Interchange amount");
				subHeader.setInterchangeCost("Interchange Cost");
				subHeader.setInterchangeRate("Interchange rate");
				subHeader.setInterchangeRateDesignator("Interchange Rate Designator");
				subHeader.setIssuerBin("Issuer Bin");
				subHeader.setIssuingMember("Issuing Member");
				subHeader.setMerchantCategoryCode("Merchant Category Code");
				subHeader.setTransaction_Volume("Transaction_volume");
				subHeader.setTransactionDescription("Transaction Description");
				subHeader.setTransactionValue("Transaction value");

				fileWriter.write(subHeader.toString());
				int numCount = 3;

				// Writing the File Lines
				for (Css_Stats_View css_Stats_View : listData) {
					CCR014ReportsDto ccr014ReportsDto = new CCR014ReportsDto();

					ccr014ReportsDto.setAcquiringMember(String.valueOf(css_Stats_View.getCss_Stats_View_PK()
							.getAcquiringMemberName()));
					ccr014ReportsDto.setCardDescription(css_Stats_View.getCss_Stats_View_PK().getCardDescription());
					ccr014ReportsDto.setInterchangeRateDesignator(String.valueOf(css_Stats_View
							.getInterchangeRateDesignator()));
					ccr014ReportsDto.setIssuerBin(css_Stats_View.getCss_Stats_View_PK().getIssuerBin());
					ccr014ReportsDto.setIssuingMember(String.valueOf(css_Stats_View.getCss_Stats_View_PK()
							.getIssuingMemberName()));
					ccr014ReportsDto.setItemCharge(String
							.valueOf(css_Stats_View.getCss_Stats_View_PK().getItemCharge()));
					ccr014ReportsDto.setItemChargeAmount(String.valueOf(css_Stats_View.getCss_Stats_View_PK()
							.getItemChargeAmount()));
					ccr014ReportsDto.setMerchantCatCode(css_Stats_View.getMerchantCatCode());
					ccr014ReportsDto.setTotalAmount(String.valueOf(css_Stats_View.getTotalAmount()));
					ccr014ReportsDto.setTotalCost(String.valueOf(css_Stats_View.getTotalCost()));
					ccr014ReportsDto.setTotalCount(String.valueOf(css_Stats_View.getTotalCount()));
					ccr014ReportsDto.setTransactionDescription(css_Stats_View.getTransactionDescription());
					fileWriter.write(ccr014ReportsDto.toString());
					numCount += 1;
				}
				// Writing the File Footer
				FileFooterDto fileFooterDto = new FileFooterDto();
				fileFooterDto.setCounterNumber(padLeftString(String.valueOf(numCount), 6));
				fileFooterDto.setOutputDate(procDateHeader);
				fileFooterDto.setServiceCode(String.valueOf(issuingMember));
				fileFooterDto.setPadAllZero("");
				fileFooterDto.setPaddAllEmpty("");
				fileFooterDto.setPadzeroOne("");
				fileFooterDto.setRecordId("99");
				fileFooterDto.setService(deliveryServices.getService());
				fileFooterDto.setSubService(deliveryServices.getSubService());
				fileWriter.write(fileFooterDto.toString()+"\n");

			} catch (Exception e) {
				log.debug(e.getMessage());
			} finally {
				try {
					fileWriter.flush();
					fileWriter.close();
				} catch (IOException e) {
				}
			}
		}
	}

	public static int incrementNum(int num) {
		int number = 0;
		if (num == 100) {
			number = 0;
		}
		numberCount += num;

		return number;
	}

	public static String ccr00xFilename(String subServiceID, Integer issuerMemberCode) {
		return "CCR" + reportId + SUB_SERVICE_MNEMONICS.get(subServiceID) + "." + TIMESTAMP_FORMAT.format(new Date())
				+ ".csv" + "." + issuerMemberCode;
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

		} catch (DAOException e) {
			e.printStackTrace();
		}

		if (returnedObject != null) {

			return returnedObject;

		}
		return null;
	}

	public static String ccr00xFilepath(String filename) {
		return REPORT_FOLDER + FILE_SEPARATOR + filename;
	}

	public static void main(String[] args) {
		new CCR017Reports().writeCsvFile("FLEET CARD");
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
