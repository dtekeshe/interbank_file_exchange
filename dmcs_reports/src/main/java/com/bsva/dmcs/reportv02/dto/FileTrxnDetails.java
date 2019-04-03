package com.bsva.dmcs.reportv02.dto;

import java.text.DecimalFormat;

import com.bsva.dcms.commons.util.StringUtil;

public class FileTrxnDetails {

	private final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("########.00");
	private String bankName;
	private String interChangeFeesAcq;
	private String interChangeFeesIss;
	private String interChangeFeesNett;
	private String nettTotalsText;
	private String nettTotals;
	
	
	public String getBankName() {
		return bankName;
	}
	public String getInterChangeFeesAcq() {
		return interChangeFeesAcq;
	}
	public String getInterChangeFeesIss() {
		return interChangeFeesIss;
	}
	public String getInterChangeFeesNett() {
		return interChangeFeesNett;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public void setInterChangeFeesAcq(String interChangeFeesAcq) {
		this.interChangeFeesAcq = interChangeFeesAcq;
	}
	public void setInterChangeFeesIss(String interChangeFeesIss) {
		this.interChangeFeesIss = interChangeFeesIss;
	}
	public void setInterChangeFeesNett(String interChangeFeesNett) {
		this.interChangeFeesNett = interChangeFeesNett;
	}
	public String getNettTotalsText() {
		return nettTotalsText;
	}
	public String getNettTotals() {
		return nettTotals;
	}
	public void setNettTotalsText(String nettTotalsText) {
		this.nettTotalsText = nettTotalsText;
	}
	public void setNettTotals(String nettTotals) {
		this.nettTotals = nettTotals;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(bankName  == null ? "" : StringUtil.leftJustify(String.valueOf(bankName),StringUtil.SPACE_STRING,20)).append(interChangeFeesAcq  == null ? "" : StringUtil.rightJustify(String.valueOf(interChangeFeesAcq),StringUtil.SPACE_STRING,26))
	           .append(interChangeFeesIss  == null ? "" : StringUtil.rightJustify(String.valueOf(interChangeFeesIss),StringUtil.SPACE_STRING,24)).append(interChangeFeesNett  == null ? "" : StringUtil.rightJustify(String.valueOf(interChangeFeesNett),StringUtil.SPACE_STRING,28));
	    builder.append(System.lineSeparator());
	    builder.append(bankName  == null ? "" : StringUtil.rightJustify("",StringUtil.SPACE_STRING,20)).append(interChangeFeesAcq  == null ? "" : StringUtil.rightJustify("",StringUtil.SPACE_STRING,26))
        .append(nettTotalsText  == null ? "" : StringUtil.rightJustify(String.valueOf(nettTotalsText),StringUtil.SPACE_STRING,40)).append(nettTotals  == null ? "" : StringUtil.rightJustify(String.valueOf(nettTotals),StringUtil.SPACE_STRING,24));
 
		return builder.toString();
	}
	
	private static Double abs(Double value) {
        return Math.abs(value);
    }
	private static String sign(Double value) {
        return value < 0.0 ? "-" : " ";
    }
}
