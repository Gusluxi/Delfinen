package com.delphin;

import java.io.*;
import java.util.ArrayList;

public class EditMembership {
    static IDNumber idNumber = new IDNumber();
    static FileEditing fileEditing = new FileEditing();
    //Member test3 = new Member(idNumber.newMemberID(), 35,"Jesus",true,false,true,false,1500);

    //@author Mick
    //Saves a member in a textfile in case of program crashes.
    void createNewMemberFile(Member member) throws IOException { // @author
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

        createNewMemberFile(member);
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
