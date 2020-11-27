package com.delphin;

import java.io.IOException;

import static com.delphin.UserInput.scan;

public class DisciplineFileRW {

    //@author Ludvig, men har bare genbrugt switch fra mariopizza?
    //A switch where you can add times to specific disciplines
    void addSwimtimeToFile(Member member) throws IOException {
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
                    member.setJuniorBrystTid(userInput.inputTimeDouble("Indtast tid"));
                    member.setJuniorBryst("\nJunior bryst: ");

                    break;
                case 2:
                    member.setJuniorButterflyTid(userInput.inputTimeDouble("Indtast tid"));
                    member.setJuniorButterfly("\nJunior butterfly: ");
                    break;
                case 3:
                    member.setJuniorCrawlTid(userInput.inputTimeDouble("Indtast tid"));
                    member.setJuniorCrawl("\nJunior crawl: ");
                    break;
                case 4:
                    member.setJuniorRygcrawlTid(userInput.inputTimeDouble("Indtast tid"));
                    member.setJuniorRygcrawl("\nJunior rygcrawl: ");
                    break;
                case 5:
                    member.setSeniorBrystTid(userInput.inputTimeDouble("Indtast tid"));
                    member.setSeniorBryst("\nSenior bryst: ");
                    break;
                case 6:
                    member.setJuniorButterflyTid(userInput.inputTimeDouble("Indtast tid"));
                    member.setSeniorButterfly("\nSenior butterfly: ");
                    break;
                case 7:
                    member.setSeniorCrawlTid(userInput.inputTimeDouble("Indtast tid"));
                    member.setSeniorCrawl("\nSenior crawl: ");
                    break;
                case 8:
                    member.setSeniorRygCrawlTid(userInput.inputTimeDouble("Indtast tid"));
                    member.setSeniorRygCrawl("\nSenior rygcrawl: ");
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

            addSwimtimeToFile(fileEditing.readFileAndConvertToObject(editMembership.getMemberIDFromString(memberData)));



        }



    }

