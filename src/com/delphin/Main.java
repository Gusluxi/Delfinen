package com.delphin;

import java.io.IOException;

public class Main {

    void run() throws IOException {
        IDNumber idNumber = new IDNumber();


        Member test = new Member(idNumber.newMemberID(),55, "Mick");
        test.methodLol(test);
        System.out.println(test.toString());

        Member test2 = new Member(idNumber.newMemberID(),14,"yaayEet");
        test2.methodLol(test2);
    }


    public static void main(String[] args) throws IOException {

        Main prg = new Main();
        prg.run();

    }
}
