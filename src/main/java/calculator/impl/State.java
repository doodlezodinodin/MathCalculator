package calculator.impl;

public enum State {
    START,

    NUMBER, CONSTANT,

    FUNCTION,

    BINARY_OPERATOR,

    OPEN_BRACKET, CLOSE_BRACKET,

    FINISH
}
