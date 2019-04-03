package com.bsva.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GeneratorType;

/**
 *
 * @author SimphiweT
 */
@Entity
@Table(name = "Cso_Billing_Summary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsoBillingSummary.findAll", query = "SELECT c FROM CsoBillingSummary c"),
    @NamedQuery(name = "CsoBillingSummary.findById", query = "SELECT c FROM CsoBillingSummary c WHERE c.id = :id"),
    @NamedQuery(name = "CsoBillingSummary.findByProcessDate", query = "SELECT c FROM CsoBillingSummary c WHERE c.processDate = :processDate"),
    @NamedQuery(name = "CsoBillingSummary.findByService", query = "SELECT c FROM CsoBillingSummary c WHERE c.service = :service"),
    @NamedQuery(name = "CsoBillingSummary.findBySubService", query = "SELECT c FROM CsoBillingSummary c WHERE c.subService = :subService"),
    @NamedQuery(name = "CsoBillingSummary.findByVolume", query = "SELECT c FROM CsoBillingSummary c WHERE c.volume = :volume"),
    @NamedQuery(name = "CsoBillingSummary.findByValue", query = "SELECT c FROM CsoBillingSummary c WHERE c.value = :value"),
    @NamedQuery(name = "CsoBillingSummary.findByIssuingMember", query = "SELECT c FROM CsoBillingSummary c WHERE c.issuingMember = :issuingMember"),
    @NamedQuery(name = "CsoBillingSummary.findByVolumeAbove", query = "SELECT c FROM CsoBillingSummary c WHERE c.volumeAbove = :volumeAbove"),
    @NamedQuery(name = "CsoBillingSummary.findByValueAbove", query = "SELECT c FROM CsoBillingSummary c WHERE c.valueAbove = :valueAbove"),
    @NamedQuery(name = "CsoBillingSummary.findByVolumeBelow", query = "SELECT c FROM CsoBillingSummary c WHERE c.volumeBelow = :volumeBelow"),
    @NamedQuery(name = "CsoBillingSummary.findByValueBelow", query = "SELECT c FROM CsoBillingSummary c WHERE c.valueBelow = :valueBelow")})
@DynamicUpdate
public class CsoBillingSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")    
    private Integer id;
    @Basic(optional = false)
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
    @Column(name = "VOLUME")
    private int volume;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALUE")
    private BigDecimal value;
    @Column(name = "ISSUING_MEMBER" , insertable = false, updatable = false)
    private short issuingMember;
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

    public CsoBillingSummary() {
    }

    public CsoBillingSummary(Integer id) {
        this.id = id;
    }

    public CsoBillingSummary(Integer id, Date processDate, String service, String subService, int volume, BigDecimal value, short issuingMember, int volumeAbove, BigDecimal valueAbove, int volumeBelow, BigDecimal valueBelow) {
        this.id = id;
        this.processDate = processDate;
        this.service = service;
        this.subService = subService;
        this.volume = volume;
        this.value = value;
        this.issuingMember = issuingMember;
        this.volumeAbove = volumeAbove;
        this.valueAbove = valueAbove;
        this.volumeBelow = volumeBelow;
        this.valueBelow = valueBelow;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public short getIssuingMember() {
        return issuingMember;
    }

    public void setIssuingMember(short issuingMember) {
        this.issuingMember = issuingMember;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoBillingSummary)) {
            return false;
        }
        CsoBillingSummary other = (CsoBillingSummary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.entities.CsoBillingSummary[ id=" + id + " ]";
    }
    
}
