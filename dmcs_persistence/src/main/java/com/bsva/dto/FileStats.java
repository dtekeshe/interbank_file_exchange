package com.bsva.dto;

/**
 * TODO Document
 */
public class FileStats {

    private Long acceptedDebitsVolume = 0L;
    private Double acceptedDebitsValue = 0.0;
    private Long acceptedCreditsVolume = 0L;
    private Double acceptedCreditsValue = 0.0;

    private Long rejectedDebitsVolume = 0L;
    private Double rejectedDebitsValue = 0.0;
    private Long rejectedCreditsVolume = 0L;
    private Double rejectedCreditsValue = 0.0;

    private Long acceptedFinRecCount = 0L;
    private Long rejectedFinRecCount = 0L;

    private Long acceptedNonFinRecCount = 0L;
    private Long rejectedNonFinRecCount = 0L;

    private Long acceptedNegativeCardRecCount = 0L;
    private Long rejectedNegativeCardRecCount = 0L;

    private Long acceptedControlRecCount = 0L;
    private Long rejectedControlRecCount = 0L;

    public Long getAcceptedDebitsVolume() {
        return acceptedDebitsVolume;
    }

    public void addAcceptedDebitsVolume(Long acceptedDebitsVolume) {
        if (this.acceptedDebitsVolume == null ) {
            this.acceptedDebitsVolume = 0L;
        }
        this.acceptedDebitsVolume += acceptedDebitsVolume;
    }

    public Double getAcceptedDebitsValue() {
        return acceptedDebitsValue;
    }

    public void addAcceptedDebitsValue(Double acceptedDebitsValue) {
        if (this.acceptedDebitsValue == null ) {
            this.acceptedDebitsValue = 0.00;
        }
        this.acceptedDebitsValue += acceptedDebitsValue;
    }

    public Long getAcceptedCreditsVolume() {
        return acceptedCreditsVolume;
    }

    public void addAcceptedCreditsVolume(Long acceptedCreditsVolume) {
        if (this.acceptedCreditsVolume == null ) {
            this.acceptedCreditsVolume = 0L;
        }
        this.acceptedCreditsVolume += acceptedCreditsVolume;
    }

    public Double getAcceptedCreditsValue() {
        return acceptedCreditsValue;
    }

    public void addAcceptedCreditsValue(Double acceptedCreditsValue) {
        if (this.acceptedCreditsValue == null ) {
            this.acceptedCreditsValue = 0.00;
        }
        this.acceptedCreditsValue += acceptedCreditsValue;
    }

    public Long getRejectedDebitsVolume() {
        return rejectedDebitsVolume;
    }

    public void addRejectedDebitsVolume(Long rejectedDebitsVolume) {
        if (this.rejectedDebitsVolume == null ) {
            this.rejectedDebitsVolume = 0L;
        }
        this.rejectedDebitsVolume += rejectedDebitsVolume;
    }

    public Double getRejectedDebitsValue() {
        return rejectedDebitsValue;
    }

    public void addRejectedDebitsValue(Double rejectedDebitsValue) {
        if (this.rejectedDebitsValue == null ) {
            this.rejectedDebitsValue = 0.0;
        }
        this.rejectedDebitsValue += rejectedDebitsValue;
    }

    public Long getRejectedCreditsVolume() {
        return rejectedCreditsVolume;
    }

    public void addRejectedCreditsVolume(Long rejectedCreditsVolume) {
        if (this.rejectedCreditsVolume == null ) {
            this.rejectedCreditsVolume = 0L;
        }
        this.rejectedCreditsVolume += rejectedCreditsVolume;
    }

    public Double getRejectedCreditsValue() {
        return rejectedCreditsValue;
    }

    public void addRejectedCreditsValue(Double rejectedCreditsValue) {
        if (this.rejectedCreditsValue == null ) {
            this.rejectedCreditsValue = 0.0;
        }
        this.rejectedCreditsValue += rejectedCreditsValue;
    }

    public Long getAcceptedFinRecCount() {
        return acceptedFinRecCount;
    }

    public void addAcceptedFinRecCount(Long acceptedFinRecCount) {
        if (this.acceptedFinRecCount == null ) {
            this.acceptedFinRecCount = 0L;
        }
        this.acceptedFinRecCount += acceptedFinRecCount;
    }

    public Long getRejectedFinRecCount() {
        return rejectedFinRecCount;
    }

    public void addRejectedFinRecCount(Long rejectedFinRecCount) {
        if (this.rejectedFinRecCount == null ) {
            this.rejectedFinRecCount = 0L;
        }
        this.rejectedFinRecCount += rejectedFinRecCount;
    }

    public Long getAcceptedNonFinRecCount() {
        return acceptedNonFinRecCount;
    }

    public void addAcceptedNonFinRecCount(Long acceptedNonFinRecCount) {
        if (this.acceptedNonFinRecCount == null ) {
            this.acceptedNonFinRecCount = 0L;
        }
        this.acceptedNonFinRecCount += acceptedNonFinRecCount;
    }

    public Long getRejectedNonFinRecCount() {
        return rejectedNonFinRecCount;
    }

    public void addRejectedNonFinRecCount(Long rejectedNonFinRecCount) {
        if (this.rejectedNonFinRecCount == null ) {
            this.rejectedNonFinRecCount = 0L;
        }
        this.rejectedNonFinRecCount += rejectedNonFinRecCount;
    }

    public Long getAcceptedNegativeCardRecCount() {
        return acceptedNegativeCardRecCount;
    }

    public void addAcceptedNegativeCardRecCount(Long acceptedNegativeCardRecCount) {
        this.acceptedNegativeCardRecCount += acceptedNegativeCardRecCount;
    }

    public Long getRejectedNegativeCardRecCount() {
        return rejectedNegativeCardRecCount;
    }

    public void addRejectedNegativeCardRecCount(Long rejectedNegativeCardRecCount) {
        this.rejectedNegativeCardRecCount += rejectedNegativeCardRecCount;
    }

    public Long getAcceptedControlRecCount() {
        return acceptedControlRecCount;
    }

    public void addAcceptedControlRecCount(Long acceptedControlRecCount) {
        this.acceptedControlRecCount += acceptedControlRecCount;
    }

    public Long getRejectedControlRecCount() {
        return rejectedControlRecCount;
    }

    public void addRejectedControlRecCount(Long rejectedControlRecCount) {
        this.rejectedControlRecCount += rejectedControlRecCount;
    }
}
