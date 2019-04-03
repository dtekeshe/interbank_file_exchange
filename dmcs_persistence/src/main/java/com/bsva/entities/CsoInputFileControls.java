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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.TableGenerator;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "CSO_INPUT_FILE_CONTROLS")
@NamedQueries({
	/*@NamedQuery(name = "CsoInputFileControls.findAllProcessStatus", query = "select c from CsoInputFileControls c where c.processStatus in (?1)"),*/
    @NamedQuery(name = "CsoInputFileControls.findAll", query = "SELECT c FROM CsoInputFileControls c"),
    @NamedQuery(name = "CsoInputFileControls.findByFileRefNumber", query = "SELECT c FROM CsoInputFileControls c WHERE c.fileRefNumber = :fileRefNumber"),
    @NamedQuery(name = "CsoInputFileControls.findByOutputDate", query = "SELECT c FROM CsoInputFileControls c WHERE c.outputDate = :outputDate"),
    @NamedQuery(name = "CsoInputFileControls.findByService", query = "SELECT c FROM CsoInputFileControls c WHERE c.service = :service"),
    @NamedQuery(name = "CsoInputFileControls.findBySubService", query = "SELECT c FROM CsoInputFileControls c WHERE c.subService = :subService"),
    @NamedQuery(name = "CsoInputFileControls.findByNumberOfRecs", query = "SELECT c FROM CsoInputFileControls c WHERE c.numberOfRecs = :numberOfRecs"),
    @NamedQuery(name = "CsoInputFileControls.findByNumberCredits", query = "SELECT c FROM CsoInputFileControls c WHERE c.numberCredits = :numberCredits"),
    @NamedQuery(name = "CsoInputFileControls.findByNumberDebits", query = "SELECT c FROM CsoInputFileControls c WHERE c.numberDebits = :numberDebits"),
    @NamedQuery(name = "CsoInputFileControls.findByCreditValue", query = "SELECT c FROM CsoInputFileControls c WHERE c.creditValue = :creditValue"),
    @NamedQuery(name = "CsoInputFileControls.findByDebitValue", query = "SELECT c FROM CsoInputFileControls c WHERE c.debitValue = :debitValue"),
    @NamedQuery(name = "CsoInputFileControls.findByHashTotal", query = "SELECT c FROM CsoInputFileControls c WHERE c.hashTotal = :hashTotal"),
    @NamedQuery(name = "CsoInputFileControls.findByLastFileIndicator", query = "SELECT c FROM CsoInputFileControls c WHERE c.lastFileIndicator = :lastFileIndicator"),
    @NamedQuery(name = "CsoInputFileControls.findByProcessStatus", query = "SELECT c FROM CsoInputFileControls c WHERE c.processStatus = :processStatus"),
    @NamedQuery(name = "CsoInputFileControls.findByExtractedCount", query = "SELECT c FROM CsoInputFileControls c WHERE c.extractedCount = :extractedCount"),
    @NamedQuery(name = "CsoInputFileControls.findByExtCredits", query = "SELECT c FROM CsoInputFileControls c WHERE c.extCredits = :extCredits"),
    @NamedQuery(name = "CsoInputFileControls.findByExtDebits", query = "SELECT c FROM CsoInputFileControls c WHERE c.extDebits = :extDebits"),
    @NamedQuery(name = "CsoInputFileControls.findByExtCreditValue", query = "SELECT c FROM CsoInputFileControls c WHERE c.extCreditValue = :extCreditValue"),
    @NamedQuery(name = "CsoInputFileControls.findByExtDebitValue", query = "SELECT c FROM CsoInputFileControls c WHERE c.extDebitValue = :extDebitValue"),
    @NamedQuery(name = "CsoInputFileControls.findByLastProcessDate", query = "SELECT c FROM CsoInputFileControls c WHERE c.lastProcessDate = :lastProcessDate"),
    @NamedQuery(name = "CsoInputFileControls.findByNextOutputDate", query = "SELECT c FROM CsoInputFileControls c WHERE c.nextOutputDate = :nextOutputDate"),
    @NamedQuery(name = "CsoInputFileControls.findBySettlementCount", query = "SELECT c FROM CsoInputFileControls c WHERE c.settlementCount = :settlementCount"),
    @NamedQuery(name = "CsoInputFileControls.findByLoadDate", query = "SELECT c FROM CsoInputFileControls c WHERE c.loadDate = :loadDate"),
    @NamedQuery(name = "CsoInputFileControls.findByOriginatingMember", query = "SELECT c FROM CsoInputFileControls c WHERE c.originatingMember = :originatingMember"),
    @NamedQuery(name = "CsoInputFileControls.findByNegativeCardCount", query = "SELECT c FROM CsoInputFileControls c WHERE c.negativeCardCount = :negativeCardCount"),
    @NamedQuery(name = "CsoInputFileControls.findByNegativeDuplicateCount", query = "SELECT c FROM CsoInputFileControls c WHERE c.negativeDuplicateCount = :negativeDuplicateCount"),
    @NamedQuery(name = "CsoInputFileControls.findByLastCommitedRecordPointer", query = "SELECT c FROM CsoInputFileControls c WHERE c.lastCommitedRecordPointer = :lastCommitedRecordPointer"),
    @NamedQuery(name = "CsoInputFileControls.findByExcepRepProducedInd", query = "SELECT c FROM CsoInputFileControls c WHERE c.excepRepProducedInd = :excepRepProducedInd"),
    @NamedQuery(name = "CsoInputFileControls.findByErrorFilename", query = "SELECT c FROM CsoInputFileControls c WHERE c.errorFilename = :errorFilename"),
    @NamedQuery(name = "CsoInputFileControls.findBySystemSeqNumber", query = "SELECT c FROM CsoInputFileControls c WHERE c.systemSeqNumber = :systemSeqNumber"),
    @NamedQuery(name = "CsoInputFileControls.findByOdsDataStatus", query = "SELECT c FROM CsoInputFileControls c WHERE c.odsDataStatus = :odsDataStatus"),
    @NamedQuery(name = "CsoInputFileControls.findByIsBilled", query = "SELECT c FROM CsoInputFileControls c WHERE c.isBilled = :isBilled"),
    @NamedQuery(name = "CsoInputFileControls.findByIsPreExtracted", query = "SELECT c FROM CsoInputFileControls c WHERE c.isPreExtracted = :isPreExtracted")})
