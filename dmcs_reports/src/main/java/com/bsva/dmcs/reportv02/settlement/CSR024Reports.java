/**
 * 
 */
package com.bsva.dmcs.reportv02.settlement;

import static com.bsva.dmcs.reportv02.util.StringUtils.format;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dcms.commons.dao.CSFCardTypesDAO;
import com.bsva.dcms.commons.dao.CsfSystemSettingsDAO;
import com.bsva.dcms.commons.dto.CSFCardTypesDTO;
import com.bsva.dcms.commons.dto.CsfSystemSettingsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dmcs.file.reports.FooterRecord;
import com.bsva.dmcs.reportv02.dto.FileHeaderDto;
import com.bsva.dmcs.reportv02.dto.FilesSubHeaderDto;
import com.bsva.dmcs.reportv02.util.Justification;
import com.bsva.entities.CsoInputFileControls;

/**
 * @author AugustineA
 *
 */
public class CSR024Reports {

	private long transCount = 0;
	private long transAmount = 0;
	private String subService = null;
	private PrintWriter pw = null;
	private final static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("HHmmss");
	private static final String NEW_LINE_SEPARATOR = "\n";
	private final static String REPORT_FOLDER;
	private final static String FILE_SEPARATOR = System.getProperty("file.separator");
	protected final static Map<String, String> SUB_SERVICE_MNEMONICS;
	private static String reportId = "CSR024";
	private static String filename = null;
	private static int numberCount = 14;
	private static BufferedWriter fileWriter = null;
	private static String LINE_SEPARATOR = System.lineSeparator();
	
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
		CsfSystemSettingsDTO csfSystemSettingsDTO = new CsfSystemSettingsDTO();
		csfSystemSettingsDTO.setSettingCode("FILENAME");
		CsfSystemSettingsDTO settingsname = new CsfSystemSettingsDAO().retrieve(csfSystemSettingsDTO);
		String serviceCode = settingsname.getSettingValue();
		// create output file
		filename = ccr00xFilename(subservice, serviceCode);
		String filepath = ccr00xFilepath(filename);
		
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
		headerFile.setReportName("CSR024");
		pw.write(headerFile.toString()+"\n");
		
		FilesSubHeaderDto filsSubHeaderDto = new FilesSubHeaderDto();
		filsSubHeaderDto.setBankName("BNK");
		filsSubHeaderDto.setReportName("CSR024");
		filsSubHeaderDto.setTimeStamp("TIME : "+"13H36");
		filsSubHeaderDto.setBankLongName("B A N K S E R V   (P T Y)   L T D ");
		String procDateHeader1 = processDate.toString().substring(0, 10).replace("-", "/").replace(" ", "");
		filsSubHeaderDto.setDate(procDateHeader1);
		filsSubHeaderDto.setPage("PAGE:");
		filsSubHeaderDto.setPageNumber("1");
		
		String registration = "					 REG. NO. 1993/07766/06";
		String interNalLine = "**** INTERNAL ****                    SUMMARY OF CCC INPUT";
		String serviceName = "			SERVICE : CARD	";
		String subServiceName = "SUB SERVICE : "+subservice;
		String keyToStatus = "				K E Y   T O   S T A T U S   C O D E S   ";
		String underLine = "			======================================================";
		
		pw.write(filsSubHeaderDto.toString()+"\n");
		pw.write(System.lineSeparator());
		pw.write(System.lineSeparator());
		pw.write(registration);
		pw.write(System.lineSeparator());
		pw.write(System.lineSeparator());
		pw.write(interNalLine);
		pw.write(System.lineSeparator());
		pw.write(System.lineSeparator());
		pw.write(serviceName + subServiceName);
		pw.write(System.lineSeparator());
		pw.write(System.lineSeparator());
		pw.write(System.lineSeparator());
		pw.write(keyToStatus);
		pw.write(System.lineSeparator());
		pw.write(underLine);
		pw.write(System.lineSeparator());
		pw.write(System.lineSeparator());
		pw.write(System.lineSeparator());
		//Create Data here 
		writColumnHeaders(pw);
		
		
		//end create Data here 
		
		//setting Footers	
		pw.write(System.lineSeparator());
		footerRecord.setRecorIdentifier("99");
		footerRecord.setOutputDate(procDateHeader);
		footerRecord.setServiceType("CARD");
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
	
	public static void writColumnHeaders(PrintWriter pw ){
		
        String s =
                format( "", 15, ' ', Justification.LEFT) +
                format( "LOAD", 10, ' ', Justification.RIGHT) +
                format( "FILENAME", 12, ' ', Justification.RIGHT) +
                format( "ACQ.NAME", 12, ' ', Justification.RIGHT) +
                format( "STATUS", 12, ' ', Justification.RIGHT) +
                format( "REJECTS", 14, ' ', Justification.RIGHT) +
                format( "NUMBER", 14, ' ', Justification.RIGHT)+
        		format( "VALUE", 14, ' ', Justification.RIGHT)+
        		 format( "NUMBER", 14, ' ', Justification.RIGHT)+
        		 format( "NUMBER", 14, ' ', Justification.RIGHT);

        pw.println( s );

        s =
                format( "", 15, ' ', Justification.RIGHT) +
                format( "DATE", 10, ' ', Justification.RIGHT) +
                format( "", 46, ' ', Justification.RIGHT) +
                format( "OF", 18, ' ', Justification.RIGHT) +
                format( "OF", 15, ' ', Justification.RIGHT) +
                format( "OF", 11, ' ', Justification.RIGHT) +
                format( "OF", 11, ' ', Justification.RIGHT);
        
        pw.println( s );
        
        s =
                format( "", 67, ' ', Justification.RIGHT) +
                format( "TRANSACTIONS", 13, ' ', Justification.RIGHT) +
                format( "TRANSACTIONS", 14, ' ', Justification.RIGHT) +
                format( "NEGATIVES", 13, ' ', Justification.RIGHT) +
                format( "DUPLICATES", 13, ' ', Justification.RIGHT);

        pw.println( s + LINE_SEPARATOR );
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
		CSR024Reports ccr420Reports = new CSR024Reports();
		try {
			ccr420Reports.getData("VISA CARD");
		} catch (FileNotFoundException | DAOException e) {
			e.printStackTrace();
		}
	}

}
