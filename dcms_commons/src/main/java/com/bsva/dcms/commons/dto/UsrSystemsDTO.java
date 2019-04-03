package com.bsva.dcms.commons.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class UsrSystemsDTO implements Serializable {
	private String fullSystemName;
	private String systemName;

	public String getFullSystemName() {
		return this.fullSystemName;
	}

	public void setFullSystemName(String fullSystemName) {
		this.fullSystemName=fullSystemName;
	}

	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName=systemName;
	}

}
