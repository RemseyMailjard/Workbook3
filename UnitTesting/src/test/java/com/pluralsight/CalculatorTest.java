package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add_shouldReturnSumOfTwoNumbers() {
        // arrange
        int firstNumber = 2;
        int secondNumber = 4;
        int expectedResult = 6;
        Calculator cn = new Calculator();
        // act
         int acctualFunctionResult = cn.add(firstNumber,secondNumber);
        // assert
     assertEquals(expectedResult, acctualFunctionResult, "Calculator should correctly add two numbers");

    }

    void substract_shouldReturnTheSubtractionOfTwoNumbers() {
        //arrange

        //act

        //assert
        assertEquals(expectedResult, actualResult);

    }



}