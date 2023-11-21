package com.sparta.javajive.view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class DaoTest {

    public static void set() {
        ArrayList<Employee> employees;
        Employee employee1 = new Employee("11111", "Mr", "Fergus", "R", "Thompson", "M", "example1@hotmail.com", "14/03/1991", "06/11/2023", "£19,000");
        Employee employee2 = new Employee("22222", "Mr", "Fergus", "R", "Kavanagh", "M", "example1@hotmail.com", "14/03/1993", "11/07/2022", "£19,000");
        Employee employee3 = new Employee("33333", "Mr", "Fergus", "R", "Cunha", "M", "example1@hotmail.com", "14/03/1996", "25/02/2020", "£19,000");
        Employee employee4 = new Employee("44444", "Mr", "Fergus", "R", "Boorman", "M", "example1@hotmail.com", "14/03/1999", "19/04/2018", "£19,000");
    }

    @BeforeAll
    static void setUp() {
        set();
    }

    @Test
    void getById() {
    }

    @Test
    void getByLastName() {
    }

    @Test
    void getByDateRange() {
    }

    @Test
    void getByAgeRange() {
    }

}