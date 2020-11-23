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

        fileEditing.removeLineFromText("Hej");

    }


    public static void main(String[] args) throws IOException {

        Main prg = new Main();
        prg.run();

    }
}
