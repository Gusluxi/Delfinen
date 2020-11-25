package com.delphin;

import java.io.IOException;

import static com.delphin.UserInput.scan;

public class DisciplineFileRW {
    void testerAddToFile() throws IOException {
        boolean run = true;
        int choice2;
        String headerText2 = "Menu til at tilføje rekordtider til svømmediscipliner";
        String leadText2 = "Indtast et tal for at tilføj til specifik disciplin";
        String[] menuItems2 = {"1. JuniorBryst", "2. JuniorButterfly", "3. JunirCrawl",
                "4. JuniorRygcrawl","5. SeniorBryst","6. SeniorButterfly","7. SeniorCrawl", "8. SeniorRygcrawl", "9. Afslut program."};
        FileEditing fileEditing = new FileEditing();
        Menu menu2 = new Menu(headerText2, leadText2, menuItems2); // Create new menu instance
        menu2.printMenu(); // Print menu
        while (run) {
            choice2 = UserInput.inputInt(leadText2);
            scan.nextLine();
            switch (choice2) {
                case 1:
                    fileEditing.addToFile(UserInput.inputString("Skriv hvad der skal tilføjes til filen", false), "JuniorBryst");
                    break;
                case 2:
                    fileEditing.addToFile(UserInput.inputString("Skriv hvad der skal tilføjes til filen", false), "JuniorButterfly");
                    break;
                case 3:
                    fileEditing.addToFile(UserInput.inputString("Skriv hvad der skal tilføjes til filen", false), "JuniorCrawl");
                    break;
                case 4:
                    fileEditing.addToFile(UserInput.inputString("Skriv hvad der skal tilføjes til filen", false), "JuniorRygcrawl");
                    break;
                case 5:
                    fileEditing.addToFile(UserInput.inputString("Skriv hvad der skal tilføjes til filen", false), "SeniorBryst");
                    break;
                case 6:
                    fileEditing.addToFile(UserInput.inputString("Skriv hvad der skal tilføjes til filen", false), "SeniorButterfly");
                    break;
                case 7:
                    fileEditing.addToFile(UserInput.inputString("Skriv hvad der skal tilføjes til filen", false), "SeniorCrawl");
                    break;
                case 8:
                    fileEditing.addToFile(UserInput.inputString("Skriv hvad der skal tilføjes til filen", false), "SeniorRygcrawl");
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

