package com.bsva.dmcs.reports;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author SimphiweT
 */
public class CSRMISPojo {
    
    private String subService;
    private String bankCode;
    private String memberName;
    
    private Date processDate;
    private String service;
    private int volume;
    private BigDecimal value;
    private short issuingMember;
    private int volumeAbove;
    private BigDecimal valueAbove;
    private int volumeBelow;
    private BigDecimal valueBelow;

    public String getSubService() {
        return subService;
    }

    public void setSubService(String subService) {
        this.subService = subService;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public short getIssuingMember() {
        return issuingMember;
    }

    public void setIssuingMember(short issuingMember) {
        this.issuingMember = issuingMember;
    }

    public int getVolumeAbove() {
        return volumeAbove;
    }

    public void setVolumeAbove(int volumeAbove) {
        this.volumeAbove = volumeAbove;
    }

    public BigDecimal getValueAbove() {
        return valueAbove;
    }

    public void setValueAbove(BigDecimal valueAbove) {
        this.valueAbove = valueAbove;
    }

    public int getVolumeBelow() {
        return volumeBelow;
    }

    public void setVolumeBelow(int volumeBelow) {
        this.volumeBelow = volumeBelow;
    }

    public BigDecimal getValueBelow() {
        return valueBelow;
    }

    public void setValueBelow(BigDecimal valueBelow) {
        this.valueBelow = valueBelow;
    }
    
    
    
    
}
