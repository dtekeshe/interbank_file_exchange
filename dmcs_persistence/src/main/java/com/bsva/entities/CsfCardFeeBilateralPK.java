package com.bsva.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author AugustineA
 */
@Embeddable
public class CsfCardFeeBilateralPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTION_CODE")
    private String transactionCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISSUING_MEMBER")
    private String issuingMember;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACQUIRING_MEMBER")
    private String acquiringMember;

    public CsfCardFeeBilateralPK() {
    }

    public CsfCardFeeBilateralPK(String transactionCode, String issuingMember, String acquiringMember) {
        this.transactionCode = transactionCode;
        this.issuingMember = issuingMember;
        this.acquiringMember = acquiringMember;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getIssuingMember() {
        return issuingMember;
    }

    public void setIssuingMember(String issuingMember) {
        this.issuingMember = issuingMember;
    }

    public String getAcquiringMember() {
        return acquiringMember;
    }

    public void setAcquiringMember(String acquiringMember) {
        this.acquiringMember = acquiringMember;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash +=  Integer.valueOf(transactionCode);
        hash += Integer.valueOf(issuingMember);
        hash += Integer.valueOf( acquiringMember);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfCardFeeBilateralPK)) {
            return false;
        }
        CsfCardFeeBilateralPK other = (CsfCardFeeBilateralPK) object;
        if (this.transactionCode != other.transactionCode) {
            return false;
        }
        if (this.issuingMember != other.issuingMember) {
            return false;
        }
        if (this.acquiringMember != other.acquiringMember) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfCardFeeBilateralPK[ transactionCode=" + transactionCode + ", issuingMember=" + issuingMember + ", acquiringMember=" + acquiringMember + " ]";
    }
    
}
