package com.ullgren.dcmsgboard4j;

public class BoardException extends RuntimeException {

	private static final long serialVersionUID = -6039465720501724258L;

	public BoardException() {
		super();
	}

	public BoardException(String message, Throwable cause) {
		super(message, cause);
	}

	public BoardException(String message) {
		super(message);
	}

	public BoardException(Throwable cause) {
		super(cause);
	}
}
