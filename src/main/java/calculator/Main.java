package calculator;

import calculator.impl.FsmCalculator;

public class Main {
    public static void main(String[] args) throws EvaluationException {
        Calculator calculator = new FsmCalculator();
        System.out.println(calculator.evaluate("(2*2+2-6+5-5+25/5-5)"));
    }
}
