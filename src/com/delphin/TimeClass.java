package com.delphin;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeClass {
    static String currentRealTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
    static UserInput userInput = new UserInput();

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
