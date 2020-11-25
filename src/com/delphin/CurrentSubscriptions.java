package com.delphin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CurrentSubscriptions {
    static FileEditing fileEditing = new FileEditing();

    //Show Total expected subscription income.
    public static void showTotalRevenue() throws IOException {
        ArrayList<Double> memberData = fileEditing.memberFilesSubscription();
        System.out.println(memberData);

        double membersRevenue;
        double totalMembersRevenue = 0;

        for (int i = 0; i < memberData.size(); i++) {
            membersRevenue = memberData.get(i);
            totalMembersRevenue += membersRevenue;
        }
        System.out.println(totalMembersRevenue);
    }

    //Show Club members with debt.
    public static void showMembersWithDebt() throws IOException {
        ArrayList<Member> memberData = fileEditing.memberFilesDebt();

        for (int i = 0; i < memberData.size(); i++) {
            System.out.println("\n" + memberData.get(i).toStringDebt() + "\n");

        }

    }


}
