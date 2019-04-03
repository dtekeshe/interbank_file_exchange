package com.bsva.dcms.commons.dto;

import java.io.Serializable;

/**
 *
 * @author SimphiweT
 */
public class CsfCardRateLookupDTO implements Serializable {
    
    private String service;
    private String subService;
    private String posEntryMode;
    private String chipCard;
    private String terminalCapability;
    private String cardPresent;
    private String eCommInd;
    private String rateDescriptor;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSubService() {
        return subService;
    }

    public void setSubService(String subService) {
        this.subService = subService;
    }

    public String getPosEntryMode() {
        return posEntryMode;
    }

    public void setPosEntryMode(String posEntryMode) {
        this.posEntryMode = posEntryMode;
    }

    public String getChipCard() {
        return chipCard;
    }

    public void setChipCard(String chipCard) {
        this.chipCard = chipCard;
    }

    public String getTerminalCapability() {
        return terminalCapability;
    }

    public void setTerminalCapability(String terminalCapability) {
        this.terminalCapability = terminalCapability;
    }

    public String getCardPresent() {
        return cardPresent;
    }

    public void setCardPresent(String cardPresent) {
        this.cardPresent = cardPresent;
    }

    public String geteCommInd() {
        return eCommInd;
    }

    public void seteCommInd(String eCommInd) {
        this.eCommInd = eCommInd;
    }

    public String getRateDescriptor() {
        return rateDescriptor;
    }

    public void setRateDescriptor(String rateDescriptor) {
        this.rateDescriptor = rateDescriptor;
    }

    
    
}
