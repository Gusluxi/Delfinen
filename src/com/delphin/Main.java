package com.delphin;

import java.io.IOException;

import static com.delphin.EditMembership.fileEditing;
import static com.delphin.UserInput.scan;

public class Main {

    void run() throws IOException {
        //Instances of classes
        EditMembership editMembership = new EditMembership();
        FileEditing fileEditing = new FileEditing();
        IDNumber idNumber = new IDNumber();
        CurrentSubscriptions currentSubscriptions = new CurrentSubscriptions();
        TimeAndDate timeClass = new TimeAndDate();

        //Testcode

        //Opretter JESUS som medlem.
        Member test3 = new Member(69, 35,"Jesus",true,false,true,true,1500);
        Member test4 = new Member(idNumber.newMemberID(), 15,"Jesus2",true,false,true,true,1000);
        fileEditing.createNewMemberObjectFile(test3);
        DisciplineFileRW disciplineFileRW = new DisciplineFileRW();
        disciplineFileRW.testerAddToFile();
        fileEditing.createNewMemberObjectFile(test4);

        CurrentSubscriptions.showTotalRevenue();



        String memberData = fileEditing.findSpecificFileValues("Skriv navn eller #nr. på den person der skal redigeres: ");
        editMembership.editMembership(fileEditing.readFileAndConvertToObject(editMembership.getMemberIDFromString(memberData)));

        System.out.println(fileEditing.readFileAndConvertToObject(editMembership.getMemberIDFromString(memberData)).toString());
        /*
        //Edit membership
        editMembership.editMembership(fileEditing.readFileAndConvertToObject(69));

         */
        //System.out.println(fileEditing.findSpecificFileValues("Skriv navn eller #nr. på den person der skal redigeres: ")); //Returner
        //fileEditing.dataToArrayList();

        boolean run = true;
        int choice;
        String headertext = "Velkommen til Delfinens system kl. er - " + TimeAndDate.displayTime() + " datoen er - " + TimeAndDate.currentDate();
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuitems = {"1. Formandslogin", "2. Trænerlogin", "3. Kassérlogin", "9. Afslut program."};

        while (run){
            Menu menu = new Menu(headertext,leadtext,menuitems);
            menu.printMenu();
            choice = UserInput.inputInt(leadtext);
            switch (choice){
                case 1: //Indtast brugernavn og kodeord?
                    editMembership.editMembership(fileEditing.readFileAndConvertToObject(editMembership.getMemberIDFromString(memberData)));
                    break;
                case 2: //Indtast brugernavn og kodeord?
                    break;
                case 3: //Indtast brugernavn og kodeord?
                    break;
                case 9: //Terminates program (if needed).
                    System.out.println("Afslutter program...");
                    int confirmEnd = UserInput.inputInt(1,2,"Er du sikker på at afslutte programmet?\n1. for Ja, 2. for Nej: ");
                    if (confirmEnd == 1)
                        run = false;
                    break;
                default:
                    menu.printMenu();
            }
        }


    }

    public static void main(String[] args) throws IOException {
        Main prg = new Main();
        prg.run();
    }

    void gammelKodetest(){
        //Nedestående tester om vi kan læse en fil, slette en givet string, og så display igen
        //fileEditing.displayTextFile();
        //fileEditing.removeLineFromText("hej");
        //fileEditing.displayTextFile();

        //Nedestående tester vores sortering. IT WORKS LEL
        //fileEditing.sortTextFile();

        //fileEditing.readSpecificFile("50");
        //editMembership.findCrazyMember();
        //System.out.println(editMembership.findCrazyMember());

        /*
        Member test = fileEditing.readFileAndConvertToObject(69); //henter JESUS medlemsnummer
        //System.out.println(test.toString()); //Viser Jesus som objekt
        //test.setActivity(false); //ændrer på ham som object
        //System.out.println(test.toString()); //viser ændringen
        fileEditing.createNewMemberObjectFile(test); //sætter ham tilbage i fil som object
        */

        //editMembership.newMembership();
        //System.out.println(fileEditing.findSpecificFileValues("Skriv navn eller #nr. på den person der skal redigeres: ")); //Returner
        //fileEditing.dataToArrayList();





    }
}

