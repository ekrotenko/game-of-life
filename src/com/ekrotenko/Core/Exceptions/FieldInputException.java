package com.ekrotenko.Core.Exceptions;

/**
 * Created by Eugene on 13.01.2017.
 */
public class FieldInputException extends Exception {

    public FieldInputException(Throwable ex){
        super(ex);
    }

    public FieldInputException(String message){
        super(message);
    }
}
