package calculator.impl.lexeme;

public class CommaLexeme implements Lexeme {

    @Override
    public void acceptVisitor(LexemeVisitor visitor) {
        visitor.visit(this);
    }
}
