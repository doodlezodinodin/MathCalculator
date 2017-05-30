package calculator.impl.parser;

import calculator.EvaluationException;
import calculator.impl.ExpressionReader;
import calculator.impl.lexeme.FinishLexeme;
import calculator.impl.lexeme.Lexeme;
import calculator.impl.parser.ExpressionParser;

public class FinishParser implements ExpressionParser {

    @Override
    public Lexeme parse(ExpressionReader reader) throws EvaluationException {

        if (reader.getRemainingExpression().length() > 0) {
            throw new EvaluationException("Invalid character after open bracket. [error position: " + reader.getParsePosition() + "]" , reader.getParsePosition());
        }

        return new FinishLexeme();
    }
}
