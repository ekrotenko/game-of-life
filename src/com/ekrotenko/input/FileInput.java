package com.ekrotenko.input;
import com.ekrotenko.Core.*;
import com.ekrotenko.Core.Exceptions.FieldInputException;
import com.ekrotenko.patterns.Patterns;
import java.io.*;
import java.util.*;

/**
 * Created by Eugene on 16.01.2017.
 */
public class FileInput implements FieldInput {
    private FieldStrategy str;
    private PatternType pattern = PatternType.NOTSELECTED;

    public FileInput(boolean isClosed){
        str = (isClosed)? new ClosedField(): new OpenedField();
    }

    public Field getField() throws FieldInputException{
        String path="";
        path = getPatternFilePath();
        try(final InputStream is = getStream(path)) {
            return new Field(getField(is), str, pattern);
        }
        catch(Exception ex){
            throw new FieldInputException(ex);
        }
    }

    private String getPatternFilePath() throws FieldInputException{
        int id = Patterns.getSelectedPatternId();
        switch(id){
            case 1:
                this.pattern = PatternType.PLANER;
                return "src\\com\\ekrotenko\\patterns\\FilePatterns\\Planer.txt";
            case 2:
                this.pattern = PatternType.STAR;
                return "src\\com\\ekrotenko\\patterns\\FilePatterns\\Star.txt";
            case 3:
                this.pattern = PatternType.SPACESHIP;
                return "src\\com\\ekrotenko\\patterns\\FilePatterns\\SpaceShip.txt";
            default: throw new FieldInputException("Invalid pattern Id selected ");
        }
    }

    private InputStream getStream(String path) throws FileNotFoundException{
        return new BufferedInputStream(new FileInputStream(path));
    }

    private boolean[][] getField(InputStream is){
        Scanner reader = new Scanner(is);
        List<boolean[]> rowsBuffer = new LinkedList<>();
        while(reader.hasNextLine()){
            rowsBuffer.add(getFieldRow(reader.nextLine()));
        }

        int arrLength = rowsBuffer.size();
        boolean[][] fieldRows = new boolean[arrLength][];
        for(int i=0;i<arrLength;i++){
            fieldRows[i]=rowsBuffer.get(i);
        }
        return fieldRows;
    }

    private boolean[] getFieldRow(String row){
        List<String> colsBuffer = new LinkedList<>();
        Scanner rowReader = new Scanner(row);
        while (rowReader.hasNext()){
            colsBuffer.add(rowReader.next());
        }
        int arrLength = colsBuffer.size();
        boolean[] fieldRow = new boolean[arrLength];
        for(int i=0;i<arrLength;i++){
            fieldRow[i]=(colsBuffer.get(i).equals("x"));
        }
        return fieldRow;
    }
}
