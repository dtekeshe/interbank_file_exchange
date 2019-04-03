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
@Table(name = "CSO_OUTPUT_CONTROLS")
@NamedQueries({
    @NamedQuery(name = "CsoOutputControls.findAll", query = "SELECT c FROM CsoOutputControls c"),
    @NamedQuery(name = "CsoOutputControls.findByBankCode", query = "SELECT c FROM CsoOutputControls c WHERE c.bankCode = :bankCode"),
    @NamedQuery(name = "CsoOutputControls.findByService", query = "SELECT c FROM CsoOutputControls c WHERE c.service = :service"),
    @NamedQuery(name = "CsoOutputControls.findBySubService", query = "SELECT c FROM CsoOutputControls c WHERE c.subService = :subService"),
    @NamedQuery(name = "CsoOutputControls.findByFilenamePrefix", query = "SELECT c FROM CsoOutputControls c WHERE c.filenamePrefix = :filenamePrefix"),
    @NamedQuery(name = "CsoOutputControls.findByDistributionCode", query = "SELECT c FROM CsoOutputControls c WHERE c.distributionCode = :distributionCode"),
    @NamedQuery(name = "CsoOutputControls.findBySeqNumber", query = "SELECT c FROM CsoOutputControls c WHERE c.seqNumber = :seqNumber"),
    @NamedQuery(name = "CsoOutputControls.findByStatusCode", query = "SELECT c FROM CsoOutputControls c WHERE c.statusCode = :statusCode"),
    @NamedQuery(name = "CsoOutputControls.findByFilenameDescription", query = "SELECT c FROM CsoOutputControls c WHERE c.filenameDescription = :filenameDescription"),
    @NamedQuery(name = "CsoOutputControls.findByTransmissionDate", query = "SELECT c FROM CsoOutputControls c WHERE c.transmissionDate = :transmissionDate"),
    @NamedQuery(name = "CsoOutputControls.findByLastFileIndicator", query = "SELECT c FROM CsoOutputControls c WHERE c.lastFileIndicator = :lastFileIndicator"),
    @NamedQuery(name = "CsoOutputControls.findByCrVolume", query = "SELECT c FROM CsoOutputControls c WHERE c.crVolume = :crVolume"),
    @NamedQuery(name = "CsoOutputControls.findByCrValue", query = "SELECT c FROM CsoOutputControls c WHERE c.crValue = :crValue"),
    @NamedQuery(name = "CsoOutputControls.findByDrVolume", query = "SELECT c FROM CsoOutputControls c WHERE c.drVolume = :drVolume"),
    @NamedQuery(name = "CsoOutputControls.findByDrValue", query = "SELECT c FROM CsoOutputControls c WHERE c.drValue = :drValue"),
    @NamedQuery(name = "CsoOutputControls.findByRecordCount", query = "SELECT c FROM CsoOutputControls c WHERE c.recordCount = :recordCount"),
    @NamedQuery(name = "CsoOutputControls.findByHashTotal98", query = "SELECT c FROM CsoOutputControls c WHERE c.hashTotal98 = :hashTotal98"),
    @NamedQuery(name = "CsoOutputControls.findByHashTotal99", query = "SELECT c FROM CsoOutputControls c WHERE c.hashTotal99 = :hashTotal99"),
    @NamedQuery(name = "CsoOutputControls.findByOriginatingBankId", query = "SELECT c FROM CsoOutputControls c WHERE c.originatingBankId = :originatingBankId"),
    @NamedQuery(name = "CsoOutputControls.findByOriginatingMember", query = "SELECT c FROM CsoOutputControls c WHERE c.originatingMember = :originatingMember"),
    @NamedQuery(name = "CsoOutputControls.findByNegCardCount", query = "SELECT c FROM CsoOutputControls c WHERE c.negCardCount = :negCardCount"),
    @NamedQuery(name = "CsoOutputControls.findByStartTime", query = "SELECT c FROM CsoOutputControls c WHERE c.startTime = :startTime"),
    @NamedQuery(name = "CsoOutputControls.findByEndTime", query = "SELECT c FROM CsoOutputControls c WHERE c.endTime = :endTime"),
    @NamedQuery(name = "CsoOutputControls.findByFullfileind", query = "SELECT c FROM CsoOutputControls c WHERE c.fullfileind = :fullfileind")})
