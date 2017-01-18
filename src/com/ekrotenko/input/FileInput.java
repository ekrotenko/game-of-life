package com.ekrotenko.input;

import com.ekrotenko.Core.*;
import com.ekrotenko.Core.Exceptions.FieldInputException;

import java.io.*;
import java.rmi.NotBoundException;
import java.util.*;

/**
 * Created by Eugene on 16.01.2017.
 */
public class FileInput implements FieldInput {
    private final Scanner console = new Scanner(System.in);
    private FieldStrategy str;

    public FileInput(boolean isClosed){
        str = (isClosed)? new ClosedField(): new OpenedField();
    }

    public Field getField(){
        System.out.println("Select pattern:"); // \n означает новую строку
        System.out.println("1 - Planer");
        System.out.println("2 - Star");
        System.out.println("3 - Space Ship");
        System.out.println("\n> ");
        String path="";
        try{
            path = getPatternFilePath();
        }
        catch (FieldInputException ex){ex.printStackTrace();}

        try(final InputStream is = getStream(path)) {
            return new Field(getField(is), str);
        }
        catch(Exception ex){
            new FieldInputException(ex).printStackTrace();
            return new Field(1, str);
        }

    }

    private String getPatternFilePath() throws FieldInputException{
        int id = Integer.parseInt(console.nextLine());
        switch(id){
            case 1:
                return "D:\\JavaLessons\\Java_Skills_UP\\Homework\\GameOfLife\\src\\com\\ekrotenko\\patterns\\FilePatterns\\Planer.txt";
            case 2:
                return "D:\\JavaLessons\\Java_Skills_UP\\Homework\\GameOfLife\\src\\com\\ekrotenko\\patterns\\FilePatterns\\Star.txt";
            case 3:
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
