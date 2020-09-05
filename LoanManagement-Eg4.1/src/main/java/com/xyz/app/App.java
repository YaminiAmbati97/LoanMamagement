package com.xyz.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.xyz.app.bean.Account;
import com.xyz.app.bean.Address;
import com.xyz.app.bean.Loan;
import com.xyz.app.bean.Transaction;
import com.xyz.app.exception.AccountIDException;
import com.xyz.app.exception.AccountNameException;
import com.xyz.app.service.BankService;
import com.xyz.app.service.IBankService;

public class App {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws AccountIDException ,AccountNameException{

		Transaction transaction = null;

		IBankService service = null;

		service = new BankService();

		while (true) {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("select a option and press enter");
			System.out.println("_______________________________");
			System.out.println("1.Create Account");
			System.out.println("2.Deposit");
			System.out.println("3.WithDraw");
			System.out.println("4.AccountDetails");
			System.out.println("5.GetLoan");
			System.out.println("6.PayLoan");
			System.out.println("7.Loan Details");
			System.out.println("8.Exit");
			System.out.println("_______________________________");

			switch (scan.nextInt()) {
			case 1:
				transaction = new Transaction();
				while (true) {
					System.out.println("Enter account Id");
					String accId = scan.next();
					if (service.validateAccountId(accId)) {
						transaction.setAccountId(accId);
						break;
					} else {
						//System.out.println("account Number is not in valid format");
						//return;
						throw new AccountIDException();
					}
				}
				while (true) {
					System.out.println("Enter name");
					String uname = scan.next();
					if (service.validateAccountName(uname)) {
						transaction.setAccountName(uname);
						break;
					} else {
						//System.out.println("Name is not in valid format");
						//return;
						throw new AccountNameException();
					}
				}

				System.out.println("Enter City ");
				String city = scan.next();
				System.out.println("Enter State ");
				String state = scan.next();
				Address address = new Address(state, city);
				transaction.setAddress(address);

				System.out.println("Enter deposit amount");
				transaction.setDepositAmount(scan.nextInt());

				System.out.println(" Applying Loans...");
				System.out.println("1 for Yes \n 2 for No :");
				int ch = scan.nextInt();
				if (ch == 1) {
					System.out.println("Enter loanId");
					transaction.setLoanId(scan.next());

					System.out.println("Enter loan Type \n Home\t Car \t  Education");
					System.out.println("Loan Type must be any of three");
					transaction.setLoanType(scan.next());

					System.out.println("Enter loan amount");
					transaction.setLoanAmount(scan.nextInt());

				}
				System.out.println("Account is created");
				service.createAccount(transaction);
				break;

			case 2:
				System.out.println("Enter accountId :");
				String accId = scan.next();
				if(service.validateAccountId(accId)) {
					System.out.println("Enter amount :");
					int amt = scan.nextInt();
					int bal = service.depositAmount(accId, amt);
					System.out.println("New balance :" + bal);
				}
				else {
					throw new AccountIDException();
				}
				
				break;

			case 3:
				System.out.println("Enter accountId :");
				String accIdw = scan.next();
				if(service.validateAccountId(accIdw)) {
					System.out.println("Enter amount :");
					int amtw = scan.nextInt();
					int balw = service.withdrawAmount(accIdw, amtw);
					System.out.println("New balance :" + balw);
				}else {
					throw new AccountIDException();
				}
				
				break;

			case 4:
				System.out.println("Enter AccountId :");
				String acnt = scan.next();
				if(service.validateAccountId(acnt)) {
					Account act = service.showAccountDetails(acnt);
					if (act != null) {
						System.out.println(act);
						break;
					} else {
						System.out.println("Not found");
						break;
					}
				}else {
					throw new AccountIDException();
				}
				

			case 5:
				System.out.println("Enter amount of loan: ");
				int lamt = scan.nextInt(); 
				System.out.println("Enter loanId : ");
				String lid = scan.next();
				int lbal = service.getLoan(lid, lamt);
				System.out.println(lbal + " loan amount got");
				break;

			case 6:
				System.out.println("Enter amount : ");
				int plamt = scan.nextInt();
				System.out.println("Enter loanId : ");
				String plid = scan.next();
				int plbal = service.payLoan(plid, plamt);
				System.out.println("paid loan amount " + plbal);
				break;

			case 7:
				System.out.println("Enter loanId : ");
				String lId = scan.next();
				Loan loan = service.showLoanDetails(lId);
				if (loan != null)
					System.out.println("Loan Id =" + loan.getLoanId() + " Loan type = " + loan.getLoanType()
							+ " Loan Amount = " + loan.getLoanAmount());
				else
					System.out.println("loanId not matched");

				break;

			case 8:
				System.out.println("Thank you!");
				break;
			}
		}

	}

}
