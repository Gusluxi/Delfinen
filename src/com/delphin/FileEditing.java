package com.delphin;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
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

    void displaySpecificFileList(int fileName) throws FileNotFoundException {
        File file = new File("src\\Members\\"+fileName+".txt");
        int count = 0;
        Scanner readFile = new Scanner(file);
        while (readFile.hasNextLine()){
            count++;
            System.out.println(count + ". " + readFile.nextLine());
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
    static Member readFileAndConvertToObject(File file) throws IOException {

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

    void addToFile(String string, String inputFraBruger) throws IOException {
        File inputFile = new File("src\\Disciplines\\" + inputFraBruger + ".txt");
     BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile,true));
     writer.write("\n" + string);
     writer.close();

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
        File directory = new File("src\\Members");
        File[] fileArray = directory.listFiles();
        ArrayList<File> fileA = new ArrayList<>(Arrays.asList(fileArray));
        ArrayList<String> memberData = new ArrayList<>();
        for (int i = 0; i < fileA.size(); i++ ) {
            //adds a string that contains the file-object's toString
            memberData.add(readFileAndConvertToObject(fileA.get(i)).toString());
        }
        return memberData;
    }

    ArrayList<Double> memberFilesSubscription() throws IOException {
        File directory = new File("src\\Members");
        File[] fileArray = directory.listFiles();
        ArrayList<File> fileA = new ArrayList<>(Arrays.asList(fileArray));
        ArrayList<Double> memberData = new ArrayList<>();
        for (int i = 0; i < fileA.size(); i++ ) {
            //adds a string that contains the file-object's toString
            memberData.add(readFileAndConvertToObject(fileA.get(i)).getSubscriptionPrice());
        }
        return memberData;
    }

    //@author Gustav

    //@author Gustav
    //Looks for a specific member by String or Number.
    //If multiply users appear, you can choose by using the ID-number
    String findSpecificFileValues(String usrMsg) throws IOException {

        ArrayList<Integer> arrayPlace = new ArrayList<>();
        String input = UserInput.inputString(usrMsg, false);
        ArrayList<String> memberData = dataToArrayList(); //Returns an Arraylist of Strings with each member instead.
        //so when searching for "Gus" it finds all members named something with "Gus"

        for (int i = 0; i < memberData.size(); i++) {
            if (memberData.get(i).contains(input)) {
                arrayPlace.add(i);
            }
        }

        //In case of more hits on Search-word.
        if (arrayPlace.size() > 1) {
            System.out.println("Vælg hvilken "+input+":");
            for (int c = 0; c < arrayPlace.size(); c++) {
                System.out.println((c+1)+"."); //Displays index numbers+1
                printNrNameFromString(memberData.get(arrayPlace.get(c))); //displays Name and NumberID only.
            }
            int reInput = UserInput.inputInt(1, arrayPlace.size(),"Skriv nr. for den " + input + " du vil vælge.")-1;
            return memberData.get(arrayPlace.get(reInput));
        } else if (arrayPlace.size() <= 0) { //Runs the same method until the user finds a correct value. (called "Recursion
            return findSpecificFileValues("Fejl, " + input + " findes ikke.\nSkriv navn eller #nr. på den person der skal redigeres: ");
        }
        return memberData.get(arrayPlace.get(0));
    }

    //@author Gustav
    //Prints MemberID and Name of the subject(data)
    void printNrNameFromString(String data) {
        Scanner scan = new Scanner(data);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.contains("MemberID:")) {
                System.out.println(line);
            }
            if (line.contains("Navn:")) {
                System.out.println(line+"\n");
            }
        }
        scan.close();
    }
    //@author Gustav
    //Prints each line in a String as a list of 1. 2. 3...
    void printStringAsList(String data) {
        Scanner scan = new Scanner (data);
        int count = 0;
        while (scan.hasNextLine()) {
            count++;
            String line = scan.nextLine();
            System.out.println(count + ". " + line);
        }
        scan.close();
    }

}
