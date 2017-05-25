package calculator.impl.parser;

import calculator.impl.lexeme.CloseBracketLexeme;
import calculator.impl.lexeme.Lexeme;

public class CloseBracketParser extends AbstractBracketParser {

    @Override
    Lexeme createLexeme() {
        return new CloseBracketLexeme();
    }
}
