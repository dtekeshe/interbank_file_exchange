package com.bsva.entities.v02.settlement;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CsvSettlementView_PK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "ORIGINATING_BANK")
	private Integer originatingBank;
	@Column(name = "HOMING_BANK")
	private Integer homingBank;
	@Column(name = "PROCESS_DATE")
	private Date processDate;
	@Column(name = "SERVICE")
	private String service;
	@Column(name = "SUB_SERVICE")
	private String subService;
	@Column(name = "SETTLEMENT_NAME")
	private String settlementName;
	
	public CsvSettlementView_PK(){
		
	}

	public CsvSettlementView_PK(Integer originatingBank, Integer homingBank, Date processDate, String service,
			String subService, String settlementName) {
		super();
		this.originatingBank = originatingBank;
		this.homingBank = homingBank;
		this.processDate = processDate;
		this.service = service;
		this.subService = subService;
		this.settlementName = settlementName;
	}

	public Integer getOriginatingBank() {
		return originatingBank;
	}

	public Integer getHomingBank() {
		return homingBank;
	}

	public Date getProcessDate() {
		return processDate;
	}

	public String getService() {
		return service;
	}

	public String getSubService() {
		return subService;
	}

	public String getSettlementName() {
		return settlementName;
	}

	public void setOriginatingBank(Integer originatingBank) {
		this.originatingBank = originatingBank;
	}

	public void setHomingBank(Integer homingBank) {
		this.homingBank = homingBank;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setSubService(String subService) {
		this.subService = subService;
	}

	public void setSettlementName(String settlementName) {
		this.settlementName = settlementName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((homingBank == null) ? 0 : homingBank.hashCode());
		result = prime * result + ((originatingBank == null) ? 0 : originatingBank.hashCode());
		result = prime * result + ((processDate == null) ? 0 : processDate.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result + ((settlementName == null) ? 0 : settlementName.hashCode());
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
		CsvSettlementView_PK other = (CsvSettlementView_PK) obj;
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
		if (processDate == null) {
			if (other.processDate != null)
				return false;
		} else if (!processDate.equals(other.processDate))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (settlementName == null) {
			if (other.settlementName != null)
				return false;
		} else if (!settlementName.equals(other.settlementName))
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
		builder.append(processDate);
		builder.append(service);
		builder.append(subService);
		builder.append(settlementName);
		return builder.toString();
	}
	
	
}
