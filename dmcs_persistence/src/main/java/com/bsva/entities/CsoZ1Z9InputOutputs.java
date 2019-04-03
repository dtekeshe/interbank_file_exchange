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
@Table(name = "CSO_Z1_Z9_INPUT_OUTPUTS")
@NamedQueries({
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findAll", query = "SELECT c FROM CsoZ1Z9InputOutputs c"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByFilenameDescription", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.filenameDescription = :filenameDescription"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByOraSeqNumber", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.oraSeqNumber = :oraSeqNumber"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByService", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.service = :service"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findBySubService", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.subService = :subService"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByInputOutputIndicator", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.inputOutputIndicator = :inputOutputIndicator"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByLastFileIndicator", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.lastFileIndicator = :lastFileIndicator"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByTransmitIndicator", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.transmitIndicator = :transmitIndicator"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByDestination", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.destination = :destination"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByNumberOfRecords", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.numberOfRecords = :numberOfRecords"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByOpsDate", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.opsDate = :opsDate"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByCrValue", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.crValue = :crValue"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByDrValue", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.drValue = :drValue"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByFileRefNumber", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.fileRefNumber = :fileRefNumber"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByBankCode", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.bankCode = :bankCode"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByReportName", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.reportName = :reportName"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByMedia", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.media = :media"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByCentre", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.centre = :centre"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByInternalIndicator", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.internalIndicator = :internalIndicator"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByPrintCode", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.printCode = :printCode"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByRecipientCode", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.recipientCode = :recipientCode"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByDistributedIndicator", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.distributedIndicator = :distributedIndicator"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByNoOfCredits", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.noOfCredits = :noOfCredits"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByNoOfDebits", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.noOfDebits = :noOfDebits"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByHashTotal", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.hashTotal = :hashTotal"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByAxdCreatedIndicator", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.axdCreatedIndicator = :axdCreatedIndicator"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByNegativeCardCount", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.negativeCardCount = :negativeCardCount"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByAcquirer", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.acquirer = :acquirer"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByIssuer", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.issuer = :issuer"),
    @NamedQuery(name = "CsoZ1Z9InputOutputs.findByControlRecordCount", query = "SELECT c FROM CsoZ1Z9InputOutputs c WHERE c.controlRecordCount = :controlRecordCount")})
