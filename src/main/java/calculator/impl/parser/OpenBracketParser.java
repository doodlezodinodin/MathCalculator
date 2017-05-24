package calculator.impl.parser;


import calculator.impl.ExpressionReader;
import calculator.impl.lexeme.OpenBracketLexeme;
import calculator.impl.lexeme.Lexeme;
import calculator.impl.operator.bracket.BracketFactory;

public class OpenBracketParser implements ExpressionParser {

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

                final String bracket = factory.getBracket(repression);
                return new OpenBracketLexeme(bracket);
            }
        }

        return null;
    }
}
