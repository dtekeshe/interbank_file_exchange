package com.bsva.dcms.commons.dto;

import java.io.Serializable;

/**
*
* @author Nombuyiselo Mbangula <nombuyiselom@bankservafrica.com>
*/

public class CSFAsciiEbcdicDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int decimalVal;
	private String asciiChar;
	private String ebcdicChar;
	private int ebcdicInt;
	


	public int getDecimalVal() {
		return decimalVal;
	}
	public void setDecimalVal(int decimalVal) {
		this.decimalVal = decimalVal;
	}
	public String getAsciiChar() {
		return asciiChar;
	}
	public void setAsciiChar(String asciiChar) {
		this.asciiChar = asciiChar;
	}
	public String getEbcdicChar() {
		return ebcdicChar;
	}
	public void setEbcdicChar(String ebcdicChar) {
		this.ebcdicChar = ebcdicChar;
	}
	public int getEbcdicInt() {
		return ebcdicInt;
	}
	public void setEbcdicInt(int ebcdicInt) {
		this.ebcdicInt = ebcdicInt;
	}
}
