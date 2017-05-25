package calculator.impl;

import calculator.impl.lexeme.*;
import calculator.impl.lexeme.CloseBracketLexeme;
import calculator.impl.lexeme.OpenBracketLexeme;
import calculator.impl.lexeme.mathMethodLexeme.MathMethodLexeme;
import calculator.impl.operator.BinaryOperator;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluationVisitor implements LexemeVisitor {

    private final Deque<Double> operands = new ArrayDeque<>();

    private final Deque<BinaryOperator> operators = new ArrayDeque<>();

    @Override
    public void visit(NumberLexeme lexeme) {
        operands.push(lexeme.getValue());
    }

    @Override
    public void visit(ConstantLexeme lexeme) {
        operands.push(lexeme.getValue());
    }

    @Override
    public void visit(BinaryOperatorLexeme lexeme) {
        final BinaryOperator operator = lexeme.getOperator();

        // todo: support priorities

    }

    @Override
    public void visit(FinishLexeme lexeme) {
        while (!operators.isEmpty()) {
            evaluateTopOperator();
        }
    }

    @Override
    public void visit(OpenBracketLexeme lexeme) {

    }

    @Override
    public void visit(CloseBracketLexeme lexeme) {

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
}
