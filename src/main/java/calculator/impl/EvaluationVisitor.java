package calculator.impl;

import calculator.impl.lexeme.*;
import calculator.impl.lexeme.bracketLexeme.CloseBracketLexeme;
import calculator.impl.lexeme.bracketLexeme.OpenBracketLexeme;
import calculator.impl.lexeme.mathMethodLexeme.MathMethodLexeme;
import calculator.impl.operator.binaryOperator.BinaryOperator;
import calculator.impl.operator.binaryOperator.DivBinaryOperator;
import calculator.impl.operator.binaryOperator.MinusBinaryOperator;
import calculator.impl.operator.binaryOperator.MulBinaryOperator;
import calculator.impl.operator.binaryOperator.PlusBinaryOperator;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluationVisitor implements LexemeVisitor {

    private final Deque<Double> operands = new ArrayDeque<>();

    private final Deque<BinaryOperator> operators = new ArrayDeque<>();

    private int priority = 0;

    @Override
    public void visit(NumberLexeme lexeme) {
        operands.push(lexeme.getValue());
    }

    @Override
    public void visit(BinaryOperatorLexeme lexeme) {
        final BinaryOperator operator = lexeme.getOperator();

        // todo: support priorities
        evaluatePriority(operator);
    }

    @Override
    public void visit(FinishLexeme lexeme) {
        while (!operators.isEmpty()) {
            evaluateTopOperator();
        }
    }

    @Override
    public void visit(OpenBracketLexeme lexeme) {
        priority = 3;
    }

    @Override
    public void visit(CloseBracketLexeme lexeme) {
        evaluateTopOperator();

        if (!operators.isEmpty()) {
            priority = findPriority(operators.getFirst());
        } else priority = 0;
    }

    @Override
    public void visit(ConstantLexeme lexeme) {
        operands.push(lexeme.getValue());
    }

    @Override
    public void visit(MathMethodLexeme lexeme) {

    }

    private void evaluateTopOperator() {

        final BinaryOperator operator = operators.pop();

        final Double rightOperand = operands.pop();
        final Double leftOperand = operands.pop();

        final double result = operator.evaluate(leftOperand, rightOperand);
        operands.push(result);
    }

    public double getResult() {
        return operands.pop();
    }

    private int findPriority(BinaryOperator operator) {
        if (operator instanceof PlusBinaryOperator || operator instanceof MinusBinaryOperator) {
            return 2;
        } else if (operator instanceof MulBinaryOperator || operator instanceof DivBinaryOperator) {
            return 1;
        } else return -2;
    }

    private void evaluatePriority(BinaryOperator operator) {

        if (operators.isEmpty()) {
            operators.push(operator);
            priority = findPriority(operator);
        } else if (findPriority(operator) < priority) {
            operators.push(operator);
            priority = findPriority(operator);
        } else if (findPriority(operator) > priority) {
            evaluateTopOperator();
            priority = findPriority(operator);
            operators.push(operator);
        } else if (findPriority(operator) == priority) {
            evaluateTopOperator();
            operators.push(operator);
        }
    }
}
