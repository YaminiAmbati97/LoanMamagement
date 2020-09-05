package com.xyz.app.service;

import java.time.LocalDate;
import java.util.List;

import com.xyz.app.bean.Account;
import com.xyz.app.bean.Loan;
import com.xyz.app.bean.Transaction;
import com.xyz.app.dao.BankDAO;
import com.xyz.app.dao.IBankDAO;



public class BankService implements IBankService {
		
	IBankDAO bankDao=new BankDAO();
	
	@Override
	public boolean validateAccountId(String id) {
		String regexId = "^[0-9]{7}[A-Za-z]{4}$";
		return id.matches(regexId);
	}

	@Override
	public boolean validateAccountName(String name) {
		String regexName = "^[A-Z]{1}[a-z]{2,30}$";
		return name.matches(regexName);
	}

	@Override
	public int depositAmount(String accId, int amt) {
		// TODO Auto-generated method stub
		return bankDao.depositAmount(accId, amt);
	}

	@Override
	public int withdrawAmount(String accId, int amt) {
		// TODO Auto-generated method stub
		return bankDao.withdrawAmount(accId, amt);
	}

	@Override
	public Account showAccountDetails(String accountNo) {
		return bankDao.showAccountDetails(accountNo);
		
	}

	@Override
	public void createAccount(Account account) {
		bankDao.createAccount(account);
		
	}
	
	public int getLoan(String loanId,int lamt) {
		return bankDao.getLoan(loanId, lamt);
	}

	@Override
	public Loan showLoanDetails(String loanId) {
		return bankDao.showLoanDetails(loanId);
		
	}

	@Override
	public int payLoan(String loanId, int lamt) {
		return bankDao.payLoan(loanId, lamt);
	}
}

	
