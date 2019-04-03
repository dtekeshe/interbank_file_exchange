package com.bsva.dcms.commons.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bsva.dcms.commons.dao.CsfPublicHolidaysDAO;
import com.bsva.dcms.commons.dto.CsfPublicHolidaysDTO;

public class TestBusinessDay {
	
	public static void main(String[] args) throws ParseException{
		
		     Date date = new Date();
		 
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date date1 = sdf.parse("2016-10-18 ");
	        Date date2 = sdf.parse("2016-10-17");
	    	boolean check = isValidBusinessDate(date2);
		
		System.out.println("Check if is a Business date " + check);
        
        /*if(date1.compareTo(date2) > 0){
        	System.out.println("True date 1 is greater");
        }*/
		
	}
	
	public static boolean isValidBusinessDate(Date date){
		
		//saturday or sunday
		if (date.getDay() == 6 || date.getDay() == 0){
			return false;
		}
		
		//check if date is a public holiday
		try{
			CsfPublicHolidaysDTO publicHol = new CsfPublicHolidaysDTO();
			publicHol.setProcessDate(date);
			CsfPublicHolidaysDAO publicHolDao = new CsfPublicHolidaysDAO();
			CsfPublicHolidaysDTO csfPublicHolidaysDto  = publicHolDao.retrieve(publicHol);
			
			if (csfPublicHolidaysDto == null || csfPublicHolidaysDto.getPublicHolidayIndicator().equals("N"))
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}


}
