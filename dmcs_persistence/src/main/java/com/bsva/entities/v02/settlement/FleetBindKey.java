package com.bsva.entities.v02.settlement;

public class FleetBindKey {
	
	private String accountNumber;
	private String acq;
	private String iss;
	private String acqBin;
	
	
	public FleetBindKey(){
		
	}
	
	public String getAcqBin() {
		return acqBin;
	}
	public void setAcqBin(String acqBin) {
		this.acqBin = acqBin;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}


	public String getAcq() {
		return acq;
	}


	public String getIss() {
		return iss;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAcq(String acq) {
		this.acq = acq;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((acq == null) ? 0 : acq.hashCode());
		result = prime * result + ((iss == null) ? 0 : iss.hashCode());
		result = prime * result + ((acqBin == null) ? 0 : acqBin.hashCode());
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
		FleetBindKey other = (FleetBindKey) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		}
		else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (acq == null) {
			if (other.acq != null)
				return false;
		}
		else if (!acq.equals(other.acq))
			return false;
		if (iss == null) {
			if (other.iss != null)
				return false;
		}
		else if (!iss.equals(other.iss))
			return false;
		if(acqBin == null){
			if(other.acqBin != null){
				return false;
			}
		}else if(!acqBin.equals(other.acqBin)){
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(accountNumber);
		builder.append(acq);
		builder.append(iss);
		builder.append(acqBin);
		return builder.toString();
	}

	


}