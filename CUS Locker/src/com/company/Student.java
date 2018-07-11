package com.company;

public class Student {

    private String firstName;
    private String lastName;
    private double phoneNumber;
    private String emailAddress;
    private Integer studentNumber;
    private Integer lockerNumber;
    private String floorPreference;


    public Student(String fn, String ln, double phone, String email, Integer stuNum, String pref) {
        this.firstName = fn;
        this.lastName = ln;
        this.phoneNumber = phone;
        this.emailAddress = email;
        this.studentNumber = stuNum;
        this.lockerNumber = null;
        this.floorPreference = pref;
    }

    public void setLocker(Integer num) {
        this.lockerNumber = num;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNumber = phoneNum;
    }

    public void clearLockerNum() {
        this.lockerNumber = null;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getEmail() {
        return this.emailAddress;
    }

    public Integer getStudentNumber() {
        return this.studentNumber;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public Integer getLockerNum() {
        if (this.lockerNumber == null) {
            return null;
        } else {
            return this.lockerNumber;
        }
    }

    public double getPhoneNum() {
        if (this.phoneNumber == 0) {
            return 0.0;
        }
        return this.phoneNumber;
    }

    public String getFloorPref() {
        return this.floorPreference;
    }


}
