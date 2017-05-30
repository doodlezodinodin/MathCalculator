package calculator.impl.parser;

import calculator.impl.lexeme.Lexeme;
import calculator.impl.lexeme.OpenBracketLexeme;

public class OpenBracketParser extends AbstractSeparatingSymbol {

    public OpenBracketParser() {
        super("(");
    }

    @Override
    protected Lexeme createLexeme() {
        return new OpenBracketLexeme();
    }
}
