package com.company;

import com.company.Core.Field;
import com.company.input.FieldInput;
import com.company.output.FieldOutput;

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
        Field fieldToOut = input.getField();

        while (true) {
            output.sendField(fieldToOut);
            fieldToOut.regenerateField();
            try{
                Thread.sleep(300);
            }
            catch(InterruptedException ex) {}

        }

    }
}
