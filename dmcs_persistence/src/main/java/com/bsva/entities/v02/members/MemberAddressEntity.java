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
public class MemberAddressEntity implements Serializable {

    @Id
    @Column(name = "BANK_CODE")
    private Integer bankCode;
    @Column(name = "MEMBER_NO")
    private String memberCode;
    @Column(name = "CONTACT_NAME")
    private String contactName;
    @Column(name = "MEMBER_NAME")
    private String bankName;
    @Column(name = "MEMBER_ADDRESS_1")
    private String memberAddress1;
    @Column(name = "MEMBER_ADDRESS_2")
    private String memberAddress2;
    @Column(name = "MEMBER_ADDRESS_3")
    private String memberAddress3;
    @Column(name = "MEMBER_ADDRESS_4")
    private String memberAddress4;
    @Column(name = "VAT_REG_NUMBER")
    private String vatRegNumber;

    public Integer getBankCode() {
        return bankCode;
    }

    public void setBankCode(Integer bankCode) {
        this.bankCode = bankCode;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }


   public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    } 

    public String getMemberAddress1() {
        return memberAddress1;
    }

    public void setMemberAddress1(String memberAddress1) {
        this.memberAddress1 = memberAddress1;
    }

    public String getMemberAddress2() {
        return memberAddress2;
    }

    public void setMemberAddress2(String memberAddress2) {
        this.memberAddress2 = memberAddress2;
    }

    public String getMemberAddress3() {
        return memberAddress3;
    }

    public void setMemberAddress3(String memberAddress3) {
        this.memberAddress3 = memberAddress3;
    }

    public String getMemberAddress4() {
        return memberAddress4;
    }

    public void setMemberAddress4(String memberAddress4) {
        this.memberAddress4 = memberAddress4;
    }

    public String getVatRegNumber() {
        return vatRegNumber;
    }

    public void setVatRegNumber(String vatRegNumber) {
        this.vatRegNumber = vatRegNumber;
    }
}
