package calculator.impl.parser;


import calculator.impl.ExpressionReader;
import calculator.impl.lexeme.BracketLexeme;
import calculator.impl.lexeme.Lexeme;
import calculator.impl.operator.BinaryOperator;
import calculator.impl.operator.bracket.BracketFactory;

public class BracketParser implements ExpressionParser {

    private final BracketFactory factory = new BracketFactory();

    @Override
    public Lexeme parse(ExpressionReader reader) {
        if (reader.endOfExpression()) {
            return null;
        }

        final String remainingExpression = reader.getRemainingExpression();

        for (String repression : factory.getRepresentations()) {
            if (remainingExpression.startsWith(repression)) {
                reader.moveParsePosition(repression.length());

                final BinaryOperator bracket = factory.getBracket(repression);
                return new BracketLexeme(bracket);
            }
        }

        return null;
    }
}
