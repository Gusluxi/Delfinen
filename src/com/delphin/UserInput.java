package com.delphin;

import java.util.Scanner;

public class UserInput {
    static Scanner scan = new Scanner(System.in);
    private int hour;
    private int minute;

    public void setHour(int hour) {
        this.hour = hour;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }


    //author Gustav (last project)
    //Checks if the input is an integer and if it is within the chosen min/max value
    public static int inputInt(int min, int max, String msg) {
        int number;
        System.out.println(msg);
        do {

            while (!scan.hasNextInt()) {
                System.out.println("Fejl, du skal skrive et tal:");
                scan.next();
            }
            number = scan.nextInt();
            scan.nextLine();
            if (number < min || number > max) {
                System.out.println("Du skal skrive et tal mellem " + min + " og " + max + ":");
            }
        } while (number < min || number > max);

        return number;
    }

    //@author (last project)
    //Asks user to input an integer if they didn't
    public static int inputInt(String msgOutput) {
        int number;
        System.out.println(msgOutput);
        while (!scan.hasNextInt()) {
            System.out.println("Du skal skrive et hel-tal!");
            System.out.println(msgOutput);
            scan.next();
        }
        number = scan.nextInt();
        return number;
    }


    //@author Gustav (last project)
    public void inputTimeInt(String msgOutput)  {
        String time;
        int hourInt = -1;
        int minuteInt = -1;
        System.out.println("\n" + msgOutput);
        scan.nextLine();

        do {
            time = scan.nextLine();
            final boolean timeContains = time.contains(":") || time.contains(".") || time.contains(",") || time.contains(" ");

            if (time.length() == 5 && timeContains) {
                //5Time in 4 numbers and 1 sign, EX. 12:30
                try {
                    hourInt = Integer.parseInt(time.substring(0, 2));
                    minuteInt = Integer.parseInt(time.substring(3, 5));
                } catch (NumberFormatException e) {
                    System.out.println(e + ". Input Error");
                }
            }

            if (time.length() == 4){
                if (timeContains) {
                    //4Time in 3 numbers and 1 sign, EX. 9:30
                    try {
                        hourInt = Integer.parseInt(time.substring(0, 1));
                        minuteInt = Integer.parseInt(time.substring(2, 4));
                    } catch (NumberFormatException e) {
                        System.out.println(e + ". Input Error");
                    }
                } else {
                    //4Time in 4 numbers, EX. 1030
                    try {
                        hourInt = Integer.parseInt(time.substring(0, 2));
                        minuteInt = Integer.parseInt(time.substring(2, 4));
                    } catch (NumberFormatException e) {
                        System.out.println(e + ". Input Error");
                    }
                }
            }

            //3Time in 3 numbers, EX. 930
            if (time.length() == 3) {
                try {
                    hourInt = Integer.parseInt(time.substring(0, 1));
                    minuteInt = Integer.parseInt(time.substring(1, 3));
                } catch (NumberFormatException e) {
                    System.out.println(e + ". Input Error");
                }
            }

            //Error message
            if ((hourInt < 0 || hourInt > 23) && (minuteInt < 0 || minuteInt > 59))
                System.out.println("Fejl, \"" + time + "\" er ikke et tidspunkt.\n" + msgOutput);
            else {
                if (hourInt < 0 || hourInt > 23)
                    System.out.println("Du skal skrive et time-tal mellem 00 og 23:");
                if (minuteInt < 0 || minuteInt > 59)
                    System.out.println("Du skal skrive et minut-tal mellem 00 og 59:");
            }

        } while ((hourInt < 0 || hourInt > 23) || (minuteInt < 0 || minuteInt > 59));
        setHour(hourInt);
        setMinute(minuteInt);
    }

    //@author Collective
    public static String inputString(String msg, Boolean checkForNumbers) {
        String word = "";
        if (!checkForNumbers) {
            System.out.println(msg);
            word = scan.nextLine();
        }
        while(checkForNumbers){
            System.out.println(msg);
            word = scan.nextLine();
            if (containsNumbers(word)){
                checkForNumbers = true;

            } else checkForNumbers = false;
        }
        return word;
    }

    //@author Mick
    //Scans the given String for numbers and returns TRUE if found.
    public static boolean containsNumbers(String str){
        for(char ch : str.toCharArray()){
            if(Character.isDigit(ch)){
                return true;
            }
        }
        return false;
    }

    //@author Unsure
    public static boolean inputBoolean(String msg) {

        boolean word;
        System.out.println(msg);
        while(!scan.hasNextBoolean()){
            System.out.println(msg);
            scan.next();
        }
        word = scan.nextBoolean();
        return word;
    }

    //@author Mick
    public static boolean inputBooleanInt(int min, int max, String msg) {
        int number;
        boolean trueOrFalse;
        System.out.println(msg);
        do {

            while (!scan.hasNextInt()) {
                System.out.println("Fejl, du skal skrive et tal:");
                scan.next();
            }
            number = scan.nextInt();
            if (number < min || number > max) {
            System.out.println("Du skal skrive et tal mellem " + min + " og " + max + ":");
            }
        } while (number < min || number > max);

        if (number == 1){
            trueOrFalse = true;
        } else {
            trueOrFalse = false;
        }
        return trueOrFalse;
    }

    //@author Gustav
    //Does the same as the method above, but more user-proof.
    public static boolean validateStringToBoo(String trueStatement, String falseStatement, String msg) {
        boolean valid = true;
        boolean statement = false;
        String trueS = trueStatement.toLowerCase();
        String falseS = falseStatement.toLowerCase();
        System.out.println(msg);

        while (valid) {
            String usrInput = scan.nextLine();
            String input = usrInput.toLowerCase();
            if (trueS.compareTo(input) == 0 || "1".compareTo(input) == 0) {
                statement = true;
                valid = false;
            } else if (falseS.compareTo(input) == 0 || "2".compareTo(input) == 0) {
                statement = false;
                valid = false;
            } else {
                System.out.println("Skriv 1. for " + trueStatement + " eller 2. for " + falseStatement);
            }
        }
        return statement;
    }


}
