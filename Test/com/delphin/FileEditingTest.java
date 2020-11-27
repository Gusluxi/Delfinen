package com.delphin;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


class FileEditingTest {
    @Test
        //@author Mick
        //asserts that when it retrieves a file, it is readable as member
    void readFileAndConvertToObject() throws IOException {
        FileEditing fileEditing = new FileEditing();
        Member member;
        member = fileEditing.readFileAndConvertToObject(87);

        assertTrue(member instanceof Member);
    }
    @Test
        //asserts that when it retrieves a file, it is readable as member
    void testReadFileAndConvertToObject() throws IOException {
        FileEditing fileEditing = new FileEditing();
        String path = "src\\Members\\87.txt";
        Member member;
        member = fileEditing.readFileAndConvertToObject(new File(path));

        assertTrue(member instanceof Member);
    }
    @Test
        //@author Mick
        //asserts that the method makes a file and that it is convertable.
    void createNewMemberObjectFile() throws IOException {
        FileEditing fileEditing = new FileEditing();
        Member member;
        member = fileEditing.readFileAndConvertToObject(87);
        String path = "src\\Members\\87.txt";
        File file = new File(path);

        assertTrue(member instanceof Member);

        fileEditing.storeInObjectFile(member);

        assertTrue(file instanceof File); //Is converted
        assertTrue(fileEditing.readFileAndConvertToObject(file) instanceof Member); //is convertable
    }

    @Test
        //@author Mick
    void sortTextFile() throws IOException {
        FileEditing fileEditing = new FileEditing();
        String path = "src\\Disciplines\\JuniorBryst.txt";
        File file = new File(path);
        //insert file to arraylists. sort one of them and compare.
        ArrayList<String> firstAL = new ArrayList<>();
        ArrayList<String> sortedAL = new ArrayList<>();

        Scanner readFile = new Scanner(file);
        while (readFile.hasNextLine()){
            firstAL.add(readFile.nextLine());
        }
        System.out.println(firstAL.toString());
        readFile.close();

        // File is readable and now we sort and assert:
        fileEditing.sortTextFile("Disciplines","JuniorBryst");

        Scanner readFile2 = new Scanner(file);
        while (readFile2.hasNextLine()){
            sortedAL.add(readFile2.nextLine());
        }
        System.out.println(sortedAL.toString());
        readFile2.close();

        assertNotEquals(firstAL,sortedAL);
    }

    @Test
        //@author Mick
    void addToFile() throws IOException {
        FileEditing fileEditing = new FileEditing();
        String path = "src\\Disciplines\\JuniorBryst.txt";
        File file = new File(path);

        //insert file to Arraylist, add line to file, insert file to new arraylist, compare.
        ArrayList<String> firstAL = new ArrayList<>();
        ArrayList<String> secondAL = new ArrayList<>();

        Scanner readFile = new Scanner(file);
        while (readFile.hasNextLine()){
            firstAL.add(readFile.nextLine());
        }
        System.out.println(firstAL.toString());
        readFile.close();

        fileEditing.addToFile("YayeetDAB","Disciplines","JuniorBryst");

        File file2 = new File(path);
        Scanner readFile2 = new Scanner(file2);
        while (readFile2.hasNextLine()){
            secondAL.add(readFile2.nextLine());
        }
        System.out.println(secondAL.toString());
        readFile2.close();
        assertNotEquals(firstAL,secondAL);
    }

    @Test
        //@author Mick
    void removeLineFromText() throws IOException {
        FileEditing fileEditing = new FileEditing();
        String path = "src\\Disciplines\\JuniorBryst.txt";
        File file = new File(path);
        //insert file to Arraylist, remove line from file, insert file to new arraylist, compare.
        ArrayList<String> firstAL = new ArrayList<>();
        ArrayList<String> secondAL = new ArrayList<>();

        Scanner readFile = new Scanner(file);
        while (readFile.hasNextLine()){
            firstAL.add(readFile.nextLine());
        }
        System.out.println(firstAL.toString());
        readFile.close();

        fileEditing.removeLineFromText("YayeetDAB","Disciplines","JuniorBryst");

        File file2 = new File(path);
        Scanner readFile2 = new Scanner(file2);
        while (readFile2.hasNextLine()){
            secondAL.add(readFile2.nextLine());
        }
        System.out.println(secondAL.toString());
        readFile2.close();
        assertNotEquals(firstAL,secondAL);
    }

