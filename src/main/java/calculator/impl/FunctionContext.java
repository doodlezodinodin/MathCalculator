package calculator.impl;

import calculator.impl.function.Function;
import calculator.impl.operator.BinaryOperator;

import java.util.ArrayDeque;
import java.util.Deque;

public class FunctionContext {

    private Deque<Double> operands = new ArrayDeque<>();

    private final Deque<Function> functions = new ArrayDeque<>();

    private final Deque<BinaryOperator> operators = new ArrayDeque<>();

    private final Deque<Integer> brackets = new ArrayDeque<>();

    public Deque<Double> getOperands() {
        return operands;
    }

    public Deque<Function> getFunctions() {
        return functions;
    }

    public Deque<BinaryOperator> getOperators() {
        return operators;
    }

    public Deque<Integer> getBrackets() {
        return brackets;
    }
}
