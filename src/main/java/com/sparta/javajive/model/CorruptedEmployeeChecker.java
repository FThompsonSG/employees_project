package com.sparta.javajive.model;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorruptedEmployeeChecker {

    private static Map<String, Integer> corruptedEmployees = new HashMap<>();


    public static Map<String, Integer> getCorruptedEmployees() {
        return corruptedEmployees;
    }

    public int getNumberOfCorruptedEmployees() {
        return corruptedEmployees.size();
    }

    public int countCorruptedFields(String[] splitEmpInfo) {
        int corrputedCount = 0;

        //employee id should be max 8 digits
        corrputedCount += checkCorruptedId(splitEmpInfo);

        //Gender should be M or F
        corrputedCount += checkCorrputedGender(splitEmpInfo);

        //checks salary is positive
        corrputedCount += checkCorruptedSalary(splitEmpInfo);

        //checks email
        corrputedCount += checkCorruptedEmail(splitEmpInfo);

        //checks 2 dates
        corrputedCount += checkCorruptedDates(splitEmpInfo);

        return corrputedCount;
    }

    public int checkCorruptedSalary(String[] splitEmpInfo) {
        int corruptedSalary = 0;
        if(Integer.parseInt(splitEmpInfo[9]) < 0) {
            corruptedSalary++;
        }
        return corruptedSalary;
    }

    public int checkCorruptedId(String[] splitEmpInfo) {
        int corruptedId = 0;

        if(splitEmpInfo[0].length() > 8) {
            corruptedId++;
        }
        return corruptedId;
    }

    public int checkCorrputedGender(String[] splitEmpInfo) {
        int corruptedGender = 0;
        if(!splitEmpInfo[5].equals("M") && !splitEmpInfo[5].equals("F")) {
            corruptedGender++;
        }
        return corruptedGender;
    }

    public int checkCorruptedEmail(String[] splitEmpInfo) {
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

    public int checkCorruptedDates(String[] splitEmpInfo) {
        int corrputedDates = 0;
        //dob and doj should be in format YYYY-MM-DD
        String dateRegex = "^\\d{2}/\\d{2}/\\d{4}$";
        Pattern datePattern = Pattern.compile(dateRegex);
        Matcher dobMatcher = datePattern.matcher(splitEmpInfo[7]);
        Matcher dojMatcher = datePattern.matcher(splitEmpInfo[8]);
        if(!dobMatcher.matches()) {
            corrputedDates++;
        }
        if(!dojMatcher.matches()) {
            corrputedDates++;
        }
        return corrputedDates;
    }



}
