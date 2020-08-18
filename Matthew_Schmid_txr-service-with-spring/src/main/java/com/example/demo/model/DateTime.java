package com.example.demo.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTime {
	
	public static String getDateTime() {
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}
	
	public static String getDateTime_Month() {
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
	    String placeholder = dateFormat.format(date);
	    return placeholder.substring(5,7);
	}
	
	public static String getDateTime_Day() {
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
	    String placeholder = dateFormat.format(date);
	    return placeholder.substring(8,10);
	}
}