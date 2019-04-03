package com.bsva.dmcs.dto;

import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bsva.dmcs.file.reports.FooterRecord;
import com.bsva.dmcs.file.reports.HeaderRecord;

public class CsvCcr015ViewDto {

	private String processMonth;
	private String issuerBin;
	private String issuerMemberName;
	private int issuerMember;
	private String cardDescription;
	private int cardType;
	private String acquiringMemberName;
	private int acquiringMember;
	private String merchantCatCode;
	private int interchangeRateDesignator;
	private int itemCharge;
	private int itemChargeAmount;
	private String transactionDescription;
	private int volume;
	private int value;
	private int totalCost;
	private FooterRecord footerRecord;
	private HeaderRecord headerRecord;
	
	public CsvCcr015ViewDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FooterRecord getFooterRecord() {
		return footerRecord;
	}
	public HeaderRecord getHeaderRecord() {
		return headerRecord;
	}
	public void setFooterRecord(FooterRecord footerRecord) {
		this.footerRecord = footerRecord;
	}
	public void setHeaderRecord(HeaderRecord headerRecord) {
		this.headerRecord = headerRecord;
	}
	public String getProcessMonth() {
		return processMonth;
	}
	public String getIssuerBin() {
		return issuerBin;
	}
	public String getIssuerMemberName() {
		return issuerMemberName;
	}
	public int getIssuerMember() {
		return issuerMember;
	}
	public String getCardDescription() {
		return cardDescription;
	}
	public int getCardType() {
		return cardType;
	}
	public String getAcquiringMemberName() {
		return acquiringMemberName;
	}
	public int getAcquiringMember() {
		return acquiringMember;
	}
	public String getMerchantCatCode() {
		return merchantCatCode;
	}
	public int getInterchangeRateDesignator() {
		return interchangeRateDesignator;
	}
	public int getItemCharge() {
		return itemCharge;
	}
	public int getItemChargeAmount() {
		return itemChargeAmount;
	}
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public int getVolume() {
		return volume;
	}
	public int getValue() {
		return value;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setProcessMonth(String processMonth) {
		this.processMonth = processMonth;
	}
	public void setIssuerBin(String issuerBin) {
		this.issuerBin = issuerBin;
	}
	public void setIssuerMemberName(String issuerMemberName) {
		this.issuerMemberName = issuerMemberName;
	}
	public void setIssuerMember(int issuerMember) {
		this.issuerMember = issuerMember;
	}
	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}
	public void setCardType(int cardType) {
		this.cardType = cardType;
	}
	public void setAcquiringMemberName(String acquiringMemberName) {
		this.acquiringMemberName = acquiringMemberName;
	}
	public void setAcquiringMember(int acquiringMember) {
		this.acquiringMember = acquiringMember;
	}
	public void setMerchantCatCode(String merchantCatCode) {
		this.merchantCatCode = merchantCatCode;
	}
	public void setInterchangeRateDesignator(int interchangeRateDesignator) {
		this.interchangeRateDesignator = interchangeRateDesignator;
	}
	public void setItemCharge(int itemCharge) {
		this.itemCharge = itemCharge;
	}
	public void setItemChargeAmount(int itemChargeAmount) {
		this.itemChargeAmount = itemChargeAmount;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		//builder.append(processMonth == null ? rightPadding(" ",145).replace(" ","0") : rightPadding(processMonth,145).replace(" "," "));
		//builder.append(',');
		builder.append(issuerBin == null ? rightPadding(" ",7).replace(" ","0") : rightPadding(issuerBin,7).replace(" "," "));
		builder.append(',');
		builder.append(issuerMemberName == null ? rightPadding(" ",31).replace(" ","0") : rightPadding(issuerMemberName,31).replace(" "," "));
		builder.append(',');
		//builder.append(issuerMember == 0 ? rightPadding(" ",30).replace(" ","0") : rightPadding(String.valueOf(issuerMember),30).replace(" "," "));
		//builder.append(',');
		builder.append(cardDescription == null ? rightPadding(" ",31).replace(" ","0") : rightPadding(cardDescription,31).replace(" "," "));
		builder.append(',');
		builder.append(cardType == 0 ? rightPadding(" ",32).replace(" ","0") : rightPadding(String.valueOf(cardType),32).replace(" "," "));
		builder.append(',');
		builder.append(acquiringMemberName == null ? rightPadding(" ",31).replace(" ","0") : rightPadding(acquiringMemberName,31).replace(" "," "));
		builder.append(',');
		//builder.append(acquiringMember == 0 ? rightPadding(" ",30).replace(" ","0") : rightPadding(String.valueOf(acquiringMember),30).replace(" "," "));
		//builder.append(',');
		builder.append(merchantCatCode == null ? rightPadding(" ",5).replace(" ","0") : rightPadding(merchantCatCode,5).replace(" "," "));
		builder.append(',');
		builder.append(interchangeRateDesignator == 0 ? rightPadding(" ",4).replace(" ","0") : rightPadding(String.valueOf(interchangeRateDesignator),4).replace(" "," "));
		builder.append(',');
		builder.append(itemCharge == 0 ? rightPadding(" ",8).replace(" ","0") : rightPadding(String.valueOf(itemCharge),8).replace(" "," "));
		builder.append(',');
		builder.append(itemChargeAmount == 0 ? rightPadding(" ",8).replace(" ","0") : rightPadding(String.valueOf(itemChargeAmount),8).replace(" "," "));
		builder.append(',');
		builder.append(transactionDescription == null ? rightPadding(" ",103).replace(" ","0") : rightPadding(transactionDescription,103).replace(" "," "));
		builder.append(',');
		builder.append(volume == 0 ? rightPadding(" ",11).replace(" ","0") : rightPadding(String.valueOf(volume),11).replace(" "," "));
		builder.append(',');
		builder.append(value == 0 ? rightPadding(" ",11).replace(" ","0") : rightPadding(String.valueOf(value),11).replace(" "," "));
		builder.append(',');
		builder.append(totalCost == 0  ? rightPadding(" ",13).replace(" ","0") : rightPadding(String.valueOf(totalCost),13).replace(" "," "));
		builder.append(System.lineSeparator());
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
