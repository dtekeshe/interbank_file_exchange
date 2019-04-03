package com.bsva.dto;

import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CsoNegativeCardsDTO {

	private String filler1;
	private String filler2;
	private String systemSeqNumber;
	private String transactoionCode;
	private String destBinNumber;
	private String sourceBinNumber;
	private String transSeqNumber;
	private String transactionType;
	private String authCenter;
	private String negativeAccNumber;
	private String responseCode;
	private String purgeDate;
	private String regionCode;
	private String cardHolderName;
	private String acquirer;
	
	
	public CsoNegativeCardsDTO() {
	}
	
	public String getSystemSeqNumber() {
		return systemSeqNumber;
	}
	public String getTransactoionCode() {
		return transactoionCode;
	}
	public String getDestBinNumber() {
		return destBinNumber;
	}
	public String getSourceBinNumber() {
		return sourceBinNumber;
	}
	public String getTransSeqNumber() {
		return transSeqNumber;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public String getAuthCenter() {
		return authCenter;
	}
	public String getNegativeAccNumber() {
		return negativeAccNumber;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public String getPurgeDate() {
		return purgeDate;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public String getAcquirer() {
		return acquirer;
	}
	
	public void setSystemSeqNumber(String systemSeqNumber) {
		this.systemSeqNumber = systemSeqNumber;
	}
	public void setTransactoionCode(String transactoionCode) {
		this.transactoionCode = transactoionCode;
	}
	public void setDestBinNumber(String destBinNumber) {
		this.destBinNumber = destBinNumber;
	}
	public void setSourceBinNumber(String sourceBinNumber) {
		this.sourceBinNumber = sourceBinNumber;
	}
	public void setTransSeqNumber(String transSeqNumber) {
		this.transSeqNumber = transSeqNumber;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public void setAuthCenter(String authCenter) {
		this.authCenter = authCenter;
	}
	public void setNegativeAccNumber(String negativeAccNumber) {
		this.negativeAccNumber = negativeAccNumber;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public void setPurgeDate(String purgeDate) {
		this.purgeDate = purgeDate;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public void setAcquirer(String acquirer) {
		this.acquirer = acquirer;
	}

	public String getFiller1() {
		return filler1;
	}

	public String getFiller2() {
		return filler2;
	}

	public void setFiller1(String filler1) {
		this.filler1 = filler1;
	}

	public void setFiller2(String filler2) {
		this.filler2 = filler2;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(transactoionCode == null ? rightPadding(" ",2): rightPadding(transactoionCode,2));
		builder.append(destBinNumber == null ? rightPadding(" ",6): rightPadding(destBinNumber,6));
		builder.append(sourceBinNumber == null ? rightPadding(" ",6): rightPadding(sourceBinNumber,6));
		builder.append(transactionType == null ? rightPadding(" ",1): rightPadding(transactionType,1));
		builder.append(authCenter == null ? rightPadding(" ",4).replace(' ', '0'): rightPadding(authCenter,4).replace(' ', '0'));
		builder.append(negativeAccNumber == null ? rightPadding(" ",16): rightPadding(negativeAccNumber,16));
		builder.append(responseCode == null ? rightPadding(" ",2): rightPadding(responseCode,2));
		builder.append(purgeDate == null ? rightPadding(" ",4): rightPadding(purgeDate,4));
		builder.append(regionCode == null ? rightPadding(" ",9): rightPadding(regionCode,9));
		builder.append(cardHolderName == null ? rightPadding(" ",71): rightPadding(cardHolderName,71));		
		
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
	public static String padLeftDoble(String s, double n) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquirer == null) ? 0 : acquirer.hashCode());
		result = prime * result + ((authCenter == null) ? 0 : authCenter.hashCode());
		result = prime * result + ((cardHolderName == null) ? 0 : cardHolderName.hashCode());
		result = prime * result + ((destBinNumber == null) ? 0 : destBinNumber.hashCode());
		result = prime * result + ((filler1 == null) ? 0 : filler1.hashCode());
		result = prime * result + ((filler2 == null) ? 0 : filler2.hashCode());
		result = prime * result + ((negativeAccNumber == null) ? 0 : negativeAccNumber.hashCode());
		result = prime * result + ((purgeDate == null) ? 0 : purgeDate.hashCode());
		result = prime * result + ((regionCode == null) ? 0 : regionCode.hashCode());
		result = prime * result + ((responseCode == null) ? 0 : responseCode.hashCode());
		result = prime * result + ((sourceBinNumber == null) ? 0 : sourceBinNumber.hashCode());
		result = prime * result + ((systemSeqNumber == null) ? 0 : systemSeqNumber.hashCode());
		result = prime * result + ((transSeqNumber == null) ? 0 : transSeqNumber.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		result = prime * result + ((transactoionCode == null) ? 0 : transactoionCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CsoNegativeCardsDTO other = (CsoNegativeCardsDTO) obj;
		if (acquirer == null) {
			if (other.acquirer != null)
				return false;
		} else if (!acquirer.equals(other.acquirer))
			return false;
		if (authCenter == null) {
			if (other.authCenter != null)
				return false;
		} else if (!authCenter.equals(other.authCenter))
			return false;
		if (cardHolderName == null) {
			if (other.cardHolderName != null)
				return false;
		} else if (!cardHolderName.equals(other.cardHolderName))
			return false;
		if (destBinNumber == null) {
			if (other.destBinNumber != null)
				return false;
		} else if (!destBinNumber.equals(other.destBinNumber))
			return false;
		if (filler1 == null) {
			if (other.filler1 != null)
				return false;
		} else if (!filler1.equals(other.filler1))
			return false;
		if (filler2 == null) {
			if (other.filler2 != null)
				return false;
		} else if (!filler2.equals(other.filler2))
			return false;
		if (negativeAccNumber == null) {
			if (other.negativeAccNumber != null)
				return false;
		} else if (!negativeAccNumber.equals(other.negativeAccNumber))
			return false;
		if (purgeDate == null) {
			if (other.purgeDate != null)
				return false;
		} else if (!purgeDate.equals(other.purgeDate))
			return false;
		if (regionCode == null) {
			if (other.regionCode != null)
				return false;
		} else if (!regionCode.equals(other.regionCode))
			return false;
		if (responseCode == null) {
			if (other.responseCode != null)
				return false;
		} else if (!responseCode.equals(other.responseCode))
			return false;
		if (sourceBinNumber == null) {
			if (other.sourceBinNumber != null)
				return false;
		} else if (!sourceBinNumber.equals(other.sourceBinNumber))
			return false;
		if (systemSeqNumber == null) {
			if (other.systemSeqNumber != null)
				return false;
		} else if (!systemSeqNumber.equals(other.systemSeqNumber))
			return false;
		if (transSeqNumber == null) {
			if (other.transSeqNumber != null)
				return false;
		} else if (!transSeqNumber.equals(other.transSeqNumber))
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		if (transactoionCode == null) {
			if (other.transactoionCode != null)
				return false;
		} else if (!transactoionCode.equals(other.transactoionCode))
			return false;
		return true;
	}
}
