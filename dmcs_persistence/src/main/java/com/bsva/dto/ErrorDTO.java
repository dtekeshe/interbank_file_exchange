package com.bsva.dto;

import java.io.Serializable;

/**
 * TODO Document
 */
public class ErrorDTO implements Serializable {

    private final String recordID;
    private final Long recordSequence;
    private final ErrorCode errorCode;
    private final Integer fieldNumber;
    private final String fieldContents;
    private Double txnAmount;

    public ErrorDTO( String recordID,
                     Long recordSequence,
                     ErrorCode errorCode,
                     Integer fieldNumber,
                     String fieldContents) {

        this(   recordID,
                recordSequence,
                errorCode,
                fieldNumber,
                fieldContents,
                0.0);
    }

    public ErrorDTO( String recordID,
                     Long recordSequence,
                     ErrorCode errorCode,
                     Integer fieldNumber,
                     String fieldContents,
                     Double txnAmount) {

        this.recordID = recordID;
        this.recordSequence = recordSequence;
        this.errorCode = errorCode;
        this.fieldNumber = fieldNumber;
        this.fieldContents = fieldContents;
        this.txnAmount = txnAmount;
    }

    public String getRecordID() {
        return recordID;
    }

    public Long getRecordSequence() {
        return recordSequence;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public Integer getFieldNumber() {
        return fieldNumber;
    }

    public String getFieldContents() {
        return fieldContents;
    }

    public Double getTxnAmount() {
        return txnAmount;
    }
}
