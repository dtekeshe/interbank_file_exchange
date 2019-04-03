package com.bsva.dmcs.file.reports.dto;

import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportsSubline {
	
	private String compName ; //"BANKSERV");
	private String reportName;//("CCR001");
	private String bankersName;//("SOUTH AFRICAN BANKERS SERVICES COMPANY LIMITED");
	private String processDate;//(processDate);
	private String page;//("PAGE:-");
	
	
	public String getCompName() {
		return compName;
	}


	public void setCompName(String compName) {
		this.compName = compName;
	}


	public String getReportName() {
		return reportName;
	}


	public void setReportName(String reportName) {
		this.reportName = reportName;
	}


	public String getBankersName() {
		return bankersName;
	}


	public void setBankersName(String bankersName) {
		this.bankersName = bankersName;
	}


	public String getProcessDate() {
		return processDate;
	}


	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}


	public String getPage() {
		return page;
	}


	public void setPage(String page) {
		this.page = page;
	}


	public ReportsSubline() {
		super();
	}

	
	public ReportsSubline(String compName, String reportName,
			String bankersName, String processDate, String page) {
		super();
		this.compName = compName;
		this.reportName = reportName;
		this.bankersName = bankersName;
		this.processDate = processDate;
		this.page = page;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(compName == null ? padLeft(" ",12) : padLeft(compName,12));
		builder.append(reportName == null ? padLeft(" ",11) : padLeft(reportName,11));
		builder.append(bankersName == null ? padLeft(" ",21) : padLeft(bankersName,21));
		builder.append(processDate == null ? padLeft(" ",13) : padLeft(processDate,13));
		builder.append(page == null ? padLeft(" ",14) : padLeft(page,14));
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
	
	public String  getDateString(String dateNow ){
		SimpleDateFormat formatDateJava = new SimpleDateFormat("dd/MM/yyyy");
		String date_to_string = formatDateJava.format(dateNow);
		
		return date_to_string;
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
