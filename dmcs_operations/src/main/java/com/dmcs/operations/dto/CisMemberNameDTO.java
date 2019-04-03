package com.dmcs.operations.dto;

import com.bsva.dcms.commons.util.StringUtil;

public class CisMemberNameDTO {
	private String auditTrailmsg;
	private String bankName;
	private String monthsText;
	
	public CisMemberNameDTO(){
		
	}
	public void setAuditTrailmsg(String auditTrailmsg) {
		this.auditTrailmsg = auditTrailmsg;
	}
	public String getAuditTrailmsg() {
		return auditTrailmsg;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setMonthsText(String monthsText) {
		this.monthsText = monthsText;
	}
	public String getMonthsText() {
		return monthsText;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(System.lineSeparator());
		builder.append(auditTrailmsg  == null ? "" : StringUtil.leftJustify(String.valueOf(auditTrailmsg),StringUtil.SPACE_STRING, 78));
		builder.append(System.lineSeparator());
		builder.append(bankName  == null ? "" : StringUtil.leftJustify(String.valueOf(bankName),StringUtil.SPACE_STRING, 40));
		builder.append(monthsText  == null ? "" : StringUtil.leftJustify(String.valueOf(monthsText),StringUtil.SPACE_STRING, 49));
		builder.append(System.lineSeparator());
		return builder.toString();
	}

}
