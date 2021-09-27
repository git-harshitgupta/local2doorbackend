package com.app.local2door.custom_excpt;

public class EmailExistException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailExistException(String msg){
        super(msg);
    }
}