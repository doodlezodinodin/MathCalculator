package calculator;

import calculator.exceptionCalculator.ExceptionCalculator;

public class CalculatorImpl implements Calculator {
    public double calculation(String expression) throws ExceptionCalculator{
        if (expression == null) throw new ExceptionCalculator("Error: empty string");

        return 0;
    }
}
