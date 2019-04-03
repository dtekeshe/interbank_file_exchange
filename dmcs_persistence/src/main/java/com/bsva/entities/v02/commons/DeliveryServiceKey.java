package com.bsva.entities.v02.commons;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class DeliveryServiceKey implements Serializable {

    @Column(name = "SERVICE_ID")
    private String serviceID;
    @Column(name = "SUB_SERVICE_ID")
    private String subServiceID;
    @Column(name = "DIRECTION")
    private String direction;

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getSubServiceID() {
        return subServiceID;
    }

    public void setSubServiceID(String subServiceID) {
        this.subServiceID = subServiceID;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryServiceKey that = (DeliveryServiceKey) o;

        if (serviceID != null ? !serviceID.equals(that.serviceID) : that.serviceID != null) return false;
        if (subServiceID != null ? !subServiceID.equals(that.subServiceID) : that.subServiceID != null) return false;
        return !(direction != null ? !direction.equals(that.direction) : that.direction != null);

    }

    @Override
    public int hashCode() {
        int result = serviceID != null ? serviceID.hashCode() : 0;
        result = 31 * result + (subServiceID != null ? subServiceID.hashCode() : 0);
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }
}
