package com.xyz.app.exception;

public class AccountIDException extends Exception {
	public String getMessage() {
		return "Enter valid account ID";
	}

}