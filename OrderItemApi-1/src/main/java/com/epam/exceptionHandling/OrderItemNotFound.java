package com.epam.exceptionHandling;

public class OrderItemNotFound extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderItemNotFound(String mesg) {
		super(mesg);
	}

}
