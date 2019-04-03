package com.dmcs.operations.dto;

import com.bsva.dcms.commons.util.StringUtil;

public class CisBinsHeaderName {
	
	private String bank;
	private String timeStr;
	private String time;
	private String bankservName;
	private String date;
	private String page;
	private String pageCount;
	private String regNoStr;
	private String regNum;
	
	public CisBinsHeaderName(){
		
	}

	public String getBank() {
		return bank;
	}

	public String getTimeStr() {
		return timeStr;
	}

	public String getTime() {
		return time;
	}

	public String getBankservName() {
		return bankservName;
	}

	public String getDate() {
		return date;
	}

	public String getPage() {
		return page;
	}

	public String getPageCount() {
		return pageCount;
	}

	public String getRegNoStr() {
		return regNoStr;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setBankservName(String bankservName) {
		this.bankservName = bankservName;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	public void setRegNoStr(String regNoStr) {
		this.regNoStr = regNoStr;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		builder.append(bank  == null ? "" : StringUtil.leftJustify(String.valueOf(bank),StringUtil.SPACE_STRING, 18));
		builder.append(timeStr  == null ? "" : StringUtil.leftJustify(String.valueOf(timeStr),StringUtil.SPACE_STRING, 6));
		builder.append(time  == null ? "" : StringUtil.leftJustify(String.valueOf(time),StringUtil.SPACE_STRING, 20));
		builder.append(bankservName  == null ? "" : StringUtil.leftJustify(String.valueOf(bankservName),StringUtil.SPACE_STRING, 62));
		builder.append(date  == null ? "" : StringUtil.leftJustify(String.valueOf(date),StringUtil.SPACE_STRING, 14));
		builder.append(page  == null ? "" : StringUtil.leftJustify(String.valueOf(page),StringUtil.SPACE_STRING, 11));
		builder.append(pageCount  == null ? "" : StringUtil.leftJustify(String.valueOf(pageCount),StringUtil.SPACE_STRING, 4));
		builder.append(System.lineSeparator());
		builder.append(regNoStr  == null ? "" : StringUtil.rightJustify(String.valueOf(regNoStr),StringUtil.SPACE_STRING, 44));
		builder.append(regNum  == null ? "" : StringUtil.leftJustify(String.valueOf(regNum),StringUtil.SPACE_STRING, 16));
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		return builder.toString();
	}

}
