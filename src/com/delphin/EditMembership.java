package com.delphin;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

public class EditMembership {
    static IDNumber idNumber = new IDNumber();
    static FileEditing fileEditing = new FileEditing();

    //Creates a member
    //@author Gustav &the gang
    void newMembership() throws IOException {
        Member member = new Member();

        int memberID = idNumber.newMemberID();
        member.setAge(UserInput.inputInt(0,122,"Skriv en alder: "));
        member.setName(UserInput.inputString("Skriv et fuldt navn: ", true));
        member.setActivity(UserInput.validateStringToBoolean("Aktiv","Passiv",
                "Skriv aktiv eller passiv for medlemskabet: "));
        member.setCompetitor(UserInput.validateStringToBoolean("Konkurrence","Atlet",
                "Skriv konkurrence eller atlet for svømningsform"));
        member.setMemberID(memberID);
        member.setJunior(member.calculateJuniorSenior(member));
        member.setSubscriptionPrice(member.calculatePrice(member));
        member.setActiveDebt(false);

        fileEditing.storeInObjectFile(member);
    }

    //@author MIck
    //A switch case to edit in a member's data.
    //Uses UserInput and getter/setters from Member.
    void editMembership(Member member) throws IOException {
        System.out.println(member.toString());
        boolean stayInLoop = true;
        //Menu

        String headerText2 = "Redigerings menu";
        String leadText2 = "Indtast et tal for at tilføj til specifik disciplin";
        String[] menuItems2 = {"1. Rediger Alder", "2. Rediger Navn", "3. Rediger Aktivitets-niveau",
                "4. Rediger Konkurrence-status","5. Rediger Aktiv Gæld","6. Vis medlemmets informationer","7. Forlad menuen"};
        Menu menu = new Menu(headerText2, leadText2, menuItems2); // Create new menu instance

        //Whileloop to stay in menu
        while(stayInLoop) {
            menu.printMenu();
            int inputNumber = UserInput.inputInt(1, 7, "Indtast et tal mellem 1-7");

            switch (inputNumber) {
                case 1://Set age
                    member.setAge(UserInput.inputInt("Indsæt den nye alder"));
                    Member.calculateJuniorSenior(member);
                    System.out.println("Den nye alder er sat til: "+ member.getAge());
                    break;
                case 2://Set name
                    member.setName(UserInput.inputString("Skriv det nye navn: ",true));
                    System.out.println("Det nye navn er sat til: "+ member.getName());
                    break;
                case 3://Change activity level (passive/active member)
                    member.setActivity(UserInput.validateStringToBoolean("Aktiv","Passiv",
                            "Er medlemmet aktiv eller passiv?"));
                    if (member.isActivity()==true){
                        System.out.println("Medlemmet er nu sat til at være et aktivt medlem!");
                    } else{
                        System.out.println("Medlemmet er nu passivt, og kan ikke længere bruge vores svømmehal.");
                    }
                    break;
                case 4://Change competitiveness level
                    member.setCompetitor(UserInput.validateStringToBoolean("Kompetitiv","Afslappet",
                            "Er medlemmet kompetitiv eller afslappet?"));
                    System.out.println("Den nye konkurrence tilstand er sat til: "+ member.isCompetitor());
                    break;
                case 5://Change arrear-status
                    member.setActiveDebt(UserInput.validateStringToBoolean("Godkendt","Mangelfuld",
                            "Er medlemmets betaling godkendt eller mangelfuld?\nEller tryk 1. for at skylde penge, 2 for at der er betalt"));
                    if (member.isActiveDebt()==true){
                        System.out.println("Medlemmet skylder penge, kontakt dem hurtigst muligt.");
                    } else{
                        System.out.println("Medlemmet skylder ikke længere penge.");
                    }
                    break;
                case 6://Print the member-info
                    System.out.println(member.toString());
                    break;
                case 7://Leave the loop
                    stayInLoop=false;
                    break;
                default:
                    System.out.println("Do something");
            }
        }
        //When out of the loop, store the information
        fileEditing.storeInObjectFile(member);

    }

    //@author Kristian
    //Deletes a member from the system.
    void removeMemberFromSystem(String directory, String IDNumber) throws FileNotFoundException {
        File file = new File("src\\"+directory+"\\"+IDNumber+".txt");
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }


    //@author Gustav
    //Used to extract MemberID from a String
    //This method takes a string and checks each line if it contains the MemberID:
    int getMemberIDFromString(String data) {
        Scanner scan = new Scanner(data);
        String memberID = "MemberID: #";
        String stringID;
        int intID = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.contains(memberID)) { //If line contains "MemberID: #" it will extract the memberID and convert int to an int
                stringID = line.substring(memberID.length());
                intID = Integer.parseInt(stringID);
            }
        }
        return intID;
    }

}
