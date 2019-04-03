package com.bsva.entities.v02.loader;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class McardChargeBacksEntity_PK implements Serializable {

	@Column(name = "MESSAGE_TYPE_IND")
	private Integer messageTypeIndicator;

	@Column(name = "FUNCTION_CODE")
	private Integer functionCode;

	public McardChargeBacksEntity_PK() {

	}

	public Integer getMessageTypeIndicator() {
		return messageTypeIndicator;
	}

	public Integer getFunctionCode() {
		return functionCode;
	}

	public void setMessageTypeIndicator(Integer messageTypeIndicator) {
		this.messageTypeIndicator = messageTypeIndicator;
	}

	public void setFunctionCode(Integer functionCode) {
		this.functionCode = functionCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((functionCode == null) ? 0 : functionCode.hashCode());
		result = prime * result + ((messageTypeIndicator == null) ? 0 : messageTypeIndicator.hashCode());
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
		McardChargeBacksEntity_PK other = (McardChargeBacksEntity_PK) obj;
		if (functionCode == null) {
			if (other.functionCode != null)
				return false;
		}
		else if (!functionCode.equals(other.functionCode))
			return false;
		if (messageTypeIndicator == null) {
			if (other.messageTypeIndicator != null)
				return false;
		}
		else if (!messageTypeIndicator.equals(other.messageTypeIndicator))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("McardChargeBacksEntity_PK [messageTypeIndicator=");
		builder.append(messageTypeIndicator);
		builder.append(", functionCode=");
		builder.append(functionCode);
		builder.append("]");
		return builder.toString();
	}

	

}
