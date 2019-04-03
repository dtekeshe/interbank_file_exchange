package com.bsva.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

	/**
	 *
	 * @author AugustineA
	 */
	@Entity
	@Table(name = "CSV_CCR015_VIEW")
	@DynamicUpdate
	public class CsvCcr015View implements Serializable {
		
	    private static final long serialVersionUID = 1L;
	    @EmbeddedId
	    private CsvCcr015View_PK csvCcr015ViewPK;
	    @Size(max = 30)
	    @Column(name = "ISSUER_MEMBER_NAME")
	    private String issuerMemberName;
	    @Size(max = 30)
	    @Column(name = "ACQUIRING_MEMBER_NAME")
	    private String acquiringMemberName;
	    @Column(name = "ITEM_CHARGE_AMOUNT")
	    private Long itemChargeAmount;
	    @Column(name = "VOLUME")
	    private Long volume;
	    @Column(name = "VALUE")
	    private Long value;
	    @Column(name = "TOTAL_COST")
	    private Long totalCost;

	   

		public CsvCcr015View() {
	    }
		
		public CsvCcr015View(CsvCcr015View_PK csvCcr015ViewPK, String issuerMemberName, String acquiringMemberName,
				Long itemChargeAmount, Long volume, Long value, Long totalCost) {
			super();
			this.csvCcr015ViewPK = csvCcr015ViewPK;
			this.issuerMemberName = issuerMemberName;
			this.acquiringMemberName = acquiringMemberName;
			this.itemChargeAmount = itemChargeAmount;
			this.volume = volume;
			this.value = value;
			this.totalCost = totalCost;
		}

		public CsvCcr015View_PK getCsvCcr015ViewPK() {
			return csvCcr015ViewPK;
		}

		public void setCsvCcr015ViewPK(CsvCcr015View_PK csvCcr015ViewPK) {
			this.csvCcr015ViewPK = csvCcr015ViewPK;
		}

	    public String getIssuerMemberName() {
	        return issuerMemberName;
	    }

	    public void setIssuerMemberName(String issuerMemberName) {
	        this.issuerMemberName = issuerMemberName;
	    }

	  

	    public String getAcquiringMemberName() {
	        return acquiringMemberName;
	    }

	    public void setAcquiringMemberName(String acquiringMemberName) {
	        this.acquiringMemberName = acquiringMemberName;
	    }

	    

	    public Long getItemChargeAmount() {
	        return itemChargeAmount;
	    }

	    public void setItemChargeAmount(Long itemChargeAmount) {
	        this.itemChargeAmount = itemChargeAmount;
	    }
	  
	    public Long getVolume() {
	        return volume;
	    }

	    public void setVolume(Long volume) {
	        this.volume = volume;
	    }

	    public Long getValue() {
	        return value;
	    }

	    public void setValue(Long value) {
	        this.value = value;
	    }

	    public Long getTotalCost() {
	        return totalCost;
	    }

	    public void setTotalCost(Long totalCost) {
	        this.totalCost = totalCost;
	    }

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((acquiringMemberName == null) ? 0 : acquiringMemberName.hashCode());
			result = prime * result + ((csvCcr015ViewPK == null) ? 0 : csvCcr015ViewPK.hashCode());
			result = prime * result + ((issuerMemberName == null) ? 0 : issuerMemberName.hashCode());
			result = prime * result + ((itemChargeAmount == null) ? 0 : itemChargeAmount.hashCode());
			result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
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
			CsvCcr015View other = (CsvCcr015View) obj;
			if (acquiringMemberName == null) {
				if (other.acquiringMemberName != null)
					return false;
			} else if (!acquiringMemberName.equals(other.acquiringMemberName))
				return false;
			if (csvCcr015ViewPK == null) {
				if (other.csvCcr015ViewPK != null)
					return false;
			} else if (!csvCcr015ViewPK.equals(other.csvCcr015ViewPK))
				return false;
			if (issuerMemberName == null) {
				if (other.issuerMemberName != null)
					return false;
			} else if (!issuerMemberName.equals(other.issuerMemberName))
				return false;
			if (itemChargeAmount == null) {
				if (other.itemChargeAmount != null)
					return false;
			} else if (!itemChargeAmount.equals(other.itemChargeAmount))
				return false;
			if (totalCost == null) {
				if (other.totalCost != null)
					return false;
			} else if (!totalCost.equals(other.totalCost))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			if (volume == null) {
				if (other.volume != null)
					return false;
			} else if (!volume.equals(other.volume))
				return false;
			return true;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("CsvCcr015View [csvCcr015ViewPK=");
			builder.append(csvCcr015ViewPK);
			builder.append(", issuerMemberName=");
			builder.append(issuerMemberName);
			builder.append(", acquiringMemberName=");
			builder.append(acquiringMemberName);
			builder.append(", itemChargeAmount=");
			builder.append(itemChargeAmount);
			builder.append(", volume=");
			builder.append(volume);
			builder.append(", value=");
			builder.append(value);
			builder.append(", totalCost=");
			builder.append(totalCost);
			builder.append("]");
			return builder.toString();
		}
	    
	}

