package com.delphin;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EditMembership {
    static IDNumber idNumber = new IDNumber();
    static FileEditing fileEditing = new FileEditing();

    //Creates a member
    //@author Gustav &the gang
    void newMembership() throws IOException {
        Member member = new Member();

        int memberID = idNumber.newMemberID();
        member.setAge(UserInput.inputInt(0, 122, "Skriv en alder: "));
        member.setName(UserInput.inputString("Skriv et fuldt navn: ", true));
        member.setActivity(UserInput.validateStringToBoolean("Aktiv", "Passiv",
                "Skriv aktiv eller passiv for medlemskabet: "));
        member.setCompetitor(UserInput.validateStringToBoolean("Konkurrence", "Atlet",
                "Skriv konkurrence eller atlet for svømningsform"));
        member.setMemberID(memberID);
        member.setJunior(member.calculateJuniorSenior(member));
        member.setSubscriptionPrice(member.calculatePrice(member));
        member.setActiveDebt(false);

        fileEditing.storeInObjectFile(member);
    }

    //@author Mick
    //A switch case to edit in a member's data.
    //Uses UserInput and getter/setters from Member.
    void editMembership(Member member) {
        System.out.println(member.toString());
        boolean stayInLoop = true;
        //Menu

        String headerText2 = "Redigerings menu";
        String leadText2 = "Indtast et tal for at tilføj til specifik disciplin";
        String[] menuItems2 = {"1. Rediger Alder", "2. Rediger Navn", "3. Rediger Aktivitets-niveau",
                "4. Rediger Konkurrence-status", "5. Rediger Aktiv Gæld", "9. Forlad menuen"};
        Menu menu = new Menu(headerText2, leadText2, menuItems2); // Create new menu instance

        while (stayInLoop) {
            menu.printMenu();
            int inputNumber = UserInput.inputInt(leadText2);

            switch (inputNumber) {
                case 1://Set age
                    member.setAge(UserInput.inputInt("Indsæt den nye alder"));
                    Member.calculateJuniorSenior(member);
                    System.out.println(member.getName()+"s nye alder er sat til: " + member.getAge());
                    break;
                case 2://Set name
                    member.setName(UserInput.inputString("Skriv det nye navn: ", true));
                    System.out.println("Medlemmets nye navn er sat til: " + member.getName());
                    break;
                case 3://Change activity level (passive/active member)
                    member.setActivity(UserInput.validateStringToBoolean("Aktiv", "Passiv",
                            "Er "+member.getName()+" aktiv eller passiv?"));
                    if (member.isActivity() == true) {
                        System.out.println(member.getName()+" er nu sat til at være et aktivt medlem!");
                    } else {
                        System.out.println(member.getName()+" er nu passivt, og kan ikke længere bruge vores svømmehal.");
                    }
                    break;
                case 4://Change competitiveness level
                    member.setCompetitor(UserInput.validateStringToBoolean("Konkurrence", "Atlet",
                            "Er "+member.getName()+" konkurrence eller atlet -svømmer?"));
                    if (member.isCompetitor() == true) {
                        System.out.println(member.getName()+" er nu sat til at være konkurrencesvømmer");
                    } else {
                        System.out.println(member.getName()+" er nu sat til at være atletisksvømmer");
                    }
                    break;
                case 5://Change arrear-status
                    member.setActiveDebt(UserInput.validateStringToBoolean("Godkendt", "Mangelfuld",
                            "Er "+member.getName()+"s betaling godkendt eller mangelfuld?"));
                    if (member.isActiveDebt() == true) {
                        System.out.println(member.getName()+" skylder penge, kontakt dem hurtigst muligt.");
                    } else {
                        System.out.println(member.getName()+" skylder ikke længere penge.");
                    }
                    break;

                case 9://Leave the loop
                    stayInLoop = false;
                    break;
                default:
                    System.out.println("");
            }
        }
        //When out of the loop, store the information
        fileEditing.storeInObjectFile(member);

    }

    //@author Kristian
    //Deletes a member from the system.
    void removeMemberFromSystem(String directory, String IDNumber) throws FileNotFoundException {
        File file = new File("src\\" + directory + "\\" + IDNumber + ".txt");
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
