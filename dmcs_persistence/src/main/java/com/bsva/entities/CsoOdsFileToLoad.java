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
@Table(name = "CSO_ODS_FILE_TO_LOAD")
@NamedQueries({
    @NamedQuery(name = "CsoOdsFileToLoad.findAll", query = "SELECT c FROM CsoOdsFileToLoad c"),
    @NamedQuery(name = "CsoOdsFileToLoad.findByFilename", query = "SELECT c FROM CsoOdsFileToLoad c WHERE c.filename = :filename"),
    @NamedQuery(name = "CsoOdsFileToLoad.findByFileRefNumber", query = "SELECT c FROM CsoOdsFileToLoad c WHERE c.fileRefNumber = :fileRefNumber"),
    @NamedQuery(name = "CsoOdsFileToLoad.findByFileformat", query = "SELECT c FROM CsoOdsFileToLoad c WHERE c.fileformat = :fileformat"),
    @NamedQuery(name = "CsoOdsFileToLoad.findBySeqNo", query = "SELECT c FROM CsoOdsFileToLoad c WHERE c.seqNo = :seqNo"),
    @NamedQuery(name = "CsoOdsFileToLoad.findByStatus", query = "SELECT c FROM CsoOdsFileToLoad c WHERE c.status = :status")})
@DynamicUpdate
public class CsoOdsFileToLoad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FILENAME")
    private String filename;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FILE_REF_NUMBER")
    private String fileRefNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "FILEFORMAT")
    private String fileformat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_NO")
    private int seqNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STATUS")
    private String status;

    public CsoOdsFileToLoad() {
    }

    public CsoOdsFileToLoad(String fileRefNumber) {
        this.fileRefNumber = fileRefNumber;
    }

    public CsoOdsFileToLoad(String fileRefNumber, String filename, String fileformat, int seqNo, String status) {
        this.fileRefNumber = fileRefNumber;
        this.filename = filename;
        this.fileformat = fileformat;
        this.seqNo = seqNo;
        this.status = status;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileRefNumber() {
        return fileRefNumber;
    }

    public void setFileRefNumber(String fileRefNumber) {
        this.fileRefNumber = fileRefNumber;
    }

    public String getFileformat() {
        return fileformat;
    }

    public void setFileformat(String fileformat) {
        this.fileformat = fileformat;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fileRefNumber != null ? fileRefNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoOdsFileToLoad)) {
            return false;
        }
        CsoOdsFileToLoad other = (CsoOdsFileToLoad) object;
        if ((this.fileRefNumber == null && other.fileRefNumber != null) || (this.fileRefNumber != null && !this.fileRefNumber.equals(other.fileRefNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoOdsFileToLoad[ fileRefNumber=" + fileRefNumber + " ]";
    }
    
}
