package calculator.impl.lexeme;

public class ConstantLexeme implements Lexeme {

    private final double value;

    public ConstantLexeme(double value) {
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
