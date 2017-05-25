package calculator.impl.parser;

import calculator.impl.ExpressionReader;
import calculator.impl.lexeme.Lexeme;
import calculator.impl.parser.ExpressionParser;

public abstract class AbstractSeparatingSymbol implements ExpressionParser {

    private final String[] separatingSymbols = {"(", ")", ","};

    @Override
    public Lexeme parse(ExpressionReader reader) {
        if (reader.endOfExpression()) {
            return null;
        }

        final String remainingExpression = reader.getRemainingExpression();


        for (int i = 0; i < separatingSymbols.length; i++) {
            if (remainingExpression.startsWith(separatingSymbols[i])) {
                reader.moveParsePosition(separatingSymbols[i].length());

                return createLexeme();
            }
        }
        return null;
    }

    abstract Lexeme createLexeme();
}
