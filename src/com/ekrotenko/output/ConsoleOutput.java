package com.ekrotenko.output;

import com.ekrotenko.Core.Field;

/**
 * Created by Eugene on 15.12.2016.
 */
public class ConsoleOutput implements FieldOutput {

    public void sendField(Field field) {
        for (int rowId = 0; rowId < field.getColumnSize(); rowId++) {
            for (int colId = 0; colId < field.getRowSize(); colId++) {
                if (field.getState(rowId, colId)) {
                    System.out.print("x ");
                } else
                    System.out.print(". ");
            }
            System.out.println();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
    }
}
