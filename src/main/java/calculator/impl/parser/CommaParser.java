package calculator.impl.parser;

import calculator.impl.lexeme.CommaLexeme;
import calculator.impl.lexeme.Lexeme;

public class CommaParser extends AbstractSeparatingSymbol {

    public CommaParser() {
        super(",");
    }

    @Override
    Lexeme createLexeme() {
        return new CommaLexeme();
    }

}
