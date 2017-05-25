package calculator.impl.function;

public class maxNumberFunction implements Function {

    @Override
    public double evaluate(Double[] operands) {

        double maxNumber = operands[0];

        for (int i = 0; i < operands.length; i++) {
            if (maxNumber < operands[i]) maxNumber = operands[i];
        }

        return maxNumber;
    }
}
