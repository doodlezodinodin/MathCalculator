package calculator.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static calculator.impl.State.*;
import static java.util.EnumSet.noneOf;
import static java.util.EnumSet.of;

public class TransitionMatrix {

    private final Map<State, Set<State>> transitions = new HashMap<State, Set<State>>() {{
        put(START, of(OPEN_BRACKET, NUMBER, CONSTANT, FUNCTION));

        put(NUMBER, of(BINARY_OPERATOR, CLOSE_BRACKET, COMMA, FINISH));

        put(CONSTANT, of(BINARY_OPERATOR, CLOSE_BRACKET, COMMA, FINISH));

        put(FUNCTION, of(OPEN_BRACKET));

        put(BINARY_OPERATOR, of(OPEN_BRACKET, NUMBER, CONSTANT, FUNCTION));

        put(OPEN_BRACKET, of(OPEN_BRACKET, NUMBER, CONSTANT, FUNCTION));

        put(CLOSE_BRACKET, of(CLOSE_BRACKET, COMMA, BINARY_OPERATOR, FINISH));

        put(COMMA, of(NUMBER, CONSTANT, FUNCTION));

        put(FINISH, noneOf(State.class));
    }};

    public Set<State> getPossibleTransitions(State state) {
        return transitions.get(state);
    }

}
