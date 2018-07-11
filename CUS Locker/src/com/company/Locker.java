package com.company;

public class Locker {
    private Integer lockerNumber;
    private Student assigned;
    private String floor;

    public Locker(Integer num, String f) {
        this.lockerNumber = num;
        this.assigned = new Student("CUS", "IT", 8273772, "cus.ca", 0000000, "Fourth");
        this.floor = f;
    }

    public String lockerLocation() {
        return this.floor;
    }

    public void cancelLocker() {
        this.assigned = null;
    }

    public void assignLocker(Student s) {
        if (assigned == null) {
            this.assigned = s;
        } else {
            assigned.clearLockerNum(); //removes previous's customer designation to the locker
            this.assigned = s;
        }
    }

    public String lockerAssignment() {
        if (this.assigned == null) {
            return "AVAILABLE FOR RENT";
        } else {
            return this.assigned.getFirstName() + " " + this.assigned.getLastName();
        }
    }

    public double getPhoneNumber() {  //to access the phone number and evade nullPointer
        if (this.assigned == null) {
            return 0;
        } else {
            return this.assigned.getPhoneNum();
        }
    }

    public Integer getLockerNumber() {
        if (this.lockerNumber != null) {
            return this.lockerNumber;
        } else {
            return null;
        }
    }

    public String getStudent() {
        return this.assigned.getFirstName();
    }

    public Student getAssigned() {
        return this.assigned;
    }


}
