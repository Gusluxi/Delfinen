package com.delphin;

import java.io.*;
import java.util.Scanner;

public class EditUserLogin {
    static FileEditing fileEditing = new FileEditing();

            void newUser() throws IOException {
                Login login = new Login();
        login.setName("Kurt");
        login.setStatus(1);
        login.setUserName("Formand");
        login.setUserPassword("JegErFormand");

                fileEditing.storeInObjectFile(login);
            }
}
