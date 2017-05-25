package calculator.impl.operator;

public interface BinaryOperator {

    enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    Priority getPriority();

    double evaluate(double leftOperand, double rightOperand);
}
