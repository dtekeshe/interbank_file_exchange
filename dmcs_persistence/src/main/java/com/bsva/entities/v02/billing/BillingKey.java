package com.bsva.entities.v02.billing;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class BillingKey implements Serializable {

    @Column(name = "POS_ENTRY_MODE")
    private String posEntryMode;

    @Column(name = "CHIP_CARD")
    private String chipCard;

    @Column(name = "TERMINAL_CAPABILITY")
    private String terminalCapability;

    @Column(name = "E_COMM_IND")
    private String eCommIndicator;

    @Column(name = "CARD_PRESENT")
    private String cardPresent;

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

    public String geteCommIndicator() {
        return eCommIndicator;
    }

    public void seteCommIndicator(String eCommIndicator) {
        this.eCommIndicator = eCommIndicator;
    }

    public String getCardPresent() {
        return cardPresent;
    }

    public void setCardPresent(String cardPresent) {
        this.cardPresent = cardPresent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillingKey that = (BillingKey) o;

        if (posEntryMode != null ? !posEntryMode.equals(that.posEntryMode) : that.posEntryMode != null) return false;
        if (chipCard != null ? !chipCard.equals(that.chipCard) : that.chipCard != null) return false;
        if (terminalCapability != null ? !terminalCapability.equals(that.terminalCapability) : that.terminalCapability != null)
            return false;
        if (eCommIndicator != null ? !eCommIndicator.equals(that.eCommIndicator) : that.eCommIndicator != null)
            return false;
        return !(cardPresent != null ? !cardPresent.equals(that.cardPresent) : that.cardPresent != null);

    }

    @Override
    public int hashCode() {
        int result = posEntryMode != null ? posEntryMode.hashCode() : 0;
        result = 31 * result + (chipCard != null ? chipCard.hashCode() : 0);
        result = 31 * result + (terminalCapability != null ? terminalCapability.hashCode() : 0);
        result = 31 * result + (eCommIndicator != null ? eCommIndicator.hashCode() : 0);
        result = 31 * result + (cardPresent != null ? cardPresent.hashCode() : 0);
        return result;
    }
}
