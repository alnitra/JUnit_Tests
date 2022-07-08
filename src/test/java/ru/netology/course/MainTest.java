package ru.netology.course;


import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class MainTest
{
    /**
     * Rigorous Test :-)
     */

    @BeforeAll
    public static void  beforeAll(){
        System.out.println("Before all test:");
    }

    @Test
    public void testSum() {
        IntsCalculator intsCalc = new IntsCalculator();
        int a = 1, b = 11, expectedResult = 12;
        int result = intsCalc.sum(a,b);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testBothClassesCoincidence() {
        IntsCalculator intsCalc = new IntsCalculator();
        Calculator calc = new Calculator();
        int a = 1, b = 11;
        int intsResult = intsCalc.sum(a,b);
        int result = (int) calc.newFormula()
                        .addOperand(a)
                        .addOperand(b)
                        .calculate(Calculator.Operation.SUM)
                        .result();

        Assertions.assertEquals(intsResult, result);
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    public void testParamMethodSource(int a, int b, int expectedResult){
        IntsCalculator intsCalc = new IntsCalculator();
        int result = intsCalc.mult(a,b);

        Assertions.assertEquals(expectedResult, result);
    }

    static Stream<Arguments> methodSource() {

        return Stream.of(
                Arguments.of(1,3,3),
                Arguments.of(5,7,35),
                Arguments.of(8,9,73)
        );
    }
}
