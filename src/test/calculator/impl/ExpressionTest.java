package calculator.impl;

import calculator.Calculator;
import calculator.EvaluationException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionTest {
    private static Calculator calculator = new FsmCalculator();

    //test operands
    @Test
    public void testEvaluatePositiveDoubleNumber() throws EvaluationException {
        Double result = calculator.evaluate("2.123");
        assertEquals(2.123, result, 0);
    }

    @Test
    public void testEvaluateNegativeDoubleNumber() throws EvaluationException {
        Double result = calculator.evaluate("-2.123");
        assertEquals(-2.123, result, 0);
    }

    @Test
    public void testEvaluatePositiveIntegerNumber() throws EvaluationException {
        Double result = calculator.evaluate("7");
        assertEquals(7, result, 0);
    }

    @Test
    public void testEvaluateNegativeIntegerNumber() throws EvaluationException {
        Double result = calculator.evaluate("-7");
        assertEquals(-7, result, 0);
    }

    //test operators
    @Test
    public void testEvaluatePlusBinaryOperator() throws EvaluationException {
        Double result = calculator.evaluate("2+2");
        assertEquals(4, result, 0);
    }

    @Test
    public void testEvaluateMinusBinaryOperator() throws EvaluationException {
        Double result = calculator.evaluate("2-2");
        assertEquals(0, result, 0);
    }

    @Test
    public void testEvaluateMultiplyBinaryOperator() throws EvaluationException {
        Double result = calculator.evaluate("2*2");
        assertEquals(4, result, 0);
    }

    @Test
    public void testEvaluateDivideBinaryOperator() throws EvaluationException {
        Double result = calculator.evaluate("2/2");
        assertEquals(1, result, 0);
    }

    @Test
    public void testEvaluatePriorityBinaryOperator() throws EvaluationException {
        Double result = calculator.evaluate("2+2^2-3*4/2");
        assertEquals(0, result, 0);
    }

    @Test
    public void testEvaluateConstants() throws EvaluationException {
        Double result = calculator.evaluate("2+Pi+e");
        assertEquals(7.85, result, 0.05);
    }

    @Test
    public void testDoSanityCheck() throws EvaluationException {
        Double result = calculator.evaluate("2*((2+2)/(6-4))+sum(min(1,2),max(2,4))+Pi");
        assertEquals(12.14, result, 0.05);
    }
}