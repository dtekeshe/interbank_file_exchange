package com.bsva.entities.v02.members;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class MemberTapeIDEntity implements Serializable {
    @Id
    @Column(name = "MEMBER_TAPE_ID")
    private String memberTapeId;
    @Column(name = "BANK_CODE")
    private Integer bankCode;
    @Column(name = "FULL_BANK_CODE")
    private Integer fullBankCode;

    public Integer getBankCode() {
        return bankCode;
    }

    public void setBankCode(Integer bankCode) {
        this.bankCode = bankCode;
    }

    public String getMemberTapeId() {
        return memberTapeId;
    }

    public void setMemberTapeId(String memberTapeId) {
        this.memberTapeId = memberTapeId;
    }

    public Integer getFullBankCode() {
        return fullBankCode;
    }

    public void setFullBankCode(Integer fullBankCode) {
        this.fullBankCode = fullBankCode;
    }
}
