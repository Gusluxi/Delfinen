package com.delphin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CurrentSubscriptions {
    static FileEditing fileEditing = new FileEditing();

    //@author Kristian
    //Show Total expected subscription income.
    public static void showTotalRevenue() throws IOException {
        ArrayList<Double> memberData = fileEditing.memberFilesSubscription(); //gets all subscriptions in Dir

        double membersRevenue;
        double totalMembersRevenue = 0;

        for (int i = 0; i < memberData.size(); i++) {
            membersRevenue = memberData.get(i);
            totalMembersRevenue += membersRevenue;
        }
        System.out.println(totalMembersRevenue);
    }

    //@author Kristian
    //Show Club members with debt.
    public static void showMembersWithDebt() throws IOException {
        ArrayList<Member> memberData = fileEditing.memberFilesDebt();

        for (int i = 0; i < memberData.size(); i++) {
            System.out.println("\n" + memberData.get(i).toStringDebt() + "\n");
        }
    }



}
