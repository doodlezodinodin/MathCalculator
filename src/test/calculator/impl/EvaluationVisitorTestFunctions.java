package calculator.impl;

import calculator.Calculator;
import calculator.EvaluationException;
import org.junit.Test;

import static org.junit.Assert.*;

public class EvaluationVisitorTestFunctions {

    private final Calculator calculator = new FsmCalculator();

    @Test
    public void testEvaluationBinaryFunctionPositiveMinDoubleNumber() throws EvaluationException {
        double result = calculator.evaluate("min(5.0, 0, 1)");
        assertEquals(result, 0, 0);
    }

    @Test
    public void testEvaluationBinaryFunctionNegativeMinDoubleNumber() throws EvaluationException {
        double result = calculator.evaluate("min(-15, 2.5, -3, -27.123)");
        assertEquals(result, -27.123, 0);
    }

    @Test
    public void testEvaluationBinaryFunctionPositiveMaxDoubleNumber() throws EvaluationException {
        double result = calculator.evaluate("max(5.12, 0, 1)");
        assertEquals(result, 5.12, 0);
    }

    @Test
    public void testEvaluationBinaryFunctionNegativeMaxDoubleNumber() throws EvaluationException {
        double result = calculator.evaluate("max(-15, 2.1, -3, -27)");
        assertEquals(result, 2.1, 0);
    }

    @Test
    public void testEvaluationNestingBinaryFunctions() throws EvaluationException {
        double result = calculator.evaluate("max(min(100, min(min(20, min(min(5, 6), min(4, 2), min(min(2, 2),min(1, 0)))), min(30, 40)), 200), min(75, -15, 100))");
        assertEquals(result, 0, 0);
    }

    @Test
    public void testEvaluationBinaryFunctionSumDoubleNumbers() throws EvaluationException {
        double result = calculator.evaluate("sum(1, -2, 3.5)");
        assertEquals(result, 2.5, 0);
    }

    @Test
    public void testEvaluationNestingBinaryFunctionSumDoubleNumbers() throws EvaluationException {
        double result = calculator.evaluate("sum(1, sum(1, sum(sum(1, 2, 5), sum(-10, 5, 3), sum(sum(2, -10, 4.5), sum(sum(0.5, -5), sum(sum(Pi, -3.14), sum(1, 1)))))))");
        assertEquals(result, 2, 0);
    }

    @Test
    public void testEvaluationFunctionOfMinAsAFunctionSum() throws EvaluationException {
        double result = calculator.evaluate("sum(1, min(1, 2), max(min(5, 6), min(2, 9)))");
        assertEquals(result, 7, 0);
    }

    /*@Test
    public void testCorrectlyInputData() throws EvaluationException {
        try {
            calculator.evaluate("min(5)");
        } catch (EvaluationException e) {
            assertEquals("This binary function", 0, e.getErrorPosition());
        }
    }*/
}