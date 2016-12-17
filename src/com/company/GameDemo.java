package com.company;

import com.company.input.ConsoleInput;
import com.company.input.ConstantInput;
import com.company.input.FieldInput;
import com.company.output.ConsoleOutput;
import com.company.output.FieldOutput;

public class GameDemo {

    public static void main(String[] args) {

        FieldInput input = new ConstantInput(20,15,true);
        //FieldInput input = new ConsoleInput(true);
        FieldOutput output = new ConsoleOutput();

        Game game = new Game(input, output);

        game.run();

    }
}
