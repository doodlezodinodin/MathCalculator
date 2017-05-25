package calculator.impl.operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static calculator.impl.operator.BinaryOperator.Priority.*;

public class BinaryOperatorFactory {

    private final Map<String, BinaryOperator> operators = new HashMap<String, BinaryOperator>() {{
        put("+", new PlusBinaryOperator(LOW));
        put("-", new MinusBinaryOperator(LOW));
        put("*", new MultiplyBinaryOperator(MEDIUM));
        put("/", new DivideBinaryOperator(MEDIUM));
        put("^", new PowerBinaryOperator(HIGH));
    }};


    public BinaryOperator getOperator(String representation) {
        return operators.get(representation);
    }

    public Set<String> getRepresentations() {
        return operators.keySet();
    }
}
