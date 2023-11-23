package com.sparta.javajive.view;

public interface Dao {

    void getById(String id);

    void getByLastName(String lastName);

    void getByDateRange(String startDate, String endDate);

    void getByAgeRange(String startAge, String endAge);

}