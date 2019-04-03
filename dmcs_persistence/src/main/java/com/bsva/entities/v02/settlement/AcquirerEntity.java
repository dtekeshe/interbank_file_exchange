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
public class AcquirerEntity implements Serializable {

    @EmbeddedId
    private AcquirerKey id;
    @Column(name = "MEMBER_NO")
    private Integer memberNumber;
    @Column(name = "ACQUIRER_MEMBER")
    private String memberName;

    public AcquirerKey getId() {
        return id;
    }

    public void setId(AcquirerKey id) {
        this.id = id;
    }

    public Integer getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(Integer memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
