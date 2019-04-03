package com.bsva.dao.v02.cisbins.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankCodeEntity {

    @Id
    @Column(name = "BANK_CODE")
    private Integer bankCode;
    
    public BankCodeEntity(){
    	
    }
    
    public Integer getBankCode() {
		return bankCode;
	}
    public void setBankCode(Integer bankCode) {
		this.bankCode = bankCode;
	}
   

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(bankCode);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankCode == null) ? 0 : bankCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankCodeEntity other = (BankCodeEntity) obj;
		if (bankCode == null) {
			if (other.bankCode != null)
				return false;
		}
		else if (!bankCode.equals(other.bankCode))
			return false;
		return true;
	}
   
}
