package com.sparta.javajive.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmployeeStoreTest {

    @Test
    @DisplayName("Testing Employee Store Initialisation")
    public void testingEmployeeStoreInitialisation(){
        EmployeeStore.initializeEmployeeStore(1000);
        Assertions.assertEquals(100, EmployeeStore.getEmployeeStore().size());
    }
}
