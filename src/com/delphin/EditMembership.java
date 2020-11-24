package com.delphin;

import java.io.*;
import java.util.ArrayList;

public class EditMembership {
    static IDNumber idNumber = new IDNumber();
    static FileEditing fileEditing = new FileEditing();
    //Member test3 = new Member(idNumber.newMemberID(), 35,"Jesus",true,false,true,false,1500);


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
        System.out.println(aMember.toString());


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
    //Saves a member in a textfile in case of program crashes.
    /*void createNewMemberFile(Member member) throws IOException {
        int IDNumber = member.getMemberID();
        String path = "src\\Members\\"+IDNumber+".txt";
        try{
            File viProver = new File(path);
            if (viProver.createNewFile()){
                System.out.println("File created: " + viProver.getName());
            }else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter fw = new FileWriter(path,true);
        PrintWriter writeToFile = new PrintWriter(fw);
        writeToFile.println(member.toString());
        writeToFile.flush();
        writeToFile.close();
    }

     */

    //Creates a member
    //@author Gustav &the gang
    void newMembership() throws IOException {
        Member member = new Member();
        boolean juniorSenior;
        boolean activeDebt = false;
        double subscriptionPrice;

        int memberID = idNumber.newMemberID();
        member.setAge(UserInput.inputInt(0,122,"Skriv en alder: "));
        member.setName(UserInput.inputString("Skriv et fuldt navn: "));
        member.setActivity(UserInput.validateStringToBoo("Aktiv","Passiv","Skriv aktiv eller passiv for medlemskabet: "));
        member.setCompetitor(UserInput.validateStringToBoo("Konkurrence","Atlet","Skriv konkurrence eller atlet for svømningsform"));
        member.setMemberID(memberID);
        member.setJunior(member.calculateJuniorSenior(member));
        member.setSubscriptionPrice(member.calculatePrice(member));

        createNewMemberObjectFile(member);
    }
    //@Gus
    void findCrazyMember() throws FileNotFoundException {
        String input = UserInput.inputString("Skriv navn eller #nr. på den person der skal redigeres: ");
        ArrayList<String> memberData = fileEditing.dataToArrayList();
        for (int i = 0; i < memberData.size(); i++) {
            if (memberData.get(i).contains(input))
                System.out.println(memberData.get(i));
        }



    }
}
