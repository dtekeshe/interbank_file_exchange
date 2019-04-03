package com.bsva.dcms.commons.util;

import java.util.Arrays;

/**
 * @author Mbonin
 *
 */
public class StringUtil {
	
	
	public final static String ZERO_STRING = "0";
	public final static String SPACE_STRING = " ";
	public final static String DASH_STRING = "-";
	
	/**
	 * Pads a string to the right
	 * @param source - a String to be padded
	 * @param filler - characters to pad the string with
	 * @param length - length of the string after padding
	 * @return - a padded string
	 */
	public static String rightJustify(String source, String filler, int length) {
		// first find out if the string(accountNumber) coming in is longer than
		// the length specified
		if (source == null )
			source = "";
		source = source.trim();
		if (source.length() > length)
			return source.substring(source.length() - length, source.length());

		int len = source.length();
		if (filler.length() > 1)
			filler = filler.substring(0, 1);
		String temp = new String();
		for (int i = 0; i < length - len; i++) {
			temp = temp + filler;
		}
		temp = temp + source;
		return temp.substring(0, length);
	}
	
	/**
	 * Pads a string to the left
	 * @param source - a String to be padded
	 * @param filler - characters to pad the string with
	 * @param length - length of the string after padding
	 * @return - a padded string
	 */
	public static String leftJustify(String source, String filler, int length) {
		
		if (source == null)
			source = "";
		if (source.isEmpty()) {
			if (length > 0) {
				char[] array = new char[length];
				Arrays.fill(array, 0, length, filler.charAt(0));
				source = new String(array);
				return source;
			} else {
				return "";
			}
		}

		source = source.trim();
		if (source.length() > length)
			return source.trim().substring(0, length);

		int len = source.length();
		if (filler.length() > 1)
			filler = filler.substring(0, 1);

		String temp = new String(source);
		for (int i = 0; i < length - len; i++) {
			temp = temp + filler;
		}
		return temp.substring(0, length);
	}

	/**
	 * remove all the white space characters on the left side of the string
	 * @param stringToBeTrimmed
	 * @return - a trimmed string
	 */
	public static String leftTrim(String stringToBeTrimmed){
		
		return stringToBeTrimmed.replaceAll("^\\s+","");


	}
	
	
}


