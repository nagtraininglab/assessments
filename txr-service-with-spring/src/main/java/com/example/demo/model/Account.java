package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {

	@Id
	private int accounNum;
	private String num;
	private double balance;

	public Account(int accountNum, String num, double balance) {
		super();
		this.accounNum = accountNum;
		this.num = num;
		this.balance = balance;
	}

	public int getAccounNum() {
		return accounNum;
	}

	public void setAccounNum(int accounNum) {
		this.accounNum = accounNum;
	}

	public Account() {
	}

	@Override
	public String toString() {
		return "Account [num=" + num + ", balance=" + balance + "]";
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
