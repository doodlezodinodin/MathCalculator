package calculator.impl.operator;

public class MultiplyBinaryOperator extends AbstractBinaryOperator {

    public MultiplyBinaryOperator(Priority priority) {
        super(priority);
    }

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return leftOperand * rightOperand;
    }
}
