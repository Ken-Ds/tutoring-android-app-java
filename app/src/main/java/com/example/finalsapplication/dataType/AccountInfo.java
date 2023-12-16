package com.example.finalsapplication.dataType;

import android.graphics.Bitmap;

public class AccountInfo {

    private String name, sex, dateOfBirth, dateHired, password, email;
    private  int id,score;


    public AccountInfo() {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dateHired = dateHired;
        this.score = score;
    }


    public AccountInfo(int id, String email, String password, String name, String sex, String dateOfBirth, String dateHired) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dateHired = dateHired;
    }

    public AccountInfo(int id, String email, String password, String name, String sex, String dateOfBirth, String dateHired, int score) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dateHired = dateHired;
        this.score = score;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) { this.sex = sex;}

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }


    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateHired() {
        return dateHired;
    }

    public void setDateHired(String dateHired) {
        this.dateHired = dateHired;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
