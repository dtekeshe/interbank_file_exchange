package com.bsva.dmcs.reportv02.settlement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dao.v02.members.Csf_Card_Types_DAO;
import com.bsva.dao.v02.members.CsrMisEntityDAO;
import com.bsva.dcms.commons.dao.CSFMembersServiceDAO;
import com.bsva.dcms.commons.dao.CsfCompanyParametersDAO;
import com.bsva.dcms.commons.dao.CsfSystemSettingsDAO;
import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.dto.CsfCompanyParametersDTO;
import com.bsva.dcms.commons.dto.CsfSystemSettingsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dmcs.reportv02.dto.CSRMISFileTotalsDto;
import com.bsva.dmcs.reportv02.dto.FileCCRMISDetailReport;
import com.bsva.dmcs.reportv02.dto.FileCSRMISSubHeaderDto;
import com.bsva.dmcs.reportv02.dto.PrintAllMnemonicnameDto;
import com.bsva.entities.CsrMisEntity;
import com.bsva.entities.v02.CsfMemberService_DAO;
import com.bsva.entities.v02.billing.CsfCardTypes_Entity;
import com.bsva.entities.v02.billing.MemberServiceEntity;

public class CSRMISReport {
	/*
	 * This reports is for MONTH END Only
	 * */
	private final static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("HHmmssSSS");
	private static String reportId = "CSRMIS";
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

