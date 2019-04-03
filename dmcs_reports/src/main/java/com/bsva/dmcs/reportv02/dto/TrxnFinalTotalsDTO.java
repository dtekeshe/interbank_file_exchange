package com.bsva.dmcs.reportv02.dto;

public class TrxnFinalTotalsDTO {

	private Long finalVolume = 0L;
    private Double finalTranValue = 0.0;
    private Double finalBillingFee = 0.0;
    private Double finalBillingFeeAmount = 0.0;
    private Double finalBillingVAT = 0.0;

    public Long getVolume() {
        return finalVolume;
    }

    public void addVolume(Long volume) {
        this.finalVolume += volume;
    }

    public Double getTranValue() {
        return finalTranValue;
    }

    public void addTranValue(Double tranValue) {
        this.finalTranValue += tranValue;
    }

    public Double getBillingFee() {
        return finalBillingFee;
    }

    public void addBillingFee(Double billingFee) {
        this.finalBillingFee += billingFee;
    }

    public Double getBillingFeeAmount() {
        return finalBillingFeeAmount;
    }

    public void addBillingFeeAmount(Double billingFeeAmount) {
        this.finalBillingFeeAmount += billingFeeAmount;
    }

    public Double getBillingVAT() {
        return finalBillingVAT;
    }

    public void addBillingVAT(Double billingVAT) {
        this.finalBillingVAT += billingVAT;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(finalVolume);
		builder.append(finalTranValue);
		builder.append(finalBillingFee);
		builder.append(finalBillingFeeAmount);
		builder.append(finalBillingVAT);
		return builder.toString();
	}
}
