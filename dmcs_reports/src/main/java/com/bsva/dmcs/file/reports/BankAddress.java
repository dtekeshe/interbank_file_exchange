package com.bsva.dmcs.file.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class BankAddress {
	
	@XmlAttribute
	private String branch_code;
	private String account_no;
	private String contact_name;
	private String mem_address1;
	private String mem_address2;
	private String mem_address3;
	private String mem_address4;
	private String vat_reg_no;
	
	
	public BankAddress(){
		
	}


	public BankAddress(String branch_code, String account_no,
			String contact_name, String mem_address1, String mem_address2,
			String mem_address3, String mem_address4, String vat_reg_no) {
		super();
		this.branch_code = branch_code;
		this.account_no = account_no;
		this.contact_name = contact_name;
		this.mem_address1 = mem_address1;
		this.mem_address2 = mem_address2;
		this.mem_address3 = mem_address3;
		this.mem_address4 = mem_address4;
		this.vat_reg_no = vat_reg_no;
	}


	public String getBranch_code() {
		return branch_code;
	}


	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}


	public String getAccount_no() {
		return account_no;
	}


	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}


	public String getContact_name() {
		return contact_name;
	}


	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}


	public String getMem_address1() {
		return mem_address1;
	}


	public void setMem_address1(String mem_address1) {
		this.mem_address1 = mem_address1;
	}


	public String getMem_address2() {
		return mem_address2;
	}


	public void setMem_address2(String mem_address2) {
		this.mem_address2 = mem_address2;
	}


	public String getMem_address3() {
		return mem_address3;
	}


	public void setMem_address3(String mem_address3) {
		this.mem_address3 = mem_address3;
	}


	public String getMem_address4() {
		return mem_address4;
	}


	public void setMem_address4(String mem_address4) {
		this.mem_address4 = mem_address4;
	}


	public String getVat_reg_no() {
		return vat_reg_no;
	}


	public void setVat_reg_no(String vat_reg_no) {
		this.vat_reg_no = vat_reg_no;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(branch_code);
		builder.append(account_no);
		builder.append(contact_name);
		builder.append(mem_address1);
		builder.append(mem_address2);
		builder.append(mem_address3);
		builder.append(mem_address4);
		builder.append(vat_reg_no);
		return builder.toString();
	}
	
}
