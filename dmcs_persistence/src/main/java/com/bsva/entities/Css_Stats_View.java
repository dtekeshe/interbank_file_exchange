package com.bsva.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "CSS_STATS_VIEW")
@DynamicUpdate
public class Css_Stats_View implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private Css_Stats_View_PK Css_Stats_View_PK ;	
	
	    @Column(name = "INTERCHANGE_RATE_DESIGNATOR")	    
	    private Short interchangeRateDesignator;   
	    
	    @Column(name = "TRANSACTION_DESCRIPTION")
	    private String transactionDescription;
	    
	    @Column(name = "TOTAL_COUNT")
	    private BigDecimal totalCount;
	    
	    @Column(name = "TOTAL_AMOUNT")
	    private BigDecimal totalAmount;
	    
	    @Column(name = "TOTAL_COST")
	    private BigDecimal totalCost;
	    @Column(name = "MERCHANT_CAT_CODE")
	    private String merchantCatCode;
	    
	   
		public Css_Stats_View() {
		}

		public Css_Stats_View_PK getCss_Stats_View_PK() {
			return Css_Stats_View_PK;
		}

		public Short getInterchangeRateDesignator() {
			return interchangeRateDesignator;
		}

		public String getTransactionDescription() {
			return transactionDescription;
		}

		public BigDecimal getTotalCount() {
			return totalCount;
		}

		public BigDecimal getTotalAmount() {
			return totalAmount;
		}

		public BigDecimal getTotalCost() {
			return totalCost;
		}

		public String getMerchantCatCode() {
			return merchantCatCode;
		}


		public void setCss_Stats_View_PK(Css_Stats_View_PK css_Stats_View_PK) {
			Css_Stats_View_PK = css_Stats_View_PK;
		}

		public void setInterchangeRateDesignator(Short interchangeRateDesignator) {
			this.interchangeRateDesignator = interchangeRateDesignator;
		}

		public void setTransactionDescription(String transactionDescription) {
			this.transactionDescription = transactionDescription;
		}

		public void setTotalCount(BigDecimal totalCount) {
			this.totalCount = totalCount;
		}

		public void setTotalAmount(BigDecimal totalAmount) {
			this.totalAmount = totalAmount;
		}

		public void setTotalCost(BigDecimal totalCost) {
			this.totalCost = totalCost;
		}

		public void setMerchantCatCode(String merchantCatCode) {
			this.merchantCatCode = merchantCatCode;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Css_Stats_View_PK == null) ? 0 : Css_Stats_View_PK.hashCode());
			result = prime * result + ((interchangeRateDesignator == null) ? 0 : interchangeRateDesignator.hashCode());
			result = prime * result + ((merchantCatCode == null) ? 0 : merchantCatCode.hashCode());
			result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
			result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
			result = prime * result + ((totalCount == null) ? 0 : totalCount.hashCode());
			result = prime * result + ((transactionDescription == null) ? 0 : transactionDescription.hashCode());
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
			Css_Stats_View other = (Css_Stats_View) obj;
			if (Css_Stats_View_PK == null) {
				if (other.Css_Stats_View_PK != null)
					return false;
			} else if (!Css_Stats_View_PK.equals(other.Css_Stats_View_PK))
				return false;
			if (interchangeRateDesignator == null) {
				if (other.interchangeRateDesignator != null)
					return false;
			} else if (!interchangeRateDesignator.equals(other.interchangeRateDesignator))
				return false;
			if (merchantCatCode == null) {
				if (other.merchantCatCode != null)
					return false;
			} else if (!merchantCatCode.equals(other.merchantCatCode))
				return false;
			if (totalAmount == null) {
				if (other.totalAmount != null)
					return false;
			} else if (!totalAmount.equals(other.totalAmount))
				return false;
			if (totalCost == null) {
				if (other.totalCost != null)
					return false;
			} else if (!totalCost.equals(other.totalCost))
				return false;
			if (totalCount == null) {
				if (other.totalCount != null)
					return false;
			} else if (!totalCount.equals(other.totalCount))
				return false;
			if (transactionDescription == null) {
				if (other.transactionDescription != null)
					return false;
			} else if (!transactionDescription.equals(other.transactionDescription))
				return false;
			return true;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(Css_Stats_View_PK);
			builder.append(interchangeRateDesignator);
			builder.append(transactionDescription);
			builder.append(totalCount);
			builder.append(totalAmount);
			builder.append(totalCost);
			builder.append(merchantCatCode);
			return builder.toString();
		}

		
	
}
