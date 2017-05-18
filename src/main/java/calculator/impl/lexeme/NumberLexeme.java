package calculator.impl.lexeme;

public class NumberLexeme implements Lexeme {

    private final double value;

    public NumberLexeme(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public void acceptVisitor(LexemeVisitor visitor) {
        visitor.visit(this);
    }
}
