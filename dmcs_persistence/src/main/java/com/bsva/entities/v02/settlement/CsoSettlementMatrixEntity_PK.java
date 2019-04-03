package com.bsva.entities.v02.settlement;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CsoSettlementMatrixEntity_PK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="ORIGINATING_BANK")
	private String originatingBank;
	@Column(name="HOMING_BANK")
	private String homingBank;
	@Column(name="SERVICE")
	private String service;
	@Column(name="SUB_SERVICE")
	private String subService;
	@Column(name="SETTLEMENT_IND")
	private String settlementInd;	
	@Column(name="ACTION_DATE")
	private Date actionDate;
	
	public CsoSettlementMatrixEntity_PK(){
		
	}

	public String getOriginatingBank() {
		return originatingBank;
	}

	public String getHomingBank() {
		return homingBank;
	}

	public String getService() {
		return service;
	}

	public String getSubService() {
		return subService;
	}

	public String getSettlementInd() {
		return settlementInd;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setOriginatingBank(String originatingBank) {
		this.originatingBank = originatingBank;
	}

	public void setHomingBank(String homingBank) {
		this.homingBank = homingBank;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setSubService(String subService) {
		this.subService = subService;
	}

	public void setSettlementInd(String settlementInd) {
		this.settlementInd = settlementInd;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actionDate == null) ? 0 : actionDate.hashCode());
		result = prime * result + ((homingBank == null) ? 0 : homingBank.hashCode());
		result = prime * result + ((originatingBank == null) ? 0 : originatingBank.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result + ((settlementInd == null) ? 0 : settlementInd.hashCode());
		result = prime * result + ((subService == null) ? 0 : subService.hashCode());
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
		CsoSettlementMatrixEntity_PK other = (CsoSettlementMatrixEntity_PK) obj;
		if (actionDate == null) {
			if (other.actionDate != null)
				return false;
		} else if (!actionDate.equals(other.actionDate))
			return false;
		if (homingBank == null) {
			if (other.homingBank != null)
				return false;
		} else if (!homingBank.equals(other.homingBank))
			return false;
		if (originatingBank == null) {
			if (other.originatingBank != null)
				return false;
		} else if (!originatingBank.equals(other.originatingBank))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (settlementInd == null) {
			if (other.settlementInd != null)
				return false;
		} else if (!settlementInd.equals(other.settlementInd))
			return false;
		if (subService == null) {
			if (other.subService != null)
				return false;
		} else if (!subService.equals(other.subService))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(originatingBank);
		builder.append(homingBank);
		builder.append(service);
		builder.append(subService);
		builder.append(settlementInd);
		builder.append(actionDate);
		return builder.toString();
	}
	
	
}
