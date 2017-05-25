package calculator.impl.function;

public class minNumberFunction implements Function {

    @Override
    public double evaluate(Double[] operands) {

        double minNumber = operands[0];

        for (int i = 0; i < operands.length; i++) {
            if (minNumber > operands[i]) minNumber = operands[i];
        }

        return minNumber;
    }
}
