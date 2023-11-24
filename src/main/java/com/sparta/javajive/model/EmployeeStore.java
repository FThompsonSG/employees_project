package com.sparta.javajive.model;


import java.util.logging.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EmployeeStore {
    private static final Logger employeeFileLogger = Logger.getLogger(EmployeeStore.class.getName());
    private static final Logger corruptedEmployeeFileLogger = Logger.getLogger("CorruptedEmployeeLogger");
    private static final Logger corruptedEmployeeConsoleLogger = Logger.getLogger("corruptedEmployeeConsoleLogger");

    private static List<Employee> employeeStore = new ArrayList<>();
    private static Map<String, Integer> corruptedEmployees = new HashMap<>();

    public static CorruptedEmployeeChecker corruptedEmployeeChecker = new CorruptedEmployeeChecker();

    public static List<Employee> getEmployeeStore() {
        return employeeStore;
    }

    public static void createEmployee(String empInfo) throws IOException {
        String[] splitEmpInfo = empInfo.split(",");

        Employee newEmployee = new Employee(Integer.parseInt(splitEmpInfo[0]),splitEmpInfo[1],splitEmpInfo[2], splitEmpInfo[3].charAt(0),splitEmpInfo[4],splitEmpInfo[5],splitEmpInfo[6],splitEmpInfo[7],splitEmpInfo[8],Integer.parseInt(splitEmpInfo[9]));

        int numberOfCorruptedFields = corruptedEmployeeChecker.countCorruptedFields(newEmployee);

        if(numberOfCorruptedFields > 0) {
            String fullName = splitEmpInfo[2] + " " + splitEmpInfo[3] + " " + splitEmpInfo[4];
            corruptedEmployees.put(fullName, numberOfCorruptedFields);
            logCorruptedEmployees(empInfo);
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
            logAmountOfCorruptEmployeesToConsole();
            logEmployees(employeeStringArray);
        } catch (IOException e) {
            System.out.println("An IOException has occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void logAmountOfCorruptEmployeesToConsole() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleMessageFormatter());
        consoleHandler.setLevel(Level.ALL);
        corruptedEmployeeConsoleLogger.setUseParentHandlers(false);
        corruptedEmployeeConsoleLogger.addHandler(consoleHandler);
        EmployeeStore.corruptedEmployeeConsoleLogger.warning("Corrupted files: " + String.valueOf(corruptedEmployees.size()));
    }

    private static void logEmployees(String[] employeeStringArray) throws IOException {
        FileHandler employeeFileHandler = new FileHandler("src/main/resources/EmployeeStore.log");
        employeeFileHandler.setLevel(Level.ALL);
        employeeFileHandler.setFormatter(new SimpleMessageFormatter());
        employeeFileLogger.setUseParentHandlers(false);
        employeeFileLogger.addHandler(employeeFileHandler);
        employeeFileLogger.info("ClientID, Name Prefix, FirstName, MidInitial, LastName, Gender, Email, DoB, DoJ, Salary");
        for (String item : employeeStringArray) {
            employeeFileLogger.info(item);
        }
    }
    private static void logCorruptedEmployees(String employeeStringArray) throws IOException {
        FileHandler corruptedEmployeeFileHandler = new FileHandler("src/main/resources/corruptedEmployeeStore.log");
        corruptedEmployeeFileHandler.setLevel(Level.ALL);
        corruptedEmployeeFileHandler.setFormatter(new SimpleMessageFormatter());
        corruptedEmployeeFileLogger.setUseParentHandlers(false);
        corruptedEmployeeFileLogger.addHandler(corruptedEmployeeFileHandler);
        corruptedEmployeeFileLogger.info("ClientID, Name Prefix, FirstName, MidInitial, LastName, Gender, Email, DoB, DoJ, Salary");
        corruptedEmployeeFileLogger.info(employeeStringArray);
    }



    public static void addEmployee(Employee employee) {
        employeeStore.add(employee);
    }
}
