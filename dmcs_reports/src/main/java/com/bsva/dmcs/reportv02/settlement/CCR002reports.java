package com.bsva.dmcs.reportv02.settlement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.batik.css.engine.value.Value;

import com.bsva.commonsv02.util.SPOLogger;
import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dao.v02.members.Csv_Ccr002_ViewDAO;
import com.bsva.dcms.commons.dao.CSFMembersServiceDAO;
import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dmcs.reportv02.dto.FileFooterDto;
import com.bsva.dmcs.reportv02.dto.FileHeaderDto;
import com.bsva.dmcs.reportv02.dto.FileReportDetails;
import com.bsva.dmcs.reportv02.dto.FileTrxnDetails;
import com.bsva.dmcs.reportv02.util.Justification;
import com.bsva.dmcs.reportv02.util.MathUtils;
import com.bsva.dto.ContentType;
import com.bsva.dto.Direction;
import com.bsva.dto.Environment;
import com.bsva.dto.FileHeaderDTO;
import com.bsva.entities.CsvCcr002View;
import com.bsva.entities.v02.params.CompanyParametersEntity;

/**
 * @author AugustineA
 *
 */
public class CCR002reports {
	private final static String FILE_SEPARATOR = System.getProperty("file.separator");
	protected final static Map<String, String> SUB_SERVICE_MNEMONICS;
	static {
		SUB_SERVICE_MNEMONICS = new HashMap<>();
		SUB_SERVICE_MNEMONICS.put("VISA CARD", "V");
		SUB_SERVICE_MNEMONICS.put("MASTERCARD", "M");
		SUB_SERVICE_MNEMONICS.put("DINERS", "D");
		SUB_SERVICE_MNEMONICS.put("AMEX", "A");
		SUB_SERVICE_MNEMONICS.put("FLEET CARD", "F");
	}

	private final static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("HHmmssSSS");
	private static String reportId = "002";
	private final static SPOLogger SPO_LOGGER;
	private final static String REPORT_FOLDER;
	private final static String SEND_FOLDER;
	private final CompanyParametersEntity params = null;
	private static BufferedWriter bw;
	private static List<Double> doubleList = new ArrayList<>();
	private static BigDecimal addDoubeCount = new BigDecimal(0);

	static {

		Map<String, String> paths = new DirectoryDAO().directories();
		SPO_LOGGER = new SPOLogger(paths.get("SPOLOG"));
		REPORT_FOLDER = paths.get("REPORTS");
		SEND_FOLDER = paths.get("SEND");
	}

