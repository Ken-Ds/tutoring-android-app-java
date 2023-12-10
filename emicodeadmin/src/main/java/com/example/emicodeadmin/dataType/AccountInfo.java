package com.example.emicodeadmin.dataType;

public class AccountInfo {

    private String lName, fName, gender, dateOfBirth, dateHired, password, email;
    private  int id;


    public AccountInfo(int id, String email, String password, String lName, String fName, String gender, String dateOfBirth, String dateHired) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.lName = lName;
        this.fName = fName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateHired = dateHired;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
