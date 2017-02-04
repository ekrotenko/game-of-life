package com.ekrotenko.input;

import com.ekrotenko.Core.Exceptions.FieldInputException;
import com.ekrotenko.Core.Field;

/**
 * Created by Eugene on 15.12.2016.
 */
public interface FieldInput {
    public Field getField() throws FieldInputException;
}
