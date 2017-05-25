package calculator.impl.parser;

import calculator.impl.ExpressionReader;
import calculator.impl.lexeme.Lexeme;
import calculator.impl.parser.ExpressionParser;

public abstract class AbstractBracketParser implements ExpressionParser {

    private final String[] brackets = {"(", ")"};

    @Override
    public Lexeme parse(ExpressionReader reader) {
        if (reader.endOfExpression()) {
            return null;
        }

        final String remainingExpression = reader.getRemainingExpression();


        for (int i = 0; i < brackets.length; i++) {
            if (remainingExpression.startsWith(brackets[i])) {
                reader.moveParsePosition(brackets[i].length());

                return createLexeme();
            }
        }
        return null;
    }

    abstract Lexeme createLexeme();
}
