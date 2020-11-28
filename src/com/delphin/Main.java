package com.delphin;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    void run() throws IOException {
        //Instances of classes
        EditMembership editMembership = new EditMembership();
        FileEditing fileEditing = new FileEditing();
        IDNumber idNumber = new IDNumber();
        CurrentSubscriptions currentSubscriptions = new CurrentSubscriptions();
        SwimTimesAndStats swimTimesAndStats = new SwimTimesAndStats();
        EditUserLogin editUserLogin = new EditUserLogin();
        MenuSwitches menuSwitches = new MenuSwitches();

        //Testcode

        //Opretter medlem.
        //Member test3 = new Member(1, 35,"Jesus",true,false,true,false,1500);
        Member stallone = new Member(2, 74,"Sylvester Stallone",true,false,true,false,1500);
        Member schwarzenegger = new Member(3, 73,"Arnold Schwarzenegger",true,false,true,false,1500);
        Member jStatham = new Member(4, 53,"Jason Statham",true,false,true,false,1500);
        Member jClaude = new Member(5, 60,"Jean-Claude Van Damme",true,false,true,false,1500);
        Member tCrews = new Member(6, 52,"Terry Crews",true,false,true,false,1500);
        Member jLi = new Member(7, 57,"Jet Li",true,false,true,false,1500);
        //Member test4 = new Member(2, 15,"Alpaca",true,false,true,true,1000);
        fileEditing.storeInObjectFile(stallone);
        fileEditing.storeInObjectFile(schwarzenegger);
        fileEditing.storeInObjectFile(jStatham);
        fileEditing.storeInObjectFile(jClaude);
        fileEditing.storeInObjectFile(jLi);
        fileEditing.storeInObjectFile(tCrews);



        //Menu
        boolean run = true;
        int menuChoice;
        String headertext = "Delfin Klubben.";
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Tilføj nyt medlem", "2. Rediger medlem", "3. Vis omsættelse og medlemmer i restance ",
                "4. Leg med Login", "5. Display content of all members", "6. Tilføje rekordtider til discipliner",
                "7. Display medlemmer MED tider", "8. Top 5", "9. Test den rigtige menu","Der findes flere, skriv noter",
                "0. Afslut"};
        while (run){
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = UserInput.inputInt(leadtext);
            switch (menuChoice){
                case 0: //End program
                    run = false;
                    break;
                case 1: //New membership
                    editMembership.newMembership();
                    break;
                case 2: //Edit membership
                    //asks user to type a single Name or #ID which it will return to memberData.
                    String memberData = fileEditing.findSpecificFileValues("Skriv navn eller #nr. på den person der skal redigeres: ");
                    //Uses the selected memberID via getMemberIdFromString() to access the connected ID.txt file and run editMembership(with user selected file).
                    editMembership.editMembership(fileEditing.readFileAndConvertToObject(editMembership.getMemberIDFromString(memberData)));
                    System.out.println(fileEditing.readFileAndConvertToObject(editMembership.getMemberIDFromString(memberData)).toString());

                    break;
                case 3: //Display total revenue and members with debt.
                    CurrentSubscriptions.showTotalRevenue();
                    CurrentSubscriptions.showMembersWithDebt();
                    break;
                case 4: //Play with Username input
                    ArrayList<String> testArray = new ArrayList<>();
                    Login chairman = new Login("Formand","JegErDejlig","Kurt Kurt", 1); //Hardcode for now
                    testArray.add(chairman.getUserName());
                    Login trainer = new Login("Traener","JegErDenHurtigeste","Hurtig Kurt", 2); //Hardcode for now
                    testArray.add(trainer.getUserName());
                    Login cashier = new Login("Kasser","JegElskerTal","Kvinde Kurt", 3); //Hardcode for now
                    testArray.add(cashier.getUserName());

                    System.out.println(UserInput.validationStringArray(testArray, "Skriv brugernavn:"));
                    break;
                case 5: //Display all members
                    for (String i : fileEditing.dataToArrayList("Members"))
                    System.out.println("\n"+i);
                    break;
                case 6: //Menu til at tilføje rekordtider til disciplin
                    Member member6 = fileEditing.findSpecificMemberAndConvert
                            (UserInput.inputString("Skriv navn eller nummer på personen du vil finde",false));
                    swimTimesAndStats.addSwimTimeToFile(member6);
                    break;
                case 7: //toString WITH times

                    Member member7 = fileEditing.findSpecificMemberAndConvert
                            (UserInput.inputString("Skriv navn eller nummer på personen du vil finde",false));

                    System.out.println(member7.toStringWithTimes());
                    break;
                case 8: //Display top 5 Switch
                    swimTimesAndStats.displayTop5();
                    break;
                case 9: //testI
                    menuSwitches.loginMenu();
                    break;
                case 10: //test af print tider..
                    Member member10 = fileEditing.readFileAndConvertToObject(123);
                    System.out.println(member10.getSeniorBrystTid());
                    System.out.println(member10.getSeniorButterflyTid());
                    System.out.println(member10.getSeniorCrawlTid());
                    System.out.println(member10.getSeniorRygCrawlTid());
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
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