@DynamicUpdate
public class CsoZ1Z9InputOutputs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FILENAME_DESCRIPTION")
    private String filenameDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORA_SEQ_NUMBER")
    private long oraSeqNumber;
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
    @Size(min = 1, max = 1)
    @Column(name = "INPUT_OUTPUT_INDICATOR")
    private String inputOutputIndicator;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "LAST_FILE_INDICATOR")
    private String lastFileIndicator;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TRANSMIT_INDICATOR")
    private String transmitIndicator;
    @Column(name = "DESTINATION")
    private Integer destination;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMBER_OF_RECORDS")
    private long numberOfRecords;
    @Column(name = "OPS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date opsDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CR_VALUE")
    private BigDecimal crValue;
    @Column(name = "DR_VALUE")
    private BigDecimal drValue;
    @Size(max = 16)
    @Column(name = "FILE_REF_NUMBER")
    private String fileRefNumber;
    @Column(name = "BANK_CODE")
    private Short bankCode;
    @Size(max = 15)
    @Column(name = "REPORT_NAME")
    private String reportName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "MEDIA")
    private String media;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CENTRE")
    private short centre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "INTERNAL_INDICATOR")
    private String internalIndicator;
    @Size(max = 1)
    @Column(name = "PRINT_CODE")
    private String printCode;
    @Size(max = 1)
    @Column(name = "RECIPIENT_CODE")
    private String recipientCode;
    @Size(max = 1)
    @Column(name = "DISTRIBUTED_INDICATOR")
    private String distributedIndicator;
    @Column(name = "NO_OF_CREDITS")
    private Integer noOfCredits;
    @Column(name = "NO_OF_DEBITS")
    private Integer noOfDebits;
    @Column(name = "HASH_TOTAL")
    private Long hashTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "AXD_CREATED_INDICATOR")
    private String axdCreatedIndicator;
    @Column(name = "NEGATIVE_CARD_COUNT")
    private Integer negativeCardCount;
    @Column(name = "ACQUIRER")
    private Short acquirer;
    @Column(name = "ISSUER")
    private Short issuer;
    @Column(name = "CONTROL_RECORD_COUNT")
    private Integer controlRecordCount;

    public CsoZ1Z9InputOutputs() {
    }

    public CsoZ1Z9InputOutputs(String filenameDescription) {
        this.filenameDescription = filenameDescription;
    }

    public CsoZ1Z9InputOutputs(String filenameDescription, long oraSeqNumber, String service, String subService, String inputOutputIndicator, String lastFileIndicator, String transmitIndicator, long numberOfRecords, String media, short centre, String internalIndicator, String axdCreatedIndicator) {
        this.filenameDescription = filenameDescription;
        this.oraSeqNumber = oraSeqNumber;
        this.service = service;
        this.subService = subService;
        this.inputOutputIndicator = inputOutputIndicator;
        this.lastFileIndicator = lastFileIndicator;
        this.transmitIndicator = transmitIndicator;
        this.numberOfRecords = numberOfRecords;
        this.media = media;
        this.centre = centre;
        this.internalIndicator = internalIndicator;
        this.axdCreatedIndicator = axdCreatedIndicator;
    }

    public String getFilenameDescription() {
        return filenameDescription;
    }

    public void setFilenameDescription(String filenameDescription) {
        this.filenameDescription = filenameDescription;
    }

    public long getOraSeqNumber() {
        return oraSeqNumber;
    }

    public void setOraSeqNumber(long oraSeqNumber) {
        this.oraSeqNumber = oraSeqNumber;
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

    public String getInputOutputIndicator() {
        return inputOutputIndicator;
    }

    public void setInputOutputIndicator(String inputOutputIndicator) {
        this.inputOutputIndicator = inputOutputIndicator;
    }

    public String getLastFileIndicator() {
        return lastFileIndicator;
    }

    public void setLastFileIndicator(String lastFileIndicator) {
        this.lastFileIndicator = lastFileIndicator;
    }

    public String getTransmitIndicator() {
        return transmitIndicator;
    }

    public void setTransmitIndicator(String transmitIndicator) {
        this.transmitIndicator = transmitIndicator;
    }

    public Integer getDestination() {
        return destination;
    }

    public void setDestination(Integer destination) {
        this.destination = destination;
    }

    public long getNumberOfRecords() {
        return numberOfRecords;
    }

    public void setNumberOfRecords(long numberOfRecords) {
        this.numberOfRecords = numberOfRecords;
    }

    public Date getOpsDate() {
        return opsDate;
    }

    public void setOpsDate(Date opsDate) {
        this.opsDate = opsDate;
    }

    public BigDecimal getCrValue() {
        return crValue;
    }

    public void setCrValue(BigDecimal crValue) {
        this.crValue = crValue;
    }

    public BigDecimal getDrValue() {
        return drValue;
    }

    public void setDrValue(BigDecimal drValue) {
        this.drValue = drValue;
    }

    public String getFileRefNumber() {
        return fileRefNumber;
    }

    public void setFileRefNumber(String fileRefNumber) {
        this.fileRefNumber = fileRefNumber;
    }

    public Short getBankCode() {
        return bankCode;
    }

    public void setBankCode(Short bankCode) {
        this.bankCode = bankCode;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public short getCentre() {
        return centre;
    }

    public void setCentre(short centre) {
        this.centre = centre;
    }

    public String getInternalIndicator() {
        return internalIndicator;
    }

    public void setInternalIndicator(String internalIndicator) {
        this.internalIndicator = internalIndicator;
    }

    public String getPrintCode() {
        return printCode;
    }

    public void setPrintCode(String printCode) {
        this.printCode = printCode;
    }

    public String getRecipientCode() {
        return recipientCode;
    }

    public void setRecipientCode(String recipientCode) {
        this.recipientCode = recipientCode;
    }

    public String getDistributedIndicator() {
        return distributedIndicator;
    }

    public void setDistributedIndicator(String distributedIndicator) {
        this.distributedIndicator = distributedIndicator;
    }

    public Integer getNoOfCredits() {
        return noOfCredits;
    }

    public void setNoOfCredits(Integer noOfCredits) {
        this.noOfCredits = noOfCredits;
    }

    public Integer getNoOfDebits() {
        return noOfDebits;
    }

    public void setNoOfDebits(Integer noOfDebits) {
        this.noOfDebits = noOfDebits;
    }

    public Long getHashTotal() {
        return hashTotal;
    }

    public void setHashTotal(Long hashTotal) {
        this.hashTotal = hashTotal;
    }

    public String getAxdCreatedIndicator() {
        return axdCreatedIndicator;
    }

    public void setAxdCreatedIndicator(String axdCreatedIndicator) {
        this.axdCreatedIndicator = axdCreatedIndicator;
    }

    public Integer getNegativeCardCount() {
        return negativeCardCount;
    }

    public void setNegativeCardCount(Integer negativeCardCount) {
        this.negativeCardCount = negativeCardCount;
    }

    public Short getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(Short acquirer) {
        this.acquirer = acquirer;
    }

    public Short getIssuer() {
        return issuer;
    }

    public void setIssuer(Short issuer) {
        this.issuer = issuer;
    }

    public Integer getControlRecordCount() {
        return controlRecordCount;
    }

    public void setControlRecordCount(Integer controlRecordCount) {
        this.controlRecordCount = controlRecordCount;
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
        if (!(object instanceof CsoZ1Z9InputOutputs)) {
            return false;
        }
        CsoZ1Z9InputOutputs other = (CsoZ1Z9InputOutputs) object;
        if ((this.filenameDescription == null && other.filenameDescription != null) || (this.filenameDescription != null && !this.filenameDescription.equals(other.filenameDescription))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoZ1Z9InputOutputs[ filenameDescription=" + filenameDescription + " ]";
    }
    
}
