package com.bsva.dmcs.file.reports;


/**
 * @author AugustineA
 *
 */
public class TaxRegNumber {
	private String taxNumber;
	private String number;
	private String regNumber;
	private String companyRegNumber;
	
	
	public TaxRegNumber() {
		super();
	}
	public TaxRegNumber(String taxNumber, String number, String regNumber,
			String companyRegNumber) {
		super();
		this.taxNumber = taxNumber;
		this.number = number;
		this.regNumber = regNumber;
		this.companyRegNumber = companyRegNumber;
	}
	public String getTaxNumber() {
		return taxNumber;
	}
	public String getNumber() {
		return number;
	}
	public String getRegNumber() {
		return regNumber;
	}
	public String getCompanyRegNumber() {
		return companyRegNumber;
	}
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public void setCompanyRegNumber(String companyRegNumber) {
		this.companyRegNumber = companyRegNumber;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(taxNumber == null ? padLeft(" ",21) : padLeft(taxNumber,21));
		builder.append(number == null ? padLeft(" ",11) : padLeft(number,11));
		builder.append(regNumber == null ? padLeft(" ",29) : padLeft(regNumber,29));
		builder.append(companyRegNumber == null ? padLeft(" ",15) : padLeft(companyRegNumber,15));
		return builder.toString();
	}
	
	/**
	* @param s
	* @param n
	* @return
	*/
	public static String padLeft(String s, int n) {
			    return String.format("%1$" + n + "s", s);
		   }

}
