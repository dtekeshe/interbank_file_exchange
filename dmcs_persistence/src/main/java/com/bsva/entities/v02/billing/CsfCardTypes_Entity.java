package com.bsva.entities.v02.billing;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table
@DynamicUpdate
public class CsfCardTypes_Entity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CARD_TYPE")
	private String cardTypes;
	@Column(name = "CARD_DESCRIPTION")
	private String cardDescription;
	@Column(name = "ACTIVE_IND")
	private String activeIndicator;
	
	public CsfCardTypes_Entity(){
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCardTypes() {
		return cardTypes;
	}

	public String getCardDescription() {
		return cardDescription;
	}

	public String getActiveIndicator() {
		return activeIndicator;
	}

	public void setCardTypes(String cardTypes) {
		this.cardTypes = cardTypes;
	}

	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}

	public void setActiveIndicator(String activeIndicator) {
		this.activeIndicator = activeIndicator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activeIndicator == null) ? 0 : activeIndicator.hashCode());
		result = prime * result + ((cardDescription == null) ? 0 : cardDescription.hashCode());
		result = prime * result + ((cardTypes == null) ? 0 : cardTypes.hashCode());
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
		CsfCardTypes_Entity other = (CsfCardTypes_Entity) obj;
		if (activeIndicator == null) {
			if (other.activeIndicator != null)
				return false;
		} else if (!activeIndicator.equals(other.activeIndicator))
			return false;
		if (cardDescription == null) {
			if (other.cardDescription != null)
				return false;
		} else if (!cardDescription.equals(other.cardDescription))
			return false;
		if (cardTypes == null) {
			if (other.cardTypes != null)
				return false;
		} else if (!cardTypes.equals(other.cardTypes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsfCardTypes_Entity [cardTypes=");
		builder.append(cardTypes);
		builder.append(", cardDescription=");
		builder.append(cardDescription);
		builder.append(", activeIndicator=");
		builder.append(activeIndicator);
		builder.append("]");
		return builder.toString();
	}
	
	

}
