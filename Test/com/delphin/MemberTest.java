package com.delphin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    static final double SENIORPRICE = 1600;
    static final double JUNIORPRICE = 1000;
    static final double DISCOUNT = 0.25;
    static final double PENSIONER = (SENIORPRICE- (SENIORPRICE*DISCOUNT));
    static final double PASSIVE = 500;

    @Test
    void calculatePrice() {
        double price = 0;
        int  age = 17;
        if (age < 18){
            price = JUNIORPRICE;
        } else if (age >= 18 && age < 60) {
            price = SENIORPRICE;
        } else {
            price = PENSIONER;
       // } if (!member.isActivity()) {
         //   price = PASSIVE;
            double expected = 1000;
            double result = 1000;
            result += price;
        assertEquals(result,expected);
        }
    }

    @Test
    void calculateJuniorSenior() {
        boolean expected = true;
        boolean result = true;
            int age = 17;
            if (age < 18) {
                result = true; //under 18
            } else {
                result = false; //over 18
            }

            assertTrue(result);
        }
    }