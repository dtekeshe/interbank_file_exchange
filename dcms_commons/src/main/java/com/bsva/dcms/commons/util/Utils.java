package com.bsva.dcms.commons.util;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dcms.commons.dao.CSFSubServicesDAO;
import com.bsva.dcms.commons.dao.CsfDeliveryServicesDAO;
import com.bsva.dcms.commons.dao.CsfProcessScheduleDAO;
import com.bsva.dcms.commons.dao.CsfPublicHolidaysDAO;
import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
import com.bsva.dcms.commons.dao.CsoProgramControlsDAO;
import com.bsva.dcms.commons.dao.CsoScheduleTimesDAO;
import com.bsva.dcms.commons.dao.CsoServiceParametersDAO;
import com.bsva.dcms.commons.dao.CsoSpologDAO;
import com.bsva.dcms.commons.dao.DelDeliveryFilesCCCDAO;
import com.bsva.dcms.commons.dto.CSFSubServicesDTO;
import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
import com.bsva.dcms.commons.dto.CsfProcessScheduleDTO;
import com.bsva.dcms.commons.dto.CsfPublicHolidaysDTO;
import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
import com.bsva.dcms.commons.dto.CsoProgramControlsDTO;
import com.bsva.dcms.commons.dto.CsoScheduleTimesDTO;
import com.bsva.dcms.commons.dto.CsoServiceParametersDTO;
import com.bsva.dcms.commons.dto.CsoSpologDTO;
import com.bsva.dcms.commons.dto.DelDeliveryFilesCCCDTO;
import com.bsva.dcms.commons.enums.Status;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.exceptions.DuplicateProcessException;

/**
 * @author AugustineA
 *
 */

public class Utils {

	private static Logger log = Logger.getLogger(Utils.class);

	private static String serviceName = null;

	private static String subServiceName = null;

	private final static String SPOLOG_FOLDER;

	private final static String FILE_SEPARATOR = "/";

	static {

		Map<String, String> paths = new DirectoryDAO().directories();
		SPOLOG_FOLDER = paths.get("SPOLOG");
	}

