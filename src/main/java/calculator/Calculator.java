package calculator;

import calculator.exceptionCalculator.ExceptionCalculator;

public interface Calculator {
    double calculation(String expression) throws ExceptionCalculator;
}
