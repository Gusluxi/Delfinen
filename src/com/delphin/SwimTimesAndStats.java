package com.delphin;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SwimTimesAndStats {

    //When asked for directory, DELPHIN works as a path name.
    static final String DELPHIN = "com\\delphin";
    static final String JB = "JuniorBryst";
    static final String JBF = "JuniorButterfly";
    static final String JC = "JuniorCrawl";
    static final String JRC = "JuniorRygcrawl";
    static final String SB = "SeniorBryst";
    static final String SBF = "SeniorButterfly";
    static final String SC = "SeniorCrawl";
    static final String SRC = "SeniorRygcrawl";


    //@author Ludvig,
    //A switch where you can add times to specific disciplines
    void addSwimTimeToFile(Member member) throws IOException {
        //Checks if member is Junior or Senior
        boolean junior = member.isJunior();
        int decideSwitch = 0;
        if (junior) {
            juniorSwitch(member);
        }
        else {
            seniorSwitch(member);
        }
    }


    void seniorSwitch(Member member) throws IOException {
        System.out.println(member.getName());
        boolean run = true;
        String date = TimeAndDate.currentDate();
        int choice2;
        String headerText2 = "Vælg dig ind på en disciplin, for at tilføje en tid!";
        String leadText2 = "Indtast den specifikke disciplins tal!";
        String[] menuItems2 = {"1. SeniorBryst", "2. SeniorButterfly", "3. SeniorCrawl", "4. SeniorRygcrawl",
                "9. Gå tilbage til hovedmenu"};
        FileEditing fileEditing = new FileEditing();
        UserInput userInput = new UserInput();
        Menu menu2 = new Menu(headerText2, leadText2, menuItems2); // Create new menu instance

        while (run) {
            menu2.printMenu(); // Print menu
            choice2 = UserInput.inputInt(leadText2);
            switch (choice2) {

                // Each case asks for the new Time to assign to a member.
                // If the time given is worse than the old PersonalBest, it isn't registered.
                // If better, it stores it with setters and at the end of the switch, it is stored in the file.
                // @author Mick - "I AM AWARE IT'S MESSY AND DRY, BUT I DON'T KNOW HOW TO USE A METHOD AS A PARAMETER"
                case 1:
                    double time5 = userInput.inputTimeDouble("Indtast tid");
                    String askForPlace5 = placeWhereTimeWasRecorded();
                    String place5 = askForPlace5+ " "+SB+". " + date;
                    double lastPB5 = member.getSeniorChestTime();
                    if (lastPB5 <1){
                        lastPB5 = 900;
                    }
                    if(time5<lastPB5){
                        member.setSeniorChestTime(time5);
                        member.setSeniorChest(place5);
                        String membersTimeAndInfo5 = stringWithTimeAndName(place5,time5,member);

                        fileEditing.addToFileTop5(membersTimeAndInfo5,"Disciplines",SB);
                    }

                    break;
                case 2:
                    double time6 = userInput.inputTimeDouble("Indtast tid");
                    String askForPlace6 = placeWhereTimeWasRecorded();
                    String place6 = askForPlace6+ " "+SBF+". " + date;
                    double lastPB6 = member.getSeniorButterflyTime();
                    if (lastPB6 <1){
                        lastPB6 = 900;
                    }
                    if(time6<lastPB6){
                        member.setSeniorButterflyTime(time6);
                        member.setSeniorButterfly(place6);
                        String membersTimeAndInfo6 = stringWithTimeAndName(place6,time6,member);

                        fileEditing.addToFileTop5(membersTimeAndInfo6,"Disciplines",SBF);
                    }

                    break;
                case 3:
                    double time7 = userInput.inputTimeDouble("Indtast tid");
                    String askForPlace7 = placeWhereTimeWasRecorded();
                    String place7 = askForPlace7+ " "+SC+". " + date;
                    double lastPB7 = member.getSeniorCrawlTime();
                    if (lastPB7 <1){
                        lastPB7 = 900;
                    }
                    if(time7<lastPB7){
                        member.setSeniorCrawlTime(time7);
                        member.setSeniorCrawl(place7);
                        String membersTimeAndInfo7 = stringWithTimeAndName(place7,time7,member);

                        fileEditing.addToFileTop5(membersTimeAndInfo7,"Disciplines",SC);
                    }

                    break;
                case 4:
                    double time8 = userInput.inputTimeDouble("Indtast tid");
                    String askForPlace8 = placeWhereTimeWasRecorded();
                    String place8 = askForPlace8+ " "+SRC+". " + date;
                    double lastPB8 = member.getSeniorBackCrawlTime();
                    if (lastPB8 <1){
                        lastPB8 = 900;
                    }
                    if(time8<lastPB8){
                        member.setSeniorBackCrawlTime(time8);
                        member.setSeniorBackCrawl(place8);
                        String membersTimeAndInfo8 = stringWithTimeAndName(place8,time8,member);

                        fileEditing.addToFileTop5(membersTimeAndInfo8,"Disciplines",SRC);
                    }

                    break;
                case 9: //Terminates program (if needed).
                    run = false;
                default:
                    System.out.println("");
            }
        }
        fileEditing.storeInObjectFile(member); //Save the updates to the member in the file.
    }

    void juniorSwitch(Member member) throws IOException {
        System.out.println(member.getName());
        boolean run = true;
        String date = TimeAndDate.currentDate();
        int choice2;
        String headerText2 = "Vælg dig ind på en disciplin, for at tilføje en tid!";
        String leadText2 = "Indtast den specifikke disciplins tal!";
        String[] menuItems2 = {"1. Bryst", "2. Butterfly", "3. Crawl",
                "4. Rygcrawl", "9. Gå tilbage til hovedmenu"};
        FileEditing fileEditing = new FileEditing();
        UserInput userInput = new UserInput();
        Menu menu2 = new Menu(headerText2, leadText2, menuItems2); // Create new menu instance
        while (run) {
            menu2.printMenu(); // Print menu
            choice2 = UserInput.inputInt(leadText2);
            switch (choice2) {

                // Each case asks for the new Time to assign to a member.
                // If the time given is worse than the old PersonalBest, it isn't registered.
                // If better, it stores it with setters and at the end of the switch, it is stored in the file.
                // @author Mick - "I AM AWARE IT'S MESSY AND DRY, BUT I DON'T KNOW HOW TO USE A METHOD AS A PARAMETER"
                case 1:
                    double time = userInput.inputTimeDouble("Indtast tid");
                    String askForPlace = placeWhereTimeWasRecorded(); //asks user to specify training/comp
                    String place = askForPlace + " "+JB+". " + date;
                    double lastPB = member.getJuniorChestTime();
                    if (lastPB <1){
                        lastPB = 900;
                    }
                    if (time <= lastPB){
                        member.setJuniorChestTime(time);
                        member.setJuniorChest(place);
                        String membersTimeAndInfo = stringWithTimeAndName(place,time,member);

                        fileEditing.addToFileTop5(membersTimeAndInfo,"Disciplines",JB);
                    }

                    break;
                case 2:
                    double time2 = userInput.inputTimeDouble("Indtast tid");
                    String askForPlace2 = placeWhereTimeWasRecorded();
                    String place2 = askForPlace2+ " "+JBF+". " +date;
                    double lastPB2 = member.getJuniorButterflyTime();
                    if (lastPB2 <1){
                        lastPB2 = 900;
                    }
                    if (time2<lastPB2) {
                        member.setJuniorButterflyTime(time2);
                        member.setJuniorButterfly(place2);
                        String membersTimeAndInfo2 = stringWithTimeAndName(place2,time2,member);

                        fileEditing.addToFileTop5(membersTimeAndInfo2,"Disciplines",JBF);
                    }

                    break;
                case 3:
                    double time3 = userInput.inputTimeDouble("Indtast tid");

                    String askForPlace3 = placeWhereTimeWasRecorded();
                    String place3 = askForPlace3+ " "+JC+". " +date;

                    double lastPB3 = member.getJuniorCrawlTime();
                    if (lastPB3 <1){
                        lastPB3 = 900;
                    }
                    if (time3<lastPB3) {
                        member.setJuniorCrawlTime(time3);
                        member.setJuniorCrawl(place3);
                        String membersTimeAndInfo3 = stringWithTimeAndName(place3,time3,member);

                        fileEditing.addToFileTop5(membersTimeAndInfo3,"Disciplines",JC);
                    }

                    break;
                case 4:
                    double time4 = userInput.inputTimeDouble("Indtast tid");

                    String askForPlace4 = placeWhereTimeWasRecorded();
                    String place4 = askForPlace4 + " "+JRC+". " + date;
                    double lastPB4 = member.getJuniorBackcrawlTime();
                    if (lastPB4 <1){
                        lastPB4 = 900;
                    }
                    if (time4<lastPB4){
                        member.setJuniorBackcrawlTime(time4);
                        member.setJuniorBackcrawl(place4);
                        String membersTimeAndInfo4 = stringWithTimeAndName(place4,time4,member);

                        fileEditing.addToFileTop5(membersTimeAndInfo4,"Disciplines",JRC);
                    }

                    break;

                case 9: //Terminates program (if needed).
                    run = false;
                default:
                    System.out.println("");
            }
        }
        fileEditing.storeInObjectFile(member); //Save the updates to the member in the file.
    }

    //@author Mick
    //Switch case to ask user, where the time was recorded (Træning eller stævne).
    String placeWhereTimeWasRecorded() {
        boolean menu = true;
        int choice2;
        String headerText2 = "Hvor blev tiden noteret?";
        String leadText2 = "Indtast tallet for stedet:";
        String[] menuItems2 = {"1. Træning", "2. Stævne"};

        Menu menu3 = new Menu(headerText2, leadText2, menuItems2); // Create new menu instance
        String placeOfTime = "";
        while (menu) {
            menu3.printMenu(); // Print menu
            choice2 = UserInput.inputInt(leadText2);
            switch (choice2) {
                case 1: // Training exercise
                    placeOfTime += "Træning.";
                    menu=false;
                    break;
                case 2: // Competition
                    placeOfTime += UserInput.inputString("Skriv hvad stævnet hed, og hvad plads konkurrenten fik: ",false);
                    menu=false;
                    break;
                default:
                    System.out.println("");
            }

        }
        return placeOfTime;
    }

    //@author Mick
    //Used to avoid DRY in switch above.. It makes a String with given values
    String stringWithTimeAndName(String place, Double time,Member member){
        String timeConverted = Double.toString(time);
        String date = TimeAndDate.currentDate();
        String line = timeConverted + " Member: " + member.getName() + ". Time recorded here: "+place+" - "+date+" \n"; //@author Gustav
        return line;
    }

    //@author Mick
    //Displays the top5 of a given filename.
    void displayTop5File(String fileName) throws IOException {

        File file = new File("src\\Disciplines\\"+fileName+".txt");
        Scanner readFile = new Scanner(file);
        FileEditing fileEditing = new FileEditing();
        fileEditing.sortTextFile(file); //Sort method from below
        for (int i = 0; i<5; i++){
            System.out.println(readFile.nextLine());
        }
    }

    //@author Mick
    //A switch menu that displays top5 dependent of which discipline you want
    void displayTop5() throws IOException {
            boolean run = true;
            int choice2;
            String headerText2 = "Menu til at tilføje rekordtider til svømmediscipliner";
            String leadText2 = "Indtast et tal for at tilføje til specifik disciplin";
            String[] menuItems2 = {"1. JuniorBryst", "2. JuniorButterfly", "3. JunirCrawl",
                    "4. JuniorRygcrawl", "5. SeniorBryst", "6. SeniorButterfly", "7. SeniorCrawl", "8. SeniorRygcrawl", "9. Gå tilbage til hovedmenu"};
            Menu menu2 = new Menu(headerText2, leadText2, menuItems2); // Create new menu instance

            while (run) {
                menu2.printMenu(); // Print menu
                choice2 = UserInput.inputInt(leadText2);
                switch (choice2) {
                    case 1:
                       displayTop5File(JB);
                        break;
                    case 2:
                        displayTop5File(JBF);
                        break;
                    case 3:
                        displayTop5File(JC);
                        break;
                    case 4:
                        displayTop5File(JRC);
                        break;
                    case 5:
                        displayTop5File(SB);
                        break;
                    case 6:
                        displayTop5File(SBF);
                        break;
                    case 7:
                        displayTop5File(SC);
                        break;
                    case 8:
                        displayTop5File(SRC);
                        break;
                    case 9: //Terminates program (if needed).
                        run = false;
                    default:
                        System.out.println("");
                }
            }
    }

    //@author Mick
    //Switch menu to set a users time to 0 if needed.
    void deleteMembersTime(Member member) throws Exception {
        boolean run = true;
        int choice2;
        String headerText2 = "Menu til at slette en svømmetid fra medlem.";
        String leadText2 = "Vælg hvilken disciplin, som skal slettes fra medlemmet:";
        String[] menuItems2 = {"1. JuniorBryst", "2. JuniorButterfly", "3. JuniorCrawl",
                "4. JuniorRygcrawl", "5. SeniorBryst", "6. SeniorButterfly", "7. SeniorCrawl", "8. SeniorRygcrawl",
                "9. Gå tilbage til hovedmenu"};
        Menu menu2 = new Menu(headerText2, leadText2, menuItems2); // Create new menu instance
        FileEditing fileEditing = new FileEditing();

        while (run) {
            System.out.println(member.getName());
            menu2.printMenu(); // Print menu
            System.out.println(member.toStringTimes());
            choice2 = UserInput.inputInt(leadText2);
            switch (choice2) {
                case 1: //Junior Bryst
                    String searchFor = ""+Double.toString(member.getJuniorChestTime()) + " Member: "+member.getName(); // get the time
                    fileEditing.removeLineFromText(searchFor, "JuniorBryst"); //remove the time
                    member.setJuniorChestTime(0);
                    member.setJuniorChest(null);
                    break;
                case 2: //Junior Butterfly
                    String searchFor2 = ""+Double.toString(member.getJuniorButterflyTime()) + " Member: "+member.getName();
                    fileEditing.removeLineFromText(searchFor2, "JuniorButterfly");
                    member.setJuniorButterflyTime(0);
                    member.setJuniorButterfly(null);
                    break;
                case 3: //Junior Crawl
                    String searchFor3 = ""+Double.toString(member.getJuniorCrawlTime()) + " Member: "+member.getName();
                    fileEditing.removeLineFromText(searchFor3, "JuniorCrawl");
                    member.setJuniorCrawlTime(0);
                    member.setJuniorCrawl(null);
                    break;
                case 4: //Junior RygCrawl
                    String searchFor4 = ""+Double.toString(member.getJuniorBackcrawlTime()) + " Member: "+member.getName();
                    fileEditing.removeLineFromText(searchFor4, "JuniorRygcrawl");
                    member.setJuniorBackcrawlTime(0);
                    member.setJuniorBackcrawl(null);
                    break;
                case 5: //Senior Bryst
                    String searchFor5 = ""+Double.toString(member.getSeniorChestTime()) + " Member: "+member.getName();
                    fileEditing.removeLineFromText(searchFor5, "SeniorBryst");
                    member.setSeniorChestTime(0);
                    member.setSeniorChest(null);
                    break;
                case 6: //Senior Butterfly
                    String searchFor6 = ""+Double.toString(member.getSeniorButterflyTime()) + " Member: "+member.getName();
                    fileEditing.removeLineFromText(searchFor6, "SeniorButterfly");
                    member.setSeniorButterflyTime(0);
                    member.setSeniorButterfly(null);
                    break;
                case 7: //Senior Crawl
                    String searchFor7 = ""+Double.toString(member.getSeniorCrawlTime()) + " Member: "+member.getName();
                    fileEditing.removeLineFromText(searchFor7, "SeniorCrawl");
                    member.setSeniorCrawlTime(0);
                    member.setSeniorCrawl(null);
                    break;
                case 8: //Senior RygCrawl
                    String searchFor8 = ""+Double.toString(member.getSeniorBackCrawlTime()) + " Member: "+member.getName();
                    fileEditing.removeLineFromText(searchFor8, "SeniorRygcrawl");
                    member.setSeniorBackCrawlTime(0);
                    member.setSeniorBackCrawl(null);
                    break;
                case 9: //Terminates program (if needed).
                    run = false;
                default:
                    System.out.println("");
            }
        }
    fileEditing.storeInObjectFile(member);  //Store changes
    }
}




