package com.bsva.entities.v02.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * TODO Document
 */
@Entity
public class ErrorEntity {

    @Id
    @Column(name = "ERROR_CODE")
    private Integer errorCode;
    @Column(name = "ERROR_MESSAGE")
    private String errorDescription;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
