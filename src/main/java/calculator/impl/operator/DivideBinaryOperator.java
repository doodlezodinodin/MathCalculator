package calculator.impl.operator;

public class DivideBinaryOperator extends AbstractBinaryOperator {


    public DivideBinaryOperator(Priority priority) {
        super(priority);
    }

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return leftOperand / rightOperand;
    }
}
