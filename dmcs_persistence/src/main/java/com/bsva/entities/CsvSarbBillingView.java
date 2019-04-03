package com.bsva.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "csv_sarb_billing_view", catalog = "cccowner", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsvSarbBillingView.findAll", query = "SELECT c FROM CsvSarbBillingView c"),    
    @NamedQuery(name = "CsvSarbBillingView.findByCardType", query = "SELECT c FROM CsvSarbBillingView c WHERE c.cardType = :cardType"),
    @NamedQuery(name = "CsvSarbBillingView.findByBillingRate", query = "SELECT c FROM CsvSarbBillingView c WHERE c.billingRate = :billingRate"),
    @NamedQuery(name = "CsvSarbBillingView.findByBillingPercent", query = "SELECT c FROM CsvSarbBillingView c WHERE c.billingPercent = :billingPercent")})
@DynamicUpdate
public class CsvSarbBillingView implements Serializable {

    @EmbeddedId
    protected CsvSarbBillingViewPK csvSarbBillingViewPK;

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "CARD_TYPE")
    private long cardType;
    @Column(name = "BILLING_RATE")
    private Integer billingRate;    
    @Column(name = "BILLING_PERCENT")
    private Double billingPercent;

    public CsvSarbBillingView() {
    }

    public long getCardType() {
        return cardType;
    }

    public void setCardType(long cardType) {
        this.cardType = cardType;
    }

    public Integer getBillingRate() {
        return billingRate;
    }

    public void setBillingRate(Integer billingRate) {
        this.billingRate = billingRate;
    }

    public Double getBillingPercent() {
        return billingPercent;
    }

    public void setBillingPercent(Double billingPercent) {
        this.billingPercent = billingPercent;
    }

    public CsvSarbBillingViewPK getCsvSarbBillingViewPK() {
        return csvSarbBillingViewPK;
    }

    public void setCsvSarbBillingViewPK(CsvSarbBillingViewPK csvSarbBillingViewPK) {
        this.csvSarbBillingViewPK = csvSarbBillingViewPK;
    }
    
    

}
