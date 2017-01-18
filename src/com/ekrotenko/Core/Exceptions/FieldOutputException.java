package com.ekrotenko.Core.Exceptions;

/**
 * Created by Eugene on 13.01.2017.
 */
public class FieldOutputException extends Exception{
    public FieldOutputException(Throwable ex){
        super(ex);
    }

    public FieldOutputException(String message){
        super(message);
    }
}
