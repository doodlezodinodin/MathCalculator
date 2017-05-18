package calculator.impl.operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BinaryOperatorFactory {

    private final Map<String, BinaryOperator> operators = new HashMap<String, BinaryOperator>() {{
        put("+", new PlusBinaryOperator());
        put("-", new MinusBinaryOperator());
    }};


    public BinaryOperator getOperator(String representation) {
        return operators.get(representation);
    }

    public Set<String> getRepresentations() {
        return operators.keySet();
    }
}
