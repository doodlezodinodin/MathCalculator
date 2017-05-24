package calculator.impl.lexeme.bracketLexeme;


import calculator.impl.lexeme.Lexeme;
import calculator.impl.lexeme.LexemeVisitor;

public class CloseBracketLexeme implements Lexeme {

    @Override
    public void acceptVisitor(LexemeVisitor visitor) {
        visitor.visit(this);
    }
}
