package com.example.finalsapplication.dataType;

import android.graphics.Bitmap;

public class AccountInfo {

    private String name, sex, dateOfBirth, dateHired, password, email;
    private Bitmap profileImage;
    private  int id;


    public AccountInfo() {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dateHired = dateHired;
        this.profileImage = null;
    }

    public AccountInfo(int id, String email, String password, String name, String sex, String dateOfBirth, String dateHired, Bitmap profileImage) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dateHired = dateHired;
        this.profileImage = profileImage;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Bitmap getProfileImage() {
        return profileImage;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateHired() {
        return dateHired;
    }

    public void setProfileImage(Bitmap profileImage) {
        this.profileImage = profileImage;
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
