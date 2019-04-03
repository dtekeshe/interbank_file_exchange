package com.bsva.dmcs.fileloadv02.model;

/**
 * POS Terminal information.
 * VISA specific
 */
public class TerminalInfo {

    private String posEntryMode = "0";
    private String terminalCapability = "0";
    private String chipCard = "0";
    private String ecommIndicator = "0";
    private String cardPresent = "0";

    public String getPosEntryMode() {
        return posEntryMode;
    }

    public void setPosEntryMode(String posEntryMode) {
        this.posEntryMode = posEntryMode;
    }

    public String getTerminalCapability() {
        return terminalCapability;
    }

    public void setTerminalCapability(String terminalCapability) {
        this.terminalCapability = terminalCapability;
    }

    public String getChipCard() {
        return chipCard;
    }

    public void setChipCard(String chipCard) {
        this.chipCard = chipCard;
    }

    public String getEcommIndicator() {
        return ecommIndicator;
    }

    public void setEcommIndicator(String ecommIndicator) {
        this.ecommIndicator = ecommIndicator;
    }

    public String getCardPresent() {
        return cardPresent;
    }

    public void setCardPresent(String cardPresent) {
        this.cardPresent = cardPresent;
    }
}
