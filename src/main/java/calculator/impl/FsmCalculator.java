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

        final EvaluationVisitor visitor = new EvaluationVisitor();

        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression is null or empty.");
        }

        //LOG.info("expression = " + expression);

        final ExpressionReader reader = new ExpressionReader(expression);

        visitor.setReader(reader);

        State state = State.START;

        //LOG.info("Start state = " + state);

        while (state != State.FINISH) {

            state = moveForward(reader, state, visitor);

            if (state == null) {
                throw new EvaluationException("Invalid expression format.", reader.getParsePosition());
            }

            //LOG.info("Move to state = " + state);
        }

        if (state == State.FINISH && reader.getRemainingExpression().length() > 0)
            throw new EvaluationException("Invalid character after open bracket. [error position: " + reader.getParsePosition() + "]" , reader.getParsePosition());

        return visitor.getResult();
    }

    private State moveForward(ExpressionReader reader, State currentState, EvaluationVisitor visitor) throws EvaluationException{

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
