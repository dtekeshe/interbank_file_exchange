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
public class MemberEntity implements Serializable {
    @Id
    @Column(name = "BANK_CODE")
    private Integer bankCode;
    @Column(name = "MEMBER_TAPE_ID")
    private String memberTapeId;
    @Column(name = "FULL_BANK_CODE")
    private Integer fullBankCode;
    @Column(name = "MAX_FILE_SIZE")
    private Integer maxFileSize;
    @Column(name = "MEMBER_NAME")
    private String memberName;
    @Column(name="TIERED_ITEM_CHARGE_BELOW")
    private String  tieredItemChargebelow;
    @Column(name="TIERED_ITEM_CHARGE_ABOVE")
    private String  tieredItemChargeAbove;
    @Column(name="TIERED_ITEM_CHARGE")
    private String tieredItemCharged;
    

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

    public Integer getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(Integer maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

	public String getTieredItemChargebelow() {
		return tieredItemChargebelow;
	}

	public String getTieredItemChargeAbove() {
		return tieredItemChargeAbove;
	}

	public void setTieredItemChargebelow(String tieredItemChargebelow) {
		this.tieredItemChargebelow = tieredItemChargebelow;
	}

	public void setTieredItemChargeAbove(String tieredItemChargeAbove) {
		this.tieredItemChargeAbove = tieredItemChargeAbove;
	}

	public String getTieredItemCharged() {
		return tieredItemCharged;
	}

	public void setTieredItemCharged(String tieredItemCharged) {
		this.tieredItemCharged = tieredItemCharged;
	}

}
