package calculator.impl;

public enum State {
    START,

    NUMBER, CONSTANT, //MATH_METHOD,

    BINARY_OPERATOR,

    OPEN_BRACKET, CLOSE_BRACKET,

    FINISH
}
