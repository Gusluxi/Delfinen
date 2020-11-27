package com.delphin;

import java.io.IOException;

public class MenuSwitches {

    void loginMenu() throws IOException {
        EditUserLogin editUserLogin = new EditUserLogin();
        FileEditing fileEditing = new FileEditing();
        editUserLogin.newUser("Formand","JegErFormand","Kurt",1);
        editUserLogin.newUser("Traener","JegErTraener","Hurtigere Kurt",2);
        editUserLogin.newUser("Kasser","JegErKasser","Dame Kurt",3);

    boolean run = true;
    int menuChoice;
    String userNameText = "Venligst indtast dit Username: ";
    String passwordText = "Venligst indtast dit Password: ";

        while (run){
        String  userName = UserInput.inputString(userNameText, false);
        String password = UserInput.inputString(passwordText, false);
        menuChoice = (fileEditing.getUserStatusFromFile(userName,password));
        switch (menuChoice){
            case 0: //End program
                System.out.println("Wrong Username and or Password");
                loginMenu();
                run = false;
                break;
            case 1: //testA new membership
                System.out.println("Tilykke du er logget ind som Formand");
                formandMenu();
                break;
            case 2: //testB edit membership
                System.out.println("Tilykke du er logget ind som Traener");
                break;
            case 3: //testC Display total revenue and members with debt.
                System.out.println("Tilykke du er logget ind som Kasser");
                break;
            case 4: //testD Play with Username input
                break;
            case 5: //testE
                break;
            case 6: //testF Menu til at tilføje rekordtider til disciplin
                break;
            case 7: //testG
                break;
            case 8: //test MICK
                break;
            case 9: //testI
                break;
            default:
                loginMenu();

        }
    }
}

   void formandMenu() throws IOException {

   //Instances
    FileEditing fileEditing = new FileEditing();
    EditUserLogin editUserLogin = new EditUserLogin();
    IDNumber idNumber = new IDNumber();
    CurrentSubscriptions currentSubscriptions = new CurrentSubscriptions();
    DisciplineFileRW disciplineFileRW = new DisciplineFileRW();
    MenuSwitches menuSwitches = new MenuSwitches();
    EditMembership editMembership = new EditMembership();

        System.out.println("jahejmegatestFORMAND");
        //Menu
        boolean run = true;
        int menuChoice;
        String headertext = "Formands valgmuligheder";
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Tilføj nyt medlem", "2. Rediger medlem", "3. Slet medlem",
                "4. ", "5.", "6. ", "7.", "8. ", "9. ", "0. Afslut"};
        while (run) {
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = UserInput.inputInt(leadtext);
            switch (menuChoice) {
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
                default:
                    menu.printMenu();
            }
        }

    }

}