	public static boolean IsNumeric(String inStr) {
		if (inStr == null) {
			return false;
		}
		if (inStr.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Takes amount in cents, converts to rands then formats the amount
	 * @param inAmount - amount in cents
	 * @param resultLen - length of the formatted value
	 * @return - amount in rands in the given format
	 */
	public static String formatAmount(long inAmount, int resultLen) {
		return formatAmount((double) inAmount / 100, resultLen);
	}

	/**
	 * Takes amount in rands and formats it
	 * @param inAmount - amount in rands
	 * @param resultLen - length of the formatted amount
	 * @return - amount in rands in the given format
	 */
	public static String formatAmount(double inAmount, int resultLen) {
		String longFormat = "###,###,###,###,###,###,###,###";//for double value with decimals
		boolean ltZero = false;
		if (inAmount < 0) {
			ltZero = true;
			inAmount = inAmount * -1;
		}
		//String retFormat = longFormat.substring(14 - (14 - resultLen));
		DecimalFormat utilFormatter = new DecimalFormat("###,###,###,###,###,##0.00");
		String result = utilFormatter.format(inAmount/100.0).replace(',', ' ');
		if (ltZero) {
			result += "-";
		}
		else {
			result += " ";
		}
		return result;
	}

	public static String formatInteger(int inNumber, int resultLen) {
		return formatInteger((long) inNumber, resultLen);
	}

	public static String formatInteger(long inNumber, int resultLen) {
		String longFormat = "###,###,###,###,###,###,###,###";
		//String retFormat = longFormat.substring(31 - (31 - resultLen));
		boolean ltZero = false;
		if (inNumber < 0) {
			ltZero = true;
			inNumber = inNumber * -1;
		}

		DecimalFormat utilFormatter = new DecimalFormat("###,###,###,###,###,##0.00");
		String result = utilFormatter.format(inNumber/100.0).replace(',', ' ');
		if (ltZero) {
			result += "-";
		}
		else {
			result += " ";
		}
		return result;
	}

	public static String getJulianDate(String inDateCCYYMMDD) {
		if (inDateCCYYMMDD.length() == 8) {
			GregorianCalendar gc = new GregorianCalendar();
			/*
			 * gc.set(GregorianCalendar.DAY_OF_MONTH, Integer.parseInt(inProcDate.substring(6,8)));
			 * gc.set(GregorianCalendar.MONTH, Integer.parseInt(inProcDate.substring(4,6)));
			 * gc.set(GregorianCalendar.YEAR, Integer.parseInt(inProcDate.substring(0,4)));
			 */

			/*
			 * This stupid calendar's month is zero offset, (i.e. January = 0) so we need to subtract 1 from the actual
			 * month! To veryfy, see Gregorian Calendar's static value for the month names.
			 */
			gc.set(Integer.parseInt(inDateCCYYMMDD.substring(0, 4)),
					Integer.parseInt(inDateCCYYMMDD.substring(4, 6)) - 1,
					Integer.parseInt(inDateCCYYMMDD.substring(6, 8)));

			int doy = gc.get(GregorianCalendar.DAY_OF_YEAR);
			return inDateCCYYMMDD.substring(2, 4) + String.format("%03d", doy);
		}
		else {
			return "00000";
		}
	}

	public static byte[] convertToEBCDIC(String inputStr) {
		byte[] outputStr = new byte[inputStr.length()];
		// for (int xx=0;xx<inputStr.length();xx++) {
		// outputStr = AsciiEbcdic.convAsciiBAtoEBCDIC(inputStr);
		// }
		return outputStr;
	}

	public static int getIntFromHexBytes(byte[] inputByteArr) {
		String hexStr = "";
		for (int xx = 0; xx < inputByteArr.length; xx++) {
			hexStr += Integer.toHexString(inputByteArr[xx]);
		}
		return Integer.parseInt(hexStr, 16);
	}

	public static int getIntFromHexBytes(int[] inputIntArr) {
		String hexStr = "";
		for (int xx = 0; xx < inputIntArr.length; xx++) {
			hexStr += Integer.toHexString(inputIntArr[xx]);
		}
		return Integer.parseInt(hexStr, 16);
	}

	public static byte[] extendByteArray(byte[] inByteArr, int extendByLength) {
		byte[] newByteArr = new byte[inByteArr.length + extendByLength];
		System.arraycopy(inByteArr, 0, newByteArr, 0, inByteArr.length);
		return newByteArr;
	}

	public static String padLeft(String s, int n) {
		return String.format("%1$" + n + "s", s);
	}

	public static String padZeroLeft(String s, int n) {
		if (s.length() > n) {
			s = s.substring(s.length() - n);
		}
		return padLeft(s, n).replace(' ', '0');
		// return String.format("%1$" + n + "s", s);
	}

	public static String padZeroLeft(int s, int n) {
		String str = "" + s;
		return padZeroLeft(str, n);
	}

	public static String leftJustifyWithZeros(String s, int length) {
		if (s.length() >= length)
			return s;
		else
			return String.format("%0" + (length - s.length()) + "d%s", 0, s);
	}

	public static String getTime() {

		Date date = new Date();
		Format formatter = new SimpleDateFormat("HH:mm:ss");
		String s = formatter.format(date);

		String[] splist = s.split(":");

		String hour = splist[0];
		String minutes = splist[1];
		String seconds = splist[2];

		return leftJustifyWithZeros(hour, 2) + minutes + seconds;
	}

	@SuppressWarnings("deprecation")
	public static boolean isSubServiceActive(String processName, String service, String subService,
			String inOutIndicator) {

		try {
			serviceName = service;
			subServiceName = subService;

			CsoServiceParametersDTO csoServiceParametersDTO = new CsoServiceParametersDTO();
			// String processDate = BsvTableLookup.getInstance().getProcessDate();
			csoServiceParametersDTO.setService(service);
			csoServiceParametersDTO.setSubService(subService);
			csoServiceParametersDTO.setProcessActiveInd("A");
			csoServiceParametersDTO.setInputRequestClose("N");

			if (inOutIndicator.equalsIgnoreCase("I"))
				csoServiceParametersDTO.setInwardStatus("A");
			else
				csoServiceParametersDTO.setOutwardStatus("N");
			log.debug("csoServiceParametersDTO " + csoServiceParametersDTO.getOutwardStatus());
			CsoServiceParametersDAO csoServiceParametersdao = new CsoServiceParametersDAO();

			CsoServiceParametersDTO csoServiceParametersdto = csoServiceParametersdao.retrieve(csoServiceParametersDTO);
			if (csoServiceParametersdto == null)
				return false;

			// first check to see if the subservice is active
			CSFSubServicesDTO csfSubServicesDTO = new CSFSubServicesDTO();
			csfSubServicesDTO.setService(service);
			csfSubServicesDTO.setSubservice(subService);
			csfSubServicesDTO.setActiveIndicator("Y");
			CSFSubServicesDAO csfSubServicesdao = new CSFSubServicesDAO();
			CSFSubServicesDTO csfSubServicesdto = csfSubServicesdao.retrieve(csfSubServicesDTO);

			if (csfSubServicesdto == null)
				return false;

			// then check to see if this subservice is active for the outward
			String fileService = service;
			String filesubService = subService;
			String outward = inOutIndicator.toUpperCase();
			String activeIndicator = "Y";

			CsfDeliveryServicesDTO csfDeliveryServicesDTO = new CsfDeliveryServicesDTO();
			csfDeliveryServicesDTO.setService(fileService);
			csfDeliveryServicesDTO.setSubService(filesubService);
			csfDeliveryServicesDTO.setInwardOutwardInd(outward);
			csfDeliveryServicesDTO.setActiveIndicator(activeIndicator);
			CsfDeliveryServicesDAO csfDeliveryServicesdao = new CsfDeliveryServicesDAO();
			CsfDeliveryServicesDTO csfDeliveryServicesdto = csfDeliveryServicesdao.retrieve(csfDeliveryServicesDTO);

			if (csfDeliveryServicesdto == null)
				return false;
		}
		catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}

		return true;
	}

	// insert entry into program control table
	public static void logProcess(String processName, String fileName, String service, String subService, String status)
			throws DuplicateProcessException {

		try {
			CsoProgramControlsDTO progCtrlDto = new CsoProgramControlsDTO();
			progCtrlDto.setProgramName(processName);
			progCtrlDto.setServiceCode(service);
			progCtrlDto.setSubServiceCode(subService);
			progCtrlDto.setArbData(fileName);
			CsoProgramControlsDAO prgCtrlDao = new CsoProgramControlsDAO();
			CsoProgramControlsDTO progCtrlDtos = prgCtrlDao.retrieve(progCtrlDto);

			if (progCtrlDtos == null) {
				// else insert with this new status
				CsoProgramControlsDTO progCtrlDto1 = new CsoProgramControlsDTO();
				progCtrlDto1.setProgramName(processName);
				progCtrlDto1.setServiceCode(service);
				progCtrlDto1.setSubServiceCode(subService);
				progCtrlDto1.setArbData(fileName);
				progCtrlDto1.setStatus(status);
				CsoProgramControlsDAO prgCtrlDao1 = new CsoProgramControlsDAO();
				prgCtrlDao1.create(progCtrlDto1);
				log.debug("Logged process " + processName + " ,arbdata = " + fileName + " ,status = " + status);
			}
			else {

				String programStatus = progCtrlDtos.getStatus();

				if (programStatus.equals("F")) {
					updateProcess(processName, fileName, service, subService, "A");
				}
				else {
					throw new DuplicateProcessException(
							"Process " + processName + " already started for filename " + fileName);
				}

			}

		}
		catch (DuplicateProcessException e) {
			/*
			 * note, this is done because we need to send this exception up the stack, but we wanna handle all the other
			 * exceptions within the next catch block
			 */

			throw new DuplicateProcessException(e.getMessage());
		}
		catch (Exception e) {
			log.error("Unable to log process " + processName + " for file " + fileName, e);
		}
	}

	// update existing entry in program control table with a new status
	public static void updateProcess(String processName, String fileName, String service, String subService,
			String status) {

		try {
			CsoProgramControlsDTO progCtrlDto = new CsoProgramControlsDTO();
			progCtrlDto.setProgramName(processName);
			progCtrlDto.setServiceCode(service);
			progCtrlDto.setSubServiceCode(subService);
			progCtrlDto.setStatus(status);
			progCtrlDto.setArbData(fileName);

			CsoProgramControlsDAO prgCtrlDao = new CsoProgramControlsDAO();
			prgCtrlDao.update(progCtrlDto);

			// updateProcessSchedule(connection, processName, service, subService, status.equalsIgnoreCase("C") ? "N" :
			// "Y");

			log.debug("Updated process " + processName + " ,arbdata = " + fileName + " ,status = " + status);

		}
		catch (Exception e) {
			log.error("Unable to log process " + processName + " for file " + fileName, e);
		}
	}

	public static void updateProcessSchedule(String processName, String service, String subservice, String status) {

		try {
			CsoScheduleTimesDTO csoScheduleTimesDTO = new CsoScheduleTimesDTO();
			csoScheduleTimesDTO.setBusyInd(status);
			csoScheduleTimesDTO.setProcess(processName);
			csoScheduleTimesDTO.setService(service);
			csoScheduleTimesDTO.setSubService(subservice);
			if ("SETTLE".equals(csoScheduleTimesDTO.getProcess())) {
				csoScheduleTimesDTO.setActiveInd("Y");
			}
			else {
				csoScheduleTimesDTO.setActiveInd("N");
			}
			CsoScheduleTimesDAO csoScheduleTimesdao = new CsoScheduleTimesDAO();
			csoScheduleTimesdao.update(csoScheduleTimesDTO);

			log.debug("Updated schedule for process " + processName + " to status " + status);

		}
		catch (Exception e) {
			log.error("Unable to update schedule for process " + processName + " to status " + status, e);
		}
	}

	// insert file details into del-delivery
	public static void logDelDelivery(String fileName, String inputOutpt, int memberNo, String ioStatus) {

		try {

			String queueFileName = inputOutpt.equals("I") ? "INQUE" : "OUTQUE";
			DelDeliveryFilesCCCDTO delDto = new DelDeliveryFilesCCCDTO();
			delDto.setQueueFileName(queueFileName);
			delDto.setPrddate(Integer.parseInt(BsvTableLookup.getInstance().getProcessDate()));
			delDto.setMember(memberNo);
			delDto.setFileName(fileName);

			if (inputOutpt.equals("I"))
				delDto.setXmitInd(ioStatus);
			else
				delDto.setDeliveryStatus(ioStatus);

			int position = getNextPosition(queueFileName);
			delDto.setPosition(position);
			DelDeliveryFilesCCCDAO delDeliveryFilesCCCdao = new DelDeliveryFilesCCCDAO();
			delDeliveryFilesCCCdao.create(delDto);

			log.debug("Logged file " + fileName + " to del delivery");
		}
		catch (Exception e) {
			log.error(
					"Unable to create " + inputOutpt + " " + fileName + " with status " + ioStatus + "on del-delivery",
					e);
		}
	}

	private static int getNextPosition(String queueFileName) throws DAOException {

		DelDeliveryFilesCCCDTO delDto = new DelDeliveryFilesCCCDTO();
		DelDeliveryFilesCCCDAO delDeliveryFilesCCCDdao = new DelDeliveryFilesCCCDAO();
		List<DelDeliveryFilesCCCDTO> delDeliveryFilesCCCDTO = delDeliveryFilesCCCDdao.retrieveRelated(delDto);
		// delDto.setQueueFileName(queueFileName);

		int result = delDeliveryFilesCCCDTO.size() + 1;

		return result;
	}
	// update del delivery entry with a new status
	/*
	 * public static void updateDelDeliveryStatus(String fileName, String xmitInd ){
	 * 
	 * try{ DelDeliveryFilesCCCDTO delDto = new DelDeliveryFilesCCCDTO(); delDto.setFileName(fileName);
	 * delDto.setPrddate(Integer.parseInt(BsvTableLookup.getInstance().getProcessDate())); delDto.setXmitInd(xmitInd);
	 * DelDeliveryFilesCCCDAO delDeliveryFilesCCCDdao = new DelDeliveryFilesCCCDAO();
	 * delDeliveryFilesCCCDdao.update(delDto);
	 * 
	 * log.debug("Updated file " + fileName + " on del delivery to status " + xmitInd); }catch(Exception e){
	 * log.error("Unable to update " + fileName + " to status " + xmitInd + "on del-delivery" , e); } }
	 */

	public static void updateDelDeliveryStatus(String fileName, int position, String qfilename, String xmitInd) {

		try {
			DelDeliveryFilesCCCDTO delDto = new DelDeliveryFilesCCCDTO();
			delDto.setFileName(fileName);
			delDto.setPosition(position);
			delDto.setQueueFileName(qfilename);
			delDto.setPrddate(Integer.parseInt(BsvTableLookup.getInstance().getProcessDate()));
			delDto.setXmitInd(xmitInd);
			DelDeliveryFilesCCCDAO delDeliveryFilesCCCDdao = new DelDeliveryFilesCCCDAO();
			delDeliveryFilesCCCDdao.update(delDto);

			log.debug("Updated file " + fileName + " on del delivery to status " + xmitInd);

		}
		catch (Exception e) {
			log.error("Unable to update " + fileName + " to status " + xmitInd + "on del-delivery", e);
		}
	}

	public static void logSpolog(String message, String processName) {

		String packageName = processName;
		String version = "  01";
		String spologDir = SPOLOG_FOLDER;// BsvTableLookup.getInstance().getSpologDir();
		String spologFileName = "DMC.spo";
		/*
		 * try { CsoSpologDTO csoSpologDTO = new CsoSpologDTO(); CsoSpologDAO dao = new CsoSpologDAO();
		 * 
		 * Calendar cal = Calendar.getInstance(); cal.setTime(new Date()); Date date = cal.getTime();
		 * 
		 * csoSpologDTO.setMessage(message); csoSpologDTO.setMessageSeq(date.getTime());
		 * csoSpologDTO.setProcessName("processName"); csoSpologDTO.setProcessNameSeq(date.getTime());
		 * csoSpologDTO.setVersion("version");
		 * 
		 * dao.create(csoSpologDTO);
		 * 
		 * } catch (DAOException e) { e.getMessage(); }
		 */

		logToFile(spologDir, spologFileName, packageName, version, message);

	}

	public static void logSpologDel(String message, String processName) {// ,String processName,String version){

		String packageName = processName;
		String version = "  01";
		String spologDir = SPOLOG_FOLDER; // BsvTableLookup.getInstance().getSpologDir();
		String spologFileName = "DEL.spo";

		logToFile(spologDir, spologFileName, packageName, version, message);

	}

	private static void logToFile(String dirPath, String fileName, String packageName, String version, String message) {

		PrintWriter writer = null;

		try {
			writer = new PrintWriter(new FileWriter(dirPath + File.separator + fileName, true));

			String line = DateUtil.formatDate(new Date(), "HH:mm:ss") + " "
					+ StringUtil.leftJustify(packageName.toUpperCase(), StringUtil.SPACE_STRING, 10) + version + " "
					+ message;
			writer.println(line);
			writer.flush();

			if (writer != null)
				writer.close();

		}
		catch (Exception e) {
			log.error("Could not write message " + message + "to spolog", e);
		}

	}

	public static void updateFileStatus(String fileRefNumber, String status) {
		try {
			CsoInputFileControlsDAO csoInputFileControlsdao = new CsoInputFileControlsDAO();
			CsoInputFileControlsDTO csoInputFileControlsDTO = new CsoInputFileControlsDTO();
			csoInputFileControlsDTO.setFileRefNumber(fileRefNumber);

			CsoInputFileControlsDTO csoInputFileControl = csoInputFileControlsdao.retrieve(csoInputFileControlsDTO);
			if (csoInputFileControl != null) {
				CsoInputFileControlsDTO csoInputFileControlsDto = new CsoInputFileControlsDTO();
				csoInputFileControlsDto.setFileRefNumber(csoInputFileControl.getFileRefNumber());
				csoInputFileControlsDto.setOutputDate(csoInputFileControl.getOutputDate());
				csoInputFileControlsDto.setService(csoInputFileControl.getService());
				csoInputFileControlsDto.setSubService(csoInputFileControl.getSubService());
				csoInputFileControlsDto.setNumberOfRecs(csoInputFileControl.getNumberOfRecs());
				csoInputFileControlsDto.setNumberDebits(csoInputFileControl.getNumberCredits());
				csoInputFileControlsDto.setNumberDebits(csoInputFileControl.getNumberDebits());
				csoInputFileControlsDto.setCreditValue(csoInputFileControl.getCreditValue());
				csoInputFileControlsDto.setDebitValue(csoInputFileControl.getDebitValue());
				csoInputFileControlsDto.setHashTotal(csoInputFileControl.getHashTotal());
				csoInputFileControlsDto.setLastFileIndicator(csoInputFileControl.getLastFileIndicator());
				csoInputFileControlsDto.setProcessStatus(status);
				csoInputFileControlsDto.setExtractedCount(csoInputFileControl.getExtractedCount());
				csoInputFileControlsDto.setExtCredits(csoInputFileControl.getExtCredits());
				csoInputFileControlsDto.setExtDebits(csoInputFileControl.getExtDebits());
				csoInputFileControlsDto.setExtCreditValue(csoInputFileControl.getExtCreditValue());
				csoInputFileControlsDto.setExtDebitValue(csoInputFileControl.getExtDebitValue());
				csoInputFileControlsDto.setLastProcessDate(csoInputFileControl.getLastProcessDate());
				csoInputFileControlsDto.setNextOutputDate(csoInputFileControl.getNextOutputDate());
				csoInputFileControlsDto.setSettlementCount(csoInputFileControl.getSettlementCount());
				csoInputFileControlsDto.setLoadDate(csoInputFileControl.getLoadDate());
				csoInputFileControlsDto.setOriginatingMember(csoInputFileControl.getOriginatingMember());
				csoInputFileControlsDto.setNegativeCardCount(csoInputFileControl.getNegativeCardCount());
				csoInputFileControlsDto.setNegativeDuplicateCount(csoInputFileControl.getNegativeDuplicateCount());
				csoInputFileControlsDto
						.setLastCommitedRecordPointer(csoInputFileControl.getLastCommitedRecordPointer());
				csoInputFileControlsDto.setExcepRepProducedInd(csoInputFileControl.getExcepRepProducedInd());
				csoInputFileControlsDto.setErrorFilename(csoInputFileControl.getErrorFilename());
				csoInputFileControlsDto.setSystemSeqNumber(csoInputFileControl.getSystemSeqNumber());
				csoInputFileControlsDto.setOdsDataStatus(csoInputFileControl.getOdsDataStatus());

				csoInputFileControlsdao.update(csoInputFileControlsDto);
			}
		}
		catch (DAOException e) {
			log.error(e.getMessage(), e);
		}

	}

	public static boolean isProcessActivated(String processName, String service, String subService) {
		// then check the time when the subservice is supposed to be running
		try {
			CsoScheduleTimesDTO dto = new CsoScheduleTimesDTO();
			dto.setProcess(processName);
			if (!service.trim().equals("")) {
				dto.setService(service);
			}

			if (!service.trim().equals("")) {
				dto.setSubService(subService);
			}

			CsoScheduleTimesDAO dao = new CsoScheduleTimesDAO();
			CsoScheduleTimesDTO dsoScheduleTimesDto = dao.retrieve(dto);
			if (dsoScheduleTimesDto.getProcess() != null) {
				// start time
				String startTime = dsoScheduleTimesDto.getStartTime() == null ? "00:00:00"
						: dsoScheduleTimesDto.getStartTime();
				Date startTimeDate = DateUtil.formatStringToDate(startTime, "HH:mm:ss");
				Calendar startTimeCal = new GregorianCalendar();
				startTimeCal.setTime(startTimeDate);

				// end time
				String endTime = dsoScheduleTimesDto.getEndTime() == null ? "23:59:59"
						: dsoScheduleTimesDto.getEndTime();
				Date endTimeDate = DateUtil.formatStringToDate(endTime, "HH:mm:ss");
				Calendar endTimeCal = new GregorianCalendar();
				endTimeCal.setTime(endTimeDate);

				// current time
				String currentTime = DateUtil.formatDate(new Date(), "HH:mm:ss"); // this is so we can strip only the
																					// time off from the date object
				Date currentTimeDate = DateUtil.formatStringToDate(currentTime, "HH:mm:ss");
				Calendar currentTimeCal = new GregorianCalendar();
				currentTimeCal.setTime(currentTimeDate);

				// sub service has to be active and has a start and end time for activity
				if (dsoScheduleTimesDto.getActiveInd().equalsIgnoreCase(Status.Y.getSymbol())
						&& (currentTimeCal.after(startTimeCal) && currentTimeCal.before(endTimeCal))) {
					return true;
				}
				else {
					return false;
				}
			}
			return false;

		}
		catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}

	public static void updateProcessActiveInd(String process, String service, String subService, String statusInd,
			Date processDate) {
		CsoScheduleTimesDTO csoScheduleTimesDTO = new CsoScheduleTimesDTO();

		csoScheduleTimesDTO.setService(service);
		csoScheduleTimesDTO.setSubService(subService);
		csoScheduleTimesDTO.setProcess(process);
		csoScheduleTimesDTO.setCheckPoint("N");
		csoScheduleTimesDTO.setBusyInd("N");
		csoScheduleTimesDTO.setStartTime("07:00:00");
		if (processDate != null) {
			DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strdate2 = targetFormat.format(processDate);
			csoScheduleTimesDTO.setProcessDate(strdate2);
		}
		if ("SETTLE".equals(csoScheduleTimesDTO.getProcess())) {
			csoScheduleTimesDTO.setActiveInd("Y");
		}
		else if ("EOD".equals(csoScheduleTimesDTO.getProcess())) {
			csoScheduleTimesDTO.setActiveInd("Y");
		}
		else {
			csoScheduleTimesDTO.setActiveInd(statusInd);
		}

		try {

			CsoScheduleTimesDAO csoScheduleTimesDAO = new CsoScheduleTimesDAO();
			csoScheduleTimesDAO.update(csoScheduleTimesDTO);
		}
		catch (DAOException e) {
			e.printStackTrace();
		}

	}

	public static Date getNextOutputDate(Date currentProcessingDate) {

		Date nextProcessingDate = null;
		try {

			//// String processDate = "20160325"; // to test the holidays
			// nextProcessingDate = DateUtil.formatStringToDate(processDate, "yyyyMMdd");
			nextProcessingDate = currentProcessingDate;
		}
		catch (Exception e) {
			nextProcessingDate = new Date();
		}

		Calendar cal = new GregorianCalendar();
		cal.setTime(nextProcessingDate);

		boolean foundNextBusinessDate = false;

		while (!foundNextBusinessDate) {

			if (isValidBusinessDate(cal.getTime()))
				foundNextBusinessDate = true;
			else
				cal.add(Calendar.DAY_OF_MONTH, 1);
		}

		return (Date) cal.getTime();
	}

	public static boolean isValidBusinessDate(Date date) {

		// Only on sunday will Start Of Day not run
		CsfProcessScheduleDAO processSchedule = new CsfProcessScheduleDAO();
		try {
			List<CsfProcessScheduleDTO> processList = processSchedule.retrieveRelated(null);
			for (CsfProcessScheduleDTO csfProcessScheduleDTO : processList) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);				//cal.add(Calendar.DAY_OF_MONTH, -1);
				int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
				if ((csfProcessScheduleDTO.getDayNumber() == dayOfWeek)
						&& (csfProcessScheduleDTO.getProcessIndicator().equals("N"))) {
					return false;
				}
			}

			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(date);
			cal2.add(Calendar.DAY_OF_MONTH, -1);
			CsfPublicHolidaysDTO publicHol = new CsfPublicHolidaysDTO();
			publicHol.setProcessDate(cal2.getTime());
			//publicHol.setPublicHolidayIndicator("Y");
			CsfPublicHolidaysDAO publicHolDao = new CsfPublicHolidaysDAO();
			CsfPublicHolidaysDTO csfPublicHolidaysDto = publicHolDao.retrieve(publicHol);
			if (csfPublicHolidaysDto != null) {
				return true;
			}
			

		}
		catch (DAOException e) {
			return false;
		}
		return true;

	}
}
