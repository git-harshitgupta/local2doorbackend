package com.app.local2door.custom_excpt;

public class IncorrectPasswordException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncorrectPasswordException(String msg){
        super(msg);
    }
}