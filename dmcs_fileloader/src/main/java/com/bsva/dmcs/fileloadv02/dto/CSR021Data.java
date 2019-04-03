package com.bsva.dmcs.fileloadv02.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@XmlRootElement(name = "reportContent")
@XmlType(propOrder = {"companyName", "companyRegNumber",
                        "processDate",
                        "serviceID", "subServiceID",
                        "filename", "fileRejectionReasons"})
public class CSR021Data implements Serializable {

    private String companyName;
    private String companyRegNumber;
    private Date processDate;
    private String serviceID;
    private String subServiceID;
    private String filename;

    private FileRejectReasonDTO fileRejectionReasons;

    public CSR021Data() {
    }

    public CSR021Data( String companyName,
                       String companyRegNumber,
                       Date processDate,
                       String serviceID,
                       String subServiceID,
                       String filename,
                       FileRejectReasonDTO fileRejectionReasons) {
        this.companyName = companyName;
        this.companyRegNumber = companyRegNumber;
        this.processDate = processDate;
        this.serviceID = serviceID;
        this.subServiceID = subServiceID;
        this.filename = filename;
        this.fileRejectionReasons = fileRejectionReasons;
    }

    public String getCompanyName() {
        return companyName;
    }

    @XmlElement
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyRegNumber() {
        return companyRegNumber;
    }

    @XmlElement
    public void setCompanyRegNumber(String companyRegNumber) {
        this.companyRegNumber = companyRegNumber;
    }

    public Date getProcessDate() {
        return processDate;
    }

    @XmlElement
    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getServiceID() {
        return serviceID;
    }

    @XmlElement(name = "service")
    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getSubServiceID() {
        return subServiceID;
    }

    @XmlElement(name = "subService")
    public void setSubServiceID(String subServiceID) {
        this.subServiceID = subServiceID;
    }

    public String getFilename() {
        return filename;
    }

    @XmlElement(name = "bsvFileName")
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public FileRejectReasonDTO getFileRejectionReasons() {
        return fileRejectionReasons;
    }

    @XmlElement(name = "fileRejectReason")
    public void setFileRejectionReasons(FileRejectReasonDTO fileRejectionReasons) {
        this.fileRejectionReasons = fileRejectionReasons;
    }
}
