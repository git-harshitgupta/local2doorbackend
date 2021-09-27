package com.app.local2door.custom_excpt;

public class SamePasswordException extends RuntimeException{
    public SamePasswordException(String msg){
        super(msg);
    }
}
