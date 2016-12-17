package com.company.patterns;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
        startField[1][2] = true;
        startField[1][3] = true;
        startField[1][6] = true;
        startField[1][7] = true;
        startField[2][4] = true;
        startField[2][5] = true;
        startField[3][4] = true;
        startField[3][5] = true;
        startField[4][1] = true;
        startField[4][3] = true;
        startField[4][6] = true;
        startField[4][8] = true;
        startField[5][1] = true;
        startField[5][8] = true;
        startField[7][1] = true;
        startField[7][8] = true;
        startField[8][2] = true;
        startField[8][3] = true;
        startField[8][6] = true;
        startField[8][7] = true;
        startField[9][3] = true;
        startField[9][4] = true;
        startField[9][5] = true;
        startField[9][6] = true;
        startField[11][4] = true;
        startField[11][5] = true;
        startField[12][4] = true;
        startField[12][5] = true;
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
