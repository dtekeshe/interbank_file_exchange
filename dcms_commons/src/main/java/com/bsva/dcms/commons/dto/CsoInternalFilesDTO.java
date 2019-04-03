package com.bsva.dcms.commons.dto;

import java.io.Serializable;


/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoInternalFilesDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String filename;
	private String absoluteFilename;
	private String service;
	private String subService;
	private long recordCount;

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename=filename;
	}

	public String getAbsoluteFilename() {
		return this.absoluteFilename;
	}

	public void setAbsoluteFilename(String absoluteFilename) {
		this.absoluteFilename=absoluteFilename;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service=service;
	}

	public String getSubService() {
		return this.subService;
	}

	public void setSubService(String subService) {
		this.subService=subService;
	}

	public long getRecordCount() {
		return this.recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount=recordCount;
	}

}
