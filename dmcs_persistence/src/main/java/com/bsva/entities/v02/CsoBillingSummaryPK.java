package com.bsva.entities.v02;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AugustineA
 */
@Embeddable
public class CsoBillingSummaryPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "PROCESS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date processDate;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISSUING_MEMBER")
    private short issuingMember;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CARD_TYPE")
    private String cardType;

    public CsoBillingSummaryPK() {
    }

    public CsoBillingSummaryPK(Date processDate, String service, String subService, short issuingMember, String cardType) {
        this.processDate = processDate;
        this.service = service;
        this.subService = subService;
        this.issuingMember = issuingMember;
        this.cardType = cardType;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
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

    public short getIssuingMember() {
        return issuingMember;
    }

    public void setIssuingMember(short issuingMember) {
        this.issuingMember = issuingMember;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (processDate != null ? processDate.hashCode() : 0);
        hash += (service != null ? service.hashCode() : 0);
        hash += (subService != null ? subService.hashCode() : 0);
        hash += (int) issuingMember;
        hash += (cardType != null ? cardType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoBillingSummaryPK)) {
            return false;
        }
        CsoBillingSummaryPK other = (CsoBillingSummaryPK) object;
        if ((this.processDate == null && other.processDate != null) || (this.processDate != null && !this.processDate.equals(other.processDate))) {
            return false;
        }
        if ((this.service == null && other.service != null) || (this.service != null && !this.service.equals(other.service))) {
            return false;
        }
        if ((this.subService == null && other.subService != null) || (this.subService != null && !this.subService.equals(other.subService))) {
            return false;
        }
        if (this.issuingMember != other.issuingMember) {
            return false;
        }
        if ((this.cardType == null && other.cardType != null) || (this.cardType != null && !this.cardType.equals(other.cardType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.entities.CsoBillingSummaryPK[ processDate=" + processDate + ", service=" + service + ", subService=" + subService + ", issuingMember=" + issuingMember + ", cardType=" + cardType + " ]";
    }
    
}
