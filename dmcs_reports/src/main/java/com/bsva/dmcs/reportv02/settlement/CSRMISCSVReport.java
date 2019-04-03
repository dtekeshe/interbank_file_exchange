package com.bsva.dmcs.reportv02.settlement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dao.v02.members.Csf_Card_Types_DAO;
import com.bsva.dao.v02.members.CsrMisEntityDAO;
import com.bsva.dao.v02.members.MembersDAO;
import com.bsva.dcms.commons.dao.CSFMembersServiceDAO;
import com.bsva.dcms.commons.dao.CsfCompanyParametersDAO;
import com.bsva.dcms.commons.dao.CsfPublicHolidaysDAO;
import com.bsva.dcms.commons.dao.CsfSystemSettingsDAO;
import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.dto.CsfCompanyParametersDTO;
import com.bsva.dcms.commons.dto.CsfPublicHolidaysDTO;
import com.bsva.dcms.commons.dto.CsfSystemSettingsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dmcs.reportv02.dto.CSRMISFileTotalsDto;
import com.bsva.dmcs.reportv02.dto.FileCCRMISCSVDetailReportDto;
import com.bsva.dmcs.reportv02.dto.FileCCRMISDetailReport;
import com.bsva.dmcs.reportv02.dto.FileCSRMISSubHeaderDto;
import com.bsva.dmcs.reportv02.dto.PrintAllMnemonicnameDto;
import com.bsva.entities.CsrMisEntity;
import com.bsva.entities.v02.CsfMemberService_DAO;
import com.bsva.entities.v02.billing.CsfCardTypes_Entity;
import com.bsva.entities.v02.billing.MemberServiceEntity;

public class CSRMISCSVReport {

	/*
	 * This reports is for CSV MONTH END Report Only
	 */
	private final static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("HHmmssSSS");

	private static String reportId = "CSRMISCSV";

	private final static String FILE_SEPARATOR = System.getProperty("file.separator");

	private static final String NEW_LINE_SEPARATOR = "\n";

	protected final static Map<String, String> SUB_SERVICE_MNEMONICS;

	private final static String REPORT_FOLDER;

	private static String filename = null;

	private static int numberCount = 1;

	private static BufferedWriter fileWriter = null;

	private static BigDecimal bdVb = BigDecimal.ZERO;

	protected final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###,###,##0.00");

	private static BigDecimal addDoubleVolumeBelow = new BigDecimal(0);

	private static BigDecimal addDoubleValuebelow = new BigDecimal(0);

	private static BigDecimal addDoubleBsvRevenueBelow = new BigDecimal(0);

	private static BigDecimal addDoubleVolumeAbove = new BigDecimal(0);

	private static BigDecimal addDoubleValueAbove = new BigDecimal(0);

	private static BigDecimal addDoubleBsvRevenueAbove = new BigDecimal(0);

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

	public static String ccr00xFilepath(String filename) {
		return REPORT_FOLDER + FILE_SEPARATOR + filename;
	}

	public static void writeCSRMISCSVReport(String subService) throws DAOException, IOException {

		try {
			CsfSystemSettingsDTO csfSystemSettingsDTO = new CsfSystemSettingsDTO();
			csfSystemSettingsDTO.setSettingCode("FILENAME");
			CsfSystemSettingsDTO settingsname = new CsfSystemSettingsDAO().retrieve(csfSystemSettingsDTO);
			String serviceCode = settingsname.getSettingValue();
			// create output file
			filename = ccr00xFilename(subService, serviceCode);
			String filepath = ccr00xFilepath(filename);
			fileWriter = new BufferedWriter(new FileWriter(filepath));

			CsfCompanyParametersDTO csfParametersDTO = new CsfCompanyParametersDAO().retrieve(null);

			Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();
			String processDat = processDate.toString().substring(0, 10);

			SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
			String forMatteddate = df.format(processDate);
			LocalTime dateTime = LocalTime.now();
			int hour = dateTime.getHour();
			int min = dateTime.getMinute();

			List<CsrMisEntity> listData = new CsrMisEntityDAO().getAllData();
			Map<String, String> mapdata = new MembersDAO().memberTieredItem();
			String tieredItem = null;
			for (Map.Entry<String, String> entry : mapdata.entrySet()) {
				tieredItem = entry.getKey();
			}
			// if issuingmember = 9 use 0.0336 as below and 0.0617 as above
			// otherwise use 0.0299 as below and 0.0549 as above
			if (listData != null) {
				for (CsrMisEntity csrMisEntity : listData) {
					MemberServiceEntity members = getBankCode(csrMisEntity.getCsrMisEntity_PK().getIssuingMember());
					String description = getCardType(csrMisEntity.getCsrMisEntity_PK().getCardType());
					FileCCRMISCSVDetailReportDto fileDetailReportDto = new FileCCRMISCSVDetailReportDto();

					fileDetailReportDto.setBankCode(csrMisEntity.getCsrMisEntity_PK().getIssuingMember());
					fileDetailReportDto.setSubService(csrMisEntity.getCsrMisEntity_PK().getServiceCode());
					fileDetailReportDto.setPublicHolidayIndicator(getPublicHoliday(processDate));
					fileDetailReportDto.setProductDateDelimiter(forMatteddate);
					fileDetailReportDto.setDayName(getDayOfWeek(processDat));
					fileDetailReportDto.setVolumeDelimitedSize(csrMisEntity.getVolumeAbove());
					DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###.00");
					fileDetailReportDto
							.setIssValueDelimitedSize(decimalFormat.format(new Double(csrMisEntity.getValueAbove())));
					fileDetailReportDto.setIssTierChargeDelimitedSize(tieredItem);

					BigDecimal bsvRevenue = new BigDecimal(
							new Double(fileDetailReportDto.getIssTierChargeDelimitedSize()).doubleValue()).setScale(4,
									RoundingMode.HALF_UP);
					addDoubleVolumeBelow = addDoubleVolumeBelow.multiply(new BigDecimal(csrMisEntity.getValueAbove()))
							.setScale(2, RoundingMode.HALF_UP);

					fileDetailReportDto.setIssBsvRevenueDelimitedSize(addDoubleVolumeBelow.toString());

					fileWriter.write(fileDetailReportDto.toString());

				}
			}

		}
		catch (Exception ex) {
			ex.getMessage();
		}
		finally {
			if (fileWriter != null) {
				fileWriter.close();
			}
		}

	}

