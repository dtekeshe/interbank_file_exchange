package com.bsva.dcms.commons.dto;

import java.util.ArrayList;
import java.util.List;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CSFMembersDTO implements java.io.Serializable, Cloneable {
	private String memberNo;
	private int bankCode;
	private String memberName;
	private String abbrevMemberName;
	private String mnemonicMemberName;
	private String memberAddress1;
	private String memberAddress2;
	private String memberAddress3;
	private String memberAddress4;
	private String memberStatus;
	private String memberTapeId;
	private String contactName;
	private String vatRegNo;
	private String originatingBankId;
	private long processorId;
	private float tieredItemCharge;
	private String incfOutputRequired;
	private int monthsUntilCisBinDeletion;
	private float tieredItemChargeBelow;
	private float tieredItemChargeAbove;
	private String negCardDataRequired;

	public String getMemberNo() {
		return this.memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo=memberNo;
	}

	public int getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(int bankCode) {
		this.bankCode=bankCode;
	}

	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName=memberName;
	}

	public String getAbbrevMemberName() {
		return this.abbrevMemberName;
	}

	public void setAbbrevMemberName(String abbrevMemberName) {
		this.abbrevMemberName=abbrevMemberName;
	}

	public String getMnemonicMemberName() {
		return this.mnemonicMemberName;
	}

	public void setMnemonicMemberName(String mnemonicMemberName) {
		this.mnemonicMemberName=mnemonicMemberName;
	}

	public String getMemberAddress1() {
		return this.memberAddress1;
	}

	public void setMemberAddress1(String memberAddress1) {
		this.memberAddress1=memberAddress1;
	}

	public String getMemberAddress2() {
		return this.memberAddress2;
	}

	public void setMemberAddress2(String memberAddress2) {
		this.memberAddress2=memberAddress2;
	}

	public String getMemberAddress3() {
		return this.memberAddress3;
	}

	public void setMemberAddress3(String memberAddress3) {
		this.memberAddress3=memberAddress3;
	}

	public String getMemberAddress4() {
		return this.memberAddress4;
	}

	public void setMemberAddress4(String memberAddress4) {
		this.memberAddress4=memberAddress4;
	}

	public String getMemberStatus() {
		return this.memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus=memberStatus;
	}

	public String getMemberTapeId() {
		return this.memberTapeId;
	}

	public void setMemberTapeId(String memberTapeId) {
		this.memberTapeId=memberTapeId;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName=contactName;
	}

	public String getVatRegNo() {
		return this.vatRegNo;
	}

	public void setVatRegNo(String vatRegNo) {
		this.vatRegNo=vatRegNo;
	}

	public String getOriginatingBankId() {
		return this.originatingBankId;
	}

	public void setOriginatingBankId(String originatingBankId) {
		this.originatingBankId=originatingBankId;
	}

	public long getProcessorId() {
		return this.processorId;
	}

	public void setProcessorId(long processorId) {
		this.processorId=processorId;
	}

	public float getTieredItemCharge() {
		return this.tieredItemCharge;
	}

	public void setTieredItemCharge(float tieredItemCharge) {
		this.tieredItemCharge=tieredItemCharge;
	}

	public String getIncfOutputRequired() {
		return this.incfOutputRequired;
	}

	public void setIncfOutputRequired(String incfOutputRequired) {
		this.incfOutputRequired=incfOutputRequired;
	}

	public int getMonthsUntilCisBinDeletion() {
		return this.monthsUntilCisBinDeletion;
	}

	public void setMonthsUntilCisBinDeletion(int monthsUntilCisBinDeletion) {
		this.monthsUntilCisBinDeletion=monthsUntilCisBinDeletion;
	}

	public float getTieredItemChargeBelow() {
		return this.tieredItemChargeBelow;
	}

	public void setTieredItemChargeBelow(float tieredItemChargeBelow) {
		this.tieredItemChargeBelow=tieredItemChargeBelow;
	}

	public float getTieredItemChargeAbove() {
		return this.tieredItemChargeAbove;
	}

	public void setTieredItemChargeAbove(float tieredItemChargeAbove) {
		this.tieredItemChargeAbove=tieredItemChargeAbove;
	}

	public String getNegCardDataRequired() {
		return this.negCardDataRequired;
	}

	public void setNegCardDataRequired(String negCardDataRequired) {
		this.negCardDataRequired=negCardDataRequired;
	}


	/* Creates and returns a copy of this object. */
	public Object clone() {
		CSFMembersDTO bean = new CSFMembersDTO();
		bean.memberNo = this.memberNo;
		bean.bankCode = this.bankCode;
		bean.memberName = this.memberName;
		bean.abbrevMemberName = this.abbrevMemberName;
		bean.mnemonicMemberName = this.mnemonicMemberName;
		bean.memberAddress1 = this.memberAddress1;
		bean.memberAddress2 = this.memberAddress2;
		bean.memberAddress3 = this.memberAddress3;
		bean.memberAddress4 = this.memberAddress4;
		bean.memberStatus = this.memberStatus;
		bean.memberTapeId = this.memberTapeId;
		bean.contactName = this.contactName;
		bean.vatRegNo = this.vatRegNo;
		bean.originatingBankId = this.originatingBankId;
		bean.processorId = this.processorId;
		bean.tieredItemCharge = this.tieredItemCharge;
		bean.incfOutputRequired = this.incfOutputRequired;
		bean.monthsUntilCisBinDeletion = this.monthsUntilCisBinDeletion;
		bean.tieredItemChargeBelow = this.tieredItemChargeBelow;
		bean.tieredItemChargeAbove = this.tieredItemChargeAbove;
		bean.negCardDataRequired = this.negCardDataRequired;
		return bean;
	}
	
}
