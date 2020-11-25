package com.delphin;

import java.io.*;
import java.nio.file.Path;
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

    //@author Mick
    //Reads a given filename as an Object (member)
    //Returns the member-object.
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
            return aMember; //returns a member-object

        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    //Gustav Overloaded Mick's method
    //Overloading to take File as a parameter instead.
    Member readFileAndConvertToObject(File file) throws IOException {

        //import ObjectInputStream to to read objects from a file.
        try{
            FileInputStream fi = new FileInputStream(file);
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

        //Finds the correct filepath
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
    //Copies a file into an Arraylist, sorts it, then sends it back to the file.
    //Sorts after numbers first, then abc..
    void sortTextFile() throws IOException {

        //File, Scanner(read), FileWriter instances
        File inputFile = new File("src\\com\\delphin\\sortTest.txt");
        Scanner readFile = new Scanner(inputFile);
        ArrayList<String> stringArrayList = new ArrayList<>();
        FileWriter fileWriter = new FileWriter(inputFile);

        while (readFile.hasNextLine()){
            stringArrayList.add(readFile.nextLine()); //adds text-lines to String arraylist
        }
        readFile.close();

        Collections.sort(stringArrayList); //Sorts the list

        for (String eachString:stringArrayList){ //Writes it back to the file, sorted.
            fileWriter.write(eachString+"\n");
        }
        fileWriter.close();
    }


    //@author Mick
    //Searches file for a given String. Writes all the code (except the string)..
    //into another file. Deletes the old file and renames the new one.
    void removeLineFromText(String string) throws IOException {

        File inputFile = new File("src\\com\\delphin\\testFile.txt");
        File tempFile = new File("src\\com\\delphin\\tempTestFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = string;
        String currentLine;

        while ((currentLine = reader.readLine()) != null) { //As long as the line exists
            //trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if (trimmedLine.contains(lineToRemove)) continue; //Skips the line that matches our input String
            writer.write(currentLine + "\n");
        }

        writer.close();
        reader.close();

        //Deletes the original file. Renames the new one to what the last file was.
        inputFile.delete();
        tempFile.renameTo(inputFile);
    }

    //@author Mick
    //Displays a file for the user.. Just a print method atm
    void displayTextFile() throws IOException{
        File inputFile = new File("src\\com\\delphin\\testFile.txt");

        Scanner textFile = new Scanner(inputFile);
        while (textFile.hasNextLine()){
            System.out.println(textFile.nextLine());
        }
        textFile.close();
    }

    //@author Gustav
    //"fileArray" is a list of all files. The method adds each file object's toString to "memberData"
    //Returns an Arraylist of String with memberData
    ArrayList<String> dataToArrayList() throws IOException {
        ArrayList<String> memberData = new ArrayList<>();
        ArrayList<File> fileArray = filesToArrayList(); //arraylist of all files
        for (int i = 0; i < fileArray.size(); i++ ) {
            //adds a string that contains the file-object's toString
            memberData.add(readFileAndConvertToObject(fileArray.get(i)).toString());
        }
        return memberData;
    }

    //@author Gustav
    //Creates an Arraylist with all the files in Members Directory.
    ArrayList<File> filesToArrayList() throws IOException {
        File directory = new File("src\\Members");
        File[] fileArray = directory.listFiles();
        ArrayList<File> fileNames = new ArrayList<>();

        for (int i = 0; i < fileArray.length; i++) {
            fileNames.add(fileArray[i]);
        }

        return fileNames;
    }
}
