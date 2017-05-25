package calculator.impl.parser;

import calculator.impl.lexeme.CloseBracketLexeme;
import calculator.impl.lexeme.Lexeme;

public class CloseBracketParse extends AbstractBracketParse {

    @Override
    Lexeme createLexeme() {
        return new CloseBracketLexeme();
    }
}
