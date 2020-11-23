package com.delphin;

import java.io.*;
import java.util.Scanner;

public class FileEditing {
    static File testFile = new File("src\\com\\delphin\\testFile.txt");

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
            writer.write(currentLine + "\n");
        }
        writer.close();
        reader.close();
        boolean checkIfDeleted = inputFile.delete();
        boolean checkIfRenamed = tempFile.renameTo(inputFile);
        System.out.println("Deleted: " + checkIfDeleted + " \nRenamed: " + checkIfRenamed);
    }

    //@author Mick
    void displayTextFile() throws IOException{

        Scanner textFile = new Scanner(testFile);
        while (textFile.hasNextLine()){
            System.out.println(textFile.nextLine());
        }
    }

}
