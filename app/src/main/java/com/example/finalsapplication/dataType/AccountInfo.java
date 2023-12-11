package com.example.finalsapplication.dataType;

public class AccountInfo {

    private String lName, fName, sex, dateOfBirth, dateHired, password, email;
    private  int id;


    public AccountInfo(int id, String email, String password, String lName, String fName, String sex, String dateOfBirth, String dateHired) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.lName = lName;
        this.fName = fName;
        this.sex = sex;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) { this.sex = sex;}

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
