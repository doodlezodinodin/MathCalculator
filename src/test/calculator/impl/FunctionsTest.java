package calculator.impl;

import calculator.Calculator;
import calculator.EvaluationException;
import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionsTest {

    private final Calculator calculator = new FsmCalculator();

    //test exception
    @Test
    public void testEvaluateEmptyFunction() throws EvaluationException {
        try {
            calculator.evaluate("sum()");
            fail();
        } catch (EvaluationException e) {
            assertEquals("Wrong error position.", 4, e.getErrorPosition());
        }
    }

    @Test
    public void testNoBracketsAfterFunction() throws EvaluationException {
        try {
            calculator.evaluate("sum");
            fail();
        } catch (EvaluationException e) {
            assertEquals("Wrong error position.", 3, e.getErrorPosition());
        }
    }

    @Test
    public void testNoCloseBracketAfterFunction() throws EvaluationException {
        try {
            calculator.evaluate("sum(2,2");
            fail();
        } catch (EvaluationException e) {
            assertEquals("Wrong error position.", 7, e.getErrorPosition());
        }
    }

    @Test
    public void testNoOpenBracketAfterFunction() throws EvaluationException {
        try {
            calculator.evaluate("sum2,2)");
            fail();
        } catch (EvaluationException e) {
            assertEquals("Wrong error position.", 3, e.getErrorPosition());
        }
    }

    @Test
    public void testEvaluateCorrectnessOfFunction() throws EvaluationException {
        try {
            calculator.evaluate("sum(5,,)");
            fail();
        } catch (EvaluationException e) {
            assertEquals("Wrong error position.", 6, e.getErrorPosition());
        }
    }

    //test function min
    @Test
    public void testEvaluationFunctionMinDoublePositiveNumber() throws EvaluationException {
        double result = calculator.evaluate("min(1.5, 5.125, 0.75)");
        assertEquals(result, 0.75, 0);
    }

    @Test
    public void testEvaluationFunctionMinDoubleNegativeNumber() throws EvaluationException {
        double result = calculator.evaluate("min(-1.5, -5.123, 0.75)");
        assertEquals(result, -5.123, 0);
    }

    @Test
    public void testEvaluationFunctionMinIntegerPositiveNumber() throws EvaluationException {
        double result = calculator.evaluate("min(25, 15, 17)");
        assertEquals(result, 15, 0);
    }

    @Test
    public void testEvaluationFunctionMinIntegerNegativeNumber() throws EvaluationException {
        double result = calculator.evaluate("min(-25, -3, 5, -17)");
        assertEquals(result, -25, 0);
    }

    //test function max
    @Test
    public void testEvaluationFunctionMaxDoublePositiveNumber() throws EvaluationException {
        double result = calculator.evaluate("max(1.5, 5.125, 0.75)");
        assertEquals(result, 5.125, 0);
    }

    @Test
    public void testEvaluationFunctionMaxDoubleNegativeNumber() throws EvaluationException {
        double result = calculator.evaluate("max(-1.5, -5.123, -0.75)");
        assertEquals(result, -0.75, 0);
    }

    @Test
    public void testEvaluationFunctionMaxIntegerPositiveNumber() throws EvaluationException {
        double result = calculator.evaluate("max(25, 15, 17)");
        assertEquals(result, 25, 0);
    }

    @Test
    public void testEvaluationFunctionMaxIntegerNegativeNumber() throws EvaluationException {
        double result = calculator.evaluate("max(-25, -3, -1, -17)");
        assertEquals(result, -1, 0);
    }

    //test function sum
    @Test
    public void testEvaluationFunctionSumDoublePositiveNumber() throws EvaluationException {
        double result = calculator.evaluate("sum(1.5, 3.25, 5.75)");
        assertEquals(result, 10.5, 0);
    }

    @Test
    public void testEvaluationFunctionSumDoubleNegativeNumber() throws EvaluationException {
        double result = calculator.evaluate("sum(-5.25, -1.75, 7)");
        assertEquals(result, 0, 0);
    }

    @Test
    public void testEvaluationFunctionSumIntegerPositiveNumber() throws EvaluationException {
        double result = calculator.evaluate("sum(25, 15, 60)");
        assertEquals(result, 100, 0);
    }

    @Test
    public void testEvaluationFunctionSumIntegerNegativeNumber() throws EvaluationException {
        double result = calculator.evaluate("sum(-25, -3, -1, 28)");
        assertEquals(result, -1, 0);
    }

    //test nesting
    @Test
    public void testFunctionMinNestedInFunctionMax() throws EvaluationException {
        double result = calculator.evaluate("max(20, 10, min(100, min(150, 50)), 15)");
        assertEquals(result, 50, 0);
    }

    @Test
    public void testFunctionNestedInFunction() throws EvaluationException {
        double result = calculator.evaluate("sum(min(100, 200), max(250, sum(100, 100, max(50, 100), 100, 100)), sum(100, 100))");
        assertEquals(result, 800, 0);
    }
}