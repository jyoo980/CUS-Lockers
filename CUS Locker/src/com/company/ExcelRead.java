package com.company;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelRead {

    public static void main(String[] args) throws IOException {

        HSSFWorkbook lockersheet = new HSSFWorkbook(new FileInputStream("Lockers.xls"));
        HSSFSheet basement = lockersheet.getSheet("Basement");
        HSSFSheet second = lockersheet.getSheet("Second Floor");
        HSSFSheet third = lockersheet.getSheet("Third Floor");
        HSSFSheet fourth = lockersheet.getSheet("Fourth Floor");

        int numOfBasementRows = basement.getPhysicalNumberOfRows();
        for (int i = 0; i < numOfBasementRows; i++) {
            HSSFRow rows0 = basement.getRow(i);
            if (rows0.getCell(0).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                Database.getInstance().addBasementLockers(new Locker((int) rows0.getCell(0).getNumericCellValue(), "Basement"));
            }
        }

        int numOfSecondRows = second.getPhysicalNumberOfRows();
        for (int i = 0; i < numOfSecondRows; i++) {
            HSSFRow rows2 = second.getRow(i);
            if (rows2.getCell(0).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                Database.getInstance().addSecondLockers(new Locker((int) rows2.getCell(0).getNumericCellValue(), "Second Floor"));
            }
        }

        int numOfThirdRows = third.getPhysicalNumberOfRows();
        for (int i = 0; i < numOfThirdRows; i++) {
            HSSFRow rows3 = third.getRow(i);
            if (rows3.getCell(0).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                Database.getInstance().addThirdLockers(new Locker((int) rows3.getCell(0).getNumericCellValue(), "Third Floor"));
            }
        }

        int numOfFourthRows = fourth.getPhysicalNumberOfRows();
        for (int i = 0; i < numOfFourthRows; i++) {
            HSSFRow rows4 = fourth.getRow(i);
            if (rows4.getCell(0).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                Database.getInstance().addFourthLockers(new Locker((int) rows4.getCell(0).getNumericCellValue(), "Fourth Floor"));
            }
        }


        HSSFWorkbook willcall = new HSSFWorkbook(new FileInputStream("Will_Call.xls"));
        HSSFSheet sheet = willcall.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();

        for (int i = 1; i < rows; i++) {
            HSSFRow row = sheet.getRow(i);
            Database.getInstance().addStudents(new Student(row.getCell(20).getStringCellValue(),
                    row.getCell(21).getStringCellValue(),
                    row.getCell(22).getNumericCellValue(),
                    row.getCell(23).getStringCellValue(),
                    (int) row.getCell(35).getNumericCellValue(),
                    row.getCell(34).getStringCellValue()));
        }


        Database.getInstance().sortLockers(Database.getInstance().basementLockers());
        Database.getInstance().sortLockers(Database.getInstance().secondLockers());
        Database.getInstance().sortLockers(Database.getInstance().thirdLockers());
        Database.getInstance().sortLockers(Database.getInstance().fourthLockers());

        Database.getInstance().allocateLockers(rows);


        //Write to Excel
        HSSFWorkbook allocation = new HSSFWorkbook();
        List<HSSFSheet> sheets = new ArrayList<>();
        HSSFSheet basementLockers = allocation.createSheet("Basement");
        HSSFSheet secondLockers = allocation.createSheet("Second Floor");
        HSSFSheet thirdLockers = allocation.createSheet("Third Floor");
        HSSFSheet fourthLockers = allocation.createSheet("Fourth Floor");
        sheets.add(basementLockers);
        sheets.add(secondLockers);
        sheets.add(thirdLockers);
        sheets.add(fourthLockers);

        for (int i = 0; i < sheets.size(); i++) {
            HSSFSheet currentSheet = sheets.get(i);
            HSSFRow headers = currentSheet.createRow(0);
            HSSFCell c1 = headers.createCell(0);
            HSSFCell c2 = headers.createCell(1);
            HSSFCell c3 = headers.createCell(2);
            HSSFCell c4 = headers.createCell(3);
            HSSFCell c5 = headers.createCell(4);
            HSSFCell c6 = headers.createCell(5);
            c1.setCellValue("First Name");
            c2.setCellValue("Last Name");
            c3.setCellValue("Student Number");
            c4.setCellValue("Phone Number");
            c5.setCellValue("Email Address");
            c6.setCellValue("Locker Number");
        }

        List<Student> allStudents = Database.getInstance().students();
        int studentSize = allStudents.size();
        int bRowCounter = 1;
        int sRowCounter = 1;
        int tRowCounter = 1;
        int fRowCounter = 1;

        for (int j = 0; j < studentSize; j++) {
            Student currStudent = allStudents.get(j);
            int lockerNum = currStudent.getLockerNum();
            if (lockerNum >= 1 && lockerNum < 2001) {
                HSSFRow row = basementLockers.createRow(bRowCounter);
                HSSFCell cell0 = row.createCell(0);
                HSSFCell cell1 = row.createCell(1);
                HSSFCell cell2 = row.createCell(2);
                HSSFCell cell3 = row.createCell(3);
                HSSFCell cell4 = row.createCell(4);
                HSSFCell cell5 = row.createCell(5);
                cell0.setCellValue(currStudent.getFirstName());
                cell1.setCellValue(currStudent.getLastName());
                cell2.setCellValue(currStudent.getStudentNumber());
                cell3.setCellValue(currStudent.getPhoneNum());
                cell4.setCellValue(currStudent.getEmail());
                cell5.setCellValue(currStudent.getLockerNum());
                bRowCounter++;
            } else if (lockerNum >= 2001 && lockerNum < 3001) {
                HSSFRow row = secondLockers.createRow(sRowCounter);
                HSSFCell cell0 = row.createCell(0);
                HSSFCell cell1 = row.createCell(1);
                HSSFCell cell2 = row.createCell(2);
                HSSFCell cell3 = row.createCell(3);
                HSSFCell cell4 = row.createCell(4);
                HSSFCell cell5 = row.createCell(5);
                cell0.setCellValue(currStudent.getFirstName());
                cell1.setCellValue(currStudent.getLastName());
                cell2.setCellValue(currStudent.getStudentNumber());
                cell3.setCellValue(currStudent.getPhoneNum());
                cell4.setCellValue(currStudent.getEmail());
                cell5.setCellValue(currStudent.getLockerNum());
                sRowCounter++;
            } else if (lockerNum >= 3001 && lockerNum < 4001) {
                HSSFRow row = thirdLockers.createRow(tRowCounter);
                HSSFCell cell0 = row.createCell(0);
                HSSFCell cell1 = row.createCell(1);
                HSSFCell cell2 = row.createCell(2);
                HSSFCell cell3 = row.createCell(3);
                HSSFCell cell4 = row.createCell(4);
                HSSFCell cell5 = row.createCell(5);
                cell0.setCellValue(currStudent.getFirstName());
                cell1.setCellValue(currStudent.getLastName());
                cell2.setCellValue(currStudent.getStudentNumber());
                cell3.setCellValue(currStudent.getPhoneNum());
                cell4.setCellValue(currStudent.getEmail());
                cell5.setCellValue(currStudent.getLockerNum());
                tRowCounter++;
            } else {
                HSSFRow row = fourthLockers.createRow(fRowCounter);
                HSSFCell cell0 = row.createCell(0);
                HSSFCell cell1 = row.createCell(1);
                HSSFCell cell2 = row.createCell(2);
                HSSFCell cell3 = row.createCell(3);
                HSSFCell cell4 = row.createCell(4);
                HSSFCell cell5 = row.createCell(5);
                cell0.setCellValue(currStudent.getFirstName());
                cell1.setCellValue(currStudent.getLastName());
                cell2.setCellValue(currStudent.getStudentNumber());
                cell3.setCellValue(currStudent.getPhoneNum());
                cell4.setCellValue(currStudent.getEmail());
                cell5.setCellValue(currStudent.getLockerNum());
                fRowCounter++;
            }
        }


        allocation.write(new FileOutputStream("Allocated Lockers.xls"));
        allocation.close();

    }
}

