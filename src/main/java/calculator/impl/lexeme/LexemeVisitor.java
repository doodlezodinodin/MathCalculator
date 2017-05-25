package calculator.impl.lexeme;

import calculator.EvaluationException;

public interface LexemeVisitor {

    void visit(NumberLexeme lexeme);

    void visit(ConstantLexeme lexeme);

    void visit(FunctionLexeme lexeme);

    void visit(BinaryOperatorLexeme lexeme);

    void visit(OpenBracketLexeme lexeme);

    void visit(CloseBracketLexeme lexeme) throws EvaluationException;

    void visit(CommaLexeme lexeme);

    void visit(FinishLexeme lexeme);

}
