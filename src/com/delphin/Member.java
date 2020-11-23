package com.delphin;

import java.io.*;
import java.util.Scanner;

public class Member {
   private int age;
   private String name;
   private int memberID;

   static File membersData = new File("src\\com\\delphin\\Members.txt");

   Member() throws IOException {}

   Member(int memberID, int age, String name) throws IOException {
       this.memberID=memberID;
       this.age=age;
       this.name=name;

   }

   public int getMemberID(){return this.memberID;}
   public void setMemberID(int memberID){this.memberID=memberID;}

   public int getAge(){return this.age;}
   public void setAge(int age) {this.age=age;}

   public String getName() {return this.name;}
   public void setName(String name) {this.name=name;}

   Scanner readFile = new Scanner(membersData);
   FileWriter fw = new FileWriter(membersData,true);
   PrintWriter writeToFile = new PrintWriter(fw);

   public String toString() {
       return getMemberID() + " " + getName() + " " + getAge();
   }

   void methodLol(Object member) throws IOException {
       writeToFile.println(member.toString());
       writeToFile.flush();
       writeToFile.close();


   }


}
