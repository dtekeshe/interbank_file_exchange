package com.bsva.dmcs.file.reports;

import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author AugustineA
 *
 */
public class TaxInvoiceSubline {

	private String service;
	private String subService;
	public TaxInvoiceSubline(String service, String subService,
			String lineReport) {
		super();
		this.service = service;
		this.subService = subService;
		this.lineReport = lineReport;
	}
	public TaxInvoiceSubline() {
		super();
	}
	private  String lineReport;
	public String getService() {
		return service;
	}
	public String getSubService() {
		return subService;
	}
	public String getLineReport() {
		return lineReport;
	}
	public void setService(String service) {
		this.service = service;
	}
	public void setSubService(String subService) {
		this.subService = subService;
	}
	public void setLineReport(String lineReport) {
		this.lineReport = lineReport;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(subService == null ? padLeft(" ",13) : padLeft(subService,13));
		builder.append(service == null ? padLeft(" ",12) : padLeft(service,12));		
		builder.append(lineReport == null ? padLeft(" ",79) : padLeft(lineReport,79));
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
