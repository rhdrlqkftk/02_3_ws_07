package com.ssafy.edu.ws;

public class QuantityException extends Exception {

	public QuantityException() {
		super("수량이 부족해요!!");
	}

	public QuantityException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public QuantityException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public QuantityException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public QuantityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
