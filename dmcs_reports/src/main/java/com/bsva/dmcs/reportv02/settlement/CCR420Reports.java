/**
 * 
 */
package com.bsva.dmcs.reportv02.settlement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dao.v02.members.InputFileControlDAO;
import com.bsva.dcms.commons.dao.CSFCardTypesDAO;
import com.bsva.dcms.commons.dao.CsfSystemSettingsDAO;
import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
import com.bsva.dcms.commons.dao.CsoTransactionsDAO;
import com.bsva.dcms.commons.dto.CSFCardTypesDTO;
import com.bsva.dcms.commons.dto.CSOTransactionDTO;
import com.bsva.dcms.commons.dto.CsfSystemSettingsDTO;
import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dmcs.file.reports.CCR420FileReportsDto;
import com.bsva.dmcs.file.reports.CCR420FileReportsHeader;
import com.bsva.dmcs.file.reports.CCR420TransReportsDto;
import com.bsva.dmcs.file.reports.CCR420TransReportsHeader;
import com.bsva.dmcs.file.reports.FooterRecord;
import com.bsva.dmcs.reportv02.dto.FileDistributionReportDto;
import com.bsva.dmcs.reportv02.dto.FileHeaderDto;
import com.bsva.dmcs.reportv02.dto.FilesSubHeaderDto;
import com.bsva.entities.CsoInputFileControls;
import com.bsva.entities.v02.billing.InputFileControlSummaryEntity;

/**
 * @author AugustineA
 *
 */
public class CCR420Reports {

	private long transCount = 0;
	private long transAmount = 0;
	private String subService = null;
	private PrintWriter pw = null;
	private final static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("HHmmss");
	private static final String NEW_LINE_SEPARATOR = "\n";
	private final static String REPORT_FOLDER;
	private final static String FILE_SEPARATOR = System.getProperty("file.separator");
	protected final static Map<String, String> SUB_SERVICE_MNEMONICS;
	private static String reportId = "CSR420";
	private static String filename = null;
	private static int numberCount = 14;
	private static BufferedWriter fileWriter = null;
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	
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
	public Set<String> filterListData(List<CsoInputFileControls> listData) {

		Set<String> dataset = new HashSet<>();
		for (CsoInputFileControls inputFile: listData) {
			dataset.add(inputFile.getSubService());
		}
		return dataset;
	}
	public static String ccr00xFilename(String subServiceID, String issuerMemberCode) {
		Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();
		String procDateHeader = processDate.toString().substring(0, 10).replace("-", "").replace(" ", "");
		return  reportId + "." + SUB_SERVICE_MNEMONICS.get(subServiceID) + procDateHeader
				+"."+ TIMESTAMP_FORMAT.format(new Date()) +"."+ issuerMemberCode;
	}
	
