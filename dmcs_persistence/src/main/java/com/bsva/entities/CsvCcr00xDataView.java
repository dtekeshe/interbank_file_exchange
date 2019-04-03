package com.bsva.entities;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSV_CCR00X_DATA_VIEW")
/*@NamedQueries({
    @NamedQuery(name = "CsvCcr00xDataView.findAll", query = "SELECT c FROM CsvCcr00xDataView c"),
    @NamedQuery(name = "CsvCcr00xDataView.findByIssuerMember", query = "SELECT c FROM CsvCcr00xDataView c WHERE c.issuerMember = :issuerMember"),
    @NamedQuery(name = "CsvCcr00xDataView.findByIssuerCode", query = "SELECT c FROM CsvCcr00xDataView c WHERE c.issuerCode = :issuerCode"),
    @NamedQuery(name = "CsvCcr00xDataView.findByAcquirerMember", query = "SELECT c FROM CsvCcr00xDataView c WHERE c.acquirerMember = :acquirerMember"),
    @NamedQuery(name = "CsvCcr00xDataView.findByAcquirerCode", query = "SELECT c FROM CsvCcr00xDataView c WHERE c.acquirerCode = :acquirerCode"),
    @NamedQuery(name = "CsvCcr00xDataView.findByService", query = "SELECT c FROM CsvCcr00xDataView c WHERE c.service = :service"),
    @NamedQuery(name = "CsvCcr00xDataView.findBySubService", query = "SELECT c FROM CsvCcr00xDataView c WHERE c.subService = :subService"),
    @NamedQuery(name = "CsvCcr00xDataView.findByCardType", query = "SELECT c FROM CsvCcr00xDataView c WHERE c.cardType = :cardType"),
    @NamedQuery(name = "CsvCcr00xDataView.findByCardDescription", query = "SELECT c FROM CsvCcr00xDataView c WHERE c.cardDescription = :cardDescription"),
    @NamedQuery(name = "CsvCcr00xDataView.findByTransactionCode", query = "SELECT c FROM CsvCcr00xDataView c WHERE c.transactionCode = :transactionCode"),
    @NamedQuery(name = "CsvCcr00xDataView.findByTransactionDescription", query = "SELECT c FROM CsvCcr00xDataView c WHERE c.transactionDescription = :transactionDescription"),
    @NamedQuery(name = "CsvCcr00xDataView.findByVolume", query = "SELECT c FROM CsvCcr00xDataView c WHERE c.volume = :volume"),
    @NamedQuery(name = "CsvCcr00xDataView.findByTranValue", query = "SELECT c FROM CsvCcr00xDataView c WHERE c.tranValue = :tranValue"),
    @NamedQuery(name = "CsvCcr00xDataView.findByBillingFee", query = "SELECT c FROM CsvCcr00xDataView c WHERE c.billingFee = :billingFee"),
    @NamedQuery(name = "CsvCcr00xDataView.findByBillingFeeAmount", query = "SELECT c FROM CsvCcr00xDataView c WHERE c.billingFeeAmount = :billingFeeAmount"),
    @NamedQuery(name = "CsvCcr00xDataView.findByBillingVat", query = "SELECT c FROM CsvCcr00xDataView c WHERE c.billingVat = :billingVat"),
    @NamedQuery(name = "CsvCcr00xDataView.findByReportSortSequence", query = "SELECT c FROM CsvCcr00xDataView c WHERE c.reportSortSequence = :reportSortSequence")})*/
