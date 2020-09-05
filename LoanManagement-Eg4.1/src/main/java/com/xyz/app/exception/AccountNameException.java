package com.xyz.app.exception;

public class AccountNameException extends Exception {

	public String getMessage() {
		return "Enter valid account Name";
	}

}