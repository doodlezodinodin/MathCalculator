package calculator.impl.parser;

import calculator.impl.ExpressionReader;
import calculator.impl.function.Function;
import calculator.impl.function.FunctionsFactory;
import calculator.impl.lexeme.FunctionLexeme;
import calculator.impl.lexeme.Lexeme;

public class FunctionsParser implements ExpressionParser {

    private final FunctionsFactory factory = new FunctionsFactory();

    @Override
    public Lexeme parse(ExpressionReader reader) {

        if (reader.endOfExpression()) {
            return null;
        }

        final String remainingExpression = reader.getRemainingExpression();

        for (String representation : factory.getFunctions()) {
            if (remainingExpression.startsWith(representation)) {

                reader.moveParsePosition(representation.length());

                final Function function = factory.getFunction(representation);

                return new FunctionLexeme(function);
            }
        }

        return null;
    }
}
