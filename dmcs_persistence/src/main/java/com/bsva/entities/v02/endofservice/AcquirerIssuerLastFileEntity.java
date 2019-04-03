package com.bsva.entities.v02.endofservice;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class AcquirerIssuerLastFileEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
    private AcquirerIssuerPairKey id;
    @Column(name = "LAST_SEQ_NUMBER")
    private String lastSeqNumber;
    
    @Column(name = "FILENAME_DESCRIPTION")
    private String fileName;
    
    @Column(name = "DISTRIBUTION_CODE")
    private String distributionCode;//FILENAME_PREFIX
    
    @Column(name = "FILENAME_PREFIX")
    private String fileNamePrefix;

    public AcquirerIssuerPairKey getId() {
        return id;
    }

    public void setId(AcquirerIssuerPairKey id) {
        this.id = id;
    }

    public String getLastSeqNumber() {
        return lastSeqNumber;
    }

    public void setLastSeqNumber(String lastSeqNumber) {
        this.lastSeqNumber = lastSeqNumber;
    }

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDistributionCode() {
		return distributionCode;
	}

	public void setDistributionCode(String distributionCode) {
		this.distributionCode = distributionCode;
	}

	public String getFileNamePrefix() {
		return fileNamePrefix;
	}

	public void setFileNamePrefix(String fileNamePrefix) {
		this.fileNamePrefix = fileNamePrefix;
	}
}
