package calculator.impl.operator;

public class PowerBinaryOperator extends AbstractBinaryOperator {

    public PowerBinaryOperator(Priority priority) {
        super(priority);
    }

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return Math.pow(leftOperand, rightOperand);
    }
}
