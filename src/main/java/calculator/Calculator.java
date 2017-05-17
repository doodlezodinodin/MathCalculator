package calculator;

import calculator.exceptionCalculator.exceptionCalculator.ExceptionCalculator;

public interface Calculator {
    double calculation(String expression) throws ExceptionCalculator;
}
