package com.delphin;

import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void calculatePrice() throws IOException {
        Member member = new Member();

        int memberID = 1;
        member.setAge(17);
        member.setName("Jesus");
        member.setActivity(true);
        member.setCompetitor(true);
        member.setMemberID(memberID);
        member.setJunior(member.calculateJuniorSenior(member));
        member.setSubscriptionPrice(member.calculatePrice(member));
        member.setActiveDebt(false);

        double expected = 1000;

        member.calculatePrice(member);
        double actual = member.getSubscriptionPrice();

        assertEquals(actual, expected);
    }

    @Test
    void calculateJuniorSenior() throws IOException {
        Member member = new Member();

        int memberID = 1;
        member.setAge(17);
        member.setName("Jesus");
        member.setActivity(true);
        member.setCompetitor(true);
        member.setMemberID(memberID);
        member.setJunior(member.calculateJuniorSenior(member));
        member.setSubscriptionPrice(member.calculatePrice(member));
        member.setActiveDebt(false);

        boolean actual = member.calculateJuniorSenior(member);

            assertTrue(actual);
        }
    }