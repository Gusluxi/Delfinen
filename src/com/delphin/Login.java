package com.delphin;

import java.io.IOException;

public class Login {
    private String userName;
    private String userPassword;
    private String name;

    Login() throws IOException {
    }

    Login(String userName, String userPassword, String name) throws IOException {
        this.userName = userName;
        this.userPassword = userPassword;
        this.name = name;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String memberID) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserName: #" + userName +
                "\nPassword: " + userPassword +
                "\nNavn: " + name;
    }
}

