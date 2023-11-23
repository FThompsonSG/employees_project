package com.sparta.javajive.view;

import com.sparta.javajive.model.Employee;

import java.util.ArrayList;

public interface Dao {

    Employee getById(int id);

    Employee getByLastName(String lastName);

    ArrayList<Employee> getByDateRange(String startDate, String endDate);

    ArrayList<Employee> getByAgeRange(String startAge, String endAge);

}