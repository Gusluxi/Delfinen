package com.delphin;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.jar.Attributes;

//Serialization is the conversion of the state of an object into a byte stream;
//deserialization does the opposite. Stated differently, serialization is the
//conversion of a Java object into a static stream (sequence) of bytes,
//which can then be saved to a database or transferred over a network.

public class Member implements Serializable {

    private int age;
    private String name;
    private int memberID;
    private boolean activity; //true = active member, not passive
    private boolean junior; //true = Under the age of 18
    private boolean competitor; //true = competes
    private boolean activeDebt; //true = has arrears
    private double subscriptionPrice; //use method to calculate

    private String juniorBryst;
    private String juniorButterfly;
    private String juniorCrawl;
    private String juniorRygcrawl;
    private String seniorBryst;
    private String seniorButterfly;
    private String seniorCrawl;
    private String seniorRygCrawl;

    private double juniorBrystTid;
    private double juniorButterflyTid;
    private double juniorCrawlTid;
    private double juniorRygcrawlTid;
    private double seniorBrystTid;
    private double seniorButterflyTid;
    private double seniorCrawlTid;
    private double seniorRygCrawlTid;

    static final double SENIORPRICE = 1600;
    static final double JUNIORPRICE = 1000;
    static final double DISCOUNT = 0.25;
    static final double PENSIONER = (SENIORPRICE- (SENIORPRICE*DISCOUNT));
    static final double PASSIVE = 500;

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

    public boolean isActivity() { return activity; }
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

    public String getJuniorBryst() {
        return juniorBryst;
    }

    public void setJuniorBryst(String juniorBryst) {
        this.juniorBryst = juniorBryst;
    }

    public String getJuniorButterfly() {
        return juniorButterfly;
    }

    public void setJuniorButterfly(String juniorButterfly) {
        this.juniorButterfly = juniorButterfly;
    }

    public String getJuniorCrawl() {
        return juniorCrawl;
    }

    public void setJuniorCrawl(String juniorCrawl) {
        this.juniorCrawl = juniorCrawl;
    }

    public String getJuniorRygcrawl() {
        return juniorRygcrawl;
    }

    public void setJuniorRygcrawl(String juniorRygcrawl) {
        this.juniorRygcrawl = juniorRygcrawl;
    }

    public String getSeniorBryst() {
        return seniorBryst;
    }

    public void setSeniorBryst(String seniorBryst) {
        this.seniorBryst = seniorBryst;
    }

    public String getSeniorButterfly() {
        return seniorButterfly;
    }

    public void setSeniorButterfly(String seniorButterfly) {
        this.seniorButterfly = seniorButterfly;
    }

    public String getSeniorCrawl() {
        return seniorCrawl;
    }

    public void setSeniorCrawl(String seniorCrawl) {
        this.seniorCrawl = seniorCrawl;
    }

    public String getSeniorRygCrawl() {
        return seniorRygCrawl;
    }

    public void setSeniorRygCrawl(String seniorRygCrawl) {
        this.seniorRygCrawl = seniorRygCrawl;
    }

    public double getJuniorBrystTid() {
        return juniorBrystTid;
    }

    public void setJuniorBrystTid(double juniorBrystTid) {
        this.juniorBrystTid = juniorBrystTid;
    }

    public double getJuniorButterflyTid() {
        return juniorButterflyTid;
    }

    public void setJuniorButterflyTid(double juniorButterflyTid) {
        this.juniorButterflyTid = juniorButterflyTid;
    }

    public double getJuniorCrawlTid() {
        return juniorCrawlTid;
    }

    public void setJuniorCrawlTid(double juniorCrawlTid) {
        this.juniorCrawlTid = juniorCrawlTid;
    }

    public double getJuniorRygcrawlTid() {
        return juniorRygcrawlTid;
    }

    public void setJuniorRygcrawlTid(double juniorRygcrawlTid) {
        this.juniorRygcrawlTid = juniorRygcrawlTid;
    }

    public double getSeniorBrystTid() {
        return seniorBrystTid;
    }

    public void setSeniorBrystTid(double seniorBrystTid) {
        this.seniorBrystTid = seniorBrystTid;
    }

    public double getSeniorButterflyTid() {
        return seniorButterflyTid;
    }

