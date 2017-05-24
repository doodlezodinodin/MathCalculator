package calculator.impl.operator.binaryOperator;

public class MulBinaryOperator implements BinaryOperator {

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return leftOperand * rightOperand;
    }
}
