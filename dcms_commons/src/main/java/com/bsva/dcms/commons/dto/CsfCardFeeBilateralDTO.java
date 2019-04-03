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

public class CsfCardFeeBilateralDTO implements java.io.Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cardType;
	private int transactionCode;
	private double interchangeFee;
	private double interchangeFeeAmount;
	private double inputVat;
	private String billIndicator;
	private String activeIndicator;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDate;
	private String countryCode;
	private int issuingMember;
	private int acquiringMember;
	private int amountDirection;
	private String destReport;

	public int getCardType() {
		return this.cardType;
	}

	public void setCardType(int cardType) {
		this.cardType=cardType;
	}

	public int getTransactionCode() {
		return this.transactionCode;
	}

	public void setTransactionCode(int transactionCode) {
		this.transactionCode=transactionCode;
	}

	public double getInterchangeFee() {
		return this.interchangeFee;
	}

	public void setInterchangeFee(double interchangeFee) {
		this.interchangeFee=interchangeFee;
	}

	public double getInterchangeFeeAmount() {
		return this.interchangeFeeAmount;
	}

	public void setInterchangeFeeAmount(double interchangeFeeAmount) {
		this.interchangeFeeAmount=interchangeFeeAmount;
	}

	public double getInputVat() {
		return this.inputVat;
	}

	public void setInputVat(double inputVat) {
		this.inputVat=inputVat;
	}

	public String getBillIndicator() {
		return this.billIndicator;
	}

	public void setBillIndicator(String billIndicator) {
		this.billIndicator=billIndicator;
	}

	public String getActiveIndicator() {
		return this.activeIndicator;
	}

	public void setActiveIndicator(String activeIndicator) {
		this.activeIndicator=activeIndicator;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy=createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate=createdDate;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy=modifiedBy;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate=modifiedDate;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode=countryCode;
	}

	public int getIssuingMember() {
		return this.issuingMember;
	}

	public void setIssuingMember(int issuingMember) {
		this.issuingMember=issuingMember;
	}

	public int getAcquiringMember() {
		return this.acquiringMember;
	}

	public void setAcquiringMember(int acquiringMember) {
		this.acquiringMember=acquiringMember;
	}

	public int getAmountDirection() {
		return this.amountDirection;
	}

	public void setAmountDirection(int amountDirection) {
		this.amountDirection=amountDirection;
	}

	public String getDestReport() {
		return this.destReport;
	}

	public void setDestReport(String destReport) {
		this.destReport=destReport;
	}


	/* Creates and returns a copy of this object. */
	public Object clone() {
		CsfCardFeeBilateralDTO bean = new CsfCardFeeBilateralDTO();
		bean.cardType = this.cardType;
		bean.transactionCode = this.transactionCode;
		bean.interchangeFee = this.interchangeFee;
		bean.interchangeFeeAmount = this.interchangeFeeAmount;
		bean.inputVat = this.inputVat;
		bean.billIndicator = this.billIndicator;
		bean.activeIndicator = this.activeIndicator;
		bean.createdBy = this.createdBy;
		bean.createdDate = this.createdDate;
		bean.modifiedBy = this.modifiedBy;
		bean.modifiedDate = this.modifiedDate;
		bean.countryCode = this.countryCode;
		bean.issuingMember = this.issuingMember;
		bean.acquiringMember = this.acquiringMember;
		bean.amountDirection = this.amountDirection;
		bean.destReport = this.destReport;
		return bean;
	}
	/* Returns a string representation of the object. */
	public String toString() {
		String sep = "\r\n";
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName()).append(sep);
		sb.append("[").append("this.cardType").append(" = ").append(this.cardType).append("]").append(sep);
		sb.append("[").append("this.transactionCode").append(" = ").append(this.transactionCode).append("]").append(sep);
		sb.append("[").append("this.interchangeFee").append(" = ").append(this.interchangeFee).append("]").append(sep);
		sb.append("[").append("this.interchangeFeeAmount").append(" = ").append(this.interchangeFeeAmount).append("]").append(sep);
		sb.append("[").append("this.inputVat").append(" = ").append(this.inputVat).append("]").append(sep);
		sb.append("[").append("this.billIndicator").append(" = ").append(this.billIndicator).append("]").append(sep);
		sb.append("[").append("this.activeIndicator").append(" = ").append(this.activeIndicator).append("]").append(sep);
		sb.append("[").append("this.createdBy").append(" = ").append(this.createdBy).append("]").append(sep);
		sb.append("[").append("this.createdDate").append(" = ").append(this.createdDate).append("]").append(sep);
		sb.append("[").append("this.modifiedBy").append(" = ").append(this.modifiedBy).append("]").append(sep);
		sb.append("[").append("this.modifiedDate").append(" = ").append(this.modifiedDate).append("]").append(sep);
		sb.append("[").append("this.countryCode").append(" = ").append(this.countryCode).append("]").append(sep);
		sb.append("[").append("this.issuingMember").append(" = ").append(this.issuingMember).append("]").append(sep);
		sb.append("[").append("this.acquiringMember").append(" = ").append(this.acquiringMember).append("]").append(sep);
		sb.append("[").append("this.amountDirection").append(" = ").append(this.amountDirection).append("]").append(sep);
		sb.append("[").append("this.destReport").append(" = ").append(this.destReport).append("]").append(sep);
		return sb.toString();
	}
}
