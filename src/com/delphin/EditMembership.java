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
        member.setName(UserInput.inputString("Skriv et fuldt navn: "));
        member.setActivity(UserInput.validateStringToBoo("Aktiv","Passiv","Skriv aktiv eller passiv for medlemskabet: "));
        member.setCompetitor(UserInput.validateStringToBoo("Konkurrence","Atlet","Skriv konkurrence eller atlet for svømningsform"));
        member.setMemberID(memberID);
        member.setJunior(member.calculateJuniorSenior(member));
        member.setSubscriptionPrice(member.calculatePrice(member));

        fileEditing.createNewMemberObjectFile(member);
    }
    //@author Gustav
    String findCrazyMember() throws IOException {
        ArrayList<Integer> arrayPlace = new ArrayList<>();
        String input = UserInput.inputString("Skriv navn eller #nr. på den person der skal redigeres: ");
        ArrayList<String> memberData = fileEditing.dataToArrayList();
        for (int i = 0; i < memberData.size(); i++) {
            if (memberData.get(i).contains(input)) {
                arrayPlace.add(i);
            }
        }
        if (arrayPlace.size() > 1) {
            System.out.println("Vælg hvilken "+input+":");
            for (int c = 0; c < arrayPlace.size(); c++) {
                System.out.println((c+1)+".");
                printNrNameFromString(memberData.get(arrayPlace.get(c)));
            }
            int reInput = UserInput.inputInt(1, arrayPlace.size(),"Skriv nr. for den " + input + " du vil vælge.")-1;
            return memberData.get(arrayPlace.get(reInput));
        }
        return memberData.get(arrayPlace.get(0));
    }

    //auther Gustav
    //Printer ved hjælp af toStringMetoden i Member.java
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