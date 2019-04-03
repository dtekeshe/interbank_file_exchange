package com.bsva.dmcs.reportv02.settlement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dao.v02.members.Csf_Card_Types_DAO;
import com.bsva.dao.v02.members.MemberServicesDAO;
import com.bsva.dcms.commons.dao.CSFMembersServiceDAO;
import com.bsva.dcms.commons.dao.CsfDeliveryServicesDAO;
import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dmcs.reportv02.dto.CCR018019ReportsDto;
import com.bsva.dmcs.reportv02.dto.FileFooterDto;
import com.bsva.dmcs.reportv02.dto.FileHeaderDto;
import com.bsva.entities.CSR018019ReportEntity;
import com.bsva.entities.Ccr03031VisaEntity;
import com.bsva.entities.v02.billing.CsfCardTypes_Entity;
import com.bsva.entities.v02.settlement.CSR018019VisaMcard_DAO;

public class CCR018019Reports {
	/*
	 * This reports is for VISA CARD AND MASTERCARD Only
	 */
	private static Logger log = Logger.getLogger(CCR15Reports.class);

	private final static String FILE_SEPARATOR = System.getProperty("file.separator");

	private final static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("HHmmssSSS");

	private static String reportId = "018";

	private static final String NEW_LINE_SEPARATOR = "\n";

	protected final static Map<String, String> SUB_SERVICE_MNEMONICS;

	private final static String REPORT_FOLDER;

	private String filename = null;

	private static BufferedWriter bw;

	private int numberCount = 1;

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

	public Set<Integer> filterListData(List<Ccr03031VisaEntity> listData) {

		Set<Integer> dataset = new HashSet<>();
		for (Ccr03031VisaEntity ccr030Entity : listData) {
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

	@SuppressWarnings("null")
	public void writeCsvFile018(String subService) {
		Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();

		String procDateHeader = processDate.toString().substring(0, 10).replace("-", "");

		List<Integer> bankCodes = new MemberServicesDAO().getbankCode();
		List<Integer> getIntegerCardTypes = new ArrayList<>();
		Set<Integer> integerSet = filterListBankCodes(bankCodes);

		List<CsfCardTypes_Entity> allCard = new Csf_Card_Types_DAO().getAllCardTypes();
		for (CsfCardTypes_Entity csfCardTypes_Entity : allCard) {
			getIntegerCardTypes.add(Integer.valueOf(csfCardTypes_Entity.getCardTypes()));
		}

		for (Integer cardTypes : getIntegerCardTypes) {

			String cardString = "" + cardTypes;
			String cardNumber = padRight(cardString, 2);
			
			for (Integer acquiringMember : integerSet) {
				if (acquiringMember == 39) {
					continue;
				}
				String intString = "" + acquiringMember;
				String number = leftPadZeros(intString, 4);
				List<CSR018019ReportEntity> listData = new CSR018019VisaMcard_DAO().getCCR018019Data(cardNumber, number);//cardType ,acquiringMember
				try {

					CSFMemberServiceDTO codeDetails = getMemberNo(Integer.valueOf(acquiringMember), subService);
					if (codeDetails == null) {
						continue;
					}
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
					header.setReportName("CCR031");
					// header.setMmnemonic(SUB_SERVICE_MNEMONICS.get(subService));

					bw.write(header.toString());

					int numCount = 2;
					String subHeader = "Issuer,Acquirer,Card Type,Transaction Code,Acq BIN,Volume,Value,Nett Interchange,Nett Interchange VAT ";

					// Writing the File Lines
					if (listData != null) {
						bw.write(subHeader );
						bw.newLine();
						numCount += 1;
						// Writing the File Record Lines
						// List<Ccr03031VisaEntity> listData2 = new CCR031VisaReportDAO().getCCR031Data();
						for (CSR018019ReportEntity ccr018019Entity : listData) {
							CCR018019ReportsDto ccr018019Dto = new CCR018019ReportsDto();
							ccr018019Dto.setAcqBin(ccr018019Entity.getAcqBin());
							ccr018019Dto.setAcquirerMember(ccr018019Entity.getAcquirerMember());
							ccr018019Dto.setCardType(ccr018019Entity.getCardType());
							ccr018019Dto.setIssuerMember(ccr018019Entity.getIssuerMember());
							ccr018019Dto.setNettInterChange(ccr018019Entity.getId().getNettInterChange());
							ccr018019Dto.setNettVat(ccr018019Entity.getId().getNettVat());
							ccr018019Dto.setTransactionCode(ccr018019Entity.getTransCode());
							ccr018019Dto.setValue(ccr018019Entity.getId().getValue());
							ccr018019Dto.setVolume(ccr018019Entity.getId().getVolume());
							ccr018019Dto.setReportNumber("018");
							bw.write(ccr018019Dto.toString());
							numCount += 1;
						}
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
				}
				catch (Exception e) {
					log.debug(e.getMessage());
				}
				finally {
					try {
						// check if writer is not null before closing it
						if (bw != null) {
							// Close the writer
							bw.close();
						}
					}
					catch (IOException e) {
					}
				}
			}
		}
	}

	public static String ccr00xFilename(String subServiceID, Integer issuerMemberCode) {
		Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();
		String procDateHeader = processDate.toString().substring(0, 10).replace("-", "").replace(" ", "");
		return "CCR" + reportId + "." + procDateHeader + ".csv" + "."
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

	public static void main(String[] args) {
		new CCR018019Reports().writeCsvFile018("FLEET CARD");
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
