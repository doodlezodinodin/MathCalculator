package calculator.impl.lexeme;

public interface LexemeVisitor {

    void visit(NumberLexeme lexeme);

    void visit(BinaryOperatorLexeme lexeme);

    void visit(FinishLexeme lexeme);

}
