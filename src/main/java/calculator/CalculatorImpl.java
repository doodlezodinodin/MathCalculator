package calculator;

import calculator.exceptionCalculator.exceptionCalculator.ExceptionCalculator;

public class CalculatorImpl implements Calculator {

    enum CalcState {
        NUMBER,
        OPERATION,
    }

    public double calculation(String expression) throws ExceptionCalculator{
        if (expression == null) throw new ExceptionCalculator("Error: empty string");

        return 0;
    }
}
