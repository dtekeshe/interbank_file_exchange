package com.bsva.entities.v02.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
public class ProgramAlreadyRunFlagEntity implements Serializable {

    @Id
    @Column(name = "ARB_DATA")
    private String arbData;

    public String getArbData() {
        return arbData;
    }

    public void setArbData(String arbData) {
        this.arbData = arbData;
    }
}
