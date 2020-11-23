package com.delphin;

import java.io.File;
import java.io.IOException;

public class Main {

    void run() throws IOException {
        IDNumber idNumber = new IDNumber();

        Member test3 = new Member(idNumber.newMemberID(), 35,"Jesus",true,false,true,false,1500);
        int idtallet = test3.getMemberID();
        String idtal = Integer.toString(idtallet);
        createNewMemberFile(idtal);



        //System.out.println("YAYEET");
        //System.out.println(test3.toString());
    }

    void createNewMemberFile(String IDNumber){ // @author Stackoverflow :)
        String path = "src\\com\\delphin\\"+IDNumber+".txt";
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
    }

    public static void main(String[] args) throws IOException {

        Main prg = new Main();
        prg.run();

    }
}
