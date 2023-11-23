package com.sparta.javajive.view;

import com.sparta.javajive.model.Employee;
import com.sparta.javajive.model.EmployeeStore;

import java.time.LocalDate;
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
    public ArrayList<Employee> getByDateRange(String minRange, String maxRange) {
        ArrayList<Employee> result = new ArrayList<>();
        LocalDate startDate = LocalDate.parse(minRange);
        LocalDate endDate = LocalDate.parse(maxRange);

        for (Employee employee :EmployeeStore.getEmployeeStore()) {
            LocalDate dateOfJoining = LocalDate.parse(employee.getDateOfJoining());
            if(!dateOfJoining.isBefore(startDate) && !dateOfJoining.isAfter(endDate)){
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Employee> getByAgeRange(String minAge, String maxAge) {
        Integer minimumAge = Integer.parseInt(minAge);
        Integer maximumAge = Integer.parseInt(minAge);

        return null;
    }

}
