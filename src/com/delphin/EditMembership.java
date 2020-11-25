package com.delphin;

import java.io.*;

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
        member.setActivity(UserInput.validateStringToBoolean("Aktiv","Passiv",
                "Skriv aktiv eller passiv for medlemskabet: "));
        member.setCompetitor(UserInput.validateStringToBoolean("Konkurrence","Atlet",
                "Skriv konkurrence eller atlet for svømningsform"));
        member.setMemberID(memberID);
        member.setJunior(member.calculateJuniorSenior(member));
        member.setSubscriptionPrice(member.calculatePrice(member));

        fileEditing.createNewMemberObjectFile(member);
    }

    //@author Mick
    //A menu to Display when editing memberships.
    void menuEditMembership() {
        System.out.println("\nMenu:");
        System.out.println("1 Ændre Alder");
        System.out.println("2 Ændre Navn");
        System.out.println("3 Ændre Aktivitets-niveau");
        System.out.println("4 Ændre Konkurrence-status");
        System.out.println("5 Ændre Aktiv Gæld");
        System.out.println("6 Vis medlemmets informationer");
        System.out.println("7 Forlad menuen");
    }

    //@author MIck
    //A switch case to edit in a member's data.
    //Uses UserInput and getter/setters from Member.
    void editMembership(Member member){
        System.out.println(member.toString());
        boolean stayInLoop = true;
        while(stayInLoop) {

            menuEditMembership();
            int inputNumber = UserInput.inputInt(1, 7, "Indtast et tal mellem 1-7");

            switch (inputNumber) {
                case 1:
                    member.setAge(UserInput.inputInt("Indsæt den nye alder"));
                    Member.calculateJuniorSenior(member);
                    System.out.println("Den nye alder er sat til: "+ member.getAge());
                    break;
                case 2:
                    member.setName(UserInput.inputString("Skriv det nye navn: ",true));
                    System.out.println("Det nye navn er sat til: "+ member.getName());
                    break;
                case 3:
                    member.setActivity(UserInput.validateStringToBoolean("Aktiv","Passiv",
                            "Er medlemmet aktiv eller passiv?"));
                    if (member.isActivity()==true){
                        System.out.println("Medlemmet er nu sat til at være et aktivt medlem!");
                    } else{
                        System.out.println("Medlemmet er nu passivt, og kan ikke længere bruge vores svømmehal.");
                    }
                    break;
                case 4:
                    member.setCompetitor(UserInput.validateStringToBoolean("Kompetitiv","Afslappet",
                            "Er medlemmet kompetitiv eller afslappet?"));
                    System.out.println("Den nye konkurrence tilstand er sat til: "+ member.isCompetitor());
                    break;
                case 5:
                    member.setActiveDebt(UserInput.validateStringToBoolean("Godkendt","Mangelfuld",
                            "Er medlemmets betaling godkendt eller mangelfuld?\nEller tryk 1. for at skylde penge, 2 for at der er betalt"));
                    if (member.isActiveDebt()==true){
                        System.out.println("Medlemmet skylder penge, kontakt dem hurtigst muligt.");
                    } else{
                        System.out.println("Medlemmet skylder ikke længere penge.");
                    }
                    break;
                case 6:
                    System.out.println(member.toString());
                    break;
                case 7:
                    stayInLoop=false;
                    break;

                default:
                    System.out.println("Do something");
            }
        }
        //When out of the loop, store the information
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