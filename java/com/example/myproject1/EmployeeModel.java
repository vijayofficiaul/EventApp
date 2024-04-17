package com.example.myproject1;

public class EmployeeModel {

    Integer id;
    String nameS;

    public EmployeeModel(Integer id, String nameS, String emailS, String mobilenemberS, String passwordS, String addressS, String pincodeS, String genderS) {
        this.id = id;
        this.nameS = nameS;
        this.emailS = emailS;
        this.mobilenemberS = mobilenemberS;
        this.PasswordS = passwordS;
        this.addressS = addressS;
        this.pincodeS = pincodeS;
        this.genderS = genderS;
    }

    String emailS;
    String mobilenemberS;
    String PasswordS;
    String addressS;
    String pincodeS;
    String genderS;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNameS() {
        return nameS;
    }

    public void setNameS(String name) {
        this.nameS = name;
    }

    public String getEmailS() {
        return emailS;
    }

    public void setEmailS(String email) {
        this.emailS = email;
    }

    public String getMobilenemberS() {
        return mobilenemberS;
    }

    public void setMobilenemberS(String mobilenember) {
        this.mobilenemberS = mobilenember;
    }

    public String getPasswordS() {
        return PasswordS;
    }

    public void setPasswordS(String password) {
        PasswordS = password;
    }

    public String getAddressS() {
        return addressS;
    }

    public void setAddressS(String address) {
        this.addressS = address;
    }

    public String getPincodeS() {
        return pincodeS;
    }

    public void setPincodeS(String pincode) {
        this.pincodeS = pincode;
    }

    public String getGenderS() {
        return genderS;
    }

    public void setGenderS(String gender) {
        this.genderS = gender;
    }

    public EmployeeModel(String name, String email, String mobilenember, String password, String address, String pincode, String gender) {
        this.nameS = name;
        this.emailS = email;
        this.mobilenemberS = mobilenember;
        this.PasswordS = password;
        this.addressS = address;
        this.pincodeS = pincode;
        this.genderS = gender;
    }



}
