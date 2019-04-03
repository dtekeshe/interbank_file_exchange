package com.bsva.dto;

public class TxnGroupTotalDTO {

	private Long volume;
	private Double tranValue;
	private Double billingFee;
	private Double billingFeeAmount;
	private Double billingVAT;
	
	public TxnGroupTotalDTO(){
		
	}

	public Long getVolume() {
		return volume;
	}

	public Double getTranValue() {
		return tranValue;
	}

	public Double getBillingFee() {
		return billingFee;
	}

	public Double getBillingFeeAmount() {
		return billingFeeAmount;
	}

	public Double getBillingVAT() {
		return billingVAT;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public void setTranValue(Double tranValue) {
		this.tranValue = tranValue;
	}

	public void setBillingFee(Double billingFee) {
		this.billingFee = billingFee;
	}

	public void setBillingFeeAmount(Double billingFeeAmount) {
		this.billingFeeAmount = billingFeeAmount;
	}

	public void setBillingVAT(Double billingVAT) {
		this.billingVAT = billingVAT;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TxnGroupTotalDTO [volume=");
		builder.append(volume);
		builder.append(", tranValue=");
		builder.append(tranValue);
		builder.append(", billingFee=");
		builder.append(billingFee);
		builder.append(", billingFeeAmount=");
		builder.append(billingFeeAmount);
		builder.append(", billingVAT=");
		builder.append(billingVAT);
		builder.append("]");
		return builder.toString();
	}

}
