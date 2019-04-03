package com.bsva.entities.v02.commons;

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
public class DeliveryServiceEntity implements Serializable {

    @EmbeddedId
    private DeliveryServiceKey id;
    @Column(name = "IS_ACTIVE")
    private String active;

    public DeliveryServiceKey getId() {
        return id;
    }

    public void setId(DeliveryServiceKey id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public boolean isActive() {

        return "Y".equalsIgnoreCase(active);
    }

    public void setActive(String active) {
        this.active = active;
    }
}
