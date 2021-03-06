package com.delphin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class IDNumber {

        private final String FILENAME = "src\\com\\delphin\\MemberID.txt";
        private int memberID;

        public void setMemberID(int memberID) {
            this.memberID = memberID;
        }

        //@author Gustav (last project)
        //reads a file and gets the number inside of it
        int readMemberID() {
            try {
                Scanner idFileScan = new Scanner(new File(FILENAME));
                String stringID = idFileScan.nextLine();
                int intID = Integer.parseInt(stringID);
                return intID;

            } catch (IOException e) {
                System.out.println("\nCould not open file - I/O Exception" + e);
            }
            return -1;
        }

        //@author Gustav (last project)
        //sets the IDnumber to the customer/member and adds 1 to file.
        int newMemberID() throws FileNotFoundException {
            int countID = readMemberID();
            countID ++;
            PrintStream writeToFile = new PrintStream(FILENAME);
            writeToFile.printf("%04d",countID);
            setMemberID(countID);
            return countID;
        }
}
