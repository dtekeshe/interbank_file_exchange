package com.bsva.dmcs.reportv02.dto;

public class PrintAllMnemonicnameDto {

	private String bankMnemonic;
	private String name;
	
	public String getBankMnemonic() {
		return bankMnemonic;
	}
	public String getName() {
		return name;
	}

	public void setBankMnemonic(String bankMnemonic) {
		this.bankMnemonic = bankMnemonic;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(System.lineSeparator());
		builder.append(bankMnemonic == null ? "" : padRight("",12)+padRight(bankMnemonic + "   /",8));
		builder.append(name == null ? "" : rightPadding("",5)+rightPadding(name,25));
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
	   return String.format("%0$"+ n +"s", s);
	}
	
	/**
	 * @param s
	 * @param n
	 * @return
	 */
	public static String paddingLeft(String s, int n) {
	   return String.format("%1$"+ n + "s", s);
	}
	
}
