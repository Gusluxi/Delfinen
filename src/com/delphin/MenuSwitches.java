package com.delphin;

import java.io.IOException;

import static com.delphin.FileEditing.JB;

public class MenuSwitches {
    static EditUserLogin editUserLogin = new EditUserLogin();
    static FileEditing fileEditing = new FileEditing();
    static EditMembership editMemberShip = new EditMembership();
    void loginMenu() throws IOException {

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
                traenerMenu();
                break;
            case 3: //testC Display total revenue and members with debt.
                System.out.println("Tilykke du er logget ind som Kasser");
                kasserMenu();
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
       EditMembership editMembership = new EditMembership();

       System.out.println("jahejmegatestFORMAND");
       //Menu
       boolean run = true;
       int menuChoice;
       String headertext = "Formands valgmuligheder";
       String leadtext = "Indtast en valgmulighed: ";
       String[] menuItems = {"1. Tilføj nyt medlem", "2. Rediger medlem", "3. Slet medlem",
               "4. ", "0. Afslut"};
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

       void traenerMenu() throws IOException {
           //instances
           FileEditing fileEditing = new FileEditing();
           DisciplineFileRW disciplineFileRW = new DisciplineFileRW();
           //print træner switchmenu
           System.out.println("jahejmegatestTRÆNER");
           //Menu
           boolean run = true;
           int menuChoice;
           String headertext = "Træner valgmuligheder";
           String leadtext = "Indtast en valgmulighed: ";
           String[] menuItems = {"1. Indtast bedste svømmetid", "2. Vis top5 svømmere indenfor alle discipliner", "0. Afslut"};
           while (run) {
               Menu menu = new Menu(headertext, leadtext, menuItems);
               menu.printMenu();
               menuChoice = UserInput.inputInt(leadtext);
               switch (menuChoice) {
                   case 0: //End program
                       loginMenu();
                       break;
                   case 1: //shows total revenue
                       String searchForID = fileEditing.findSpecificFileValues("Skriv navn eller #nr. på den person der skal redigeres: ");
                       disciplineFileRW.addSwimtimeToFile(fileEditing.readFileAndConvertToObject(editMemberShip.getMemberIDFromString(searchForID)));
                       break;
                   case 2: //shows memberARREARS?!
                       fileEditing.displayTop5File(JB);
                       break;
                   default:
                       traenerMenu();
               }
           }
       }

    void kasserMenu() throws IOException {
        //print kasser swtichmenu
        System.out.println("jahejmegatestKASSER");
        //Menu
        boolean run = true;
        int menuChoice;
        String headertext = "Kasser valgmuligheder";
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Vis omsættelse", "2. Vis medlemmer i restance", "0. Afslut"};
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


}
