package com.bsva.dmcs.reportv02.dto;

import com.bsva.dcms.commons.util.StringUtil;

public class MemberAddress {
	
	private String addressLine1 ;
	private String addressLine2 ;
	private String addressLine3 ;
	private String addressLine4 ;
	private String addressLine5 ;
	
	private String billingBranchNumber;
	private String billingAccountNumber;
	private String vatRegNumber;
	
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
	public String getAddressLine5() {
		return addressLine5;
	}
	public String getBillingBranchNumber() {
		return billingBranchNumber;
	}
	public String getBillingAccountNumber() {
		return billingAccountNumber;
	}
	public String getVatRegNumber() {
		return vatRegNumber;
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
	public void setAddressLine5(String addressLine5) {
		this.addressLine5 = addressLine5;
	}
	public void setBillingBranchNumber(String billingBranchNumber) {
		this.billingBranchNumber = billingBranchNumber;
	}
	public void setBillingAccountNumber(String billingAccountNumber) {
		this.billingAccountNumber = billingAccountNumber;
	}
	public void setVatRegNumber(String vatRegNumber) {
		this.vatRegNumber = vatRegNumber;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(addressLine1 == null ? "" : StringUtil.leftJustify(String.valueOf(addressLine1),StringUtil.SPACE_STRING, 20));
		builder.append(addressLine2 == null ? "" : StringUtil.leftJustify(String.valueOf(addressLine2),StringUtil.SPACE_STRING, 20));
		builder.append(addressLine3 == null ? "" : StringUtil.leftJustify(String.valueOf(addressLine3),StringUtil.SPACE_STRING, 20));
		builder.append(addressLine4 == null ? "" : StringUtil.leftJustify(String.valueOf(addressLine4),StringUtil.SPACE_STRING, 20));
		builder.append(addressLine5 == null ? "" : StringUtil.leftJustify(String.valueOf(addressLine5),StringUtil.SPACE_STRING, 20));
		builder.append(billingBranchNumber == null ? "" : StringUtil.leftJustify(String.valueOf(billingBranchNumber),StringUtil.SPACE_STRING, 30));
		builder.append(billingAccountNumber == null ? "" : StringUtil.leftJustify(String.valueOf(billingAccountNumber),StringUtil.SPACE_STRING, 30));
		builder.append(vatRegNumber == null ? "" : StringUtil.leftJustify(String.valueOf(vatRegNumber),StringUtil.SPACE_STRING, 20));
		
		return builder.toString();
	}

}