    @Test
        //@author Mick
    void testAddToFile() throws IOException {
        FileEditing fileEditing = new FileEditing();
        String path = "src\\Disciplines\\JuniorBryst.txt";
        File file = new File(path);

        //insert file to Arraylist, add line to file, insert file to new arraylist, compare.
        ArrayList<String> firstAL = new ArrayList<>();
        ArrayList<String> secondAL = new ArrayList<>();

        Scanner readFile = new Scanner(file);
        while (readFile.hasNextLine()){
            firstAL.add(readFile.nextLine());
        }
        System.out.println(firstAL.toString());
        readFile.close();

        fileEditing.addToFile("lod",file);

        File file2 = new File(path);
        Scanner readFile2 = new Scanner(file2);
        while (readFile2.hasNextLine()){
            secondAL.add(readFile2.nextLine());
        }
        System.out.println(secondAL.toString());
        readFile2.close();
        assertNotEquals(firstAL,secondAL);
    }
    @Test
        //@Author Gustav
    void testDataToArrayList() {
        File directory = new File("test\\TestMembers");
        File[] fileArray = directory.listFiles();
        File testDirectory = new File("test\\TestMembers\\107.txt");
        assertNotEquals(directory, testDirectory); //Tests that directory and testDirectory is not equals each other.
        ArrayList<File> fileA = new ArrayList<>(Arrays.asList(fileArray));
        ArrayList<File> fileB = new ArrayList<>(Arrays.asList(testDirectory)); //TestArrayList for a later Assertion
        ArrayList<String> memberData = new ArrayList<>();
        assertEquals(fileA, fileB); //Tests that he list of files from directory is the same as file from testDirectory

        for (int i = 0; i < fileA.size(); i++) {
            memberData.add(fileA.get(i).toString());
            assertEquals(fileA.get(i),fileB.get(i)); //Tests if the same ArrayListIndex is equals each other.
        }
        assertEquals(1, memberData.size()); //Tests if for loop was properly looped through.
    }

    @Test
        //@Author Gustav
    void testMemberFilesSubscription() {
        File directory = new File("test\\TestMembers");
        File[] fileArray = directory.listFiles();
        File testDirectory = new File("test\\TestMembers\\107.txt");
        assertNotEquals(directory, testDirectory); //Tests that directory and testDirectory is not equals each other.
        ArrayList<File> fileA = new ArrayList<>(Arrays.asList(fileArray));
        ArrayList<File> fileB = new ArrayList<>(Arrays.asList(testDirectory)); //TestArrayList for a later Assertion
        ArrayList<Integer> memberData = new ArrayList<>();
        assertEquals(fileA, fileB);  //Tests that he list of files from directory is the same as file from testDirectory

        for (int i = 0; i < fileA.size(); i++) {
            memberData.add(i);
            assertEquals(fileA.get(i),fileB.get(i)); //Tests if the same ArrayListIndex is equals each other.
        }
        assertEquals(1, memberData.size()); //Tests if for loop was properly looped through.
    }

