package com.delphin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    void run() throws IOException {
        // IDNumber idNumber = new IDNumber();
        // Member test3 = new Member(idNumber.newMemberID(), 35,"Jesus",true,false,true,false,1500);

        //EditMembership editMembership = new EditMembership();
        //editMembership.newMembership();

        FileEditing fileEditing = new FileEditing();

        // FIX INPUT STRING
        //String word = UserInput.inputString("Skriv det du vil fjerne");


        //Nedestående tester om vi kan læse en fil, slette en givet string, og så display igen
        //fileEditing.displayTextFile();
        //fileEditing.removeLineFromText("hej");
        //fileEditing.displayTextFile();

        //Nedestående tester vores sortering. IT WORKS LEL
        //fileEditing.sortTextFile();
    }


    public static void main(String[] args) throws IOException {

        Main prg = new Main();
        prg.run();

    }
}
