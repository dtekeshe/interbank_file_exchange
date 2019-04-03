package com.dmcs.operations.dto;

import com.bsva.dcms.commons.util.StringUtil;

public class CsrBinsReportDTO {
	private String binNo;
	private String DeletionDate;
	private String ProcessDate;
	private String monthsUntilCisBinDeletion;
	private String processActiveInd;
	private String bankCode;
	private String binDescription;
	private String cardType;
	private String oldCardType;
	private String fuelAllowed;
	private String issAcqBoth;
	private String liveDate;
	
	public CsrBinsReportDTO(){
		
	}
	
	public void setLiveDate(String liveDate) {
		this.liveDate = liveDate;
	}
	public String getLiveDate() {
		return liveDate;
	}

	public String getBinNo() {
		return binNo;
	}

	public String getDeletionDate() {
		return DeletionDate;
	}

	public String getProcessDate() {
		return ProcessDate;
	}

	public String getMonthsUntilCisBinDeletion() {
		return monthsUntilCisBinDeletion;
	}

	public String getProcessActiveInd() {
		return processActiveInd;
	}

	public String getBankCode() {
		return bankCode;
	}

	public String getBinDescription() {
		return binDescription;
	}

	public String getCardType() {
		return cardType;
	}

	public String getOldCardType() {
		return oldCardType;
	}

	public String getFuelAllowed() {
		return fuelAllowed;
	}

	public String getIssAcqBoth() {
		return issAcqBoth;
	}

	public void setBinNo(String binNo) {
		this.binNo = binNo;
	}

	public void setDeletionDate(String deletionDate) {
		DeletionDate = deletionDate;
	}

	public void setProcessDate(String processDate) {
		ProcessDate = processDate;
	}

	public void setMonthsUntilCisBinDeletion(String monthsUntilCisBinDeletion) {
		this.monthsUntilCisBinDeletion = monthsUntilCisBinDeletion;
	}

	public void setProcessActiveInd(String processActiveInd) {
		this.processActiveInd = processActiveInd;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public void setBinDescription(String binDescription) {
		this.binDescription = binDescription;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public void setOldCardType(String oldCardType) {
		this.oldCardType = oldCardType;
	}

	public void setFuelAllowed(String fuelAllowed) {
		this.fuelAllowed = fuelAllowed;
	}

	public void setIssAcqBoth(String issAcqBoth) {
		this.issAcqBoth = issAcqBoth;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(bankCode == null ? "" : StringUtil.rightJustify(String.valueOf(bankCode),StringUtil.SPACE_STRING, 10));
		builder.append("    ");
		builder.append(binNo == null ? "" : StringUtil.leftJustify(String.valueOf(binNo),StringUtil.SPACE_STRING, 12));
		builder.append(binDescription == null ? StringUtil.leftJustify(String.valueOf(""),StringUtil.SPACE_STRING, 35) : StringUtil.leftJustify(String.valueOf(binDescription),StringUtil.SPACE_STRING, 35));
		builder.append(DeletionDate == null ? StringUtil.leftJustify(String.valueOf(""),StringUtil.SPACE_STRING, 15) : StringUtil.leftJustify(String.valueOf(DeletionDate),StringUtil.SPACE_STRING, 15));
		builder.append(cardType == null ? StringUtil.leftJustify(String.valueOf(""),StringUtil.SPACE_STRING, 15) : StringUtil.leftJustify(String.valueOf(cardType),StringUtil.SPACE_STRING, 15));
		builder.append(oldCardType == null ? StringUtil.leftJustify(String.valueOf(""),StringUtil.SPACE_STRING, 11) : StringUtil.leftJustify(String.valueOf(oldCardType),StringUtil.SPACE_STRING, 11));
		builder.append(fuelAllowed  == null ? StringUtil.leftJustify(String.valueOf(""),StringUtil.SPACE_STRING, 11) : StringUtil.leftJustify(String.valueOf(fuelAllowed),StringUtil.SPACE_STRING, 11));
		builder.append(issAcqBoth  == null ? StringUtil.leftJustify(String.valueOf(""),StringUtil.SPACE_STRING, 14) : StringUtil.leftJustify(String.valueOf(issAcqBoth),StringUtil.SPACE_STRING, 14));
		builder.append(liveDate  == null ? StringUtil.leftJustify(String.valueOf(""),StringUtil.SPACE_STRING, 22) : StringUtil.leftJustify(String.valueOf(liveDate),StringUtil.SPACE_STRING, 22));
		builder.append(System.lineSeparator());
		return builder.toString();
	}

	
	
	

}
