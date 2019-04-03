package com.bsva.dmcs.fileloadv02.dto;

import com.bsva.entities.v02.members.MemberBinInfo;

/**
 *
 */
public class MemberInfoDTO {

    private final Integer bin;
    private final Integer bankCode;
    private final String distributionCode;
    private final Integer cardType;
    private final MemberRole memberRole;
    private final Long daysBeforefirstDeletionDate;
    private final Long daysBeforefinalDeletionDate;

    public MemberInfoDTO( Integer bin,
                          Integer bankCode,
                          String distributionCode,
                          Integer cardType,
                          MemberRole memberRole,
                          Long daysBeforefirstDeletionDate,
                          Long daysBeforefinalDeletionDate) {
        this.bin = bin;
        this.bankCode = bankCode;
        this.distributionCode = distributionCode;
        this.cardType = cardType;
        this.memberRole = memberRole;
        this.daysBeforefirstDeletionDate = daysBeforefirstDeletionDate;
        this.daysBeforefinalDeletionDate = daysBeforefinalDeletionDate;
    }

    public Integer getBin() {
        return bin;
    }

    public Integer getBankCode() {
        return bankCode;
    }

    public String getDistributionCode() {
        return distributionCode;
    }

    public Integer getCardType() {
        return cardType;
    }

    public MemberRole getMemberRole() {
        return memberRole;
    }

    public Long getDaysBeforefirstDeletionDate() {
        return daysBeforefirstDeletionDate;
    }

    public Long getDaysBeforefinalDeletionDate() {
        return daysBeforefinalDeletionDate;
    }

    public static MemberInfoDTO instance(MemberBinInfo memberBinInfoEntity) {

        return new MemberInfoDTO(
                    memberBinInfoEntity.getBin(),
                    memberBinInfoEntity.getBankCode(),
                    memberBinInfoEntity.getDistributionCode(),
                    memberBinInfoEntity.getCardType(),
                    MemberRole.memberRole(memberBinInfoEntity.getMemberRoleID()),
                    memberBinInfoEntity.getDaysBeforefirstDeletionDate(),
                    memberBinInfoEntity.getDaysBeforefinalDeletionDate());
    }
}
