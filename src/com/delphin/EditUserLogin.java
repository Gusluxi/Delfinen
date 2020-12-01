package com.delphin;


import java.io.IOException;

//@author Frederik (partial copy of EditMembership)
public class EditUserLogin {
    static FileEditing fileEditing = new FileEditing();

        void newUser() throws IOException {
            Login userLogin = new Login();
            userLogin.setUserName(UserInput.inputString("Skriv dit brugernavn: ", false));
            userLogin.setUserPassword(UserInput.inputString("Skriv dit Kodeord: ",false));
            userLogin.setName(UserInput.inputString("Skriv dit navn",true));
            userLogin.setStatus(UserInput.inputInt(1,4,"Skriv: \n1. for Formand.\n2. for Traener.\n3. for Kasseren.\n4. for ny Admin"));


        fileEditing.storeInObjectFile(userLogin);
            }
}
