package com.example.fitnesssgp;

public class userModel {
    private String number,name,mail,pass;

    public userModel() {
    }

    public userModel(String number, String name, String mail, String pass) {
        this.number = number;
        this.name = name;
        this.mail = mail;
        this.pass = pass;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
