package com.bsva.dmcs.fileloadv02.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 *
 */
@XmlRootElement(name = "error")
@XmlType(propOrder = {"recordID", "recordNumber",
                        "fieldNumber", "errorDescription",
                        "content"})
public class ErrorDTO implements Serializable{

    private Integer recordID;
    private Long recordNumber;
    private Integer fieldNumber;
    private String errorDescription;
    private String content;

    public ErrorDTO() {
    }

    public ErrorDTO( String errorDescription,
                     String content) {
        this(0, 0L, 0, errorDescription, content);
    }

    public ErrorDTO( Integer recordID,
                     Long recordNumber,
                     Integer fieldNumber,
                     String errorDescription,
                     String content) {
        this.recordID = recordID;
        this.recordNumber = recordNumber;
        this.fieldNumber = fieldNumber;
        this.errorDescription = errorDescription;
        this.content = content;
    }

    public static ErrorDTO errorDTO(String errorDescription,
                             String content) {
        return new ErrorDTO(errorDescription, content);
    }

    public static ErrorDTO errorDTO(Integer recordID,
                                    Long recordNumber,
                                    Integer fieldNumber,
                                    String errorDescription,
                                    String content) {
        return new ErrorDTO(recordID, recordNumber,fieldNumber, errorDescription, content);
    }

    public static ErrorDTO errorDTO(Integer recordID,
                                    Long recordNumber,
                                    Integer fieldNumber,
                                    String errorDescription) {
        return new ErrorDTO(recordID, recordNumber,fieldNumber, errorDescription, null);
    }

    public Integer getRecordID() {
        return recordID;
    }

    @XmlElement(name = "errorRecordId")
    public void setRecordID(Integer recordID) {
        this.recordID = recordID;
    }

    public Long getRecordNumber() {
        return recordNumber;
    }

    @XmlElement(name = "errorRecordNo")
    public void setRecordNumber(Long recordNumber) {
        this.recordNumber = recordNumber;
    }

    public Integer getFieldNumber() {
        return fieldNumber;
    }

    @XmlElement(name = "errorRejNo")
    public void setFieldNumber(Integer fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    @XmlElement(name = "errorDescription")
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getContent() {
        return content;
    }


    @XmlElement(name = "fieldContent")
    public void setContent(String content) {
        this.content = content;
    }
}
