package com.delphin;

import java.io.IOException;
import java.io.Serializable;

public class Login implements Serializable {
    private String userName;
    private String userPassword;
    private String name;
    private int status;

    Login() throws IOException {
    }

    Login(String userName, String userPassword, String name, int status) throws IOException {
        this.userName = userName;
        this.userPassword = userPassword;
        this.name = name;
        this.status = status;
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

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status; }

    @Override
    public String toString() {
        return "UserName: #" + userName +
                "\nPassword: " + userPassword +
                "\nNavn: " + name +
                "\nStatus: " + status;
    }


}

