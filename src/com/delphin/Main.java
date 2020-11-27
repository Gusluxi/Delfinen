package com.delphin;

import java.io.IOException;
import java.util.ArrayList;
import static com.delphin.EditMembership.fileEditing;
import static com.delphin.UserInput.scan;

public class Main {

    void run() throws IOException {
        //Instances of classes
        EditMembership editMembership = new EditMembership();
        FileEditing fileEditing = new FileEditing();
        IDNumber idNumber = new IDNumber();
        CurrentSubscriptions currentSubscriptions = new CurrentSubscriptions();
        DisciplineFileRW disciplineFileRW = new DisciplineFileRW();
        EditUserLogin editUserLogin = new EditUserLogin();


        final String DELPHIN = "src\\Disciplines";
        final String JB = "JuniorBryst";
        final String JBF = "JuniorButterfly";
        final String JC = "JuniorCrawl";
        final String JRC = "JuniorRygcrawl";
        final String SB = "SeniorBryst";
        final String SBF = "SeniorButterfly";
        final String SC = "SeniorCrawl";
        final String SRC = "SeniorRygcrawl";
        //Testcode

        //Opretter JESUS som medlem.
        //Member test3 = new Member(69, 35,"Jesus",true,false,true,false,1500);
        //Member test4 = new Member(idNumber.newMemberID(), 15,"Jesus2",true,false,true,true,1000);
        //fileEditing.createNewMemberObjectFile(test3);
        //fileEditing.createNewMemberObjectFile(test4);
        
        //Menu
        boolean run = true;
        int menuChoice;
        String headertext = "Delfin Klubben.";
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. testA Tilføj nyt medlem", "2. testB Rediger medlem", "3. testC Vis omsættelse og medlemmer i restance ",
                "4. testD leg med Login", "5. testE Display content of all members", "6. Tilføje rekordtider til discipliner", "7. testG", "8. MICKS", "9. testI", "0. Afslut"};
        while (run){
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = UserInput.inputInt(leadtext);
            switch (menuChoice){
                case 0: //End program
                    run = false;
                    break;
                case 1: //testA new membership
                    editMembership.newMembership();
                    break;
                case 2: //testB edit membership
                    //asks user to type a single Name or #ID which it will return to memberData.
                    String memberData = fileEditing.findSpecificFileValues("Skriv navn eller #nr. på den person der skal redigeres: ");
                    //Uses the selected memberID via getMemberIdFromString() to access the connected ID.txt file and run editMembership(with user selected file).
                    editMembership.editMembership(fileEditing.readFileAndConvertToObject(editMembership.getMemberIDFromString(memberData)));
                    System.out.println(fileEditing.readFileAndConvertToObject(editMembership.getMemberIDFromString(memberData)).toString());

                    break;
                case 3: //testC Display total revenue and members with debt.
                    CurrentSubscriptions.showTotalRevenue();
                    CurrentSubscriptions.showMembersWithDebt();
                    break;
                case 4: //testD Play with Username input
                    ArrayList<String> testArray = new ArrayList<>();
                    Login chairman = new Login("Formand","JegErDejlig","Kurt Kurt", 1); //Hardcode for now
                    testArray.add(chairman.getUserName());
                    Login trainer = new Login("Traener","JegErDenHurtigeste","Hurtig Kurt", 2); //Hardcode for now
                    testArray.add(trainer.getUserName());
                    Login cashier = new Login("Kasser","JegElskerTal","Kvinde Kurt", 3); //Hardcode for now
                    testArray.add(cashier.getUserName());

                    System.out.println(UserInput.validationStringArray(testArray, "Skriv brugernavn:"));
                    break;
                case 5: //testE
                    for (String i : fileEditing.dataToArrayList())
                    System.out.println("\n"+i);
                    break;
                case 6: //testF Menu til at tilføje rekordtider til disciplin
                    disciplineFileRW.addSwimtimeToFile();
                    break;
                case 7: //testG
                    break;
                case 8: //test MICK
                    fileEditing.displayTop5File(JB);
                    break;
                case 9: //testI
                    editUserLogin.newUser();
                    System.out.println(fileEditing.dataToArrayListLogin().toString());

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

        /*
        Member test = fileEditing.readFileAndConvertToObject(69); //henter JESUS medlemsnummer
        //System.out.println(test.toString()); //Viser Jesus som objekt
        //test.setActivity(false); //ændrer på ham som object
        //System.out.println(test.toString()); //viser ændringen
        fileEditing.createNewMemberObjectFile(test); //sætter ham tilbage i fil som object
        */

        //editMembership.newMembership();
        //fileEditing.dataToArrayList();

        //disciplineFileRW.testerAddToFile();
    }
}

