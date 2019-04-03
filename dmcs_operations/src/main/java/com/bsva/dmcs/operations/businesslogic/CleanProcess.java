package com.bsva.dmcs.operations.businesslogic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.InputFileControlDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dao.v02.cisbins.entity.BankCodeDao;
import com.bsva.dao.v02.cisbins.entity.BankCodeEntity;
import com.bsva.dao.v02.cisbins.entity.CisBinCountDao;
import com.bsva.dao.v02.cisbins.entity.CisBinsCountEntity;
import com.bsva.dao.v02.cisbins.entity.CisBinsEntity;
import com.bsva.dao.v02.cisbins.entity.CisBinsMemberInfoDao;
import com.bsva.dao.v02.cisbins.entity.CisBinsMemberInfoEntity;
import com.bsva.dao.v02.cisbins.entity.CisBinsMembersDao;
import com.bsva.dao.v02.fileloader.Cso_File_seq_DAO;
import com.bsva.dcms.commons.dao.CSOPaymentInstructionsVisaDAO;
import com.bsva.dcms.commons.dao.CsfPublicHolidaysDAO;
import com.bsva.dcms.commons.dao.CsoBatchProcessesDAO;
import com.bsva.dcms.commons.dao.CsoCoreProcessesDAO;
import com.bsva.dcms.commons.dao.CsoEndOfServiceControlsDAO;
import com.bsva.dcms.commons.dao.CsoFleetBillingDAO;
import com.bsva.dcms.commons.dao.CsoFleetBindResolvedDAO;
import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
import com.bsva.dcms.commons.dao.CsoNegcardInfoDAO;
import com.bsva.dcms.commons.dao.CsoOdsFileToLoadDAO;
import com.bsva.dcms.commons.dao.CsoOutputControlsDAO;
import com.bsva.dcms.commons.dao.CsoPaymentInstructionsMcardDAO;
import com.bsva.dcms.commons.dao.CsoPaymentMcardPdsDAO;
import com.bsva.dcms.commons.dao.CsoProgramControlsDAO;
import com.bsva.dcms.commons.dao.CsoSeqNumbersDAO;
import com.bsva.dcms.commons.dao.CsoServiceParametersDAO;
import com.bsva.dcms.commons.dao.CsoSettlementMatrixesDAO;
import com.bsva.dcms.commons.dao.CsoSystemParametersDAO;
import com.bsva.dcms.commons.dao.CsoTransactionsDAO;
import com.bsva.dcms.commons.dao.CsoZ1Z9InputOutputsDAO;
import com.bsva.dcms.commons.dao.DelDeliveryFilesCCCDAO;
import com.bsva.dcms.commons.dao.HsoInputFileControlsDAO;
import com.bsva.dcms.commons.dto.CSOTransactionDTO;
import com.bsva.dcms.commons.dto.CsfPublicHolidaysDTO;
import com.bsva.dcms.commons.dto.CsoBatchProcessesDTO;
import com.bsva.dcms.commons.dto.CsoCoreProcessesDTO;
import com.bsva.dcms.commons.dto.CsoEndOfServiceControlsDTO;
import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
import com.bsva.dcms.commons.dto.CsoNegcardInfoDTO;
import com.bsva.dcms.commons.dto.CsoOdsFileToLoadDTO;
import com.bsva.dcms.commons.dto.CsoOutputControlsDTO;
import com.bsva.dcms.commons.dto.CsoPaymentInstructionsMcardDTO;
import com.bsva.dcms.commons.dto.CsoSeqNumbersDTO;
import com.bsva.dcms.commons.dto.CsoServiceParametersDTO;
import com.bsva.dcms.commons.dto.CsoSettlementMatrixesDTO;
import com.bsva.dcms.commons.dto.CsoSystemParametersDTO;
import com.bsva.dcms.commons.dto.CsoZ1Z9InputOutputsDTO;
import com.bsva.dcms.commons.dto.DelDeliveryFilesCCCDTO;
import com.bsva.dcms.commons.dto.HsoInputFileControlsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.util.DateUtil;
import com.bsva.dcms.commons.util.Utils;
import com.dmcs.operations.dto.CisBinCountDTO;
import com.dmcs.operations.dto.CisBinsHeaderName;
import com.dmcs.operations.dto.CisBinsReportHeader;
import com.dmcs.operations.dto.CisMemberNameDTO;
import com.dmcs.operations.dto.CsrBinsReportDTO;

