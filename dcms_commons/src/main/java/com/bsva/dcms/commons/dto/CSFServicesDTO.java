package com.bsva.dcms.commons.dto;

import java.io.Serializable;
import java.util.Date;


/**
*
* @author Nombuyiselo Mbangula <nombuyiselom@bankservafrica.com>
*/

public class CSFServicesDTO implements Serializable {

	private String serviceCode;
	private String serviceName;
	private String activeIndicator;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDate;
	private int inputSla;
	private int settleSla;
	private int outputSla;
	

	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getActiveIndicator() {
		return activeIndicator;
	}
	public void setActiveIndicator(String activeIndicator) {
		this.activeIndicator = activeIndicator;
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
	public int getInputSla() {
		return inputSla;
	}
	public void setInputSla(int inputSla) {
		this.inputSla = inputSla;
	}
	public int getSettleSla() {
		return settleSla;
	}
	public void setSettleSla(int settleSla) {
		this.settleSla = settleSla;
	}
	public int getOutputSla() {
		return outputSla;
	}
	public void setOutputSla(int outputSla) {
		this.outputSla = outputSla;
	}
	
	
}
