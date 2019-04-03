package com.bsva.dao.v02.cisbins.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CisBinsMemberInfoEntity {
	
	@Column(name="BANK_CODE")
	private String bankCode;
	@Column(name="MEMBER_NAME")
	private String membername;
	@Id
	@Column(name="VAT_REG_NUMBER")
	private String vatRegNumber;
	
	public CisBinsMemberInfoEntity(){
		
	}

	public String getBankCode() {
		return bankCode;
	}

	public String getMembername() {
		return membername;
	}

	public String getVatRegNumber() {
		return vatRegNumber;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public void setVatRegNumber(String vatRegNumber) {
		this.vatRegNumber = vatRegNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CisBinsMemberInfoEntity [bankCode=");
		builder.append(bankCode);
		builder.append(", membername=");
		builder.append(membername);
		builder.append(", vatRegNumber=");
		builder.append(vatRegNumber);
		builder.append("]");
		return builder.toString();
	}

}
