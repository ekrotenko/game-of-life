package com.ekrotenko.patterns;

/**
 * Created by Eugene on 15.12.2016.
 */
public class Patterns {
    private static boolean[][] startField;


    private static boolean[][] getPlaner(){
        startField = new boolean[20][20];
        startField[0][1] = true;
        startField[1][2] = true;
        startField[2][2] = true;
        startField[2][0] = true;
        startField[2][1] = true;
        return startField;
    }


    private static boolean[][] getStar(){
        startField = new boolean[20][20];
        startField[10][11] = true;
        startField[10][10] = true;
        startField[10][9] = true;
        startField[9][10] = true;
        startField[11][10] = true;
        return startField;
    }

    private static boolean[][] getSpaceShip(){
        startField = new boolean[20][20];
        startField[4][5] = true;
        startField[4][6] = true;
        startField[4][9] = true;
        startField[4][10] = true;
        startField[5][7] = true;
        startField[5][8] = true;
        startField[6][7] = true;
        startField[6][8] = true;
        startField[7][4] = true;
        startField[7][6] = true;
        startField[7][9] = true;
        startField[7][11] = true;
        startField[8][4] = true;
        startField[8][11] = true;
        startField[10][4] = true;
        startField[10][11] = true;
        startField[11][5] = true;
        startField[11][6] = true;
        startField[11][9] = true;
        startField[11][10] = true;
        startField[12][6] = true;
        startField[12][7] = true;
        startField[12][8] = true;
        startField[12][9] = true;
        startField[14][7] = true;
        startField[14][8] = true;
        startField[15][7] = true;
        startField[15][8] = true;
        return startField;
    }

    public static boolean[][] getStartField(int id){

            switch (id) {
                case 1:
                    return getPlaner();
                case 2:
                    return getStar();
                case 3:
                    return getSpaceShip();
                default: return new boolean[10][10];
            }
    }
}
