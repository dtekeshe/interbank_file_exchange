package com.bsva.entities.v02.members;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class MemberBinInfo {

    @Id
    @Column(name = "BIN_NO")
    private Integer bin;

    @Column(name = "BANK_CODE")
    private Integer bankCode;

    @Column(name = "CARD_TYPE")
    private Integer cardType;

    @Column(name = "MEMBER_ROLE_ID")
    private String memberRoleID;

    @Column(name = "DAYS_BEFOREFIRST_DELETION_DATE")
    private Long daysBeforefirstDeletionDate;

    @Column(name = "DAYS_BEFOREFINAL_DELETION_DATE")
    private Long daysBeforefinalDeletionDate;

    @Column(name = "DISTRIBUTION_CODE")
    private String distributionCode;

    public Integer getBin() {
        return bin;
    }

    public void setBin(Integer bin) {
        this.bin = bin;
    }

    public Integer getBankCode() {
        return bankCode;
    }

    public void setBankCode(Integer bankCode) {
        this.bankCode = bankCode;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getMemberRoleID() {
        return memberRoleID;
    }

    public void setMemberRoleID(String memberRoleID) {
        this.memberRoleID = memberRoleID;
    }

    public Long getDaysBeforefirstDeletionDate() {
        return daysBeforefirstDeletionDate;
    }

    public void setDaysBeforefirstDeletionDate(Long daysBeforefirstDeletionDate) {
        this.daysBeforefirstDeletionDate = daysBeforefirstDeletionDate;
    }

    public Long getDaysBeforefinalDeletionDate() {
        return daysBeforefinalDeletionDate;
    }

    public void setDaysBeforefinalDeletionDate(Long daysBeforefinalDeletionDate) {
        this.daysBeforefinalDeletionDate = daysBeforefinalDeletionDate;
    }

    public String getDistributionCode() {
        return distributionCode;
    }

    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }
}
