package com.ekrotenko;

import com.ekrotenko.Core.Exceptions.FieldInputException;
import com.ekrotenko.Core.Exceptions.FieldOutputException;
import com.ekrotenko.Core.Field;
import com.ekrotenko.input.FieldInput;
import com.ekrotenko.output.ConsoleOutput;
import com.ekrotenko.output.FieldOutput;

/**
 * Created by Eugene on 15.12.2016.
 */
public class Game {
    private final FieldInput input;
    private final FieldOutput output;

    public Game(FieldInput input, FieldOutput output){
        this.input=input;
        this.output=output;
    }

    public void run(){
        int i = 0;
        try {
            Field fieldToOut = input.getField();
            while (i<15) {
                try{
                    output.sendField(fieldToOut);
                }
                catch (FieldOutputException ex){
                    ex.printStackTrace();
                }
                fieldToOut.regenerateField();

                if(output instanceof ConsoleOutput) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException ex) {
                    }
                }
                i++;
            }
        }
        catch (FieldInputException ex){
            ex.printStackTrace();
        }

    }
}
