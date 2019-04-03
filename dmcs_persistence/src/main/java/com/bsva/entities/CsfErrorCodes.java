/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSF_ERROR_CODES")
@NamedQueries({
    @NamedQuery(name = "CsfErrorCodes.findAll", query = "SELECT c FROM CsfErrorCodes c"),
    @NamedQuery(name = "CsfErrorCodes.findByErrorCode", query = "SELECT c FROM CsfErrorCodes c WHERE c.errorCode = :errorCode"),
    @NamedQuery(name = "CsfErrorCodes.findByErrorMessage", query = "SELECT c FROM CsfErrorCodes c WHERE c.errorMessage = :errorMessage"),
    @NamedQuery(name = "CsfErrorCodes.findByErrorRejectLevel", query = "SELECT c FROM CsfErrorCodes c WHERE c.errorRejectLevel = :errorRejectLevel")})
@DynamicUpdate
public class CsfErrorCodes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ERROR_CODE")
    private Integer errorCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ERROR_MESSAGE")
    private String errorMessage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ERROR_REJECT_LEVEL")
    private String errorRejectLevel;

    public CsfErrorCodes() {
    }

    public CsfErrorCodes(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public CsfErrorCodes(Integer errorCode, String errorMessage, String errorRejectLevel) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorRejectLevel = errorRejectLevel;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorRejectLevel() {
        return errorRejectLevel;
    }

    public void setErrorRejectLevel(String errorRejectLevel) {
        this.errorRejectLevel = errorRejectLevel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (errorCode != null ? errorCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfErrorCodes)) {
            return false;
        }
        CsfErrorCodes other = (CsfErrorCodes) object;
        if ((this.errorCode == null && other.errorCode != null) || (this.errorCode != null && !this.errorCode.equals(other.errorCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfErrorCodes[ errorCode=" + errorCode + " ]";
    }
    
}
