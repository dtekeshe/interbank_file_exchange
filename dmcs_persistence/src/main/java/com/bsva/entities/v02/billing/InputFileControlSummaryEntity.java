package com.bsva.entities.v02.billing;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "CSO_INPUT_FILE_CONTROLS")
@DynamicUpdate
public class InputFileControlSummaryEntity {
	
	@Id
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	@Column(name = "COUNT")
	private BigInteger count;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public BigInteger getCount() {
		return count;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public void setCount(BigInteger count) {
		this.count = count;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
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
		InputFileControlSummaryEntity other = (InputFileControlSummaryEntity) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(amount);
		builder.append(count);
		return builder.toString();
	}

}
