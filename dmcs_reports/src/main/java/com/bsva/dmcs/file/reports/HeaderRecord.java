package com.bsva.dmcs.file.reports;

import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author AugustineA
 *
 */
public class HeaderRecord {

	
	private String recorIdentifier;
	private String outputDate;
	private String serviceType;
	private String subservice;
	private String bankMemberNumber;
	private String originator;
	private String fileName;
	private String fileNumber;
	private String dataType;
	private String dataDirection;
	private String settlementDate;
	private String testLive;
	private String recordSize;
	private String filler;
	
	
	public HeaderRecord() {
	}


	public String getRecorIdentifier() {
		return recorIdentifier;
	}


	public void setRecorIdentifier(String recorIdentifier) {
		this.recorIdentifier = recorIdentifier;
	}


	public String getOutputDate() {
		return outputDate;
	}


	public void setOutputDate(String outputDate) {
		this.outputDate = outputDate;
	}


	public String getServiceType() {
		return serviceType;
	}


	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}


	public String getSubservice() {
		return subservice;
	}


	public void setSubservice(String subservice) {
		this.subservice = subservice;
	}


	public String getBankMemberNumber() {
		return bankMemberNumber;
	}


	public void setBankMemberNumber(String bankMemberNumber) {
		this.bankMemberNumber = bankMemberNumber;
	}


	public String getOriginator() {
		return originator;
	}


	public void setOriginator(String originator) {
		this.originator = originator;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFileNumber() {
		return fileNumber;
	}


	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}


	public String getDataType() {
		return dataType;
	}


	public void setDataType(String dataType) {
		this.dataType = dataType;
	}


	public String getDataDirection() {
		return dataDirection;
	}


	public void setDataDirection(String dataDirection) {
		this.dataDirection = dataDirection;
	}


	public String getSettlementDate() {
		return settlementDate;
	}


	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}


	public String getTestLive() {
		return testLive;
	}


	public void setTestLive(String testLive) {
		this.testLive = testLive;
	}


	public String getRecordSize() {
		return recordSize;
	}


	public void setRecordSize(String recordSize) {
		this.recordSize = recordSize;
	}


	public String getFiller() {
		return filler;
	}


	public void setFiller(String filler) {
		this.filler = filler;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		//Header Formatting
		//builder.append(settleDetailInd == null ? rightPadding(" ",1).replace(" ","0") :rightPadding(settleDetailInd,1).replace(" "," "));
		builder.append(recorIdentifier == null ? rightPadding(" ",1).replace(" ","0") :rightPadding(recorIdentifier,1).replace(" "," "));
		builder.append(outputDate == null ? rightPadding(" ",1).replace(" ","0") :rightPadding(outputDate,1).replace(" "," "));
		builder.append(serviceType == null ? rightPadding(" ",1).replace(" ","0") :rightPadding(serviceType,1).replace(" "," "));
		builder.append(subservice == null ? rightPadding(" ",1).replace(" ","0") :rightPadding(subservice,1).replace(" "," "));
		builder.append(bankMemberNumber == null ? rightPadding(" ",1).replace(" ","0") :rightPadding(bankMemberNumber,1).replace(" "," "));
		builder.append(originator == null ? rightPadding(" ",1).replace(" ","0") :rightPadding(originator,1).replace(" "," "));
		builder.append(fileName == null ? rightPadding(" ",1).replace(" ","0") :rightPadding(fileName,1).replace(" "," "));
		builder.append(fileNumber == null ? rightPadding(" ",1).replace(" ","0") :rightPadding(fileNumber,1).replace(" "," "));
		builder.append(dataType == null ? rightPadding(" ",1).replace(" ","0") :rightPadding(dataType,1).replace(" "," "));
		builder.append(dataDirection == null ? rightPadding(" ",1).replace(" ","0") :rightPadding(dataDirection,1).replace(" "," "));
		builder.append(settlementDate == null ? rightPadding(" ",1).replace(" ","0") :rightPadding(settlementDate,1).replace(" "," "));
		builder.append(testLive == null ? rightPadding(" ",1).replace(" ","0") :rightPadding(testLive,1).replace(" "," "));
		builder.append(recordSize == null ? rightPadding(" ",1).replace(" ","0") :rightPadding(recordSize,1).replace(" "," "));
		builder.append(filler == null ? rightPadding(" ",1).replace(" ","0") :rightPadding(filler,1).replace(" "," "));
		return builder.toString();
	}
	
	public static String leftJustifyWithZeros(String s, int length) {
	     if (s.length() >= length) return s;
	     else return String.format("%0" + (length-s.length()) + "d%s", 0, s);
	}
	
	public static String leftJustifyWithSpaces(String s, int length) {
	     if (s.length() >= length) return s;
	     else return String.format("%"+ (length-s.length()) +"s", s);
	}
	
	public static String doubleToStringCommaReplacer(Long l) {

	     return String.format("%.2f", l).replace(".", "");
	}
	
	public static String getTime(){
		
    Date date = new Date();
		  Format formatter = new SimpleDateFormat("HH:mm:ss");
		 String s = formatter.format(date);
		 
		 String[] splist =s.split(":");
		 
		 String hour = splist[0];
		 String minutes = splist[1];
		 String seconds = splist[2];
		 	 
		 return leftJustifyWithZeros(hour,2) + minutes + seconds;
	}
	public static boolean isEmpty(String str) {
	      return str == null || str.length() == 0;
	  }
	  /**
	 * @param str
	 * @param num
	 * @return
	 */
	public static String rightPadZeros(String str, int num) {
		    return String.format("%1$-" + num + "s", str).replace(' ', ' ');
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
* @param s
* @param n
* @return
*/
public static String padLeft(String s, int n) {
		    return String.format("%1$" + n + "s", s);
	   }
	 /**
	 * @param s
	 * @param n
	 * @return
	 */
	public static String padLeftString(String s, int n) {
		   return String.format("%0$"+ n +"s", s);
	  }
	 /**
	 * @param s
	 * @param n
	 * @return
	 */
	public static String paddingLeft(String s, int n) {
		   return String.format("%1$"+ n + "s", s);
	  }
	 /**
	 * @param str
	 * @return
	 */
	public static String Convert(String str) {
		   
		   BigDecimal payments = new BigDecimal(str);
		   BigDecimal payments2 = new BigDecimal("100");
		   String str1 = String.format("%.2f",payments.multiply(payments2)).replace('.','0').substring(0,6);
		   return str1 ;
	   }
	 
	 /**
	 * @param str
	 * @return
	 */
	public static String Converter(String str){
		    BigDecimal payments3 = new BigDecimal(str);
			BigDecimal payments24= new BigDecimal("100");
			payments3.toBigInteger().toString();
			String str1 = paddingLeft(String.format("%.2f",payments3.multiply(payments24)),16).replace('.',' ').substring(0, 14);
			String str3 = str1;	
			return paddingLeft(str3,17).substring(0, 16);
	 }
	 
	 /**
	 * @param str
	 * @return
	 */
	public static String Converter1(String str){
		    BigDecimal payments3 = new BigDecimal(str);
			BigDecimal payments24= new BigDecimal("100");
			payments3.toBigInteger().toString();
			String str1 = paddingLeft(String.format("%.2f",payments3.multiply(payments24)),16).replace('.',' ').substring(0, 14);
			String str3 = str1;	
			return paddingLeft(str3,17).substring(0, 16).replace(' ', '0');
	 }
}
