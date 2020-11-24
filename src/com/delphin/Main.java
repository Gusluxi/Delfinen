package com.delphin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    void run() throws IOException {
        //Instances of classes
        EditMembership editMembership = new EditMembership();
        FileEditing fileEditing = new FileEditing();
        IDNumber idNumber = new IDNumber();


        //Testcode
                    //Opretter JESUS som medlem.
        Member test3 = new Member(idNumber.newMemberID(), 35,"Jesus",true,false,true,false,1500);
        editMembership.createNewMemberObjectFile(test3);


        Member test = editMembership.readFileAndConvertToObject(69); //henter JESUS medlemsnummer
        System.out.println(test.toString()); //viser ham som object
        System.out.println("\n\n\n");
        test.setActivity(false); //ændrer på ham som object
        System.out.println(test.toString()); //viser ændringen
        editMembership.createNewMemberObjectFile(test); //sætter ham tilbage i fil som object
        //POGGERS DUDE


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

        //editMembership.newMembership();
    }
}

