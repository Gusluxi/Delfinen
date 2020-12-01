package com.delphin;

import java.io.IOException;


public class Main {

    static void testSubjects() throws IOException {
        FileEditing fileEditing = new FileEditing();
        //Opretter medlem.
        //Member test3 = new Member(1, 35,"Jesus",true,false,true,false,1500);
        Member stallone = new Member(2, 74,"Sylvester Stallone",true,false,true,false,1500);
        Member schwarzenegger = new Member(3, 73,"Arnold Schwarzenegger",true,false,true,false,1500);
        Member jStatham = new Member(4, 53,"Jason Statham",true,false,true,false,1500);
        Member jClaude = new Member(5, 60,"Jean-Claude Van Damme",true,false,true,false,1500);
        Member tCrews = new Member(6, 52,"Terry Crews",true,false,true,false,1500);
        Member jLi = new Member(7, 57,"Jet Li",true,false,true,false,1500);

        //Member test4 = new Member(2, 15,"Alpaca",true,false,true,true,1000);
        fileEditing.storeInObjectFile(stallone);
        fileEditing.storeInObjectFile(schwarzenegger);
        fileEditing.storeInObjectFile(jStatham);
        fileEditing.storeInObjectFile(jClaude);
        fileEditing.storeInObjectFile(jLi);
        fileEditing.storeInObjectFile(tCrews);
    }


    public static void main(String[] args) throws Exception {
        //testSubjects();
        MenuSwitches menuSwitches = new MenuSwitches();
        menuSwitches.loginMenu();
    }

}

