package calculator.impl;

import calculator.Calculator;
import calculator.EvaluationException;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ExpressionTest {

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
    public void testEvaluatePlusBinaryOperator() throws EvaluationException {
        Double result = calculator.evaluate("56+30");
        assertEquals(86, result, 0);
    }

    @Test
    public void testEvaluateMinusBinaryOperator() throws EvaluationException {
        Double result = calculator.evaluate("56-30");
        assertEquals(26, result, 0);
    }

    @Test
    public void testEvaluateMultiplyBinaryOperator() throws EvaluationException {
        Double result = calculator.evaluate("10*10");
        assertEquals(100, result, 0);
    }

    @Test
    public void testEvaluateDivideBinaryOperator() throws EvaluationException {
        Double result = calculator.evaluate("10/10");
        assertEquals(1, result, 0);
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

    @Test
    public void testEvaluate() throws EvaluationException {
        try {
            calculator.evaluate("2++2");
            fail();
        } catch (EvaluationException e) {
            assertEquals("Wrong error position.", 2, e.getErrorPosition());
        }
    }
}