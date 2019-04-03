/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CSF_DELIVERY_SERVICES")
@NamedQueries({
    @NamedQuery(name = "CsfDeliveryServices.findAll", query = "SELECT c FROM CsfDeliveryServices c"),
    @NamedQuery(name = "CsfDeliveryServices.findByFilenamePrefix", query = "SELECT c FROM CsfDeliveryServices c WHERE c.filenamePrefix = :filenamePrefix"),
    @NamedQuery(name = "CsfDeliveryServices.findByMediaType", query = "SELECT c FROM CsfDeliveryServices c WHERE c.mediaType = :mediaType"),
    @NamedQuery(name = "CsfDeliveryServices.findByInwardOutwardInd", query = "SELECT c FROM CsfDeliveryServices c WHERE c.inwardOutwardInd = :inwardOutwardInd"),
    @NamedQuery(name = "CsfDeliveryServices.findByDescription", query = "SELECT c FROM CsfDeliveryServices c WHERE c.description = :description"),
    @NamedQuery(name = "CsfDeliveryServices.findBySubService", query = "SELECT c FROM CsfDeliveryServices c WHERE c.subService = :subService"),
    @NamedQuery(name = "CsfDeliveryServices.findByFormat", query = "SELECT c FROM CsfDeliveryServices c WHERE c.format = :format"),
    @NamedQuery(name = "CsfDeliveryServices.findByDestinationCode", query = "SELECT c FROM CsfDeliveryServices c WHERE c.destinationCode = :destinationCode"),
    @NamedQuery(name = "CsfDeliveryServices.findByBackupFormat", query = "SELECT c FROM CsfDeliveryServices c WHERE c.backupFormat = :backupFormat"),
    @NamedQuery(name = "CsfDeliveryServices.findByActiveIndicator", query = "SELECT c FROM CsfDeliveryServices c WHERE c.activeIndicator = :activeIndicator"),
    @NamedQuery(name = "CsfDeliveryServices.findByCreatedBy", query = "SELECT c FROM CsfDeliveryServices c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CsfDeliveryServices.findByCreatedDate", query = "SELECT c FROM CsfDeliveryServices c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "CsfDeliveryServices.findByModifiedBy", query = "SELECT c FROM CsfDeliveryServices c WHERE c.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "CsfDeliveryServices.findByModifiedDate", query = "SELECT c FROM CsfDeliveryServices c WHERE c.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "CsfDeliveryServices.findByHeaderReference", query = "SELECT c FROM CsfDeliveryServices c WHERE c.headerReference = :headerReference"),
    @NamedQuery(name = "CsfDeliveryServices.findByFileFormat", query = "SELECT c FROM CsfDeliveryServices c WHERE c.fileFormat = :fileFormat"),
    @NamedQuery(name = "CsfDeliveryServices.findById", query = "SELECT c FROM CsfDeliveryServices c WHERE c.id = :id")})
@DynamicUpdate
public class CsfDeliveryServices implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "FILENAME_PREFIX")
    private String filenamePrefix;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "MEDIA_TYPE")
    private String mediaType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "INWARD_OUTWARD_IND")
    private String inwardOutwardInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SUB_SERVICE")
    private String subService;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "FORMAT")
    private String format;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESTINATION_CODE")
    private short destinationCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "BACKUP_FORMAT")
    private String backupFormat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ACTIVE_INDICATOR")
    private String activeIndicator;
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
    @Size(max = 4)
    @Column(name = "HEADER_REFERENCE")
    private String headerReference;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "FILE_FORMAT")
    private String fileFormat;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "SERVICE", referencedColumnName = "SERVICE_CODE")
    private CsfSystemService service;

    public CsfSystemService getService() {
		return service;
	}

	public void setService(CsfSystemService service) {
		this.service = service;
	}

	public CsfDeliveryServices() {
    }

    public CsfDeliveryServices(BigDecimal id) {
        this.id = id;
    }

    public CsfDeliveryServices(BigDecimal id, String filenamePrefix, String mediaType, String inwardOutwardInd, String description, String subService, String format, short destinationCode, String backupFormat, String activeIndicator, String fileFormat) {
        this.id = id;
        this.filenamePrefix = filenamePrefix;
        this.mediaType = mediaType;
        this.inwardOutwardInd = inwardOutwardInd;
        this.description = description;
        this.subService = subService;
        this.format = format;
        this.destinationCode = destinationCode;
        this.backupFormat = backupFormat;
        this.activeIndicator = activeIndicator;
        this.fileFormat = fileFormat;
    }

    public String getFilenamePrefix() {
        return filenamePrefix;
    }

    public void setFilenamePrefix(String filenamePrefix) {
        this.filenamePrefix = filenamePrefix;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getInwardOutwardInd() {
        return inwardOutwardInd;
    }

    public void setInwardOutwardInd(String inwardOutwardInd) {
        this.inwardOutwardInd = inwardOutwardInd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubService() {
        return subService;
    }

    public void setSubService(String subService) {
        this.subService = subService;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public short getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(short destinationCode) {
        this.destinationCode = destinationCode;
    }

    public String getBackupFormat() {
        return backupFormat;
    }

    public void setBackupFormat(String backupFormat) {
        this.backupFormat = backupFormat;
    }

    public String getActiveIndicator() {
        return activeIndicator;
    }

    public void setActiveIndicator(String activeIndicator) {
        this.activeIndicator = activeIndicator;
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

    public String getHeaderReference() {
        return headerReference;
    }

    public void setHeaderReference(String headerReference) {
        this.headerReference = headerReference;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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
        if (!(object instanceof CsfDeliveryServices)) {
            return false;
        }
        CsfDeliveryServices other = (CsfDeliveryServices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfDeliveryServices[ id=" + id + " ]";
    }
    
}
