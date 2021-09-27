package com.app.local2door.custom_excpt;

public class ProductNotAvailableException extends RuntimeException{
    public ProductNotAvailableException(String msg){
        super(msg);
    }
}
