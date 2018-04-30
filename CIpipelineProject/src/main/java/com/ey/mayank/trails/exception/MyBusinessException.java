package com.ey.mayank.trails.exception;

public class MyBusinessException extends Exception {
	/**
	 * Serial Id
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor taking the error message.
	 * 
	 * @param errorMessage
	 *            - The error message.
	 */
	public MyBusinessException(String errorMessage) {
		super(errorMessage);
	}
	/**
	 * Constructor taking the error message.
	 * 
	 * @param errorMessage
	 *            - The error message.
	 * @param throwable
	 *            - The {@link Throwable} instance to wrap.    
	 */
	public MyBusinessException(Throwable throwable) {
        super(throwable);
    }
}
