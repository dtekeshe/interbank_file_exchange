package com.bsva.dmcs.reportv02.settlement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dao.v02.members.MemberServicesDAO;
import com.bsva.dao.v02.settlement.CCR031McardReportDAO;
import com.bsva.dcms.commons.dao.CSFMembersServiceDAO;
import com.bsva.dcms.commons.dao.CsfDeliveryServicesDAO;
import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dmcs.reportv02.dto.FileFooterDto;
import com.bsva.dmcs.reportv02.dto.FileHeaderDto;
import com.bsva.entities.Ccr03031McardEntity;

//mastercard ccr030 and CCR031 Reports
public class CCR031McardReports {
	/*
	 * This reports is for VISA CARD AND MASTERCARD Only
	 */
	// private static Logger log = Logger.getLogger(CCR15Reports.class);
	private final static String FILE_SEPARATOR = System.getProperty("file.separator");

	private final static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("HHmmssSSS");

	private static String reportId = "031";

	private static final String NEW_LINE_SEPARATOR = "\n";

	protected final static Map<String, String> SUB_SERVICE_MNEMONICS;

	private final static String REPORT_FOLDER;

	private String filename = null;

	private int numberCount = 1;
	private int numCount = 2;


	private static BufferedWriter bw;
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

	public Set<Integer> filterListData(List<Ccr03031McardEntity> listData) {

		Set<Integer> dataset = new HashSet<>();
		for (Ccr03031McardEntity ccr030Entity : listData) {
			dataset.add(Integer.valueOf(ccr030Entity.getAcquirer()));
		}
		return dataset;
	}

	public Set<Integer> filterListBankCodes(List<Integer> listData) {

		Set<Integer> dataset = new HashSet<>();
		for (Integer ccr030Entity : listData) {
			dataset.add(ccr030Entity);
		}
		return dataset;
	}

