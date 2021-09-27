package com.app.local2door.custom_excpt;

public class NumberAlreadyInUseException extends RuntimeException{
    public NumberAlreadyInUseException(String msg){
        super(msg);
    }
}