	public static void writeCSRMISReport(String subService) throws DAOException, IOException {

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
			
			LocalTime dateTime = LocalTime.now();
			int hour = dateTime.getHour();
			int min = dateTime.getMinute();

			// control header
			String subMenu1 = "BNK         CSRMIS TIME : "+hour+"H"+min
					+ "  :                     B A N K S E R V   (P T Y)   L T D              "
					+ processDate.toString().substring(0, 10).replace("-", "") + "    PAGE:-     1";
			String subMenu2 = "                     							 REG.NO.  " + csfParametersDTO.getRegistrationNumber() + "";
			String subMenu3 = "**** INTERNAL ****                    MIS AND BANKSERV REVENUE CONTROL REPORT";
			String subMenu4 = " 			MONTH-TO-DATE ACCUMULATION AS AT  " + processDat;
			String subMenu5 = "                   SUMMARY OF SUB TOTALS";

			fileWriter.write(subMenu1);
			fileWriter.newLine();
			fileWriter.newLine();
			fileWriter.write(subMenu2);
			fileWriter.newLine();
			fileWriter.newLine();
			fileWriter.write(subMenu3);
			fileWriter.newLine();
			fileWriter.newLine();
			fileWriter.write(subMenu4);
			fileWriter.newLine();
			fileWriter.newLine();
			fileWriter.write(subMenu5);
			FileCSRMISSubHeaderDto fileCSRMISReport = new FileCSRMISSubHeaderDto();
			fileCSRMISReport.setMemberNameHeader("MEMBER");
			fileCSRMISReport.setSubService("SUB SERVICE");
			fileCSRMISReport.setVolumeBelow("VOLUME");
			fileCSRMISReport.setValueBelow("VALUE");
			fileCSRMISReport.setBsvRevenueBelow("BSV REVENUE");
			fileCSRMISReport.setVolumeAbove("VOLUME");
			fileCSRMISReport.setValueAbove("VALUE");
			fileCSRMISReport.setBsvRevenueAbove("BSV REVENUE");

			fileCSRMISReport.setSubMember("NAME");
			fileCSRMISReport.setSubVolume("BELOW");
			fileCSRMISReport.setSubValue("BELOW");
			fileCSRMISReport.setSubbsvRevenueBelow("BELOW");
			fileCSRMISReport.setSubVolumeAbove("ABOVE");
			fileCSRMISReport.setSubValueAbove("ABOVE");
			fileCSRMISReport.setSubBsvRevenueAbove("ABOVE");

			fileCSRMISReport.setMembernameUnderLine("------");
			fileCSRMISReport.setSubServiceUnderLine("-------------------");
			fileCSRMISReport.setVolumeUnderLine("-----------------");
			fileCSRMISReport.setValueBelowUnderLine("----------------");
			fileCSRMISReport.setBsvRevenueBelowUnderLine("-----------");
			fileCSRMISReport.setVolumeAboveUnderLine("-----------");
			fileCSRMISReport.setValueAboveUnderLine("------------");
			fileCSRMISReport.setBsvRevenueAboveUnderLine("---------------------");

			fileWriter.write(fileCSRMISReport.toString());
			List<CsrMisEntity> listData = new CsrMisEntityDAO().getAllData();
			if (listData != null) {
				for (CsrMisEntity csrMisEntity : listData) {
					if (processDat.equals(csrMisEntity.getCsrMisEntity_PK().getProcessDate().substring(0, 10))) {
						MemberServiceEntity members = getBankCode(csrMisEntity.getCsrMisEntity_PK().getIssuingMember());
						String description = getCardType(csrMisEntity.getCsrMisEntity_PK().getCardType());
						FileCCRMISDetailReport fileCCRMISDetailReport = new FileCCRMISDetailReport();

						fileCCRMISDetailReport.setMemberNameText(members.getMnemonicMemberName());
						fileCCRMISDetailReport.setSubServiceText(description);
						fileCCRMISDetailReport.setVolumeText(csrMisEntity.getVolumeBelow());
						fileCCRMISDetailReport.setValueBelowText(csrMisEntity.getValueBelow());
						fileCCRMISDetailReport.setBsvRevenueBelowText(csrMisEntity.getVolume());
						fileCCRMISDetailReport.setVolumeAboveText(csrMisEntity.getVolumeAbove());
						fileCCRMISDetailReport.setValueAboveText(csrMisEntity.getValueAbove());
						fileCCRMISDetailReport.setBsvRevenueAboveText(csrMisEntity.getValue());

						BigDecimal bdVolumeBelow = new BigDecimal(new Double(csrMisEntity.getVolumeBelow()));
						addDoubleVolumeBelow = addDoubleVolumeBelow.add(bdVolumeBelow)
								.setScale(2, RoundingMode.HALF_UP);

						BigDecimal bdValueBelow = new BigDecimal(new Double(csrMisEntity.getValueBelow()));
						addDoubleValuebelow = addDoubleValuebelow.add(bdValueBelow).setScale(2, RoundingMode.HALF_UP);

						BigDecimal bdBsvRevenueBelow = new BigDecimal(new Double(csrMisEntity.getVolume()));
						addDoubleBsvRevenueBelow = addDoubleBsvRevenueBelow.add(bdBsvRevenueBelow).setScale(2,
								RoundingMode.HALF_UP);

						BigDecimal bdVolumeAbove = new BigDecimal(new Double(csrMisEntity.getVolumeAbove()));
						addDoubleVolumeAbove = addDoubleVolumeAbove.add(bdVolumeAbove)
								.setScale(2, RoundingMode.HALF_UP);

						BigDecimal bdValueAbove = new BigDecimal(new Double(csrMisEntity.getValueAbove()));
						addDoubleValueAbove = addDoubleValueAbove.add(bdValueAbove).setScale(2, RoundingMode.HALF_UP);

						BigDecimal bdBsvRevenueAbove = new BigDecimal(new Double(csrMisEntity.getValue()));
						addDoubleBsvRevenueAbove = addDoubleBsvRevenueAbove.add(bdBsvRevenueAbove).setScale(2,
								RoundingMode.HALF_UP);

						fileWriter.write(fileCCRMISDetailReport.toString());

					}
				}
			}

			CSRMISFileTotalsDto csrMISFileTotalsDto = new CSRMISFileTotalsDto();

			csrMISFileTotalsDto.setMembernameUnderLine("------");
			csrMISFileTotalsDto.setSubServiceUnderLine("-------------------");
			csrMISFileTotalsDto.setVolumeUnderLine("-----------------");
			csrMISFileTotalsDto.setValueBelowUnderLine("----------------");
			csrMISFileTotalsDto.setBsvRevenueBelowUnderLine("-----------");
			csrMISFileTotalsDto.setVolumeAboveUnderLine("-----------");
			csrMISFileTotalsDto.setValueAboveUnderLine("------------");
			csrMISFileTotalsDto.setBsvRevenueAboveUnderLine("---------------------");

			csrMISFileTotalsDto.setMemberGrandTotal("GRAND TOTAL");
			csrMISFileTotalsDto.setVolumeBelowGrandTotal(String.valueOf(addDoubleVolumeBelow));
			csrMISFileTotalsDto.setValueBelowGrandTotal(String.valueOf(addDoubleValuebelow));
			csrMISFileTotalsDto.setBsvRevenueBelowGrandTotal(String.valueOf(addDoubleBsvRevenueBelow));
			csrMISFileTotalsDto.setVolumeAboveGrandTotal(String.valueOf(addDoubleVolumeAbove));
			csrMISFileTotalsDto.setValueAboveGrandTotal(String.valueOf(addDoubleValueAbove));
			csrMISFileTotalsDto.setBsvRevenueAboveGrandTotal(String.valueOf(addDoubleBsvRevenueAbove));

			fileWriter.write(csrMISFileTotalsDto.toString());
			fileWriter.newLine();
			fileWriter.newLine();

			String legend = "LEGEND :";
			String bankName = "    BANK MNEMONIC  /  NAME";
			fileWriter.write(legend);
			fileWriter.newLine();
			fileWriter.write(bankName);
			List<MemberServiceEntity> listMember = new CsfMemberService_DAO().getMemberTypes();
			if (listMember != null) {
				for (MemberServiceEntity memberServiceEntity : listMember) {
					if (memberServiceEntity.getMnemonicMemberName() == null) {
						continue;
					}
					PrintAllMnemonicnameDto printAllMnemonicnameDto = new PrintAllMnemonicnameDto();
					printAllMnemonicnameDto.setBankMnemonic(memberServiceEntity.getMnemonicMemberName());
					printAllMnemonicnameDto.setName(memberServiceEntity.getMemberName());
					fileWriter.write(printAllMnemonicnameDto.toString()+"\n");
				}
			}

		} catch (Exception ex) {
			ex.getMessage();
		} finally {
			if (fileWriter != null) {
				fileWriter.close();
			}
		}

	}

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

	public static String getCardType(String cardTypes) {

		String cardType = null;

		List<CsfCardTypes_Entity> cardTy = new Csf_Card_Types_DAO().getCardTypes(cardTypes);
		for (CsfCardTypes_Entity csfCardTypes_Entity : cardTy) {
			cardType = csfCardTypes_Entity.getCardDescription();
		}

		return cardType;
	}

	public static void main(String[] args) throws DAOException, IOException {

		new CSRMISReport();
		CSRMISReport.writeCSRMISReport("MASTERCARD");
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
		return reportId + SUB_SERVICE_MNEMONICS.get(subServiceID) + "." + TIMESTAMP_FORMAT.format(new Date())
				+ "." + issuerMemberCode;
	}

}
