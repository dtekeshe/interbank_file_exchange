package com.bsva.dmcs.fileloadv02.dto;

/**
 *
 */
public enum MemberRole {
    ACQUIRER("A"), ISSUER("I"), ACQUIRER_ISSUER("B");

    private final String roleID;

    MemberRole(String roleID) {
        this.roleID = roleID;
    }

    public static MemberRole memberRole(String roleID) {
        for (MemberRole memberRole : values()) {
            if (memberRole.roleID.equals(roleID)) {
                return memberRole;
            }
        }

        return null;
    }
}
