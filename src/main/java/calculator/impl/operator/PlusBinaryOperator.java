package calculator.impl.operator;

public class PlusBinaryOperator extends AbstractBinaryOperator {

    public PlusBinaryOperator(Priority priority) {
        super(priority);
    }

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }
}
