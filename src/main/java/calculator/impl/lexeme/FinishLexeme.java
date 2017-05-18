package calculator.impl.lexeme;

public class FinishLexeme implements Lexeme {

    @Override
    public void acceptVisitor(LexemeVisitor visitor) {
        visitor.visit(this);
    }
}