public class CleanProcess {

	@Resource(lookup = "java:jboss/datasources/DMCSDb")
	private DataSource datasource;

	private final static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("HHmmssSSS");

	private Logger log = Logger.getLogger(CleanProcess.class.getName());

	private static final String PROCESSNAME = "CleanProcess";

	private final static String FILE_SEPARATOR = System.getProperty("file.separator");

	private static int numberCount = 1;

	private static int pageCount = 0;

	private final static String REPORT_FOLDER;

	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

	public CleanProcess(DataSource conn) {
		this.datasource = conn;
	}

	public CleanProcess() {
	}

	public static String cisBinsFilename() {
		Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();
		String date = formatter.format(processDate);
		return "CSRBIN." + date.replace("/", "").trim() + "." + TIMESTAMP_FORMAT.format(new Date()).substring(0, 8)
				+ ".4149";
	}

	public static String cisBinsFilepath(String filename) {
		return FILE_SEPARATOR + REPORT_FOLDER + FILE_SEPARATOR + filename;
	}

	static {

		Map<String, String> paths = new DirectoryDAO().directories();
		REPORT_FOLDER = paths.get("REPORTS");
	}

	// Used to generate CISBINS Report at SOD
	public void generateCisBinsReports() {
		Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();
		// BsvTableLookup.getInstance().getReceiveDir()
		final String FILENAME = cisBinsFilepath(cisBinsFilename());
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			List<BankCodeEntity> bankCodeDao = new BankCodeDao().returnBankCode();
			Map<String, Object> members = returnMembersCode();

			CisBinsCountEntity cisBinCount = getBinNum();
			// used to write lines based on the bankcode
			for (BankCodeEntity bankCodeEntity : bankCodeDao) {
				CisBinsMemberInfoEntity entity = (CisBinsMemberInfoEntity) members
						.get("" + bankCodeEntity.getBankCode() + "");
				pageCount++;
				writeFileHeader(bw, pageCount, entity.getVatRegNumber());
				CisBinCountDTOWriter(bw, cisBinCount);
				List<CisBinsEntity> cisBins = new CisBinsMembersDao()
						.returnBins(String.valueOf(bankCodeEntity.getBankCode()));
				writeSubHeaderLine(bw, entity);

				CisBinsReportHeaderWriter(bw);
				// Used to write the Lines until page break Count is reached
				for (CisBinsEntity cisBinsEntity : cisBins) {
					numberCount++;
					CsrBinsReportDTO csrBinsReportDTO = new CsrBinsReportDTO();
					csrBinsReportDTO.setBankCode(cisBinsEntity.getBankCode());
					csrBinsReportDTO.setBinDescription(cisBinsEntity.getBinDescription());
					csrBinsReportDTO.setBinNo(cisBinsEntity.getBinNo());
					csrBinsReportDTO.setCardType(cisBinsEntity.getCardType());
					csrBinsReportDTO.setDeletionDate(cisBinsEntity.getDeletionDate());
					csrBinsReportDTO.setFuelAllowed(cisBinsEntity.getFuelAllowed());
					csrBinsReportDTO.setIssAcqBoth(cisBinsEntity.getIssAcqBoth());
					csrBinsReportDTO.setMonthsUntilCisBinDeletion(cisBinsEntity.getMonthsUntilCisBinDeletion());
					csrBinsReportDTO.setOldCardType(cisBinsEntity.getOldCardType());
					csrBinsReportDTO.setProcessActiveInd(cisBinsEntity.getProcessActiveInd());
					csrBinsReportDTO.setProcessDate(formatter.format(processDate));
					csrBinsReportDTO.setLiveDate(cisBinsEntity.getLiveDate().substring(0, 10));
					bw.write(csrBinsReportDTO.toString());
					bw.flush();

					boolean result = isMultipleOfThree(numberCount);
					// writing the sub Headers to before starting to write a new bank Member OR page break
					if (result == true) {
						pageCount++;
						writeFileHeader(bw, pageCount, entity.getVatRegNumber());
						CisBinCountDTOWriter(bw, cisBinCount);
						writeSubHeaderLine(bw, entity);
					}
				}
			}

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		// This must be executed to do the closing of FileWriter and BufferedWriter weather there is an error or not.
		finally {

			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}

		}

	}

	public static boolean isMultipleOfThree(int n) {
		if (n != 0) {
			if (n % 50 == 0) {

				return true;
			}
		}
		return false;
	}

	// Used to write the subHeader for CISBINS Report
	private static void writeSubHeaderLine(BufferedWriter bw, CisBinsMemberInfoEntity entity) throws IOException {
		CisMemberNameDTO cisMemberNameDTO = new CisMemberNameDTO();
		cisMemberNameDTO.setAuditTrailmsg("PRD64Bit - Credit Card Clearin   LIST OF BINS AND ASSOCIATED AUDIT TRAIL");
		cisMemberNameDTO.setBankName(entity.getMembername());
		cisMemberNameDTO.setMonthsText("9 MONTH(S) BETWEEN FIRST AND FINAL DELETION DATES");
		bw.write(cisMemberNameDTO.toString());
		bw.flush();
	}

	// Used to Count page number for CISBINS Report
	public static int incrementNum(int num) {
		int number = 1;
		if (num == 100) {
			number = 1;
			return number;
		}
		number = numberCount += num;

		return number;
	}

	// Used to write Bins statistics in the system
	private static void CisBinCountDTOWriter(BufferedWriter bw, CisBinsCountEntity cisBinCount) throws IOException {
		CisBinCountDTO cisBinCountDTO = new CisBinCountDTO();
		cisBinCountDTO.setBinheaderDescription("PRD64Bit - Credit Card Clearin   BIN TABLE TOTALS FOR SYSTEM");
		cisBinCountDTO.setActiveBinsStr(" NUMBER OF ACTIVE BINS ");
		cisBinCountDTO.setActiveBins(cisBinCount.getActiveBins());

		cisBinCountDTO.setBinDeletedStr(" NUMBER OF BINS DELETED ");
		cisBinCountDTO.setBinDeleted(cisBinCount.getBinDeleted());

		cisBinCountDTO.setBinTotalNumberStr("TOTAL NUMBER OF BINS");
		cisBinCountDTO.setBinTotalNumber(cisBinCount.getBinTotalNumber());

		cisBinCountDTO.setDeletionCycleStr("NUMBER OF BINS IN DELETION CYCLE");
		cisBinCountDTO.setDeletionCycle(cisBinCount.getDeletionCycle());

		cisBinCountDTO.setSetForDeletionStr(" NUMBER OF SET FOR DELETION");
		cisBinCountDTO.setSetForDeletion(cisBinCount.getSetForDeletion());

		bw.write(cisBinCountDTO.toString());
		bw.flush();
	}

	// Used to write the Report Header for CISBINS Report
	private static void CisBinsReportHeaderWriter(BufferedWriter bw) throws IOException {
		CisBinsReportHeader cisBinsReportHeader = new CisBinsReportHeader();
		cisBinsReportHeader.setBinNo("BIN NO");
		cisBinsReportHeader.setBankCode("BANK");
		cisBinsReportHeader.setBinDescription("BIN DESCRIPTION");
		cisBinsReportHeader.setCardType("C-TYPE");
		cisBinsReportHeader.setDeletionDate("DEL DATE");
		cisBinsReportHeader.setFuelAllowed("FUEL");
		cisBinsReportHeader.setIssAcqBoth("I/A/B");
		cisBinsReportHeader.setOldCardType("OCT");
		cisBinsReportHeader.setLiveDate("LIVE DATE");
		bw.write(cisBinsReportHeader.toString());
		bw.flush();
	}

	private static Map<String, Object> returnMembersCode() {
		Map<String, Object> membersCode = new CisBinsMemberInfoDao().returnMembers();
		return membersCode;
	}

	// Used to write top file Header for CISBINS Report
	private static void writeFileHeader(BufferedWriter bw, long pageCount, String regNum) throws IOException {
		Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();
		CisBinsHeaderName cisBinsHeaderName = new CisBinsHeaderName();
		cisBinsHeaderName.setBank("BNK");
		cisBinsHeaderName.setBankservName("B A N K S E R V   (P T Y)   L T D");
		cisBinsHeaderName.setDate(formatter.format(processDate));
		cisBinsHeaderName.setPage("PAGE");
		Long pageCounter = pageCount;
		cisBinsHeaderName.setPageCount(String.valueOf(pageCounter));
		cisBinsHeaderName.setRegNoStr("REG. NO.");
		cisBinsHeaderName.setRegNum(regNum);
		cisBinsHeaderName.setTimeStr("TIME: ");
		Calendar rightNow = Calendar.getInstance();
		int hour = rightNow.get(Calendar.HOUR_OF_DAY);
		int min = rightNow.get(Calendar.MINUTE);
		cisBinsHeaderName.setTime(hour + "H" + leftPadZeros(min + "", 2));
		bw.write(cisBinsHeaderName.toString());
		bw.flush();
	}

	// Used to format the spacing in the file
	public static String leftPadZeros(String str, int num) {
		return String.format("%1$" + num + "s", str).replace(' ', '0');
	}

	// Used to get the BinNumber from the system
	public static CisBinsCountEntity getBinNum() {
		CisBinsCountEntity cisBinsCountEntity = null;
		List<CisBinsCountEntity> cisBinscount = new CisBinCountDao().returnBinCount();
		for (CisBinsCountEntity cisBinsCount : cisBinscount) {
			cisBinsCountEntity = new CisBinsCountEntity();
			cisBinsCountEntity.setActiveBins(cisBinsCount.getActiveBins());
			cisBinsCountEntity.setBinDeleted(cisBinsCount.getBinDeleted());
			cisBinsCountEntity.setBinTotalNumber(cisBinsCount.getBinTotalNumber());
			cisBinsCountEntity.setDeletionCycle(cisBinsCount.getDeletionCycle());
			cisBinsCountEntity.setSetForDeletion(cisBinsCount.getSetForDeletion());
		}
		return cisBinsCountEntity;
	}

	public boolean runCleanProcess(Date processDate) {
		// Utils.logSpolog("### SOD Process Started ###");
		boolean result = true;
		try {

			Utils.logSpolog("#####-----Start of Day Starting.....------###", PROCESSNAME);

			deleteZ1Z9InputOutput();

		}
		catch (DAOException e) {
			e.getMessage();
		}
		deleteEndOfServiceControls();
		deleteSettlementMatrixes();
		deleteSeqNumbers();
		deleteCsoFileSeq();

		// resetCoreProcesses();
		// resetBatchProcesses();

		/*
		 * List<CsoInputFileControlsDTO> csoInputFileControlsListDTO = retrieveAllInputFileControls(new
		 * CsoInputFileControlsDTO());
		 * 
		 * if (csoInputFileControlsListDTO != null && csoInputFileControlsListDTO.size() > 0) {
		 * 
		 * for (CsoInputFileControlsDTO csoInputFile : csoInputFileControlsListDTO) {
		 * 
		 * deleteHsoInputFileControlsBySeqNumber(csoInputFile); }
		 * 
		 * }
		 * 
		 * CsoInputFileControlsDTO csoInputFileControlsDTO = new CsoInputFileControlsDTO();
		 * 
		 * csoInputFileControlsDTO.setProcessStatus("C");
		 * 
		 * csoInputFileControlsListDTO = retrieveAllInputFileControls(csoInputFileControlsDTO);
		 * 
		 * if (csoInputFileControlsListDTO != null && csoInputFileControlsListDTO.size() > 0) {
		 * 
		 * for (CsoInputFileControlsDTO csoFileInput : csoInputFileControlsListDTO) {
		 * 
		 * createHsoInputFileControls(csoFileInput); } }
		 * 
		 * deleteHsoAgeingInputFiles();
		 */
		try {
			//check if the day is a holiday
			CsfPublicHolidaysDTO publicHol = new CsfPublicHolidaysDTO();
			Calendar cal3 = Calendar.getInstance();
			cal3.setTime(processDate);
			 cal3.add(Calendar.DAY_OF_MONTH, -1);
			publicHol.setProcessDate(cal3.getTime());
			CsfPublicHolidaysDAO publicHolDao = new CsfPublicHolidaysDAO();
			CsfPublicHolidaysDTO csfPublicHolidaysDto = publicHolDao.retrieve(publicHol);
			if (csfPublicHolidaysDto == null) {				
				deletePaymentInstructionsMcard();
				deletePaymentInstructionsVisa();
				deleteCsoTransactions();
				deleteInputFileControls();
				deleteFleetBindResolved();
				deleteCSOProgramControls();
			}
			//check if previous day is a holiday
			CsfPublicHolidaysDTO publicHol2 = new CsfPublicHolidaysDTO();
			Calendar cal32 = Calendar.getInstance();
			cal32.setTime(processDate);
			cal32.add(Calendar.DAY_OF_MONTH, -1);
			publicHol2.setProcessDate(cal32.getTime());
			CsfPublicHolidaysDAO publicHolDao2 = new CsfPublicHolidaysDAO();
			CsfPublicHolidaysDTO csfPublicHolidaysDto2 = publicHolDao2.retrieve(publicHol2);
			if (csfPublicHolidaysDto2 != null) {
				new InputFileControlDAO().updateDeliveryFile();
			}
			//clear tables and prepare for new data
			deleteMasterCardPDS();
			deleteFilesToLoad();
			deleteOutputControls();
			deleteServiceParameters();
			deleteSystemParameters();
			deleteNegCardInfo();
			deleteAgeingSystemParameters(processDate);
			deleteDelDeliveryFiles();
			deleteCSOProgramControls();

		}
		catch (DAOException e) {
			log.info(e.getMessage());
			result = false;
		}
		return result;
	}

	private void deleteZ1Z9InputOutput() throws DAOException {

		CsoZ1Z9InputOutputsDTO csoZ1Z9InputOutputsDTO = new CsoZ1Z9InputOutputsDTO();
		CsoZ1Z9InputOutputsDAO csoZ1Z9InputOutputsDAO = new CsoZ1Z9InputOutputsDAO();
		csoZ1Z9InputOutputsDAO.delete();
		log.info("Successfully Deleted CSO_Z1_Z9_INPUT_OUTPUTS");
		Utils.logSpolog("Successfully Deleted CSO_Z1_Z9_INPUT_OUTPUTS", PROCESSNAME);
	}

	private void deleteEndOfServiceControls() {

		CsoEndOfServiceControlsDTO CsoEndOfServiceControlsDTO = new CsoEndOfServiceControlsDTO();
		CsoEndOfServiceControlsDAO csoEndOfServiceControlsDAO = new CsoEndOfServiceControlsDAO(datasource);

		try {

			// csoEndOfServiceControlsDAO.delete(CsoEndOfServiceControlsDTO);

			log.info("Successfully Deleted CSO_END_OF_SERVICE_CONTROLS");
			Utils.logSpolog("Successfully Deleted CSO_END_OF_SERVICE_CONTROLS", PROCESSNAME);

		}
		catch (Exception e) {

		}
	}

	private void deleteSettlementMatrixes() {

		CsoSettlementMatrixesDTO CsoSettlementMatrixesDTO = new CsoSettlementMatrixesDTO();
		CsoSettlementMatrixesDAO CsoSettlementMatrixesDAO = new CsoSettlementMatrixesDAO(datasource);

		try {

			// CsoSettlementMatrixesDAO.delete(CsoSettlementMatrixesDTO);

			log.info("Successfully Deleted CSO_SETTLEMENT_MATRIXES");

		}
		catch (Exception e) {

		}

	}

	private void deleteSeqNumbers() {

		CsoSeqNumbersDTO csoSeqNumbersDTO = new CsoSeqNumbersDTO();
		CsoSeqNumbersDAO csoSeqNumbersDAO = new CsoSeqNumbersDAO();

		try {

			csoSeqNumbersDAO.delete();

			log.info("Successfully Deleted CSO_SEQ_NUMBERS");
			Utils.logSpolog("Successfully Deleted CSO_SEQ_NUMBERS", PROCESSNAME);

		}
		catch (DAOException e) {

		}
	}

	private void deleteCsoFileSeq() {

		try {
			new Cso_File_seq_DAO().deleteTruncate("TRUNCATE TABLE CSO_FILE_SEQ");
		}
		catch (Exception ex) {
			ex.getMessage();
		}
	}

	private void deleteMasterCardPDS() {
		CsoPaymentMcardPdsDAO csoPaymentMcardPdsDAO = new CsoPaymentMcardPdsDAO();
		try {

			csoPaymentMcardPdsDAO.delete();

			log.info("Successfully Deleted csoPaymentMcardPdsDAO");
			Utils.logSpolog("Successfully Deleted csoPaymentMcardPdsDAO", PROCESSNAME);
		}
		catch (DAOException e) {
			e.getMessage();
		}
	}

	private void resetCoreProcesses() {

		CsoCoreProcessesDTO csoCoreProcessesDTO = new CsoCoreProcessesDTO();
		CsoCoreProcessesDAO csoCoreProcessesDAO = new CsoCoreProcessesDAO(datasource);

		csoCoreProcessesDTO.setActiveInd("N");

		try {

			// csoCoreProcessesDAO.update(csoCoreProcessesDTO);

		}
		catch (Exception e) {
		}

	}

	private void resetBatchProcesses() {
		CsoBatchProcessesDTO csoBatchProcessesDTO = new CsoBatchProcessesDTO();
		CsoBatchProcessesDAO csoBatchProcessesDAO = new CsoBatchProcessesDAO(datasource);

		csoBatchProcessesDTO.setCompleted("N");

		try {

			// csoBatchProcessesDAO.update(csoBatchProcessesDTO);

		}
		catch (Exception e) {

		}
	}

	private List<CsoInputFileControlsDTO> retrieveAllInputFileControls(
			CsoInputFileControlsDTO csoInputFileControlsDTO) {

		List<CsoInputFileControlsDTO> csoInputFileControlsListDTO = new ArrayList<CsoInputFileControlsDTO>();
		CsoInputFileControlsDAO csoInputFileControlsDAO = new CsoInputFileControlsDAO();

		try {

			csoInputFileControlsListDTO = csoInputFileControlsDAO.retrieveRelated(null);

		}
		catch (DAOException e) {
		}
		return csoInputFileControlsListDTO;
	}

	private void deleteHsoInputFileControlsBySeqNumber(CsoInputFileControlsDTO csoInputFile) {

		HsoInputFileControlsDTO hsoInputFileControlsDTO = new HsoInputFileControlsDTO();
		HsoInputFileControlsDAO hsoInputFileControlsDAO = new HsoInputFileControlsDAO(datasource);

		hsoInputFileControlsDTO.setSystemSeqNumber(csoInputFile.getSystemSeqNumber());

		try {

			// hsoInputFileControlsDAO.delete(hsoInputFileControlsDTO);

			log.info("Successfully Deleted HSO_INPUT_FILE_CONTROLS");

		}
		catch (Exception e) {
		}
	}

	private void createHsoInputFileControls(CsoInputFileControlsDTO csoFileInput) {

		HsoInputFileControlsDTO hsoInputFileControlsDTO = new HsoInputFileControlsDTO();
		HsoInputFileControlsDAO hsoInputFileControlsDAO = new HsoInputFileControlsDAO(datasource);

		hsoInputFileControlsDTO.setFileRefNumber(csoFileInput.getFileRefNumber());
		hsoInputFileControlsDTO.setOutputDate(csoFileInput.getOutputDate());
		hsoInputFileControlsDTO.setService(csoFileInput.getService());
		hsoInputFileControlsDTO.setSubService(csoFileInput.getSubService());
		hsoInputFileControlsDTO.setNumberOfRecs(csoFileInput.getNumberOfRecs());
		hsoInputFileControlsDTO.setNumberCredits(csoFileInput.getNumberCredits());
		hsoInputFileControlsDTO.setNumberDebits(csoFileInput.getNumberDebits());
		hsoInputFileControlsDTO.setCreditValue(csoFileInput.getCreditValue());
		hsoInputFileControlsDTO.setDebitValue(csoFileInput.getDebitValue());
		hsoInputFileControlsDTO.setHashTotal(csoFileInput.getHashTotal());
		hsoInputFileControlsDTO.setLastFileIndicator(csoFileInput.getLastFileIndicator());
		hsoInputFileControlsDTO.setProcessStatus(csoFileInput.getProcessStatus());
		hsoInputFileControlsDTO.setExtractedCount(csoFileInput.getExtractedCount());
		hsoInputFileControlsDTO.setExtCredits(csoFileInput.getExtCredits());
		hsoInputFileControlsDTO.setExtDebits(csoFileInput.getExtDebits());
		hsoInputFileControlsDTO.setExtCreditValue(csoFileInput.getCreditValue());
		hsoInputFileControlsDTO.setExtDebitValue(csoFileInput.getDebitValue());
		hsoInputFileControlsDTO.setLastProcessDate(csoFileInput.getLastProcessDate());
		hsoInputFileControlsDTO.setNextOutputDate(csoFileInput.getNextOutputDate());
		hsoInputFileControlsDTO.setSettlementCount(csoFileInput.getSettlementCount());
		hsoInputFileControlsDTO.setLoadDate(csoFileInput.getLoadDate());
		hsoInputFileControlsDTO.setOriginatingMember(csoFileInput.getOriginatingMember());
		hsoInputFileControlsDTO.setNegativeCardCount(csoFileInput.getNegativeCardCount());
		hsoInputFileControlsDTO.setNegativeDuplicateCount(csoFileInput.getNegativeDuplicateCount());
		hsoInputFileControlsDTO.setLastCommitedRecordPointer(csoFileInput.getLastCommitedRecordPointer());
		hsoInputFileControlsDTO.setExcepRepProducedInd(csoFileInput.getExcepRepProducedInd());
		hsoInputFileControlsDTO.setErrorFilename(csoFileInput.getErrorFilename());
		hsoInputFileControlsDTO.setSystemSeqNumber(csoFileInput.getSystemSeqNumber());

		try {

			// hsoInputFileControlsDAO.create(hsoInputFileControlsDTO);

		}
		catch (Exception e) {

		}
	}

	private void deleteHsoAgeingInputFiles() {

		Date date = new Date();
		HsoInputFileControlsDAO hsoInputFileControlsDAO = new HsoInputFileControlsDAO(datasource);

		try {

			// hsoInputFileControlsDAO.deleteAgeing(DateUtil.getNextDate(date, -45));

			log.info("Successfully Deleted HSO_INPUT_FILE_CONTROLS Ageing less than 45 days");

		}
		catch (Exception e) {

		}

	}

	private void deletePaymentInstructionsMcard() throws DAOException {

		CsoPaymentInstructionsMcardDTO csoPaymentInstructionsMcardDTO = new CsoPaymentInstructionsMcardDTO();
		CsoPaymentInstructionsMcardDAO csoPaymentInstructionsMcardDAO = new CsoPaymentInstructionsMcardDAO();
		csoPaymentInstructionsMcardDAO.deletePayment();
		Utils.logSpolog("Successfully Deleted CSO_PAYMENT_INSTRUCTIONS_MCARD", PROCESSNAME);

	}

	private void deletePaymentInstructionsVisa() throws DAOException {

		CSOPaymentInstructionsVisaDAO cSOPaymentInstructionsVisaDAO = new CSOPaymentInstructionsVisaDAO();
		cSOPaymentInstructionsVisaDAO.delete();
		Utils.logSpolog("Successfully Deleted CSO_PAYMENT_INSTRUCTIONS_VISA", PROCESSNAME);
	}

	private void deleteCsoTransactions() throws DAOException {

		CSOTransactionDTO cSOTransactionDTO = new CSOTransactionDTO();
		CsoTransactionsDAO cSOTransactionDAO = new CsoTransactionsDAO();
		cSOTransactionDAO.delete();
		Utils.logSpolog("Successfully Deleted CSO_TRANSACTIONS", PROCESSNAME);

	}

	private void deleteInputFileControls() {
		CsoInputFileControlsDTO csoInputFileControlsDTO = new CsoInputFileControlsDTO();
		CsoInputFileControlsDAO csoInputFileControlsDAO = new CsoInputFileControlsDAO();
		csoInputFileControlsDTO.setProcessStatus("H");

		try {
			csoInputFileControlsDAO.delete();
			Utils.logSpolog("Successfully Deleted CSO_INPUT_FILE_CONTROLS WHERE PROCESS STATUS IS NOT H processStatus",
					PROCESSNAME);

		}
		catch (DAOException e) {
		}
	}

	private void deleteFilesToLoad() {

		CsoOdsFileToLoadDTO csoOdsFileToLoadDTO = new CsoOdsFileToLoadDTO();
		CsoOdsFileToLoadDAO csoOdsFileToLoadDAO = new CsoOdsFileToLoadDAO();

		try {

			csoOdsFileToLoadDAO.delete();

			Utils.logSpolog("Successfully Deleted CSO_ODS_FILE_TO_LOAD", PROCESSNAME);

		}
		catch (DAOException e) {
		}
	}

	private void deleteOutputControls() {

		CsoOutputControlsDTO csoOutputControlsDTO = new CsoOutputControlsDTO();
		CsoOutputControlsDAO csoOutputControlsDAO = new CsoOutputControlsDAO();

		try {

			csoOutputControlsDAO.delete();

			Utils.logSpolog("Successfully Deleted CSO_OUTPUT_CONTROLS", PROCESSNAME);

		}
		catch (DAOException e) {

		}

	}

	private void deleteServiceParameters() throws DAOException {
		CsoServiceParametersDTO csoServiceParametersDTO = new CsoServiceParametersDTO();
		CsoServiceParametersDAO csoServiceParametersDAO = new CsoServiceParametersDAO();
		try {

			csoServiceParametersDAO.delete();

			Utils.logSpolog("Successfully Deleted CSO_SERVICE_PARAMETERS", PROCESSNAME);

		}
		catch (DAOException e) {

		}
	}

	private void deleteSystemParameters() throws DAOException {
		CsoSystemParametersDTO csoSystemParametersDTO = new CsoSystemParametersDTO();
		CsoSystemParametersDAO csoSystemParametersDAO = new CsoSystemParametersDAO();
		try {

			csoSystemParametersDAO.delete();

			Utils.logSpolog("Successfully Deleted CSO_SYSTEM_PARAMETERS", PROCESSNAME);

		}
		catch (DAOException e) {

		}
	}

	private void deleteNegCardInfo() {
		CsoNegcardInfoDTO csoNegcardInfoDTO = new CsoNegcardInfoDTO();
		CsoNegcardInfoDAO csoNegcardInfoDAO = new CsoNegcardInfoDAO();

		try {

			csoNegcardInfoDAO.delete();

			Utils.logSpolog("Successfully Deleted CSO_NEGCARD_INFO", PROCESSNAME);

		}
		catch (DAOException e) {

		}
	}

	private void deleteFleetBindResolved() {

		// CsoFleetBindResolvedDTO csoFleetBindResolvedDTO = new CsoFleetBindResolvedDTO();
		CsoFleetBindResolvedDAO csoFleetBindResolvedDAO = new CsoFleetBindResolvedDAO();
		CsoFleetBillingDAO csoFleetBillingDAO = new CsoFleetBillingDAO();

		try {

			csoFleetBindResolvedDAO.delete();
			Utils.logSpolog("Successfully Deleted CSO_FLEET_BIND_RESOLVED", PROCESSNAME);
			csoFleetBillingDAO.delete();

			Utils.logSpolog("Successfully Deleted CSO_FLEET_BILLING", PROCESSNAME);

		}
		catch (Exception e) {

		}
	}

	private void deleteAgeingSystemParameters(Date processDate) {

		CsoSystemParametersDAO csoSystemParametersDAO = new CsoSystemParametersDAO();
		CsoSystemParametersDTO csoSystemParametersDTO = new CsoSystemParametersDTO();
		csoSystemParametersDTO.setProcessDate(DateUtil.getNextDate(processDate, -366));

		try {
			csoSystemParametersDAO.delete();
			Utils.logSpolog("Successfully Deleted CSO_SYSTEM_PARAMETERS", PROCESSNAME);

		}
		catch (DAOException e) {
			e.printStackTrace();
		}

	}

	private void deleteDelDeliveryFiles() throws DAOException {
		DelDeliveryFilesCCCDTO delDeliveryFilesCCCDTO = new DelDeliveryFilesCCCDTO();
		DelDeliveryFilesCCCDAO delDeliveryFilesCCCDAO = new DelDeliveryFilesCCCDAO();

		delDeliveryFilesCCCDAO.delete();
		Utils.logSpolog("Successfully Deleted DEL_DELIVERY_FILES_CCC", PROCESSNAME);
	}

	private void deleteCSOProgramControls() {
		CsoProgramControlsDAO csoProgramControlsDAO = new CsoProgramControlsDAO();
		try {
			csoProgramControlsDAO.delete();
		}
		catch (DAOException e) {
			e.printStackTrace();
		}

	}

}
