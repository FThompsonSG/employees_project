package com.sparta.javajive.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeStore {
    private static List<Employee> employeeStore = new ArrayList<>();
    private static Map<String, Integer> corruptedEmployees = new HashMap<>();

    public static Map<String, Integer> getCorruptedEmployees() {
        return corruptedEmployees;
    }

    public static int getNumberOfCorruptedEmployees() {
        return corruptedEmployees.size();
    }

    public static List<Employee> getEmployeeStore() {
        return employeeStore;
    }

    public static Employee createEmployee(String empInfo) {
        String[] splitEmpInfo = empInfo.split(",");

        int numberOfCorruptedFields = countCorruptedFields(splitEmpInfo);

        if(numberOfCorruptedFields > 0) {
            String fullName = splitEmpInfo[2] + " " + splitEmpInfo[3] + " " + splitEmpInfo[4];
            corruptedEmployees.put(fullName, numberOfCorruptedFields);
        }

        return new Employee(Integer.parseInt(splitEmpInfo[0]),splitEmpInfo[1],splitEmpInfo[2], splitEmpInfo[3].charAt(0),splitEmpInfo[4],splitEmpInfo[5],splitEmpInfo[6],splitEmpInfo[7],splitEmpInfo[8],Integer.parseInt(splitEmpInfo[9]));
    }

    public static int countCorruptedFields(String[] splitEmpInfo) {
        int corrputedCount = 0;

        //employee id should be max 8 digits
        if(splitEmpInfo[0].length() > 8) {
            corrputedCount++;
        }

        //Gender should be M or F
        if(!splitEmpInfo[5].equals("M") && !splitEmpInfo[5].equals("F")) {
            corrputedCount++;
        }

        if(Integer.parseInt(splitEmpInfo[9]) < 0) {
            corrputedCount++;
        }

        corrputedCount += checkCorruptedEmail(splitEmpInfo);

        corrputedCount += checkDatesCorrupted(splitEmpInfo);

        return corrputedCount;
    }

    private static int checkCorruptedEmail(String[] splitEmpInfo) {
        int emailCorrupted = 0;
        //email should be in standard format
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(splitEmpInfo[6]);
        if(!matcher.matches()) {
            emailCorrupted++;
        }
        return emailCorrupted;
    }

    private static int checkDatesCorrupted(String[] splitEmpInfo) {
        int corrputedDates = 0;
        //dob and doj should be in format YYYY-MM-DD
        String dateRegex = "^\\d{2}/\\d{2}/\\d{4}$";
        Pattern datePattern = Pattern.compile(dateRegex);
        Matcher dobMatcher = datePattern.matcher(splitEmpInfo[7]);
        Matcher dojMatcher = datePattern.matcher(splitEmpInfo[8]);
        if(!dobMatcher.matches()) {
            System.out.println("dob");
            corrputedDates++;
        }
        if(!dojMatcher.matches()) {
            System.out.println("doj");
            corrputedDates++;
        }
        return corrputedDates;
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
        } catch (Exception e) {
            System.out.println("IOException");
        }
    }
}
