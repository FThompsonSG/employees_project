package com.sparta.javajive.model;

public class FactoryTest {

    public static void main(String[] args) {
        try {
            String[] test = EmployeeFactory.getEmployees(3);
            for (String employee: test) {
                System.out.println(employee);
            }
        } catch (Exception e) {
            System.out.println("IOException");
        }
    }
}
