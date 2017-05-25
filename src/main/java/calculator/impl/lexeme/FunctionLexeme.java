package calculator.impl.lexeme;

import calculator.impl.function.Function;

public class FunctionLexeme implements Lexeme {

    private final Function function;

    public FunctionLexeme(Function function) {
        this.function = function;
    }

    public Function getFunction() {
        return function;
    }

    @Override
    public void acceptVisitor(LexemeVisitor visitor) {
        visitor.visit(this);
    }
}
