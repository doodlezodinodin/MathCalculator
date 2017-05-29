package calculator.impl;

import calculator.Calculator;
import calculator.EvaluationException;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class FsmCalculatorTest {

    private Calculator calculator = new FsmCalculator();

    @Test
    public void testEvaluatePositiveIntegerNumber() throws EvaluationException {
        Double result = calculator.evaluate("5");
        assertEquals(5, result, 0);
    }


    @Test
    public void testEvaluateNegativeIntegerNumber() throws EvaluationException {
        final Double result = calculator.evaluate("-78");
        assertEquals(-78, result, 0);
    }

    @Test
    public void testEvaluatePositiveDoubleNumber() throws EvaluationException {
        final Double result = calculator.evaluate("4.123");
        assertEquals(4.123, result, 0);
    }

    @Test
    public void testEvaluateNegativeDoubleNumber() throws EvaluationException {
        final Double result = calculator.evaluate("-45.456");
        assertEquals(-45.456, result, 0);
    }

    @Test
    public void testEvaluateMinusBinaryOperator() throws EvaluationException {
        Double result = calculator.evaluate("56-30");
        assertEquals(26, result, 0);
    }

    @Test
    public void testEvaluatePriorityBinaryOperation() throws EvaluationException {
        Double result = calculator.evaluate("2*2+2");
        assertEquals(6, result, 0);
    }

    @Test
    public void testEvaluateConstant() throws EvaluationException {
        Double result = calculator.evaluate("2+Pi");
        assertEquals(5.14, result, 0.5);
    }

    @Test
    public void testEvaluatePowerBinaryOperation() throws EvaluationException {
        Double result = calculator.evaluate("2+3+((2^2^2*3+2)+5^2)+2^2/4");
        assertEquals(81, result, 0);
    }

    @Test
    public void testDoSanityCheck() throws EvaluationException {
        Double result = calculator.evaluate("2+(2+2)*2");
        assertEquals(10, result, 1);
    }
}