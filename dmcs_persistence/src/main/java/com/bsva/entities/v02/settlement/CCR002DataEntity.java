package com.bsva.entities.v02.settlement;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class CCR002DataEntity implements Serializable {

    @EmbeddedId
    private CCR002DataKey id;
    @Column(name = "FULL_BANK_CODE")
    private String fullBankCode;
    @Column(name = "ISSUER_MEMBER")
    private String issuerMember;
    @Column(name = "ACQUIRER_MEMBER")
    private String acquirerMember;
    @Column(name = "INTERCHANGE_FEE")
    private  Double interchangeFee;

    public CCR002DataKey getId() {
        return id;
    }

    public void setId(CCR002DataKey id) {
        this.id = id;
    }

    public String getFullBankCode() {
        return fullBankCode;
    }

    public void setFullBankCode(String fullBankCode) {
        this.fullBankCode = fullBankCode;
    }

    public String getIssuerMember() {
        return issuerMember;
    }

    public void setIssuerMember(String issuerMember) {
        this.issuerMember = issuerMember;
    }

    public String getAcquirerMember() {
        return acquirerMember;
    }

    public void setAcquirerMember(String acquirerMember) {
        this.acquirerMember = acquirerMember;
    }

    public Double getInterchangeFee() {
        return interchangeFee;
    }

    public void setInterchangeFee(Double interchangeFee) {
        this.interchangeFee = interchangeFee;
    }
}
