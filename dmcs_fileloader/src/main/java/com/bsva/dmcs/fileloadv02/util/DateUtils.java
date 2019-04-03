package com.bsva.dmcs.fileloadv02.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * TODO Document
 */
public class DateUtils {

	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd HHmmss");

	public final static Date dateFromMonthDay(String monthDayString, String timeString) throws ParseException {

		if (timeString.trim().length() < 6) {
			timeString = format(timeString,6);
		} else if (timeString.trim().length() >= 6) {
			timeString = timeString.trim().substring(0, 6);
		}
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		Date date = DATE_FORMAT.parse(year + monthDayString + " " + timeString);

		return today.getTime().before(date) ? DATE_FORMAT.parse((--year) + monthDayString + " " + timeString) : date;
	}

	private static String format(String timeString,int number) {
		String format =  padLeftString(timeString,number);				
		return format;
	}
	public static String padLeftString(String s, int n) {
		   return String.format("%0$"+ n +"s", s).replace(' ', '0');
	}
	
	
	
}
