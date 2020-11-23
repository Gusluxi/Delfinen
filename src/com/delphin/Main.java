package com.delphin;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        IDNumber idNumber = new IDNumber();


    Member test = new Member(15,"Mick", idNumber.newMemberID());
    test.methodLol(test);
        System.out.println(test.toString());

    Member test2 = new Member(12,"lel",idNumber.newMemberID());
    test2.methodLol(test2);

    }
}
