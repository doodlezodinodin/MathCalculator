package calculator.impl.lexeme;


public class CloseBracketLexeme implements Lexeme {
    private final String bracket;

    public CloseBracketLexeme(String bracket) {
        this.bracket = bracket;
    }

    public String getOperator() {
        return bracket;
    }

    @Override
    public void acceptVisitor(LexemeVisitor visitor) {
        visitor.visit(this);
    }
}
