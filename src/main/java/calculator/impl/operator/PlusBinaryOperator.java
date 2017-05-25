package calculator.impl.operator;

public class PlusBinaryOperator implements BinaryOperator {

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }
}
