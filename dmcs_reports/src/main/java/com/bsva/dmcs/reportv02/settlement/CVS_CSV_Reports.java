package com.bsva.dmcs.reportv02.settlement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.commonsv02.util.SPOLogger;
import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dcms.commons.dao.CsfSystemSettingsDAO;
import com.bsva.dcms.commons.dto.CsfSystemSettingsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.util.Utils;
import com.bsva.dmcs.reportv02.dto.CvsCsvChargeBackVisaDto;
import com.bsva.dmcs.reportv02.dto.CvsCsvReportsDto;
import com.bsva.entities.v02.ChargeBacksDAO;
import com.bsva.entities.v02.ChargeBacksMcard;
import com.bsva.entities.v02.ChargeBacksVISA;
import com.bsva.entities.v02.ChargeBacksVISA_DAO;
import com.bsva.entities.v02.CsfMemberService_DAO;
import com.bsva.entities.v02.CsoMemberMcard_DAO;
import com.bsva.entities.v02.CsoMemberVisa_DAO;
import com.bsva.entities.v02.CsoPaymentMcardEntity;
import com.bsva.entities.v02.CsoPaymentVisaEntity;
import com.bsva.entities.v02.IssuerAcquirerEntity;
import com.bsva.entities.v02.IssuerAcquirerEntity_PK;
import com.bsva.entities.v02.IssuerAcquirerSelect_DAO;
import com.bsva.entities.v02.IssuerAcquirer_DAO;
import com.bsva.entities.v02.billing.MemberServiceEntity;

public class CVS_CSV_Reports {
	/*
	 * This reports is for MONTH END Only
	 */
	private final static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("HHmmssSSS");
	private static String reportId = "CVSCSV";
	private final static String FILE_SEPARATOR = System.getProperty("file.separator");
	private static final String NEW_LINE_SEPARATOR = "\n";
	private final static String REPORT_FOLDER;
	private static String filename = null;
	private static String processData = null;
	private static String memberToStatus = null;
	private static String memberFromStatus = null;
	private static String memberIssuer = null;
	private static String memberAcquirer = null;
	private static String from = null;
	private static String to = null;
	private static String visaChargebacks = "VISA CARD";
	private static String masterChargebacks = "MASTERCARD";
	private static int numberCount = 1;
	private static boolean zeroData = false;
	private static BufferedWriter fileWriter = null;
	private static FileWriter fw = null;
	private static PrintWriter pw = null;
	private static BigDecimal bdVb = BigDecimal.ZERO;
	private static Map<String, String> Issuermemberkey = new HashMap<>();
	protected final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###,###,##0.00");
	private final static SPOLogger SPO_LOGGER;
	private static final String PROCESSNAME = "REPORTS";
	private static String PROCESS_NAME = "CHARGEBACK REPORTS";
	private static String VERSION = "20";

	static {

		Map<String, String> paths = new DirectoryDAO().directories();
		SPO_LOGGER = new SPOLogger(paths.get("SPOLOG"));
	}

	static {
		Map<String, String> paths = new DirectoryDAO().directories();
		REPORT_FOLDER = paths.get("REPORTS");
	}

	public static String ccr00xFilepath(String filename) {
		return REPORT_FOLDER + FILE_SEPARATOR + filename;
	}

