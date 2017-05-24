package calculator.impl.lexeme;

import calculator.impl.operator.binaryOperator.BinaryOperator;

public class BinaryOperatorLexeme implements Lexeme {

    private final BinaryOperator operator;

    public BinaryOperatorLexeme(BinaryOperator operator) {
        this.operator = operator;
    }

    public BinaryOperator getOperator() {
        return operator;
    }

    @Override
    public void acceptVisitor(LexemeVisitor visitor) {
        visitor.visit(this);
    }
}
