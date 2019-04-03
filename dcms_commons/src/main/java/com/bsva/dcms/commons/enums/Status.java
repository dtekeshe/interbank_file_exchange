package com.bsva.dcms.commons.enums;

public enum Status {
	
	A("A" , "Accepted"),
	B("B" , "Busy"),
	C("C" , "Completed"),
	F("F" , "Failed"),
	H("H" , "Hold"),
	I("I" , ""),
	Y("Y", ""),
	R("R", "Rejected"),
	N("N" , "No"),
	E("E" , "Extracted"),
	L("L" , "Loaded"),
	Bi("B" , "Billing"),
	_F("F" , "Full"),
	D("D" , "Default"),
	_N("N" , "NotFull"),
	O("O" , "Output"),
	S("S" , "Settled"),
	X("X" , "Processed"),
	U("U" , "Unknown");
	
	
	
	private String symbol;
	private String description;
	
	private Status(String symbol , String description){
		this.symbol = symbol;
		this.description = description;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
