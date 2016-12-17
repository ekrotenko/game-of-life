package com.company;

/**
 * Created by Eugene on 26.11.2016.
 */
public class GameField {
    int rows=20;
    int columns=30;
    public boolean[][] field=new boolean[rows][columns];
    public boolean[][] tmpField=new boolean[rows][columns];

    public void PrintField() {
        for (boolean[] rows : field) {
            for (boolean cell : rows) {
                if (cell) {
                    System.out.print("x ");
                } else
                    System.out.print(". ");
            }
            System.out.println();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
        try{
            Thread.sleep(300);
        }
        catch(InterruptedException ex){}
    }

    public void PrintFieldFor() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j]) {
                    System.out.print("x ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public int GetIndex(int ind, int size){
        if(ind<0){
            return size-1;
        }
        else if(ind>=size){
            return 0;
        }
        else return ind;
    }

    public int ReturnLiveCellsCount(int rowID, int columnID) {
        int count = 0;
        int rBorInd, cBorInd;
        for (int i = rowID - 1; i <= rowID + 1; i++) {
            for (int j = columnID - 1; j <= columnID + 1; j++) {
                    /*if ((i >= 0 && i < field.length) && (j >= 0 && j < field[i].length)) {
                        if (!(i == rowID && j == columnID) && field[i][j]) {
                            count++;
                        }
                    }*/
                rBorInd=GetIndex(i,field.length);
                cBorInd=GetIndex(j,field[rBorInd].length);
                if (!(rBorInd == rowID && cBorInd == columnID) && field[rBorInd][cBorInd]) {
                    count++;
                }
            }
        }
        return count;
    }

    public void ChangeStateOfCell(int rowID, int columnID, boolean[][] tmpField) {
        int neibors = ReturnLiveCellsCount(rowID, columnID);
        if (field[rowID][columnID]) {
            if (!(neibors < 2 || neibors > 3)) {
                tmpField[rowID][columnID] = true;
            }
        } else {
            if (neibors == 3)
                tmpField[rowID][columnID] = true;

        }
    }

    public void RedrawField() {
        PrintField();
        tmpField = new boolean[rows][columns];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                ChangeStateOfCell(i, j, tmpField);
            }
        }
        field = tmpField;
    }

}
