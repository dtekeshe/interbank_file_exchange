package com.dmcs.operations.dto;

import com.bsva.dcms.commons.util.StringUtil;

public class CisBinCountDTO {
	private String binheaderDescription;
	private String binTotalNumberStr;
	private String binTotalNumber;
	private String binDeletedStr;
	private String binDeleted;
	private String deletionCycleStr;
	private String deletionCycle;
	private String setForDeletionStr;
	private String setForDeletion;
	public String getBinTotalNumberStr() {
		return binTotalNumberStr;
	}


	public void setBinheaderDescription(String binheaderDescription) {
		this.binheaderDescription = binheaderDescription;
	}
	
	public String getBinheaderDescription() {
		return binheaderDescription;
	}
	
	public String getBinTotalNumber() {
		return binTotalNumber;
	}


	public String getBinDeletedStr() {
		return binDeletedStr;
	}


	public String getBinDeleted() {
		return binDeleted;
	}


	public String getDeletionCycleStr() {
		return deletionCycleStr;
	}


	public String getDeletionCycle() {
		return deletionCycle;
	}


	public String getSetForDeletionStr() {
		return setForDeletionStr;
	}


	public String getSetForDeletion() {
		return setForDeletion;
	}


	public String getActiveBinsStr() {
		return activeBinsStr;
	}


	public String getActiveBins() {
		return activeBins;
	}


	public void setBinTotalNumberStr(String binTotalNumberStr) {
		this.binTotalNumberStr = binTotalNumberStr;
	}


	public void setBinTotalNumber(String binTotalNumber) {
		this.binTotalNumber = binTotalNumber;
	}


	public void setBinDeletedStr(String binDeletedStr) {
		this.binDeletedStr = binDeletedStr;
	}


	public void setBinDeleted(String binDeleted) {
		this.binDeleted = binDeleted;
	}


	public void setDeletionCycleStr(String deletionCycleStr) {
		this.deletionCycleStr = deletionCycleStr;
	}


	public void setDeletionCycle(String deletionCycle) {
		this.deletionCycle = deletionCycle;
	}


	public void setSetForDeletionStr(String setForDeletionStr) {
		this.setForDeletionStr = setForDeletionStr;
	}


	public void setSetForDeletion(String setForDeletion) {
		this.setForDeletion = setForDeletion;
	}


	public void setActiveBinsStr(String activeBinsStr) {
		this.activeBinsStr = activeBinsStr;
	}


	public void setActiveBins(String activeBins) {
		this.activeBins = activeBins;
	}


	private String activeBinsStr;
	private String activeBins;
	
	public CisBinCountDTO(){
		
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(System.lineSeparator());
		builder.append(binheaderDescription == null ? "" : StringUtil.leftJustify(String.valueOf(binheaderDescription),StringUtil.SPACE_STRING, 62));
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		builder.append(binTotalNumberStr == null ? "" : "          "+StringUtil.leftJustify(String.valueOf(binTotalNumberStr),StringUtil.SPACE_STRING, 48));
		builder.append(binTotalNumber == null ? "" : "          "+StringUtil.leftJustify(String.valueOf(binTotalNumber),StringUtil.SPACE_STRING, 8));
		builder.append(System.lineSeparator());
		builder.append(binDeletedStr == null ? "" : "          "+StringUtil.leftJustify(String.valueOf(binDeletedStr),StringUtil.SPACE_STRING, 48));
		builder.append(binDeleted == null ? "" : "          "+StringUtil.leftJustify(String.valueOf(binDeleted),StringUtil.SPACE_STRING, 8));
		builder.append(System.lineSeparator());
		builder.append(deletionCycleStr == null ? "" : "          "+StringUtil.leftJustify(String.valueOf(deletionCycleStr),StringUtil.SPACE_STRING, 48));
		builder.append(deletionCycle == null ? "" : "          "+StringUtil.leftJustify(String.valueOf(deletionCycle),StringUtil.SPACE_STRING, 8));
		builder.append(System.lineSeparator());
		builder.append(setForDeletionStr == null ? "" : "          "+StringUtil.leftJustify(String.valueOf(setForDeletionStr),StringUtil.SPACE_STRING, 48));
		builder.append(setForDeletion == null ? "" : "          "+StringUtil.leftJustify(String.valueOf(setForDeletion),StringUtil.SPACE_STRING, 8));
		builder.append(System.lineSeparator());
		builder.append(activeBinsStr == null ? "" : "          "+StringUtil.leftJustify(String.valueOf(activeBinsStr),StringUtil.SPACE_STRING, 48));
		builder.append(activeBins == null ? "" : "          "+StringUtil.leftJustify(String.valueOf(activeBins),StringUtil.SPACE_STRING, 8));
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		return builder.toString();
	}
	
	public static String padLeftString(String s, int n) {
		return String.format("%0$" + n + "s", s).replace(' ', '0');
	}

}
