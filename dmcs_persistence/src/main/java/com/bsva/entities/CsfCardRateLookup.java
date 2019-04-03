package com.bsva.entities;

import java.io.Serializable;
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
@Table(name = "csf_card_rate_lookup", catalog = "cccowner", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsfCardRateLookup.findAll", query = "SELECT c FROM CsfCardRateLookup c"),
    @NamedQuery(name = "CsfCardRateLookup.findByService", query = "SELECT c FROM CsfCardRateLookup c WHERE c.csfCardRateLookupPK.service = :service"),
    @NamedQuery(name = "CsfCardRateLookup.findBySubService", query = "SELECT c FROM CsfCardRateLookup c WHERE c.csfCardRateLookupPK.subService = :subService"),
    @NamedQuery(name = "CsfCardRateLookup.findByPosEntryMode", query = "SELECT c FROM CsfCardRateLookup c WHERE c.csfCardRateLookupPK.posEntryMode = :posEntryMode"),
    @NamedQuery(name = "CsfCardRateLookup.findByChipCard", query = "SELECT c FROM CsfCardRateLookup c WHERE c.csfCardRateLookupPK.chipCard = :chipCard"),
    @NamedQuery(name = "CsfCardRateLookup.findByTerminalCapability", query = "SELECT c FROM CsfCardRateLookup c WHERE c.csfCardRateLookupPK.terminalCapability = :terminalCapability"),
    @NamedQuery(name = "CsfCardRateLookup.findByCardPresent", query = "SELECT c FROM CsfCardRateLookup c WHERE c.csfCardRateLookupPK.cardPresent = :cardPresent"),
    @NamedQuery(name = "CsfCardRateLookup.findByECommInd", query = "SELECT c FROM CsfCardRateLookup c WHERE c.csfCardRateLookupPK.eCommInd = :eCommInd"),
    @NamedQuery(name = "CsfCardRateLookup.findByRateDescriptor", query = "SELECT c FROM CsfCardRateLookup c WHERE c.rateDescriptor = :rateDescriptor")})
@DynamicUpdate
public class CsfCardRateLookup implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsfCardRateLookupPK csfCardRateLookupPK;
    @Column(name = "RATE_DESCRIPTOR")
    private String rateDescriptor;

    public CsfCardRateLookup() {
    }

    public CsfCardRateLookup(CsfCardRateLookupPK csfCardRateLookupPK) {
        this.csfCardRateLookupPK = csfCardRateLookupPK;
    }

    public CsfCardRateLookup(String service, String subService, String posEntryMode, String chipCard, String terminalCapability, String cardPresent, String eCommInd) {
        this.csfCardRateLookupPK = new CsfCardRateLookupPK(service, subService, posEntryMode, chipCard, terminalCapability, cardPresent, eCommInd);
    }

    public CsfCardRateLookupPK getCsfCardRateLookupPK() {
        return csfCardRateLookupPK;
    }

    public void setCsfCardRateLookupPK(CsfCardRateLookupPK csfCardRateLookupPK) {
        this.csfCardRateLookupPK = csfCardRateLookupPK;
    }

    public String getRateDescriptor() {
        return rateDescriptor;
    }

    public void setRateDescriptor(String rateDescriptor) {
        this.rateDescriptor = rateDescriptor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csfCardRateLookupPK != null ? csfCardRateLookupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfCardRateLookup)) {
            return false;
        }
        CsfCardRateLookup other = (CsfCardRateLookup) object;
        if ((this.csfCardRateLookupPK == null && other.csfCardRateLookupPK != null) || (this.csfCardRateLookupPK != null && !this.csfCardRateLookupPK.equals(other.csfCardRateLookupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.dmcs.dmcs_entities.CsfCardRateLookup[ csfCardRateLookupPK=" + csfCardRateLookupPK + " ]";
    }
    
}
