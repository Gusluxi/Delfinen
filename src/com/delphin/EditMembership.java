package com.delphin;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EditMembership {
    static IDNumber idNumber = new IDNumber();
    static FileEditing fileEditing = new FileEditing();

    //Creates a member
    //@author Gustav &the gang
    void newMembership() throws IOException {
        Member member = new Member();
        boolean juniorSenior;
        boolean activeDebt = false;
        double subscriptionPrice;

        int memberID = idNumber.newMemberID();
        member.setAge(UserInput.inputInt(0,122,"Skriv en alder: "));
        member.setName(UserInput.inputString("Skriv et fuldt navn: ", true));
        member.setActivity(UserInput.validateStringToBoo("Aktiv","Passiv","Skriv aktiv eller passiv for medlemskabet: "));
        member.setCompetitor(UserInput.validateStringToBoo("Konkurrence","Atlet","Skriv konkurrence eller atlet for svømningsform"));
        member.setMemberID(memberID);
        member.setJunior(member.calculateJuniorSenior(member));
        member.setSubscriptionPrice(member.calculatePrice(member));

        fileEditing.createNewMemberObjectFile(member);
    }

}

    //Old, maybe reuseable.
    //@author Mick
    //Saves a member in a textfile in case of program crashes.
    /*
    void createNewMemberFile(Member member) throws IOException {
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