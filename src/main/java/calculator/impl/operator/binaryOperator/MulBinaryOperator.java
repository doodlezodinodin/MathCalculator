package calculator.impl.operator.binaryOperator;

import calculator.impl.operator.BinaryOperator;

public class MulBinaryOperator implements BinaryOperator {

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return leftOperand * rightOperand;
    }
}