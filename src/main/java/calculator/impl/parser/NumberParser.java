package calculator.impl.parser;

import calculator.impl.ExpressionReader;
import calculator.impl.lexeme.Lexeme;
import calculator.impl.lexeme.NumberLexeme;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class NumberParser implements ExpressionParser {

    private final NumberFormat numberFormat = new DecimalFormat("#.#");

    @Override
    public Lexeme parse(ExpressionReader reader) {

        if (reader.endOfExpression()) {
            return null;
        }

        final String remainingExpression = reader.getRemainingExpression();

        final ParsePosition parsePosition = new ParsePosition(0);
        final Number number = numberFormat.parse(remainingExpression, parsePosition);

        if (parsePosition.getErrorIndex() == -1) {
            reader.moveParsePosition(parsePosition.getIndex());
            return new NumberLexeme(number.doubleValue());
        }

        return null;
    }
}
