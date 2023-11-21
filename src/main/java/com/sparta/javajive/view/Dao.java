package com.sparta.javajive.view;

import java.util.ArrayList;

public interface Dao {

    Employee getById(String id);

    Employee getByLastName(String lastName);

    ArrayList<Employee> getByDateRange(String startDate, String endDate);

    ArrayList<Employee> getByAgeRange(String startAge, String endAge);

}