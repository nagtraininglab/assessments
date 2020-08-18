package com.example.demo.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statement")
public class Txn {

	
	
	private String toaccnum;
	private String fromaccnum;
	private double amount;
	@Id
	private String localdatetime;
	private String remarks;
	private String localdatetime_month;
	private String localdatetime_day;

	public Txn(String toaccnum, String fromaccnum, double amount, String localdatetime, String remarks,
			String localdatetime_month, String localdatetime_day) {
		super();
		this.toaccnum = toaccnum;
		this.fromaccnum = fromaccnum;
		this.amount = amount;
		this.localdatetime = localdatetime;
		this.remarks = remarks;
		this.localdatetime_month = localdatetime_month;
		this.localdatetime_day = localdatetime_day;
	}
		
		public Txn() {
		}
	
	
	@Override
	public String toString() {
		return "Txn [toAccNum=" + toaccnum + ", fromAccNum=" + fromaccnum + ", amount=" + amount +
				"localdatetime=" + localdatetime + ", remarks=" + remarks 
						+ ", localdatetime_month=" + localdatetime_month + 
						", localdatetime_day=" + localdatetime_day + " ]";
	}


	public String getToAccNum() {
		return toaccnum;
	}

	public void setToAccNum(String toaccnum) {
		this.toaccnum = toaccnum;
	}
	
	public String getFromAccNum() {
		return fromaccnum;
	}

	public void setFromAccNum(String fromaccnum) {
		this.fromaccnum = fromaccnum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public static String getLocalDateTime() {
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Date date = new Date();
		 return dateFormat.format(date);
	}
	
	public  String getLocalDateTimedb() {
		return localdatetime;
	}

	public void setLocalDateTime(String localdatetime) {
		this.localdatetime = localdatetime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public static String getLocalDateTime_Month() {
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Date date = new Date();
		 return dateFormat.format(date).substring(5,7);
	}
	
	public static String getLocalDateTime_Day() {
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Date date = new Date();
		 return dateFormat.format(date).substring(8,10);
	}
	
	public  String getLocalDateTime_Daydb() {
		 return localdatetime_day;
	}
	
	public void setLocalDateTime_Day(String localdatetime_day) {
		this.localdatetime_day = localdatetime_day;
	}

}