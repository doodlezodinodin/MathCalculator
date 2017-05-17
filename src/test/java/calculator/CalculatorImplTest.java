package calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CalculatorImplTest {

    private Calculator calculator = new CalculatorImpl();

    @Before
    public void setCalculator() {
        calculator = new CalculatorImpl();
    }

    @Test
    public void testCheckEmptyExpression() {
        try {
            calculator.calculation(null);
            Assert.fail();
        } catch (Exception e) {

        }
    }

}