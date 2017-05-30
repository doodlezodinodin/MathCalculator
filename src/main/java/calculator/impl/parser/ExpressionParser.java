package calculator.impl.parser;

import calculator.EvaluationException;
import calculator.impl.ExpressionReader;
import calculator.impl.lexeme.Lexeme;

public interface ExpressionParser {

    Lexeme parse(ExpressionReader reader) throws EvaluationException;
}
