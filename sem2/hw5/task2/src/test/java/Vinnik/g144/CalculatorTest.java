package Vinnik.g144;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculate() {
        int a = 8;
        int b = 4;
        String plus = "+";
        String minus = "-";
        String division = "/";
        String multiplication = "*";
        assertEquals((double) 12, Calculator.calculate(a, b, plus));
        assertEquals((double) 4, Calculator.calculate(a, b, minus));
        assertEquals((double) 2, Calculator.calculate(a, b, division));
        assertEquals((double) 32, Calculator.calculate(a, b, multiplication));
    }
}