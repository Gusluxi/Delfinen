package com.delphin;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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

        fileEditing.createNewMemberObjectFile(member);

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

        fileEditing.removeLineFromText("Mick","Disciplines","JuniorBryst");

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
    void dataToArrayList() {
    }

    @Test
    void memberFilesSubscription() {
    }

    @Test
    void memberFilesDebt() {
    }

    @Test
    void findSpecificFileValues() {
    }

    @Test
    void printNrNameFromString() {
    }

    @Test
    void printStringAsList() {
    }


}