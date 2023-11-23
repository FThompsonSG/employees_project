package com.sparta.javajive.view;

import com.sparta.javajive.controller.DaoImpl;
import com.sparta.javajive.model.Employee;
import com.sparta.javajive.model.EmployeeStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class DaoImplTest {

    ArrayList<Employee> employees = new ArrayList<>();
    DaoImpl daoImpl = new DaoImpl(employees);

    @BeforeAll
    public static void set() {
//        Employee employee1 = new Employee(11111, "Mr", "Fergus", 'R', "Thompson", "M", "example1@hotmail.com", "14/03/1991", "06/11/2023", 19000);
//        Employee employee2 = new Employee(22222, "Mr", "Fergus", 'C', "Kavanagh", "M", "example1@hotmail.com", "14/03/1993", "11/07/2022", 20000);
//        Employee employee3 = new Employee(33333, "Mr", "Fergus", 'R', "Cunha", "M", "example1@hotmail.com", "14/03/1996", "25/02/2020", 19000);
//        Employee employee4 = new Employee(44444, "Mr", "Fergus", 'C', "Boorman", "M", "example1@hotmail.com", "14/03/1999", "19/04/2018", 19000);
//        employees.add(employee1);
//        employees.add(employee2);
//        employees.add(employee3);
//        employees.add(employee4);
        EmployeeStore.initializeEmployeeStore(10);
    }

    @BeforeAll
    static void setUpAll() {
        set();
    }

    @Test
    void getByIdTest() {
        Employee employee = new Employee(777872, "Mr.", "Blaine", 'Q', "Cockrell", "M", "blaine.cockrell@gmail.com", "31/08/1973", "29/06/2016", 176446);
        Assertions.assertEquals(employee, daoImpl.getById(777872));

    }

    @Test
    void getByLastNameNoneFoundTest() {
        Employee employee = new Employee(777872, "Mr.", "Blaine", 'Q', "Cockrell", "M", "blaine.cockrell@gmail.com", "31/08/1973", "29/06/2016", 176446);
        Assertions.assertEquals(employees, daoImpl.getByLastName("Cockrell"));
    }

    @Test
    void getByDateRangeTest() {
    }

    @Test
    void getByAgeRangeTest() {
    }

}