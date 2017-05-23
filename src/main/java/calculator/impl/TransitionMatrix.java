package calculator.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static calculator.impl.State.*;
import static java.util.EnumSet.noneOf;
import static java.util.EnumSet.of;

public class TransitionMatrix {

    private final Map<State, Set<State>> transitions = new HashMap<State, Set<State>>() {
        {
            put(START, of(NUMBER));
            put(NUMBER, of(BINARY_OPERATOR, FINISH));
            put(BINARY_OPERATOR, of(NUMBER, OPEN_BRACKET));
            put(OPEN_BRACKET, of(NUMBER, OPEN_BRACKET));
            put(CLOSE_BRACKET, of(BINARY_OPERATOR, CLOSE_BRACKET, FINISH));
            put(FINISH, noneOf(State.class));
        }
    };

    public Set<State> getPossibleTransitions(State state) {
        return transitions.get(state);
    }

}