    public void setSeniorButterflyTid(double seniorButterflyTid) {
        this.seniorButterflyTid = seniorButterflyTid;
    }

    public double getSeniorCrawlTid() {
        return seniorCrawlTid;
    }

    public void setSeniorCrawlTid(double seniorCrawlTid) {
        this.seniorCrawlTid = seniorCrawlTid;
    }

    public double getSeniorRygCrawlTid() {
        return seniorRygCrawlTid;
    }

    public void setSeniorRygCrawlTid(double seniorRygCrawlTid) {
        this.seniorRygCrawlTid = seniorRygCrawlTid;
    }


     @Override
     public String toString() {
         return "MemberID: #" + memberID +
                 "\nAlder: " + age +
                 "\nNavn: " + name +
                 "\nAktiv: " + activity +
                 "\njunior: " + junior +
                 "\nKonkurrence: " + competitor +
                 "\nRestance: " + activeDebt +
                 "\nKontingentet: " + subscriptionPrice + " kr.";
     }

     public String toStringDebt() {
         return "MemberID: #" + memberID +
                 "\nNavn: " + name +
                 "\nRestance: " + activeDebt +
                 "\nManglende betaling: " + subscriptionPrice + " kr.";
     }

     public String toStringTimes() {
         ArrayList<String> times = new ArrayList<>();
         ArrayList<Double> times2 = new ArrayList<>();
         times.add(juniorBryst);
         //times.add(String.valueOf(juniorBrystTid));
         times.add(juniorButterfly);
         //times.add(String.valueOf(juniorButterflyTid));
         times.add(juniorCrawl);
         //times.add(String.valueOf(juniorCrawlTid));
         times.add(juniorRygcrawl);
         //times.add(String.valueOf(juniorRygcrawlTid));
         times.add(seniorBryst);
         //times.add(String.valueOf(seniorBrystTid));
         times.add(seniorButterfly);
         //times.add(String.valueOf(seniorButterflyTid));
         times.add(seniorCrawl);
         //times.add(String.valueOf(seniorCrawlTid));
         times.add(seniorRygCrawl);
         //times.add(String.valueOf(seniorCrawlTid));
         times2.add(juniorBrystTid);
         times2.add(juniorButterflyTid);
         times2.add(juniorCrawlTid);
         times2.add(juniorRygcrawlTid);
         times2.add(seniorBrystTid);
         times2.add(seniorButterflyTid);
         times2.add(seniorCrawlTid);
         times2.add(seniorRygCrawlTid);

         ArrayList<Double> testDouble = new ArrayList<>();
         ArrayList<String> test = new ArrayList<>();
         ArrayList<String> testDConvert = new ArrayList<>();
         ArrayList<String> lastAL = new ArrayList<>();

         //for loop for string nulls
         for (int i = 0; i < times.size(); i++) {
             if (times.get(i) != null) {
                 test.add(times.get(i));
             }
         }
        //for loop for double nulls  (0.0)
         for (int i =0;i<times2.size();i++){
             if (times2.get(i) != 0.0){
                testDouble.add(times2.get(i));
             }
         }

         //Convert double to String
         for (int i = 0; i<testDouble.size();i++){
             testDConvert.add(String.valueOf(testDouble.get(i)));
         }

         //Put into ONE list
         for (int i=0;i<test.size();i++){
             lastAL.add(test.get(i));
             lastAL.add(testDConvert.get(i));
         }

         return lastAL.toString();
     }


     //@author GroupCall
     //Calculates the price for a new member.
    static double calculatePrice(Member member) {
         double price = 0;
         if (member.getAge() < 18){
             price = JUNIORPRICE;
         } else if (member.getAge() >= 18 && member.getAge() < 60) {
             price = SENIORPRICE;
         } else {
             price = PENSIONER;
         } if (!member.isActivity()) {
             price = PASSIVE;
         }
         return price;
    }

     //@author Gustav
     //Figures out if the member is junior or senior
    static boolean calculateJuniorSenior(Member member) {
         boolean juniorSenior;
        if (member.getAge() < 18) {
            juniorSenior = true; //under 18
        } else {
            juniorSenior = false; //over 18
        }
        return juniorSenior;
    }

}
