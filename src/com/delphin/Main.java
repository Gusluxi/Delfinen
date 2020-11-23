package com.delphin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    void run() throws IOException {
        IDNumber idNumber = new IDNumber();

        Member test3 = new Member(idNumber.newMemberID(), 35,"Jesus",true,false,true,false,1500);
        createNewMemberFile(test3);



        //System.out.println("YAYEET");
        //System.out.println(test3.toString());
    }

    void createNewMemberFile(Member member) throws IOException { // @author Stackoverflow :)
        int IDNumber = member.getMemberID();
        String path = "src\\Members\\"+IDNumber+".txt";
        try{
            File viProver = new File(path);
            if (viProver.createNewFile()){
                System.out.println("File created: " + viProver.getName());
            }else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter fw = new FileWriter(path,true);
        PrintWriter writeToFile = new PrintWriter(fw);
        writeToFile.println(member.toString());
        writeToFile.flush();
        writeToFile.close();
    }

    public static void main(String[] args) throws IOException {

        Main prg = new Main();
        prg.run();

    }
}
