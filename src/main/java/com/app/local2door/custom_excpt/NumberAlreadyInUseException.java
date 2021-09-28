package com.app.local2door.custom_excpt;

public class NumberAlreadyInUseException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NumberAlreadyInUseException(String msg){
        super(msg);
    }
}
