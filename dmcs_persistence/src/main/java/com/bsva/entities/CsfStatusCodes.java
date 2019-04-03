/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSF_STATUS_CODES")
@NamedQueries({
    @NamedQuery(name = "CsfStatusCodes.findAll", query = "SELECT c FROM CsfStatusCodes c"),
    @NamedQuery(name = "CsfStatusCodes.findByStatusCode", query = "SELECT c FROM CsfStatusCodes c WHERE c.statusCode = :statusCode"),
    @NamedQuery(name = "CsfStatusCodes.findByStatusDescription", query = "SELECT c FROM CsfStatusCodes c WHERE c.statusDescription = :statusDescription"),
    @NamedQuery(name = "CsfStatusCodes.findByCreatedBy", query = "SELECT c FROM CsfStatusCodes c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CsfStatusCodes.findByCreatedDate", query = "SELECT c FROM CsfStatusCodes c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "CsfStatusCodes.findByModifiedBy", query = "SELECT c FROM CsfStatusCodes c WHERE c.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "CsfStatusCodes.findByModifiedDate", query = "SELECT c FROM CsfStatusCodes c WHERE c.modifiedDate = :modifiedDate")})
@DynamicUpdate
public class CsfStatusCodes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STATUS_CODE")
    private String statusCode;
    @Size(max = 30)
    @Column(name = "STATUS_DESCRIPTION")
    private String statusDescription;
    @Size(max = 30)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 30)
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public CsfStatusCodes() {
    }

    public CsfStatusCodes(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusCode != null ? statusCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfStatusCodes)) {
            return false;
        }
        CsfStatusCodes other = (CsfStatusCodes) object;
        if ((this.statusCode == null && other.statusCode != null) || (this.statusCode != null && !this.statusCode.equals(other.statusCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfStatusCodes[ statusCode=" + statusCode + " ]";
    }
    
}
