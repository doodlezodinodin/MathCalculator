package calculator.impl.operator;

public abstract class AbstractBinaryOperator implements BinaryOperator {

    private final Priority priority;

    public AbstractBinaryOperator(Priority priority) {
        this.priority = priority;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }
}
