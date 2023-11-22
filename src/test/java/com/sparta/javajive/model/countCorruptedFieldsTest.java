package com.sparta.javajive.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class countCorruptedFieldsTest {
    CorruptedEmployeeChecker checker = new CorruptedEmployeeChecker();
    String[] thisGuy = {"155554419","Mr.","Bob","J","Thatcher","NULL","bobthatcher.com","151212","5151211","-1000"};
    @Test
    public void corruptedDatesTest(){
//        Assertions.assertEquals(2, CurruptedEmployeeChecker.checkDatesCorrupted(thisGuy1));
        Assertions.assertEquals(2, checker.checkCorruptedDates(thisGuy));
    }

    @Test
    public void corruptedEmailTest(){
//        Assertions.assertEquals(1, CurruptedEmployeeChecker.checkCorruptedEmail(thisGuy1));
        Assertions.assertEquals(1, checker.checkCorruptedEmail(thisGuy));
    }

    @Test
    public void corruptedGenderTest(){
//        Assertions.assertEquals(1, CurruptedEmployeeChecker.checkCorrputedGender(thisGuy1));
        Assertions.assertEquals(1, checker.checkCorrputedGender(thisGuy));
    }

    @Test
    public void corruptedIdTest(){
//        Assertions.assertEquals(1, CurruptedEmployeeChecker.checkCorruptedId(thisGuy1));
        Assertions.assertEquals(1, checker.checkCorruptedId(thisGuy));
    }

    @Test
    public void corruptedSalaryTest(){
//        Assertions.assertEquals(1, CurruptedEmployeeChecker.checkCorruptedSalary(thisGuy1));
        Assertions.assertEquals(1, checker.checkCorruptedSalary(thisGuy));
    }

    @Test
    public void totalTest(){
//        Assertions.assertEquals(6, CurruptedEmployeeChecker.countCorruptedFields(thisGuy1));
        Assertions.assertEquals(6, checker.countCorruptedFields(thisGuy));
    }
}
