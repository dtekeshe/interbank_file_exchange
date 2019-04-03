package com.bsva.entities.v02.members;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * TODO document
 */
@Entity
@DynamicUpdate
public class MemberParamsEntity implements Serializable {

    @EmbeddedId
    private MemberParamKey id;

    @Column( name = "MAX_SIZE_TRANS_FILE")
    private Long maxFileSize;

    public Long getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(Long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public MemberParamKey getId() {
        return id;
    }

    public void setId(MemberParamKey id) {
        this.id = id;
    }
}
