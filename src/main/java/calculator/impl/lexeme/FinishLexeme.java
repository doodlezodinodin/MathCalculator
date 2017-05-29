package calculator.impl.lexeme;

import calculator.EvaluationException;

public class FinishLexeme implements Lexeme {

    @Override
    public void acceptVisitor(LexemeVisitor visitor) throws EvaluationException {
        visitor.visit(this);
    }
}
