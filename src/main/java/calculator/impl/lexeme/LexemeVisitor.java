package calculator.impl.lexeme;

public interface LexemeVisitor {

    void visit(NumberLexeme lexeme);

    void visit(ConstantLexeme lexeme);

    void visit(BinaryOperatorLexeme lexeme);

    void visit(OpenBracketLexeme lexeme);

    void visit(CloseBracketLexeme lexeme);

    //void visit(MathMethodLexeme lexeme);

    void visit(FinishLexeme lexeme);

}