	// / this method will take subservices as a parameter
	public  void write(String subServices) {
		String filename = null;

		Date processDate = new SystemParametersDAO().systemParameters().getProcessDate();

		// fetching Data from the view reports
		//List<CsvCcr002View> ccr002List = new Csv_Ccr002_ViewDAO().getCsvViewList();
		Map<Integer, CsvCcr002View> maplist = new  Csv_Ccr002_ViewDAO().getCCR002Reports(subServices);
		
		List<CsvCcr002View> list2 = new ArrayList<>(maplist.values());
		//Looping through the fetch Data
		for (CsvCcr002View csvCcr002View : maplist.values()) {
			//if(!csvCcr002View.getAcquiringFees().equals("0")){

			Integer issuerCode = Integer.valueOf(csvCcr002View.getCsvCcr015ViewPK().getIssuerCode());
			Integer acqCode = Integer.valueOf(csvCcr002View.getCsvCcr015ViewPK().getAcquireCode());
			try {
				//Getting the memberServices using the IssuerCode
				CSFMemberServiceDTO codeDetails = getMemberNo(Integer.valueOf(csvCcr002View.getCsvCcr015ViewPK()
						.getIssuerCode()),csvCcr002View.getCsvCcr015ViewPK().getSubService());
				// create output file
				filename = ccr00xFilename(csvCcr002View.getCsvCcr015ViewPK().getSubService(),
						Integer.valueOf(codeDetails.getMemberNo()));
				

				String filepath = ccr00xFilepath(filename);
				
				// control header
				String subMenu1 = "BANKSERV         CCR002"
						+ SUB_SERVICE_MNEMONICS.get(csvCcr002View.getCsvCcr015ViewPK().getSubService())
						+ "  :                    SOUTH AFRICAN BANKERS SERVICES COMPANY LIMITED             "
						+ processDate.toString().substring(0, 8).replace("-", "") + "    PAGE:-     1";
				String subMenu2 = "TAX INVOICE NUMBER: " + codeDetails.getInvoiceNoCCR001()
						+ "                      REG.NO.  " + codeDetails.getVatRegNumber() + "";
				String subMenu3 = "                                            CREDIT CARD FEES AND TRANSACTION PROCESSING STATEMENT";
				String subMenu4 = "                                         -------------------------------------------------------------";
				//getting all the values and add them to list to be written later
				List<FileTrxnDetails> listString = new ArrayList<>();
			      for (CsvCcr002View csvCcr002View2 : list2) {
			    	  if(csvCcr002View2.getCsvCcr015ViewPK().getAcquireCode().equals(String.valueOf(issuerCode))){
			    		  continue;
			    	  }else{
			    		  FileTrxnDetails fileTrxnDetails = new FileTrxnDetails();
			    		  fileTrxnDetails.setBankName(csvCcr002View2.getCsvCcr015ViewPK().getAcquireMember());
			    		  fileTrxnDetails.setInterChangeFeesAcq(csvCcr002View2.getAcquiringFees());
			    		  fileTrxnDetails.setInterChangeFeesIss(csvCcr002View2.getIssuerFees());
			    		  BigDecimal bigfDecim =  new BigDecimal(csvCcr002View2.getAcquiringFees()).subtract(new BigDecimal(csvCcr002View2.getIssuerFees()));
			    		  fileTrxnDetails.setInterChangeFeesNett(String.valueOf(bigfDecim.doubleValue()));//Converted to String
			    		  listString.add(fileTrxnDetails);
			    	  }
			    	  
			      }
			     //assigning value to the header
				FileHeaderDto header = new FileHeaderDto();
				header.setRecordId("01");
				header.setOutputDate(processDate.toString().replace("-", ""));
				header.setService("CARD");
				header.setSubService("REPORTS");
				header.setBankMemberNumber("");
				header.setBankMemberNumber(padLeftString(String.valueOf(issuerCode), 4));
				header.setOriginator("ACBJ");
				header.setFileName("");
				header.setDataType("DATA");
				header.setDataDirection("OUT");
				header.setSettlementDate(processDate.toString().replace("-", ""));
				header.setTestLiveInd("LIVE");
				header.setNumber("01320");
				header.setBankCode(padLeftString(String.valueOf(issuerCode), 3));
				header.setReportName("CCR002");
				header.setMmnemonic(SUB_SERVICE_MNEMONICS.get(csvCcr002View.getCsvCcr015ViewPK().getSubService()));
				
				//Assigning Values to the footer
				FileFooterDto fileFooterDto = new FileFooterDto();
				fileFooterDto.setFooterTextString("THE ABOVE AMOUNT WILL BE DEBITED/CREDITED TO YOUR NOMINATED ACCOUNT");
				fileFooterDto.setRecordId("99");
				fileFooterDto.setOutputDate(processDate.toString().replace("-", ""));
				fileFooterDto.setService("CARD");
				fileFooterDto.setSubService("REPORTS");
				fileFooterDto.setServiceCode(padLeftString(String.valueOf(issuerCode), 4));
				
				fileFooterDto.setPadzeroOne("0");
				fileFooterDto.setPaddAllEmpty("");
				fileFooterDto.setPadAllZero("0");
				
				//Assigning Values to the report Details
				FileReportDetails fileReportDetails = new FileReportDetails();
				fileReportDetails.setToAddressLine1("TO :-  "+codeDetails.getContactName());
				fileReportDetails.setAddressLine1(codeDetails.getMemberAddress1());
				fileReportDetails.setAddressLine2(codeDetails.getMemberAddress2());
				fileReportDetails.setAddressLine3(codeDetails.getMemberAddress3());
				fileReportDetails.setAddressLine4(codeDetails.getMemberAddress4());
				
				fileReportDetails.setBilling1("BILLING BRANCH NUMBER  : "+codeDetails.getBranchCode()+"");
				fileReportDetails.setBilling2("BILLING ACCOUNT NUMBER : 00000000000");
				fileReportDetails.setBillingVat("VAT REG. NO. "+codeDetails.getVatRegNumber() + "");
				
				fileReportDetails.setInterChangeFeesAddress(" INTERCHANGE FEES");
				fileReportDetails.setInterChangeFeesAddressUnderLine("-------------------------------------");
				fileReportDetails.setInterChangeFessHeader1("INTERCHANGE");
				fileReportDetails.setInterChangeFessHeader11("INTERCHANGE FEES");
				fileReportDetails.setInterChangeFessHeader12("INTERCHANGE FEES");
				fileReportDetails.setInterChangeFessHeader13("NET INTERCHANGE FEES");
				
				fileReportDetails.setInterChangeFessHeader2("INSTITUTION");
				fileReportDetails.setInterChangeFessHeader21("AS AN ACQUIRING BANK ");
				fileReportDetails.setInterChangeFessHeader22("AS AN ISSUING BANK");
				fileReportDetails.setInterChangeFessHeader23("DUE/PAYABLE");
				
				
				//wrapping fileWriter to bufferededWriter
				bw = new BufferedWriter(new FileWriter(filepath));
				
				// writing file header to the file
				bw.write(header.toString());
				bw.newLine();
				bw.newLine();
				bw.write(subMenu1);
				bw.newLine();
				bw.newLine();
				bw.write(subMenu2);
				bw.newLine();
				bw.newLine();
				bw.write(subMenu3);
				bw.newLine();
				bw.newLine();
				bw.write(subMenu4);
				bw.newLine();
				bw.newLine();
				bw.write(fileReportDetails.toString());
				bw.newLine();
				 for (FileTrxnDetails trxn : listString) {
						 FileTrxnDetails fileTrxnDetails = new FileTrxnDetails();
						 fileTrxnDetails.setBankName(trxn.getBankName());
						 fileTrxnDetails.setInterChangeFeesAcq(abs(Double.valueOf(trxn.getInterChangeFeesAcq()))+sign(Double.valueOf(trxn.getInterChangeFeesAcq())));
						 fileTrxnDetails.setInterChangeFeesIss(abs(Double.valueOf(trxn.getInterChangeFeesIss()))+sign(Double.valueOf(trxn.getInterChangeFeesIss())));
						 fileTrxnDetails.setInterChangeFeesNett(abs(Double.valueOf(trxn.getInterChangeFeesNett()))+sign(Double.valueOf(trxn.getInterChangeFeesNett())));
						 addDoubeCount = addDoubeCount.add(new BigDecimal(trxn.getInterChangeFeesNett()));
						 bw.write(fileTrxnDetails.toString());
						 bw.newLine();
				}
				 String lastLine = "                                                                         ===========================";
				 String lastLine1 = "                                    TOTAL INTERCHANGE FEES DUE/PAYABLE                    " + abs(addDoubeCount.doubleValue())+sign(addDoubeCount.doubleValue())+"";
				 String lastLine2 = "                                                                         ===========================";
				bw.newLine();
				bw.write(lastLine);
				bw.newLine();
				bw.write(lastLine1);
				bw.newLine();
				bw.write(lastLine2);
				bw.newLine();
				int countNum = sumCounter(listString);				
				fileFooterDto.setCounterNumber(padRightString(""+ countNum,6));
				bw.write(fileFooterDto.toString()+"\n");
				bw.flush();
				addDoubeCount = BigDecimal.ZERO;

			} catch (Exception ex) {
				ex.getMessage();
			}
			finally{ 
				try{
					  if(bw != null){
					  
					  bw.close(); 
					  } 
					  
					}catch(Exception ex){
						ex.getMessage();
					}
			 
			}
		
			//}
			
		}
		
		
	}
	
