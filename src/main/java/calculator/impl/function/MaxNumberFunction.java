package calculator.impl.function;

public class MaxNumberFunction implements Function {

    @Override
    public double evaluate(double firstOperand, double secondOperand) {

        if (firstOperand > secondOperand) return firstOperand;
        else return secondOperand;
    }
}
