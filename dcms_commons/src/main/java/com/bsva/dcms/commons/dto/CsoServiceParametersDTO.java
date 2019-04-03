package com.bsva.dcms.commons.dto;
import java.io.Serializable;
import java.util.Date;


/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoServiceParametersDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date processDate;
	private String service;
	private String subService;
	private String processActiveInd;
	private String inwardStatus;
	private String outwardStatus;
	private String inputRequestClose;

	public Date getProcessDate() {
		return this.processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate=processDate;
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

	public String getProcessActiveInd() {
		return this.processActiveInd;
	}

	public void setProcessActiveInd(String processActiveInd) {
		this.processActiveInd=processActiveInd;
	}

	public String getInwardStatus() {
		return this.inwardStatus;
	}

	public void setInwardStatus(String inwardStatus) {
		this.inwardStatus=inwardStatus;
	}

	public String getOutwardStatus() {
		return this.outwardStatus;
	}

	public void setOutwardStatus(String outwardStatus) {
		this.outwardStatus=outwardStatus;
	}

	public String getInputRequestClose() {
		return this.inputRequestClose;
	}

	public void setInputRequestClose(String inputRequestClose) {
		this.inputRequestClose=inputRequestClose;
	}


	/* Creates and returns a copy of this object. */
	public Object clone() {
		CsoServiceParametersDTO bean = new CsoServiceParametersDTO();
		bean.processDate = this.processDate;
		bean.service = this.service;
		bean.subService = this.subService;
		bean.processActiveInd = this.processActiveInd;
		bean.inwardStatus = this.inwardStatus;
		bean.outwardStatus = this.outwardStatus;
		bean.inputRequestClose = this.inputRequestClose;
		return bean;
	}
	/* Returns a string representation of the object. */
	public String toString() {
		String sep = "\r\n";
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName()).append(sep);
		sb.append("[").append("this.processDate").append(" = ").append(this.processDate).append("]").append(sep);
		sb.append("[").append("this.service").append(" = ").append(this.service).append("]").append(sep);
		sb.append("[").append("this.subService").append(" = ").append(this.subService).append("]").append(sep);
		sb.append("[").append("this.processActiveInd").append(" = ").append(this.processActiveInd).append("]").append(sep);
		sb.append("[").append("this.inwardStatus").append(" = ").append(this.inwardStatus).append("]").append(sep);
		sb.append("[").append("this.outwardStatus").append(" = ").append(this.outwardStatus).append("]").append(sep);
		sb.append("[").append("this.inputRequestClose").append(" = ").append(this.inputRequestClose).append("]").append(sep);
		return sb.toString();
	}
}
