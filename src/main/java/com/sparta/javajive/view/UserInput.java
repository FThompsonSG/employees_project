package com.sparta.javajive.view;

import com.sparta.javajive.controller.DaoImpl;
import com.sparta.javajive.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {


    ArrayList<Employee> employees = new ArrayList<>();
    DaoImpl daoImpl = new DaoImpl(employees);

    public void empIDScanner() {
        Scanner empIdScanner = new Scanner(System.in);
        System.out.println("Please enter the employee ID: ");
        int empIdInput = empIdScanner.nextInt();
        daoImpl.getById(empIdInput);
        empIdScanner.close();
    }

    public void lastNameScanner() {
        Scanner lastNameScanner = new Scanner(System.in);
        String lastNameInput = lastNameScanner.nextLine();
        daoImpl.getByLastName(lastNameInput);
        lastNameScanner.close();
    }

    public void dateRangeScanner() {
        Scanner dateRangeScanner = new Scanner(System.in);
        System.out.println("Please enter the first date: (dd-MM-YYYY)");
        String dateRangeFirstInput = dateRangeScanner.nextLine();
        System.out.println("Please enter another date: (dd-MM-YYYY)");
        String dateRangeLastInput = dateRangeScanner.nextLine();
        daoImpl.getByDateRange(dateRangeFirstInput, dateRangeLastInput);
        dateRangeScanner.close();
    }

    public void ageRangeScanner() {
        Scanner ageRangeScanner = new Scanner(System.in);
        System.out.println("Please enter the first age in age range: ");
        String ageRangeFirstInput = ageRangeScanner.nextLine();
        System.out.println("Please enter the second age in age range: ");
        String ageRangeLastInput = ageRangeScanner.nextLine();
        daoImpl.getByAgeRange(ageRangeFirstInput, ageRangeLastInput);
        ageRangeScanner.close();
    }

}
