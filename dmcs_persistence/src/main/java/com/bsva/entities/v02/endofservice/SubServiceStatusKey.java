package com.bsva.entities.v02.endofservice;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class SubServiceStatusKey implements Serializable {

    @Column(name = "SUB_SERVICE")
    private String subServiceID;
    @Column(name = "INWARD_OUTWARD_IND")
    private String direction;

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

        SubServiceStatusKey that = (SubServiceStatusKey) o;

        if (subServiceID != null ? !subServiceID.equals(that.subServiceID) : that.subServiceID != null) return false;
        return !(direction != null ? !direction.equals(that.direction) : that.direction != null);

    }

    @Override
    public int hashCode() {
        int result = subServiceID != null ? subServiceID.hashCode() : 0;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }
}