@DynamicUpdate
public class CsoInputFileControls implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "FILE_REF_NUMBER")
    private String fileRefNumber;
    @Column(name = "OUTPUT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date outputDate;
    @Size(max = 4)
    @Column(name = "SERVICE")
    private String service;
    @Size(max = 10)
    @Column(name = "SUB_SERVICE")
    private String subService;
    @Column(name = "NUMBER_OF_RECS")
    private Integer numberOfRecs;
    @Column(name = "NUMBER_CREDITS")
    private Integer numberCredits;
    @Column(name = "NUMBER_DEBITS")
    private Integer numberDebits;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CREDIT_VALUE")
    private BigDecimal creditValue;
    @Column(name = "DEBIT_VALUE")
    private BigDecimal debitValue;
    @Column(name = "HASH_TOTAL")
    private Long hashTotal;
    @Size(max = 1)
    @Column(name = "LAST_FILE_INDICATOR")
    private String lastFileIndicator;
    @Size(max = 1)
    @Column(name = "PROCESS_STATUS")
    private String processStatus;
    @Column(name = "EXTRACTED_COUNT")
    private Integer extractedCount;
    @Column(name = "EXT_CREDITS")
    private Integer extCredits;
    @Column(name = "EXT_DEBITS")
    private Integer extDebits;
    @Column(name = "EXT_CREDIT_VALUE")
    private BigDecimal extCreditValue;
    @Column(name = "EXT_DEBIT_VALUE")
    private BigDecimal extDebitValue;
    @Column(name = "LAST_PROCESS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastProcessDate;
    @Column(name = "NEXT_OUTPUT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextOutputDate;
    @Column(name = "SETTLEMENT_COUNT")
    private Integer settlementCount;
    @Column(name = "LOAD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loadDate;
    @Column(name = "ORIGINATING_MEMBER")
    private Short originatingMember;
    @Column(name = "NEGATIVE_CARD_COUNT")
    private Integer negativeCardCount;
    @Column(name = "NEGATIVE_DUPLICATE_COUNT")
    private Integer negativeDuplicateCount;
    @Column(name = "LAST_COMMITED_RECORD_POINTER")
    private Integer lastCommitedRecordPointer;
    @Size(max = 1)
    @Column(name = "EXCEP_REP_PRODUCED_IND")
    private String excepRepProducedInd;
    @Size(max = 6)
    @Column(name = "ERROR_FILENAME")
    private String errorFilename;
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="generator")
//	@SequenceGenerator(name="generator", sequenceName="CSO_INP_SEQ", allocationSize=0)
    @TableGenerator(
            name = "dmcsSequenceStore",
            table="DMCS_SEQ_STORE",
            pkColumnName = "DMCS_SEQ_NAME",
            pkColumnValue = "IN_FILE_CONT.SYSTEM_SEQ_NUMBER",
            valueColumnName = "DMCS_SEQ_VALUE",
            initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "dmcsSequenceStore")
    @NotNull
    @Column(name = "SYSTEM_SEQ_NUMBER")
    private Long systemSeqNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ODS_DATA_STATUS")
    private String odsDataStatus;
    @Size(max = 1)
    @Column(name = "IS_BILLED")
    private String isBilled;
    @Size(max = 1)
    @Column(name = "IS_PRE_EXTRACTED")
    private String isPreExtracted;
    @Column(name="NUMBER_OF_REJECTS")
    private String numberOfRejects;

    public CsoInputFileControls() {
    }

    public CsoInputFileControls(Long systemSeqNumber) {
        this.systemSeqNumber = systemSeqNumber;
    }

    public CsoInputFileControls(Long systemSeqNumber, String fileRefNumber, String odsDataStatus) {
        this.systemSeqNumber = systemSeqNumber;
        this.fileRefNumber = fileRefNumber;
        this.odsDataStatus = odsDataStatus;
    }

    public String getFileRefNumber() {
        return fileRefNumber;
    }

    public void setFileRefNumber(String fileRefNumber) {
        this.fileRefNumber = fileRefNumber;
    }

    public Date getOutputDate() {
        return outputDate;
    }

    public void setOutputDate(Date outputDate) {
        this.outputDate = outputDate;
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

    public Integer getNumberOfRecs() {
        return numberOfRecs;
    }

    public void setNumberOfRecs(Integer numberOfRecs) {
        this.numberOfRecs = numberOfRecs;
    }

    public Integer getNumberCredits() {
        return numberCredits;
    }

    public void setNumberCredits(Integer numberCredits) {
        this.numberCredits = numberCredits;
    }

    public Integer getNumberDebits() {
        return numberDebits;
    }

    public void setNumberDebits(Integer numberDebits) {
        this.numberDebits = numberDebits;
    }

    public BigDecimal getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(BigDecimal creditValue) {
        this.creditValue = creditValue;
    }

    public BigDecimal getDebitValue() {
        return debitValue;
    }

    public void setDebitValue(BigDecimal debitValue) {
        this.debitValue = debitValue;
    }

    public Long getHashTotal() {
        return hashTotal;
    }

    public void setHashTotal(Long hashTotal) {
        this.hashTotal = hashTotal;
    }

    public String getLastFileIndicator() {
        return lastFileIndicator;
    }

    public void setLastFileIndicator(String lastFileIndicator) {
        this.lastFileIndicator = lastFileIndicator;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public Integer getExtractedCount() {
        return extractedCount;
    }

    public void setExtractedCount(Integer extractedCount) {
        this.extractedCount = extractedCount;
    }

    public Integer getExtCredits() {
        return extCredits;
    }

    public void setExtCredits(Integer extCredits) {
        this.extCredits = extCredits;
    }

    public Integer getExtDebits() {
        return extDebits;
    }

    public void setExtDebits(Integer extDebits) {
        this.extDebits = extDebits;
    }

    public BigDecimal getExtCreditValue() {
        return extCreditValue;
    }

    public void setExtCreditValue(BigDecimal extCreditValue) {
        this.extCreditValue = extCreditValue;
    }

    public BigDecimal getExtDebitValue() {
        return extDebitValue;
    }

    public void setExtDebitValue(BigDecimal extDebitValue) {
        this.extDebitValue = extDebitValue;
    }

    public Date getLastProcessDate() {
        return lastProcessDate;
    }

    public void setLastProcessDate(Date lastProcessDate) {
        this.lastProcessDate = lastProcessDate;
    }

    public Date getNextOutputDate() {
        return nextOutputDate;
    }

    public void setNextOutputDate(Date nextOutputDate) {
        this.nextOutputDate = nextOutputDate;
    }

    public Integer getSettlementCount() {
        return settlementCount;
    }

    public void setSettlementCount(Integer settlementCount) {
        this.settlementCount = settlementCount;
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    public Short getOriginatingMember() {
        return originatingMember;
    }

    public void setOriginatingMember(Short originatingMember) {
        this.originatingMember = originatingMember;
    }

    public Integer getNegativeCardCount() {
        return negativeCardCount;
    }

    public void setNegativeCardCount(Integer negativeCardCount) {
        this.negativeCardCount = negativeCardCount;
    }

    public Integer getNegativeDuplicateCount() {
        return negativeDuplicateCount;
    }

    public void setNegativeDuplicateCount(Integer negativeDuplicateCount) {
        this.negativeDuplicateCount = negativeDuplicateCount;
    }

    public Integer getLastCommitedRecordPointer() {
        return lastCommitedRecordPointer;
    }

    public void setLastCommitedRecordPointer(Integer lastCommitedRecordPointer) {
        this.lastCommitedRecordPointer = lastCommitedRecordPointer;
    }

    public String getExcepRepProducedInd() {
        return excepRepProducedInd;
    }

    public void setExcepRepProducedInd(String excepRepProducedInd) {
        this.excepRepProducedInd = excepRepProducedInd;
    }

    public String getErrorFilename() {
        return errorFilename;
    }

    public void setErrorFilename(String errorFilename) {
        this.errorFilename = errorFilename;
    }

    public Long getSystemSeqNumber() {
        return systemSeqNumber;
    }

    public void setSystemSeqNumber(Long systemSeqNumber) {
        this.systemSeqNumber = systemSeqNumber;
    }

    public String getOdsDataStatus() {
        return odsDataStatus;
    }

    public void setOdsDataStatus(String odsDataStatus) {
        this.odsDataStatus = odsDataStatus;
    }

    public String getIsBilled() {
        return isBilled;
    }

    public void setIsBilled(String isBilled) {
        this.isBilled = isBilled;
    }

    public String getIsPreExtracted() {
        return isPreExtracted;
    }

    public void setIsPreExtracted(String isPreExtracted) {
        this.isPreExtracted = isPreExtracted;
    }
    public void setNumberOfRejects(String numberOfRejects) {
		this.numberOfRejects = numberOfRejects;
	}
    public String getNumberOfRejects() {
		return numberOfRejects;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (systemSeqNumber != null ? systemSeqNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoInputFileControls)) {
            return false;
        }
        CsoInputFileControls other = (CsoInputFileControls) object;
        if ((this.systemSeqNumber == null && other.systemSeqNumber != null) || (this.systemSeqNumber != null && !this.systemSeqNumber.equals(other.systemSeqNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.disc.CsoInputFileControls[ systemSeqNumber=" + systemSeqNumber + " ]";
    }
    
}