	private static Double abs(Double value) {
        return Math.abs(value);
    }
	private static String sign(Double value) {
        return value < 0.0 ? "-" : " ";
    }
	
	public static BigDecimal initializeToZero(BigDecimal bigDec){
		
		BigDecimal bigDecimal = BigDecimal.ZERO;
		if(bigDec.compareTo(bigDecimal) > 0){
			bigDec = bigDecimal;
		}
		return bigDecimal;
	}
	
	public static int sumCounter(List<FileTrxnDetails> listString){
		
		return listString.size() + 30;
		
	}
	
    //Used to test Locally
	/*public static void main(String[] args) {
		CCR002reports.write("FLEET CARD");
	}*/

	

	public static String ccr00xFilepath(String filename) {
		return REPORT_FOLDER + FILE_SEPARATOR + filename;
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
	
	/**
	 * @param s
	 * @param n
	 * @return
	 */
	// used to format String for FileWriter
	public static String padRightString(String s, int n) {
		return String.format("%0$" + n + "s", s).replace(' ', '0');
	}

	/**
	 * @param bankCode
	 * @return full member Number
	 */
	// fetching the bank information based on the bankCode
	private static CSFMemberServiceDTO getMemberNo(int bankCode,String subservices) {

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

	public static String ccr00xFilename(String subServiceID, Integer issuerMemberCode) {
		return "CCR" + reportId + SUB_SERVICE_MNEMONICS.get(subServiceID) + "." + TIMESTAMP_FORMAT.format(new Date())
				+ "." + issuerMemberCode;
	}
	
	

}
