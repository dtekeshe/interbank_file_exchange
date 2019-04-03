package com.bsva.entities.v02.billing;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSF_CARD_TYPES_DIRECTION")
@DynamicUpdate
public class CsfCardTypesDirection implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@Column(name = "CARD_TYPE")
	private Short cardType;
	@Column(name = "CARD_DIRECTION")
	private String cardDirection;

	public CsfCardTypesDirection() {
	}

	public CsfCardTypesDirection(Short cardType) {
		this.cardType = cardType;
	}

	public Short getCardType() {
		return cardType;
	}

	public void setCardType(Short cardType) {
		this.cardType = cardType;
	}

	public String getCardDirection() {
		return cardDirection;
	}

	public void setCardDirection(String cardDirection) {
		this.cardDirection = cardDirection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (cardType != null ? cardType.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof CsfCardTypesDirection)) {
			return false;
		}
		CsfCardTypesDirection other = (CsfCardTypesDirection) object;
		if ((this.cardType == null && other.cardType != null)
				|| (this.cardType != null && !this.cardType.equals(other.cardType))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.bsva.entities.CsfCardTypesDirection[ cardType=" + cardType + " ]";
	}

}
