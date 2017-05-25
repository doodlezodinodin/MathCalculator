package calculator.impl.parser;

import calculator.impl.lexeme.CommaLexeme;
import calculator.impl.lexeme.Lexeme;

public class CommaParser extends AbstractSeparatingSymbol {

    @Override
    Lexeme createLexeme() {
        return new CommaLexeme();
    }
}