@DynamicUpdate
public class CsvCcr00xDataView implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected CsvCcr00xDataViewPK csvCcr00xDataViewPK;
    @Size(max = 30)
    @Column(name = "ISSUER_MEMBER")
    private String issuerMember;
    @Size(max = 30)
    @Column(name = "ACQUIRER_MEMBER")
    private String acquirerMember;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "SERVICE")
    private String service;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SUB_SERVICE")
    private String subService;
    @Size(max = 30)
    @Column(name = "CARD_DESCRIPTION")
    private String cardDescription;
    @Size(max = 30)
    @Column(name = "TRANSACTION_DESCRIPTION")
    private String transactionDescription;
    @Column(name = "VOLUME")
    private int volume;
    @Column(name = "TRAN_VALUE")
    private long tranValue;
    @Column(name = "BILLING_FEE")
    private double billingFee;
    @Column(name = "BILLING_FEE_AMOUNT")
    private double billingFeeAmount;
    @Column(name = "BILLING_VAT")
    private double billingVat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REPORT_SORT_SEQUENCE")
    private short reportSortSequence;

    public CsvCcr00xDataView() {
    }
    
    public CsvCcr00xDataView(CsvCcr00xDataViewPK csvCcr00xDataViewPK) {
		this.csvCcr00xDataViewPK = csvCcr00xDataViewPK;
	}

    public CsvCcr00xDataView(CsvCcr00xDataViewPK csvCcr00xDataViewPK,
			String issuerMember, short issuerCode, String acquirerMember,
			short acquirerCode, String service, String subService,
			short cardType, String cardDescription, BigInteger transactionCode,
			String transactionDescription, BigInteger volume,
			BigInteger tranValue, BigInteger billingFee,
			BigInteger billingFeeAmount, BigInteger billingVat,
			short reportSortSequence) {
		super();
		this.csvCcr00xDataViewPK = csvCcr00xDataViewPK;
		this.issuerMember = issuerMember;
		this.acquirerMember = acquirerMember;
		this.service = service;
		this.subService = subService;
		this.cardDescription = cardDescription;
		this.transactionDescription = transactionDescription;
		
		this.reportSortSequence = reportSortSequence;
	}

	public CsvCcr00xDataViewPK getCsvCcr00xDataViewPK() {
		return csvCcr00xDataViewPK;
	}

	public void setCsvCcr00xDataViewPK(CsvCcr00xDataViewPK csvCcr00xDataViewPK) {
		this.csvCcr00xDataViewPK = csvCcr00xDataViewPK;
	}

	public String getIssuerMember() {
        return issuerMember;
    }

    public void setIssuerMember(String issuerMember) {
        this.issuerMember = issuerMember;
    }



    public String getAcquirerMember() {
        return acquirerMember;
    }

    public void setAcquirerMember(String acquirerMember) {
        this.acquirerMember = acquirerMember;
    }

    
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSubService() {
        return subService;
    }

    public void setSubService(String subService) {
        this.subService = subService;
    }


    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }


    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public long getTranValue() {
        return tranValue;
    }

    public void setTranValue(long tranValue) {
        this.tranValue = tranValue;
    }

    public double getBillingFee() {
        return billingFee;
    }

    public void setBillingFee(double billingFee) {
        this.billingFee = billingFee;
    }

    public double getBillingFeeAmount() {
        return billingFeeAmount;
    }

    public void setBillingFeeAmount(double billingFeeAmount) {
        this.billingFeeAmount = billingFeeAmount;
    }

    public double getBillingVat() {
        return billingVat;
    }

    public void setBillingVat(double billingVat) {
        this.billingVat = billingVat;
    }

    public short getReportSortSequence() {
        return reportSortSequence;
    }

    public void setReportSortSequence(short reportSortSequence) {
        this.reportSortSequence = reportSortSequence;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		/*result = prime * result
				+ ((acquirerMember == null) ? 0 : acquirerMember.hashCode());
		result = prime * result
				+ ((billingFee == null) ? 0 : billingFee.hashCode());
		result = prime
				* result
				+ ((billingFeeAmount == null) ? 0 : billingFeeAmount.hashCode());
		result = prime * result
				+ ((billingVat == null) ? 0 : billingVat.hashCode());
		result = prime * result
				+ ((cardDescription == null) ? 0 : cardDescription.hashCode());
		result = prime
				* result
				+ ((csvCcr00xDataViewPK == null) ? 0 : csvCcr00xDataViewPK
						.hashCode());
		result = prime * result
				+ ((issuerMember == null) ? 0 : issuerMember.hashCode());
		result = prime * result + reportSortSequence;
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result
				+ ((subService == null) ? 0 : subService.hashCode());
		result = prime * result
				+ ((tranValue == null) ? 0 : tranValue.hashCode());
		result = prime
				* result
				+ ((transactionDescription == null) ? 0
						: transactionDescription.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());*/
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
		CsvCcr00xDataView other = (CsvCcr00xDataView) obj;
		
		if (acquirerMember == null) {
			if (other.acquirerMember != null)
				return false;
		} else if (!acquirerMember.equals(other.acquirerMember))
			return false;
		/*if (billingFee == null) {
			if (other.billingFee != null)
				return false;
		} else if (!billingFee.equals(other.billingFee))
			return false;
		if (billingFeeAmount == null) {
			if (other.billingFeeAmount != null)
				return false;
		} else if (!billingFeeAmount.equals(other.billingFeeAmount))
			return false;
		if (billingVat == null) {
			if (other.billingVat != null)
				return false;
		} else if (!billingVat.equals(other.billingVat))
			return false;*/
		if (cardDescription == null) {
			if (other.cardDescription != null)
				return false;
		} else if (!cardDescription.equals(other.cardDescription))
			return false;
		if (csvCcr00xDataViewPK == null) {
			if (other.csvCcr00xDataViewPK != null)
				return false;
		} else if (!csvCcr00xDataViewPK.equals(other.csvCcr00xDataViewPK))
			return false;
		if (issuerMember == null) {
			if (other.issuerMember != null)
				return false;
		} else if (!issuerMember.equals(other.issuerMember))
			return false;
		if (reportSortSequence != other.reportSortSequence)
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (subService == null) {
			if (other.subService != null)
				return false;
		} else if (!subService.equals(other.subService))
			return false;
		/*if (tranValue == null) {
			if (other.tranValue != null)
				return false;
		} else if (!tranValue.equals(other.tranValue))
			return false;
		if (transactionDescription == null) {
			if (other.transactionDescription != null)
				return false;
		} else if (!transactionDescription.equals(other.transactionDescription))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;*/
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsvCcr00xDataView [csvCcr00xDataViewPK=");
		builder.append(csvCcr00xDataViewPK);
		builder.append(", issuerMember=");
		builder.append(issuerMember);
		builder.append(", issuerCode=");
		builder.append(", acquirerMember=");
		builder.append(acquirerMember);
		builder.append(", acquirerCode=");
		builder.append(", service=");
		builder.append(service);
		builder.append(", subService=");
		builder.append(subService);
		builder.append(", cardType=");
		builder.append(", cardDescription=");
		builder.append(cardDescription);
		builder.append(", transactionCode=");
		builder.append(", transactionDescription=");
		builder.append(transactionDescription);
		builder.append(", volume=");
		//builder.append(volume);
		//builder.append(", tranValue=");
		//builder.append(tranValue);
		//builder.append(", billingFee=");
		//builder.append(billingFee);
		//builder.append(", billingFeeAmount=");
		//builder.append(billingFeeAmount);
		//builder.append(", billingVat=");
		//builder.append(billingVat);
		builder.append(", reportSortSequence=");
		builder.append(reportSortSequence);
		builder.append("]");
		return builder.toString();
	}

	
    
}
