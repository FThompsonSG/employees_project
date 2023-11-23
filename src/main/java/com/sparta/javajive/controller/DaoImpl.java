package com.sparta.javajive.controller;

import com.sparta.javajive.model.Employee;
import com.sparta.javajive.model.EmployeeStore;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao {

    private List<Employee> employees;

    public DaoImpl(List<Employee> employees) {
        this.employees = employees;
    }


    @Override
    public Employee getById(int empId) {
        for (Employee employee : EmployeeStore.getEmployeeStore()) {
            if (employee.getEmpId().equals(empId)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Employee> getByLastName(String lastName) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : EmployeeStore.getEmployeeStore()) {
            System.out.println(employee.toString());
            System.out.println(employee.getLastName());
            if (employee.getLastName().equals(lastName)) {
                result.add(employee);
            }
        }
        if (result.size() == 0) {
            System.err.println("No employees found matching criteria");
        }
        return result;
    }

    @Override
    public ArrayList<Employee> getByDateRange(String minRange, String maxRange) {
        ArrayList<Employee> result = new ArrayList<>();
        LocalDate startDate = LocalDate.parse(minRange);
        LocalDate endDate = LocalDate.parse(maxRange);

        for (Employee employee : EmployeeStore.getEmployeeStore()) {
            LocalDate dateOfJoining = LocalDate.parse(employee.getDateOfJoining());
            if (!dateOfJoining.isBefore(startDate) && !dateOfJoining.isAfter(endDate)) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Employee> getByAgeRange(String minAge, String maxAge) {
        ArrayList<Employee> result = new ArrayList<>();
        Integer minimumAge = Integer.parseInt(minAge);
        Integer maximumAge = Integer.parseInt(maxAge);

        for (Employee employee : EmployeeStore.getEmployeeStore()) {
            LocalDate dateOfBirth = LocalDate.parse(employee.getDateOfBirth());
            LocalDate currentDate = LocalDate.now();
            Period period = Period.between(dateOfBirth, currentDate);
            int yearsOld = period.getYears();
            if (yearsOld >= minimumAge && yearsOld <= maximumAge) {
                result.add(employee);
            }

        }
        return result;
    }

}
