package com.bsva.dmcs.reportv02.dto;

import com.bsva.dcms.commons.util.StringUtil;

public class MonthEndReportDTO {
	
	private String month;
	private String valueAbove;
	private String valueBelow;
	private String volumeAbove;
	private String volumeBelow;
	private String chargeAbove;
	private String chargeBelow;
	private String totalCharge;
	private String tieredItemChargeAbove;
	private String tieredItemChargeBelow;
	private String MnemonicMemberName;
	private String subService;
	private String cardDescription;
	private String product;
	private String priceBelow;
	private String priceAbove;
	private String total;
	
	public MonthEndReportDTO(){
		
	}

	public String getPriceBelow() {
		return priceBelow;
	}

	public String getTotal() {
		return total;
	}

	public void setPriceBelow(String priceBelow) {
		this.priceBelow = priceBelow;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getMonth() {
		return month;
	}

	public String getValueAbove() {
		return valueAbove;
	}

	public String getValueBelow() {
		return valueBelow;
	}

	public String getVolumeAbove() {
		return volumeAbove;
	}

	public String getVolumeBelow() {
		return volumeBelow;
	}

	public String getChargeAbove() {
		return chargeAbove;
	}

	public String getChargeBelow() {
		return chargeBelow;
	}

	public String getTotalCharge() {
		return totalCharge;
	}

	public String getTieredItemChargeAbove() {
		return tieredItemChargeAbove;
	}

	public String getTieredItemChargeBelow() {
		return tieredItemChargeBelow;
	}

	public String getMnemonicMemberName() {
		return MnemonicMemberName;
	}

	public String getSubService() {
		return subService;
	}

	public String getCardDescription() {
		return cardDescription;
	}

	public String getProduct() {
		return product;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setValueAbove(String valueAbove) {
		this.valueAbove = valueAbove;
	}

	public void setValueBelow(String valueBelow) {
		this.valueBelow = valueBelow;
	}

	public void setVolumeAbove(String volumeAbove) {
		this.volumeAbove = volumeAbove;
	}

	public void setVolumeBelow(String volumeBelow) {
		this.volumeBelow = volumeBelow;
	}

	public void setChargeAbove(String chargeAbove) {
		this.chargeAbove = chargeAbove;
	}

	public void setChargeBelow(String chargeBelow) {
		this.chargeBelow = chargeBelow;
	}

	public void setTotalCharge(String totalCharge) {
		this.totalCharge = totalCharge;
	}

	public void setTieredItemChargeAbove(String tieredItemChargeAbove) {
		this.tieredItemChargeAbove = tieredItemChargeAbove;
	}

	public void setTieredItemChargeBelow(String tieredItemChargeBelow) {
		this.tieredItemChargeBelow = tieredItemChargeBelow;
	}

	public void setMnemonicMemberName(String mnemonicMemberName) {
		MnemonicMemberName = mnemonicMemberName;
	}

	public void setSubService(String subService) {
		this.subService = subService;
	}

	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getPriceAbove() {
		return priceAbove;
	}

	public void setPriceAbove(String priceAbove) {
		this.priceAbove = priceAbove;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(month == null ? "" : rightPadding(month,8));
		builder.append(",");
		builder.append(product == null ? "" : rightPadding(product,5));
		builder.append(",");
		builder.append(MnemonicMemberName == null ? "" : rightPadding(MnemonicMemberName,6));
		builder.append(",");
		builder.append(subService == null ? "" : rightPadding(subService,10));
		builder.append(",");
		builder.append(cardDescription == null ? "" : rightPadding(cardDescription,30));
		builder.append(",");
		builder.append(volumeBelow == null ? "" : leftPadZeros(volumeBelow,15));
		builder.append(",");
		builder.append(valueBelow == null ? "" : leftPadZeros(valueBelow,18));
		builder.append(",");
		builder.append(volumeAbove == null ? "" : leftPadZeros(volumeAbove,15));
		builder.append(",");
		builder.append(valueAbove == null ? "" : leftPadZeros(valueAbove,18));
		builder.append(",");
		builder.append(tieredItemChargeAbove == null ? "" : leftPadZeros(tieredItemChargeAbove,12));
		builder.append(",");
		builder.append(tieredItemChargeBelow == null ? "" : leftPadZeros(tieredItemChargeBelow,12));
		builder.append(",");
		builder.append(priceBelow == null ? leftPadZeros("0",15) : leftPadZeros(priceBelow,15));
		builder.append(",");
		builder.append(priceAbove == null ? leftPadZeros("0",8) : leftPadZeros(priceAbove,8));
		builder.append(",");
		builder.append(totalCharge == null ? leftPadZeros("0",15) : leftPadZeros(totalCharge,15));
		builder.append(System.lineSeparator());
		return builder.toString();
	}
	
	/**
	 * @param s
	 * @param n
	 * @return
	 */
	public static String padRight(String s, int n) {
		return String.format("%1$" + n + "s", s);
	}

	/**
	 * @param str
	 * @param num
	 * @return
	 */
	public static String rightPadding(String str, int num) {
		return String.format("%1$-" + num + "s", str);
	}

	/**
	 * @param str
	 * @param num
	 * @return
	 */
	public static String leftPadZeros(String str, int num) {
		return String.format("%1$" + num + "s", str).replace(' ', '0');
	}

	/**
	 * @param str
	 * @param num
	 * @return
	 */
	public static String rightPadZeros(String str, int num) {
		return String.format("%1$-" + num + "s", str).replace(' ', '0');
	}

	/**
	 * @param s
	 * @param n
	 * @return
	 */
	// used to format String for FileWriter
	public static String padLeftString(String s, int n) {
		return String.format("%0$" + n + "s", s).replace(' ', '0');
	}


}
