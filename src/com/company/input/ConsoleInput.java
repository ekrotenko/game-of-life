package com.company.input;

import com.company.Core.ClosedField;
import com.company.Core.Field;
import com.company.Core.FieldStrategy;
import com.company.Core.OpenedField;
import com.company.patterns.Patterns;

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

        boolean[][] startField = Patterns.getStartField(Integer.parseInt(console.nextLine()));
        FieldStrategy str = (isClosed)? new ClosedField(): new OpenedField();

        return new Field(startField, str);
    }
}
