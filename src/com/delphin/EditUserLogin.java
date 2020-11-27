package com.delphin;

import java.io.*;
import java.util.Scanner;

public class EditUserLogin {
    static FileEditing fileEditing = new FileEditing();

        void newUser() throws IOException {
        Login userLogin = new Login();
        userLogin.setName("Kurt");
        userLogin.setStatus(1);
        userLogin.setUserName("Formand");
        userLogin.setUserPassword("JegErFormand");

        fileEditing.storeInObjectFile(userLogin);
            }
}
