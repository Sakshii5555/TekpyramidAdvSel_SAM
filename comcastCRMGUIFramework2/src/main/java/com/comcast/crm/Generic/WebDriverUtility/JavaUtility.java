package com.comcast.crm.Generic.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int randomNum() {
		Random ran = new Random();
		int random_Num = ran.nextInt(500);
		return random_Num;
	}
	
	public String SystemCurrentDate_yyyyMMdd() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String current_date = sdf.format(date);
		return current_date;
	}
	
	public String requiredDate(int days) {		
		Date dObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startdate = sdf.format(dObj);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String requiredDaysDate = sdf.format(cal.getTime());
		return requiredDaysDate;		
	}
	
	public String timeStampforSSFileName()
	{
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		return time;
	}
}
