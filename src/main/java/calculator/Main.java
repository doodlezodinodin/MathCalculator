package calculator;

import calculator.impl.FsmCalculator;

public class Main {
    public static void main(String[] args) throws EvaluationException {
        Calculator calculator = new FsmCalculator();
        calculator.evaluate("5");
    }
}
