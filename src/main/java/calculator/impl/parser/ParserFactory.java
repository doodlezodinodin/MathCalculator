package calculator.impl.parser;

import calculator.impl.State;

import java.util.HashMap;
import java.util.Map;

import static calculator.impl.State.BINARY_OPERATOR;
import static calculator.impl.State.FINISH;
import static calculator.impl.State.NUMBER;

public class ParserFactory {

    private final Map<State, ExpressionParser> parsers = new HashMap<State, ExpressionParser>(){{
        put(NUMBER, new NumberParser());
        put(BINARY_OPERATOR, new BinaryOperationParser());
        put(FINISH, new FinishParser());
    }};

    public ExpressionParser getParser(State state){
        return parsers.get(state);
    }

}
