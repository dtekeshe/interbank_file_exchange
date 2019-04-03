package com.bsva.dto;

public class TxnGroupFleet {
	private final String serviceID;
	private final String subServiceID;
	private final Integer issuerBankCode;
	private final Integer acquirerBankCode;
	
	

	public TxnGroupFleet(String serviceID, String subServiceID, Integer issuerBankCode, Integer acquirerBankCode) {
		super();
		this.serviceID = serviceID;
		this.subServiceID = subServiceID;
		this.issuerBankCode = issuerBankCode;
		this.acquirerBankCode = acquirerBankCode;
	}



	public String getServiceID() {
		return serviceID;
	}



	public String getSubServiceID() {
		return subServiceID;
	}



	public Integer getIssuerBankCode() {
		return issuerBankCode;
	}



	public Integer getAcquirerBankCode() {
		return acquirerBankCode;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquirerBankCode == null) ? 0 : acquirerBankCode.hashCode());
		result = prime * result + ((issuerBankCode == null) ? 0 : issuerBankCode.hashCode());
		result = prime * result + ((serviceID == null) ? 0 : serviceID.hashCode());
		result = prime * result + ((subServiceID == null) ? 0 : subServiceID.hashCode());
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
		TxnGroupFleet other = (TxnGroupFleet) obj;
		if (acquirerBankCode == null) {
			if (other.acquirerBankCode != null)
				return false;
		}
		else if (!acquirerBankCode.equals(other.acquirerBankCode))
			return false;
		if (issuerBankCode == null) {
			if (other.issuerBankCode != null)
				return false;
		}
		else if (!issuerBankCode.equals(other.issuerBankCode))
			return false;
		if (serviceID == null) {
			if (other.serviceID != null)
				return false;
		}
		else if (!serviceID.equals(other.serviceID))
			return false;
		if (subServiceID == null) {
			if (other.subServiceID != null)
				return false;
		}
		else if (!subServiceID.equals(other.subServiceID))
			return false;
		return true;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(serviceID);
		builder.append(subServiceID);
		builder.append(issuerBankCode);
		builder.append(acquirerBankCode);
		return builder.toString();
	}

}
