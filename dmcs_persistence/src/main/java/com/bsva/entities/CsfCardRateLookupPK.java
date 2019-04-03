package com.bsva.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author SimphiweT
 */
@Embeddable
public class CsfCardRateLookupPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "SERVICE")
    private String service;
    @Basic(optional = false)
    @Column(name = "SUB_SERVICE")
    private String subService;
    @Basic(optional = false)
    @Column(name = "POS_ENTRY_MODE")
    private String posEntryMode;
    @Basic(optional = false)
    @Column(name = "CHIP_CARD")
    private String chipCard;
    @Basic(optional = false)
    @Column(name = "TERMINAL_CAPABILITY")
    private String terminalCapability;
    @Basic(optional = false)
    @Column(name = "CARD_PRESENT")
    private String cardPresent;
    @Basic(optional = false)
    @Column(name = "E_COMM_IND")
    private String eCommInd;

    public CsfCardRateLookupPK() {
    }

    public CsfCardRateLookupPK(String service, String subService, String posEntryMode, String chipCard, String terminalCapability, String cardPresent, String eCommInd) {
        this.service = service;
        this.subService = subService;
        this.posEntryMode = posEntryMode;
        this.chipCard = chipCard;
        this.terminalCapability = terminalCapability;
        this.cardPresent = cardPresent;
        this.eCommInd = eCommInd;
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

    public String getPosEntryMode() {
        return posEntryMode;
    }

    public void setPosEntryMode(String posEntryMode) {
        this.posEntryMode = posEntryMode;
    }

    public String getChipCard() {
        return chipCard;
    }

    public void setChipCard(String chipCard) {
        this.chipCard = chipCard;
    }

    public String getTerminalCapability() {
        return terminalCapability;
    }

    public void setTerminalCapability(String terminalCapability) {
        this.terminalCapability = terminalCapability;
    }

    public String getCardPresent() {
        return cardPresent;
    }

    public void setCardPresent(String cardPresent) {
        this.cardPresent = cardPresent;
    }

    public String getECommInd() {
        return eCommInd;
    }

    public void setECommInd(String eCommInd) {
        this.eCommInd = eCommInd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (service != null ? service.hashCode() : 0);
        hash += (subService != null ? subService.hashCode() : 0);
        hash += (posEntryMode != null ? posEntryMode.hashCode() : 0);
        hash += (chipCard != null ? chipCard.hashCode() : 0);
        hash += (terminalCapability != null ? terminalCapability.hashCode() : 0);
        hash += (cardPresent != null ? cardPresent.hashCode() : 0);
        hash += (eCommInd != null ? eCommInd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfCardRateLookupPK)) {
            return false;
        }
        CsfCardRateLookupPK other = (CsfCardRateLookupPK) object;
        if ((this.service == null && other.service != null) || (this.service != null && !this.service.equals(other.service))) {
            return false;
        }
        if ((this.subService == null && other.subService != null) || (this.subService != null && !this.subService.equals(other.subService))) {
            return false;
        }
        if ((this.posEntryMode == null && other.posEntryMode != null) || (this.posEntryMode != null && !this.posEntryMode.equals(other.posEntryMode))) {
            return false;
        }
        if ((this.chipCard == null && other.chipCard != null) || (this.chipCard != null && !this.chipCard.equals(other.chipCard))) {
            return false;
        }
        if ((this.terminalCapability == null && other.terminalCapability != null) || (this.terminalCapability != null && !this.terminalCapability.equals(other.terminalCapability))) {
            return false;
        }
        if ((this.cardPresent == null && other.cardPresent != null) || (this.cardPresent != null && !this.cardPresent.equals(other.cardPresent))) {
            return false;
        }
        if ((this.eCommInd == null && other.eCommInd != null) || (this.eCommInd != null && !this.eCommInd.equals(other.eCommInd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.dmcs.dmcs_entities.CsfCardRateLookupPK[ service=" + service + ", subService=" + subService + ", posEntryMode=" + posEntryMode + ", chipCard=" + chipCard + ", terminalCapability=" + terminalCapability + ", cardPresent=" + cardPresent + ", eCommInd=" + eCommInd + " ]";
    }
    
}
