package calculator.impl.lexeme;

import calculator.impl.lexeme.bracketLexeme.CloseBracketLexeme;
import calculator.impl.lexeme.bracketLexeme.OpenBracketLexeme;

public interface LexemeVisitor {

    void visit(NumberLexeme lexeme);

    void visit(BinaryOperatorLexeme lexeme);

    void visit(FinishLexeme lexeme);

    void visit(OpenBracketLexeme lexeme);

    void visit(CloseBracketLexeme lexeme);

    void visit(ConstantLexeme lexeme);

}
