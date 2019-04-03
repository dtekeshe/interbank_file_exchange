package com.bsva.dmcs.file.reports;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;



/**
 * @author AugustineA
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CCR002 {
	
	@XmlAttribute
	private String companyName;
	private String companyRegNo;
	private String procDate;
	private String procDateStr;
	private Date date;
	private String fileName;
	private int issCode;
	private int currIss;
	private double issFees;
	private double acqFees;
	private double netFee;
	private double total;
	private long invoiceNumber;
	private String to;
	private String branch;
	private String branchCode;
	private Long accountNo;
	private String contactName;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private Long vatRegNo;
	private String fromBankName;
	private String fromAcqFee;
	private String fromIssFee;
	private String fromNetFee;
	private String reportContent;
	private String toBank;
	private String companyRegNumber;
	private String subService;
	private Date processDate;
	private double totalFee;
	
	public CCR002(){
		
	}
	public CCR002(String companyName, String companyRegNo, String procDate,
			String procDateStr, Date date, String fileName, int issCode,
			int currIss, double issFees, double acqFees, double netFee,
			double total, long invoiceNumber, String to, String branch,
			String branchCode, Long accountNo, String contactName,
			String address1, String address2, String address3, String address4,
			Long vatRegNo, String fromBankName, String fromAcqFee,
			String fromIssFee, String fromNetFee, String reportContent,
			String toBank, String companyRegNumber, String subService,
			Date processDate, double totalFee) {
		super();
		this.companyName = companyName;
		this.companyRegNo = companyRegNo;
		this.procDate = procDate;
		this.procDateStr = procDateStr;
		this.date = date;
		this.fileName = fileName;
		this.issCode = issCode;
		this.currIss = currIss;
		this.issFees = issFees;
		this.acqFees = acqFees;
		this.netFee = netFee;
		this.total = total;
		this.invoiceNumber = invoiceNumber;
		this.to = to;
		this.branch = branch;
		this.branchCode = branchCode;
		this.accountNo = accountNo;
		this.contactName = contactName;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.address4 = address4;
		this.vatRegNo = vatRegNo;
		this.fromBankName = fromBankName;
		this.fromAcqFee = fromAcqFee;
		this.fromIssFee = fromIssFee;
		this.fromNetFee = fromNetFee;
		this.reportContent = reportContent;
		this.toBank = toBank;
		this.companyRegNumber = companyRegNumber;
		this.subService = subService;
		this.processDate = processDate;
		this.totalFee = totalFee;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyRegNo() {
		return companyRegNo;
	}
	public void setCompanyRegNo(String companyRegNo) {
		this.companyRegNo = companyRegNo;
	}
	public String getProcDate() {
		return procDate;
	}
	public void setProcDate(String procDate) {
		this.procDate = procDate;
	}
	public String getProcDateStr() {
		return procDateStr;
	}
	public void setProcDateStr(String procDateStr) {
		this.procDateStr = procDateStr;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getIssCode() {
		return issCode;
	}
	public void setIssCode(int issCode) {
		this.issCode = issCode;
	}
	public int getCurrIss() {
		return currIss;
	}
	public void setCurrIss(int currIss) {
		this.currIss = currIss;
	}
	public double getIssFees() {
		return issFees;
	}
	public void setIssFees(double issFees) {
		this.issFees = issFees;
	}
	public double getAcqFees() {
		return acqFees;
	}
	public void setAcqFees(double acqFees) {
		this.acqFees = acqFees;
	}
	public double getNetFee() {
		return netFee;
	}
	public void setNetFee(double netFee) {
		this.netFee = netFee;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public long getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getAddress4() {
		return address4;
	}
	public void setAddress4(String address4) {
		this.address4 = address4;
	}
	public Long getvatRegNo() {
		return vatRegNo;
	}
	public void setvatRegNo(Long vatRegNo) {
		this.vatRegNo = vatRegNo;
	}
	public String getFromBankName() {
		return fromBankName;
	}
	public void setFromBankName(String fromBankName) {
		this.fromBankName = fromBankName;
	}
	public String getFromAcqFee() {
		return fromAcqFee;
	}
	public void setFromAcqFee(String fromAcqFee) {
		this.fromAcqFee = fromAcqFee;
	}
	public String getFromIssFee() {
		return fromIssFee;
	}
	public void setFromIssFee(String fromIssFee) {
		this.fromIssFee = fromIssFee;
	}
	public String getFromNetFee() {
		return fromNetFee;
	}
	public void setFromNetFee(String fromNetFee) {
		this.fromNetFee = fromNetFee;
	}
	public String getReportContent() {
		return reportContent;
	}
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}
	public String getToBank() {
		return toBank;
	}
	public void setToBank(String toBank) {
		this.toBank = toBank;
	}
	public String getCompanyRegNumber() {
		return companyRegNumber;
	}
	public void setCompanyRegNumber(String companyRegNumber) {
		this.companyRegNumber = companyRegNumber;
	}
	public String getSubService() {
		return subService;
	}
	public void setSubService(String subService) {
		this.subService = subService;
	}
	public Date getProcessDate() {
		return processDate;
	}
	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}
	public double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(companyName);
		builder.append(companyRegNo);
		builder.append(procDate);
		builder.append(procDateStr);
		builder.append(date);
		builder.append(fileName);
		builder.append(issCode);
		builder.append(currIss);
		builder.append(issFees);
		builder.append(acqFees);
		builder.append(netFee);
		builder.append(total);
		builder.append(invoiceNumber);
		builder.append(to);
		builder.append(branch);
		builder.append(branchCode);
		builder.append(accountNo);
		builder.append(contactName);
		builder.append(address1);
		builder.append(address2);
		builder.append(address3);
		builder.append(address4);
		builder.append(vatRegNo);
		builder.append(fromBankName);
		builder.append(fromAcqFee);
		builder.append(fromIssFee);
		builder.append(fromNetFee);
		builder.append(reportContent);
		builder.append(toBank);
		builder.append(companyRegNumber);
		builder.append(subService);
		builder.append(processDate);
		builder.append(totalFee);
		return builder.toString();
	}

}
