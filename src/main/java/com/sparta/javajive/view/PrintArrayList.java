package com.sparta.javajive.view;

import com.sparta.javajive.model.Employee;

import java.util.ArrayList;

public class PrintArrayList {

    public static void printArrayList(ArrayList<Employee> arrayList) {

        for (Employee employee : arrayList) {
            System.out.println(employee.toString());
        }

    }

}
