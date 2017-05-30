package calculator.impl;

import calculator.Calculator;
import calculator.EvaluationException;
import calculator.impl.lexeme.Lexeme;
import calculator.impl.parser.ExpressionParser;
import calculator.impl.parser.ParserFactory;

import java.util.logging.Logger;

public class FsmCalculator implements Calculator {

    //private static final Logger LOG = Logger.getLogger(FsmCalculator.class.getName());

    private final TransitionMatrix matrix = new TransitionMatrix();

    private final ParserFactory parserFactory = new ParserFactory();

    @Override
    public double evaluate(String expression) throws EvaluationException {

        //final ExpressionReader reader = new ExpressionReader(expression);

        final EvaluationVisitor visitor = new EvaluationVisitor(new ExpressionReader(expression));

        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression is null or empty.");
        }

        //LOG.info("expression = " + expression);

        State state = State.START;

        //LOG.info("Start state = " + state);

        while (state != State.FINISH) {

            state = moveForward(state, visitor);

            if (state == null) {
                throw new EvaluationException("Invalid expression format. [error position: " + visitor.getReader().getParsePosition() + "]", visitor.getReader().getParsePosition());
            }
            //LOG.info("Move to state = " + state);
        }

        return visitor.getResult();
    }

    private State moveForward(State currentState, EvaluationVisitor visitor) throws EvaluationException {

        for (State possibleState : matrix.getPossibleTransitions(currentState)) {

            final ExpressionParser parser = parserFactory.getParser(possibleState);
            final Lexeme lexeme = parser.parse(visitor.getReader());

            if (lexeme != null) {

                lexeme.acceptVisitor(visitor);
                return possibleState;
            }
        }

        return null;
    }


}
