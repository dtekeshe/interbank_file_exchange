package com.bsva.dmcs.fileloadv02.model;

import com.bsva.dmcs.fileloadv02.dto.Justification;
import com.bsva.dmcs.fileloadv02.util.Counter;
import com.bsva.dmcs.fileloadv02.util.StringUtils;

import static com.bsva.dmcs.fileloadv02.util.StringUtils.format;

/**
 *
 */
public class VISAFileHeader {

    private final Long fileSystemSeqNumber;
    private final String fileDate;
    private final String serviceId;
    private final String subServiceId;
    private final String originatingMemberId;
    private final String validationCode;
    private final String filename;
    private final String fileContentType;
    private final String fileDirection;
    private final String environment;
    private final String recordLength;
    private Integer originatorFullCode;
    private String processStatus;

    public VISAFileHeader(
                          Long fileSystemSeqNumber,
                          String fileDate,
                          String serviceId,
                          String subServiceId,
                          String originatingMemberId,
                          String validationCode,
                          String filename,
                          String fileContentType,
                          String fileDirection,
                          String environment,
                          String recordLength) {

        this.fileSystemSeqNumber = fileSystemSeqNumber;
        this.fileDate = fileDate;
        this.serviceId = serviceId;
        this.subServiceId = subServiceId;
        this.originatingMemberId = originatingMemberId;
        this.validationCode = validationCode;
        this.filename = filename;
        this.fileContentType = fileContentType;
        this.fileDirection = fileDirection;
        this.environment = environment;
        this.recordLength = recordLength;
    }

    public Long getFileSystemSeqNumber() {
        return fileSystemSeqNumber;
    }

    public String getFileDate() {
        return fileDate;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getSubServiceId() {
        return subServiceId;
    }

    public String getOriginatingMemberId() {
        return originatingMemberId;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public String getFilename() {
        return filename;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public String getFileDirection() {
        return fileDirection;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getRecordLength() {
        return recordLength;
    }

    public Integer getOriginatorFullCode() {
        return originatorFullCode;
    }

    public void setOriginatorFullCode(Integer originatorFullCode) {
        this.originatorFullCode = originatorFullCode;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(boolean isValid) {
        this.processStatus = isValid ? "C" : "R";
    }

    @Override
    public String toString() {
        String s = "01" +
                StringUtils.format(filename.trim() + fileDate.trim(), 30, ' ', Justification.LEFT) +
                format(serviceId.trim(), 4, ' ',Justification.LEFT) +
                format(subServiceId.trim(), 10, ' ',Justification.LEFT) +
                format(originatingMemberId.trim(), 4, ' ',Justification.LEFT) +
                format("" + fileSystemSeqNumber, 10, ' ',Justification.RIGHT) +
                format("" + Counter.numberOfRecs, 11, ' ',Justification.RIGHT) +
                format("" + Counter.numberOfDebits, 11, ' ',Justification.RIGHT) +
                format("" + Counter.numberOfCredits, 11, ' ',Justification.RIGHT) +
                format("" + Counter.debitValue, 11, ' ',Justification.RIGHT) +
                format("" + Counter.creditValue, 11, ' ',Justification.RIGHT) +
                format("" + Counter.numberOfRejectedDebits, 11, ' ',Justification.RIGHT) +
                format("" + Counter.numberOfRejectedCredits, 11, ' ',Justification.RIGHT) +
                format("" + Counter.debitRejectedValue, 11, ' ',Justification.RIGHT) +
                format("" + Counter.creditRejectedValue, 11, ' ',Justification.RIGHT) +
                processStatus;
        return s;
    }
}