@DynamicUpdate
public class CsoOutputControls implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BANK_CODE")
    private String bankCode;
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
    @Size(min = 1, max = 2)
    @Column(name = "FILENAME_PREFIX")
    private String filenamePrefix;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "DISTRIBUTION_CODE")
    private String distributionCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "SEQ_NUMBER")
    private String seqNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STATUS_CODE")
    private String statusCode;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FILENAME_DESCRIPTION")
    private String filenameDescription;
    @Column(name = "TRANSMISSION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transmissionDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "LAST_FILE_INDICATOR")
    private String lastFileIndicator;
    @Column(name = "CR_VOLUME")
    private Long crVolume;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CR_VALUE")
    private BigDecimal crValue;
    @Column(name = "DR_VOLUME")
    private Long drVolume;
    @Column(name = "DR_VALUE")
    private BigDecimal drValue;
    @Column(name = "RECORD_COUNT")
    private Integer recordCount;
    @Column(name = "HASH_TOTAL_98")
    private Long hashTotal98;
    @Column(name = "HASH_TOTAL_99")
    private Long hashTotal99;
    @Size(max = 2)
    @Column(name = "ORIGINATING_BANK_ID")
    private String originatingBankId;
    @Column(name = "ORIGINATING_MEMBER")
    private String originatingMember;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NEG_CARD_COUNT")
    private long negCardCount;
    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "END_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Size(max = 1)
    @Column(name = "FULLFILEIND")
    private String fullfileind;
    @Column(name = "RECORD_COUNT_FOR_DAY")
    private Long recordCountForDay;
    @Column(name = "DR_VALUE_FOR_DAY")
    private Double drValueForDay;

    public CsoOutputControls() {
    }

    public CsoOutputControls(String filenameDescription) {
        this.filenameDescription = filenameDescription;
    }

    public CsoOutputControls(String filenameDescription, String bankCode, String service, String subService, String filenamePrefix, String distributionCode, String seqNumber, String statusCode, String lastFileIndicator, long negCardCount) {
        this.filenameDescription = filenameDescription;
        this.bankCode = bankCode;
        this.service = service;
        this.subService = subService;
        this.filenamePrefix = filenamePrefix;
        this.distributionCode = distributionCode;
        this.seqNumber = seqNumber;
        this.statusCode = statusCode;
        this.lastFileIndicator = lastFileIndicator;
        this.negCardCount = negCardCount;
    }

    public Long getRecordCountForDay() {
		return recordCountForDay;
	}

	public Double getDrValueForDay() {
		return drValueForDay;
	}

	public void setRecordCountForDay(Long recordCountForDay) {
		this.recordCountForDay = recordCountForDay;
	}

	public void setDrValueForDay(Double drValueForDay) {
		this.drValueForDay = drValueForDay;
	}

	public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
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

    public String getFilenamePrefix() {
        return filenamePrefix;
    }

    public void setFilenamePrefix(String filenamePrefix) {
        this.filenamePrefix = filenamePrefix;
    }

    public String getDistributionCode() {
        return distributionCode;
    }

    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }

    public String getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(String seqNumber) {
        this.seqNumber = seqNumber;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getFilenameDescription() {
        return filenameDescription;
    }

    public void setFilenameDescription(String filenameDescription) {
        this.filenameDescription = filenameDescription;
    }

    public Date getTransmissionDate() {
        return transmissionDate;
    }

    public void setTransmissionDate(Date transmissionDate) {
        this.transmissionDate = transmissionDate;
    }

    public String getLastFileIndicator() {
        return lastFileIndicator;
    }

    public void setLastFileIndicator(String lastFileIndicator) {
        this.lastFileIndicator = lastFileIndicator;
    }

    public Long getCrVolume() {
        return crVolume;
    }

    public void setCrVolume(Long crVolume) {
        this.crVolume = crVolume;
    }

    public BigDecimal getCrValue() {
        return crValue;
    }

    public void setCrValue(BigDecimal crValue) {
        this.crValue = crValue;
    }

    public Long getDrVolume() {
        return drVolume;
    }

    public void setDrVolume(Long drVolume) {
        this.drVolume = drVolume;
    }

    public BigDecimal getDrValue() {
        return drValue;
    }

    public void setDrValue(BigDecimal drValue) {
        this.drValue = drValue;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public Long getHashTotal98() {
        return hashTotal98;
    }

    public void setHashTotal98(Long hashTotal98) {
        this.hashTotal98 = hashTotal98;
    }

    public Long getHashTotal99() {
        return hashTotal99;
    }

    public void setHashTotal99(Long hashTotal99) {
        this.hashTotal99 = hashTotal99;
    }

    public String getOriginatingBankId() {
        return originatingBankId;
    }

    public void setOriginatingBankId(String originatingBankId) {
        this.originatingBankId = originatingBankId;
    }

    public String getOriginatingMember() {
        return originatingMember;
    }

    public void setOriginatingMember(String originatingMember) {
        this.originatingMember = originatingMember;
    }

    public long getNegCardCount() {
        return negCardCount;
    }

    public void setNegCardCount(long negCardCount) {
        this.negCardCount = negCardCount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getFullfileind() {
        return fullfileind;
    }

    public void setFullfileind(String fullfileind) {
        this.fullfileind = fullfileind;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filenameDescription != null ? filenameDescription.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoOutputControls)) {
            return false;
        }
        CsoOutputControls other = (CsoOutputControls) object;
        if ((this.filenameDescription == null && other.filenameDescription != null) || (this.filenameDescription != null && !this.filenameDescription.equals(other.filenameDescription))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoOutputControls[ filenameDescription=" + filenameDescription + " ]";
    }
    
}
