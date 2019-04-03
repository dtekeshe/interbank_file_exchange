package com.bsva.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CSR018019ReportEntityKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="VOL")
	private String volume;
	@Column(name="VAL")
	private String value;
	@Column(name="NETT_INTCH")
	private String nettInterChange;
	@Column(name="NETT_VAT")
	private String nettVat;
	
	public CSR018019ReportEntityKey(){
		
	}

	public CSR018019ReportEntityKey(String volume, String value, String nettInterChange, String nettVat) {
		super();
		this.volume = volume;
		this.value = value;
		this.nettInterChange = nettInterChange;
		this.nettVat = nettVat;
	}

	public String getVolume() {
		return volume;
	}

	public String getValue() {
		return value;
	}

	public String getNettInterChange() {
		return nettInterChange;
	}

	public String getNettVat() {
		return nettVat;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setNettInterChange(String nettInterChange) {
		this.nettInterChange = nettInterChange;
	}

	public void setNettVat(String nettVat) {
		this.nettVat = nettVat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nettInterChange == null) ? 0 : nettInterChange.hashCode());
		result = prime * result + ((nettVat == null) ? 0 : nettVat.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
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
		CSR018019ReportEntityKey other = (CSR018019ReportEntityKey) obj;
		if (nettInterChange == null) {
			if (other.nettInterChange != null)
				return false;
		}
		else if (!nettInterChange.equals(other.nettInterChange))
			return false;
		if (nettVat == null) {
			if (other.nettVat != null)
				return false;
		}
		else if (!nettVat.equals(other.nettVat))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		}
		else if (!value.equals(other.value))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		}
		else if (!volume.equals(other.volume))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CSR018019ReportEntityKey [volume=");
		builder.append(volume);
		builder.append(", value=");
		builder.append(value);
		builder.append(", nettInterChange=");
		builder.append(nettInterChange);
		builder.append(", nettVat=");
		builder.append(nettVat);
		builder.append("]");
		return builder.toString();
	}


}
