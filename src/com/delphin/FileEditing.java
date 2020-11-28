package com.delphin;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FileEditing  {

    //When asked for directory, DELPHIN works as a path name.
    static final String DELPHIN = "com\\delphin";
    static final String JB = "JuniorBryst";
    static final String JBF = "JuniorButterfly";
    static final String JC = "JuniorCrawl";
    static final String JRC = "JuniorRygcrawl";
    static final String SB = "SeniorBryst";
    static final String SBF = "SeniorButterfly";
    static final String SC = "SeniorCrawl";
    static final String SRC = "SeniorRygcrawl";


    //@author Mick
    //Finds a file with given string-name, displays it.
    void readSpecificFile(String path, String fileName) throws FileNotFoundException {
        File file = new File(path+"\\"+fileName+".txt"); //path = ex. "src\\Disciplines" & fileName = ex. "107".
        Scanner readFile = new Scanner(file);
        while (readFile.hasNextLine()){
            System.out.println(readFile.nextLine());
        }
    }

    //@author Mick
    //Not sure if we're using this.
    //it displays a file......
    void displaySpecificFileList(String path, String fileName) throws FileNotFoundException {
        File file = new File(path+"\\"+fileName+".txt"); //path = ex. "src\\Disciplines" & fileName = ex. "107"
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
    Member readFileAndConvertToObject(File file) throws IOException {

        //import ObjectInputStream to to read objects from a file.

        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);

            //Read Object
            Member aMember = (Member) oi.readObject();

            oi.close();
            fi.close();
            return aMember;
        } catch (IOException ex) {
            System.out.println("IOException is caught");
            ex.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    //Frederik Overloaded previous method to fit Login
    Login readFileAndConvertToObjectLogin(File file) throws IOException {

        try{
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);

            //Read Object
            Login aLogin = (Login) oi.readObject();

            oi.close();
            fi.close();
            return aLogin; //returns a login-object

        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    //@author Mick
    //Stores our members as objects in files.
    void storeInObjectFile(Member member){

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

    //Overloaded to fit Login
    void storeInObjectFile(Login login){

        //Finds the correct filepath
        String name = login.getName();
        String path = "src\\UserLogin\\"+name+".txt";

        try{
            FileOutputStream f = new FileOutputStream(new File(path));
            ObjectOutputStream o = new ObjectOutputStream(f);

            //Write object to file
            o.writeObject(login);
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
    void sortTextFile(String directory,String fileName) throws IOException {

        File inputFile = new File("src\\"+directory+"\\"+fileName+".txt");
        Scanner readFile = new Scanner(inputFile);
        ArrayList<String> stringArrayList = new ArrayList<>();

        //Read the file and pass it on
        while (readFile.hasNextLine()){
            stringArrayList.add(readFile.nextLine()); //adds text-lines to String arraylist
        }
        readFile.close();

        Collections.sort(stringArrayList); //Sorts the list

        //Write to file
        FileWriter fileWriter = new FileWriter(inputFile);
        for (String str : stringArrayList){
            fileWriter.write(str+"\n");
        }
        fileWriter.close();
    }

    //@author Mick OVERLOADED
    void sortTextFile(File file) throws IOException {

        File inputFile = file;
        Scanner readFile = new Scanner(inputFile);
        ArrayList<String> stringArrayList = new ArrayList<>();

        //Read file
        while (readFile.hasNextLine()){
            stringArrayList.add(readFile.nextLine()); //adds text-lines to String arraylist
        }
        readFile.close();

        Collections.sort(stringArrayList); //Sorts the list

        //Write to file
        FileWriter fileWriter = new FileWriter(inputFile);
        for (String str : stringArrayList){
            fileWriter.write(str+"\n");
        }
        fileWriter.close();
    }

    //@author Mick
    //Searches file for a given String. Writes all the code (except the string)..
    //into another file. Deletes the old file and renames the new one.
    void removeLineFromText(String string,String directory,String filename) throws IOException {

        File inputFile = new File("src\\"+directory+"\\"+filename+".txt");
        File tempFile = new File("src\\"+directory+"\\tempTestFile.txt");

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

    //@author Ludvig
    //Adds String to textfile.
    void addToFile(String stringToFile,String directory, String fileName) throws IOException {
        File inputFile = new File("src\\"+directory+"\\" + fileName + ".txt");
     BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile,true));
     writer.write("\n" + stringToFile);
     writer.close();
    }

    //OVERLOADED.
    //Removed a nextline because of top5 formatting.
    void addToFileTop5(String stringToFile,String directory, String fileName) throws IOException {
        File inputFile = new File("src\\"+directory+"\\" + fileName + ".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile,true));
        writer.write(stringToFile);
        writer.close();
    }

    //@author Ludvig OVERLOAD FILE PARAMETER
    //Adds String to textfile.
    void addToFile(String stringToFile,File file) throws IOException {
        File inputFile = file;
        BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile,true));
        writer.write("\n" + stringToFile);
        writer.close();
    }

    //@author Mick
    //Added to avoid "DRY" coding.
    //Adds all files in given dir to an ArrayList
    ArrayList<File> getAllFilesInDir(String directory){
        File dir = new File("src\\"+directory+"");
        File[] fileArray = dir.listFiles();
        ArrayList<File> arrayListOfFiles = new ArrayList<>(Arrays.asList(fileArray)); //Converts Array to ArrayList
        return arrayListOfFiles;
    }

    //@author Gustav
    //"fileArray" is a list of all files. The method adds each file object's toString to "memberData"
    //Returns an Arraylist of String with memberData
    ArrayList<String> dataToArrayList(String dir) throws IOException {
        ArrayList<File> fileArrayList = getAllFilesInDir(dir);
        ArrayList<String> memberData = new ArrayList<>();
        for (int i = 0; i < fileArrayList.size(); i++ ) {
            //adds a string that contains the file-object's toString
            memberData.add(readFileAndConvertToObject(fileArrayList.get(i)).toString());

        }
        return memberData;
    }

    ArrayList<Integer> userStatus() throws IOException {
        ArrayList<File> fileA = getAllFilesInDir("UserLogin");
        ArrayList<Integer> loginData = new ArrayList<>();

        for (int i = 0; i < fileA.size(); i++ ) {
            //adds a string that contains the file-object's toString
            loginData.add(readFileAndConvertToObjectLogin(fileA.get(i)).getStatus());

        }
        return loginData;
    }
    //@Author Frederik
    //Overloaded method of memberFilesDebt
    //Method searches all Login-objects for Username and password. If they fit a member, they return status int of member.
   int getUserStatusFromFile(String username, String password) throws IOException {
       ArrayList<File> fileArrayList = getAllFilesInDir("UserLogin");
        int status = 0;

        for (int i = 0; i<fileArrayList.size(); i++) {
            if (readFileAndConvertToObjectLogin(fileArrayList.get(i)).getUserName().compareTo(username)==0  &&
                    readFileAndConvertToObjectLogin(fileArrayList.get(i)).getUserPassword().compareTo(password)==0) {
            status=readFileAndConvertToObjectLogin(fileArrayList.get(i)).getStatus();
            }
        }
        return status;
    }

    //@author Kristian
    //Returns personal subscription Price for each club member.
    ArrayList<Double> memberFilesSubscription() throws IOException {
        ArrayList<File> fileArrayList = getAllFilesInDir("Members");
        ArrayList<Double> memberData = new ArrayList<>();
        for (int i = 0; i < fileArrayList.size(); i++ ) {
            //adds a string that contains the file-object's toString
            memberData.add(readFileAndConvertToObject(fileArrayList.get(i)).getSubscriptionPrice());
        }
        return memberData;
    }

    //@author Kristian
    //Returns all members with missing payment.
    ArrayList<Member> memberFilesDebt() throws IOException {
        ArrayList<File> fileArrayList = getAllFilesInDir("Members");
        ArrayList<Member> memberData = new ArrayList<>();

        for (int i = 0; i < fileArrayList.size(); i++ ) {
            if (readFileAndConvertToObject(fileArrayList.get(i)).isActiveDebt() == true);
            memberData.add(readFileAndConvertToObject(fileArrayList.get(i)));
        }
        return memberData;
    }


    //@author Gustav
    //Looks for a specific member by String or Number.
    //If multiply users appear, you can choose by using the ID-number
    String findSpecificFileValues(String usrMsg) throws IOException {

        ArrayList<Integer> arrayPlace = new ArrayList<>(); //Keeps track of each search result.
        String input = UserInput.inputString(usrMsg, false);
        ArrayList<String> memberData = dataToArrayList("Members"); //Returns an Arraylist of Strings with each member instead.
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
                printNrNameFromString(memberData.get(arrayPlace.get(c))); //displays Name and NumberID only.T
            }

            int reInput = UserInput.inputInt(1, arrayPlace.size(),"Skriv nr. for den " + input + " du vil vælge.")-1;
            return memberData.get(arrayPlace.get(reInput));

            //in case the search has 0 results
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
        Scanner scan = new Scanner(data);
        int count = 0;
        while (scan.hasNextLine()) {
            count++;
            String line = scan.nextLine();
            System.out.println(count + ". " + line);
        }
        scan.close();
    }

    //@author Mick
    //Remade findSpecificFileValues to work with objects instead.

    Member findSpecificMemberAndConvert(String searchFor) throws IOException {
        ArrayList<File> everyMember = getAllFilesInDir("Members");
        ArrayList<Member> membersFound = new ArrayList<>();

        //Loop through and find matches to "searchFor". Send to arraylist.
        for (int i = 0; i<everyMember.size(); i++) {
            //Convert MemberID to string
            String word = Integer.toString(readFileAndConvertToObject(everyMember.get(i)).getMemberID());

            if (readFileAndConvertToObject(everyMember.get(i)).getName().contains(searchFor) ||
                    word.compareTo(searchFor)==0) {
                membersFound.add(readFileAndConvertToObject(everyMember.get(i)));
            }
        }

        //With only one hit
        if (membersFound.size() ==1){
            return membersFound.get(0);
        } else if (membersFound.size()>1){
            //More than one hit
        for (int i = 0; i < membersFound.size(); i++) {
            System.out.println((i + 1) + "."); //Displays index numbers+1
            System.out.println(membersFound.get(i).getName() + membersFound.get(i).getMemberID());
            }
            int reInput = UserInput.inputInt("Skriv ID-nummer for den " + searchFor + " du vil vælge.");
            return readFileAndConvertToObject(reInput);
        } else {
            System.out.println("Der kunne ikke findes nogen med søgningen: "+searchFor+ ". Prøv igen!" );
            findSpecificMemberAndConvert(UserInput.inputString("Skriv navn eller nummer på personen du vil finde"
                    ,false));

        }
        return membersFound.get(0);
    }



}