	public void writeCsvFile31(String subService) {
		Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();

		String procDateHeader = processDate.toString().substring(0, 10).replace("-", "");

		List<Integer> bankCodes = new MemberServicesDAO().getbankCode();
		Set<Integer> integerSet = filterListBankCodes(bankCodes);
		for (Integer acquiringMember : integerSet) {
			// System.out.println("The Values : " + integer);
			if (acquiringMember == 39) {
				continue;
			}
			String intString = "" + acquiringMember;
			String number = leftPadZeros(intString, 4);
			List<Ccr03031McardEntity> listData = new CCR031McardReportDAO().getCCR03031Data(number,"ACQUIRER");

			/*
			 * if(listData == null){ continue; }
			 */
			// Set<Integer> datasetList = filterListData(listData);
			// for (Integer issuingMember : datasetList) {
			try {

				CSFMemberServiceDTO codeDetails = getMemberNo(Integer.valueOf(acquiringMember), subService);

				CsfDeliveryServicesDTO csfDeliveryServicesDTO = new CsfDeliveryServicesDTO();
				csfDeliveryServicesDTO.setFilenamePrefix("C9");
				CsfDeliveryServicesDTO deliveryServices = new CsfDeliveryServicesDAO().retrieve(csfDeliveryServicesDTO);

				// create output file
				filename = ccr00xFilename(subService, Integer.valueOf(codeDetails.getMemberNo()));
				String filepath = ccr00xFilepath(filename);
				bw = new BufferedWriter(new FileWriter(filepath));
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
				header.setBankMemberNumber(padLeftString(String.valueOf(acquiringMember), 4));
				header.setOriginator("ACBJ");
				header.setFileName(filename);
				header.setDataType("DATA");
				header.setDataDirection("OUT");
				header.setSettlementDate(procDateHeader);
				header.setTestLiveInd("LIVE");
				header.setNumber("01320");
				header.setBankCode(padLeftString(String.valueOf(acquiringMember), 3));
				header.setReportName("CCR030");
				header.setMmnemonic(SUB_SERVICE_MNEMONICS.get(subService));

				bw.write(header.toString());

				String subHeader = "ACQUIRER, ISSUER, CARD TYPE,CARD NUMBER,TRANSACTION CODE,PROCESSING CODE,TRANSACTION DATE,TRANSACTION TIME,BANKSERV"
						+ " REF NO,ACQ REF NO,POS DATA,TERMINAL CAPABILITY,CARD PRESENT,SERVICE CODE,IRD, E-COMMERCE INDICATOR,TRANSACTION AMOUNT,CASHBACK "
						+ " AMOUNT,MERCHANT CATEGORY CODE,SARB RATE DESCRIPTOR,INTERCHANGE FEE,INTERCHANGE PERCENTAGE FEE,INTERCHANGE VAT,CASHBACK INTERCHANGE FEE,"
						+ " CASHBACK INTERCHANGE, CASHBACK INTERCHANGE VAT,TERMINAL TYPE ";

				if (listData == null) {
					// Writing the File Footer
					FileFooterDto fileFooterDto = new FileFooterDto();
					fileFooterDto.setCounterNumber(padLeftString(String.valueOf(numCount), 6));
					fileFooterDto.setOutputDate(procDateHeader);
					fileFooterDto.setServiceCode(String.valueOf(acquiringMember));
					fileFooterDto.setPadAllZero("");
					fileFooterDto.setPaddAllEmpty("");
					fileFooterDto.setPadzeroOne("");
					fileFooterDto.setRecordId("99");
					fileFooterDto.setService(deliveryServices.getService());
					fileFooterDto.setSubService(deliveryServices.getSubService());
					bw.write(fileFooterDto.toString() + "\n");
					bw.flush();
					numberCount++;
					numCount = 2;
				}
				else if (listData.size() > 0) {
					bw.write(subHeader);
					bw.newLine();

					numCount += 1;
					// Writing the File Record Lines
					// List<Ccr03031McardEntity> listData2 = new CCR031McardReportDAO().getCCR03031Data();
					for (Ccr03031McardEntity ccr030Entity : listData) {
						Ccr030And031ReportDto ccr030And031Dto = new Ccr030And031ReportDto();
						if (ccr030Entity.getAcquirer() != null) {
							ccr030And031Dto.setAcquirer(ccr030Entity.getAcquirer());
						}
						if (ccr030Entity.getIssuer() != null) {
							ccr030And031Dto.setIssuer(ccr030Entity.getIssuer());
						}
						if (ccr030Entity.getCardType() != null) {
							ccr030And031Dto.setCardType(ccr030Entity.getCardType());
						}
						if (ccr030Entity.getReportString() != null) {
							ccr030And031Dto.setReportString(ccr030Entity.getReportString());
						}
						
						ccr030And031Dto.setReportName("031");

						bw.write(ccr030And031Dto.toString());
						numCount += 1;
					}
					// Writing the File Footer
					FileFooterDto fileFooterDto = new FileFooterDto();
					fileFooterDto.setCounterNumber(padLeftString(String.valueOf(numCount), 6));
					fileFooterDto.setOutputDate(procDateHeader);
					fileFooterDto.setServiceCode(String.valueOf(acquiringMember));
					fileFooterDto.setPadAllZero("");
					fileFooterDto.setPaddAllEmpty("");
					fileFooterDto.setPadzeroOne("");
					fileFooterDto.setRecordId("99");
					fileFooterDto.setService(deliveryServices.getService());
					fileFooterDto.setSubService(deliveryServices.getSubService());
					bw.write(fileFooterDto.toString() + "\n");
					bw.flush();
					numberCount++;
					numCount = 2;
				}

			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					// check if writer is not null before closing it
					if (bw != null) {
						// close the writer
						bw.close();
					}
				}
				catch (IOException e) {
				}
			}
		}
	}

	public static String ccr00xFilename(String subServiceID, Integer issuerMemberCode) {
		Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();
		String procDateHeader = processDate.toString().substring(0, 10).replace("-", "").replace(" ", "");
		return "CCR" + reportId + SUB_SERVICE_MNEMONICS.get(subServiceID) + "." + procDateHeader + ".csv" + "."
				+ issuerMemberCode;
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
