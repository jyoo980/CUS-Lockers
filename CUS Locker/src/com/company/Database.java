package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Database {

    private List<Student> students;
    private List<Locker> basementLockers;
    private List<Locker> secondLockers;
    private List<Locker> thirdLockers;
    private List<Locker> fourthLockers;
    private static Database instance;

    public Database() {
        this.students = new ArrayList<>();
        this.basementLockers = new ArrayList<>();
        this.secondLockers = new ArrayList<>();
        this.thirdLockers = new ArrayList<>();
        this.fourthLockers = new ArrayList<>();
    }

    public static Database getInstance() {
        // Do not modify the implementation of this method!
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void addBasementLockers(Locker l) {
        this.basementLockers.add(l);
    }

    public void addSecondLockers(Locker l) {
        this.secondLockers.add(l);
    }

    public void addThirdLockers(Locker l) {
        this.thirdLockers.add(l);
    }

    public void addFourthLockers(Locker l) {
        this.fourthLockers.add(l);
    }

    public void addStudents(Student s) {
        this.students.add(s);
    }

    public List<Locker> basementLockers() {
        return basementLockers;
    }

    public List<Locker> secondLockers() {
        return secondLockers;
    }

    public List<Locker> thirdLockers() {
        return thirdLockers;
    }

    public List<Locker> fourthLockers() {
        return fourthLockers;
    }

    public List<Student> students() {
        return students;
    }

    public int nextAvailableLocker(List<Locker> l) {
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getStudent() == "CUS") {
                return i;
            }
        }
        return 0;
    }

    //sorts smallest odds then all evens
    public void sortLockers(List<Locker> arr) {
        Comparator<Locker> comparator = new Sort();
        PriorityQueue<Locker> pq = new PriorityQueue<Locker>(140, comparator);
        pq.addAll(arr);
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            arr.set(i, pq.remove());
        }
    }

    public void allocateLockers(int size) {

        for (int i = 0; i < size - 1; i++) {
            switch (students.get(i).getFloorPref()) {
                case "Basement":
                    int bIndex = nextAvailableLocker(basementLockers);
                    students.get(i).setLocker(basementLockers.get(bIndex).getLockerNumber());
                    basementLockers.get(bIndex).assignLocker(students.get(i));
                    System.out.println(students.get(i).getFullName());
                    System.out.println(students.get(i).getLockerNum());
                    break;
                case "Second Floor":
                    int sIndex = nextAvailableLocker(secondLockers);
                    students.get(i).setLocker(secondLockers.get(sIndex).getLockerNumber());
                    secondLockers.get(sIndex).assignLocker(students.get(i));
                    System.out.println(students.get(i).getFullName());
                    System.out.println(students.get(i).getLockerNum());
                    break;
                case "Third Floor":
                    int tIndex = nextAvailableLocker(thirdLockers);
                    students.get(i).setLocker(thirdLockers.get(tIndex).getLockerNumber());
                    thirdLockers.get(tIndex).assignLocker(students.get(i));
                    System.out.println(students.get(i).getFullName());
                    System.out.println(students.get(i).getLockerNum());
                    break;
                case "Fourth Floor":
                    int fIndex = nextAvailableLocker(fourthLockers);
                    students.get(i).setLocker(fourthLockers.get(fIndex).getLockerNumber());
                    fourthLockers.get(fIndex).assignLocker(students.get(i));
                    System.out.println(students.get(i).getFullName());
                    System.out.println(students.get(i).getLockerNum());
                    break;
                default:
                    return;
            }
        }
    }
}