    @Test
        //@Author Gustav
    void testMemberFilesDebt() {
        File directory = new File("test\\TestMembers");
        File[] fileArray = directory.listFiles();
        File testDirectory = new File("test\\TestMembers\\107.txt");
        assertNotEquals(directory, testDirectory); //Tests that directory and testDirectory is not equals each other.
        ArrayList<File> fileA = new ArrayList<>(Arrays.asList(fileArray));
        ArrayList<File> fileB = new ArrayList<>(Arrays.asList(testDirectory)); //TestArrayList for a later Assertion
        ArrayList<Double> memberData = new ArrayList<>();
        assertEquals(fileA, fileB); //Tests that he list of files from directory is the same as file from testDirectory

        for (int i = 0; i < fileA.size(); i++) {
            double testi = i;
            memberData.add(testi);
        assertEquals(fileA.get(i),fileB.get(i)); //Tests if the same ArrayListIndex is equals each other.
        }
        assertEquals(1, memberData.size()); //Tests if for loop was properly looped through.
    }
    @Test
        //@Author Gustav
    void testFindSpecificFileValues() {
        ArrayList<Integer> arrayPlace = new ArrayList<>();
        String input = "Gustav";
        ArrayList<String> memberData = new ArrayList<>();
        memberData.add("Gustav 1"); //Test Index 0
        memberData.add("Gustav 2"); //Test Index 1
        memberData.add("Jesus 1"); //Test Index 2
        // Tests that memberData.get("Jesus 1) is not equals input"Gustav"
        assertFalse(memberData.get(2).contains(input));
        for (int i = 0; i < memberData.size(); i++) {
            if (memberData.get(i).contains(input)) {
                // Tests that memberdata.get(i) actually contains input
                assertTrue(memberData.get(i).contains(input), "True error");
                arrayPlace.add(i);
            } else {
                // Tests that memberdata.get(i) does not contain input
                assertFalse(memberData.get(i).contains(input), "False error");
            }
        }
        //Tests if arrayPlace counted each memberdata that contains input more than twice
        assertTrue(arrayPlace.size() > 1);
        if (arrayPlace.size() > 1) {
            for (int c = 0; c < arrayPlace.size(); c++) {
                if (arrayPlace.get(c) == 0) //Tests if arrayPlace works and remembered the placemente of each data
                    assertEquals(memberData.get(arrayPlace.get(c)), memberData.get(0));
                else if (arrayPlace.get(c) == 1)
                    assertEquals(memberData.get(arrayPlace.get(c)), memberData.get(1));
            }
        }
    }

    @Test
        //@Author Gustav
    void testPrintNrNameFromString() {
        //TestData
        String dataLineOneAge = "This is line one Alder: ";
        String dataLineTwoName = "This is line two Navn: ";
        String dataLineThreeMemberID = "This is line three MemberID:";
        String data = "\n" + dataLineOneAge + "\n" + dataLineTwoName + "\n" + dataLineThreeMemberID; //What a data string would look like
        Scanner scan = new Scanner(data);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.contains("MemberID:"))  {
                //Tests to see if the specific Line 3 with MemberID: Matches and tests that the other lines did not
                assertNotEquals(dataLineOneAge, line);
                assertNotEquals(dataLineTwoName, line);
                assertEquals(dataLineThreeMemberID, line);
            }
            if (line.contains("Navn:")) {
                //Tests to see if the specific Line 2 with Navn: Matches and tests that the other lines did not.
                assertNotEquals(dataLineOneAge, line);
                assertEquals(dataLineTwoName, line);
                assertNotEquals(dataLineThreeMemberID, line);
            }

        }
    }

    @Test
        //@Author Gustav
    void testPrintStringAsList() {
        String dataLineOneAge = "This is line one Alder: ";
        String dataLineTwoName = "This is line two Navn: ";
        String dataLineThreeMemberID = "This is line three MemberID:";
        String data = "\n" + dataLineOneAge + "\n" + dataLineTwoName + "\n" + dataLineThreeMemberID; //What a data string would look like
        Scanner scan = new Scanner(data);
        int count = 0;

        while (scan.hasNextLine()) {
            count++;
            String line = scan.nextLine();
            //Tests that only one line gets scanned at a time.
            assertTrue(dataLineOneAge.contains(line)|| dataLineTwoName.contains(line) || dataLineThreeMemberID.contains(line));
        }
        //Tests if count actually counted the number of lines
        assertEquals(count, 3);
    }

}