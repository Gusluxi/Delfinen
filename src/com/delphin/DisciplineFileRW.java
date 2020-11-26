package com.delphin;

import java.io.IOException;

import static com.delphin.UserInput.scan;

public class DisciplineFileRW {

    //@author Ludvig, men har bare genbrugt switch fra mariopizza?
    void testerAddToFile() throws IOException {
        boolean run = true;
        int choice2;
        String headerText2 = "Menu til at tilføje rekordtider til svømmediscipliner";
        String leadText2 = "Indtast et tal for at tilføje til specifik disciplin";
        String[] menuItems2 = {"1. JuniorBryst", "2. JuniorButterfly", "3. JunirCrawl",
                "4. JuniorRygcrawl","5. SeniorBryst","6. SeniorButterfly","7. SeniorCrawl", "8. SeniorRygcrawl", "9. Afslut program."};
        FileEditing fileEditing = new FileEditing();
        Menu menu2 = new Menu(headerText2, leadText2, menuItems2); // Create new menu instance
        menu2.printMenu(); // Print menu
        while (run) {
            choice2 = UserInput.inputInt(leadText2);
            switch (choice2) {
                case 1:
                    fileEditing.addToFile(UserInput.inputString("Skriv hvad der skal tilføjes til filen", false), "JuniorBryst");
                    run = false;
                    break;
                case 2:
                    fileEditing.addToFile(UserInput.inputString("Skriv hvad der skal tilføjes til filen", false), "JuniorButterfly");
                    run = false;
                    break;
                case 3:
                    fileEditing.addToFile(UserInput.inputString("Skriv hvad der skal tilføjes til filen", false), "JuniorCrawl");
                    run = false;
                    break;
                case 4:
                    fileEditing.addToFile(UserInput.inputString("Skriv hvad der skal tilføjes til filen", false), "JuniorRygcrawl");
                    run = false;
                    break;
                case 5:
                    fileEditing.addToFile(UserInput.inputString("Skriv hvad der skal tilføjes til filen", false), "SeniorBryst");
                    run = false;
                    break;
                case 6:
                    fileEditing.addToFile(UserInput.inputString("Skriv hvad der skal tilføjes til filen", false), "SeniorButterfly");
                    run = false;
                    break;
                case 7:
                    fileEditing.addToFile(UserInput.inputString("Skriv hvad der skal tilføjes til filen", false), "SeniorCrawl");
                    run = false;
                    break;
                case 8:
                    fileEditing.addToFile(UserInput.inputString("Skriv hvad der skal tilføjes til filen", false), "SeniorRygcrawl");
                    run = false;
                    break;
                case 9: //Terminates program (if needed).
                    System.out.println("Afslutter program...");
                        run = false;
                default:
                    menu2.printMenu();
            }
        }

        }
    }

