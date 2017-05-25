package calculator.impl.parser;

import calculator.impl.ExpressionReader;
import calculator.impl.lexeme.FinishLexeme;
import calculator.impl.lexeme.Lexeme;
import calculator.impl.parser.ExpressionParser;

public class FinishParser implements ExpressionParser {

    @Override
    public Lexeme parse(ExpressionReader reader) {
        return new FinishLexeme();
    }
}
