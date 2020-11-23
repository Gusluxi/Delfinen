package com.delphin;

import java.io.*;

public class EditMembership {
    static IDNumber idNumber = new IDNumber();
    //Member test3 = new Member(idNumber.newMemberID(), 35,"Jesus",true,false,true,false,1500);

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

    void newMembership() throws IOException {
        Member member = new Member();
        boolean juniorSenior;
        boolean activeDebt = false;
        double subscriptionPrice;

        int memberID = idNumber.newMemberID();
        member.setAge(UserInput.inputInt("Skriv en alder: "));
        member.setName(UserInput.inputString("Skriv et navn: "));
        member.setActivity(UserInput.inputBooleanInt(1,2,"1 for aktiv, 2 for passiv:"));
        member.setCompetitor(UserInput.inputBooleanInt(1,2,"1 for konkurrencesvømmer, 2 for hyggesvømmer:"));
        member.setMemberID(memberID);
        member.setJunior(member.calculateJuniorSenior(member));
        member.setSubscriptionPrice(member.calculatePrice(member));

        createNewMemberFile(member);
    }
}
