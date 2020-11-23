package com.delphin;

import java.io.*;
import java.util.Scanner;

public class FileEditing {

    //@author Mick
    void removeLineFromText(String string) throws IOException {
        File inputFile = new File("src\\com\\delphin\\testFile.txt");
        File tempFile = new File("src\\com\\delphin\\tempTestFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = string;
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if (trimmedLine.contains(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        inputFile.delete();
        tempFile.renameTo(inputFile);
    }
    //@author Mick
    void displayTextFile(){
        Scanner textFile = new Scanner("src\\com\\delphin\\testFile.txt");
        while (textFile.hasNextLine()){
            System.out.println(textFile.nextLine());
        }
    }

}
