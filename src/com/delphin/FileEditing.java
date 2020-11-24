package com.delphin;

import java.io.*;
import java.util.Scanner;

public class FileEditing {
    static File testFile = new File("src\\com\\delphin\\testFile.txt");


    //@author Mick
    void removeLineFromText(String string) throws IOException {

        File inputFile = new File("src\\com\\delphin\\testFile.txt");
        if (inputFile.createNewFile()){
            System.out.println("Filen er oprettet: "+inputFile.getName()); //prints filename
        } else {
            System.out.println("Filen findes:" +inputFile.getName());
        }

        File tempFile = new File("src\\com\\delphin\\tempTestFile.txt");
        if (tempFile.createNewFile()){
            System.out.println("Filen er oprettet: "+inputFile.getName()); //prints filename
        } else {
            System.out.println("Filen findes: "+tempFile.getName());
        }
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
        //writer.flush();
        writer.close();
        reader.close();


        inputFile.delete();
        tempFile.renameTo(inputFile);
    }
/*
    //@author Mick
    void displayTextFile() throws IOException{
        Scanner textFile = new Scanner(testFile);
        while (textFile.hasNextLine()){
            System.out.println(textFile.nextLine());
        }
    }

 */

}

