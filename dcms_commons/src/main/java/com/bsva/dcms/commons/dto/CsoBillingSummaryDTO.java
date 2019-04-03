package com.bsva.dcms.commons.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author SimphiweT
 */
public class CsoBillingSummaryDTO implements Serializable {
    
    private Date processDate;
    private String service;
    private int volume;
    private BigDecimal value;
    private short issuingMember;
    private int volumeAbove;
    private BigDecimal valueAbove;
    private int volumeBelow;
    private BigDecimal valueBelow;

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
