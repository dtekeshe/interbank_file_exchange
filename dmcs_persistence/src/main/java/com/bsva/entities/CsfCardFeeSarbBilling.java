package com.bsva.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author SimphiweT
 */
@Entity
@Table(name = "csf_card_fee_sarb_billing", catalog = "cccowner", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsfCardFeeSarbBilling.findAll", query = "SELECT c FROM CsfCardFeeSarbBilling c"),
    @NamedQuery(name = "CsfCardFeeSarbBilling.findByRateDescriptor", query = "SELECT c FROM CsfCardFeeSarbBilling c WHERE c.rateDescriptor = :rateDescriptor"),
    @NamedQuery(name = "CsfCardFeeSarbBilling.findByDebitRate", query = "SELECT c FROM CsfCardFeeSarbBilling c WHERE c.debitRate = :debitRate"),
    @NamedQuery(name = "CsfCardFeeSarbBilling.findByDebitPercent", query = "SELECT c FROM CsfCardFeeSarbBilling c WHERE c.debitPercent = :debitPercent"),
    @NamedQuery(name = "CsfCardFeeSarbBilling.findByCreditRate", query = "SELECT c FROM CsfCardFeeSarbBilling c WHERE c.creditRate = :creditRate"),
    @NamedQuery(name = "CsfCardFeeSarbBilling.findByCreditPercent", query = "SELECT c FROM CsfCardFeeSarbBilling c WHERE c.creditPercent = :creditPercent"),
    @NamedQuery(name = "CsfCardFeeSarbBilling.findByOldDebitRate", query = "SELECT c FROM CsfCardFeeSarbBilling c WHERE c.oldDebitRate = :oldDebitRate"),
    @NamedQuery(name = "CsfCardFeeSarbBilling.findByOldDebitPercent", query = "SELECT c FROM CsfCardFeeSarbBilling c WHERE c.oldDebitPercent = :oldDebitPercent"),
    @NamedQuery(name = "CsfCardFeeSarbBilling.findByOldCreditRate", query = "SELECT c FROM CsfCardFeeSarbBilling c WHERE c.oldCreditRate = :oldCreditRate"),
    @NamedQuery(name = "CsfCardFeeSarbBilling.findByChangeOverDate", query = "SELECT c FROM CsfCardFeeSarbBilling c WHERE c.changeOverDate = :changeOverDate"),
    @NamedQuery(name = "CsfCardFeeSarbBilling.findByOldCreditPercent", query = "SELECT c FROM CsfCardFeeSarbBilling c WHERE c.oldCreditPercent = :oldCreditPercent")})
@DynamicUpdate
public class CsfCardFeeSarbBilling implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RATE_DESCRIPTOR")
    private String rateDescriptor;
    @Column(name = "DEBIT_RATE")
    private Integer debitRate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DEBIT_PERCENT")
    private Double debitPercent;
    @Column(name = "CREDIT_RATE")
    private Integer creditRate;
    @Column(name = "CREDIT_PERCENT")
    private Double creditPercent;
    @Column(name = "OLD_DEBIT_RATE")
    private Integer oldDebitRate;
    @Column(name = "OLD_DEBIT_PERCENT")
    private Double oldDebitPercent;
    @Column(name = "OLD_CREDIT_RATE")
    private Integer oldCreditRate;
    @Column(name = "OLD_CREDIT_PERCENT")
    private Double oldCreditPercent;
    @Lob
    @Column(name = "CHANGE_OVER_DATE")
    private String changeOverDate;

    public CsfCardFeeSarbBilling() {
    }

    public CsfCardFeeSarbBilling(String rateDescriptor) {
        this.rateDescriptor = rateDescriptor;
    }

    public String getRateDescriptor() {
        return rateDescriptor;
    }

    public void setRateDescriptor(String rateDescriptor) {
        this.rateDescriptor = rateDescriptor;
    }

    public Integer getDebitRate() {
        return debitRate;
    }

    public void setDebitRate(Integer debitRate) {
        this.debitRate = debitRate;
    }

    public Double getDebitPercent() {
        return debitPercent;
    }

    public void setDebitPercent(Double debitPercent) {
        this.debitPercent = debitPercent;
    }

    public Integer getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(Integer creditRate) {
        this.creditRate = creditRate;
    }

    public Double getCreditPercent() {
        return creditPercent;
    }

    public void setCreditPercent(Double creditPercent) {
        this.creditPercent = creditPercent;
    }

    public Integer getOldDebitRate() {
        return oldDebitRate;
    }

    public void setOldDebitRate(Integer oldDebitRate) {
        this.oldDebitRate = oldDebitRate;
    }

    public Double getOldDebitPercent() {
        return oldDebitPercent;
    }

    public void setOldDebitPercent(Double oldDebitPercent) {
        this.oldDebitPercent = oldDebitPercent;
    }

    public Integer getOldCreditRate() {
        return oldCreditRate;
    }

    public void setOldCreditRate(Integer oldCreditRate) {
        this.oldCreditRate = oldCreditRate;
    }

    public Double getOldCreditPercent() {
        return oldCreditPercent;
    }

    public void setOldCreditPercent(Double oldCreditPercent) {
        this.oldCreditPercent = oldCreditPercent;
    }

    public String getChangeOverDate() {
        return changeOverDate;
    }

    public void setChangeOverDate(String changeOverDate) {
        this.changeOverDate = changeOverDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rateDescriptor != null ? rateDescriptor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfCardFeeSarbBilling)) {
            return false;
        }
        CsfCardFeeSarbBilling other = (CsfCardFeeSarbBilling) object;
        if ((this.rateDescriptor == null && other.rateDescriptor != null) || (this.rateDescriptor != null && !this.rateDescriptor.equals(other.rateDescriptor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.dmcs.dmcs_entities.CsfCardFeeSarbBilling[ rateDescriptor=" + rateDescriptor + " ]";
    }
    
}
