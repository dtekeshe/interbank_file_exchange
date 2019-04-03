package com.bsva.dmcs.reportv02.dto;

/**
 * TODO Document
 */
public class TxnGroupTotalsDTO {

    private Long volume = 0L;
    private Double tranValue = 0.0;
    private Double billingFee = 0.0;
    private Double billingFeeAmount = 0.0;
    private Double billingVAT = 0.0;
    
    public TxnGroupTotalsDTO(){
    	
    }

    public Long getVolume() {
        return volume;
    }

    public void addVolume(Long volume) {
        this.volume += volume;
    }

    public Double getTranValue() {
        return tranValue;
    }

    public void addTranValue(Double tranValue) {
        this.tranValue += tranValue;
    }

    public Double getBillingFee() {
        return billingFee;
    }

    public void addBillingFee(Double billingFee) {
        this.billingFee += billingFee;
    }

    public Double getBillingFeeAmount() {
        return billingFeeAmount;
    }

    public void addBillingFeeAmount(Double billingFeeAmount) {
        this.billingFeeAmount += billingFeeAmount;
    }

    public Double getBillingVAT() {
        return billingVAT;
    }

    public void addBillingVAT(Double billingVAT) {
        this.billingVAT += billingVAT;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(volume);
		builder.append(tranValue);
		builder.append(billingFee);
		builder.append(billingFeeAmount);
		builder.append(billingVAT);
		return builder.toString();
	}
}
