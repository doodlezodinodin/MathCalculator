package calculator.impl.operator;

public class MulBinaryOperator implements BinaryOperator {

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return leftOperand * rightOperand;
    }
}
