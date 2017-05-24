package calculator.impl.parser;


import calculator.impl.ExpressionReader;
import calculator.impl.lexeme.ConstantLexeme;
import calculator.impl.lexeme.Lexeme;
import calculator.impl.operator.constant.ConstantFactory;

public class ConstantParser implements ExpressionParser {

    private final ConstantFactory constantFactory = new ConstantFactory();

    @Override
    public Lexeme parse(ExpressionReader reader) {

        if (reader.endOfExpression()) {
            return null;
        }

        final String remainingExpression = reader.getRemainingExpression();

        for (String repression : constantFactory.getRepresentation()) {
            if (remainingExpression.startsWith(repression)) {
                reader.moveParsePosition(repression.length());

                return new ConstantLexeme(constantFactory.getConstant(repression));
            }
        }



        return null;
    }
}
