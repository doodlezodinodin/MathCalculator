package calculator.impl.parser.bracketParser;

import calculator.impl.lexeme.Lexeme;
import calculator.impl.lexeme.bracketLexeme.OpenBracketLexeme;

public class OpenBracketParser extends BracketParse {

    @Override
    Lexeme createLexeme() {
        return new OpenBracketLexeme();
    }
}
