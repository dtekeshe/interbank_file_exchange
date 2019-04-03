package com.bsva.dmcs.settlement.utils;

import java.text.Format;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author AugustineA
 *
 */
public class SettleUtil {

	public static String leftJustifyWithZeros(String s, int length) {
	     if (s.length() >= length) return s;
	     else return String.format("%0" + (length-s.length()) + "d%s", 0, s);
	}

	public static String leftJustifyWithSpaces(String s, int length) {
	     if (s.length() >= length) return s;
	     else return String.format("%"+ (length-s.length()) +"s", s);
	}

	public static String doubleToStringCommaReplacer(Long l) {

	     return String.format("%.2f", l).replace(".", "");
	}

	public static String getTime(){

       Date date = new Date();
		  Format formatter = new SimpleDateFormat("HH:mm:ss");
		 String s = formatter.format(date);

		 String[] splist =s.split(":");

		 String hour = splist[0];
		 String minutes = splist[1];
		 String seconds = splist[2];

		 return leftJustifyWithZeros(hour,2) + minutes + seconds;
	}

}
