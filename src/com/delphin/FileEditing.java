package com.delphin;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileEditing {


    //@author Mick
    //Copies a file into an Arraylist, sorts it, then sends it back.
    //Sorts after numbers first, then abc..
    void sortTextFile() throws IOException {

        File inputFile = new File("src\\com\\delphin\\sortTest.txt");
        System.out.println(inputFile.canRead()+"Filen kan læses");
        Scanner readFile = new Scanner(inputFile);

        ArrayList<String> stringArrayList = new ArrayList<>();

        while (readFile.hasNextLine()){
            stringArrayList.add(readFile.nextLine());
        }
        readFile.close();
        System.out.println(stringArrayList.toString()+" Dette er arraylisten efter overførelse");
        FileWriter fileWriter = new FileWriter(inputFile);

        Collections.sort(stringArrayList);
        for (String eachString:stringArrayList){
            fileWriter.write(eachString+"\n");
        }
        fileWriter.close();
    }





    //@author Mick
    //Searches file for a given String. Writes all the code (except the string)..
    //into another file. Deletes the old file and renames the new one.
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

    //@author Mick
    //Displays a file for the user..
    void displayTextFile() throws IOException{
        File inputFile = new File("src\\com\\delphin\\testFile.txt");
        if (inputFile.createNewFile()){
            System.out.println("Filen er oprettet: "+inputFile.getName()); //prints filename
        } else {
            System.out.println("Filen findes:" +inputFile.getName());
        }

        Scanner textFile = new Scanner(inputFile);
        while (textFile.hasNextLine()){
            System.out.println(textFile.nextLine());
        }
        textFile.close();
    }

}
