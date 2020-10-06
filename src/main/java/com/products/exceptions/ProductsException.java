package com.products.exceptions;


public class ProductsException extends InternalErrorException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductsException(String message) {
        super(message);
    }

    public ProductsException(ErrorType errorType, String message) {
        super(errorType, message);
    }

    public ProductsException(ErrorType errorType, String message, Exception exception) {
        super(errorType, message, exception);
    }
}
