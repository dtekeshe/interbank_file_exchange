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
@Table(name = "CSF_DIRECTORIES")
@NamedQueries({
    @NamedQuery(name = "CsfDirectories.findAll", query = "SELECT c FROM CsfDirectories c"),
    @NamedQuery(name = "CsfDirectories.findByDirectoryName", query = "SELECT c FROM CsfDirectories c WHERE c.directoryName = :directoryName"),
    @NamedQuery(name = "CsfDirectories.findByDirectoryPath", query = "SELECT c FROM CsfDirectories c WHERE c.directoryPath = :directoryPath")})
@DynamicUpdate
public class CsfDirectories implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DIRECTORY_NAME")
    private String directoryName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DIRECTORY_PATH")
    private String directoryPath;

    public CsfDirectories() {
    }

    public CsfDirectories(String directoryName) {
        this.directoryName = directoryName;
    }

    public CsfDirectories(String directoryName, String directoryPath) {
        this.directoryName = directoryName;
        this.directoryPath = directoryPath;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (directoryName != null ? directoryName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfDirectories)) {
            return false;
        }
        CsfDirectories other = (CsfDirectories) object;
        if ((this.directoryName == null && other.directoryName != null) || (this.directoryName != null && !this.directoryName.equals(other.directoryName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfDirectories[ directoryName=" + directoryName + " ]";
    }
    
}
