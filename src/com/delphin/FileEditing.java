package com.delphin;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileEditing {

    //@author Mick
    //Finds a file with given string-name, displays it.
    void readSpecificFile(int fileName) throws FileNotFoundException {
        File file = new File("src\\Members\\"+fileName+".txt");
        Scanner readFile = new Scanner(file);
        while (readFile.hasNextLine()){
            System.out.println(readFile.nextLine());
        }
    }

    Member readFileAndConvertToObject(int IDNumber) throws IOException {
        /*On reading objects, the ObjectInputStream directly tries to map all the attributes
         *into the class into which we try to cast the read object.
         *If it is unable to map the respective object exactly then it throws a ClassNotFound exception.
         */

        //import ObjectInputStream to to read objects from a file.

        String path = "src\\Members\\"+IDNumber+".txt";
        try{
            FileInputStream fi = new FileInputStream(new File(path));
            ObjectInputStream oi = new ObjectInputStream(fi);

            //Read Object
            Member aMember = (Member) oi.readObject();

            oi.close();
            fi.close();
            return aMember;

        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }
    //@author Mick
    //Stores our members as objects in files.
    void createNewMemberObjectFile(Member member){
        //import ObjectOutputStream to write objects to a file.

        int IDNumber = member.getMemberID();
        String path = "src\\Members\\"+IDNumber+".txt";

        try{
            FileOutputStream f = new FileOutputStream(new File(path));
            ObjectOutputStream o = new ObjectOutputStream(f);

            //Write object to file
            o.writeObject(member);
            o.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
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

    //@Gus
    ArrayList dataToArrayList() throws IOException {
        File directory = new File("src\\Members");
        File[] fileArray = directory.listFiles();
        ArrayList<Member> memberList = new ArrayList<>();
        System.out.println(fileArray[0]);
        for (int i = 0; i < fileArray.length; i++) {

            memberList.add(readFileAndConvertToObject(fileArray.get(i)));
        }
        System.out.println(memberList.toString());
        return memberList;
    }



}
