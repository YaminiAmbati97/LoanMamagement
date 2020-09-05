package com.xyz.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.xyz.app.bean.Account;
import com.xyz.app.bean.Loan;
import com.xyz.app.bean.Transaction;

public class BankDAO implements IBankDAO{

	Transaction[] accounts = new Transaction[10];
	private static int i = 0;
	int amount = 0;
	static int loanBal = 0;

	@Override
	public int depositAmount(String accId, int amt) {
		
		for(Account acc : accounts) {
			if(acc.getAccountId().equals(accId)) {
				amount = acc.getDepositAmount()+amt;
				acc.setDepositAmount(acc.getDepositAmount()+amt);
				System.out.println("Deposit succesful");
				break;
			}
		}
		return amount;
	}

	@Override
	public int withdrawAmount(String accId, int amt) {
		// TODO Auto-generated method stub
		for(Account ac : accounts) {
			if(ac.getAccountId().equals(accId)) {
				amount = ac.getDepositAmount()-amt;
				ac.setDepositAmount(ac.getDepositAmount()+amt);
				System.out.println("Withdraw succesful");
				break;
			}
		}
		return amount;
	}

	@Override
	public Account showAccountDetails(String accountNo) {
		for(Account acc : accounts) {
			if(acc.getAccountId().equals(accountNo)) {
				return acc;
			}
		}
		return null;
	}

	@Override
	public void createAccount(Account account) {
		if(i<9)
			accounts[i++]=(Transaction) account;
		else
			System.out.println("Array size full");
		
	}

	@Override
	public int getLoan(String loanId, int lamt) {
		// TODO Auto-generated method stub
		
		for(Loan l : accounts) {
			if(l.getLoanId().equals(loanId)) {
				loanBal = l.getLoanAmount()+lamt;
				l.setLoanAmount(l.getLoanAmount()+lamt);
				break;
			}
		}
		return loanBal;
	}

	@Override
	public Loan showLoanDetails(String loanId) {
		for(Loan l : accounts) {
			if(l.getLoanId().equals(loanId)) {
				return l;
			}
		}return null;
	}

	@Override
	public int payLoan(String loanId, int lamt) {
		
		for(Loan l : accounts) {
			if(l.getLoanId().equals(loanId)) {
				loanBal = l.getLoanAmount()-lamt;
				l.setLoanAmount(loanBal);
				break;
			}
		}
		return loanBal;
		
	}

	

}
	
