package com.app.local2door.custom_excpt;

public class SamePasswordException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SamePasswordException(String msg){
        super(msg);
    }
}
