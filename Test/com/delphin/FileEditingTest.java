package com.delphin;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FileEditingTest {

    @Test
    void readFileAndConvertToObject() throws IOException {
        FileEditing fileEditing = new FileEditing();
        Member member;
        member = fileEditing.readFileAndConvertToObject(87);

        assertTrue(member instanceof Member);
    }

    @Test
    void testReadFileAndConvertToObject() throws IOException {
        FileEditing fileEditing = new FileEditing();
        String path = "src\\Members\\87.txt";
        Member member;
        member = fileEditing.readFileAndConvertToObject(new File(path));

        assertTrue(member instanceof Member);
    }

    @Test
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
    void sortTextFile() throws IOException {
        FileEditing fileEditing = new FileEditing();
        String path = "src\\Disciplines\\JuniorBryst.txt";
        File file = new File(path);

        ArrayList<String> firstAL = new ArrayList<>();
        ArrayList<String> sortedAL = new ArrayList<>();

        Scanner readFile = new Scanner(file);
        while (readFile.hasNextLine()){
            firstAL.add(readFile.nextLine());
        }

        // File is readable and now we sort and assert:
        fileEditing.sortTextFile("Disciplines","JuniorBryst");

        assertNotEquals(firstAL,sortedAL);
    }

    @Test
    void removeLineFromText() {
    }

    @Test
    void addToFile() {
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