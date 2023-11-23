package com.sparta.javajive.model;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorruptedEmployeeChecker {

    public int countCorruptedFields(Employee employee){
        int corruptedFields = 0;
        corruptedFields += checkCorruptedId(employee);
        corruptedFields += checkCorruptedGender(employee);
        corruptedFields += checkCorruptedSalary(employee);
        corruptedFields += checkCorruptedEmail(employee);
        corruptedFields += checkCorruptedDates(employee);
        return corruptedFields;
    }

    public int checkCorruptedDates(Employee employee) {
        int corruptedDates = 0;
        String dateRegex = "^\\d{2}/\\d{2}/\\d{4}$";
        Pattern datePattern = Pattern.compile(dateRegex);
        Matcher dobMatcher = datePattern.matcher(employee.getDateOfBirth());
        Matcher dojMatcher = datePattern.matcher(employee.getDateOfJoining());
        if(!dobMatcher.matches()){
            corruptedDates++;
        }
        if(!dojMatcher.matches()){
            corruptedDates++;
        }
        return corruptedDates;
    }

    public int checkCorruptedEmail(Employee employee) {
        int corruptedEmail = 0;
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(employee.getEmail());
        if(!matcher.matches()){
            corruptedEmail++;
        }
        return corruptedEmail;
    }

    public int checkCorruptedSalary(Employee employee) {
        int corruptedSalary = 0;
        if(employee.getSalary() < 0){
            corruptedSalary++;
        }
        return corruptedSalary;
    }

    public int checkCorruptedGender(Employee employee) {
        int corruptedGender = 0;
        if(!employee.getGender().equals("M") && !employee.getGender().equals("F")){
            corruptedGender++;
        }
        return corruptedGender;
    }

    public int checkCorruptedId(Employee employee) {
        int corruptedId = 0;
        if(employee.getEmpId().toString().length() > 8){
            corruptedId++;
        }
        return corruptedId;
    }

}
