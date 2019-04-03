package com.bsva.dcms.commons.dto;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CssCcr002StatsDTO implements java.io.Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date processDate;
	private String service;
	private String subService;
	private int targetBank;
	private int otherBank;
	private double feesAsAcq;
	private double feesAsIss;
	private double nettFees;

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

	public int getTargetBank() {
		return this.targetBank;
	}

	public void setTargetBank(int targetBank) {
		this.targetBank=targetBank;
	}

	public int getOtherBank() {
		return this.otherBank;
	}

	public void setOtherBank(int otherBank) {
		this.otherBank=otherBank;
	}

	public double getFeesAsAcq() {
		return this.feesAsAcq;
	}

	public void setFeesAsAcq(double feesAsAcq) {
		this.feesAsAcq=feesAsAcq;
	}

	public double getFeesAsIss() {
		return this.feesAsIss;
	}

	public void setFeesAsIss(double feesAsIss) {
		this.feesAsIss=feesAsIss;
	}

	public double getNettFees() {
		return this.nettFees;
	}

	public void setNettFees(double nettFees) {
		this.nettFees=nettFees;
	}


	/* Creates and returns a copy of this object. */
	public Object clone() {
		CssCcr002StatsDTO bean = new CssCcr002StatsDTO();
		bean.processDate = this.processDate;
		bean.service = this.service;
		bean.subService = this.subService;
		bean.targetBank = this.targetBank;
		bean.otherBank = this.otherBank;
		bean.feesAsAcq = this.feesAsAcq;
		bean.feesAsIss = this.feesAsIss;
		bean.nettFees = this.nettFees;
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
		sb.append("[").append("this.targetBank").append(" = ").append(this.targetBank).append("]").append(sep);
		sb.append("[").append("this.otherBank").append(" = ").append(this.otherBank).append("]").append(sep);
		sb.append("[").append("this.feesAsAcq").append(" = ").append(this.feesAsAcq).append("]").append(sep);
		sb.append("[").append("this.feesAsIss").append(" = ").append(this.feesAsIss).append("]").append(sep);
		sb.append("[").append("this.nettFees").append(" = ").append(this.nettFees).append("]").append(sep);
		return sb.toString();
	}
}
