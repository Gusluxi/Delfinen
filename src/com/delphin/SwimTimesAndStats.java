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
        boolean run = true;
        int choice2;
        String headerText2 = "Vælg dig ind på en disciplin, for at tilføje en tid!";
        String leadText2 = "Indtast den specifikke disciplins tal!";
        String[] menuItems2 = {"1. JuniorBryst", "2. JuniorButterfly", "3. JuniorCrawl",
                "4. JuniorRygcrawl", "5. SeniorBryst", "6. SeniorButterfly", "7. SeniorCrawl", "8. SeniorRygcrawl",
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
                    double time = userInput.inputTimeDouble("Indtast tid");
                    String askForPlace = placeWhereTimeWasRecorded(); //asks user to specify training/comp
                    String place = "Junior Bryst: " + askForPlace;
                    double lastPB = member.getJuniorBrystTid();
                    if (time <= lastPB){
                        member.setJuniorBrystTid(time);
                        member.setJuniorBryst(place);
                        String membersTimeAndInfo = stringWithTimeAndName(place,time,member);

                        fileEditing.addToFileTop5(membersTimeAndInfo,"Disciplines",JB);
                    }

                    break;
                case 2:
                    double time2 = userInput.inputTimeDouble("Indtast tid");
                    String askForPlace2 = placeWhereTimeWasRecorded();
                    String place2 = "Junior ButterFly: "+askForPlace2;
                    double lastPB2 = member.getJuniorButterflyTid();
                    if (time2<lastPB2) {
                        member.setJuniorButterflyTid(time2);
                        member.setJuniorButterfly(place2);
                        String membersTimeAndInfo2 = stringWithTimeAndName(place2,time2,member);

                        fileEditing.addToFileTop5(membersTimeAndInfo2,"Disciplines",JBF);
                    }

                    break;
                case 3:
                    double time3 = userInput.inputTimeDouble("Indtast tid");
                    String askForPlace3 = placeWhereTimeWasRecorded();
                    String place3 = "Junior Crawl: "+askForPlace3;

                    double lastPB3 = member.getJuniorCrawlTid();
                    if (time3<lastPB3) {
                        member.setJuniorCrawlTid(time3);
                        member.setJuniorCrawl(place3);
                        String membersTimeAndInfo3 = stringWithTimeAndName(place3,time3,member);

                        fileEditing.addToFileTop5(membersTimeAndInfo3,"Disciplines",JC);
                    }

                    break;
                case 4:
                    double time4 = userInput.inputTimeDouble("Indtast tid");
                    String askForPlace4 = placeWhereTimeWasRecorded();
                    String place4 = "Junior RygCrawl: "+askForPlace4;
                    double lastPB4 = member.getJuniorRygcrawlTid();
                    if (time4<lastPB4){
                        member.setJuniorRygcrawlTid(time4);
                        member.setJuniorRygcrawl(place4);
                        String membersTimeAndInfo4 = stringWithTimeAndName(place4,time4,member);

                        fileEditing.addToFileTop5(membersTimeAndInfo4,"Disciplines",JRC);
                    }

                    break;
                case 5:
                    double time5 = userInput.inputTimeDouble("Indtast tid");
                    String askForPlace5 = placeWhereTimeWasRecorded();
                    String place5 = "Senior Bryst: "+askForPlace5;
                    double lastPB5 = member.getSeniorBrystTid();
                    if(time5<lastPB5){
                        member.setSeniorBrystTid(time5);
                        member.setSeniorBryst(place5);
                        String membersTimeAndInfo5 = stringWithTimeAndName(place5,time5,member);

                        fileEditing.addToFileTop5(membersTimeAndInfo5,"Disciplines",SB);
                    }

                    break;
                case 6:
                    double time6 = userInput.inputTimeDouble("Indtast tid");
                    String askForPlace6 = placeWhereTimeWasRecorded();
                    String place6 = "Senior ButterFly: "+askForPlace6;
                    double lastPB6 = member.getSeniorButterflyTid();
                    if(time6<lastPB6){
                        member.setSeniorButterflyTid(time6);
                        member.setSeniorButterfly(place6);
                        String membersTimeAndInfo6 = stringWithTimeAndName(place6,time6,member);

                        fileEditing.addToFileTop5(membersTimeAndInfo6,"Disciplines",SBF);
                    }

                    break;
                case 7:
                    double time7 = userInput.inputTimeDouble("Indtast tid");
                    String askForPlace7 = placeWhereTimeWasRecorded();
                    String place7 = "Senior Crawl: "+askForPlace7;
                    double lastPB7 = member.getSeniorCrawlTid();
                    if(time7<lastPB7){
                        member.setSeniorCrawlTid(time7);
                        member.setSeniorCrawl(place7);
                        String membersTimeAndInfo7 = stringWithTimeAndName(place7,time7,member);

                        fileEditing.addToFileTop5(membersTimeAndInfo7,"Disciplines",SC);
                    }

                    break;
                case 8:
                    double time8 = userInput.inputTimeDouble("Indtast tid");
                    String askForPlace8 = placeWhereTimeWasRecorded();
                    String place8 = "Senior RygCrawl: "+askForPlace8;
                    double lastPB8 = member.getSeniorRygCrawlTid();
                    if(time8<lastPB8){
                        member.setSeniorRygCrawlTid(time8);
                        member.setSeniorRygCrawl(place8);
                        String membersTimeAndInfo8 = stringWithTimeAndName(place8,time8,member);

                        fileEditing.addToFileTop5(membersTimeAndInfo8,"Disciplines",SRC);
                    }

                    break;
                case 9: //Terminates program (if needed).
                    run = false;
                default:
                    menu2.printMenu();
            }
        }
        fileEditing.storeInObjectFile(member); //Save the updates to the member in the file.


    }//end of addSwimTimeToFile

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
                    placeOfTime += "Træning";
                    menu=false;
                    break;
                case 2: // Competition
                    placeOfTime += UserInput.inputString("Skriv hvad stævnet hed: ",true);
                    menu=false;
                    break;
                default:
                    menu3.printMenu();
            }

        }
        return placeOfTime;
    }

    //@author Mick
    //Used to avoid DRY in switch above.. It makes a String with given values
    String stringWithTimeAndName(String place, Double time,Member member){
        String timeConverted = Double.toString(time);
        String line = timeConverted + " Member: " + member.getName() + ". Time recorded here: "+place;
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
                        menu2.printMenu();
                }
            }

    } //end of DisplayTop5

    void choseMemberToEdit(Member member) throws Exception {

    }
}



