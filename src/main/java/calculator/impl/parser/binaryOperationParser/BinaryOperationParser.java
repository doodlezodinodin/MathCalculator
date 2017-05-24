package calculator.impl.parser.binaryOperationParser;

import calculator.impl.ExpressionReader;
import calculator.impl.lexeme.BinaryOperatorLexeme;
import calculator.impl.lexeme.Lexeme;
import calculator.impl.operator.BinaryOperator;
import calculator.impl.operator.binaryOperator.BinaryOperatorFactory;
import calculator.impl.parser.ExpressionParser;

public class BinaryOperationParser implements ExpressionParser {

    private final BinaryOperatorFactory factory = new BinaryOperatorFactory();

    @Override
    public Lexeme parse(ExpressionReader reader) {

        if (reader.endOfExpression()) {
            return null;
        }

        final String remainingExpression = reader.getRemainingExpression();

        for (String representation : factory.getRepresentations()) {
            if (remainingExpression.startsWith(representation)) {

                reader.moveParsePosition(representation.length());

                final BinaryOperator operator = factory.getOperator(representation);

                return new BinaryOperatorLexeme(operator);
            }
        }

        return null;
    }
}
