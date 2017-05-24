package calculator.impl.lexeme;


public class OpenBracketLexeme implements Lexeme {

    private final String bracket;

    public OpenBracketLexeme(String bracket) {
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
