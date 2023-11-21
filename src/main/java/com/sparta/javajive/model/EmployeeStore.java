package com.sparta.javajive.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStore {
    private static List<Employee> employeeStore = new ArrayList<>();

    public static List<Employee> getEmployeeStore() {
        return employeeStore;
    }


    public static Employee createEmployee(String empInfo) {
        String[] splitEmpInfo = empInfo.split(",");
        return new Employee(Integer.parseInt(splitEmpInfo[0]),splitEmpInfo[1],splitEmpInfo[2], splitEmpInfo[3].charAt(0),splitEmpInfo[4],splitEmpInfo[5],splitEmpInfo[6],splitEmpInfo[7],splitEmpInfo[8],Integer.parseInt(splitEmpInfo[9]));
    }

    public static void setEmployeeArray(Employee employee){
        employeeStore.add(employee);
    }


    public static void initializeEmployeeStore(int howMany) {
        try {
            String[] employeeStringArray = EmployeeFactory.getEmployees(howMany);
            for (String employeeString: employeeStringArray) {
                setEmployeeArray(createEmployee(employeeString));
            }
        } catch (Exception e) {
            System.out.println("IOException");
        }
    }
}
