package com.sparta.javajive.controller;

import com.sparta.javajive.model.Employee;
import com.sparta.javajive.model.EmployeeStore;
import com.sparta.javajive.view.PrintArrayList;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao {

    private List<Employee> employees;

    public DaoImpl(List<Employee> employees) {
        this.employees = employees;
    }


    @Override
    public Employee getById(int empId) {
        try {
            for (Employee employee : EmployeeStore.getEmployeeStore()) {
                if (employee.getEmpId().equals(empId)) {
                    return employee;
                }
            }
        } catch (RuntimeException e) {
            System.err.println("Employee Not Found.");
        }
        return null;
    }

    @Override
    public ArrayList<Employee> getByLastName(String lastName) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : EmployeeStore.getEmployeeStore()) {
            if (employee.getLastName().equals(lastName)) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Employee> getByDateRange(String minRange, String maxRange) {
        ArrayList<Employee> result = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate = LocalDate.parse(minRange, formatter);
        LocalDate endDate = LocalDate.parse(maxRange, formatter);


        for (Employee employee : EmployeeStore.getEmployeeStore()) {
            try {
                LocalDate dateOfJoining = LocalDate.parse(employee.getDateOfJoining(), formatter);
                if (!dateOfJoining.isBefore(startDate) && !dateOfJoining.isAfter(endDate)) {
                    result.add(employee);
                }
            } catch (DateTimeParseException e) {
                System.err.println("Error parsing date for: " + employee.getLastName());
            }
        }
        return result;
    }

    @Override
    public ArrayList<Employee> getByAgeRange(String minAge, String maxAge) {
        ArrayList<Employee> result = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Integer minimumAge = Integer.parseInt(minAge);
        Integer maximumAge = Integer.parseInt(maxAge);

        for (Employee employee : EmployeeStore.getEmployeeStore()) {
            LocalDate dateOfBirth = LocalDate.parse(employee.getDateOfBirth(), formatter);
            LocalDate currentDate = LocalDate.now();
            Period period = Period.between(dateOfBirth, currentDate);
            int yearsOld = period.getYears();
            if (yearsOld >= minimumAge && yearsOld <= maximumAge) {
                result.add(employee);
            }
            try {
                LocalDate dateOfBirth = LocalDate.parse(employee.getDateOfBirth(), formatter);
                LocalDate currentDate = LocalDate.now();
                Period period = Period.between(dateOfBirth, currentDate);
                int yearsOld = period.getYears();
                if (yearsOld >= minimumAge && yearsOld <= maximumAge) {
                    result.add(employee);
                }
            } catch (DateTimeParseException e) {
                System.err.println("Error parsing date for: " + employee.getLastName());
            }         
        }
        return result;
    }

}
