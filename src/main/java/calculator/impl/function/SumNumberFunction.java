package calculator.impl.function;

public class SumNumberFunction implements Function {

    @Override
    public double evaluate(double firstOperand, double secondOperand) {
        return firstOperand+secondOperand;
    }
}
