package com.ekrotenko.input;

import com.ekrotenko.Core.*;
import com.ekrotenko.Core.Exceptions.FieldInputException;
import com.ekrotenko.patterns.Patterns;

import java.rmi.NotBoundException;
import java.util.Scanner;

import static com.ekrotenko.patterns.Patterns.getSpaceShip;

/**
 * Created by Eugene on 15.12.2016.
 */
public class ConsoleInput implements FieldInput {
    private int colSize;
    private int rowSize;
    private final Scanner console = new Scanner(System.in);
    private boolean isClosed;
    private PatternType pattern;

    public ConsoleInput(boolean isClosed) {
        this.isClosed = isClosed;
    }

    @Override
    public Field getField() throws FieldInputException{
        System.out.println("Select pattern:"); // \n означает новую строку
        System.out.println("1 - Planer");
        System.out.println("2 - Star");
        System.out.println("3 - Space Ship");
        System.out.println("\n> ");

        FieldStrategy str = (isClosed)? new ClosedField(): new OpenedField();
        boolean[][] startField = getStartField(Integer.parseInt(console.nextLine()));
        return new Field(startField, str);
    }

    public boolean[][] getStartField(int id) throws FieldInputException{

        switch (id) {
            case 1:
                pattern=PatternType.PLANER;
                return Patterns.getPlaner();
            case 2:
                pattern=PatternType.STAR;
                return Patterns.getStar();
            case 3:
                pattern=PatternType.SPACESHIP;
                return Patterns.getSpaceShip();
            default: throw new FieldInputException(new NotBoundException());
        }
    }

}
