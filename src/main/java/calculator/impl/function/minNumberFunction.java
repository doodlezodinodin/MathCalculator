package calculator.impl.function;

public class minNumberFunction implements Function {

    @Override
    public double evaluate(double leftOperands, double rightOperands) {

        if (leftOperands < rightOperands) return leftOperands;
        else return rightOperands;
    }
}
