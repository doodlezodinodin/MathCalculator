package calculator.impl.parser.bracketParser;

import calculator.impl.lexeme.bracketLexeme.CloseBracketLexeme;
import calculator.impl.lexeme.Lexeme;

public class CloseBracketParse extends BracketParse {

    @Override
    Lexeme createLexeme() {
        return new CloseBracketLexeme();
    }
}