	public static String getPublicHoliday(Date processDate) {
		// check if the day is a holiday
		CsfPublicHolidaysDTO publicHol = new CsfPublicHolidaysDTO();
		Calendar cal3 = Calendar.getInstance();
		cal3.setTime(processDate);
		cal3.add(Calendar.DAY_OF_MONTH, -1);
		publicHol.setProcessDate(cal3.getTime());
		CsfPublicHolidaysDAO publicHolDao = new CsfPublicHolidaysDAO();
		CsfPublicHolidaysDTO csfPublicHolidaysDto;
		try {
			csfPublicHolidaysDto = publicHolDao.retrieve(publicHol);
			if (csfPublicHolidaysDto == null) {
				return "N";
			}
			else {
				return "Y";
			}
		}
		catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getWeekday(Date processDate) {
		// check if the day is a holiday
		CsfPublicHolidaysDTO publicHol = new CsfPublicHolidaysDTO();
		Calendar cal3 = Calendar.getInstance();
		cal3.setTime(processDate);
		cal3.add(Calendar.DAY_OF_WEEK, 0);
		publicHol.setProcessDate(cal3.getTime());

		return null;
	}

	public static String getDayOfWeek(String processDate) {
		return LocalDate.parse(processDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")).getDayOfWeek().name();
	}

	public static void callerMethod(String processDate) {
		System.out.println(getDayOfWeek(processDate));
	}

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

	public static String getCardType(String cardTypes) {

		String cardType = null;

		List<CsfCardTypes_Entity> cardTy = new Csf_Card_Types_DAO().getCardTypes(cardTypes);
		for (CsfCardTypes_Entity csfCardTypes_Entity : cardTy) {
			cardType = csfCardTypes_Entity.getCardDescription();
		}

		return cardType;
	}

	public static void main(String[] args) throws DAOException, IOException {

		// new CSRMISReport.writeCSRMISReport("MASTERCARD");
	}

	public static MemberServiceEntity getBankCode(String bankCode) {

		List<MemberServiceEntity> memberdata = new CsfMemberService_DAO().getMemberTypes(bankCode);
		MemberServiceEntity memberService = new MemberServiceEntity();
		for (MemberServiceEntity memberServiceEntity : memberdata) {

			memberService.setBankCode(memberServiceEntity.getBankCode());
			memberService.setFullBankCode(memberServiceEntity.getFullBankCode());
			memberService.setMaxFileSize(memberServiceEntity.getMaxFileSize());
			memberService.setMemberName(memberServiceEntity.getMemberName());
			memberService.setMemberTapeId(memberServiceEntity.getMemberTapeId());
			memberService.setMnemonicMemberName(memberServiceEntity.getMnemonicMemberName());
			memberService.setMemberNo(memberServiceEntity.getMemberNo());
		}

		return memberService;
	}

	public static MemberServiceEntity getBankMnemonicName() {

		List<MemberServiceEntity> memberdata = new CsfMemberService_DAO().getMemberTypes();
		MemberServiceEntity memberService = new MemberServiceEntity();
		for (MemberServiceEntity memberServiceEntity : memberdata) {

			memberService.setBankCode(memberServiceEntity.getBankCode());
			memberService.setFullBankCode(memberServiceEntity.getFullBankCode());
			memberService.setMaxFileSize(memberServiceEntity.getMaxFileSize());
			memberService.setMemberName(memberServiceEntity.getMemberName());
			memberService.setMemberTapeId(memberServiceEntity.getMemberTapeId());
			memberService.setMnemonicMemberName(memberServiceEntity.getMnemonicMemberName());
			memberService.setMemberNo(memberServiceEntity.getMemberNo());
		}

		return memberService;
	}

	public static String ccr00xFilename(String subServiceID, String issuerMemberCode) {
		return reportId + "." + TIMESTAMP_FORMAT.format(new Date()) + ".csv" + "." + issuerMemberCode;
	}

}
