package com.bsva.dcms.commons.dto.file;

import java.util.Collection;
import java.util.List;

public class DataElementDTO {
	
	private int number;
	private String value;
	private int length;
	private int maxLength;
	private Collection<PrivateDataSubelementDTO> pds;

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	public Collection<PrivateDataSubelementDTO> getPds() {
		return pds;
	}
	public void setPds(Collection<PrivateDataSubelementDTO> pds) {
		this.pds = pds;
	}
	
}
