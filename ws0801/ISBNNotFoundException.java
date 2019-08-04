package com.ssafy.edu.ws;

public class ISBNNotFoundException extends Exception {

	public ISBNNotFoundException() {
		super("isbn이 없습니다.");
	}

	public ISBNNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ISBNNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ISBNNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ISBNNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
