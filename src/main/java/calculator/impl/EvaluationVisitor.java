package calculator.impl;

import calculator.impl.lexeme.BinaryOperatorLexeme;
import calculator.impl.lexeme.FinishLexeme;
import calculator.impl.lexeme.LexemeVisitor;
import calculator.impl.lexeme.NumberLexeme;
import calculator.impl.operator.*;

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
    public void visit(BinaryOperatorLexeme lexeme) {
        final BinaryOperator operator = lexeme.getOperator();

        // todo: support priorities

        if (operators.isEmpty()) operators.push(operator);
        else if (priorityOperator(operator) < priorityOperator(operators.getFirst())) {
            evaluateTopOperator();
            operators.push(operator);
        } else operators.push(operator);


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

    public double getResult() {
        return operands.pop();
    }

    private int priorityOperator(BinaryOperator operator) {
        if (operator instanceof MulBinaryOperator || operator instanceof DivBinaryOperator) {
            return 1;
        } else if (operator instanceof PlusBinaryOperator || operator instanceof MinusBinaryOperator) {
            return 0;
        } else return -1;
    }
}
