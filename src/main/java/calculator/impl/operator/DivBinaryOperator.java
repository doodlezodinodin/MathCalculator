package calculator.impl.operator;

public class DivBinaryOperator implements BinaryOperator {
    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return leftOperand / rightOperand;
    }
}
