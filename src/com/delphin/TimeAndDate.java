package com.delphin;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class TimeAndDate {
    static String currentRealTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
    static UserInput userInput = new UserInput();
    static Calendar cal = Calendar.getInstance();

    //@author last project
    public String displayTime(){
        return currentRealTime;
    }


    //@author last project
    public String setTimeOfTheDay(int hours, int min) {
        LocalTime setTime = LocalTime.of(hours,min);
        String timeTest = setTime.toString();
        return timeTest;
    }
    // Calendar cal = TimeAndDate.setDate(2010, Calendar.MAY, 21);
    public static Calendar setDate(int year, int month, int day) {
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        return cal;
    }

    public static Calendar currentDate() {
        cal.get(Calendar.YEAR);
        cal.get(Calendar.MONTH);
        cal.get(Calendar.DAY_OF_MONTH);
        return cal;
    }


    /*
    //@author last project
    public void askForTime(Order order){
        //Ask for input, then assign value to timer
        userInput.inputTimeInt("Skriv en tid i timer og minutter: ");
        int timeHourSat = userInput.getHour();
        int timeMinSat = userInput.getMinute();

        System.out.println("Tid sat til kl. " + timeHourSat + ":" + timeMinSat);
        //Assigning values order
        order.setTime(setTimeOfTheDay(timeHourSat, timeMinSat));
        order.setTimeInt(order.convertTimetoTimeInt(order));
    }

     */
}