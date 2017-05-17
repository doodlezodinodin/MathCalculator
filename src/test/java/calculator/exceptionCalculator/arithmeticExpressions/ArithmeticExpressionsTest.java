package calculator.exceptionCalculator.arithmeticExpressions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticExpressionsTest {

    private ArithmeticExpressions arithmeticExpressions;

    @Test
    public void testAddition() {
        arithmeticExpressions = new Addition();
        Double result = arithmeticExpressions.count(15, 15);
        assertEquals(30, result, 0);
    }

    @Test
    public void testSubtraction() {
        arithmeticExpressions = new Subtraction();
        Double result = arithmeticExpressions.count(15, 10);
        assertEquals(5, result, 0);
    }

    @Test
    public void testMultiplication() {
        arithmeticExpressions = new Multiplication();
        Double result = arithmeticExpressions.count(5, 5);
        assertEquals(25, result, 0);
    }

    @Test
    public void testDivision() {
        arithmeticExpressions = new Division();
        Double result = arithmeticExpressions.count(5, 5);
        assertEquals(1, result, 0);
    }
}