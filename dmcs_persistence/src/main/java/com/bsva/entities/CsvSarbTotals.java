package com.bsva.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name= "CSV_SARB_TOTALS_VIEW")
@DynamicUpdate
public class CsvSarbTotals {
	@Column(name="ACQUIRER_MEMBER")
	private String acquirerMember;
	@Id
	@Column(name="CSVSTR")
	private String csvString;
	
	public CsvSarbTotals(){
		
	}
	public CsvSarbTotals(String acquirerMember,String csvString){
		this.acquirerMember = acquirerMember;
		this.csvString = csvString;
		
	}
	public String getAcquirerMember() {
		return acquirerMember;
	}
	public String getCsvString() {
		return csvString;
	}
	public void setAcquirerMember(String acquirerMember) {
		this.acquirerMember = acquirerMember;
	}
	public void setCsvString(String csvString) {
		this.csvString = csvString;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquirerMember == null) ? 0 : acquirerMember.hashCode());
		result = prime * result + ((csvString == null) ? 0 : csvString.hashCode());
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
		CsvSarbTotals other = (CsvSarbTotals) obj;
		if (acquirerMember == null) {
			if (other.acquirerMember != null)
				return false;
		} else if (!acquirerMember.equals(other.acquirerMember))
			return false;
		if (csvString == null) {
			if (other.csvString != null)
				return false;
		} else if (!csvString.equals(other.csvString))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsvSarbTotals [acquirerMember=");
		builder.append(acquirerMember);
		builder.append(", csvString=");
		builder.append(csvString);
		builder.append("]");
		return builder.toString();
	}
	

}
