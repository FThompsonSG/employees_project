package com.sparta.javajive.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmployeeStoreTest {

    //Test is possibly failing due to corrupted fields, however, aslong as number is roughly close it is fine
    @Test
    @DisplayName("Testing Employee Store Initialisation")
    public void testingEmployeeStoreInitialisation(){
        EmployeeStore.initializeEmployeeStore(1000);
        Assertions.assertEquals(1000, EmployeeStore.getEmployeeStore().size());
    }
}
