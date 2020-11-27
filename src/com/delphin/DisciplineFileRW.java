package com.delphin;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DisciplineFileRW {

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


    //@author Ludvig, men har bare genbrugt switch fra mariopizza?
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
                case 1:
                    double time = userInput.inputTimeDouble("Indtast tid");
                    String place = "Junior Bryst: Træning";
                    member.setJuniorBrystTid(time);
                    member.setJuniorBryst(place);
                    String membersTimeAndInfo = stringWithTimeAndName(place,time,member);

                    fileEditing.addToFileTop5(membersTimeAndInfo,"Disciplines",JB);
                    //fileEditing.storeInObjectFile(member);
                    break;
                case 2:
                    double time2 = userInput.inputTimeDouble("Indtast tid");
                    String place2 = "Junior ButterFly: Træning";
                    member.setJuniorButterflyTid(time2);
                    member.setJuniorButterfly(place2);
                    String membersTimeAndInfo2 = stringWithTimeAndName(place2,time2,member);

                    fileEditing.addToFileTop5(membersTimeAndInfo2,"Disciplines",JBF);
                    //fileEditing.storeInObjectFile(member);
                    break;
                case 3:
                    double time3 = userInput.inputTimeDouble("Indtast tid");
                    String place3 = "Junior Crawl: Træning";
                    member.setJuniorCrawlTid(time3);
                    member.setJuniorCrawl(place3);
                    String membersTimeAndInfo3 = stringWithTimeAndName(place3,time3,member);

                    fileEditing.addToFileTop5(membersTimeAndInfo3,"Disciplines",JC);
                    //fileEditing.storeInObjectFile(member);
                    break;
                case 4:
                    double time4 = userInput.inputTimeDouble("Indtast tid");
                    String place4 = "Junior RygCrawl: Træning";
                    member.setJuniorCrawlTid(time4);
                    member.setJuniorCrawl(place4);
                    String membersTimeAndInfo4 = stringWithTimeAndName(place4,time4,member);

                    fileEditing.addToFileTop5(membersTimeAndInfo4,"Disciplines",JRC);
                    //fileEditing.storeInObjectFile(member);
                    break;
                case 5:
                    double time5 = userInput.inputTimeDouble("Indtast tid");
                    String place5 = "Senior Bryst: Træning";
                    member.setSeniorCrawlTid(time5);
                    member.setSeniorCrawl(place5);
                    String membersTimeAndInfo5 = stringWithTimeAndName(place5,time5,member);

                    fileEditing.addToFileTop5(membersTimeAndInfo5,"Disciplines",SB);
                    //fileEditing.storeInObjectFile(member);
                    break;
                case 6:
                    double time6 = userInput.inputTimeDouble("Indtast tid");
                    String place6 = "Senior ButterFly: Træning";
                    member.setSeniorCrawlTid(time6);
                    member.setSeniorCrawl(place6);
                    String membersTimeAndInfo6 = stringWithTimeAndName(place6,time6,member);

                    fileEditing.addToFileTop5(membersTimeAndInfo6,"Disciplines",SBF);
                    //fileEditing.storeInObjectFile(member);
                    break;
                case 7:
                    double time7 = userInput.inputTimeDouble("Indtast tid");
                    String place7 = "Senior Crawl: Træning";
                    member.setSeniorCrawlTid(time7);
                    member.setSeniorCrawl(place7);
                    String membersTimeAndInfo7 = stringWithTimeAndName(place7,time7,member);

                    fileEditing.addToFileTop5(membersTimeAndInfo7,"Disciplines",SC);
                    //fileEditing.storeInObjectFile(member);
                    break;
                case 8:
                    double time8 = userInput.inputTimeDouble("Indtast tid");
                    String place8 = "Senior RygCrawl: Træning";
                    member.setSeniorCrawlTid(time8);
                    member.setSeniorCrawl(place8);
                    String membersTimeAndInfo8 = stringWithTimeAndName(place8,time8,member);

                    fileEditing.addToFileTop5(membersTimeAndInfo8,"Disciplines",SRC);
                    //fileEditing.storeInObjectFile(member);
                    break;
                case 9: //Terminates program (if needed).
                    run = false;
                    fileEditing.storeInObjectFile(member);
                default:
                    menu2.printMenu();
            }
        }

        System.out.println(member.toStringTimes() + " DEBUG LINJE, SLET MIG I DISCIPLINEFILERW");

    }//end of addSwimTimeToFile

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

        }

    void choseMemberToEdit(Member member) throws Exception {
        FileEditing fileEditing = new FileEditing();
        EditMembership editMembership = new EditMembership();


        //asks user to type a single Name or #ID which it will return to memberData.
        String memberData = fileEditing.findSpecificFileValues("Skriv navn eller #nr. på den person der skal redigeres: ");

        addSwimTimeToFile(fileEditing.readFileAndConvertToObject(editMembership.getMemberIDFromString(memberData)));

    }
}



