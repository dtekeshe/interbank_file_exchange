package com.bsva.dmcs.file.reports;

import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author AugustineA
 *
 */
public class FooterRecord {
	
	private String recorIdentifier;
	private String outputDate;
	private String serviceType;
	private String subServiceType;			
	private String bankMemberNumber;	
	private String numberOfTransmissionFiles;
	private String numberOfCreditRecords;
	private String numberOfDebitRecords;
	private String valueOfCreditRecords;
	private String valueOfDebitRecords;
	private String hashTotalOfAccount;
	private String filler;
	
	public FooterRecord() {
		super();
	}
	public FooterRecord(String recorIdentifier, String outputDate,
			String serviceType, String subServiceType, String bankMemberNumber,
			String numberOfTransmissionFiles, String numberOfCreditRecords,
			String numberOfDebitRecords, String valueOfCreditRecords,
			String valueOfDebitRecords, String hashTotalOfAccount, String filler) {
		super();
		this.recorIdentifier = recorIdentifier;
		this.outputDate = outputDate;
		this.serviceType = serviceType;
		this.subServiceType = subServiceType;
		this.bankMemberNumber = bankMemberNumber;
		this.numberOfTransmissionFiles = numberOfTransmissionFiles;
		this.numberOfCreditRecords = numberOfCreditRecords;
		this.numberOfDebitRecords = numberOfDebitRecords;
		this.valueOfCreditRecords = valueOfCreditRecords;
		this.valueOfDebitRecords = valueOfDebitRecords;
		this.hashTotalOfAccount = hashTotalOfAccount;
		this.filler = filler;
	}
	public String getRecorIdentifier() {
		return recorIdentifier;
	}
	public String getOutputDate() {
		return outputDate;
	}
	public String getServiceType() {
		return serviceType;
	}
	public String getSubServiceType() {
		return subServiceType;
	}
	public String getBankMemberNumber() {
		return bankMemberNumber;
	}
	public String getNumberOfTransmissionFiles() {
		return numberOfTransmissionFiles;
	}
	public String getNumberOfCreditRecords() {
		return numberOfCreditRecords;
	}
	public String getNumberOfDebitRecords() {
		return numberOfDebitRecords;
	}
	public String getValueOfCreditRecords() {
		return valueOfCreditRecords;
	}
	public String getValueOfDebitRecords() {
		return valueOfDebitRecords;
	}
	public String getHashTotalOfAccount() {
		return hashTotalOfAccount;
	}
	public String getFiller() {
		return filler;
	}
	public void setRecorIdentifier(String recorIdentifier) {
		this.recorIdentifier = recorIdentifier;
	}
	public void setOutputDate(String outputDate) {
		this.outputDate = outputDate;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public void setSubServiceType(String subServiceType) {
		this.subServiceType = subServiceType;
	}
	public void setBankMemberNumber(String bankMemberNumber) {
		this.bankMemberNumber = bankMemberNumber;
	}
	public void setNumberOfTransmissionFiles(String numberOfTransmissionFiles) {
		this.numberOfTransmissionFiles = numberOfTransmissionFiles;
	}
	public void setNumberOfCreditRecords(String numberOfCreditRecords) {
		this.numberOfCreditRecords = numberOfCreditRecords;
	}
	public void setNumberOfDebitRecords(String numberOfDebitRecords) {
		this.numberOfDebitRecords = numberOfDebitRecords;
	}
	public void setValueOfCreditRecords(String valueOfCreditRecords) {
		this.valueOfCreditRecords = valueOfCreditRecords;
	}
	public void setValueOfDebitRecords(String valueOfDebitRecords) {
		this.valueOfDebitRecords = valueOfDebitRecords;
	}
	public void setHashTotalOfAccount(String hashTotalOfAccount) {
		this.hashTotalOfAccount = hashTotalOfAccount;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(recorIdentifier == null ? rightPadding(" ",1) :rightPadding(recorIdentifier,1));
		builder.append(outputDate == null ? rightPadding(" ",1) :rightPadding(outputDate,1));
		builder.append(serviceType == null ? rightPadding(" ",1) :rightPadding(serviceType,1));
		builder.append(subServiceType == null ? rightPadding(" ",1) :rightPadding(subServiceType,1));
		builder.append(bankMemberNumber == null ? rightPadding(" ",1) :rightPadding(bankMemberNumber,1));
		builder.append(numberOfTransmissionFiles == null ? rightPadding(" ",1) :rightPadding(numberOfTransmissionFiles,1));
		builder.append(numberOfCreditRecords == null ? rightPadding(" ",1) :rightPadding(numberOfCreditRecords,1));
		builder.append(numberOfDebitRecords == null ? rightPadding(" ",1) :rightPadding(numberOfDebitRecords,1));
		builder.append(valueOfCreditRecords == null ? rightPadding(" ",1) :rightPadding(valueOfCreditRecords,1));
		builder.append(valueOfDebitRecords == null ? rightPadding(" ",1) :rightPadding(valueOfDebitRecords,1));
		builder.append(hashTotalOfAccount == null ? rightPadding(" ",1) :rightPadding(hashTotalOfAccount,1));
		builder.append(filler == null ? rightPadding(" ",1) :rightPadding(filler,1));
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