	public void getData(String subservice) throws DAOException, FileNotFoundException{
		try{
		Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();
		String procDateHeader = processDate.toString().substring(0, 10).replace("-", "").replace(" ", "");
		CCR420FileReportsDto ccr420FileReportsDto = new CCR420FileReportsDto();
		CCR420TransReportsDto ccr420TransReportsDto = new CCR420TransReportsDto();
		CCR420FileReportsHeader ccr420FileReportsHeader = new CCR420FileReportsHeader();
		CCR420TransReportsHeader ccr420TransReportsHeader = new CCR420TransReportsHeader();
		
		CsfSystemSettingsDTO csfSystemSettingsDTO = new CsfSystemSettingsDTO();
		csfSystemSettingsDTO.setSettingCode("FILENAME");
		CsfSystemSettingsDTO settingsname = new CsfSystemSettingsDAO().retrieve(csfSystemSettingsDTO);
		String serviceCode = settingsname.getSettingValue();
		// create output file
		filename = ccr00xFilename(subservice, serviceCode);
		String filepath = ccr00xFilepath(filename);
		//fileWriter = new BufferedWriter(new FileWriter(filepath));
		
		 pw = new PrintWriter(new File(filepath));
		
		FileHeaderDto headerFile = new FileHeaderDto();
		FooterRecord footerRecord = new FooterRecord();
		
		//setting Headers		
		headerFile.setRecordId("01");
		headerFile.setOutputDate(processDate.toString().replace("-", ""));
		headerFile.setService("CARD");
		headerFile.setSubService("REPORTS");
		headerFile.setBankMemberNumber("");
		headerFile.setOriginator("ACBJ");
		headerFile.setDataType("DATA");
		headerFile.setDataDirection("OUT");
		headerFile.setSettlementDate(processDate.toString().replace("-", ""));
		headerFile.setTestLiveInd("LIVE");
		headerFile.setNumber("01320");
		headerFile.setReportName("CSR420");
		
		FilesSubHeaderDto filsSubHeaderDto = new FilesSubHeaderDto();
		filsSubHeaderDto.setBankName("BNK");
		filsSubHeaderDto.setReportName("CSR420");
		filsSubHeaderDto.setTimeStamp("TIME : "+"13H36");
		filsSubHeaderDto.setBankLongName("B A N K S E R V   (P T Y)   L T D ");
		filsSubHeaderDto.setDate(formatter.format(processDate));
		filsSubHeaderDto.setPage("PAGE:");
		filsSubHeaderDto.setPageNumber("1");
		
		String registration = "REG. NO. 1993/07766/06";
		
		
		
		FileDistributionReportDto fileDistributionReportDto = new FileDistributionReportDto();
		fileDistributionReportDto.setInternal("**** INTERNAL ****");
		fileDistributionReportDto.setTrxnDisReport("T R A N S A C T I O N  D I S T R I B U T I O N  R E P O R T");
		fileDistributionReportDto.setTrxnCarriedForward("TRANSACTIONS CARRIED FORWARD FOR: ");
		fileDistributionReportDto.setTrxnCarriedForwardDate(formatter.format(processDate));
		
	    
	    fileDistributionReportDto.setService("SERVICE");
	    fileDistributionReportDto.setSubService(" SUB-SERVICE");
	    fileDistributionReportDto.setTypeCode("TYPE/CODE");
	    fileDistributionReportDto.setCreditVolume("VOLUMES");
	    fileDistributionReportDto.setCreditValue("VALUES");
	    
	    fileDistributionReportDto.setUnderService("-------");
	    fileDistributionReportDto.setUnderSubService("-----------");
	    fileDistributionReportDto.setUnderTypeCode("---------");
	    fileDistributionReportDto.setUnderDebitVolume("-----------");
	    fileDistributionReportDto.setUnderDebitValue("------------");
	    //writing tthe reports data
	    List<InputFileControlSummaryEntity> csoInputFileControls = new InputFileControlDAO().getSubServices(subservice);
	    if(csoInputFileControls.isEmpty()){
			for (InputFileControlSummaryEntity inputFileControlSummaryEntity : csoInputFileControls) {
				fileDistributionReportDto.setPaymentDebitValue(String.valueOf(inputFileControlSummaryEntity.getAmount().setScale(2, RoundingMode.HALF_UP)));
				fileDistributionReportDto.setPaymentDebitVolume(String.valueOf(inputFileControlSummaryEntity.getCount()));
				numberCount += 1;
			}
	    }else{
	    	fileDistributionReportDto.setPaymentDebitValue("0000.00");
			fileDistributionReportDto.setPaymentDebitVolume("0000.00");
			numberCount += 1;
	    }
	    
	    
	    fileDistributionReportDto.setNoService("CARD");
	    fileDistributionReportDto.setPaymentSubService(subservice);    
		
		pw.write(headerFile.toString());
		pw.write(filsSubHeaderDto.toString());
		pw.write(registration);
		
		
		pw.write(fileDistributionReportDto.toString());
		pw.write(ccr420FileReportsHeader.toString());
		pw.write(System.lineSeparator());
		pw.flush();
		
		transCount = 0;
		transAmount = 0;
		
		//setting Footers	
		footerRecord.setRecorIdentifier("99");
		footerRecord.setOutputDate(procDateHeader);
		footerRecord.setServiceType("");
		footerRecord.setSubServiceType("REPORTS");
		footerRecord.setBankMemberNumber("000000");
		footerRecord.setNumberOfTransmissionFiles(""+numberCount);
		footerRecord.setNumberOfCreditRecords("00000000");
		footerRecord.setNumberOfDebitRecords("       ");
		footerRecord.setValueOfCreditRecords("        ");
		footerRecord.setValueOfDebitRecords("        ");
		footerRecord.setHashTotalOfAccount("        ");
		footerRecord.setFiller("000000000000000000000000000000000000000000000000000000000000");
		pw.write(footerRecord.toString()+"\n");
		pw.flush();
		
		}catch(Exception e){
			e.getMessage();
		}finally{
			if(pw != null){
				pw.close();
			}
		}
				
	}
	
	public static String ccr00xFilepath(String filename) {
		return REPORT_FOLDER + FILE_SEPARATOR + filename;
	}
	//getting the card type
	public String getCardType(String cardTypes){
		
		String cardType = null;
		
		CSFCardTypesDTO csf_cardTypes = new CSFCardTypesDTO();
		csf_cardTypes.setCardDescription(cardTypes);
		CSFCardTypesDAO csfcardDao = new CSFCardTypesDAO();
		try {
			List<CSFCardTypesDTO> csfCardTypesDTO = csfcardDao.retrieveRelated(csf_cardTypes);
			for (CSFCardTypesDTO csfCardTypesDTO2 : csfCardTypesDTO) {
				if(csfCardTypesDTO2.getSubService().equals(cardTypes)){
					cardType  = String.valueOf(csfCardTypesDTO2.getCardType());
					break;
				}
			}
		} catch (DAOException e) {
			e.getMessage();
		}
		
		return cardType;
	}
	
	public static void  main(String[] args){
		CCR420Reports ccr420Reports = new CCR420Reports();
		try {
			ccr420Reports.getData("MASTERCARD");
		} catch (FileNotFoundException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
