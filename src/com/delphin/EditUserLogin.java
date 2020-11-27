package com.delphin;

import java.io.*;
import java.util.Scanner;

public class EditUserLogin {
    static FileEditing fileEditing = new FileEditing();

        void newUser(String userName, String userPassword, String name, int status) throws IOException {
        Login userLogin = new Login();
        userLogin.setName(name);
        userLogin.setStatus(status);
        userLogin.setUserName(userName);
        userLogin.setUserPassword(userPassword);

        fileEditing.storeInObjectFile(userLogin);
            }
}
