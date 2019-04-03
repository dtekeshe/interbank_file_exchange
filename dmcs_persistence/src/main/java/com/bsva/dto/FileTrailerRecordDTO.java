package com.bsva.dto;

import java.util.Date;

/**
 * TODO Document
 */
public class FileTrailerRecordDTO {

    private final Integer recordID;
    private final Date processDate;
    private final String serviceID;
    private final String subServiceID;
    private final Integer originatorID;
    private final Long recordCount;

    public FileTrailerRecordDTO(Long recordCount,
                                Integer originatorID,
                                String subServiceID,
                                String serviceID,
                                Date processDate,
                                Integer recordID) {

        this.recordCount = recordCount;
        this.originatorID = originatorID;
        this.subServiceID = subServiceID;
        this.serviceID = serviceID;
        this.processDate = processDate;
        this.recordID = recordID;
    }

    public Integer getRecordID() {
        return recordID;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public String getServiceID() {
        return serviceID;
    }

    public String getSubServiceID() {
        return subServiceID;
    }

    public Integer getOriginatorID() {
        return originatorID;
    }

    public Long getRecordCount() {
        return recordCount;
    }
}
