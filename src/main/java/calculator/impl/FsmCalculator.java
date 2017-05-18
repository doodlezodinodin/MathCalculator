package calculator.impl;

import calculator.Calculator;
import calculator.EvaluationException;
import calculator.impl.lexeme.Lexeme;
import calculator.impl.parser.ExpressionParser;
import calculator.impl.parser.ParserFactory;

public class FsmCalculator implements Calculator {

    private final TransitionMatrix matrix = new TransitionMatrix();

    private final ParserFactory parserFactory = new ParserFactory();

    private final EvaluationVisitor visitor = new EvaluationVisitor();


    @Override
    public double evaluate(String expression) throws EvaluationException {

        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression is null or empty.");
        }

        final ExpressionReader reader = new ExpressionReader(expression);

        State state = State.START;

        while (state != State.FINISH) {

            state = moveForward(reader, state);

            if (state == null) {
                throw new EvaluationException("Invalid expression format.", reader.getParsePosition());
            }
        }

        return visitor.getResult();
    }

    private State moveForward(ExpressionReader reader, State currentState) {

        for (State possibleState : matrix.getPossibleTransitions(currentState)) {

            final ExpressionParser parser = parserFactory.getParser(possibleState);
            final Lexeme lexeme = parser.parse(reader);

            if (lexeme != null) {

                lexeme.acceptVisitor(visitor);
                return possibleState;
            }
        }

        return null;
    }


}
