package com.sparta.javajive.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeStore {
    private static List<Employee> employeeStore = new ArrayList<>();
    private static Map<String, Integer> corruptedEmployees = new HashMap<>();

    public static CorruptedEmployeeChecker corruptedEmployeeChecker = new CorruptedEmployeeChecker();

    public static List<Employee> getEmployeeStore() {
        return employeeStore;
    }

    public static void createEmployee(String empInfo) {
        String[] splitEmpInfo = empInfo.split(",");

        Employee newEmployee = new Employee(Integer.parseInt(splitEmpInfo[0]),splitEmpInfo[1],splitEmpInfo[2], splitEmpInfo[3].charAt(0),splitEmpInfo[4],splitEmpInfo[5],splitEmpInfo[6],splitEmpInfo[7],splitEmpInfo[8],Integer.parseInt(splitEmpInfo[9]));

        int numberOfCorruptedFields = corruptedEmployeeChecker.countCorruptedFields(newEmployee);

        if(numberOfCorruptedFields > 0) {
            String fullName = splitEmpInfo[2] + " " + splitEmpInfo[3] + " " + splitEmpInfo[4];
            corruptedEmployees.put(fullName, numberOfCorruptedFields);
        } else {
            setEmployeeArray(newEmployee);
        }
    }

    public static void setEmployeeArray(Employee employee){
        employeeStore.add(employee);
    }

    public static void initializeEmployeeStore(int howMany) {
        try {
            employeeStore.clear();
            corruptedEmployees.clear();
            String[] employeeStringArray = EmployeeFactory.getEmployees(howMany);
            for (String employeeString: employeeStringArray) {
                createEmployee(employeeString);
            }
        } catch (IOException e) {
            System.out.println("An IOException has occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initializeEmployeeStore(1000);
        System.out.println(corruptedEmployees);
    }

    public static void addEmployee(Employee employee) {
        employeeStore.add(employee);
    }
}
