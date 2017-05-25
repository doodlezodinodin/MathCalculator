package calculator.impl.parser;


import calculator.impl.ExpressionReader;
import calculator.impl.lexeme.Lexeme;
import calculator.impl.lexeme.mathMethodLexeme.MathMethodLexeme;
import calculator.impl.operator.mathMethod.MathMethod;
import calculator.impl.operator.mathMethod.MathMethodFactory;
import calculator.impl.parser.ExpressionParser;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class MathMethodParser implements ExpressionParser{

    private final NumberFormat numberFormat = new DecimalFormat("#.#");
    private final MathMethodFactory factory = new MathMethodFactory();

    @Override
    public Lexeme parse(ExpressionReader reader) {

        if (reader.endOfExpression()) {
            return null;
        }

        final String remainingExpression = reader.getRemainingExpression();

        for (String representation : factory.getRepresentations()) {
            if (remainingExpression.startsWith(representation)) {
                final ParsePosition parsePosition = new ParsePosition(representation.length());
                final Number number = numberFormat.parse(remainingExpression, parsePosition);

                if (parsePosition.getErrorIndex() == -1) {
                    reader.moveParsePosition(representation.length() + parsePosition.getIndex());

                    //final MathMethod method = factory.getMethod(representation);
                    return null;
                }
            }
        }

        return null;
    }
}
