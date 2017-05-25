package calculator;

import calculator.impl.FsmCalculator;


public class Main {
    public static void main(String[] args) throws EvaluationException {
        Calculator calculator = new FsmCalculator();
        System.out.println(calculator.evaluate("max(min(5,1),2)+2*2"));
    }
}
