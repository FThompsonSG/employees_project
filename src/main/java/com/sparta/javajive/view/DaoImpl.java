package com.sparta.javajive.view;

import com.sparta.javajive.model.Employee;
import com.sparta.javajive.model.EmployeeStore;

import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao {

    private List<Employee> employees;

    public DaoImpl(List<Employee> employees) {
        this.employees = employees;
    }


    @Override
    public Employee getById(int empId) {
        for(Employee employee: EmployeeStore.getEmployeeStore()) {
            if(employee.getEmpId().equals(empId)) {
                return employee;
            }
        } return null;
    }

    @Override
    public Employee getByLastName(String lastName) {
        for(Employee employee:EmployeeStore.getEmployeeStore()) {
            if(employee.getLastName().equals(lastName)){
                return employee;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Employee> getByDateRange(String dateOfJoining, String endDate) {
        return null;
    }

    @Override
    public ArrayList<Employee> getByAgeRange(String dateOfBirth, String endAge) {
        return null;
    }

}
