package com.delphin;

import java.io.IOException;

import static com.delphin.FileEditing.JB;

public class MenuSwitches {

    //@author ludvig+frederik
    void loginMenu() throws IOException {
        EditUserLogin editUserLogin = new EditUserLogin();
        FileEditing fileEditing = new FileEditing();


        editUserLogin.newUser("Formand","JegErFormand","Kurt",1);
        editUserLogin.newUser("Traener","JegErTraener","Hurtigere Kurt",2);
        editUserLogin.newUser("Kasser","JegErKasser","Dame Kurt",3);
        editUserLogin.newUser("admin","admin","admin",4);
        editUserLogin.newUser("luk","luk","luk",9);

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
                break;
            case 1: //FormandsMenu
                System.out.println("Tilykke du er logget ind som Formand");
                formandMenu();
                break;
            case 2: //TraenerMenu
                System.out.println("Tilykke du er logget ind som Traener");
                traenerMenu();
                break;
            case 3: //KasserMenu
                System.out.println("Tilykke du er logget ind som Kasser");
                kasserMenu();
                break;
            case 4: //AdminMenu
                System.out.println("Tilykke du er admin, you win REEEEEEEEE PEPEGAPLS");
                adminMenu();
                break;
            case 9: //Luk
                run = false;
                break;
            default:
                loginMenu();

        }
    }
}

    //@author ludvig+frederik
   void formandMenu() throws IOException {

       //Instances
       FileEditing fileEditing = new FileEditing();
       EditMembership editMembership = new EditMembership();

       System.out.println("jahejmegatestFORMAND");
       //Menu
       boolean run = true;
       int menuChoice;
       String headertext = "Formands valgmuligheder";
       String leadtext = "Indtast en valgmulighed: ";
       String[] menuItems = {"1. Tilføj nyt medlem", "2. Rediger medlem", "3. Slet medlem",
               "4. ", "0. Log ud af din bruger"};
       while (run) {
           Menu menu = new Menu(headertext, leadtext, menuItems);
           menu.printMenu();
           menuChoice = UserInput.inputInt(leadtext);
           switch (menuChoice) {
               case 0: //End program
                   loginMenu();
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
                   formandMenu();
           }
       }
   }

       //@author ludvig+frederik
       void traenerMenu() throws IOException {
           //instances
           FileEditing fileEditing = new FileEditing();
           DisciplineFileRW disciplineFileRW = new DisciplineFileRW();
           EditMembership editMembership = new EditMembership();

           //print træner switchmenu
           System.out.println("jahejmegatestTRÆNER");
           //Menu
           boolean run = true;
           int menuChoice;
           String headertext = "Træner valgmuligheder";
           String leadtext = "Indtast en valgmulighed: ";
           String[] menuItems = {"1. Indtast bedste svømmetid", "2. Vis top5 svømmere indenfor alle discipliner", "0. Log ud af din bruger"};
           while (run) {
               Menu menu = new Menu(headertext, leadtext, menuItems);
               menu.printMenu();
               menuChoice = UserInput.inputInt(leadtext);
               switch (menuChoice) {
                   case 0: //End program
                       loginMenu();
                       break;
                   case 1: //Add new swimtime/best swimtime
                       String searchForID = fileEditing.findSpecificFileValues("Skriv navn eller #nr. på den person der skal redigeres: ");
                       disciplineFileRW.addSwimtimeToFile(fileEditing.readFileAndConvertToObject(editMembership.getMemberIDFromString(searchForID)));
                       break;
                   case 2: //Show top 5 swimmmers in disciplines
                       fileEditing.displayTop5File(JB);
                       break;
                   default:
                       traenerMenu();
               }
           }
       }

    //@author ludvig+frederik
    void kasserMenu() throws IOException {
        //print kasser swtichmenu
        System.out.println("jahejmegatestKASSER");
        //Menu
        boolean run = true;
        int menuChoice;
        String headertext = "Kasser valgmuligheder";
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Vis omsættelse", "2. Vis medlemmer i restance", "0. Log ud af din bruger"};
        while (run) {
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = UserInput.inputInt(leadtext);
            switch (menuChoice) {
                case 0: //End program
                    loginMenu();
                    break;
                case 1: //shows total revenue
                    CurrentSubscriptions.showTotalRevenue();
                    break;
                case 2: //shows memberARREARS?!
                    CurrentSubscriptions.showMembersWithDebt();
                    break;
                default:
                    kasserMenu();
            }
        }
    }

    //@author ludvig+frederik test push
    void adminMenu() throws IOException {

        //Instances
        FileEditing fileEditing = new FileEditing();
        EditMembership editMembership = new EditMembership();
        DisciplineFileRW disciplineFileRW = new DisciplineFileRW();

        //print admin swtichmenu
        System.out.println("admin virker kekw");
        //Menu
        boolean run = true;
        int menuChoice;
        String headertext = "admin valgmuligheder";
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Tilføj nyt medlem", "2. Rediger medlem", "3. Slet medlem",
                "4. Indtast bedste svømmetid", "5. Vis top5 svømmere indenfor alle discipliner",
                "6. Vis omsættelse", "7. Vis medlemmer i restance", "0. Log ud af din bruger"};
        while (run) {
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = UserInput.inputInt(leadtext);
            switch (menuChoice) {
                case 0: //End program
                    loginMenu();
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
                case 4: //Add new swimtime/best swimtime
                    String searchForID = fileEditing.findSpecificFileValues("Skriv navn eller #nr. på den person der skal redigeres: ");
                    disciplineFileRW.addSwimtimeToFile(fileEditing.readFileAndConvertToObject(editMembership.getMemberIDFromString(searchForID)));
                    break;
                case 5: //Show top 5 swimmmers in disciplines
                    fileEditing.displayTop5File(JB);
                    break;
                case 6: //shows total revenue
                    CurrentSubscriptions.showTotalRevenue();
                    break;
                case 7: //shows memberARREARS?!
                    CurrentSubscriptions.showMembersWithDebt();
                    break;
                default:
                    adminMenu();
            }

        }
    }
}
