package com.zarlok.webshop.exception;

public class UserExistsException extends Exception{
    public UserExistsException(String errorMessage){
        super(errorMessage);
    }
}
