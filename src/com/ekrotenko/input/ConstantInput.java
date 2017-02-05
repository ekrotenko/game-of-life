package com.ekrotenko.input;

import com.ekrotenko.Core.*;

/**
 * Created by Eugene on 15.12.2016.
 */
public class ConstantInput implements FieldInput {
    private int colSize;
    private int rowSize;
    boolean isClosed;



    public ConstantInput(int colSize, int rowSize, boolean isClosed){
        this.colSize=colSize;
        this.rowSize=rowSize;
        this.isClosed=isClosed;
    }

    public ConstantInput(int size, boolean isClosed){
        this(size,size, isClosed);
    }

    public Field getField(){
        boolean[][] startField = new boolean[colSize][rowSize];
        startField[0][1] = true;
        startField[1][2] = true;
        startField[2][2] = true;
        startField[2][0] = true;
        startField[2][1] = true;
        FieldStrategy str = (isClosed)? new ClosedField(): new OpenedField();
        return new Field(startField, str, PatternType.NOTSELECTED);
    }
}
