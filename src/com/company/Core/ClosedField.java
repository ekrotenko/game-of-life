package com.company.Core;

/**
 * Created by Eugene on 16.12.2016.
 */
public class ClosedField implements FieldStrategy {

    public int getIndex(int ind, int size){
        return (ind<0 || ind>=size)? -1: ind;
    }
}
