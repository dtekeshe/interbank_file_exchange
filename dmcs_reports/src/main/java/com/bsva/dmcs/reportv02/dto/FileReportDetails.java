package com.bsva.dmcs.reportv02.dto;

import com.bsva.dcms.commons.util.StringUtil;

public class FileReportDetails {
	
	private String toAddressLine1;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String addressLine4;	
	
	private String interChangeFeesAddress;
	private String interChangeFeesAddressUnderLine;	
	
	private String interChangeFessHeader1;
	private String interChangeFessHeader11;
	private String interChangeFessHeader12;
	private String interChangeFessHeader13;
	
	private String interChangeFessHeader2;
	private String interChangeFessHeader21;
	private String interChangeFessHeader22;
	private String interChangeFessHeader23;
	
	private String billing1;
	private String billing2;
	private String billingVat;
	
	
	public String getToAddressLine1() {
		return toAddressLine1;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public String getAddressLine4() {
		return addressLine4;
	}
	public String getInterChangeFeesAddress() {
		return interChangeFeesAddress;
	}
	public String getInterChangeFeesAddressUnderLine() {
		return interChangeFeesAddressUnderLine;
	}
	public String getInterChangeFessHeader1() {
		return interChangeFessHeader1;
	}
	public String getInterChangeFessHeader2() {
		return interChangeFessHeader2;
	}
	public void setToAddressLine1(String toAddressLine1) {
		this.toAddressLine1 = toAddressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public void setAddressLine4(String addressLine4) {
		this.addressLine4 = addressLine4;
	}
	public void setInterChangeFeesAddress(String interChangeFeesAddress) {
		this.interChangeFeesAddress = interChangeFeesAddress;
	}
	public void setInterChangeFeesAddressUnderLine(String interChangeFeesAddressUnderLine) {
		this.interChangeFeesAddressUnderLine = interChangeFeesAddressUnderLine;
	}
	public void setInterChangeFessHeader1(String interChangeFessHeader1) {
		this.interChangeFessHeader1 = interChangeFessHeader1;
	}
	public void setInterChangeFessHeader2(String interChangeFessHeader2) {
		this.interChangeFessHeader2 = interChangeFessHeader2;
	}
	public String getBilling1() {
		return billing1;
	}
	public String getBilling2() {
		return billing2;
	}
	public String getBillingVat() {
		return billingVat;
	}
	public void setBilling1(String billing1) {
		this.billing1 = billing1;
	}
	public void setBilling2(String billing2) {
		this.billing2 = billing2;
	}
	public String getInterChangeFessHeader11() {
		return interChangeFessHeader11;
	}
	public String getInterChangeFessHeader12() {
		return interChangeFessHeader12;
	}
	public String getInterChangeFessHeader13() {
		return interChangeFessHeader13;
	}
	public String getInterChangeFessHeader21() {
		return interChangeFessHeader21;
	}
	public String getInterChangeFessHeader22() {
		return interChangeFessHeader22;
	}
	public String getInterChangeFessHeader23() {
		return interChangeFessHeader23;
	}
	public void setInterChangeFessHeader11(String interChangeFessHeader11) {
		this.interChangeFessHeader11 = interChangeFessHeader11;
	}
	public void setInterChangeFessHeader12(String interChangeFessHeader12) {
		this.interChangeFessHeader12 = interChangeFessHeader12;
	}
	public void setInterChangeFessHeader13(String interChangeFessHeader13) {
		this.interChangeFessHeader13 = interChangeFessHeader13;
	}
	public void setInterChangeFessHeader21(String interChangeFessHeader21) {
		this.interChangeFessHeader21 = interChangeFessHeader21;
	}
	public void setInterChangeFessHeader22(String interChangeFessHeader22) {
		this.interChangeFessHeader22 = interChangeFessHeader22;
	}
	public void setInterChangeFessHeader23(String interChangeFessHeader23) {
		this.interChangeFessHeader23 = interChangeFessHeader23;
	}
	public void setBillingVat(String billingVat) {
		this.billingVat = billingVat;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(toAddressLine1 == null ? "" : StringUtil.leftJustify(String.valueOf(toAddressLine1),StringUtil.SPACE_STRING,90)).append(billing1== null ? "" : StringUtil.leftJustify(String.valueOf(billing1),StringUtil.SPACE_STRING,36));
		builder.append(System.lineSeparator());
		builder.append(addressLine1  == null ? "" : padLeftString(addressLine1, 30)+StringUtil.leftJustify(" ",StringUtil.SPACE_STRING, 60)).append(billing2== null ? "" : StringUtil.leftJustify(String.valueOf(billing2),StringUtil.SPACE_STRING,36));
		builder.append(System.lineSeparator());
		builder.append(addressLine2  == null ? "" : padLeftString(addressLine2, 30)+StringUtil.leftJustify(" ",StringUtil.SPACE_STRING, 60)).append(billingVat== null ? "" : StringUtil.leftJustify(String.valueOf(billingVat),StringUtil.SPACE_STRING,36));
		builder.append(System.lineSeparator());
		builder.append(addressLine3  == null ? "" : padLeftString(addressLine3, 30)+StringUtil.leftJustify(" ",StringUtil.SPACE_STRING, 60));
		builder.append(System.lineSeparator());
		builder.append(addressLine4  == null ? "" : padLeftString(addressLine4, 30)+StringUtil.leftJustify(" ",StringUtil.SPACE_STRING, 60));
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		builder.append(interChangeFeesAddress  == null ? "" : StringUtil.leftJustify(String.valueOf(interChangeFeesAddress),StringUtil.SPACE_STRING, 20));
		builder.append(System.lineSeparator());
		builder.append(interChangeFeesAddressUnderLine  == null ? "" : StringUtil.leftJustify(String.valueOf(interChangeFeesAddressUnderLine),StringUtil.SPACE_STRING, 20));
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		builder.append(interChangeFessHeader1  == null ? "" : StringUtil.leftJustify(String.valueOf(interChangeFessHeader1),StringUtil.SPACE_STRING,26)).append(interChangeFessHeader11  == null ? "" : StringUtil.leftJustify(String.valueOf(interChangeFessHeader11),StringUtil.SPACE_STRING,26))
		       .append(interChangeFessHeader12  == null ? "" : StringUtil.leftJustify(String.valueOf(interChangeFessHeader12),StringUtil.SPACE_STRING,26)).append(interChangeFessHeader13  == null ? "" : StringUtil.leftJustify(String.valueOf(interChangeFessHeader13),StringUtil.SPACE_STRING,26));
		builder.append(System.lineSeparator());
		builder.append(interChangeFessHeader2  == null ? "" : StringUtil.leftJustify(String.valueOf(interChangeFessHeader2),StringUtil.SPACE_STRING,26)).append(interChangeFessHeader21  == null ? "" : StringUtil.leftJustify(String.valueOf(interChangeFessHeader21),StringUtil.SPACE_STRING,26))
		       .append(interChangeFessHeader22  == null ? "" : StringUtil.leftJustify(String.valueOf(interChangeFessHeader22),StringUtil.SPACE_STRING,26)).append(interChangeFessHeader23  == null ? "" : StringUtil.leftJustify(String.valueOf(interChangeFessHeader23),StringUtil.SPACE_STRING,26));
		builder.append(System.lineSeparator());
		return builder.toString();
	}	

	
	// used to format String for FileWriter
		public static String padLeftString(String s, int n) {
			return String.format("%0$" + n + "s", s);
		}

}
