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
                    member.setJuniorButterflyTid(userInput.inputTimeDouble("Indtast tid"));
                    member.setJuniorButterfly("\nJunior bryst: ");
                    fileEditing.storeInObjectFile(member);
                    break;
                case 2:
                    member.setJuniorButterflyTid(userInput.inputTimeDouble("Indtast tid"));
                    member.setJuniorButterfly("\nJunior butterfly: ");
                    fileEditing.storeInObjectFile(member);
                    break;
                case 3:
                    member.setJuniorCrawlTid(userInput.inputTimeDouble("Indtast tid"));
                    member.setJuniorCrawl("\nJunior crawl: ");
                    fileEditing.storeInObjectFile(member);
                    break;
                case 4:
                    member.setJuniorRygcrawlTid(userInput.inputTimeDouble("Indtast tid"));
                    member.setJuniorRygcrawl("\nJunior rygcrawl: ");
                    fileEditing.storeInObjectFile(member);
                    break;
                case 5:
                    member.setSeniorBrystTid(userInput.inputTimeDouble("Indtast tid"));
                    member.setSeniorBryst("\nSenior bryst: ");
                    fileEditing.storeInObjectFile(member);
                    break;
                case 6:
                    member.setSeniorButterflyTid(userInput.inputTimeDouble("Indtast tid"));
                    member.setSeniorButterfly("\nSenior butterfly: ");
                    fileEditing.storeInObjectFile(member);
                    break;
                case 7:
                    member.setSeniorCrawlTid(userInput.inputTimeDouble("Indtast tid"));
                    member.setSeniorCrawl("\nSenior crawl: ");
                    fileEditing.storeInObjectFile(member);
                    break;
                case 8:
                    member.setSeniorRygCrawlTid(userInput.inputTimeDouble("Indtast tid"));
                    member.setSeniorRygCrawl("\nSenior rygcrawl: ");
                    fileEditing.storeInObjectFile(member);
                    break;
                case 9: //Terminates program (if needed).
                    run = false;
                default:
                    menu2.printMenu();
            }
        }

        System.out.println(member.toStringTimes());

    }

        void choseMemberToEdit(Member member) throws Exception {
        FileEditing fileEditing = new FileEditing();
        EditMembership editMembership = new EditMembership();


            //asks user to type a single Name or #ID which it will return to memberData.
            String memberData = fileEditing.findSpecificFileValues("Skriv navn eller #nr. på den person der skal redigeres: ");

            addSwimTimeToFile(fileEditing.readFileAndConvertToObject(editMembership.getMemberIDFromString(memberData)));

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

    void displayTop5() throws IOException {
            boolean run = true;
            int choice2;
            String headerText2 = "Menu til at tilføje rekordtider til svømmediscipliner";
            String leadText2 = "Indtast et tal for at tilføje til specifik disciplin";
            String[] menuItems2 = {"1. JuniorBryst", "2. JuniorButterfly", "3. JunirCrawl",
                    "4. JuniorRygcrawl", "5. SeniorBryst", "6. SeniorButterfly", "7. SeniorCrawl", "8. SeniorRygcrawl", "9. Gå tilbage til hovedmenu"};
            FileEditing fileEditing = new FileEditing();
            UserInput userInput = new UserInput();
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

}



