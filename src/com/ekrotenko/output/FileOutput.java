package com.ekrotenko.output;

import com.ekrotenko.Core.Exceptions.FieldInputException;
import com.ekrotenko.Core.Exceptions.FieldOutputException;
import com.ekrotenko.Core.Field;
import com.ekrotenko.Core.PatternType;
import com.ekrotenko.patterns.Patterns;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Eugene on 03.02.2017.
 */
public class FileOutput implements FieldOutput {

    @Override
    public void sendField(Field field) throws FieldOutputException {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm");
        final String outFolderName = "OutputFiles";
        final String outFileName = Patterns.selectedPattern.toString()+"_"+LocalDateTime.now().format(formatter).toString()+".txt";
        final String outFilePath = outFolderName+"\\"+outFileName;
        File newFile = new File(outFilePath);
        File dir = new File(outFolderName);
        if(!dir.exists()){
            dir.mkdir();
        }
        try {
            newFile.createNewFile();
        }
        catch(IOException ex){
            throw new FieldOutputException(ex);
        }
        try(FileWriter writer = new FileWriter(newFile, true)){
            for (int rowId =0; rowId<field.getColumnSize(); rowId++) {
                for (int colId =0; colId<field.getRowSize(); colId++) {
                    if (field.getState(rowId,colId)) {
                        writer.append("x ");
                    } else
                        writer.append(". ");
                }
                writer.append("\n");
            }
            writer.append("\n");
            writer.flush();
        }
        catch(IOException ex){
            throw new FieldOutputException(ex);
        }
    }

//    private OutputStream getOutputStream() throws IOException{
//        final File newFile = new File(outFilePath);
//        newFile.createNewFile();
//        return new BufferedOutputStream(new FileOutputStream(newFile));
//    }

}
