package calculator.impl;

import calculator.Calculator;
import calculator.EvaluationException;
import org.testng.annotations.Test;

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

    @Test
    public void EvaluatePriority() throws EvaluationException {
        Double result = calculator.evaluate("2*2+2");
        assertEquals(6, result, 0);
    }

    @Test
    public void EvaluateBracket() throws EvaluationException {
        Double result = calculator.evaluate("(2+2*2+2)");
        assertEquals(8, result, 0);
    }

    @Test
    public void EvaluateExpression() throws EvaluationException {
        Double result = calculator.evaluate("(2+2)+(5*3)-7");
        assertEquals(12, result, 0);
    }

    @Test
    public void EvaluatePi() throws EvaluationException {
        Double result = calculator.evaluate("2+Pi");
        assertEquals(5.14, result, 0.5);
    }
}