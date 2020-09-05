package com.xyz.app.bean;

import java.time.LocalDate;
import java.util.List;

import com.xyz.app.service.BankService;


public class Transaction extends Loan{
	
	private int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}