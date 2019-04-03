/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AugustineA
 */
@Embeddable
public class CsfDistributionParametersPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "BANK_CODE")
    private short bankCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "REPORT_NAME")
    private String reportName;

    public CsfDistributionParametersPK() {
    }

    public CsfDistributionParametersPK(short bankCode, String reportName) {
        this.bankCode = bankCode;
        this.reportName = reportName;
    }

    public short getBankCode() {
        return bankCode;
    }

    public void setBankCode(short bankCode) {
        this.bankCode = bankCode;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) bankCode;
        hash += (reportName != null ? reportName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfDistributionParametersPK)) {
            return false;
        }
        CsfDistributionParametersPK other = (CsfDistributionParametersPK) object;
        if (this.bankCode != other.bankCode) {
            return false;
        }
        if ((this.reportName == null && other.reportName != null) || (this.reportName != null && !this.reportName.equals(other.reportName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfDistributionParametersPK[ bankCode=" + bankCode + ", reportName=" + reportName + " ]";
    }
    
}
