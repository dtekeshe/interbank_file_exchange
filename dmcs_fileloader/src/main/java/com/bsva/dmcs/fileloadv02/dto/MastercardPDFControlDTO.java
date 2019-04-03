package com.bsva.dmcs.fileloadv02.dto;

/**
 * TODO Document
 */
public class MastercardPDFControlDTO {

    // control fields
    private int currentIdx;
    private Boolean isLastElement;

    public int getCurrentIdx() {
        return currentIdx;
    }

    public void setCurrentIdx(int currentIdx) {
        this.currentIdx = currentIdx;
    }

    public Boolean getIsLastElement() {
        return isLastElement;
    }

    public void setIsLastElement(Boolean isLastElement) {
        this.isLastElement = isLastElement;
    }
}
