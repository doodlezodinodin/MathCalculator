package calculator.impl.operator;

public class MinusBinaryOperator extends AbstractBinaryOperator {

    public MinusBinaryOperator(Priority priority) {
        super(priority);
    }

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return leftOperand - rightOperand;
    }
}
