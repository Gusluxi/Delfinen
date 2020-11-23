package com.delphin;

import java.io.*;
import java.util.Scanner;

public class Member {
   private int age;
   private String name;
   private int memberID;
   private boolean activity; //true = active member, not passive
   private boolean junior; //true = Under the age of 18
   private boolean competitor; //true = competes
   private boolean activeDebt; //true = has arrears
   private double subscriptionPrice; //use method to calculate


   static File membersData = new File("src\\com\\delphin\\Members.txt");

   Member() throws IOException {}

   Member(int memberID, int age, String name) throws IOException {
       this.memberID=memberID;
       this.age=age;
       this.name=name;

   }

   Member(int memberID, int age, String name, boolean activity, boolean junior, boolean competitor, boolean activeDebt, double subscriptionPrice) throws IOException {
       this.memberID=memberID;
       this.age=age;
       this.name=name;
       this.activity=activity;
       this.junior=junior;
       this.competitor=competitor;
       this.activeDebt=activeDebt;
       this.subscriptionPrice=subscriptionPrice;
   }

   public boolean isActivity() {
        return activity;
    }
   public void setActivity(boolean activity) {
        this.activity = activity;
    }

   public boolean isJunior() {
        return junior;
    }
   public void setJunior(boolean junior) {
        this.junior = junior;
    }

   public boolean isCompetitor() {
        return competitor;
    }
   public void setCompetitor(boolean competitor) {
        this.competitor = competitor;
    }

   public boolean isActiveDebt() {
        return activeDebt;
    }
   public void setActiveDebt(boolean activeDebt) {
        this.activeDebt = activeDebt;
    }

   public double getSubscriptionPrice() {
        return subscriptionPrice;
    }
   public void setSubscriptionPrice(double subscriptionPrice) {
        this.subscriptionPrice = subscriptionPrice;
    }

   public int getMemberID(){return this.memberID;}
   public void setMemberID(int memberID){this.memberID=memberID;}

   public int getAge(){return this.age;}
   public void setAge(int age) {this.age=age;}

   public String getName() {return this.name;}
   public void setName(String name) {this.name=name;}

    @Override
    public String toString() {
        return "Member{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", memberID=" + memberID +
                ", activity=" + activity +
                ", junior=" + junior +
                ", competitor=" + competitor +
                ", activeDebt=" + activeDebt +
                ", subscriptionPrice=" + subscriptionPrice +
                '}';
    }

   Scanner readFile = new Scanner(membersData);
   FileWriter fw = new FileWriter(membersData,true);
   PrintWriter writeToFile = new PrintWriter(fw);

    void methodLol(Object member) throws IOException {
       writeToFile.println(member.toString());
       writeToFile.flush();
       writeToFile.close();


   }


}
