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
@Table(name = "CSF_REPORT_NAMES")
@NamedQueries({
    @NamedQuery(name = "CsfReportNames.findAll", query = "SELECT c FROM CsfReportNames c"),
    @NamedQuery(name = "CsfReportNames.findByReportName", query = "SELECT c FROM CsfReportNames c WHERE c.reportName = :reportName"),
    @NamedQuery(name = "CsfReportNames.findByReportTitle", query = "SELECT c FROM CsfReportNames c WHERE c.reportTitle = :reportTitle"),
    @NamedQuery(name = "CsfReportNames.findByProgramName", query = "SELECT c FROM CsfReportNames c WHERE c.programName = :programName"),
    @NamedQuery(name = "CsfReportNames.findByActiveIndicator", query = "SELECT c FROM CsfReportNames c WHERE c.activeIndicator = :activeIndicator"),
    @NamedQuery(name = "CsfReportNames.findByInternalFilename", query = "SELECT c FROM CsfReportNames c WHERE c.internalFilename = :internalFilename"),
    @NamedQuery(name = "CsfReportNames.findByExternalFilenamePrefix", query = "SELECT c FROM CsfReportNames c WHERE c.externalFilenamePrefix = :externalFilenamePrefix"),
    @NamedQuery(name = "CsfReportNames.findByInternalIndicator", query = "SELECT c FROM CsfReportNames c WHERE c.internalIndicator = :internalIndicator"),
    @NamedQuery(name = "CsfReportNames.findByCreatedBy", query = "SELECT c FROM CsfReportNames c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CsfReportNames.findByCreatedDate", query = "SELECT c FROM CsfReportNames c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "CsfReportNames.findByModifiedBy", query = "SELECT c FROM CsfReportNames c WHERE c.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "CsfReportNames.findByModifiedDate", query = "SELECT c FROM CsfReportNames c WHERE c.modifiedDate = :modifiedDate")})
@DynamicUpdate
public class CsfReportNames implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "REPORT_NAME")
    private String reportName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "REPORT_TITLE")
    private String reportTitle;
    @Size(max = 10)
    @Column(name = "PROGRAM_NAME")
    private String programName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ACTIVE_INDICATOR")
    private String activeIndicator;
    @Size(max = 15)
    @Column(name = "INTERNAL_FILENAME")
    private String internalFilename;
    @Size(max = 2)
    @Column(name = "EXTERNAL_FILENAME_PREFIX")
    private String externalFilenamePrefix;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "INTERNAL_INDICATOR")
    private String internalIndicator;
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

    public CsfReportNames() {
    }

    public CsfReportNames(String reportName) {
        this.reportName = reportName;
    }

    public CsfReportNames(String reportName, String reportTitle, String activeIndicator, String internalIndicator) {
        this.reportName = reportName;
        this.reportTitle = reportTitle;
        this.activeIndicator = activeIndicator;
        this.internalIndicator = internalIndicator;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getActiveIndicator() {
        return activeIndicator;
    }

    public void setActiveIndicator(String activeIndicator) {
        this.activeIndicator = activeIndicator;
    }

    public String getInternalFilename() {
        return internalFilename;
    }

    public void setInternalFilename(String internalFilename) {
        this.internalFilename = internalFilename;
    }

    public String getExternalFilenamePrefix() {
        return externalFilenamePrefix;
    }

    public void setExternalFilenamePrefix(String externalFilenamePrefix) {
        this.externalFilenamePrefix = externalFilenamePrefix;
    }

    public String getInternalIndicator() {
        return internalIndicator;
    }

    public void setInternalIndicator(String internalIndicator) {
        this.internalIndicator = internalIndicator;
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
        hash += (reportName != null ? reportName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfReportNames)) {
            return false;
        }
        CsfReportNames other = (CsfReportNames) object;
        if ((this.reportName == null && other.reportName != null) || (this.reportName != null && !this.reportName.equals(other.reportName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfReportNames[ reportName=" + reportName + " ]";
    }
    
}
