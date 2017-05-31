package calculator.impl;

import calculator.EvaluationException;
import calculator.impl.function.Function;
import calculator.impl.lexeme.*;
import calculator.impl.lexeme.CloseBracketLexeme;
import calculator.impl.lexeme.OpenBracketLexeme;
import calculator.impl.operator.BinaryOperator;

import java.util.*;

public class EvaluationVisitor implements LexemeVisitor {

    private final Deque<Double> operands = new ArrayDeque<>();
    private final Deque<Function> functions = new ArrayDeque<>();
    private final Deque<BinaryOperator> operators = new ArrayDeque<>();
    private final Deque<Integer> brackets = new ArrayDeque<>();

    private final Deque<FunctionContext> functionContexts = new ArrayDeque<>();

    private final ExpressionReader reader;

    public EvaluationVisitor(ExpressionReader reader) {
        this.reader = reader;
    }

    public ExpressionReader getReader() {
        return reader;
    }

    @Override
    public void visit(NumberLexeme lexeme) {
        operands.push(lexeme.getValue());
    }

    @Override
    public void visit(ConstantLexeme lexeme) {
        operands.push(lexeme.getValue());
    }

    @Override
    public void visit(FunctionLexeme lexeme) {
        functions.push(lexeme.getFunction());
    }

    @Override
    public void visit(BinaryOperatorLexeme lexeme) {
        final BinaryOperator operator = lexeme.getOperator();

        final int minOperatorsSize = brackets.isEmpty() ? 0 : brackets.peek();

        while (operators.size() > minOperatorsSize &&
                operator.getPriority().compareTo(operators.peek().getPriority()) < 1) {
            evaluateTopOperator();
        }

        operators.push(operator);
    }

    @Override
    public void visit(OpenBracketLexeme lexeme) {
        brackets.push(operators.size());
    }

    @Override
    public void visit(CloseBracketLexeme lexeme) throws EvaluationException {
        if (brackets.isEmpty()) {
            throw new EvaluationException("Invalid number of parentheses. [error position: " + reader.getParsePosition() + "]", reader.getParsePosition());
        }

        final int requiredSize = brackets.pop();

        while (operators.size() > requiredSize) {
            evaluateTopOperator();
        }
    }

    @Override
    public void visit(CommaLexeme lexeme) {

    }

    @Override
    public void visit(FinishLexeme lexeme) throws EvaluationException {
        if (!brackets.isEmpty()) {
            throw new EvaluationException("Invalid number of parentheses. [error position: " + reader.getParsePosition() + "]", reader.getParsePosition());
        }

        while (!operators.isEmpty()) {
            evaluateTopOperator();
        }
    }

    private void evaluateTopOperator() {

        final BinaryOperator operator = operators.pop();

        final Double rightOperand = operands.pop();
        final Double leftOperand = operands.pop();

        final double result = operator.evaluate(leftOperand, rightOperand);
        operands.push(result);
    }

    /*private void evaluateTopFunction() {

        final Function function = functions.pop();

        double[] numbers = new double[operands.size() - bracketsFunction.peek()];

        for (int i = 0; i < operands.size() - bracketsFunction.peek(); i++) {
            numbers[i] = operands.pop();
        }

        final double result = function.evaluate(numbers);
        operands.push(result);
    }*/

    public double getResult() {
        return operands.pop();
    }
}
