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

    private ExpressionReader reader;

    public void setReader(ExpressionReader reader) {
        this.reader = reader;
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
        if (!functions.isEmpty()) brackets.push(operands.size());
        else brackets.push(operators.size());

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

        while (!functions.isEmpty() && functions.size() > functions.size() - 1 && operands.size() > requiredSize + 1) {
            evaluateTopBinaryFunction();
            if (operands.size() == requiredSize + 1) {
                functions.pop();
            }
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

    private void evaluateTopBinaryFunction() {
        final Function function = functions.peek();

        double firstOperand = operands.pop();
        double secondOperand = operands.pop();

        final double result = function.evaluate(firstOperand, secondOperand);
        operands.push(result);
    }

    public double getResult() {
        return operands.pop();
    }
}