	public  void writeCVSCSVReport(String subService) throws DAOException, IOException {

		try {
			CsfSystemSettingsDTO csfSystemSettingsDTO = new CsfSystemSettingsDTO();
			csfSystemSettingsDTO.setSettingCode("CHARGEBACK");
			CsfSystemSettingsDTO settingsname = new CsfSystemSettingsDAO().retrieve(csfSystemSettingsDTO);
			String serviceCode = settingsname.getSettingValue();
			Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();
			String processDat = processDate.toString().substring(0, 10).replace("-", "");
			processData = processDat;
			// Getting Data for Visa Card
			if(!subService.equals("MASTERCARD")){
			List<CsoPaymentVisaEntity> dataList1 = new CsoMemberVisa_DAO().getVisaCard();
			List<IssuerAcquirerEntity> listPair = new ArrayList<>();
			if (dataList1.size() > 0) {
				for (CsoPaymentVisaEntity csoPaymentVisaEntity : dataList1) {
					IssuerAcquirerEntity issuerAcquirer = new IssuerAcquirerEntity();
					IssuerAcquirerEntity_PK issuerAcquirerPK = new IssuerAcquirerEntity_PK();
					issuerAcquirerPK.setAcquirerMember(csoPaymentVisaEntity.getId().getAcquirerMember());
					issuerAcquirerPK.setIssuerMember(csoPaymentVisaEntity.getId().getIssuerMember());
					issuerAcquirer.setId(issuerAcquirerPK);
					issuerAcquirer.setStatus("Y");
					listPair.add(issuerAcquirer);
				}
				 Utils.logSpolog(".... INSERTING DATA INTO ACQUIRER ISSUER PAIR TABLE "+ visaChargebacks+"",PROCESSNAME);
				new IssuerAcquirer_DAO().insert(listPair);
				 Utils.logSpolog(".... INSERTING DATA INTO ACQUIRER ISSUER PAIR TABLE "+ visaChargebacks+"",PROCESSNAME);
			}
			List<IssuerAcquirerEntity> listPairData = new IssuerAcquirerSelect_DAO().getIssuerAcquirerMember();
			if (listPairData.size() > 0) {
				// for (ChargeBacksVISA chargeBacksVISA : chargBack) {
				for (IssuerAcquirerEntity paymentVisa : listPairData) {

					List<ChargeBacksVISA> chargebackIssuer = new ChargeBacksVISA_DAO().getVisaChargeBacksReport(
							paymentVisa.getId().getIssuerMember(), paymentVisa.getId().getAcquirerMember());
					if (chargebackIssuer.size() > 0) {
						for (ChargeBacksVISA chargeBacksVISA : chargebackIssuer) {

							if (zeroData == false) {

								String acquiringMem = getBankMnemonicName(chargeBacksVISA.getAcquirerMember());
								String issuingMem = getBankMnemonicName(chargeBacksVISA.getIssuerMember());
								filename = ccr00xFilename(serviceCode, issuingMem, acquiringMem);
								String filepath = ccr00xFilepath(filename);
								fileWriter = new BufferedWriter(new FileWriter(filepath));
								memberToStatus = acquiringMem;
								memberFromStatus = issuingMem;
								memberAcquirer = chargeBacksVISA.getAcquirerMember();
								memberIssuer = chargeBacksVISA.getIssuerMember();
								zeroData = true;
							}
							// get Data and write to file
							CvsCsvChargeBackVisaDto cvsCsvReportsDto = new CvsCsvChargeBackVisaDto();
							cvsCsvReportsDto.setAccountNumber(chargeBacksVISA.getAccountNumber());
							cvsCsvReportsDto.setAcquirerMember(chargeBacksVISA.getAcquirerMember());
							cvsCsvReportsDto.setAmount(chargeBacksVISA.getAmount());
							cvsCsvReportsDto.setAmount2(chargeBacksVISA.getAuth2());
							cvsCsvReportsDto.setAuth1(chargeBacksVISA.getAuth_1());
							cvsCsvReportsDto.setAuth2(chargeBacksVISA.getAuth2());
							cvsCsvReportsDto.setCheckDigit(chargeBacksVISA.getCheckDigit());
							cvsCsvReportsDto.setIssuerMember(chargeBacksVISA.getIssuerMember());
							cvsCsvReportsDto.setMerchantCity(chargeBacksVISA.getMerchntCity());
							cvsCsvReportsDto.setMerchantCountry(chargeBacksVISA.getMerchantCountry());
							cvsCsvReportsDto.setMerchantName(chargeBacksVISA.getMerchantName());
							cvsCsvReportsDto.setMerchantType(chargeBacksVISA.getMerchantType());
							cvsCsvReportsDto.setMfAcquirer(chargeBacksVISA.getMfAcquirer());
							cvsCsvReportsDto.setMfBatchNo(chargeBacksVISA.getMfBatchNo());
							cvsCsvReportsDto.setMfDate(chargeBacksVISA.getMfDate());
							cvsCsvReportsDto.setMfFormat(chargeBacksVISA.getMfFormat());
							cvsCsvReportsDto.setPurchaseDate(chargeBacksVISA.getPurchaseDate());
							cvsCsvReportsDto.setReason(chargeBacksVISA.getReason());
							cvsCsvReportsDto.setReasonCode(chargeBacksVISA.getReasonCode());
							cvsCsvReportsDto.setSystemSeqNumber(chargeBacksVISA.getSystemGenSeqNumber());
							cvsCsvReportsDto.setTransactionCode(chargeBacksVISA.getTransactionCode());
							fileWriter.write(cvsCsvReportsDto.toString());
							fileWriter.newLine();
						}
					}
					System.out.println("Finished writing  " + paymentVisa.getId().getIssuerMember() + " and "
							+ paymentVisa.getId().getAcquirerMember());
					 Utils.logSpolog("Finished writing  " + paymentVisa.getId().getIssuerMember() + " and "
							+ paymentVisa.getId().getAcquirerMember(),PROCESSNAME);
					zeroData = false;
				}
				 Utils.logSpolog(".... DELETING ACQUIRER ISSUER PAIR TABLE ",PROCESSNAME);
				new IssuerAcquirerSelect_DAO().deleteData();
				 Utils.logSpolog("....FINISHED DELETING ACQUIRER ISSUER PAIR TABLE ",PROCESSNAME);
			 }
			}else{
			
			List<CsoPaymentMcardEntity> dataList = new CsoMemberMcard_DAO().getMasterCard();
			List<IssuerAcquirerEntity> listPairMcard = new ArrayList<>();
			if (dataList.size() > 0) {
				for (CsoPaymentMcardEntity csoPaymentMcardEntity : dataList) {
					IssuerAcquirerEntity issuerAcquirer = new IssuerAcquirerEntity();
					IssuerAcquirerEntity_PK issuerAcquirerPK = new IssuerAcquirerEntity_PK();
					issuerAcquirerPK.setAcquirerMember(csoPaymentMcardEntity.getId().getAcquirerMember());
					issuerAcquirerPK.setIssuerMember(csoPaymentMcardEntity.getId().getIssuerMember());
					issuerAcquirer.setId(issuerAcquirerPK);
					issuerAcquirer.setStatus("Y");
					listPairMcard.add(issuerAcquirer);
				}
				 Utils.logSpolog( ".... INSERTING DATA INTO ACQUIRER ISSUER PAIR TABLE ",PROCESSNAME);
				 new IssuerAcquirer_DAO().insert(listPairMcard);
				 Utils.logSpolog( "....FINISHED INSERTING DATA INTO ACQUIRER ISSUER PAIR TABLE ",PROCESSNAME);
			}

			List<IssuerAcquirerEntity> listPairMc = new IssuerAcquirerSelect_DAO().getIssuerAcquirerMember();
			if (listPairMc.size() > 0) {
				for (IssuerAcquirerEntity issuerAcquirerEntity : listPairMc) {

					List<ChargeBacksMcard> chargBackMcard = new ChargeBacksDAO().getMasterCard(issuerAcquirerEntity
							.getId().getIssuerMember(), issuerAcquirerEntity.getId().getAcquirerMember());
					if (chargBackMcard.size() > 0) {
						for (ChargeBacksMcard chargeBacksMcard : chargBackMcard) {
							if (zeroData == false) {
								String acquiringMem = getBankMnemonicName(chargeBacksMcard.getAcquirer());
								String issuingMem = getBankMnemonicName(chargeBacksMcard.getIssuer());
								filename = ccr00xFilename(serviceCode, issuingMem, acquiringMem);
								String fileNumber = filename.substring(0, 8);
								String path = REPORT_FOLDER;
								boolean fileExist = listFilesAndFolders(path, fileNumber);
								if (fileExist) {
									String strFileName = getFileName(path, fileNumber);
									fw = new FileWriter(strFileName, true);
									fileWriter = new BufferedWriter(fw);
									zeroData = true;
								} else {
									String filepath = ccr00xFilepath(filename);
									fileWriter = new BufferedWriter(new FileWriter(filepath));
									zeroData = true;
								}
							}
							CvsCsvReportsDto cvsCsvReportsDto = new CvsCsvReportsDto();
							cvsCsvReportsDto.setAccountNumber(chargeBacksMcard.getAccountNumber());
							cvsCsvReportsDto.setAcquirerMember(chargeBacksMcard.getAcquirer());
							cvsCsvReportsDto.setAmount(chargeBacksMcard.getAmount());
							cvsCsvReportsDto.setAmount2(chargeBacksMcard.getAmount());
							cvsCsvReportsDto.setCardAcceptorName(chargeBacksMcard.getCardAccptorName());
							cvsCsvReportsDto.setCheckDigit(chargeBacksMcard.getChheckDigit());
							cvsCsvReportsDto.setIssuerMember(chargeBacksMcard.getIssuer());
							cvsCsvReportsDto.setMcardAuth(chargeBacksMcard.getMcardAuth());
							cvsCsvReportsDto.setMerchantType(chargeBacksMcard.getMerchantType());
							cvsCsvReportsDto.setMfAcquirer(chargeBacksMcard.getMfAcquirer());
							cvsCsvReportsDto.setMfbatchNumber(chargeBacksMcard.getMfBatchNo());
							cvsCsvReportsDto.setMfDate(chargeBacksMcard.getMfDate());
							cvsCsvReportsDto.setMfFormat(chargeBacksMcard.getMfFormat());
							cvsCsvReportsDto.setPurchaseDate(chargeBacksMcard.getPurchaseDate());
							cvsCsvReportsDto.setReason(chargeBacksMcard.getReason());
							cvsCsvReportsDto.setSystemSeqNumber(chargeBacksMcard.getSystemSeqNumber());
							cvsCsvReportsDto.setTransactionCode(chargeBacksMcard.getTransactionCode());
							cvsCsvReportsDto.setUsageCode(chargeBacksMcard.getUsageCode());

							fileWriter.write(cvsCsvReportsDto.toString());
							fileWriter.newLine();
							fileWriter.flush();
						}

					}
					System.out.println("Finished writing Issuer : " + chargBackMcard.get(0).getIssuer()
							+ " and Acquirer : " + chargBackMcard.get(0).getAcquirer());
					zeroData = false;
					 Utils.logSpolog("Finished writing Issuer : " + chargBackMcard.get(0).getIssuer()
								+ " and Acquirer : " + chargBackMcard.get(0).getAcquirer(),PROCESSNAME);
				}
				 Utils.logSpolog(".... DELETING DATA IN ACQUIRER ISSUER PAIR TABLE ",PROCESSNAME);
				 new IssuerAcquirerSelect_DAO().deleteData();
				 Utils.logSpolog("....FINISHED DELETING DATA IN ACQUIRER ISSUER PAIR TABLE ",PROCESSNAME);
			}
		  }

		} catch (IOException ex) {
			ex.getMessage();
		} finally {
			try {
				if (fileWriter != null) {
					fileWriter.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException ex) {

			}
		}

	}

	public static boolean listFilesAndFolders(String directoryName, String filenamePrefix) {
		File directory = new File(directoryName);
		// get all the files from a directory
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.getName().startsWith(filenamePrefix)) {
				System.out.println(file.getName());
				return true;
			}
		}
		return false;
	}

	public static String getFileName(String directoryName, String filenamePrefix) {
		File directory = new File(directoryName);
		// get all the files from a directory
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.getName().startsWith(filenamePrefix)) {
				System.out.println(file.getName());
				return REPORT_FOLDER + FILE_SEPARATOR + file.getName();
			}
		}
		return null;
	}

	/*@SuppressWarnings("static-access")
	public static void main(String[] args) throws DAOException, IOException {

		CVS_CSV_Reports csvCsrReports = new CVS_CSV_Reports();
		csvCsrReports.writeCVSCSVReport();
	}*/

	public static String getBankMnemonicName(String bankCode) {

		MemberServiceEntity memberdata = new CsfMemberService_DAO().getMemberTypesSingle(bankCode);

		return memberdata.getMnemonicMemberName();
	}

	public static String ccr00xFilename(String issuerMemberCode, String acqMem, String issMem) {
		return acqMem + "TO" + issMem + "." + processData + "." + TIMESTAMP_FORMAT.format(new Date());
	}

}
