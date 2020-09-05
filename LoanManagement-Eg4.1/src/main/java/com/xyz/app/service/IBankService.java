package com.xyz.app.service;

import com.xyz.app.bean.Account;
import com.xyz.app.bean.Loan;

public interface IBankService {
		
	public boolean validateAccountId(String id);
	public boolean validateAccountName(String name);
	
	public int depositAmount(String accId,int amt);
	public int withdrawAmount(String accId,int amt);
	public Account showAccountDetails(String accountNo);
	public void createAccount(Account account);
	
	public int getLoan(String loanId,int lamt);
	public int payLoan(String loanId,int lamt);
	public Loan showLoanDetails(String loanId);
	
}
