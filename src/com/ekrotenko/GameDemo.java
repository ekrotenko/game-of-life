package com.ekrotenko;

import com.ekrotenko.input.ConstantInput;
import com.ekrotenko.input.FieldInput;
import com.ekrotenko.input.FileInput;
import com.ekrotenko.output.ConsoleOutput;
import com.ekrotenko.output.FieldOutput;
import com.ekrotenko.input.ConsoleInput;
import com.ekrotenko.output.FileOutput;

public class GameDemo {

    public static void main(String[] args) {

        //FieldInput input = new ConstantInput(20,15,true);
        FieldInput input = new FileInput(true);
        FieldOutput output = new FileOutput();

        Game game = new Game(input, output);

        game.run();

    }
}
