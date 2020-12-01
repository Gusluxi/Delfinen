package com.delphin;

import java.io.*; //IOExceptions, ObjectInputStream/ObjectOutputStream, FileInputStream/FileOutputStream, File
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class FileEditing  {

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

        } catch (ClassNotFoundException | FileNotFoundException e){
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

        File file = new File("src\\"+directory+"\\"+fileName+".txt");
        Scanner readFile = new Scanner(file);
        ArrayList<String> stringArrayList = new ArrayList<>();

        //Read the file and pass it on
        while (readFile.hasNextLine()){
            stringArrayList.add(readFile.nextLine()); //adds text-lines to String arraylist
        }
        readFile.close();

        Collections.sort(stringArrayList); //Sorts the list

        //Write to file
        FileWriter fileWriter = new FileWriter(file);
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
    void removeLineFromText(String string, String filename) throws IOException {

        File inputFile = new File("src\\"+ "Disciplines" +"\\"+filename+".txt");
        File tempFile = new File("src\\"+ "Disciplines" +"\\tempTestFile.txt");

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
            if (readFileAndConvertToObject(fileArrayList.get(i)).isActiveDebt() == true) {
            memberData.add(readFileAndConvertToObject(fileArrayList.get(i)));
            }
        }
        return memberData;
    }

    //@author Mick
    //Remade findSpecificFileValues to work with objects instead.
    Member findSpecificMemberAndConvert(String searchFor) throws IOException {
        ArrayList<File> everyMember = getAllFilesInDir("Members");
        ArrayList<Member> membersFound = new ArrayList<>();

        //Loop through and find matches to "searchFor". Send to arraylist.
        for (int i = 0; i<everyMember.size(); i++) {
            //Convert MemberID to string
            String numberID = Integer.toString(readFileAndConvertToObject(everyMember.get(i)).getMemberID());

            if (readFileAndConvertToObject(everyMember.get(i)).getName().contains(searchFor) ||
                    numberID.compareTo(searchFor)==0) {
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
            //No hits on the search-term.
            System.out.println("Der kunne ikke findes nogen med søgningen: "+searchFor+ ". Prøv igen!" );
            Member memberr = findSpecificMemberAndConvert(UserInput.inputString("Skriv navn eller nummer på personen du vil finde"
                    ,false));
            return memberr;
        }
   }



}
