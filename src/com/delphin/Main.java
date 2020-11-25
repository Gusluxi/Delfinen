package com.delphin;

import java.io.IOException;

public class Main {

    void run() throws IOException {
        //Instances of classes
        EditMembership editMembership = new EditMembership();
        FileEditing fileEditing = new FileEditing();
        IDNumber idNumber = new IDNumber();
        TimeAndDate timeClass = new TimeAndDate();

        //Testcode
        //Opretter JESUS som medlem.
        Member test3 = new Member(69, 35, "Jesus", true, false, true, false, 1500);
        fileEditing.createNewMemberObjectFile(test3);

        //editMembership.newMembership();

        Member test = fileEditing.readFileAndConvertToObject(69); //henter JESUS medlemsnummer
        System.out.println(test.toString()); //Viser Jesus som objekt
        test.setActivity(false); //ændrer på ham som object
        System.out.println(test.toString()); //viser ændringen
        fileEditing.createNewMemberObjectFile(test); //sætter ham tilbage i fil som object


        System.out.println(fileEditing.findSpecificFileValues("Skriv navn eller #nr. på den person der skal redigeres: ")); //Returner
        fileEditing.dataToArrayList();

        boolean run = true;
        int choice;
        String headertext = "Velkommen til Definens system  -  kl. " + timeClass.displayTime();
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuitems = {"1. Formandens Menu", "2. Svømmetræner Menu", "3. Kasser Menu", "9. Afslut program."};

        while (run) {
            Menu menu = new Menu(headertext, leadtext, menuitems);
            menu.printMenu();
            choice = UserInput.inputInt(leadtext);
            switch (choice) {
                case 1: //Formandens Menu
                    break;
                case 2: //Svømmetræner Menu
                    break;
                case 3: //Kassér Menu
                    break;
                case 9: //Terminates program (if needed).
                    System.out.println("Afslutter program...");
                    int confirmEnd = UserInput.inputInt(1, 2, "Er du sikker på at afslutte programmet?\n1. for Ja, 2. for Nej: ");
                    if (confirmEnd == 1)
                        run = false;
                    break;
                default:
                    menu.printMenu();
            }
        }
    }

            public static void main (String[]args) throws IOException {
                Main prg = new Main();
             //   prg.run();
            }

            //void gammelKodetest(){
            //Nedestående tester om vi kan læse en fil, slette en givet string, og så display igen
            //fileEditing.displayTextFile();
            //fileEditing.removeLineFromText("hej");
            //fileEditing.displayTextFile();

            //Nedestående tester vores sortering. IT WORKS LEL
            //fileEditing.sortTextFile();

            //fileEditing.readSpecificFile("50");
            //editMembership.findCrazyMember();
            //System.out.println(editMembership.findCrazyMember());

}

