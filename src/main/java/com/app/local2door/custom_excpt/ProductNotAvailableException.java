package com.app.local2door.custom_excpt;

public class ProductNotAvailableException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotAvailableException(String msg){
        super(msg);
    }
}
