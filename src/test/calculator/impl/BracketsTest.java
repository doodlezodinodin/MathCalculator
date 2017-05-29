package calculator.impl;

import calculator.Calculator;
import calculator.EvaluationException;
import org.junit.Test;

import static org.junit.Assert.*;

public class BracketsTest {

    private final Calculator calculator = new FsmCalculator();

    @Test
    public void testEvaluateBrackets() throws EvaluationException {
        Double result = calculator.evaluate("(2+2)*2");
        assertEquals(8, result, 0);
    }

    @Test
    public void testEvaluateNestedBrackets() throws EvaluationException {
        Double result = calculator.evaluate("2*((5+5)/(3-1))");
        assertEquals(10, result, 0);
    }

    @Test
    public void testDoSanityCheck() throws EvaluationException {
        Double result = calculator.evaluate("(2*((10*(7+(1.5+1.5)))+(25-5)/10))+Pi");
        assertEquals(207.14, result, 1);
    }

    @Test
    public void testEvaluateEmptyBrackets() throws EvaluationException {
        try {
            calculator.evaluate("()");
            fail();
        } catch (EvaluationException e) {
            assertEquals("Wrong error position.", 2, e.getErrorPosition());
        }
    }

    @Test
    public void testBracketWasNotOpen() throws EvaluationException {
        try {
            calculator.evaluate("2+(2+2)+2)");
            fail("Evaluation exception was not thrown");
        } catch (EvaluationException e) {
            assertEquals("Wrong error position.", 10, e.getErrorPosition());
        }
    }

    @Test
    public void testBracketWasNotClose() throws EvaluationException {
        try {
            calculator.evaluate("(2+(2+(2+2))");
            fail();
        } catch (EvaluationException e) {
            assertEquals("Wrong error position.", 12, e.getErrorPosition());
        }
    }

    @Test
    public void testNumberBeforeOpenBracket() throws EvaluationException {
        try {
            calculator.evaluate("2+2(2+2)");
            fail();
        } catch (EvaluationException e) {
            assertEquals("Wrong error position.", 4, e.getErrorPosition());
        }
    }

    @Test
    public void testNumberAfterCloseBracket() throws EvaluationException {
        try {
            calculator.evaluate("(2+2)2+2");
            fail();
        } catch (EvaluationException e) {
            assertEquals("Wrong error position.", 5, e.getErrorPosition());
        }
    }
}