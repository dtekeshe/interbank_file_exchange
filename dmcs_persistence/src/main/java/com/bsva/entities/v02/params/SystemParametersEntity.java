package com.bsva.entities.v02.params;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class SystemParametersEntity implements Serializable{

    @Id
    @Column(name = "PROCESS_DATE")
    private Date processDate;

    @Column(name = "LIVE_TEST_CODE")
    private String environmentID;

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getEnvironmentID() {
        if (environmentID == null || environmentID.length() < 1) {
            return environmentID;
        }

        return environmentID.substring(0, 1);
    }

    public String getEnvironmentDescription() {

        return environmentID;
    }

    public void setEnvironmentID(String environment) {
        this.environmentID = environment;
    }
}
