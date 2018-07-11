package com.company;

import java.util.Comparator;

public class Sort implements Comparator<Locker> {
    @Override
    public int compare(Locker o1, Locker o2) {

        //odd vs odd
        if (o1.getLockerNumber() % 2 != 0 && o2.getLockerNumber() % 2 != 0) {
            if (o1.getLockerNumber() < o2.getLockerNumber()) {
                return -1; //odd
            } else {
                return 1; // even
            }
        }
        //odd vs even
        if ((o1.getLockerNumber() % 2 != 0 && o2.getLockerNumber() % 2 == 0) ||
                (o1.getLockerNumber() % 2 == 0 && o2.getLockerNumber() % 2 != 0)) {
            if (o1.getLockerNumber() % 2 != 0) {
                return -1;
            } else {
                return 1;
            }
        }

        if (o1.getLockerNumber() % 2 == 0 && o2.getLockerNumber() % 2 == 0) {
            if (o1.getLockerNumber() < o2.getLockerNumber()) {
                return -1;
            }
        }

        return 1;

    }
}
