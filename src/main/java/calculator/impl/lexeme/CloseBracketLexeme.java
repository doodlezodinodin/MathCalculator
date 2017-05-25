package calculator.impl.lexeme;

import calculator.EvaluationException;

public class CloseBracketLexeme implements Lexeme {

    @Override
    public void acceptVisitor(LexemeVisitor visitor) throws EvaluationException {
        visitor.visit(this);
    }
}
