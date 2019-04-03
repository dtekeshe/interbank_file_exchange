package com.bsva.entities;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "DMCS_SEQ_STORE", schema = "CCCOWNER", catalog = "")
@DynamicUpdate
public class DmcsSeqStore {
    private String dmcsSeqName;
    private Integer dmcsSeqValue;

    public DmcsSeqStore() {
    }

    public DmcsSeqStore(String dmcsSeqName, Integer dmcsSeqValue) {
        this.dmcsSeqName = dmcsSeqName;
        this.dmcsSeqValue = dmcsSeqValue;
    }

    @Id
    @Column(name = "DMCS_SEQ_NAME", nullable = false, insertable = true, updatable = true, length = 30)
    public String getDmcsSeqName() {
        return dmcsSeqName;
    }

    public void setDmcsSeqName(String dmcsSeqName) {
        this.dmcsSeqName = dmcsSeqName;
    }

    @Basic
    @Column(name = "DMCS_SEQ_VALUE", nullable = false, insertable = true, updatable = true, precision = 0)
    public Integer getDmcsSeqValue() {
        return dmcsSeqValue;
    }

    public void setDmcsSeqValue(Integer dmcsSeqValue) {
        this.dmcsSeqValue = dmcsSeqValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmcsSeqStore that = (DmcsSeqStore) o;

        if (dmcsSeqName != null ? !dmcsSeqName.equals(that.dmcsSeqName) : that.dmcsSeqName != null) return false;
        if (dmcsSeqValue != null ? !dmcsSeqValue.equals(that.dmcsSeqValue) : that.dmcsSeqValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dmcsSeqName != null ? dmcsSeqName.hashCode() : 0;
        result = 31 * result + (dmcsSeqValue != null ? dmcsSeqValue.hashCode() : 0);
        return result;
    }
}
