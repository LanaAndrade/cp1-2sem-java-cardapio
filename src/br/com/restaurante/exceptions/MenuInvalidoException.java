package br.com.restaurante.exceptions;

public class MenuInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuInvalidoException() {
		super();
	}

	public MenuInvalidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MenuInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public MenuInvalidoException(String message) {
		super(message);
	}

	public MenuInvalidoException(Throwable cause) {
		super(cause);
	}
	
	

}
