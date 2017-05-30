package calculator.impl.parser;

import calculator.impl.ExpressionReader;
import calculator.impl.lexeme.Lexeme;
import calculator.impl.parser.ExpressionParser;

public abstract class AbstractSeparatingSymbol implements ExpressionParser {

    private final String symbol;

    public AbstractSeparatingSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public Lexeme parse(ExpressionReader reader) {
        if (reader.endOfExpression()) {
            return null;
        }

        final String remainingExpression = reader.getRemainingExpression();

        if (remainingExpression.startsWith(symbol)) {

            reader.moveParsePosition(symbol.length());

            return createLexeme();
        }

        return null;
    }

    abstract Lexeme createLexeme();
}
