package calculator.impl.lexeme;

import calculator.EvaluationException;

public interface Lexeme {

    void acceptVisitor(LexemeVisitor visitor) throws EvaluationException;
}
