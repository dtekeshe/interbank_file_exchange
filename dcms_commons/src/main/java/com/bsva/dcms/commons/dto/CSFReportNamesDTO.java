package com.bsva.dcms.commons.dto;

import java.io.Serializable;
import java.util.Date;

public class CSFReportNamesDTO implements Serializable {
	
	private String reportName;
	private String reportTitle;
	private String programName;
	private String activeIndicator;
	private String internalFilename;
	private String externalFilenamePrefix;
	private String internalIndicator;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDate;
	
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getReportTitle() {
		return reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getActiveIndicator() {
		return activeIndicator;
	}
	public void setActiveIndicator(String activeIndicator) {
		this.activeIndicator = activeIndicator;
	}
	public String getInternalFilename() {
		return internalFilename;
	}
	public void setInternalFilename(String internalFilename) {
		this.internalFilename = internalFilename;
	}
	public String getExternalFilenamePrefix() {
		return externalFilenamePrefix;
	}
	public void setExternalFilenamePrefix(String externalFilenamePrefix) {
		this.externalFilenamePrefix = externalFilenamePrefix;
	}
	public String getInternalIndicator() {
		return internalIndicator;
	}
	public void setInternalIndicator(String internalIndicator) {
		this.internalIndicator = internalIndicator;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
