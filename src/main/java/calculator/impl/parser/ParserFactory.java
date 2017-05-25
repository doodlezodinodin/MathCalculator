package calculator.impl.parser;

import calculator.impl.State;
import calculator.impl.lexeme.CommaLexeme;

import java.util.HashMap;
import java.util.Map;

import static calculator.impl.State.*;

public class ParserFactory {

    private final Map<State, ExpressionParser> parsers = new HashMap<State, ExpressionParser>() {{

        put(NUMBER, new NumberParser());

        put(CONSTANT, new ConstantParser());

        put(FUNCTION, new FunctionsParser());

        put(BINARY_OPERATOR, new BinaryOperationParser());

        put(OPEN_BRACKET, new OpenBracketParser());

        put(CLOSE_BRACKET, new CloseBracketParser());

        put(COMMA, new CommaParser());

        put(FINISH, new FinishParser());
    }};

    public ExpressionParser getParser(State state) {
        return parsers.get(state);
    }

}
