package calculator.impl.parser;

import calculator.impl.lexeme.CloseBracketLexeme;
import calculator.impl.lexeme.Lexeme;

public class CloseBracketParser extends AbstractSeparatingSymbol {

    public CloseBracketParser() {
        super(")");
    }

    @Override
    protected Lexeme createLexeme() {
        return new CloseBracketLexeme();
    }
}
