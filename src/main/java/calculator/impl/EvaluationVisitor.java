package calculator.impl;

import calculator.impl.function.Function;
import calculator.impl.lexeme.*;
import calculator.impl.lexeme.CloseBracketLexeme;
import calculator.impl.lexeme.OpenBracketLexeme;
import calculator.impl.operator.BinaryOperator;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluationVisitor implements LexemeVisitor {

    private final Deque<Double> operands = new ArrayDeque<>();

    private final Deque<Function> functions = new ArrayDeque<>();

    private final Deque<BinaryOperator> operators = new ArrayDeque<>();

    private final Deque<Integer> brackets = new ArrayDeque<>();

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
        final Function function = lexeme.getFunction();

        functions.push(function);
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
        brackets.push(operands.size());
    }

    @Override
    public void visit(CloseBracketLexeme lexeme) {

        if (brackets.isEmpty()) {
            throw new RuntimeException("");
        }

        final int requiredSize = brackets.pop();
        while (operators.size() > requiredSize) {
            evaluateTopOperator();
        }
        evaluateTopFunction();
        functions.pop();
    }

    @Override
    public void visit(CommaLexeme lexeme) {
        if (operands.size() > brackets.peek()+1) evaluateTopFunction();
    }

    @Override
    public void visit(FinishLexeme lexeme) {
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

    private void evaluateTopFunction() {
        final Function function = functions.peek();

        final Double rightOperand = operands.pop();
        final Double leftOperand = operands.pop();

        final double result = function.evaluate(leftOperand, rightOperand);
        operands.push(result);
    }

    public double getResult() {
        return operands.pop();
    }
}
