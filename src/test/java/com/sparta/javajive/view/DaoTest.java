package com.sparta.javajive.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class DaoTest {

//    DaoImpl daoImpl = new DaoImpl();
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void set() {
        Employee employee1 = new Employee("11111", "Mr", "Fergus", "R", "Thompson", "M", "example1@hotmail.com", "14/03/1991", "06/11/2023", "£19,000");
        Employee employee2 = new Employee("22222", "Mr", "Fergus", "R", "Kavanagh", "M", "example1@hotmail.com", "14/03/1993", "11/07/2022", "£19,000");
        Employee employee3 = new Employee("33333", "Mr", "Fergus", "R", "Cunha", "M", "example1@hotmail.com", "14/03/1996", "25/02/2020", "£19,000");
        Employee employee4 = new Employee("44444", "Mr", "Fergus", "R", "Boorman", "M", "example1@hotmail.com", "14/03/1999", "19/04/2018", "£19,000");
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
    }

    @BeforeAll
    static void setUp() {
        set();
    }

    @Test
    void getByIdTest() {
//        Assertions.assertEquals(employees[0], daoImpl.getById(employees,"11111"));
    }

    @Test
    void getByLastNameTest() {
    }

    @Test
    void getByDateRangeTest() {
    }

    @Test
    void getByAgeRangeTest() {
    }

}