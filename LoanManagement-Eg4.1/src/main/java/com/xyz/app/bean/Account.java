package com.xyz.app.bean;

public class Account {
	private String accountId;
	private String accountName;
	private Address address;
	private int depositAmount;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String accountId, String accountName, Address address, int depositAmount) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.address = address;
		this.depositAmount = depositAmount;
	}

	
	
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", address=" + address
				+ ", depositAmount=" + depositAmount + "]";
	}
	
	
	public String getDetails() {
		return getAccountName()+" "+getAccountId()+" "+getAddress().getCity()+" "+getAddress().getState()+" "+getDepositAmount();
	}
	
	public void shpowDetails() {
		System.out.println("Account Name :"+getAccountName());
		System.out.println("Account Id : "+getAccountId());
		System.out.println("Address : "+getAddress().getCity()+" "+getAddress().getState());
		System.out.println("Deposit Amount :"+getDepositAmount());
	}
	
}
