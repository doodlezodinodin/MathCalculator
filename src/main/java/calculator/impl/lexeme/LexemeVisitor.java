package calculator.impl.lexeme;

import calculator.impl.lexeme.bracketLexeme.CloseBracketLexeme;
import calculator.impl.lexeme.bracketLexeme.OpenBracketLexeme;
import calculator.impl.lexeme.mathMethodLexeme.MathMethodLexeme;

public interface LexemeVisitor {

    void visit(NumberLexeme lexeme);

    void visit(BinaryOperatorLexeme lexeme);

    void visit(FinishLexeme lexeme);

    void visit(OpenBracketLexeme lexeme);

    void visit(CloseBracketLexeme lexeme);

    void visit(ConstantLexeme lexeme);

    void visit(MathMethodLexeme lexeme);

}
