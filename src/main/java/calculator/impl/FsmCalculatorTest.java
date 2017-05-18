package calculator.impl;

import calculator.Calculator;
import calculator.EvaluationException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FsmCalculatorTest {

    private Calculator calculator = new FsmCalculator();

    @Test
    public void testEvaluateInputNumber() throws EvaluationException {
        Double result = calculator.evaluate("5");
        assertEquals(5, result, 0);
    }

    @Test
    public void testEvaluateMinusBinaryOperator() throws EvaluationException {
        Double result = calculator.evaluate("56-30");
        assertEquals(26, result, 0);
    }

}