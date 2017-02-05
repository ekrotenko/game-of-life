package com.ekrotenko.input;

import com.ekrotenko.Core.*;
import com.ekrotenko.Core.Exceptions.FieldInputException;
import com.ekrotenko.patterns.Patterns;


/**
 * Created by Eugene on 15.12.2016.
 */
public class ConsoleInput implements FieldInput {
    private int colSize;
    private int rowSize;
    private boolean isClosed;
    private PatternType pattern;

    public ConsoleInput(boolean isClosed) {
        this.isClosed = isClosed;
    }

    @Override
    public Field getField() throws FieldInputException{
        FieldStrategy str = (isClosed)? new ClosedField(): new OpenedField();
        boolean[][] startField = getStartField(Patterns.getSelectedPatternId());
        return new Field(startField, str, pattern);
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
            default: throw new FieldInputException("Invalid pattern Id selected");
        }
    }

}
