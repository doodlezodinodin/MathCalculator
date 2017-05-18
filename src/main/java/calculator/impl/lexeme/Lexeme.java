package calculator.impl.lexeme;

public interface Lexeme {

    void acceptVisitor(LexemeVisitor visitor);
}
