package com.bsva.dmcs.reportv02.dto;

public class FileCCRMISCSVDetailReportDto {

	private String bankCode;

	private String subService;

	private String publicHolidayIndicator;

	private String productDateDelimiter;

	private String dayName;

	private String volumeDelimitedSize;

	private String issValueDelimitedSize;

	private String issTierChargeDelimitedSize;

	private String issBsvRevenueDelimitedSize;

	public FileCCRMISCSVDetailReportDto() {

	}

	public String getBankCode() {
		return bankCode;
	}

	public String getSubService() {
		return subService;
	}

	public String getPublicHolidayIndicator() {
		return publicHolidayIndicator;
	}

	public String getProductDateDelimiter() {
		return productDateDelimiter;
	}

	public String getDayName() {
		return dayName;
	}

	public String getVolumeDelimitedSize() {
		return volumeDelimitedSize;
	}

	public String getIssValueDelimitedSize() {
		return issValueDelimitedSize;
	}

	public String getIssTierChargeDelimitedSize() {
		return issTierChargeDelimitedSize;
	}

	public String getIssBsvRevenueDelimitedSize() {
		return issBsvRevenueDelimitedSize;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public void setSubService(String subService) {
		this.subService = subService;
	}

	public void setPublicHolidayIndicator(String publicHolidayIndicator) {
		this.publicHolidayIndicator = publicHolidayIndicator;
	}

	public void setProductDateDelimiter(String productDateDelimiter) {
		this.productDateDelimiter = productDateDelimiter;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public void setVolumeDelimitedSize(String volumeDelimitedSize) {
		this.volumeDelimitedSize = volumeDelimitedSize;
	}

	public void setIssValueDelimitedSize(String issValueDelimitedSize) {
		this.issValueDelimitedSize = issValueDelimitedSize;
	}

	public void setIssTierChargeDelimitedSize(String issTierChargeDelimitedSize) {
		this.issTierChargeDelimitedSize = issTierChargeDelimitedSize;
	}

	public void setIssBsvRevenueDelimitedSize(String issBsvRevenueDelimitedSize) {
		this.issBsvRevenueDelimitedSize = issBsvRevenueDelimitedSize;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(bankCode == null ? "" : leftPadZeros(bankCode, 4));
		builder.append(",");
		builder.append(subService == null ? "" : rightPadding(subService, 10));
		builder.append(",");
		builder.append(publicHolidayIndicator == null ? "" : rightPadding(publicHolidayIndicator, 1));
		builder.append(",");
		builder.append(productDateDelimiter == null ? "" : rightPadding(productDateDelimiter, 8));
		builder.append(",");
		builder.append(dayName == null ? "" : rightPadding(dayName, 10));
		builder.append(",");
		builder.append(volumeDelimitedSize == null ? "" : leftPadZeros(volumeDelimitedSize, 9));
		builder.append(",");
		builder.append(issValueDelimitedSize == null ? "" : padRight(issValueDelimitedSize, 22));
		builder.append(",");
		builder.append(issTierChargeDelimitedSize == null ? "" : padRight(issTierChargeDelimitedSize,9));
		builder.append(",");
		builder.append(issBsvRevenueDelimitedSize == null ? "" : padRight(issBsvRevenueDelimitedSize, 14));
		builder.append(System.lineSeparator());
		return builder.toString();
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
	public static String rightPadding(String str, int num) {
		return String.format("%1$-" + num + "s", str);
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
	 * @param s
	 * @param n
	 * @return
	 */
	public static String padLeftString(String s, int n) {
		return String.format("%0$" + n + "s", s);
	}

	/**
	 * @param s
	 * @param n
	 * @return
	 */
	public static String paddingLeft(String s, int n) {
		return String.format("%1$" + n + "s", s);
	}

}
