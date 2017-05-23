package calculator.impl.lexeme;


import calculator.impl.operator.BinaryOperator;

public class BracketLexeme implements Lexeme {

    private final BinaryOperator bracket;

    public BracketLexeme(BinaryOperator bracket) {
        this.bracket = bracket;
    }

    public BinaryOperator getBracket() {
        return bracket;
    }

    @Override
    public void acceptVisitor(LexemeVisitor visitor) {
        visitor.visit(this);
    }
}
