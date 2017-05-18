package calculator.impl;

import static java.lang.Character.isWhitespace;

public class ExpressionReader {

    private final String expression;

    private int parsePosition = 0;

    public ExpressionReader(String expression) {
        this.expression = expression;
    }

    public int getParsePosition() {
        return parsePosition;
    }

    public void moveParsePosition(int step) {
        parsePosition += step;
    }

    public String getRemainingExpression() {
        skipWhitespaces();
        return expression.substring(parsePosition);
    }

    public boolean endOfExpression() {
        skipWhitespaces();
        return parsePosition >= expression.length();
    }

    private void skipWhitespaces() {
        while (parsePosition < expression.length() && isWhitespace(expression.charAt(parsePosition))) {
            parsePosition++;
        }
    }

}
