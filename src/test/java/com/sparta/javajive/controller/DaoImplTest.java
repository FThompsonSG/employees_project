package com.sparta.javajive.controller;

import com.sparta.javajive.controller.DaoImpl;
import com.sparta.javajive.model.Employee;
import com.sparta.javajive.model.EmployeeFactory;
import com.sparta.javajive.model.EmployeeStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DaoImplTest {

    ArrayList<Employee> employees = new ArrayList<>();
    DaoImpl daoImpl = new DaoImpl(employees);

    @BeforeAll
    public static void set() {
        EmployeeStore.initializeEmployeeStore(100);
        Employee employee = new Employee(11111, "Mr", "Fergus", 'R', "Thompson", "M", "example1@hotmail.com", "14/03/1991", "06/11/2023", 19000);
        EmployeeStore.addEmployee(employee);
    }

    @BeforeAll
    static void setUpAll() {
        set();
    }

    @Test
    void getByIdNoneFoundTest() {
        Assertions.assertNull(daoImpl.getById(123456));
    }

    @Test
    void getByIdTest() {
        Employee employee = new Employee(777872, "Mr.", "Blaine", 'Q', "Cockrell", "M", "blaine.cockrell@gmail.com", "31/08/1973", "29/06/2016", 176446);
        EmployeeStore.addEmployee(employee);
        Assertions.assertEquals(employee, daoImpl.getById(777872));
    }

    @Test
    void getByLastNameNoneFoundTest() {
        Employee employee = new Employee(777872, "Mr.", "Blaine", 'Q', "Cockrell", "M", "blaine.cockrell@gmail.com", "31/08/1973", "29/06/2016", 176446);
        Assertions.assertEquals(employees, daoImpl.getByLastName("Cockrell"));
    }

    @Test
    void getByLastNameTest() {
        Employee employee = new Employee(11111, "Mr", "Fergus", 'R', "Thompson", "M", "example1@hotmail.com", "14/03/1991", "06/11/2023", 19000);
        employees.add(employee);
        Assertions.assertEquals(employees.toString(), daoImpl.getByLastName("Thompson").toString());
    }

    @Test
    void getByDateRangeTest() {
        Employee employee = new Employee(777872, "Mr.", "Blaine", 'Q', "Cockrell", "M", "blaine.cockrell@gmail.com", "31/08/1973", "29/06/2016", 176446);
        EmployeeStore.addEmployee(employee);
        employees.add(employee);
        Assertions.assertEquals(employees, daoImpl.getByDateRange("29/06/2016", "30/06/2016"));
    }

    @Test
    void getByAgeRangeTest() {
        Employee employee = new Employee(777872, "Mr.", "Blaine", 'Q', "Cockrell", "M", "blaine.cockrell@gmail.com", "31/08/2005", "29/06/2016", 176446);
        EmployeeStore.addEmployee(employee);
        employees.add(employee);
        Assertions.assertEquals(employees, daoImpl.getByAgeRange("18", "18"));
    }
    

}