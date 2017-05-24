package calculator.impl;

public enum State {
    START,
    NUMBER,
    CONSTANT,
    BINARY_OPERATOR,
    OPEN_BRACKET,
    CLOSE_BRACKET,
    FINISH
}
