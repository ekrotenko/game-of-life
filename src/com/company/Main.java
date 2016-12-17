package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        GameField f = new GameField();
        f.field[0][1] = true;
        f.field[1][2] = true;
        f.field[2][2] = true;
        f.field[2][0] = true;
        f.field[2][1] = true;

        while (true) {
            f.RedrawField();
        }
    }
}
