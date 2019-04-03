/**
 * 
 */
package com.bsva.dcms.commons.util;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author AugustineA
 *
 */
public class DateUtil {

	/**
	 * Formats date using the given patten
	 * @param date to be formatted
	 * @param formatString
	 * @return - A string representation of the date
	 * @throws ParseException
	 */
	public static String formatDate(Date date, String formatString)
			throws ParseException {

		if (date == null) {
			return null; 
		}
		  Format formatter = new SimpleDateFormat(formatString);
		 String s = formatter.format(date);

		return s;
	}
	
	/**
	 * Takes a string of a particular pattern and converts it into a date object
	 * @param dateString
	 * @param formatString
	 * @return
	 * @throws ParseException
	 */
	public static Date formatStringToDate(String dateString , String formatString) throws ParseException{
		
		DateFormat formatter = new SimpleDateFormat(formatString);
		Date formattedDate = formatter.parse(dateString);
		
		return formattedDate;
	}
	
	/**
	 * adds number of days to the parsed date
	 * @param date
	 * @param noOfDays
	 * @return 
	 * @throws ParseException
	 */
	public static Date getNextDate(Date date, int noOfDays){
		
		if (date == null) {
			return null; 
		}
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, noOfDays);
		
		return date;
	}
	/**
	 * adds number of years to the parsed date
	 * @param date
	 * @param noOfDays
	 * @return 
	 * @throws ParseException
	 */
	public static Date getNextYear(Date date, int noOfDays){
		
		if (date == null) {
			return null; 
		}
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, noOfDays);
		
		return date;
	}
	
	public static int getDayOfTheWeek(Date date){
		
		if (date == null) {
			return 0; 
		}
		
		int dayOfTheWeek = 0;
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		dayOfTheWeek = c.get(Calendar.DAY_OF_WEEK);
		
		return dayOfTheWeek;
	}

}
