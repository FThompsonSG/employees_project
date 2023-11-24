package com.sparta.javajive.view;

import com.sparta.javajive.controller.DaoImpl;
import com.sparta.javajive.model.Employee;
import com.sparta.javajive.model.EmployeeStore;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInput {


    DaoImpl daoImpl = new DaoImpl(EmployeeStore.getEmployeeStore());

    public void empIDScanner() throws InputMismatchException {
        try {
            Scanner empIdScanner = new Scanner(System.in);
            System.out.println("Please enter the employee ID: ");
            int empIdInput = empIdScanner.nextInt();
            System.out.println(daoImpl.getById(empIdInput));
        }catch (InputMismatchException e){
            System.err.println("Invalid Input.");
        }
    }

    public void lastNameScanner() {
        Scanner lastNameScanner = new Scanner(System.in);
        System.out.println("Please enter the Last Name");
        String lastNameInput = lastNameScanner.nextLine();
        System.out.println(daoImpl.getByLastName(lastNameInput));
    }

    public void dateRangeScanner() {
        Scanner dateRangeScanner = new Scanner(System.in);
        System.out.println("Please enter the first date in date range: (dd/MM/YYYY)");
        String dateRangeFirstInput = dateRangeScanner.nextLine();
        System.out.println("Please enter the second date in date range: (dd/MM/YYYY)");
        String dateRangeLastInput = dateRangeScanner.nextLine();
        PrintArrayList.printArrayList(daoImpl.getByDateRange(dateRangeFirstInput, dateRangeLastInput));
    }

    public void ageRangeScanner() {
        Scanner ageRangeScanner = new Scanner(System.in);
        System.out.println("Please enter the first age in age range: ");
        String ageRangeFirstInput = ageRangeScanner.nextLine();
        System.out.println("Please enter the second age in age range: ");
        String ageRangeLastInput = ageRangeScanner.nextLine();
        PrintArrayList.printArrayList(daoImpl.getByAgeRange(ageRangeFirstInput, ageRangeLastInput));
    }

}
