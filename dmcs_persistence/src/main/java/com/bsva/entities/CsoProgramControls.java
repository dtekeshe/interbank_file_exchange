/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSO_PROGRAM_CONTROLS")
@NamedQueries({
    @NamedQuery(name = "CsoProgramControls.findAll", query = "SELECT c FROM CsoProgramControls c"),
    @NamedQuery(name = "CsoProgramControls.findByProgramName", query = "SELECT c FROM CsoProgramControls c WHERE c.csoProgramControlsPK.programName = :programName"),
    @NamedQuery(name = "CsoProgramControls.findByServiceCode", query = "SELECT c FROM CsoProgramControls c WHERE c.serviceCode = :serviceCode"),
    @NamedQuery(name = "CsoProgramControls.findBySubServiceCode", query = "SELECT c FROM CsoProgramControls c WHERE c.subServiceCode = :subServiceCode"),
    @NamedQuery(name = "CsoProgramControls.findByPaymentStream", query = "SELECT c FROM CsoProgramControls c WHERE c.paymentStream = :paymentStream"),
    @NamedQuery(name = "CsoProgramControls.findByStartTime", query = "SELECT c FROM CsoProgramControls c WHERE c.startTime = :startTime"),
    @NamedQuery(name = "CsoProgramControls.findByEndTime", query = "SELECT c FROM CsoProgramControls c WHERE c.endTime = :endTime"),
    @NamedQuery(name = "CsoProgramControls.findByStatus", query = "SELECT c FROM CsoProgramControls c WHERE c.status = :status"),
    @NamedQuery(name = "CsoProgramControls.findByExecutionAverage", query = "SELECT c FROM CsoProgramControls c WHERE c.executionAverage = :executionAverage"),
    @NamedQuery(name = "CsoProgramControls.findByExecutionLast", query = "SELECT c FROM CsoProgramControls c WHERE c.executionLast = :executionLast"),
    @NamedQuery(name = "CsoProgramControls.findBySeqNo", query = "SELECT c FROM CsoProgramControls c WHERE c.seqNo = :seqNo"),
    @NamedQuery(name = "CsoProgramControls.findByArbData", query = "SELECT c FROM CsoProgramControls c WHERE c.csoProgramControlsPK.arbData = :arbData")})
@DynamicUpdate
public class CsoProgramControls implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsoProgramControlsPK csoProgramControlsPK;
    @Size(max = 4)
    @Column(name = "SERVICE_CODE")
    private String serviceCode;
    @Size(max = 10)
    @Column(name = "SUB_SERVICE_CODE")
    private String subServiceCode;
    @Size(max = 4)
    @Column(name = "PAYMENT_STREAM")
    private String paymentStream;
    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "END_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Size(max = 1)
    @Column(name = "STATUS")
    private String status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "EXECUTION_AVERAGE")
    private BigDecimal executionAverage;
    @Column(name = "EXECUTION_LAST")
    private BigDecimal executionLast;
    @Column(name = "SEQ_NO")
    private Short seqNo;

    public CsoProgramControls() {
    }

    public CsoProgramControls(CsoProgramControlsPK csoProgramControlsPK) {
        this.csoProgramControlsPK = csoProgramControlsPK;
    }

    public CsoProgramControls(String programName, String arbData) {
        this.csoProgramControlsPK = new CsoProgramControlsPK(programName, arbData);
    }

    public CsoProgramControlsPK getCsoProgramControlsPK() {
        return csoProgramControlsPK;
    }

    public void setCsoProgramControlsPK(CsoProgramControlsPK csoProgramControlsPK) {
        this.csoProgramControlsPK = csoProgramControlsPK;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getSubServiceCode() {
        return subServiceCode;
    }

    public void setSubServiceCode(String subServiceCode) {
        this.subServiceCode = subServiceCode;
    }

    public String getPaymentStream() {
        return paymentStream;
    }

    public void setPaymentStream(String paymentStream) {
        this.paymentStream = paymentStream;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getExecutionAverage() {
        return executionAverage;
    }

    public void setExecutionAverage(BigDecimal executionAverage) {
        this.executionAverage = executionAverage;
    }

    public BigDecimal getExecutionLast() {
        return executionLast;
    }

    public void setExecutionLast(BigDecimal executionLast) {
        this.executionLast = executionLast;
    }

    public Short getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Short seqNo) {
        this.seqNo = seqNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csoProgramControlsPK != null ? csoProgramControlsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoProgramControls)) {
            return false;
        }
        CsoProgramControls other = (CsoProgramControls) object;
        if ((this.csoProgramControlsPK == null && other.csoProgramControlsPK != null) || (this.csoProgramControlsPK != null && !this.csoProgramControlsPK.equals(other.csoProgramControlsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoProgramControls[ csoProgramControlsPK=" + csoProgramControlsPK + " ]";
    }
    
}
