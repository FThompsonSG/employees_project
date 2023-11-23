package com.sparta.javajive.model;

import java.util.*;
import java.util.logging.*;

public class EmployeeStore {
    private static final Logger logger = Logger.getLogger(EmployeeStore.class.getName());//pulls information from the class itself

    private static List<Employee> employeeStore = new ArrayList<>();
    private static Map<String, Integer> corruptedEmployees = new HashMap<>();

    public static CorruptedEmployeeChecker corruptedEmployeeChecker = new CorruptedEmployeeChecker();

    public static List<Employee> getEmployeeStore() {
        return employeeStore;
    }

    public static Employee createEmployee(String empInfo) {
        String[] splitEmpInfo = empInfo.split(",");

        int numberOfCorruptedFields = corruptedEmployeeChecker.countCorruptedFields(splitEmpInfo);

        if(numberOfCorruptedFields > 0) {
            String fullName = splitEmpInfo[2] + " " + splitEmpInfo[3] + " " + splitEmpInfo[4];
            corruptedEmployees.put(fullName, numberOfCorruptedFields);
        }

        return new Employee(Integer.parseInt(splitEmpInfo[0]),splitEmpInfo[1],splitEmpInfo[2], splitEmpInfo[3].charAt(0),splitEmpInfo[4],splitEmpInfo[5],splitEmpInfo[6],splitEmpInfo[7],splitEmpInfo[8],Integer.parseInt(splitEmpInfo[9]));
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
                setEmployeeArray(createEmployee(employeeString));
            }
            FileHandler fileHandler = new FileHandler("src/main/resources/loggedEmployeeFile.log");
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.setUseParentHandlers(false);
            logger.addHandler(fileHandler);

            for (String item : employeeStringArray) {
                logger.info(item);
            }
        } catch (Exception e) {
            System.out.println("IOException");
        }
    }

    public static void main(String[] args) {
        initializeEmployeeStore(10);
    }

    public static void addEmployee(Employee employee) {
        employeeStore.add(employee);
    }
}
