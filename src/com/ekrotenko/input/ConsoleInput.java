package com.ekrotenko.input;

import com.ekrotenko.Core.ClosedField;
import com.ekrotenko.Core.Exceptions.FieldInputException;
import com.ekrotenko.Core.Field;
import com.ekrotenko.Core.FieldStrategy;
import com.ekrotenko.Core.OpenedField;
import com.ekrotenko.patterns.Patterns;

import java.util.Scanner;

/**
 * Created by Eugene on 15.12.2016.
 */
public class ConsoleInput implements FieldInput {
    private int colSize;
    private int rowSize;
    private final Scanner console = new Scanner(System.in);
    private boolean isClosed;

    public ConsoleInput(boolean isClosed) {
        this.isClosed = isClosed;
    }

    @Override
    public Field getField() {
        System.out.println("Select pattern:"); // \n означает новую строку
        System.out.println("1 - Planer");
        System.out.println("2 - Star");
        System.out.println("3 - Space Ship");
        System.out.println("\n> ");

        FieldStrategy str = (isClosed)? new ClosedField(): new OpenedField();
        try {
            boolean[][] startField = Patterns.getStartField(Integer.parseInt(console.nextLine()));
            return new Field(startField, str);
        } catch (FieldInputException ex)
        {
            ex.printStackTrace();
            return new Field(1, str);
        }


    }


}
