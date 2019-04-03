package com.bsva.entities.v02;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSO_BILLING_SUMMARY")
@DynamicUpdate
public class CsoBillingSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsoBillingSummaryPK csoBillingSummaryPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VOLUME")
    private int volume;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALUE")
    private BigDecimal value;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VOLUME_ABOVE")
    private int volumeAbove;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALUE_ABOVE")
    private BigDecimal valueAbove;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VOLUME_BELOW")
    private int volumeBelow;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALUE_BELOW")
    private BigDecimal valueBelow;
/*    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ISSUING_MEMBER")
    private String issuingMember;
*/
    public CsoBillingSummary() {
    }

    public CsoBillingSummary(CsoBillingSummaryPK csoBillingSummaryPK) {
        this.csoBillingSummaryPK = csoBillingSummaryPK;
    }

    public CsoBillingSummary(CsoBillingSummaryPK csoBillingSummaryPK, int volume, BigDecimal value, int volumeAbove, BigDecimal valueAbove, int volumeBelow, BigDecimal valueBelow) {
        this.csoBillingSummaryPK = csoBillingSummaryPK;
        this.volume = volume;
        this.value = value;
        this.volumeAbove = volumeAbove;
        this.valueAbove = valueAbove;
        this.volumeBelow = volumeBelow;
        this.valueBelow = valueBelow;
      
    }

    public CsoBillingSummary(Date processDate, String service, String subService, short issuingMember, String cardType) {
        this.csoBillingSummaryPK = new CsoBillingSummaryPK(processDate, service, subService, issuingMember, cardType);
    }

    public CsoBillingSummaryPK getCsoBillingSummaryPK() {
        return csoBillingSummaryPK;
    }

    public void setCsoBillingSummaryPK(CsoBillingSummaryPK csoBillingSummaryPK) {
        this.csoBillingSummaryPK = csoBillingSummaryPK;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getVolumeAbove() {
        return volumeAbove;
    }

    public void setVolumeAbove(int volumeAbove) {
        this.volumeAbove = volumeAbove;
    }

    public BigDecimal getValueAbove() {
        return valueAbove;
    }

    public void setValueAbove(BigDecimal valueAbove) {
        this.valueAbove = valueAbove;
    }

    public int getVolumeBelow() {
        return volumeBelow;
    }

    public void setVolumeBelow(int volumeBelow) {
        this.volumeBelow = volumeBelow;
    }

    public BigDecimal getValueBelow() {
        return valueBelow;
    }

    public void setValueBelow(BigDecimal valueBelow) {
        this.valueBelow = valueBelow;
    }

  /*  public String getIssuingMember() {
        return issuingMember;
    }

    public void setIssuingMember(String issuingMember) {
        this.issuingMember = issuingMember;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csoBillingSummaryPK != null ? csoBillingSummaryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoBillingSummary)) {
            return false;
        }
        CsoBillingSummary other = (CsoBillingSummary) object;
        if ((this.csoBillingSummaryPK == null && other.csoBillingSummaryPK != null) || (this.csoBillingSummaryPK != null && !this.csoBillingSummaryPK.equals(other.csoBillingSummaryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.entities.CsoBillingSummary[ csoBillingSummaryPK=" + csoBillingSummaryPK + " ]";
    }
    
}
