package com.bsva.entities.v02.loader;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class ServiceTypeEntity implements Serializable {

    @Id
    @Column (name = "FILENAME_PREFIX")
    private String filenamePrefix;
    @Column (name = "SERVICE")
    private String serviceID;
    @Column (name = "SUB_SERVICE")
    private String subServiceID;
    @Column (name = "FILE_INDEXER_NAME")
    private String fileIndexerName;
    @Column (name = "FILE_LOADER_NAME")
    private String fileLoaderName;
    @Column (name = "FILE_BILLING_CALCULATOR_NAME")
    private String fileBillingCalculatorName;
    @Column(name = "TXN_RECORD_PARSER_NAME")
    private String txnRecordParserName;

    public String getFilenamePrefix() {
        return filenamePrefix;
    }

    public void setFilenamePrefix(String filenamePrefix) {
        this.filenamePrefix = filenamePrefix;
    }

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

    public String getFileIndexerName() {
        return fileIndexerName;
    }

    public void setFileIndexerName(String fileIndexerName) {
        this.fileIndexerName = fileIndexerName;
    }

    public String getFileLoaderName() {
        return fileLoaderName;
    }

    public void setFileLoaderName(String fileLoaderName) {
        this.fileLoaderName = fileLoaderName;
    }

    public String getFileBillingCalculatorName() {
        return fileBillingCalculatorName;
    }

    public void setFileBillingCalculatorName(String fileBillingCalculatorName) {
        this.fileBillingCalculatorName = fileBillingCalculatorName;
    }

    public String getTxnRecordParserName() {
        return txnRecordParserName;
    }

    public void setTxnRecordParserName(String txnRecordParserName) {
        this.txnRecordParserName = txnRecordParserName;
    }
}
