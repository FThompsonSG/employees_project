package com.sparta.javajive.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class countCorruptedFieldsTest {
    CorruptedEmployeeChecker checker = new CorruptedEmployeeChecker();
    String[] thisGuyString = {"155554419","Mr.","Bob","J","Thatcher","NULL","bobthatcher.com","151212","5151211","-1000"};
    Employee thisGuyEmployeeObject = new Employee(155554419,"Mr.","Bob",'J',"Thatcher","NULL","bobthatcher.com","151212","5151211",-1000);
    @Test
    public void corruptedDatesTest(){
        Assertions.assertEquals(2, checker.checkCorruptedDates(thisGuyEmployeeObject));
    }

    @Test
    public void corruptedEmailTest(){
        Assertions.assertEquals(1, checker.checkCorruptedEmail(thisGuyEmployeeObject));
    }

    @Test
    public void corruptedGenderTest(){
        Assertions.assertEquals(1, checker.checkCorruptedGender(thisGuyEmployeeObject));
    }

    @Test
    public void corruptedIdTest(){
        Assertions.assertEquals(1, checker.checkCorruptedId(thisGuyEmployeeObject));
    }

    @Test
    public void corruptedSalaryTest(){
        Assertions.assertEquals(1, checker.checkCorruptedSalary(thisGuyEmployeeObject));
    }

    @Test
    public void totalTest(){
        Assertions.assertEquals(6, checker.countCorruptedFields(thisGuyEmployeeObject));
    }
}
