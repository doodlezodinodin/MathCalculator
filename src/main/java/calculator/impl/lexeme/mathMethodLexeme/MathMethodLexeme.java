package calculator.impl.lexeme.mathMethodLexeme;


import calculator.impl.lexeme.Lexeme;
import calculator.impl.lexeme.LexemeVisitor;

public class MathMethodLexeme implements Lexeme {

    private final double method;

    public MathMethodLexeme(double method) {
        this.method = method;
    }

    public double getMethod() {
        return method;
    }

    @Override
    public void acceptVisitor(LexemeVisitor visitor) {
        visitor.visit(this);
    }
}
