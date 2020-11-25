package com.delphin;

import java.io.IOException;
import java.util.ArrayList;

import static com.delphin.EditMembership.fileEditing;
import static com.delphin.UserInput.scan;

public class Main {

    void run() throws IOException {
        //Instances of classes
        EditMembership editMembership = new EditMembership();
        FileEditing fileEditing = new FileEditing();
        IDNumber idNumber = new IDNumber();
        CurrentSubscriptions currentSubscriptions = new CurrentSubscriptions();

        //Testcode
        ArrayList<String> testArray = new ArrayList<>();
        testArray.add("HEJ");
        testArray.add("NoO");
        UserInput.validationStringArray(testArray, "Skriv brugernavn:");
        //Opretter JESUS som medlem.
        Login Formand = new Login("Formand","JegErDejlig","Kurt Kurt");
        Login Traener = new Login("Traener","JegErDenHurtigeste","Hurtig Kurt");
        Login Kasser = new Login("Kasser","JegElskerTal","Kvinde Kurt");
        Member test3 = new Member(69, 35,"Jesus",true,false,true,true,1500);
        Member test4 = new Member(idNumber.newMemberID(), 15,"Jesus2",true,false,true,true,1000);
        fileEditing.createNewMemberObjectFile(test3);
        DisciplineFileRW disciplineFileRW = new DisciplineFileRW();
        disciplineFileRW.testerAddToFile();
        fileEditing.createNewMemberObjectFile(test4);

        CurrentSubscriptions.showTotalRevenue();



        String memberData = fileEditing.findSpecificFileValues("Skriv navn eller #nr. på den person der skal redigeres: ");
        editMembership.editMembership(fileEditing.readFileAndConvertToObject(editMembership.getMemberIDFromString(memberData)));

        System.out.println(fileEditing.readFileAndConvertToObject(editMembership.getMemberIDFromString(memberData)).toString());
        /*
        //Edit membership
        editMembership.editMembership(fileEditing.readFileAndConvertToObject(69));

         */
        //System.out.println(fileEditing.findSpecificFileValues("Skriv navn eller #nr. på den person der skal redigeres: ")); //Returner
        //fileEditing.dataToArrayList();

    }


    public static void main(String[] args) throws IOException {
        Main prg = new Main();
        prg.run();
    }

    void gammelKodetest(){
        //Nedestående tester om vi kan læse en fil, slette en givet string, og så display igen
        //fileEditing.displayTextFile();
        //fileEditing.removeLineFromText("hej");
        //fileEditing.displayTextFile();

        //Nedestående tester vores sortering. IT WORKS LEL
        //fileEditing.sortTextFile();

        //fileEditing.readSpecificFile("50");
        //editMembership.findCrazyMember();
        //System.out.println(editMembership.findCrazyMember());

        /*
        Member test = fileEditing.readFileAndConvertToObject(69); //henter JESUS medlemsnummer
        //System.out.println(test.toString()); //Viser Jesus som objekt
        //test.setActivity(false); //ændrer på ham som object
        //System.out.println(test.toString()); //viser ændringen
        fileEditing.createNewMemberObjectFile(test); //sætter ham tilbage i fil som object
        */

        //editMembership.newMembership();
        //System.out.println(fileEditing.findSpecificFileValues("Skriv navn eller #nr. på den person der skal redigeres: ")); //Returner
        //fileEditing.dataToArrayList();





    }
}

