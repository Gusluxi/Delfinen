package com.delphin;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CurrentSubscriptionsTest {

    //Test of method, adding members subscription prices together through a for-loop.
    @Test
    void showTotalRevenue() throws IOException {
            Member member = new Member();
            ArrayList<Double> subscriptionPrice = new ArrayList<Double>();

            subscriptionPrice.add(member.SENIORPRICE);
            subscriptionPrice.add(member.JUNIORPRICE);
            subscriptionPrice.add(member.JUNIORPRICE);
            subscriptionPrice.add(member.PASSIVE);
            subscriptionPrice.add(member.PENSIONER);

            double expected = 5300;
            double result = 0;

            for (int i = 0; i < subscriptionPrice.size(); i++) {
                double tempTotal = subscriptionPrice.get(i);
                result += tempTotal;
            }
            assertEquals(expected, result);
        }

}