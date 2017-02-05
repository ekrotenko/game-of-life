package com.ekrotenko.Core;

/**
 * Created by Eugene on 26.11.2016.
 */
public class Field {
    private int rowSize;
    private int colSize;
    private boolean[][] fieldArray;
    private boolean[][] tmpFieldArray;
    private FieldStrategy isClosed;
    private PatternType pattern = PatternType.NOTSELECTED;

    public Field(int size, FieldStrategy isClosed, PatternType pattern){
        this(size,size, isClosed, pattern);
    }

    public Field(boolean[][] startField, FieldStrategy isClosed, PatternType pattern){
        this(startField.length, startField[startField.length-1].length, isClosed, pattern);
        for(int i = 0; i<this.colSize; i++){
            for(int j =0; j<this.rowSize; j++){
                fieldArray[i][j] = startField[i][j];
            }
        }
    }

    public Field(int colSize, int rowSize, FieldStrategy isClosed, PatternType pattern){
        this.rowSize=rowSize;
        this.colSize=colSize;
        this.fieldArray=new boolean[colSize][rowSize];
        this.tmpFieldArray=new boolean[colSize][rowSize];
        this.isClosed = isClosed;
        this.pattern = pattern;
    }

    public PatternType getPatternType(){
        return this.pattern;
    }

    public int getRowSize(){
        return this.rowSize;
    }

    public int getColumnSize(){
        return this.colSize;
    }

    public boolean getState(int rowId, int colId){
        return this.fieldArray[rowId][colId];
    }

    private int getNeighborsCount(int rowID, int columnID) {
        int count = 0;
        int rBorInd, cBorInd;
        for (int i = rowID - 1; i <= rowID + 1; i++) {
            for (int j = columnID - 1; j <= columnID + 1; j++) {
                rBorInd= isClosed.getIndex(i,this.colSize);
                cBorInd= isClosed.getIndex(j,this.rowSize); //cBorInd= getIndex(j,fieldArray[rBorInd].length);
                if(rBorInd<0 || cBorInd<0)
                    continue;
                if (!(rBorInd == rowID && cBorInd == columnID) && fieldArray[rBorInd][cBorInd]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void changeStateOfCell(int rowID, int columnID, boolean[][] tmpField) {
        int neibors = getNeighborsCount(rowID, columnID);
        tmpField[rowID][columnID]=((fieldArray[rowID][columnID]&&neibors==2)||neibors==3);
        //tmpField[rowID][columnID]=(field[rowID][columnID]&&!(neibors < 2 || neibors > 3 ))||(!field[rowID][columnID]&&neibors == 3);
        /*if (field[rowID][columnID]) {
            if (!(neibors < 2 || neibors > 3 )) {
                tmpField[rowID][columnID] = true;
            }
        } else {
            if (neibors == 3)
                tmpField[rowID][columnID] = true;
        }*/
    }

    public void regenerateField() {
        tmpFieldArray = new boolean[colSize][rowSize];
        for (int i = 0; i < fieldArray.length; i++) {
            for (int j = 0; j < fieldArray[i].length; j++) {
                changeStateOfCell(i, j, tmpFieldArray);
            }
        }
        fieldArray = tmpFieldArray;
    }

}
