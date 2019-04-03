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
@Table(name = "CSF_INPUT_FILE_FIELDS")
@NamedQueries({
    @NamedQuery(name = "CsfInputFileFields.findAll", query = "SELECT c FROM CsfInputFileFields c"),
    @NamedQuery(name = "CsfInputFileFields.findByFieldCode", query = "SELECT c FROM CsfInputFileFields c WHERE c.fieldCode = :fieldCode"),
    @NamedQuery(name = "CsfInputFileFields.findByFieldName", query = "SELECT c FROM CsfInputFileFields c WHERE c.fieldName = :fieldName"),
    @NamedQuery(name = "CsfInputFileFields.findByFieldDataType", query = "SELECT c FROM CsfInputFileFields c WHERE c.fieldDataType = :fieldDataType"),
    @NamedQuery(name = "CsfInputFileFields.findByFieldLength", query = "SELECT c FROM CsfInputFileFields c WHERE c.fieldLength = :fieldLength")})
@DynamicUpdate
public class CsfInputFileFields implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FIELD_CODE")
    private Short fieldCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FIELD_NAME")
    private String fieldName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "FIELD_DATA_TYPE")
    private String fieldDataType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FIELD_LENGTH")
    private short fieldLength;

    public CsfInputFileFields() {
    }

    public CsfInputFileFields(Short fieldCode) {
        this.fieldCode = fieldCode;
    }

    public CsfInputFileFields(Short fieldCode, String fieldName, String fieldDataType, short fieldLength) {
        this.fieldCode = fieldCode;
        this.fieldName = fieldName;
        this.fieldDataType = fieldDataType;
        this.fieldLength = fieldLength;
    }

    public Short getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(Short fieldCode) {
        this.fieldCode = fieldCode;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldDataType() {
        return fieldDataType;
    }

    public void setFieldDataType(String fieldDataType) {
        this.fieldDataType = fieldDataType;
    }

    public short getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(short fieldLength) {
        this.fieldLength = fieldLength;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fieldCode != null ? fieldCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfInputFileFields)) {
            return false;
        }
        CsfInputFileFields other = (CsfInputFileFields) object;
        if ((this.fieldCode == null && other.fieldCode != null) || (this.fieldCode != null && !this.fieldCode.equals(other.fieldCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfInputFileFields[ fieldCode=" + fieldCode + " ]";
    }
    
}
