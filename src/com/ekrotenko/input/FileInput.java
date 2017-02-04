package com.ekrotenko.input;

import com.ekrotenko.Core.*;
import com.ekrotenko.Core.Exceptions.FieldInputException;
import com.ekrotenko.patterns.Patterns;

import java.io.*;
import java.rmi.NotBoundException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Eugene on 16.01.2017.
 */
public class FileInput implements FieldInput {
    private final Scanner console = new Scanner(System.in);
    private FieldStrategy str;


    public FileInput(boolean isClosed){
        str = (isClosed)? new ClosedField(): new OpenedField();
    }

    public Field getField() throws FieldInputException{
        System.out.println("Select pattern:"); // \n означает новую строку
        System.out.println("1 - Planer");
        System.out.println("2 - Star");
        System.out.println("3 - Space Ship");
        System.out.println("\n> ");
        String path="";
        path = getPatternFilePath();
        try(final InputStream is = getStream(path)) {
            return new Field(getField(is), str);
        }
        catch(Exception ex){
            throw new FieldInputException(ex);
        }
    }

    private String getPatternFilePath() throws FieldInputException{
        int id = Integer.parseInt(console.nextLine());
        switch(id){
            case 1:
                Patterns.selectedPattern=PatternType.PLANER;
                return "D:\\JavaLessons\\Java_Skills_UP\\Homework\\GameOfLife\\src\\com\\ekrotenko\\patterns\\FilePatterns\\Planer.txt";
            case 2:
                Patterns.selectedPattern=PatternType.STAR;
                return "D:\\JavaLessons\\Java_Skills_UP\\Homework\\GameOfLife\\src\\com\\ekrotenko\\patterns\\FilePatterns\\Star.txt";
            case 3:
                Patterns.selectedPattern=PatternType.SPACESHIP;
                return "D:\\JavaLessons\\Java_Skills_UP\\Homework\\GameOfLife\\src\\com\\ekrotenko\\patterns\\FilePatterns\\SpaceShip.txt";
            default: throw new FieldInputException(new NotBoundException());
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
