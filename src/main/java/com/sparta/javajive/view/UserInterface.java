package com.sparta.javajive.view;

import com.sparta.javajive.model.EmployeeStore;

import java.util.Scanner;

public class UserInterface {
    public static void userInterfaceStart() {
        Scanner numberOfEmployeesScanner = new Scanner(System.in);
        System.out.println("----------------" + "\n" + "How many employees would you like to query?" + "\n" + "----------------");
        if(numberOfEmployeesScanner.hasNextInt()) {
            int choice = numberOfEmployeesScanner.nextInt();
            numberOfEmployeesScanner.nextLine();
            if(choice <= 0 || choice > 1000) {
                System.out.println("Invalid Choice, please choose an integer over 0 and below 1000");
            } else {
                initEmployeeStore(choice);
            }
        } else {
            System.out.println("Invalid Choice, please choose an integer over 0 and below 1000");
        }
        numberOfEmployeesScanner.close();
    }

    public static void initEmployeeStore(int choice) {
        try {
            EmployeeStore.initializeEmployeeStore(choice);
            displayMethodChoices();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void displayMethodChoices() {
        Scanner methodMenuChoice = new Scanner(System.in);

        int choice = 0;

        while(choice != 4) {
            System.out.println(" ");
            System.out.println("Please pick a method that you would like to call to query these employees.");
            System.out.println(" ");
            System.out.println("1. ");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. Exit");

            if(methodMenuChoice.hasNextInt()) {
                choice = methodMenuChoice.nextInt();
                methodMenuChoice.nextLine(); //eat the new line character

                //method calls for controller methods
                switch(choice) {
                    case 1 -> System.out.println("1 was selected");
                    case 2 -> System.out.println("2 was selected");
                    case 3 -> System.out.println("3 was selected");
                    case 4 -> System.out.println("Exit was selected");
                    default -> System.out.println("Invalid choice of method");
                }
            } else {
                System.out.println("Invalid choice");
                methodMenuChoice.nextLine();
            }
        }
        methodMenuChoice.close();
    }

}
