package com.ekrotenko.output;

import com.ekrotenko.Core.Exceptions.FieldOutputException;
import com.ekrotenko.Core.Field;

import java.io.IOException;

/**
 * Created by Eugene on 15.12.2016.
 */
public interface FieldOutput {
    public void sendField(Field field) throws FieldOutputException;
}
