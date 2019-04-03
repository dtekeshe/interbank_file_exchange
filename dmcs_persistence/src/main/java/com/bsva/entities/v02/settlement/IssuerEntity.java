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
public class IssuerEntity implements Serializable {

    @EmbeddedId
    private IssuerKey id;
    @Column(name = "ISSUER_MEMBER")
    private String memberName;
    @Column(name = "MEMBER_NO")
    private Integer memberNumber;
    @Column(name = "MNEMONIC_MEMBER_NAME")
    private String MnemonicMemberName;

   

	public IssuerKey getId() {
        return id;
    }

    public void setId(IssuerKey id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(Integer memberNo) {
        this.memberNumber = memberNo;
    }
    
    public String getMnemonicMemberName() {
		return MnemonicMemberName;
	}

	public void setMnemonicMemberName(String mnemonicMemberName) {
		MnemonicMemberName = mnemonicMemberName;
	}
}
