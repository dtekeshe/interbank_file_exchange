package com.bsva.entities.v02.billing;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class FleetBillingKey implements Serializable {

    @Column(name = "TRAN_SYSTEM_SEQ_NUMBER")
    private Integer systemSeqNumber;
    @Column(name = "ISSUER_CODE")
    private Integer issuerCode;
    @Column(name = "ACQUIRER_CODE")
    private Integer acquirerCode;
    @Column(name = "TXN_CODE")
    private Integer txnCode;
    @Column(name = "CARD_TYPE")
    private Integer cardType;

    public Integer getSystemSeqNumber() {
        return systemSeqNumber;
    }

    public void setSystemSeqNumber(Integer systemSeqNumber) {
        this.systemSeqNumber = systemSeqNumber;
    }

    public Integer getIssuerCode() {
        return issuerCode;
    }

    public void setIssuerCode(Integer issuerCode) {
        this.issuerCode = issuerCode;
    }

    public Integer getAcquirerCode() {
        return acquirerCode;
    }

    public void setAcquirerCode(Integer acquirerCode) {
        this.acquirerCode = acquirerCode;
    }

    public Integer getTxnCode() {
        return txnCode;
    }

    public void setTxnCode(Integer txnCode) {
        this.txnCode = txnCode;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquirerCode == null) ? 0 : acquirerCode.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((issuerCode == null) ? 0 : issuerCode.hashCode());
		result = prime * result + ((systemSeqNumber == null) ? 0 : systemSeqNumber.hashCode());
		result = prime * result + ((txnCode == null) ? 0 : txnCode.hashCode());
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
		FleetBillingKey other = (FleetBillingKey) obj;
		if (acquirerCode == null) {
			if (other.acquirerCode != null)
				return false;
		} else if (!acquirerCode.equals(other.acquirerCode))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		} else if (!cardType.equals(other.cardType))
			return false;
		if (issuerCode == null) {
			if (other.issuerCode != null)
				return false;
		} else if (!issuerCode.equals(other.issuerCode))
			return false;
		if (systemSeqNumber == null) {
			if (other.systemSeqNumber != null)
				return false;
		} else if (!systemSeqNumber.equals(other.systemSeqNumber))
			return false;
		if (txnCode == null) {
			if (other.txnCode != null)
				return false;
		} else if (!txnCode.equals(other.txnCode))
			return false;
		return true;
	}
}
