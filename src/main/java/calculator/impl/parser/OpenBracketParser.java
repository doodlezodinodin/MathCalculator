package calculator.impl.parser;

import calculator.impl.lexeme.Lexeme;
import calculator.impl.lexeme.OpenBracketLexeme;

public class OpenBracketParser extends AbstractBracketParser {

    @Override
    Lexeme createLexeme() {
        return new OpenBracketLexeme();
    }
}
