package com.company.Core;

/**
 * Created by Eugene on 16.12.2016.
 */
public class OpenedField implements FieldStrategy{

    public int getIndex(int ind, int size){
        if (ind < 0) {
            return size - 1;
        } else if (ind >= size) {
            return 0;
        } else return ind;
    }
}
